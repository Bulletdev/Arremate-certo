/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.server.Service;
/*     */ import org.h2.server.ShutdownHandler;
/*     */ import org.h2.server.TcpServer;
/*     */ import org.h2.server.pg.PgServer;
/*     */ import org.h2.server.web.WebServer;
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
/*     */ public class Server
/*     */   extends Tool
/*     */   implements Runnable, ShutdownHandler
/*     */ {
/*     */   private final Service service;
/*     */   private Server web;
/*     */   private Server tcp;
/*     */   private Server pg;
/*     */   private ShutdownHandler shutdownHandler;
/*     */   private boolean started;
/*     */   
/*     */   public Server() {
/*  37 */     this.service = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Server(Service paramService, String... paramVarArgs) throws SQLException {
/*  47 */     verifyArgs(paramVarArgs);
/*  48 */     this.service = paramService;
/*     */     try {
/*  50 */       paramService.init(paramVarArgs);
/*  51 */     } catch (Exception exception) {
/*  52 */       throw DbException.toSQLException(exception);
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
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/* 118 */     (new Server()).runTool(paramVarArgs);
/*     */   }
/*     */   
/*     */   private void verifyArgs(String... paramVarArgs) throws SQLException {
/* 122 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/* 123 */       String str = paramVarArgs[b];
/* 124 */       if (str != null)
/*     */       {
/* 126 */         if (!"-?".equals(str) && !"-help".equals(str))
/*     */         {
/* 128 */           if (str.startsWith("-web")) {
/* 129 */             if (!"-web".equals(str))
/*     */             {
/* 131 */               if (!"-webAllowOthers".equals(str))
/*     */               {
/* 133 */                 if (!"-webDaemon".equals(str))
/*     */                 {
/* 135 */                   if (!"-webSSL".equals(str))
/*     */                   {
/* 137 */                     if ("-webPort".equals(str)) {
/* 138 */                       b++;
/*     */                     } else {
/* 140 */                       throwUnsupportedOption(str);
/*     */                     }  }  }  }  } 
/* 142 */           } else if (!"-browser".equals(str)) {
/*     */             
/* 144 */             if (str.startsWith("-tcp")) {
/* 145 */               if (!"-tcp".equals(str))
/*     */               {
/* 147 */                 if (!"-tcpAllowOthers".equals(str))
/*     */                 {
/* 149 */                   if (!"-tcpDaemon".equals(str))
/*     */                   {
/* 151 */                     if (!"-tcpSSL".equals(str))
/*     */                     {
/* 153 */                       if ("-tcpPort".equals(str)) {
/* 154 */                         b++;
/* 155 */                       } else if ("-tcpPassword".equals(str)) {
/* 156 */                         b++;
/* 157 */                       } else if ("-tcpShutdown".equals(str)) {
/* 158 */                         b++;
/* 159 */                       } else if (!"-tcpShutdownForce".equals(str)) {
/*     */ 
/*     */                         
/* 162 */                         throwUnsupportedOption(str);
/*     */                       }  }  }  }  } 
/* 164 */             } else if (str.startsWith("-pg")) {
/* 165 */               if (!"-pg".equals(str))
/*     */               {
/* 167 */                 if (!"-pgAllowOthers".equals(str))
/*     */                 {
/* 169 */                   if (!"-pgDaemon".equals(str))
/*     */                   {
/* 171 */                     if ("-pgPort".equals(str)) {
/* 172 */                       b++;
/*     */                     } else {
/* 174 */                       throwUnsupportedOption(str);
/*     */                     }  }  }  } 
/* 176 */             } else if (str.startsWith("-ftp")) {
/* 177 */               if ("-ftpPort".equals(str)) {
/* 178 */                 b++;
/* 179 */               } else if ("-ftpDir".equals(str)) {
/* 180 */                 b++;
/* 181 */               } else if ("-ftpRead".equals(str)) {
/* 182 */                 b++;
/* 183 */               } else if ("-ftpWrite".equals(str)) {
/* 184 */                 b++;
/* 185 */               } else if ("-ftpWritePassword".equals(str)) {
/* 186 */                 b++;
/* 187 */               } else if (!"-ftpTask".equals(str)) {
/*     */ 
/*     */                 
/* 190 */                 throwUnsupportedOption(str);
/*     */               } 
/* 192 */             } else if ("-properties".equals(str)) {
/* 193 */               b++;
/* 194 */             } else if (!"-trace".equals(str)) {
/*     */               
/* 196 */               if (!"-ifExists".equals(str))
/*     */               {
/* 198 */                 if ("-baseDir".equals(str)) {
/* 199 */                   b++;
/* 200 */                 } else if ("-key".equals(str)) {
/* 201 */                   b += 2;
/* 202 */                 } else if (!"-tool".equals(str)) {
/*     */ 
/*     */                   
/* 205 */                   throwUnsupportedOption(str);
/*     */                 }  } 
/*     */             } 
/*     */           }  }  } 
/*     */     } 
/*     */   }
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/* 212 */     boolean bool1 = false, bool2 = false, bool3 = false;
/* 213 */     boolean bool4 = false;
/* 214 */     boolean bool5 = false, bool6 = false;
/* 215 */     String str1 = "";
/* 216 */     String str2 = "";
/* 217 */     boolean bool7 = true;
/* 218 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/* 219 */       String str = paramVarArgs[b];
/* 220 */       if (str != null) {
/*     */         
/* 222 */         if ("-?".equals(str) || "-help".equals(str)) {
/* 223 */           showUsage(); return;
/*     */         } 
/* 225 */         if (str.startsWith("-web")) {
/* 226 */           if ("-web".equals(str)) {
/* 227 */             bool7 = false;
/* 228 */             bool3 = true;
/* 229 */           } else if (!"-webAllowOthers".equals(str)) {
/*     */             
/* 231 */             if (!"-webDaemon".equals(str))
/*     */             {
/* 233 */               if (!"-webSSL".equals(str))
/*     */               {
/* 235 */                 if ("-webPort".equals(str))
/* 236 */                 { b++; }
/*     */                 else
/* 238 */                 { showUsageAndThrowUnsupportedOption(str); }  }  } 
/*     */           } 
/* 240 */         } else if ("-browser".equals(str)) {
/* 241 */           bool7 = false;
/* 242 */           bool4 = true;
/* 243 */         } else if (str.startsWith("-tcp")) {
/* 244 */           if ("-tcp".equals(str)) {
/* 245 */             bool7 = false;
/* 246 */             bool1 = true;
/* 247 */           } else if (!"-tcpAllowOthers".equals(str)) {
/*     */             
/* 249 */             if (!"-tcpDaemon".equals(str))
/*     */             {
/* 251 */               if (!"-tcpSSL".equals(str))
/*     */               {
/* 253 */                 if ("-tcpPort".equals(str))
/* 254 */                 { b++; }
/* 255 */                 else if ("-tcpPassword".equals(str))
/* 256 */                 { str1 = paramVarArgs[++b]; }
/* 257 */                 else if ("-tcpShutdown".equals(str))
/* 258 */                 { bool7 = false;
/* 259 */                   bool5 = true;
/* 260 */                   str2 = paramVarArgs[++b]; }
/* 261 */                 else if ("-tcpShutdownForce".equals(str))
/* 262 */                 { bool6 = true; }
/*     */                 else
/* 264 */                 { showUsageAndThrowUnsupportedOption(str); }  }  } 
/*     */           } 
/* 266 */         } else if (str.startsWith("-pg")) {
/* 267 */           if ("-pg".equals(str)) {
/* 268 */             bool7 = false;
/* 269 */             bool2 = true;
/* 270 */           } else if (!"-pgAllowOthers".equals(str)) {
/*     */             
/* 272 */             if (!"-pgDaemon".equals(str))
/*     */             {
/* 274 */               if ("-pgPort".equals(str))
/* 275 */               { b++; }
/*     */               else
/* 277 */               { showUsageAndThrowUnsupportedOption(str); }  } 
/*     */           } 
/* 279 */         } else if ("-properties".equals(str)) {
/* 280 */           b++;
/* 281 */         } else if (!"-trace".equals(str)) {
/*     */           
/* 283 */           if (!"-ifExists".equals(str))
/*     */           {
/* 285 */             if ("-baseDir".equals(str))
/* 286 */             { b++; }
/* 287 */             else if ("-key".equals(str))
/* 288 */             { b += 2; }
/*     */             else
/* 290 */             { showUsageAndThrowUnsupportedOption(str); }  } 
/*     */         } 
/*     */       } 
/* 293 */     }  verifyArgs(paramVarArgs);
/* 294 */     if (bool7) {
/* 295 */       bool1 = true;
/* 296 */       bool2 = true;
/* 297 */       bool3 = true;
/* 298 */       bool4 = true;
/*     */     } 
/*     */     
/* 301 */     if (bool5) {
/* 302 */       this.out.println("Shutting down TCP Server at " + str2);
/* 303 */       shutdownTcpServer(str2, str1, bool6, false);
/*     */     } 
/*     */     
/*     */     try {
/* 307 */       if (bool1) {
/* 308 */         this.tcp = createTcpServer(paramVarArgs);
/* 309 */         this.tcp.start();
/* 310 */         this.out.println(this.tcp.getStatus());
/* 311 */         this.tcp.setShutdownHandler(this);
/*     */       } 
/* 313 */       if (bool2) {
/* 314 */         this.pg = createPgServer(paramVarArgs);
/* 315 */         this.pg.start();
/* 316 */         this.out.println(this.pg.getStatus());
/*     */       } 
/* 318 */       if (bool3) {
/* 319 */         this.web = createWebServer(paramVarArgs);
/* 320 */         this.web.setShutdownHandler(this);
/* 321 */         SQLException sQLException = null;
/*     */         try {
/* 323 */           this.web.start();
/* 324 */         } catch (Exception exception) {
/* 325 */           sQLException = DbException.toSQLException(exception);
/*     */         } 
/* 327 */         this.out.println(this.web.getStatus());
/*     */ 
/*     */ 
/*     */         
/* 331 */         if (bool4) {
/*     */           try {
/* 333 */             openBrowser(this.web.getURL());
/* 334 */           } catch (Exception exception) {
/* 335 */             this.out.println(exception.getMessage());
/*     */           } 
/*     */         }
/* 338 */         if (sQLException != null) {
/* 339 */           throw sQLException;
/*     */         }
/* 341 */       } else if (bool4) {
/* 342 */         this.out.println("The browser can only start if a web server is started (-web)");
/*     */       } 
/* 344 */     } catch (SQLException sQLException) {
/* 345 */       stopAll();
/* 346 */       throw sQLException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void shutdownTcpServer(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) throws SQLException {
/* 371 */     TcpServer.shutdown(paramString1, paramString2, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatus() {
/* 380 */     StringBuilder stringBuilder = new StringBuilder();
/* 381 */     if (!this.started) {
/* 382 */       stringBuilder.append("Not started");
/* 383 */     } else if (isRunning(false)) {
/* 384 */       stringBuilder.append(this.service.getType()).append(" server running at ").append(this.service.getURL()).append(" (");
/*     */ 
/*     */ 
/*     */       
/* 388 */       if (this.service.getAllowOthers()) {
/* 389 */         stringBuilder.append("others can connect");
/*     */       } else {
/* 391 */         stringBuilder.append("only local connections");
/*     */       } 
/* 393 */       stringBuilder.append(')');
/*     */     } else {
/* 395 */       stringBuilder.append("The ").append(this.service.getType()).append(" server could not be started. Possible cause: another server is already running at ").append(this.service.getURL());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 401 */     return stringBuilder.toString();
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
/*     */   public static Server createWebServer(String... paramVarArgs) throws SQLException {
/* 419 */     WebServer webServer = new WebServer();
/* 420 */     Server server = new Server((Service)webServer, paramVarArgs);
/* 421 */     webServer.setShutdownHandler(server);
/* 422 */     return server;
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
/*     */ 
/*     */   
/*     */   public static Server createTcpServer(String... paramVarArgs) throws SQLException {
/* 446 */     TcpServer tcpServer = new TcpServer();
/* 447 */     Server server = new Server((Service)tcpServer, paramVarArgs);
/* 448 */     tcpServer.setShutdownHandler(server);
/* 449 */     return server;
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
/*     */ 
/*     */   
/*     */   public static Server createPgServer(String... paramVarArgs) throws SQLException {
/* 473 */     return new Server((Service)new PgServer(), paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Server start() throws SQLException {
/*     */     try {
/* 483 */       this.started = true;
/* 484 */       this.service.start();
/* 485 */       String str = this.service.getName() + " (" + this.service.getURL() + ")";
/* 486 */       Thread thread = new Thread(this, str);
/* 487 */       thread.setDaemon(this.service.isDaemon());
/* 488 */       thread.start();
/* 489 */       for (int i = 1; i < 64; i += i) {
/* 490 */         wait(i);
/* 491 */         if (isRunning(false)) {
/* 492 */           return this;
/*     */         }
/*     */       } 
/* 495 */       if (isRunning(true)) {
/* 496 */         return this;
/*     */       }
/* 498 */       throw DbException.get(90061, new String[] { str, "timeout; please check your network configuration, specially the file /etc/hosts" });
/*     */     
/*     */     }
/* 501 */     catch (DbException dbException) {
/* 502 */       throw DbException.toSQLException(dbException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void wait(int paramInt) {
/*     */     try {
/* 509 */       long l = paramInt * paramInt;
/* 510 */       Thread.sleep(l);
/* 511 */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void stopAll() {
/* 517 */     Server server = this.web;
/* 518 */     if (server != null && server.isRunning(false)) {
/* 519 */       server.stop();
/* 520 */       this.web = null;
/*     */     } 
/* 522 */     server = this.tcp;
/* 523 */     if (server != null && server.isRunning(false)) {
/* 524 */       server.stop();
/* 525 */       this.tcp = null;
/*     */     } 
/* 527 */     server = this.pg;
/* 528 */     if (server != null && server.isRunning(false)) {
/* 529 */       server.stop();
/* 530 */       this.pg = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRunning(boolean paramBoolean) {
/* 541 */     return this.service.isRunning(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 548 */     this.started = false;
/* 549 */     if (this.service != null) {
/* 550 */       this.service.stop();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getURL() {
/* 560 */     return this.service.getURL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 569 */     return this.service.getPort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 578 */       this.service.listen();
/* 579 */     } catch (Exception exception) {
/* 580 */       DbException.traceThrowable(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShutdownHandler(ShutdownHandler paramShutdownHandler) {
/* 588 */     this.shutdownHandler = paramShutdownHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 596 */     if (this.shutdownHandler != null) {
/* 597 */       this.shutdownHandler.shutdown();
/*     */     } else {
/* 599 */       stopAll();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Service getService() {
/* 609 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void openBrowser(String paramString) throws Exception {
/*     */     try {
/* 619 */       String str1 = StringUtils.toLowerEnglish(Utils.getProperty("os.name", "linux"));
/*     */       
/* 621 */       Runtime runtime = Runtime.getRuntime();
/* 622 */       String str2 = Utils.getProperty("h2.browser", null);
/* 623 */       if (str2 == null) {
/*     */         
/*     */         try {
/* 626 */           str2 = System.getenv("BROWSER");
/* 627 */         } catch (SecurityException securityException) {}
/*     */       }
/*     */ 
/*     */       
/* 631 */       if (str2 != null) {
/* 632 */         if (str2.startsWith("call:")) {
/* 633 */           str2 = str2.substring("call:".length());
/* 634 */           Utils.callStaticMethod(str2, new Object[] { paramString });
/* 635 */         } else if (str2.contains("%url")) {
/* 636 */           String[] arrayOfString = StringUtils.arraySplit(str2, ',', false);
/* 637 */           for (byte b = 0; b < arrayOfString.length; b++) {
/* 638 */             arrayOfString[b] = StringUtils.replaceAll(arrayOfString[b], "%url", paramString);
/*     */           }
/* 640 */           runtime.exec(arrayOfString);
/* 641 */         } else if (str1.contains("windows")) {
/* 642 */           runtime.exec(new String[] { "cmd.exe", "/C", str2, paramString });
/*     */         } else {
/* 644 */           runtime.exec(new String[] { str2, paramString });
/*     */         } 
/*     */         return;
/*     */       } 
/*     */       try {
/* 649 */         Class<?> clazz = Class.forName("java.awt.Desktop");
/*     */         
/* 651 */         Boolean bool = (Boolean)clazz.getMethod("isDesktopSupported", new Class[0]).invoke(null, new Object[0]);
/*     */ 
/*     */         
/* 654 */         URI uRI = new URI(paramString);
/* 655 */         if (bool.booleanValue()) {
/*     */           
/* 657 */           Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
/*     */ 
/*     */           
/* 660 */           clazz.getMethod("browse", new Class[] { URI.class }).invoke(object, new Object[] { uRI });
/*     */           
/*     */           return;
/*     */         } 
/* 664 */       } catch (Exception exception) {}
/*     */ 
/*     */       
/* 667 */       if (str1.contains("windows")) {
/* 668 */         runtime.exec(new String[] { "rundll32", "url.dll,FileProtocolHandler", paramString });
/* 669 */       } else if (str1.contains("mac") || str1.contains("darwin")) {
/*     */         
/* 671 */         Runtime.getRuntime().exec(new String[] { "open", paramString });
/*     */       } else {
/* 673 */         String[] arrayOfString = { "xdg-open", "chromium", "google-chrome", "firefox", "mozilla-firefox", "mozilla", "konqueror", "netscape", "opera", "midori" };
/*     */ 
/*     */         
/* 676 */         boolean bool = false;
/* 677 */         for (String str : arrayOfString) {
/*     */           try {
/* 679 */             runtime.exec(new String[] { str, paramString });
/* 680 */             bool = true;
/*     */             break;
/* 682 */           } catch (Exception exception) {}
/*     */         } 
/*     */ 
/*     */         
/* 686 */         if (!bool)
/*     */         {
/* 688 */           throw new Exception("Browser detection failed and system property h2.browser not set");
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 693 */     catch (Exception exception) {
/* 694 */       throw new Exception("Failed to start a browser to open the URL " + paramString + ": " + exception.getMessage());
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
/*     */   public static void startWebServer(Connection paramConnection) throws SQLException {
/* 709 */     WebServer webServer = new WebServer();
/* 710 */     Server server1 = new Server((Service)webServer, new String[] { "-webPort", "0" });
/* 711 */     server1.start();
/* 712 */     Server server2 = new Server();
/* 713 */     server2.web = server1;
/* 714 */     webServer.setShutdownHandler(server2);
/* 715 */     String str = webServer.addSession(paramConnection);
/*     */     try {
/* 717 */       openBrowser(str);
/* 718 */       while (!webServer.isStopped()) {
/* 719 */         Thread.sleep(1000L);
/*     */       }
/* 721 */     } catch (Exception exception) {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\Server.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */