/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.util.CellRangeAddress8Bit;
/*     */ import org.apache.poi.hssf.util.CellReference;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TableRecord
/*     */   extends SharedValueRecordBase
/*     */ {
/*     */   public static final short sid = 566;
/*  40 */   private static final BitField alwaysCalc = BitFieldFactory.getInstance(1);
/*  41 */   private static final BitField calcOnOpen = BitFieldFactory.getInstance(2);
/*  42 */   private static final BitField rowOrColInpCell = BitFieldFactory.getInstance(4);
/*  43 */   private static final BitField oneOrTwoVar = BitFieldFactory.getInstance(8);
/*  44 */   private static final BitField rowDeleted = BitFieldFactory.getInstance(16);
/*  45 */   private static final BitField colDeleted = BitFieldFactory.getInstance(32);
/*     */   
/*     */   private int field_5_flags;
/*     */   private int field_6_res;
/*     */   private int field_7_rowInputRow;
/*     */   private int field_8_colInputRow;
/*     */   private int field_9_rowInputCol;
/*     */   private int field_10_colInputCol;
/*     */   
/*     */   public TableRecord(RecordInputStream paramRecordInputStream) {
/*  55 */     super(paramRecordInputStream);
/*  56 */     this.field_5_flags = paramRecordInputStream.readByte();
/*  57 */     this.field_6_res = paramRecordInputStream.readByte();
/*  58 */     this.field_7_rowInputRow = paramRecordInputStream.readShort();
/*  59 */     this.field_8_colInputRow = paramRecordInputStream.readShort();
/*  60 */     this.field_9_rowInputCol = paramRecordInputStream.readShort();
/*  61 */     this.field_10_colInputCol = paramRecordInputStream.readShort();
/*     */   }
/*     */   
/*     */   public TableRecord(CellRangeAddress8Bit paramCellRangeAddress8Bit) {
/*  65 */     super(paramCellRangeAddress8Bit);
/*  66 */     this.field_6_res = 0;
/*     */   }
/*     */   
/*     */   public int getFlags() {
/*  70 */     return this.field_5_flags;
/*     */   }
/*     */   public void setFlags(int paramInt) {
/*  73 */     this.field_5_flags = paramInt;
/*     */   }
/*     */   
/*     */   public int getRowInputRow() {
/*  77 */     return this.field_7_rowInputRow;
/*     */   }
/*     */   public void setRowInputRow(int paramInt) {
/*  80 */     this.field_7_rowInputRow = paramInt;
/*     */   }
/*     */   
/*     */   public int getColInputRow() {
/*  84 */     return this.field_8_colInputRow;
/*     */   }
/*     */   public void setColInputRow(int paramInt) {
/*  87 */     this.field_8_colInputRow = paramInt;
/*     */   }
/*     */   
/*     */   public int getRowInputCol() {
/*  91 */     return this.field_9_rowInputCol;
/*     */   }
/*     */   public void setRowInputCol(int paramInt) {
/*  94 */     this.field_9_rowInputCol = paramInt;
/*     */   }
/*     */   
/*     */   public int getColInputCol() {
/*  98 */     return this.field_10_colInputCol;
/*     */   }
/*     */   public void setColInputCol(int paramInt) {
/* 101 */     this.field_10_colInputCol = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAlwaysCalc() {
/* 106 */     return alwaysCalc.isSet(this.field_5_flags);
/*     */   }
/*     */   public void setAlwaysCalc(boolean paramBoolean) {
/* 109 */     this.field_5_flags = alwaysCalc.setBoolean(this.field_5_flags, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isRowOrColInpCell() {
/* 113 */     return rowOrColInpCell.isSet(this.field_5_flags);
/*     */   }
/*     */   public void setRowOrColInpCell(boolean paramBoolean) {
/* 116 */     this.field_5_flags = rowOrColInpCell.setBoolean(this.field_5_flags, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isOneNotTwoVar() {
/* 120 */     return oneOrTwoVar.isSet(this.field_5_flags);
/*     */   }
/*     */   public void setOneNotTwoVar(boolean paramBoolean) {
/* 123 */     this.field_5_flags = oneOrTwoVar.setBoolean(this.field_5_flags, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isColDeleted() {
/* 127 */     return colDeleted.isSet(this.field_5_flags);
/*     */   }
/*     */   public void setColDeleted(boolean paramBoolean) {
/* 130 */     this.field_5_flags = colDeleted.setBoolean(this.field_5_flags, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isRowDeleted() {
/* 134 */     return rowDeleted.isSet(this.field_5_flags);
/*     */   }
/*     */   public void setRowDeleted(boolean paramBoolean) {
/* 137 */     this.field_5_flags = rowDeleted.setBoolean(this.field_5_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 142 */     return 566;
/*     */   }
/*     */   protected int getExtraDataSize() {
/* 145 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void serializeExtraData(LittleEndianOutput paramLittleEndianOutput) {
/* 150 */     paramLittleEndianOutput.writeByte(this.field_5_flags);
/* 151 */     paramLittleEndianOutput.writeByte(this.field_6_res);
/* 152 */     paramLittleEndianOutput.writeShort(this.field_7_rowInputRow);
/* 153 */     paramLittleEndianOutput.writeShort(this.field_8_colInputRow);
/* 154 */     paramLittleEndianOutput.writeShort(this.field_9_rowInputCol);
/* 155 */     paramLittleEndianOutput.writeShort(this.field_10_colInputCol);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 159 */     StringBuffer stringBuffer = new StringBuffer();
/* 160 */     stringBuffer.append("[TABLE]\n");
/* 161 */     stringBuffer.append("    .range    = ").append(getRange().toString()).append("\n");
/* 162 */     stringBuffer.append("    .flags    = ").append(HexDump.byteToHex(this.field_5_flags)).append("\n");
/* 163 */     stringBuffer.append("    .alwaysClc= ").append(isAlwaysCalc()).append("\n");
/* 164 */     stringBuffer.append("    .reserved = ").append(HexDump.intToHex(this.field_6_res)).append("\n");
/* 165 */     CellReference cellReference1 = cr(this.field_7_rowInputRow, this.field_8_colInputRow);
/* 166 */     CellReference cellReference2 = cr(this.field_9_rowInputCol, this.field_10_colInputCol);
/* 167 */     stringBuffer.append("    .rowInput = ").append(cellReference1.formatAsString()).append("\n");
/* 168 */     stringBuffer.append("    .colInput = ").append(cellReference2.formatAsString()).append("\n");
/* 169 */     stringBuffer.append("[/TABLE]\n");
/* 170 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private static CellReference cr(int paramInt1, int paramInt2) {
/* 174 */     int i = paramInt2 & 0xFF;
/* 175 */     boolean bool1 = ((paramInt2 & 0x8000) == 0) ? true : false;
/* 176 */     boolean bool2 = ((paramInt2 & 0x4000) == 0) ? true : false;
/* 177 */     return new CellReference(paramInt1, i, bool1, bool2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\TableRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */