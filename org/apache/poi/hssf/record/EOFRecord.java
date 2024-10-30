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
/*    */ public final class EOFRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 10;
/*    */   public static final int ENCODED_SIZE = 4;
/* 36 */   public static final EOFRecord instance = new EOFRecord();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private EOFRecord() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EOFRecord(RecordInputStream paramRecordInputStream) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 53 */     stringBuffer.append("[EOF]\n");
/* 54 */     stringBuffer.append("[/EOF]\n");
/* 55 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {}
/*    */   
/*    */   protected int getDataSize() {
/* 62 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 67 */     return 10;
/*    */   }
/*    */ 
/*    */   
/*    */   public EOFRecord clone() {
/* 72 */     return instance;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\EOFRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */