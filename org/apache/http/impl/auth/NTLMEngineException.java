/*    */ package org.apache.http.impl.auth;
/*    */ 
/*    */ import org.apache.http.auth.AuthenticationException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NTLMEngineException
/*    */   extends AuthenticationException
/*    */ {
/*    */   private static final long serialVersionUID = 6027981323731768824L;
/*    */   
/*    */   public NTLMEngineException() {}
/*    */   
/*    */   public NTLMEngineException(String paramString) {
/* 51 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NTLMEngineException(String paramString, Throwable paramThrowable) {
/* 62 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\NTLMEngineException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */