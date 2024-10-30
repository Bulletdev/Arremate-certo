/*    */ package org.apache.poi.hssf.record.chart;
/*    */ 
/*    */ import org.apache.poi.hssf.record.RecordInputStream;
/*    */ import org.apache.poi.hssf.record.StandardRecord;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class PlotAreaRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 4149;
/*    */   
/*    */   public PlotAreaRecord() {}
/*    */   
/*    */   public PlotAreaRecord(RecordInputStream paramRecordInputStream) {}
/*    */   
/*    */   public String toString() {
/* 46 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 48 */     stringBuffer.append("[PLOTAREA]\n");
/*    */     
/* 50 */     stringBuffer.append("[/PLOTAREA]\n");
/* 51 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {}
/*    */   
/*    */   protected int getDataSize() {
/* 58 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 63 */     return 4149;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 67 */     return new PlotAreaRecord();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\PlotAreaRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */