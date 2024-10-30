/*     */ package org.apache.poi.ss.formula.eval.forked;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationName;
/*     */ import org.apache.poi.ss.formula.EvaluationSheet;
/*     */ import org.apache.poi.ss.formula.EvaluationWorkbook;
/*     */ import org.apache.poi.ss.formula.ptg.NamePtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ final class ForkedEvaluationWorkbook
/*     */   implements EvaluationWorkbook
/*     */ {
/*     */   private final EvaluationWorkbook _masterBook;
/*     */   private final Map<String, ForkedEvaluationSheet> _sharedSheetsByName;
/*     */   
/*     */   public ForkedEvaluationWorkbook(EvaluationWorkbook paramEvaluationWorkbook) {
/*  48 */     this._masterBook = paramEvaluationWorkbook;
/*  49 */     this._sharedSheetsByName = new HashMap<String, ForkedEvaluationSheet>();
/*     */   }
/*     */ 
/*     */   
/*     */   public ForkedEvaluationCell getOrCreateUpdatableCell(String paramString, int paramInt1, int paramInt2) {
/*  54 */     ForkedEvaluationSheet forkedEvaluationSheet = getSharedSheet(paramString);
/*  55 */     return forkedEvaluationSheet.getOrCreateUpdatableCell(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public EvaluationCell getEvaluationCell(String paramString, int paramInt1, int paramInt2) {
/*  59 */     ForkedEvaluationSheet forkedEvaluationSheet = getSharedSheet(paramString);
/*  60 */     return forkedEvaluationSheet.getCell(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   private ForkedEvaluationSheet getSharedSheet(String paramString) {
/*  64 */     ForkedEvaluationSheet forkedEvaluationSheet = this._sharedSheetsByName.get(paramString);
/*  65 */     if (forkedEvaluationSheet == null) {
/*  66 */       forkedEvaluationSheet = new ForkedEvaluationSheet(this._masterBook.getSheet(this._masterBook.getSheetIndex(paramString)));
/*     */       
/*  68 */       this._sharedSheetsByName.put(paramString, forkedEvaluationSheet);
/*     */     } 
/*  70 */     return forkedEvaluationSheet;
/*     */   }
/*     */   
/*     */   public void copyUpdatedCells(Workbook paramWorkbook) {
/*  74 */     String[] arrayOfString = new String[this._sharedSheetsByName.size()];
/*  75 */     this._sharedSheetsByName.keySet().toArray((Object[])arrayOfString);
/*  76 */     for (String str : arrayOfString) {
/*  77 */       ForkedEvaluationSheet forkedEvaluationSheet = this._sharedSheetsByName.get(str);
/*  78 */       forkedEvaluationSheet.copyUpdatedCells(paramWorkbook.getSheet(str));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int convertFromExternSheetIndex(int paramInt) {
/*  84 */     return this._masterBook.convertFromExternSheetIndex(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationWorkbook.ExternalSheet getExternalSheet(int paramInt) {
/*  89 */     return this._masterBook.getExternalSheet(paramInt);
/*     */   }
/*     */   
/*     */   public EvaluationWorkbook.ExternalSheet getExternalSheet(String paramString1, String paramString2, int paramInt) {
/*  93 */     return this._masterBook.getExternalSheet(paramString1, paramString2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Ptg[] getFormulaTokens(EvaluationCell paramEvaluationCell) {
/*  98 */     if (paramEvaluationCell instanceof ForkedEvaluationCell)
/*     */     {
/* 100 */       throw new RuntimeException("Updated formulas not supported yet");
/*     */     }
/* 102 */     return this._masterBook.getFormulaTokens(paramEvaluationCell);
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationName getName(NamePtg paramNamePtg) {
/* 107 */     return this._masterBook.getName(paramNamePtg);
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationName getName(String paramString, int paramInt) {
/* 112 */     return this._masterBook.getName(paramString, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationSheet getSheet(int paramInt) {
/* 117 */     return getSharedSheet(getSheetName(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationWorkbook.ExternalName getExternalName(int paramInt1, int paramInt2) {
/* 122 */     return this._masterBook.getExternalName(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public EvaluationWorkbook.ExternalName getExternalName(String paramString1, String paramString2, int paramInt) {
/* 126 */     return this._masterBook.getExternalName(paramString1, paramString2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSheetIndex(EvaluationSheet paramEvaluationSheet) {
/* 131 */     if (paramEvaluationSheet instanceof ForkedEvaluationSheet) {
/* 132 */       ForkedEvaluationSheet forkedEvaluationSheet = (ForkedEvaluationSheet)paramEvaluationSheet;
/* 133 */       return forkedEvaluationSheet.getSheetIndex(this._masterBook);
/*     */     } 
/* 135 */     return this._masterBook.getSheetIndex(paramEvaluationSheet);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSheetIndex(String paramString) {
/* 140 */     return this._masterBook.getSheetIndex(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSheetName(int paramInt) {
/* 145 */     return this._masterBook.getSheetName(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public String resolveNameXText(NameXPtg paramNameXPtg) {
/* 150 */     return this._masterBook.resolveNameXText(paramNameXPtg);
/*     */   }
/*     */ 
/*     */   
/*     */   public UDFFinder getUDFFinder() {
/* 155 */     return this._masterBook.getUDFFinder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAllCachedResultValues() {
/* 166 */     this._masterBook.clearAllCachedResultValues();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\forked\ForkedEvaluationWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */