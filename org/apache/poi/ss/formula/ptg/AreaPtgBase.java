/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.util.AreaReference;
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
/*     */ public abstract class AreaPtgBase
/*     */   extends OperandPtg
/*     */   implements AreaI
/*     */ {
/*     */   private int field_1_first_row;
/*     */   private int field_2_last_row;
/*     */   private int field_3_first_column;
/*     */   private int field_4_last_column;
/*     */   
/*     */   protected final RuntimeException notImplemented() {
/*  39 */     return new RuntimeException("Coding Error: This method should never be called. This ptg should be converted");
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
/*  51 */   private static final BitField rowRelative = BitFieldFactory.getInstance(32768);
/*  52 */   private static final BitField colRelative = BitFieldFactory.getInstance(16384);
/*  53 */   private static final BitField columnMask = BitFieldFactory.getInstance(16383);
/*     */ 
/*     */   
/*     */   protected AreaPtgBase() {}
/*     */ 
/*     */   
/*     */   protected AreaPtgBase(AreaReference paramAreaReference) {
/*  60 */     CellReference cellReference1 = paramAreaReference.getFirstCell();
/*  61 */     CellReference cellReference2 = paramAreaReference.getLastCell();
/*  62 */     setFirstRow(cellReference1.getRow());
/*  63 */     setFirstColumn((cellReference1.getCol() == -1) ? 0 : cellReference1.getCol());
/*  64 */     setLastRow(cellReference2.getRow());
/*  65 */     setLastColumn((cellReference2.getCol() == -1) ? 255 : cellReference2.getCol());
/*  66 */     setFirstColRelative(!cellReference1.isColAbsolute());
/*  67 */     setLastColRelative(!cellReference2.isColAbsolute());
/*  68 */     setFirstRowRelative(!cellReference1.isRowAbsolute());
/*  69 */     setLastRowRelative(!cellReference2.isRowAbsolute());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AreaPtgBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*  75 */     if (paramInt2 >= paramInt1) {
/*  76 */       setFirstRow(paramInt1);
/*  77 */       setLastRow(paramInt2);
/*  78 */       setFirstRowRelative(paramBoolean1);
/*  79 */       setLastRowRelative(paramBoolean2);
/*     */     } else {
/*  81 */       setFirstRow(paramInt2);
/*  82 */       setLastRow(paramInt1);
/*  83 */       setFirstRowRelative(paramBoolean2);
/*  84 */       setLastRowRelative(paramBoolean1);
/*     */     } 
/*     */     
/*  87 */     if (paramInt4 >= paramInt3) {
/*  88 */       setFirstColumn(paramInt3);
/*  89 */       setLastColumn(paramInt4);
/*  90 */       setFirstColRelative(paramBoolean3);
/*  91 */       setLastColRelative(paramBoolean4);
/*     */     } else {
/*  93 */       setFirstColumn(paramInt4);
/*  94 */       setLastColumn(paramInt3);
/*  95 */       setFirstColRelative(paramBoolean4);
/*  96 */       setLastColRelative(paramBoolean3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sortTopLeftToBottomRight() {
/* 107 */     if (getFirstRow() > getLastRow()) {
/*     */ 
/*     */       
/* 110 */       int i = getFirstRow();
/* 111 */       boolean bool = isFirstRowRelative();
/* 112 */       setFirstRow(getLastRow());
/* 113 */       setFirstRowRelative(isLastRowRelative());
/* 114 */       setLastRow(i);
/* 115 */       setLastRowRelative(bool);
/*     */     } 
/* 117 */     if (getFirstColumn() > getLastColumn()) {
/*     */ 
/*     */       
/* 120 */       int i = getFirstColumn();
/* 121 */       boolean bool = isFirstColRelative();
/* 122 */       setFirstColumn(getLastColumn());
/* 123 */       setFirstColRelative(isLastColRelative());
/* 124 */       setLastColumn(i);
/* 125 */       setLastColRelative(bool);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void readCoordinates(LittleEndianInput paramLittleEndianInput) {
/* 130 */     this.field_1_first_row = paramLittleEndianInput.readUShort();
/* 131 */     this.field_2_last_row = paramLittleEndianInput.readUShort();
/* 132 */     this.field_3_first_column = paramLittleEndianInput.readUShort();
/* 133 */     this.field_4_last_column = paramLittleEndianInput.readUShort();
/*     */   }
/*     */   protected final void writeCoordinates(LittleEndianOutput paramLittleEndianOutput) {
/* 136 */     paramLittleEndianOutput.writeShort(this.field_1_first_row);
/* 137 */     paramLittleEndianOutput.writeShort(this.field_2_last_row);
/* 138 */     paramLittleEndianOutput.writeShort(this.field_3_first_column);
/* 139 */     paramLittleEndianOutput.writeShort(this.field_4_last_column);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getFirstRow() {
/* 146 */     return this.field_1_first_row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFirstRow(int paramInt) {
/* 154 */     this.field_1_first_row = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLastRow() {
/* 161 */     return this.field_2_last_row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLastRow(int paramInt) {
/* 168 */     this.field_2_last_row = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getFirstColumn() {
/* 175 */     return columnMask.getValue(this.field_3_first_column);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final short getFirstColumnRaw() {
/* 182 */     return (short)this.field_3_first_column;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isFirstRowRelative() {
/* 189 */     return rowRelative.isSet(this.field_3_first_column);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFirstRowRelative(boolean paramBoolean) {
/* 197 */     this.field_3_first_column = rowRelative.setBoolean(this.field_3_first_column, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isFirstColRelative() {
/* 204 */     return colRelative.isSet(this.field_3_first_column);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFirstColRelative(boolean paramBoolean) {
/* 211 */     this.field_3_first_column = colRelative.setBoolean(this.field_3_first_column, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFirstColumn(int paramInt) {
/* 218 */     this.field_3_first_column = columnMask.setValue(this.field_3_first_column, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFirstColumnRaw(int paramInt) {
/* 225 */     this.field_3_first_column = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLastColumn() {
/* 232 */     return columnMask.getValue(this.field_4_last_column);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final short getLastColumnRaw() {
/* 239 */     return (short)this.field_4_last_column;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isLastRowRelative() {
/* 246 */     return rowRelative.isSet(this.field_4_last_column);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLastRowRelative(boolean paramBoolean) {
/* 255 */     this.field_4_last_column = rowRelative.setBoolean(this.field_4_last_column, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isLastColRelative() {
/* 262 */     return colRelative.isSet(this.field_4_last_column);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLastColRelative(boolean paramBoolean) {
/* 269 */     this.field_4_last_column = colRelative.setBoolean(this.field_4_last_column, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLastColumn(int paramInt) {
/* 276 */     this.field_4_last_column = columnMask.setValue(this.field_4_last_column, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLastColumnRaw(short paramShort) {
/* 283 */     this.field_4_last_column = paramShort;
/*     */   }
/*     */   protected final String formatReferenceAsString() {
/* 286 */     CellReference cellReference1 = new CellReference(getFirstRow(), getFirstColumn(), !isFirstRowRelative(), !isFirstColRelative());
/* 287 */     CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn(), !isLastRowRelative(), !isLastColRelative());
/*     */     
/* 289 */     if (AreaReference.isWholeColumnReference(SpreadsheetVersion.EXCEL97, cellReference1, cellReference2)) {
/* 290 */       return (new AreaReference(cellReference1, cellReference2)).formatAsString();
/*     */     }
/* 292 */     return cellReference1.formatAsString() + ":" + cellReference2.formatAsString();
/*     */   }
/*     */   
/*     */   public String toFormulaString() {
/* 296 */     return formatReferenceAsString();
/*     */   }
/*     */   
/*     */   public byte getDefaultOperandClass() {
/* 300 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\AreaPtgBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */