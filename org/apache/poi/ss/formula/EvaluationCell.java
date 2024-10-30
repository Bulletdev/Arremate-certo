package org.apache.poi.ss.formula;

import org.apache.poi.ss.usermodel.CellType;

public interface EvaluationCell {
  Object getIdentityKey();
  
  EvaluationSheet getSheet();
  
  int getRowIndex();
  
  int getColumnIndex();
  
  int getCellType();
  
  CellType getCellTypeEnum();
  
  double getNumericCellValue();
  
  String getStringCellValue();
  
  boolean getBooleanCellValue();
  
  int getErrorCellValue();
  
  int getCachedFormulaResultType();
  
  CellType getCachedFormulaResultTypeEnum();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\EvaluationCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */