/*     */ package ch.qos.logback.core.net.server;
/*     */ 
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.util.CloseUtil;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketException;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ContextAwareBase
/*     */   implements a
/*     */ {
/*     */   private final String gm;
/*     */   private final Socket socket;
/*     */   private final OutputStream outputStream;
/*     */   private BlockingQueue<Serializable> a;
/*     */   
/*     */   public d(String paramString, Socket paramSocket) {
/*  48 */     this.gm = "client " + paramString + ": ";
/*  49 */     this.socket = paramSocket;
/*  50 */     this.outputStream = null;
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
/*     */   d(String paramString, OutputStream paramOutputStream) {
/*  63 */     this.gm = "client " + paramString + ": ";
/*  64 */     this.socket = null;
/*  65 */     this.outputStream = paramOutputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(BlockingQueue<Serializable> paramBlockingQueue) {
/*  72 */     this.a = paramBlockingQueue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(Serializable paramSerializable) {
/*  79 */     if (this.a == null) {
/*  80 */       throw new IllegalStateException("client has no event queue");
/*     */     }
/*  82 */     return this.a.offer(paramSerializable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  89 */     if (this.socket == null)
/*     */       return; 
/*  91 */     CloseUtil.closeQuietly(this.socket);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  98 */     addInfo(this.gm + "connected");
/*     */     
/* 100 */     ObjectOutputStream objectOutputStream = null;
/*     */     try {
/* 102 */       byte b = 0;
/* 103 */       objectOutputStream = a();
/* 104 */       while (!Thread.currentThread().isInterrupted()) {
/*     */         try {
/* 106 */           Serializable serializable = this.a.take();
/* 107 */           objectOutputStream.writeObject(serializable);
/* 108 */           objectOutputStream.flush();
/* 109 */           if (++b >= 70) {
/*     */ 
/*     */             
/* 112 */             b = 0;
/* 113 */             objectOutputStream.reset();
/*     */           } 
/* 115 */         } catch (InterruptedException interruptedException) {
/* 116 */           Thread.currentThread().interrupt();
/*     */         } 
/*     */       } 
/* 119 */     } catch (SocketException socketException) {
/* 120 */       addInfo(this.gm + socketException);
/* 121 */     } catch (IOException iOException) {
/* 122 */       addError(this.gm + iOException);
/* 123 */     } catch (RuntimeException runtimeException) {
/* 124 */       addError(this.gm + runtimeException);
/*     */     } finally {
/* 126 */       if (objectOutputStream != null) {
/* 127 */         CloseUtil.closeQuietly(objectOutputStream);
/*     */       }
/* 129 */       close();
/* 130 */       addInfo(this.gm + "connection closed");
/*     */     } 
/*     */   }
/*     */   
/*     */   private ObjectOutputStream a() throws IOException {
/* 135 */     if (this.socket == null) {
/* 136 */       return new ObjectOutputStream(this.outputStream);
/*     */     }
/* 138 */     return new ObjectOutputStream(this.socket.getOutputStream());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\server\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */