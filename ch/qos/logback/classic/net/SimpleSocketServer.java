/*     */ package ch.qos.logback.classic.net;
/*     */ 
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.joran.JoranConfigurator;
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import java.io.IOException;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import javax.net.ServerSocketFactory;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleSocketServer
/*     */   extends Thread
/*     */ {
/*  52 */   Logger logger = LoggerFactory.getLogger(SimpleSocketServer.class);
/*     */   
/*     */   private final int port;
/*     */   private final LoggerContext lc;
/*     */   private boolean closed = false;
/*     */   private ServerSocket serverSocket;
/*  58 */   private List<SocketNode> socketNodeList = new ArrayList<SocketNode>();
/*     */   
/*     */   private CountDownLatch latch;
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  64 */     doMain(SimpleSocketServer.class, paramArrayOfString);
/*     */   }
/*     */   
/*     */   protected static void doMain(Class<? extends SimpleSocketServer> paramClass, String[] paramArrayOfString) throws Exception {
/*  68 */     int i = -1;
/*  69 */     if (paramArrayOfString.length == 2) {
/*  70 */       i = parsePortNumber(paramArrayOfString[0]);
/*     */     } else {
/*  72 */       usage("Wrong number of arguments.");
/*     */     } 
/*     */     
/*  75 */     String str = paramArrayOfString[1];
/*  76 */     LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
/*  77 */     configureLC(loggerContext, str);
/*     */     
/*  79 */     SimpleSocketServer simpleSocketServer = new SimpleSocketServer(loggerContext, i);
/*  80 */     simpleSocketServer.start();
/*     */   }
/*     */   
/*     */   public SimpleSocketServer(LoggerContext paramLoggerContext, int paramInt) {
/*  84 */     this.lc = paramLoggerContext;
/*  85 */     this.port = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  90 */     String str = Thread.currentThread().getName();
/*     */ 
/*     */     
/*     */     try {
/*  94 */       String str1 = getServerThreadName();
/*  95 */       Thread.currentThread().setName(str1);
/*     */       
/*  97 */       this.logger.info("Listening on port " + this.port);
/*  98 */       this.serverSocket = getServerSocketFactory().createServerSocket(this.port);
/*  99 */       while (!this.closed) {
/* 100 */         this.logger.info("Waiting to accept a new client.");
/* 101 */         signalAlmostReadiness();
/* 102 */         Socket socket = this.serverSocket.accept();
/* 103 */         this.logger.info("Connected to client at " + socket.getInetAddress());
/* 104 */         this.logger.info("Starting new socket node.");
/* 105 */         SocketNode socketNode = new SocketNode(this, socket, this.lc);
/* 106 */         synchronized (this.socketNodeList) {
/* 107 */           this.socketNodeList.add(socketNode);
/*     */         } 
/* 109 */         String str2 = getClientThreadName(socket);
/* 110 */         (new Thread(socketNode, str2)).start();
/*     */       } 
/* 112 */     } catch (Exception exception) {
/* 113 */       if (this.closed) {
/* 114 */         this.logger.info("Exception in run method for a closed server. This is normal.");
/*     */       } else {
/* 116 */         this.logger.error("Unexpected failure in run method", exception);
/*     */       }
/*     */     
/*     */     } finally {
/*     */       
/* 121 */       Thread.currentThread().setName(str);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getServerThreadName() {
/* 129 */     return String.format("Logback %s (port %d)", new Object[] { getClass().getSimpleName(), Integer.valueOf(this.port) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClientThreadName(Socket paramSocket) {
/* 136 */     return String.format("Logback SocketNode (client: %s)", new Object[] { paramSocket.getRemoteSocketAddress() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ServerSocketFactory getServerSocketFactory() {
/* 145 */     return ServerSocketFactory.getDefault();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void signalAlmostReadiness() {
/* 153 */     if (this.latch != null && this.latch.getCount() != 0L)
/*     */     {
/* 155 */       this.latch.countDown();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setLatch(CountDownLatch paramCountDownLatch) {
/* 164 */     this.latch = paramCountDownLatch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CountDownLatch getLatch() {
/* 171 */     return this.latch;
/*     */   }
/*     */   
/*     */   public boolean isClosed() {
/* 175 */     return this.closed;
/*     */   }
/*     */   
/*     */   public void close() {
/* 179 */     this.closed = true;
/* 180 */     if (this.serverSocket != null) {
/*     */       try {
/* 182 */         this.serverSocket.close();
/* 183 */       } catch (IOException iOException) {
/* 184 */         this.logger.error("Failed to close serverSocket", iOException);
/*     */       } finally {
/* 186 */         this.serverSocket = null;
/*     */       } 
/*     */     }
/*     */     
/* 190 */     this.logger.info("closing this server");
/* 191 */     synchronized (this.socketNodeList) {
/* 192 */       for (SocketNode socketNode : this.socketNodeList) {
/* 193 */         socketNode.close();
/*     */       }
/*     */     } 
/* 196 */     if (this.socketNodeList.size() != 0) {
/* 197 */       this.logger.warn("Was expecting a 0-sized socketNodeList after server shutdown");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void socketNodeClosing(SocketNode paramSocketNode) {
/* 203 */     this.logger.debug("Removing {}", paramSocketNode);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     synchronized (this.socketNodeList) {
/* 209 */       this.socketNodeList.remove(paramSocketNode);
/*     */     } 
/*     */   }
/*     */   
/*     */   static void usage(String paramString) {
/* 214 */     System.err.println(paramString);
/* 215 */     System.err.println("Usage: java " + SimpleSocketServer.class.getName() + " port configFile");
/* 216 */     System.exit(1);
/*     */   }
/*     */   
/*     */   static int parsePortNumber(String paramString) {
/*     */     try {
/* 221 */       return Integer.parseInt(paramString);
/* 222 */     } catch (NumberFormatException numberFormatException) {
/* 223 */       numberFormatException.printStackTrace();
/* 224 */       usage("Could not interpret port number [" + paramString + "].");
/*     */       
/* 226 */       return -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void configureLC(LoggerContext paramLoggerContext, String paramString) throws JoranException {
/* 231 */     JoranConfigurator joranConfigurator = new JoranConfigurator();
/* 232 */     paramLoggerContext.reset();
/* 233 */     joranConfigurator.setContext((Context)paramLoggerContext);
/* 234 */     joranConfigurator.doConfigure(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\SimpleSocketServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */