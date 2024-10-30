/*     */ package ch.qos.logback.classic.net.server;
/*     */ 
/*     */ import ch.qos.logback.classic.net.ReceiverBase;
/*     */ import ch.qos.logback.core.net.server.ServerListener;
/*     */ import ch.qos.logback.core.net.server.ServerRunner;
/*     */ import ch.qos.logback.core.util.CloseUtil;
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.concurrent.Executor;
/*     */ import javax.net.ServerSocketFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServerSocketReceiver
/*     */   extends ReceiverBase
/*     */ {
/*     */   public static final int DEFAULT_BACKLOG = 50;
/*  42 */   private int port = 4560;
/*  43 */   private int backlog = 50;
/*     */ 
/*     */   
/*     */   private String address;
/*     */   
/*     */   private ServerSocket serverSocket;
/*     */   
/*     */   private ServerRunner runner;
/*     */ 
/*     */   
/*     */   protected boolean shouldStart() {
/*     */     try {
/*  55 */       ServerSocket serverSocket = getServerSocketFactory().createServerSocket(getPort(), getBacklog(), getInetAddress());
/*     */       
/*  57 */       ServerListener<a> serverListener = createServerListener(serverSocket);
/*     */       
/*  59 */       this.runner = createServerRunner(serverListener, getContext().getExecutorService());
/*  60 */       this.runner.setContext(getContext());
/*  61 */       return true;
/*  62 */     } catch (Exception exception) {
/*  63 */       addError("server startup error: " + exception, exception);
/*  64 */       CloseUtil.closeQuietly(this.serverSocket);
/*  65 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ServerListener<a> createServerListener(ServerSocket paramServerSocket) {
/*  70 */     return (ServerListener<a>)new b(paramServerSocket);
/*     */   }
/*     */   
/*     */   protected ServerRunner createServerRunner(ServerListener<a> paramServerListener, Executor paramExecutor) {
/*  74 */     return (ServerRunner)new c(paramServerListener, paramExecutor);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Runnable getRunnableTask() {
/*  79 */     return (Runnable)this.runner;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onStop() {
/*     */     try {
/*  87 */       if (this.runner == null)
/*     */         return; 
/*  89 */       this.runner.stop();
/*  90 */     } catch (IOException iOException) {
/*  91 */       addError("server shutdown error: " + iOException, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ServerSocketFactory getServerSocketFactory() throws Exception {
/* 103 */     return ServerSocketFactory.getDefault();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected InetAddress getInetAddress() throws UnknownHostException {
/* 112 */     if (getAddress() == null)
/* 113 */       return null; 
/* 114 */     return InetAddress.getByName(getAddress());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 122 */     return this.port;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPort(int paramInt) {
/* 130 */     this.port = paramInt;
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
/*     */   public int getBacklog() {
/* 142 */     return this.backlog;
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
/*     */   public void setBacklog(int paramInt) {
/* 154 */     this.backlog = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress() {
/* 162 */     return this.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress(String paramString) {
/* 170 */     this.address = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\server\ServerSocketReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */