package org.apache.poi.ss.usermodel;

public interface PatternFormatting {
  public static final short NO_FILL = 0;
  
  public static final short SOLID_FOREGROUND = 1;
  
  public static final short FINE_DOTS = 2;
  
  public static final short ALT_BARS = 3;
  
  public static final short SPARSE_DOTS = 4;
  
  public static final short THICK_HORZ_BANDS = 5;
  
  public static final short THICK_VERT_BANDS = 6;
  
  public static final short THICK_BACKWARD_DIAG = 7;
  
  public static final short THICK_FORWARD_DIAG = 8;
  
  public static final short BIG_SPOTS = 9;
  
  public static final short BRICKS = 10;
  
  public static final short THIN_HORZ_BANDS = 11;
  
  public static final short THIN_VERT_BANDS = 12;
  
  public static final short THIN_BACKWARD_DIAG = 13;
  
  public static final short THIN_FORWARD_DIAG = 14;
  
  public static final short SQUARES = 15;
  
  public static final short DIAMONDS = 16;
  
  public static final short LESS_DOTS = 17;
  
  public static final short LEAST_DOTS = 18;
  
  short getFillBackgroundColor();
  
  short getFillForegroundColor();
  
  Color getFillBackgroundColorColor();
  
  Color getFillForegroundColorColor();
  
  short getFillPattern();
  
  void setFillBackgroundColor(short paramShort);
  
  void setFillForegroundColor(short paramShort);
  
  void setFillBackgroundColor(Color paramColor);
  
  void setFillForegroundColor(Color paramColor);
  
  void setFillPattern(short paramShort);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PatternFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */