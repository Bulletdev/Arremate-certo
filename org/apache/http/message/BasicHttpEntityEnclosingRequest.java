/*    */ package org.apache.http.message;
/*    */ 
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.HttpEntityEnclosingRequest;
/*    */ import org.apache.http.ProtocolVersion;
/*    */ import org.apache.http.RequestLine;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BasicHttpEntityEnclosingRequest
/*    */   extends BasicHttpRequest
/*    */   implements HttpEntityEnclosingRequest
/*    */ {
/*    */   private HttpEntity entity;
/*    */   
/*    */   public BasicHttpEntityEnclosingRequest(String paramString1, String paramString2) {
/* 48 */     super(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public BasicHttpEntityEnclosingRequest(String paramString1, String paramString2, ProtocolVersion paramProtocolVersion) {
/* 53 */     super(paramString1, paramString2, paramProtocolVersion);
/*    */   }
/*    */   
/*    */   public BasicHttpEntityEnclosingRequest(RequestLine paramRequestLine) {
/* 57 */     super(paramRequestLine);
/*    */   }
/*    */ 
/*    */   
/*    */   public HttpEntity getEntity() {
/* 62 */     return this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEntity(HttpEntity paramHttpEntity) {
/* 67 */     this.entity = paramHttpEntity;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expectContinue() {
/* 72 */     Header header = getFirstHeader("Expect");
/* 73 */     return (header != null && "100-continue".equalsIgnoreCase(header.getValue()));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicHttpEntityEnclosingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */