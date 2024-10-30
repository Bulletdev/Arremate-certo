/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.io.StringReader;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Properties;
/*     */ import org.h2.Driver;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.server.web.ConnectionInfo;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.ScriptReader;
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
/*     */ public class Shell
/*     */   extends Tool
/*     */   implements Runnable
/*     */ {
/*     */   private static final int MAX_ROW_BUFFER = 5000;
/*     */   private static final int HISTORY_COUNT = 20;
/*     */   private static final char BOX_VERTICAL = '|';
/*  43 */   private PrintStream err = System.err;
/*  44 */   private InputStream in = System.in;
/*     */   private BufferedReader reader;
/*     */   private Connection conn;
/*     */   private Statement stat;
/*     */   private boolean listMode;
/*  49 */   private int maxColumnSize = 100;
/*  50 */   private final ArrayList<String> history = New.arrayList();
/*     */   private boolean stopHide;
/*  52 */   private String serverPropertiesDir = "~";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  79 */     (new Shell()).runTool(paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setErr(PrintStream paramPrintStream) {
/*  88 */     this.err = paramPrintStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIn(InputStream paramInputStream) {
/*  97 */     this.in = paramInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInReader(BufferedReader paramBufferedReader) {
/* 106 */     this.reader = paramBufferedReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/* 116 */     String str1 = null;
/* 117 */     String str2 = "";
/* 118 */     String str3 = "";
/* 119 */     String str4 = null;
/* 120 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/* 121 */       String str = paramVarArgs[b];
/* 122 */       if (str.equals("-url"))
/* 123 */       { str1 = paramVarArgs[++b]; }
/* 124 */       else if (str.equals("-user"))
/* 125 */       { str2 = paramVarArgs[++b]; }
/* 126 */       else if (str.equals("-password"))
/* 127 */       { str3 = paramVarArgs[++b]; }
/* 128 */       else if (str.equals("-driver"))
/* 129 */       { String str5 = paramVarArgs[++b];
/* 130 */         JdbcUtils.loadUserClass(str5); }
/* 131 */       else if (str.equals("-sql"))
/* 132 */       { str4 = paramVarArgs[++b]; }
/* 133 */       else if (str.equals("-properties"))
/* 134 */       { this.serverPropertiesDir = paramVarArgs[++b]; }
/* 135 */       else { if (str.equals("-help") || str.equals("-?")) {
/* 136 */           showUsage(); return;
/*     */         } 
/* 138 */         if (str.equals("-list")) {
/* 139 */           this.listMode = true;
/*     */         } else {
/* 141 */           showUsageAndThrowUnsupportedOption(str);
/*     */         }  }
/*     */     
/* 144 */     }  if (str1 != null) {
/* 145 */       Driver.load();
/* 146 */       this.conn = DriverManager.getConnection(str1, str2, str3);
/* 147 */       this.stat = this.conn.createStatement();
/*     */     } 
/* 149 */     if (str4 == null) {
/* 150 */       promptLoop();
/*     */     } else {
/* 152 */       ScriptReader scriptReader = new ScriptReader(new StringReader(str4));
/*     */       while (true) {
/* 154 */         String str = scriptReader.readStatement();
/* 155 */         if (str == null) {
/*     */           break;
/*     */         }
/* 158 */         execute(str);
/*     */       } 
/* 160 */       if (this.conn != null) {
/* 161 */         this.conn.close();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void runTool(Connection paramConnection, String... paramVarArgs) throws SQLException {
/* 179 */     this.conn = paramConnection;
/* 180 */     this.stat = paramConnection.createStatement();
/* 181 */     runTool(paramVarArgs);
/*     */   }
/*     */   
/*     */   private void showHelp() {
/* 185 */     println("Commands are case insensitive; SQL statements end with ';'");
/* 186 */     println("help or ?      Display this help");
/* 187 */     println("list           Toggle result list / stack trace mode");
/* 188 */     println("maxwidth       Set maximum column width (default is 100)");
/* 189 */     println("autocommit     Enable or disable autocommit");
/* 190 */     println("history        Show the last 20 statements");
/* 191 */     println("quit or exit   Close the connection and exit");
/* 192 */     println("");
/*     */   }
/*     */   
/*     */   private void promptLoop() {
/* 196 */     println("");
/* 197 */     println("Welcome to H2 Shell " + Constants.getFullVersion());
/* 198 */     println("Exit with Ctrl+C");
/* 199 */     if (this.conn != null) {
/* 200 */       showHelp();
/*     */     }
/* 202 */     String str = null;
/* 203 */     if (this.reader == null) {
/* 204 */       this.reader = new BufferedReader(new InputStreamReader(this.in));
/*     */     }
/*     */     while (true) {
/*     */       try {
/* 208 */         if (this.conn == null) {
/* 209 */           connect();
/* 210 */           showHelp();
/*     */         } 
/* 212 */         if (str == null) {
/* 213 */           print("sql> ");
/*     */         } else {
/* 215 */           print("...> ");
/*     */         } 
/* 217 */         String str1 = readLine();
/* 218 */         if (str1 == null) {
/*     */           break;
/*     */         }
/* 221 */         String str2 = str1.trim();
/* 222 */         if (str2.length() == 0) {
/*     */           continue;
/*     */         }
/* 225 */         boolean bool = str2.endsWith(";");
/* 226 */         if (bool) {
/* 227 */           str1 = str1.substring(0, str1.lastIndexOf(';'));
/* 228 */           str2 = str2.substring(0, str2.length() - 1);
/*     */         } 
/* 230 */         String str3 = StringUtils.toLowerEnglish(str2);
/* 231 */         if ("exit".equals(str3) || "quit".equals(str3))
/*     */           break; 
/* 233 */         if ("help".equals(str3) || "?".equals(str3)) {
/* 234 */           showHelp(); continue;
/* 235 */         }  if ("list".equals(str3)) {
/* 236 */           this.listMode = !this.listMode;
/* 237 */           println("Result list mode is now " + (this.listMode ? "on" : "off")); continue;
/* 238 */         }  if ("history".equals(str3)) {
/* 239 */           byte b; int i; for (b = 0, i = this.history.size(); b < i; b++) {
/* 240 */             String str4 = this.history.get(b);
/* 241 */             str4 = str4.replace('\n', ' ').replace('\r', ' ');
/* 242 */             println("#" + (1 + b) + ": " + str4);
/*     */           } 
/* 244 */           if (this.history.size() > 0) {
/* 245 */             println("To re-run a statement, type the number and press and enter"); continue;
/*     */           } 
/* 247 */           println("No history"); continue;
/*     */         } 
/* 249 */         if (str3.startsWith("autocommit")) {
/* 250 */           str3 = str3.substring("autocommit".length()).trim();
/* 251 */           if ("true".equals(str3)) {
/* 252 */             this.conn.setAutoCommit(true);
/* 253 */           } else if ("false".equals(str3)) {
/* 254 */             this.conn.setAutoCommit(false);
/*     */           } else {
/* 256 */             println("Usage: autocommit [true|false]");
/*     */           } 
/* 258 */           println("Autocommit is now " + this.conn.getAutoCommit()); continue;
/* 259 */         }  if (str3.startsWith("maxwidth")) {
/* 260 */           str3 = str3.substring("maxwidth".length()).trim();
/*     */           try {
/* 262 */             this.maxColumnSize = Integer.parseInt(str3);
/* 263 */           } catch (NumberFormatException numberFormatException) {
/* 264 */             println("Usage: maxwidth <integer value>");
/*     */           } 
/* 266 */           println("Maximum column width is now " + this.maxColumnSize); continue;
/*     */         } 
/* 268 */         boolean bool1 = true;
/* 269 */         if (str == null) {
/* 270 */           if (StringUtils.isNumber(str1)) {
/* 271 */             int i = Integer.parseInt(str1);
/* 272 */             if (i == 0 || i > this.history.size()) {
/* 273 */               println("Not found");
/*     */             } else {
/* 275 */               str = this.history.get(i - 1);
/* 276 */               bool1 = false;
/* 277 */               println(str);
/* 278 */               bool = true;
/*     */             } 
/*     */           } else {
/* 281 */             str = str1;
/*     */           } 
/*     */         } else {
/* 284 */           str = str + "\n" + str1;
/*     */         } 
/* 286 */         if (bool) {
/* 287 */           if (bool1) {
/* 288 */             this.history.add(0, str);
/* 289 */             if (this.history.size() > 20) {
/* 290 */               this.history.remove(20);
/*     */             }
/*     */           } 
/* 293 */           execute(str);
/* 294 */           str = null;
/*     */         }
/*     */       
/* 297 */       } catch (SQLException sQLException) {
/* 298 */         println("SQL Exception: " + sQLException.getMessage());
/* 299 */         str = null;
/* 300 */       } catch (IOException iOException) {
/* 301 */         println(iOException.getMessage());
/*     */         break;
/* 303 */       } catch (Exception exception) {
/* 304 */         println("Exception: " + exception.toString());
/* 305 */         exception.printStackTrace(this.err);
/*     */         break;
/*     */       } 
/*     */     } 
/* 309 */     if (this.conn != null) {
/*     */       try {
/* 311 */         this.conn.close();
/* 312 */         println("Connection closed");
/* 313 */       } catch (SQLException sQLException) {
/* 314 */         println("SQL Exception: " + sQLException.getMessage());
/* 315 */         sQLException.printStackTrace(this.err);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void connect() throws IOException, SQLException {
/* 321 */     String str1 = "jdbc:h2:~/test";
/* 322 */     String str2 = "";
/* 323 */     String str3 = null;
/*     */     try {
/*     */       SortedProperties sortedProperties;
/* 326 */       if ("null".equals(this.serverPropertiesDir)) {
/* 327 */         Properties properties = new Properties();
/*     */       } else {
/* 329 */         sortedProperties = SortedProperties.loadProperties(this.serverPropertiesDir + "/" + ".h2.server.properties");
/*     */       } 
/*     */       
/* 332 */       String str = null;
/* 333 */       boolean bool = false;
/* 334 */       for (byte b = 0;; b++) {
/* 335 */         String str5 = sortedProperties.getProperty(String.valueOf(b));
/* 336 */         if (str5 == null) {
/*     */           break;
/*     */         }
/* 339 */         bool = true;
/* 340 */         str = str5;
/*     */       } 
/* 342 */       if (bool) {
/* 343 */         ConnectionInfo connectionInfo = new ConnectionInfo(str);
/* 344 */         str1 = connectionInfo.url;
/* 345 */         str2 = connectionInfo.user;
/* 346 */         str3 = connectionInfo.driver;
/*     */       } 
/* 348 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/* 351 */     println("[Enter]   " + str1);
/* 352 */     print("URL       ");
/* 353 */     str1 = readLine(str1).trim();
/* 354 */     if (str3 == null) {
/* 355 */       str3 = JdbcUtils.getDriver(str1);
/*     */     }
/* 357 */     if (str3 != null) {
/* 358 */       println("[Enter]   " + str3);
/*     */     }
/* 360 */     print("Driver    ");
/* 361 */     str3 = readLine(str3).trim();
/* 362 */     println("[Enter]   " + str2);
/* 363 */     print("User      ");
/* 364 */     str2 = readLine(str2);
/* 365 */     println("[Enter]   Hide");
/* 366 */     print("Password  ");
/* 367 */     String str4 = readLine();
/* 368 */     if (str4.length() == 0) {
/* 369 */       str4 = readPassword();
/*     */     }
/* 371 */     this.conn = JdbcUtils.getConnection(str3, str1, str2, str4);
/* 372 */     this.stat = this.conn.createStatement();
/* 373 */     println("Connected");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void print(String paramString) {
/* 382 */     this.out.print(paramString);
/* 383 */     this.out.flush();
/*     */   }
/*     */   
/*     */   private void println(String paramString) {
/* 387 */     this.out.println(paramString);
/* 388 */     this.out.flush();
/*     */   }
/*     */   
/*     */   private String readPassword() throws IOException {
/*     */     try {
/* 393 */       Object object = Utils.callStaticMethod("java.lang.System.console", new Object[0]);
/* 394 */       print("Password  ");
/* 395 */       char[] arrayOfChar = (char[])Utils.callMethod(object, "readPassword", new Object[0]);
/* 396 */       return (arrayOfChar == null) ? null : new String(arrayOfChar);
/* 397 */     } catch (Exception exception) {
/*     */ 
/*     */       
/* 400 */       Thread thread = new Thread(this, "Password hider");
/* 401 */       this.stopHide = false;
/* 402 */       thread.start();
/* 403 */       print("Password  > ");
/* 404 */       String str = readLine();
/* 405 */       this.stopHide = true;
/*     */       try {
/* 407 */         thread.join();
/* 408 */       } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */       
/* 411 */       print("\b\b");
/* 412 */       return str;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 422 */     while (!this.stopHide) {
/* 423 */       print("\b\b><");
/*     */       try {
/* 425 */         Thread.sleep(10L);
/* 426 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String readLine(String paramString) throws IOException {
/* 434 */     String str = readLine();
/* 435 */     return (str.length() == 0) ? paramString : str;
/*     */   }
/*     */   
/*     */   private String readLine() throws IOException {
/* 439 */     String str = this.reader.readLine();
/* 440 */     if (str == null) {
/* 441 */       throw new IOException("Aborted");
/*     */     }
/* 443 */     return str;
/*     */   }
/*     */   
/*     */   private void execute(String paramString) {
/* 447 */     if (paramString.trim().length() == 0) {
/*     */       return;
/*     */     }
/* 450 */     long l = System.currentTimeMillis();
/*     */     try {
/* 452 */       ResultSet resultSet = null;
/*     */       try {
/* 454 */         if (this.stat.execute(paramString)) {
/* 455 */           resultSet = this.stat.getResultSet();
/* 456 */           int i = printResult(resultSet, this.listMode);
/* 457 */           l = System.currentTimeMillis() - l;
/* 458 */           println("(" + i + ((i == 1) ? " row, " : " rows, ") + l + " ms)");
/*     */         } else {
/*     */           
/* 461 */           int i = this.stat.getUpdateCount();
/* 462 */           l = System.currentTimeMillis() - l;
/* 463 */           println("(Update count: " + i + ", " + l + " ms)");
/*     */         } 
/*     */       } finally {
/* 466 */         JdbcUtils.closeSilently(resultSet);
/*     */       } 
/* 468 */     } catch (SQLException sQLException) {
/* 469 */       println("Error: " + sQLException.toString());
/* 470 */       if (this.listMode) {
/* 471 */         sQLException.printStackTrace(this.err);
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private int printResult(ResultSet paramResultSet, boolean paramBoolean) throws SQLException {
/* 478 */     if (paramBoolean) {
/* 479 */       return printResultAsList(paramResultSet);
/*     */     }
/* 481 */     return printResultAsTable(paramResultSet);
/*     */   }
/*     */   
/*     */   private int printResultAsTable(ResultSet paramResultSet) throws SQLException {
/* 485 */     ResultSetMetaData resultSetMetaData = paramResultSet.getMetaData();
/* 486 */     int i = resultSetMetaData.getColumnCount();
/* 487 */     boolean bool = false;
/* 488 */     ArrayList<String[]> arrayList = New.arrayList();
/*     */     
/* 490 */     String[] arrayOfString = new String[i]; byte b;
/* 491 */     for (b = 0; b < i; b++) {
/* 492 */       String str = resultSetMetaData.getColumnLabel(b + 1);
/* 493 */       arrayOfString[b] = (str == null) ? "" : str;
/*     */     } 
/* 495 */     arrayList.add(arrayOfString);
/* 496 */     b = 0;
/* 497 */     while (paramResultSet.next()) {
/* 498 */       b++;
/* 499 */       bool |= loadRow(paramResultSet, i, arrayList);
/* 500 */       if (b > 'ᎈ') {
/* 501 */         printRows(arrayList, i);
/* 502 */         arrayList.clear();
/*     */       } 
/*     */     } 
/* 505 */     printRows(arrayList, i);
/* 506 */     arrayList.clear();
/* 507 */     if (bool) {
/* 508 */       println("(data is partially truncated)");
/*     */     }
/* 510 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean loadRow(ResultSet paramResultSet, int paramInt, ArrayList<String[]> paramArrayList) throws SQLException {
/* 515 */     boolean bool = false;
/* 516 */     String[] arrayOfString = new String[paramInt];
/* 517 */     for (byte b = 0; b < paramInt; b++) {
/* 518 */       String str = paramResultSet.getString(b + 1);
/* 519 */       if (str == null) {
/* 520 */         str = "null";
/*     */       }
/*     */       
/* 523 */       if (paramInt > 1 && str.length() > this.maxColumnSize) {
/* 524 */         str = str.substring(0, this.maxColumnSize);
/* 525 */         bool = true;
/*     */       } 
/* 527 */       arrayOfString[b] = str;
/*     */     } 
/* 529 */     paramArrayList.add(arrayOfString);
/* 530 */     return bool;
/*     */   }
/*     */   
/*     */   private int[] printRows(ArrayList<String[]> paramArrayList, int paramInt) {
/* 534 */     int[] arrayOfInt = new int[paramInt];
/* 535 */     for (byte b = 0; b < paramInt; b++) {
/* 536 */       int i = 0;
/* 537 */       for (String[] arrayOfString : paramArrayList) {
/* 538 */         i = Math.max(i, arrayOfString[b].length());
/*     */       }
/* 540 */       if (paramInt > 1) {
/* 541 */         Math.min(this.maxColumnSize, i);
/*     */       }
/* 543 */       arrayOfInt[b] = i;
/*     */     } 
/* 545 */     for (String[] arrayOfString : paramArrayList) {
/* 546 */       StringBuilder stringBuilder = new StringBuilder();
/* 547 */       for (byte b1 = 0; b1 < paramInt; b1++) {
/* 548 */         if (b1 > 0) {
/* 549 */           stringBuilder.append(' ').append('|').append(' ');
/*     */         }
/* 551 */         String str = arrayOfString[b1];
/* 552 */         stringBuilder.append(str);
/* 553 */         if (b1 < paramInt - 1) {
/* 554 */           for (int i = str.length(); i < arrayOfInt[b1]; i++) {
/* 555 */             stringBuilder.append(' ');
/*     */           }
/*     */         }
/*     */       } 
/* 559 */       println(stringBuilder.toString());
/*     */     } 
/* 561 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   private int printResultAsList(ResultSet paramResultSet) throws SQLException {
/* 565 */     ResultSetMetaData resultSetMetaData = paramResultSet.getMetaData();
/* 566 */     int i = 0;
/* 567 */     int j = resultSetMetaData.getColumnCount();
/* 568 */     String[] arrayOfString = new String[j];
/* 569 */     for (byte b1 = 0; b1 < j; b1++) {
/* 570 */       String str = resultSetMetaData.getColumnLabel(b1 + 1);
/* 571 */       arrayOfString[b1] = str;
/* 572 */       i = Math.max(i, str.length());
/*     */     } 
/* 574 */     StringBuilder stringBuilder = new StringBuilder();
/* 575 */     byte b2 = 0;
/* 576 */     while (paramResultSet.next()) {
/* 577 */       b2++;
/* 578 */       stringBuilder.setLength(0);
/* 579 */       if (b2 > 1) {
/* 580 */         println("");
/*     */       }
/* 582 */       for (byte b = 0; b < j; b++) {
/* 583 */         if (b > 0) {
/* 584 */           stringBuilder.append('\n');
/*     */         }
/* 586 */         String str = arrayOfString[b];
/* 587 */         stringBuilder.append(str);
/* 588 */         for (int k = str.length(); k < i; k++) {
/* 589 */           stringBuilder.append(' ');
/*     */         }
/* 591 */         stringBuilder.append(": ").append(paramResultSet.getString(b + 1));
/*     */       } 
/* 593 */       println(stringBuilder.toString());
/*     */     } 
/* 595 */     if (b2 == 0) {
/* 596 */       for (byte b = 0; b < j; b++) {
/* 597 */         if (b > 0) {
/* 598 */           stringBuilder.append('\n');
/*     */         }
/* 600 */         String str = arrayOfString[b];
/* 601 */         stringBuilder.append(str);
/*     */       } 
/* 603 */       println(stringBuilder.toString());
/*     */     } 
/* 605 */     return b2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\Shell.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */