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
/*    */ public final class UncalcedRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 94;
/*    */   private short _reserved;
/*    */   
/*    */   public UncalcedRecord() {
/* 36 */     this._reserved = 0;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 40 */     return 94;
/*    */   }
/*    */   
/*    */   public UncalcedRecord(RecordInputStream paramRecordInputStream) {
/* 44 */     this._reserved = paramRecordInputStream.readShort();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 48 */     StringBuffer stringBuffer = new StringBuffer();
/* 49 */     stringBuffer.append("[UNCALCED]\n");
/* 50 */     stringBuffer.append("    _reserved: ").append(this._reserved).append('\n');
/* 51 */     stringBuffer.append("[/UNCALCED]\n");
/* 52 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 56 */     paramLittleEndianOutput.writeShort(this._reserved);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 60 */     return 2;
/*    */   }
/*    */   
/*    */   public static int getStaticRecordSize() {
/* 64 */     return 6;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\UncalcedRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */