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
/*     */ 
/*     */ 
/*     */ public final class LittleEndianByteArrayOutputStream
/*     */   implements DelayableLittleEndianOutput, LittleEndianOutput
/*     */ {
/*     */   private final byte[] _buf;
/*     */   private final int _endIndex;
/*     */   private int _writeIndex;
/*     */   
/*     */   public LittleEndianByteArrayOutputStream(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  33 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length) {
/*  34 */       throw new IllegalArgumentException("Specified startOffset (" + paramInt1 + ") is out of allowable range (0.." + paramArrayOfbyte.length + ")");
/*     */     }
/*     */     
/*  37 */     this._buf = paramArrayOfbyte;
/*  38 */     this._writeIndex = paramInt1;
/*  39 */     this._endIndex = paramInt1 + paramInt2;
/*  40 */     if (this._endIndex < paramInt1 || this._endIndex > paramArrayOfbyte.length) {
/*  41 */       throw new IllegalArgumentException("calculated end index (" + this._endIndex + ") is out of allowable range (" + this._writeIndex + ".." + paramArrayOfbyte.length + ")");
/*     */     }
/*     */   }
/*     */   
/*     */   public LittleEndianByteArrayOutputStream(byte[] paramArrayOfbyte, int paramInt) {
/*  46 */     this(paramArrayOfbyte, paramInt, paramArrayOfbyte.length - paramInt);
/*     */   }
/*     */   
/*     */   private void checkPosition(int paramInt) {
/*  50 */     if (paramInt > this._endIndex - this._writeIndex) {
/*  51 */       throw new RuntimeException("Buffer overrun");
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeByte(int paramInt) {
/*  56 */     checkPosition(1);
/*  57 */     this._buf[this._writeIndex++] = (byte)paramInt;
/*     */   }
/*     */   
/*     */   public void writeDouble(double paramDouble) {
/*  61 */     writeLong(Double.doubleToLongBits(paramDouble));
/*     */   }
/*     */   
/*     */   public void writeInt(int paramInt) {
/*  65 */     checkPosition(4);
/*  66 */     int i = this._writeIndex;
/*  67 */     this._buf[i++] = (byte)(paramInt >>> 0 & 0xFF);
/*  68 */     this._buf[i++] = (byte)(paramInt >>> 8 & 0xFF);
/*  69 */     this._buf[i++] = (byte)(paramInt >>> 16 & 0xFF);
/*  70 */     this._buf[i++] = (byte)(paramInt >>> 24 & 0xFF);
/*  71 */     this._writeIndex = i;
/*     */   }
/*     */   
/*     */   public void writeLong(long paramLong) {
/*  75 */     writeInt((int)(paramLong >> 0L));
/*  76 */     writeInt((int)(paramLong >> 32L));
/*     */   }
/*     */   
/*     */   public void writeShort(int paramInt) {
/*  80 */     checkPosition(2);
/*  81 */     int i = this._writeIndex;
/*  82 */     this._buf[i++] = (byte)(paramInt >>> 0 & 0xFF);
/*  83 */     this._buf[i++] = (byte)(paramInt >>> 8 & 0xFF);
/*  84 */     this._writeIndex = i;
/*     */   }
/*     */   public void write(byte[] paramArrayOfbyte) {
/*  87 */     int i = paramArrayOfbyte.length;
/*  88 */     checkPosition(i);
/*  89 */     System.arraycopy(paramArrayOfbyte, 0, this._buf, this._writeIndex, i);
/*  90 */     this._writeIndex += i;
/*     */   }
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  93 */     checkPosition(paramInt2);
/*  94 */     System.arraycopy(paramArrayOfbyte, paramInt1, this._buf, this._writeIndex, paramInt2);
/*  95 */     this._writeIndex += paramInt2;
/*     */   }
/*     */   public int getWriteIndex() {
/*  98 */     return this._writeIndex;
/*     */   }
/*     */   public LittleEndianOutput createDelayedOutput(int paramInt) {
/* 101 */     checkPosition(paramInt);
/* 102 */     LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(this._buf, this._writeIndex, paramInt);
/* 103 */     this._writeIndex += paramInt;
/* 104 */     return littleEndianByteArrayOutputStream;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LittleEndianByteArrayOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */