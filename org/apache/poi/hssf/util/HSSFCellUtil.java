/*     */ package org.apache.poi.hssf.util;
/*     */ 
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*     */ import org.apache.poi.hssf.usermodel.HSSFFont;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.HorizontalAlignment;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.CellUtil;
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
/*     */ @Deprecated
/*     */ @Removal(version = "3.17")
/*     */ public final class HSSFCellUtil
/*     */ {
/*     */   public static HSSFRow getRow(int paramInt, HSSFSheet paramHSSFSheet) {
/*  57 */     return (HSSFRow)CellUtil.getRow(paramInt, (Sheet)paramHSSFSheet);
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
/*     */   public static HSSFCell getCell(HSSFRow paramHSSFRow, int paramInt) {
/*  70 */     return (HSSFCell)CellUtil.getCell((Row)paramHSSFRow, paramInt);
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
/*     */   public static HSSFCell createCell(HSSFRow paramHSSFRow, int paramInt, String paramString, HSSFCellStyle paramHSSFCellStyle) {
/*  84 */     return (HSSFCell)CellUtil.createCell((Row)paramHSSFRow, paramInt, paramString, (CellStyle)paramHSSFCellStyle);
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
/*     */   public static HSSFCell createCell(HSSFRow paramHSSFRow, int paramInt, String paramString) {
/*  97 */     return createCell(paramHSSFRow, paramInt, paramString, null);
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
/*     */   public static void setAlignment(HSSFCell paramHSSFCell, HSSFWorkbook paramHSSFWorkbook, short paramShort) {
/* 111 */     setAlignment(paramHSSFCell, HorizontalAlignment.forInt(paramShort));
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
/*     */   public static void setAlignment(HSSFCell paramHSSFCell, HorizontalAlignment paramHorizontalAlignment) {
/* 123 */     CellUtil.setAlignment((Cell)paramHSSFCell, paramHorizontalAlignment);
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
/*     */   public static void setFont(HSSFCell paramHSSFCell, HSSFWorkbook paramHSSFWorkbook, HSSFFont paramHSSFFont) {
/* 135 */     CellUtil.setFont((Cell)paramHSSFCell, (Font)paramHSSFFont);
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
/*     */   public static void setCellStyleProperty(HSSFCell paramHSSFCell, HSSFWorkbook paramHSSFWorkbook, String paramString, Object paramObject) {
/* 153 */     CellUtil.setCellStyleProperty((Cell)paramHSSFCell, paramString, paramObject);
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
/*     */   public static HSSFCell translateUnicodeValues(HSSFCell paramHSSFCell) {
/* 166 */     CellUtil.translateUnicodeValues((Cell)paramHSSFCell);
/* 167 */     return paramHSSFCell;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\util\HSSFCellUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */