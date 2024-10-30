/*     */ package org.apache.poi.hssf.record.crypto;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.ShortBufferException;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Biff8RC4
/*     */   implements Biff8Cipher
/*     */ {
/*     */   private static final int RC4_REKEYING_INTERVAL = 1024;
/*     */   private Cipher _rc4;
/*     */   private int _streamPos;
/*     */   private int _nextRC4BlockStart;
/*     */   private int _currentKeyIndex;
/*     */   private boolean _shouldSkipEncryptionOnCurrentRecord;
/*     */   private final Biff8RC4Key _key;
/*  51 */   private ByteBuffer _buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
/*     */   
/*     */   public Biff8RC4(int paramInt, Biff8RC4Key paramBiff8RC4Key) {
/*  54 */     if (paramInt >= 1024) {
/*  55 */       throw new RuntimeException("initialOffset (" + paramInt + ")>" + 'Ѐ' + " not supported yet");
/*     */     }
/*     */     
/*  58 */     this._key = paramBiff8RC4Key;
/*  59 */     this._rc4 = this._key.getCipher();
/*  60 */     this._streamPos = 0;
/*  61 */     rekeyForNextBlock();
/*  62 */     this._streamPos = paramInt;
/*  63 */     this._shouldSkipEncryptionOnCurrentRecord = false;
/*     */     
/*  65 */     encryptBytes(new byte[paramInt], 0, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private void rekeyForNextBlock() {
/*  70 */     this._currentKeyIndex = this._streamPos / 1024;
/*  71 */     this._key.initCipherForBlock(this._rc4, this._currentKeyIndex);
/*  72 */     this._nextRC4BlockStart = (this._currentKeyIndex + 1) * 1024;
/*     */   }
/*     */   
/*     */   private void encryptBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  76 */     if (paramInt2 == 0)
/*     */       return; 
/*  78 */     if (this._shouldSkipEncryptionOnCurrentRecord) {
/*     */       
/*  80 */       byte[] arrayOfByte = new byte[paramInt2];
/*  81 */       System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
/*  82 */       paramArrayOfbyte = arrayOfByte;
/*  83 */       paramInt1 = 0;
/*     */     } 
/*     */     
/*     */     try {
/*  87 */       this._rc4.update(paramArrayOfbyte, paramInt1, paramInt2, paramArrayOfbyte, paramInt1);
/*  88 */     } catch (ShortBufferException shortBufferException) {
/*  89 */       throw new EncryptedDocumentException("input buffer too small", shortBufferException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void startRecord(int paramInt) {
/*  94 */     this._shouldSkipEncryptionOnCurrentRecord = isNeverEncryptedRecord(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isNeverEncryptedRecord(int paramInt) {
/* 103 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
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
/* 119 */         return true;
/*     */     } 
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void skipTwoBytes() {
/* 129 */     xor(this._buffer.array(), 0, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void xor(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 134 */     int i = this._nextRC4BlockStart - this._streamPos;
/* 135 */     if (paramInt2 <= i) {
/*     */       
/* 137 */       encryptBytes(paramArrayOfbyte, paramInt1, paramInt2);
/* 138 */       this._streamPos += paramInt2;
/*     */       
/*     */       return;
/*     */     } 
/* 142 */     int j = paramInt1;
/* 143 */     int k = paramInt2;
/*     */ 
/*     */     
/* 146 */     if (k > i) {
/* 147 */       if (i > 0) {
/* 148 */         encryptBytes(paramArrayOfbyte, j, i);
/* 149 */         this._streamPos += i;
/* 150 */         j += i;
/* 151 */         k -= i;
/*     */       } 
/* 153 */       rekeyForNextBlock();
/*     */     } 
/*     */     
/* 156 */     while (k > 1024) {
/* 157 */       encryptBytes(paramArrayOfbyte, j, 1024);
/* 158 */       this._streamPos += 1024;
/* 159 */       j += 1024;
/* 160 */       k -= 1024;
/* 161 */       rekeyForNextBlock();
/*     */     } 
/*     */     
/* 164 */     encryptBytes(paramArrayOfbyte, j, k);
/* 165 */     this._streamPos += k;
/*     */   }
/*     */   
/*     */   public int xorByte(int paramInt) {
/* 169 */     this._buffer.put(0, (byte)paramInt);
/* 170 */     xor(this._buffer.array(), 0, 1);
/* 171 */     return this._buffer.get(0);
/*     */   }
/*     */   
/*     */   public int xorShort(int paramInt) {
/* 175 */     this._buffer.putShort(0, (short)paramInt);
/* 176 */     xor(this._buffer.array(), 0, 2);
/* 177 */     return this._buffer.getShort(0);
/*     */   }
/*     */   
/*     */   public int xorInt(int paramInt) {
/* 181 */     this._buffer.putInt(0, paramInt);
/* 182 */     xor(this._buffer.array(), 0, 4);
/* 183 */     return this._buffer.getInt(0);
/*     */   }
/*     */   
/*     */   public long xorLong(long paramLong) {
/* 187 */     this._buffer.putLong(0, paramLong);
/* 188 */     xor(this._buffer.array(), 0, 8);
/* 189 */     return this._buffer.getLong(0);
/*     */   }
/*     */   
/*     */   public void setNextRecordSize(int paramInt) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\crypto\Biff8RC4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */