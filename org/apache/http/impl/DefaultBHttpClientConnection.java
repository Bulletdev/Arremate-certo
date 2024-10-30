/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
/*     */ import org.apache.http.impl.io.DefaultHttpResponseParserFactory;
/*     */ import org.apache.http.io.HttpMessageParser;
/*     */ import org.apache.http.io.HttpMessageParserFactory;
/*     */ import org.apache.http.io.HttpMessageWriter;
/*     */ import org.apache.http.io.HttpMessageWriterFactory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultBHttpClientConnection
/*     */   extends BHttpConnectionBase
/*     */   implements HttpClientConnection
/*     */ {
/*     */   private final HttpMessageParser<HttpResponse> responseParser;
/*     */   private final HttpMessageWriter<HttpRequest> requestWriter;
/*     */   
/*     */   public DefaultBHttpClientConnection(int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, MessageConstraints paramMessageConstraints, ContentLengthStrategy paramContentLengthStrategy1, ContentLengthStrategy paramContentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> paramHttpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> paramHttpMessageParserFactory) {
/*  95 */     super(paramInt1, paramInt2, paramCharsetDecoder, paramCharsetEncoder, paramMessageConstraints, paramContentLengthStrategy1, paramContentLengthStrategy2);
/*     */     
/*  97 */     this.requestWriter = ((paramHttpMessageWriterFactory != null) ? paramHttpMessageWriterFactory : DefaultHttpRequestWriterFactory.INSTANCE).create(getSessionOutputBuffer());
/*     */     
/*  99 */     this.responseParser = ((paramHttpMessageParserFactory != null) ? paramHttpMessageParserFactory : DefaultHttpResponseParserFactory.INSTANCE).create(getSessionInputBuffer(), paramMessageConstraints);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultBHttpClientConnection(int paramInt, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, MessageConstraints paramMessageConstraints) {
/* 108 */     this(paramInt, paramInt, paramCharsetDecoder, paramCharsetEncoder, paramMessageConstraints, (ContentLengthStrategy)null, (ContentLengthStrategy)null, (HttpMessageWriterFactory<HttpRequest>)null, (HttpMessageParserFactory<HttpResponse>)null);
/*     */   }
/*     */   
/*     */   public DefaultBHttpClientConnection(int paramInt) {
/* 112 */     this(paramInt, paramInt, (CharsetDecoder)null, (CharsetEncoder)null, (MessageConstraints)null, (ContentLengthStrategy)null, (ContentLengthStrategy)null, (HttpMessageWriterFactory<HttpRequest>)null, (HttpMessageParserFactory<HttpResponse>)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onResponseReceived(HttpResponse paramHttpResponse) {}
/*     */ 
/*     */   
/*     */   protected void onRequestSubmitted(HttpRequest paramHttpRequest) {}
/*     */ 
/*     */   
/*     */   public void bind(Socket paramSocket) throws IOException {
/* 123 */     super.bind(paramSocket);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isResponseAvailable(int paramInt) throws IOException {
/* 128 */     ensureOpen();
/*     */     try {
/* 130 */       return awaitInput(paramInt);
/* 131 */     } catch (SocketTimeoutException socketTimeoutException) {
/* 132 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendRequestHeader(HttpRequest paramHttpRequest) throws HttpException, IOException {
/* 139 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 140 */     ensureOpen();
/* 141 */     this.requestWriter.write((HttpMessage)paramHttpRequest);
/* 142 */     onRequestSubmitted(paramHttpRequest);
/* 143 */     incrementRequestCount();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws HttpException, IOException {
/* 149 */     Args.notNull(paramHttpEntityEnclosingRequest, "HTTP request");
/* 150 */     ensureOpen();
/* 151 */     HttpEntity httpEntity = paramHttpEntityEnclosingRequest.getEntity();
/* 152 */     if (httpEntity == null) {
/*     */       return;
/*     */     }
/* 155 */     OutputStream outputStream = prepareOutput((HttpMessage)paramHttpEntityEnclosingRequest);
/* 156 */     httpEntity.writeTo(outputStream);
/* 157 */     outputStream.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
/* 162 */     ensureOpen();
/* 163 */     HttpResponse httpResponse = (HttpResponse)this.responseParser.parse();
/* 164 */     onResponseReceived(httpResponse);
/* 165 */     if (httpResponse.getStatusLine().getStatusCode() >= 200) {
/* 166 */       incrementResponseCount();
/*     */     }
/* 168 */     return httpResponse;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveResponseEntity(HttpResponse paramHttpResponse) throws HttpException, IOException {
/* 174 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 175 */     ensureOpen();
/* 176 */     HttpEntity httpEntity = prepareInput((HttpMessage)paramHttpResponse);
/* 177 */     paramHttpResponse.setEntity(httpEntity);
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 182 */     ensureOpen();
/* 183 */     doFlush();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultBHttpClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */