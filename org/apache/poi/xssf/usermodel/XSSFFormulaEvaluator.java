/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.formula.BaseFormulaEvaluator;
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.IStabilityClassifier;
/*     */ import org.apache.poi.ss.formula.WorkbookEvaluator;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
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
/*     */ public final class XSSFFormulaEvaluator
/*     */   extends BaseXSSFFormulaEvaluator
/*     */ {
/*     */   private XSSFWorkbook _book;
/*     */   
/*     */   public XSSFFormulaEvaluator(XSSFWorkbook paramXSSFWorkbook) {
/*  40 */     this(paramXSSFWorkbook, null, null);
/*     */   }
/*     */   private XSSFFormulaEvaluator(XSSFWorkbook paramXSSFWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/*  43 */     this(paramXSSFWorkbook, new WorkbookEvaluator(XSSFEvaluationWorkbook.create(paramXSSFWorkbook), paramIStabilityClassifier, paramUDFFinder));
/*     */   }
/*     */   protected XSSFFormulaEvaluator(XSSFWorkbook paramXSSFWorkbook, WorkbookEvaluator paramWorkbookEvaluator) {
/*  46 */     super(paramWorkbookEvaluator);
/*  47 */     this._book = paramXSSFWorkbook;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSSFFormulaEvaluator create(XSSFWorkbook paramXSSFWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/*  57 */     return new XSSFFormulaEvaluator(paramXSSFWorkbook, paramIStabilityClassifier, paramUDFFinder);
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
/*     */   public static void evaluateAllFormulaCells(XSSFWorkbook paramXSSFWorkbook) {
/*  72 */     BaseFormulaEvaluator.evaluateAllFormulaCells(paramXSSFWorkbook);
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFCell evaluateInCell(Cell paramCell) {
/*  77 */     return (XSSFCell)super.evaluateInCell(paramCell);
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
/*     */   public void evaluateAll() {
/*  92 */     evaluateAllFormulaCells(this._book, (FormulaEvaluator)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EvaluationCell toEvaluationCell(Cell paramCell) {
/*  99 */     if (!(paramCell instanceof XSSFCell)) {
/* 100 */       throw new IllegalArgumentException("Unexpected type of cell: " + paramCell.getClass() + "." + " Only XSSFCells can be evaluated.");
/*     */     }
/*     */ 
/*     */     
/* 104 */     return new XSSFEvaluationCell((XSSFCell)paramCell);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFFormulaEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */