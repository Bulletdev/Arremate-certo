/*     */ package org.c.a.b.e;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.b.b;
/*     */ import org.c.a.b.e.c.b;
/*     */ import org.c.a.b.e.d.b;
/*     */ import org.c.a.b.e.e.b;
/*     */ import org.c.a.b.e.f.b;
/*     */ import org.c.a.b.e.g.b;
/*     */ import org.c.a.b.e.h.b;
/*     */ import org.c.a.b.e.i.b;
/*     */ import org.c.a.b.e.j.d;
/*     */ import org.c.a.b.e.k.b;
/*     */ import org.c.a.b.e.l.b;
/*     */ import org.c.a.b.e.m.b;
/*     */ import org.c.a.b.e.n.c;
/*     */ import org.c.a.b.e.o.b;
/*     */ import org.c.a.b.f.b;
/*     */ import org.c.a.b.h.e;
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
/*     */ public class a
/*     */ {
/*  49 */   private static final org.c.a.a.f.a a = c.b(a.class);
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
/*     */   public static b a(b paramb, boolean paramBoolean) {
/*     */     boolean bool;
/*  70 */     b.id();
/*     */     
/*  72 */     Connection connection = e.a(paramb.a(), paramb.bK());
/*     */     
/*     */     try {
/*  75 */       bool = connection.getAutoCommit();
/*  76 */       if (!bool) {
/*  77 */         connection.setAutoCommit(true);
/*     */       }
/*  79 */     } catch (SQLException sQLException) {
/*  80 */       throw new b("Unable to turn on auto-commit for the connection", sQLException);
/*     */     } 
/*     */     
/*  83 */     DatabaseMetaData databaseMetaData = e.a(connection);
/*  84 */     String str = e.c(databaseMetaData);
/*  85 */     if (paramBoolean) {
/*  86 */       a.info("Database: " + b(databaseMetaData) + " (" + str + ")");
/*  87 */       a.debug("Driver  : " + a(databaseMetaData));
/*     */     } 
/*     */     
/*  90 */     org.c.a.b.h.a a1 = org.c.a.b.h.a.a(connection);
/*     */     
/*  92 */     b b1 = a(a1, paramb, connection, bool);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     b1.hX();
/*     */     
/*  99 */     if (!b1.fy() && (paramb.l()).length > 0) {
/* 100 */       a.warn(str + " does not support setting the schema for the current session. Default schema will NOT be changed to " + paramb
/* 101 */           .l()[0] + " !");
/*     */     }
/*     */     
/* 104 */     return b1;
/*     */   }
/*     */   
/*     */   private static String a(DatabaseMetaData paramDatabaseMetaData) {
/*     */     try {
/* 109 */       return paramDatabaseMetaData.getDriverName() + " " + paramDatabaseMetaData.getDriverVersion();
/* 110 */     } catch (SQLException sQLException) {
/* 111 */       throw new b("Unable to read database driver info: " + sQLException.getMessage(), sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static b a(org.c.a.b.h.a parama, b paramb, Connection paramConnection, boolean paramBoolean) {
/* 121 */     switch (null.an[parama.ordinal()]) {
/*     */       case 1:
/* 123 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 129 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 135 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 141 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 5:
/* 147 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 6:
/* 153 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 7:
/* 159 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 8:
/* 165 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 9:
/* 171 */         return (b)new d(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 10:
/* 177 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 11:
/* 183 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 12:
/* 189 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 13:
/* 195 */         return (b)new c(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 14:
/*     */       case 15:
/* 202 */         return (b)new b(paramb, paramConnection, paramBoolean);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     throw new org.c.a.a.a("Unsupported Database: " + parama.name());
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
/*     */   private static String b(DatabaseMetaData paramDatabaseMetaData) {
/*     */     String str;
/*     */     try {
/* 222 */       str = paramDatabaseMetaData.getURL();
/* 223 */     } catch (SQLException sQLException) {
/* 224 */       throw new b("Unable to retrieve the JDBC connection URL!", sQLException);
/*     */     } 
/* 226 */     if (str == null) {
/* 227 */       return "";
/*     */     }
/* 229 */     return aM(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String aM(String paramString) {
/* 239 */     int i = paramString.indexOf("?");
/* 240 */     if (i >= 0 && !paramString.contains("?databaseName=")) {
/* 241 */       paramString = paramString.substring(0, i);
/*     */     }
/* 243 */     paramString = paramString.replaceAll("://.*:.*@", "://");
/* 244 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */