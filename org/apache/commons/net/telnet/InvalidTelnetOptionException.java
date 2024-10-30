/*    */ package org.apache.commons.net.telnet;
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
/*    */ public class InvalidTelnetOptionException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = -2516777155928793597L;
/*    */   private final int optionCode;
/*    */   private final String msg;
/*    */   
/*    */   public InvalidTelnetOptionException(String paramString, int paramInt) {
/* 48 */     this.optionCode = paramInt;
/* 49 */     this.msg = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 60 */     return this.msg + ": " + this.optionCode;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\telnet\InvalidTelnetOptionException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */