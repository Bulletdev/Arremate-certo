/*    */ package org.apache.poi.hssf.record.chart;
/*    */ 
/*    */ import org.apache.poi.hssf.record.RecordInputStream;
/*    */ import org.apache.poi.hssf.record.StandardRecord;
/*    */ import org.apache.poi.util.HexDump;
/*    */ import org.apache.poi.util.LittleEndianOutput;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SeriesChartGroupIndexRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 4165;
/*    */   private short field_1_chartGroupIndex;
/*    */   
/*    */   public SeriesChartGroupIndexRecord() {}
/*    */   
/*    */   public SeriesChartGroupIndexRecord(RecordInputStream paramRecordInputStream) {
/* 40 */     this.field_1_chartGroupIndex = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 45 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 47 */     stringBuffer.append("[SERTOCRT]\n");
/* 48 */     stringBuffer.append("    .chartGroupIndex      = ").append("0x").append(HexDump.toHex(getChartGroupIndex())).append(" (").append(getChartGroupIndex()).append(" )");
/*    */ 
/*    */     
/* 51 */     stringBuffer.append(System.getProperty("line.separator"));
/*    */     
/* 53 */     stringBuffer.append("[/SERTOCRT]\n");
/* 54 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 58 */     paramLittleEndianOutput.writeShort(this.field_1_chartGroupIndex);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 62 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 67 */     return 4165;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 71 */     SeriesChartGroupIndexRecord seriesChartGroupIndexRecord = new SeriesChartGroupIndexRecord();
/*    */     
/* 73 */     seriesChartGroupIndexRecord.field_1_chartGroupIndex = this.field_1_chartGroupIndex;
/* 74 */     return seriesChartGroupIndexRecord;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getChartGroupIndex() {
/* 85 */     return this.field_1_chartGroupIndex;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setChartGroupIndex(short paramShort) {
/* 93 */     this.field_1_chartGroupIndex = paramShort;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\SeriesChartGroupIndexRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */