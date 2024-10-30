/*     */ package org.apache.http.entity.mime;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Random;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.entity.mime.content.ContentBody;
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
/*     */ public class MultipartEntity
/*     */   implements HttpEntity
/*     */ {
/*  53 */   private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final MultipartEntityBuilder builder;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile MultipartFormEntity entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipartEntity(HttpMultipartMode paramHttpMultipartMode, String paramString, Charset paramCharset) {
/*  71 */     this.builder = (new MultipartEntityBuilder()).setMode(paramHttpMultipartMode).setCharset((paramCharset != null) ? paramCharset : MIME.DEFAULT_CHARSET).setBoundary(paramString);
/*     */ 
/*     */ 
/*     */     
/*  75 */     this.entity = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipartEntity(HttpMultipartMode paramHttpMultipartMode) {
/*  84 */     this(paramHttpMultipartMode, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipartEntity() {
/*  91 */     this(HttpMultipartMode.STRICT, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String generateContentType(String paramString, Charset paramCharset) {
/*  97 */     StringBuilder stringBuilder = new StringBuilder();
/*  98 */     stringBuilder.append("multipart/form-data; boundary=");
/*  99 */     stringBuilder.append(paramString);
/* 100 */     if (paramCharset != null) {
/* 101 */       stringBuilder.append("; charset=");
/* 102 */       stringBuilder.append(paramCharset.name());
/*     */     } 
/* 104 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected String generateBoundary() {
/* 108 */     StringBuilder stringBuilder = new StringBuilder();
/* 109 */     Random random = new Random();
/* 110 */     int i = random.nextInt(11) + 30;
/* 111 */     for (byte b = 0; b < i; b++) {
/* 112 */       stringBuilder.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
/*     */     }
/* 114 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private MultipartFormEntity getEntity() {
/* 118 */     if (this.entity == null) {
/* 119 */       this.entity = this.builder.buildEntity();
/*     */     }
/* 121 */     return this.entity;
/*     */   }
/*     */   
/*     */   public void addPart(FormBodyPart paramFormBodyPart) {
/* 125 */     this.builder.addPart(paramFormBodyPart);
/* 126 */     this.entity = null;
/*     */   }
/*     */   
/*     */   public void addPart(String paramString, ContentBody paramContentBody) {
/* 130 */     addPart(new FormBodyPart(paramString, paramContentBody));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/* 135 */     return getEntity().isRepeatable();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChunked() {
/* 140 */     return getEntity().isChunked();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 145 */     return getEntity().isStreaming();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 150 */     return getEntity().getContentLength();
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getContentType() {
/* 155 */     return getEntity().getContentType();
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getContentEncoding() {
/* 160 */     return getEntity().getContentEncoding();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void consumeContent() throws IOException, UnsupportedOperationException {
/* 166 */     if (isStreaming()) {
/* 167 */       throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException, UnsupportedOperationException {
/* 174 */     throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 180 */     getEntity().writeTo(paramOutputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\MultipartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */