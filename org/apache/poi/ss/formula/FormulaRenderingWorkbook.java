package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;

public interface FormulaRenderingWorkbook {
  EvaluationWorkbook.ExternalSheet getExternalSheet(int paramInt);
  
  String getSheetFirstNameByExternSheet(int paramInt);
  
  String getSheetLastNameByExternSheet(int paramInt);
  
  String resolveNameXText(NameXPtg paramNameXPtg);
  
  String getNameText(NamePtg paramNamePtg);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaRenderingWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */