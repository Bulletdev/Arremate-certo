/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.util.CellRangeAddress8Bit;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public abstract class SharedValueRecordBase
/*     */   extends StandardRecord
/*     */ {
/*     */   private CellRangeAddress8Bit _range;
/*     */   
/*     */   protected SharedValueRecordBase(CellRangeAddress8Bit paramCellRangeAddress8Bit) {
/*  33 */     if (paramCellRangeAddress8Bit == null) {
/*  34 */       throw new IllegalArgumentException("range must be supplied.");
/*     */     }
/*  36 */     this._range = paramCellRangeAddress8Bit;
/*     */   }
/*     */   
/*     */   protected SharedValueRecordBase() {
/*  40 */     this(new CellRangeAddress8Bit(0, 0, 0, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SharedValueRecordBase(LittleEndianInput paramLittleEndianInput) {
/*  47 */     this._range = new CellRangeAddress8Bit(paramLittleEndianInput);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final CellRangeAddress8Bit getRange() {
/*  54 */     return this._range;
/*     */   }
/*     */   
/*     */   public final int getFirstRow() {
/*  58 */     return this._range.getFirstRow();
/*     */   }
/*     */   
/*     */   public final int getLastRow() {
/*  62 */     return this._range.getLastRow();
/*     */   }
/*     */   
/*     */   public final int getFirstColumn() {
/*  66 */     return (short)this._range.getFirstColumn();
/*     */   }
/*     */   
/*     */   public final int getLastColumn() {
/*  70 */     return (short)this._range.getLastColumn();
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  74 */     return 6 + getExtraDataSize();
/*     */   }
/*     */   
/*     */   protected abstract int getExtraDataSize();
/*     */   
/*     */   protected abstract void serializeExtraData(LittleEndianOutput paramLittleEndianOutput);
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  82 */     this._range.serialize(paramLittleEndianOutput);
/*  83 */     serializeExtraData(paramLittleEndianOutput);
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
/*     */   public final boolean isInRange(int paramInt1, int paramInt2) {
/*  95 */     CellRangeAddress8Bit cellRangeAddress8Bit = this._range;
/*  96 */     return (cellRangeAddress8Bit.getFirstRow() <= paramInt1 && cellRangeAddress8Bit.getLastRow() >= paramInt1 && cellRangeAddress8Bit.getFirstColumn() <= paramInt2 && cellRangeAddress8Bit.getLastColumn() >= paramInt2);
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
/*     */   public final boolean isFirstCell(int paramInt1, int paramInt2) {
/* 113 */     CellRangeAddress8Bit cellRangeAddress8Bit = getRange();
/* 114 */     return (cellRangeAddress8Bit.getFirstRow() == paramInt1 && cellRangeAddress8Bit.getFirstColumn() == paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SharedValueRecordBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */