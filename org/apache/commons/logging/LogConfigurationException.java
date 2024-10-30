/*    */ package org.apache.commons.logging;
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
/*    */ public class LogConfigurationException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 8486587136871052495L;
/*    */   
/*    */   public LogConfigurationException() {}
/*    */   
/*    */   public LogConfigurationException(String paramString) {
/* 45 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LogConfigurationException(Throwable paramThrowable) {
/* 55 */     this((paramThrowable == null) ? null : paramThrowable.toString(), paramThrowable);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LogConfigurationException(String paramString, Throwable paramThrowable) {
/* 65 */     super(paramString + " (Caused by " + paramThrowable + ")");
/* 66 */     this.cause = paramThrowable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 72 */   protected Throwable cause = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Throwable getCause() {
/* 78 */     return this.cause;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\LogConfigurationException.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */