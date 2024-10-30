package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddressList;

public interface DataValidationHelper {
  DataValidationConstraint createFormulaListConstraint(String paramString);
  
  DataValidationConstraint createExplicitListConstraint(String[] paramArrayOfString);
  
  DataValidationConstraint createNumericConstraint(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  DataValidationConstraint createTextLengthConstraint(int paramInt, String paramString1, String paramString2);
  
  DataValidationConstraint createDecimalConstraint(int paramInt, String paramString1, String paramString2);
  
  DataValidationConstraint createIntegerConstraint(int paramInt, String paramString1, String paramString2);
  
  DataValidationConstraint createDateConstraint(int paramInt, String paramString1, String paramString2, String paramString3);
  
  DataValidationConstraint createTimeConstraint(int paramInt, String paramString1, String paramString2);
  
  DataValidationConstraint createCustomConstraint(String paramString);
  
  DataValidation createValidation(DataValidationConstraint paramDataValidationConstraint, CellRangeAddressList paramCellRangeAddressList);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\DataValidationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */