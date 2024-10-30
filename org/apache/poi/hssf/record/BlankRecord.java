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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BlankRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable, CellValueRecordInterface
/*     */ {
/*     */   public static final short sid = 513;
/*     */   private int field_1_row;
/*     */   private short field_2_col;
/*     */   private short field_3_xf;
/*     */   
/*     */   public BlankRecord() {}
/*     */   
/*     */   public BlankRecord(RecordInputStream paramRecordInputStream) {
/*  44 */     this.field_1_row = paramRecordInputStream.readUShort();
/*  45 */     this.field_2_col = paramRecordInputStream.readShort();
/*  46 */     this.field_3_xf = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow(int paramInt) {
/*  55 */     this.field_1_row = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRow() {
/*  65 */     return this.field_1_row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getColumn() {
/*  75 */     return this.field_2_col;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXFIndex(short paramShort) {
/*  86 */     this.field_3_xf = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getXFIndex() {
/*  96 */     return this.field_3_xf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumn(short paramShort) {
/* 107 */     this.field_2_col = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 115 */     return 513;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 122 */     stringBuffer.append("[BLANK]\n");
/* 123 */     stringBuffer.append("    row= ").append(HexDump.shortToHex(getRow())).append("\n");
/* 124 */     stringBuffer.append("    col= ").append(HexDump.shortToHex(getColumn())).append("\n");
/* 125 */     stringBuffer.append("    xf = ").append(HexDump.shortToHex(getXFIndex())).append("\n");
/* 126 */     stringBuffer.append("[/BLANK]\n");
/* 127 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 131 */     paramLittleEndianOutput.writeShort(getRow());
/* 132 */     paramLittleEndianOutput.writeShort(getColumn());
/* 133 */     paramLittleEndianOutput.writeShort(getXFIndex());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 137 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlankRecord clone() {
/* 142 */     BlankRecord blankRecord = new BlankRecord();
/* 143 */     blankRecord.field_1_row = this.field_1_row;
/* 144 */     blankRecord.field_2_col = this.field_2_col;
/* 145 */     blankRecord.field_3_xf = this.field_3_xf;
/* 146 */     return blankRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\BlankRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */