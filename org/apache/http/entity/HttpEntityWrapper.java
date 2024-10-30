/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.util.Args;
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
/*     */ 
/*     */ 
/*     */ public class HttpEntityWrapper
/*     */   implements HttpEntity
/*     */ {
/*     */   protected HttpEntity wrappedEntity;
/*     */   
/*     */   public HttpEntityWrapper(HttpEntity paramHttpEntity) {
/*  59 */     this.wrappedEntity = (HttpEntity)Args.notNull(paramHttpEntity, "Wrapped entity");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  64 */     return this.wrappedEntity.isRepeatable();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChunked() {
/*  69 */     return this.wrappedEntity.isChunked();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/*  74 */     return this.wrappedEntity.getContentLength();
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getContentType() {
/*  79 */     return this.wrappedEntity.getContentType();
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getContentEncoding() {
/*  84 */     return this.wrappedEntity.getContentEncoding();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/*  90 */     return this.wrappedEntity.getContent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  96 */     this.wrappedEntity.writeTo(paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 101 */     return this.wrappedEntity.isStreaming();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void consumeContent() throws IOException {
/* 111 */     this.wrappedEntity.consumeContent();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\HttpEntityWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */