/*     */ package org.h2.upgrade;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.Properties;
/*     */ import java.util.UUID;
/*     */ import org.h2.engine.ConnectionInfo;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DbUpgrade
/*     */ {
/*  35 */   private static final boolean UPGRADE_CLASSES_PRESENT = Utils.isClassPresent("org.h2.upgrade.v1_1.Driver");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean scriptInTempDir;
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean deleteOldDb;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Connection connectOrUpgrade(String paramString, Properties paramProperties) throws SQLException {
/*  50 */     if (!UPGRADE_CLASSES_PRESENT) {
/*  51 */       return null;
/*     */     }
/*  53 */     Properties properties = new Properties();
/*  54 */     properties.putAll(paramProperties);
/*     */     
/*  56 */     Object object = paramProperties.get("password");
/*  57 */     if (object instanceof char[]) {
/*  58 */       properties.put("password", StringUtils.cloneCharArray((char[])object));
/*     */     }
/*  60 */     paramProperties = properties;
/*  61 */     ConnectionInfo connectionInfo = new ConnectionInfo(paramString, paramProperties);
/*  62 */     if (connectionInfo.isRemote() || !connectionInfo.isPersistent()) {
/*  63 */       return null;
/*     */     }
/*  65 */     String str = connectionInfo.getName();
/*  66 */     if (FileUtils.exists(str + ".h2.db")) {
/*  67 */       return null;
/*     */     }
/*  69 */     if (!FileUtils.exists(str + ".data.db")) {
/*  70 */       return null;
/*     */     }
/*  72 */     if (connectionInfo.removeProperty("NO_UPGRADE", false)) {
/*  73 */       return connectWithOldVersion(paramString, paramProperties);
/*     */     }
/*  75 */     synchronized (DbUpgrade.class) {
/*  76 */       upgrade(connectionInfo, paramProperties);
/*  77 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setScriptInTempDir(boolean paramBoolean) {
/*  90 */     scriptInTempDir = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setDeleteOldDb(boolean paramBoolean) {
/* 101 */     deleteOldDb = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Connection connectWithOldVersion(String paramString, Properties paramProperties) throws SQLException {
/* 106 */     paramString = "jdbc:h2v1_1:" + paramString.substring("jdbc:h2:".length()) + ";IGNORE_UNKNOWN_SETTINGS=TRUE";
/*     */     
/* 108 */     return DriverManager.getConnection(paramString, paramProperties);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void upgrade(ConnectionInfo paramConnectionInfo, Properties paramProperties) throws SQLException {
/* 113 */     String str1 = paramConnectionInfo.getName();
/* 114 */     String str2 = str1 + ".data.db";
/* 115 */     String str3 = str1 + ".index.db";
/* 116 */     String str4 = str1 + ".lobs.db";
/* 117 */     String str5 = str2 + ".backup";
/* 118 */     String str6 = str3 + ".backup";
/* 119 */     String str7 = str4 + ".backup";
/* 120 */     String str8 = null;
/*     */     try {
/* 122 */       if (scriptInTempDir) {
/* 123 */         (new File(Utils.getProperty("java.io.tmpdir", "."))).mkdirs();
/* 124 */         str8 = File.createTempFile("h2dbmigration", "backup.sql").getAbsolutePath();
/*     */       } else {
/*     */         
/* 127 */         str8 = str1 + ".script.sql";
/*     */       } 
/* 129 */       String str9 = "jdbc:h2v1_1:" + str1 + ";UNDO_LOG=0;LOG=0;LOCK_MODE=0";
/*     */       
/* 131 */       String str10 = paramConnectionInfo.getProperty("CIPHER", null);
/* 132 */       if (str10 != null) {
/* 133 */         str9 = str9 + ";CIPHER=" + str10;
/*     */       }
/* 135 */       Connection connection = DriverManager.getConnection(str9, paramProperties);
/* 136 */       Statement statement = connection.createStatement();
/* 137 */       String str11 = UUID.randomUUID().toString();
/* 138 */       if (str10 != null) {
/* 139 */         statement.execute("script to '" + str8 + "' cipher aes password '" + str11 + "' --hide--");
/*     */       } else {
/*     */         
/* 142 */         statement.execute("script to '" + str8 + "'");
/*     */       } 
/* 144 */       connection.close();
/* 145 */       FileUtils.move(str2, str5);
/* 146 */       FileUtils.move(str3, str6);
/* 147 */       if (FileUtils.exists(str4)) {
/* 148 */         FileUtils.move(str4, str7);
/*     */       }
/* 150 */       paramConnectionInfo.removeProperty("IFEXISTS", false);
/* 151 */       JdbcConnection jdbcConnection = new JdbcConnection(paramConnectionInfo, true);
/* 152 */       statement = jdbcConnection.createStatement();
/* 153 */       if (str10 != null) {
/* 154 */         statement.execute("runscript from '" + str8 + "' cipher aes password '" + str11 + "' --hide--");
/*     */       } else {
/*     */         
/* 157 */         statement.execute("runscript from '" + str8 + "'");
/*     */       } 
/* 159 */       statement.execute("analyze");
/* 160 */       statement.execute("shutdown compact");
/* 161 */       statement.close();
/* 162 */       jdbcConnection.close();
/* 163 */       if (deleteOldDb) {
/* 164 */         FileUtils.delete(str5);
/* 165 */         FileUtils.delete(str6);
/* 166 */         FileUtils.deleteRecursive(str7, false);
/*     */       } 
/* 168 */     } catch (Exception exception) {
/* 169 */       if (FileUtils.exists(str5)) {
/* 170 */         FileUtils.move(str5, str2);
/*     */       }
/* 172 */       if (FileUtils.exists(str6)) {
/* 173 */         FileUtils.move(str6, str3);
/*     */       }
/* 175 */       if (FileUtils.exists(str7)) {
/* 176 */         FileUtils.move(str7, str4);
/*     */       }
/* 178 */       FileUtils.delete(str1 + ".h2.db");
/* 179 */       throw DbException.toSQLException(exception);
/*     */     } finally {
/* 181 */       if (str8 != null)
/* 182 */         FileUtils.delete(str8); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\upgrade\DbUpgrade.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */