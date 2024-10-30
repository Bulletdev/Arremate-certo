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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConcurrentException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 6622707671812226130L;
/*    */   
/*    */   protected ConcurrentException() {}
/*    */   
/*    */   public ConcurrentException(Throwable paramThrowable) {
/* 55 */     super(ConcurrentUtils.checkedException(paramThrowable));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ConcurrentException(String paramString, Throwable paramThrowable) {
/* 67 */     super(paramString, ConcurrentUtils.checkedException(paramThrowable));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\ConcurrentException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */