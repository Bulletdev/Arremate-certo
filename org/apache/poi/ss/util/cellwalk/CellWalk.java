/*     */ package org.apache.poi.ss.util.cellwalk;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CellWalk
/*     */ {
/*     */   private Sheet sheet;
/*     */   private CellRangeAddress range;
/*     */   private boolean traverseEmptyCells;
/*     */   
/*     */   public CellWalk(Sheet paramSheet, CellRangeAddress paramCellRangeAddress) {
/*  39 */     this.sheet = paramSheet;
/*  40 */     this.range = paramCellRangeAddress;
/*  41 */     this.traverseEmptyCells = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTraverseEmptyCells() {
/*  52 */     return this.traverseEmptyCells;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTraverseEmptyCells(boolean paramBoolean) {
/*  61 */     this.traverseEmptyCells = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void traverse(CellHandler paramCellHandler) {
/*  70 */     int i = this.range.getFirstRow();
/*  71 */     int j = this.range.getLastRow();
/*  72 */     int k = this.range.getFirstColumn();
/*  73 */     int m = this.range.getLastColumn();
/*  74 */     int n = m - k + 1;
/*  75 */     SimpleCellWalkContext simpleCellWalkContext = new SimpleCellWalkContext();
/*  76 */     Row row = null;
/*  77 */     Cell cell = null;
/*     */     
/*  79 */     for (simpleCellWalkContext.rowNumber = i; simpleCellWalkContext.rowNumber <= j; simpleCellWalkContext.rowNumber++) {
/*  80 */       row = this.sheet.getRow(simpleCellWalkContext.rowNumber);
/*  81 */       if (row != null)
/*     */       {
/*     */         
/*  84 */         for (simpleCellWalkContext.colNumber = k; simpleCellWalkContext.colNumber <= m; simpleCellWalkContext.colNumber++) {
/*  85 */           cell = row.getCell(simpleCellWalkContext.colNumber);
/*     */           
/*  87 */           if (cell != null)
/*     */           {
/*     */             
/*  90 */             if (!isEmpty(cell) || this.traverseEmptyCells) {
/*     */ 
/*     */ 
/*     */               
/*  94 */               simpleCellWalkContext.ordinalNumber = ((simpleCellWalkContext.rowNumber - i) * n + simpleCellWalkContext.colNumber - k + 1);
/*     */ 
/*     */ 
/*     */               
/*  98 */               paramCellHandler.onCell(cell, simpleCellWalkContext);
/*     */             }  } 
/*     */         }  } 
/*     */     } 
/*     */   }
/*     */   private boolean isEmpty(Cell paramCell) {
/* 104 */     return (paramCell.getCellTypeEnum() == CellType.BLANK);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class SimpleCellWalkContext
/*     */     implements CellWalkContext
/*     */   {
/* 113 */     public long ordinalNumber = 0L;
/* 114 */     public int rowNumber = 0;
/* 115 */     public int colNumber = 0;
/*     */     
/*     */     public long getOrdinalNumber() {
/* 118 */       return this.ordinalNumber;
/*     */     }
/*     */     
/*     */     public int getRowNumber() {
/* 122 */       return this.rowNumber;
/*     */     }
/*     */     
/*     */     public int getColumnNumber() {
/* 126 */       return this.colNumber;
/*     */     }
/*     */     
/*     */     private SimpleCellWalkContext() {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\cellwalk\CellWalk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */