/*     */ package ch.qos.logback.core.net;
/*     */ 
/*     */ import ch.qos.logback.core.AppenderBase;
/*     */ import ch.qos.logback.core.spi.PreSerializationTransformer;
/*     */ import ch.qos.logback.core.util.CloseUtil;
/*     */ import ch.qos.logback.core.util.Duration;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.concurrent.BlockingDeque;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.net.SocketFactory;
/*     */ import javax.net.ssl.SSLHandshakeException;
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
/*     */ public abstract class AbstractSocketAppender<E>
/*     */   extends AppenderBase<E>
/*     */   implements SocketConnector.ExceptionHandler
/*     */ {
/*     */   public static final int DEFAULT_PORT = 4560;
/*     */   public static final int DEFAULT_RECONNECTION_DELAY = 30000;
/*     */   public static final int DEFAULT_QUEUE_SIZE = 128;
/*     */   private static final int DEFAULT_ACCEPT_CONNECTION_DELAY = 5000;
/*     */   private static final int DEFAULT_EVENT_DELAY_TIMEOUT = 100;
/*     */   private final ObjectWriterFactory objectWriterFactory;
/*     */   private final QueueFactory queueFactory;
/*     */   private String remoteHost;
/*  78 */   private int port = 4560;
/*     */   private InetAddress address;
/*  80 */   private Duration reconnectionDelay = new Duration(30000L);
/*  81 */   private int queueSize = 128;
/*  82 */   private int acceptConnectionTimeout = 5000;
/*  83 */   private Duration eventDelayLimit = new Duration(100L);
/*     */   
/*     */   private BlockingDeque<E> deque;
/*     */   
/*     */   private String peerId;
/*     */   
/*     */   private SocketConnector connector;
/*     */   
/*     */   private Future<?> task;
/*     */   
/*     */   private volatile Socket socket;
/*     */   
/*     */   protected AbstractSocketAppender() {
/*  96 */     this(new QueueFactory(), new ObjectWriterFactory());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AbstractSocketAppender(QueueFactory paramQueueFactory, ObjectWriterFactory paramObjectWriterFactory) {
/* 103 */     this.objectWriterFactory = paramObjectWriterFactory;
/* 104 */     this.queueFactory = paramQueueFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 111 */     if (isStarted())
/*     */       return; 
/* 113 */     byte b = 0;
/* 114 */     if (this.port <= 0) {
/* 115 */       b++;
/* 116 */       addError("No port was configured for appender" + this.name + " For more information, please visit http://logback.qos.ch/codes.html#socket_no_port");
/*     */     } 
/*     */     
/* 119 */     if (this.remoteHost == null) {
/* 120 */       b++;
/* 121 */       addError("No remote host was configured for appender" + this.name + " For more information, please visit http://logback.qos.ch/codes.html#socket_no_host");
/*     */     } 
/*     */ 
/*     */     
/* 125 */     if (this.queueSize == 0) {
/* 126 */       addWarn("Queue size of zero is deprecated, use a size of one to indicate synchronous processing");
/*     */     }
/*     */     
/* 129 */     if (this.queueSize < 0) {
/* 130 */       b++;
/* 131 */       addError("Queue size must be greater than zero");
/*     */     } 
/*     */     
/* 134 */     if (b == 0) {
/*     */       try {
/* 136 */         this.address = InetAddress.getByName(this.remoteHost);
/* 137 */       } catch (UnknownHostException unknownHostException) {
/* 138 */         addError("unknown host: " + this.remoteHost);
/* 139 */         b++;
/*     */       } 
/*     */     }
/*     */     
/* 143 */     if (b == 0) {
/* 144 */       this.deque = this.queueFactory.newLinkedBlockingDeque(this.queueSize);
/* 145 */       this.peerId = "remote peer " + this.remoteHost + ":" + this.port + ": ";
/* 146 */       this.connector = createConnector(this.address, this.port, 0, this.reconnectionDelay.getMilliseconds());
/* 147 */       this.task = getContext().getExecutorService().submit(new Runnable(this)
/*     */           {
/*     */             public void run() {
/* 150 */               this.a.connectSocketAndDispatchEvents();
/*     */             }
/*     */           });
/* 153 */       super.start();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 162 */     if (!isStarted())
/*     */       return; 
/* 164 */     CloseUtil.closeQuietly(this.socket);
/* 165 */     this.task.cancel(true);
/* 166 */     super.stop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void append(E paramE) {
/* 174 */     if (paramE == null || !isStarted()) {
/*     */       return;
/*     */     }
/*     */     try {
/* 178 */       boolean bool = this.deque.offer(paramE, this.eventDelayLimit.getMilliseconds(), TimeUnit.MILLISECONDS);
/* 179 */       if (!bool) {
/* 180 */         addInfo("Dropping event due to timeout limit of [" + this.eventDelayLimit + "] being exceeded");
/*     */       }
/* 182 */     } catch (InterruptedException interruptedException) {
/* 183 */       addError("Interrupted while appending event to SocketAppender", interruptedException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void connectSocketAndDispatchEvents() {
/*     */     try {
/* 189 */       while (socketConnectionCouldBeEstablished()) {
/*     */         try {
/* 191 */           ObjectWriter objectWriter = createObjectWriterForSocket();
/* 192 */           addInfo(this.peerId + "connection established");
/* 193 */           dispatchEvents(objectWriter);
/* 194 */         } catch (SSLHandshakeException sSLHandshakeException) {
/*     */           
/* 196 */           Thread.sleep(30000L);
/* 197 */         } catch (IOException iOException) {
/* 198 */           addInfo(this.peerId + "connection failed: ", iOException);
/*     */         } finally {
/* 200 */           CloseUtil.closeQuietly(this.socket);
/* 201 */           this.socket = null;
/* 202 */           addInfo(this.peerId + "connection closed");
/*     */         } 
/*     */       } 
/* 205 */     } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */     
/* 208 */     addInfo("shutting down");
/*     */   }
/*     */   
/*     */   private boolean socketConnectionCouldBeEstablished() throws InterruptedException {
/* 212 */     return ((this.socket = this.connector.call()) != null);
/*     */   }
/*     */   
/*     */   private ObjectWriter createObjectWriterForSocket() throws IOException {
/* 216 */     this.socket.setSoTimeout(this.acceptConnectionTimeout);
/* 217 */     AutoFlushingObjectWriter autoFlushingObjectWriter = this.objectWriterFactory.newAutoFlushingObjectWriter(this.socket.getOutputStream());
/* 218 */     this.socket.setSoTimeout(0);
/* 219 */     return autoFlushingObjectWriter;
/*     */   }
/*     */   
/*     */   private SocketConnector createConnector(InetAddress paramInetAddress, int paramInt1, int paramInt2, long paramLong) {
/* 223 */     SocketConnector socketConnector = newConnector(paramInetAddress, paramInt1, paramInt2, paramLong);
/* 224 */     socketConnector.setExceptionHandler(this);
/* 225 */     socketConnector.setSocketFactory(getSocketFactory());
/* 226 */     return socketConnector;
/*     */   }
/*     */   
/*     */   private void dispatchEvents(ObjectWriter paramObjectWriter) throws InterruptedException, IOException {
/*     */     while (true) {
/* 231 */       E e = this.deque.takeFirst();
/* 232 */       postProcessEvent(e);
/* 233 */       Serializable serializable = getPST().transform(e);
/*     */       try {
/* 235 */         paramObjectWriter.write(serializable);
/* 236 */       } catch (IOException iOException) {
/* 237 */         tryReAddingEventToFrontOfQueue(e);
/* 238 */         throw iOException;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void tryReAddingEventToFrontOfQueue(E paramE) {
/* 244 */     boolean bool = this.deque.offerFirst(paramE);
/* 245 */     if (!bool) {
/* 246 */       addInfo("Dropping event due to socket connection error and maxed out deque capacity");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connectionFailed(SocketConnector paramSocketConnector, Exception paramException) {
/* 254 */     if (paramException instanceof InterruptedException) {
/* 255 */       addInfo("connector interrupted");
/* 256 */     } else if (paramException instanceof java.net.ConnectException) {
/* 257 */       addInfo(this.peerId + "connection refused");
/*     */     } else {
/* 259 */       addInfo(this.peerId + paramException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SocketConnector newConnector(InetAddress paramInetAddress, int paramInt, long paramLong1, long paramLong2) {
/* 277 */     return new DefaultSocketConnector(paramInetAddress, paramInt, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SocketFactory getSocketFactory() {
/* 286 */     return SocketFactory.getDefault();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRemoteHost(String paramString) {
/* 308 */     this.remoteHost = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRemoteHost() {
/* 315 */     return this.remoteHost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPort(int paramInt) {
/* 323 */     this.port = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 330 */     return this.port;
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
/*     */   public void setReconnectionDelay(Duration paramDuration) {
/* 342 */     this.reconnectionDelay = paramDuration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Duration getReconnectionDelay() {
/* 349 */     return this.reconnectionDelay;
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
/*     */ 
/*     */   
/*     */   public void setQueueSize(int paramInt) {
/* 365 */     this.queueSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getQueueSize() {
/* 372 */     return this.queueSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEventDelayLimit(Duration paramDuration) {
/* 383 */     this.eventDelayLimit = paramDuration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Duration getEventDelayLimit() {
/* 390 */     return this.eventDelayLimit;
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
/*     */   void setAcceptConnectionTimeout(int paramInt) {
/* 403 */     this.acceptConnectionTimeout = paramInt;
/*     */   }
/*     */   
/*     */   protected abstract void postProcessEvent(E paramE);
/*     */   
/*     */   protected abstract PreSerializationTransformer<E> getPST();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\AbstractSocketAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */