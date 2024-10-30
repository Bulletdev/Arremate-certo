/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.CellValue;
/*     */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
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
/*     */ public abstract class BaseFormulaEvaluator
/*     */   implements WorkbookEvaluatorProvider, FormulaEvaluator
/*     */ {
/*     */   protected final WorkbookEvaluator _bookEvaluator;
/*     */   
/*     */   protected BaseFormulaEvaluator(WorkbookEvaluator paramWorkbookEvaluator) {
/*  38 */     this._bookEvaluator = paramWorkbookEvaluator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setupEnvironment(String[] paramArrayOfString, BaseFormulaEvaluator[] paramArrayOfBaseFormulaEvaluator) {
/*  49 */     WorkbookEvaluator[] arrayOfWorkbookEvaluator = new WorkbookEvaluator[paramArrayOfBaseFormulaEvaluator.length];
/*  50 */     for (byte b = 0; b < arrayOfWorkbookEvaluator.length; b++) {
/*  51 */       arrayOfWorkbookEvaluator[b] = (paramArrayOfBaseFormulaEvaluator[b])._bookEvaluator;
/*     */     }
/*  53 */     CollaboratingWorkbooksEnvironment.setup(paramArrayOfString, arrayOfWorkbookEvaluator);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> paramMap) {
/*  58 */     CollaboratingWorkbooksEnvironment.setupFormulaEvaluator(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public WorkbookEvaluator _getWorkbookEvaluator() {
/*  63 */     return this._bookEvaluator;
/*     */   }
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
/*     */   public void clearAllCachedResultValues() {
/*  76 */     this._bookEvaluator.clearAllCachedResultValues();
/*     */   }
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
/*     */   public CellValue evaluate(Cell paramCell) {
/*  91 */     if (paramCell == null) {
/*  92 */       return null;
/*     */     }
/*     */     
/*  95 */     switch (paramCell.getCellTypeEnum()) {
/*     */       case BOOLEAN:
/*  97 */         return CellValue.valueOf(paramCell.getBooleanCellValue());
/*     */       case ERROR:
/*  99 */         return CellValue.getError(paramCell.getErrorCellValue());
/*     */       case FORMULA:
/* 101 */         return evaluateFormulaCellValue(paramCell);
/*     */       case NUMERIC:
/* 103 */         return new CellValue(paramCell.getNumericCellValue());
/*     */       case STRING:
/* 105 */         return new CellValue(paramCell.getRichStringCellValue().getString());
/*     */       case BLANK:
/* 107 */         return null;
/*     */     } 
/* 109 */     throw new IllegalStateException("Bad cell type (" + paramCell.getCellTypeEnum() + ")");
/*     */   }
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
/*     */   public Cell evaluateInCell(Cell paramCell) {
/* 132 */     if (paramCell == null) {
/* 133 */       return null;
/*     */     }
/* 135 */     Cell cell = paramCell;
/* 136 */     if (paramCell.getCellTypeEnum() == CellType.FORMULA) {
/* 137 */       CellValue cellValue = evaluateFormulaCellValue(paramCell);
/* 138 */       setCellValue(paramCell, cellValue);
/* 139 */       setCellType(paramCell, cellValue);
/*     */     } 
/* 141 */     return cell;
/*     */   }
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
/*     */   protected abstract CellValue evaluateFormulaCellValue(Cell paramCell);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int evaluateFormulaCell(Cell paramCell) {
/* 164 */     return evaluateFormulaCellEnum(paramCell).getCode();
/*     */   }
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
/*     */   public CellType evaluateFormulaCellEnum(Cell paramCell) {
/* 190 */     if (paramCell == null || paramCell.getCellTypeEnum() != CellType.FORMULA) {
/* 191 */       return CellType._NONE;
/*     */     }
/* 193 */     CellValue cellValue = evaluateFormulaCellValue(paramCell);
/*     */     
/* 195 */     setCellValue(paramCell, cellValue);
/* 196 */     return cellValue.getCellTypeEnum();
/*     */   }
/*     */   
/*     */   protected static void setCellType(Cell paramCell, CellValue paramCellValue) {
/* 200 */     CellType cellType = paramCellValue.getCellTypeEnum();
/* 201 */     switch (cellType) {
/*     */       case BOOLEAN:
/*     */       case ERROR:
/*     */       case NUMERIC:
/*     */       case STRING:
/* 206 */         paramCell.setCellType(cellType);
/*     */         return;
/*     */       
/*     */       case BLANK:
/* 210 */         throw new IllegalArgumentException("This should never happen. Blanks eventually get translated to zero.");
/*     */       
/*     */       case FORMULA:
/* 213 */         throw new IllegalArgumentException("This should never happen. Formulas should have already been evaluated.");
/*     */     } 
/* 215 */     throw new IllegalStateException("Unexpected cell value type (" + cellType + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract RichTextString createRichTextString(String paramString);
/*     */   
/*     */   protected void setCellValue(Cell paramCell, CellValue paramCellValue) {
/* 222 */     CellType cellType = paramCellValue.getCellTypeEnum();
/* 223 */     switch (cellType) {
/*     */       case BOOLEAN:
/* 225 */         paramCell.setCellValue(paramCellValue.getBooleanValue());
/*     */         return;
/*     */       case ERROR:
/* 228 */         paramCell.setCellErrorValue(paramCellValue.getErrorValue());
/*     */         return;
/*     */       case NUMERIC:
/* 231 */         paramCell.setCellValue(paramCellValue.getNumberValue());
/*     */         return;
/*     */       case STRING:
/* 234 */         paramCell.setCellValue(createRichTextString(paramCellValue.getStringValue()));
/*     */         return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     throw new IllegalStateException("Unexpected cell value type (" + cellType + ")");
/*     */   }
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
/*     */   public static void evaluateAllFormulaCells(Workbook paramWorkbook) {
/* 258 */     FormulaEvaluator formulaEvaluator = paramWorkbook.getCreationHelper().createFormulaEvaluator();
/* 259 */     evaluateAllFormulaCells(paramWorkbook, formulaEvaluator);
/*     */   }
/*     */   protected static void evaluateAllFormulaCells(Workbook paramWorkbook, FormulaEvaluator paramFormulaEvaluator) {
/* 262 */     for (byte b = 0; b < paramWorkbook.getNumberOfSheets(); b++) {
/* 263 */       Sheet sheet = paramWorkbook.getSheetAt(b);
/*     */       
/* 265 */       for (Row row : sheet) {
/* 266 */         for (Cell cell : row) {
/* 267 */           if (cell.getCellTypeEnum() == CellType.FORMULA) {
/* 268 */             paramFormulaEvaluator.evaluateFormulaCellEnum(cell);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIgnoreMissingWorkbooks(boolean paramBoolean) {
/* 278 */     this._bookEvaluator.setIgnoreMissingWorkbooks(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugEvaluationOutputForNextEval(boolean paramBoolean) {
/* 284 */     this._bookEvaluator.setDebugEvaluationOutputForNextEval(paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\BaseFormulaEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */