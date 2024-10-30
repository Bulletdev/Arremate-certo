package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddress;

public interface ConditionalFormatting {
  CellRangeAddress[] getFormattingRanges();
  
  void setRule(int paramInt, ConditionalFormattingRule paramConditionalFormattingRule);
  
  void addRule(ConditionalFormattingRule paramConditionalFormattingRule);
  
  ConditionalFormattingRule getRule(int paramInt);
  
  int getNumberOfRules();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ConditionalFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */