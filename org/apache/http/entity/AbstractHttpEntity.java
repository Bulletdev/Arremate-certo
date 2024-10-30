/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.message.BasicHeader;
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
/*     */ public abstract class AbstractHttpEntity
/*     */   implements HttpEntity
/*     */ {
/*     */   protected static final int OUTPUT_BUFFER_SIZE = 4096;
/*     */   protected Header contentType;
/*     */   protected Header contentEncoding;
/*     */   protected boolean chunked;
/*     */   
/*     */   public Header getContentType() {
/*  76 */     return this.contentType;
/*     */   }
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
/*     */   public Header getContentEncoding() {
/*  89 */     return this.contentEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isChunked() {
/* 101 */     return this.chunked;
/*     */   }
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
/*     */   public void setContentType(Header paramHeader) {
/* 114 */     this.contentType = paramHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentType(String paramString) {
/* 126 */     BasicHeader basicHeader = null;
/* 127 */     if (paramString != null) {
/* 128 */       basicHeader = new BasicHeader("Content-Type", paramString);
/*     */     }
/* 130 */     setContentType((Header)basicHeader);
/*     */   }
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
/*     */   public void setContentEncoding(Header paramHeader) {
/* 143 */     this.contentEncoding = paramHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentEncoding(String paramString) {
/* 155 */     BasicHeader basicHeader = null;
/* 156 */     if (paramString != null) {
/* 157 */       basicHeader = new BasicHeader("Content-Encoding", paramString);
/*     */     }
/* 159 */     setContentEncoding((Header)basicHeader);
/*     */   }
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
/*     */   public void setChunked(boolean paramBoolean) {
/* 178 */     this.chunked = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void consumeContent() throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 195 */     StringBuilder stringBuilder = new StringBuilder();
/* 196 */     stringBuilder.append('[');
/* 197 */     if (this.contentType != null) {
/* 198 */       stringBuilder.append("Content-Type: ");
/* 199 */       stringBuilder.append(this.contentType.getValue());
/* 200 */       stringBuilder.append(',');
/*     */     } 
/* 202 */     if (this.contentEncoding != null) {
/* 203 */       stringBuilder.append("Content-Encoding: ");
/* 204 */       stringBuilder.append(this.contentEncoding.getValue());
/* 205 */       stringBuilder.append(',');
/*     */     } 
/* 207 */     long l = getContentLength();
/* 208 */     if (l >= 0L) {
/* 209 */       stringBuilder.append("Content-Length: ");
/* 210 */       stringBuilder.append(l);
/* 211 */       stringBuilder.append(',');
/*     */     } 
/* 213 */     stringBuilder.append("Chunked: ");
/* 214 */     stringBuilder.append(this.chunked);
/* 215 */     stringBuilder.append(']');
/* 216 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\AbstractHttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */