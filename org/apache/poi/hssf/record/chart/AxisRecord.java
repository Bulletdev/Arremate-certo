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
/*     */ public final class AxisRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4125;
/*     */   private short field_1_axisType;
/*     */   public static final short AXIS_TYPE_CATEGORY_OR_X_AXIS = 0;
/*     */   public static final short AXIS_TYPE_VALUE_AXIS = 1;
/*     */   public static final short AXIS_TYPE_SERIES_AXIS = 2;
/*     */   private int field_2_reserved1;
/*     */   private int field_3_reserved2;
/*     */   private int field_4_reserved3;
/*     */   private int field_5_reserved4;
/*     */   
/*     */   public AxisRecord() {}
/*     */   
/*     */   public AxisRecord(RecordInputStream paramRecordInputStream) {
/*  49 */     this.field_1_axisType = paramRecordInputStream.readShort();
/*  50 */     this.field_2_reserved1 = paramRecordInputStream.readInt();
/*  51 */     this.field_3_reserved2 = paramRecordInputStream.readInt();
/*  52 */     this.field_4_reserved3 = paramRecordInputStream.readInt();
/*  53 */     this.field_5_reserved4 = paramRecordInputStream.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  58 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  60 */     stringBuffer.append("[AXIS]\n");
/*  61 */     stringBuffer.append("    .axisType             = ").append("0x").append(HexDump.toHex(getAxisType())).append(" (").append(getAxisType()).append(" )");
/*     */ 
/*     */     
/*  64 */     stringBuffer.append(System.getProperty("line.separator"));
/*  65 */     stringBuffer.append("    .reserved1            = ").append("0x").append(HexDump.toHex(getReserved1())).append(" (").append(getReserved1()).append(" )");
/*     */ 
/*     */     
/*  68 */     stringBuffer.append(System.getProperty("line.separator"));
/*  69 */     stringBuffer.append("    .reserved2            = ").append("0x").append(HexDump.toHex(getReserved2())).append(" (").append(getReserved2()).append(" )");
/*     */ 
/*     */     
/*  72 */     stringBuffer.append(System.getProperty("line.separator"));
/*  73 */     stringBuffer.append("    .reserved3            = ").append("0x").append(HexDump.toHex(getReserved3())).append(" (").append(getReserved3()).append(" )");
/*     */ 
/*     */     
/*  76 */     stringBuffer.append(System.getProperty("line.separator"));
/*  77 */     stringBuffer.append("    .reserved4            = ").append("0x").append(HexDump.toHex(getReserved4())).append(" (").append(getReserved4()).append(" )");
/*     */ 
/*     */     
/*  80 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  82 */     stringBuffer.append("[/AXIS]\n");
/*  83 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  87 */     paramLittleEndianOutput.writeShort(this.field_1_axisType);
/*  88 */     paramLittleEndianOutput.writeInt(this.field_2_reserved1);
/*  89 */     paramLittleEndianOutput.writeInt(this.field_3_reserved2);
/*  90 */     paramLittleEndianOutput.writeInt(this.field_4_reserved3);
/*  91 */     paramLittleEndianOutput.writeInt(this.field_5_reserved4);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  95 */     return 18;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 100 */     return 4125;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisRecord clone() {
/* 105 */     AxisRecord axisRecord = new AxisRecord();
/*     */     
/* 107 */     axisRecord.field_1_axisType = this.field_1_axisType;
/* 108 */     axisRecord.field_2_reserved1 = this.field_2_reserved1;
/* 109 */     axisRecord.field_3_reserved2 = this.field_3_reserved2;
/* 110 */     axisRecord.field_4_reserved3 = this.field_4_reserved3;
/* 111 */     axisRecord.field_5_reserved4 = this.field_5_reserved4;
/* 112 */     return axisRecord;
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
/*     */   public short getAxisType() {
/* 128 */     return this.field_1_axisType;
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
/*     */   public void setAxisType(short paramShort) {
/* 142 */     this.field_1_axisType = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReserved1() {
/* 150 */     return this.field_2_reserved1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved1(int paramInt) {
/* 158 */     this.field_2_reserved1 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReserved2() {
/* 166 */     return this.field_3_reserved2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved2(int paramInt) {
/* 174 */     this.field_3_reserved2 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReserved3() {
/* 182 */     return this.field_4_reserved3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved3(int paramInt) {
/* 190 */     this.field_4_reserved3 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReserved4() {
/* 198 */     return this.field_5_reserved4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved4(int paramInt) {
/* 206 */     this.field_5_reserved4 = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\AxisRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */