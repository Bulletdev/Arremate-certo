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
/*     */ 
/*     */ public final class DimensionsRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 512;
/*     */   private int field_1_first_row;
/*     */   private int field_2_last_row;
/*     */   private short field_3_first_col;
/*     */   private short field_4_last_col;
/*     */   private short field_5_zero;
/*     */   
/*     */   public DimensionsRecord() {}
/*     */   
/*     */   public DimensionsRecord(RecordInputStream paramRecordInputStream) {
/*  48 */     this.field_1_first_row = paramRecordInputStream.readInt();
/*  49 */     this.field_2_last_row = paramRecordInputStream.readInt();
/*  50 */     this.field_3_first_col = paramRecordInputStream.readShort();
/*  51 */     this.field_4_last_col = paramRecordInputStream.readShort();
/*  52 */     this.field_5_zero = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstRow(int paramInt) {
/*  62 */     this.field_1_first_row = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastRow(int paramInt) {
/*  72 */     this.field_2_last_row = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstCol(short paramShort) {
/*  82 */     this.field_3_first_col = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastCol(short paramShort) {
/*  92 */     this.field_4_last_col = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstRow() {
/* 102 */     return this.field_1_first_row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastRow() {
/* 112 */     return this.field_2_last_row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFirstCol() {
/* 122 */     return this.field_3_first_col;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLastCol() {
/* 132 */     return this.field_4_last_col;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 137 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 139 */     stringBuffer.append("[DIMENSIONS]\n");
/* 140 */     stringBuffer.append("    .firstrow       = ").append(Integer.toHexString(getFirstRow())).append("\n");
/*     */     
/* 142 */     stringBuffer.append("    .lastrow        = ").append(Integer.toHexString(getLastRow())).append("\n");
/*     */     
/* 144 */     stringBuffer.append("    .firstcol       = ").append(Integer.toHexString(getFirstCol())).append("\n");
/*     */     
/* 146 */     stringBuffer.append("    .lastcol        = ").append(Integer.toHexString(getLastCol())).append("\n");
/*     */     
/* 148 */     stringBuffer.append("    .zero           = ").append(Integer.toHexString(this.field_5_zero)).append("\n");
/*     */     
/* 150 */     stringBuffer.append("[/DIMENSIONS]\n");
/* 151 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 155 */     paramLittleEndianOutput.writeInt(getFirstRow());
/* 156 */     paramLittleEndianOutput.writeInt(getLastRow());
/* 157 */     paramLittleEndianOutput.writeShort(getFirstCol());
/* 158 */     paramLittleEndianOutput.writeShort(getLastCol());
/* 159 */     paramLittleEndianOutput.writeShort(0);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 163 */     return 14;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 168 */     return 512;
/*     */   }
/*     */ 
/*     */   
/*     */   public DimensionsRecord clone() {
/* 173 */     DimensionsRecord dimensionsRecord = new DimensionsRecord();
/* 174 */     dimensionsRecord.field_1_first_row = this.field_1_first_row;
/* 175 */     dimensionsRecord.field_2_last_row = this.field_2_last_row;
/* 176 */     dimensionsRecord.field_3_first_col = this.field_3_first_col;
/* 177 */     dimensionsRecord.field_4_last_col = this.field_4_last_col;
/* 178 */     dimensionsRecord.field_5_zero = this.field_5_zero;
/* 179 */     return dimensionsRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DimensionsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */