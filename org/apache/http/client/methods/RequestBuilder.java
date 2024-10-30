/*     */ package org.apache.http.client.methods;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderIterator;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.entity.UrlEncodedFormEntity;
/*     */ import org.apache.http.client.utils.URIBuilder;
/*     */ import org.apache.http.client.utils.URLEncodedUtils;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.message.BasicHeader;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.apache.http.message.HeaderGroup;
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
/*     */ public class RequestBuilder
/*     */ {
/*     */   private String method;
/*     */   private Charset charset;
/*     */   private ProtocolVersion version;
/*     */   private URI uri;
/*     */   private HeaderGroup headerGroup;
/*     */   private HttpEntity entity;
/*     */   private List<NameValuePair> parameters;
/*     */   private RequestConfig config;
/*     */   
/*     */   RequestBuilder(String paramString) {
/*  82 */     this.charset = Consts.UTF_8;
/*  83 */     this.method = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   RequestBuilder(String paramString, URI paramURI) {
/*  88 */     this.method = paramString;
/*  89 */     this.uri = paramURI;
/*     */   }
/*     */ 
/*     */   
/*     */   RequestBuilder(String paramString1, String paramString2) {
/*  94 */     this.method = paramString1;
/*  95 */     this.uri = (paramString2 != null) ? URI.create(paramString2) : null;
/*     */   }
/*     */   
/*     */   RequestBuilder() {
/*  99 */     this(null);
/*     */   }
/*     */   
/*     */   public static RequestBuilder create(String paramString) {
/* 103 */     Args.notBlank(paramString, "HTTP method");
/* 104 */     return new RequestBuilder(paramString);
/*     */   }
/*     */   
/*     */   public static RequestBuilder get() {
/* 108 */     return new RequestBuilder("GET");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder get(URI paramURI) {
/* 115 */     return new RequestBuilder("GET", paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder get(String paramString) {
/* 122 */     return new RequestBuilder("GET", paramString);
/*     */   }
/*     */   
/*     */   public static RequestBuilder head() {
/* 126 */     return new RequestBuilder("HEAD");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder head(URI paramURI) {
/* 133 */     return new RequestBuilder("HEAD", paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder head(String paramString) {
/* 140 */     return new RequestBuilder("HEAD", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder patch() {
/* 147 */     return new RequestBuilder("PATCH");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder patch(URI paramURI) {
/* 154 */     return new RequestBuilder("PATCH", paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder patch(String paramString) {
/* 161 */     return new RequestBuilder("PATCH", paramString);
/*     */   }
/*     */   
/*     */   public static RequestBuilder post() {
/* 165 */     return new RequestBuilder("POST");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder post(URI paramURI) {
/* 172 */     return new RequestBuilder("POST", paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder post(String paramString) {
/* 179 */     return new RequestBuilder("POST", paramString);
/*     */   }
/*     */   
/*     */   public static RequestBuilder put() {
/* 183 */     return new RequestBuilder("PUT");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder put(URI paramURI) {
/* 190 */     return new RequestBuilder("PUT", paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder put(String paramString) {
/* 197 */     return new RequestBuilder("PUT", paramString);
/*     */   }
/*     */   
/*     */   public static RequestBuilder delete() {
/* 201 */     return new RequestBuilder("DELETE");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder delete(URI paramURI) {
/* 208 */     return new RequestBuilder("DELETE", paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder delete(String paramString) {
/* 215 */     return new RequestBuilder("DELETE", paramString);
/*     */   }
/*     */   
/*     */   public static RequestBuilder trace() {
/* 219 */     return new RequestBuilder("TRACE");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder trace(URI paramURI) {
/* 226 */     return new RequestBuilder("TRACE", paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder trace(String paramString) {
/* 233 */     return new RequestBuilder("TRACE", paramString);
/*     */   }
/*     */   
/*     */   public static RequestBuilder options() {
/* 237 */     return new RequestBuilder("OPTIONS");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder options(URI paramURI) {
/* 244 */     return new RequestBuilder("OPTIONS", paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestBuilder options(String paramString) {
/* 251 */     return new RequestBuilder("OPTIONS", paramString);
/*     */   }
/*     */   
/*     */   public static RequestBuilder copy(HttpRequest paramHttpRequest) {
/* 255 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 256 */     return (new RequestBuilder()).doCopy(paramHttpRequest);
/*     */   }
/*     */   
/*     */   private RequestBuilder doCopy(HttpRequest paramHttpRequest) {
/* 260 */     if (paramHttpRequest == null) {
/* 261 */       return this;
/*     */     }
/* 263 */     this.method = paramHttpRequest.getRequestLine().getMethod();
/* 264 */     this.version = paramHttpRequest.getRequestLine().getProtocolVersion();
/*     */     
/* 266 */     if (this.headerGroup == null) {
/* 267 */       this.headerGroup = new HeaderGroup();
/*     */     }
/* 269 */     this.headerGroup.clear();
/* 270 */     this.headerGroup.setHeaders(paramHttpRequest.getAllHeaders());
/*     */     
/* 272 */     this.parameters = null;
/* 273 */     this.entity = null;
/*     */     
/* 275 */     if (paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/* 276 */       HttpEntity httpEntity = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
/* 277 */       ContentType contentType = ContentType.get(httpEntity);
/* 278 */       if (contentType != null && contentType.getMimeType().equals(ContentType.APPLICATION_FORM_URLENCODED.getMimeType())) {
/*     */         
/*     */         try {
/* 281 */           this.charset = contentType.getCharset();
/* 282 */           List<NameValuePair> list = URLEncodedUtils.parse(httpEntity);
/* 283 */           if (!list.isEmpty()) {
/* 284 */             this.parameters = list;
/*     */           }
/* 286 */         } catch (IOException iOException) {}
/*     */       } else {
/*     */         
/* 289 */         this.entity = httpEntity;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 294 */     if (paramHttpRequest instanceof HttpUriRequest) {
/* 295 */       this.uri = ((HttpUriRequest)paramHttpRequest).getURI();
/*     */     } else {
/* 297 */       this.uri = URI.create(paramHttpRequest.getRequestLine().getUri());
/*     */     } 
/*     */     
/* 300 */     if (paramHttpRequest instanceof Configurable) {
/* 301 */       this.config = ((Configurable)paramHttpRequest).getConfig();
/*     */     } else {
/* 303 */       this.config = null;
/*     */     } 
/* 305 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RequestBuilder setCharset(Charset paramCharset) {
/* 312 */     this.charset = paramCharset;
/* 313 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Charset getCharset() {
/* 320 */     return this.charset;
/*     */   }
/*     */   
/*     */   public String getMethod() {
/* 324 */     return this.method;
/*     */   }
/*     */   
/*     */   public ProtocolVersion getVersion() {
/* 328 */     return this.version;
/*     */   }
/*     */   
/*     */   public RequestBuilder setVersion(ProtocolVersion paramProtocolVersion) {
/* 332 */     this.version = paramProtocolVersion;
/* 333 */     return this;
/*     */   }
/*     */   
/*     */   public URI getUri() {
/* 337 */     return this.uri;
/*     */   }
/*     */   
/*     */   public RequestBuilder setUri(URI paramURI) {
/* 341 */     this.uri = paramURI;
/* 342 */     return this;
/*     */   }
/*     */   
/*     */   public RequestBuilder setUri(String paramString) {
/* 346 */     this.uri = (paramString != null) ? URI.create(paramString) : null;
/* 347 */     return this;
/*     */   }
/*     */   
/*     */   public Header getFirstHeader(String paramString) {
/* 351 */     return (this.headerGroup != null) ? this.headerGroup.getFirstHeader(paramString) : null;
/*     */   }
/*     */   
/*     */   public Header getLastHeader(String paramString) {
/* 355 */     return (this.headerGroup != null) ? this.headerGroup.getLastHeader(paramString) : null;
/*     */   }
/*     */   
/*     */   public Header[] getHeaders(String paramString) {
/* 359 */     return (this.headerGroup != null) ? this.headerGroup.getHeaders(paramString) : null;
/*     */   }
/*     */   
/*     */   public RequestBuilder addHeader(Header paramHeader) {
/* 363 */     if (this.headerGroup == null) {
/* 364 */       this.headerGroup = new HeaderGroup();
/*     */     }
/* 366 */     this.headerGroup.addHeader(paramHeader);
/* 367 */     return this;
/*     */   }
/*     */   
/*     */   public RequestBuilder addHeader(String paramString1, String paramString2) {
/* 371 */     if (this.headerGroup == null) {
/* 372 */       this.headerGroup = new HeaderGroup();
/*     */     }
/* 374 */     this.headerGroup.addHeader((Header)new BasicHeader(paramString1, paramString2));
/* 375 */     return this;
/*     */   }
/*     */   
/*     */   public RequestBuilder removeHeader(Header paramHeader) {
/* 379 */     if (this.headerGroup == null) {
/* 380 */       this.headerGroup = new HeaderGroup();
/*     */     }
/* 382 */     this.headerGroup.removeHeader(paramHeader);
/* 383 */     return this;
/*     */   }
/*     */   
/*     */   public RequestBuilder removeHeaders(String paramString) {
/* 387 */     if (paramString == null || this.headerGroup == null) {
/* 388 */       return this;
/*     */     }
/* 390 */     for (HeaderIterator headerIterator = this.headerGroup.iterator(); headerIterator.hasNext(); ) {
/* 391 */       Header header = headerIterator.nextHeader();
/* 392 */       if (paramString.equalsIgnoreCase(header.getName())) {
/* 393 */         headerIterator.remove();
/*     */       }
/*     */     } 
/* 396 */     return this;
/*     */   }
/*     */   
/*     */   public RequestBuilder setHeader(Header paramHeader) {
/* 400 */     if (this.headerGroup == null) {
/* 401 */       this.headerGroup = new HeaderGroup();
/*     */     }
/* 403 */     this.headerGroup.updateHeader(paramHeader);
/* 404 */     return this;
/*     */   }
/*     */   
/*     */   public RequestBuilder setHeader(String paramString1, String paramString2) {
/* 408 */     if (this.headerGroup == null) {
/* 409 */       this.headerGroup = new HeaderGroup();
/*     */     }
/* 411 */     this.headerGroup.updateHeader((Header)new BasicHeader(paramString1, paramString2));
/* 412 */     return this;
/*     */   }
/*     */   
/*     */   public HttpEntity getEntity() {
/* 416 */     return this.entity;
/*     */   }
/*     */   
/*     */   public RequestBuilder setEntity(HttpEntity paramHttpEntity) {
/* 420 */     this.entity = paramHttpEntity;
/* 421 */     return this;
/*     */   }
/*     */   
/*     */   public List<NameValuePair> getParameters() {
/* 425 */     return (this.parameters != null) ? new ArrayList<NameValuePair>(this.parameters) : new ArrayList<NameValuePair>();
/*     */   }
/*     */ 
/*     */   
/*     */   public RequestBuilder addParameter(NameValuePair paramNameValuePair) {
/* 430 */     Args.notNull(paramNameValuePair, "Name value pair");
/* 431 */     if (this.parameters == null) {
/* 432 */       this.parameters = new LinkedList<NameValuePair>();
/*     */     }
/* 434 */     this.parameters.add(paramNameValuePair);
/* 435 */     return this;
/*     */   }
/*     */   
/*     */   public RequestBuilder addParameter(String paramString1, String paramString2) {
/* 439 */     return addParameter((NameValuePair)new BasicNameValuePair(paramString1, paramString2));
/*     */   }
/*     */   
/*     */   public RequestBuilder addParameters(NameValuePair... paramVarArgs) {
/* 443 */     for (NameValuePair nameValuePair : paramVarArgs) {
/* 444 */       addParameter(nameValuePair);
/*     */     }
/* 446 */     return this;
/*     */   }
/*     */   
/*     */   public RequestConfig getConfig() {
/* 450 */     return this.config;
/*     */   }
/*     */   
/*     */   public RequestBuilder setConfig(RequestConfig paramRequestConfig) {
/* 454 */     this.config = paramRequestConfig;
/* 455 */     return this;
/*     */   }
/*     */   public HttpUriRequest build() {
/*     */     InternalEntityEclosingRequest internalEntityEclosingRequest;
/*     */     UrlEncodedFormEntity urlEncodedFormEntity;
/* 460 */     URI uRI = (this.uri != null) ? this.uri : URI.create("/");
/* 461 */     HttpEntity httpEntity = this.entity;
/* 462 */     if (this.parameters != null && !this.parameters.isEmpty()) {
/* 463 */       if (httpEntity == null && ("POST".equalsIgnoreCase(this.method) || "PUT".equalsIgnoreCase(this.method))) {
/*     */         
/* 465 */         urlEncodedFormEntity = new UrlEncodedFormEntity(this.parameters, (this.charset != null) ? this.charset : HTTP.DEF_CONTENT_CHARSET);
/*     */       } else {
/*     */         try {
/* 468 */           uRI = (new URIBuilder(uRI)).setCharset(this.charset).addParameters(this.parameters).build();
/*     */ 
/*     */         
/*     */         }
/* 472 */         catch (URISyntaxException uRISyntaxException) {}
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 477 */     if (urlEncodedFormEntity == null) {
/* 478 */       InternalRequest internalRequest = new InternalRequest(this.method);
/*     */     } else {
/* 480 */       InternalEntityEclosingRequest internalEntityEclosingRequest1 = new InternalEntityEclosingRequest(this.method);
/* 481 */       internalEntityEclosingRequest1.setEntity((HttpEntity)urlEncodedFormEntity);
/* 482 */       internalEntityEclosingRequest = internalEntityEclosingRequest1;
/*     */     } 
/* 484 */     internalEntityEclosingRequest.setProtocolVersion(this.version);
/* 485 */     internalEntityEclosingRequest.setURI(uRI);
/* 486 */     if (this.headerGroup != null) {
/* 487 */       internalEntityEclosingRequest.setHeaders(this.headerGroup.getAllHeaders());
/*     */     }
/* 489 */     internalEntityEclosingRequest.setConfig(this.config);
/* 490 */     return internalEntityEclosingRequest;
/*     */   }
/*     */   
/*     */   static class InternalRequest
/*     */     extends HttpRequestBase
/*     */   {
/*     */     private final String method;
/*     */     
/*     */     InternalRequest(String param1String) {
/* 499 */       this.method = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getMethod() {
/* 504 */       return this.method;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class InternalEntityEclosingRequest
/*     */     extends HttpEntityEnclosingRequestBase
/*     */   {
/*     */     private final String method;
/*     */     
/*     */     InternalEntityEclosingRequest(String param1String) {
/* 515 */       this.method = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getMethod() {
/* 520 */       return this.method;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 527 */     StringBuilder stringBuilder = new StringBuilder();
/* 528 */     stringBuilder.append("RequestBuilder [method=");
/* 529 */     stringBuilder.append(this.method);
/* 530 */     stringBuilder.append(", charset=");
/* 531 */     stringBuilder.append(this.charset);
/* 532 */     stringBuilder.append(", version=");
/* 533 */     stringBuilder.append(this.version);
/* 534 */     stringBuilder.append(", uri=");
/* 535 */     stringBuilder.append(this.uri);
/* 536 */     stringBuilder.append(", headerGroup=");
/* 537 */     stringBuilder.append(this.headerGroup);
/* 538 */     stringBuilder.append(", entity=");
/* 539 */     stringBuilder.append(this.entity);
/* 540 */     stringBuilder.append(", parameters=");
/* 541 */     stringBuilder.append(this.parameters);
/* 542 */     stringBuilder.append(", config=");
/* 543 */     stringBuilder.append(this.config);
/* 544 */     stringBuilder.append("]");
/* 545 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\methods\RequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */