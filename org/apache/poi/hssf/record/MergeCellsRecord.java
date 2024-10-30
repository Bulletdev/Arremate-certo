/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellRangeAddressList;
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
/*     */ public final class MergeCellsRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 229;
/*     */   private final CellRangeAddress[] _regions;
/*     */   private final int _startIndex;
/*     */   private final int _numberOfRegions;
/*     */   
/*     */   public MergeCellsRecord(CellRangeAddress[] paramArrayOfCellRangeAddress, int paramInt1, int paramInt2) {
/*  37 */     this._regions = paramArrayOfCellRangeAddress;
/*  38 */     this._startIndex = paramInt1;
/*  39 */     this._numberOfRegions = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MergeCellsRecord(RecordInputStream paramRecordInputStream) {
/*  46 */     int i = paramRecordInputStream.readUShort();
/*  47 */     CellRangeAddress[] arrayOfCellRangeAddress = new CellRangeAddress[i];
/*  48 */     for (byte b = 0; b < i; b++) {
/*  49 */       arrayOfCellRangeAddress[b] = new CellRangeAddress(paramRecordInputStream);
/*     */     }
/*  51 */     this._numberOfRegions = i;
/*  52 */     this._startIndex = 0;
/*  53 */     this._regions = arrayOfCellRangeAddress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNumAreas() {
/*  61 */     return (short)this._numberOfRegions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellRangeAddress getAreaAt(int paramInt) {
/*  70 */     return this._regions[this._startIndex + paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  75 */     return CellRangeAddressList.getEncodedSize(this._numberOfRegions);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  80 */     return 229;
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  85 */     int i = this._numberOfRegions;
/*  86 */     paramLittleEndianOutput.writeShort(i);
/*  87 */     for (byte b = 0; b < this._numberOfRegions; b++) {
/*  88 */       this._regions[this._startIndex + b].serialize(paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  96 */     stringBuffer.append("[MERGEDCELLS]").append("\n");
/*  97 */     stringBuffer.append("     .numregions =").append(getNumAreas()).append("\n");
/*  98 */     for (byte b = 0; b < this._numberOfRegions; b++) {
/*  99 */       CellRangeAddress cellRangeAddress = this._regions[this._startIndex + b];
/*     */       
/* 101 */       stringBuffer.append("     .rowfrom =").append(cellRangeAddress.getFirstRow()).append("\n");
/* 102 */       stringBuffer.append("     .rowto   =").append(cellRangeAddress.getLastRow()).append("\n");
/* 103 */       stringBuffer.append("     .colfrom =").append(cellRangeAddress.getFirstColumn()).append("\n");
/* 104 */       stringBuffer.append("     .colto   =").append(cellRangeAddress.getLastColumn()).append("\n");
/*     */     } 
/* 106 */     stringBuffer.append("[MERGEDCELLS]").append("\n");
/* 107 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public MergeCellsRecord clone() {
/* 112 */     int i = this._numberOfRegions;
/* 113 */     CellRangeAddress[] arrayOfCellRangeAddress = new CellRangeAddress[i];
/* 114 */     for (byte b = 0; b < arrayOfCellRangeAddress.length; b++) {
/* 115 */       arrayOfCellRangeAddress[b] = this._regions[this._startIndex + b].copy();
/*     */     }
/* 117 */     return new MergeCellsRecord(arrayOfCellRangeAddress, 0, i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\MergeCellsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */