/*     */ package ch.qos.logback.classic.net;
/*     */ 
/*     */ import ch.qos.logback.classic.Logger;
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.net.server.HardenedLoggingEventInputStream;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.core.net.DefaultSocketConnector;
/*     */ import ch.qos.logback.core.net.SocketConnector;
/*     */ import ch.qos.logback.core.util.CloseUtil;
/*     */ import java.io.Closeable;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.RejectedExecutionException;
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
/*     */ public class SocketReceiver
/*     */   extends ReceiverBase
/*     */   implements SocketConnector.ExceptionHandler, Runnable
/*     */ {
/*     */   private static final int DEFAULT_ACCEPT_CONNECTION_DELAY = 5000;
/*     */   private String remoteHost;
/*     */   private InetAddress address;
/*     */   private int port;
/*     */   private int reconnectionDelay;
/*  52 */   private int acceptConnectionTimeout = 5000;
/*     */   
/*     */   private String receiverId;
/*     */   
/*     */   private volatile Socket socket;
/*     */   
/*     */   private Future<Socket> connectorTask;
/*     */ 
/*     */   
/*     */   protected boolean shouldStart() {
/*  62 */     byte b = 0;
/*  63 */     if (this.port == 0) {
/*  64 */       b++;
/*  65 */       addError("No port was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_port");
/*     */     } 
/*     */     
/*  68 */     if (this.remoteHost == null) {
/*  69 */       b++;
/*  70 */       addError("No host name or address was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_host");
/*     */     } 
/*     */ 
/*     */     
/*  74 */     if (this.reconnectionDelay == 0) {
/*  75 */       this.reconnectionDelay = 30000;
/*     */     }
/*     */     
/*  78 */     if (b == 0) {
/*     */       try {
/*  80 */         this.address = InetAddress.getByName(this.remoteHost);
/*  81 */       } catch (UnknownHostException unknownHostException) {
/*  82 */         addError("unknown host: " + this.remoteHost);
/*  83 */         b++;
/*     */       } 
/*     */     }
/*     */     
/*  87 */     if (b == 0) {
/*  88 */       this.receiverId = "receiver " + this.remoteHost + ":" + this.port + ": ";
/*     */     }
/*     */     
/*  91 */     return (b == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onStop() {
/*  98 */     if (this.socket != null) {
/*  99 */       CloseUtil.closeQuietly(this.socket);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected Runnable getRunnableTask() {
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 113 */       LoggerContext loggerContext = (LoggerContext)getContext();
/* 114 */       while (!Thread.currentThread().isInterrupted()) {
/* 115 */         SocketConnector socketConnector = createConnector(this.address, this.port, 0, this.reconnectionDelay);
/* 116 */         this.connectorTask = activateConnector(socketConnector);
/* 117 */         if (this.connectorTask == null) {
/*     */           break;
/*     */         }
/* 120 */         this.socket = waitForConnectorToReturnASocket();
/* 121 */         if (this.socket == null)
/*     */           break; 
/* 123 */         dispatchEvents(loggerContext);
/*     */       } 
/* 125 */     } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */     
/* 128 */     addInfo("shutting down");
/*     */   }
/*     */   
/*     */   private SocketConnector createConnector(InetAddress paramInetAddress, int paramInt1, int paramInt2, int paramInt3) {
/* 132 */     SocketConnector socketConnector = newConnector(paramInetAddress, paramInt1, paramInt2, paramInt3);
/* 133 */     socketConnector.setExceptionHandler(this);
/* 134 */     socketConnector.setSocketFactory(getSocketFactory());
/* 135 */     return socketConnector;
/*     */   }
/*     */   
/*     */   private Future<Socket> activateConnector(SocketConnector paramSocketConnector) {
/*     */     try {
/* 140 */       return getContext().getScheduledExecutorService().submit((Callable<Socket>)paramSocketConnector);
/* 141 */     } catch (RejectedExecutionException rejectedExecutionException) {
/* 142 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Socket waitForConnectorToReturnASocket() throws InterruptedException {
/*     */     try {
/* 148 */       Socket socket = this.connectorTask.get();
/* 149 */       this.connectorTask = null;
/* 150 */       return socket;
/* 151 */     } catch (ExecutionException executionException) {
/* 152 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dispatchEvents(LoggerContext paramLoggerContext) {
/* 157 */     HardenedLoggingEventInputStream hardenedLoggingEventInputStream = null;
/*     */     try {
/* 159 */       this.socket.setSoTimeout(this.acceptConnectionTimeout);
/* 160 */       hardenedLoggingEventInputStream = new HardenedLoggingEventInputStream(this.socket.getInputStream());
/* 161 */       this.socket.setSoTimeout(0);
/* 162 */       addInfo(this.receiverId + "connection established");
/*     */       while (true) {
/* 164 */         ILoggingEvent iLoggingEvent = (ILoggingEvent)hardenedLoggingEventInputStream.readObject();
/* 165 */         Logger logger = paramLoggerContext.getLogger(iLoggingEvent.getLoggerName());
/* 166 */         if (logger.isEnabledFor(iLoggingEvent.getLevel())) {
/* 167 */           logger.callAppenders(iLoggingEvent);
/*     */         }
/*     */       } 
/* 170 */     } catch (EOFException eOFException) {
/* 171 */       addInfo(this.receiverId + "end-of-stream detected");
/* 172 */     } catch (IOException iOException) {
/* 173 */       addInfo(this.receiverId + "connection failed: " + iOException);
/* 174 */     } catch (ClassNotFoundException classNotFoundException) {
/* 175 */       addInfo(this.receiverId + "unknown event class: " + classNotFoundException);
/*     */     } finally {
/* 177 */       CloseUtil.closeQuietly((Closeable)hardenedLoggingEventInputStream);
/* 178 */       CloseUtil.closeQuietly(this.socket);
/* 179 */       this.socket = null;
/* 180 */       addInfo(this.receiverId + "connection closed");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connectionFailed(SocketConnector paramSocketConnector, Exception paramException) {
/* 188 */     if (paramException instanceof InterruptedException) {
/* 189 */       addInfo("connector interrupted");
/* 190 */     } else if (paramException instanceof java.net.ConnectException) {
/* 191 */       addInfo(this.receiverId + "connection refused");
/*     */     } else {
/* 193 */       addInfo(this.receiverId + paramException);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected SocketConnector newConnector(InetAddress paramInetAddress, int paramInt1, int paramInt2, int paramInt3) {
/* 198 */     return (SocketConnector)new DefaultSocketConnector(paramInetAddress, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   protected SocketFactory getSocketFactory() {
/* 202 */     return SocketFactory.getDefault();
/*     */   }
/*     */   
/*     */   public void setRemoteHost(String paramString) {
/* 206 */     this.remoteHost = paramString;
/*     */   }
/*     */   
/*     */   public void setPort(int paramInt) {
/* 210 */     this.port = paramInt;
/*     */   }
/*     */   
/*     */   public void setReconnectionDelay(int paramInt) {
/* 214 */     this.reconnectionDelay = paramInt;
/*     */   }
/*     */   
/*     */   public void setAcceptConnectionTimeout(int paramInt) {
/* 218 */     this.acceptConnectionTimeout = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\SocketReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */