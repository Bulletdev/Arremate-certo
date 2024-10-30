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
/*    */ public class RedirectException
/*    */   extends ProtocolException
/*    */ {
/*    */   private static final long serialVersionUID = 4418824536372559326L;
/*    */   
/*    */   public RedirectException() {}
/*    */   
/*    */   public RedirectException(String paramString) {
/* 54 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RedirectException(String paramString, Throwable paramThrowable) {
/* 65 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\RedirectException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */