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
/*    */ 
/*    */ 
/*    */ public final class SeriesToChartGroupRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 4165;
/*    */   private short field_1_chartGroupIndex;
/*    */   
/*    */   public SeriesToChartGroupRecord() {}
/*    */   
/*    */   public SeriesToChartGroupRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     this.field_1_chartGroupIndex = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 49 */     stringBuffer.append("[SeriesToChartGroup]\n");
/* 50 */     stringBuffer.append("    .chartGroupIndex      = ").append("0x").append(HexDump.toHex(getChartGroupIndex())).append(" (").append(getChartGroupIndex()).append(" )");
/*    */ 
/*    */     
/* 53 */     stringBuffer.append(System.getProperty("line.separator"));
/*    */     
/* 55 */     stringBuffer.append("[/SeriesToChartGroup]\n");
/* 56 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 60 */     paramLittleEndianOutput.writeShort(this.field_1_chartGroupIndex);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 64 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 69 */     return 4165;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 73 */     SeriesToChartGroupRecord seriesToChartGroupRecord = new SeriesToChartGroupRecord();
/*    */     
/* 75 */     seriesToChartGroupRecord.field_1_chartGroupIndex = this.field_1_chartGroupIndex;
/* 76 */     return seriesToChartGroupRecord;
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
/* 87 */     return this.field_1_chartGroupIndex;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setChartGroupIndex(short paramShort) {
/* 95 */     this.field_1_chartGroupIndex = paramShort;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\SeriesToChartGroupRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */