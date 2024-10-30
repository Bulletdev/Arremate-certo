package org.apache.poi.ss.usermodel;

public interface FontFormatting {
  public static final short SS_NONE = 0;
  
  public static final short SS_SUPER = 1;
  
  public static final short SS_SUB = 2;
  
  public static final byte U_NONE = 0;
  
  public static final byte U_SINGLE = 1;
  
  public static final byte U_DOUBLE = 2;
  
  public static final byte U_SINGLE_ACCOUNTING = 33;
  
  public static final byte U_DOUBLE_ACCOUNTING = 34;
  
  short getEscapementType();
  
  void setEscapementType(short paramShort);
  
  short getFontColorIndex();
  
  void setFontColorIndex(short paramShort);
  
  Color getFontColor();
  
  void setFontColor(Color paramColor);
  
  int getFontHeight();
  
  void setFontHeight(int paramInt);
  
  short getUnderlineType();
  
  void setUnderlineType(short paramShort);
  
  boolean isBold();
  
  boolean isItalic();
  
  void setFontStyle(boolean paramBoolean1, boolean paramBoolean2);
  
  void resetFontStyle();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FontFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */