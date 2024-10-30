/*    */ package org.c.a.b.e.h;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import java.util.concurrent.Callable;
/*    */ import org.c.a.a.a;
/*    */ import org.c.a.a.f.a;
/*    */ import org.c.a.b.f.b;
/*    */ import org.c.a.b.h.d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class c
/*    */ {
/* 31 */   private static final a a = org.c.a.a.f.c.b(c.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final d a;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String iU;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   c(d paramd, int paramInt) {
/* 47 */     this.a = paramd;
/* 48 */     this.iU = "Flyway-" + paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> T execute(Callable<T> paramCallable) {
/*    */     try {
/* 59 */       lock();
/* 60 */       return paramCallable.call();
/* 61 */     } catch (SQLException sQLException) {
/* 62 */       throw new b("Unable to acquire MySQL named lock: " + this.iU, sQLException);
/* 63 */     } catch (Exception exception) {
/*    */       a a1;
/* 65 */       if (exception instanceof RuntimeException) {
/* 66 */         RuntimeException runtimeException = (RuntimeException)exception;
/*    */       } else {
/* 68 */         a1 = new a(exception);
/*    */       } 
/* 70 */       throw a1;
/*    */     } finally {
/*    */       try {
/* 73 */         this.a.a("SELECT RELEASE_LOCK('" + this.iU + "')", new Object[0]);
/* 74 */       } catch (SQLException sQLException) {
/* 75 */         a.a("Unable to release MySQL named lock: " + this.iU, sQLException);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void lock() throws SQLException {
/* 81 */     while (!tryLock()) {
/*    */       try {
/* 83 */         Thread.sleep(100L);
/* 84 */       } catch (InterruptedException interruptedException) {
/* 85 */         throw new a("Interrupted while attempting to acquire MySQL named lock: " + this.iU, interruptedException);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean tryLock() throws SQLException {
/* 91 */     return (this.a.b("SELECT GET_LOCK(?,10)", new String[] { this.iU }) == 1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\h\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */