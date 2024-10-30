/*     */ package org.apache.poi.xssf.usermodel.helpers;
/*     */ 
/*     */ import org.apache.poi.ss.formula.FormulaParser;
/*     */ import org.apache.poi.ss.formula.FormulaParsingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaRenderer;
/*     */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaType;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.Pxg;
/*     */ import org.apache.poi.ss.formula.ptg.Pxg3D;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCell;
/*     */ import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
/*     */ import org.apache.poi.xssf.usermodel.XSSFName;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
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
/*     */ public final class XSSFFormulaUtils
/*     */ {
/*     */   private final XSSFWorkbook _wb;
/*     */   private final XSSFEvaluationWorkbook _fpwb;
/*     */   
/*     */   public XSSFFormulaUtils(XSSFWorkbook paramXSSFWorkbook) {
/*  48 */     this._wb = paramXSSFWorkbook;
/*  49 */     this._fpwb = XSSFEvaluationWorkbook.create(this._wb);
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
/*     */   public void updateSheetName(int paramInt, String paramString1, String paramString2) {
/*  68 */     for (XSSFName xSSFName : this._wb.getAllNames()) {
/*  69 */       if (xSSFName.getSheetIndex() == -1 || xSSFName.getSheetIndex() == paramInt) {
/*  70 */         updateName(xSSFName, paramString1, paramString2);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  75 */     for (Sheet sheet : this._wb) {
/*  76 */       for (Row row : sheet) {
/*  77 */         for (Cell cell : row) {
/*  78 */           if (cell.getCellTypeEnum() == CellType.FORMULA) {
/*  79 */             updateFormula((XSSFCell)cell, paramString1, paramString2);
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
/*     */   private void updateFormula(XSSFCell paramXSSFCell, String paramString1, String paramString2) {
/*  92 */     CTCellFormula cTCellFormula = paramXSSFCell.getCTCell().getF();
/*  93 */     if (cTCellFormula != null) {
/*  94 */       String str = cTCellFormula.getStringValue();
/*  95 */       if (str != null && str.length() > 0) {
/*  96 */         int i = this._wb.getSheetIndex((Sheet)paramXSSFCell.getSheet());
/*  97 */         Ptg[] arrayOfPtg = FormulaParser.parse(str, (FormulaParsingWorkbook)this._fpwb, FormulaType.CELL, i, paramXSSFCell.getRowIndex());
/*  98 */         for (Ptg ptg : arrayOfPtg) {
/*  99 */           updatePtg(ptg, paramString1, paramString2);
/*     */         }
/* 101 */         String str1 = FormulaRenderer.toFormulaString((FormulaRenderingWorkbook)this._fpwb, arrayOfPtg);
/* 102 */         if (!str.equals(str1)) cTCellFormula.setStringValue(str1);
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateName(XSSFName paramXSSFName, String paramString1, String paramString2) {
/* 113 */     String str = paramXSSFName.getRefersToFormula();
/* 114 */     if (str != null) {
/* 115 */       int i = paramXSSFName.getSheetIndex();
/* 116 */       byte b = -1;
/* 117 */       Ptg[] arrayOfPtg = FormulaParser.parse(str, (FormulaParsingWorkbook)this._fpwb, FormulaType.NAMEDRANGE, i, b);
/* 118 */       for (Ptg ptg : arrayOfPtg) {
/* 119 */         updatePtg(ptg, paramString1, paramString2);
/*     */       }
/* 121 */       String str1 = FormulaRenderer.toFormulaString((FormulaRenderingWorkbook)this._fpwb, arrayOfPtg);
/* 122 */       if (!str.equals(str1)) paramXSSFName.setRefersToFormula(str1); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updatePtg(Ptg paramPtg, String paramString1, String paramString2) {
/* 127 */     if (paramPtg instanceof Pxg) {
/* 128 */       Pxg pxg = (Pxg)paramPtg;
/* 129 */       if (pxg.getExternalWorkbookNumber() < 1) {
/* 130 */         if (pxg.getSheetName() != null && pxg.getSheetName().equals(paramString1))
/*     */         {
/* 132 */           pxg.setSheetName(paramString2);
/*     */         }
/* 134 */         if (pxg instanceof Pxg3D) {
/* 135 */           Pxg3D pxg3D = (Pxg3D)pxg;
/* 136 */           if (pxg3D.getLastSheetName() != null && pxg3D.getLastSheetName().equals(paramString1))
/*     */           {
/* 138 */             pxg3D.setLastSheetName(paramString2);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\XSSFFormulaUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */