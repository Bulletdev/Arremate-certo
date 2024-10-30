/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import java.util.HashMap;
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
/*    */ final class PlainCellCache
/*    */ {
/*    */   private Map<Loc, PlainValueCellCacheEntry> _plainValueEntriesByLoc;
/*    */   
/*    */   public static final class Loc
/*    */   {
/*    */     private final long _bookSheetColumn;
/*    */     private final int _rowIndex;
/*    */     
/*    */     public Loc(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 36 */       this._bookSheetColumn = toBookSheetColumn(param1Int1, param1Int2, param1Int4);
/* 37 */       this._rowIndex = param1Int3;
/*    */     }
/*    */     
/*    */     public static long toBookSheetColumn(int param1Int1, int param1Int2, int param1Int3) {
/* 41 */       return ((param1Int1 & 0xFFFFL) << 48L) + ((param1Int2 & 0xFFFFL) << 32L) + ((param1Int3 & 0xFFFFL) << 0L);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Loc(long param1Long, int param1Int) {
/* 47 */       this._bookSheetColumn = param1Long;
/* 48 */       this._rowIndex = param1Int;
/*    */     }
/*    */     
/*    */     public int hashCode() {
/* 52 */       return (int)(this._bookSheetColumn ^ this._bookSheetColumn >>> 32L) + 17 * this._rowIndex;
/*    */     }
/*    */     
/*    */     public boolean equals(Object param1Object) {
/* 56 */       assert param1Object instanceof Loc : "these package-private cache key instances are only compared to themselves";
/* 57 */       Loc loc = (Loc)param1Object;
/* 58 */       return (this._bookSheetColumn == loc._bookSheetColumn && this._rowIndex == loc._rowIndex);
/*    */     }
/*    */     
/*    */     public int getRowIndex() {
/* 62 */       return this._rowIndex;
/*    */     }
/*    */     
/*    */     public int getColumnIndex() {
/* 66 */       return (int)(this._bookSheetColumn & 0xFFFFL);
/*    */     }
/*    */     
/*    */     public int getSheetIndex() {
/* 70 */       return (int)(this._bookSheetColumn >> 32L & 0xFFFFL);
/*    */     }
/*    */     
/*    */     public int getBookIndex() {
/* 74 */       return (int)(this._bookSheetColumn >> 48L & 0xFFFFL);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PlainCellCache() {
/* 81 */     this._plainValueEntriesByLoc = new HashMap<Loc, PlainValueCellCacheEntry>();
/*    */   }
/*    */   public void put(Loc paramLoc, PlainValueCellCacheEntry paramPlainValueCellCacheEntry) {
/* 84 */     this._plainValueEntriesByLoc.put(paramLoc, paramPlainValueCellCacheEntry);
/*    */   }
/*    */   public void clear() {
/* 87 */     this._plainValueEntriesByLoc.clear();
/*    */   }
/*    */   public PlainValueCellCacheEntry get(Loc paramLoc) {
/* 90 */     return this._plainValueEntriesByLoc.get(paramLoc);
/*    */   }
/*    */   public void remove(Loc paramLoc) {
/* 93 */     this._plainValueEntriesByLoc.remove(paramLoc);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\PlainCellCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */