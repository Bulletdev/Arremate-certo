/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.hssf.record.crypto.Biff8DecryptingStream;
/*     */ import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RecordInputStream
/*     */   implements LittleEndianInput
/*     */ {
/*     */   public static final short MAX_RECORD_DATA_SIZE = 8224;
/*     */   private static final int INVALID_SID_VALUE = -1;
/*     */   private static final int DATA_LEN_NEEDS_TO_BE_READ = -1;
/*     */   private final BiffHeaderInput _bhi;
/*     */   private final LittleEndianInput _dataInput;
/*     */   private int _currentSid;
/*  47 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*     */   private int _currentDataLength;
/*     */   private int _nextSid;
/*     */   private int _currentDataOffset;
/*     */   
/*     */   public static final class LeftoverDataException
/*     */     extends RuntimeException
/*     */   {
/*     */     public LeftoverDataException(int param1Int1, int param1Int2) {
/*  56 */       super("Initialisation of record 0x" + Integer.toHexString(param1Int1).toUpperCase(Locale.ROOT) + "(" + getRecordName(param1Int1) + ") left " + param1Int2 + " bytes remaining still to be read.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static String getRecordName(int param1Int) {
/*  62 */       Class<? extends Record> clazz = RecordFactory.getRecordClass(param1Int);
/*  63 */       if (clazz == null) {
/*  64 */         return null;
/*     */       }
/*  66 */       return clazz.getSimpleName();
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
/*     */   private static final class SimpleHeaderInput
/*     */     implements BiffHeaderInput
/*     */   {
/*     */     private final LittleEndianInput _lei;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleHeaderInput(InputStream param1InputStream) {
/* 100 */       this._lei = RecordInputStream.getLEI(param1InputStream);
/*     */     }
/*     */     
/*     */     public int available() {
/* 104 */       return this._lei.available();
/*     */     }
/*     */     
/*     */     public int readDataSize() {
/* 108 */       return this._lei.readUShort();
/*     */     }
/*     */     
/*     */     public int readRecordSID() {
/* 112 */       return this._lei.readUShort();
/*     */     }
/*     */   }
/*     */   
/*     */   public RecordInputStream(InputStream paramInputStream) throws RecordFormatException {
/* 117 */     this(paramInputStream, null, 0);
/*     */   }
/*     */   
/*     */   public RecordInputStream(InputStream paramInputStream, Biff8EncryptionKey paramBiff8EncryptionKey, int paramInt) throws RecordFormatException {
/* 121 */     if (paramBiff8EncryptionKey == null) {
/* 122 */       this._dataInput = getLEI(paramInputStream);
/* 123 */       this._bhi = new SimpleHeaderInput(paramInputStream);
/*     */     } else {
/* 125 */       Biff8DecryptingStream biff8DecryptingStream = new Biff8DecryptingStream(paramInputStream, paramInt, paramBiff8EncryptionKey);
/* 126 */       this._bhi = (BiffHeaderInput)biff8DecryptingStream;
/* 127 */       this._dataInput = (LittleEndianInput)biff8DecryptingStream;
/*     */     } 
/* 129 */     this._nextSid = readNextSid();
/*     */   }
/*     */   
/*     */   static LittleEndianInput getLEI(InputStream paramInputStream) {
/* 133 */     if (paramInputStream instanceof LittleEndianInput)
/*     */     {
/* 135 */       return (LittleEndianInput)paramInputStream;
/*     */     }
/*     */     
/* 138 */     return (LittleEndianInput)new LittleEndianInputStream(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/* 147 */     return remaining();
/*     */   }
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 151 */     int i = Math.min(paramInt2, remaining());
/* 152 */     if (i == 0) {
/* 153 */       return 0;
/*     */     }
/* 155 */     readFully(paramArrayOfbyte, paramInt1, i);
/* 156 */     return i;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 160 */     return (short)this._currentSid;
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
/*     */   public boolean hasNextRecord() throws LeftoverDataException {
/* 173 */     if (this._currentDataLength != -1 && this._currentDataLength != this._currentDataOffset) {
/* 174 */       throw new LeftoverDataException(this._currentSid, remaining());
/*     */     }
/* 176 */     if (this._currentDataLength != -1) {
/* 177 */       this._nextSid = readNextSid();
/*     */     }
/* 179 */     return (this._nextSid != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readNextSid() {
/* 186 */     int i = this._bhi.available();
/* 187 */     if (i < 4) {
/* 188 */       if (i > 0);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       return -1;
/*     */     } 
/* 195 */     int j = this._bhi.readRecordSID();
/* 196 */     if (j == -1) {
/* 197 */       throw new RecordFormatException("Found invalid sid (" + j + ")");
/*     */     }
/* 199 */     this._currentDataLength = -1;
/* 200 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void nextRecord() throws RecordFormatException {
/* 208 */     if (this._nextSid == -1) {
/* 209 */       throw new IllegalStateException("EOF - next record not available");
/*     */     }
/* 211 */     if (this._currentDataLength != -1) {
/* 212 */       throw new IllegalStateException("Cannot call nextRecord() without checking hasNextRecord() first");
/*     */     }
/* 214 */     this._currentSid = this._nextSid;
/* 215 */     this._currentDataOffset = 0;
/* 216 */     this._currentDataLength = this._bhi.readDataSize();
/* 217 */     if (this._currentDataLength > 8224) {
/* 218 */       throw new RecordFormatException("The content of an excel record cannot exceed 8224 bytes");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkRecordPosition(int paramInt) {
/* 225 */     int i = remaining();
/* 226 */     if (i >= paramInt) {
/*     */       return;
/*     */     }
/*     */     
/* 230 */     if (i == 0 && isContinueNext()) {
/* 231 */       nextRecord();
/*     */       return;
/*     */     } 
/* 234 */     throw new RecordFormatException("Not enough data (" + i + ") to read requested (" + paramInt + ") bytes");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte readByte() {
/* 243 */     checkRecordPosition(1);
/* 244 */     this._currentDataOffset++;
/* 245 */     return this._dataInput.readByte();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short readShort() {
/* 253 */     checkRecordPosition(2);
/* 254 */     this._currentDataOffset += 2;
/* 255 */     return this._dataInput.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readInt() {
/* 263 */     checkRecordPosition(4);
/* 264 */     this._currentDataOffset += 4;
/* 265 */     return this._dataInput.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readLong() {
/* 273 */     checkRecordPosition(8);
/* 274 */     this._currentDataOffset += 8;
/* 275 */     return this._dataInput.readLong();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readUByte() {
/* 283 */     return readByte() & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readUShort() {
/* 291 */     checkRecordPosition(2);
/* 292 */     this._currentDataOffset += 2;
/* 293 */     return this._dataInput.readUShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public double readDouble() {
/* 298 */     long l = readLong();
/* 299 */     double d = Double.longBitsToDouble(l);
/* 300 */     if (Double.isNaN(d));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 306 */     return d;
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/* 310 */     readFully(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 315 */     int i = paramInt2;
/* 316 */     if (paramArrayOfbyte == null)
/* 317 */       throw new NullPointerException(); 
/* 318 */     if (paramInt1 < 0 || paramInt2 < 0 || paramInt2 > paramArrayOfbyte.length - paramInt1) {
/* 319 */       throw new IndexOutOfBoundsException();
/*     */     }
/*     */     
/* 322 */     while (paramInt2 > 0) {
/* 323 */       int j = Math.min(available(), paramInt2);
/* 324 */       if (j == 0) {
/* 325 */         if (!hasNextRecord()) {
/* 326 */           throw new RecordFormatException("Can't read the remaining " + paramInt2 + " bytes of the requested " + i + " bytes. No further record exists.");
/*     */         }
/* 328 */         nextRecord();
/* 329 */         j = Math.min(available(), paramInt2);
/* 330 */         assert j > 0;
/*     */       } 
/*     */       
/* 333 */       checkRecordPosition(j);
/* 334 */       this._dataInput.readFully(paramArrayOfbyte, paramInt1, j);
/* 335 */       this._currentDataOffset += j;
/* 336 */       paramInt1 += j;
/* 337 */       paramInt2 -= j;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String readString() {
/* 342 */     int i = readUShort();
/* 343 */     byte b = readByte();
/* 344 */     return readStringCommon(i, (b == 0));
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
/*     */   public String readUnicodeLEString(int paramInt) {
/* 359 */     return readStringCommon(paramInt, false);
/*     */   }
/*     */   
/*     */   public String readCompressedUnicode(int paramInt) {
/* 363 */     return readStringCommon(paramInt, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private String readStringCommon(int paramInt, boolean paramBoolean) {
/* 368 */     if (paramInt < 0 || paramInt > 1048576) {
/* 369 */       throw new IllegalArgumentException("Bad requested string length (" + paramInt + ")");
/*     */     }
/* 371 */     char[] arrayOfChar = new char[paramInt];
/* 372 */     boolean bool = paramBoolean;
/* 373 */     byte b = 0;
/*     */     while (true) {
/* 375 */       int i = bool ? remaining() : (remaining() / 2);
/* 376 */       if (paramInt - b <= i) {
/*     */         
/* 378 */         while (b < paramInt) {
/*     */           char c;
/* 380 */           if (bool) {
/* 381 */             c = (char)readUByte();
/*     */           } else {
/* 383 */             c = (char)readShort();
/*     */           } 
/* 385 */           arrayOfChar[b] = c;
/* 386 */           b++;
/*     */         } 
/* 388 */         return new String(arrayOfChar);
/*     */       } 
/*     */ 
/*     */       
/* 392 */       while (i > 0) {
/*     */         char c;
/* 394 */         if (bool) {
/* 395 */           c = (char)readUByte();
/*     */         } else {
/* 397 */           c = (char)readShort();
/*     */         } 
/* 399 */         arrayOfChar[b] = c;
/* 400 */         b++;
/* 401 */         i--;
/*     */       } 
/* 403 */       if (!isContinueNext()) {
/* 404 */         throw new RecordFormatException("Expected to find a ContinueRecord in order to read remaining " + (paramInt - b) + " of " + paramInt + " chars");
/*     */       }
/*     */       
/* 407 */       if (remaining() != 0) {
/* 408 */         throw new RecordFormatException("Odd number of bytes(" + remaining() + ") left behind");
/*     */       }
/* 410 */       nextRecord();
/*     */       
/* 412 */       byte b1 = readByte();
/* 413 */       assert b1 == 0 || b1 == 1;
/* 414 */       bool = (b1 == 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] readRemainder() {
/* 423 */     int i = remaining();
/* 424 */     if (i == 0) {
/* 425 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 427 */     byte[] arrayOfByte = new byte[i];
/* 428 */     readFully(arrayOfByte);
/* 429 */     return arrayOfByte;
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
/*     */   @Deprecated
/*     */   public byte[] readAllContinuedRemainder() {
/* 444 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16448);
/*     */     
/*     */     while (true) {
/* 447 */       byte[] arrayOfByte = readRemainder();
/* 448 */       byteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/* 449 */       if (!isContinueNext()) {
/*     */         break;
/*     */       }
/* 452 */       nextRecord();
/*     */     } 
/* 454 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int remaining() {
/* 462 */     if (this._currentDataLength == -1)
/*     */     {
/* 464 */       return 0;
/*     */     }
/* 466 */     return this._currentDataLength - this._currentDataOffset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isContinueNext() {
/* 474 */     if (this._currentDataLength != -1 && this._currentDataOffset != this._currentDataLength) {
/* 475 */       throw new IllegalStateException("Should never be called before end of current record");
/*     */     }
/* 477 */     if (!hasNextRecord()) {
/* 478 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 485 */     return (this._nextSid == 60);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNextSid() {
/* 492 */     return this._nextSid;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RecordInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */