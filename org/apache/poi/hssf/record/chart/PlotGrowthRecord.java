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
/*     */ public final class PlotGrowthRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4196;
/*     */   private int field_1_horizontalScale;
/*     */   private int field_2_verticalScale;
/*     */   
/*     */   public PlotGrowthRecord() {}
/*     */   
/*     */   public PlotGrowthRecord(RecordInputStream paramRecordInputStream) {
/*  41 */     this.field_1_horizontalScale = paramRecordInputStream.readInt();
/*  42 */     this.field_2_verticalScale = paramRecordInputStream.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  48 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  50 */     stringBuffer.append("[PLOTGROWTH]\n");
/*  51 */     stringBuffer.append("    .horizontalScale      = ").append("0x").append(HexDump.toHex(getHorizontalScale())).append(" (").append(getHorizontalScale()).append(" )");
/*     */ 
/*     */     
/*  54 */     stringBuffer.append(System.getProperty("line.separator"));
/*  55 */     stringBuffer.append("    .verticalScale        = ").append("0x").append(HexDump.toHex(getVerticalScale())).append(" (").append(getVerticalScale()).append(" )");
/*     */ 
/*     */     
/*  58 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  60 */     stringBuffer.append("[/PLOTGROWTH]\n");
/*  61 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  65 */     paramLittleEndianOutput.writeInt(this.field_1_horizontalScale);
/*  66 */     paramLittleEndianOutput.writeInt(this.field_2_verticalScale);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  70 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  75 */     return 4196;
/*     */   }
/*     */   
/*     */   public Object clone() {
/*  79 */     PlotGrowthRecord plotGrowthRecord = new PlotGrowthRecord();
/*     */     
/*  81 */     plotGrowthRecord.field_1_horizontalScale = this.field_1_horizontalScale;
/*  82 */     plotGrowthRecord.field_2_verticalScale = this.field_2_verticalScale;
/*  83 */     return plotGrowthRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHorizontalScale() {
/*  94 */     return this.field_1_horizontalScale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontalScale(int paramInt) {
/* 102 */     this.field_1_horizontalScale = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVerticalScale() {
/* 110 */     return this.field_2_verticalScale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalScale(int paramInt) {
/* 118 */     this.field_2_verticalScale = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\PlotGrowthRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */