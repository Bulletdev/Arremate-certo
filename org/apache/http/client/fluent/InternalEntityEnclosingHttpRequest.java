/*    */ package org.apache.http.client.fluent;
/*    */ 
/*    */ import java.net.URI;
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.HttpEntityEnclosingRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class InternalEntityEnclosingHttpRequest
/*    */   extends InternalHttpRequest
/*    */   implements HttpEntityEnclosingRequest
/*    */ {
/*    */   private HttpEntity entity;
/*    */   
/*    */   public InternalEntityEnclosingHttpRequest(String paramString, URI paramURI) {
/* 42 */     super(paramString, paramURI);
/*    */   }
/*    */ 
/*    */   
/*    */   public HttpEntity getEntity() {
/* 47 */     return this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEntity(HttpEntity paramHttpEntity) {
/* 52 */     this.entity = paramHttpEntity;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expectContinue() {
/* 57 */     Header header = getFirstHeader("Expect");
/* 58 */     return (header != null && "100-continue".equalsIgnoreCase(header.getValue()));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\InternalEntityEnclosingHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */