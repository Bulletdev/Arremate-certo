/*    */ package ch.qos.logback.core.spi;
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
/*    */ public class ScanException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = -3132040414328475658L;
/*    */   Throwable cause;
/*    */   
/*    */   public ScanException(String paramString) {
/* 23 */     super(paramString);
/*    */   }
/*    */   
/*    */   public ScanException(String paramString, Throwable paramThrowable) {
/* 27 */     super(paramString);
/* 28 */     this.cause = paramThrowable;
/*    */   }
/*    */   
/*    */   public Throwable getCause() {
/* 32 */     return this.cause;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\ScanException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */