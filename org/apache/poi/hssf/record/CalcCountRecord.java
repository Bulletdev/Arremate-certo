/*    */ package org.apache.poi.hssf.record;
/*    */ 
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
/*    */ public final class CalcCountRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 12;
/*    */   private short field_1_iterations;
/*    */   
/*    */   public CalcCountRecord() {}
/*    */   
/*    */   public CalcCountRecord(RecordInputStream paramRecordInputStream) {
/* 46 */     this.field_1_iterations = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIterations(short paramShort) {
/* 56 */     this.field_1_iterations = paramShort;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getIterations() {
/* 66 */     return this.field_1_iterations;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 73 */     stringBuffer.append("[CALCCOUNT]\n");
/* 74 */     stringBuffer.append("    .iterations     = ").append(Integer.toHexString(getIterations())).append("\n");
/*    */     
/* 76 */     stringBuffer.append("[/CALCCOUNT]\n");
/* 77 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 81 */     paramLittleEndianOutput.writeShort(getIterations());
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 85 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 90 */     return 12;
/*    */   }
/*    */ 
/*    */   
/*    */   public CalcCountRecord clone() {
/* 95 */     CalcCountRecord calcCountRecord = new CalcCountRecord();
/* 96 */     calcCountRecord.field_1_iterations = this.field_1_iterations;
/* 97 */     return calcCountRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CalcCountRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */