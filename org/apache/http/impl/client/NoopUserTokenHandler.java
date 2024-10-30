/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.client.UserTokenHandler;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class NoopUserTokenHandler
/*    */   implements UserTokenHandler
/*    */ {
/* 42 */   public static final NoopUserTokenHandler INSTANCE = new NoopUserTokenHandler();
/*    */ 
/*    */   
/*    */   public Object getUserToken(HttpContext paramHttpContext) {
/* 46 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\NoopUserTokenHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */