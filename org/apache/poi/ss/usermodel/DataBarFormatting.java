package org.apache.poi.ss.usermodel;

public interface DataBarFormatting {
  boolean isLeftToRight();
  
  void setLeftToRight(boolean paramBoolean);
  
  boolean isIconOnly();
  
  void setIconOnly(boolean paramBoolean);
  
  int getWidthMin();
  
  void setWidthMin(int paramInt);
  
  int getWidthMax();
  
  void setWidthMax(int paramInt);
  
  Color getColor();
  
  void setColor(Color paramColor);
  
  ConditionalFormattingThreshold getMinThreshold();
  
  ConditionalFormattingThreshold getMaxThreshold();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\DataBarFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */