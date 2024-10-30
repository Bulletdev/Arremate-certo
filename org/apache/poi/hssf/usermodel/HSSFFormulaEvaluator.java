/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.formula.BaseFormulaEvaluator;
/*     */ import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
/*     */ import org.apache.poi.ss.formula.IStabilityClassifier;
/*     */ import org.apache.poi.ss.formula.WorkbookEvaluator;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.NumericValueEval;
/*     */ import org.apache.poi.ss.formula.eval.StringValueEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellValue;
/*     */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFFormulaEvaluator
/*     */   extends BaseFormulaEvaluator
/*     */ {
/*     */   private final HSSFWorkbook _book;
/*     */   
/*     */   public HSSFFormulaEvaluator(HSSFWorkbook paramHSSFWorkbook) {
/*  49 */     this(paramHSSFWorkbook, (IStabilityClassifier)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFFormulaEvaluator(HSSFWorkbook paramHSSFWorkbook, IStabilityClassifier paramIStabilityClassifier) {
/*  58 */     this(paramHSSFWorkbook, paramIStabilityClassifier, (UDFFinder)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HSSFFormulaEvaluator(HSSFWorkbook paramHSSFWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/*  69 */     super(new WorkbookEvaluator(HSSFEvaluationWorkbook.create(paramHSSFWorkbook), paramIStabilityClassifier, paramUDFFinder));
/*  70 */     this._book = paramHSSFWorkbook;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HSSFFormulaEvaluator create(HSSFWorkbook paramHSSFWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/*  81 */     return new HSSFFormulaEvaluator(paramHSSFWorkbook, paramIStabilityClassifier, paramUDFFinder);
/*     */   }
/*     */ 
/*     */   
/*     */   protected RichTextString createRichTextString(String paramString) {
/*  86 */     return new HSSFRichTextString(paramString);
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
/*     */   public static void setupEnvironment(String[] paramArrayOfString, HSSFFormulaEvaluator[] paramArrayOfHSSFFormulaEvaluator) {
/*  98 */     BaseFormulaEvaluator.setupEnvironment(paramArrayOfString, (BaseFormulaEvaluator[])paramArrayOfHSSFFormulaEvaluator);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> paramMap) {
/* 103 */     CollaboratingWorkbooksEnvironment.setupFormulaEvaluator(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyUpdateCell(HSSFCell paramHSSFCell) {
/* 113 */     this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell(paramHSSFCell));
/*     */   }
/*     */   
/*     */   public void notifyUpdateCell(Cell paramCell) {
/* 117 */     this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell((HSSFCell)paramCell));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyDeleteCell(HSSFCell paramHSSFCell) {
/* 126 */     this._bookEvaluator.notifyDeleteCell(new HSSFEvaluationCell(paramHSSFCell));
/*     */   }
/*     */   
/*     */   public void notifyDeleteCell(Cell paramCell) {
/* 130 */     this._bookEvaluator.notifyDeleteCell(new HSSFEvaluationCell((HSSFCell)paramCell));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifySetFormula(Cell paramCell) {
/* 141 */     this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell((HSSFCell)paramCell));
/*     */   }
/*     */ 
/*     */   
/*     */   public HSSFCell evaluateInCell(Cell paramCell) {
/* 146 */     return (HSSFCell)super.evaluateInCell(paramCell);
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
/*     */   public static void evaluateAllFormulaCells(HSSFWorkbook paramHSSFWorkbook) {
/* 161 */     evaluateAllFormulaCells(paramHSSFWorkbook, (FormulaEvaluator)new HSSFFormulaEvaluator(paramHSSFWorkbook));
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
/*     */   public static void evaluateAllFormulaCells(Workbook paramWorkbook) {
/* 176 */     BaseFormulaEvaluator.evaluateAllFormulaCells(paramWorkbook);
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
/*     */   public void evaluateAll() {
/* 192 */     evaluateAllFormulaCells(this._book, (FormulaEvaluator)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CellValue evaluateFormulaCellValue(Cell paramCell) {
/* 200 */     ValueEval valueEval = this._bookEvaluator.evaluate(new HSSFEvaluationCell((HSSFCell)paramCell));
/* 201 */     if (valueEval instanceof BoolEval) {
/* 202 */       BoolEval boolEval = (BoolEval)valueEval;
/* 203 */       return CellValue.valueOf(boolEval.getBooleanValue());
/*     */     } 
/* 205 */     if (valueEval instanceof NumericValueEval) {
/* 206 */       NumericValueEval numericValueEval = (NumericValueEval)valueEval;
/* 207 */       return new CellValue(numericValueEval.getNumberValue());
/*     */     } 
/* 209 */     if (valueEval instanceof StringValueEval) {
/* 210 */       StringValueEval stringValueEval = (StringValueEval)valueEval;
/* 211 */       return new CellValue(stringValueEval.getStringValue());
/*     */     } 
/* 213 */     if (valueEval instanceof ErrorEval) {
/* 214 */       return CellValue.getError(((ErrorEval)valueEval).getErrorCode());
/*     */     }
/* 216 */     throw new RuntimeException("Unexpected eval class (" + valueEval.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIgnoreMissingWorkbooks(boolean paramBoolean) {
/* 222 */     this._bookEvaluator.setIgnoreMissingWorkbooks(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugEvaluationOutputForNextEval(boolean paramBoolean) {
/* 228 */     this._bookEvaluator.setDebugEvaluationOutputForNextEval(paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFFormulaEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */