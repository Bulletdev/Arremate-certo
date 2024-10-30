/*     */ package org.c.a.b.h;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import javax.sql.DataSource;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.f.b;
/*     */ import org.c.a.b.r.f;
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
/*     */ public class e
/*     */ {
/*  35 */   private static final a a = c.b(e.class);
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
/*     */   public static Connection a(DataSource paramDataSource, int paramInt) throws a {
/*  53 */     byte b = 0;
/*     */     while (true) {
/*     */       try {
/*  56 */         return paramDataSource.getConnection();
/*  57 */       } catch (SQLException sQLException) {
/*  58 */         if (++b > paramInt) {
/*  59 */           throw new b("Unable to obtain connection from database" + 
/*  60 */               a(paramDataSource) + ": " + sQLException.getMessage(), sQLException);
/*     */         }
/*  62 */         Throwable throwable = f.getRootCause(sQLException);
/*  63 */         String str = "Connection error: " + sQLException.getMessage();
/*  64 */         if (throwable != null && throwable != sQLException && throwable.getMessage() != null) {
/*  65 */           str = str + " (Caused by " + throwable.getMessage() + ")";
/*     */         }
/*  67 */         a.warn(str + " Retrying in 1 sec...");
/*     */         try {
/*  69 */           Thread.sleep(1000L);
/*  70 */         } catch (InterruptedException interruptedException) {
/*  71 */           throw new b("Unable to obtain connection from database" + 
/*  72 */               a(paramDataSource) + ": " + sQLException.getMessage(), sQLException);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String a(DataSource paramDataSource) {
/*  79 */     if (!(paramDataSource instanceof b)) {
/*  80 */       return "";
/*     */     }
/*  82 */     b b = (b)paramDataSource;
/*  83 */     return " (" + b.getUrl() + ") for user '" + b.getUser() + "'";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void p(Connection paramConnection) {
/*  92 */     if (paramConnection == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  97 */       paramConnection.close();
/*  98 */     } catch (Exception exception) {
/*  99 */       a.a("Error while closing database connection: " + exception.getMessage(), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(Statement paramStatement) {
/* 109 */     if (paramStatement == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 114 */       paramStatement.close();
/* 115 */     } catch (SQLException sQLException) {
/* 116 */       a.a("Error while closing JDBC statement", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(ResultSet paramResultSet) {
/* 126 */     if (paramResultSet == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 131 */       paramResultSet.close();
/* 132 */     } catch (SQLException sQLException) {
/* 133 */       a.a("Error while closing JDBC resultSet", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DatabaseMetaData a(Connection paramConnection) {
/*     */     DatabaseMetaData databaseMetaData;
/*     */     try {
/* 146 */       databaseMetaData = paramConnection.getMetaData();
/* 147 */     } catch (SQLException sQLException) {
/* 148 */       throw new b("Unable to read database connection metadata: " + sQLException.getMessage(), sQLException);
/*     */     } 
/* 150 */     if (databaseMetaData == null) {
/* 151 */       throw new a("Unable to read database connection metadata while it is null!");
/*     */     }
/* 153 */     return databaseMetaData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String c(DatabaseMetaData paramDatabaseMetaData) {
/*     */     try {
/* 164 */       String str = paramDatabaseMetaData.getDatabaseProductName();
/* 165 */       if (str == null) {
/* 166 */         throw new a("Unable to determine database. Product name is null.");
/*     */       }
/*     */       
/* 169 */       int i = paramDatabaseMetaData.getDatabaseMajorVersion();
/* 170 */       int j = paramDatabaseMetaData.getDatabaseMinorVersion();
/*     */       
/* 172 */       return str + " " + i + "." + j;
/* 173 */     } catch (SQLException sQLException) {
/* 174 */       throw new b("Error while determining database product name", sQLException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\h\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */