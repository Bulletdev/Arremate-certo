/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
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
/*     */ public class BufferedHttpEntity
/*     */   extends HttpEntityWrapper
/*     */ {
/*     */   private final byte[] buffer;
/*     */   
/*     */   public BufferedHttpEntity(HttpEntity paramHttpEntity) throws IOException {
/*  59 */     super(paramHttpEntity);
/*  60 */     if (!paramHttpEntity.isRepeatable() || paramHttpEntity.getContentLength() < 0L) {
/*  61 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  62 */       paramHttpEntity.writeTo(byteArrayOutputStream);
/*  63 */       byteArrayOutputStream.flush();
/*  64 */       this.buffer = byteArrayOutputStream.toByteArray();
/*     */     } else {
/*  66 */       this.buffer = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/*  72 */     return (this.buffer != null) ? this.buffer.length : super.getContentLength();
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/*  77 */     return (this.buffer != null) ? new ByteArrayInputStream(this.buffer) : super.getContent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isChunked() {
/*  87 */     return (this.buffer == null && super.isChunked());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 103 */     Args.notNull(paramOutputStream, "Output stream");
/* 104 */     if (this.buffer != null) {
/* 105 */       paramOutputStream.write(this.buffer);
/*     */     } else {
/* 107 */       super.writeTo(paramOutputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 115 */     return (this.buffer == null && super.isStreaming());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\BufferedHttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */