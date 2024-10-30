/*    */ package org.apache.poi.hssf.record.cont;
/*    */ 
/*    */ import org.apache.poi.hssf.record.Record;
/*    */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ContinuableRecord
/*    */   extends Record
/*    */ {
/*    */   protected abstract void serialize(ContinuableRecordOutput paramContinuableRecordOutput);
/*    */   
/*    */   public final int getRecordSize() {
/* 53 */     ContinuableRecordOutput continuableRecordOutput = ContinuableRecordOutput.createForCountingOnly();
/* 54 */     serialize(continuableRecordOutput);
/* 55 */     continuableRecordOutput.terminate();
/* 56 */     return continuableRecordOutput.getTotalSize();
/*    */   }
/*    */ 
/*    */   
/*    */   public final int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 61 */     LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(paramArrayOfbyte, paramInt);
/* 62 */     ContinuableRecordOutput continuableRecordOutput = new ContinuableRecordOutput((LittleEndianOutput)littleEndianByteArrayOutputStream, getSid());
/* 63 */     serialize(continuableRecordOutput);
/* 64 */     continuableRecordOutput.terminate();
/* 65 */     return continuableRecordOutput.getTotalSize();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cont\ContinuableRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */