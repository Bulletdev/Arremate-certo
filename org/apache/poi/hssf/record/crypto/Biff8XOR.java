/*     */ package org.apache.poi.hssf.record.crypto;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Biff8XOR
/*     */   implements Biff8Cipher
/*     */ {
/*     */   private final Biff8XORKey _key;
/*  32 */   private ByteBuffer _buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
/*     */   private boolean _shouldSkipEncryptionOnCurrentRecord;
/*     */   private final int _initialOffset;
/*  35 */   private int _dataLength = 0;
/*  36 */   private int _xorArrayIndex = 0;
/*     */   
/*     */   public Biff8XOR(int paramInt, Biff8XORKey paramBiff8XORKey) {
/*  39 */     this._key = paramBiff8XORKey;
/*  40 */     this._initialOffset = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startRecord(int paramInt) {
/*  45 */     this._shouldSkipEncryptionOnCurrentRecord = isNeverEncryptedRecord(paramInt);
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
/*     */   public void setNextRecordSize(int paramInt) {
/*  59 */     this._xorArrayIndex = (this._initialOffset + this._dataLength + paramInt) % 16;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isNeverEncryptedRecord(int paramInt) {
/*  69 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 47:
/*     */       case 225:
/*     */       case 2057:
/*  85 */         return true;
/*     */     } 
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void skipTwoBytes() {
/*  95 */     this._dataLength += 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xor(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 105 */     if (this._shouldSkipEncryptionOnCurrentRecord) {
/* 106 */       this._dataLength += paramInt2;
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 114 */     byte[] arrayOfByte = this._key._secretKey.getEncoded();
/*     */     
/* 116 */     for (byte b = 0; b < paramInt2; b++) {
/* 117 */       byte b1 = paramArrayOfbyte[paramInt1 + b];
/* 118 */       b1 = rotateLeft(b1, 3);
/* 119 */       b1 = (byte)(b1 ^ arrayOfByte[this._xorArrayIndex]);
/* 120 */       paramArrayOfbyte[paramInt1 + b] = b1;
/* 121 */       this._xorArrayIndex = (this._xorArrayIndex + 1) % 16;
/* 122 */       this._dataLength++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static byte rotateLeft(byte paramByte, int paramInt) {
/* 127 */     return (byte)((paramByte & 0xFF) << paramInt | (paramByte & 0xFF) >>> 8 - paramInt);
/*     */   }
/*     */   
/*     */   public int xorByte(int paramInt) {
/* 131 */     this._buffer.put(0, (byte)paramInt);
/* 132 */     xor(this._buffer.array(), 0, 1);
/* 133 */     return this._buffer.get(0);
/*     */   }
/*     */   
/*     */   public int xorShort(int paramInt) {
/* 137 */     this._buffer.putShort(0, (short)paramInt);
/* 138 */     xor(this._buffer.array(), 0, 2);
/* 139 */     return this._buffer.getShort(0);
/*     */   }
/*     */   
/*     */   public int xorInt(int paramInt) {
/* 143 */     this._buffer.putInt(0, paramInt);
/* 144 */     xor(this._buffer.array(), 0, 4);
/* 145 */     return this._buffer.getInt(0);
/*     */   }
/*     */   
/*     */   public long xorLong(long paramLong) {
/* 149 */     this._buffer.putLong(0, paramLong);
/* 150 */     xor(this._buffer.array(), 0, 8);
/* 151 */     return this._buffer.getLong(0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\crypto\Biff8XOR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */