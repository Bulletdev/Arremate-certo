/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
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
/*    */ final class FormulaCellCache
/*    */ {
/* 38 */   private final Map<Object, FormulaCellCacheEntry> _formulaEntriesByCell = new HashMap<Object, FormulaCellCacheEntry>();
/*    */ 
/*    */ 
/*    */   
/*    */   public CellCacheEntry[] getCacheEntries() {
/* 43 */     FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry = new FormulaCellCacheEntry[this._formulaEntriesByCell.size()];
/* 44 */     this._formulaEntriesByCell.values().toArray((Object[])arrayOfFormulaCellCacheEntry);
/* 45 */     return (CellCacheEntry[])arrayOfFormulaCellCacheEntry;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 49 */     this._formulaEntriesByCell.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FormulaCellCacheEntry get(EvaluationCell paramEvaluationCell) {
/* 56 */     return this._formulaEntriesByCell.get(paramEvaluationCell.getIdentityKey());
/*    */   }
/*    */   
/*    */   public void put(EvaluationCell paramEvaluationCell, FormulaCellCacheEntry paramFormulaCellCacheEntry) {
/* 60 */     this._formulaEntriesByCell.put(paramEvaluationCell.getIdentityKey(), paramFormulaCellCacheEntry);
/*    */   }
/*    */   
/*    */   public FormulaCellCacheEntry remove(EvaluationCell paramEvaluationCell) {
/* 64 */     return this._formulaEntriesByCell.remove(paramEvaluationCell.getIdentityKey());
/*    */   }
/*    */   
/*    */   public void applyOperation(IEntryOperation paramIEntryOperation) {
/* 68 */     Iterator<FormulaCellCacheEntry> iterator = this._formulaEntriesByCell.values().iterator();
/* 69 */     while (iterator.hasNext())
/* 70 */       paramIEntryOperation.processEntry(iterator.next()); 
/*    */   }
/*    */   
/*    */   static interface IEntryOperation {
/*    */     void processEntry(FormulaCellCacheEntry param1FormulaCellCacheEntry);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaCellCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */