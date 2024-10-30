/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import javax.sql.DataSource;
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
/*     */ public class g
/*     */   implements d
/*     */ {
/*     */   protected DataSource a;
/*     */   protected String mt;
/*     */   protected String mu;
/*     */   
/*     */   public g(DataSource paramDataSource, String paramString1, String paramString2) {
/*  37 */     this.a = paramDataSource;
/*  38 */     this.mt = paramString1;
/*  39 */     this.mu = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean search(String paramString) {
/*     */     try {
/*  47 */       return (a(this.mt, String.class, new Object[] { paramString }) != null);
/*  48 */     } catch (SQLException sQLException) {
/*  49 */       throw new RuntimeException("Error executing SQL", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long size() {
/*     */     try {
/*  58 */       return ((Long)a(this.mu, Long.class, (Object[])null)).longValue();
/*  59 */     } catch (SQLException sQLException) {
/*  60 */       throw new RuntimeException("Error executing SQL", sQLException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T> T a(String paramString, Class<T> paramClass, Object... paramVarArgs) throws SQLException {
/*  81 */     try(Connection null = getConnection(); 
/*  82 */         PreparedStatement null = connection.prepareStatement(paramString)) {
/*  83 */       if (paramVarArgs != null && paramVarArgs.length > 0) {
/*  84 */         for (byte b = 0; b < paramVarArgs.length; b++) {
/*  85 */           preparedStatement.setObject(b + 1, paramVarArgs[b]);
/*     */         }
/*     */       }
/*  88 */       try (ResultSet null = preparedStatement.executeQuery()) {
/*  89 */         if (resultSet.next()) {
/*  90 */           return (T)resultSet.getObject(1, (Class)paramClass);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return null;
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
/*     */   protected Connection getConnection() throws SQLException {
/* 109 */     return this.a.getConnection();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */