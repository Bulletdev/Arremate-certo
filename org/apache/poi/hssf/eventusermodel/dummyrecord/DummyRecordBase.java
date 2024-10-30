/*    */ package org.apache.poi.hssf.eventusermodel.dummyrecord;
/*    */ 
/*    */ import org.apache.poi.hssf.record.Record;
/*    */ import org.apache.poi.hssf.record.RecordFormatException;
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
/*    */ abstract class DummyRecordBase
/*    */   extends Record
/*    */ {
/*    */   public final short getSid() {
/* 32 */     return -1;
/*    */   }
/*    */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 35 */     throw new RecordFormatException("Cannot serialize a dummy record");
/*    */   }
/*    */   public final int getRecordSize() {
/* 38 */     throw new RecordFormatException("Cannot serialize a dummy record");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\dummyrecord\DummyRecordBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */