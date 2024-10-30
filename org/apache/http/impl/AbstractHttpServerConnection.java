/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.HttpConnectionMetrics;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestFactory;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpServerConnection;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
/*     */ import org.apache.http.impl.entity.EntityDeserializer;
/*     */ import org.apache.http.impl.entity.EntitySerializer;
/*     */ import org.apache.http.impl.entity.LaxContentLengthStrategy;
/*     */ import org.apache.http.impl.entity.StrictContentLengthStrategy;
/*     */ import org.apache.http.impl.io.DefaultHttpRequestParser;
/*     */ import org.apache.http.impl.io.HttpResponseWriter;
/*     */ import org.apache.http.io.EofSensor;
/*     */ import org.apache.http.io.HttpMessageParser;
/*     */ import org.apache.http.io.HttpMessageWriter;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.io.SessionOutputBuffer;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ @Deprecated
/*     */ public abstract class AbstractHttpServerConnection
/*     */   implements HttpServerConnection
/*     */ {
/*     */   private final EntitySerializer entityserializer;
/*     */   private final EntityDeserializer entitydeserializer;
/*  79 */   private SessionInputBuffer inBuffer = null;
/*  80 */   private SessionOutputBuffer outbuffer = null;
/*  81 */   private EofSensor eofSensor = null;
/*  82 */   private HttpMessageParser<HttpRequest> requestParser = null;
/*  83 */   private HttpMessageWriter<HttpResponse> responseWriter = null;
/*  84 */   private HttpConnectionMetricsImpl metrics = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractHttpServerConnection() {
/*  96 */     this.entityserializer = createEntitySerializer();
/*  97 */     this.entitydeserializer = createEntityDeserializer();
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
/*     */   protected abstract void assertOpen() throws IllegalStateException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EntityDeserializer createEntityDeserializer() {
/* 119 */     return new EntityDeserializer((ContentLengthStrategy)new DisallowIdentityContentLengthStrategy((ContentLengthStrategy)new LaxContentLengthStrategy(0)));
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
/*     */   protected EntitySerializer createEntitySerializer() {
/* 135 */     return new EntitySerializer((ContentLengthStrategy)new StrictContentLengthStrategy());
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
/*     */   protected HttpRequestFactory createHttpRequestFactory() {
/* 149 */     return DefaultHttpRequestFactory.INSTANCE;
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
/*     */   protected HttpMessageParser<HttpRequest> createRequestParser(SessionInputBuffer paramSessionInputBuffer, HttpRequestFactory paramHttpRequestFactory, HttpParams paramHttpParams) {
/* 171 */     return (HttpMessageParser<HttpRequest>)new DefaultHttpRequestParser(paramSessionInputBuffer, null, paramHttpRequestFactory, paramHttpParams);
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
/*     */   protected HttpMessageWriter<HttpResponse> createResponseWriter(SessionOutputBuffer paramSessionOutputBuffer, HttpParams paramHttpParams) {
/* 191 */     return (HttpMessageWriter<HttpResponse>)new HttpResponseWriter(paramSessionOutputBuffer, null, paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics paramHttpTransportMetrics1, HttpTransportMetrics paramHttpTransportMetrics2) {
/* 200 */     return new HttpConnectionMetricsImpl(paramHttpTransportMetrics1, paramHttpTransportMetrics2);
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
/*     */   protected void init(SessionInputBuffer paramSessionInputBuffer, SessionOutputBuffer paramSessionOutputBuffer, HttpParams paramHttpParams) {
/* 223 */     this.inBuffer = (SessionInputBuffer)Args.notNull(paramSessionInputBuffer, "Input session buffer");
/* 224 */     this.outbuffer = (SessionOutputBuffer)Args.notNull(paramSessionOutputBuffer, "Output session buffer");
/* 225 */     if (paramSessionInputBuffer instanceof EofSensor) {
/* 226 */       this.eofSensor = (EofSensor)paramSessionInputBuffer;
/*     */     }
/* 228 */     this.requestParser = createRequestParser(paramSessionInputBuffer, createHttpRequestFactory(), paramHttpParams);
/*     */ 
/*     */ 
/*     */     
/* 232 */     this.responseWriter = createResponseWriter(paramSessionOutputBuffer, paramHttpParams);
/*     */     
/* 234 */     this.metrics = createConnectionMetrics(paramSessionInputBuffer.getMetrics(), paramSessionOutputBuffer.getMetrics());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRequest receiveRequestHeader() throws HttpException, IOException {
/* 242 */     assertOpen();
/* 243 */     HttpRequest httpRequest = (HttpRequest)this.requestParser.parse();
/* 244 */     this.metrics.incrementRequestCount();
/* 245 */     return httpRequest;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws HttpException, IOException {
/* 251 */     Args.notNull(paramHttpEntityEnclosingRequest, "HTTP request");
/* 252 */     assertOpen();
/* 253 */     HttpEntity httpEntity = this.entitydeserializer.deserialize(this.inBuffer, (HttpMessage)paramHttpEntityEnclosingRequest);
/* 254 */     paramHttpEntityEnclosingRequest.setEntity(httpEntity);
/*     */   }
/*     */   
/*     */   protected void doFlush() throws IOException {
/* 258 */     this.outbuffer.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 263 */     assertOpen();
/* 264 */     doFlush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendResponseHeader(HttpResponse paramHttpResponse) throws HttpException, IOException {
/* 270 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 271 */     assertOpen();
/* 272 */     this.responseWriter.write((HttpMessage)paramHttpResponse);
/* 273 */     if (paramHttpResponse.getStatusLine().getStatusCode() >= 200) {
/* 274 */       this.metrics.incrementResponseCount();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendResponseEntity(HttpResponse paramHttpResponse) throws HttpException, IOException {
/* 281 */     if (paramHttpResponse.getEntity() == null) {
/*     */       return;
/*     */     }
/* 284 */     this.entityserializer.serialize(this.outbuffer, (HttpMessage)paramHttpResponse, paramHttpResponse.getEntity());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isEof() {
/* 291 */     return (this.eofSensor != null && this.eofSensor.isEof());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStale() {
/* 296 */     if (!isOpen()) {
/* 297 */       return true;
/*     */     }
/* 299 */     if (isEof()) {
/* 300 */       return true;
/*     */     }
/*     */     try {
/* 303 */       this.inBuffer.isDataAvailable(1);
/* 304 */       return isEof();
/* 305 */     } catch (IOException iOException) {
/* 306 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpConnectionMetrics getMetrics() {
/* 312 */     return this.metrics;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\AbstractHttpServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */