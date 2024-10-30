/*     */ package org.c.a.b.h;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
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
/*     */ public enum a
/*     */ {
/*  34 */   a(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   b(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   c(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   d(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   e(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   f(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   g(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   h(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   i(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   j(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   k(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   l(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   m(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   n(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   o(12);
/*     */   
/*     */   private final int iE;
/*     */   
/*     */   a(int paramInt1) {
/* 109 */     this.iE = paramInt1;
/*     */   }
/*     */   
/*     */   public static a a(Connection paramConnection) {
/* 113 */     DatabaseMetaData databaseMetaData = e.a(paramConnection);
/* 114 */     String str1 = e.c(databaseMetaData);
/* 115 */     String str2 = str1.startsWith("PostgreSQL") ? a(paramConnection) : "";
/*     */     
/* 117 */     return a(str1, str2);
/*     */   }
/*     */   
/*     */   private static a a(String paramString1, String paramString2) {
/* 121 */     if (paramString1.startsWith("Apache Derby")) {
/* 122 */       return c;
/*     */     }
/* 124 */     if (paramString1.startsWith("SQLite")) {
/* 125 */       return k;
/*     */     }
/* 127 */     if (paramString1.startsWith("H2")) {
/* 128 */       return d;
/*     */     }
/* 130 */     if (paramString1.contains("HSQL Database Engine")) {
/* 131 */       return e;
/*     */     }
/* 133 */     if (paramString1.startsWith("Microsoft SQL Server")) {
/* 134 */       return l;
/*     */     }
/* 136 */     if (paramString1.contains("MySQL"))
/*     */     {
/*     */       
/* 139 */       return g;
/*     */     }
/* 141 */     if (paramString1.startsWith("Oracle")) {
/* 142 */       return h;
/*     */     }
/* 144 */     if (paramString1.startsWith("PostgreSQL 8") && paramString2.contains("Redshift")) {
/* 145 */       return j;
/*     */     }
/* 147 */     if (paramString1.startsWith("PostgreSQL")) {
/* 148 */       if (paramString2.contains("CockroachDB")) {
/* 149 */         return (a)a;
/*     */       }
/* 151 */       return i;
/*     */     } 
/* 153 */     if (paramString1.startsWith("DB2")) {
/* 154 */       return b;
/*     */     }
/* 156 */     if (paramString1.startsWith("ASE")) {
/* 157 */       return m;
/*     */     }
/* 159 */     if (paramString1.startsWith("Adaptive Server Enterprise")) {
/* 160 */       return n;
/*     */     }
/* 162 */     if (paramString1.startsWith("HDB")) {
/* 163 */       return o;
/*     */     }
/* 165 */     if (paramString1.startsWith("Informix")) {
/* 166 */       return f;
/*     */     }
/* 168 */     throw new org.c.a.a.a("Unsupported Database: " + paramString1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(Connection paramConnection) {
/*     */     String str;
/* 178 */     PreparedStatement preparedStatement = null;
/* 179 */     ResultSet resultSet = null;
/*     */ 
/*     */     
/*     */     try {
/* 183 */       preparedStatement = paramConnection.prepareStatement("SELECT version()");
/* 184 */       resultSet = preparedStatement.executeQuery();
/* 185 */       str = null;
/* 186 */       if (resultSet.next()) {
/* 187 */         str = resultSet.getString(1);
/*     */       }
/* 189 */     } catch (SQLException sQLException) {
/* 190 */       return "";
/*     */     } finally {
/* 192 */       e.a(resultSet);
/* 193 */       e.a(preparedStatement);
/*     */     } 
/*     */     
/* 196 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bO() {
/* 203 */     return this.iE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\h\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */