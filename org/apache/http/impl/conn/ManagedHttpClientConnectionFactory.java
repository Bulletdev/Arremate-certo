/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpConnection;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.config.ConnectionConfig;
/*     */ import org.apache.http.conn.HttpConnectionFactory;
/*     */ import org.apache.http.conn.ManagedHttpClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.impl.entity.LaxContentLengthStrategy;
/*     */ import org.apache.http.impl.entity.StrictContentLengthStrategy;
/*     */ import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
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
/*     */ public class ManagedHttpClientConnectionFactory
/*     */   implements HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection>
/*     */ {
/*  61 */   private static final AtomicLong COUNTER = new AtomicLong();
/*     */   
/*  63 */   public static final ManagedHttpClientConnectionFactory INSTANCE = new ManagedHttpClientConnectionFactory();
/*     */   
/*  65 */   private final Log log = LogFactory.getLog(DefaultManagedHttpClientConnection.class);
/*  66 */   private final Log headerLog = LogFactory.getLog("org.apache.http.headers");
/*  67 */   private final Log wireLog = LogFactory.getLog("org.apache.http.wire");
/*     */ 
/*     */   
/*     */   private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
/*     */ 
/*     */   
/*     */   private final HttpMessageParserFactory<HttpResponse> responseParserFactory;
/*     */ 
/*     */   
/*     */   private final ContentLengthStrategy incomingContentStrategy;
/*     */ 
/*     */   
/*     */   private final ContentLengthStrategy outgoingContentStrategy;
/*     */ 
/*     */   
/*     */   public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory<HttpRequest> paramHttpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> paramHttpMessageParserFactory, ContentLengthStrategy paramContentLengthStrategy1, ContentLengthStrategy paramContentLengthStrategy2) {
/*  83 */     this.requestWriterFactory = (paramHttpMessageWriterFactory != null) ? paramHttpMessageWriterFactory : (HttpMessageWriterFactory<HttpRequest>)DefaultHttpRequestWriterFactory.INSTANCE;
/*     */     
/*  85 */     this.responseParserFactory = (paramHttpMessageParserFactory != null) ? paramHttpMessageParserFactory : DefaultHttpResponseParserFactory.INSTANCE;
/*     */     
/*  87 */     this.incomingContentStrategy = (paramContentLengthStrategy1 != null) ? paramContentLengthStrategy1 : (ContentLengthStrategy)LaxContentLengthStrategy.INSTANCE;
/*     */     
/*  89 */     this.outgoingContentStrategy = (paramContentLengthStrategy2 != null) ? paramContentLengthStrategy2 : (ContentLengthStrategy)StrictContentLengthStrategy.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory<HttpRequest> paramHttpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> paramHttpMessageParserFactory) {
/*  96 */     this(paramHttpMessageWriterFactory, paramHttpMessageParserFactory, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public ManagedHttpClientConnectionFactory(HttpMessageParserFactory<HttpResponse> paramHttpMessageParserFactory) {
/* 101 */     this(null, paramHttpMessageParserFactory);
/*     */   }
/*     */   
/*     */   public ManagedHttpClientConnectionFactory() {
/* 105 */     this(null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public ManagedHttpClientConnection create(HttpRoute paramHttpRoute, ConnectionConfig paramConnectionConfig) {
/* 110 */     ConnectionConfig connectionConfig = (paramConnectionConfig != null) ? paramConnectionConfig : ConnectionConfig.DEFAULT;
/* 111 */     CharsetDecoder charsetDecoder = null;
/* 112 */     CharsetEncoder charsetEncoder = null;
/* 113 */     Charset charset = connectionConfig.getCharset();
/* 114 */     CodingErrorAction codingErrorAction1 = (connectionConfig.getMalformedInputAction() != null) ? connectionConfig.getMalformedInputAction() : CodingErrorAction.REPORT;
/*     */     
/* 116 */     CodingErrorAction codingErrorAction2 = (connectionConfig.getUnmappableInputAction() != null) ? connectionConfig.getUnmappableInputAction() : CodingErrorAction.REPORT;
/*     */     
/* 118 */     if (charset != null) {
/* 119 */       charsetDecoder = charset.newDecoder();
/* 120 */       charsetDecoder.onMalformedInput(codingErrorAction1);
/* 121 */       charsetDecoder.onUnmappableCharacter(codingErrorAction2);
/* 122 */       charsetEncoder = charset.newEncoder();
/* 123 */       charsetEncoder.onMalformedInput(codingErrorAction1);
/* 124 */       charsetEncoder.onUnmappableCharacter(codingErrorAction2);
/*     */     } 
/* 126 */     String str = "http-outgoing-" + Long.toString(COUNTER.getAndIncrement());
/* 127 */     return new LoggingManagedHttpClientConnection(str, this.log, this.headerLog, this.wireLog, connectionConfig.getBufferSize(), connectionConfig.getFragmentSizeHint(), charsetDecoder, charsetEncoder, connectionConfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestWriterFactory, this.responseParserFactory);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\ManagedHttpClientConnectionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */