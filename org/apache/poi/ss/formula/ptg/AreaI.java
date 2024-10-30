/*    */ package org.apache.poi.ss.formula.ptg;
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
/*    */ public interface AreaI
/*    */ {
/*    */   int getFirstRow();
/*    */   
/*    */   int getLastRow();
/*    */   
/*    */   int getFirstColumn();
/*    */   
/*    */   int getLastColumn();
/*    */   
/*    */   public static class OffsetArea
/*    */     implements AreaI
/*    */   {
/*    */     private final int _firstColumn;
/*    */     private final int _firstRow;
/*    */     private final int _lastColumn;
/*    */     private final int _lastRow;
/*    */     
/*    */     public OffsetArea(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6) {
/* 53 */       this._firstRow = param1Int1 + Math.min(param1Int3, param1Int4);
/* 54 */       this._lastRow = param1Int1 + Math.max(param1Int3, param1Int4);
/* 55 */       this._firstColumn = param1Int2 + Math.min(param1Int5, param1Int6);
/* 56 */       this._lastColumn = param1Int2 + Math.max(param1Int5, param1Int6);
/*    */     }
/*    */     
/*    */     public int getFirstColumn() {
/* 60 */       return this._firstColumn;
/*    */     }
/*    */     
/*    */     public int getFirstRow() {
/* 64 */       return this._firstRow;
/*    */     }
/*    */     
/*    */     public int getLastColumn() {
/* 68 */       return this._lastColumn;
/*    */     }
/*    */     
/*    */     public int getLastRow() {
/* 72 */       return this._lastRow;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\AreaI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */