package org.apache.poi.ss.usermodel;

public interface ConditionalFormattingRule {
  BorderFormatting createBorderFormatting();
  
  BorderFormatting getBorderFormatting();
  
  FontFormatting createFontFormatting();
  
  FontFormatting getFontFormatting();
  
  PatternFormatting createPatternFormatting();
  
  PatternFormatting getPatternFormatting();
  
  DataBarFormatting getDataBarFormatting();
  
  IconMultiStateFormatting getMultiStateFormatting();
  
  ColorScaleFormatting getColorScaleFormatting();
  
  ConditionType getConditionType();
  
  byte getComparisonOperation();
  
  String getFormula1();
  
  String getFormula2();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ConditionalFormattingRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */