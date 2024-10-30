/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseFactory;
/*     */ import org.apache.http.HttpServerConnection;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.entity.ByteArrayEntity;
/*     */ import org.apache.http.impl.DefaultConnectionReuseStrategy;
/*     */ import org.apache.http.impl.DefaultHttpResponseFactory;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.EncodingUtils;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class HttpService
/*     */ {
/*  81 */   private volatile HttpParams params = null;
/*  82 */   private volatile HttpProcessor processor = null;
/*  83 */   private volatile HttpRequestHandlerMapper handlerMapper = null;
/*  84 */   private volatile ConnectionReuseStrategy connStrategy = null;
/*  85 */   private volatile HttpResponseFactory responseFactory = null;
/*  86 */   private volatile HttpExpectationVerifier expectationVerifier = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public HttpService(HttpProcessor paramHttpProcessor, ConnectionReuseStrategy paramConnectionReuseStrategy, HttpResponseFactory paramHttpResponseFactory, HttpRequestHandlerResolver paramHttpRequestHandlerResolver, HttpExpectationVerifier paramHttpExpectationVerifier, HttpParams paramHttpParams) {
/* 110 */     this(paramHttpProcessor, paramConnectionReuseStrategy, paramHttpResponseFactory, new HttpRequestHandlerResolverAdapter(paramHttpRequestHandlerResolver), paramHttpExpectationVerifier);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.params = paramHttpParams;
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
/*     */   
/*     */   @Deprecated
/*     */   public HttpService(HttpProcessor paramHttpProcessor, ConnectionReuseStrategy paramConnectionReuseStrategy, HttpResponseFactory paramHttpResponseFactory, HttpRequestHandlerResolver paramHttpRequestHandlerResolver, HttpParams paramHttpParams) {
/* 138 */     this(paramHttpProcessor, paramConnectionReuseStrategy, paramHttpResponseFactory, new HttpRequestHandlerResolverAdapter(paramHttpRequestHandlerResolver), (HttpExpectationVerifier)null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     this.params = paramHttpParams;
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
/*     */   @Deprecated
/*     */   public HttpService(HttpProcessor paramHttpProcessor, ConnectionReuseStrategy paramConnectionReuseStrategy, HttpResponseFactory paramHttpResponseFactory) {
/* 162 */     setHttpProcessor(paramHttpProcessor);
/* 163 */     setConnReuseStrategy(paramConnectionReuseStrategy);
/* 164 */     setResponseFactory(paramHttpResponseFactory);
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
/*     */ 
/*     */   
/*     */   public HttpService(HttpProcessor paramHttpProcessor, ConnectionReuseStrategy paramConnectionReuseStrategy, HttpResponseFactory paramHttpResponseFactory, HttpRequestHandlerMapper paramHttpRequestHandlerMapper, HttpExpectationVerifier paramHttpExpectationVerifier) {
/* 187 */     this.processor = (HttpProcessor)Args.notNull(paramHttpProcessor, "HTTP processor");
/* 188 */     this.connStrategy = (paramConnectionReuseStrategy != null) ? paramConnectionReuseStrategy : (ConnectionReuseStrategy)DefaultConnectionReuseStrategy.INSTANCE;
/*     */     
/* 190 */     this.responseFactory = (paramHttpResponseFactory != null) ? paramHttpResponseFactory : (HttpResponseFactory)DefaultHttpResponseFactory.INSTANCE;
/*     */     
/* 192 */     this.handlerMapper = paramHttpRequestHandlerMapper;
/* 193 */     this.expectationVerifier = paramHttpExpectationVerifier;
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
/*     */   public HttpService(HttpProcessor paramHttpProcessor, ConnectionReuseStrategy paramConnectionReuseStrategy, HttpResponseFactory paramHttpResponseFactory, HttpRequestHandlerMapper paramHttpRequestHandlerMapper) {
/* 213 */     this(paramHttpProcessor, paramConnectionReuseStrategy, paramHttpResponseFactory, paramHttpRequestHandlerMapper, (HttpExpectationVerifier)null);
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
/*     */   public HttpService(HttpProcessor paramHttpProcessor, HttpRequestHandlerMapper paramHttpRequestHandlerMapper) {
/* 226 */     this(paramHttpProcessor, (ConnectionReuseStrategy)null, (HttpResponseFactory)null, paramHttpRequestHandlerMapper, (HttpExpectationVerifier)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setHttpProcessor(HttpProcessor paramHttpProcessor) {
/* 234 */     Args.notNull(paramHttpProcessor, "HTTP processor");
/* 235 */     this.processor = paramHttpProcessor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setConnReuseStrategy(ConnectionReuseStrategy paramConnectionReuseStrategy) {
/* 243 */     Args.notNull(paramConnectionReuseStrategy, "Connection reuse strategy");
/* 244 */     this.connStrategy = paramConnectionReuseStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setResponseFactory(HttpResponseFactory paramHttpResponseFactory) {
/* 252 */     Args.notNull(paramHttpResponseFactory, "Response factory");
/* 253 */     this.responseFactory = paramHttpResponseFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setParams(HttpParams paramHttpParams) {
/* 261 */     this.params = paramHttpParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setHandlerResolver(HttpRequestHandlerResolver paramHttpRequestHandlerResolver) {
/* 269 */     this.handlerMapper = new HttpRequestHandlerResolverAdapter(paramHttpRequestHandlerResolver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setExpectationVerifier(HttpExpectationVerifier paramHttpExpectationVerifier) {
/* 277 */     this.expectationVerifier = paramHttpExpectationVerifier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public HttpParams getParams() {
/* 285 */     return this.params;
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
/*     */   public void handleRequest(HttpServerConnection paramHttpServerConnection, HttpContext paramHttpContext) throws IOException, HttpException {
/* 302 */     paramHttpContext.setAttribute("http.connection", paramHttpServerConnection);
/*     */     
/* 304 */     HttpRequest httpRequest = null;
/* 305 */     HttpResponse httpResponse = null;
/*     */     
/*     */     try {
/* 308 */       httpRequest = paramHttpServerConnection.receiveRequestHeader();
/* 309 */       if (httpRequest instanceof HttpEntityEnclosingRequest)
/*     */       {
/* 311 */         if (((HttpEntityEnclosingRequest)httpRequest).expectContinue()) {
/* 312 */           httpResponse = this.responseFactory.newHttpResponse((ProtocolVersion)HttpVersion.HTTP_1_1, 100, paramHttpContext);
/*     */           
/* 314 */           if (this.expectationVerifier != null) {
/*     */             try {
/* 316 */               this.expectationVerifier.verify(httpRequest, httpResponse, paramHttpContext);
/* 317 */             } catch (HttpException httpException) {
/* 318 */               httpResponse = this.responseFactory.newHttpResponse((ProtocolVersion)HttpVersion.HTTP_1_0, 500, paramHttpContext);
/*     */               
/* 320 */               handleException(httpException, httpResponse);
/*     */             } 
/*     */           }
/* 323 */           if (httpResponse.getStatusLine().getStatusCode() < 200) {
/*     */ 
/*     */             
/* 326 */             paramHttpServerConnection.sendResponseHeader(httpResponse);
/* 327 */             paramHttpServerConnection.flush();
/* 328 */             httpResponse = null;
/* 329 */             paramHttpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest)httpRequest);
/*     */           } 
/*     */         } else {
/* 332 */           paramHttpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest)httpRequest);
/*     */         } 
/*     */       }
/*     */       
/* 336 */       paramHttpContext.setAttribute("http.request", httpRequest);
/*     */       
/* 338 */       if (httpResponse == null) {
/* 339 */         httpResponse = this.responseFactory.newHttpResponse((ProtocolVersion)HttpVersion.HTTP_1_1, 200, paramHttpContext);
/*     */         
/* 341 */         this.processor.process(httpRequest, paramHttpContext);
/* 342 */         doService(httpRequest, httpResponse, paramHttpContext);
/*     */       } 
/*     */ 
/*     */       
/* 346 */       if (httpRequest instanceof HttpEntityEnclosingRequest) {
/* 347 */         HttpEntity httpEntity = ((HttpEntityEnclosingRequest)httpRequest).getEntity();
/* 348 */         EntityUtils.consume(httpEntity);
/*     */       }
/*     */     
/* 351 */     } catch (HttpException httpException) {
/* 352 */       httpResponse = this.responseFactory.newHttpResponse((ProtocolVersion)HttpVersion.HTTP_1_0, 500, paramHttpContext);
/*     */ 
/*     */       
/* 355 */       handleException(httpException, httpResponse);
/*     */     } 
/*     */     
/* 358 */     paramHttpContext.setAttribute("http.response", httpResponse);
/*     */     
/* 360 */     this.processor.process(httpResponse, paramHttpContext);
/* 361 */     paramHttpServerConnection.sendResponseHeader(httpResponse);
/* 362 */     if (canResponseHaveBody(httpRequest, httpResponse)) {
/* 363 */       paramHttpServerConnection.sendResponseEntity(httpResponse);
/*     */     }
/* 365 */     paramHttpServerConnection.flush();
/*     */     
/* 367 */     if (!this.connStrategy.keepAlive(httpResponse, paramHttpContext)) {
/* 368 */       paramHttpServerConnection.close();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canResponseHaveBody(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse) {
/* 373 */     if (paramHttpRequest != null && "HEAD".equalsIgnoreCase(paramHttpRequest.getRequestLine().getMethod())) {
/* 374 */       return false;
/*     */     }
/* 376 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/* 377 */     return (i >= 200 && i != 204 && i != 304 && i != 205);
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
/*     */   protected void handleException(HttpException paramHttpException, HttpResponse paramHttpResponse) {
/* 392 */     if (paramHttpException instanceof org.apache.http.MethodNotSupportedException) {
/* 393 */       paramHttpResponse.setStatusCode(501);
/* 394 */     } else if (paramHttpException instanceof org.apache.http.UnsupportedHttpVersionException) {
/* 395 */       paramHttpResponse.setStatusCode(505);
/* 396 */     } else if (paramHttpException instanceof org.apache.http.ProtocolException) {
/* 397 */       paramHttpResponse.setStatusCode(400);
/*     */     } else {
/* 399 */       paramHttpResponse.setStatusCode(500);
/*     */     } 
/* 401 */     String str = paramHttpException.getMessage();
/* 402 */     if (str == null) {
/* 403 */       str = paramHttpException.toString();
/*     */     }
/* 405 */     byte[] arrayOfByte = EncodingUtils.getAsciiBytes(str);
/* 406 */     ByteArrayEntity byteArrayEntity = new ByteArrayEntity(arrayOfByte);
/* 407 */     byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
/* 408 */     paramHttpResponse.setEntity((HttpEntity)byteArrayEntity);
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doService(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/* 432 */     HttpRequestHandler httpRequestHandler = null;
/* 433 */     if (this.handlerMapper != null) {
/* 434 */       httpRequestHandler = this.handlerMapper.lookup(paramHttpRequest);
/*     */     }
/* 436 */     if (httpRequestHandler != null) {
/* 437 */       httpRequestHandler.handle(paramHttpRequest, paramHttpResponse, paramHttpContext);
/*     */     } else {
/* 439 */       paramHttpResponse.setStatusCode(501);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   private static class HttpRequestHandlerResolverAdapter
/*     */     implements HttpRequestHandlerMapper
/*     */   {
/*     */     private final HttpRequestHandlerResolver resolver;
/*     */ 
/*     */ 
/*     */     
/*     */     public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver param1HttpRequestHandlerResolver) {
/* 454 */       this.resolver = param1HttpRequestHandlerResolver;
/*     */     }
/*     */ 
/*     */     
/*     */     public HttpRequestHandler lookup(HttpRequest param1HttpRequest) {
/* 459 */       return this.resolver.lookup(param1HttpRequest.getRequestLine().getUri());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\HttpService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */