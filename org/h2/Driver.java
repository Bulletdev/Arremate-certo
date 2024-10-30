/*     */ package org.h2;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.Driver;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.DriverPropertyInfo;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Logger;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.upgrade.DbUpgrade;
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
/*     */ public class Driver
/*     */   implements Driver, JdbcDriverBackwardsCompat
/*     */ {
/*  33 */   private static final Driver INSTANCE = new Driver();
/*     */   private static final String DEFAULT_URL = "jdbc:default:connection";
/*  35 */   private static final ThreadLocal<Connection> DEFAULT_CONNECTION = new ThreadLocal<>();
/*     */   
/*     */   private static volatile boolean registered;
/*     */ 
/*     */   
/*     */   static {
/*  41 */     load();
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
/*     */   public Connection connect(String paramString, Properties paramProperties) throws SQLException {
/*     */     try {
/*  56 */       if (paramProperties == null) {
/*  57 */         paramProperties = new Properties();
/*     */       }
/*  59 */       if (!acceptsURL(paramString)) {
/*  60 */         return null;
/*     */       }
/*  62 */       if (paramString.equals("jdbc:default:connection")) {
/*  63 */         return DEFAULT_CONNECTION.get();
/*     */       }
/*  65 */       Connection connection = DbUpgrade.connectOrUpgrade(paramString, paramProperties);
/*  66 */       if (connection != null) {
/*  67 */         return connection;
/*     */       }
/*  69 */       return (Connection)new JdbcConnection(paramString, paramProperties);
/*  70 */     } catch (Exception exception) {
/*  71 */       throw DbException.toSQLException(exception);
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
/*     */   public boolean acceptsURL(String paramString) {
/*  84 */     if (paramString != null) {
/*  85 */       if (paramString.startsWith("jdbc:h2:"))
/*  86 */         return true; 
/*  87 */       if (paramString.equals("jdbc:default:connection")) {
/*  88 */         return (DEFAULT_CONNECTION.get() != null);
/*     */       }
/*     */     } 
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMajorVersion() {
/* 102 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinorVersion() {
/* 113 */     return 4;
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
/*     */   public DriverPropertyInfo[] getPropertyInfo(String paramString, Properties paramProperties) {
/* 126 */     return new DriverPropertyInfo[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jdbcCompliant() {
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getParentLogger() {
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized Driver load() {
/*     */     try {
/* 153 */       if (!registered) {
/* 154 */         registered = true;
/* 155 */         DriverManager.registerDriver(INSTANCE);
/*     */       } 
/* 157 */     } catch (SQLException sQLException) {
/* 158 */       DbException.traceThrowable(sQLException);
/*     */     } 
/* 160 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void unload() {
/*     */     try {
/* 168 */       if (registered) {
/* 169 */         registered = false;
/* 170 */         DriverManager.deregisterDriver(INSTANCE);
/*     */       } 
/* 172 */     } catch (SQLException sQLException) {
/* 173 */       DbException.traceThrowable(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setDefaultConnection(Connection paramConnection) {
/* 183 */     if (paramConnection == null) {
/* 184 */       DEFAULT_CONNECTION.remove();
/*     */     } else {
/* 186 */       DEFAULT_CONNECTION.set(paramConnection);
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
/*     */   
/*     */   public static void setThreadContextClassLoader(Thread paramThread) {
/*     */     try {
/* 201 */       paramThread.setContextClassLoader(Driver.class.getClassLoader());
/* 202 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\Driver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */