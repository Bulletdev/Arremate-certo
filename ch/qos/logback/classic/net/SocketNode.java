/*     */ package ch.qos.logback.classic.net;
/*     */ 
/*     */ import ch.qos.logback.classic.Logger;
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.net.server.HardenedLoggingEventInputStream;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketAddress;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SocketNode
/*     */   implements Runnable
/*     */ {
/*     */   Socket socket;
/*     */   LoggerContext context;
/*     */   HardenedLoggingEventInputStream hardenedLoggingEventInputStream;
/*     */   SocketAddress remoteSocketAddress;
/*     */   Logger logger;
/*     */   boolean closed = false;
/*     */   SimpleSocketServer socketServer;
/*     */   
/*     */   public SocketNode(SimpleSocketServer paramSimpleSocketServer, Socket paramSocket, LoggerContext paramLoggerContext) {
/*  54 */     this.socketServer = paramSimpleSocketServer;
/*  55 */     this.socket = paramSocket;
/*  56 */     this.remoteSocketAddress = paramSocket.getRemoteSocketAddress();
/*  57 */     this.context = paramLoggerContext;
/*  58 */     this.logger = paramLoggerContext.getLogger(SocketNode.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  70 */       this.hardenedLoggingEventInputStream = new HardenedLoggingEventInputStream(new BufferedInputStream(this.socket.getInputStream()));
/*  71 */     } catch (Exception exception) {
/*  72 */       this.logger.error("Could not open ObjectInputStream to " + this.socket, exception);
/*  73 */       this.closed = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     while (!this.closed) {
/*     */       
/*  82 */       ILoggingEvent iLoggingEvent = (ILoggingEvent)this.hardenedLoggingEventInputStream.readObject();
/*     */ 
/*     */       
/*  85 */       Logger logger = this.context.getLogger(iLoggingEvent.getLoggerName());
/*     */       
/*  87 */       if (logger.isEnabledFor(iLoggingEvent.getLevel()))
/*     */       {
/*  89 */         logger.callAppenders(iLoggingEvent);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     this.socketServer.socketNodeClosing(this);
/* 104 */     close();
/*     */   }
/*     */   
/*     */   void close() {
/* 108 */     if (this.closed) {
/*     */       return;
/*     */     }
/* 111 */     this.closed = true;
/* 112 */     if (this.hardenedLoggingEventInputStream != null) {
/*     */       try {
/* 114 */         this.hardenedLoggingEventInputStream.close();
/* 115 */       } catch (IOException iOException) {
/* 116 */         this.logger.warn("Could not close connection.", iOException);
/*     */       } finally {
/* 118 */         this.hardenedLoggingEventInputStream = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     return getClass().getName() + this.remoteSocketAddress.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\SocketNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */