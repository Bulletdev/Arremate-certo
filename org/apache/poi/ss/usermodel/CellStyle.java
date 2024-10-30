package org.apache.poi.ss.usermodel;

import org.apache.poi.util.Removal;

public interface CellStyle {
  @Removal(version = "3.17")
  public static final short ALIGN_GENERAL = 0;
  
  @Removal(version = "3.17")
  public static final short ALIGN_LEFT = 1;
  
  @Removal(version = "3.17")
  public static final short ALIGN_CENTER = 2;
  
  @Removal(version = "3.17")
  public static final short ALIGN_RIGHT = 3;
  
  @Removal(version = "3.17")
  public static final short ALIGN_FILL = 4;
  
  @Removal(version = "3.17")
  public static final short ALIGN_JUSTIFY = 5;
  
  @Removal(version = "3.17")
  public static final short ALIGN_CENTER_SELECTION = 6;
  
  @Removal(version = "3.17")
  public static final short VERTICAL_TOP = 0;
  
  @Removal(version = "3.17")
  public static final short VERTICAL_CENTER = 1;
  
  @Removal(version = "3.17")
  public static final short VERTICAL_BOTTOM = 2;
  
  @Removal(version = "3.17")
  public static final short VERTICAL_JUSTIFY = 3;
  
  @Removal(version = "3.17")
  public static final short BORDER_NONE = 0;
  
  @Removal(version = "3.17")
  public static final short BORDER_THIN = 1;
  
  @Removal(version = "3.17")
  public static final short BORDER_MEDIUM = 2;
  
  @Removal(version = "3.17")
  public static final short BORDER_DASHED = 3;
  
  @Removal(version = "3.17")
  public static final short BORDER_DOTTED = 4;
  
  @Removal(version = "3.17")
  public static final short BORDER_THICK = 5;
  
  @Removal(version = "3.17")
  public static final short BORDER_DOUBLE = 6;
  
  @Removal(version = "3.17")
  public static final short BORDER_HAIR = 7;
  
  @Removal(version = "3.17")
  public static final short BORDER_MEDIUM_DASHED = 8;
  
  @Removal(version = "3.17")
  public static final short BORDER_DASH_DOT = 9;
  
  @Removal(version = "3.17")
  public static final short BORDER_MEDIUM_DASH_DOT = 10;
  
  @Removal(version = "3.17")
  public static final short BORDER_DASH_DOT_DOT = 11;
  
  @Removal(version = "3.17")
  public static final short BORDER_MEDIUM_DASH_DOT_DOT = 12;
  
  @Removal(version = "3.17")
  public static final short BORDER_SLANTED_DASH_DOT = 13;
  
  @Removal(version = "3.17")
  public static final short NO_FILL = 0;
  
  @Removal(version = "3.17")
  public static final short SOLID_FOREGROUND = 1;
  
  @Removal(version = "3.17")
  public static final short FINE_DOTS = 2;
  
  @Removal(version = "3.17")
  public static final short ALT_BARS = 3;
  
  @Removal(version = "3.17")
  public static final short SPARSE_DOTS = 4;
  
  @Removal(version = "3.17")
  public static final short THICK_HORZ_BANDS = 5;
  
  @Removal(version = "3.17")
  public static final short THICK_VERT_BANDS = 6;
  
  @Removal(version = "3.17")
  public static final short THICK_BACKWARD_DIAG = 7;
  
  @Removal(version = "3.17")
  public static final short THICK_FORWARD_DIAG = 8;
  
  @Removal(version = "3.17")
  public static final short BIG_SPOTS = 9;
  
  @Removal(version = "3.17")
  public static final short BRICKS = 10;
  
  @Removal(version = "3.17")
  public static final short THIN_HORZ_BANDS = 11;
  
  @Removal(version = "3.17")
  public static final short THIN_VERT_BANDS = 12;
  
  @Removal(version = "3.17")
  public static final short THIN_BACKWARD_DIAG = 13;
  
  @Removal(version = "3.17")
  public static final short THIN_FORWARD_DIAG = 14;
  
  @Removal(version = "3.17")
  public static final short SQUARES = 15;
  
  @Removal(version = "3.17")
  public static final short DIAMONDS = 16;
  
  @Removal(version = "3.17")
  public static final short LESS_DOTS = 17;
  
  @Removal(version = "3.17")
  public static final short LEAST_DOTS = 18;
  
  short getIndex();
  
  void setDataFormat(short paramShort);
  
  short getDataFormat();
  
  String getDataFormatString();
  
  void setFont(Font paramFont);
  
  short getFontIndex();
  
  void setHidden(boolean paramBoolean);
  
  boolean getHidden();
  
  void setLocked(boolean paramBoolean);
  
  boolean getLocked();
  
  void setAlignment(short paramShort);
  
  void setAlignment(HorizontalAlignment paramHorizontalAlignment);
  
  short getAlignment();
  
  HorizontalAlignment getAlignmentEnum();
  
  void setWrapText(boolean paramBoolean);
  
  boolean getWrapText();
  
  void setVerticalAlignment(short paramShort);
  
  void setVerticalAlignment(VerticalAlignment paramVerticalAlignment);
  
  short getVerticalAlignment();
  
  VerticalAlignment getVerticalAlignmentEnum();
  
  void setRotation(short paramShort);
  
  short getRotation();
  
  void setIndention(short paramShort);
  
  short getIndention();
  
  @Removal(version = "3.17")
  void setBorderLeft(short paramShort);
  
  void setBorderLeft(BorderStyle paramBorderStyle);
  
  short getBorderLeft();
  
  BorderStyle getBorderLeftEnum();
  
  @Removal(version = "3.17")
  void setBorderRight(short paramShort);
  
  void setBorderRight(BorderStyle paramBorderStyle);
  
  short getBorderRight();
  
  BorderStyle getBorderRightEnum();
  
  @Removal(version = "3.17")
  void setBorderTop(short paramShort);
  
  void setBorderTop(BorderStyle paramBorderStyle);
  
  short getBorderTop();
  
  BorderStyle getBorderTopEnum();
  
  @Removal(version = "3.17")
  void setBorderBottom(short paramShort);
  
  void setBorderBottom(BorderStyle paramBorderStyle);
  
  short getBorderBottom();
  
  BorderStyle getBorderBottomEnum();
  
  void setLeftBorderColor(short paramShort);
  
  short getLeftBorderColor();
  
  void setRightBorderColor(short paramShort);
  
  short getRightBorderColor();
  
  void setTopBorderColor(short paramShort);
  
  short getTopBorderColor();
  
  void setBottomBorderColor(short paramShort);
  
  short getBottomBorderColor();
  
  void setFillPattern(short paramShort);
  
  void setFillPattern(FillPatternType paramFillPatternType);
  
  short getFillPattern();
  
  FillPatternType getFillPatternEnum();
  
  void setFillBackgroundColor(short paramShort);
  
  short getFillBackgroundColor();
  
  Color getFillBackgroundColorColor();
  
  void setFillForegroundColor(short paramShort);
  
  short getFillForegroundColor();
  
  Color getFillForegroundColorColor();
  
  void cloneStyleFrom(CellStyle paramCellStyle);
  
  void setShrinkToFit(boolean paramBoolean);
  
  boolean getShrinkToFit();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\CellStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */