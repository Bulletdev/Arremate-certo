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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class DefaultBHttpClientConnectionFactory
/*     */   implements HttpConnectionFactory<DefaultBHttpClientConnection>
/*     */ {
/*  51 */   public static final DefaultBHttpClientConnectionFactory INSTANCE = new DefaultBHttpClientConnectionFactory();
/*     */ 
/*     */   
/*     */   private final ConnectionConfig cconfig;
/*     */   
/*     */   private final ContentLengthStrategy incomingContentStrategy;
/*     */   
/*     */   private final ContentLengthStrategy outgoingContentStrategy;
/*     */   
/*     */   private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
/*     */   
/*     */   private final HttpMessageParserFactory<HttpResponse> responseParserFactory;
/*     */ 
/*     */   
/*     */   public DefaultBHttpClientConnectionFactory(ConnectionConfig paramConnectionConfig, ContentLengthStrategy paramContentLengthStrategy1, ContentLengthStrategy paramContentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> paramHttpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> paramHttpMessageParserFactory) {
/*  66 */     this.cconfig = (paramConnectionConfig != null) ? paramConnectionConfig : ConnectionConfig.DEFAULT;
/*  67 */     this.incomingContentStrategy = paramContentLengthStrategy1;
/*  68 */     this.outgoingContentStrategy = paramContentLengthStrategy2;
/*  69 */     this.requestWriterFactory = paramHttpMessageWriterFactory;
/*  70 */     this.responseParserFactory = paramHttpMessageParserFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultBHttpClientConnectionFactory(ConnectionConfig paramConnectionConfig, HttpMessageWriterFactory<HttpRequest> paramHttpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> paramHttpMessageParserFactory) {
/*  77 */     this(paramConnectionConfig, null, null, paramHttpMessageWriterFactory, paramHttpMessageParserFactory);
/*     */   }
/*     */   
/*     */   public DefaultBHttpClientConnectionFactory(ConnectionConfig paramConnectionConfig) {
/*  81 */     this(paramConnectionConfig, null, null, null, null);
/*     */   }
/*     */   
/*     */   public DefaultBHttpClientConnectionFactory() {
/*  85 */     this(null, null, null, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultBHttpClientConnection createConnection(Socket paramSocket) throws IOException {
/*  90 */     DefaultBHttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestWriterFactory, this.responseParserFactory);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     defaultBHttpClientConnection.bind(paramSocket);
/* 101 */     return defaultBHttpClientConnection;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultBHttpClientConnectionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */