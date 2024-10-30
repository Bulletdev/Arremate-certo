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
/*    */ public final class SeriesIndexRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 4197;
/*    */   private short field_1_index;
/*    */   
/*    */   public SeriesIndexRecord() {}
/*    */   
/*    */   public SeriesIndexRecord(RecordInputStream paramRecordInputStream) {
/* 40 */     this.field_1_index = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 45 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 47 */     stringBuffer.append("[SINDEX]\n");
/* 48 */     stringBuffer.append("    .index                = ").append("0x").append(HexDump.toHex(getIndex())).append(" (").append(getIndex()).append(" )");
/*    */ 
/*    */     
/* 51 */     stringBuffer.append(System.getProperty("line.separator"));
/*    */     
/* 53 */     stringBuffer.append("[/SINDEX]\n");
/* 54 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 58 */     paramLittleEndianOutput.writeShort(this.field_1_index);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 62 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 67 */     return 4197;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 71 */     SeriesIndexRecord seriesIndexRecord = new SeriesIndexRecord();
/*    */     
/* 73 */     seriesIndexRecord.field_1_index = this.field_1_index;
/* 74 */     return seriesIndexRecord;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getIndex() {
/* 85 */     return this.field_1_index;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIndex(short paramShort) {
/* 93 */     this.field_1_index = paramShort;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\SeriesIndexRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */