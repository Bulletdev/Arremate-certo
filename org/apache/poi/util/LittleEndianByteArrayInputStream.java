/*     */ package org.apache.poi.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LittleEndianByteArrayInputStream
/*     */   implements LittleEndianInput
/*     */ {
/*     */   private final byte[] _buf;
/*     */   private final int _endIndex;
/*     */   private int _readIndex;
/*     */   
/*     */   public LittleEndianByteArrayInputStream(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  31 */     this._buf = paramArrayOfbyte;
/*  32 */     this._readIndex = paramInt1;
/*  33 */     this._endIndex = paramInt1 + paramInt2;
/*     */   }
/*     */   public LittleEndianByteArrayInputStream(byte[] paramArrayOfbyte, int paramInt) {
/*  36 */     this(paramArrayOfbyte, paramInt, paramArrayOfbyte.length - paramInt);
/*     */   }
/*     */   public LittleEndianByteArrayInputStream(byte[] paramArrayOfbyte) {
/*  39 */     this(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public int available() {
/*  43 */     return this._endIndex - this._readIndex;
/*     */   }
/*     */   private void checkPosition(int paramInt) {
/*  46 */     if (paramInt > this._endIndex - this._readIndex) {
/*  47 */       throw new RuntimeException("Buffer overrun");
/*     */     }
/*     */   }
/*     */   
/*     */   public int getReadIndex() {
/*  52 */     return this._readIndex;
/*     */   }
/*     */   public byte readByte() {
/*  55 */     checkPosition(1);
/*  56 */     return this._buf[this._readIndex++];
/*     */   }
/*     */   
/*     */   public int readInt() {
/*  60 */     checkPosition(4);
/*  61 */     int i = this._readIndex;
/*     */     
/*  63 */     int j = this._buf[i++] & 0xFF;
/*  64 */     int k = this._buf[i++] & 0xFF;
/*  65 */     int m = this._buf[i++] & 0xFF;
/*  66 */     int n = this._buf[i++] & 0xFF;
/*  67 */     this._readIndex = i;
/*  68 */     return (n << 24) + (m << 16) + (k << 8) + (j << 0);
/*     */   }
/*     */   public long readLong() {
/*  71 */     checkPosition(8);
/*  72 */     int i = this._readIndex;
/*     */     
/*  74 */     int j = this._buf[i++] & 0xFF;
/*  75 */     int k = this._buf[i++] & 0xFF;
/*  76 */     int m = this._buf[i++] & 0xFF;
/*  77 */     int n = this._buf[i++] & 0xFF;
/*  78 */     int i1 = this._buf[i++] & 0xFF;
/*  79 */     int i2 = this._buf[i++] & 0xFF;
/*  80 */     int i3 = this._buf[i++] & 0xFF;
/*  81 */     int i4 = this._buf[i++] & 0xFF;
/*  82 */     this._readIndex = i;
/*  83 */     return (i4 << 56L) + (i3 << 48L) + (i2 << 40L) + (i1 << 32L) + (n << 24L) + (m << 16) + (k << 8) + (j << 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short readShort() {
/*  93 */     return (short)readUShort();
/*     */   }
/*     */   public int readUByte() {
/*  96 */     checkPosition(1);
/*  97 */     return this._buf[this._readIndex++] & 0xFF;
/*     */   }
/*     */   public int readUShort() {
/* 100 */     checkPosition(2);
/* 101 */     int i = this._readIndex;
/*     */     
/* 103 */     int j = this._buf[i++] & 0xFF;
/* 104 */     int k = this._buf[i++] & 0xFF;
/* 105 */     this._readIndex = i;
/* 106 */     return (k << 8) + (j << 0);
/*     */   }
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 109 */     checkPosition(paramInt2);
/* 110 */     System.arraycopy(this._buf, this._readIndex, paramArrayOfbyte, paramInt1, paramInt2);
/* 111 */     this._readIndex += paramInt2;
/*     */   }
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/* 114 */     readFully(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   public double readDouble() {
/* 117 */     return Double.longBitsToDouble(readLong());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LittleEndianByteArrayInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */