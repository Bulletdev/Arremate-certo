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
/*     */ public final class AxisLineFormatRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4129;
/*     */   private short field_1_axisType;
/*     */   public static final short AXIS_TYPE_AXIS_LINE = 0;
/*     */   public static final short AXIS_TYPE_MAJOR_GRID_LINE = 1;
/*     */   public static final short AXIS_TYPE_MINOR_GRID_LINE = 2;
/*     */   public static final short AXIS_TYPE_WALLS_OR_FLOOR = 3;
/*     */   
/*     */   public AxisLineFormatRecord() {}
/*     */   
/*     */   public AxisLineFormatRecord(RecordInputStream paramRecordInputStream) {
/*  46 */     this.field_1_axisType = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  51 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  53 */     stringBuffer.append("[AXISLINEFORMAT]\n");
/*  54 */     stringBuffer.append("    .axisType             = ").append("0x").append(HexDump.toHex(getAxisType())).append(" (").append(getAxisType()).append(" )");
/*     */ 
/*     */     
/*  57 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  59 */     stringBuffer.append("[/AXISLINEFORMAT]\n");
/*  60 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  64 */     paramLittleEndianOutput.writeShort(this.field_1_axisType);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  68 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  73 */     return 4129;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisLineFormatRecord clone() {
/*  78 */     AxisLineFormatRecord axisLineFormatRecord = new AxisLineFormatRecord();
/*     */     
/*  80 */     axisLineFormatRecord.field_1_axisType = this.field_1_axisType;
/*  81 */     return axisLineFormatRecord;
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
/*     */   public short getAxisType() {
/*  98 */     return this.field_1_axisType;
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
/*     */   public void setAxisType(short paramShort) {
/* 113 */     this.field_1_axisType = paramShort;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\AxisLineFormatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */