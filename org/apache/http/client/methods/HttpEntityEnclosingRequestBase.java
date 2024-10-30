/*    */ package org.apache.http.client.methods;
/*    */ 
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.HttpEntityEnclosingRequest;
/*    */ import org.apache.http.client.utils.CloneUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class HttpEntityEnclosingRequestBase
/*    */   extends HttpRequestBase
/*    */   implements HttpEntityEnclosingRequest
/*    */ {
/*    */   private HttpEntity entity;
/*    */   
/*    */   public HttpEntity getEntity() {
/* 53 */     return this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEntity(HttpEntity paramHttpEntity) {
/* 58 */     this.entity = paramHttpEntity;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expectContinue() {
/* 63 */     Header header = getFirstHeader("Expect");
/* 64 */     return (header != null && "100-continue".equalsIgnoreCase(header.getValue()));
/*    */   }
/*    */ 
/*    */   
/*    */   public Object clone() throws CloneNotSupportedException {
/* 69 */     HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase = (HttpEntityEnclosingRequestBase)super.clone();
/*    */     
/* 71 */     if (this.entity != null) {
/* 72 */       httpEntityEnclosingRequestBase.entity = (HttpEntity)CloneUtils.cloneObject(this.entity);
/*    */     }
/* 74 */     return httpEntityEnclosingRequestBase;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\methods\HttpEntityEnclosingRequestBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */