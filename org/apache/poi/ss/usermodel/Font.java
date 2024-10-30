package org.apache.poi.ss.usermodel;

public interface Font {
  public static final short BOLDWEIGHT_NORMAL = 400;
  
  public static final short BOLDWEIGHT_BOLD = 700;
  
  public static final short COLOR_NORMAL = 32767;
  
  public static final short COLOR_RED = 10;
  
  public static final short SS_NONE = 0;
  
  public static final short SS_SUPER = 1;
  
  public static final short SS_SUB = 2;
  
  public static final byte U_NONE = 0;
  
  public static final byte U_SINGLE = 1;
  
  public static final byte U_DOUBLE = 2;
  
  public static final byte U_SINGLE_ACCOUNTING = 33;
  
  public static final byte U_DOUBLE_ACCOUNTING = 34;
  
  public static final byte ANSI_CHARSET = 0;
  
  public static final byte DEFAULT_CHARSET = 1;
  
  public static final byte SYMBOL_CHARSET = 2;
  
  void setFontName(String paramString);
  
  String getFontName();
  
  void setFontHeight(short paramShort);
  
  void setFontHeightInPoints(short paramShort);
  
  short getFontHeight();
  
  short getFontHeightInPoints();
  
  void setItalic(boolean paramBoolean);
  
  boolean getItalic();
  
  void setStrikeout(boolean paramBoolean);
  
  boolean getStrikeout();
  
  void setColor(short paramShort);
  
  short getColor();
  
  void setTypeOffset(short paramShort);
  
  short getTypeOffset();
  
  void setUnderline(byte paramByte);
  
  byte getUnderline();
  
  int getCharSet();
  
  void setCharSet(byte paramByte);
  
  void setCharSet(int paramInt);
  
  short getIndex();
  
  void setBoldweight(short paramShort);
  
  void setBold(boolean paramBoolean);
  
  short getBoldweight();
  
  boolean getBold();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Font.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */