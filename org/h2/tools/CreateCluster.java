/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import org.h2.Driver;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.Tool;
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
/*     */ public class CreateCluster
/*     */   extends Tool
/*     */ {
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  48 */     (new CreateCluster()).runTool(paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/*  53 */     String str1 = null;
/*  54 */     String str2 = null;
/*  55 */     String str3 = "";
/*  56 */     String str4 = "";
/*  57 */     String str5 = null;
/*  58 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  59 */       String str = paramVarArgs[b];
/*  60 */       if (str.equals("-urlSource"))
/*  61 */       { str1 = paramVarArgs[++b]; }
/*  62 */       else if (str.equals("-urlTarget"))
/*  63 */       { str2 = paramVarArgs[++b]; }
/*  64 */       else if (str.equals("-user"))
/*  65 */       { str3 = paramVarArgs[++b]; }
/*  66 */       else if (str.equals("-password"))
/*  67 */       { str4 = paramVarArgs[++b]; }
/*  68 */       else if (str.equals("-serverList"))
/*  69 */       { str5 = paramVarArgs[++b]; }
/*  70 */       else { if (str.equals("-help") || str.equals("-?")) {
/*  71 */           showUsage();
/*     */           return;
/*     */         } 
/*  74 */         showUsageAndThrowUnsupportedOption(str); }
/*     */     
/*     */     } 
/*  77 */     if (str1 == null || str2 == null || str5 == null) {
/*  78 */       showUsage();
/*  79 */       throw new SQLException("Source URL, target URL, or server list not set");
/*     */     } 
/*  81 */     process(str1, str2, str3, str4, str5);
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
/*     */ 
/*     */   
/*     */   public void execute(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws SQLException {
/*  95 */     process(paramString1, paramString2, paramString3, paramString4, paramString5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws SQLException {
/* 100 */     Connection connection1 = null, connection2 = null;
/* 101 */     Statement statement1 = null, statement2 = null;
/* 102 */     String str = "backup.sql";
/*     */     try {
/* 104 */       Driver.load();
/*     */ 
/*     */ 
/*     */       
/* 108 */       boolean bool = true;
/*     */       try {
/* 110 */         connection2 = DriverManager.getConnection(paramString2 + ";IFEXISTS=TRUE;CLUSTER=" + "TRUE", paramString3, paramString4);
/*     */ 
/*     */         
/* 113 */         Statement statement = connection2.createStatement();
/* 114 */         statement.execute("DROP ALL OBJECTS DELETE FILES");
/* 115 */         statement.close();
/* 116 */         bool = false;
/* 117 */         connection2.close();
/* 118 */       } catch (SQLException sQLException) {
/* 119 */         if (sQLException.getErrorCode() == 90013) {
/*     */           
/* 121 */           bool = false;
/*     */         } else {
/* 123 */           throw sQLException;
/*     */         } 
/*     */       } 
/* 126 */       if (bool) {
/* 127 */         throw new SQLException("Target database must not yet exist. Please delete it first: " + paramString2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       connection1 = DriverManager.getConnection(paramString1 + ";CLUSTER=''", paramString3, paramString4);
/*     */       
/* 136 */       statement1 = connection1.createStatement();
/*     */ 
/*     */ 
/*     */       
/* 140 */       statement1.execute("SET EXCLUSIVE 2");
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 145 */         Script script = new Script();
/* 146 */         script.setOut(this.out);
/* 147 */         Script.process(connection1, str, "", "");
/*     */ 
/*     */         
/* 150 */         connection2 = DriverManager.getConnection(paramString2 + ";CLUSTER=''", paramString3, paramString4);
/*     */         
/* 152 */         statement2 = connection2.createStatement();
/* 153 */         statement2.execute("DROP ALL OBJECTS DELETE FILES");
/* 154 */         connection2.close();
/*     */         
/* 156 */         RunScript runScript = new RunScript();
/* 157 */         runScript.setOut(this.out);
/* 158 */         runScript.process(paramString2, paramString3, paramString4, str, (Charset)null, false);
/*     */         
/* 160 */         connection2 = DriverManager.getConnection(paramString2, paramString3, paramString4);
/* 161 */         statement2 = connection2.createStatement();
/*     */ 
/*     */         
/* 164 */         statement1.executeUpdate("SET CLUSTER '" + paramString5 + "'");
/* 165 */         statement2.executeUpdate("SET CLUSTER '" + paramString5 + "'");
/*     */       }
/*     */       finally {
/*     */         
/* 169 */         statement1.execute("SET EXCLUSIVE FALSE");
/*     */       } 
/*     */     } finally {
/* 172 */       FileUtils.delete(str);
/* 173 */       JdbcUtils.closeSilently(statement1);
/* 174 */       JdbcUtils.closeSilently(statement2);
/* 175 */       JdbcUtils.closeSilently(connection1);
/* 176 */       JdbcUtils.closeSilently(connection2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\CreateCluster.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */