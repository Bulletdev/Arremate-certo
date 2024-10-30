/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ public final class MulBlankRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 190;
/*     */   private final int _row;
/*     */   private final int _firstCol;
/*     */   private final short[] _xfs;
/*     */   private final int _lastCol;
/*     */   
/*     */   public MulBlankRecord(int paramInt1, int paramInt2, short[] paramArrayOfshort) {
/*  39 */     this._row = paramInt1;
/*  40 */     this._firstCol = paramInt2;
/*  41 */     this._xfs = paramArrayOfshort;
/*  42 */     this._lastCol = paramInt2 + paramArrayOfshort.length - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRow() {
/*  49 */     return this._row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstColumn() {
/*  56 */     return this._firstCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastColumn() {
/*  63 */     return this._lastCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumColumns() {
/*  71 */     return this._lastCol - this._firstCol + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getXFAt(int paramInt) {
/*  80 */     return this._xfs[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MulBlankRecord(RecordInputStream paramRecordInputStream) {
/*  87 */     this._row = paramRecordInputStream.readUShort();
/*  88 */     this._firstCol = paramRecordInputStream.readShort();
/*  89 */     this._xfs = parseXFs(paramRecordInputStream);
/*  90 */     this._lastCol = paramRecordInputStream.readShort();
/*     */   }
/*     */   
/*     */   private static short[] parseXFs(RecordInputStream paramRecordInputStream) {
/*  94 */     short[] arrayOfShort = new short[(paramRecordInputStream.remaining() - 2) / 2];
/*     */     
/*  96 */     for (byte b = 0; b < arrayOfShort.length; b++) {
/*  97 */       arrayOfShort[b] = paramRecordInputStream.readShort();
/*     */     }
/*  99 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 105 */     stringBuffer.append("[MULBLANK]\n");
/* 106 */     stringBuffer.append("row  = ").append(Integer.toHexString(getRow())).append("\n");
/* 107 */     stringBuffer.append("firstcol  = ").append(Integer.toHexString(getFirstColumn())).append("\n");
/* 108 */     stringBuffer.append(" lastcol  = ").append(Integer.toHexString(this._lastCol)).append("\n");
/* 109 */     for (byte b = 0; b < getNumColumns(); b++) {
/* 110 */       stringBuffer.append("xf").append(b).append("\t\t= ").append(Integer.toHexString(getXFAt(b))).append("\n");
/*     */     }
/*     */     
/* 113 */     stringBuffer.append("[/MULBLANK]\n");
/* 114 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 118 */     return 190;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 122 */     paramLittleEndianOutput.writeShort(this._row);
/* 123 */     paramLittleEndianOutput.writeShort(this._firstCol);
/* 124 */     int i = this._xfs.length;
/* 125 */     for (byte b = 0; b < i; b++) {
/* 126 */       paramLittleEndianOutput.writeShort(this._xfs[b]);
/*     */     }
/* 128 */     paramLittleEndianOutput.writeShort(this._lastCol);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 133 */     return 6 + this._xfs.length * 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MulBlankRecord clone() {
/* 139 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\MulBlankRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */