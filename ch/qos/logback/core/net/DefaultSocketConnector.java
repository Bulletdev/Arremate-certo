/*     */ package ch.qos.logback.core.net;
/*     */ 
/*     */ import ch.qos.logback.core.util.DelayStrategy;
/*     */ import ch.qos.logback.core.util.FixedDelay;
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import javax.net.SocketFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultSocketConnector
/*     */   implements SocketConnector
/*     */ {
/*     */   private final InetAddress address;
/*     */   private final int port;
/*     */   private final DelayStrategy delayStrategy;
/*     */   private SocketConnector.ExceptionHandler exceptionHandler;
/*     */   private SocketFactory socketFactory;
/*     */   
/*     */   public DefaultSocketConnector(InetAddress paramInetAddress, int paramInt, long paramLong1, long paramLong2) {
/*  49 */     this(paramInetAddress, paramInt, (DelayStrategy)new FixedDelay(paramLong1, paramLong2));
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
/*     */   public DefaultSocketConnector(InetAddress paramInetAddress, int paramInt, DelayStrategy paramDelayStrategy) {
/*  61 */     this.address = paramInetAddress;
/*  62 */     this.port = paramInt;
/*  63 */     this.delayStrategy = paramDelayStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket call() throws InterruptedException {
/*  70 */     useDefaultsForMissingFields();
/*  71 */     Socket socket = createSocket();
/*  72 */     while (socket == null && !Thread.currentThread().isInterrupted()) {
/*  73 */       Thread.sleep(this.delayStrategy.nextDelay());
/*  74 */       socket = createSocket();
/*     */     } 
/*  76 */     return socket;
/*     */   }
/*     */   
/*     */   private Socket createSocket() {
/*  80 */     Socket socket = null;
/*     */     try {
/*  82 */       socket = this.socketFactory.createSocket(this.address, this.port);
/*  83 */     } catch (IOException iOException) {
/*  84 */       this.exceptionHandler.connectionFailed(this, iOException);
/*     */     } 
/*  86 */     return socket;
/*     */   }
/*     */   
/*     */   private void useDefaultsForMissingFields() {
/*  90 */     if (this.exceptionHandler == null) {
/*  91 */       this.exceptionHandler = new a();
/*     */     }
/*  93 */     if (this.socketFactory == null) {
/*  94 */       this.socketFactory = SocketFactory.getDefault();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExceptionHandler(SocketConnector.ExceptionHandler paramExceptionHandler) {
/* 102 */     this.exceptionHandler = paramExceptionHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSocketFactory(SocketFactory paramSocketFactory) {
/* 109 */     this.socketFactory = paramSocketFactory;
/*     */   }
/*     */   
/*     */   private static class a
/*     */     implements SocketConnector.ExceptionHandler
/*     */   {
/*     */     private a() {}
/*     */     
/*     */     public void connectionFailed(SocketConnector param1SocketConnector, Exception param1Exception) {
/* 118 */       System.out.println(param1Exception);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\DefaultSocketConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */