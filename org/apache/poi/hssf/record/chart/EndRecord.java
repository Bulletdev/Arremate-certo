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
/*    */ 
/*    */ 
/*    */ public final class EndRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 4148;
/*    */   
/*    */   public EndRecord() {}
/*    */   
/*    */   public EndRecord(RecordInputStream paramRecordInputStream) {}
/*    */   
/*    */   public String toString() {
/* 49 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 51 */     stringBuffer.append("[END]\n");
/* 52 */     stringBuffer.append("[/END]\n");
/* 53 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {}
/*    */   
/*    */   protected int getDataSize() {
/* 60 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 65 */     return 4148;
/*    */   }
/*    */ 
/*    */   
/*    */   public EndRecord clone() {
/* 70 */     return new EndRecord();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\EndRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */