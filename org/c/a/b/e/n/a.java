/*    */ package org.c.a.b.e.n;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import java.util.concurrent.Callable;
/*    */ import org.c.a.a.f.c;
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
/*    */ 
/*    */ public class a
/*    */ {
/* 31 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*    */ 
/*    */   
/*    */   private final b a;
/*    */ 
/*    */   
/*    */   private final d a;
/*    */   
/*    */   private final String databaseName;
/*    */   
/*    */   private final String iU;
/*    */ 
/*    */   
/*    */   a(b paramb, d paramd, String paramString, int paramInt) {
/* 45 */     this.a = (d)paramb;
/* 46 */     this.a = paramd;
/* 47 */     this.databaseName = paramString;
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
/* 59 */       this.a.bE(this.databaseName);
/* 60 */       this.a.a("EXEC sp_getapplock @Resource = ?, @LockTimeout='3600000', @LockMode = 'Exclusive', @LockOwner = 'Session'", new Object[] { this.iU });
/*    */       
/* 62 */       return paramCallable.call();
/* 63 */     } catch (SQLException sQLException) {
/* 64 */       throw new b("Unable to acquire SQL Server application lock", sQLException);
/* 65 */     } catch (Exception exception) {
/*    */       org.c.a.a.a a1;
/* 67 */       if (exception instanceof RuntimeException) {
/* 68 */         RuntimeException runtimeException = (RuntimeException)exception;
/*    */       } else {
/* 70 */         a1 = new org.c.a.a.a(exception);
/*    */       } 
/* 72 */       throw a1;
/*    */     } finally {
/*    */       try {
/* 75 */         this.a.bE(this.databaseName);
/* 76 */         this.a.a("EXEC sp_releaseapplock @Resource = ?, @LockOwner = 'Session'", new Object[] { this.iU });
/* 77 */       } catch (SQLException sQLException) {
/* 78 */         a.a("Unable to release SQL Server application lock", sQLException);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\n\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */