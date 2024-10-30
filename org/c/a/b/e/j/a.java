/*     */ package org.c.a.b.e.j;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.f.b;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.h.h;
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
/*  34 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long bN = 77431708279161L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final d a;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final long bO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   a(d paramd, int paramInt) {
/*  58 */     this.a = paramd;
/*  59 */     this.bO = 77431708279161L + paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(Callable<T> paramCallable) {
/*     */     try {
/*  70 */       lock();
/*  71 */       return paramCallable.call();
/*  72 */     } catch (SQLException sQLException) {
/*  73 */       throw new b("Unable to acquire PostgreSQL advisory lock", sQLException);
/*  74 */     } catch (Exception exception) {
/*     */       org.c.a.a.a a1;
/*  76 */       if (exception instanceof RuntimeException) {
/*  77 */         RuntimeException runtimeException = (RuntimeException)exception;
/*     */       } else {
/*  79 */         a1 = new org.c.a.a.a(exception);
/*     */       } 
/*  81 */       throw a1;
/*     */     } finally {
/*     */       try {
/*  84 */         this.a.a("SELECT pg_advisory_unlock(" + this.bO + ")", new Object[0]);
/*  85 */       } catch (SQLException sQLException) {
/*  86 */         a.a("Unable to release PostgreSQL advisory lock", sQLException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void lock() throws SQLException {
/*  92 */     while (!tryLock()) {
/*     */       try {
/*  94 */         Thread.sleep(100L);
/*  95 */       } catch (InterruptedException interruptedException) {
/*  96 */         throw new org.c.a.a.a("Interrupted while attempting to acquire PostgreSQL advisory lock", interruptedException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean tryLock() throws SQLException {
/* 102 */     List<Boolean> list = this.a.a("SELECT pg_try_advisory_lock(" + this.bO + ")", new h<Boolean>(this)
/*     */         {
/*     */           
/*     */           public Boolean a(ResultSet param1ResultSet) throws SQLException
/*     */           {
/* 107 */             return Boolean.valueOf("t".equals(param1ResultSet.getString("pg_try_advisory_lock")));
/*     */           }
/*     */         });
/* 110 */     return (list.size() == 1 && ((Boolean)list.get(0)).booleanValue());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\j\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */