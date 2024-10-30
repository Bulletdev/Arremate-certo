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
/*    */ public final class InterfaceEndRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 226;
/* 32 */   public static final InterfaceEndRecord instance = new InterfaceEndRecord();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Record create(RecordInputStream paramRecordInputStream) {
/* 39 */     switch (paramRecordInputStream.remaining()) {
/*    */       case 0:
/* 41 */         return instance;
/*    */       case 2:
/* 43 */         return new InterfaceHdrRecord(paramRecordInputStream);
/*    */     } 
/* 45 */     throw new RecordFormatException("Invalid record data size: " + paramRecordInputStream.remaining());
/*    */   }
/*    */   
/*    */   public String toString() {
/* 49 */     return "[INTERFACEEND/]\n";
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {}
/*    */ 
/*    */   
/*    */   protected int getDataSize() {
/* 57 */     return 0;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 61 */     return 226;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\InterfaceEndRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */