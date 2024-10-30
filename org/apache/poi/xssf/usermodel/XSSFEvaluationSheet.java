/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationSheet;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.util.Internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ final class XSSFEvaluationSheet
/*     */   implements EvaluationSheet
/*     */ {
/*     */   private final XSSFSheet _xs;
/*     */   private Map<CellKey, EvaluationCell> _cellCache;
/*     */   
/*     */   public XSSFEvaluationSheet(XSSFSheet paramXSSFSheet) {
/*  39 */     this._xs = paramXSSFSheet;
/*     */   }
/*     */   
/*     */   public XSSFSheet getXSSFSheet() {
/*  43 */     return this._xs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAllCachedResultValues() {
/*  51 */     this._cellCache = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EvaluationCell getCell(int paramInt1, int paramInt2) {
/*  57 */     if (this._cellCache == null) {
/*  58 */       this._cellCache = new HashMap<CellKey, EvaluationCell>(this._xs.getLastRowNum() * 3);
/*  59 */       for (Row row : this._xs) {
/*  60 */         int i = row.getRowNum();
/*  61 */         for (Cell cell : row) {
/*     */           
/*  63 */           CellKey cellKey1 = new CellKey(i, cell.getColumnIndex());
/*  64 */           XSSFEvaluationCell xSSFEvaluationCell = new XSSFEvaluationCell((XSSFCell)cell, this);
/*  65 */           this._cellCache.put(cellKey1, xSSFEvaluationCell);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  70 */     CellKey cellKey = new CellKey(paramInt1, paramInt2);
/*  71 */     EvaluationCell evaluationCell = this._cellCache.get(cellKey);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     if (evaluationCell == null) {
/*  79 */       XSSFRow xSSFRow = this._xs.getRow(paramInt1);
/*  80 */       if (xSSFRow == null) {
/*  81 */         return null;
/*     */       }
/*  83 */       XSSFCell xSSFCell = xSSFRow.getCell(paramInt2);
/*  84 */       if (xSSFCell == null) {
/*  85 */         return null;
/*     */       }
/*  87 */       evaluationCell = new XSSFEvaluationCell(xSSFCell, this);
/*  88 */       this._cellCache.put(cellKey, evaluationCell);
/*     */     } 
/*     */     
/*  91 */     return evaluationCell;
/*     */   }
/*     */   
/*     */   private static class CellKey {
/*     */     private final int _row;
/*     */     private final int _col;
/*  97 */     private int _hash = -1;
/*     */     
/*     */     protected CellKey(int param1Int1, int param1Int2) {
/* 100 */       this._row = param1Int1;
/* 101 */       this._col = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 106 */       if (this._hash == -1) {
/* 107 */         this._hash = (629 + this._row) * 37 + this._col;
/*     */       }
/* 109 */       return this._hash;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 114 */       if (!(param1Object instanceof CellKey)) {
/* 115 */         return false;
/*     */       }
/*     */       
/* 118 */       CellKey cellKey = (CellKey)param1Object;
/* 119 */       return (this._row == cellKey._row && this._col == cellKey._col);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFEvaluationSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */