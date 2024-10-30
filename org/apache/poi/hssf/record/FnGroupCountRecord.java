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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FnGroupCountRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 156;
/*    */   public static final short COUNT = 14;
/*    */   private short field_1_count;
/*    */   
/*    */   public FnGroupCountRecord() {}
/*    */   
/*    */   public FnGroupCountRecord(RecordInputStream paramRecordInputStream) {
/* 51 */     this.field_1_count = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCount(short paramShort) {
/* 62 */     this.field_1_count = paramShort;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getCount() {
/* 73 */     return this.field_1_count;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 80 */     stringBuffer.append("[FNGROUPCOUNT]\n");
/* 81 */     stringBuffer.append("    .count            = ").append(getCount()).append("\n");
/*    */     
/* 83 */     stringBuffer.append("[/FNGROUPCOUNT]\n");
/* 84 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 88 */     paramLittleEndianOutput.writeShort(getCount());
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 92 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 97 */     return 156;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FnGroupCountRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */