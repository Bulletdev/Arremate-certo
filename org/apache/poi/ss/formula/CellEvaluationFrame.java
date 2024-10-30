/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*    */ final class CellEvaluationFrame
/*    */ {
/*    */   private final FormulaCellCacheEntry _cce;
/*    */   private final Set<CellCacheEntry> _sensitiveInputCells;
/*    */   private FormulaUsedBlankCellSet _usedBlankCellGroup;
/*    */   
/*    */   public CellEvaluationFrame(FormulaCellCacheEntry paramFormulaCellCacheEntry) {
/* 35 */     this._cce = paramFormulaCellCacheEntry;
/* 36 */     this._sensitiveInputCells = new HashSet<CellCacheEntry>();
/*    */   }
/*    */   public CellCacheEntry getCCE() {
/* 39 */     return this._cce;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 43 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 44 */     stringBuffer.append(getClass().getName()).append(" [");
/* 45 */     stringBuffer.append("]");
/* 46 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addSensitiveInputCell(CellCacheEntry paramCellCacheEntry) {
/* 52 */     this._sensitiveInputCells.add(paramCellCacheEntry);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private CellCacheEntry[] getSensitiveInputCells() {
/* 59 */     int i = this._sensitiveInputCells.size();
/* 60 */     if (i < 1) {
/* 61 */       return CellCacheEntry.EMPTY_ARRAY;
/*    */     }
/* 63 */     CellCacheEntry[] arrayOfCellCacheEntry = new CellCacheEntry[i];
/* 64 */     this._sensitiveInputCells.toArray(arrayOfCellCacheEntry);
/* 65 */     return arrayOfCellCacheEntry;
/*    */   }
/*    */   public void addUsedBlankCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 68 */     if (this._usedBlankCellGroup == null) {
/* 69 */       this._usedBlankCellGroup = new FormulaUsedBlankCellSet();
/*    */     }
/* 71 */     this._usedBlankCellGroup.addCell(paramInt1, paramInt2, paramInt3, paramInt4);
/*    */   }
/*    */   
/*    */   public void updateFormulaResult(ValueEval paramValueEval) {
/* 75 */     this._cce.updateFormulaResult(paramValueEval, getSensitiveInputCells(), this._usedBlankCellGroup);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\CellEvaluationFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */