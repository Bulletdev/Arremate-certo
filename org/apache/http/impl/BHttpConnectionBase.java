/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketAddress;
/*     */ import java.net.SocketException;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ import org.apache.http.ConnectionClosedException;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpConnectionMetrics;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpInetConnection;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.entity.BasicHttpEntity;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.impl.entity.LaxContentLengthStrategy;
/*     */ import org.apache.http.impl.entity.StrictContentLengthStrategy;
/*     */ import org.apache.http.impl.io.ChunkedInputStream;
/*     */ import org.apache.http.impl.io.ChunkedOutputStream;
/*     */ import org.apache.http.impl.io.ContentLengthInputStream;
/*     */ import org.apache.http.impl.io.ContentLengthOutputStream;
/*     */ import org.apache.http.impl.io.EmptyInputStream;
/*     */ import org.apache.http.impl.io.HttpTransportMetricsImpl;
/*     */ import org.apache.http.impl.io.IdentityInputStream;
/*     */ import org.apache.http.impl.io.IdentityOutputStream;
/*     */ import org.apache.http.impl.io.SessionInputBufferImpl;
/*     */ import org.apache.http.impl.io.SessionOutputBufferImpl;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.io.SessionOutputBuffer;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.NetUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BHttpConnectionBase
/*     */   implements HttpInetConnection
/*     */ {
/*     */   private final SessionInputBufferImpl inBuffer;
/*     */   private final SessionOutputBufferImpl outbuffer;
/*     */   private final MessageConstraints messageConstraints;
/*     */   private final HttpConnectionMetricsImpl connMetrics;
/*     */   private final ContentLengthStrategy incomingContentStrategy;
/*     */   private final ContentLengthStrategy outgoingContentStrategy;
/*     */   private final AtomicReference<Socket> socketHolder;
/*     */   
/*     */   protected BHttpConnectionBase(int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, MessageConstraints paramMessageConstraints, ContentLengthStrategy paramContentLengthStrategy1, ContentLengthStrategy paramContentLengthStrategy2) {
/* 111 */     Args.positive(paramInt1, "Buffer size");
/* 112 */     HttpTransportMetricsImpl httpTransportMetricsImpl1 = new HttpTransportMetricsImpl();
/* 113 */     HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
/* 114 */     this.inBuffer = new SessionInputBufferImpl(httpTransportMetricsImpl1, paramInt1, -1, (paramMessageConstraints != null) ? paramMessageConstraints : MessageConstraints.DEFAULT, paramCharsetDecoder);
/*     */     
/* 116 */     this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, paramInt1, paramInt2, paramCharsetEncoder);
/*     */     
/* 118 */     this.messageConstraints = paramMessageConstraints;
/* 119 */     this.connMetrics = new HttpConnectionMetricsImpl((HttpTransportMetrics)httpTransportMetricsImpl1, (HttpTransportMetrics)httpTransportMetricsImpl2);
/* 120 */     this.incomingContentStrategy = (paramContentLengthStrategy1 != null) ? paramContentLengthStrategy1 : (ContentLengthStrategy)LaxContentLengthStrategy.INSTANCE;
/*     */     
/* 122 */     this.outgoingContentStrategy = (paramContentLengthStrategy2 != null) ? paramContentLengthStrategy2 : (ContentLengthStrategy)StrictContentLengthStrategy.INSTANCE;
/*     */     
/* 124 */     this.socketHolder = new AtomicReference<Socket>();
/*     */   }
/*     */   
/*     */   protected void ensureOpen() throws IOException {
/* 128 */     Socket socket = this.socketHolder.get();
/* 129 */     if (socket == null) {
/* 130 */       throw new ConnectionClosedException();
/*     */     }
/* 132 */     if (!this.inBuffer.isBound()) {
/* 133 */       this.inBuffer.bind(getSocketInputStream(socket));
/*     */     }
/* 135 */     if (!this.outbuffer.isBound()) {
/* 136 */       this.outbuffer.bind(getSocketOutputStream(socket));
/*     */     }
/*     */   }
/*     */   
/*     */   protected InputStream getSocketInputStream(Socket paramSocket) throws IOException {
/* 141 */     return paramSocket.getInputStream();
/*     */   }
/*     */   
/*     */   protected OutputStream getSocketOutputStream(Socket paramSocket) throws IOException {
/* 145 */     return paramSocket.getOutputStream();
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
/*     */   protected void bind(Socket paramSocket) throws IOException {
/* 159 */     Args.notNull(paramSocket, "Socket");
/* 160 */     this.socketHolder.set(paramSocket);
/* 161 */     this.inBuffer.bind(null);
/* 162 */     this.outbuffer.bind(null);
/*     */   }
/*     */   
/*     */   protected SessionInputBuffer getSessionInputBuffer() {
/* 166 */     return (SessionInputBuffer)this.inBuffer;
/*     */   }
/*     */   
/*     */   protected SessionOutputBuffer getSessionOutputBuffer() {
/* 170 */     return (SessionOutputBuffer)this.outbuffer;
/*     */   }
/*     */   
/*     */   protected void doFlush() throws IOException {
/* 174 */     this.outbuffer.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/* 179 */     return (this.socketHolder.get() != null);
/*     */   }
/*     */   
/*     */   protected Socket getSocket() {
/* 183 */     return this.socketHolder.get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected OutputStream createOutputStream(long paramLong, SessionOutputBuffer paramSessionOutputBuffer) {
/* 189 */     if (paramLong == -2L)
/* 190 */       return (OutputStream)new ChunkedOutputStream(2048, paramSessionOutputBuffer); 
/* 191 */     if (paramLong == -1L) {
/* 192 */       return (OutputStream)new IdentityOutputStream(paramSessionOutputBuffer);
/*     */     }
/* 194 */     return (OutputStream)new ContentLengthOutputStream(paramSessionOutputBuffer, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   protected OutputStream prepareOutput(HttpMessage paramHttpMessage) throws HttpException {
/* 199 */     long l = this.outgoingContentStrategy.determineLength(paramHttpMessage);
/* 200 */     return createOutputStream(l, (SessionOutputBuffer)this.outbuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected InputStream createInputStream(long paramLong, SessionInputBuffer paramSessionInputBuffer) {
/* 206 */     if (paramLong == -2L)
/* 207 */       return (InputStream)new ChunkedInputStream(paramSessionInputBuffer, this.messageConstraints); 
/* 208 */     if (paramLong == -1L)
/* 209 */       return (InputStream)new IdentityInputStream(paramSessionInputBuffer); 
/* 210 */     if (paramLong == 0L) {
/* 211 */       return (InputStream)EmptyInputStream.INSTANCE;
/*     */     }
/* 213 */     return (InputStream)new ContentLengthInputStream(paramSessionInputBuffer, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   protected HttpEntity prepareInput(HttpMessage paramHttpMessage) throws HttpException {
/* 218 */     BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
/*     */     
/* 220 */     long l = this.incomingContentStrategy.determineLength(paramHttpMessage);
/* 221 */     InputStream inputStream = createInputStream(l, (SessionInputBuffer)this.inBuffer);
/* 222 */     if (l == -2L) {
/* 223 */       basicHttpEntity.setChunked(true);
/* 224 */       basicHttpEntity.setContentLength(-1L);
/* 225 */       basicHttpEntity.setContent(inputStream);
/* 226 */     } else if (l == -1L) {
/* 227 */       basicHttpEntity.setChunked(false);
/* 228 */       basicHttpEntity.setContentLength(-1L);
/* 229 */       basicHttpEntity.setContent(inputStream);
/*     */     } else {
/* 231 */       basicHttpEntity.setChunked(false);
/* 232 */       basicHttpEntity.setContentLength(l);
/* 233 */       basicHttpEntity.setContent(inputStream);
/*     */     } 
/*     */     
/* 236 */     Header header1 = paramHttpMessage.getFirstHeader("Content-Type");
/* 237 */     if (header1 != null) {
/* 238 */       basicHttpEntity.setContentType(header1);
/*     */     }
/* 240 */     Header header2 = paramHttpMessage.getFirstHeader("Content-Encoding");
/* 241 */     if (header2 != null) {
/* 242 */       basicHttpEntity.setContentEncoding(header2);
/*     */     }
/* 244 */     return (HttpEntity)basicHttpEntity;
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 249 */     Socket socket = this.socketHolder.get();
/* 250 */     return (socket != null) ? socket.getLocalAddress() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLocalPort() {
/* 255 */     Socket socket = this.socketHolder.get();
/* 256 */     return (socket != null) ? socket.getLocalPort() : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getRemoteAddress() {
/* 261 */     Socket socket = this.socketHolder.get();
/* 262 */     return (socket != null) ? socket.getInetAddress() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRemotePort() {
/* 267 */     Socket socket = this.socketHolder.get();
/* 268 */     return (socket != null) ? socket.getPort() : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSocketTimeout(int paramInt) {
/* 273 */     Socket socket = this.socketHolder.get();
/* 274 */     if (socket != null) {
/*     */       try {
/* 276 */         socket.setSoTimeout(paramInt);
/* 277 */       } catch (SocketException socketException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSocketTimeout() {
/* 287 */     Socket socket = this.socketHolder.get();
/* 288 */     if (socket != null) {
/*     */       try {
/* 290 */         return socket.getSoTimeout();
/* 291 */       } catch (SocketException socketException) {}
/*     */     }
/*     */ 
/*     */     
/* 295 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/* 300 */     Socket socket = this.socketHolder.getAndSet(null);
/* 301 */     if (socket != null) {
/*     */ 
/*     */       
/* 304 */       try { socket.setSoLinger(true, 0); }
/* 305 */       catch (IOException iOException) {  }
/*     */       finally
/* 307 */       { socket.close(); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 314 */     Socket socket = this.socketHolder.getAndSet(null);
/* 315 */     if (socket != null) {
/*     */       try {
/* 317 */         this.inBuffer.clear();
/* 318 */         this.outbuffer.flush();
/*     */       } finally {
/* 320 */         socket.close();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private int fillInputBuffer(int paramInt) throws IOException {
/* 326 */     Socket socket = this.socketHolder.get();
/* 327 */     int i = socket.getSoTimeout();
/*     */     try {
/* 329 */       socket.setSoTimeout(paramInt);
/* 330 */       return this.inBuffer.fillBuffer();
/*     */     } finally {
/* 332 */       socket.setSoTimeout(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean awaitInput(int paramInt) throws IOException {
/* 337 */     if (this.inBuffer.hasBufferedData()) {
/* 338 */       return true;
/*     */     }
/* 340 */     fillInputBuffer(paramInt);
/* 341 */     return this.inBuffer.hasBufferedData();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStale() {
/* 346 */     if (!isOpen()) {
/* 347 */       return true;
/*     */     }
/*     */     try {
/* 350 */       int i = fillInputBuffer(1);
/* 351 */       return (i < 0);
/* 352 */     } catch (SocketTimeoutException socketTimeoutException) {
/* 353 */       return false;
/* 354 */     } catch (IOException iOException) {
/* 355 */       return true;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void incrementRequestCount() {
/* 360 */     this.connMetrics.incrementRequestCount();
/*     */   }
/*     */   
/*     */   protected void incrementResponseCount() {
/* 364 */     this.connMetrics.incrementResponseCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpConnectionMetrics getMetrics() {
/* 369 */     return this.connMetrics;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 374 */     Socket socket = this.socketHolder.get();
/* 375 */     if (socket != null) {
/* 376 */       StringBuilder stringBuilder = new StringBuilder();
/* 377 */       SocketAddress socketAddress1 = socket.getRemoteSocketAddress();
/* 378 */       SocketAddress socketAddress2 = socket.getLocalSocketAddress();
/* 379 */       if (socketAddress1 != null && socketAddress2 != null) {
/* 380 */         NetUtils.formatAddress(stringBuilder, socketAddress2);
/* 381 */         stringBuilder.append("<->");
/* 382 */         NetUtils.formatAddress(stringBuilder, socketAddress1);
/*     */       } 
/* 384 */       return stringBuilder.toString();
/*     */     } 
/* 386 */     return "[Not bound]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\BHttpConnectionBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */