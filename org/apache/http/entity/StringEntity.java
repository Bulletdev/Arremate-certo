/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.UnsupportedCharsetException;
/*     */ import org.apache.http.protocol.HTTP;
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
/*     */ 
/*     */ 
/*     */ public class StringEntity
/*     */   extends AbstractHttpEntity
/*     */   implements Cloneable
/*     */ {
/*     */   protected final byte[] content;
/*     */   
/*     */   public StringEntity(String paramString, ContentType paramContentType) throws UnsupportedCharsetException {
/*  65 */     Args.notNull(paramString, "Source string");
/*  66 */     Charset charset = (paramContentType != null) ? paramContentType.getCharset() : null;
/*  67 */     if (charset == null) {
/*  68 */       charset = HTTP.DEF_CONTENT_CHARSET;
/*     */     }
/*  70 */     this.content = paramString.getBytes(charset);
/*  71 */     if (paramContentType != null) {
/*  72 */       setContentType(paramContentType.toString());
/*     */     }
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
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public StringEntity(String paramString1, String paramString2, String paramString3) throws UnsupportedEncodingException {
/*  95 */     Args.notNull(paramString1, "Source string");
/*  96 */     String str1 = (paramString2 != null) ? paramString2 : "text/plain";
/*  97 */     String str2 = (paramString3 != null) ? paramString3 : "ISO-8859-1";
/*  98 */     this.content = paramString1.getBytes(str2);
/*  99 */     setContentType(str1 + "; charset=" + str2);
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
/*     */   public StringEntity(String paramString1, String paramString2) throws UnsupportedCharsetException {
/* 116 */     this(paramString1, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), paramString2));
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
/*     */   public StringEntity(String paramString, Charset paramCharset) {
/* 132 */     this(paramString, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), paramCharset));
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
/*     */   public StringEntity(String paramString) throws UnsupportedEncodingException {
/* 146 */     this(paramString, ContentType.DEFAULT_TEXT);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 156 */     return this.content.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/* 161 */     return new ByteArrayInputStream(this.content);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 166 */     Args.notNull(paramOutputStream, "Output stream");
/* 167 */     paramOutputStream.write(this.content);
/* 168 */     paramOutputStream.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 178 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 183 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\StringEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */