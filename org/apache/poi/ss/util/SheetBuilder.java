/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import org.apache.poi.ss.usermodel.Cell;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SheetBuilder
/*     */ {
/*     */   private final Workbook workbook;
/*     */   private final Object[][] cells;
/*     */   private boolean shouldCreateEmptyCells = false;
/*  39 */   private String sheetName = null;
/*     */   
/*     */   public SheetBuilder(Workbook paramWorkbook, Object[][] paramArrayOfObject) {
/*  42 */     this.workbook = paramWorkbook;
/*  43 */     this.cells = (Object[][])paramArrayOfObject.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCreateEmptyCells() {
/*  54 */     return this.shouldCreateEmptyCells;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SheetBuilder setCreateEmptyCells(boolean paramBoolean) {
/*  65 */     this.shouldCreateEmptyCells = paramBoolean;
/*  66 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SheetBuilder setSheetName(String paramString) {
/*  76 */     this.sheetName = paramString;
/*  77 */     return this;
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
/*     */   public Sheet build() {
/* 100 */     Sheet sheet = (this.sheetName == null) ? this.workbook.createSheet() : this.workbook.createSheet(this.sheetName);
/* 101 */     Row row = null;
/* 102 */     Cell cell = null;
/*     */     
/* 104 */     for (byte b = 0; b < this.cells.length; b++) {
/* 105 */       Object[] arrayOfObject = this.cells[b];
/* 106 */       row = sheet.createRow(b);
/*     */       
/* 108 */       for (byte b1 = 0; b1 < arrayOfObject.length; b1++) {
/* 109 */         Object object = arrayOfObject[b1];
/* 110 */         if (object != null || this.shouldCreateEmptyCells) {
/* 111 */           cell = row.createCell(b1);
/* 112 */           setCellValue(cell, object);
/*     */         } 
/*     */       } 
/*     */     } 
/* 116 */     return sheet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setCellValue(Cell paramCell, Object paramObject) {
/* 126 */     if (paramObject == null || paramCell == null)
/*     */       return; 
/* 128 */     if (paramObject instanceof Number) {
/* 129 */       double d = ((Number)paramObject).doubleValue();
/* 130 */       paramCell.setCellValue(d);
/* 131 */     } else if (paramObject instanceof Date) {
/* 132 */       paramCell.setCellValue((Date)paramObject);
/* 133 */     } else if (paramObject instanceof Calendar) {
/* 134 */       paramCell.setCellValue((Calendar)paramObject);
/* 135 */     } else if (isFormulaDefinition(paramObject)) {
/* 136 */       paramCell.setCellFormula(getFormula(paramObject));
/*     */     } else {
/* 138 */       paramCell.setCellValue(paramObject.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isFormulaDefinition(Object paramObject) {
/* 143 */     if (paramObject instanceof String) {
/* 144 */       String str = (String)paramObject;
/* 145 */       if (str.length() < 2) {
/* 146 */         return false;
/*     */       }
/* 148 */       return (((String)paramObject).charAt(0) == '=');
/*     */     } 
/*     */     
/* 151 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private String getFormula(Object paramObject) {
/* 156 */     return ((String)paramObject).substring(1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\SheetBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */