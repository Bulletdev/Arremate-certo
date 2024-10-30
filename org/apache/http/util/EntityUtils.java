/*     */ package org.apache.http.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.UnsupportedCharsetException;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.protocol.HTTP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EntityUtils
/*     */ {
/*     */   private static final int DEFAULT_BUFFER_SIZE = 4096;
/*     */   
/*     */   public static void consumeQuietly(HttpEntity paramHttpEntity) {
/*     */     try {
/*  69 */       consume(paramHttpEntity);
/*  70 */     } catch (IOException iOException) {}
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
/*     */   public static void consume(HttpEntity paramHttpEntity) throws IOException {
/*  84 */     if (paramHttpEntity == null) {
/*     */       return;
/*     */     }
/*  87 */     if (paramHttpEntity.isStreaming()) {
/*  88 */       InputStream inputStream = paramHttpEntity.getContent();
/*  89 */       if (inputStream != null) {
/*  90 */         inputStream.close();
/*     */       }
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
/*     */   public static void updateEntity(HttpResponse paramHttpResponse, HttpEntity paramHttpEntity) throws IOException {
/* 108 */     Args.notNull(paramHttpResponse, "Response");
/* 109 */     consume(paramHttpResponse.getEntity());
/* 110 */     paramHttpResponse.setEntity(paramHttpEntity);
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
/*     */   public static byte[] toByteArray(HttpEntity paramHttpEntity) throws IOException {
/* 123 */     Args.notNull(paramHttpEntity, "Entity");
/* 124 */     InputStream inputStream = paramHttpEntity.getContent();
/* 125 */     if (inputStream == null) {
/* 126 */       return null;
/*     */     }
/*     */     try {
/* 129 */       Args.check((paramHttpEntity.getContentLength() <= 2147483647L), "HTTP entity too large to be buffered in memory");
/*     */       
/* 131 */       int i = (int)paramHttpEntity.getContentLength();
/* 132 */       if (i < 0) {
/* 133 */         i = 4096;
/*     */       }
/* 135 */       ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i);
/* 136 */       byte[] arrayOfByte = new byte[4096];
/*     */       int j;
/* 138 */       while ((j = inputStream.read(arrayOfByte)) != -1) {
/* 139 */         byteArrayBuffer.append(arrayOfByte, 0, j);
/*     */       }
/* 141 */       return byteArrayBuffer.toByteArray();
/*     */     } finally {
/* 143 */       inputStream.close();
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
/*     */   @Deprecated
/*     */   public static String getContentCharSet(HttpEntity paramHttpEntity) throws ParseException {
/* 159 */     Args.notNull(paramHttpEntity, "Entity");
/* 160 */     String str = null;
/* 161 */     if (paramHttpEntity.getContentType() != null) {
/* 162 */       HeaderElement[] arrayOfHeaderElement = paramHttpEntity.getContentType().getElements();
/* 163 */       if (arrayOfHeaderElement.length > 0) {
/* 164 */         NameValuePair nameValuePair = arrayOfHeaderElement[0].getParameterByName("charset");
/* 165 */         if (nameValuePair != null) {
/* 166 */           str = nameValuePair.getValue();
/*     */         }
/*     */       } 
/*     */     } 
/* 170 */     return str;
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
/*     */   public static String getContentMimeType(HttpEntity paramHttpEntity) throws ParseException {
/* 187 */     Args.notNull(paramHttpEntity, "Entity");
/* 188 */     String str = null;
/* 189 */     if (paramHttpEntity.getContentType() != null) {
/* 190 */       HeaderElement[] arrayOfHeaderElement = paramHttpEntity.getContentType().getElements();
/* 191 */       if (arrayOfHeaderElement.length > 0) {
/* 192 */         str = arrayOfHeaderElement[0].getName();
/*     */       }
/*     */     } 
/* 195 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String toString(HttpEntity paramHttpEntity, ContentType paramContentType) throws IOException {
/* 201 */     InputStream inputStream = paramHttpEntity.getContent();
/* 202 */     if (inputStream == null) {
/* 203 */       return null;
/*     */     }
/*     */     try {
/* 206 */       Args.check((paramHttpEntity.getContentLength() <= 2147483647L), "HTTP entity too large to be buffered in memory");
/*     */       
/* 208 */       int i = (int)paramHttpEntity.getContentLength();
/* 209 */       if (i < 0) {
/* 210 */         i = 4096;
/*     */       }
/* 212 */       Charset charset = null;
/* 213 */       if (paramContentType != null) {
/* 214 */         charset = paramContentType.getCharset();
/* 215 */         if (charset == null) {
/* 216 */           ContentType contentType = ContentType.getByMimeType(paramContentType.getMimeType());
/* 217 */           charset = (contentType != null) ? contentType.getCharset() : null;
/*     */         } 
/*     */       } 
/* 220 */       if (charset == null) {
/* 221 */         charset = HTTP.DEF_CONTENT_CHARSET;
/*     */       }
/* 223 */       InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
/* 224 */       CharArrayBuffer charArrayBuffer = new CharArrayBuffer(i);
/* 225 */       char[] arrayOfChar = new char[1024];
/*     */       int j;
/* 227 */       while ((j = inputStreamReader.read(arrayOfChar)) != -1) {
/* 228 */         charArrayBuffer.append(arrayOfChar, 0, j);
/*     */       }
/* 230 */       return charArrayBuffer.toString();
/*     */     } finally {
/* 232 */       inputStream.close();
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
/*     */   public static String toString(HttpEntity paramHttpEntity, Charset paramCharset) throws IOException, ParseException {
/* 254 */     Args.notNull(paramHttpEntity, "Entity");
/* 255 */     ContentType contentType = null;
/*     */     try {
/* 257 */       contentType = ContentType.get(paramHttpEntity);
/* 258 */     } catch (UnsupportedCharsetException unsupportedCharsetException) {
/* 259 */       if (paramCharset == null) {
/* 260 */         throw new UnsupportedEncodingException(unsupportedCharsetException.getMessage());
/*     */       }
/*     */     } 
/* 263 */     if (contentType != null) {
/* 264 */       if (contentType.getCharset() == null) {
/* 265 */         contentType = contentType.withCharset(paramCharset);
/*     */       }
/*     */     } else {
/* 268 */       contentType = ContentType.DEFAULT_TEXT.withCharset(paramCharset);
/*     */     } 
/* 270 */     return toString(paramHttpEntity, contentType);
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
/*     */   public static String toString(HttpEntity paramHttpEntity, String paramString) throws IOException, ParseException {
/* 290 */     return toString(paramHttpEntity, (paramString != null) ? Charset.forName(paramString) : null);
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
/*     */   public static String toString(HttpEntity paramHttpEntity) throws IOException, ParseException {
/* 307 */     Args.notNull(paramHttpEntity, "Entity");
/* 308 */     return toString(paramHttpEntity, ContentType.get(paramHttpEntity));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\EntityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */