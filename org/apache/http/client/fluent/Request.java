/*     */ package org.apache.http.client.fluent;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.nio.charset.Charset;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.Configurable;
/*     */ import org.apache.http.client.utils.URLEncodedUtils;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Request
/*     */ {
/*     */   public static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";
/*  70 */   public static final Locale DATE_LOCALE = Locale.US;
/*  71 */   public static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT");
/*     */   
/*     */   private final InternalHttpRequest request;
/*     */   
/*     */   private Boolean useExpectContinue;
/*     */   private Integer socketTmeout;
/*     */   private Integer connectTimeout;
/*     */   private HttpHost proxy;
/*     */   private SimpleDateFormat dateFormatter;
/*     */   
/*     */   public static Request Get(URI paramURI) {
/*  82 */     return new Request(new InternalHttpRequest("GET", paramURI));
/*     */   }
/*     */   
/*     */   public static Request Get(String paramString) {
/*  86 */     return new Request(new InternalHttpRequest("GET", URI.create(paramString)));
/*     */   }
/*     */   
/*     */   public static Request Head(URI paramURI) {
/*  90 */     return new Request(new InternalHttpRequest("HEAD", paramURI));
/*     */   }
/*     */   
/*     */   public static Request Head(String paramString) {
/*  94 */     return new Request(new InternalHttpRequest("HEAD", URI.create(paramString)));
/*     */   }
/*     */   
/*     */   public static Request Post(URI paramURI) {
/*  98 */     return new Request(new InternalEntityEnclosingHttpRequest("POST", paramURI));
/*     */   }
/*     */   
/*     */   public static Request Post(String paramString) {
/* 102 */     return new Request(new InternalEntityEnclosingHttpRequest("POST", URI.create(paramString)));
/*     */   }
/*     */   
/*     */   public static Request Patch(URI paramURI) {
/* 106 */     return new Request(new InternalEntityEnclosingHttpRequest("PATCH", paramURI));
/*     */   }
/*     */   
/*     */   public static Request Patch(String paramString) {
/* 110 */     return new Request(new InternalEntityEnclosingHttpRequest("PATCH", URI.create(paramString)));
/*     */   }
/*     */   
/*     */   public static Request Put(URI paramURI) {
/* 114 */     return new Request(new InternalEntityEnclosingHttpRequest("PUT", paramURI));
/*     */   }
/*     */   
/*     */   public static Request Put(String paramString) {
/* 118 */     return new Request(new InternalEntityEnclosingHttpRequest("PUT", URI.create(paramString)));
/*     */   }
/*     */   
/*     */   public static Request Trace(URI paramURI) {
/* 122 */     return new Request(new InternalHttpRequest("TRACE", paramURI));
/*     */   }
/*     */   
/*     */   public static Request Trace(String paramString) {
/* 126 */     return new Request(new InternalHttpRequest("TRACE", URI.create(paramString)));
/*     */   }
/*     */   
/*     */   public static Request Delete(URI paramURI) {
/* 130 */     return new Request(new InternalHttpRequest("DELETE", paramURI));
/*     */   }
/*     */   
/*     */   public static Request Delete(String paramString) {
/* 134 */     return new Request(new InternalHttpRequest("DELETE", URI.create(paramString)));
/*     */   }
/*     */   
/*     */   public static Request Options(URI paramURI) {
/* 138 */     return new Request(new InternalHttpRequest("OPTIONS", paramURI));
/*     */   }
/*     */   
/*     */   public static Request Options(String paramString) {
/* 142 */     return new Request(new InternalHttpRequest("OPTIONS", URI.create(paramString)));
/*     */   }
/*     */ 
/*     */   
/*     */   Request(InternalHttpRequest paramInternalHttpRequest) {
/* 147 */     this.request = paramInternalHttpRequest;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   HttpResponse internalExecute(HttpClient paramHttpClient, HttpContext paramHttpContext) throws ClientProtocolException, IOException {
/*     */     RequestConfig.Builder builder;
/* 154 */     if (paramHttpClient instanceof Configurable) {
/* 155 */       builder = RequestConfig.copy(((Configurable)paramHttpClient).getConfig());
/*     */     } else {
/* 157 */       builder = RequestConfig.custom();
/*     */     } 
/* 159 */     if (this.useExpectContinue != null) {
/* 160 */       builder.setExpectContinueEnabled(this.useExpectContinue.booleanValue());
/*     */     }
/* 162 */     if (this.socketTmeout != null) {
/* 163 */       builder.setSocketTimeout(this.socketTmeout.intValue());
/*     */     }
/* 165 */     if (this.connectTimeout != null) {
/* 166 */       builder.setConnectTimeout(this.connectTimeout.intValue());
/*     */     }
/* 168 */     if (this.proxy != null) {
/* 169 */       builder.setProxy(this.proxy);
/*     */     }
/* 171 */     RequestConfig requestConfig = builder.build();
/* 172 */     this.request.setConfig(requestConfig);
/* 173 */     return paramHttpClient.execute(this.request, paramHttpContext);
/*     */   }
/*     */   
/*     */   public Response execute() throws ClientProtocolException, IOException {
/* 177 */     return new Response(internalExecute(Executor.CLIENT, null));
/*     */   }
/*     */   
/*     */   public void abort() throws UnsupportedOperationException {
/* 181 */     this.request.abort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Request addHeader(Header paramHeader) {
/* 187 */     this.request.addHeader(paramHeader);
/* 188 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Request setHeader(Header paramHeader) {
/* 195 */     this.request.setHeader(paramHeader);
/* 196 */     return this;
/*     */   }
/*     */   
/*     */   public Request addHeader(String paramString1, String paramString2) {
/* 200 */     this.request.addHeader(paramString1, paramString2);
/* 201 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Request setHeader(String paramString1, String paramString2) {
/* 208 */     this.request.setHeader(paramString1, paramString2);
/* 209 */     return this;
/*     */   }
/*     */   
/*     */   public Request removeHeader(Header paramHeader) {
/* 213 */     this.request.removeHeader(paramHeader);
/* 214 */     return this;
/*     */   }
/*     */   
/*     */   public Request removeHeaders(String paramString) {
/* 218 */     this.request.removeHeaders(paramString);
/* 219 */     return this;
/*     */   }
/*     */   
/*     */   public Request setHeaders(Header... paramVarArgs) {
/* 223 */     this.request.setHeaders(paramVarArgs);
/* 224 */     return this;
/*     */   }
/*     */   
/*     */   public Request setCacheControl(String paramString) {
/* 228 */     this.request.setHeader("Cache-Control", paramString);
/* 229 */     return this;
/*     */   }
/*     */   
/*     */   private SimpleDateFormat getDateFormat() {
/* 233 */     if (this.dateFormatter == null) {
/* 234 */       this.dateFormatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", DATE_LOCALE);
/* 235 */       this.dateFormatter.setTimeZone(TIME_ZONE);
/*     */     } 
/* 237 */     return this.dateFormatter;
/*     */   }
/*     */   
/*     */   public Request setDate(Date paramDate) {
/* 241 */     this.request.setHeader("Date", getDateFormat().format(paramDate));
/* 242 */     return this;
/*     */   }
/*     */   
/*     */   public Request setIfModifiedSince(Date paramDate) {
/* 246 */     this.request.setHeader("If-Modified-Since", getDateFormat().format(paramDate));
/* 247 */     return this;
/*     */   }
/*     */   
/*     */   public Request setIfUnmodifiedSince(Date paramDate) {
/* 251 */     this.request.setHeader("If-Unmodified-Since", getDateFormat().format(paramDate));
/* 252 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Request config(String paramString, Object paramObject) {
/* 262 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Request removeConfig(String paramString) {
/* 272 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Request version(HttpVersion paramHttpVersion) {
/* 278 */     this.request.setProtocolVersion((ProtocolVersion)paramHttpVersion);
/* 279 */     return this;
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
/*     */   @Deprecated
/*     */   public Request elementCharset(String paramString) {
/* 292 */     return this;
/*     */   }
/*     */   
/*     */   public Request useExpectContinue() {
/* 296 */     this.useExpectContinue = Boolean.TRUE;
/* 297 */     return this;
/*     */   }
/*     */   
/*     */   public Request userAgent(String paramString) {
/* 301 */     this.request.setHeader("User-Agent", paramString);
/* 302 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Request socketTimeout(int paramInt) {
/* 308 */     this.socketTmeout = Integer.valueOf(paramInt);
/* 309 */     return this;
/*     */   }
/*     */   
/*     */   public Request connectTimeout(int paramInt) {
/* 313 */     this.connectTimeout = Integer.valueOf(paramInt);
/* 314 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Request staleConnectionCheck(boolean paramBoolean) {
/* 324 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Request viaProxy(HttpHost paramHttpHost) {
/* 330 */     this.proxy = paramHttpHost;
/* 331 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Request viaProxy(String paramString) {
/* 338 */     this.proxy = HttpHost.create(paramString);
/* 339 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Request body(HttpEntity paramHttpEntity) {
/* 345 */     if (this.request instanceof HttpEntityEnclosingRequest) {
/* 346 */       ((HttpEntityEnclosingRequest)this.request).setEntity(paramHttpEntity);
/*     */     } else {
/* 348 */       throw new IllegalStateException(this.request.getMethod() + " request cannot enclose an entity");
/*     */     } 
/*     */     
/* 351 */     return this;
/*     */   }
/*     */   
/*     */   public Request bodyForm(Iterable<? extends NameValuePair> paramIterable, Charset paramCharset) {
/* 355 */     ArrayList<NameValuePair> arrayList = new ArrayList();
/* 356 */     for (NameValuePair nameValuePair : paramIterable) {
/* 357 */       arrayList.add(nameValuePair);
/*     */     }
/* 359 */     ContentType contentType = ContentType.create("application/x-www-form-urlencoded", paramCharset);
/* 360 */     String str = URLEncodedUtils.format(arrayList, paramCharset);
/* 361 */     return bodyString(str, contentType);
/*     */   }
/*     */   
/*     */   public Request bodyForm(Iterable<? extends NameValuePair> paramIterable) {
/* 365 */     return bodyForm(paramIterable, Consts.ISO_8859_1);
/*     */   }
/*     */   
/*     */   public Request bodyForm(NameValuePair... paramVarArgs) {
/* 369 */     return bodyForm(Arrays.asList(paramVarArgs), Consts.ISO_8859_1);
/*     */   }
/*     */   
/*     */   public Request bodyString(String paramString, ContentType paramContentType) {
/* 373 */     Charset charset = (paramContentType != null) ? paramContentType.getCharset() : null;
/* 374 */     byte[] arrayOfByte = (charset != null) ? paramString.getBytes(charset) : paramString.getBytes();
/* 375 */     return body((HttpEntity)new InternalByteArrayEntity(arrayOfByte, paramContentType));
/*     */   }
/*     */   
/*     */   public Request bodyFile(File paramFile, ContentType paramContentType) {
/* 379 */     return body((HttpEntity)new InternalFileEntity(paramFile, paramContentType));
/*     */   }
/*     */   
/*     */   public Request bodyByteArray(byte[] paramArrayOfbyte) {
/* 383 */     return body((HttpEntity)new InternalByteArrayEntity(paramArrayOfbyte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Request bodyByteArray(byte[] paramArrayOfbyte, ContentType paramContentType) {
/* 390 */     return body((HttpEntity)new InternalByteArrayEntity(paramArrayOfbyte, paramContentType));
/*     */   }
/*     */   
/*     */   public Request bodyByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 394 */     return body((HttpEntity)new InternalByteArrayEntity(paramArrayOfbyte, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Request bodyByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ContentType paramContentType) {
/* 401 */     return body((HttpEntity)new InternalByteArrayEntity(paramArrayOfbyte, paramInt1, paramInt2, paramContentType));
/*     */   }
/*     */   
/*     */   public Request bodyStream(InputStream paramInputStream) {
/* 405 */     return body((HttpEntity)new InternalInputStreamEntity(paramInputStream, -1L, null));
/*     */   }
/*     */   
/*     */   public Request bodyStream(InputStream paramInputStream, ContentType paramContentType) {
/* 409 */     return body((HttpEntity)new InternalInputStreamEntity(paramInputStream, -1L, paramContentType));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 414 */     return this.request.getRequestLine().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */