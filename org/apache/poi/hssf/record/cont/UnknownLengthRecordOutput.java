/*     */ package org.apache.poi.hssf.record.cont;
/*     */ 
/*     */ import org.apache.poi.util.DelayableLittleEndianOutput;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class UnknownLengthRecordOutput
/*     */   implements LittleEndianOutput
/*     */ {
/*     */   private static final int MAX_DATA_SIZE = 8224;
/*     */   private final LittleEndianOutput _originalOut;
/*     */   private final LittleEndianOutput _dataSizeOutput;
/*     */   private final byte[] _byteBuffer;
/*     */   private LittleEndianOutput _out;
/*     */   private int _size;
/*     */   
/*     */   public UnknownLengthRecordOutput(LittleEndianOutput paramLittleEndianOutput, int paramInt) {
/*  40 */     this._originalOut = paramLittleEndianOutput;
/*  41 */     paramLittleEndianOutput.writeShort(paramInt);
/*  42 */     if (paramLittleEndianOutput instanceof DelayableLittleEndianOutput) {
/*     */       
/*  44 */       DelayableLittleEndianOutput delayableLittleEndianOutput = (DelayableLittleEndianOutput)paramLittleEndianOutput;
/*  45 */       this._dataSizeOutput = delayableLittleEndianOutput.createDelayedOutput(2);
/*  46 */       this._byteBuffer = null;
/*  47 */       this._out = paramLittleEndianOutput;
/*     */     } else {
/*     */       
/*  50 */       this._dataSizeOutput = paramLittleEndianOutput;
/*  51 */       this._byteBuffer = new byte[8224];
/*  52 */       this._out = (LittleEndianOutput)new LittleEndianByteArrayOutputStream(this._byteBuffer, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalSize() {
/*  59 */     return 4 + this._size;
/*     */   }
/*     */   public int getAvailableSpace() {
/*  62 */     if (this._out == null) {
/*  63 */       throw new IllegalStateException("Record already terminated");
/*     */     }
/*  65 */     return 8224 - this._size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void terminate() {
/*  72 */     if (this._out == null) {
/*  73 */       throw new IllegalStateException("Record already terminated");
/*     */     }
/*  75 */     this._dataSizeOutput.writeShort(this._size);
/*  76 */     if (this._byteBuffer != null) {
/*  77 */       this._originalOut.write(this._byteBuffer, 0, this._size);
/*  78 */       this._out = null;
/*     */       return;
/*     */     } 
/*  81 */     this._out = null;
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) {
/*  85 */     this._out.write(paramArrayOfbyte);
/*  86 */     this._size += paramArrayOfbyte.length;
/*     */   }
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  89 */     this._out.write(paramArrayOfbyte, paramInt1, paramInt2);
/*  90 */     this._size += paramInt2;
/*     */   }
/*     */   public void writeByte(int paramInt) {
/*  93 */     this._out.writeByte(paramInt);
/*  94 */     this._size++;
/*     */   }
/*     */   public void writeDouble(double paramDouble) {
/*  97 */     this._out.writeDouble(paramDouble);
/*  98 */     this._size += 8;
/*     */   }
/*     */   public void writeInt(int paramInt) {
/* 101 */     this._out.writeInt(paramInt);
/* 102 */     this._size += 4;
/*     */   }
/*     */   public void writeLong(long paramLong) {
/* 105 */     this._out.writeLong(paramLong);
/* 106 */     this._size += 8;
/*     */   }
/*     */   public void writeShort(int paramInt) {
/* 109 */     this._out.writeShort(paramInt);
/* 110 */     this._size += 2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cont\UnknownLengthRecordOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */