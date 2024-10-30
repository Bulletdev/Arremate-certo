/*    */ package org.apache.http.auth;
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
/*    */ public class AuthenticationException
/*    */   extends ProtocolException
/*    */ {
/*    */   private static final long serialVersionUID = -6794031905674764776L;
/*    */   
/*    */   public AuthenticationException() {}
/*    */   
/*    */   public AuthenticationException(String paramString) {
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
/*    */   public AuthenticationException(String paramString, Throwable paramThrowable) {
/* 65 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\AuthenticationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */