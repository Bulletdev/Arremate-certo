package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

public interface FormulaParsingWorkbook {
  EvaluationName getName(String paramString, int paramInt);
  
  Name createName();
  
  Table getTable(String paramString);
  
  Ptg getNameXPtg(String paramString, SheetIdentifier paramSheetIdentifier);
  
  Ptg get3DReferencePtg(CellReference paramCellReference, SheetIdentifier paramSheetIdentifier);
  
  Ptg get3DReferencePtg(AreaReference paramAreaReference, SheetIdentifier paramSheetIdentifier);
  
  int getExternalSheetIndex(String paramString);
  
  int getExternalSheetIndex(String paramString1, String paramString2);
  
  SpreadsheetVersion getSpreadsheetVersion();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaParsingWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */