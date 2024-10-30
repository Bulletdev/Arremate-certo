/*     */ package org.apache.http.entity.mime;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.entity.mime.content.ByteArrayBody;
/*     */ import org.apache.http.entity.mime.content.ContentBody;
/*     */ import org.apache.http.entity.mime.content.FileBody;
/*     */ import org.apache.http.entity.mime.content.InputStreamBody;
/*     */ import org.apache.http.entity.mime.content.StringBody;
/*     */ import org.apache.http.message.BasicNameValuePair;
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
/*     */ public class MultipartEntityBuilder
/*     */ {
/*  59 */   private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_SUBTYPE = "form-data";
/*     */   
/*     */   private ContentType contentType;
/*     */   
/*  66 */   private HttpMultipartMode mode = HttpMultipartMode.STRICT;
/*  67 */   private String boundary = null;
/*  68 */   private Charset charset = null;
/*  69 */   private List<FormBodyPart> bodyParts = null;
/*     */   
/*     */   public static MultipartEntityBuilder create() {
/*  72 */     return new MultipartEntityBuilder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder setMode(HttpMultipartMode paramHttpMultipartMode) {
/*  79 */     this.mode = paramHttpMultipartMode;
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public MultipartEntityBuilder setLaxMode() {
/*  84 */     this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
/*  85 */     return this;
/*     */   }
/*     */   
/*     */   public MultipartEntityBuilder setStrictMode() {
/*  89 */     this.mode = HttpMultipartMode.STRICT;
/*  90 */     return this;
/*     */   }
/*     */   
/*     */   public MultipartEntityBuilder setBoundary(String paramString) {
/*  94 */     this.boundary = paramString;
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder setMimeSubtype(String paramString) {
/* 102 */     Args.notBlank(paramString, "MIME subtype");
/* 103 */     this.contentType = ContentType.create("multipart/" + paramString);
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public MultipartEntityBuilder seContentType(ContentType paramContentType) {
/* 114 */     return setContentType(paramContentType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder setContentType(ContentType paramContentType) {
/* 121 */     Args.notNull(paramContentType, "Content type");
/* 122 */     this.contentType = paramContentType;
/* 123 */     return this;
/*     */   }
/*     */   
/*     */   public MultipartEntityBuilder setCharset(Charset paramCharset) {
/* 127 */     this.charset = paramCharset;
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder addPart(FormBodyPart paramFormBodyPart) {
/* 135 */     if (paramFormBodyPart == null) {
/* 136 */       return this;
/*     */     }
/* 138 */     if (this.bodyParts == null) {
/* 139 */       this.bodyParts = new ArrayList<FormBodyPart>();
/*     */     }
/* 141 */     this.bodyParts.add(paramFormBodyPart);
/* 142 */     return this;
/*     */   }
/*     */   
/*     */   public MultipartEntityBuilder addPart(String paramString, ContentBody paramContentBody) {
/* 146 */     Args.notNull(paramString, "Name");
/* 147 */     Args.notNull(paramContentBody, "Content body");
/* 148 */     return addPart(FormBodyPartBuilder.create(paramString, paramContentBody).build());
/*     */   }
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder addTextBody(String paramString1, String paramString2, ContentType paramContentType) {
/* 153 */     return addPart(paramString1, (ContentBody)new StringBody(paramString2, paramContentType));
/*     */   }
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder addTextBody(String paramString1, String paramString2) {
/* 158 */     return addTextBody(paramString1, paramString2, ContentType.DEFAULT_TEXT);
/*     */   }
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder addBinaryBody(String paramString1, byte[] paramArrayOfbyte, ContentType paramContentType, String paramString2) {
/* 163 */     return addPart(paramString1, (ContentBody)new ByteArrayBody(paramArrayOfbyte, paramContentType, paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder addBinaryBody(String paramString, byte[] paramArrayOfbyte) {
/* 168 */     return addBinaryBody(paramString, paramArrayOfbyte, ContentType.DEFAULT_BINARY, (String)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder addBinaryBody(String paramString1, File paramFile, ContentType paramContentType, String paramString2) {
/* 173 */     return addPart(paramString1, (ContentBody)new FileBody(paramFile, paramContentType, paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder addBinaryBody(String paramString, File paramFile) {
/* 178 */     return addBinaryBody(paramString, paramFile, ContentType.DEFAULT_BINARY, (paramFile != null) ? paramFile.getName() : null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MultipartEntityBuilder addBinaryBody(String paramString1, InputStream paramInputStream, ContentType paramContentType, String paramString2) {
/* 184 */     return addPart(paramString1, (ContentBody)new InputStreamBody(paramInputStream, paramContentType, paramString2));
/*     */   }
/*     */   
/*     */   public MultipartEntityBuilder addBinaryBody(String paramString, InputStream paramInputStream) {
/* 188 */     return addBinaryBody(paramString, paramInputStream, ContentType.DEFAULT_BINARY, (String)null);
/*     */   }
/*     */   
/*     */   private String generateBoundary() {
/* 192 */     StringBuilder stringBuilder = new StringBuilder();
/* 193 */     Random random = new Random();
/* 194 */     int i = random.nextInt(11) + 30;
/* 195 */     for (byte b = 0; b < i; b++) {
/* 196 */       stringBuilder.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
/*     */     }
/* 198 */     return stringBuilder.toString();
/*     */   } MultipartFormEntity buildEntity() {
/*     */     HttpBrowserCompatibleMultipart httpBrowserCompatibleMultipart;
/*     */     HttpRFC6532Multipart httpRFC6532Multipart;
/* 202 */     String str = this.boundary;
/* 203 */     if (str == null && this.contentType != null) {
/* 204 */       str = this.contentType.getParameter("boundary");
/*     */     }
/* 206 */     if (str == null) {
/* 207 */       str = generateBoundary();
/*     */     }
/* 209 */     Charset charset = this.charset;
/* 210 */     if (charset == null && this.contentType != null) {
/* 211 */       charset = this.contentType.getCharset();
/*     */     }
/* 213 */     ArrayList<BasicNameValuePair> arrayList = new ArrayList(2);
/* 214 */     arrayList.add(new BasicNameValuePair("boundary", str));
/* 215 */     if (charset != null) {
/* 216 */       arrayList.add(new BasicNameValuePair("charset", charset.name()));
/*     */     }
/* 218 */     NameValuePair[] arrayOfNameValuePair = arrayList.<NameValuePair>toArray(new NameValuePair[arrayList.size()]);
/* 219 */     ContentType contentType = (this.contentType != null) ? this.contentType.withParameters(arrayOfNameValuePair) : ContentType.create("multipart/form-data", arrayOfNameValuePair);
/*     */ 
/*     */     
/* 222 */     List<FormBodyPart> list = (this.bodyParts != null) ? new ArrayList<FormBodyPart>(this.bodyParts) : Collections.emptyList();
/*     */     
/* 224 */     HttpMultipartMode httpMultipartMode = (this.mode != null) ? this.mode : HttpMultipartMode.STRICT;
/*     */     
/* 226 */     switch (httpMultipartMode)
/*     */     { case BROWSER_COMPATIBLE:
/* 228 */         httpBrowserCompatibleMultipart = new HttpBrowserCompatibleMultipart(charset, str, list);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 236 */         return new MultipartFormEntity(httpBrowserCompatibleMultipart, contentType, httpBrowserCompatibleMultipart.getTotalLength());case RFC6532: httpRFC6532Multipart = new HttpRFC6532Multipart(charset, str, list); return new MultipartFormEntity(httpRFC6532Multipart, contentType, httpRFC6532Multipart.getTotalLength()); }  HttpStrictMultipart httpStrictMultipart = new HttpStrictMultipart(charset, str, list); return new MultipartFormEntity(httpStrictMultipart, contentType, httpStrictMultipart.getTotalLength());
/*     */   }
/*     */   
/*     */   public HttpEntity build() {
/* 240 */     return buildEntity();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\MultipartEntityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */