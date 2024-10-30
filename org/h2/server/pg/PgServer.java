/*     */ package org.h2.server.pg;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.h2.Driver;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.server.Service;
/*     */ import org.h2.util.NetUtils;
/*     */ import org.h2.util.New;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PgServer
/*     */   implements Service
/*     */ {
/*     */   public static final int DEFAULT_PORT = 5435;
/*     */   public static final int PG_TYPE_VARCHAR = 1043;
/*     */   public static final int PG_TYPE_INT2VECTOR = 22;
/*     */   public static final int PG_TYPE_BOOL = 16;
/*     */   public static final int PG_TYPE_BYTEA = 17;
/*     */   public static final int PG_TYPE_BPCHAR = 1042;
/*     */   public static final int PG_TYPE_INT8 = 20;
/*     */   public static final int PG_TYPE_INT2 = 21;
/*     */   public static final int PG_TYPE_INT4 = 23;
/*     */   public static final int PG_TYPE_TEXT = 25;
/*     */   public static final int PG_TYPE_OID = 26;
/*     */   public static final int PG_TYPE_FLOAT4 = 700;
/*     */   public static final int PG_TYPE_FLOAT8 = 701;
/*     */   public static final int PG_TYPE_UNKNOWN = 705;
/*     */   public static final int PG_TYPE_TEXTARRAY = 1009;
/*     */   public static final int PG_TYPE_DATE = 1082;
/*     */   public static final int PG_TYPE_TIME = 1083;
/*     */   public static final int PG_TYPE_TIMESTAMP_NO_TMZONE = 1114;
/*     */   public static final int PG_TYPE_NUMERIC = 1700;
/*  75 */   private final HashSet<Integer> typeSet = New.hashSet();
/*     */   
/*  77 */   private int port = 5435;
/*     */   private boolean portIsSet;
/*     */   private boolean stop;
/*     */   private boolean trace;
/*     */   private ServerSocket serverSocket;
/*  82 */   private final Set<PgServerThread> running = Collections.synchronizedSet(new HashSet<>());
/*     */   
/*  84 */   private final AtomicInteger pid = new AtomicInteger();
/*     */   private String baseDir;
/*     */   private boolean allowOthers;
/*     */   private boolean isDaemon;
/*     */   private boolean ifExists;
/*     */   private String key;
/*     */   private String keyDatabase;
/*     */   
/*     */   public void init(String... paramVarArgs) {
/*  93 */     this.port = 5435;
/*  94 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  95 */       String str = paramVarArgs[b];
/*  96 */       if (Tool.isOption(str, "-trace")) {
/*  97 */         this.trace = true;
/*  98 */       } else if (Tool.isOption(str, "-pgPort")) {
/*  99 */         this.port = Integer.decode(paramVarArgs[++b]).intValue();
/* 100 */         this.portIsSet = true;
/* 101 */       } else if (Tool.isOption(str, "-baseDir")) {
/* 102 */         this.baseDir = paramVarArgs[++b];
/* 103 */       } else if (Tool.isOption(str, "-pgAllowOthers")) {
/* 104 */         this.allowOthers = true;
/* 105 */       } else if (Tool.isOption(str, "-pgDaemon")) {
/* 106 */         this.isDaemon = true;
/* 107 */       } else if (Tool.isOption(str, "-ifExists")) {
/* 108 */         this.ifExists = true;
/* 109 */       } else if (Tool.isOption(str, "-key")) {
/* 110 */         this.key = paramVarArgs[++b];
/* 111 */         this.keyDatabase = paramVarArgs[++b];
/*     */       } 
/*     */     } 
/* 114 */     Driver.load();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getTrace() {
/* 120 */     return this.trace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void trace(String paramString) {
/* 129 */     if (this.trace) {
/* 130 */       System.out.println(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void remove(PgServerThread paramPgServerThread) {
/* 140 */     this.running.remove(paramPgServerThread);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void traceError(Exception paramException) {
/* 149 */     if (this.trace) {
/* 150 */       paramException.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getURL() {
/* 156 */     return "pg://" + NetUtils.getLocalAddress() + ":" + this.port;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 161 */     return this.port;
/*     */   }
/*     */   
/*     */   private boolean allow(Socket paramSocket) {
/* 165 */     if (this.allowOthers) {
/* 166 */       return true;
/*     */     }
/*     */     try {
/* 169 */       return NetUtils.isLocalAddress(paramSocket);
/* 170 */     } catch (UnknownHostException unknownHostException) {
/* 171 */       traceError(unknownHostException);
/* 172 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/* 178 */     this.stop = false;
/*     */     try {
/* 180 */       this.serverSocket = NetUtils.createServerSocket(this.port, false);
/* 181 */     } catch (DbException dbException) {
/* 182 */       if (!this.portIsSet) {
/* 183 */         this.serverSocket = NetUtils.createServerSocket(0, false);
/*     */       } else {
/* 185 */         throw dbException;
/*     */       } 
/*     */     } 
/* 188 */     this.port = this.serverSocket.getLocalPort();
/*     */   }
/*     */ 
/*     */   
/*     */   public void listen() {
/* 193 */     String str = Thread.currentThread().getName();
/*     */     try {
/* 195 */       while (!this.stop) {
/* 196 */         Socket socket = this.serverSocket.accept();
/* 197 */         if (!allow(socket)) {
/* 198 */           trace("Connection not allowed");
/* 199 */           socket.close(); continue;
/*     */         } 
/* 201 */         PgServerThread pgServerThread = new PgServerThread(socket, this);
/* 202 */         this.running.add(pgServerThread);
/* 203 */         pgServerThread.setProcessId(this.pid.incrementAndGet());
/* 204 */         Thread thread = new Thread(pgServerThread, str + " thread");
/* 205 */         thread.setDaemon(this.isDaemon);
/* 206 */         pgServerThread.setThread(thread);
/* 207 */         thread.start();
/*     */       }
/*     */     
/* 210 */     } catch (Exception exception) {
/* 211 */       if (!this.stop) {
/* 212 */         exception.printStackTrace();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 220 */     if (!this.stop) {
/* 221 */       this.stop = true;
/* 222 */       if (this.serverSocket != null) {
/*     */         try {
/* 224 */           this.serverSocket.close();
/* 225 */         } catch (IOException iOException) {
/*     */           
/* 227 */           iOException.printStackTrace();
/*     */         } 
/* 229 */         this.serverSocket = null;
/*     */       } 
/*     */     } 
/*     */     
/* 233 */     for (PgServerThread pgServerThread : New.arrayList(this.running)) {
/* 234 */       pgServerThread.close();
/*     */       try {
/* 236 */         Thread thread = pgServerThread.getThread();
/* 237 */         if (thread != null) {
/* 238 */           thread.join(100L);
/*     */         }
/* 240 */       } catch (Exception exception) {
/*     */         
/* 242 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRunning(boolean paramBoolean) {
/* 249 */     if (this.serverSocket == null) {
/* 250 */       return false;
/*     */     }
/*     */     try {
/* 253 */       Socket socket = NetUtils.createLoopbackSocket(this.serverSocket.getLocalPort(), false);
/* 254 */       socket.close();
/* 255 */       return true;
/* 256 */     } catch (Exception exception) {
/* 257 */       if (paramBoolean) {
/* 258 */         traceError(exception);
/*     */       }
/* 260 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PgServerThread getThread(int paramInt) {
/* 271 */     for (PgServerThread pgServerThread : New.arrayList(this.running)) {
/* 272 */       if (pgServerThread.getProcessId() == paramInt) {
/* 273 */         return pgServerThread;
/*     */       }
/*     */     } 
/* 276 */     return null;
/*     */   }
/*     */   
/*     */   String getBaseDir() {
/* 280 */     return this.baseDir;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getAllowOthers() {
/* 285 */     return this.allowOthers;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType() {
/* 290 */     return "PG";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 295 */     return "H2 PG Server";
/*     */   }
/*     */   
/*     */   boolean getIfExists() {
/* 299 */     return this.ifExists;
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
/*     */   public static String getIndexColumn(Connection paramConnection, int paramInt, Integer paramInteger, Boolean paramBoolean) throws SQLException {
/* 316 */     if (paramInteger == null || paramInteger.intValue() == 0) {
/* 317 */       PreparedStatement preparedStatement1 = paramConnection.prepareStatement("select sql from information_schema.indexes where id=?");
/*     */       
/* 319 */       preparedStatement1.setInt(1, paramInt);
/* 320 */       ResultSet resultSet1 = preparedStatement1.executeQuery();
/* 321 */       if (resultSet1.next()) {
/* 322 */         return resultSet1.getString(1);
/*     */       }
/* 324 */       return "";
/*     */     } 
/* 326 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("select column_name from information_schema.indexes where id=? and ordinal_position=?");
/*     */ 
/*     */     
/* 329 */     preparedStatement.setInt(1, paramInt);
/* 330 */     preparedStatement.setInt(2, paramInteger.intValue());
/* 331 */     ResultSet resultSet = preparedStatement.executeQuery();
/* 332 */     if (resultSet.next()) {
/* 333 */       return resultSet.getString(1);
/*     */     }
/* 335 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getCurrentSchema(Connection paramConnection) throws SQLException {
/* 346 */     ResultSet resultSet = paramConnection.createStatement().executeQuery("call schema()");
/* 347 */     resultSet.next();
/* 348 */     return resultSet.getString(1);
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
/*     */   public static int getOid(Connection paramConnection, String paramString) throws SQLException {
/* 360 */     if (paramString.startsWith("\"") && paramString.endsWith("\"")) {
/* 361 */       paramString = paramString.substring(1, paramString.length() - 1);
/*     */     }
/* 363 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("select oid from pg_class where relName = ?");
/*     */     
/* 365 */     preparedStatement.setString(1, paramString);
/* 366 */     ResultSet resultSet = preparedStatement.executeQuery();
/* 367 */     if (!resultSet.next()) {
/* 368 */       return 0;
/*     */     }
/* 370 */     return resultSet.getInt(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getEncodingName(int paramInt) {
/* 381 */     switch (paramInt) {
/*     */       case 0:
/* 383 */         return "SQL_ASCII";
/*     */       case 6:
/* 385 */         return "UTF8";
/*     */       case 8:
/* 387 */         return "LATIN1";
/*     */     } 
/* 389 */     return (paramInt < 40) ? "UTF8" : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getVersion() {
/* 400 */     return "PostgreSQL 8.1.4  server protocol using H2 " + Constants.getFullVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Timestamp getStartTime() {
/* 411 */     return new Timestamp(System.currentTimeMillis());
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
/*     */   public static String getUserById(Connection paramConnection, int paramInt) throws SQLException {
/* 423 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("SELECT NAME FROM INFORMATION_SCHEMA.USERS WHERE ID=?");
/*     */     
/* 425 */     preparedStatement.setInt(1, paramInt);
/* 426 */     ResultSet resultSet = preparedStatement.executeQuery();
/* 427 */     if (resultSet.next()) {
/* 428 */       return resultSet.getString(1);
/*     */     }
/* 430 */     return null;
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
/*     */   public static boolean hasDatabasePrivilege(int paramInt, String paramString) {
/* 442 */     return true;
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
/*     */   public static boolean hasTablePrivilege(String paramString1, String paramString2) {
/* 454 */     return true;
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
/*     */   public static int getCurrentTid(String paramString1, String paramString2) {
/* 466 */     return 1;
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
/*     */   public static String getPgExpr(String paramString, int paramInt) {
/* 479 */     return null;
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
/*     */   public static String formatType(Connection paramConnection, int paramInt1, int paramInt2) throws SQLException {
/* 493 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("select typname from pg_catalog.pg_type where oid = ? and typtypmod = ?");
/*     */     
/* 495 */     preparedStatement.setInt(1, paramInt1);
/* 496 */     preparedStatement.setInt(2, paramInt2);
/* 497 */     ResultSet resultSet = preparedStatement.executeQuery();
/* 498 */     if (resultSet.next()) {
/* 499 */       return resultSet.getString(1);
/*     */     }
/* 501 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int convertType(int paramInt) {
/* 511 */     switch (paramInt) {
/*     */       case 16:
/* 513 */         return 16;
/*     */       case 12:
/* 515 */         return 1043;
/*     */       case 2005:
/* 517 */         return 25;
/*     */       case 1:
/* 519 */         return 1042;
/*     */       case 5:
/* 521 */         return 21;
/*     */       case 4:
/* 523 */         return 23;
/*     */       case -5:
/* 525 */         return 20;
/*     */       case 3:
/* 527 */         return 1700;
/*     */       case 7:
/* 529 */         return 700;
/*     */       case 8:
/* 531 */         return 701;
/*     */       case 92:
/* 533 */         return 1083;
/*     */       case 91:
/* 535 */         return 1082;
/*     */       case 93:
/* 537 */         return 1114;
/*     */       case -3:
/* 539 */         return 17;
/*     */       case 2004:
/* 541 */         return 26;
/*     */       case 2003:
/* 543 */         return 1009;
/*     */     } 
/* 545 */     return 705;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   HashSet<Integer> getTypeSet() {
/* 555 */     return this.typeSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void checkType(int paramInt) {
/* 565 */     if (!this.typeSet.contains(Integer.valueOf(paramInt))) {
/* 566 */       trace("Unsupported type: " + paramInt);
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
/* 580 */     if (this.key == null) {
/* 581 */       return paramString;
/*     */     }
/* 583 */     if (this.key.equals(paramString)) {
/* 584 */       return this.keyDatabase;
/*     */     }
/* 586 */     throw DbException.get(28000);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDaemon() {
/* 591 */     return this.isDaemon;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\pg\PgServer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */