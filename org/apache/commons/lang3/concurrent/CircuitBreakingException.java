/*    */ package org.apache.commons.lang3.concurrent;
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
/*    */ public class CircuitBreakingException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1408176654686913340L;
/*    */   
/*    */   public CircuitBreakingException() {}
/*    */   
/*    */   public CircuitBreakingException(String paramString, Throwable paramThrowable) {
/* 46 */     super(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CircuitBreakingException(String paramString) {
/* 55 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CircuitBreakingException(Throwable paramThrowable) {
/* 64 */     super(paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\CircuitBreakingException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */