/*      */ package org.apache.poi.hssf.usermodel;
/*      */ 
/*      */ import java.util.List;
/*      */ import org.apache.poi.hssf.model.InternalWorkbook;
/*      */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*      */ import org.apache.poi.hssf.record.FontRecord;
/*      */ import org.apache.poi.hssf.record.FormatRecord;
/*      */ import org.apache.poi.hssf.record.StyleRecord;
/*      */ import org.apache.poi.hssf.util.HSSFColor;
/*      */ import org.apache.poi.ss.usermodel.BorderStyle;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.Color;
/*      */ import org.apache.poi.ss.usermodel.FillPatternType;
/*      */ import org.apache.poi.ss.usermodel.Font;
/*      */ import org.apache.poi.ss.usermodel.HorizontalAlignment;
/*      */ import org.apache.poi.ss.usermodel.VerticalAlignment;
/*      */ import org.apache.poi.ss.usermodel.Workbook;
/*      */ import org.apache.poi.util.Removal;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class HSSFCellStyle
/*      */   implements CellStyle
/*      */ {
/*      */   private final ExtendedFormatRecord _format;
/*      */   private final short _index;
/*      */   private final InternalWorkbook _workbook;
/*      */   
/*      */   protected HSSFCellStyle(short paramShort, ExtendedFormatRecord paramExtendedFormatRecord, HSSFWorkbook paramHSSFWorkbook) {
/*   53 */     this(paramShort, paramExtendedFormatRecord, paramHSSFWorkbook.getWorkbook());
/*      */   }
/*      */   
/*      */   protected HSSFCellStyle(short paramShort, ExtendedFormatRecord paramExtendedFormatRecord, InternalWorkbook paramInternalWorkbook) {
/*   57 */     this._workbook = paramInternalWorkbook;
/*   58 */     this._index = paramShort;
/*   59 */     this._format = paramExtendedFormatRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getIndex() {
/*   70 */     return this._index;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFCellStyle getParentStyle() {
/*   79 */     short s = this._format.getParentIndex();
/*      */     
/*   81 */     if (s == 0 || s == 4095) {
/*   82 */       return null;
/*      */     }
/*   84 */     return new HSSFCellStyle(s, this._workbook.getExFormatAt(s), this._workbook);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDataFormat(short paramShort) {
/*   98 */     this._format.setFormatIndex(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getDataFormat() {
/*  108 */     return this._format.getFormatIndex();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  114 */   private static final ThreadLocal<Short> lastDateFormat = new ThreadLocal<Short>() {
/*      */       protected Short initialValue() {
/*  116 */         return Short.valueOf(-32768);
/*      */       }
/*      */     };
/*  119 */   private static final ThreadLocal<List<FormatRecord>> lastFormats = new ThreadLocal<List<FormatRecord>>();
/*  120 */   private static final ThreadLocal<String> getDataFormatStringCache = new ThreadLocal<String>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDataFormatString() {
/*  130 */     if (getDataFormatStringCache.get() != null && (
/*  131 */       (Short)lastDateFormat.get()).shortValue() == getDataFormat() && this._workbook.getFormats().equals(lastFormats.get())) {
/*  132 */       return getDataFormatStringCache.get();
/*      */     }
/*      */ 
/*      */     
/*  136 */     lastFormats.set(this._workbook.getFormats());
/*  137 */     lastDateFormat.set(Short.valueOf(getDataFormat()));
/*      */     
/*  139 */     getDataFormatStringCache.set(getDataFormatString(this._workbook));
/*      */     
/*  141 */     return getDataFormatStringCache.get();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDataFormatString(Workbook paramWorkbook) {
/*  152 */     HSSFDataFormat hSSFDataFormat = new HSSFDataFormat(((HSSFWorkbook)paramWorkbook).getWorkbook());
/*      */     
/*  154 */     short s = getDataFormat();
/*  155 */     return (s == -1) ? "General" : hSSFDataFormat.getFormat(getDataFormat());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDataFormatString(InternalWorkbook paramInternalWorkbook) {
/*  163 */     HSSFDataFormat hSSFDataFormat = new HSSFDataFormat(paramInternalWorkbook);
/*      */     
/*  165 */     return hSSFDataFormat.getFormat(getDataFormat());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFont(Font paramFont) {
/*  176 */     setFont((HSSFFont)paramFont);
/*      */   }
/*      */   public void setFont(HSSFFont paramHSSFFont) {
/*  179 */     this._format.setIndentNotParentFont(true);
/*  180 */     short s = paramHSSFFont.getIndex();
/*  181 */     this._format.setFontIndex(s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFontIndex() {
/*  191 */     return this._format.getFontIndex();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFFont getFont(Workbook paramWorkbook) {
/*  201 */     return ((HSSFWorkbook)paramWorkbook).getFontAt(getFontIndex());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHidden(boolean paramBoolean) {
/*  211 */     this._format.setIndentNotParentCellOptions(true);
/*  212 */     this._format.setHidden(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHidden() {
/*  222 */     return this._format.isHidden();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLocked(boolean paramBoolean) {
/*  232 */     this._format.setIndentNotParentCellOptions(true);
/*  233 */     this._format.setLocked(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getLocked() {
/*  243 */     return this._format.isLocked();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setAlignment(short paramShort) {
/*  262 */     this._format.setIndentNotParentAlignment(true);
/*  263 */     this._format.setAlignment(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlignment(HorizontalAlignment paramHorizontalAlignment) {
/*  272 */     this._format.setIndentNotParentAlignment(true);
/*  273 */     this._format.setAlignment(paramHorizontalAlignment.getCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getAlignment() {
/*  291 */     return this._format.getAlignment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HorizontalAlignment getAlignmentEnum() {
/*  300 */     return HorizontalAlignment.forInt(this._format.getAlignment());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWrapText(boolean paramBoolean) {
/*  310 */     this._format.setIndentNotParentAlignment(true);
/*  311 */     this._format.setWrapText(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getWrapText() {
/*  321 */     return this._format.getWrapText();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setVerticalAlignment(short paramShort) {
/*  338 */     this._format.setVerticalAlignment(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVerticalAlignment(VerticalAlignment paramVerticalAlignment) {
/*  347 */     this._format.setVerticalAlignment(paramVerticalAlignment.getCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getVerticalAlignment() {
/*  363 */     return this._format.getVerticalAlignment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VerticalAlignment getVerticalAlignmentEnum() {
/*  372 */     return VerticalAlignment.forInt(this._format.getVerticalAlignment());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRotation(short paramShort) {
/*  388 */     if (paramShort != 255)
/*      */     {
/*      */       
/*  391 */       if (paramShort < 0 && paramShort >= -90) {
/*      */ 
/*      */         
/*  394 */         paramShort = (short)(90 - paramShort);
/*      */       }
/*  396 */       else if (paramShort <= 90 || paramShort > 180) {
/*      */ 
/*      */ 
/*      */         
/*  400 */         if (paramShort < -90 || paramShort > 90)
/*      */         {
/*  402 */           throw new IllegalArgumentException("The rotation must be between -90 and 90 degrees, or 0xff"); } 
/*      */       }  } 
/*  404 */     this._format.setRotation(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getRotation() {
/*  414 */     short s = this._format.getRotation();
/*  415 */     if (s == 255)
/*      */     {
/*  417 */       return s;
/*      */     }
/*  419 */     if (s > 90)
/*      */     {
/*  421 */       s = (short)(90 - s);
/*      */     }
/*  423 */     return s;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndention(short paramShort) {
/*  433 */     this._format.setIndent(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getIndention() {
/*  443 */     return this._format.getIndent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setBorderLeft(short paramShort) {
/*  469 */     this._format.setIndentNotParentBorder(true);
/*  470 */     this._format.setBorderLeft(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderLeft(BorderStyle paramBorderStyle) {
/*  481 */     setBorderLeft(paramBorderStyle.getCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderLeft() {
/*  492 */     return this._format.getBorderLeft();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BorderStyle getBorderLeftEnum() {
/*  502 */     return BorderStyle.valueOf(this._format.getBorderLeft());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setBorderRight(short paramShort) {
/*  528 */     this._format.setIndentNotParentBorder(true);
/*  529 */     this._format.setBorderRight(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderRight(BorderStyle paramBorderStyle) {
/*  540 */     setBorderRight(paramBorderStyle.getCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderRight() {
/*  551 */     return this._format.getBorderRight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BorderStyle getBorderRightEnum() {
/*  561 */     return BorderStyle.valueOf(this._format.getBorderRight());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setBorderTop(short paramShort) {
/*  587 */     this._format.setIndentNotParentBorder(true);
/*  588 */     this._format.setBorderTop(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderTop(BorderStyle paramBorderStyle) {
/*  599 */     setBorderTop(paramBorderStyle.getCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderTop() {
/*  610 */     return this._format.getBorderTop();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BorderStyle getBorderTopEnum() {
/*  620 */     return BorderStyle.valueOf(this._format.getBorderTop());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setBorderBottom(short paramShort) {
/*  646 */     this._format.setIndentNotParentBorder(true);
/*  647 */     this._format.setBorderBottom(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderBottom(BorderStyle paramBorderStyle) {
/*  658 */     setBorderBottom(paramBorderStyle.getCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderBottom() {
/*  669 */     return this._format.getBorderBottom();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BorderStyle getBorderBottomEnum() {
/*  679 */     return BorderStyle.valueOf(this._format.getBorderBottom());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLeftBorderColor(short paramShort) {
/*  689 */     this._format.setLeftBorderPaletteIdx(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getLeftBorderColor() {
/*  700 */     return this._format.getLeftBorderPaletteIdx();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRightBorderColor(short paramShort) {
/*  710 */     this._format.setRightBorderPaletteIdx(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getRightBorderColor() {
/*  721 */     return this._format.getRightBorderPaletteIdx();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTopBorderColor(short paramShort) {
/*  731 */     this._format.setTopBorderPaletteIdx(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getTopBorderColor() {
/*  742 */     return this._format.getTopBorderPaletteIdx();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBottomBorderColor(short paramShort) {
/*  752 */     this._format.setBottomBorderPaletteIdx(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBottomBorderColor() {
/*  763 */     return this._format.getBottomBorderPaletteIdx();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setFillPattern(short paramShort) {
/*  795 */     setFillPattern(FillPatternType.forInt(paramShort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillPattern(FillPatternType paramFillPatternType) {
/*  807 */     this._format.setAdtlFillPattern(paramFillPatternType.getCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFillPattern() {
/*  818 */     return getFillPatternEnum().getCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FillPatternType getFillPatternEnum() {
/*  828 */     return FillPatternType.forInt(this._format.getAdtlFillPattern());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkDefaultBackgroundFills() {
/*  842 */     if (this._format.getFillForeground() == 64) {
/*      */ 
/*      */ 
/*      */       
/*  846 */       if (this._format.getFillBackground() != 65)
/*  847 */         setFillBackgroundColor((short)65); 
/*  848 */     } else if (this._format.getFillBackground() == 65) {
/*      */       
/*  850 */       if (this._format.getFillForeground() != 64) {
/*  851 */         setFillBackgroundColor((short)64);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillBackgroundColor(short paramShort) {
/*  882 */     this._format.setFillBackground(paramShort);
/*  883 */     checkDefaultBackgroundFills();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFillBackgroundColor() {
/*  896 */     short s = this._format.getFillBackground();
/*      */ 
/*      */     
/*  899 */     if (s == 65) {
/*  900 */       return 64;
/*      */     }
/*  902 */     return s;
/*      */   }
/*      */ 
/*      */   
/*      */   public HSSFColor getFillBackgroundColorColor() {
/*  907 */     HSSFPalette hSSFPalette = new HSSFPalette(this._workbook.getCustomPalette());
/*      */ 
/*      */     
/*  910 */     return hSSFPalette.getColor(getFillBackgroundColor());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillForegroundColor(short paramShort) {
/*  923 */     this._format.setFillForeground(paramShort);
/*  924 */     checkDefaultBackgroundFills();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFillForegroundColor() {
/*  937 */     return this._format.getFillForeground();
/*      */   }
/*      */ 
/*      */   
/*      */   public HSSFColor getFillForegroundColorColor() {
/*  942 */     HSSFPalette hSSFPalette = new HSSFPalette(this._workbook.getCustomPalette());
/*      */ 
/*      */     
/*  945 */     return hSSFPalette.getColor(getFillForegroundColor());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUserStyleName() {
/*  956 */     StyleRecord styleRecord = this._workbook.getStyleRecord(this._index);
/*  957 */     if (styleRecord == null) {
/*  958 */       return null;
/*      */     }
/*  960 */     if (styleRecord.isBuiltin()) {
/*  961 */       return null;
/*      */     }
/*  963 */     return styleRecord.getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUserStyleName(String paramString) {
/*  971 */     StyleRecord styleRecord = this._workbook.getStyleRecord(this._index);
/*  972 */     if (styleRecord == null) {
/*  973 */       styleRecord = this._workbook.createStyleRecord(this._index);
/*      */     }
/*      */ 
/*      */     
/*  977 */     if (styleRecord.isBuiltin() && this._index <= 20) {
/*  978 */       throw new IllegalArgumentException("Unable to set user specified style names for built in styles!");
/*      */     }
/*  980 */     styleRecord.setName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShrinkToFit(boolean paramBoolean) {
/*  989 */     this._format.setShrinkToFit(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getShrinkToFit() {
/*  997 */     return this._format.getShrinkToFit();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getReadingOrder() {
/* 1009 */     return this._format.getReadingOrder();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReadingOrder(short paramShort) {
/* 1020 */     this._format.setReadingOrder(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void verifyBelongsToWorkbook(HSSFWorkbook paramHSSFWorkbook) {
/* 1032 */     if (paramHSSFWorkbook.getWorkbook() != this._workbook) {
/* 1033 */       throw new IllegalArgumentException("This Style does not belong to the supplied Workbook. Are you trying to assign a style from one workbook to the cell of a differnt workbook?");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cloneStyleFrom(CellStyle paramCellStyle) {
/* 1051 */     if (paramCellStyle instanceof HSSFCellStyle) {
/* 1052 */       cloneStyleFrom((HSSFCellStyle)paramCellStyle);
/*      */     } else {
/* 1054 */       throw new IllegalArgumentException("Can only clone from one HSSFCellStyle to another, not between HSSFCellStyle and XSSFCellStyle");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void cloneStyleFrom(HSSFCellStyle paramHSSFCellStyle) {
/* 1060 */     this._format.cloneStyleFrom(paramHSSFCellStyle._format);
/*      */ 
/*      */     
/* 1063 */     if (this._workbook != paramHSSFCellStyle._workbook) {
/*      */       
/* 1065 */       lastDateFormat.set(Short.valueOf(-32768));
/* 1066 */       lastFormats.set(null);
/* 1067 */       getDataFormatStringCache.set(null);
/*      */ 
/*      */ 
/*      */       
/* 1071 */       short s = (short)this._workbook.createFormat(paramHSSFCellStyle.getDataFormatString());
/* 1072 */       setDataFormat(s);
/*      */ 
/*      */ 
/*      */       
/* 1076 */       FontRecord fontRecord = this._workbook.createNewFont();
/* 1077 */       fontRecord.cloneStyleFrom(paramHSSFCellStyle._workbook.getFontRecordAt(paramHSSFCellStyle.getFontIndex()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1083 */       HSSFFont hSSFFont = new HSSFFont((short)this._workbook.getFontIndex(fontRecord), fontRecord);
/*      */ 
/*      */       
/* 1086 */       setFont(hSSFFont);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1093 */     byte b = 31;
/* 1094 */     int i = 1;
/* 1095 */     i = 31 * i + ((this._format == null) ? 0 : this._format.hashCode());
/* 1096 */     i = 31 * i + this._index;
/* 1097 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1102 */     if (this == paramObject) return true; 
/* 1103 */     if (paramObject == null) return false; 
/* 1104 */     if (paramObject instanceof HSSFCellStyle) {
/* 1105 */       HSSFCellStyle hSSFCellStyle = (HSSFCellStyle)paramObject;
/* 1106 */       if (this._format == null) {
/* 1107 */         if (hSSFCellStyle._format != null)
/* 1108 */           return false; 
/* 1109 */       } else if (!this._format.equals(hSSFCellStyle._format)) {
/* 1110 */         return false;
/* 1111 */       }  if (this._index != hSSFCellStyle._index)
/* 1112 */         return false; 
/* 1113 */       return true;
/*      */     } 
/* 1115 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFCellStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */