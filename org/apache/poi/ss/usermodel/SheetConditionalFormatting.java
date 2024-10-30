package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddress;

public interface SheetConditionalFormatting {
  int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule paramConditionalFormattingRule);
  
  int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule paramConditionalFormattingRule1, ConditionalFormattingRule paramConditionalFormattingRule2);
  
  int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule[] paramArrayOfConditionalFormattingRule);
  
  int addConditionalFormatting(ConditionalFormatting paramConditionalFormatting);
  
  ConditionalFormattingRule createConditionalFormattingRule(byte paramByte, String paramString1, String paramString2);
  
  ConditionalFormattingRule createConditionalFormattingRule(byte paramByte, String paramString);
  
  ConditionalFormattingRule createConditionalFormattingRule(String paramString);
  
  ConditionalFormattingRule createConditionalFormattingRule(ExtendedColor paramExtendedColor);
  
  ConditionalFormattingRule createConditionalFormattingRule(IconMultiStateFormatting.IconSet paramIconSet);
  
  ConditionalFormattingRule createConditionalFormattingColorScaleRule();
  
  ConditionalFormatting getConditionalFormattingAt(int paramInt);
  
  int getNumConditionalFormattings();
  
  void removeConditionalFormatting(int paramInt);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\SheetConditionalFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */