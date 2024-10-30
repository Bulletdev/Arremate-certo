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
/*    */ public final class MissingCellDummyRecord
/*    */   extends DummyRecordBase
/*    */ {
/*    */   private int row;
/*    */   private int column;
/*    */   
/*    */   public MissingCellDummyRecord(int paramInt1, int paramInt2) {
/* 30 */     this.row = paramInt1;
/* 31 */     this.column = paramInt2;
/*    */   }
/* 33 */   public int getRow() { return this.row; } public int getColumn() {
/* 34 */     return this.column;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\dummyrecord\MissingCellDummyRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */