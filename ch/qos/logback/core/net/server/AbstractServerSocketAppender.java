/*     */ package ch.qos.logback.core.net.server;
/*     */ 
/*     */ import ch.qos.logback.core.AppenderBase;
/*     */ import ch.qos.logback.core.spi.PreSerializationTransformer;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractServerSocketAppender<E>
/*     */   extends AppenderBase<E>
/*     */ {
/*     */   public static final int DEFAULT_BACKLOG = 50;
/*     */   public static final int DEFAULT_CLIENT_QUEUE_SIZE = 100;
/*  48 */   private int port = 4560;
/*  49 */   private int backlog = 50;
/*  50 */   private int clientQueueSize = 100;
/*     */   
/*     */   private String address;
/*     */   
/*     */   private ServerRunner<a> runner;
/*     */ 
/*     */   
/*     */   public void start() {
/*  58 */     if (isStarted())
/*     */       return; 
/*     */     try {
/*  61 */       ServerSocket serverSocket = getServerSocketFactory().createServerSocket(getPort(), getBacklog(), getInetAddress());
/*  62 */       ServerListener<a> serverListener = createServerListener(serverSocket);
/*     */       
/*  64 */       this.runner = createServerRunner(serverListener, getContext().getExecutorService());
/*  65 */       this.runner.setContext(getContext());
/*  66 */       getContext().getExecutorService().execute(this.runner);
/*  67 */       super.start();
/*  68 */     } catch (Exception exception) {
/*  69 */       addError("server startup error: " + exception, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ServerListener<a> createServerListener(ServerSocket paramServerSocket) {
/*  74 */     return new b(paramServerSocket);
/*     */   }
/*     */   
/*     */   protected ServerRunner<a> createServerRunner(ServerListener<a> paramServerListener, Executor paramExecutor) {
/*  78 */     return new c(paramServerListener, paramExecutor, getClientQueueSize());
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/*  83 */     if (!isStarted())
/*     */       return; 
/*     */     try {
/*  86 */       this.runner.stop();
/*  87 */       super.stop();
/*  88 */     } catch (IOException iOException) {
/*  89 */       addError("server shutdown error: " + iOException, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void append(E paramE) {
/*  95 */     if (paramE == null)
/*     */       return; 
/*  97 */     postProcessEvent(paramE);
/*  98 */     Serializable serializable = getPST().transform(paramE);
/*  99 */     this.runner.accept(new ClientVisitor<a>(this, serializable) {
/*     */           public void a(a param1a) {
/* 101 */             param1a.a((Serializable)this.a);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void postProcessEvent(E paramE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract PreSerializationTransformer<E> getPST();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ServerSocketFactory getServerSocketFactory() throws Exception {
/* 129 */     return ServerSocketFactory.getDefault();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected InetAddress getInetAddress() throws UnknownHostException {
/* 138 */     if (getAddress() == null)
/* 139 */       return null; 
/* 140 */     return InetAddress.getByName(getAddress());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 148 */     return this.port;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPort(int paramInt) {
/* 156 */     this.port = paramInt;
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
/* 168 */     return this.backlog;
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
/* 180 */     this.backlog = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress() {
/* 188 */     return this.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress(String paramString) {
/* 196 */     this.address = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getClientQueueSize() {
/* 204 */     return this.clientQueueSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClientQueueSize(int paramInt) {
/* 212 */     this.clientQueueSize = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\server\AbstractServerSocketAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */