/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
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
/*     */ public final class AxisParentRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4161;
/*     */   private short field_1_axisType;
/*     */   public static final short AXIS_TYPE_MAIN = 0;
/*     */   public static final short AXIS_TYPE_SECONDARY = 1;
/*     */   private int field_2_x;
/*     */   private int field_3_y;
/*     */   private int field_4_width;
/*     */   private int field_5_height;
/*     */   
/*     */   public AxisParentRecord() {}
/*     */   
/*     */   public AxisParentRecord(RecordInputStream paramRecordInputStream) {
/*  48 */     this.field_1_axisType = paramRecordInputStream.readShort();
/*  49 */     this.field_2_x = paramRecordInputStream.readInt();
/*  50 */     this.field_3_y = paramRecordInputStream.readInt();
/*  51 */     this.field_4_width = paramRecordInputStream.readInt();
/*  52 */     this.field_5_height = paramRecordInputStream.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  57 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  59 */     stringBuffer.append("[AXISPARENT]\n");
/*  60 */     stringBuffer.append("    .axisType             = ").append("0x").append(HexDump.toHex(getAxisType())).append(" (").append(getAxisType()).append(" )");
/*     */ 
/*     */     
/*  63 */     stringBuffer.append(System.getProperty("line.separator"));
/*  64 */     stringBuffer.append("    .x                    = ").append("0x").append(HexDump.toHex(getX())).append(" (").append(getX()).append(" )");
/*     */ 
/*     */     
/*  67 */     stringBuffer.append(System.getProperty("line.separator"));
/*  68 */     stringBuffer.append("    .y                    = ").append("0x").append(HexDump.toHex(getY())).append(" (").append(getY()).append(" )");
/*     */ 
/*     */     
/*  71 */     stringBuffer.append(System.getProperty("line.separator"));
/*  72 */     stringBuffer.append("    .width                = ").append("0x").append(HexDump.toHex(getWidth())).append(" (").append(getWidth()).append(" )");
/*     */ 
/*     */     
/*  75 */     stringBuffer.append(System.getProperty("line.separator"));
/*  76 */     stringBuffer.append("    .height               = ").append("0x").append(HexDump.toHex(getHeight())).append(" (").append(getHeight()).append(" )");
/*     */ 
/*     */     
/*  79 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  81 */     stringBuffer.append("[/AXISPARENT]\n");
/*  82 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  86 */     paramLittleEndianOutput.writeShort(this.field_1_axisType);
/*  87 */     paramLittleEndianOutput.writeInt(this.field_2_x);
/*  88 */     paramLittleEndianOutput.writeInt(this.field_3_y);
/*  89 */     paramLittleEndianOutput.writeInt(this.field_4_width);
/*  90 */     paramLittleEndianOutput.writeInt(this.field_5_height);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  94 */     return 18;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  99 */     return 4161;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisParentRecord clone() {
/* 104 */     AxisParentRecord axisParentRecord = new AxisParentRecord();
/*     */     
/* 106 */     axisParentRecord.field_1_axisType = this.field_1_axisType;
/* 107 */     axisParentRecord.field_2_x = this.field_2_x;
/* 108 */     axisParentRecord.field_3_y = this.field_3_y;
/* 109 */     axisParentRecord.field_4_width = this.field_4_width;
/* 110 */     axisParentRecord.field_5_height = this.field_5_height;
/* 111 */     return axisParentRecord;
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
/*     */   public short getAxisType() {
/* 126 */     return this.field_1_axisType;
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
/*     */   public void setAxisType(short paramShort) {
/* 139 */     this.field_1_axisType = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX() {
/* 147 */     return this.field_2_x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(int paramInt) {
/* 155 */     this.field_2_x = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getY() {
/* 163 */     return this.field_3_y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(int paramInt) {
/* 171 */     this.field_3_y = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 179 */     return this.field_4_width;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWidth(int paramInt) {
/* 187 */     this.field_4_width = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 195 */     return this.field_5_height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeight(int paramInt) {
/* 203 */     this.field_5_height = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\AxisParentRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */