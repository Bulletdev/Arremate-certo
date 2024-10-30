/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.ss.usermodel.BorderStyle;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.FillPatternType;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.HorizontalAlignment;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.VerticalAlignment;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public final class CellUtil
/*     */ {
/*  55 */   private static final POILogger log = POILogFactory.getLogger(CellUtil.class);
/*     */   
/*     */   public static final String ALIGNMENT = "alignment";
/*     */   
/*     */   public static final String BORDER_BOTTOM = "borderBottom";
/*     */   
/*     */   public static final String BORDER_LEFT = "borderLeft";
/*     */   public static final String BORDER_RIGHT = "borderRight";
/*     */   public static final String BORDER_TOP = "borderTop";
/*     */   public static final String BOTTOM_BORDER_COLOR = "bottomBorderColor";
/*     */   public static final String LEFT_BORDER_COLOR = "leftBorderColor";
/*     */   public static final String RIGHT_BORDER_COLOR = "rightBorderColor";
/*     */   public static final String TOP_BORDER_COLOR = "topBorderColor";
/*     */   public static final String DATA_FORMAT = "dataFormat";
/*     */   public static final String FILL_BACKGROUND_COLOR = "fillBackgroundColor";
/*     */   public static final String FILL_FOREGROUND_COLOR = "fillForegroundColor";
/*     */   public static final String FILL_PATTERN = "fillPattern";
/*     */   public static final String FONT = "font";
/*     */   public static final String HIDDEN = "hidden";
/*     */   public static final String INDENTION = "indention";
/*     */   public static final String LOCKED = "locked";
/*     */   public static final String ROTATION = "rotation";
/*     */   public static final String VERTICAL_ALIGNMENT = "verticalAlignment";
/*     */   public static final String WRAP_TEXT = "wrapText";
/*  79 */   private static final Set<String> shortValues = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "bottomBorderColor", "leftBorderColor", "rightBorderColor", "topBorderColor", "fillForegroundColor", "fillBackgroundColor", "indention", "dataFormat", "font", "rotation" })));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   private static final Set<String> booleanValues = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "locked", "hidden", "wrapText" })));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   private static final Set<String> borderTypeValues = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "borderBottom", "borderLeft", "borderRight", "borderTop" })));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class UnicodeMapping
/*     */   {
/*     */     public final String entityName;
/*     */ 
/*     */ 
/*     */     
/*     */     public final String resolvedValue;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public UnicodeMapping(String param1String1, String param1String2) {
/* 116 */       this.entityName = "&" + param1String1 + ";";
/* 117 */       this.resolvedValue = param1String2;
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
/*     */   
/*     */   public static Row getRow(int paramInt, Sheet paramSheet) {
/* 133 */     Row row = paramSheet.getRow(paramInt);
/* 134 */     if (row == null) {
/* 135 */       row = paramSheet.createRow(paramInt);
/*     */     }
/* 137 */     return row;
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
/*     */   public static Cell getCell(Row paramRow, int paramInt) {
/* 149 */     Cell cell = paramRow.getCell(paramInt);
/*     */     
/* 151 */     if (cell == null) {
/* 152 */       cell = paramRow.createCell(paramInt);
/*     */     }
/* 154 */     return cell;
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
/*     */   public static Cell createCell(Row paramRow, int paramInt, String paramString, CellStyle paramCellStyle) {
/* 168 */     Cell cell = getCell(paramRow, paramInt);
/*     */     
/* 170 */     cell.setCellValue(cell.getRow().getSheet().getWorkbook().getCreationHelper().createRichTextString(paramString));
/*     */     
/* 172 */     if (paramCellStyle != null) {
/* 173 */       cell.setCellStyle(paramCellStyle);
/*     */     }
/* 175 */     return cell;
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
/*     */   public static Cell createCell(Row paramRow, int paramInt, String paramString) {
/* 188 */     return createCell(paramRow, paramInt, paramString, null);
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
/*     */   @Deprecated
/*     */   @Removal(version = "3.17")
/*     */   public static void setAlignment(Cell paramCell, Workbook paramWorkbook, short paramShort) {
/* 211 */     setAlignment(paramCell, HorizontalAlignment.forInt(paramShort));
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
/*     */   public static void setAlignment(Cell paramCell, HorizontalAlignment paramHorizontalAlignment) {
/* 230 */     setCellStyleProperty(paramCell, "alignment", paramHorizontalAlignment);
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
/*     */   public static void setVerticalAlignment(Cell paramCell, VerticalAlignment paramVerticalAlignment) {
/* 249 */     setCellStyleProperty(paramCell, "verticalAlignment", paramVerticalAlignment);
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
/*     */   @Deprecated
/*     */   @Removal(version = "3.17")
/*     */   public static void setFont(Cell paramCell, Workbook paramWorkbook, Font paramFont) {
/* 265 */     setFont(paramCell, paramFont);
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
/*     */   public static void setFont(Cell paramCell, Font paramFont) {
/* 277 */     Workbook workbook = paramCell.getSheet().getWorkbook();
/* 278 */     short s = paramFont.getIndex();
/* 279 */     if (!workbook.getFontAt(s).equals(paramFont)) {
/* 280 */       throw new IllegalArgumentException("Font does not belong to this workbook");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     setCellStyleProperty(paramCell, "font", Short.valueOf(s));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCellStyleProperties(Cell paramCell, Map<String, Object> paramMap) {
/* 315 */     Workbook workbook = paramCell.getSheet().getWorkbook();
/* 316 */     CellStyle cellStyle1 = paramCell.getCellStyle();
/* 317 */     CellStyle cellStyle2 = null;
/* 318 */     Map<String, Object> map = getFormatProperties(cellStyle1);
/* 319 */     putAll(paramMap, map);
/*     */ 
/*     */ 
/*     */     
/* 323 */     int i = workbook.getNumCellStyles();
/*     */     
/* 325 */     for (byte b = 0; b < i; b++) {
/* 326 */       CellStyle cellStyle = workbook.getCellStyleAt(b);
/* 327 */       Map<String, Object> map1 = getFormatProperties(cellStyle);
/*     */ 
/*     */       
/* 330 */       if (map1.equals(map)) {
/* 331 */         cellStyle2 = cellStyle;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 337 */     if (cellStyle2 == null) {
/* 338 */       cellStyle2 = workbook.createCellStyle();
/* 339 */       setFormatProperties(cellStyle2, workbook, map);
/*     */     } 
/*     */     
/* 342 */     paramCell.setCellStyle(cellStyle2);
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
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @Removal(version = "3.17")
/*     */   public static void setCellStyleProperty(Cell paramCell, Workbook paramWorkbook, String paramString, Object paramObject) {
/* 369 */     setCellStyleProperty(paramCell, paramString, paramObject);
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
/*     */   public static void setCellStyleProperty(Cell paramCell, String paramString, Object paramObject) {
/* 390 */     Map<String, Object> map = Collections.singletonMap(paramString, paramObject);
/* 391 */     setCellStyleProperties(paramCell, map);
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
/*     */   private static Map<String, Object> getFormatProperties(CellStyle paramCellStyle) {
/* 405 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 406 */     put((Map)hashMap, "alignment", paramCellStyle.getAlignmentEnum());
/* 407 */     put((Map)hashMap, "verticalAlignment", paramCellStyle.getVerticalAlignmentEnum());
/* 408 */     put((Map)hashMap, "borderBottom", paramCellStyle.getBorderBottomEnum());
/* 409 */     put((Map)hashMap, "borderLeft", paramCellStyle.getBorderLeftEnum());
/* 410 */     put((Map)hashMap, "borderRight", paramCellStyle.getBorderRightEnum());
/* 411 */     put((Map)hashMap, "borderTop", paramCellStyle.getBorderTopEnum());
/* 412 */     put((Map)hashMap, "bottomBorderColor", Short.valueOf(paramCellStyle.getBottomBorderColor()));
/* 413 */     put((Map)hashMap, "dataFormat", Short.valueOf(paramCellStyle.getDataFormat()));
/* 414 */     put((Map)hashMap, "fillPattern", paramCellStyle.getFillPatternEnum());
/* 415 */     put((Map)hashMap, "fillForegroundColor", Short.valueOf(paramCellStyle.getFillForegroundColor()));
/* 416 */     put((Map)hashMap, "fillBackgroundColor", Short.valueOf(paramCellStyle.getFillBackgroundColor()));
/* 417 */     put((Map)hashMap, "font", Short.valueOf(paramCellStyle.getFontIndex()));
/* 418 */     put((Map)hashMap, "hidden", Boolean.valueOf(paramCellStyle.getHidden()));
/* 419 */     put((Map)hashMap, "indention", Short.valueOf(paramCellStyle.getIndention()));
/* 420 */     put((Map)hashMap, "leftBorderColor", Short.valueOf(paramCellStyle.getLeftBorderColor()));
/* 421 */     put((Map)hashMap, "locked", Boolean.valueOf(paramCellStyle.getLocked()));
/* 422 */     put((Map)hashMap, "rightBorderColor", Short.valueOf(paramCellStyle.getRightBorderColor()));
/* 423 */     put((Map)hashMap, "rotation", Short.valueOf(paramCellStyle.getRotation()));
/* 424 */     put((Map)hashMap, "topBorderColor", Short.valueOf(paramCellStyle.getTopBorderColor()));
/* 425 */     put((Map)hashMap, "wrapText", Boolean.valueOf(paramCellStyle.getWrapText()));
/* 426 */     return (Map)hashMap;
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
/*     */   private static void putAll(Map<String, Object> paramMap1, Map<String, Object> paramMap2) {
/* 438 */     for (String str : paramMap1.keySet()) {
/* 439 */       if (shortValues.contains(str)) {
/* 440 */         paramMap2.put(str, Short.valueOf(getShort(paramMap1, str))); continue;
/* 441 */       }  if (booleanValues.contains(str)) {
/* 442 */         paramMap2.put(str, Boolean.valueOf(getBoolean(paramMap1, str))); continue;
/* 443 */       }  if (borderTypeValues.contains(str)) {
/* 444 */         paramMap2.put(str, getBorderStyle(paramMap1, str)); continue;
/* 445 */       }  if ("alignment".equals(str)) {
/* 446 */         paramMap2.put(str, getHorizontalAlignment(paramMap1, str)); continue;
/* 447 */       }  if ("verticalAlignment".equals(str)) {
/* 448 */         paramMap2.put(str, getVerticalAlignment(paramMap1, str)); continue;
/* 449 */       }  if ("fillPattern".equals(str)) {
/* 450 */         paramMap2.put(str, getFillPattern(paramMap1, str)); continue;
/*     */       } 
/* 452 */       if (log.check(3)) {
/* 453 */         log.log(3, new Object[] { "Ignoring unrecognized CellUtil format properties key: " + str });
/*     */       }
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
/*     */   private static void setFormatProperties(CellStyle paramCellStyle, Workbook paramWorkbook, Map<String, Object> paramMap) {
/* 468 */     paramCellStyle.setAlignment(getHorizontalAlignment(paramMap, "alignment"));
/* 469 */     paramCellStyle.setVerticalAlignment(getVerticalAlignment(paramMap, "verticalAlignment"));
/* 470 */     paramCellStyle.setBorderBottom(getBorderStyle(paramMap, "borderBottom"));
/* 471 */     paramCellStyle.setBorderLeft(getBorderStyle(paramMap, "borderLeft"));
/* 472 */     paramCellStyle.setBorderRight(getBorderStyle(paramMap, "borderRight"));
/* 473 */     paramCellStyle.setBorderTop(getBorderStyle(paramMap, "borderTop"));
/* 474 */     paramCellStyle.setBottomBorderColor(getShort(paramMap, "bottomBorderColor"));
/* 475 */     paramCellStyle.setDataFormat(getShort(paramMap, "dataFormat"));
/* 476 */     paramCellStyle.setFillPattern(getFillPattern(paramMap, "fillPattern"));
/* 477 */     paramCellStyle.setFillForegroundColor(getShort(paramMap, "fillForegroundColor"));
/* 478 */     paramCellStyle.setFillBackgroundColor(getShort(paramMap, "fillBackgroundColor"));
/* 479 */     paramCellStyle.setFont(paramWorkbook.getFontAt(getShort(paramMap, "font")));
/* 480 */     paramCellStyle.setHidden(getBoolean(paramMap, "hidden"));
/* 481 */     paramCellStyle.setIndention(getShort(paramMap, "indention"));
/* 482 */     paramCellStyle.setLeftBorderColor(getShort(paramMap, "leftBorderColor"));
/* 483 */     paramCellStyle.setLocked(getBoolean(paramMap, "locked"));
/* 484 */     paramCellStyle.setRightBorderColor(getShort(paramMap, "rightBorderColor"));
/* 485 */     paramCellStyle.setRotation(getShort(paramMap, "rotation"));
/* 486 */     paramCellStyle.setTopBorderColor(getShort(paramMap, "topBorderColor"));
/* 487 */     paramCellStyle.setWrapText(getBoolean(paramMap, "wrapText"));
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
/*     */   private static short getShort(Map<String, Object> paramMap, String paramString) {
/* 499 */     Object object = paramMap.get(paramString);
/* 500 */     if (object instanceof Short) {
/* 501 */       return ((Short)object).shortValue();
/*     */     }
/* 503 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static BorderStyle getBorderStyle(Map<String, Object> paramMap, String paramString) {
/*     */     BorderStyle borderStyle;
/* 514 */     Object object = paramMap.get(paramString);
/*     */     
/* 516 */     if (object instanceof BorderStyle) {
/* 517 */       borderStyle = (BorderStyle)object;
/*     */     
/*     */     }
/* 520 */     else if (object instanceof Short) {
/* 521 */       if (log.check(5)) {
/* 522 */         log.log(5, new Object[] { "Deprecation warning: CellUtil properties map uses Short values for " + paramString + ". Should use BorderStyle enums instead." });
/*     */       }
/*     */       
/* 525 */       System.out.println("BorderStyle short usage");
/* 526 */       short s = ((Short)object).shortValue();
/* 527 */       borderStyle = BorderStyle.valueOf(s);
/*     */     }
/* 529 */     else if (object == null) {
/* 530 */       borderStyle = BorderStyle.NONE;
/*     */     } else {
/*     */       
/* 533 */       throw new RuntimeException("Unexpected border style class. Must be BorderStyle or Short (deprecated).");
/*     */     } 
/* 535 */     return borderStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static FillPatternType getFillPattern(Map<String, Object> paramMap, String paramString) {
/*     */     FillPatternType fillPatternType;
/* 547 */     Object object = paramMap.get(paramString);
/*     */     
/* 549 */     if (object instanceof FillPatternType) {
/* 550 */       fillPatternType = (FillPatternType)object;
/*     */     
/*     */     }
/* 553 */     else if (object instanceof Short) {
/* 554 */       if (log.check(5)) {
/* 555 */         log.log(5, new Object[] { "Deprecation warning: CellUtil properties map uses Short values for " + paramString + ". Should use FillPatternType enums instead." });
/*     */       }
/*     */       
/* 558 */       System.out.println("FillPatternType short usage");
/* 559 */       short s = ((Short)object).shortValue();
/* 560 */       fillPatternType = FillPatternType.forInt(s);
/*     */     }
/* 562 */     else if (object == null) {
/* 563 */       fillPatternType = FillPatternType.NO_FILL;
/*     */     } else {
/*     */       
/* 566 */       throw new RuntimeException("Unexpected fill pattern style class. Must be FillPatternType or Short (deprecated).");
/*     */     } 
/* 568 */     return fillPatternType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static HorizontalAlignment getHorizontalAlignment(Map<String, Object> paramMap, String paramString) {
/*     */     HorizontalAlignment horizontalAlignment;
/* 580 */     Object object = paramMap.get(paramString);
/*     */     
/* 582 */     if (object instanceof HorizontalAlignment) {
/* 583 */       horizontalAlignment = (HorizontalAlignment)object;
/*     */     
/*     */     }
/* 586 */     else if (object instanceof Short) {
/* 587 */       if (log.check(5)) {
/* 588 */         log.log(5, new Object[] { "Deprecation warning: CellUtil properties map used a Short value for " + paramString + ". Should use HorizontalAlignment enums instead." });
/*     */       }
/*     */       
/* 591 */       System.out.println("HorizontalAlignment short usage");
/* 592 */       short s = ((Short)object).shortValue();
/* 593 */       horizontalAlignment = HorizontalAlignment.forInt(s);
/*     */     }
/* 595 */     else if (object == null) {
/* 596 */       horizontalAlignment = HorizontalAlignment.GENERAL;
/*     */     } else {
/*     */       
/* 599 */       throw new RuntimeException("Unexpected horizontal alignment style class. Must be HorizontalAlignment or Short (deprecated).");
/*     */     } 
/* 601 */     return horizontalAlignment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static VerticalAlignment getVerticalAlignment(Map<String, Object> paramMap, String paramString) {
/*     */     VerticalAlignment verticalAlignment;
/* 613 */     Object object = paramMap.get(paramString);
/*     */     
/* 615 */     if (object instanceof VerticalAlignment) {
/* 616 */       verticalAlignment = (VerticalAlignment)object;
/*     */     
/*     */     }
/* 619 */     else if (object instanceof Short) {
/* 620 */       if (log.check(5)) {
/* 621 */         log.log(5, new Object[] { "Deprecation warning: CellUtil properties map used a Short value for " + paramString + ". Should use VerticalAlignment enums instead." });
/*     */       }
/*     */       
/* 624 */       System.out.println("VerticalAlignment usage " + paramString + " " + object);
/* 625 */       short s = ((Short)object).shortValue();
/* 626 */       verticalAlignment = VerticalAlignment.forInt(s);
/*     */     }
/* 628 */     else if (object == null) {
/* 629 */       verticalAlignment = VerticalAlignment.BOTTOM;
/*     */     } else {
/*     */       
/* 632 */       throw new RuntimeException("Unexpected vertical alignment style class. Must be VerticalAlignment or Short (deprecated).");
/*     */     } 
/* 634 */     return verticalAlignment;
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
/*     */   private static boolean getBoolean(Map<String, Object> paramMap, String paramString) {
/* 646 */     Object object = paramMap.get(paramString);
/*     */     
/* 648 */     if (object instanceof Boolean) {
/* 649 */       return ((Boolean)object).booleanValue();
/*     */     }
/* 651 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void put(Map<String, Object> paramMap, String paramString, Object paramObject) {
/* 662 */     paramMap.put(paramString, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void putShort(Map<String, Object> paramMap, String paramString, short paramShort) {
/* 673 */     paramMap.put(paramString, Short.valueOf(paramShort));
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
/*     */   private static void putEnum(Map<String, Object> paramMap, String paramString, Enum<?> paramEnum) {
/* 685 */     paramMap.put(paramString, paramEnum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void putBoolean(Map<String, Object> paramMap, String paramString, boolean paramBoolean) {
/* 696 */     paramMap.put(paramString, Boolean.valueOf(paramBoolean));
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
/*     */   public static Cell translateUnicodeValues(Cell paramCell) {
/* 708 */     String str1 = paramCell.getRichStringCellValue().getString();
/* 709 */     boolean bool = false;
/* 710 */     String str2 = str1.toLowerCase(Locale.ROOT);
/*     */     
/* 712 */     for (UnicodeMapping unicodeMapping : unicodeMappings) {
/* 713 */       String str = unicodeMapping.entityName;
/* 714 */       if (str2.contains(str)) {
/* 715 */         str1 = str1.replaceAll(str, unicodeMapping.resolvedValue);
/* 716 */         bool = true;
/*     */       } 
/*     */     } 
/* 719 */     if (bool) {
/* 720 */       paramCell.setCellValue(paramCell.getRow().getSheet().getWorkbook().getCreationHelper().createRichTextString(str1));
/*     */     }
/*     */     
/* 723 */     return paramCell;
/*     */   }
/*     */ 
/*     */   
/* 727 */   private static UnicodeMapping[] unicodeMappings = new UnicodeMapping[] { um("alpha", "α"), um("beta", "β"), um("gamma", "γ"), um("delta", "δ"), um("epsilon", "ε"), um("zeta", "ζ"), um("eta", "η"), um("theta", "θ"), um("iota", "ι"), um("kappa", "κ"), um("lambda", "λ"), um("mu", "μ"), um("nu", "ν"), um("xi", "ξ"), um("omicron", "ο") };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static UnicodeMapping um(String paramString1, String paramString2) {
/* 747 */     return new UnicodeMapping(paramString1, paramString2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\CellUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */