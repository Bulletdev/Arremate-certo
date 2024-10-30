/*    */ package org.apache.http.client;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class ClientProtocolException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = -5596590843227115865L;
/*    */   
/*    */   public ClientProtocolException() {}
/*    */   
/*    */   public ClientProtocolException(String paramString) {
/* 45 */     super(paramString);
/*    */   }
/*    */   
/*    */   public ClientProtocolException(Throwable paramThrowable) {
/* 49 */     initCause(paramThrowable);
/*    */   }
/*    */   
/*    */   public ClientProtocolException(String paramString, Throwable paramThrowable) {
/* 53 */     super(paramString);
/* 54 */     initCause(paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\ClientProtocolException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */