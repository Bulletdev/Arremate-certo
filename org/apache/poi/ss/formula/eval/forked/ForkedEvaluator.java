/*     */ package org.apache.poi.ss.formula.eval.forked;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationWorkbook;
/*     */ import org.apache.poi.ss.formula.IStabilityClassifier;
/*     */ import org.apache.poi.ss.formula.WorkbookEvaluator;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*     */ import org.apache.poi.ss.usermodel.CellType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ForkedEvaluator
/*     */ {
/*     */   private WorkbookEvaluator _evaluator;
/*     */   private ForkedEvaluationWorkbook _sewb;
/*     */   
/*     */   private ForkedEvaluator(EvaluationWorkbook paramEvaluationWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/*  52 */     this._sewb = new ForkedEvaluationWorkbook(paramEvaluationWorkbook);
/*  53 */     this._evaluator = new WorkbookEvaluator(this._sewb, paramIStabilityClassifier, paramUDFFinder);
/*     */   }
/*     */   private static EvaluationWorkbook createEvaluationWorkbook(Workbook paramWorkbook) {
/*  56 */     if (paramWorkbook instanceof HSSFWorkbook) {
/*  57 */       return (EvaluationWorkbook)HSSFEvaluationWorkbook.create((HSSFWorkbook)paramWorkbook);
/*     */     }
/*     */     
/*     */     try {
/*  61 */       Class<?> clazz1 = Class.forName("org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook");
/*  62 */       Class<?> clazz2 = Class.forName("org.apache.poi.xssf.usermodel.XSSFWorkbook");
/*  63 */       Method method = clazz1.getDeclaredMethod("create", new Class[] { clazz2 });
/*  64 */       return (EvaluationWorkbook)method.invoke(null, new Object[] { paramWorkbook });
/*  65 */     } catch (Exception exception) {
/*  66 */       throw new IllegalArgumentException("Unexpected workbook type (" + paramWorkbook.getClass().getName() + ") - check for poi-ooxml and poi-ooxml schemas jar in the classpath", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ForkedEvaluator create(Workbook paramWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/*  75 */     return new ForkedEvaluator(createEvaluationWorkbook(paramWorkbook), paramIStabilityClassifier, paramUDFFinder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateCell(String paramString, int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*  86 */     ForkedEvaluationCell forkedEvaluationCell = this._sewb.getOrCreateUpdatableCell(paramString, paramInt1, paramInt2);
/*  87 */     forkedEvaluationCell.setValue(paramValueEval);
/*  88 */     this._evaluator.notifyUpdateCell(forkedEvaluationCell);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyUpdatedCells(Workbook paramWorkbook) {
/*  97 */     this._sewb.copyUpdatedCells(paramWorkbook);
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
/*     */   public ValueEval evaluate(String paramString, int paramInt1, int paramInt2) {
/* 113 */     EvaluationCell evaluationCell = this._sewb.getEvaluationCell(paramString, paramInt1, paramInt2);
/*     */     
/* 115 */     switch (evaluationCell.getCellTypeEnum()) {
/*     */       case BOOLEAN:
/* 117 */         return (ValueEval)BoolEval.valueOf(evaluationCell.getBooleanCellValue());
/*     */       case ERROR:
/* 119 */         return (ValueEval)ErrorEval.valueOf(evaluationCell.getErrorCellValue());
/*     */       case FORMULA:
/* 121 */         return this._evaluator.evaluate(evaluationCell);
/*     */       case NUMERIC:
/* 123 */         return (ValueEval)new NumberEval(evaluationCell.getNumericCellValue());
/*     */       case STRING:
/* 125 */         return (ValueEval)new StringEval(evaluationCell.getStringCellValue());
/*     */       case BLANK:
/* 127 */         return null;
/*     */     } 
/* 129 */     throw new IllegalStateException("Bad cell type (" + evaluationCell.getCellTypeEnum() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setupEnvironment(String[] paramArrayOfString, ForkedEvaluator[] paramArrayOfForkedEvaluator) {
/* 140 */     WorkbookEvaluator[] arrayOfWorkbookEvaluator = new WorkbookEvaluator[paramArrayOfForkedEvaluator.length];
/* 141 */     for (byte b = 0; b < arrayOfWorkbookEvaluator.length; b++) {
/* 142 */       arrayOfWorkbookEvaluator[b] = (paramArrayOfForkedEvaluator[b])._evaluator;
/*     */     }
/* 144 */     CollaboratingWorkbooksEnvironment.setup(paramArrayOfString, arrayOfWorkbookEvaluator);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\forked\ForkedEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */