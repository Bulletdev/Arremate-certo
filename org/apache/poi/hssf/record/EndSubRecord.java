/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianInput;
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
/*    */ public final class EndSubRecord
/*    */   extends SubRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 0;
/*    */   private static final int ENCODED_SIZE = 0;
/*    */   
/*    */   public EndSubRecord() {}
/*    */   
/*    */   public EndSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/* 43 */     if ((paramInt & 0xFF) != 0) {
/* 44 */       throw new RecordFormatException("Unexpected size (" + paramInt + ")");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTerminating() {
/* 50 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 57 */     stringBuffer.append("[ftEnd]\n");
/*    */     
/* 59 */     stringBuffer.append("[/ftEnd]\n");
/* 60 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 64 */     paramLittleEndianOutput.writeShort(0);
/* 65 */     paramLittleEndianOutput.writeShort(0);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 69 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 74 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public EndSubRecord clone() {
/* 79 */     return new EndSubRecord();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\EndSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */