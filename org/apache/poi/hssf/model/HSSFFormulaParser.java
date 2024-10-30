/*     */ package org.apache.poi.hssf.model;
/*     */ 
/*     */ import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaParseException;
/*     */ import org.apache.poi.ss.formula.FormulaParser;
/*     */ import org.apache.poi.ss.formula.FormulaParsingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaRenderer;
/*     */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaType;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.Removal;
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
/*     */ public final class HSSFFormulaParser
/*     */ {
/*     */   private static FormulaParsingWorkbook createParsingWorkbook(HSSFWorkbook paramHSSFWorkbook) {
/*  38 */     return (FormulaParsingWorkbook)HSSFEvaluationWorkbook.create(paramHSSFWorkbook);
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
/*     */   public static Ptg[] parse(String paramString, HSSFWorkbook paramHSSFWorkbook) throws FormulaParseException {
/*  53 */     return parse(paramString, paramHSSFWorkbook, FormulaType.CELL);
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
/*     */   @Removal(version = "3.17")
/*     */   public static Ptg[] parse(String paramString, HSSFWorkbook paramHSSFWorkbook, int paramInt) throws FormulaParseException {
/*  67 */     return parse(paramString, paramHSSFWorkbook, FormulaType.forInt(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Ptg[] parse(String paramString, HSSFWorkbook paramHSSFWorkbook, FormulaType paramFormulaType) throws FormulaParseException {
/*  77 */     return parse(paramString, paramHSSFWorkbook, paramFormulaType, -1);
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
/*     */   @Removal(version = "3.17")
/*     */   public static Ptg[] parse(String paramString, HSSFWorkbook paramHSSFWorkbook, int paramInt1, int paramInt2) throws FormulaParseException {
/*  94 */     return parse(paramString, paramHSSFWorkbook, FormulaType.forInt(paramInt1), paramInt2);
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
/*     */   public static Ptg[] parse(String paramString, HSSFWorkbook paramHSSFWorkbook, FormulaType paramFormulaType, int paramInt) throws FormulaParseException {
/* 108 */     return FormulaParser.parse(paramString, createParsingWorkbook(paramHSSFWorkbook), paramFormulaType, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toFormulaString(HSSFWorkbook paramHSSFWorkbook, Ptg[] paramArrayOfPtg) {
/* 119 */     return FormulaRenderer.toFormulaString((FormulaRenderingWorkbook)HSSFEvaluationWorkbook.create(paramHSSFWorkbook), paramArrayOfPtg);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\HSSFFormulaParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */