/*     */ package org.apache.poi.xssf.streaming;
/*     */ 
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationWorkbook;
/*     */ import org.apache.poi.ss.formula.IStabilityClassifier;
/*     */ import org.apache.poi.ss.formula.WorkbookEvaluator;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator;
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
/*     */ public final class SXSSFFormulaEvaluator
/*     */   extends BaseXSSFFormulaEvaluator
/*     */ {
/*  37 */   private static POILogger logger = POILogFactory.getLogger(SXSSFFormulaEvaluator.class);
/*     */   
/*     */   private SXSSFWorkbook wb;
/*     */   
/*     */   public SXSSFFormulaEvaluator(SXSSFWorkbook paramSXSSFWorkbook) {
/*  42 */     this(paramSXSSFWorkbook, null, null);
/*     */   }
/*     */   private SXSSFFormulaEvaluator(SXSSFWorkbook paramSXSSFWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/*  45 */     this(paramSXSSFWorkbook, new WorkbookEvaluator((EvaluationWorkbook)SXSSFEvaluationWorkbook.create(paramSXSSFWorkbook), paramIStabilityClassifier, paramUDFFinder));
/*     */   }
/*     */   private SXSSFFormulaEvaluator(SXSSFWorkbook paramSXSSFWorkbook, WorkbookEvaluator paramWorkbookEvaluator) {
/*  48 */     super(paramWorkbookEvaluator);
/*  49 */     this.wb = paramSXSSFWorkbook;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SXSSFFormulaEvaluator create(SXSSFWorkbook paramSXSSFWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/*  59 */     return new SXSSFFormulaEvaluator(paramSXSSFWorkbook, paramIStabilityClassifier, paramUDFFinder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EvaluationCell toEvaluationCell(Cell paramCell) {
/*  67 */     if (!(paramCell instanceof SXSSFCell)) {
/*  68 */       throw new IllegalArgumentException("Unexpected type of cell: " + paramCell.getClass() + "." + " Only SXSSFCells can be evaluated.");
/*     */     }
/*     */ 
/*     */     
/*  72 */     return new SXSSFEvaluationCell((SXSSFCell)paramCell);
/*     */   }
/*     */ 
/*     */   
/*     */   public SXSSFCell evaluateInCell(Cell paramCell) {
/*  77 */     return (SXSSFCell)super.evaluateInCell(paramCell);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void evaluateAllFormulaCells(SXSSFWorkbook paramSXSSFWorkbook, boolean paramBoolean) {
/*  87 */     SXSSFFormulaEvaluator sXSSFFormulaEvaluator = new SXSSFFormulaEvaluator(paramSXSSFWorkbook);
/*     */ 
/*     */     
/*  90 */     for (Sheet sheet : paramSXSSFWorkbook) {
/*  91 */       if (((SXSSFSheet)sheet).areAllRowsFlushed()) {
/*  92 */         throw new SheetsFlushedException();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  97 */     for (Sheet sheet : paramSXSSFWorkbook) {
/*     */ 
/*     */       
/* 100 */       int i = ((SXSSFSheet)sheet).getLastFlushedRowNum();
/* 101 */       if (i > -1) {
/* 102 */         if (!paramBoolean) throw new RowFlushedException(0); 
/* 103 */         logger.log(3, new Object[] { "Rows up to " + i + " have already been flushed, skipping" });
/*     */       } 
/*     */ 
/*     */       
/* 107 */       for (Row row : sheet) {
/* 108 */         for (Cell cell : row) {
/* 109 */           if (cell.getCellTypeEnum() == CellType.FORMULA) {
/* 110 */             sXSSFFormulaEvaluator.evaluateFormulaCellEnum(cell);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
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
/*     */   public void evaluateAll() {
/* 126 */     evaluateAllFormulaCells(this.wb, false);
/*     */   }
/*     */   
/*     */   public static class SheetsFlushedException extends IllegalStateException {
/*     */     protected SheetsFlushedException() {
/* 131 */       super("One or more sheets have been flushed, cannot evaluate all cells");
/*     */     } }
/*     */   
/*     */   public static class RowFlushedException extends IllegalStateException {
/*     */     protected RowFlushedException(int param1Int) {
/* 136 */       super("Row " + param1Int + " has been flushed, cannot evaluate all cells");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFFormulaEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */