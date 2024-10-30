/*    */ package com.google.a.o.a;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.util.concurrent.Executor;
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
/*    */ @b
/*    */ enum v
/*    */   implements Executor
/*    */ {
/* 26 */   a;
/*    */ 
/*    */   
/*    */   public void execute(Runnable paramRunnable) {
/* 30 */     paramRunnable.run();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 35 */     return "MoreExecutors.directExecutor()";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */