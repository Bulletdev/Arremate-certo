/*     */ package org.h2.value;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
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
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.SmallLRUCache;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueLob
/*     */   extends Value
/*     */ {
/*     */   private static int dirCounter;
/*     */   private final int type;
/*     */   private long precision;
/*     */   private DataHandler handler;
/*     */   private int tableId;
/*     */   private int objectId;
/*     */   private String fileName;
/*     */   private boolean linked;
/*     */   private byte[] small;
/*     */   private int hash;
/*     */   private boolean compressed;
/*     */   private FileStore tempFile;
/*     */   
/*     */   private ValueLob(int paramInt1, DataHandler paramDataHandler, String paramString, int paramInt2, int paramInt3, boolean paramBoolean1, long paramLong, boolean paramBoolean2) {
/*  69 */     this.type = paramInt1;
/*  70 */     this.handler = paramDataHandler;
/*  71 */     this.fileName = paramString;
/*  72 */     this.tableId = paramInt2;
/*  73 */     this.objectId = paramInt3;
/*  74 */     this.linked = paramBoolean1;
/*  75 */     this.precision = paramLong;
/*  76 */     this.compressed = paramBoolean2;
/*     */   }
/*     */   
/*     */   private ValueLob(int paramInt, byte[] paramArrayOfbyte) {
/*  80 */     this.type = paramInt;
/*  81 */     this.small = paramArrayOfbyte;
/*  82 */     if (paramArrayOfbyte != null) {
/*  83 */       if (paramInt == 15) {
/*  84 */         this.precision = paramArrayOfbyte.length;
/*     */       } else {
/*  86 */         this.precision = getString().length();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static ValueLob copy(ValueLob paramValueLob) {
/*  92 */     ValueLob valueLob = new ValueLob(paramValueLob.type, paramValueLob.handler, paramValueLob.fileName, paramValueLob.tableId, paramValueLob.objectId, paramValueLob.linked, paramValueLob.precision, paramValueLob.compressed);
/*     */     
/*  94 */     valueLob.small = paramValueLob.small;
/*  95 */     valueLob.hash = paramValueLob.hash;
/*  96 */     return valueLob;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ValueLob createSmallLob(int paramInt, byte[] paramArrayOfbyte) {
/* 107 */     return new ValueLob(paramInt, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getFileName(DataHandler paramDataHandler, int paramInt1, int paramInt2) {
/* 112 */     if (SysProperties.CHECK && paramInt1 == 0 && paramInt2 == 0) {
/* 113 */       DbException.throwInternalError("0 LOB");
/*     */     }
/* 115 */     String str = (paramInt1 < 0) ? ".temp" : (".t" + paramInt1);
/* 116 */     return getFileNamePrefix(paramDataHandler.getDatabasePath(), paramInt2) + str + ".lob.db";
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
/*     */   public static ValueLob openLinked(int paramInt1, DataHandler paramDataHandler, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean) {
/* 133 */     String str = getFileName(paramDataHandler, paramInt2, paramInt3);
/* 134 */     return new ValueLob(paramInt1, paramDataHandler, str, paramInt2, paramInt3, true, paramLong, paramBoolean);
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
/*     */   public static ValueLob openUnlinked(int paramInt1, DataHandler paramDataHandler, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean, String paramString) {
/* 153 */     return new ValueLob(paramInt1, paramDataHandler, paramString, paramInt2, paramInt3, false, paramLong, paramBoolean);
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
/*     */   private static ValueLob createClob(Reader paramReader, long paramLong, DataHandler paramDataHandler) {
/*     */     try {
/*     */       char[] arrayOfChar;
/* 168 */       if (paramDataHandler == null) {
/* 169 */         String str = IOUtils.readStringAndClose(paramReader, (int)paramLong);
/* 170 */         return createSmallLob(16, str.getBytes(Constants.UTF8));
/*     */       } 
/* 172 */       boolean bool = (paramDataHandler.getLobCompressionAlgorithm(16) != null) ? true : false;
/* 173 */       long l = Long.MAX_VALUE;
/* 174 */       if (paramLong >= 0L && paramLong < l) {
/* 175 */         l = paramLong;
/*     */       }
/* 177 */       int i = getBufferSize(paramDataHandler, bool, l);
/*     */       
/* 179 */       if (i >= Integer.MAX_VALUE) {
/* 180 */         String str = IOUtils.readStringAndClose(paramReader, -1);
/* 181 */         arrayOfChar = str.toCharArray();
/* 182 */         i = arrayOfChar.length;
/*     */       } else {
/* 184 */         arrayOfChar = new char[i];
/* 185 */         i = IOUtils.readFully(paramReader, arrayOfChar, i);
/*     */       } 
/* 187 */       if (i <= paramDataHandler.getMaxLengthInplaceLob()) {
/* 188 */         byte[] arrayOfByte = (new String(arrayOfChar, 0, i)).getBytes(Constants.UTF8);
/* 189 */         return createSmallLob(16, arrayOfByte);
/*     */       } 
/* 191 */       ValueLob valueLob = new ValueLob(16, null);
/* 192 */       valueLob.createFromReader(arrayOfChar, i, paramReader, l, paramDataHandler);
/* 193 */       return valueLob;
/* 194 */     } catch (IOException iOException) {
/* 195 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getBufferSize(DataHandler paramDataHandler, boolean paramBoolean, long paramLong) {
/* 201 */     if (paramLong < 0L || paramLong > 2147483647L) {
/* 202 */       paramLong = 2147483647L;
/*     */     }
/* 204 */     int i = paramDataHandler.getMaxLengthInplaceLob();
/* 205 */     long l = paramBoolean ? 131072L : 4096L;
/*     */     
/* 207 */     if (l < paramLong && l <= i) {
/*     */       
/* 209 */       l = Math.min(paramLong, i + 1L);
/*     */ 
/*     */       
/* 212 */       l = MathUtils.roundUpLong(l, 4096L);
/*     */     } 
/* 214 */     l = Math.min(paramLong, l);
/* 215 */     l = MathUtils.convertLongToInt(l);
/* 216 */     if (l < 0L) {
/* 217 */       l = 2147483647L;
/*     */     }
/* 219 */     return (int)l;
/*     */   }
/*     */ 
/*     */   
/*     */   private void createFromReader(char[] paramArrayOfchar, int paramInt, Reader paramReader, long paramLong, DataHandler paramDataHandler) throws IOException {
/* 224 */     try (FileStoreOutputStream null = initLarge(paramDataHandler)) {
/* 225 */       boolean bool = (paramDataHandler.getLobCompressionAlgorithm(16) != null) ? true : false;
/*     */       do {
/* 227 */         this.precision += paramInt;
/* 228 */         byte[] arrayOfByte = (new String(paramArrayOfchar, 0, paramInt)).getBytes(Constants.UTF8);
/* 229 */         fileStoreOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/* 230 */         paramLong -= paramInt;
/* 231 */         if (paramLong <= 0L) {
/*     */           break;
/*     */         }
/* 234 */         paramInt = getBufferSize(paramDataHandler, bool, paramLong);
/* 235 */         paramInt = IOUtils.readFully(paramReader, paramArrayOfchar, paramInt);
/* 236 */       } while (paramInt != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getFileNamePrefix(String paramString, int paramInt) {
/* 245 */     int i = paramInt % SysProperties.LOB_FILES_PER_DIRECTORY;
/* 246 */     if (i > 0) {
/* 247 */       str = SysProperties.FILE_SEPARATOR + paramInt;
/*     */     } else {
/* 249 */       str = "";
/*     */     } 
/* 251 */     paramInt /= SysProperties.LOB_FILES_PER_DIRECTORY;
/* 252 */     while (paramInt > 0) {
/* 253 */       i = paramInt % SysProperties.LOB_FILES_PER_DIRECTORY;
/* 254 */       str = SysProperties.FILE_SEPARATOR + i + ".lobs.db" + str;
/*     */       
/* 256 */       paramInt /= SysProperties.LOB_FILES_PER_DIRECTORY;
/*     */     } 
/* 258 */     String str = FileUtils.toRealPath(paramString + ".lobs.db" + str);
/*     */     
/* 260 */     return str;
/*     */   }
/*     */   
/*     */   private static int getNewObjectId(DataHandler paramDataHandler) {
/* 264 */     String str = paramDataHandler.getDatabasePath();
/* 265 */     if (str != null && str.length() == 0) {
/* 266 */       str = (new File(Utils.getProperty("java.io.tmpdir", "."), SysProperties.PREFIX_TEMP_FILE)).getAbsolutePath();
/*     */     }
/*     */     
/* 269 */     int i = 0;
/* 270 */     int j = SysProperties.LOB_FILES_PER_DIRECTORY;
/*     */     while (true) {
/* 272 */       String str1 = getFileNamePrefix(str, i);
/* 273 */       String[] arrayOfString = getFileList(paramDataHandler, str1);
/* 274 */       byte b = 0;
/* 275 */       boolean[] arrayOfBoolean = new boolean[j];
/* 276 */       for (String str2 : arrayOfString) {
/* 277 */         if (str2.endsWith(".db")) {
/* 278 */           byte b2; str2 = FileUtils.getName(str2);
/* 279 */           String str3 = str2.substring(0, str2.indexOf('.'));
/*     */           
/*     */           try {
/* 282 */             b2 = Integer.parseInt(str3);
/* 283 */           } catch (NumberFormatException numberFormatException) {
/* 284 */             b2 = -1;
/*     */           } 
/* 286 */           if (b2 > 0) {
/* 287 */             b++;
/* 288 */             arrayOfBoolean[b2 % j] = true;
/*     */           } 
/*     */         } 
/*     */       } 
/* 292 */       byte b1 = -1;
/* 293 */       if (b < j) {
/* 294 */         for (byte b2 = 1; b2 < j; b2++) {
/* 295 */           if (!arrayOfBoolean[b2]) {
/* 296 */             b1 = b2;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 301 */       if (b1 > 0) {
/* 302 */         i += b1;
/* 303 */         invalidateFileList(paramDataHandler, str1);
/*     */         break;
/*     */       } 
/* 306 */       if (i > Integer.MAX_VALUE / j) {
/*     */         
/* 308 */         i = 0;
/* 309 */         dirCounter = MathUtils.randomInt(j - 1) * j;
/*     */ 
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */ 
/*     */       
/* 317 */       int k = dirCounter++ / (j - 1) + 1;
/* 318 */       i *= j;
/* 319 */       i += k * j;
/*     */     } 
/*     */     
/* 322 */     return i;
/*     */   }
/*     */   
/*     */   private static void invalidateFileList(DataHandler paramDataHandler, String paramString) {
/* 326 */     SmallLRUCache smallLRUCache = paramDataHandler.getLobFileListCache();
/* 327 */     if (smallLRUCache != null)
/* 328 */       synchronized (smallLRUCache) {
/* 329 */         smallLRUCache.remove(paramString);
/*     */       }  
/*     */   }
/*     */   
/*     */   private static String[] getFileList(DataHandler paramDataHandler, String paramString) {
/*     */     String[] arrayOfString;
/* 335 */     SmallLRUCache smallLRUCache = paramDataHandler.getLobFileListCache();
/*     */     
/* 337 */     if (smallLRUCache == null) {
/* 338 */       arrayOfString = (String[])FileUtils.newDirectoryStream(paramString).toArray((Object[])new String[0]);
/*     */     } else {
/* 340 */       synchronized (smallLRUCache) {
/* 341 */         arrayOfString = (String[])smallLRUCache.get(paramString);
/* 342 */         if (arrayOfString == null) {
/* 343 */           arrayOfString = (String[])FileUtils.newDirectoryStream(paramString).toArray((Object[])new String[0]);
/* 344 */           smallLRUCache.put(paramString, arrayOfString);
/*     */         } 
/*     */       } 
/*     */     } 
/* 348 */     return arrayOfString;
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
/*     */   private static ValueLob createBlob(InputStream paramInputStream, long paramLong, DataHandler paramDataHandler) {
/*     */     try {
/*     */       byte[] arrayOfByte;
/* 362 */       if (paramDataHandler == null) {
/* 363 */         byte[] arrayOfByte1 = IOUtils.readBytesAndClose(paramInputStream, (int)paramLong);
/* 364 */         return createSmallLob(15, arrayOfByte1);
/*     */       } 
/* 366 */       long l = Long.MAX_VALUE;
/* 367 */       boolean bool = (paramDataHandler.getLobCompressionAlgorithm(15) != null) ? true : false;
/* 368 */       if (paramLong >= 0L && paramLong < l) {
/* 369 */         l = paramLong;
/*     */       }
/* 371 */       int i = getBufferSize(paramDataHandler, bool, l);
/*     */       
/* 373 */       if (i >= Integer.MAX_VALUE) {
/* 374 */         arrayOfByte = IOUtils.readBytesAndClose(paramInputStream, -1);
/* 375 */         i = arrayOfByte.length;
/*     */       } else {
/* 377 */         arrayOfByte = DataUtils.newBytes(i);
/* 378 */         i = IOUtils.readFully(paramInputStream, arrayOfByte, i);
/*     */       } 
/* 380 */       if (i <= paramDataHandler.getMaxLengthInplaceLob()) {
/* 381 */         byte[] arrayOfByte1 = DataUtils.newBytes(i);
/* 382 */         System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, i);
/* 383 */         return createSmallLob(15, arrayOfByte1);
/*     */       } 
/* 385 */       ValueLob valueLob = new ValueLob(15, null);
/* 386 */       valueLob.createFromStream(arrayOfByte, i, paramInputStream, l, paramDataHandler);
/* 387 */       return valueLob;
/* 388 */     } catch (IOException iOException) {
/* 389 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private FileStoreOutputStream initLarge(DataHandler paramDataHandler) {
/* 394 */     this.handler = paramDataHandler;
/* 395 */     this.tableId = 0;
/* 396 */     this.linked = false;
/* 397 */     this.precision = 0L;
/* 398 */     this.small = null;
/* 399 */     this.hash = 0;
/* 400 */     String str = paramDataHandler.getLobCompressionAlgorithm(this.type);
/* 401 */     this.compressed = (str != null);
/* 402 */     synchronized (paramDataHandler) {
/* 403 */       String str1 = paramDataHandler.getDatabasePath();
/* 404 */       if (str1 != null && str1.length() == 0) {
/* 405 */         str1 = (new File(Utils.getProperty("java.io.tmpdir", "."), SysProperties.PREFIX_TEMP_FILE)).getAbsolutePath();
/*     */       }
/*     */       
/* 408 */       this.objectId = getNewObjectId(paramDataHandler);
/* 409 */       this.fileName = getFileNamePrefix(str1, this.objectId) + ".temp.db";
/* 410 */       this.tempFile = paramDataHandler.openFile(this.fileName, "rw", false);
/* 411 */       this.tempFile.autoDelete();
/*     */     } 
/* 413 */     return new FileStoreOutputStream(this.tempFile, paramDataHandler, str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createFromStream(byte[] paramArrayOfbyte, int paramInt, InputStream paramInputStream, long paramLong, DataHandler paramDataHandler) throws IOException {
/* 420 */     try (FileStoreOutputStream null = initLarge(paramDataHandler)) {
/* 421 */       boolean bool = (paramDataHandler.getLobCompressionAlgorithm(15) != null) ? true : false;
/*     */       do {
/* 423 */         this.precision += paramInt;
/* 424 */         fileStoreOutputStream.write(paramArrayOfbyte, 0, paramInt);
/* 425 */         paramLong -= paramInt;
/* 426 */         if (paramLong <= 0L) {
/*     */           break;
/*     */         }
/* 429 */         paramInt = getBufferSize(paramDataHandler, bool, paramLong);
/* 430 */         paramInt = IOUtils.readFully(paramInputStream, paramArrayOfbyte, paramInt);
/* 431 */       } while (paramInt > 0);
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
/*     */   public Value convertTo(int paramInt) {
/* 447 */     if (paramInt == this.type)
/* 448 */       return this; 
/* 449 */     if (paramInt == 16) {
/* 450 */       return createClob(getReader(), -1L, this.handler);
/*     */     }
/* 452 */     if (paramInt == 15) {
/* 453 */       return createBlob(getInputStream(), -1L, this.handler);
/*     */     }
/*     */     
/* 456 */     return super.convertTo(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLinkedToTable() {
/* 461 */     return this.linked;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/* 470 */     return this.fileName;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 475 */     if (this.fileName != null) {
/* 476 */       if (this.tempFile != null) {
/* 477 */         this.tempFile.stopAutoDelete();
/* 478 */         this.tempFile = null;
/*     */       } 
/* 480 */       deleteFile(this.handler, this.fileName);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Value copy(DataHandler paramDataHandler, int paramInt) {
/* 486 */     if (this.fileName == null) {
/* 487 */       this.tableId = paramInt;
/* 488 */       return this;
/*     */     } 
/* 490 */     if (this.linked) {
/* 491 */       ValueLob valueLob = copy(this);
/* 492 */       valueLob.objectId = getNewObjectId(paramDataHandler);
/* 493 */       valueLob.tableId = paramInt;
/* 494 */       String str = getFileName(paramDataHandler, valueLob.tableId, valueLob.objectId);
/* 495 */       copyFileTo(paramDataHandler, this.fileName, str);
/* 496 */       valueLob.fileName = str;
/* 497 */       valueLob.linked = true;
/* 498 */       return valueLob;
/*     */     } 
/* 500 */     if (!this.linked) {
/* 501 */       this.tableId = paramInt;
/* 502 */       String str = getFileName(paramDataHandler, this.tableId, this.objectId);
/* 503 */       if (this.tempFile != null) {
/* 504 */         this.tempFile.stopAutoDelete();
/* 505 */         this.tempFile = null;
/*     */       } 
/* 507 */       renameFile(paramDataHandler, this.fileName, str);
/* 508 */       this.fileName = str;
/* 509 */       this.linked = true;
/*     */     } 
/* 511 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTableId() {
/* 521 */     return this.tableId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getObjectId() {
/* 530 */     return this.objectId;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 535 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 540 */     return this.precision;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 545 */     int i = (this.precision > 2147483647L || this.precision == 0L) ? Integer.MAX_VALUE : (int)this.precision;
/*     */     try {
/*     */       byte[] arrayOfByte;
/* 548 */       if (this.type == 16) {
/* 549 */         if (this.small != null) {
/* 550 */           return new String(this.small, Constants.UTF8);
/*     */         }
/* 552 */         return IOUtils.readStringAndClose(getReader(), i);
/*     */       } 
/*     */       
/* 555 */       if (this.small != null) {
/* 556 */         arrayOfByte = this.small;
/*     */       } else {
/* 558 */         arrayOfByte = IOUtils.readBytesAndClose(getInputStream(), i);
/*     */       } 
/* 560 */       return StringUtils.convertBytesToHex(arrayOfByte);
/* 561 */     } catch (IOException iOException) {
/* 562 */       throw DbException.convertIOException(iOException, this.fileName);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 568 */     if (this.type == 16)
/*     */     {
/* 570 */       return super.getBytes();
/*     */     }
/* 572 */     byte[] arrayOfByte = getBytesNoCopy();
/* 573 */     return Utils.cloneByteArray(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytesNoCopy() {
/* 578 */     if (this.type == 16)
/*     */     {
/* 580 */       return super.getBytesNoCopy();
/*     */     }
/* 582 */     if (this.small != null) {
/* 583 */       return this.small;
/*     */     }
/*     */     try {
/* 586 */       return IOUtils.readBytesAndClose(getInputStream(), 2147483647);
/*     */     }
/* 588 */     catch (IOException iOException) {
/* 589 */       throw DbException.convertIOException(iOException, this.fileName);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 595 */     if (this.hash == 0) {
/* 596 */       if (this.precision > 4096L)
/*     */       {
/*     */         
/* 599 */         return (int)(this.precision ^ this.precision >>> 32L);
/*     */       }
/* 601 */       if (this.type == 16) {
/* 602 */         this.hash = getString().hashCode();
/*     */       } else {
/* 604 */         this.hash = Utils.getByteArrayHash(getBytes());
/*     */       } 
/*     */     } 
/* 607 */     return this.hash;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 612 */     if (this.type == 16) {
/* 613 */       return Integer.signum(getString().compareTo(paramValue.getString()));
/*     */     }
/* 615 */     byte[] arrayOfByte = paramValue.getBytesNoCopy();
/* 616 */     return Utils.compareNotNullSigned(getBytes(), arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 621 */     if (this.type == 16) {
/* 622 */       return getReader();
/*     */     }
/* 624 */     return getInputStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public Reader getReader() {
/* 629 */     return IOUtils.getBufferedReader(getInputStream());
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() {
/* 634 */     if (this.fileName == null) {
/* 635 */       return new ByteArrayInputStream(this.small);
/*     */     }
/* 637 */     FileStore fileStore = this.handler.openFile(this.fileName, "r", true);
/* 638 */     boolean bool = SysProperties.lobCloseBetweenReads;
/* 639 */     return new BufferedInputStream((InputStream)new FileStoreInputStream(fileStore, this.handler, this.compressed, bool), 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 647 */     long l = getPrecision();
/* 648 */     if (l > 2147483647L || l <= 0L) {
/* 649 */       l = -1L;
/*     */     }
/* 651 */     if (this.type == 15) {
/* 652 */       paramPreparedStatement.setBinaryStream(paramInt, getInputStream(), (int)l);
/*     */     } else {
/* 654 */       paramPreparedStatement.setCharacterStream(paramInt, getReader(), (int)l);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 661 */     if (this.type == 16) {
/* 662 */       String str1 = getString();
/* 663 */       return StringUtils.quoteStringSQL(str1);
/*     */     } 
/* 665 */     byte[] arrayOfByte = getBytes();
/* 666 */     String str = StringUtils.convertBytesToHex(arrayOfByte);
/* 667 */     return "X'" + str + "'";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTraceSQL() {
/* 672 */     if (this.small != null && getPrecision() <= SysProperties.MAX_TRACE_DATA_LENGTH) {
/* 673 */       return getSQL();
/*     */     }
/* 675 */     StringBuilder stringBuilder = new StringBuilder();
/* 676 */     if (this.type == 16) {
/* 677 */       stringBuilder.append("SPACE(").append(getPrecision());
/*     */     } else {
/* 679 */       stringBuilder.append("CAST(REPEAT('00', ").append(getPrecision()).append(") AS BINARY");
/*     */     } 
/* 681 */     stringBuilder.append(" /* ").append(this.fileName).append(" */)");
/* 682 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getSmall() {
/* 692 */     return this.small;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 697 */     return MathUtils.convertLongToInt(getPrecision());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 702 */     return (paramObject instanceof ValueLob && compareSecure((Value)paramObject, null) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void convertToFileIfRequired(DataHandler paramDataHandler) {
/*     */     try {
/* 713 */       if (this.small != null && this.small.length > paramDataHandler.getMaxLengthInplaceLob()) {
/* 714 */         boolean bool = (paramDataHandler.getLobCompressionAlgorithm(this.type) != null) ? true : false;
/* 715 */         int i = getBufferSize(paramDataHandler, bool, Long.MAX_VALUE);
/* 716 */         int j = this.tableId;
/* 717 */         if (this.type == 15) {
/* 718 */           createFromStream(DataUtils.newBytes(i), 0, getInputStream(), Long.MAX_VALUE, paramDataHandler);
/*     */         } else {
/*     */           
/* 721 */           createFromReader(new char[i], 0, getReader(), Long.MAX_VALUE, paramDataHandler);
/*     */         } 
/*     */         
/* 724 */         Value value = copy(paramDataHandler, j);
/* 725 */         if (SysProperties.CHECK && value != this) {
/* 726 */           DbException.throwInternalError();
/*     */         }
/*     */       } 
/* 729 */     } catch (IOException iOException) {
/* 730 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCompressed() {
/* 740 */     return this.compressed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static synchronized void deleteFile(DataHandler paramDataHandler, String paramString) {
/* 747 */     synchronized (paramDataHandler.getLobSyncObject()) {
/* 748 */       FileUtils.delete(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static synchronized void renameFile(DataHandler paramDataHandler, String paramString1, String paramString2) {
/* 754 */     synchronized (paramDataHandler.getLobSyncObject()) {
/* 755 */       FileUtils.move(paramString1, paramString2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void copyFileTo(DataHandler paramDataHandler, String paramString1, String paramString2) {
/* 761 */     synchronized (paramDataHandler.getLobSyncObject()) {
/*     */       try {
/* 763 */         IOUtils.copyFiles(paramString1, paramString2);
/* 764 */       } catch (IOException iOException) {
/* 765 */         throw DbException.convertIOException(iOException, null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 772 */     if (this.small != null) {
/* 773 */       return this.small.length + 104;
/*     */     }
/* 775 */     return 140;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueLob copyToTemp() {
/*     */     ValueLob valueLob;
/* 787 */     if (this.type == 16) {
/* 788 */       valueLob = createClob(getReader(), this.precision, this.handler);
/*     */     } else {
/* 790 */       valueLob = createBlob(getInputStream(), this.precision, this.handler);
/*     */     } 
/* 792 */     return valueLob;
/*     */   }
/*     */   
/*     */   public Value convertPrecision(long paramLong, boolean paramBoolean) {
/*     */     ValueLob valueLob;
/* 797 */     if (this.precision <= paramLong) {
/* 798 */       return this;
/*     */     }
/*     */     
/* 801 */     if (this.type == 16) {
/* 802 */       valueLob = createClob(getReader(), paramLong, this.handler);
/*     */     } else {
/* 804 */       valueLob = createBlob(getInputStream(), paramLong, this.handler);
/*     */     } 
/* 806 */     return valueLob;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueLob.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */