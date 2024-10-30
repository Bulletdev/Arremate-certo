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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GutsRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 128;
/*     */   private short field_1_left_row_gutter;
/*     */   private short field_2_top_col_gutter;
/*     */   private short field_3_row_level_max;
/*     */   private short field_4_col_level_max;
/*     */   
/*     */   public GutsRecord() {}
/*     */   
/*     */   public GutsRecord(RecordInputStream paramRecordInputStream) {
/*  46 */     this.field_1_left_row_gutter = paramRecordInputStream.readShort();
/*  47 */     this.field_2_top_col_gutter = paramRecordInputStream.readShort();
/*  48 */     this.field_3_row_level_max = paramRecordInputStream.readShort();
/*  49 */     this.field_4_col_level_max = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftRowGutter(short paramShort) {
/*  60 */     this.field_1_left_row_gutter = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTopColGutter(short paramShort) {
/*  71 */     this.field_2_top_col_gutter = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowLevelMax(short paramShort) {
/*  82 */     this.field_3_row_level_max = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColLevelMax(short paramShort) {
/*  93 */     this.field_4_col_level_max = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLeftRowGutter() {
/* 104 */     return this.field_1_left_row_gutter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTopColGutter() {
/* 115 */     return this.field_2_top_col_gutter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getRowLevelMax() {
/* 126 */     return this.field_3_row_level_max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getColLevelMax() {
/* 137 */     return this.field_4_col_level_max;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 144 */     stringBuffer.append("[GUTS]\n");
/* 145 */     stringBuffer.append("    .leftgutter     = ").append(Integer.toHexString(getLeftRowGutter())).append("\n");
/*     */     
/* 147 */     stringBuffer.append("    .topgutter      = ").append(Integer.toHexString(getTopColGutter())).append("\n");
/*     */     
/* 149 */     stringBuffer.append("    .rowlevelmax    = ").append(Integer.toHexString(getRowLevelMax())).append("\n");
/*     */     
/* 151 */     stringBuffer.append("    .collevelmax    = ").append(Integer.toHexString(getColLevelMax())).append("\n");
/*     */     
/* 153 */     stringBuffer.append("[/GUTS]\n");
/* 154 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 158 */     paramLittleEndianOutput.writeShort(getLeftRowGutter());
/* 159 */     paramLittleEndianOutput.writeShort(getTopColGutter());
/* 160 */     paramLittleEndianOutput.writeShort(getRowLevelMax());
/* 161 */     paramLittleEndianOutput.writeShort(getColLevelMax());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 165 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 170 */     return 128;
/*     */   }
/*     */ 
/*     */   
/*     */   public GutsRecord clone() {
/* 175 */     GutsRecord gutsRecord = new GutsRecord();
/* 176 */     gutsRecord.field_1_left_row_gutter = this.field_1_left_row_gutter;
/* 177 */     gutsRecord.field_2_top_col_gutter = this.field_2_top_col_gutter;
/* 178 */     gutsRecord.field_3_row_level_max = this.field_3_row_level_max;
/* 179 */     gutsRecord.field_4_col_level_max = this.field_4_col_level_max;
/* 180 */     return gutsRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\GutsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */