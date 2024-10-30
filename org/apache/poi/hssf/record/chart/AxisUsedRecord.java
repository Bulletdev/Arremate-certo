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
/*    */ public final class AxisUsedRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 4166;
/*    */   private short field_1_numAxis;
/*    */   
/*    */   public AxisUsedRecord() {}
/*    */   
/*    */   public AxisUsedRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     this.field_1_numAxis = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 49 */     stringBuffer.append("[AXISUSED]\n");
/* 50 */     stringBuffer.append("    .numAxis              = ").append("0x").append(HexDump.toHex(getNumAxis())).append(" (").append(getNumAxis()).append(" )");
/*    */ 
/*    */     
/* 53 */     stringBuffer.append(System.getProperty("line.separator"));
/*    */     
/* 55 */     stringBuffer.append("[/AXISUSED]\n");
/* 56 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 60 */     paramLittleEndianOutput.writeShort(this.field_1_numAxis);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 64 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 69 */     return 4166;
/*    */   }
/*    */ 
/*    */   
/*    */   public AxisUsedRecord clone() {
/* 74 */     AxisUsedRecord axisUsedRecord = new AxisUsedRecord();
/*    */     
/* 76 */     axisUsedRecord.field_1_numAxis = this.field_1_numAxis;
/* 77 */     return axisUsedRecord;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getNumAxis() {
/* 88 */     return this.field_1_numAxis;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setNumAxis(short paramShort) {
/* 96 */     this.field_1_numAxis = paramShort;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\AxisUsedRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */