/*     */ package org.apache.poi.hssf.util;
/*     */ 
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.RegionUtil;
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
/*     */ public final class HSSFRegionUtil
/*     */ {
/*     */   public static void setBorderLeft(int paramInt, CellRangeAddress paramCellRangeAddress, HSSFSheet paramHSSFSheet, HSSFWorkbook paramHSSFWorkbook) {
/*  45 */     RegionUtil.setBorderLeft(paramInt, paramCellRangeAddress, (Sheet)paramHSSFSheet, (Workbook)paramHSSFWorkbook);
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
/*     */   public static void setLeftBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, HSSFSheet paramHSSFSheet, HSSFWorkbook paramHSSFWorkbook) {
/*  58 */     RegionUtil.setLeftBorderColor(paramInt, paramCellRangeAddress, (Sheet)paramHSSFSheet, (Workbook)paramHSSFWorkbook);
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
/*     */   public static void setBorderRight(int paramInt, CellRangeAddress paramCellRangeAddress, HSSFSheet paramHSSFSheet, HSSFWorkbook paramHSSFWorkbook) {
/*  71 */     RegionUtil.setBorderRight(paramInt, paramCellRangeAddress, (Sheet)paramHSSFSheet, (Workbook)paramHSSFWorkbook);
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
/*     */   public static void setRightBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, HSSFSheet paramHSSFSheet, HSSFWorkbook paramHSSFWorkbook) {
/*  84 */     RegionUtil.setRightBorderColor(paramInt, paramCellRangeAddress, (Sheet)paramHSSFSheet, (Workbook)paramHSSFWorkbook);
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
/*     */   public static void setBorderBottom(int paramInt, CellRangeAddress paramCellRangeAddress, HSSFSheet paramHSSFSheet, HSSFWorkbook paramHSSFWorkbook) {
/*  97 */     RegionUtil.setBorderBottom(paramInt, paramCellRangeAddress, (Sheet)paramHSSFSheet, (Workbook)paramHSSFWorkbook);
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
/*     */   public static void setBottomBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, HSSFSheet paramHSSFSheet, HSSFWorkbook paramHSSFWorkbook) {
/* 110 */     RegionUtil.setBottomBorderColor(paramInt, paramCellRangeAddress, (Sheet)paramHSSFSheet, (Workbook)paramHSSFWorkbook);
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
/*     */   public static void setBorderTop(int paramInt, CellRangeAddress paramCellRangeAddress, HSSFSheet paramHSSFSheet, HSSFWorkbook paramHSSFWorkbook) {
/* 123 */     RegionUtil.setBorderTop(paramInt, paramCellRangeAddress, (Sheet)paramHSSFSheet, (Workbook)paramHSSFWorkbook);
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
/*     */   public static void setTopBorderColor(int paramInt, CellRangeAddress paramCellRangeAddress, HSSFSheet paramHSSFSheet, HSSFWorkbook paramHSSFWorkbook) {
/* 136 */     RegionUtil.setTopBorderColor(paramInt, paramCellRangeAddress, (Sheet)paramHSSFSheet, (Workbook)paramHSSFWorkbook);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\util\HSSFRegionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */