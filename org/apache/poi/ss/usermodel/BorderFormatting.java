package org.apache.poi.ss.usermodel;

import org.apache.poi.util.Removal;

public interface BorderFormatting {
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
  
  short getBorderBottom();
  
  BorderStyle getBorderBottomEnum();
  
  short getBorderDiagonal();
  
  BorderStyle getBorderDiagonalEnum();
  
  short getBorderLeft();
  
  BorderStyle getBorderLeftEnum();
  
  short getBorderRight();
  
  BorderStyle getBorderRightEnum();
  
  short getBorderTop();
  
  BorderStyle getBorderTopEnum();
  
  short getBottomBorderColor();
  
  Color getBottomBorderColorColor();
  
  short getDiagonalBorderColor();
  
  Color getDiagonalBorderColorColor();
  
  short getLeftBorderColor();
  
  Color getLeftBorderColorColor();
  
  short getRightBorderColor();
  
  Color getRightBorderColorColor();
  
  short getTopBorderColor();
  
  Color getTopBorderColorColor();
  
  void setBorderBottom(short paramShort);
  
  void setBorderBottom(BorderStyle paramBorderStyle);
  
  void setBorderDiagonal(short paramShort);
  
  void setBorderDiagonal(BorderStyle paramBorderStyle);
  
  void setBorderLeft(short paramShort);
  
  void setBorderLeft(BorderStyle paramBorderStyle);
  
  void setBorderRight(short paramShort);
  
  void setBorderRight(BorderStyle paramBorderStyle);
  
  void setBorderTop(short paramShort);
  
  void setBorderTop(BorderStyle paramBorderStyle);
  
  void setBottomBorderColor(short paramShort);
  
  void setBottomBorderColor(Color paramColor);
  
  void setDiagonalBorderColor(short paramShort);
  
  void setDiagonalBorderColor(Color paramColor);
  
  void setLeftBorderColor(short paramShort);
  
  void setLeftBorderColor(Color paramColor);
  
  void setRightBorderColor(short paramShort);
  
  void setRightBorderColor(Color paramColor);
  
  void setTopBorderColor(short paramShort);
  
  void setTopBorderColor(Color paramColor);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\BorderFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */