package org.apache.poi.ss.formula.ptg;

public interface Pxg {
  int getExternalWorkbookNumber();
  
  String getSheetName();
  
  void setSheetName(String paramString);
  
  String toFormulaString();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Pxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */