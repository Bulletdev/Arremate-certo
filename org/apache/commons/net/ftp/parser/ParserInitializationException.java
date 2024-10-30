/*    */ package org.apache.commons.net.ftp.parser;
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
/*    */ public class ParserInitializationException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 5563335279583210658L;
/*    */   
/*    */   public ParserInitializationException(String paramString) {
/* 35 */     super(paramString);
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
/*    */   public ParserInitializationException(String paramString, Throwable paramThrowable) {
/* 47 */     super(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public Throwable getRootCause() {
/* 59 */     return getCause();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\ParserInitializationException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */