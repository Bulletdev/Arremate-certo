/*     */ package org.h2.server.pg;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.StringReader;
/*     */ import java.net.Socket;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ParameterMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Properties;
/*     */ import org.h2.engine.ConnectionInfo;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.jdbc.JdbcPreparedStatement;
/*     */ import org.h2.jdbc.JdbcStatement;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.ScriptReader;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
/*     */ import org.h2.value.CaseInsensitiveMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PgServerThread
/*     */   implements Runnable
/*     */ {
/*     */   private final PgServer server;
/*     */   private Socket socket;
/*     */   private Connection conn;
/*     */   private boolean stop;
/*     */   private DataInputStream dataInRaw;
/*     */   private DataInputStream dataIn;
/*     */   private OutputStream out;
/*     */   private int messageType;
/*     */   private ByteArrayOutputStream outBuffer;
/*     */   private DataOutputStream dataOut;
/*     */   private Thread thread;
/*     */   private boolean initDone;
/*     */   private String userName;
/*     */   private String databaseName;
/*     */   private int processId;
/*     */   private int secret;
/*     */   private JdbcStatement activeRequest;
/*  67 */   private String clientEncoding = SysProperties.PG_DEFAULT_CLIENT_ENCODING;
/*  68 */   private String dateStyle = "ISO";
/*  69 */   private final HashMap<String, Prepared> prepared = (HashMap<String, Prepared>)new CaseInsensitiveMap();
/*     */   
/*  71 */   private final HashMap<String, Portal> portals = (HashMap<String, Portal>)new CaseInsensitiveMap();
/*     */ 
/*     */   
/*     */   PgServerThread(Socket paramSocket, PgServer paramPgServer) {
/*  75 */     this.server = paramPgServer;
/*  76 */     this.socket = paramSocket;
/*  77 */     this.secret = (int)MathUtils.secureRandomLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  83 */       this.server.trace("Connect");
/*  84 */       InputStream inputStream = this.socket.getInputStream();
/*  85 */       this.out = this.socket.getOutputStream();
/*  86 */       this.dataInRaw = new DataInputStream(inputStream);
/*  87 */       while (!this.stop) {
/*  88 */         process();
/*  89 */         this.out.flush();
/*     */       } 
/*  91 */     } catch (EOFException eOFException) {
/*     */     
/*  93 */     } catch (Exception exception) {
/*  94 */       this.server.traceError(exception);
/*     */     } finally {
/*  96 */       this.server.trace("Disconnect");
/*  97 */       close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private String readString() throws IOException {
/* 102 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     while (true) {
/* 104 */       int i = this.dataIn.read();
/* 105 */       if (i <= 0) {
/*     */         break;
/*     */       }
/* 108 */       byteArrayOutputStream.write(i);
/*     */     } 
/* 110 */     return new String(byteArrayOutputStream.toByteArray(), getEncoding());
/*     */   }
/*     */   
/*     */   private int readInt() throws IOException {
/* 114 */     return this.dataIn.readInt();
/*     */   }
/*     */   
/*     */   private short readShort() throws IOException {
/* 118 */     return this.dataIn.readShort();
/*     */   }
/*     */   
/*     */   private byte readByte() throws IOException {
/* 122 */     return this.dataIn.readByte();
/*     */   }
/*     */   
/*     */   private void readFully(byte[] paramArrayOfbyte) throws IOException {
/* 126 */     this.dataIn.readFully(paramArrayOfbyte); } private void process() throws IOException { boolean bool; int j; String str2; Prepared prepared1; Portal portal1; char c; String str1; short s; String str3;
/*     */     Portal portal2;
/*     */     ScriptReader scriptReader;
/*     */     int[] arrayOfInt;
/*     */     Prepared prepared2;
/* 131 */     if (this.initDone) {
/* 132 */       bool = this.dataInRaw.read();
/* 133 */       if (bool < 0) {
/* 134 */         this.stop = true;
/*     */         return;
/*     */       } 
/*     */     } else {
/* 138 */       bool = false;
/*     */     } 
/* 140 */     int i = this.dataInRaw.readInt();
/* 141 */     i -= 4;
/* 142 */     byte[] arrayOfByte = DataUtils.newBytes(i);
/* 143 */     this.dataInRaw.readFully(arrayOfByte, 0, i);
/* 144 */     this.dataIn = new DataInputStream(new ByteArrayInputStream(arrayOfByte, 0, i));
/* 145 */     switch (bool) {
/*     */       case false:
/* 147 */         this.server.trace("Init");
/* 148 */         j = readInt();
/* 149 */         if (j == 80877102) {
/* 150 */           this.server.trace("CancelRequest");
/* 151 */           int k = readInt();
/* 152 */           int m = readInt();
/* 153 */           PgServerThread pgServerThread = this.server.getThread(k);
/* 154 */           if (pgServerThread != null && m == pgServerThread.secret) {
/* 155 */             pgServerThread.cancelRequest();
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 160 */             this.server.trace("Invalid CancelRequest: pid=" + k + ", key=" + m);
/*     */           } 
/* 162 */           close();
/* 163 */         } else if (j == 80877103) {
/* 164 */           this.server.trace("SSLRequest");
/* 165 */           this.out.write(78);
/*     */         } else {
/* 167 */           this.server.trace("StartupMessage");
/* 168 */           this.server.trace(" version " + j + " (" + (j >> 16) + "." + (j & 0xFF) + ")");
/*     */           
/*     */           while (true) {
/* 171 */             String str4 = readString();
/* 172 */             if (str4.length() == 0) {
/*     */               break;
/*     */             }
/* 175 */             String str5 = readString();
/* 176 */             if ("user".equals(str4)) {
/* 177 */               this.userName = str5;
/* 178 */             } else if ("database".equals(str4)) {
/* 179 */               this.databaseName = this.server.checkKeyAndGetDatabaseName(str5);
/* 180 */             } else if ("client_encoding".equals(str4)) {
/*     */               
/* 182 */               this.clientEncoding = str5;
/* 183 */             } else if ("DateStyle".equals(str4)) {
/* 184 */               this.dateStyle = str5;
/*     */             } 
/*     */ 
/*     */             
/* 188 */             this.server.trace(" param " + str4 + "=" + str5);
/*     */           } 
/* 190 */           sendAuthenticationCleartextPassword();
/* 191 */           this.initDone = true;
/*     */         } 
/*     */         return;
/*     */       case true:
/* 195 */         this.server.trace("PasswordMessage");
/* 196 */         str2 = readString();
/*     */         try {
/* 198 */           Properties properties = new Properties();
/* 199 */           properties.put("MODE", "PostgreSQL");
/* 200 */           properties.put("USER", this.userName);
/* 201 */           properties.put("PASSWORD", str2);
/* 202 */           String str4 = "jdbc:h2:" + this.databaseName;
/* 203 */           ConnectionInfo connectionInfo = new ConnectionInfo(str4, properties);
/* 204 */           String str5 = this.server.getBaseDir();
/* 205 */           if (str5 == null) {
/* 206 */             str5 = SysProperties.getBaseDir();
/*     */           }
/* 208 */           if (str5 != null) {
/* 209 */             connectionInfo.setBaseDir(str5);
/*     */           }
/* 211 */           if (this.server.getIfExists()) {
/* 212 */             connectionInfo.setProperty("IFEXISTS", "TRUE");
/*     */           }
/* 214 */           this.conn = (Connection)new JdbcConnection(connectionInfo, false);
/*     */ 
/*     */ 
/*     */           
/* 218 */           initDb();
/* 219 */           sendAuthenticationOk();
/* 220 */         } catch (Exception exception) {
/* 221 */           exception.printStackTrace();
/* 222 */           this.stop = true;
/*     */         } 
/*     */         return;
/*     */       
/*     */       case true:
/* 227 */         this.server.trace("Parse");
/* 228 */         prepared1 = new Prepared();
/* 229 */         prepared1.name = readString();
/* 230 */         prepared1.sql = getSQL(readString());
/* 231 */         s = readShort();
/* 232 */         arrayOfInt = null;
/* 233 */         if (s > 0) {
/* 234 */           arrayOfInt = new int[s];
/* 235 */           for (byte b = 0; b < s; b++) {
/* 236 */             arrayOfInt[b] = readInt();
/*     */           }
/*     */         } 
/*     */         try {
/* 240 */           prepared1.prep = (JdbcPreparedStatement)this.conn.prepareStatement(prepared1.sql);
/* 241 */           ParameterMetaData parameterMetaData = prepared1.prep.getParameterMetaData();
/* 242 */           prepared1.paramType = new int[parameterMetaData.getParameterCount()];
/* 243 */           for (byte b = 0; b < prepared1.paramType.length; b++) {
/*     */             int k;
/* 245 */             if (b < s && arrayOfInt[b] != 0) {
/* 246 */               k = arrayOfInt[b];
/* 247 */               this.server.checkType(k);
/*     */             } else {
/* 249 */               k = PgServer.convertType(parameterMetaData.getParameterType(b + 1));
/*     */             } 
/* 251 */             prepared1.paramType[b] = k;
/*     */           } 
/* 253 */           this.prepared.put(prepared1.name, prepared1);
/* 254 */           sendParseComplete();
/* 255 */         } catch (Exception exception) {
/* 256 */           sendErrorResponse(exception);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case true:
/* 261 */         this.server.trace("Bind");
/* 262 */         portal1 = new Portal();
/* 263 */         portal1.name = readString();
/* 264 */         str3 = readString();
/* 265 */         prepared2 = this.prepared.get(str3);
/* 266 */         if (prepared2 == null) {
/* 267 */           sendErrorResponse("Prepared not found");
/*     */         } else {
/*     */           
/* 270 */           portal1.prep = prepared2;
/* 271 */           this.portals.put(portal1.name, portal1);
/* 272 */           short s1 = readShort();
/* 273 */           int[] arrayOfInt1 = new int[s1]; short s2;
/* 274 */           for (s2 = 0; s2 < s1; s2++) {
/* 275 */             arrayOfInt1[s2] = readShort();
/*     */           }
/* 277 */           s2 = readShort();
/*     */           try {
/* 279 */             for (byte b1 = 0; b1 < s2; b1++) {
/* 280 */               setParameter((PreparedStatement)prepared2.prep, prepared2.paramType[b1], b1, arrayOfInt1);
/*     */             }
/* 282 */           } catch (Exception exception) {
/* 283 */             sendErrorResponse(exception);
/*     */           } 
/*     */           
/* 286 */           short s3 = readShort();
/* 287 */           portal1.resultColumnFormat = new int[s3];
/* 288 */           for (byte b = 0; b < s3; b++) {
/* 289 */             portal1.resultColumnFormat[b] = readShort();
/*     */           }
/* 291 */           sendBindComplete();
/*     */         } 
/*     */         return;
/*     */       case true:
/* 295 */         c = (char)readByte();
/* 296 */         str3 = readString();
/* 297 */         this.server.trace("Close");
/* 298 */         if (c == 'S') {
/* 299 */           prepared2 = this.prepared.remove(str3);
/* 300 */           if (prepared2 != null) {
/* 301 */             JdbcUtils.closeSilently((Statement)prepared2.prep);
/*     */           }
/* 303 */         } else if (c == 'P') {
/* 304 */           this.portals.remove(str3);
/*     */         } else {
/* 306 */           this.server.trace("expected S or P, got " + c);
/* 307 */           sendErrorResponse("expected S or P");
/*     */           return;
/*     */         } 
/* 310 */         sendCloseComplete();
/*     */         return;
/*     */       
/*     */       case true:
/* 314 */         c = (char)readByte();
/* 315 */         str3 = readString();
/* 316 */         this.server.trace("Describe");
/* 317 */         if (c == 'S') {
/* 318 */           prepared2 = this.prepared.get(str3);
/* 319 */           if (prepared2 == null) {
/* 320 */             sendErrorResponse("Prepared not found: " + str3);
/*     */           } else {
/*     */             try {
/* 323 */               sendParameterDescription(prepared2.prep.getParameterMetaData(), prepared2.paramType);
/* 324 */               sendRowDescription(prepared2.prep.getMetaData());
/* 325 */             } catch (Exception exception) {
/* 326 */               sendErrorResponse(exception);
/*     */             } 
/*     */           } 
/* 329 */         } else if (c == 'P') {
/* 330 */           Portal portal = this.portals.get(str3);
/* 331 */           if (portal == null) {
/* 332 */             sendErrorResponse("Portal not found: " + str3);
/*     */           } else {
/* 334 */             JdbcPreparedStatement jdbcPreparedStatement = portal.prep.prep;
/*     */             try {
/* 336 */               ResultSetMetaData resultSetMetaData = jdbcPreparedStatement.getMetaData();
/* 337 */               sendRowDescription(resultSetMetaData);
/* 338 */             } catch (Exception exception) {
/* 339 */               sendErrorResponse(exception);
/*     */             } 
/*     */           } 
/*     */         } else {
/* 343 */           this.server.trace("expected S or P, got " + c);
/* 344 */           sendErrorResponse("expected S or P");
/*     */         } 
/*     */         return;
/*     */       
/*     */       case true:
/* 349 */         str1 = readString();
/* 350 */         this.server.trace("Execute");
/* 351 */         portal2 = this.portals.get(str1);
/* 352 */         if (portal2 == null) {
/* 353 */           sendErrorResponse("Portal not found: " + str1);
/*     */         } else {
/*     */           
/* 356 */           short s1 = readShort();
/* 357 */           Prepared prepared = portal2.prep;
/* 358 */           JdbcPreparedStatement jdbcPreparedStatement = prepared.prep;
/* 359 */           this.server.trace(prepared.sql);
/*     */           try {
/* 361 */             jdbcPreparedStatement.setMaxRows(s1);
/* 362 */             setActiveRequest((JdbcStatement)jdbcPreparedStatement);
/* 363 */             boolean bool1 = jdbcPreparedStatement.execute();
/* 364 */             if (bool1) {
/*     */               try {
/* 366 */                 ResultSet resultSet = jdbcPreparedStatement.getResultSet();
/*     */                 
/* 368 */                 while (resultSet.next()) {
/* 369 */                   sendDataRow(resultSet, portal2.resultColumnFormat);
/*     */                 }
/* 371 */                 sendCommandComplete((JdbcStatement)jdbcPreparedStatement, 0);
/* 372 */               } catch (Exception exception) {
/* 373 */                 sendErrorResponse(exception);
/*     */               } 
/*     */             } else {
/* 376 */               sendCommandComplete((JdbcStatement)jdbcPreparedStatement, jdbcPreparedStatement.getUpdateCount());
/*     */             } 
/* 378 */           } catch (Exception exception) {
/* 379 */             if (jdbcPreparedStatement.wasCancelled()) {
/* 380 */               sendCancelQueryResponse();
/*     */             } else {
/* 382 */               sendErrorResponse(exception);
/*     */             } 
/*     */           } finally {
/* 385 */             setActiveRequest(null);
/*     */           } 
/*     */         } 
/*     */         return;
/*     */       case true:
/* 390 */         this.server.trace("Sync");
/* 391 */         sendReadyForQuery();
/*     */         return;
/*     */       
/*     */       case true:
/* 395 */         this.server.trace("Query");
/* 396 */         str1 = readString();
/* 397 */         scriptReader = new ScriptReader(new StringReader(str1)); while (true) {
/*     */           JdbcStatement jdbcStatement;
/* 399 */           prepared2 = null;
/*     */           
/* 401 */           try { String str = scriptReader.readStatement();
/* 402 */             if (str == null)
/*     */             
/*     */             { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 433 */               JdbcUtils.closeSilently((Statement)prepared2);
/* 434 */               setActiveRequest(null); break; }  str = getSQL(str); jdbcStatement = (JdbcStatement)this.conn.createStatement(); setActiveRequest(jdbcStatement); boolean bool1 = jdbcStatement.execute(str); if (bool1) { ResultSet resultSet = jdbcStatement.getResultSet(); ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); try { sendRowDescription(resultSetMetaData); while (resultSet.next()) sendDataRow(resultSet, null);  sendCommandComplete(jdbcStatement, 0); } catch (Exception exception) { sendErrorResponse(exception); JdbcUtils.closeSilently((Statement)jdbcStatement); setActiveRequest(null); break; }  } else { sendCommandComplete(jdbcStatement, jdbcStatement.getUpdateCount()); }  } catch (SQLException sQLException) { if (jdbcStatement != null && jdbcStatement.wasCancelled()) { sendCancelQueryResponse(); } else { sendErrorResponse(sQLException); }  break; } finally { JdbcUtils.closeSilently((Statement)jdbcStatement); setActiveRequest(null); }
/*     */         
/*     */         } 
/* 437 */         sendReadyForQuery();
/*     */         return;
/*     */       
/*     */       case true:
/* 441 */         this.server.trace("Terminate");
/* 442 */         close();
/*     */         return;
/*     */     } 
/*     */     
/* 446 */     this.server.trace("Unsupported: " + bool + " (" + (char)bool + ")"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getSQL(String paramString) {
/* 452 */     String str = StringUtils.toLowerEnglish(paramString);
/* 453 */     if (str.startsWith("show max_identifier_length")) {
/* 454 */       paramString = "CALL 63";
/* 455 */     } else if (str.startsWith("set client_encoding to")) {
/* 456 */       paramString = "set DATESTYLE ISO";
/*     */     } 
/*     */     
/* 459 */     if (this.server.getTrace()) {
/* 460 */       this.server.trace(paramString + ";");
/*     */     }
/* 462 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   private void sendCommandComplete(JdbcStatement paramJdbcStatement, int paramInt) throws IOException {
/* 467 */     startMessage(67);
/* 468 */     switch (paramJdbcStatement.getLastExecutedCommandType()) {
/*     */       case 61:
/* 470 */         writeStringPart("INSERT 0 ");
/* 471 */         writeString(Integer.toString(paramInt));
/*     */         break;
/*     */       case 68:
/* 474 */         writeStringPart("UPDATE ");
/* 475 */         writeString(Integer.toString(paramInt));
/*     */         break;
/*     */       case 58:
/* 478 */         writeStringPart("DELETE ");
/* 479 */         writeString(Integer.toString(paramInt));
/*     */         break;
/*     */       case 57:
/*     */       case 66:
/* 483 */         writeString("SELECT");
/*     */         break;
/*     */       case 83:
/* 486 */         writeString("BEGIN");
/*     */         break;
/*     */       default:
/* 489 */         this.server.trace("check CommandComplete tag for command " + paramJdbcStatement);
/* 490 */         writeStringPart("UPDATE ");
/* 491 */         writeString(Integer.toString(paramInt)); break;
/*     */     } 
/* 493 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendDataRow(ResultSet paramResultSet, int[] paramArrayOfint) throws Exception {
/* 497 */     ResultSetMetaData resultSetMetaData = paramResultSet.getMetaData();
/* 498 */     int i = resultSetMetaData.getColumnCount();
/* 499 */     startMessage(68);
/* 500 */     writeShort(i);
/* 501 */     for (byte b = 1; b <= i; b++) {
/* 502 */       int j = PgServer.convertType(resultSetMetaData.getColumnType(b));
/* 503 */       boolean bool = formatAsText(j);
/* 504 */       if (paramArrayOfint != null) {
/* 505 */         if (paramArrayOfint.length == 0) {
/* 506 */           bool = true;
/* 507 */         } else if (paramArrayOfint.length == 1) {
/* 508 */           bool = (paramArrayOfint[0] == 0);
/* 509 */         } else if (b - 1 < paramArrayOfint.length) {
/* 510 */           bool = (paramArrayOfint[b - 1] == 0);
/*     */         } 
/*     */       }
/* 513 */       writeDataColumn(paramResultSet, b, j, bool);
/*     */     } 
/* 515 */     sendMessage();
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeDataColumn(ResultSet paramResultSet, int paramInt1, int paramInt2, boolean paramBoolean) throws Exception {
/* 520 */     if (paramBoolean) {
/*     */       
/* 522 */       switch (paramInt2) {
/*     */         case 16:
/* 524 */           writeInt(1);
/* 525 */           this.dataOut.writeByte(paramResultSet.getBoolean(paramInt1) ? 116 : 102);
/*     */           return;
/*     */       } 
/* 528 */       String str = paramResultSet.getString(paramInt1);
/* 529 */       if (str == null) {
/* 530 */         writeInt(-1);
/*     */       } else {
/* 532 */         byte[] arrayOfByte = str.getBytes(getEncoding());
/* 533 */         writeInt(arrayOfByte.length);
/* 534 */         write(arrayOfByte);
/*     */       } 
/*     */     } else {
/*     */       byte[] arrayOfByte;
/*     */       
/* 539 */       switch (paramInt2) {
/*     */         case 21:
/* 541 */           writeInt(2);
/* 542 */           writeShort(paramResultSet.getShort(paramInt1));
/*     */           return;
/*     */         case 23:
/* 545 */           writeInt(4);
/* 546 */           writeInt(paramResultSet.getInt(paramInt1));
/*     */           return;
/*     */         case 20:
/* 549 */           writeInt(8);
/* 550 */           this.dataOut.writeLong(paramResultSet.getLong(paramInt1));
/*     */           return;
/*     */         case 700:
/* 553 */           writeInt(4);
/* 554 */           this.dataOut.writeFloat(paramResultSet.getFloat(paramInt1));
/*     */           return;
/*     */         case 701:
/* 557 */           writeInt(8);
/* 558 */           this.dataOut.writeDouble(paramResultSet.getDouble(paramInt1));
/*     */           return;
/*     */         case 17:
/* 561 */           arrayOfByte = paramResultSet.getBytes(paramInt1);
/* 562 */           if (arrayOfByte == null) {
/* 563 */             writeInt(-1);
/*     */           } else {
/* 565 */             writeInt(arrayOfByte.length);
/* 566 */             write(arrayOfByte);
/*     */           } 
/*     */           return;
/*     */       } 
/* 570 */       throw new IllegalStateException("output binary format is undefined");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String getEncoding() {
/* 576 */     if ("UNICODE".equals(this.clientEncoding)) {
/* 577 */       return "UTF-8";
/*     */     }
/* 579 */     return this.clientEncoding;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setParameter(PreparedStatement paramPreparedStatement, int paramInt1, int paramInt2, int[] paramArrayOfint) throws SQLException, IOException {
/* 584 */     boolean bool = (paramInt2 >= paramArrayOfint.length || paramArrayOfint[paramInt2] == 0) ? true : false;
/* 585 */     int i = paramInt2 + 1;
/* 586 */     int j = readInt();
/* 587 */     if (j == -1) {
/* 588 */       paramPreparedStatement.setNull(i, 0);
/* 589 */     } else if (bool) {
/*     */       
/* 591 */       byte[] arrayOfByte = DataUtils.newBytes(j);
/* 592 */       readFully(arrayOfByte);
/* 593 */       paramPreparedStatement.setString(i, new String(arrayOfByte, getEncoding()));
/*     */     } else {
/*     */       byte[] arrayOfByte1;
/* 596 */       switch (paramInt1) {
/*     */         case 21:
/* 598 */           checkParamLength(2, j);
/* 599 */           paramPreparedStatement.setShort(i, readShort());
/*     */           return;
/*     */         case 23:
/* 602 */           checkParamLength(4, j);
/* 603 */           paramPreparedStatement.setInt(i, readInt());
/*     */           return;
/*     */         case 20:
/* 606 */           checkParamLength(8, j);
/* 607 */           paramPreparedStatement.setLong(i, this.dataIn.readLong());
/*     */           return;
/*     */         case 700:
/* 610 */           checkParamLength(4, j);
/* 611 */           paramPreparedStatement.setFloat(i, this.dataIn.readFloat());
/*     */           return;
/*     */         case 701:
/* 614 */           checkParamLength(8, j);
/* 615 */           paramPreparedStatement.setDouble(i, this.dataIn.readDouble());
/*     */           return;
/*     */         case 17:
/* 618 */           arrayOfByte1 = DataUtils.newBytes(j);
/* 619 */           readFully(arrayOfByte1);
/* 620 */           paramPreparedStatement.setBytes(i, arrayOfByte1);
/*     */           return;
/*     */       } 
/* 623 */       this.server.trace("Binary format for type: " + paramInt1 + " is unsupported");
/* 624 */       byte[] arrayOfByte2 = DataUtils.newBytes(j);
/* 625 */       readFully(arrayOfByte2);
/* 626 */       paramPreparedStatement.setString(i, new String(arrayOfByte2, getEncoding()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void checkParamLength(int paramInt1, int paramInt2) {
/* 632 */     if (paramInt1 != paramInt2) {
/* 633 */       throw DbException.getInvalidValueException("paramLen", Integer.valueOf(paramInt2));
/*     */     }
/*     */   }
/*     */   
/*     */   private void sendErrorResponse(Exception paramException) throws IOException {
/* 638 */     SQLException sQLException = DbException.toSQLException(paramException);
/* 639 */     this.server.traceError(sQLException);
/* 640 */     startMessage(69);
/* 641 */     write(83);
/* 642 */     writeString("ERROR");
/* 643 */     write(67);
/* 644 */     writeString(sQLException.getSQLState());
/* 645 */     write(77);
/* 646 */     writeString(sQLException.getMessage());
/* 647 */     write(68);
/* 648 */     writeString(sQLException.toString());
/* 649 */     write(0);
/* 650 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendCancelQueryResponse() throws IOException {
/* 654 */     this.server.trace("CancelSuccessResponse");
/* 655 */     startMessage(69);
/* 656 */     write(83);
/* 657 */     writeString("ERROR");
/* 658 */     write(67);
/* 659 */     writeString("57014");
/* 660 */     write(77);
/* 661 */     writeString("canceling statement due to user request");
/* 662 */     write(0);
/* 663 */     sendMessage();
/*     */   }
/*     */ 
/*     */   
/*     */   private void sendParameterDescription(ParameterMetaData paramParameterMetaData, int[] paramArrayOfint) throws Exception {
/* 668 */     int i = paramParameterMetaData.getParameterCount();
/* 669 */     startMessage(116);
/* 670 */     writeShort(i);
/* 671 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/* 673 */       if (paramArrayOfint != null && paramArrayOfint[b] != 0) {
/* 674 */         c = paramArrayOfint[b];
/*     */       } else {
/* 676 */         c = 'Г';
/*     */       } 
/* 678 */       this.server.checkType(c);
/* 679 */       writeInt(c);
/*     */     } 
/* 681 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendNoData() throws IOException {
/* 685 */     startMessage(110);
/* 686 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendRowDescription(ResultSetMetaData paramResultSetMetaData) throws Exception {
/* 690 */     if (paramResultSetMetaData == null) {
/* 691 */       sendNoData();
/*     */     } else {
/* 693 */       int i = paramResultSetMetaData.getColumnCount();
/* 694 */       int[] arrayOfInt1 = new int[i];
/* 695 */       int[] arrayOfInt2 = new int[i];
/* 696 */       String[] arrayOfString = new String[i]; byte b;
/* 697 */       for (b = 0; b < i; b++) {
/* 698 */         String str = paramResultSetMetaData.getColumnName(b + 1);
/* 699 */         arrayOfString[b] = str;
/* 700 */         int j = paramResultSetMetaData.getColumnType(b + 1);
/* 701 */         int k = PgServer.convertType(j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 709 */         arrayOfInt2[b] = paramResultSetMetaData.getColumnDisplaySize(b + 1);
/* 710 */         if (j != 0) {
/* 711 */           this.server.checkType(k);
/*     */         }
/* 713 */         arrayOfInt1[b] = k;
/*     */       } 
/* 715 */       startMessage(84);
/* 716 */       writeShort(i);
/* 717 */       for (b = 0; b < i; b++) {
/* 718 */         writeString(StringUtils.toLowerEnglish(arrayOfString[b]));
/*     */         
/* 720 */         writeInt(0);
/*     */         
/* 722 */         writeShort(0);
/*     */         
/* 724 */         writeInt(arrayOfInt1[b]);
/*     */         
/* 726 */         writeShort(getTypeSize(arrayOfInt1[b], arrayOfInt2[b]));
/*     */         
/* 728 */         writeInt(-1);
/*     */         
/* 730 */         writeShort(formatAsText(arrayOfInt1[b]) ? 0 : 1);
/*     */       } 
/* 732 */       sendMessage();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean formatAsText(int paramInt) {
/* 742 */     switch (paramInt) {
/*     */ 
/*     */       
/*     */       case 17:
/* 746 */         return false;
/*     */     } 
/* 748 */     return true;
/*     */   }
/*     */   
/*     */   private static int getTypeSize(int paramInt1, int paramInt2) {
/* 752 */     switch (paramInt1) {
/*     */       case 16:
/* 754 */         return 1;
/*     */       case 1043:
/* 756 */         return Math.max(255, paramInt2 + 10);
/*     */     } 
/* 758 */     return paramInt2 + 4;
/*     */   }
/*     */ 
/*     */   
/*     */   private void sendErrorResponse(String paramString) throws IOException {
/* 763 */     this.server.trace("Exception: " + paramString);
/* 764 */     startMessage(69);
/* 765 */     write(83);
/* 766 */     writeString("ERROR");
/* 767 */     write(67);
/*     */     
/* 769 */     writeString("08P01");
/* 770 */     write(77);
/* 771 */     writeString(paramString);
/* 772 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendParseComplete() throws IOException {
/* 776 */     startMessage(49);
/* 777 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendBindComplete() throws IOException {
/* 781 */     startMessage(50);
/* 782 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendCloseComplete() throws IOException {
/* 786 */     startMessage(51);
/* 787 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void initDb() throws SQLException {
/* 791 */     Statement statement = null;
/* 792 */     ResultSet resultSet = null;
/*     */     try {
/* 794 */       synchronized (this.server) {
/*     */         
/* 796 */         resultSet = this.conn.getMetaData().getTables(null, "PG_CATALOG", "PG_VERSION", null);
/* 797 */         boolean bool = resultSet.next();
/* 798 */         statement = this.conn.createStatement();
/* 799 */         if (!bool) {
/* 800 */           installPgCatalog(statement);
/*     */         }
/* 802 */         resultSet = statement.executeQuery("select * from pg_catalog.pg_version");
/* 803 */         if (!resultSet.next() || resultSet.getInt(1) < 2) {
/*     */           
/* 805 */           installPgCatalog(statement);
/*     */         } else {
/*     */           
/* 808 */           int i = resultSet.getInt(2);
/* 809 */           if (i > 2) {
/* 810 */             throw DbException.throwInternalError("Incompatible PG_VERSION");
/*     */           }
/*     */         } 
/*     */       } 
/* 814 */       statement.execute("set search_path = PUBLIC, pg_catalog");
/* 815 */       HashSet<Integer> hashSet = this.server.getTypeSet();
/* 816 */       if (hashSet.size() == 0) {
/* 817 */         resultSet = statement.executeQuery("select oid from pg_catalog.pg_type");
/* 818 */         while (resultSet.next()) {
/* 819 */           hashSet.add(Integer.valueOf(resultSet.getInt(1)));
/*     */         }
/*     */       } 
/*     */     } finally {
/* 823 */       JdbcUtils.closeSilently(statement);
/* 824 */       JdbcUtils.closeSilently(resultSet);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void installPgCatalog(Statement paramStatement) throws SQLException {
/* 829 */     try (InputStreamReader null = new InputStreamReader(new ByteArrayInputStream(Utils.getResource("/org/h2/server/pg/pg_catalog.sql")))) {
/*     */       
/* 831 */       ScriptReader scriptReader = new ScriptReader(inputStreamReader);
/*     */       while (true) {
/* 833 */         String str = scriptReader.readStatement();
/* 834 */         if (str == null) {
/*     */           break;
/*     */         }
/* 837 */         paramStatement.execute(str);
/*     */       } 
/* 839 */       scriptReader.close();
/* 840 */     } catch (IOException iOException) {
/* 841 */       throw DbException.convertIOException(iOException, "Can not read pg_catalog resource");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void close() {
/*     */     try {
/* 850 */       this.stop = true;
/* 851 */       JdbcUtils.closeSilently(this.conn);
/* 852 */       if (this.socket != null) {
/* 853 */         this.socket.close();
/*     */       }
/* 855 */       this.server.trace("Close");
/* 856 */     } catch (Exception exception) {
/* 857 */       this.server.traceError(exception);
/*     */     } 
/* 859 */     this.conn = null;
/* 860 */     this.socket = null;
/* 861 */     this.server.remove(this);
/*     */   }
/*     */   
/*     */   private void sendAuthenticationCleartextPassword() throws IOException {
/* 865 */     startMessage(82);
/* 866 */     writeInt(3);
/* 867 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendAuthenticationOk() throws IOException {
/* 871 */     startMessage(82);
/* 872 */     writeInt(0);
/* 873 */     sendMessage();
/* 874 */     sendParameterStatus("client_encoding", this.clientEncoding);
/* 875 */     sendParameterStatus("DateStyle", this.dateStyle);
/* 876 */     sendParameterStatus("integer_datetimes", "off");
/* 877 */     sendParameterStatus("is_superuser", "off");
/* 878 */     sendParameterStatus("server_encoding", "SQL_ASCII");
/* 879 */     sendParameterStatus("server_version", "8.1.4");
/* 880 */     sendParameterStatus("session_authorization", this.userName);
/* 881 */     sendParameterStatus("standard_conforming_strings", "off");
/*     */     
/* 883 */     sendParameterStatus("TimeZone", "CET");
/* 884 */     sendBackendKeyData();
/* 885 */     sendReadyForQuery();
/*     */   }
/*     */   private void sendReadyForQuery() throws IOException {
/*     */     byte b;
/* 889 */     startMessage(90);
/*     */     
/*     */     try {
/* 892 */       if (this.conn.getAutoCommit()) {
/*     */         
/* 894 */         b = 73;
/*     */       } else {
/*     */         
/* 897 */         b = 84;
/*     */       } 
/* 899 */     } catch (SQLException sQLException) {
/*     */       
/* 901 */       b = 69;
/*     */     } 
/* 903 */     write((byte)b);
/* 904 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void sendBackendKeyData() throws IOException {
/* 908 */     startMessage(75);
/* 909 */     writeInt(this.processId);
/* 910 */     writeInt(this.secret);
/* 911 */     sendMessage();
/*     */   }
/*     */   
/*     */   private void writeString(String paramString) throws IOException {
/* 915 */     writeStringPart(paramString);
/* 916 */     write(0);
/*     */   }
/*     */   
/*     */   private void writeStringPart(String paramString) throws IOException {
/* 920 */     write(paramString.getBytes(getEncoding()));
/*     */   }
/*     */   
/*     */   private void writeInt(int paramInt) throws IOException {
/* 924 */     this.dataOut.writeInt(paramInt);
/*     */   }
/*     */   
/*     */   private void writeShort(int paramInt) throws IOException {
/* 928 */     this.dataOut.writeShort(paramInt);
/*     */   }
/*     */   
/*     */   private void write(byte[] paramArrayOfbyte) throws IOException {
/* 932 */     this.dataOut.write(paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   private void write(int paramInt) throws IOException {
/* 936 */     this.dataOut.write(paramInt);
/*     */   }
/*     */   
/*     */   private void startMessage(int paramInt) {
/* 940 */     this.messageType = paramInt;
/* 941 */     this.outBuffer = new ByteArrayOutputStream();
/* 942 */     this.dataOut = new DataOutputStream(this.outBuffer);
/*     */   }
/*     */   
/*     */   private void sendMessage() throws IOException {
/* 946 */     this.dataOut.flush();
/* 947 */     byte[] arrayOfByte = this.outBuffer.toByteArray();
/* 948 */     int i = arrayOfByte.length;
/* 949 */     this.dataOut = new DataOutputStream(this.out);
/* 950 */     this.dataOut.write(this.messageType);
/* 951 */     this.dataOut.writeInt(i + 4);
/* 952 */     this.dataOut.write(arrayOfByte);
/* 953 */     this.dataOut.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   private void sendParameterStatus(String paramString1, String paramString2) throws IOException {
/* 958 */     startMessage(83);
/* 959 */     writeString(paramString1);
/* 960 */     writeString(paramString2);
/* 961 */     sendMessage();
/*     */   }
/*     */   
/*     */   void setThread(Thread paramThread) {
/* 965 */     this.thread = paramThread;
/*     */   }
/*     */   
/*     */   Thread getThread() {
/* 969 */     return this.thread;
/*     */   }
/*     */   
/*     */   void setProcessId(int paramInt) {
/* 973 */     this.processId = paramInt;
/*     */   }
/*     */   
/*     */   int getProcessId() {
/* 977 */     return this.processId;
/*     */   }
/*     */   
/*     */   private synchronized void setActiveRequest(JdbcStatement paramJdbcStatement) {
/* 981 */     this.activeRequest = paramJdbcStatement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized void cancelRequest() {
/* 988 */     if (this.activeRequest != null)
/*     */       try {
/* 990 */         this.activeRequest.cancel();
/* 991 */         this.activeRequest = null;
/* 992 */       } catch (SQLException sQLException) {
/* 993 */         throw DbException.convert(sQLException);
/*     */       }  
/*     */   }
/*     */   
/*     */   static class Prepared {
/*     */     String name;
/*     */     String sql;
/*     */     JdbcPreparedStatement prep;
/*     */     int[] paramType;
/*     */   }
/*     */   
/*     */   static class Portal {
/*     */     String name;
/*     */     int[] resultColumnFormat;
/*     */     PgServerThread.Prepared prep;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\pg\PgServerThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */