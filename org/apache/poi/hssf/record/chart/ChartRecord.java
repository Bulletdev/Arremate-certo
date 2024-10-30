/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ChartRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4098;
/*     */   private int field_1_x;
/*     */   private int field_2_y;
/*     */   private int field_3_width;
/*     */   private int field_4_height;
/*     */   
/*     */   public ChartRecord() {}
/*     */   
/*     */   public ChartRecord(RecordInputStream paramRecordInputStream) {
/*  54 */     this.field_1_x = paramRecordInputStream.readInt();
/*  55 */     this.field_2_y = paramRecordInputStream.readInt();
/*  56 */     this.field_3_width = paramRecordInputStream.readInt();
/*  57 */     this.field_4_height = paramRecordInputStream.readInt();
/*     */   }
/*     */   
/*     */   public String toString() {
/*  61 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  63 */     stringBuffer.append("[CHART]\n");
/*  64 */     stringBuffer.append("    .x     = ").append(getX()).append('\n');
/*  65 */     stringBuffer.append("    .y     = ").append(getY()).append('\n');
/*  66 */     stringBuffer.append("    .width = ").append(getWidth()).append('\n');
/*  67 */     stringBuffer.append("    .height= ").append(getHeight()).append('\n');
/*  68 */     stringBuffer.append("[/CHART]\n");
/*  69 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  73 */     paramLittleEndianOutput.writeInt(this.field_1_x);
/*  74 */     paramLittleEndianOutput.writeInt(this.field_2_y);
/*  75 */     paramLittleEndianOutput.writeInt(this.field_3_width);
/*  76 */     paramLittleEndianOutput.writeInt(this.field_4_height);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  80 */     return 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  85 */     return 4098;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChartRecord clone() {
/*  90 */     ChartRecord chartRecord = new ChartRecord();
/*     */     
/*  92 */     chartRecord.field_1_x = this.field_1_x;
/*  93 */     chartRecord.field_2_y = this.field_2_y;
/*  94 */     chartRecord.field_3_width = this.field_3_width;
/*  95 */     chartRecord.field_4_height = this.field_4_height;
/*  96 */     return chartRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX() {
/* 106 */     return this.field_1_x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(int paramInt) {
/* 113 */     this.field_1_x = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getY() {
/* 120 */     return this.field_2_y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(int paramInt) {
/* 127 */     this.field_2_y = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 134 */     return this.field_3_width;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWidth(int paramInt) {
/* 141 */     this.field_3_width = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 148 */     return this.field_4_height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeight(int paramInt) {
/* 155 */     this.field_4_height = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ChartRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */