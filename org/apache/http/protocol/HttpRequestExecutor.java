/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class HttpRequestExecutor
/*     */ {
/*     */   public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
/*     */   private final int waitForContinue;
/*     */   
/*     */   public HttpRequestExecutor(int paramInt) {
/*  72 */     this.waitForContinue = Args.positive(paramInt, "Wait for continue time");
/*     */   }
/*     */   
/*     */   public HttpRequestExecutor() {
/*  76 */     this(3000);
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
/*     */   protected boolean canResponseHaveBody(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse) {
/*  93 */     if ("HEAD".equalsIgnoreCase(paramHttpRequest.getRequestLine().getMethod())) {
/*  94 */       return false;
/*     */     }
/*  96 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/*  97 */     return (i >= 200 && i != 204 && i != 304 && i != 205);
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
/*     */   public HttpResponse execute(HttpRequest paramHttpRequest, HttpClientConnection paramHttpClientConnection, HttpContext paramHttpContext) throws IOException, HttpException {
/* 119 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 120 */     Args.notNull(paramHttpClientConnection, "Client connection");
/* 121 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     try {
/* 123 */       HttpResponse httpResponse = doSendRequest(paramHttpRequest, paramHttpClientConnection, paramHttpContext);
/* 124 */       if (httpResponse == null) {
/* 125 */         httpResponse = doReceiveResponse(paramHttpRequest, paramHttpClientConnection, paramHttpContext);
/*     */       }
/* 127 */       return httpResponse;
/* 128 */     } catch (IOException iOException) {
/* 129 */       closeConnection(paramHttpClientConnection);
/* 130 */       throw iOException;
/* 131 */     } catch (HttpException httpException) {
/* 132 */       closeConnection(paramHttpClientConnection);
/* 133 */       throw httpException;
/* 134 */     } catch (RuntimeException runtimeException) {
/* 135 */       closeConnection(paramHttpClientConnection);
/* 136 */       throw runtimeException;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void closeConnection(HttpClientConnection paramHttpClientConnection) {
/*     */     try {
/* 142 */       paramHttpClientConnection.close();
/* 143 */     } catch (IOException iOException) {}
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
/*     */   public void preProcess(HttpRequest paramHttpRequest, HttpProcessor paramHttpProcessor, HttpContext paramHttpContext) throws HttpException, IOException {
/* 163 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 164 */     Args.notNull(paramHttpProcessor, "HTTP processor");
/* 165 */     Args.notNull(paramHttpContext, "HTTP context");
/* 166 */     paramHttpContext.setAttribute("http.request", paramHttpRequest);
/* 167 */     paramHttpProcessor.process(paramHttpRequest, paramHttpContext);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpResponse doSendRequest(HttpRequest paramHttpRequest, HttpClientConnection paramHttpClientConnection, HttpContext paramHttpContext) throws IOException, HttpException {
/* 196 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 197 */     Args.notNull(paramHttpClientConnection, "Client connection");
/* 198 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     
/* 200 */     HttpResponse httpResponse = null;
/*     */     
/* 202 */     paramHttpContext.setAttribute("http.connection", paramHttpClientConnection);
/* 203 */     paramHttpContext.setAttribute("http.request_sent", Boolean.FALSE);
/*     */     
/* 205 */     paramHttpClientConnection.sendRequestHeader(paramHttpRequest);
/* 206 */     if (paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/*     */ 
/*     */ 
/*     */       
/* 210 */       boolean bool = true;
/* 211 */       ProtocolVersion protocolVersion = paramHttpRequest.getRequestLine().getProtocolVersion();
/*     */       
/* 213 */       if (((HttpEntityEnclosingRequest)paramHttpRequest).expectContinue() && !protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/*     */ 
/*     */         
/* 216 */         paramHttpClientConnection.flush();
/*     */ 
/*     */         
/* 219 */         if (paramHttpClientConnection.isResponseAvailable(this.waitForContinue)) {
/* 220 */           httpResponse = paramHttpClientConnection.receiveResponseHeader();
/* 221 */           if (canResponseHaveBody(paramHttpRequest, httpResponse)) {
/* 222 */             paramHttpClientConnection.receiveResponseEntity(httpResponse);
/*     */           }
/* 224 */           int i = httpResponse.getStatusLine().getStatusCode();
/* 225 */           if (i < 200) {
/* 226 */             if (i != 100) {
/* 227 */               throw new ProtocolException("Unexpected response: " + httpResponse.getStatusLine());
/*     */             }
/*     */ 
/*     */             
/* 231 */             httpResponse = null;
/*     */           } else {
/* 233 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       } 
/* 237 */       if (bool) {
/* 238 */         paramHttpClientConnection.sendRequestEntity((HttpEntityEnclosingRequest)paramHttpRequest);
/*     */       }
/*     */     } 
/* 241 */     paramHttpClientConnection.flush();
/* 242 */     paramHttpContext.setAttribute("http.request_sent", Boolean.TRUE);
/* 243 */     return httpResponse;
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
/*     */   protected HttpResponse doReceiveResponse(HttpRequest paramHttpRequest, HttpClientConnection paramHttpClientConnection, HttpContext paramHttpContext) throws HttpException, IOException {
/* 265 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 266 */     Args.notNull(paramHttpClientConnection, "Client connection");
/* 267 */     Args.notNull(paramHttpContext, "HTTP context");
/* 268 */     HttpResponse httpResponse = null;
/* 269 */     int i = 0;
/*     */     
/* 271 */     while (httpResponse == null || i < 200) {
/*     */       
/* 273 */       httpResponse = paramHttpClientConnection.receiveResponseHeader();
/* 274 */       i = httpResponse.getStatusLine().getStatusCode();
/* 275 */       if (i < 100) {
/* 276 */         throw new ProtocolException("Invalid response: " + httpResponse.getStatusLine());
/*     */       }
/* 278 */       if (canResponseHaveBody(paramHttpRequest, httpResponse)) {
/* 279 */         paramHttpClientConnection.receiveResponseEntity(httpResponse);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 284 */     return httpResponse;
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
/*     */   
/*     */   public void postProcess(HttpResponse paramHttpResponse, HttpProcessor paramHttpProcessor, HttpContext paramHttpContext) throws HttpException, IOException {
/* 309 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 310 */     Args.notNull(paramHttpProcessor, "HTTP processor");
/* 311 */     Args.notNull(paramHttpContext, "HTTP context");
/* 312 */     paramHttpContext.setAttribute("http.response", paramHttpResponse);
/* 313 */     paramHttpProcessor.process(paramHttpResponse, paramHttpContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\HttpRequestExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */