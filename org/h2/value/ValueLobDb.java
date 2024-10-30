/*     */ package org.h2.value;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.store.FileStoreInputStream;
/*     */ import org.h2.store.FileStoreOutputStream;
/*     */ import org.h2.store.LobStorageInterface;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class ValueLobDb
/*     */   extends Value
/*     */   implements Value.ValueBlob, Value.ValueClob
/*     */ {
/*     */   private final int type;
/*     */   private final long lobId;
/*     */   private final byte[] hmac;
/*     */   private final byte[] small;
/*     */   private final DataHandler handler;
/*     */   private final long precision;
/*     */   private final String fileName;
/*     */   private final FileStore tempFile;
/*     */   private int tableId;
/*     */   private int hash;
/*     */   
/*     */   private ValueLobDb(int paramInt1, DataHandler paramDataHandler, int paramInt2, long paramLong1, byte[] paramArrayOfbyte, long paramLong2) {
/*  60 */     this.type = paramInt1;
/*  61 */     this.handler = paramDataHandler;
/*  62 */     this.tableId = paramInt2;
/*  63 */     this.lobId = paramLong1;
/*  64 */     this.hmac = paramArrayOfbyte;
/*  65 */     this.precision = paramLong2;
/*  66 */     this.small = null;
/*  67 */     this.fileName = null;
/*  68 */     this.tempFile = null;
/*     */   }
/*     */   
/*     */   private ValueLobDb(int paramInt, byte[] paramArrayOfbyte, long paramLong) {
/*  72 */     this.type = paramInt;
/*  73 */     this.small = paramArrayOfbyte;
/*  74 */     this.precision = paramLong;
/*  75 */     this.lobId = 0L;
/*  76 */     this.hmac = null;
/*  77 */     this.handler = null;
/*  78 */     this.fileName = null;
/*  79 */     this.tempFile = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ValueLobDb(DataHandler paramDataHandler, Reader paramReader, long paramLong) throws IOException {
/*  87 */     this.type = 16;
/*  88 */     this.handler = paramDataHandler;
/*  89 */     this.small = null;
/*  90 */     this.lobId = 0L;
/*  91 */     this.hmac = null;
/*  92 */     this.fileName = createTempLobFileName(paramDataHandler);
/*  93 */     this.tempFile = this.handler.openFile(this.fileName, "rw", false);
/*  94 */     this.tempFile.autoDelete();
/*     */     
/*  96 */     long l = 0L;
/*  97 */     try (FileStoreOutputStream null = new FileStoreOutputStream(this.tempFile, null, null)) {
/*  98 */       char[] arrayOfChar = new char[4096];
/*     */       while (true) {
/* 100 */         int i = getBufferSize(this.handler, false, paramLong);
/* 101 */         i = IOUtils.readFully(paramReader, arrayOfChar, i);
/* 102 */         if (i == 0) {
/*     */           break;
/*     */         }
/* 105 */         byte[] arrayOfByte = (new String(arrayOfChar, 0, i)).getBytes("UTF-8");
/* 106 */         fileStoreOutputStream.write(arrayOfByte);
/* 107 */         l += i;
/*     */       } 
/*     */     } 
/* 110 */     this.precision = l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ValueLobDb(DataHandler paramDataHandler, byte[] paramArrayOfbyte, int paramInt, InputStream paramInputStream, long paramLong) throws IOException {
/* 118 */     this.type = 15;
/* 119 */     this.handler = paramDataHandler;
/* 120 */     this.small = null;
/* 121 */     this.lobId = 0L;
/* 122 */     this.hmac = null;
/* 123 */     this.fileName = createTempLobFileName(paramDataHandler);
/* 124 */     this.tempFile = this.handler.openFile(this.fileName, "rw", false);
/* 125 */     this.tempFile.autoDelete();
/* 126 */     FileStoreOutputStream fileStoreOutputStream = new FileStoreOutputStream(this.tempFile, null, null);
/* 127 */     long l = 0L;
/* 128 */     boolean bool = (this.handler.getLobCompressionAlgorithm(15) != null) ? true : false;
/*     */     try {
/*     */       do {
/* 131 */         l += paramInt;
/* 132 */         fileStoreOutputStream.write(paramArrayOfbyte, 0, paramInt);
/* 133 */         paramLong -= paramInt;
/* 134 */         if (paramLong <= 0L) {
/*     */           break;
/*     */         }
/* 137 */         paramInt = getBufferSize(this.handler, bool, paramLong);
/* 138 */         paramInt = IOUtils.readFully(paramInputStream, paramArrayOfbyte, paramInt);
/* 139 */       } while (paramInt > 0);
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/* 144 */       fileStoreOutputStream.close();
/*     */     } 
/* 146 */     this.precision = l;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String createTempLobFileName(DataHandler paramDataHandler) throws IOException {
/* 151 */     String str = paramDataHandler.getDatabasePath();
/* 152 */     if (str.length() == 0) {
/* 153 */       str = SysProperties.PREFIX_TEMP_FILE;
/*     */     }
/* 155 */     return FileUtils.createTempFile(str, ".temp.db", true, true);
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
/*     */   public static ValueLobDb create(int paramInt1, DataHandler paramDataHandler, int paramInt2, long paramLong1, byte[] paramArrayOfbyte, long paramLong2) {
/* 171 */     return new ValueLobDb(paramInt1, paramDataHandler, paramInt2, paramLong1, paramArrayOfbyte, paramLong2);
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
/*     */   public Value convertTo(int paramInt) {
/* 183 */     if (paramInt == this.type)
/* 184 */       return this; 
/* 185 */     if (paramInt == 16) {
/* 186 */       if (this.handler != null) {
/* 187 */         return this.handler.getLobStorage().createClob(getReader(), -1L);
/*     */       }
/*     */       
/* 190 */       if (this.small != null) {
/* 191 */         return createSmallLob(paramInt, this.small);
/*     */       }
/* 193 */     } else if (paramInt == 15) {
/* 194 */       if (this.handler != null) {
/* 195 */         return this.handler.getLobStorage().createBlob(getInputStream(), -1L);
/*     */       }
/*     */       
/* 198 */       if (this.small != null) {
/* 199 */         return createSmallLob(paramInt, this.small);
/*     */       }
/*     */     } 
/* 202 */     return super.convertTo(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLinkedToTable() {
/* 207 */     return (this.small == null && this.tableId >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStored() {
/* 212 */     return (this.small == null && this.fileName == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 217 */     if (this.fileName != null) {
/* 218 */       if (this.tempFile != null) {
/* 219 */         this.tempFile.stopAutoDelete();
/*     */       }
/*     */ 
/*     */       
/* 223 */       synchronized (this.handler.getLobSyncObject()) {
/* 224 */         FileUtils.delete(this.fileName);
/*     */       } 
/*     */     } 
/* 227 */     if (this.handler != null) {
/* 228 */       this.handler.getLobStorage().removeLob(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Value copy(DataHandler paramDataHandler, int paramInt) {
/* 234 */     if (this.small == null) {
/* 235 */       return this.handler.getLobStorage().copyLob(this, paramInt, getPrecision());
/*     */     }
/* 237 */     if (this.small.length > paramDataHandler.getMaxLengthInplaceLob()) {
/* 238 */       Value value1; LobStorageInterface lobStorageInterface = paramDataHandler.getLobStorage();
/*     */       
/* 240 */       if (this.type == 15) {
/* 241 */         value1 = lobStorageInterface.createBlob(getInputStream(), getPrecision());
/*     */       } else {
/* 243 */         value1 = lobStorageInterface.createClob(getReader(), getPrecision());
/*     */       } 
/* 245 */       Value value2 = value1.copy(paramDataHandler, paramInt);
/* 246 */       value1.remove();
/* 247 */       return value2;
/*     */     } 
/* 249 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTableId() {
/* 259 */     return this.tableId;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 264 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 269 */     return this.precision;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 274 */     int i = (this.precision > 2147483647L || this.precision == 0L) ? Integer.MAX_VALUE : (int)this.precision;
/*     */     try {
/*     */       byte[] arrayOfByte;
/* 277 */       if (this.type == 16) {
/* 278 */         if (this.small != null) {
/* 279 */           return new String(this.small, Constants.UTF8);
/*     */         }
/* 281 */         return IOUtils.readStringAndClose(getReader(), i);
/*     */       } 
/*     */       
/* 284 */       if (this.small != null) {
/* 285 */         arrayOfByte = this.small;
/*     */       } else {
/* 287 */         arrayOfByte = IOUtils.readBytesAndClose(getInputStream(), i);
/*     */       } 
/* 289 */       return StringUtils.convertBytesToHex(arrayOfByte);
/* 290 */     } catch (IOException iOException) {
/* 291 */       throw DbException.convertIOException(iOException, toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 297 */     if (this.type == 16)
/*     */     {
/* 299 */       return super.getBytes();
/*     */     }
/* 301 */     byte[] arrayOfByte = getBytesNoCopy();
/* 302 */     return Utils.cloneByteArray(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytesNoCopy() {
/* 307 */     if (this.type == 16)
/*     */     {
/* 309 */       return super.getBytesNoCopy();
/*     */     }
/* 311 */     if (this.small != null) {
/* 312 */       return this.small;
/*     */     }
/*     */     try {
/* 315 */       return IOUtils.readBytesAndClose(getInputStream(), 2147483647);
/* 316 */     } catch (IOException iOException) {
/* 317 */       throw DbException.convertIOException(iOException, toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 323 */     if (this.hash == 0) {
/* 324 */       if (this.precision > 4096L)
/*     */       {
/*     */         
/* 327 */         return (int)(this.precision ^ this.precision >>> 32L);
/*     */       }
/* 329 */       if (this.type == 16) {
/* 330 */         this.hash = getString().hashCode();
/*     */       } else {
/* 332 */         this.hash = Utils.getByteArrayHash(getBytes());
/*     */       } 
/*     */     } 
/* 335 */     return this.hash;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 340 */     if (paramValue instanceof ValueLobDb) {
/* 341 */       ValueLobDb valueLobDb = (ValueLobDb)paramValue;
/* 342 */       if (paramValue == this) {
/* 343 */         return 0;
/*     */       }
/* 345 */       if (this.lobId == valueLobDb.lobId && this.small == null && valueLobDb.small == null) {
/* 346 */         return 0;
/*     */       }
/*     */     } 
/* 349 */     if (this.type == 16) {
/* 350 */       return Integer.signum(getString().compareTo(paramValue.getString()));
/*     */     }
/* 352 */     byte[] arrayOfByte = paramValue.getBytesNoCopy();
/* 353 */     return Utils.compareNotNullSigned(getBytes(), arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 358 */     if (this.type == 16) {
/* 359 */       return getReader();
/*     */     }
/* 361 */     return getInputStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public Reader getReader() {
/* 366 */     return IOUtils.getBufferedReader(getInputStream());
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() {
/* 371 */     if (this.small != null)
/* 372 */       return new ByteArrayInputStream(this.small); 
/* 373 */     if (this.fileName != null) {
/* 374 */       FileStore fileStore = this.handler.openFile(this.fileName, "r", true);
/* 375 */       boolean bool = SysProperties.lobCloseBetweenReads;
/* 376 */       return new BufferedInputStream((InputStream)new FileStoreInputStream(fileStore, this.handler, false, bool), 4096);
/*     */     } 
/*     */     
/* 379 */     long l = (this.type == 15) ? this.precision : -1L;
/*     */     try {
/* 381 */       return this.handler.getLobStorage().getInputStream(this, this.hmac, l);
/* 382 */     } catch (IOException iOException) {
/* 383 */       throw DbException.convertIOException(iOException, toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 390 */     long l = getPrecision();
/* 391 */     if (l > 2147483647L || l <= 0L) {
/* 392 */       l = -1L;
/*     */     }
/* 394 */     if (this.type == 15) {
/* 395 */       paramPreparedStatement.setBinaryStream(paramInt, getInputStream(), (int)l);
/*     */     } else {
/* 397 */       paramPreparedStatement.setCharacterStream(paramInt, getReader(), (int)l);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 404 */     if (this.type == 16) {
/* 405 */       String str1 = getString();
/* 406 */       return StringUtils.quoteStringSQL(str1);
/*     */     } 
/* 408 */     byte[] arrayOfByte = getBytes();
/* 409 */     String str = StringUtils.convertBytesToHex(arrayOfByte);
/* 410 */     return "X'" + str + "'";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTraceSQL() {
/* 415 */     if (this.small != null && getPrecision() <= SysProperties.MAX_TRACE_DATA_LENGTH) {
/* 416 */       return getSQL();
/*     */     }
/* 418 */     StringBuilder stringBuilder = new StringBuilder();
/* 419 */     if (this.type == 16) {
/* 420 */       stringBuilder.append("SPACE(").append(getPrecision());
/*     */     } else {
/* 422 */       stringBuilder.append("CAST(REPEAT('00', ").append(getPrecision()).append(") AS BINARY");
/*     */     } 
/* 424 */     stringBuilder.append(" /* table: ").append(this.tableId).append(" id: ").append(this.lobId).append(" */)");
/*     */     
/* 426 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getSmall() {
/* 436 */     return this.small;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 441 */     return MathUtils.convertLongToInt(getPrecision());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 446 */     return (paramObject instanceof ValueLobDb && compareSecure((Value)paramObject, null) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 451 */     if (this.small != null) {
/* 452 */       return this.small.length + 104;
/*     */     }
/* 454 */     return 140;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueLobDb copyToTemp() {
/* 465 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueLobDb copyToResult() {
/* 476 */     if (this.handler == null) {
/* 477 */       return this;
/*     */     }
/* 479 */     LobStorageInterface lobStorageInterface = this.handler.getLobStorage();
/* 480 */     if (lobStorageInterface.isReadOnly()) {
/* 481 */       return this;
/*     */     }
/* 483 */     return lobStorageInterface.copyLob(this, -3, getPrecision());
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLobId() {
/* 488 */     return this.lobId;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 493 */     return "lob: " + this.fileName + " table: " + this.tableId + " id: " + this.lobId;
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
/*     */   public static ValueLobDb createTempClob(Reader paramReader, long paramLong, DataHandler paramDataHandler) {
/*     */     BufferedReader bufferedReader;
/* 507 */     if (paramReader instanceof BufferedReader) {
/* 508 */       bufferedReader = (BufferedReader)paramReader;
/*     */     } else {
/* 510 */       bufferedReader = new BufferedReader(paramReader, 4096);
/*     */     }  try {
/*     */       char[] arrayOfChar;
/* 513 */       boolean bool = (paramDataHandler.getLobCompressionAlgorithm(16) != null) ? true : false;
/* 514 */       long l = Long.MAX_VALUE;
/* 515 */       if (paramLong >= 0L && paramLong < l) {
/* 516 */         l = paramLong;
/*     */       }
/* 518 */       int i = getBufferSize(paramDataHandler, bool, l);
/*     */       
/* 520 */       if (i >= Integer.MAX_VALUE) {
/* 521 */         String str = IOUtils.readStringAndClose(bufferedReader, -1);
/* 522 */         arrayOfChar = str.toCharArray();
/* 523 */         i = arrayOfChar.length;
/*     */       } else {
/* 525 */         arrayOfChar = new char[i];
/* 526 */         bufferedReader.mark(i);
/* 527 */         i = IOUtils.readFully(bufferedReader, arrayOfChar, i);
/*     */       } 
/* 529 */       if (i <= paramDataHandler.getMaxLengthInplaceLob()) {
/* 530 */         byte[] arrayOfByte = (new String(arrayOfChar, 0, i)).getBytes(Constants.UTF8);
/* 531 */         return createSmallLob(16, arrayOfByte, i);
/*     */       } 
/* 533 */       bufferedReader.reset();
/* 534 */       return new ValueLobDb(paramDataHandler, bufferedReader, l);
/*     */     }
/* 536 */     catch (IOException iOException) {
/* 537 */       throw DbException.convertIOException(iOException, null);
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
/*     */   public static ValueLobDb createTempBlob(InputStream paramInputStream, long paramLong, DataHandler paramDataHandler) {
/*     */     try {
/*     */       byte[] arrayOfByte;
/* 552 */       long l = Long.MAX_VALUE;
/* 553 */       boolean bool = (paramDataHandler.getLobCompressionAlgorithm(15) != null) ? true : false;
/* 554 */       if (paramLong >= 0L && paramLong < l) {
/* 555 */         l = paramLong;
/*     */       }
/* 557 */       int i = getBufferSize(paramDataHandler, bool, l);
/*     */       
/* 559 */       if (i >= Integer.MAX_VALUE) {
/* 560 */         arrayOfByte = IOUtils.readBytesAndClose(paramInputStream, -1);
/* 561 */         i = arrayOfByte.length;
/*     */       } else {
/* 563 */         arrayOfByte = DataUtils.newBytes(i);
/* 564 */         i = IOUtils.readFully(paramInputStream, arrayOfByte, i);
/*     */       } 
/* 566 */       if (i <= paramDataHandler.getMaxLengthInplaceLob()) {
/* 567 */         byte[] arrayOfByte1 = DataUtils.newBytes(i);
/* 568 */         System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, i);
/* 569 */         return createSmallLob(15, arrayOfByte1, arrayOfByte1.length);
/*     */       } 
/* 571 */       return new ValueLobDb(paramDataHandler, arrayOfByte, i, paramInputStream, l);
/*     */     }
/* 573 */     catch (IOException iOException) {
/* 574 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getBufferSize(DataHandler paramDataHandler, boolean paramBoolean, long paramLong) {
/* 580 */     if (paramLong < 0L || paramLong > 2147483647L) {
/* 581 */       paramLong = 2147483647L;
/*     */     }
/* 583 */     int i = paramDataHandler.getMaxLengthInplaceLob();
/* 584 */     long l = paramBoolean ? 131072L : 4096L;
/*     */     
/* 586 */     if (l < paramLong && l <= i) {
/*     */ 
/*     */       
/* 589 */       l = Math.min(paramLong, i + 1L);
/*     */ 
/*     */       
/* 592 */       l = MathUtils.roundUpLong(l, 4096L);
/*     */     } 
/* 594 */     l = Math.min(paramLong, l);
/* 595 */     l = MathUtils.convertLongToInt(l);
/* 596 */     if (l < 0L) {
/* 597 */       l = 2147483647L;
/*     */     }
/* 599 */     return (int)l;
/*     */   }
/*     */   
/*     */   public Value convertPrecision(long paramLong, boolean paramBoolean) {
/*     */     ValueLobDb valueLobDb;
/* 604 */     if (this.precision <= paramLong) {
/* 605 */       return this;
/*     */     }
/*     */     
/* 608 */     if (this.type == 16) {
/* 609 */       if (this.handler == null) {
/*     */         try {
/* 611 */           int i = MathUtils.convertLongToInt(paramLong);
/* 612 */           String str = IOUtils.readStringAndClose(getReader(), i);
/* 613 */           byte[] arrayOfByte = str.getBytes(Constants.UTF8);
/* 614 */           valueLobDb = createSmallLob(this.type, arrayOfByte, str.length());
/* 615 */         } catch (IOException iOException) {
/* 616 */           throw DbException.convertIOException(iOException, null);
/*     */         } 
/*     */       } else {
/* 619 */         valueLobDb = createTempClob(getReader(), paramLong, this.handler);
/*     */       }
/*     */     
/* 622 */     } else if (this.handler == null) {
/*     */       try {
/* 624 */         int i = MathUtils.convertLongToInt(paramLong);
/* 625 */         byte[] arrayOfByte = IOUtils.readBytesAndClose(getInputStream(), i);
/* 626 */         valueLobDb = createSmallLob(this.type, arrayOfByte, arrayOfByte.length);
/* 627 */       } catch (IOException iOException) {
/* 628 */         throw DbException.convertIOException(iOException, null);
/*     */       } 
/*     */     } else {
/* 631 */       valueLobDb = createTempBlob(getInputStream(), paramLong, this.handler);
/*     */     } 
/*     */     
/* 634 */     return valueLobDb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Value createSmallLob(int paramInt, byte[] paramArrayOfbyte) {
/*     */     int i;
/* 646 */     if (paramInt == 16) {
/* 647 */       i = (new String(paramArrayOfbyte, Constants.UTF8)).length();
/*     */     } else {
/* 649 */       i = paramArrayOfbyte.length;
/*     */     } 
/* 651 */     return createSmallLob(paramInt, paramArrayOfbyte, i);
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
/*     */   public static ValueLobDb createSmallLob(int paramInt, byte[] paramArrayOfbyte, long paramLong) {
/* 664 */     return new ValueLobDb(paramInt, paramArrayOfbyte, paramLong);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueLobDb.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */