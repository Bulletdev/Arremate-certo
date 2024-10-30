/*     */ package ch.qos.logback.classic.net.server;
/*     */ 
/*     */ import ch.qos.logback.classic.Logger;
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.core.net.HardenedObjectInputStream;
/*     */ import ch.qos.logback.core.util.CloseUtil;
/*     */ import java.io.Closeable;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.Socket;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class d
/*     */   implements a
/*     */ {
/*     */   private final String id;
/*     */   private final Socket socket;
/*     */   private final InputStream a;
/*     */   private LoggerContext lc;
/*     */   private Logger logger;
/*     */   
/*     */   public d(String paramString, Socket paramSocket) {
/*  48 */     this.id = paramString;
/*  49 */     this.socket = paramSocket;
/*  50 */     this.a = null;
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
/*     */   public d(String paramString, InputStream paramInputStream) {
/*  63 */     this.id = paramString;
/*  64 */     this.socket = null;
/*  65 */     this.a = paramInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoggerContext(LoggerContext paramLoggerContext) {
/*  72 */     this.lc = paramLoggerContext;
/*  73 */     this.logger = paramLoggerContext.getLogger(getClass().getPackage().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  80 */     if (this.socket == null)
/*     */       return; 
/*  82 */     CloseUtil.closeQuietly(this.socket);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  89 */     this.logger.info(this + ": connected");
/*  90 */     HardenedObjectInputStream hardenedObjectInputStream = null;
/*     */     try {
/*  92 */       hardenedObjectInputStream = a();
/*     */       
/*     */       while (true) {
/*  95 */         ILoggingEvent iLoggingEvent = (ILoggingEvent)hardenedObjectInputStream.readObject();
/*     */ 
/*     */         
/*  98 */         Logger logger = this.lc.getLogger(iLoggingEvent.getLoggerName());
/*     */         
/* 100 */         if (logger.isEnabledFor(iLoggingEvent.getLevel()))
/*     */         {
/* 102 */           logger.callAppenders(iLoggingEvent);
/*     */         }
/*     */       } 
/* 105 */     } catch (EOFException eOFException) {
/*     */ 
/*     */     
/* 108 */     } catch (IOException iOException) {
/* 109 */       this.logger.info(this + ": " + iOException);
/* 110 */     } catch (ClassNotFoundException classNotFoundException) {
/* 111 */       this.logger.error(this + ": unknown event class");
/* 112 */     } catch (RuntimeException runtimeException) {
/* 113 */       this.logger.error(this + ": " + runtimeException);
/*     */     } finally {
/* 115 */       if (hardenedObjectInputStream != null) {
/* 116 */         CloseUtil.closeQuietly((Closeable)hardenedObjectInputStream);
/*     */       }
/* 118 */       close();
/* 119 */       this.logger.info(this + ": connection closed");
/*     */     } 
/*     */   }
/*     */   
/*     */   private HardenedObjectInputStream a() throws IOException {
/* 124 */     if (this.a != null) {
/* 125 */       return new HardenedLoggingEventInputStream(this.a);
/*     */     }
/* 127 */     return new HardenedLoggingEventInputStream(this.socket.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     return "client " + this.id;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\server\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */