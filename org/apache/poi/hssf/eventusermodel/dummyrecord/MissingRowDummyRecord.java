/*    */ package org.apache.poi.hssf.eventusermodel.dummyrecord;
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
/*    */ public final class MissingRowDummyRecord
/*    */   extends DummyRecordBase
/*    */ {
/*    */   private int rowNumber;
/*    */   
/*    */   public MissingRowDummyRecord(int paramInt) {
/* 29 */     this.rowNumber = paramInt;
/*    */   }
/*    */   public int getRowNumber() {
/* 32 */     return this.rowNumber;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\dummyrecord\MissingRowDummyRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */