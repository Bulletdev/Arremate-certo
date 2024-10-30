/*    */ package org.apache.http.client;
/*    */ 
/*    */ import org.apache.http.ProtocolException;
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
/*    */ public class NonRepeatableRequestException
/*    */   extends ProtocolException
/*    */ {
/*    */   private static final long serialVersionUID = 82685265288806048L;
/*    */   
/*    */   public NonRepeatableRequestException() {}
/*    */   
/*    */   public NonRepeatableRequestException(String paramString) {
/* 55 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NonRepeatableRequestException(String paramString, Throwable paramThrowable) {
/* 65 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\NonRepeatableRequestException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */