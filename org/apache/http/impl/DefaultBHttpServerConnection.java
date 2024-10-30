/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.net.Socket;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpServerConnection;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
/*     */ import org.apache.http.impl.io.DefaultHttpRequestParserFactory;
/*     */ import org.apache.http.impl.io.DefaultHttpResponseWriterFactory;
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
/*     */ public class DefaultBHttpServerConnection
/*     */   extends BHttpConnectionBase
/*     */   implements HttpServerConnection
/*     */ {
/*     */   private final HttpMessageParser<HttpRequest> requestParser;
/*     */   private final HttpMessageWriter<HttpResponse> responseWriter;
/*     */   
/*     */   public DefaultBHttpServerConnection(int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, MessageConstraints paramMessageConstraints, ContentLengthStrategy paramContentLengthStrategy1, ContentLengthStrategy paramContentLengthStrategy2, HttpMessageParserFactory<HttpRequest> paramHttpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> paramHttpMessageWriterFactory) {
/*  93 */     super(paramInt1, paramInt2, paramCharsetDecoder, paramCharsetEncoder, paramMessageConstraints, (paramContentLengthStrategy1 != null) ? paramContentLengthStrategy1 : (ContentLengthStrategy)DisallowIdentityContentLengthStrategy.INSTANCE, paramContentLengthStrategy2);
/*     */ 
/*     */     
/*  96 */     this.requestParser = ((paramHttpMessageParserFactory != null) ? paramHttpMessageParserFactory : DefaultHttpRequestParserFactory.INSTANCE).create(getSessionInputBuffer(), paramMessageConstraints);
/*     */     
/*  98 */     this.responseWriter = ((paramHttpMessageWriterFactory != null) ? paramHttpMessageWriterFactory : DefaultHttpResponseWriterFactory.INSTANCE).create(getSessionOutputBuffer());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultBHttpServerConnection(int paramInt, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, MessageConstraints paramMessageConstraints) {
/* 107 */     this(paramInt, paramInt, paramCharsetDecoder, paramCharsetEncoder, paramMessageConstraints, (ContentLengthStrategy)null, (ContentLengthStrategy)null, (HttpMessageParserFactory<HttpRequest>)null, (HttpMessageWriterFactory<HttpResponse>)null);
/*     */   }
/*     */   
/*     */   public DefaultBHttpServerConnection(int paramInt) {
/* 111 */     this(paramInt, paramInt, (CharsetDecoder)null, (CharsetEncoder)null, (MessageConstraints)null, (ContentLengthStrategy)null, (ContentLengthStrategy)null, (HttpMessageParserFactory<HttpRequest>)null, (HttpMessageWriterFactory<HttpResponse>)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onRequestReceived(HttpRequest paramHttpRequest) {}
/*     */ 
/*     */   
/*     */   protected void onResponseSubmitted(HttpResponse paramHttpResponse) {}
/*     */ 
/*     */   
/*     */   public void bind(Socket paramSocket) throws IOException {
/* 122 */     super.bind(paramSocket);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRequest receiveRequestHeader() throws HttpException, IOException {
/* 128 */     ensureOpen();
/* 129 */     HttpRequest httpRequest = (HttpRequest)this.requestParser.parse();
/* 130 */     onRequestReceived(httpRequest);
/* 131 */     incrementRequestCount();
/* 132 */     return httpRequest;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws HttpException, IOException {
/* 138 */     Args.notNull(paramHttpEntityEnclosingRequest, "HTTP request");
/* 139 */     ensureOpen();
/* 140 */     HttpEntity httpEntity = prepareInput((HttpMessage)paramHttpEntityEnclosingRequest);
/* 141 */     paramHttpEntityEnclosingRequest.setEntity(httpEntity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendResponseHeader(HttpResponse paramHttpResponse) throws HttpException, IOException {
/* 147 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 148 */     ensureOpen();
/* 149 */     this.responseWriter.write((HttpMessage)paramHttpResponse);
/* 150 */     onResponseSubmitted(paramHttpResponse);
/* 151 */     if (paramHttpResponse.getStatusLine().getStatusCode() >= 200) {
/* 152 */       incrementResponseCount();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendResponseEntity(HttpResponse paramHttpResponse) throws HttpException, IOException {
/* 159 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 160 */     ensureOpen();
/* 161 */     HttpEntity httpEntity = paramHttpResponse.getEntity();
/* 162 */     if (httpEntity == null) {
/*     */       return;
/*     */     }
/* 165 */     OutputStream outputStream = prepareOutput((HttpMessage)paramHttpResponse);
/* 166 */     httpEntity.writeTo(outputStream);
/* 167 */     outputStream.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 172 */     ensureOpen();
/* 173 */     doFlush();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultBHttpServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */