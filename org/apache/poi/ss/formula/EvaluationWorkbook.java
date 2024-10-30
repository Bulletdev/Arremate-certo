/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import org.apache.poi.ss.formula.ptg.NamePtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
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
/*     */ public interface EvaluationWorkbook
/*     */ {
/*     */   String getSheetName(int paramInt);
/*     */   
/*     */   int getSheetIndex(EvaluationSheet paramEvaluationSheet);
/*     */   
/*     */   int getSheetIndex(String paramString);
/*     */   
/*     */   EvaluationSheet getSheet(int paramInt);
/*     */   
/*     */   ExternalSheet getExternalSheet(int paramInt);
/*     */   
/*     */   ExternalSheet getExternalSheet(String paramString1, String paramString2, int paramInt);
/*     */   
/*     */   int convertFromExternSheetIndex(int paramInt);
/*     */   
/*     */   ExternalName getExternalName(int paramInt1, int paramInt2);
/*     */   
/*     */   ExternalName getExternalName(String paramString1, String paramString2, int paramInt);
/*     */   
/*     */   EvaluationName getName(NamePtg paramNamePtg);
/*     */   
/*     */   EvaluationName getName(String paramString, int paramInt);
/*     */   
/*     */   String resolveNameXText(NameXPtg paramNameXPtg);
/*     */   
/*     */   Ptg[] getFormulaTokens(EvaluationCell paramEvaluationCell);
/*     */   
/*     */   UDFFinder getUDFFinder();
/*     */   
/*     */   void clearAllCachedResultValues();
/*     */   
/*     */   public static class ExternalSheet
/*     */   {
/*     */     private final String _workbookName;
/*     */     private final String _sheetName;
/*     */     
/*     */     public ExternalSheet(String param1String1, String param1String2) {
/*  93 */       this._workbookName = param1String1;
/*  94 */       this._sheetName = param1String2;
/*     */     }
/*     */     public String getWorkbookName() {
/*  97 */       return this._workbookName;
/*     */     }
/*     */     public String getSheetName() {
/* 100 */       return this._sheetName;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ExternalSheetRange extends ExternalSheet {
/*     */     public ExternalSheetRange(String param1String1, String param1String2, String param1String3) {
/* 106 */       super(param1String1, param1String2);
/* 107 */       this._lastSheetName = param1String3;
/*     */     }
/*     */     private final String _lastSheetName;
/*     */     public String getFirstSheetName() {
/* 111 */       return getSheetName();
/*     */     }
/*     */     public String getLastSheetName() {
/* 114 */       return this._lastSheetName;
/*     */     } }
/*     */   
/*     */   public static class ExternalName {
/*     */     private final String _nameName;
/*     */     private final int _nameNumber;
/*     */     private final int _ix;
/*     */     
/*     */     public ExternalName(String param1String, int param1Int1, int param1Int2) {
/* 123 */       this._nameName = param1String;
/* 124 */       this._nameNumber = param1Int1;
/* 125 */       this._ix = param1Int2;
/*     */     }
/*     */     public String getName() {
/* 128 */       return this._nameName;
/*     */     }
/*     */     public int getNumber() {
/* 131 */       return this._nameNumber;
/*     */     }
/*     */     public int getIx() {
/* 134 */       return this._ix;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\EvaluationWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */