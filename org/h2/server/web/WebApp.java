/*      */ package org.h2.server.web;
/*      */ 
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.PrintStream;
/*      */ import java.io.PrintWriter;
/*      */ import java.io.StringReader;
/*      */ import java.io.StringWriter;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.math.BigDecimal;
/*      */ import java.sql.Connection;
/*      */ import java.sql.DatabaseMetaData;
/*      */ import java.sql.ParameterMetaData;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.ResultSetMetaData;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Statement;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import java.util.Random;
/*      */ import org.h2.bnf.Bnf;
/*      */ import org.h2.bnf.context.DbColumn;
/*      */ import org.h2.bnf.context.DbContents;
/*      */ import org.h2.bnf.context.DbSchema;
/*      */ import org.h2.bnf.context.DbTableOrView;
/*      */ import org.h2.engine.Constants;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.jdbc.JdbcSQLException;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.security.SHA256;
/*      */ import org.h2.tools.Backup;
/*      */ import org.h2.tools.ChangeFileEncryption;
/*      */ import org.h2.tools.ConvertTraceFile;
/*      */ import org.h2.tools.CreateCluster;
/*      */ import org.h2.tools.DeleteDbFiles;
/*      */ import org.h2.tools.Recover;
/*      */ import org.h2.tools.Restore;
/*      */ import org.h2.tools.RunScript;
/*      */ import org.h2.tools.Script;
/*      */ import org.h2.tools.SimpleResultSet;
/*      */ import org.h2.util.JdbcUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.Profiler;
/*      */ import org.h2.util.ScriptReader;
/*      */ import org.h2.util.SortedProperties;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.util.Utils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class WebApp
/*      */ {
/*      */   protected final WebServer server;
/*      */   protected WebSession session;
/*      */   protected Properties attributes;
/*      */   protected String mimeType;
/*      */   protected boolean cache;
/*      */   protected boolean stop;
/*      */   protected String headerLanguage;
/*      */   private Profiler profiler;
/*      */   
/*      */   WebApp(WebServer paramWebServer) {
/*  110 */     this.server = paramWebServer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setSession(WebSession paramWebSession, Properties paramProperties) {
/*  120 */     this.session = paramWebSession;
/*  121 */     this.attributes = paramProperties;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   String processRequest(String paramString1, String paramString2) {
/*      */     String str;
/*  132 */     int i = paramString1.lastIndexOf('.');
/*      */     
/*  134 */     if (i >= 0) {
/*  135 */       str = paramString1.substring(i + 1);
/*      */     } else {
/*  137 */       str = "";
/*      */     } 
/*  139 */     if ("ico".equals(str)) {
/*  140 */       this.mimeType = "image/x-icon";
/*  141 */       this.cache = true;
/*  142 */     } else if ("gif".equals(str)) {
/*  143 */       this.mimeType = "image/gif";
/*  144 */       this.cache = true;
/*  145 */     } else if ("css".equals(str)) {
/*  146 */       this.cache = true;
/*  147 */       this.mimeType = "text/css";
/*  148 */     } else if ("html".equals(str) || "do".equals(str) || "jsp".equals(str)) {
/*      */ 
/*      */       
/*  151 */       this.cache = false;
/*  152 */       this.mimeType = "text/html";
/*  153 */       if (this.session == null) {
/*  154 */         this.session = this.server.createNewSession(paramString2);
/*  155 */         if (!"notAllowed.jsp".equals(paramString1)) {
/*  156 */           paramString1 = "index.do";
/*      */         }
/*      */       } 
/*  159 */     } else if ("js".equals(str)) {
/*  160 */       this.cache = true;
/*  161 */       this.mimeType = "text/javascript";
/*      */     } else {
/*  163 */       this.cache = true;
/*  164 */       this.mimeType = "application/octet-stream";
/*      */     } 
/*  166 */     trace("mimeType=" + this.mimeType);
/*  167 */     trace(paramString1);
/*  168 */     if (paramString1.endsWith(".do")) {
/*  169 */       paramString1 = process(paramString1);
/*      */     }
/*  171 */     return paramString1;
/*      */   }
/*      */   
/*      */   private static String getComboBox(String[] paramArrayOfString, String paramString) {
/*  175 */     StringBuilder stringBuilder = new StringBuilder();
/*  176 */     for (String str : paramArrayOfString) {
/*  177 */       stringBuilder.append("<option value=\"").append(PageParser.escapeHtmlData(str)).append('"');
/*      */ 
/*      */       
/*  180 */       if (str.equals(paramString)) {
/*  181 */         stringBuilder.append(" selected");
/*      */       }
/*  183 */       stringBuilder.append('>').append(PageParser.escapeHtml(str)).append("</option>");
/*      */     } 
/*      */ 
/*      */     
/*  187 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private static String getComboBox(String[][] paramArrayOfString, String paramString) {
/*  191 */     StringBuilder stringBuilder = new StringBuilder();
/*  192 */     for (String[] arrayOfString : paramArrayOfString) {
/*  193 */       stringBuilder.append("<option value=\"").append(PageParser.escapeHtmlData(arrayOfString[0])).append('"');
/*      */ 
/*      */       
/*  196 */       if (arrayOfString[0].equals(paramString)) {
/*  197 */         stringBuilder.append(" selected");
/*      */       }
/*  199 */       stringBuilder.append('>').append(PageParser.escapeHtml(arrayOfString[1])).append("</option>");
/*      */     } 
/*      */ 
/*      */     
/*  203 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private String process(String paramString) {
/*  207 */     trace("process " + paramString);
/*  208 */     while (paramString.endsWith(".do")) {
/*  209 */       if ("login.do".equals(paramString)) {
/*  210 */         paramString = login(); continue;
/*  211 */       }  if ("index.do".equals(paramString)) {
/*  212 */         paramString = index(); continue;
/*  213 */       }  if ("logout.do".equals(paramString)) {
/*  214 */         paramString = logout(); continue;
/*  215 */       }  if ("settingRemove.do".equals(paramString)) {
/*  216 */         paramString = settingRemove(); continue;
/*  217 */       }  if ("settingSave.do".equals(paramString)) {
/*  218 */         paramString = settingSave(); continue;
/*  219 */       }  if ("test.do".equals(paramString)) {
/*  220 */         paramString = test(); continue;
/*  221 */       }  if ("query.do".equals(paramString)) {
/*  222 */         paramString = query(); continue;
/*  223 */       }  if ("tables.do".equals(paramString)) {
/*  224 */         paramString = tables(); continue;
/*  225 */       }  if ("editResult.do".equals(paramString)) {
/*  226 */         paramString = editResult(); continue;
/*  227 */       }  if ("getHistory.do".equals(paramString)) {
/*  228 */         paramString = getHistory(); continue;
/*  229 */       }  if ("admin.do".equals(paramString)) {
/*  230 */         paramString = admin(); continue;
/*  231 */       }  if ("adminSave.do".equals(paramString)) {
/*  232 */         paramString = adminSave(); continue;
/*  233 */       }  if ("adminStartTranslate.do".equals(paramString)) {
/*  234 */         paramString = adminStartTranslate(); continue;
/*  235 */       }  if ("adminShutdown.do".equals(paramString)) {
/*  236 */         paramString = adminShutdown(); continue;
/*  237 */       }  if ("autoCompleteList.do".equals(paramString)) {
/*  238 */         paramString = autoCompleteList(); continue;
/*  239 */       }  if ("tools.do".equals(paramString)) {
/*  240 */         paramString = tools(); continue;
/*      */       } 
/*  242 */       paramString = "error.jsp";
/*      */     } 
/*      */     
/*  245 */     trace("return " + paramString);
/*  246 */     return paramString;
/*      */   }
/*      */   
/*      */   private String autoCompleteList() {
/*  250 */     String str = (String)this.attributes.get("query");
/*  251 */     boolean bool = false;
/*  252 */     if (str.trim().length() > 0 && Character.isLowerCase(str.trim().charAt(0)))
/*      */     {
/*  254 */       bool = true;
/*      */     }
/*      */     try {
/*  257 */       String str1 = str;
/*  258 */       if (str1.endsWith(";")) {
/*  259 */         str1 = str1 + " ";
/*      */       }
/*  261 */       ScriptReader scriptReader = new ScriptReader(new StringReader(str1));
/*  262 */       scriptReader.setSkipRemarks(true);
/*  263 */       String str2 = "";
/*      */       while (true) {
/*  265 */         String str4 = scriptReader.readStatement();
/*  266 */         if (str4 == null) {
/*      */           break;
/*      */         }
/*  269 */         str2 = str4;
/*      */       } 
/*  271 */       String str3 = "";
/*  272 */       if (scriptReader.isInsideRemark()) {
/*  273 */         if (scriptReader.isBlockRemark()) {
/*  274 */           str3 = "1#(End Remark)# */\n" + str3;
/*      */         } else {
/*  276 */           str3 = "1#(Newline)#\n" + str3;
/*      */         } 
/*      */       } else {
/*  279 */         str1 = str2;
/*  280 */         while (str1.length() > 0 && str1.charAt(0) <= ' ') {
/*  281 */           str1 = str1.substring(1);
/*      */         }
/*  283 */         if (str1.trim().length() > 0 && Character.isLowerCase(str1.trim().charAt(0))) {
/*  284 */           bool = true;
/*      */         }
/*  286 */         Bnf bnf = this.session.getBnf();
/*  287 */         if (bnf == null) {
/*  288 */           return "autoCompleteList.jsp";
/*      */         }
/*  290 */         HashMap hashMap = bnf.getNextTokenList(str1);
/*  291 */         String str4 = "";
/*  292 */         if (str1.length() > 0) {
/*  293 */           char c = str1.charAt(str1.length() - 1);
/*  294 */           if (!Character.isWhitespace(c) && c != '.' && c >= ' ' && c != '\'' && c != '"')
/*      */           {
/*  296 */             str4 = " ";
/*      */           }
/*      */         } 
/*  299 */         ArrayList<String> arrayList = New.arrayList(hashMap.size());
/*  300 */         for (Map.Entry entry : hashMap.entrySet()) {
/*  301 */           String str5 = (String)entry.getKey();
/*  302 */           String str6 = (String)entry.getValue();
/*  303 */           String str7 = "" + str5.charAt(0);
/*  304 */           if (Integer.parseInt(str7) > 2) {
/*      */             continue;
/*      */           }
/*  307 */           str5 = str5.substring(2);
/*  308 */           if (Character.isLetter(str5.charAt(0)) && bool) {
/*  309 */             str5 = StringUtils.toLowerEnglish(str5);
/*  310 */             str6 = StringUtils.toLowerEnglish(str6);
/*      */           } 
/*  312 */           if (str5.equals(str6) && !".".equals(str6)) {
/*  313 */             str6 = str4 + str6;
/*      */           }
/*  315 */           str5 = StringUtils.urlEncode(str5);
/*  316 */           str5 = StringUtils.replaceAll(str5, "+", " ");
/*  317 */           str6 = StringUtils.urlEncode(str6);
/*  318 */           str6 = StringUtils.replaceAll(str6, "+", " ");
/*  319 */           arrayList.add(str7 + "#" + str5 + "#" + str6);
/*      */         } 
/*  321 */         Collections.sort(arrayList);
/*  322 */         if (str.endsWith("\n") || str.trim().endsWith(";")) {
/*  323 */           arrayList.add(0, "1#(Newline)#\n");
/*      */         }
/*  325 */         StatementBuilder statementBuilder = new StatementBuilder();
/*  326 */         for (String str5 : arrayList) {
/*  327 */           statementBuilder.appendExceptFirst("|");
/*  328 */           statementBuilder.append(str5);
/*      */         } 
/*  330 */         str3 = statementBuilder.toString();
/*      */       } 
/*  332 */       this.session.put("autoCompleteList", str3);
/*  333 */     } catch (Throwable throwable) {
/*  334 */       this.server.traceError(throwable);
/*      */     } 
/*  336 */     return "autoCompleteList.jsp";
/*      */   }
/*      */   
/*      */   private String admin() {
/*  340 */     this.session.put("port", "" + this.server.getPort());
/*  341 */     this.session.put("allowOthers", "" + this.server.getAllowOthers());
/*  342 */     this.session.put("ssl", String.valueOf(this.server.getSSL()));
/*  343 */     this.session.put("sessions", this.server.getSessions());
/*  344 */     return "admin.jsp";
/*      */   }
/*      */   
/*      */   private String adminSave() {
/*      */     try {
/*  349 */       SortedProperties sortedProperties = new SortedProperties();
/*  350 */       int i = Integer.decode((String)this.attributes.get("port")).intValue();
/*  351 */       sortedProperties.setProperty("webPort", String.valueOf(i));
/*  352 */       this.server.setPort(i);
/*  353 */       boolean bool1 = Boolean.parseBoolean((String)this.attributes.get("allowOthers"));
/*      */       
/*  355 */       sortedProperties.setProperty("webAllowOthers", String.valueOf(bool1));
/*  356 */       this.server.setAllowOthers(bool1);
/*  357 */       boolean bool2 = Boolean.parseBoolean((String)this.attributes.get("ssl"));
/*      */       
/*  359 */       sortedProperties.setProperty("webSSL", String.valueOf(bool2));
/*  360 */       this.server.setSSL(bool2);
/*  361 */       this.server.saveProperties((Properties)sortedProperties);
/*  362 */     } catch (Exception exception) {
/*  363 */       trace(exception.toString());
/*      */     } 
/*  365 */     return admin();
/*      */   }
/*      */   private String tools() {
/*      */     try {
/*      */       CreateCluster createCluster;
/*  370 */       String str1 = (String)this.attributes.get("tool");
/*  371 */       this.session.put("tool", str1);
/*  372 */       String str2 = (String)this.attributes.get("args");
/*  373 */       String[] arrayOfString = StringUtils.arraySplit(str2, ',', false);
/*  374 */       Backup backup = null;
/*  375 */       if ("Backup".equals(str1)) {
/*  376 */         backup = new Backup();
/*  377 */       } else if ("Restore".equals(str1)) {
/*  378 */         Restore restore = new Restore();
/*  379 */       } else if ("Recover".equals(str1)) {
/*  380 */         Recover recover = new Recover();
/*  381 */       } else if ("DeleteDbFiles".equals(str1)) {
/*  382 */         DeleteDbFiles deleteDbFiles = new DeleteDbFiles();
/*  383 */       } else if ("ChangeFileEncryption".equals(str1)) {
/*  384 */         ChangeFileEncryption changeFileEncryption = new ChangeFileEncryption();
/*  385 */       } else if ("Script".equals(str1)) {
/*  386 */         Script script = new Script();
/*  387 */       } else if ("RunScript".equals(str1)) {
/*  388 */         RunScript runScript = new RunScript();
/*  389 */       } else if ("ConvertTraceFile".equals(str1)) {
/*  390 */         ConvertTraceFile convertTraceFile = new ConvertTraceFile();
/*  391 */       } else if ("CreateCluster".equals(str1)) {
/*  392 */         createCluster = new CreateCluster();
/*      */       } else {
/*  394 */         throw DbException.throwInternalError(str1);
/*      */       } 
/*  396 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  397 */       PrintStream printStream = new PrintStream(byteArrayOutputStream, false, "UTF-8");
/*  398 */       createCluster.setOut(printStream);
/*      */       try {
/*  400 */         createCluster.runTool(arrayOfString);
/*  401 */         printStream.flush();
/*  402 */         String str3 = new String(byteArrayOutputStream.toByteArray(), Constants.UTF8);
/*  403 */         String str4 = PageParser.escapeHtml(str3);
/*  404 */         this.session.put("toolResult", str4);
/*  405 */       } catch (Exception exception) {
/*  406 */         this.session.put("toolResult", getStackTrace(0, exception, true));
/*      */       } 
/*  408 */     } catch (Exception exception) {
/*  409 */       this.server.traceError(exception);
/*      */     } 
/*  411 */     return "tools.jsp";
/*      */   }
/*      */   
/*      */   private String adminStartTranslate() {
/*  415 */     Map<Object, Object> map1 = Map.class.cast(this.session.map.get("text"));
/*      */     
/*  417 */     Map<Object, Object> map2 = map1;
/*  418 */     String str = this.server.startTranslate(map2);
/*  419 */     this.session.put("translationFile", str);
/*  420 */     return "helpTranslate.jsp";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String adminShutdown() {
/*  429 */     this.server.shutdown();
/*  430 */     return "admin.jsp";
/*      */   }
/*      */   
/*      */   private String index() {
/*  434 */     String[][] arrayOfString = WebServer.LANGUAGES;
/*  435 */     String str1 = (String)this.attributes.get("language");
/*  436 */     Locale locale = this.session.locale;
/*  437 */     if (str1 != null) {
/*  438 */       if (locale == null || !StringUtils.toLowerEnglish(locale.getLanguage()).equals(str1)) {
/*      */         
/*  440 */         locale = new Locale(str1, "");
/*  441 */         this.server.readTranslations(this.session, locale.getLanguage());
/*  442 */         this.session.put("language", str1);
/*  443 */         this.session.locale = locale;
/*      */       } 
/*      */     } else {
/*  446 */       str1 = (String)this.session.get("language");
/*      */     } 
/*  448 */     if (str1 == null)
/*      */     {
/*      */       
/*  451 */       str1 = this.headerLanguage;
/*      */     }
/*  453 */     this.session.put("languageCombo", getComboBox(arrayOfString, str1));
/*  454 */     String[] arrayOfString1 = this.server.getSettingNames();
/*  455 */     String str2 = this.attributes.getProperty("setting");
/*  456 */     if (str2 == null && arrayOfString1.length > 0) {
/*  457 */       str2 = arrayOfString1[0];
/*      */     }
/*  459 */     String str3 = getComboBox(arrayOfString1, str2);
/*  460 */     this.session.put("settingsList", str3);
/*  461 */     ConnectionInfo connectionInfo = this.server.getSetting(str2);
/*  462 */     if (connectionInfo == null) {
/*  463 */       connectionInfo = new ConnectionInfo();
/*      */     }
/*  465 */     this.session.put("setting", PageParser.escapeHtmlData(str2));
/*  466 */     this.session.put("name", PageParser.escapeHtmlData(str2));
/*  467 */     this.session.put("driver", PageParser.escapeHtmlData(connectionInfo.driver));
/*  468 */     this.session.put("url", PageParser.escapeHtmlData(connectionInfo.url));
/*  469 */     this.session.put("user", PageParser.escapeHtmlData(connectionInfo.user));
/*  470 */     return "index.jsp";
/*      */   }
/*      */   
/*      */   private String getHistory() {
/*  474 */     int i = Integer.parseInt(this.attributes.getProperty("id"));
/*  475 */     String str = this.session.getCommand(i);
/*  476 */     this.session.put("query", PageParser.escapeHtmlData(str));
/*  477 */     return "query.jsp";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static int addColumns(boolean paramBoolean1, DbTableOrView paramDbTableOrView, StringBuilder paramStringBuilder1, int paramInt, boolean paramBoolean2, StringBuilder paramStringBuilder2) {
/*  483 */     DbColumn[] arrayOfDbColumn = paramDbTableOrView.getColumns();
/*  484 */     for (byte b = 0; arrayOfDbColumn != null && b < arrayOfDbColumn.length; b++) {
/*  485 */       DbColumn dbColumn = arrayOfDbColumn[b];
/*  486 */       if (paramStringBuilder2.length() > 0) {
/*  487 */         paramStringBuilder2.append(' ');
/*      */       }
/*  489 */       paramStringBuilder2.append(dbColumn.getName());
/*  490 */       String str1 = escapeIdentifier(dbColumn.getName());
/*  491 */       String str2 = paramBoolean1 ? ", 1, 1" : ", 2, 2";
/*  492 */       paramStringBuilder1.append("setNode(" + paramInt + str2 + ", 'column', '" + PageParser.escapeJavaScript(dbColumn.getName()) + "', 'javascript:ins(\\'" + str1 + "\\')');\n");
/*      */ 
/*      */       
/*  495 */       paramInt++;
/*  496 */       if (paramBoolean1 && paramBoolean2) {
/*  497 */         paramStringBuilder1.append("setNode(" + paramInt + ", 2, 2, 'type', '" + PageParser.escapeJavaScript(dbColumn.getDataType()) + "', null);\n");
/*      */ 
/*      */         
/*  500 */         paramInt++;
/*      */       } 
/*      */     } 
/*  503 */     return paramInt;
/*      */   }
/*      */   
/*      */   private static String escapeIdentifier(String paramString) {
/*  507 */     return StringUtils.urlEncode(PageParser.escapeJavaScript(paramString)).replace('+', ' ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class IndexInfo
/*      */   {
/*      */     String name;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     String type;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     String columns;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int addIndexes(boolean paramBoolean, DatabaseMetaData paramDatabaseMetaData, String paramString1, String paramString2, StringBuilder paramStringBuilder, int paramInt) throws SQLException {
/*      */     ResultSet resultSet;
/*      */     try {
/*  537 */       resultSet = paramDatabaseMetaData.getIndexInfo(null, paramString2, paramString1, false, true);
/*  538 */     } catch (SQLException sQLException) {
/*      */       
/*  540 */       return paramInt;
/*      */     } 
/*  542 */     HashMap<String, IndexInfo> hashMap = New.hashMap();
/*  543 */     while (resultSet.next()) {
/*  544 */       String str = resultSet.getString("INDEX_NAME");
/*  545 */       IndexInfo indexInfo = (IndexInfo)hashMap.get(str);
/*  546 */       if (indexInfo == null) {
/*  547 */         String str1; int i = resultSet.getInt("TYPE");
/*      */         
/*  549 */         if (i == 1) {
/*  550 */           str1 = "";
/*  551 */         } else if (i == 2) {
/*  552 */           str1 = " (${text.tree.hashed})";
/*  553 */         } else if (i == 3) {
/*  554 */           str1 = "";
/*      */         } else {
/*  556 */           str1 = null;
/*      */         } 
/*  558 */         if (str != null && str1 != null) {
/*  559 */           indexInfo = new IndexInfo();
/*  560 */           indexInfo.name = str;
/*  561 */           str1 = (resultSet.getBoolean("NON_UNIQUE") ? "${text.tree.nonUnique}" : "${text.tree.unique}") + str1;
/*      */           
/*  563 */           indexInfo.type = str1;
/*  564 */           indexInfo.columns = resultSet.getString("COLUMN_NAME");
/*  565 */           hashMap.put(str, indexInfo);
/*      */         }  continue;
/*      */       } 
/*  568 */       indexInfo.columns += ", " + resultSet.getString("COLUMN_NAME");
/*      */     } 
/*      */     
/*  571 */     resultSet.close();
/*  572 */     if (hashMap.size() > 0) {
/*  573 */       String str1 = paramBoolean ? ", 1, 1" : ", 2, 1";
/*  574 */       String str2 = paramBoolean ? ", 2, 1" : ", 3, 1";
/*  575 */       String str3 = paramBoolean ? ", 3, 2" : ", 4, 2";
/*  576 */       paramStringBuilder.append("setNode(" + paramInt + str1 + ", 'index_az', '${text.tree.indexes}', null);\n");
/*      */       
/*  578 */       paramInt++;
/*  579 */       for (IndexInfo indexInfo : hashMap.values()) {
/*  580 */         paramStringBuilder.append("setNode(" + paramInt + str2 + ", 'index', '" + PageParser.escapeJavaScript(indexInfo.name) + "', null);\n");
/*      */ 
/*      */         
/*  583 */         paramInt++;
/*  584 */         paramStringBuilder.append("setNode(" + paramInt + str3 + ", 'type', '" + indexInfo.type + "', null);\n");
/*      */         
/*  586 */         paramInt++;
/*  587 */         paramStringBuilder.append("setNode(" + paramInt + str3 + ", 'type', '" + PageParser.escapeJavaScript(indexInfo.columns) + "', null);\n");
/*      */ 
/*      */ 
/*      */         
/*  591 */         paramInt++;
/*      */       } 
/*      */     } 
/*  594 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int addTablesAndViews(DbSchema paramDbSchema, boolean paramBoolean, StringBuilder paramStringBuilder, int paramInt) throws SQLException {
/*  599 */     if (paramDbSchema == null) {
/*  600 */       return paramInt;
/*      */     }
/*  602 */     Connection connection = this.session.getConnection();
/*  603 */     DatabaseMetaData databaseMetaData = this.session.getMetaData();
/*  604 */     byte b = paramBoolean ? 0 : 1;
/*  605 */     boolean bool1 = (paramBoolean || !paramDbSchema.isSystem) ? true : false;
/*  606 */     String str1 = ", " + b + ", " + (bool1 ? "1" : "2") + ", ";
/*  607 */     String str2 = ", " + (b + 1) + ", 2, ";
/*  608 */     DbTableOrView[] arrayOfDbTableOrView = paramDbSchema.getTables();
/*  609 */     if (arrayOfDbTableOrView == null) {
/*  610 */       return paramInt;
/*      */     }
/*  612 */     boolean bool = paramDbSchema.getContents().isOracle();
/*  613 */     boolean bool2 = (arrayOfDbTableOrView.length < SysProperties.CONSOLE_MAX_TABLES_LIST_INDEXES) ? true : false;
/*  614 */     for (DbTableOrView dbTableOrView : arrayOfDbTableOrView) {
/*  615 */       if (!dbTableOrView.isView()) {
/*      */ 
/*      */         
/*  618 */         int i = paramInt;
/*  619 */         String str = dbTableOrView.getQuotedName();
/*  620 */         if (!paramBoolean) {
/*  621 */           str = paramDbSchema.quotedName + "." + str;
/*      */         }
/*  623 */         str = escapeIdentifier(str);
/*  624 */         paramStringBuilder.append("setNode(" + paramInt + str1 + " 'table', '" + PageParser.escapeJavaScript(dbTableOrView.getName()) + "', 'javascript:ins(\\'" + str + "\\',true)');\n");
/*      */ 
/*      */         
/*  627 */         paramInt++;
/*  628 */         if (paramBoolean || bool1) {
/*  629 */           StringBuilder stringBuilder = new StringBuilder();
/*  630 */           paramInt = addColumns(paramBoolean, dbTableOrView, paramStringBuilder, paramInt, bool2, stringBuilder);
/*      */           
/*  632 */           if (!bool && bool2) {
/*  633 */             paramInt = addIndexes(paramBoolean, databaseMetaData, dbTableOrView.getName(), paramDbSchema.name, paramStringBuilder, paramInt);
/*      */           }
/*      */           
/*  636 */           paramStringBuilder.append("addTable('" + PageParser.escapeJavaScript(dbTableOrView.getName()) + "', '" + PageParser.escapeJavaScript(stringBuilder.toString()) + "', " + i + ");\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  642 */     arrayOfDbTableOrView = paramDbSchema.getTables();
/*  643 */     for (DbTableOrView dbTableOrView : arrayOfDbTableOrView) {
/*  644 */       if (dbTableOrView.isView()) {
/*      */ 
/*      */         
/*  647 */         int i = paramInt;
/*  648 */         String str = dbTableOrView.getQuotedName();
/*  649 */         if (!paramBoolean) {
/*  650 */           str = (dbTableOrView.getSchema()).quotedName + "." + str;
/*      */         }
/*  652 */         str = escapeIdentifier(str);
/*  653 */         paramStringBuilder.append("setNode(" + paramInt + str1 + " 'view', '" + PageParser.escapeJavaScript(dbTableOrView.getName()) + "', 'javascript:ins(\\'" + str + "\\',true)');\n");
/*      */ 
/*      */         
/*  656 */         paramInt++;
/*  657 */         if (paramBoolean) {
/*  658 */           StringBuilder stringBuilder = new StringBuilder();
/*  659 */           paramInt = addColumns(paramBoolean, dbTableOrView, paramStringBuilder, paramInt, bool2, stringBuilder);
/*      */           
/*  661 */           if (paramDbSchema.getContents().isH2())
/*      */           {
/*  663 */             try (PreparedStatement null = connection.prepareStatement("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME=?")) {
/*      */               
/*  665 */               preparedStatement.setString(1, dbTableOrView.getName());
/*  666 */               ResultSet resultSet = preparedStatement.executeQuery();
/*  667 */               if (resultSet.next()) {
/*  668 */                 String str3 = resultSet.getString("SQL");
/*  669 */                 paramStringBuilder.append("setNode(" + paramInt + str2 + " 'type', '" + PageParser.escapeJavaScript(str3) + "', null);\n");
/*      */ 
/*      */ 
/*      */                 
/*  673 */                 paramInt++;
/*      */               } 
/*  675 */               resultSet.close();
/*      */             } 
/*      */           }
/*  678 */           paramStringBuilder.append("addTable('" + PageParser.escapeJavaScript(dbTableOrView.getName()) + "', '" + PageParser.escapeJavaScript(stringBuilder.toString()) + "', " + i + ");\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  684 */     return paramInt;
/*      */   }
/*      */   
/*      */   private String tables() {
/*  688 */     DbContents dbContents = this.session.getContents();
/*  689 */     boolean bool = false;
/*      */     try {
/*  691 */       String str1 = (String)this.session.get("url");
/*  692 */       Connection connection = this.session.getConnection();
/*  693 */       dbContents.readContents(str1, connection);
/*  694 */       this.session.loadBnf();
/*  695 */       bool = dbContents.isH2();
/*      */       
/*  697 */       StringBuilder stringBuilder = new StringBuilder();
/*  698 */       stringBuilder.append("setNode(0, 0, 0, 'database', '" + PageParser.escapeJavaScript(str1) + "', null);\n");
/*      */       
/*  700 */       int i = 1;
/*      */       
/*  702 */       DbSchema dbSchema = dbContents.getDefaultSchema();
/*  703 */       i = addTablesAndViews(dbSchema, true, stringBuilder, i);
/*  704 */       DbSchema[] arrayOfDbSchema = dbContents.getSchemas();
/*  705 */       for (DbSchema dbSchema1 : arrayOfDbSchema) {
/*  706 */         if (dbSchema1 != dbSchema && dbSchema1 != null) {
/*      */ 
/*      */           
/*  709 */           stringBuilder.append("setNode(" + i + ", 0, 1, 'folder', '" + PageParser.escapeJavaScript(dbSchema1.name) + "', null);\n");
/*      */ 
/*      */           
/*  712 */           i++;
/*  713 */           i = addTablesAndViews(dbSchema1, false, stringBuilder, i);
/*      */         } 
/*  715 */       }  if (bool) {
/*  716 */         try (Statement null = connection.createStatement()) {
/*  717 */           ResultSet resultSet = statement.executeQuery("SELECT * FROM INFORMATION_SCHEMA.SEQUENCES ORDER BY SEQUENCE_NAME");
/*      */           byte b;
/*  719 */           for (b = 0; resultSet.next(); b++) {
/*  720 */             if (!b) {
/*  721 */               stringBuilder.append("setNode(" + i + ", 0, 1, 'sequences', '${text.tree.sequences}', null);\n");
/*      */               
/*  723 */               i++;
/*      */             } 
/*  725 */             String str3 = resultSet.getString("SEQUENCE_NAME");
/*  726 */             String str4 = resultSet.getString("CURRENT_VALUE");
/*  727 */             String str5 = resultSet.getString("INCREMENT");
/*  728 */             stringBuilder.append("setNode(" + i + ", 1, 1, 'sequence', '" + PageParser.escapeJavaScript(str3) + "', null);\n");
/*      */ 
/*      */ 
/*      */             
/*  732 */             i++;
/*  733 */             stringBuilder.append("setNode(" + i + ", 2, 2, 'type', '${text.tree.current}: " + PageParser.escapeJavaScript(str4) + "', null);\n");
/*      */ 
/*      */ 
/*      */             
/*  737 */             i++;
/*  738 */             if (!"1".equals(str5)) {
/*  739 */               stringBuilder.append("setNode(" + i + ", 2, 2, 'type', '${text.tree.increment}: " + PageParser.escapeJavaScript(str5) + "', null);\n");
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  744 */               i++;
/*      */             } 
/*      */           } 
/*  747 */           resultSet.close();
/*  748 */           resultSet = statement.executeQuery("SELECT * FROM INFORMATION_SCHEMA.USERS ORDER BY NAME");
/*      */           
/*  750 */           for (b = 0; resultSet.next(); b++) {
/*  751 */             if (b == 0) {
/*  752 */               stringBuilder.append("setNode(" + i + ", 0, 1, 'users', '${text.tree.users}', null);\n");
/*      */               
/*  754 */               i++;
/*      */             } 
/*  756 */             String str3 = resultSet.getString("NAME");
/*  757 */             String str4 = resultSet.getString("ADMIN");
/*  758 */             stringBuilder.append("setNode(" + i + ", 1, 1, 'user', '" + PageParser.escapeJavaScript(str3) + "', null);\n");
/*      */ 
/*      */ 
/*      */             
/*  762 */             i++;
/*  763 */             if (str4.equalsIgnoreCase("TRUE")) {
/*  764 */               stringBuilder.append("setNode(" + i + ", 2, 2, 'type', '${text.tree.admin}', null);\n");
/*      */               
/*  766 */               i++;
/*      */             } 
/*      */           } 
/*  769 */           resultSet.close();
/*      */         } 
/*      */       }
/*  772 */       DatabaseMetaData databaseMetaData = this.session.getMetaData();
/*  773 */       String str2 = databaseMetaData.getDatabaseProductName() + " " + databaseMetaData.getDatabaseProductVersion();
/*      */       
/*  775 */       stringBuilder.append("setNode(" + i + ", 0, 0, 'info', '" + PageParser.escapeJavaScript(str2) + "', null);\n");
/*      */       
/*  777 */       stringBuilder.append("refreshQueryTables();");
/*  778 */       this.session.put("tree", stringBuilder.toString());
/*  779 */     } catch (Exception exception) {
/*  780 */       this.session.put("tree", "");
/*  781 */       this.session.put("error", getStackTrace(0, exception, bool));
/*      */     } 
/*  783 */     return "tables.jsp";
/*      */   }
/*      */   
/*      */   private String getStackTrace(int paramInt, Throwable paramThrowable, boolean paramBoolean) {
/*      */     try {
/*  788 */       StringWriter stringWriter = new StringWriter();
/*  789 */       paramThrowable.printStackTrace(new PrintWriter(stringWriter));
/*  790 */       String str1 = stringWriter.toString();
/*  791 */       str1 = PageParser.escapeHtml(str1);
/*  792 */       if (paramBoolean) {
/*  793 */         str1 = linkToSource(str1);
/*      */       }
/*  795 */       str1 = StringUtils.replaceAll(str1, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
/*      */       
/*  797 */       String str2 = PageParser.escapeHtml(paramThrowable.getMessage());
/*  798 */       String str3 = "<a class=\"error\" href=\"#\" onclick=\"var x=document.getElementById('st" + paramInt + "').style;x.display=x.display==''?'none':'';\">" + str2 + "</a>";
/*      */ 
/*      */ 
/*      */       
/*  802 */       if (paramThrowable instanceof SQLException) {
/*  803 */         SQLException sQLException = (SQLException)paramThrowable;
/*  804 */         str3 = str3 + " " + sQLException.getSQLState() + "/" + sQLException.getErrorCode();
/*  805 */         if (paramBoolean) {
/*  806 */           int i = sQLException.getErrorCode();
/*  807 */           str3 = str3 + " <a href=\"http://h2database.com/javadoc/org/h2/api/ErrorCode.html#c" + i + "\">(${text.a.help})</a>";
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  812 */       str3 = str3 + "<span style=\"display: none;\" id=\"st" + paramInt + "\"><br />" + str1 + "</span>";
/*      */       
/*  814 */       str3 = formatAsError(str3);
/*  815 */       return str3;
/*  816 */     } catch (OutOfMemoryError outOfMemoryError) {
/*  817 */       this.server.traceError(paramThrowable);
/*  818 */       return paramThrowable.toString();
/*      */     } 
/*      */   }
/*      */   
/*      */   private static String linkToSource(String paramString) {
/*      */     try {
/*  824 */       StringBuilder stringBuilder = new StringBuilder(paramString.length());
/*  825 */       int i = paramString.indexOf("<br />");
/*  826 */       stringBuilder.append(paramString.substring(0, i));
/*      */       while (true) {
/*  828 */         int j = paramString.indexOf("org.h2.", i);
/*  829 */         if (j < 0) {
/*  830 */           stringBuilder.append(paramString.substring(i));
/*      */           break;
/*      */         } 
/*  833 */         stringBuilder.append(paramString.substring(i, j));
/*  834 */         int k = paramString.indexOf(')', j);
/*  835 */         if (k < 0) {
/*  836 */           stringBuilder.append(paramString.substring(i));
/*      */           break;
/*      */         } 
/*  839 */         String str1 = paramString.substring(j, k);
/*  840 */         int m = str1.lastIndexOf('(');
/*  841 */         int n = str1.lastIndexOf('.', m - 1);
/*  842 */         int i1 = str1.lastIndexOf('.', n - 1);
/*  843 */         String str2 = str1.substring(0, i1);
/*  844 */         int i2 = str1.lastIndexOf(':');
/*  845 */         String str3 = str1.substring(m + 1, i2);
/*  846 */         String str4 = str1.substring(i2 + 1, str1.length());
/*  847 */         String str5 = str2.replace('.', '/') + "/" + str3;
/*  848 */         stringBuilder.append("<a href=\"http://h2database.com/html/source.html?file=");
/*  849 */         stringBuilder.append(str5);
/*  850 */         stringBuilder.append("&line=");
/*  851 */         stringBuilder.append(str4);
/*  852 */         stringBuilder.append("&build=");
/*  853 */         stringBuilder.append(193);
/*  854 */         stringBuilder.append("\">");
/*  855 */         stringBuilder.append(str1);
/*  856 */         stringBuilder.append("</a>");
/*  857 */         i = k;
/*      */       } 
/*  859 */       return stringBuilder.toString();
/*  860 */     } catch (Throwable throwable) {
/*  861 */       return paramString;
/*      */     } 
/*      */   }
/*      */   
/*      */   private static String formatAsError(String paramString) {
/*  866 */     return "<div class=\"error\">" + paramString + "</div>";
/*      */   }
/*      */   
/*      */   private String test() {
/*  870 */     String str1 = this.attributes.getProperty("driver", "");
/*  871 */     String str2 = this.attributes.getProperty("url", "");
/*  872 */     String str3 = this.attributes.getProperty("user", "");
/*  873 */     String str4 = this.attributes.getProperty("password", "");
/*  874 */     this.session.put("driver", str1);
/*  875 */     this.session.put("url", str2);
/*  876 */     this.session.put("user", str3);
/*  877 */     boolean bool = str2.startsWith("jdbc:h2:"); try {
/*      */       Connection connection; String str7;
/*  879 */       long l1 = System.currentTimeMillis();
/*  880 */       String str5 = "", str6 = "";
/*  881 */       Profiler profiler = new Profiler();
/*  882 */       profiler.startCollecting();
/*      */       
/*      */       try {
/*  885 */         connection = this.server.getConnection(str1, str2, str3, str4);
/*      */       } finally {
/*  887 */         profiler.stopCollecting();
/*  888 */         str5 = profiler.getTop(3);
/*      */       } 
/*  890 */       profiler = new Profiler();
/*  891 */       profiler.startCollecting();
/*      */       try {
/*  893 */         JdbcUtils.closeSilently(connection);
/*      */       } finally {
/*  895 */         profiler.stopCollecting();
/*  896 */         str6 = profiler.getTop(3);
/*      */       } 
/*  898 */       long l2 = System.currentTimeMillis() - l1;
/*      */       
/*  900 */       if (l2 > 1000L) {
/*  901 */         str7 = "<a class=\"error\" href=\"#\" onclick=\"var x=document.getElementById('prof').style;x.display=x.display==''?'none':'';\">${text.login.testSuccessful}</a><span style=\"display: none;\" id=\"prof\"><br />" + PageParser.escapeHtml(str5) + "<br />" + PageParser.escapeHtml(str6) + "</span>";
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  911 */         str7 = "${text.login.testSuccessful}";
/*      */       } 
/*  913 */       this.session.put("error", str7);
/*      */       
/*  915 */       return "login.jsp";
/*  916 */     } catch (Exception exception) {
/*  917 */       this.session.put("error", getLoginError(exception, bool));
/*  918 */       return "login.jsp";
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getLoginError(Exception paramException, boolean paramBoolean) {
/*  930 */     if (paramException instanceof JdbcSQLException && ((JdbcSQLException)paramException).getErrorCode() == 90086)
/*      */     {
/*  932 */       return "${text.login.driverNotFound}<br />" + getStackTrace(0, paramException, paramBoolean);
/*      */     }
/*  934 */     return getStackTrace(0, paramException, paramBoolean);
/*      */   }
/*      */   
/*      */   private String login() {
/*  938 */     String str1 = this.attributes.getProperty("driver", "");
/*  939 */     String str2 = this.attributes.getProperty("url", "");
/*  940 */     String str3 = this.attributes.getProperty("user", "");
/*  941 */     String str4 = this.attributes.getProperty("password", "");
/*  942 */     this.session.put("autoCommit", "checked");
/*  943 */     this.session.put("autoComplete", "1");
/*  944 */     this.session.put("maxrows", "1000");
/*  945 */     boolean bool = str2.startsWith("jdbc:h2:");
/*      */     try {
/*  947 */       Connection connection = this.server.getConnection(str1, str2, str3, str4);
/*  948 */       this.session.setConnection(connection);
/*  949 */       this.session.put("url", str2);
/*  950 */       this.session.put("user", str3);
/*  951 */       this.session.remove("error");
/*  952 */       settingSave();
/*  953 */       return "frame.jsp";
/*  954 */     } catch (Exception exception) {
/*  955 */       this.session.put("error", getLoginError(exception, bool));
/*  956 */       return "login.jsp";
/*      */     } 
/*      */   }
/*      */   
/*      */   private String logout() {
/*      */     try {
/*  962 */       Connection connection = this.session.getConnection();
/*  963 */       this.session.setConnection(null);
/*  964 */       this.session.remove("conn");
/*  965 */       this.session.remove("result");
/*  966 */       this.session.remove("tables");
/*  967 */       this.session.remove("user");
/*  968 */       this.session.remove("tool");
/*  969 */       if (connection != null) {
/*  970 */         if (this.session.getShutdownServerOnDisconnect()) {
/*  971 */           this.server.shutdown();
/*      */         } else {
/*  973 */           connection.close();
/*      */         } 
/*      */       }
/*  976 */     } catch (Exception exception) {
/*  977 */       trace(exception.toString());
/*      */     } 
/*  979 */     return "index.do";
/*      */   }
/*      */   
/*      */   private String query() {
/*  983 */     String str = this.attributes.getProperty("sql").trim();
/*      */     try {
/*  985 */       ScriptReader scriptReader = new ScriptReader(new StringReader(str));
/*  986 */       final ArrayList<String> list = New.arrayList();
/*      */       while (true) {
/*  988 */         String str2 = scriptReader.readStatement();
/*  989 */         if (str2 == null) {
/*      */           break;
/*      */         }
/*  992 */         arrayList.add(str2);
/*      */       } 
/*  994 */       final Connection conn = this.session.getConnection();
/*  995 */       if (SysProperties.CONSOLE_STREAM && this.server.getAllowChunked()) {
/*  996 */         String str2 = new String(this.server.getFile("result.jsp"), Constants.UTF8);
/*  997 */         int i = str2.indexOf("${result}");
/*      */ 
/*      */         
/* 1000 */         arrayList.add(0, str2.substring(0, i));
/* 1001 */         arrayList.add(str2.substring(i + "${result}".length()));
/* 1002 */         this.session.put("chunks", new Iterator<String>() {
/*      */               private int i;
/*      */               
/*      */               public boolean hasNext() {
/* 1006 */                 return (this.i < list.size());
/*      */               }
/*      */               
/*      */               public String next() {
/* 1010 */                 String str = list.get(this.i++);
/* 1011 */                 if (this.i == 1 || this.i == list.size()) {
/* 1012 */                   return str;
/*      */                 }
/* 1014 */                 StringBuilder stringBuilder = new StringBuilder();
/* 1015 */                 WebApp.this.query(conn, str, this.i - 1, list.size() - 2, stringBuilder);
/* 1016 */                 return stringBuilder.toString();
/*      */               }
/*      */               
/*      */               public void remove() {
/* 1020 */                 throw new UnsupportedOperationException();
/*      */               }
/*      */             });
/* 1023 */         return "result.jsp";
/*      */       } 
/*      */       
/* 1026 */       StringBuilder stringBuilder = new StringBuilder();
/* 1027 */       for (byte b = 0; b < arrayList.size(); b++) {
/* 1028 */         String str2 = arrayList.get(b);
/* 1029 */         query(connection, str2, b, arrayList.size(), stringBuilder);
/*      */       } 
/* 1031 */       String str1 = stringBuilder.toString();
/* 1032 */       this.session.put("result", str1);
/* 1033 */     } catch (Throwable throwable) {
/* 1034 */       this.session.put("result", getStackTrace(0, throwable, this.session.getContents().isH2()));
/*      */     } 
/* 1036 */     return "result.jsp";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void query(Connection paramConnection, String paramString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) {
/* 1049 */     if (!paramString.startsWith("@") || !paramString.endsWith(".")) {
/* 1050 */       paramStringBuilder.append(PageParser.escapeHtml(paramString + ";")).append("<br />");
/*      */     }
/* 1052 */     boolean bool = paramString.startsWith("@edit");
/* 1053 */     paramStringBuilder.append(getResult(paramConnection, paramInt1 + 1, paramString, (paramInt2 == 1), bool)).append("<br />");
/*      */   }
/*      */ 
/*      */   
/*      */   private String editResult() {
/* 1058 */     ResultSet resultSet = this.session.result;
/* 1059 */     int i = Integer.parseInt(this.attributes.getProperty("row"));
/* 1060 */     int j = Integer.parseInt(this.attributes.getProperty("op"));
/* 1061 */     String str1 = "", str2 = "";
/*      */     try {
/* 1063 */       if (j == 1) {
/* 1064 */         boolean bool = (i < 0) ? true : false;
/* 1065 */         if (bool) {
/* 1066 */           resultSet.moveToInsertRow();
/*      */         } else {
/* 1068 */           resultSet.absolute(i);
/*      */         } 
/* 1070 */         for (byte b = 0; b < resultSet.getMetaData().getColumnCount(); b++) {
/* 1071 */           String str = this.attributes.getProperty("r" + i + "c" + (b + 1));
/* 1072 */           unescapeData(str, resultSet, b + 1);
/*      */         } 
/* 1074 */         if (bool) {
/* 1075 */           resultSet.insertRow();
/*      */         } else {
/* 1077 */           resultSet.updateRow();
/*      */         } 
/* 1079 */       } else if (j == 2) {
/* 1080 */         resultSet.absolute(i);
/* 1081 */         resultSet.deleteRow();
/* 1082 */       } else if (j == 3) {
/*      */       
/*      */       } 
/* 1085 */     } catch (Throwable throwable) {
/* 1086 */       str1 = "<br />" + getStackTrace(0, throwable, this.session.getContents().isH2());
/* 1087 */       str2 = formatAsError(throwable.getMessage());
/*      */     } 
/* 1089 */     String str3 = "@edit " + (String)this.session.get("resultSetSQL");
/* 1090 */     Connection connection = this.session.getConnection();
/* 1091 */     str1 = str2 + getResult(connection, -1, str3, true, true) + str1;
/* 1092 */     this.session.put("result", str1);
/* 1093 */     return "result.jsp";
/*      */   }
/*      */ 
/*      */   
/*      */   private ResultSet getMetaResultSet(Connection paramConnection, String paramString) throws SQLException {
/* 1098 */     DatabaseMetaData databaseMetaData = paramConnection.getMetaData();
/* 1099 */     if (isBuiltIn(paramString, "@best_row_identifier")) {
/* 1100 */       String[] arrayOfString = split(paramString);
/* 1101 */       boolean bool1 = (arrayOfString[4] == null) ? false : Integer.parseInt(arrayOfString[4]);
/* 1102 */       boolean bool2 = (arrayOfString[5] == null) ? false : Boolean.parseBoolean(arrayOfString[5]);
/* 1103 */       return databaseMetaData.getBestRowIdentifier(arrayOfString[1], arrayOfString[2], arrayOfString[3], bool1, bool2);
/* 1104 */     }  if (isBuiltIn(paramString, "@catalogs"))
/* 1105 */       return databaseMetaData.getCatalogs(); 
/* 1106 */     if (isBuiltIn(paramString, "@columns")) {
/* 1107 */       String[] arrayOfString = split(paramString);
/* 1108 */       return databaseMetaData.getColumns(arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4]);
/* 1109 */     }  if (isBuiltIn(paramString, "@column_privileges")) {
/* 1110 */       String[] arrayOfString = split(paramString);
/* 1111 */       return databaseMetaData.getColumnPrivileges(arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4]);
/* 1112 */     }  if (isBuiltIn(paramString, "@cross_references")) {
/* 1113 */       String[] arrayOfString = split(paramString);
/* 1114 */       return databaseMetaData.getCrossReference(arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4], arrayOfString[5], arrayOfString[6]);
/* 1115 */     }  if (isBuiltIn(paramString, "@exported_keys")) {
/* 1116 */       String[] arrayOfString = split(paramString);
/* 1117 */       return databaseMetaData.getExportedKeys(arrayOfString[1], arrayOfString[2], arrayOfString[3]);
/* 1118 */     }  if (isBuiltIn(paramString, "@imported_keys")) {
/* 1119 */       String[] arrayOfString = split(paramString);
/* 1120 */       return databaseMetaData.getImportedKeys(arrayOfString[1], arrayOfString[2], arrayOfString[3]);
/* 1121 */     }  if (isBuiltIn(paramString, "@index_info")) {
/* 1122 */       String[] arrayOfString = split(paramString);
/* 1123 */       boolean bool1 = (arrayOfString[4] == null) ? false : Boolean.parseBoolean(arrayOfString[4]);
/* 1124 */       boolean bool2 = (arrayOfString[5] == null) ? false : Boolean.parseBoolean(arrayOfString[5]);
/* 1125 */       return databaseMetaData.getIndexInfo(arrayOfString[1], arrayOfString[2], arrayOfString[3], bool1, bool2);
/* 1126 */     }  if (isBuiltIn(paramString, "@primary_keys")) {
/* 1127 */       String[] arrayOfString = split(paramString);
/* 1128 */       return databaseMetaData.getPrimaryKeys(arrayOfString[1], arrayOfString[2], arrayOfString[3]);
/* 1129 */     }  if (isBuiltIn(paramString, "@procedures")) {
/* 1130 */       String[] arrayOfString = split(paramString);
/* 1131 */       return databaseMetaData.getProcedures(arrayOfString[1], arrayOfString[2], arrayOfString[3]);
/* 1132 */     }  if (isBuiltIn(paramString, "@procedure_columns")) {
/* 1133 */       String[] arrayOfString = split(paramString);
/* 1134 */       return databaseMetaData.getProcedureColumns(arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4]);
/* 1135 */     }  if (isBuiltIn(paramString, "@schemas"))
/* 1136 */       return databaseMetaData.getSchemas(); 
/* 1137 */     if (isBuiltIn(paramString, "@tables")) {
/* 1138 */       String[] arrayOfString1 = split(paramString);
/* 1139 */       String[] arrayOfString2 = (arrayOfString1[4] == null) ? null : StringUtils.arraySplit(arrayOfString1[4], ',', false);
/* 1140 */       return databaseMetaData.getTables(arrayOfString1[1], arrayOfString1[2], arrayOfString1[3], arrayOfString2);
/* 1141 */     }  if (isBuiltIn(paramString, "@table_privileges")) {
/* 1142 */       String[] arrayOfString = split(paramString);
/* 1143 */       return databaseMetaData.getTablePrivileges(arrayOfString[1], arrayOfString[2], arrayOfString[3]);
/* 1144 */     }  if (isBuiltIn(paramString, "@table_types"))
/* 1145 */       return databaseMetaData.getTableTypes(); 
/* 1146 */     if (isBuiltIn(paramString, "@type_info"))
/* 1147 */       return databaseMetaData.getTypeInfo(); 
/* 1148 */     if (isBuiltIn(paramString, "@udts")) {
/* 1149 */       int[] arrayOfInt; String[] arrayOfString = split(paramString);
/*      */       
/* 1151 */       if (arrayOfString[4] == null) {
/* 1152 */         arrayOfInt = null;
/*      */       } else {
/* 1154 */         String[] arrayOfString1 = StringUtils.arraySplit(arrayOfString[4], ',', false);
/* 1155 */         arrayOfInt = new int[arrayOfString1.length];
/* 1156 */         for (byte b = 0; b < arrayOfString1.length; b++) {
/* 1157 */           arrayOfInt[b] = Integer.parseInt(arrayOfString1[b]);
/*      */         }
/*      */       } 
/* 1160 */       return databaseMetaData.getUDTs(arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfInt);
/* 1161 */     }  if (isBuiltIn(paramString, "@version_columns")) {
/* 1162 */       String[] arrayOfString = split(paramString);
/* 1163 */       return databaseMetaData.getVersionColumns(arrayOfString[1], arrayOfString[2], arrayOfString[3]);
/* 1164 */     }  if (isBuiltIn(paramString, "@memory")) {
/* 1165 */       SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 1166 */       simpleResultSet.addColumn("Type", 12, 0, 0);
/* 1167 */       simpleResultSet.addColumn("KB", 12, 0, 0);
/* 1168 */       simpleResultSet.addRow(new Object[] { "Used Memory", "" + Utils.getMemoryUsed() });
/* 1169 */       simpleResultSet.addRow(new Object[] { "Free Memory", "" + Utils.getMemoryFree() });
/* 1170 */       return (ResultSet)simpleResultSet;
/* 1171 */     }  if (isBuiltIn(paramString, "@info")) {
/* 1172 */       String str; SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 1173 */       simpleResultSet.addColumn("KEY", 12, 0, 0);
/* 1174 */       simpleResultSet.addColumn("VALUE", 12, 0, 0);
/* 1175 */       simpleResultSet.addRow(new Object[] { "conn.getCatalog", paramConnection.getCatalog() });
/* 1176 */       simpleResultSet.addRow(new Object[] { "conn.getAutoCommit", "" + paramConnection.getAutoCommit() });
/* 1177 */       simpleResultSet.addRow(new Object[] { "conn.getTransactionIsolation", "" + paramConnection.getTransactionIsolation() });
/* 1178 */       simpleResultSet.addRow(new Object[] { "conn.getWarnings", "" + paramConnection.getWarnings() });
/*      */       
/*      */       try {
/* 1181 */         str = "" + paramConnection.getTypeMap();
/* 1182 */       } catch (SQLException sQLException) {
/* 1183 */         str = sQLException.toString();
/*      */       } 
/* 1185 */       simpleResultSet.addRow(new Object[] { "conn.getTypeMap", "" + str });
/* 1186 */       simpleResultSet.addRow(new Object[] { "conn.isReadOnly", "" + paramConnection.isReadOnly() });
/* 1187 */       simpleResultSet.addRow(new Object[] { "conn.getHoldability", "" + paramConnection.getHoldability() });
/* 1188 */       addDatabaseMetaData(simpleResultSet, databaseMetaData);
/* 1189 */       return (ResultSet)simpleResultSet;
/* 1190 */     }  if (isBuiltIn(paramString, "@attributes")) {
/* 1191 */       String[] arrayOfString = split(paramString);
/* 1192 */       return databaseMetaData.getAttributes(arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4]);
/* 1193 */     }  if (isBuiltIn(paramString, "@super_tables")) {
/* 1194 */       String[] arrayOfString = split(paramString);
/* 1195 */       return databaseMetaData.getSuperTables(arrayOfString[1], arrayOfString[2], arrayOfString[3]);
/* 1196 */     }  if (isBuiltIn(paramString, "@super_types")) {
/* 1197 */       String[] arrayOfString = split(paramString);
/* 1198 */       return databaseMetaData.getSuperTypes(arrayOfString[1], arrayOfString[2], arrayOfString[3]);
/* 1199 */     }  if (isBuiltIn(paramString, "@prof_stop") && 
/* 1200 */       this.profiler != null) {
/* 1201 */       this.profiler.stopCollecting();
/* 1202 */       SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 1203 */       simpleResultSet.addColumn("Top Stack Trace(s)", 12, 0, 0);
/* 1204 */       simpleResultSet.addRow(new Object[] { this.profiler.getTop(3) });
/* 1205 */       this.profiler = null;
/* 1206 */       return (ResultSet)simpleResultSet;
/*      */     } 
/*      */     
/* 1209 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void addDatabaseMetaData(SimpleResultSet paramSimpleResultSet, DatabaseMetaData paramDatabaseMetaData) {
/* 1214 */     Method[] arrayOfMethod = DatabaseMetaData.class.getDeclaredMethods();
/* 1215 */     Arrays.sort(arrayOfMethod, new Comparator<Method>()
/*      */         {
/*      */           public int compare(Method param1Method1, Method param1Method2) {
/* 1218 */             return param1Method1.toString().compareTo(param1Method2.toString());
/*      */           }
/*      */         });
/* 1221 */     for (Method method : arrayOfMethod) {
/* 1222 */       if ((method.getParameterTypes()).length == 0) {
/*      */         try {
/* 1224 */           Object object = method.invoke(paramDatabaseMetaData, new Object[0]);
/* 1225 */           paramSimpleResultSet.addRow(new Object[] { "meta." + method.getName(), "" + object });
/* 1226 */         } catch (InvocationTargetException invocationTargetException) {
/* 1227 */           paramSimpleResultSet.addRow(new Object[] { "meta." + method.getName(), invocationTargetException.getTargetException().toString() });
/* 1228 */         } catch (Exception exception) {
/* 1229 */           paramSimpleResultSet.addRow(new Object[] { "meta." + method.getName(), exception.toString() });
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static String[] split(String paramString) {
/* 1236 */     String[] arrayOfString1 = new String[10];
/* 1237 */     String[] arrayOfString2 = StringUtils.arraySplit(paramString, ' ', true);
/* 1238 */     System.arraycopy(arrayOfString2, 0, arrayOfString1, 0, arrayOfString2.length);
/* 1239 */     for (byte b = 0; b < arrayOfString1.length; b++) {
/* 1240 */       if ("null".equals(arrayOfString1[b])) {
/* 1241 */         arrayOfString1[b] = null;
/*      */       }
/*      */     } 
/* 1244 */     return arrayOfString1;
/*      */   }
/*      */   
/*      */   private int getMaxrows() {
/* 1248 */     String str = (String)this.session.get("maxrows");
/* 1249 */     return (str == null) ? 0 : Integer.parseInt(str);
/*      */   }
/*      */   
/*      */   private String getResult(Connection paramConnection, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/*      */     try {
/*      */       Statement statement;
/*      */       ResultSet resultSet;
/* 1256 */       paramString = paramString.trim();
/* 1257 */       StringBuilder stringBuilder = new StringBuilder();
/* 1258 */       String str = StringUtils.toUpperEnglish(paramString);
/* 1259 */       if (str.contains("CREATE") || str.contains("DROP") || str.contains("ALTER") || str.contains("RUNSCRIPT")) {
/*      */ 
/*      */ 
/*      */         
/* 1263 */         String str1 = this.attributes.getProperty("jsessionid");
/* 1264 */         stringBuilder.append("<script type=\"text/javascript\">parent['h2menu'].location='tables.do?jsessionid=" + str1 + "';</script>");
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1269 */       DbContents dbContents = this.session.getContents();
/* 1270 */       if (paramBoolean2 || (paramBoolean1 && dbContents.isH2())) {
/* 1271 */         statement = paramConnection.createStatement(1004, 1008);
/*      */       }
/*      */       else {
/*      */         
/* 1275 */         statement = paramConnection.createStatement();
/*      */       } 
/*      */       
/* 1278 */       long l = System.currentTimeMillis();
/* 1279 */       boolean bool1 = false;
/* 1280 */       boolean bool2 = false;
/* 1281 */       boolean bool3 = false;
/* 1282 */       boolean bool4 = false;
/* 1283 */       if (isBuiltIn(paramString, "@autocommit_true")) {
/* 1284 */         paramConnection.setAutoCommit(true);
/* 1285 */         return "${text.result.autoCommitOn}";
/* 1286 */       }  if (isBuiltIn(paramString, "@autocommit_false")) {
/* 1287 */         paramConnection.setAutoCommit(false);
/* 1288 */         return "${text.result.autoCommitOff}";
/* 1289 */       }  if (isBuiltIn(paramString, "@cancel")) {
/* 1290 */         statement = this.session.executingStatement;
/* 1291 */         if (statement != null) {
/* 1292 */           statement.cancel();
/* 1293 */           stringBuilder.append("${text.result.statementWasCanceled}");
/*      */         } else {
/* 1295 */           stringBuilder.append("${text.result.noRunningStatement}");
/*      */         } 
/* 1297 */         return stringBuilder.toString();
/* 1298 */       }  if (isBuiltIn(paramString, "@edit")) {
/* 1299 */         bool3 = true;
/* 1300 */         paramString = paramString.substring("@edit".length()).trim();
/* 1301 */         this.session.put("resultSetSQL", paramString);
/*      */       } 
/* 1303 */       if (isBuiltIn(paramString, "@list")) {
/* 1304 */         bool4 = true;
/* 1305 */         paramString = paramString.substring("@list".length()).trim();
/*      */       } 
/* 1307 */       if (isBuiltIn(paramString, "@meta")) {
/* 1308 */         bool1 = true;
/* 1309 */         paramString = paramString.substring("@meta".length()).trim();
/*      */       } 
/* 1311 */       if (isBuiltIn(paramString, "@generated"))
/* 1312 */       { bool2 = true;
/* 1313 */         paramString = paramString.substring("@generated".length()).trim(); }
/* 1314 */       else { if (isBuiltIn(paramString, "@history")) {
/* 1315 */           stringBuilder.append(getCommandHistoryString());
/* 1316 */           return stringBuilder.toString();
/* 1317 */         }  if (isBuiltIn(paramString, "@loop")) {
/* 1318 */           paramString = paramString.substring("@loop".length()).trim();
/* 1319 */           int i = paramString.indexOf(' ');
/* 1320 */           int j = Integer.decode(paramString.substring(0, i)).intValue();
/* 1321 */           paramString = paramString.substring(i).trim();
/* 1322 */           return executeLoop(paramConnection, j, paramString);
/* 1323 */         }  if (isBuiltIn(paramString, "@maxrows")) {
/* 1324 */           int i = (int)Double.parseDouble(paramString.substring("@maxrows".length()).trim());
/*      */           
/* 1326 */           this.session.put("maxrows", "" + i);
/* 1327 */           return "${text.result.maxrowsSet}";
/* 1328 */         }  if (isBuiltIn(paramString, "@parameter_meta")) {
/* 1329 */           paramString = paramString.substring("@parameter_meta".length()).trim();
/* 1330 */           PreparedStatement preparedStatement = paramConnection.prepareStatement(paramString);
/* 1331 */           stringBuilder.append(getParameterResultSet(preparedStatement.getParameterMetaData()));
/* 1332 */           return stringBuilder.toString();
/* 1333 */         }  if (isBuiltIn(paramString, "@password_hash")) {
/* 1334 */           paramString = paramString.substring("@password_hash".length()).trim();
/* 1335 */           String[] arrayOfString = split(paramString);
/* 1336 */           return StringUtils.convertBytesToHex(SHA256.getKeyPasswordHash(arrayOfString[0], arrayOfString[1].toCharArray()));
/*      */         } 
/* 1338 */         if (isBuiltIn(paramString, "@prof_start")) {
/* 1339 */           if (this.profiler != null) {
/* 1340 */             this.profiler.stopCollecting();
/*      */           }
/* 1342 */           this.profiler = new Profiler();
/* 1343 */           this.profiler.startCollecting();
/* 1344 */           return "Ok";
/* 1345 */         }  if (isBuiltIn(paramString, "@sleep")) {
/* 1346 */           String str1 = paramString.substring("@sleep".length()).trim();
/* 1347 */           int i = 1;
/* 1348 */           if (str1.length() > 0) {
/* 1349 */             i = Integer.parseInt(str1);
/*      */           }
/* 1351 */           Thread.sleep((i * 1000));
/* 1352 */           return "Ok";
/* 1353 */         }  if (isBuiltIn(paramString, "@transaction_isolation")) {
/* 1354 */           String str1 = paramString.substring("@transaction_isolation".length()).trim();
/* 1355 */           if (str1.length() > 0) {
/* 1356 */             int i = Integer.parseInt(str1);
/* 1357 */             paramConnection.setTransactionIsolation(i);
/*      */           } 
/* 1359 */           stringBuilder.append("Transaction Isolation: " + paramConnection.getTransactionIsolation() + "<br />");
/*      */           
/* 1361 */           stringBuilder.append("1: read_uncommitted<br />");
/*      */           
/* 1363 */           stringBuilder.append("2: read_committed<br />");
/*      */           
/* 1365 */           stringBuilder.append("4: repeatable_read<br />");
/*      */           
/* 1367 */           stringBuilder.append("8: serializable");
/*      */         }  }
/*      */       
/* 1370 */       if (paramString.startsWith("@")) {
/* 1371 */         resultSet = getMetaResultSet(paramConnection, paramString);
/* 1372 */         if (resultSet == null) {
/* 1373 */           stringBuilder.append("?: " + paramString);
/* 1374 */           return stringBuilder.toString();
/*      */         } 
/*      */       } else {
/* 1377 */         int i = getMaxrows();
/* 1378 */         statement.setMaxRows(i);
/* 1379 */         this.session.executingStatement = statement;
/* 1380 */         boolean bool = statement.execute(paramString);
/* 1381 */         this.session.addCommand(paramString);
/* 1382 */         if (bool2) {
/* 1383 */           resultSet = null;
/* 1384 */           resultSet = statement.getGeneratedKeys();
/*      */         } else {
/* 1386 */           if (!bool) {
/* 1387 */             stringBuilder.append("${text.result.updateCount}: " + statement.getUpdateCount());
/* 1388 */             l = System.currentTimeMillis() - l;
/* 1389 */             stringBuilder.append("<br />(").append(l).append(" ms)");
/* 1390 */             statement.close();
/* 1391 */             return stringBuilder.toString();
/*      */           } 
/* 1393 */           resultSet = statement.getResultSet();
/*      */         } 
/*      */       } 
/* 1396 */       l = System.currentTimeMillis() - l;
/* 1397 */       stringBuilder.append(getResultSet(paramString, resultSet, bool1, bool4, bool3, l, paramBoolean1));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1403 */       if (!bool3) {
/* 1404 */         statement.close();
/*      */       }
/* 1406 */       return stringBuilder.toString();
/* 1407 */     } catch (Throwable throwable) {
/*      */       
/* 1409 */       return getStackTrace(paramInt, throwable, this.session.getContents().isH2());
/*      */     } finally {
/* 1411 */       this.session.executingStatement = null;
/*      */     } 
/*      */   }
/*      */   
/*      */   private static boolean isBuiltIn(String paramString1, String paramString2) {
/* 1416 */     return StringUtils.startsWithIgnoreCase(paramString1, paramString2);
/*      */   }
/*      */   
/*      */   private String executeLoop(Connection paramConnection, int paramInt, String paramString) throws SQLException {
/*      */     boolean bool;
/* 1421 */     ArrayList<Integer> arrayList = New.arrayList();
/* 1422 */     int i = 0;
/* 1423 */     while (!this.stop) {
/* 1424 */       i = paramString.indexOf('?', i);
/* 1425 */       if (i < 0) {
/*      */         break;
/*      */       }
/* 1428 */       if (isBuiltIn(paramString.substring(i), "?/*rnd*/")) {
/* 1429 */         arrayList.add(Integer.valueOf(1));
/* 1430 */         paramString = paramString.substring(0, i) + "?" + paramString.substring(i + "/*rnd*/".length() + 1);
/*      */       } else {
/* 1432 */         arrayList.add(Integer.valueOf(0));
/*      */       } 
/* 1434 */       i++;
/*      */     } 
/*      */     
/* 1437 */     Random random = new Random(1L);
/* 1438 */     long l = System.currentTimeMillis();
/* 1439 */     if (isBuiltIn(paramString, "@statement")) {
/* 1440 */       paramString = paramString.substring("@statement".length()).trim();
/* 1441 */       bool = false;
/* 1442 */       Statement statement = paramConnection.createStatement();
/* 1443 */       for (byte b = 0; !this.stop && b < paramInt; b++) {
/* 1444 */         String str = paramString;
/* 1445 */         for (Integer integer : arrayList) {
/* 1446 */           i = str.indexOf('?');
/* 1447 */           if (integer.intValue() == 1) {
/* 1448 */             str = str.substring(0, i) + random.nextInt(paramInt) + str.substring(i + 1); continue;
/*      */           } 
/* 1450 */           str = str.substring(0, i) + b + str.substring(i + 1);
/*      */         } 
/*      */         
/* 1453 */         if (statement.execute(str)) {
/* 1454 */           ResultSet resultSet = statement.getResultSet();
/* 1455 */           while (!this.stop && resultSet.next());
/*      */ 
/*      */           
/* 1458 */           resultSet.close();
/*      */         } 
/*      */       } 
/*      */     } else {
/* 1462 */       bool = true;
/* 1463 */       PreparedStatement preparedStatement = paramConnection.prepareStatement(paramString);
/* 1464 */       for (byte b = 0; !this.stop && b < paramInt; b++) {
/* 1465 */         for (byte b1 = 0; b1 < arrayList.size(); b1++) {
/* 1466 */           Integer integer = arrayList.get(b1);
/* 1467 */           if (integer.intValue() == 1) {
/* 1468 */             preparedStatement.setInt(b1 + 1, random.nextInt(paramInt));
/*      */           } else {
/* 1470 */             preparedStatement.setInt(b1 + 1, b);
/*      */           } 
/*      */         } 
/* 1473 */         if (this.session.getContents().isSQLite()) {
/*      */           
/* 1475 */           preparedStatement.executeUpdate();
/*      */         }
/* 1477 */         else if (preparedStatement.execute()) {
/* 1478 */           ResultSet resultSet = preparedStatement.getResultSet();
/* 1479 */           while (!this.stop && resultSet.next());
/*      */ 
/*      */           
/* 1482 */           resultSet.close();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1487 */     l = System.currentTimeMillis() - l;
/* 1488 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 1489 */     statementBuilder.append(l).append(" ms: ").append(paramInt).append(" * ");
/* 1490 */     if (bool) {
/* 1491 */       statementBuilder.append("(Prepared) ");
/*      */     } else {
/* 1493 */       statementBuilder.append("(Statement) ");
/*      */     } 
/* 1495 */     statementBuilder.append('(');
/* 1496 */     for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) { int j = ((Integer)iterator.next()).intValue();
/* 1497 */       statementBuilder.appendExceptFirst(", ");
/* 1498 */       statementBuilder.append((j == 0) ? "i" : "rnd"); }
/*      */     
/* 1500 */     return statementBuilder.append(") ").append(paramString).toString();
/*      */   }
/*      */   
/*      */   private String getCommandHistoryString() {
/* 1504 */     StringBuilder stringBuilder = new StringBuilder();
/* 1505 */     ArrayList<String> arrayList = this.session.getCommandHistory();
/* 1506 */     stringBuilder.append("<table cellspacing=0 cellpadding=0><tr><th></th><th>Command</th></tr>");
/*      */     
/* 1508 */     for (int i = arrayList.size() - 1; i >= 0; i--) {
/* 1509 */       String str = arrayList.get(i);
/* 1510 */       stringBuilder.append("<tr><td><a href=\"getHistory.do?id=").append(i).append("&jsessionid=${sessionId}\" target=\"h2query\" >").append("<img width=16 height=16 src=\"ico_write.gif\" onmouseover = \"this.className ='icon_hover'\" ").append("onmouseout = \"this.className ='icon'\" class=\"icon\" alt=\"${text.resultEdit.edit}\" ").append("title=\"${text.resultEdit.edit}\" border=\"1\"/></a>").append("</td><td>").append(PageParser.escapeHtml(str)).append("</td></tr>");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1522 */     stringBuilder.append("</table>");
/* 1523 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private static String getParameterResultSet(ParameterMetaData paramParameterMetaData) throws SQLException {
/* 1528 */     StringBuilder stringBuilder = new StringBuilder();
/* 1529 */     if (paramParameterMetaData == null) {
/* 1530 */       return "No parameter meta data";
/*      */     }
/* 1532 */     stringBuilder.append("<table cellspacing=0 cellpadding=0>").append("<tr><th>className</th><th>mode</th><th>type</th>").append("<th>typeName</th><th>precision</th><th>scale</th></tr>");
/*      */ 
/*      */     
/* 1535 */     for (byte b = 0; b < paramParameterMetaData.getParameterCount(); b++) {
/* 1536 */       stringBuilder.append("</tr><td>").append(paramParameterMetaData.getParameterClassName(b + 1)).append("</td><td>").append(paramParameterMetaData.getParameterMode(b + 1)).append("</td><td>").append(paramParameterMetaData.getParameterType(b + 1)).append("</td><td>").append(paramParameterMetaData.getParameterTypeName(b + 1)).append("</td><td>").append(paramParameterMetaData.getPrecision(b + 1)).append("</td><td>").append(paramParameterMetaData.getScale(b + 1)).append("</td></tr>");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1550 */     stringBuilder.append("</table>");
/* 1551 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private String getResultSet(String paramString, ResultSet paramResultSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4) throws SQLException {
/*      */     SimpleResultSet simpleResultSet;
/* 1557 */     int i = getMaxrows();
/* 1558 */     paramLong = System.currentTimeMillis() - paramLong;
/* 1559 */     StringBuilder stringBuilder = new StringBuilder();
/* 1560 */     if (paramBoolean3) {
/* 1561 */       stringBuilder.append("<form id=\"editing\" name=\"editing\" method=\"post\" action=\"editResult.do?jsessionid=${sessionId}\" id=\"mainForm\" target=\"h2result\"><input type=\"hidden\" name=\"op\" value=\"1\" /><input type=\"hidden\" name=\"row\" value=\"\" /><table cellspacing=0 cellpadding=0 id=\"editTable\">");
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 1568 */       stringBuilder.append("<table cellspacing=0 cellpadding=0>");
/*      */     } 
/* 1570 */     if (paramBoolean1) {
/* 1571 */       SimpleResultSet simpleResultSet1 = new SimpleResultSet();
/* 1572 */       simpleResultSet1.addColumn("#", 4, 0, 0);
/* 1573 */       simpleResultSet1.addColumn("label", 12, 0, 0);
/* 1574 */       simpleResultSet1.addColumn("catalog", 12, 0, 0);
/* 1575 */       simpleResultSet1.addColumn("schema", 12, 0, 0);
/* 1576 */       simpleResultSet1.addColumn("table", 12, 0, 0);
/* 1577 */       simpleResultSet1.addColumn("column", 12, 0, 0);
/* 1578 */       simpleResultSet1.addColumn("type", 4, 0, 0);
/* 1579 */       simpleResultSet1.addColumn("typeName", 12, 0, 0);
/* 1580 */       simpleResultSet1.addColumn("class", 12, 0, 0);
/* 1581 */       simpleResultSet1.addColumn("precision", 4, 0, 0);
/* 1582 */       simpleResultSet1.addColumn("scale", 4, 0, 0);
/* 1583 */       simpleResultSet1.addColumn("displaySize", 4, 0, 0);
/* 1584 */       simpleResultSet1.addColumn("autoIncrement", 16, 0, 0);
/* 1585 */       simpleResultSet1.addColumn("caseSensitive", 16, 0, 0);
/* 1586 */       simpleResultSet1.addColumn("currency", 16, 0, 0);
/* 1587 */       simpleResultSet1.addColumn("nullable", 4, 0, 0);
/* 1588 */       simpleResultSet1.addColumn("readOnly", 16, 0, 0);
/* 1589 */       simpleResultSet1.addColumn("searchable", 16, 0, 0);
/* 1590 */       simpleResultSet1.addColumn("signed", 16, 0, 0);
/* 1591 */       simpleResultSet1.addColumn("writable", 16, 0, 0);
/* 1592 */       simpleResultSet1.addColumn("definitelyWritable", 16, 0, 0);
/* 1593 */       ResultSetMetaData resultSetMetaData1 = paramResultSet.getMetaData();
/* 1594 */       for (byte b1 = 1; b1 <= resultSetMetaData1.getColumnCount(); b1++) {
/* 1595 */         simpleResultSet1.addRow(new Object[] { Integer.valueOf(b1), resultSetMetaData1.getColumnLabel(b1), resultSetMetaData1.getCatalogName(b1), resultSetMetaData1.getSchemaName(b1), resultSetMetaData1.getTableName(b1), resultSetMetaData1.getColumnName(b1), Integer.valueOf(resultSetMetaData1.getColumnType(b1)), resultSetMetaData1.getColumnTypeName(b1), resultSetMetaData1.getColumnClassName(b1), Integer.valueOf(resultSetMetaData1.getPrecision(b1)), Integer.valueOf(resultSetMetaData1.getScale(b1)), Integer.valueOf(resultSetMetaData1.getColumnDisplaySize(b1)), Boolean.valueOf(resultSetMetaData1.isAutoIncrement(b1)), Boolean.valueOf(resultSetMetaData1.isCaseSensitive(b1)), Boolean.valueOf(resultSetMetaData1.isCurrency(b1)), Integer.valueOf(resultSetMetaData1.isNullable(b1)), Boolean.valueOf(resultSetMetaData1.isReadOnly(b1)), Boolean.valueOf(resultSetMetaData1.isSearchable(b1)), Boolean.valueOf(resultSetMetaData1.isSigned(b1)), Boolean.valueOf(resultSetMetaData1.isWritable(b1)), Boolean.valueOf(resultSetMetaData1.isDefinitelyWritable(b1)) });
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1617 */       simpleResultSet = simpleResultSet1;
/*      */     } 
/* 1619 */     ResultSetMetaData resultSetMetaData = simpleResultSet.getMetaData();
/* 1620 */     int j = resultSetMetaData.getColumnCount();
/* 1621 */     byte b = 0;
/* 1622 */     if (paramBoolean2) {
/* 1623 */       stringBuilder.append("<tr><th>Column</th><th>Data</th></tr><tr>");
/* 1624 */       while (simpleResultSet.next() && (
/* 1625 */         i <= 0 || b < i))
/*      */       {
/*      */         
/* 1628 */         b++;
/* 1629 */         stringBuilder.append("<tr><td>Row #</td><td>").append(b).append("</tr>");
/*      */         
/* 1631 */         for (byte b1 = 0; b1 < j; b1++) {
/* 1632 */           stringBuilder.append("<tr><td>").append(PageParser.escapeHtml(resultSetMetaData.getColumnLabel(b1 + 1))).append("</td><td>").append(escapeData((ResultSet)simpleResultSet, b1 + 1)).append("</td></tr>");
/*      */         
/*      */         }
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1640 */       stringBuilder.append("<tr>");
/* 1641 */       if (paramBoolean3)
/* 1642 */         stringBuilder.append("<th>${text.resultEdit.action}</th>"); 
/*      */       byte b1;
/* 1644 */       for (b1 = 0; b1 < j; b1++) {
/* 1645 */         stringBuilder.append("<th>").append(PageParser.escapeHtml(resultSetMetaData.getColumnLabel(b1 + 1))).append("</th>");
/*      */       }
/*      */ 
/*      */       
/* 1649 */       stringBuilder.append("</tr>");
/* 1650 */       while (simpleResultSet.next() && (
/* 1651 */         i <= 0 || b < i)) {
/*      */ 
/*      */         
/* 1654 */         b++;
/* 1655 */         stringBuilder.append("<tr>");
/* 1656 */         if (paramBoolean3) {
/* 1657 */           stringBuilder.append("<td>").append("<img onclick=\"javascript:editRow(").append(simpleResultSet.getRow()).append(",'${sessionId}', '${text.resultEdit.save}', '${text.resultEdit.cancel}'").append(")\" width=16 height=16 src=\"ico_write.gif\" onmouseover = \"this.className ='icon_hover'\" onmouseout = \"this.className ='icon'\" class=\"icon\" alt=\"${text.resultEdit.edit}\" title=\"${text.resultEdit.edit}\" border=\"1\"/>").append("<a href=\"editResult.do?op=2&row=").append(simpleResultSet.getRow()).append("&jsessionid=${sessionId}\" target=\"h2result\" ><img width=16 height=16 src=\"ico_remove.gif\" onmouseover = \"this.className ='icon_hover'\" onmouseout = \"this.className ='icon'\" class=\"icon\" alt=\"${text.resultEdit.delete}\" title=\"${text.resultEdit.delete}\" border=\"1\" /></a>").append("</td>");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1677 */         for (b1 = 0; b1 < j; b1++) {
/* 1678 */           stringBuilder.append("<td>").append(escapeData((ResultSet)simpleResultSet, b1 + 1)).append("</td>");
/*      */         }
/*      */ 
/*      */         
/* 1682 */         stringBuilder.append("</tr>");
/*      */       } 
/*      */     } 
/* 1685 */     boolean bool = false;
/*      */     try {
/* 1687 */       if (!this.session.getContents().isDB2()) {
/* 1688 */         bool = (simpleResultSet.getConcurrency() == 1008 && simpleResultSet.getType() != 1003) ? true : false;
/*      */       }
/*      */     }
/* 1691 */     catch (NullPointerException nullPointerException) {}
/*      */ 
/*      */ 
/*      */     
/* 1695 */     if (paramBoolean3) {
/* 1696 */       ResultSet resultSet = this.session.result;
/* 1697 */       if (resultSet != null) {
/* 1698 */         resultSet.close();
/*      */       }
/* 1700 */       this.session.result = (ResultSet)simpleResultSet;
/*      */     } else {
/* 1702 */       simpleResultSet.close();
/*      */     } 
/* 1704 */     if (paramBoolean3) {
/* 1705 */       stringBuilder.append("<tr><td>").append("<img onclick=\"javascript:editRow(-1, '${sessionId}', '${text.resultEdit.save}', '${text.resultEdit.cancel}'").append(")\" width=16 height=16 src=\"ico_add.gif\" onmouseover = \"this.className ='icon_hover'\" onmouseout = \"this.className ='icon'\" class=\"icon\" alt=\"${text.resultEdit.add}\" title=\"${text.resultEdit.add}\" border=\"1\"/>").append("</td>");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1714 */       for (byte b1 = 0; b1 < j; b1++) {
/* 1715 */         stringBuilder.append("<td></td>");
/*      */       }
/* 1717 */       stringBuilder.append("</tr>");
/*      */     } 
/* 1719 */     stringBuilder.append("</table>");
/* 1720 */     if (paramBoolean3) {
/* 1721 */       stringBuilder.append("</form>");
/*      */     }
/* 1723 */     if (b == 0) {
/* 1724 */       stringBuilder.append("(${text.result.noRows}");
/* 1725 */     } else if (b == 1) {
/* 1726 */       stringBuilder.append("(${text.result.1row}");
/*      */     } else {
/* 1728 */       stringBuilder.append('(').append(b).append(" ${text.result.rows}");
/*      */     } 
/* 1730 */     stringBuilder.append(", ");
/* 1731 */     paramLong = System.currentTimeMillis() - paramLong;
/* 1732 */     stringBuilder.append(paramLong).append(" ms)");
/* 1733 */     if (!paramBoolean3 && bool && paramBoolean4) {
/* 1734 */       stringBuilder.append("<br /><br /><form name=\"editResult\" method=\"post\" action=\"query.do?jsessionid=${sessionId}\" target=\"h2result\"><input type=\"submit\" class=\"button\" value=\"${text.resultEdit.editResult}\" /><input type=\"hidden\" name=\"sql\" value=\"@edit ").append(PageParser.escapeHtmlData(paramString)).append("\" /></form>");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1743 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String settingSave() {
/* 1752 */     ConnectionInfo connectionInfo = new ConnectionInfo();
/* 1753 */     connectionInfo.name = this.attributes.getProperty("name", "");
/* 1754 */     connectionInfo.driver = this.attributes.getProperty("driver", "");
/* 1755 */     connectionInfo.url = this.attributes.getProperty("url", "");
/* 1756 */     connectionInfo.user = this.attributes.getProperty("user", "");
/* 1757 */     this.server.updateSetting(connectionInfo);
/* 1758 */     this.attributes.put("setting", connectionInfo.name);
/* 1759 */     this.server.saveProperties(null);
/* 1760 */     return "index.do";
/*      */   }
/*      */ 
/*      */   
/*      */   private static String escapeData(ResultSet paramResultSet, int paramInt) throws SQLException {
/* 1765 */     String str = paramResultSet.getString(paramInt);
/* 1766 */     if (str == null)
/* 1767 */       return "<i>null</i>"; 
/* 1768 */     if (str.length() > 100000) {
/*      */       String str1;
/* 1770 */       if (isBinary(paramResultSet.getMetaData().getColumnType(paramInt))) {
/* 1771 */         str1 = PageParser.escapeHtml(str.substring(0, 6)) + "... (" + (str.length() / 2) + " ${text.result.bytes})";
/*      */       } else {
/*      */         
/* 1774 */         str1 = PageParser.escapeHtml(str.substring(0, 100)) + "... (" + str.length() + " ${text.result.characters})";
/*      */       } 
/*      */       
/* 1777 */       return "<div style='display: none'>=+</div>" + str1;
/* 1778 */     }  if (str.equals("null") || str.startsWith("= ") || str.startsWith("=+"))
/* 1779 */       return "<div style='display: none'>= </div>" + PageParser.escapeHtml(str); 
/* 1780 */     if (str.equals(""))
/*      */     {
/* 1782 */       return "";
/*      */     }
/* 1784 */     return PageParser.escapeHtml(str);
/*      */   }
/*      */   
/*      */   private static boolean isBinary(int paramInt) {
/* 1788 */     switch (paramInt) {
/*      */       case -4:
/*      */       case -3:
/*      */       case -2:
/*      */       case 1111:
/*      */       case 2000:
/*      */       case 2004:
/* 1795 */         return true;
/*      */     } 
/* 1797 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void unescapeData(String paramString, ResultSet paramResultSet, int paramInt) throws SQLException {
/* 1802 */     if (paramString.equals("null")) {
/* 1803 */       paramResultSet.updateNull(paramInt); return;
/*      */     } 
/* 1805 */     if (paramString.startsWith("=+")) {
/*      */       return;
/*      */     }
/* 1808 */     if (paramString.equals("=*")) {
/*      */       
/* 1810 */       int j = paramResultSet.getMetaData().getColumnType(paramInt);
/* 1811 */       switch (j) {
/*      */         case 92:
/* 1813 */           paramResultSet.updateString(paramInt, "12:00:00");
/*      */           return;
/*      */         case 91:
/*      */         case 93:
/* 1817 */           paramResultSet.updateString(paramInt, "2001-01-01");
/*      */           return;
/*      */       } 
/* 1820 */       paramResultSet.updateString(paramInt, "1");
/*      */       
/*      */       return;
/*      */     } 
/* 1824 */     if (paramString.startsWith("= ")) {
/* 1825 */       paramString = paramString.substring(2);
/*      */     }
/* 1827 */     ResultSetMetaData resultSetMetaData = paramResultSet.getMetaData();
/* 1828 */     int i = resultSetMetaData.getColumnType(paramInt);
/* 1829 */     if (this.session.getContents().isH2()) {
/* 1830 */       paramResultSet.updateString(paramInt, paramString);
/*      */       return;
/*      */     } 
/* 1833 */     switch (i) {
/*      */       case -5:
/* 1835 */         paramResultSet.updateLong(paramInt, Long.decode(paramString).longValue());
/*      */         return;
/*      */       case 3:
/* 1838 */         paramResultSet.updateBigDecimal(paramInt, new BigDecimal(paramString));
/*      */         return;
/*      */       case 6:
/*      */       case 8:
/* 1842 */         paramResultSet.updateDouble(paramInt, Double.parseDouble(paramString));
/*      */         return;
/*      */       case 7:
/* 1845 */         paramResultSet.updateFloat(paramInt, Float.parseFloat(paramString));
/*      */         return;
/*      */       case 4:
/* 1848 */         paramResultSet.updateInt(paramInt, Integer.decode(paramString).intValue());
/*      */         return;
/*      */       case -6:
/* 1851 */         paramResultSet.updateShort(paramInt, Short.decode(paramString).shortValue());
/*      */         return;
/*      */     } 
/* 1854 */     paramResultSet.updateString(paramInt, paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   private String settingRemove() {
/* 1859 */     String str = this.attributes.getProperty("name", "");
/* 1860 */     this.server.removeSetting(str);
/* 1861 */     ArrayList<ConnectionInfo> arrayList = this.server.getSettings();
/* 1862 */     if (arrayList.size() > 0) {
/* 1863 */       this.attributes.put("setting", arrayList.get(0));
/*      */     }
/* 1865 */     this.server.saveProperties(null);
/* 1866 */     return "index.do";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   String getMimeType() {
/* 1875 */     return this.mimeType;
/*      */   }
/*      */   
/*      */   boolean getCache() {
/* 1879 */     return this.cache;
/*      */   }
/*      */   
/*      */   WebSession getSession() {
/* 1883 */     return this.session;
/*      */   }
/*      */   
/*      */   private void trace(String paramString) {
/* 1887 */     this.server.trace(paramString);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\web\WebApp.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */