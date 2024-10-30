package org.apache.poi.ss.usermodel;

public interface ColorScaleFormatting {
  int getNumControlPoints();
  
  void setNumControlPoints(int paramInt);
  
  Color[] getColors();
  
  void setColors(Color[] paramArrayOfColor);
  
  ConditionalFormattingThreshold[] getThresholds();
  
  void setThresholds(ConditionalFormattingThreshold[] paramArrayOfConditionalFormattingThreshold);
  
  ConditionalFormattingThreshold createThreshold();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ColorScaleFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */