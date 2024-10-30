/*    */ package org.h2.engine;
/*    */ 
/*    */ import java.lang.ref.WeakReference;
/*    */ import org.h2.message.Trace;
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
/*    */ class DatabaseCloser
/*    */   extends Thread
/*    */ {
/*    */   private final boolean shutdownHook;
/*    */   private final Trace trace;
/*    */   private volatile WeakReference<Database> databaseRef;
/*    */   private int delayInMillis;
/*    */   
/*    */   DatabaseCloser(Database paramDatabase, int paramInt, boolean paramBoolean) {
/* 25 */     this.databaseRef = new WeakReference<>(paramDatabase);
/* 26 */     this.delayInMillis = paramInt;
/* 27 */     this.shutdownHook = paramBoolean;
/* 28 */     this.trace = paramDatabase.getTrace(2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void reset() {
/* 36 */     synchronized (this) {
/* 37 */       this.databaseRef = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 43 */     while (this.delayInMillis > 0) {
/*    */       try {
/* 45 */         byte b = 100;
/* 46 */         Thread.sleep(b);
/* 47 */         this.delayInMillis -= b;
/* 48 */       } catch (Exception exception) {}
/*    */ 
/*    */       
/* 51 */       if (this.databaseRef == null) {
/*    */         return;
/*    */       }
/*    */     } 
/* 55 */     Database database = null;
/* 56 */     synchronized (this) {
/* 57 */       if (this.databaseRef != null) {
/* 58 */         database = this.databaseRef.get();
/*    */       }
/*    */     } 
/* 61 */     if (database != null)
/*    */       try {
/* 63 */         database.close(this.shutdownHook);
/* 64 */       } catch (RuntimeException runtimeException) {
/*    */ 
/*    */         
/*    */         try {
/*    */           
/* 69 */           this.trace.error(runtimeException, "could not close the database");
/*    */         
/*    */         }
/* 72 */         catch (RuntimeException runtimeException1) {
/* 73 */           throw runtimeException;
/*    */         } 
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\DatabaseCloser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */