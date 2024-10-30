/*     */ package org.apache.poi.ss;
/*     */ 
/*     */ import org.apache.poi.ss.util.CellReference;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum SpreadsheetVersion
/*     */ {
/*  39 */   EXCEL97(65536, 256, 30, 3, 4000, 32767),
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
/*  54 */   EXCEL2007(1048576, 16384, 255, 2147483647, 64000, 32767);
/*     */   
/*     */   private final int _maxRows;
/*     */   private final int _maxColumns;
/*     */   private final int _maxFunctionArgs;
/*     */   private final int _maxCondFormats;
/*     */   private final int _maxCellStyles;
/*     */   private final int _maxTextLength;
/*     */   
/*     */   SpreadsheetVersion(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  64 */     this._maxRows = paramInt1;
/*  65 */     this._maxColumns = paramInt2;
/*  66 */     this._maxFunctionArgs = paramInt3;
/*  67 */     this._maxCondFormats = paramInt4;
/*  68 */     this._maxCellStyles = paramInt5;
/*  69 */     this._maxTextLength = paramInt6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxRows() {
/*  76 */     return this._maxRows;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastRowIndex() {
/*  83 */     return this._maxRows - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxColumns() {
/*  90 */     return this._maxColumns;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastColumnIndex() {
/*  97 */     return this._maxColumns - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxFunctionArgs() {
/* 104 */     return this._maxFunctionArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxConditionalFormats() {
/* 111 */     return this._maxCondFormats;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxCellStyles() {
/* 118 */     return this._maxCellStyles;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLastColumnName() {
/* 127 */     return CellReference.convertNumToColString(getLastColumnIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxTextLength() {
/* 134 */     return this._maxTextLength;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\SpreadsheetVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */