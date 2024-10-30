/*    */ package org.apache.http.client;
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
/*    */ public class CircularRedirectException
/*    */   extends RedirectException
/*    */ {
/*    */   private static final long serialVersionUID = 6830063487001091803L;
/*    */   
/*    */   public CircularRedirectException() {}
/*    */   
/*    */   public CircularRedirectException(String paramString) {
/* 52 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CircularRedirectException(String paramString, Throwable paramThrowable) {
/* 63 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\CircularRedirectException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */