/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import org.apache.http.HttpConnection;
/*     */ import org.apache.http.HttpConnectionFactory;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.config.ConnectionConfig;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.io.HttpMessageParserFactory;
/*     */ import org.apache.http.io.HttpMessageWriterFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class DefaultBHttpServerConnectionFactory
/*     */   implements HttpConnectionFactory<DefaultBHttpServerConnection>
/*     */ {
/*  52 */   public static final DefaultBHttpServerConnectionFactory INSTANCE = new DefaultBHttpServerConnectionFactory();
/*     */ 
/*     */   
/*     */   private final ConnectionConfig cconfig;
/*     */   
/*     */   private final ContentLengthStrategy incomingContentStrategy;
/*     */   
/*     */   private final ContentLengthStrategy outgoingContentStrategy;
/*     */   
/*     */   private final HttpMessageParserFactory<HttpRequest> requestParserFactory;
/*     */   
/*     */   private final HttpMessageWriterFactory<HttpResponse> responseWriterFactory;
/*     */ 
/*     */   
/*     */   public DefaultBHttpServerConnectionFactory(ConnectionConfig paramConnectionConfig, ContentLengthStrategy paramContentLengthStrategy1, ContentLengthStrategy paramContentLengthStrategy2, HttpMessageParserFactory<HttpRequest> paramHttpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> paramHttpMessageWriterFactory) {
/*  67 */     this.cconfig = (paramConnectionConfig != null) ? paramConnectionConfig : ConnectionConfig.DEFAULT;
/*  68 */     this.incomingContentStrategy = paramContentLengthStrategy1;
/*  69 */     this.outgoingContentStrategy = paramContentLengthStrategy2;
/*  70 */     this.requestParserFactory = paramHttpMessageParserFactory;
/*  71 */     this.responseWriterFactory = paramHttpMessageWriterFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultBHttpServerConnectionFactory(ConnectionConfig paramConnectionConfig, HttpMessageParserFactory<HttpRequest> paramHttpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> paramHttpMessageWriterFactory) {
/*  78 */     this(paramConnectionConfig, null, null, paramHttpMessageParserFactory, paramHttpMessageWriterFactory);
/*     */   }
/*     */   
/*     */   public DefaultBHttpServerConnectionFactory(ConnectionConfig paramConnectionConfig) {
/*  82 */     this(paramConnectionConfig, null, null, null, null);
/*     */   }
/*     */   
/*     */   public DefaultBHttpServerConnectionFactory() {
/*  86 */     this(null, null, null, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultBHttpServerConnection createConnection(Socket paramSocket) throws IOException {
/*  91 */     DefaultBHttpServerConnection defaultBHttpServerConnection = new DefaultBHttpServerConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestParserFactory, this.responseWriterFactory);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     defaultBHttpServerConnection.bind(paramSocket);
/* 102 */     return defaultBHttpServerConnection;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultBHttpServerConnectionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */