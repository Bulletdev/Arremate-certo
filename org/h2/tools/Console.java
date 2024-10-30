/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.awt.Button;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Image;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Label;
/*     */ import java.awt.MenuItem;
/*     */ import java.awt.Panel;
/*     */ import java.awt.PopupMenu;
/*     */ import java.awt.SystemColor;
/*     */ import java.awt.TextField;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.awt.event.WindowListener;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.server.ShutdownHandler;
/*     */ import org.h2.util.JdbcUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Console
/*     */   extends Tool
/*     */   implements ActionListener, MouseListener, WindowListener, ShutdownHandler
/*     */ {
/*     */   private Frame frame;
/*     */   private boolean trayIconUsed;
/*     */   private Font font;
/*     */   private Button startBrowser;
/*     */   private TextField urlText;
/*     */   private Object tray;
/*     */   private Object trayIcon;
/*     */   private Server web;
/*     */   private Server tcp;
/*     */   private Server pg;
/*     */   private boolean isWindows;
/*     */   private long lastOpen;
/*     */   
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  99 */     (new Console()).runTool(paramVarArgs);
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
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/* 111 */     this.isWindows = Utils.getProperty("os.name", "").startsWith("Windows");
/* 112 */     boolean bool1 = false, bool2 = false, bool3 = false, bool4 = false;
/* 113 */     boolean bool5 = false;
/* 114 */     boolean bool6 = true;
/* 115 */     boolean bool7 = (paramVarArgs != null && paramVarArgs.length > 0) ? true : false;
/* 116 */     String str1 = null, str2 = null, str3 = null, str4 = null;
/* 117 */     boolean bool8 = false, bool9 = false;
/* 118 */     String str5 = "";
/* 119 */     String str6 = "";
/* 120 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/* 121 */       String str = paramVarArgs[b];
/* 122 */       if (str != null) {
/*     */         
/* 124 */         if ("-?".equals(str) || "-help".equals(str)) {
/* 125 */           showUsage(); return;
/*     */         } 
/* 127 */         if ("-url".equals(str)) {
/* 128 */           bool6 = false;
/* 129 */           str2 = paramVarArgs[++b];
/* 130 */         } else if ("-driver".equals(str)) {
/* 131 */           str1 = paramVarArgs[++b];
/* 132 */         } else if ("-user".equals(str)) {
/* 133 */           str3 = paramVarArgs[++b];
/* 134 */         } else if ("-password".equals(str)) {
/* 135 */           str4 = paramVarArgs[++b];
/* 136 */         } else if (str.startsWith("-web")) {
/* 137 */           if ("-web".equals(str)) {
/* 138 */             bool6 = false;
/* 139 */             bool3 = true;
/* 140 */           } else if (!"-webAllowOthers".equals(str)) {
/*     */             
/* 142 */             if (!"-webDaemon".equals(str))
/*     */             {
/* 144 */               if (!"-webSSL".equals(str))
/*     */               {
/* 146 */                 if ("-webPort".equals(str))
/* 147 */                 { b++; }
/*     */                 else
/* 149 */                 { showUsageAndThrowUnsupportedOption(str); }  }  } 
/*     */           } 
/* 151 */         } else if ("-tool".equals(str)) {
/* 152 */           bool6 = false;
/* 153 */           bool3 = true;
/* 154 */           bool4 = true;
/* 155 */         } else if ("-browser".equals(str)) {
/* 156 */           bool6 = false;
/* 157 */           bool3 = true;
/* 158 */           bool5 = true;
/* 159 */         } else if (str.startsWith("-tcp")) {
/* 160 */           if ("-tcp".equals(str)) {
/* 161 */             bool6 = false;
/* 162 */             bool1 = true;
/* 163 */           } else if (!"-tcpAllowOthers".equals(str)) {
/*     */             
/* 165 */             if (!"-tcpDaemon".equals(str))
/*     */             {
/* 167 */               if (!"-tcpSSL".equals(str))
/*     */               {
/* 169 */                 if ("-tcpPort".equals(str))
/* 170 */                 { b++; }
/* 171 */                 else if ("-tcpPassword".equals(str))
/* 172 */                 { str5 = paramVarArgs[++b]; }
/* 173 */                 else if ("-tcpShutdown".equals(str))
/* 174 */                 { bool6 = false;
/* 175 */                   bool8 = true;
/* 176 */                   str6 = paramVarArgs[++b]; }
/* 177 */                 else if ("-tcpShutdownForce".equals(str))
/* 178 */                 { bool9 = true; }
/*     */                 else
/* 180 */                 { showUsageAndThrowUnsupportedOption(str); }  }  } 
/*     */           } 
/* 182 */         } else if (str.startsWith("-pg")) {
/* 183 */           if ("-pg".equals(str)) {
/* 184 */             bool6 = false;
/* 185 */             bool2 = true;
/* 186 */           } else if (!"-pgAllowOthers".equals(str)) {
/*     */             
/* 188 */             if (!"-pgDaemon".equals(str))
/*     */             {
/* 190 */               if ("-pgPort".equals(str))
/* 191 */               { b++; }
/*     */               else
/* 193 */               { showUsageAndThrowUnsupportedOption(str); }  } 
/*     */           } 
/* 195 */         } else if ("-properties".equals(str)) {
/* 196 */           b++;
/* 197 */         } else if (!"-trace".equals(str)) {
/*     */           
/* 199 */           if (!"-ifExists".equals(str))
/*     */           {
/* 201 */             if ("-baseDir".equals(str))
/* 202 */             { b++; }
/*     */             else
/* 204 */             { showUsageAndThrowUnsupportedOption(str); }  } 
/*     */         } 
/*     */       } 
/* 207 */     }  if (bool6) {
/* 208 */       bool3 = true;
/* 209 */       bool4 = true;
/* 210 */       bool5 = true;
/* 211 */       bool1 = true;
/* 212 */       bool2 = true;
/*     */     } 
/* 214 */     if (bool8) {
/* 215 */       this.out.println("Shutting down TCP Server at " + str6);
/* 216 */       Server.shutdownTcpServer(str6, str5, bool9, false);
/*     */     } 
/*     */     
/* 219 */     SQLException sQLException = null;
/* 220 */     boolean bool10 = false;
/*     */     
/* 222 */     if (str2 != null) {
/* 223 */       Connection connection = JdbcUtils.getConnection(str1, str2, str3, str4);
/* 224 */       Server.startWebServer(connection);
/*     */     } 
/*     */     
/* 227 */     if (bool3) {
/*     */       try {
/* 229 */         this.web = Server.createWebServer(paramVarArgs);
/* 230 */         this.web.setShutdownHandler(this);
/* 231 */         this.web.start();
/* 232 */         if (bool7) {
/* 233 */           this.out.println(this.web.getStatus());
/*     */         }
/* 235 */         bool10 = true;
/* 236 */       } catch (SQLException sQLException1) {
/* 237 */         printProblem(sQLException1, this.web);
/* 238 */         sQLException = sQLException1;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 243 */     if (bool4 && bool10 && !GraphicsEnvironment.isHeadless()) {
/* 244 */       loadFont();
/*     */       try {
/* 246 */         if (!createTrayIcon()) {
/* 247 */           showWindow();
/*     */         }
/* 249 */       } catch (Exception exception) {
/* 250 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 258 */     if (bool5 && this.web != null) {
/* 259 */       openBrowser(this.web.getURL());
/*     */     }
/*     */     
/* 262 */     if (bool1) {
/*     */       try {
/* 264 */         this.tcp = Server.createTcpServer(paramVarArgs);
/* 265 */         this.tcp.start();
/* 266 */         if (bool7) {
/* 267 */           this.out.println(this.tcp.getStatus());
/*     */         }
/* 269 */         this.tcp.setShutdownHandler(this);
/* 270 */       } catch (SQLException sQLException1) {
/* 271 */         printProblem(sQLException1, this.tcp);
/* 272 */         if (sQLException == null) {
/* 273 */           sQLException = sQLException1;
/*     */         }
/*     */       } 
/*     */     }
/* 277 */     if (bool2) {
/*     */       try {
/* 279 */         this.pg = Server.createPgServer(paramVarArgs);
/* 280 */         this.pg.start();
/* 281 */         if (bool7) {
/* 282 */           this.out.println(this.pg.getStatus());
/*     */         }
/* 284 */       } catch (SQLException sQLException1) {
/* 285 */         printProblem(sQLException1, this.pg);
/* 286 */         if (sQLException == null) {
/* 287 */           sQLException = sQLException1;
/*     */         }
/*     */       } 
/*     */     }
/* 291 */     if (sQLException != null) {
/* 292 */       shutdown();
/* 293 */       throw sQLException;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void printProblem(Exception paramException, Server paramServer) {
/* 298 */     if (paramServer == null) {
/* 299 */       paramException.printStackTrace();
/*     */     } else {
/* 301 */       this.out.println(paramServer.getStatus());
/* 302 */       this.out.println("Root cause: " + paramException.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Image loadImage(String paramString) {
/*     */     try {
/* 308 */       byte[] arrayOfByte = Utils.getResource(paramString);
/* 309 */       if (arrayOfByte == null) {
/* 310 */         return null;
/*     */       }
/* 312 */       return Toolkit.getDefaultToolkit().createImage(arrayOfByte);
/* 313 */     } catch (IOException iOException) {
/* 314 */       iOException.printStackTrace();
/* 315 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 325 */     if (this.web != null && this.web.isRunning(false)) {
/* 326 */       this.web.stop();
/* 327 */       this.web = null;
/*     */     } 
/* 329 */     if (this.tcp != null && this.tcp.isRunning(false)) {
/* 330 */       this.tcp.stop();
/* 331 */       this.tcp = null;
/*     */     } 
/* 333 */     if (this.pg != null && this.pg.isRunning(false)) {
/* 334 */       this.pg.stop();
/* 335 */       this.pg = null;
/*     */     } 
/*     */     
/* 338 */     if (this.frame != null) {
/* 339 */       this.frame.dispose();
/* 340 */       this.frame = null;
/*     */     } 
/* 342 */     if (this.trayIconUsed) {
/*     */       
/*     */       try {
/* 345 */         Utils.callMethod(this.tray, "remove", new Object[] { this.trayIcon });
/* 346 */       } catch (Exception exception) {
/*     */       
/*     */       } finally {
/* 349 */         this.trayIcon = null;
/* 350 */         this.tray = null;
/* 351 */         this.trayIconUsed = false;
/*     */       } 
/* 353 */       System.gc();
/*     */       
/* 355 */       for (Thread thread : Thread.getAllStackTraces().keySet()) {
/* 356 */         if (thread.getName().startsWith("AWT-")) {
/* 357 */           thread.interrupt();
/*     */         }
/*     */       } 
/* 360 */       Thread.currentThread().interrupt();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void loadFont() {
/* 368 */     if (this.isWindows) {
/* 369 */       this.font = new Font("Dialog", 0, 11);
/*     */     } else {
/* 371 */       this.font = new Font("Dialog", 0, 12);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean createTrayIcon() {
/*     */     try {
/*     */       String str;
/* 378 */       boolean bool = ((Boolean)Utils.callStaticMethod("java.awt.SystemTray.isSupported", new Object[0])).booleanValue();
/*     */       
/* 380 */       if (!bool) {
/* 381 */         return false;
/*     */       }
/* 383 */       PopupMenu popupMenu = new PopupMenu();
/* 384 */       MenuItem menuItem1 = new MenuItem("H2 Console");
/* 385 */       menuItem1.setActionCommand("console");
/* 386 */       menuItem1.addActionListener(this);
/* 387 */       menuItem1.setFont(this.font);
/* 388 */       popupMenu.add(menuItem1);
/* 389 */       MenuItem menuItem2 = new MenuItem("Status");
/* 390 */       menuItem2.setActionCommand("status");
/* 391 */       menuItem2.addActionListener(this);
/* 392 */       menuItem2.setFont(this.font);
/* 393 */       popupMenu.add(menuItem2);
/* 394 */       MenuItem menuItem3 = new MenuItem("Exit");
/* 395 */       menuItem3.setFont(this.font);
/* 396 */       menuItem3.setActionCommand("exit");
/* 397 */       menuItem3.addActionListener(this);
/* 398 */       popupMenu.add(menuItem3);
/*     */ 
/*     */       
/* 401 */       this.tray = Utils.callStaticMethod("java.awt.SystemTray.getSystemTray", new Object[0]);
/*     */ 
/*     */       
/* 404 */       Dimension dimension = (Dimension)Utils.callMethod(this.tray, "getTrayIconSize", new Object[0]);
/*     */       
/* 406 */       if (dimension.width >= 24 && dimension.height >= 24) {
/* 407 */         str = "/org/h2/res/h2-24.png";
/* 408 */       } else if (dimension.width >= 22 && dimension.height >= 22) {
/*     */ 
/*     */ 
/*     */         
/* 412 */         str = "/org/h2/res/h2-64-t.png";
/*     */       } else {
/*     */         
/* 415 */         str = "/org/h2/res/h2.png";
/*     */       } 
/* 417 */       Image image = loadImage(str);
/*     */ 
/*     */ 
/*     */       
/* 421 */       this.trayIcon = Utils.newInstance("java.awt.TrayIcon", new Object[] { image, "H2 Database Engine", popupMenu });
/*     */ 
/*     */ 
/*     */       
/* 425 */       Utils.callMethod(this.trayIcon, "addMouseListener", new Object[] { this });
/*     */ 
/*     */       
/* 428 */       Utils.callMethod(this.tray, "add", new Object[] { this.trayIcon });
/*     */       
/* 430 */       this.trayIconUsed = true;
/*     */       
/* 432 */       return true;
/* 433 */     } catch (Exception exception) {
/* 434 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void showWindow() {
/* 439 */     if (this.frame != null) {
/*     */       return;
/*     */     }
/* 442 */     this.frame = new Frame("H2 Console");
/* 443 */     this.frame.addWindowListener(this);
/* 444 */     Image image = loadImage("/org/h2/res/h2.png");
/* 445 */     if (image != null) {
/* 446 */       this.frame.setIconImage(image);
/*     */     }
/* 448 */     this.frame.setResizable(false);
/* 449 */     this.frame.setBackground(SystemColor.control);
/*     */     
/* 451 */     GridBagLayout gridBagLayout = new GridBagLayout();
/* 452 */     this.frame.setLayout(gridBagLayout);
/*     */ 
/*     */     
/* 455 */     Panel panel = new Panel(gridBagLayout);
/*     */     
/* 457 */     GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
/* 458 */     gridBagConstraints1.gridx = 0;
/* 459 */     gridBagConstraints1.weightx = 1.0D;
/* 460 */     gridBagConstraints1.weighty = 1.0D;
/* 461 */     gridBagConstraints1.fill = 1;
/* 462 */     gridBagConstraints1.insets = new Insets(0, 10, 0, 10);
/* 463 */     gridBagConstraints1.gridy = 0;
/*     */     
/* 465 */     GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
/* 466 */     gridBagConstraints2.gridx = 0;
/* 467 */     gridBagConstraints2.gridwidth = 2;
/* 468 */     gridBagConstraints2.insets = new Insets(10, 0, 0, 0);
/* 469 */     gridBagConstraints2.gridy = 1;
/* 470 */     gridBagConstraints2.anchor = 13;
/*     */     
/* 472 */     GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
/* 473 */     gridBagConstraints3.fill = 2;
/* 474 */     gridBagConstraints3.gridy = 0;
/* 475 */     gridBagConstraints3.weightx = 1.0D;
/* 476 */     gridBagConstraints3.insets = new Insets(0, 5, 0, 0);
/* 477 */     gridBagConstraints3.gridx = 1;
/*     */     
/* 479 */     GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
/* 480 */     gridBagConstraints4.gridx = 0;
/* 481 */     gridBagConstraints4.gridy = 0;
/*     */     
/* 483 */     Label label = new Label("H2 Console URL:", 0);
/* 484 */     label.setFont(this.font);
/* 485 */     panel.add(label, gridBagConstraints4);
/*     */     
/* 487 */     this.urlText = new TextField();
/* 488 */     this.urlText.setEditable(false);
/* 489 */     this.urlText.setFont(this.font);
/* 490 */     this.urlText.setText(this.web.getURL());
/* 491 */     if (this.isWindows) {
/* 492 */       this.urlText.setFocusable(false);
/*     */     }
/* 494 */     panel.add(this.urlText, gridBagConstraints3);
/*     */     
/* 496 */     this.startBrowser = new Button("Start Browser");
/* 497 */     this.startBrowser.setFocusable(false);
/* 498 */     this.startBrowser.setActionCommand("console");
/* 499 */     this.startBrowser.addActionListener(this);
/* 500 */     this.startBrowser.setFont(this.font);
/* 501 */     panel.add(this.startBrowser, gridBagConstraints2);
/* 502 */     this.frame.add(panel, gridBagConstraints1);
/*     */     
/* 504 */     char c = 'Ĭ'; byte b = 120;
/* 505 */     this.frame.setSize(c, b);
/* 506 */     Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
/* 507 */     this.frame.setLocation((dimension.width - c) / 2, (dimension.height - b) / 2);
/*     */     
/*     */     try {
/* 510 */       this.frame.setVisible(true);
/* 511 */     } catch (Throwable throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 518 */       this.frame.setAlwaysOnTop(true);
/* 519 */       this.frame.setAlwaysOnTop(false);
/* 520 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void startBrowser() {
/* 526 */     if (this.web != null) {
/* 527 */       String str = this.web.getURL();
/* 528 */       if (this.urlText != null) {
/* 529 */         this.urlText.setText(str);
/*     */       }
/* 531 */       long l = System.currentTimeMillis();
/* 532 */       if (this.lastOpen == 0L || this.lastOpen + 100L < l) {
/* 533 */         this.lastOpen = l;
/* 534 */         openBrowser(str);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void openBrowser(String paramString) {
/*     */     try {
/* 542 */       Server.openBrowser(paramString);
/* 543 */     } catch (Exception exception) {
/* 544 */       this.out.println(exception.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent paramActionEvent) {
/* 554 */     String str = paramActionEvent.getActionCommand();
/* 555 */     if ("exit".equals(str)) {
/* 556 */       shutdown();
/* 557 */     } else if ("console".equals(str)) {
/* 558 */       startBrowser();
/* 559 */     } else if ("status".equals(str)) {
/* 560 */       showWindow();
/* 561 */     } else if (this.startBrowser == paramActionEvent.getSource()) {
/*     */       
/* 563 */       startBrowser();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(MouseEvent paramMouseEvent) {
/* 574 */     if (paramMouseEvent.getButton() == 1) {
/* 575 */       startBrowser();
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
/*     */   public void mouseEntered(MouseEvent paramMouseEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseExited(MouseEvent paramMouseEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mousePressed(MouseEvent paramMouseEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseReleased(MouseEvent paramMouseEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void windowClosing(WindowEvent paramWindowEvent) {
/* 626 */     if (this.trayIconUsed) {
/* 627 */       this.frame.dispose();
/* 628 */       this.frame = null;
/*     */     } else {
/* 630 */       shutdown();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void windowActivated(WindowEvent paramWindowEvent) {}
/*     */   
/*     */   public void windowClosed(WindowEvent paramWindowEvent) {}
/*     */   
/*     */   public void windowDeactivated(WindowEvent paramWindowEvent) {}
/*     */   
/*     */   public void windowDeiconified(WindowEvent paramWindowEvent) {}
/*     */   
/*     */   public void windowIconified(WindowEvent paramWindowEvent) {}
/*     */   
/*     */   public void windowOpened(WindowEvent paramWindowEvent) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\Console.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */