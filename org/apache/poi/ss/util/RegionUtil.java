/*     */ package org.apache.poi.ss.util;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RegionUtil
/*     */ {
/*     */   private static final class CellPropertySetter
/*     */   {
/*     */     private final String _propertyName;
/*     */     private final Short _propertyValue;
/*     */     
/*     */     public CellPropertySetter(String param1String, int param1Int) {
/*  44 */       this._propertyName = param1String;
/*  45 */       this._propertyValue = Short.valueOf((short)param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setProperty(Row param1Row, int param1Int) {
/*  50 */       Cell cell = CellUtil.getCell(param1Row, param1Int);
/*  51 */       CellUtil.setCellStyleProperty(cell, this._propertyName, this._propertyValue);
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
/*     */ 
/*     */   
/*     */   public static void setBorderLeft(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet, Workbook paramWorkbook) {
/*  66 */     setBorderLeft(paramInt, paramCellRangeAddress, paramSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setBorderLeft(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet) {
/*  77 */     int i = paramCellRangeAddress.getFirstRow();
/*  78 */     int j = paramCellRangeAddress.getLastRow();
/*  79 */     int k = paramCellRangeAddress.getFirstColumn();
/*     */     
/*  81 */     CellPropertySetter cellPropertySetter = new CellPropertySetter("borderLeft", paramInt);
/*  82 */     for (int m = i; m <= j; m++) {
/*  83 */       cellPropertySetter.setProperty(CellUtil.getRow(m, paramSheet), k);
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
/*     */ 
/*     */   
/*     */   public static void setLeftBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet, Workbook paramWorkbook) {
/*  98 */     setLeftBorderColor(paramInt, paramCellRangeAddress, paramSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setLeftBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet) {
/* 109 */     int i = paramCellRangeAddress.getFirstRow();
/* 110 */     int j = paramCellRangeAddress.getLastRow();
/* 111 */     int k = paramCellRangeAddress.getFirstColumn();
/*     */     
/* 113 */     CellPropertySetter cellPropertySetter = new CellPropertySetter("leftBorderColor", paramInt);
/* 114 */     for (int m = i; m <= j; m++) {
/* 115 */       cellPropertySetter.setProperty(CellUtil.getRow(m, paramSheet), k);
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
/*     */ 
/*     */   
/*     */   public static void setBorderRight(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet, Workbook paramWorkbook) {
/* 130 */     setBorderRight(paramInt, paramCellRangeAddress, paramSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setBorderRight(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet) {
/* 141 */     int i = paramCellRangeAddress.getFirstRow();
/* 142 */     int j = paramCellRangeAddress.getLastRow();
/* 143 */     int k = paramCellRangeAddress.getLastColumn();
/*     */     
/* 145 */     CellPropertySetter cellPropertySetter = new CellPropertySetter("borderRight", paramInt);
/* 146 */     for (int m = i; m <= j; m++) {
/* 147 */       cellPropertySetter.setProperty(CellUtil.getRow(m, paramSheet), k);
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
/*     */ 
/*     */   
/*     */   public static void setRightBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet, Workbook paramWorkbook) {
/* 162 */     setRightBorderColor(paramInt, paramCellRangeAddress, paramSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setRightBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet) {
/* 173 */     int i = paramCellRangeAddress.getFirstRow();
/* 174 */     int j = paramCellRangeAddress.getLastRow();
/* 175 */     int k = paramCellRangeAddress.getLastColumn();
/*     */     
/* 177 */     CellPropertySetter cellPropertySetter = new CellPropertySetter("rightBorderColor", paramInt);
/* 178 */     for (int m = i; m <= j; m++) {
/* 179 */       cellPropertySetter.setProperty(CellUtil.getRow(m, paramSheet), k);
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
/*     */ 
/*     */   
/*     */   public static void setBorderBottom(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet, Workbook paramWorkbook) {
/* 194 */     setBorderBottom(paramInt, paramCellRangeAddress, paramSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setBorderBottom(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet) {
/* 205 */     int i = paramCellRangeAddress.getFirstColumn();
/* 206 */     int j = paramCellRangeAddress.getLastColumn();
/* 207 */     int k = paramCellRangeAddress.getLastRow();
/* 208 */     CellPropertySetter cellPropertySetter = new CellPropertySetter("borderBottom", paramInt);
/* 209 */     Row row = CellUtil.getRow(k, paramSheet);
/* 210 */     for (int m = i; m <= j; m++) {
/* 211 */       cellPropertySetter.setProperty(row, m);
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
/*     */ 
/*     */   
/*     */   public static void setBottomBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet, Workbook paramWorkbook) {
/* 226 */     setBottomBorderColor(paramInt, paramCellRangeAddress, paramSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setBottomBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet) {
/* 237 */     int i = paramCellRangeAddress.getFirstColumn();
/* 238 */     int j = paramCellRangeAddress.getLastColumn();
/* 239 */     int k = paramCellRangeAddress.getLastRow();
/* 240 */     CellPropertySetter cellPropertySetter = new CellPropertySetter("bottomBorderColor", paramInt);
/* 241 */     Row row = CellUtil.getRow(k, paramSheet);
/* 242 */     for (int m = i; m <= j; m++) {
/* 243 */       cellPropertySetter.setProperty(row, m);
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
/*     */ 
/*     */   
/*     */   public static void setBorderTop(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet, Workbook paramWorkbook) {
/* 258 */     setBorderTop(paramInt, paramCellRangeAddress, paramSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setBorderTop(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet) {
/* 269 */     int i = paramCellRangeAddress.getFirstColumn();
/* 270 */     int j = paramCellRangeAddress.getLastColumn();
/* 271 */     int k = paramCellRangeAddress.getFirstRow();
/* 272 */     CellPropertySetter cellPropertySetter = new CellPropertySetter("borderTop", paramInt);
/* 273 */     Row row = CellUtil.getRow(k, paramSheet);
/* 274 */     for (int m = i; m <= j; m++) {
/* 275 */       cellPropertySetter.setProperty(row, m);
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
/*     */ 
/*     */   
/*     */   public static void setTopBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet, Workbook paramWorkbook) {
/* 290 */     setTopBorderColor(paramInt, paramCellRangeAddress, paramSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setTopBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, Sheet paramSheet) {
/* 301 */     int i = paramCellRangeAddress.getFirstColumn();
/* 302 */     int j = paramCellRangeAddress.getLastColumn();
/* 303 */     int k = paramCellRangeAddress.getFirstRow();
/* 304 */     CellPropertySetter cellPropertySetter = new CellPropertySetter("topBorderColor", paramInt);
/* 305 */     Row row = CellUtil.getRow(k, paramSheet);
/* 306 */     for (int m = i; m <= j; m++)
/* 307 */       cellPropertySetter.setProperty(row, m); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\RegionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */