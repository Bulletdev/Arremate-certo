/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
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
/*     */ public abstract class CellRecord
/*     */   extends StandardRecord
/*     */   implements CellValueRecordInterface
/*     */ {
/*     */   private int _rowIndex;
/*     */   private int _columnIndex;
/*     */   private int _formatIndex;
/*     */   
/*     */   protected CellRecord() {}
/*     */   
/*     */   protected CellRecord(RecordInputStream paramRecordInputStream) {
/*  37 */     this._rowIndex = paramRecordInputStream.readUShort();
/*  38 */     this._columnIndex = paramRecordInputStream.readUShort();
/*  39 */     this._formatIndex = paramRecordInputStream.readUShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setRow(int paramInt) {
/*  44 */     this._rowIndex = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setColumn(short paramShort) {
/*  49 */     this._columnIndex = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setXFIndex(short paramShort) {
/*  60 */     this._formatIndex = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getRow() {
/*  65 */     return this._rowIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public final short getColumn() {
/*  70 */     return (short)this._columnIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final short getXFIndex() {
/*  81 */     return (short)this._formatIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/*  86 */     StringBuilder stringBuilder = new StringBuilder();
/*  87 */     String str = getRecordName();
/*     */     
/*  89 */     stringBuilder.append("[").append(str).append("]\n");
/*  90 */     stringBuilder.append("    .row    = ").append(HexDump.shortToHex(getRow())).append("\n");
/*  91 */     stringBuilder.append("    .col    = ").append(HexDump.shortToHex(getColumn())).append("\n");
/*  92 */     stringBuilder.append("    .xfindex= ").append(HexDump.shortToHex(getXFIndex())).append("\n");
/*  93 */     appendValueText(stringBuilder);
/*  94 */     stringBuilder.append("\n");
/*  95 */     stringBuilder.append("[/").append(str).append("]\n");
/*  96 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void appendValueText(StringBuilder paramStringBuilder);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String getRecordName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void serializeValue(LittleEndianOutput paramLittleEndianOutput);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract int getValueDataSize();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 129 */     paramLittleEndianOutput.writeShort(getRow());
/* 130 */     paramLittleEndianOutput.writeShort(getColumn());
/* 131 */     paramLittleEndianOutput.writeShort(getXFIndex());
/* 132 */     serializeValue(paramLittleEndianOutput);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final int getDataSize() {
/* 137 */     return 6 + getValueDataSize();
/*     */   }
/*     */   
/*     */   protected final void copyBaseFields(CellRecord paramCellRecord) {
/* 141 */     paramCellRecord._rowIndex = this._rowIndex;
/* 142 */     paramCellRecord._columnIndex = this._columnIndex;
/* 143 */     paramCellRecord._formatIndex = this._formatIndex;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CellRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */