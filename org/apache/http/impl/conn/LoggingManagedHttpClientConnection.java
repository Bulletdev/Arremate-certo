/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.Socket;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.config.MessageConstraints;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class LoggingManagedHttpClientConnection
/*     */   extends DefaultManagedHttpClientConnection
/*     */ {
/*     */   private final Log log;
/*     */   private final Log headerLog;
/*     */   private final Wire wire;
/*     */   
/*     */   public LoggingManagedHttpClientConnection(String paramString, Log paramLog1, Log paramLog2, Log paramLog3, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, MessageConstraints paramMessageConstraints, ContentLengthStrategy paramContentLengthStrategy1, ContentLengthStrategy paramContentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> paramHttpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> paramHttpMessageParserFactory) {
/*  66 */     super(paramString, paramInt1, paramInt2, paramCharsetDecoder, paramCharsetEncoder, paramMessageConstraints, paramContentLengthStrategy1, paramContentLengthStrategy2, paramHttpMessageWriterFactory, paramHttpMessageParserFactory);
/*     */ 
/*     */     
/*  69 */     this.log = paramLog1;
/*  70 */     this.headerLog = paramLog2;
/*  71 */     this.wire = new Wire(paramLog3, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  77 */     if (isOpen()) {
/*  78 */       if (this.log.isDebugEnabled()) {
/*  79 */         this.log.debug(getId() + ": Close connection");
/*     */       }
/*  81 */       super.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSocketTimeout(int paramInt) {
/*  87 */     if (this.log.isDebugEnabled()) {
/*  88 */       this.log.debug(getId() + ": set socket timeout to " + paramInt);
/*     */     }
/*  90 */     super.setSocketTimeout(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/*  95 */     if (this.log.isDebugEnabled()) {
/*  96 */       this.log.debug(getId() + ": Shutdown connection");
/*     */     }
/*  98 */     super.shutdown();
/*     */   }
/*     */ 
/*     */   
/*     */   protected InputStream getSocketInputStream(Socket paramSocket) throws IOException {
/* 103 */     InputStream inputStream = super.getSocketInputStream(paramSocket);
/* 104 */     if (this.wire.enabled()) {
/* 105 */       inputStream = new LoggingInputStream(inputStream, this.wire);
/*     */     }
/* 107 */     return inputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   protected OutputStream getSocketOutputStream(Socket paramSocket) throws IOException {
/* 112 */     OutputStream outputStream = super.getSocketOutputStream(paramSocket);
/* 113 */     if (this.wire.enabled()) {
/* 114 */       outputStream = new LoggingOutputStream(outputStream, this.wire);
/*     */     }
/* 116 */     return outputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onResponseReceived(HttpResponse paramHttpResponse) {
/* 121 */     if (paramHttpResponse != null && this.headerLog.isDebugEnabled()) {
/* 122 */       this.headerLog.debug(getId() + " << " + paramHttpResponse.getStatusLine().toString());
/* 123 */       Header[] arrayOfHeader = paramHttpResponse.getAllHeaders();
/* 124 */       for (Header header : arrayOfHeader) {
/* 125 */         this.headerLog.debug(getId() + " << " + header.toString());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onRequestSubmitted(HttpRequest paramHttpRequest) {
/* 132 */     if (paramHttpRequest != null && this.headerLog.isDebugEnabled()) {
/* 133 */       this.headerLog.debug(getId() + " >> " + paramHttpRequest.getRequestLine().toString());
/* 134 */       Header[] arrayOfHeader = paramHttpRequest.getAllHeaders();
/* 135 */       for (Header header : arrayOfHeader)
/* 136 */         this.headerLog.debug(getId() + " >> " + header.toString()); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\LoggingManagedHttpClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */