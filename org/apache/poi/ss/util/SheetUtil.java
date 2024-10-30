/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.TextAttribute;
/*     */ import java.awt.font.TextLayout;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.text.AttributedString;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.CellValue;
/*     */ import org.apache.poi.ss.usermodel.DataFormatter;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SheetUtil
/*     */ {
/*     */   private static final char defaultChar = '0';
/*     */   private static final double fontHeightMultiple = 2.0D;
/*     */   
/*  71 */   private static final FormulaEvaluator dummyEvaluator = new FormulaEvaluator() {
/*     */       public void clearAllCachedResultValues() {}
/*     */       
/*     */       public void notifySetFormula(Cell param1Cell) {}
/*     */       
/*     */       public void notifyDeleteCell(Cell param1Cell) {}
/*     */       
/*     */       public void notifyUpdateCell(Cell param1Cell) {}
/*     */       
/*     */       public CellValue evaluate(Cell param1Cell) {
/*  81 */         return null;
/*     */       } public Cell evaluateInCell(Cell param1Cell) {
/*  83 */         return null;
/*     */       }
/*     */       public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> param1Map) {}
/*     */       
/*     */       public void setDebugEvaluationOutputForNextEval(boolean param1Boolean) {}
/*     */       
/*     */       public void setIgnoreMissingWorkbooks(boolean param1Boolean) {}
/*     */       
/*     */       public void evaluateAll() {}
/*     */       
/*     */       public int evaluateFormulaCell(Cell param1Cell) {
/*  94 */         return param1Cell.getCachedFormulaResultType();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Internal(since = "POI 3.15 beta 3")
/*     */       public CellType evaluateFormulaCellEnum(Cell param1Cell) {
/* 103 */         return param1Cell.getCachedFormulaResultTypeEnum();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   private static final FontRenderContext fontRenderContext = new FontRenderContext(null, true, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getCellWidth(Cell paramCell, int paramInt, DataFormatter paramDataFormatter, boolean paramBoolean) {
/* 122 */     Sheet sheet = paramCell.getSheet();
/* 123 */     Workbook workbook = sheet.getWorkbook();
/* 124 */     Row row = paramCell.getRow();
/* 125 */     int i = paramCell.getColumnIndex();
/*     */ 
/*     */ 
/*     */     
/* 129 */     int j = 1;
/* 130 */     for (CellRangeAddress cellRangeAddress : sheet.getMergedRegions()) {
/* 131 */       if (containsCell(cellRangeAddress, row.getRowNum(), i)) {
/* 132 */         if (!paramBoolean)
/*     */         {
/* 134 */           return -1.0D;
/*     */         }
/* 136 */         paramCell = row.getCell(cellRangeAddress.getFirstColumn());
/* 137 */         j = 1 + cellRangeAddress.getLastColumn() - cellRangeAddress.getFirstColumn();
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     CellStyle cellStyle = paramCell.getCellStyle();
/* 142 */     CellType cellType = paramCell.getCellTypeEnum();
/*     */ 
/*     */     
/* 145 */     if (cellType == CellType.FORMULA) {
/* 146 */       cellType = paramCell.getCachedFormulaResultTypeEnum();
/*     */     }
/* 148 */     Font font = workbook.getFontAt(cellStyle.getFontIndex());
/*     */     
/* 150 */     double d = -1.0D;
/* 151 */     if (cellType == CellType.STRING) {
/* 152 */       RichTextString richTextString = paramCell.getRichStringCellValue();
/* 153 */       String[] arrayOfString = richTextString.getString().split("\\n");
/* 154 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 155 */         String str = arrayOfString[b] + '0';
/*     */         
/* 157 */         AttributedString attributedString = new AttributedString(str);
/* 158 */         copyAttributes(font, attributedString, 0, str.length());
/*     */         
/* 160 */         if (richTextString.numFormattingRuns() > 0);
/*     */ 
/*     */ 
/*     */         
/* 164 */         d = getCellWidth(paramInt, j, cellStyle, d, attributedString);
/*     */       } 
/*     */     } else {
/* 167 */       String str = null;
/* 168 */       if (cellType == CellType.NUMERIC) {
/*     */         
/*     */         try {
/* 171 */           str = paramDataFormatter.formatCellValue(paramCell, dummyEvaluator);
/* 172 */         } catch (Exception exception) {
/* 173 */           str = String.valueOf(paramCell.getNumericCellValue());
/*     */         } 
/* 175 */       } else if (cellType == CellType.BOOLEAN) {
/* 176 */         str = String.valueOf(paramCell.getBooleanCellValue()).toUpperCase(Locale.ROOT);
/*     */       } 
/* 178 */       if (str != null) {
/* 179 */         String str1 = str + '0';
/* 180 */         AttributedString attributedString = new AttributedString(str1);
/* 181 */         copyAttributes(font, attributedString, 0, str1.length());
/*     */         
/* 183 */         d = getCellWidth(paramInt, j, cellStyle, d, attributedString);
/*     */       } 
/*     */     } 
/* 186 */     return d;
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
/*     */   private static double getCellWidth(int paramInt1, int paramInt2, CellStyle paramCellStyle, double paramDouble, AttributedString paramAttributedString) {
/*     */     Rectangle2D rectangle2D;
/* 202 */     TextLayout textLayout = new TextLayout(paramAttributedString.getIterator(), fontRenderContext);
/*     */     
/* 204 */     if (paramCellStyle.getRotation() != 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 211 */       AffineTransform affineTransform = new AffineTransform();
/* 212 */       affineTransform.concatenate(AffineTransform.getRotateInstance(paramCellStyle.getRotation() * 2.0D * Math.PI / 360.0D));
/* 213 */       affineTransform.concatenate(AffineTransform.getScaleInstance(1.0D, 2.0D));
/*     */ 
/*     */       
/* 216 */       rectangle2D = textLayout.getOutline(affineTransform).getBounds();
/*     */     } else {
/* 218 */       rectangle2D = textLayout.getBounds();
/*     */     } 
/*     */     
/* 221 */     double d = rectangle2D.getX() + rectangle2D.getWidth();
/* 222 */     return Math.max(paramDouble, d / paramInt2 / paramInt1 + paramCellStyle.getIndention());
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
/*     */   public static double getColumnWidth(Sheet paramSheet, int paramInt, boolean paramBoolean) {
/* 235 */     return getColumnWidth(paramSheet, paramInt, paramBoolean, paramSheet.getFirstRowNum(), paramSheet.getLastRowNum());
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
/*     */   public static double getColumnWidth(Sheet paramSheet, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
/* 249 */     DataFormatter dataFormatter = new DataFormatter();
/* 250 */     int i = getDefaultCharWidth(paramSheet.getWorkbook());
/*     */     
/* 252 */     double d = -1.0D;
/* 253 */     for (int j = paramInt2; j <= paramInt3; j++) {
/* 254 */       Row row = paramSheet.getRow(j);
/* 255 */       if (row != null) {
/* 256 */         double d1 = getColumnWidthForRow(row, paramInt1, i, dataFormatter, paramBoolean);
/* 257 */         d = Math.max(d, d1);
/*     */       } 
/*     */     } 
/* 260 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public static int getDefaultCharWidth(Workbook paramWorkbook) {
/* 271 */     Font font = paramWorkbook.getFontAt((short)0);
/*     */     
/* 273 */     AttributedString attributedString = new AttributedString(String.valueOf('0'));
/* 274 */     copyAttributes(font, attributedString, 0, 1);
/* 275 */     TextLayout textLayout = new TextLayout(attributedString.getIterator(), fontRenderContext);
/* 276 */     return (int)textLayout.getAdvance();
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
/*     */   private static double getColumnWidthForRow(Row paramRow, int paramInt1, int paramInt2, DataFormatter paramDataFormatter, boolean paramBoolean) {
/* 293 */     if (paramRow == null) {
/* 294 */       return -1.0D;
/*     */     }
/*     */     
/* 297 */     Cell cell = paramRow.getCell(paramInt1);
/*     */     
/* 299 */     if (cell == null) {
/* 300 */       return -1.0D;
/*     */     }
/*     */     
/* 303 */     return getCellWidth(cell, paramInt2, paramDataFormatter, paramBoolean);
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
/*     */   public static boolean canComputeColumnWidth(Font paramFont) {
/* 320 */     AttributedString attributedString = new AttributedString("1w");
/* 321 */     copyAttributes(paramFont, attributedString, 0, "1w".length());
/*     */     
/* 323 */     TextLayout textLayout = new TextLayout(attributedString.getIterator(), fontRenderContext);
/* 324 */     if (textLayout.getBounds().getWidth() > 0.0D) {
/* 325 */       return true;
/*     */     }
/*     */     
/* 328 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void copyAttributes(Font paramFont, AttributedString paramAttributedString, int paramInt1, int paramInt2) {
/* 335 */     paramAttributedString.addAttribute(TextAttribute.FAMILY, paramFont.getFontName(), paramInt1, paramInt2);
/* 336 */     paramAttributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(paramFont.getFontHeightInPoints()));
/* 337 */     if (paramFont.getBoldweight() == 700) paramAttributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, paramInt1, paramInt2); 
/* 338 */     if (paramFont.getItalic()) paramAttributedString.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, paramInt1, paramInt2); 
/* 339 */     if (paramFont.getUnderline() == 1) paramAttributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, paramInt1, paramInt2);
/*     */   
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
/*     */   public static boolean containsCell(CellRangeAddress paramCellRangeAddress, int paramInt1, int paramInt2) {
/* 352 */     return paramCellRangeAddress.isInRange(paramInt1, paramInt2);
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
/*     */   public static Cell getCellWithMerges(Sheet paramSheet, int paramInt1, int paramInt2) {
/* 367 */     Row row = paramSheet.getRow(paramInt1);
/* 368 */     if (row != null) {
/* 369 */       Cell cell = row.getCell(paramInt2);
/* 370 */       if (cell != null)
/*     */       {
/* 372 */         return cell;
/*     */       }
/*     */     } 
/*     */     
/* 376 */     for (CellRangeAddress cellRangeAddress : paramSheet.getMergedRegions()) {
/* 377 */       if (cellRangeAddress.isInRange(paramInt1, paramInt2)) {
/*     */ 
/*     */         
/* 380 */         row = paramSheet.getRow(cellRangeAddress.getFirstRow());
/* 381 */         if (row != null) {
/* 382 */           return row.getCell(cellRangeAddress.getFirstColumn());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 389 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\SheetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */