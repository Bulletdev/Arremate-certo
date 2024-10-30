/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
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
/*     */ public final class ChartFormatRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4116;
/*  36 */   private static final BitField varyDisplayPattern = BitFieldFactory.getInstance(1);
/*     */   
/*     */   private int field1_x_position;
/*     */   
/*     */   private int field2_y_position;
/*     */   
/*     */   private int field3_width;
/*     */   
/*     */   private int field4_height;
/*     */   private int field5_grbit;
/*     */   private int field6_unknown;
/*     */   
/*     */   public ChartFormatRecord() {}
/*     */   
/*     */   public ChartFormatRecord(RecordInputStream paramRecordInputStream) {
/*  51 */     this.field1_x_position = paramRecordInputStream.readInt();
/*  52 */     this.field2_y_position = paramRecordInputStream.readInt();
/*  53 */     this.field3_width = paramRecordInputStream.readInt();
/*  54 */     this.field4_height = paramRecordInputStream.readInt();
/*  55 */     this.field5_grbit = paramRecordInputStream.readUShort();
/*  56 */     this.field6_unknown = paramRecordInputStream.readUShort();
/*     */   }
/*     */   
/*     */   public String toString() {
/*  60 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  62 */     stringBuffer.append("[CHARTFORMAT]\n");
/*  63 */     stringBuffer.append("    .xPosition       = ").append(getXPosition()).append("\n");
/*  64 */     stringBuffer.append("    .yPosition       = ").append(getYPosition()).append("\n");
/*  65 */     stringBuffer.append("    .width           = ").append(getWidth()).append("\n");
/*  66 */     stringBuffer.append("    .height          = ").append(getHeight()).append("\n");
/*  67 */     stringBuffer.append("    .grBit           = ").append(HexDump.intToHex(this.field5_grbit)).append("\n");
/*  68 */     stringBuffer.append("[/CHARTFORMAT]\n");
/*  69 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  73 */     paramLittleEndianOutput.writeInt(getXPosition());
/*  74 */     paramLittleEndianOutput.writeInt(getYPosition());
/*  75 */     paramLittleEndianOutput.writeInt(getWidth());
/*  76 */     paramLittleEndianOutput.writeInt(getHeight());
/*  77 */     paramLittleEndianOutput.writeShort(this.field5_grbit);
/*  78 */     paramLittleEndianOutput.writeShort(this.field6_unknown);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  82 */     return 20;
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  86 */     return 4116;
/*     */   }
/*     */   
/*     */   public int getXPosition() {
/*  90 */     return this.field1_x_position;
/*     */   }
/*     */   
/*     */   public void setXPosition(int paramInt) {
/*  94 */     this.field1_x_position = paramInt;
/*     */   }
/*     */   
/*     */   public int getYPosition() {
/*  98 */     return this.field2_y_position;
/*     */   }
/*     */   
/*     */   public void setYPosition(int paramInt) {
/* 102 */     this.field2_y_position = paramInt;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 106 */     return this.field3_width;
/*     */   }
/*     */   
/*     */   public void setWidth(int paramInt) {
/* 110 */     this.field3_width = paramInt;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 114 */     return this.field4_height;
/*     */   }
/*     */   
/*     */   public void setHeight(int paramInt) {
/* 118 */     this.field4_height = paramInt;
/*     */   }
/*     */   
/*     */   public boolean getVaryDisplayPattern() {
/* 122 */     return varyDisplayPattern.isSet(this.field5_grbit);
/*     */   }
/*     */   
/*     */   public void setVaryDisplayPattern(boolean paramBoolean) {
/* 126 */     this.field5_grbit = varyDisplayPattern.setBoolean(this.field5_grbit, paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ChartFormatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */