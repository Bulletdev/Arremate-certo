/*     */ package org.apache.http.impl.bootstrap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.apache.http.ExceptionLogger;
/*     */ import org.apache.http.HttpConnectionFactory;
/*     */ import org.apache.http.HttpServerConnection;
/*     */ import org.apache.http.config.SocketConfig;
/*     */ import org.apache.http.protocol.HttpService;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RequestListener
/*     */   implements Runnable
/*     */ {
/*     */   private final SocketConfig socketConfig;
/*     */   private final ServerSocket serversocket;
/*     */   private final HttpService httpService;
/*     */   private final HttpConnectionFactory<? extends HttpServerConnection> connectionFactory;
/*     */   private final ExceptionLogger exceptionLogger;
/*     */   private final ExecutorService executorService;
/*     */   private final AtomicBoolean terminated;
/*     */   
/*     */   public RequestListener(SocketConfig paramSocketConfig, ServerSocket paramServerSocket, HttpService paramHttpService, HttpConnectionFactory<? extends HttpServerConnection> paramHttpConnectionFactory, ExceptionLogger paramExceptionLogger, ExecutorService paramExecutorService) {
/*  61 */     this.socketConfig = paramSocketConfig;
/*  62 */     this.serversocket = paramServerSocket;
/*  63 */     this.connectionFactory = paramHttpConnectionFactory;
/*  64 */     this.httpService = paramHttpService;
/*  65 */     this.exceptionLogger = paramExceptionLogger;
/*  66 */     this.executorService = paramExecutorService;
/*  67 */     this.terminated = new AtomicBoolean(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  73 */       while (!isTerminated() && !Thread.interrupted()) {
/*  74 */         Socket socket = this.serversocket.accept();
/*  75 */         socket.setSoTimeout(this.socketConfig.getSoTimeout());
/*  76 */         socket.setKeepAlive(this.socketConfig.isSoKeepAlive());
/*  77 */         socket.setTcpNoDelay(this.socketConfig.isTcpNoDelay());
/*  78 */         if (this.socketConfig.getRcvBufSize() > 0) {
/*  79 */           socket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
/*     */         }
/*  81 */         if (this.socketConfig.getSndBufSize() > 0) {
/*  82 */           socket.setSendBufferSize(this.socketConfig.getSndBufSize());
/*     */         }
/*  84 */         if (this.socketConfig.getSoLinger() >= 0) {
/*  85 */           socket.setSoLinger(true, this.socketConfig.getSoLinger());
/*     */         }
/*  87 */         HttpServerConnection httpServerConnection = (HttpServerConnection)this.connectionFactory.createConnection(socket);
/*  88 */         Worker worker = new Worker(this.httpService, httpServerConnection, this.exceptionLogger);
/*  89 */         this.executorService.execute(worker);
/*     */       } 
/*  91 */     } catch (Exception exception) {
/*  92 */       this.exceptionLogger.log(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isTerminated() {
/*  97 */     return this.terminated.get();
/*     */   }
/*     */   
/*     */   public void terminate() throws IOException {
/* 101 */     if (this.terminated.compareAndSet(false, true))
/* 102 */       this.serversocket.close(); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\bootstrap\RequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */