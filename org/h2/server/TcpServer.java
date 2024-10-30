/*     */ package org.h2.server;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import org.h2.Driver;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.NetUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Tool;
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
/*     */ public class TcpServer
/*     */   implements Service
/*     */ {
/*     */   private static final int SHUTDOWN_NORMAL = 0;
/*     */   private static final int SHUTDOWN_FORCE = 1;
/*     */   private static final String MANAGEMENT_DB_PREFIX = "management_db_";
/*  52 */   private static final Map<Integer, TcpServer> SERVERS = Collections.synchronizedMap(new HashMap<>());
/*     */   
/*     */   private int port;
/*     */   
/*     */   private boolean portIsSet;
/*     */   private boolean trace;
/*     */   private boolean ssl;
/*     */   private boolean stop;
/*     */   private ShutdownHandler shutdownHandler;
/*     */   private ServerSocket serverSocket;
/*  62 */   private final Set<TcpServerThread> running = Collections.synchronizedSet(new HashSet<>());
/*     */   
/*     */   private String baseDir;
/*     */   private boolean allowOthers;
/*     */   private boolean isDaemon;
/*     */   private boolean ifExists;
/*     */   private Connection managementDb;
/*     */   private PreparedStatement managementDbAdd;
/*     */   private PreparedStatement managementDbRemove;
/*  71 */   private String managementPassword = "";
/*     */ 
/*     */   
/*     */   private Thread listenerThread;
/*     */   
/*     */   private int nextThreadId;
/*     */   
/*     */   private String key;
/*     */   
/*     */   private String keyDatabase;
/*     */ 
/*     */   
/*     */   public static String getManagementDbName(int paramInt) {
/*  84 */     return "mem:management_db_" + paramInt;
/*     */   }
/*     */   
/*     */   private void initManagementDb() throws SQLException {
/*  88 */     Properties properties = new Properties();
/*  89 */     properties.setProperty("user", "");
/*  90 */     properties.setProperty("password", this.managementPassword);
/*     */     
/*  92 */     Connection connection = Driver.load().connect("jdbc:h2:" + getManagementDbName(this.port), properties);
/*     */     
/*  94 */     this.managementDb = connection;
/*     */     
/*  96 */     try (Statement null = connection.createStatement()) {
/*  97 */       statement.execute("CREATE ALIAS IF NOT EXISTS STOP_SERVER FOR \"" + TcpServer.class.getName() + ".stopServer\"");
/*     */       
/*  99 */       statement.execute("CREATE TABLE IF NOT EXISTS SESSIONS(ID INT PRIMARY KEY, URL VARCHAR, USER VARCHAR, CONNECTED TIMESTAMP)");
/*     */ 
/*     */       
/* 102 */       this.managementDbAdd = connection.prepareStatement("INSERT INTO SESSIONS VALUES(?, ?, ?, NOW())");
/*     */       
/* 104 */       this.managementDbRemove = connection.prepareStatement("DELETE FROM SESSIONS WHERE ID=?");
/*     */     } 
/*     */     
/* 107 */     SERVERS.put(Integer.valueOf(this.port), this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void shutdown() {
/* 114 */     if (this.shutdownHandler != null) {
/* 115 */       this.shutdownHandler.shutdown();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setShutdownHandler(ShutdownHandler paramShutdownHandler) {
/* 120 */     this.shutdownHandler = paramShutdownHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void addConnection(int paramInt, String paramString1, String paramString2) {
/*     */     try {
/* 132 */       this.managementDbAdd.setInt(1, paramInt);
/* 133 */       this.managementDbAdd.setString(2, paramString1);
/* 134 */       this.managementDbAdd.setString(3, paramString2);
/* 135 */       this.managementDbAdd.execute();
/* 136 */     } catch (SQLException sQLException) {
/* 137 */       DbException.traceThrowable(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void removeConnection(int paramInt) {
/*     */     try {
/* 148 */       this.managementDbRemove.setInt(1, paramInt);
/* 149 */       this.managementDbRemove.execute();
/* 150 */     } catch (SQLException sQLException) {
/* 151 */       DbException.traceThrowable(sQLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private synchronized void stopManagementDb() {
/* 156 */     if (this.managementDb != null) {
/*     */       try {
/* 158 */         this.managementDb.close();
/* 159 */       } catch (SQLException sQLException) {
/* 160 */         DbException.traceThrowable(sQLException);
/*     */       } 
/* 162 */       this.managementDb = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(String... paramVarArgs) {
/* 168 */     this.port = 9092;
/* 169 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/* 170 */       String str = paramVarArgs[b];
/* 171 */       if (Tool.isOption(str, "-trace")) {
/* 172 */         this.trace = true;
/* 173 */       } else if (Tool.isOption(str, "-tcpSSL")) {
/* 174 */         this.ssl = true;
/* 175 */       } else if (Tool.isOption(str, "-tcpPort")) {
/* 176 */         this.port = Integer.decode(paramVarArgs[++b]).intValue();
/* 177 */         this.portIsSet = true;
/* 178 */       } else if (Tool.isOption(str, "-tcpPassword")) {
/* 179 */         this.managementPassword = paramVarArgs[++b];
/* 180 */       } else if (Tool.isOption(str, "-baseDir")) {
/* 181 */         this.baseDir = paramVarArgs[++b];
/* 182 */       } else if (Tool.isOption(str, "-key")) {
/* 183 */         this.key = paramVarArgs[++b];
/* 184 */         this.keyDatabase = paramVarArgs[++b];
/* 185 */       } else if (Tool.isOption(str, "-tcpAllowOthers")) {
/* 186 */         this.allowOthers = true;
/* 187 */       } else if (Tool.isOption(str, "-tcpDaemon")) {
/* 188 */         this.isDaemon = true;
/* 189 */       } else if (Tool.isOption(str, "-ifExists")) {
/* 190 */         this.ifExists = true;
/*     */       } 
/*     */     } 
/* 193 */     Driver.load();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getURL() {
/* 198 */     return (this.ssl ? "ssl" : "tcp") + "://" + NetUtils.getLocalAddress() + ":" + this.port;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 203 */     return this.port;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean allow(Socket paramSocket) {
/* 214 */     if (this.allowOthers) {
/* 215 */       return true;
/*     */     }
/*     */     try {
/* 218 */       return NetUtils.isLocalAddress(paramSocket);
/* 219 */     } catch (UnknownHostException unknownHostException) {
/* 220 */       traceError(unknownHostException);
/* 221 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void start() throws SQLException {
/* 227 */     this.stop = false;
/*     */     try {
/* 229 */       this.serverSocket = NetUtils.createServerSocket(this.port, this.ssl);
/* 230 */     } catch (DbException dbException) {
/* 231 */       if (!this.portIsSet) {
/* 232 */         this.serverSocket = NetUtils.createServerSocket(0, this.ssl);
/*     */       } else {
/* 234 */         throw dbException;
/*     */       } 
/*     */     } 
/* 237 */     this.port = this.serverSocket.getLocalPort();
/* 238 */     initManagementDb();
/*     */   }
/*     */ 
/*     */   
/*     */   public void listen() {
/* 243 */     this.listenerThread = Thread.currentThread();
/* 244 */     String str = this.listenerThread.getName();
/*     */     try {
/* 246 */       while (!this.stop) {
/* 247 */         Socket socket = this.serverSocket.accept();
/* 248 */         TcpServerThread tcpServerThread = new TcpServerThread(socket, this, this.nextThreadId++);
/* 249 */         this.running.add(tcpServerThread);
/* 250 */         Thread thread = new Thread(tcpServerThread, str + " thread");
/* 251 */         thread.setDaemon(this.isDaemon);
/* 252 */         tcpServerThread.setThread(thread);
/* 253 */         thread.start();
/*     */       } 
/* 255 */       this.serverSocket = NetUtils.closeSilently(this.serverSocket);
/* 256 */     } catch (Exception exception) {
/* 257 */       if (!this.stop) {
/* 258 */         DbException.traceThrowable(exception);
/*     */       }
/*     */     } 
/* 261 */     stopManagementDb();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean isRunning(boolean paramBoolean) {
/* 266 */     if (this.serverSocket == null) {
/* 267 */       return false;
/*     */     }
/*     */     try {
/* 270 */       Socket socket = NetUtils.createLoopbackSocket(this.port, this.ssl);
/* 271 */       socket.close();
/* 272 */       return true;
/* 273 */     } catch (Exception exception) {
/* 274 */       if (paramBoolean) {
/* 275 */         traceError(exception);
/*     */       }
/* 277 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 286 */     SERVERS.remove(Integer.valueOf(this.port));
/* 287 */     if (!this.stop) {
/* 288 */       stopManagementDb();
/* 289 */       this.stop = true;
/* 290 */       if (this.serverSocket != null) {
/*     */         try {
/* 292 */           this.serverSocket.close();
/* 293 */         } catch (IOException iOException) {
/* 294 */           DbException.traceThrowable(iOException);
/* 295 */         } catch (NullPointerException nullPointerException) {}
/*     */ 
/*     */         
/* 298 */         this.serverSocket = null;
/*     */       } 
/* 300 */       if (this.listenerThread != null) {
/*     */         try {
/* 302 */           this.listenerThread.join(1000L);
/* 303 */         } catch (InterruptedException interruptedException) {
/* 304 */           DbException.traceThrowable(interruptedException);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 309 */     for (TcpServerThread tcpServerThread : New.arrayList(this.running)) {
/* 310 */       if (tcpServerThread != null) {
/* 311 */         tcpServerThread.close();
/*     */         try {
/* 313 */           tcpServerThread.getThread().join(100L);
/* 314 */         } catch (Exception exception) {
/* 315 */           DbException.traceThrowable(exception);
/*     */         } 
/*     */       } 
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
/*     */   public static void stopServer(int paramInt1, String paramString, int paramInt2) {
/* 330 */     if (paramInt1 == 0) {
/* 331 */       Integer[] arrayOfInteger; int i; byte b; for (arrayOfInteger = (Integer[])SERVERS.keySet().toArray((Object[])new Integer[0]), i = arrayOfInteger.length, b = 0; b < i; ) { int j = arrayOfInteger[b].intValue();
/* 332 */         if (j != 0)
/* 333 */           stopServer(j, paramString, paramInt2); 
/*     */         b++; }
/*     */       
/*     */       return;
/*     */     } 
/* 338 */     TcpServer tcpServer = SERVERS.get(Integer.valueOf(paramInt1));
/* 339 */     if (tcpServer == null) {
/*     */       return;
/*     */     }
/* 342 */     if (!tcpServer.managementPassword.equals(paramString)) {
/*     */       return;
/*     */     }
/* 345 */     if (paramInt2 == 0) {
/* 346 */       tcpServer.stopManagementDb();
/* 347 */       tcpServer.stop = true;
/*     */       try {
/* 349 */         Socket socket = NetUtils.createLoopbackSocket(paramInt1, false);
/* 350 */         socket.close();
/* 351 */       } catch (Exception exception) {}
/*     */     
/*     */     }
/* 354 */     else if (paramInt2 == 1) {
/* 355 */       tcpServer.stop();
/*     */     } 
/* 357 */     tcpServer.shutdown();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void remove(TcpServerThread paramTcpServerThread) {
/* 366 */     this.running.remove(paramTcpServerThread);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getBaseDir() {
/* 375 */     return this.baseDir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void trace(String paramString) {
/* 384 */     if (this.trace) {
/* 385 */       System.out.println(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void traceError(Throwable paramThrowable) {
/* 394 */     if (this.trace) {
/* 395 */       paramThrowable.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getAllowOthers() {
/* 401 */     return this.allowOthers;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType() {
/* 406 */     return "TCP";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 411 */     return "H2 TCP Server";
/*     */   }
/*     */   
/*     */   boolean getIfExists() {
/* 415 */     return this.ifExists;
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
/*     */   public static synchronized void shutdown(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) throws SQLException {
/*     */     try {
/* 430 */       int i = 9092;
/* 431 */       int j = paramString1.lastIndexOf(':');
/* 432 */       if (j >= 0) {
/* 433 */         String str1 = paramString1.substring(j + 1);
/* 434 */         if (StringUtils.isNumber(str1)) {
/* 435 */           i = Integer.decode(str1).intValue();
/*     */         }
/*     */       } 
/* 438 */       String str = getManagementDbName(i);
/*     */       try {
/* 440 */         Driver.load();
/* 441 */       } catch (Throwable throwable) {
/* 442 */         throw DbException.convert(throwable);
/*     */       } 
/* 444 */       for (byte b = 0; b < 2; b++) {
/* 445 */         PreparedStatement preparedStatement; Connection connection = null;
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
/*     */       }
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
/*     */     }
/* 474 */     catch (Exception exception) {
/* 475 */       throw DbException.toSQLException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void cancelStatement(String paramString, int paramInt) {
/* 486 */     for (TcpServerThread tcpServerThread : New.arrayList(this.running)) {
/* 487 */       if (tcpServerThread != null) {
/* 488 */         tcpServerThread.cancelStatement(paramString, paramInt);
/*     */       }
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
/*     */   public String checkKeyAndGetDatabaseName(String paramString) {
/* 503 */     if (this.key == null) {
/* 504 */       return paramString;
/*     */     }
/* 506 */     if (this.key.equals(paramString)) {
/* 507 */       return this.keyDatabase;
/*     */     }
/* 509 */     throw DbException.get(28000);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDaemon() {
/* 514 */     return this.isDaemon;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\TcpServer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */