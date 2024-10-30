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
/*    */ public final class BeginRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 4147;
/*    */   
/*    */   public BeginRecord() {}
/*    */   
/*    */   public BeginRecord(RecordInputStream paramRecordInputStream) {}
/*    */   
/*    */   public String toString() {
/* 48 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 50 */     stringBuffer.append("[BEGIN]\n");
/* 51 */     stringBuffer.append("[/BEGIN]\n");
/* 52 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {}
/*    */   
/*    */   protected int getDataSize() {
/* 59 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 64 */     return 4147;
/*    */   }
/*    */ 
/*    */   
/*    */   public BeginRecord clone() {
/* 69 */     return new BeginRecord();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\BeginRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */