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
/*     */ public final class DVALRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 434;
/*     */   private short field_1_options;
/*     */   private int field_2_horiz_pos;
/*     */   private int field_3_vert_pos;
/*     */   private int field_cbo_id;
/*     */   private int field_5_dv_no;
/*     */   
/*     */   public DVALRecord() {
/*  46 */     this.field_cbo_id = -1;
/*  47 */     this.field_5_dv_no = 0;
/*     */   }
/*     */   
/*     */   public DVALRecord(RecordInputStream paramRecordInputStream) {
/*  51 */     this.field_1_options = paramRecordInputStream.readShort();
/*  52 */     this.field_2_horiz_pos = paramRecordInputStream.readInt();
/*  53 */     this.field_3_vert_pos = paramRecordInputStream.readInt();
/*  54 */     this.field_cbo_id = paramRecordInputStream.readInt();
/*  55 */     this.field_5_dv_no = paramRecordInputStream.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/*  62 */     this.field_1_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontalPos(int paramInt) {
/*  69 */     this.field_2_horiz_pos = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalPos(int paramInt) {
/*  76 */     this.field_3_vert_pos = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObjectID(int paramInt) {
/*  84 */     this.field_cbo_id = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDVRecNo(int paramInt) {
/*  92 */     this.field_5_dv_no = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/*  99 */     return this.field_1_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHorizontalPos() {
/* 106 */     return this.field_2_horiz_pos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVerticalPos() {
/* 113 */     return this.field_3_vert_pos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getObjectID() {
/* 120 */     return this.field_cbo_id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDVRecNo() {
/* 127 */     return this.field_5_dv_no;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 134 */     stringBuffer.append("[DVAL]\n");
/* 135 */     stringBuffer.append("    .options      = ").append(getOptions()).append('\n');
/* 136 */     stringBuffer.append("    .horizPos     = ").append(getHorizontalPos()).append('\n');
/* 137 */     stringBuffer.append("    .vertPos      = ").append(getVerticalPos()).append('\n');
/* 138 */     stringBuffer.append("    .comboObjectID   = ").append(Integer.toHexString(getObjectID())).append("\n");
/* 139 */     stringBuffer.append("    .DVRecordsNumber = ").append(Integer.toHexString(getDVRecNo())).append("\n");
/* 140 */     stringBuffer.append("[/DVAL]\n");
/* 141 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 146 */     paramLittleEndianOutput.writeShort(getOptions());
/* 147 */     paramLittleEndianOutput.writeInt(getHorizontalPos());
/* 148 */     paramLittleEndianOutput.writeInt(getVerticalPos());
/* 149 */     paramLittleEndianOutput.writeInt(getObjectID());
/* 150 */     paramLittleEndianOutput.writeInt(getDVRecNo());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 154 */     return 18;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 158 */     return 434;
/*     */   }
/*     */ 
/*     */   
/*     */   public DVALRecord clone() {
/* 163 */     DVALRecord dVALRecord = new DVALRecord();
/* 164 */     dVALRecord.field_1_options = this.field_1_options;
/* 165 */     dVALRecord.field_2_horiz_pos = this.field_2_horiz_pos;
/* 166 */     dVALRecord.field_3_vert_pos = this.field_3_vert_pos;
/* 167 */     dVALRecord.field_cbo_id = this.field_cbo_id;
/* 168 */     dVALRecord.field_5_dv_no = this.field_5_dv_no;
/* 169 */     return dVALRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DVALRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */