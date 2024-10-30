/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.entity.HttpEntityWrapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class EntityEnclosingRequestWrapper
/*     */   extends RequestWrapper
/*     */   implements HttpEntityEnclosingRequest
/*     */ {
/*     */   private HttpEntity entity;
/*     */   private boolean consumed;
/*     */   
/*     */   public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws ProtocolException {
/*  63 */     super((HttpRequest)paramHttpEntityEnclosingRequest);
/*  64 */     setEntity(paramHttpEntityEnclosingRequest.getEntity());
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpEntity getEntity() {
/*  69 */     return this.entity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEntity(HttpEntity paramHttpEntity) {
/*  74 */     this.entity = (paramHttpEntity != null) ? (HttpEntity)new EntityWrapper(paramHttpEntity) : null;
/*  75 */     this.consumed = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean expectContinue() {
/*  80 */     Header header = getFirstHeader("Expect");
/*  81 */     return (header != null && "100-continue".equalsIgnoreCase(header.getValue()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  86 */     return (this.entity == null || this.entity.isRepeatable() || !this.consumed);
/*     */   }
/*     */   
/*     */   class EntityWrapper
/*     */     extends HttpEntityWrapper {
/*     */     EntityWrapper(HttpEntity param1HttpEntity) {
/*  92 */       super(param1HttpEntity);
/*     */     }
/*     */ 
/*     */     
/*     */     public void consumeContent() throws IOException {
/*  97 */       EntityEnclosingRequestWrapper.this.consumed = true;
/*  98 */       super.consumeContent();
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream getContent() throws IOException {
/* 103 */       EntityEnclosingRequestWrapper.this.consumed = true;
/* 104 */       return super.getContent();
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeTo(OutputStream param1OutputStream) throws IOException {
/* 109 */       EntityEnclosingRequestWrapper.this.consumed = true;
/* 110 */       super.writeTo(param1OutputStream);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\EntityEnclosingRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */