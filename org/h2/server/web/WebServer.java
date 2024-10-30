/*     */ package org.h2.server.web;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.TimeZone;
/*     */ import org.h2.Driver;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.server.Service;
/*     */ import org.h2.server.ShutdownHandler;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.NetUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.SortedProperties;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Tool;
/*     */ import org.h2.util.Utils;
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
/*     */ public class WebServer
/*     */   implements Service
/*     */ {
/*  49 */   static final String[][] LANGUAGES = new String[][] { { "cs", "Čeština" }, { "de", "Deutsch" }, { "en", "English" }, { "es", "Español" }, { "fr", "Français" }, { "hu", "Magyar" }, { "ko", "한국어" }, { "in", "Indonesia" }, { "it", "Italiano" }, { "ja", "日本語" }, { "nl", "Nederlands" }, { "pl", "Polski" }, { "pt_BR", "Português (Brasil)" }, { "pt_PT", "Português (Europeu)" }, { "ru", "русский" }, { "sk", "Slovensky" }, { "tr", "Türkçe" }, { "uk", "Українська" }, { "zh_CN", "中文 (简体)" }, { "zh_TW", "中文 (繁體)" } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String COMMAND_HISTORY = "commandHistory";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_LANGUAGE = "en";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   private static final String[] GENERIC = new String[] { "Generic JNDI Data Source|javax.naming.InitialContext|java:comp/env/jdbc/Test|sa", "Generic Firebird Server|org.firebirdsql.jdbc.FBDriver|jdbc:firebirdsql:localhost:c:/temp/firebird/test|sysdba", "Generic SQLite|org.sqlite.JDBC|jdbc:sqlite:test|sa", "Generic DB2|com.ibm.db2.jcc.DB2Driver|jdbc:db2://localhost/test|", "Generic Oracle|oracle.jdbc.driver.OracleDriver|jdbc:oracle:thin:@localhost:1521:XE|sa", "Generic MS SQL Server 2000|com.microsoft.jdbc.sqlserver.SQLServerDriver|jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=sqlexpress|sa", "Generic MS SQL Server 2005|com.microsoft.sqlserver.jdbc.SQLServerDriver|jdbc:sqlserver://localhost;DatabaseName=test|sa", "Generic PostgreSQL|org.postgresql.Driver|jdbc:postgresql:test|", "Generic MySQL|com.mysql.jdbc.Driver|jdbc:mysql://localhost:3306/test|", "Generic HSQLDB|org.hsqldb.jdbcDriver|jdbc:hsqldb:test;hsqldb.default_table_type=cached|sa", "Generic Derby (Server)|org.apache.derby.jdbc.ClientDriver|jdbc:derby://localhost:1527/test;create=true|sa", "Generic Derby (Embedded)|org.apache.derby.jdbc.EmbeddedDriver|jdbc:derby:test;create=true|sa", "Generic H2 (Server)|org.h2.Driver|jdbc:h2:tcp://localhost/~/test|sa", "Generic H2 (Embedded)|org.h2.Driver|jdbc:h2:~/test|sa" };
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
/*     */   private static int ticker;
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
/* 113 */   private static final long SESSION_TIMEOUT = SysProperties.CONSOLE_TIMEOUT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int port;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean allowOthers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isDaemon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   private final Set<WebThread> running = Collections.synchronizedSet(new HashSet<>());
/*     */   
/*     */   private boolean ssl;
/* 143 */   private final HashMap<String, ConnectionInfo> connInfoMap = New.hashMap();
/*     */   
/*     */   private long lastTimeoutCheck;
/* 146 */   private final HashMap<String, WebSession> sessions = New.hashMap();
/* 147 */   private final HashSet<String> languages = New.hashSet();
/*     */   private String startDateTime;
/*     */   private ServerSocket serverSocket;
/*     */   private String url;
/*     */   private ShutdownHandler shutdownHandler;
/*     */   private Thread listenerThread;
/*     */   private boolean ifExists;
/*     */   private boolean trace;
/*     */   private TranslateThread translateThread;
/*     */   private boolean allowChunked = true;
/* 157 */   private String serverPropertiesDir = "~";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String commandHistoryString;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   byte[] getFile(String paramString) throws IOException {
/* 168 */     trace("getFile <" + paramString + ">");
/* 169 */     byte[] arrayOfByte = Utils.getResource("/org/h2/server/web/res/" + paramString);
/* 170 */     if (arrayOfByte == null) {
/* 171 */       trace(" null");
/*     */     } else {
/* 173 */       trace(" size=" + arrayOfByte.length);
/*     */     } 
/* 175 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isSimpleName(String paramString) {
/* 186 */     for (char c : paramString.toCharArray()) {
/* 187 */       if (c != '.' && c != '_' && c != '-' && !Character.isLetterOrDigit(c)) {
/* 188 */         return false;
/*     */       }
/*     */     } 
/* 191 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void remove(WebThread paramWebThread) {
/* 200 */     this.running.remove(paramWebThread);
/*     */   }
/*     */   
/*     */   private static String generateSessionId() {
/* 204 */     byte[] arrayOfByte = MathUtils.secureRandomBytes(16);
/* 205 */     return StringUtils.convertBytesToHex(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WebSession getSession(String paramString) {
/* 215 */     long l = System.currentTimeMillis();
/* 216 */     if (this.lastTimeoutCheck + SESSION_TIMEOUT < l) {
/* 217 */       for (String str : New.arrayList(this.sessions.keySet())) {
/* 218 */         WebSession webSession1 = this.sessions.get(str);
/* 219 */         if (webSession1.lastAccess + SESSION_TIMEOUT < l) {
/* 220 */           trace("timeout for " + str);
/* 221 */           this.sessions.remove(str);
/*     */         } 
/*     */       } 
/* 224 */       this.lastTimeoutCheck = l;
/*     */     } 
/* 226 */     WebSession webSession = this.sessions.get(paramString);
/* 227 */     if (webSession != null) {
/* 228 */       webSession.lastAccess = System.currentTimeMillis();
/*     */     }
/* 230 */     return webSession;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WebSession createNewSession(String paramString) {
/*     */     while (true) {
/* 242 */       String str = generateSessionId();
/* 243 */       if (this.sessions.get(str) == null) {
/* 244 */         WebSession webSession = new WebSession(this);
/* 245 */         webSession.lastAccess = System.currentTimeMillis();
/* 246 */         webSession.put("sessionId", str);
/* 247 */         webSession.put("ip", paramString);
/* 248 */         webSession.put("language", "en");
/* 249 */         webSession.put("frame-border", "0");
/* 250 */         webSession.put("frameset-border", "4");
/* 251 */         this.sessions.put(str, webSession);
/*     */ 
/*     */         
/* 254 */         readTranslations(webSession, "en");
/* 255 */         return getSession(str);
/*     */       } 
/*     */     } 
/*     */   } String getStartDateTime() {
/* 259 */     if (this.startDateTime == null) {
/* 260 */       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", new Locale("en", ""));
/*     */       
/* 262 */       simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
/* 263 */       this.startDateTime = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
/*     */     } 
/* 265 */     return this.startDateTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(String... paramVarArgs) {
/* 271 */     for (byte b1 = 0; paramVarArgs != null && b1 < paramVarArgs.length; b1++) {
/* 272 */       if ("-properties".equals(paramVarArgs[b1])) {
/* 273 */         this.serverPropertiesDir = paramVarArgs[++b1];
/*     */       }
/*     */     } 
/* 276 */     Properties properties = loadProperties();
/* 277 */     this.port = SortedProperties.getIntProperty(properties, "webPort", 8082);
/*     */     
/* 279 */     this.ssl = SortedProperties.getBooleanProperty(properties, "webSSL", false);
/*     */     
/* 281 */     this.allowOthers = SortedProperties.getBooleanProperty(properties, "webAllowOthers", false);
/*     */     
/* 283 */     this.commandHistoryString = properties.getProperty("commandHistory");
/* 284 */     for (byte b2 = 0; paramVarArgs != null && b2 < paramVarArgs.length; b2++) {
/* 285 */       String str = paramVarArgs[b2];
/* 286 */       if (Tool.isOption(str, "-webPort")) {
/* 287 */         this.port = Integer.decode(paramVarArgs[++b2]).intValue();
/* 288 */       } else if (Tool.isOption(str, "-webSSL")) {
/* 289 */         this.ssl = true;
/* 290 */       } else if (Tool.isOption(str, "-webAllowOthers")) {
/* 291 */         this.allowOthers = true;
/* 292 */       } else if (Tool.isOption(str, "-webDaemon")) {
/* 293 */         this.isDaemon = true;
/* 294 */       } else if (Tool.isOption(str, "-baseDir")) {
/* 295 */         String str1 = paramVarArgs[++b2];
/* 296 */         SysProperties.setBaseDir(str1);
/* 297 */       } else if (Tool.isOption(str, "-ifExists")) {
/* 298 */         this.ifExists = true;
/* 299 */       } else if (Tool.isOption(str, "-properties")) {
/*     */         
/* 301 */         b2++;
/* 302 */       } else if (Tool.isOption(str, "-trace")) {
/* 303 */         this.trace = true;
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
/*     */ 
/*     */     
/* 319 */     for (String[] arrayOfString : LANGUAGES) {
/* 320 */       this.languages.add(arrayOfString[0]);
/*     */     }
/* 322 */     updateURL();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getURL() {
/* 327 */     updateURL();
/* 328 */     return this.url;
/*     */   }
/*     */   
/*     */   private void updateURL() {
/*     */     try {
/* 333 */       this.url = (this.ssl ? "https" : "http") + "://" + NetUtils.getLocalAddress() + ":" + this.port;
/*     */     }
/* 335 */     catch (NoClassDefFoundError noClassDefFoundError) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 342 */     this.serverSocket = NetUtils.createServerSocket(this.port, this.ssl);
/* 343 */     this.port = this.serverSocket.getLocalPort();
/* 344 */     updateURL();
/*     */   }
/*     */ 
/*     */   
/*     */   public void listen() {
/* 349 */     this.listenerThread = Thread.currentThread();
/*     */     try {
/* 351 */       while (this.serverSocket != null) {
/* 352 */         Socket socket = this.serverSocket.accept();
/* 353 */         WebThread webThread = new WebThread(socket, this);
/* 354 */         this.running.add(webThread);
/* 355 */         webThread.start();
/*     */       } 
/* 357 */     } catch (Exception exception) {
/* 358 */       trace(exception.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRunning(boolean paramBoolean) {
/* 364 */     if (this.serverSocket == null) {
/* 365 */       return false;
/*     */     }
/*     */     try {
/* 368 */       Socket socket = NetUtils.createLoopbackSocket(this.port, this.ssl);
/* 369 */       socket.close();
/* 370 */       return true;
/* 371 */     } catch (Exception exception) {
/* 372 */       if (paramBoolean) {
/* 373 */         traceError(exception);
/*     */       }
/* 375 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isStopped() {
/* 380 */     return (this.serverSocket == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 385 */     if (this.serverSocket != null) {
/*     */       try {
/* 387 */         this.serverSocket.close();
/* 388 */       } catch (IOException iOException) {
/* 389 */         traceError(iOException);
/*     */       } 
/* 391 */       this.serverSocket = null;
/*     */     } 
/* 393 */     if (this.listenerThread != null) {
/*     */       try {
/* 395 */         this.listenerThread.join(1000L);
/* 396 */       } catch (InterruptedException interruptedException) {
/* 397 */         DbException.traceThrowable(interruptedException);
/*     */       } 
/*     */     }
/*     */     
/* 401 */     for (WebSession webSession : New.arrayList(this.sessions.values())) {
/* 402 */       webSession.close();
/*     */     }
/* 404 */     for (WebThread webThread : New.arrayList(this.running)) {
/*     */       try {
/* 406 */         webThread.stopNow();
/* 407 */         webThread.join(100);
/* 408 */       } catch (Exception exception) {
/* 409 */         traceError(exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void trace(String paramString) {
/* 420 */     if (this.trace) {
/* 421 */       System.out.println(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void traceError(Throwable paramThrowable) {
/* 431 */     if (this.trace) {
/* 432 */       paramThrowable.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean supportsLanguage(String paramString) {
/* 443 */     return this.languages.contains(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void readTranslations(WebSession paramWebSession, String paramString) {
/*     */     SortedProperties sortedProperties;
/* 454 */     Properties properties = new Properties();
/*     */     try {
/* 456 */       trace("translation: " + paramString);
/* 457 */       byte[] arrayOfByte = getFile("_text_" + paramString + ".prop");
/* 458 */       trace("  " + new String(arrayOfByte));
/* 459 */       sortedProperties = SortedProperties.fromLines(new String(arrayOfByte, Constants.UTF8));
/*     */       
/* 461 */       for (Map.Entry<Object, Object> entry : sortedProperties.entrySet()) {
/* 462 */         String str = (String)entry.getValue();
/* 463 */         if (str.startsWith("#")) {
/* 464 */           entry.setValue(str.substring(1));
/*     */         }
/*     */       } 
/* 467 */     } catch (IOException iOException) {
/* 468 */       DbException.traceThrowable(iOException);
/*     */     } 
/* 470 */     paramWebSession.put("text", new HashMap<>((Map<?, ?>)sortedProperties));
/*     */   }
/*     */   
/*     */   ArrayList<HashMap<String, Object>> getSessions() {
/* 474 */     ArrayList<HashMap<String, Object>> arrayList = New.arrayList();
/* 475 */     for (WebSession webSession : this.sessions.values()) {
/* 476 */       arrayList.add(webSession.getInfo());
/*     */     }
/* 478 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType() {
/* 483 */     return "Web Console";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 488 */     return "H2 Console Server";
/*     */   }
/*     */   
/*     */   void setAllowOthers(boolean paramBoolean) {
/* 492 */     this.allowOthers = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getAllowOthers() {
/* 497 */     return this.allowOthers;
/*     */   }
/*     */   
/*     */   void setSSL(boolean paramBoolean) {
/* 501 */     this.ssl = paramBoolean;
/*     */   }
/*     */   
/*     */   void setPort(int paramInt) {
/* 505 */     this.port = paramInt;
/*     */   }
/*     */   
/*     */   boolean getSSL() {
/* 509 */     return this.ssl;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 514 */     return this.port;
/*     */   }
/*     */   
/*     */   public boolean isCommandHistoryAllowed() {
/* 518 */     return (this.commandHistoryString != null);
/*     */   }
/*     */   
/*     */   public void setCommandHistoryAllowed(boolean paramBoolean) {
/* 522 */     if (paramBoolean) {
/* 523 */       if (this.commandHistoryString == null) {
/* 524 */         this.commandHistoryString = "";
/*     */       }
/*     */     } else {
/* 527 */       this.commandHistoryString = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public ArrayList<String> getCommandHistoryList() {
/* 532 */     ArrayList<String> arrayList = New.arrayList();
/* 533 */     if (this.commandHistoryString == null) {
/* 534 */       return arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 539 */     StringBuilder stringBuilder = new StringBuilder();
/* 540 */     for (byte b = 0;; b++) {
/* 541 */       if (b == this.commandHistoryString.length() || this.commandHistoryString.charAt(b) == ';') {
/*     */         
/* 543 */         if (stringBuilder.length() > 0) {
/* 544 */           arrayList.add(stringBuilder.toString());
/* 545 */           stringBuilder.delete(0, stringBuilder.length());
/*     */         } 
/* 547 */         if (b == this.commandHistoryString.length()) {
/*     */           break;
/*     */         }
/* 550 */       } else if (this.commandHistoryString.charAt(b) == '\\' && b < this.commandHistoryString.length() - 1) {
/*     */         
/* 552 */         stringBuilder.append(this.commandHistoryString.charAt(++b));
/*     */       } else {
/* 554 */         stringBuilder.append(this.commandHistoryString.charAt(b));
/*     */       } 
/*     */     } 
/* 557 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveCommandHistoryList(ArrayList<String> paramArrayList) {
/* 566 */     StringBuilder stringBuilder = new StringBuilder();
/* 567 */     for (String str : paramArrayList) {
/* 568 */       if (stringBuilder.length() > 0) {
/* 569 */         stringBuilder.append(';');
/*     */       }
/* 571 */       stringBuilder.append(str.replace("\\", "\\\\").replace(";", "\\;"));
/*     */     } 
/* 573 */     this.commandHistoryString = stringBuilder.toString();
/* 574 */     saveProperties(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ConnectionInfo getSetting(String paramString) {
/* 584 */     return this.connInfoMap.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void updateSetting(ConnectionInfo paramConnectionInfo) {
/* 593 */     this.connInfoMap.put(paramConnectionInfo.name, paramConnectionInfo);
/* 594 */     paramConnectionInfo.lastAccess = ticker++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeSetting(String paramString) {
/* 603 */     this.connInfoMap.remove(paramString);
/*     */   }
/*     */   
/*     */   private Properties loadProperties() {
/*     */     try {
/* 608 */       if ("null".equals(this.serverPropertiesDir)) {
/* 609 */         return new Properties();
/*     */       }
/* 611 */       return (Properties)SortedProperties.loadProperties(this.serverPropertiesDir + "/" + ".h2.server.properties");
/*     */     }
/* 613 */     catch (Exception exception) {
/* 614 */       DbException.traceThrowable(exception);
/* 615 */       return new Properties();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String[] getSettingNames() {
/* 625 */     ArrayList<ConnectionInfo> arrayList = getSettings();
/* 626 */     String[] arrayOfString = new String[arrayList.size()];
/* 627 */     for (byte b = 0; b < arrayList.size(); b++) {
/* 628 */       arrayOfString[b] = ((ConnectionInfo)arrayList.get(b)).name;
/*     */     }
/* 630 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized ArrayList<ConnectionInfo> getSettings() {
/* 639 */     ArrayList<ConnectionInfo> arrayList = New.arrayList();
/* 640 */     if (this.connInfoMap.size() == 0) {
/* 641 */       Properties properties = loadProperties();
/* 642 */       if (properties.size() == 0) {
/* 643 */         for (String str : GENERIC) {
/* 644 */           ConnectionInfo connectionInfo = new ConnectionInfo(str);
/* 645 */           arrayList.add(connectionInfo);
/* 646 */           updateSetting(connectionInfo);
/*     */         } 
/*     */       } else {
/* 649 */         for (byte b = 0;; b++) {
/* 650 */           String str = properties.getProperty(String.valueOf(b));
/* 651 */           if (str == null) {
/*     */             break;
/*     */           }
/* 654 */           ConnectionInfo connectionInfo = new ConnectionInfo(str);
/* 655 */           arrayList.add(connectionInfo);
/* 656 */           updateSetting(connectionInfo);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 660 */       arrayList.addAll(this.connInfoMap.values());
/*     */     } 
/* 662 */     Collections.sort(arrayList);
/* 663 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void saveProperties(Properties paramProperties) {
/*     */     try {
/*     */       SortedProperties sortedProperties;
/* 673 */       if (paramProperties == null) {
/* 674 */         Properties properties = loadProperties();
/* 675 */         sortedProperties = new SortedProperties();
/* 676 */         sortedProperties.setProperty("webPort", "" + SortedProperties.getIntProperty(properties, "webPort", this.port));
/*     */ 
/*     */         
/* 679 */         sortedProperties.setProperty("webAllowOthers", "" + SortedProperties.getBooleanProperty(properties, "webAllowOthers", this.allowOthers));
/*     */ 
/*     */         
/* 682 */         sortedProperties.setProperty("webSSL", "" + SortedProperties.getBooleanProperty(properties, "webSSL", this.ssl));
/*     */ 
/*     */         
/* 685 */         if (this.commandHistoryString != null) {
/* 686 */           sortedProperties.setProperty("commandHistory", this.commandHistoryString);
/*     */         }
/*     */       } 
/* 689 */       ArrayList<ConnectionInfo> arrayList = getSettings();
/* 690 */       int i = arrayList.size();
/* 691 */       for (byte b = 0; b < i; b++) {
/* 692 */         ConnectionInfo connectionInfo = arrayList.get(b);
/* 693 */         if (connectionInfo != null) {
/* 694 */           sortedProperties.setProperty(String.valueOf(i - b - 1), connectionInfo.getString());
/*     */         }
/*     */       } 
/* 697 */       if (!"null".equals(this.serverPropertiesDir)) {
/* 698 */         OutputStream outputStream = FileUtils.newOutputStream(this.serverPropertiesDir + "/" + ".h2.server.properties", false);
/*     */         
/* 700 */         sortedProperties.store(outputStream, "H2 Server Properties");
/* 701 */         outputStream.close();
/*     */       } 
/* 703 */     } catch (Exception exception) {
/* 704 */       DbException.traceThrowable(exception);
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
/*     */   Connection getConnection(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/* 719 */     paramString1 = paramString1.trim();
/* 720 */     paramString2 = paramString2.trim();
/* 721 */     Driver.load();
/* 722 */     Properties properties = new Properties();
/* 723 */     properties.setProperty("user", paramString3.trim());
/*     */ 
/*     */     
/* 726 */     properties.setProperty("password", paramString4);
/* 727 */     if (paramString2.startsWith("jdbc:h2:")) {
/* 728 */       if (this.ifExists) {
/* 729 */         paramString2 = paramString2 + ";IFEXISTS=TRUE";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 735 */       return Driver.load().connect(paramString2, properties);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 744 */     return JdbcUtils.getConnection(paramString1, paramString2, properties);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void shutdown() {
/* 751 */     if (this.shutdownHandler != null) {
/* 752 */       this.shutdownHandler.shutdown();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setShutdownHandler(ShutdownHandler paramShutdownHandler) {
/* 757 */     this.shutdownHandler = paramShutdownHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String addSession(Connection paramConnection) throws SQLException {
/* 767 */     WebSession webSession = createNewSession("local");
/* 768 */     webSession.setShutdownServerOnDisconnect();
/* 769 */     webSession.setConnection(paramConnection);
/* 770 */     webSession.put("url", paramConnection.getMetaData().getURL());
/* 771 */     String str = (String)webSession.get("sessionId");
/* 772 */     return this.url + "/frame.jsp?jsessionid=" + str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class TranslateThread
/*     */     extends Thread
/*     */   {
/* 781 */     private final File file = new File("translation.properties");
/*     */     private final Map<Object, Object> translation;
/*     */     private volatile boolean stopNow;
/*     */     
/*     */     TranslateThread(Map<Object, Object> param1Map) {
/* 786 */       this.translation = param1Map;
/*     */     }
/*     */     
/*     */     public String getFileName() {
/* 790 */       return this.file.getAbsolutePath();
/*     */     }
/*     */     
/*     */     public void stopNow() {
/* 794 */       this.stopNow = true;
/*     */       try {
/* 796 */         join();
/* 797 */       } catch (InterruptedException interruptedException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 804 */       while (!this.stopNow) {
/*     */         try {
/* 806 */           SortedProperties sortedProperties = new SortedProperties();
/* 807 */           if (this.file.exists()) {
/* 808 */             InputStream inputStream = FileUtils.newInputStream(this.file.getName());
/* 809 */             sortedProperties.load(inputStream);
/* 810 */             this.translation.putAll((Map<?, ?>)sortedProperties);
/*     */           } else {
/* 812 */             OutputStream outputStream = FileUtils.newOutputStream(this.file.getName(), false);
/* 813 */             sortedProperties.putAll(this.translation);
/* 814 */             sortedProperties.store(outputStream, "Translation");
/*     */           } 
/* 816 */           Thread.sleep(1000L);
/* 817 */         } catch (Exception exception) {
/* 818 */           WebServer.this.traceError(exception);
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
/*     */   String startTranslate(Map<Object, Object> paramMap) {
/* 832 */     if (this.translateThread != null) {
/* 833 */       this.translateThread.stopNow();
/*     */     }
/* 835 */     this.translateThread = new TranslateThread(paramMap);
/* 836 */     this.translateThread.setDaemon(true);
/* 837 */     this.translateThread.start();
/* 838 */     return this.translateThread.getFileName();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDaemon() {
/* 843 */     return this.isDaemon;
/*     */   }
/*     */   
/*     */   void setAllowChunked(boolean paramBoolean) {
/* 847 */     this.allowChunked = paramBoolean;
/*     */   }
/*     */   
/*     */   boolean getAllowChunked() {
/* 851 */     return this.allowChunked;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\web\WebServer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */