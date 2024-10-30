/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RefPtgBase
/*     */   extends OperandPtg
/*     */ {
/*     */   private int field_1_row;
/*     */   private int field_2_col;
/*  41 */   private static final BitField rowRelative = BitFieldFactory.getInstance(32768);
/*  42 */   private static final BitField colRelative = BitFieldFactory.getInstance(16384);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   private static final BitField column = BitFieldFactory.getInstance(16383);
/*     */ 
/*     */   
/*     */   protected RefPtgBase() {}
/*     */ 
/*     */   
/*     */   protected RefPtgBase(CellReference paramCellReference) {
/*  57 */     setRow(paramCellReference.getRow());
/*  58 */     setColumn(paramCellReference.getCol());
/*  59 */     setColRelative(!paramCellReference.isColAbsolute());
/*  60 */     setRowRelative(!paramCellReference.isRowAbsolute());
/*     */   }
/*     */   
/*     */   protected final void readCoordinates(LittleEndianInput paramLittleEndianInput) {
/*  64 */     this.field_1_row = paramLittleEndianInput.readUShort();
/*  65 */     this.field_2_col = paramLittleEndianInput.readUShort();
/*     */   }
/*     */   
/*     */   protected final void writeCoordinates(LittleEndianOutput paramLittleEndianOutput) {
/*  69 */     paramLittleEndianOutput.writeShort(this.field_1_row);
/*  70 */     paramLittleEndianOutput.writeShort(this.field_2_col);
/*     */   }
/*     */   
/*     */   public final void setRow(int paramInt) {
/*  74 */     this.field_1_row = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getRow() {
/*  81 */     return this.field_1_row;
/*     */   }
/*     */   
/*     */   public final boolean isRowRelative() {
/*  85 */     return rowRelative.isSet(this.field_2_col);
/*     */   }
/*     */   
/*     */   public final void setRowRelative(boolean paramBoolean) {
/*  89 */     this.field_2_col = rowRelative.setBoolean(this.field_2_col, paramBoolean);
/*     */   }
/*     */   
/*     */   public final boolean isColRelative() {
/*  93 */     return colRelative.isSet(this.field_2_col);
/*     */   }
/*     */   
/*     */   public final void setColRelative(boolean paramBoolean) {
/*  97 */     this.field_2_col = colRelative.setBoolean(this.field_2_col, paramBoolean);
/*     */   }
/*     */   
/*     */   public final void setColumn(int paramInt) {
/* 101 */     this.field_2_col = column.setValue(this.field_2_col, paramInt);
/*     */   }
/*     */   
/*     */   public final int getColumn() {
/* 105 */     return column.getValue(this.field_2_col);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final String formatReferenceAsString() {
/* 110 */     CellReference cellReference = new CellReference(getRow(), getColumn(), !isRowRelative(), !isColRelative());
/* 111 */     return cellReference.formatAsString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final byte getDefaultOperandClass() {
/* 116 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\RefPtgBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */