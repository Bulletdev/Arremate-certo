/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Csv
/*     */   implements SimpleRowSource
/*     */ {
/*     */   private String[] columnNames;
/*  48 */   private String characterSet = SysProperties.FILE_ENCODING;
/*  49 */   private char escapeCharacter = '"';
/*  50 */   private char fieldDelimiter = '"';
/*  51 */   private char fieldSeparatorRead = ',';
/*  52 */   private String fieldSeparatorWrite = ",";
/*     */   private boolean caseSensitiveColumnNames;
/*     */   private boolean preserveWhitespace;
/*     */   private boolean writeColumnHeader = true;
/*     */   private char lineComment;
/*  57 */   private String lineSeparator = SysProperties.LINE_SEPARATOR;
/*  58 */   private String nullString = "";
/*     */   
/*     */   private String fileName;
/*     */   private Reader input;
/*     */   private char[] inputBuffer;
/*     */   private int inputBufferPos;
/*  64 */   private int inputBufferStart = -1; private int inputBufferEnd;
/*     */   private Writer output;
/*     */   private boolean endOfLine;
/*     */   private boolean endOfFile;
/*     */   
/*     */   private int writeResultSet(ResultSet paramResultSet) throws SQLException {
/*     */     
/*  71 */     try { byte b1 = 0;
/*  72 */       ResultSetMetaData resultSetMetaData = paramResultSet.getMetaData();
/*  73 */       int i = resultSetMetaData.getColumnCount();
/*  74 */       String[] arrayOfString = new String[i];
/*  75 */       int[] arrayOfInt = new int[i]; byte b2;
/*  76 */       for (b2 = 0; b2 < i; b2++) {
/*  77 */         arrayOfString[b2] = resultSetMetaData.getColumnLabel(b2 + 1);
/*  78 */         arrayOfInt[b2] = resultSetMetaData.getColumnType(b2 + 1);
/*     */       } 
/*  80 */       if (this.writeColumnHeader) {
/*  81 */         writeRow(arrayOfString);
/*     */       }
/*  83 */       while (paramResultSet.next()) {
/*  84 */         for (b2 = 0; b2 < i; b2++) {
/*     */           Date date; Time time; Timestamp timestamp; String str;
/*  86 */           switch (arrayOfInt[b2]) {
/*     */             case 91:
/*  88 */               date = paramResultSet.getDate(b2 + 1);
/*     */               break;
/*     */             case 92:
/*  91 */               time = paramResultSet.getTime(b2 + 1);
/*     */               break;
/*     */             case 93:
/*  94 */               timestamp = paramResultSet.getTimestamp(b2 + 1);
/*     */               break;
/*     */             default:
/*  97 */               str = paramResultSet.getString(b2 + 1); break;
/*     */           } 
/*  99 */           arrayOfString[b2] = (str == null) ? null : str.toString();
/*     */         } 
/* 101 */         writeRow(arrayOfString);
/* 102 */         b1++;
/*     */       } 
/* 104 */       this.output.close();
/* 105 */       b2 = b1;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 110 */       return b2; } catch (IOException iOException) { throw DbException.convertIOException(iOException, null); } finally { close(); JdbcUtils.closeSilently(paramResultSet); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int write(Writer paramWriter, ResultSet paramResultSet) throws SQLException {
/* 122 */     this.output = paramWriter;
/* 123 */     return writeResultSet(paramResultSet);
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
/*     */   public int write(String paramString1, ResultSet paramResultSet, String paramString2) throws SQLException {
/* 145 */     init(paramString1, paramString2);
/*     */     try {
/* 147 */       initWrite();
/* 148 */       return writeResultSet(paramResultSet);
/* 149 */     } catch (IOException iOException) {
/* 150 */       throw convertException("IOException writing " + paramString1, iOException);
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
/*     */   public int write(Connection paramConnection, String paramString1, String paramString2, String paramString3) throws SQLException {
/* 166 */     Statement statement = paramConnection.createStatement();
/* 167 */     ResultSet resultSet = statement.executeQuery(paramString2);
/* 168 */     int i = write(paramString1, resultSet, paramString3);
/* 169 */     statement.close();
/* 170 */     return i;
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
/*     */   public ResultSet read(String paramString1, String[] paramArrayOfString, String paramString2) throws SQLException {
/* 193 */     init(paramString1, paramString2);
/*     */     try {
/* 195 */       return readResultSet(paramArrayOfString);
/* 196 */     } catch (IOException iOException) {
/* 197 */       throw convertException("IOException reading " + paramString1, iOException);
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
/*     */   public ResultSet read(Reader paramReader, String[] paramArrayOfString) throws IOException {
/* 212 */     init(null, null);
/* 213 */     this.input = paramReader;
/* 214 */     return readResultSet(paramArrayOfString);
/*     */   }
/*     */   
/*     */   private ResultSet readResultSet(String[] paramArrayOfString) throws IOException {
/* 218 */     this.columnNames = paramArrayOfString;
/* 219 */     initRead();
/* 220 */     SimpleResultSet simpleResultSet = new SimpleResultSet(this);
/* 221 */     makeColumnNamesUnique();
/* 222 */     for (String str : this.columnNames) {
/* 223 */       simpleResultSet.addColumn(str, 12, 2147483647, 0);
/*     */     }
/* 225 */     return simpleResultSet;
/*     */   }
/*     */   
/*     */   private void makeColumnNamesUnique() {
/* 229 */     for (byte b = 0; b < this.columnNames.length; b++) {
/* 230 */       StringBuilder stringBuilder = new StringBuilder();
/* 231 */       String str = this.columnNames[b];
/* 232 */       if (str == null || str.length() == 0) {
/* 233 */         stringBuilder.append('C').append(b + 1);
/*     */       } else {
/* 235 */         stringBuilder.append(str);
/*     */       } 
/* 237 */       for (byte b1 = 0; b1 < b; b1++) {
/* 238 */         String str1 = this.columnNames[b1];
/* 239 */         if (stringBuilder.toString().equals(str1)) {
/* 240 */           stringBuilder.append('1');
/* 241 */           b1 = -1;
/*     */         } 
/*     */       } 
/* 244 */       this.columnNames[b] = stringBuilder.toString();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void init(String paramString1, String paramString2) {
/* 249 */     this.fileName = paramString1;
/* 250 */     if (paramString2 != null) {
/* 251 */       this.characterSet = paramString2;
/*     */     }
/*     */   }
/*     */   
/*     */   private void initWrite() throws IOException {
/* 256 */     if (this.output == null) {
/*     */       try {
/* 258 */         OutputStream outputStream = FileUtils.newOutputStream(this.fileName, false);
/* 259 */         outputStream = new BufferedOutputStream(outputStream, 4096);
/* 260 */         this.output = new BufferedWriter(new OutputStreamWriter(outputStream, this.characterSet));
/* 261 */       } catch (Exception exception) {
/* 262 */         close();
/* 263 */         throw DbException.convertToIOException(exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeRow(String[] paramArrayOfString) throws IOException {
/* 269 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 270 */       if (b > 0 && 
/* 271 */         this.fieldSeparatorWrite != null) {
/* 272 */         this.output.write(this.fieldSeparatorWrite);
/*     */       }
/*     */       
/* 275 */       String str = paramArrayOfString[b];
/* 276 */       if (str != null) {
/* 277 */         if (this.escapeCharacter != '\000') {
/* 278 */           if (this.fieldDelimiter != '\000') {
/* 279 */             this.output.write(this.fieldDelimiter);
/*     */           }
/* 281 */           this.output.write(escape(str));
/* 282 */           if (this.fieldDelimiter != '\000') {
/* 283 */             this.output.write(this.fieldDelimiter);
/*     */           }
/*     */         } else {
/* 286 */           this.output.write(str);
/*     */         } 
/* 288 */       } else if (this.nullString != null && this.nullString.length() > 0) {
/* 289 */         this.output.write(this.nullString);
/*     */       } 
/*     */     } 
/* 292 */     this.output.write(this.lineSeparator);
/*     */   }
/*     */   
/*     */   private String escape(String paramString) {
/* 296 */     if (paramString.indexOf(this.fieldDelimiter) < 0 && (
/* 297 */       this.escapeCharacter == this.fieldDelimiter || paramString.indexOf(this.escapeCharacter) < 0)) {
/* 298 */       return paramString;
/*     */     }
/*     */     
/* 301 */     int i = paramString.length();
/* 302 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 303 */     for (byte b = 0; b < i; b++) {
/* 304 */       char c = paramString.charAt(b);
/* 305 */       if (c == this.fieldDelimiter || c == this.escapeCharacter) {
/* 306 */         stringBuilder.append(this.escapeCharacter);
/*     */       }
/* 308 */       stringBuilder.append(c);
/*     */     } 
/* 310 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void initRead() throws IOException {
/* 314 */     if (this.input == null) {
/*     */       try {
/* 316 */         InputStream inputStream = FileUtils.newInputStream(this.fileName);
/* 317 */         inputStream = new BufferedInputStream(inputStream, 4096);
/* 318 */         this.input = new InputStreamReader(inputStream, this.characterSet);
/* 319 */       } catch (IOException iOException) {
/* 320 */         close();
/* 321 */         throw iOException;
/*     */       } 
/*     */     }
/* 324 */     if (!this.input.markSupported()) {
/* 325 */       this.input = new BufferedReader(this.input);
/*     */     }
/* 327 */     this.input.mark(1);
/* 328 */     int i = this.input.read();
/* 329 */     if (i != 65279)
/*     */     {
/*     */       
/* 332 */       this.input.reset();
/*     */     }
/* 334 */     this.inputBuffer = new char[8192];
/* 335 */     if (this.columnNames == null) {
/* 336 */       readHeader();
/*     */     }
/*     */   }
/*     */   
/*     */   private void readHeader() throws IOException {
/* 341 */     ArrayList<String> arrayList = New.arrayList();
/*     */     while (true) {
/* 343 */       String str = readValue();
/* 344 */       if (str == null) {
/* 345 */         if (this.endOfLine) {
/* 346 */           if (this.endOfFile || arrayList.size() > 0)
/*     */             break; 
/*     */           continue;
/*     */         } 
/* 350 */         str = "COLUMN" + arrayList.size();
/* 351 */         arrayList.add(str);
/*     */         continue;
/*     */       } 
/* 354 */       if (str.length() == 0) {
/* 355 */         str = "COLUMN" + arrayList.size();
/* 356 */       } else if (!this.caseSensitiveColumnNames && isSimpleColumnName(str)) {
/* 357 */         str = str.toUpperCase();
/*     */       } 
/* 359 */       arrayList.add(str);
/* 360 */       if (this.endOfLine) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 365 */     this.columnNames = new String[arrayList.size()];
/* 366 */     arrayList.toArray(this.columnNames);
/*     */   } private static boolean isSimpleColumnName(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 370 */     for (b = 0, i = paramString.length(); b < i; b++) {
/* 371 */       char c = paramString.charAt(b);
/* 372 */       if (b == 0) {
/* 373 */         if (c != '_' && !Character.isLetter(c)) {
/* 374 */           return false;
/*     */         }
/*     */       }
/* 377 */       else if (c != '_' && !Character.isLetterOrDigit(c)) {
/* 378 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 382 */     if (paramString.length() == 0) {
/* 383 */       return false;
/*     */     }
/* 385 */     return true;
/*     */   }
/*     */   
/*     */   private void pushBack() {
/* 389 */     this.inputBufferPos--;
/*     */   }
/*     */   
/*     */   private int readChar() throws IOException {
/* 393 */     if (this.inputBufferPos >= this.inputBufferEnd) {
/* 394 */       return readBuffer();
/*     */     }
/* 396 */     return this.inputBuffer[this.inputBufferPos++];
/*     */   }
/*     */   private int readBuffer() throws IOException {
/*     */     byte b;
/* 400 */     if (this.endOfFile) {
/* 401 */       return -1;
/*     */     }
/*     */     
/* 404 */     if (this.inputBufferStart >= 0) {
/* 405 */       b = this.inputBufferPos - this.inputBufferStart;
/* 406 */       if (b > 0) {
/* 407 */         char[] arrayOfChar = this.inputBuffer;
/* 408 */         if (b + 4096 > arrayOfChar.length) {
/* 409 */           this.inputBuffer = new char[arrayOfChar.length * 2];
/*     */         }
/* 411 */         System.arraycopy(arrayOfChar, this.inputBufferStart, this.inputBuffer, 0, b);
/*     */       } 
/* 413 */       this.inputBufferStart = 0;
/*     */     } else {
/* 415 */       b = 0;
/*     */     } 
/* 417 */     this.inputBufferPos = b;
/* 418 */     int i = this.input.read(this.inputBuffer, b, 4096);
/* 419 */     if (i == -1) {
/*     */ 
/*     */       
/* 422 */       this.inputBufferEnd = -1024;
/* 423 */       this.endOfFile = true;
/*     */ 
/*     */       
/* 426 */       this.inputBufferPos++;
/* 427 */       return -1;
/*     */     } 
/* 429 */     this.inputBufferEnd = b + i;
/* 430 */     return this.inputBuffer[this.inputBufferPos++];
/*     */   }
/*     */   private String readValue() throws IOException {
/*     */     int i;
/* 434 */     this.endOfLine = false;
/* 435 */     this.inputBufferStart = this.inputBufferPos;
/*     */     while (true) {
/* 437 */       i = readChar();
/* 438 */       if (i == this.fieldDelimiter) {
/*     */         byte b;
/* 440 */         boolean bool = false;
/* 441 */         this.inputBufferStart = this.inputBufferPos;
/*     */         
/*     */         while (true) {
/* 444 */           i = readChar();
/* 445 */           if (i == this.fieldDelimiter) {
/* 446 */             i = readChar();
/* 447 */             if (i != this.fieldDelimiter) {
/* 448 */               b = 2;
/*     */               break;
/*     */             } 
/* 451 */             bool = true; continue;
/* 452 */           }  if (i == this.escapeCharacter) {
/* 453 */             i = readChar();
/* 454 */             if (i < 0) {
/* 455 */               b = 1;
/*     */               break;
/*     */             } 
/* 458 */             bool = true; continue;
/* 459 */           }  if (i < 0) {
/* 460 */             b = 1;
/*     */             break;
/*     */           } 
/*     */         } 
/* 464 */         String str1 = new String(this.inputBuffer, this.inputBufferStart, this.inputBufferPos - this.inputBufferStart - b);
/*     */         
/* 466 */         if (bool) {
/* 467 */           str1 = unEscape(str1);
/*     */         }
/* 469 */         this.inputBufferStart = -1;
/*     */         
/* 471 */         while (i != this.fieldSeparatorRead) {
/*     */           
/* 473 */           if (i == 10 || i < 0 || i == 13) {
/* 474 */             this.endOfLine = true; break;
/*     */           } 
/* 476 */           if (i == 32 || i == 9) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 482 */             i = readChar(); continue;
/*     */           }  pushBack(); break;
/* 484 */         }  return str1;
/* 485 */       }  if (i == 10 || i < 0 || i == 13) {
/* 486 */         this.endOfLine = true;
/* 487 */         return null;
/* 488 */       }  if (i == this.fieldSeparatorRead)
/*     */       {
/* 490 */         return null; } 
/* 491 */       if (i <= 32)
/*     */         continue;  break;
/*     */     } 
/* 494 */     if (this.lineComment != '\000' && i == this.lineComment) {
/*     */       
/* 496 */       this.inputBufferStart = -1;
/*     */       do {
/* 498 */         i = readChar();
/* 499 */       } while (i != 10 && i >= 0 && i != 13);
/*     */ 
/*     */ 
/*     */       
/* 503 */       this.endOfLine = true;
/* 504 */       return null;
/*     */     } 
/*     */     
/*     */     while (true) {
/* 508 */       i = readChar();
/* 509 */       if (i == this.fieldSeparatorRead)
/*     */         break; 
/* 511 */       if (i == 10 || i < 0 || i == 13) {
/* 512 */         this.endOfLine = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 516 */     String str = new String(this.inputBuffer, this.inputBufferStart, this.inputBufferPos - this.inputBufferStart - 1);
/*     */     
/* 518 */     if (!this.preserveWhitespace) {
/* 519 */       str = str.trim();
/*     */     }
/* 521 */     this.inputBufferStart = -1;
/*     */     
/* 523 */     return readNull(str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String readNull(String paramString) {
/* 529 */     return paramString.equals(this.nullString) ? null : paramString;
/*     */   }
/*     */   
/*     */   private String unEscape(String paramString) {
/* 533 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 534 */     int i = 0;
/* 535 */     char[] arrayOfChar = null;
/*     */     while (true) {
/* 537 */       int j = paramString.indexOf(this.escapeCharacter, i);
/* 538 */       if (j < 0) {
/* 539 */         j = paramString.indexOf(this.fieldDelimiter, i);
/* 540 */         if (j < 0) {
/*     */           break;
/*     */         }
/*     */       } 
/* 544 */       if (arrayOfChar == null) {
/* 545 */         arrayOfChar = paramString.toCharArray();
/*     */       }
/* 547 */       stringBuilder.append(arrayOfChar, i, j - i);
/* 548 */       if (j == paramString.length() - 1) {
/* 549 */         i = paramString.length();
/*     */         break;
/*     */       } 
/* 552 */       stringBuilder.append(arrayOfChar[j + 1]);
/* 553 */       i = j + 2;
/*     */     } 
/* 555 */     stringBuilder.append(paramString.substring(i));
/* 556 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] readRow() throws SQLException {
/* 564 */     if (this.input == null) {
/* 565 */       return null;
/*     */     }
/* 567 */     String[] arrayOfString = new String[this.columnNames.length];
/*     */     try {
/* 569 */       byte b = 0;
/*     */       while (true) {
/* 571 */         String str = readValue();
/* 572 */         if (str == null && 
/* 573 */           this.endOfLine) {
/* 574 */           if (!b) {
/* 575 */             if (this.endOfFile) {
/* 576 */               return null;
/*     */             }
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/*     */           break;
/*     */         } 
/* 584 */         if (b < arrayOfString.length) {
/* 585 */           arrayOfString[b++] = str;
/*     */         }
/* 587 */         if (this.endOfLine) {
/*     */           break;
/*     */         }
/*     */       } 
/* 591 */     } catch (IOException iOException) {
/* 592 */       throw convertException("IOException reading from " + this.fileName, iOException);
/*     */     } 
/* 594 */     return (Object[])arrayOfString;
/*     */   }
/*     */   
/*     */   private static SQLException convertException(String paramString, Exception paramException) {
/* 598 */     return DbException.get(90028, paramException, new String[] { paramString }).getSQLException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 606 */     IOUtils.closeSilently(this.input);
/* 607 */     this.input = null;
/* 608 */     IOUtils.closeSilently(this.output);
/* 609 */     this.output = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() throws SQLException {
/* 617 */     throw new SQLException("Method is not supported", "CSV");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldSeparatorWrite(String paramString) {
/* 626 */     this.fieldSeparatorWrite = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldSeparatorWrite() {
/* 635 */     return this.fieldSeparatorWrite;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCaseSensitiveColumnNames(boolean paramBoolean) {
/* 645 */     this.caseSensitiveColumnNames = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCaseSensitiveColumnNames() {
/* 654 */     return this.caseSensitiveColumnNames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldSeparatorRead(char paramChar) {
/* 663 */     this.fieldSeparatorRead = paramChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getFieldSeparatorRead() {
/* 672 */     return this.fieldSeparatorRead;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineCommentCharacter(char paramChar) {
/* 682 */     this.lineComment = paramChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getLineCommentCharacter() {
/* 691 */     return this.lineComment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldDelimiter(char paramChar) {
/* 701 */     this.fieldDelimiter = paramChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getFieldDelimiter() {
/* 710 */     return this.fieldDelimiter;
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
/*     */   public void setEscapeCharacter(char paramChar) {
/* 740 */     this.escapeCharacter = paramChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getEscapeCharacter() {
/* 749 */     return this.escapeCharacter;
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
/*     */   public void setLineSeparator(String paramString) {
/* 761 */     this.lineSeparator = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLineSeparator() {
/* 770 */     return this.lineSeparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNullString(String paramString) {
/* 780 */     this.nullString = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNullString() {
/* 789 */     return this.nullString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPreserveWhitespace(boolean paramBoolean) {
/* 798 */     this.preserveWhitespace = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPreserveWhitespace() {
/* 807 */     return this.preserveWhitespace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWriteColumnHeader(boolean paramBoolean) {
/* 816 */     this.writeColumnHeader = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getWriteColumnHeader() {
/* 825 */     return this.writeColumnHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String setOptions(String paramString) {
/* 836 */     String str = null;
/* 837 */     String[] arrayOfString = StringUtils.arraySplit(paramString, ' ', false);
/* 838 */     for (String str1 : arrayOfString) {
/* 839 */       if (str1.length() != 0) {
/*     */ 
/*     */         
/* 842 */         int i = str1.indexOf('=');
/* 843 */         String str2 = StringUtils.trim(str1.substring(0, i), true, true, " ");
/* 844 */         String str3 = str1.substring(i + 1);
/* 845 */         boolean bool = (str3.length() == 0) ? false : str3.charAt(0);
/* 846 */         if (isParam(str2, new String[] { "escape", "esc", "escapeCharacter" })) {
/* 847 */           setEscapeCharacter(bool);
/* 848 */         } else if (isParam(str2, new String[] { "fieldDelimiter", "fieldDelim" })) {
/* 849 */           setFieldDelimiter(bool);
/* 850 */         } else if (isParam(str2, new String[] { "fieldSeparator", "fieldSep" })) {
/* 851 */           setFieldSeparatorRead(bool);
/* 852 */           setFieldSeparatorWrite(str3);
/* 853 */         } else if (isParam(str2, new String[] { "lineComment", "lineCommentCharacter" })) {
/* 854 */           setLineCommentCharacter(bool);
/* 855 */         } else if (isParam(str2, new String[] { "lineSeparator", "lineSep" })) {
/* 856 */           setLineSeparator(str3);
/* 857 */         } else if (isParam(str2, new String[] { "null", "nullString" })) {
/* 858 */           setNullString(str3);
/* 859 */         } else if (isParam(str2, new String[] { "charset", "characterSet" })) {
/* 860 */           str = str3;
/* 861 */         } else if (isParam(str2, new String[] { "preserveWhitespace" })) {
/* 862 */           setPreserveWhitespace(Boolean.parseBoolean(str3));
/* 863 */         } else if (isParam(str2, new String[] { "writeColumnHeader" })) {
/* 864 */           setWriteColumnHeader(Boolean.parseBoolean(str3));
/* 865 */         } else if (isParam(str2, new String[] { "caseSensitiveColumnNames" })) {
/* 866 */           setCaseSensitiveColumnNames(Boolean.parseBoolean(str3));
/*     */         } else {
/* 868 */           throw DbException.getUnsupportedException(str2);
/*     */         } 
/*     */       } 
/* 871 */     }  return str;
/*     */   }
/*     */   
/*     */   private static boolean isParam(String paramString, String... paramVarArgs) {
/* 875 */     for (String str : paramVarArgs) {
/* 876 */       if (paramString.equalsIgnoreCase(str)) {
/* 877 */         return true;
/*     */       }
/*     */     } 
/* 880 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\Csv.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */