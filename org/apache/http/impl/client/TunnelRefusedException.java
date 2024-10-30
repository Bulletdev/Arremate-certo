/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class TunnelRefusedException
/*    */   extends HttpException
/*    */ {
/*    */   private static final long serialVersionUID = -8646722842745617323L;
/*    */   private final HttpResponse response;
/*    */   
/*    */   public TunnelRefusedException(String paramString, HttpResponse paramHttpResponse) {
/* 48 */     super(paramString);
/* 49 */     this.response = paramHttpResponse;
/*    */   }
/*    */   
/*    */   public HttpResponse getResponse() {
/* 53 */     return this.response;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\TunnelRefusedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */