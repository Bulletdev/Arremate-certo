/*     */ package org.apache.http.entity.mime.content;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.entity.ContentType;
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
/*     */ public class StringBody
/*     */   extends AbstractContentBody
/*     */ {
/*     */   private final byte[] content;
/*     */   
/*     */   @Deprecated
/*     */   public static StringBody create(String paramString1, String paramString2, Charset paramCharset) throws IllegalArgumentException {
/*     */     try {
/*  67 */       return new StringBody(paramString1, paramString2, paramCharset);
/*  68 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  69 */       throw new IllegalArgumentException("Charset " + paramCharset + " is not supported", unsupportedEncodingException);
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
/*     */   @Deprecated
/*     */   public static StringBody create(String paramString, Charset paramCharset) throws IllegalArgumentException {
/*  82 */     return create(paramString, null, paramCharset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static StringBody create(String paramString) throws IllegalArgumentException {
/*  93 */     return create(paramString, null, null);
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
/*     */   @Deprecated
/*     */   public StringBody(String paramString1, String paramString2, Charset paramCharset) throws UnsupportedEncodingException {
/* 113 */     this(paramString1, ContentType.create(paramString2, (paramCharset != null) ? paramCharset : Consts.ASCII));
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
/*     */   @Deprecated
/*     */   public StringBody(String paramString, Charset paramCharset) throws UnsupportedEncodingException {
/* 130 */     this(paramString, "text/plain", paramCharset);
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
/*     */   @Deprecated
/*     */   public StringBody(String paramString) throws UnsupportedEncodingException {
/* 147 */     this(paramString, "text/plain", Consts.ASCII);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBody(String paramString, ContentType paramContentType) {
/* 154 */     super(paramContentType);
/* 155 */     Args.notNull(paramString, "Text");
/* 156 */     Charset charset = paramContentType.getCharset();
/* 157 */     this.content = paramString.getBytes((charset != null) ? charset : Consts.ASCII);
/*     */   }
/*     */   
/*     */   public Reader getReader() {
/* 161 */     Charset charset = getContentType().getCharset();
/* 162 */     return new InputStreamReader(new ByteArrayInputStream(this.content), (charset != null) ? charset : Consts.ASCII);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 169 */     Args.notNull(paramOutputStream, "Output stream");
/* 170 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
/* 171 */     byte[] arrayOfByte = new byte[4096];
/*     */     int i;
/* 173 */     while ((i = byteArrayInputStream.read(arrayOfByte)) != -1) {
/* 174 */       paramOutputStream.write(arrayOfByte, 0, i);
/*     */     }
/* 176 */     paramOutputStream.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTransferEncoding() {
/* 181 */     return "8bit";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 186 */     return this.content.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFilename() {
/* 191 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\content\StringBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */