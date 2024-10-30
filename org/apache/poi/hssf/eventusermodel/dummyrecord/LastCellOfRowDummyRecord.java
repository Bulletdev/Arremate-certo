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
/*    */ public final class LastCellOfRowDummyRecord
/*    */   extends DummyRecordBase
/*    */ {
/*    */   private final int row;
/*    */   private final int lastColumnNumber;
/*    */   
/*    */   public LastCellOfRowDummyRecord(int paramInt1, int paramInt2) {
/* 30 */     this.row = paramInt1;
/* 31 */     this.lastColumnNumber = paramInt2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRow() {
/* 41 */     return this.row;
/*    */   }
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
/*    */   public int getLastColumnNumber() {
/* 54 */     return this.lastColumnNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 59 */     return "End-of-Row for Row=" + this.row + " at Column=" + this.lastColumnNumber;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\dummyrecord\LastCellOfRowDummyRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */