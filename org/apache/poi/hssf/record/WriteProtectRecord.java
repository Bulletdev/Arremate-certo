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
/*    */ public final class WriteProtectRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 134;
/*    */   
/*    */   public WriteProtectRecord() {}
/*    */   
/*    */   public WriteProtectRecord(RecordInputStream paramRecordInputStream) {}
/*    */   
/*    */   public String toString() {
/* 44 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 46 */     stringBuffer.append("[WRITEPROTECT]\n");
/* 47 */     stringBuffer.append("[/WRITEPROTECT]\n");
/* 48 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {}
/*    */   
/*    */   protected int getDataSize() {
/* 55 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 60 */     return 134;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\WriteProtectRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */