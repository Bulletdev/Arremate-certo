/*     */ package org.apache.poi.poifs.storage;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DataInputBlock
/*     */ {
/*     */   private final byte[] _buf;
/*     */   private int _readIndex;
/*     */   private int _maxIndex;
/*     */   
/*     */   DataInputBlock(byte[] paramArrayOfbyte, int paramInt) {
/*  51 */     this._buf = paramArrayOfbyte;
/*  52 */     this._readIndex = paramInt;
/*  53 */     this._maxIndex = this._buf.length;
/*     */   }
/*     */   public int available() {
/*  56 */     return this._maxIndex - this._readIndex;
/*     */   }
/*     */   
/*     */   public int readUByte() {
/*  60 */     return this._buf[this._readIndex++] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readUShortLE() {
/*  67 */     int i = this._readIndex;
/*     */     
/*  69 */     int j = this._buf[i++] & 0xFF;
/*  70 */     int k = this._buf[i++] & 0xFF;
/*  71 */     this._readIndex = i;
/*  72 */     return (k << 8) + (j << 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readUShortLE(DataInputBlock paramDataInputBlock) {
/*  80 */     int i = paramDataInputBlock._buf.length - 1;
/*     */     
/*  82 */     int j = paramDataInputBlock._buf[i] & 0xFF;
/*  83 */     int k = this._buf[this._readIndex++] & 0xFF;
/*  84 */     return (k << 8) + (j << 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readIntLE() {
/*  91 */     int i = this._readIndex;
/*     */     
/*  93 */     int j = this._buf[i++] & 0xFF;
/*  94 */     int k = this._buf[i++] & 0xFF;
/*  95 */     int m = this._buf[i++] & 0xFF;
/*  96 */     int n = this._buf[i++] & 0xFF;
/*  97 */     this._readIndex = i;
/*  98 */     return (n << 24) + (m << 16) + (k << 8) + (j << 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readIntLE(DataInputBlock paramDataInputBlock, int paramInt) {
/* 105 */     byte[] arrayOfByte = new byte[4];
/*     */     
/* 107 */     readSpanning(paramDataInputBlock, paramInt, arrayOfByte);
/* 108 */     int i = arrayOfByte[0] & 0xFF;
/* 109 */     int j = arrayOfByte[1] & 0xFF;
/* 110 */     int k = arrayOfByte[2] & 0xFF;
/* 111 */     int m = arrayOfByte[3] & 0xFF;
/* 112 */     return (m << 24) + (k << 16) + (j << 8) + (i << 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readLongLE() {
/* 119 */     int i = this._readIndex;
/*     */     
/* 121 */     int j = this._buf[i++] & 0xFF;
/* 122 */     int k = this._buf[i++] & 0xFF;
/* 123 */     int m = this._buf[i++] & 0xFF;
/* 124 */     int n = this._buf[i++] & 0xFF;
/* 125 */     int i1 = this._buf[i++] & 0xFF;
/* 126 */     int i2 = this._buf[i++] & 0xFF;
/* 127 */     int i3 = this._buf[i++] & 0xFF;
/* 128 */     int i4 = this._buf[i++] & 0xFF;
/* 129 */     this._readIndex = i;
/* 130 */     return (i4 << 56L) + (i3 << 48L) + (i2 << 40L) + (i1 << 32L) + (n << 24L) + (m << 16) + (k << 8) + (j << 0);
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
/*     */   public long readLongLE(DataInputBlock paramDataInputBlock, int paramInt) {
/* 144 */     byte[] arrayOfByte = new byte[8];
/*     */     
/* 146 */     readSpanning(paramDataInputBlock, paramInt, arrayOfByte);
/*     */     
/* 148 */     int i = arrayOfByte[0] & 0xFF;
/* 149 */     int j = arrayOfByte[1] & 0xFF;
/* 150 */     int k = arrayOfByte[2] & 0xFF;
/* 151 */     int m = arrayOfByte[3] & 0xFF;
/* 152 */     int n = arrayOfByte[4] & 0xFF;
/* 153 */     int i1 = arrayOfByte[5] & 0xFF;
/* 154 */     int i2 = arrayOfByte[6] & 0xFF;
/* 155 */     int i3 = arrayOfByte[7] & 0xFF;
/* 156 */     return (i3 << 56L) + (i2 << 48L) + (i1 << 40L) + (n << 32L) + (m << 24L) + (k << 16) + (j << 8) + (i << 0);
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
/*     */   private void readSpanning(DataInputBlock paramDataInputBlock, int paramInt, byte[] paramArrayOfbyte) {
/* 173 */     System.arraycopy(paramDataInputBlock._buf, paramDataInputBlock._readIndex, paramArrayOfbyte, 0, paramInt);
/* 174 */     int i = paramArrayOfbyte.length - paramInt;
/* 175 */     System.arraycopy(this._buf, 0, paramArrayOfbyte, paramInt, i);
/* 176 */     this._readIndex = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 183 */     System.arraycopy(this._buf, this._readIndex, paramArrayOfbyte, paramInt1, paramInt2);
/* 184 */     this._readIndex += paramInt2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\DataInputBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */