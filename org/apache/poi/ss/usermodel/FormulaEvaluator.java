package org.apache.poi.ss.usermodel;

import java.util.Map;
import org.apache.poi.util.Internal;

public interface FormulaEvaluator {
  void clearAllCachedResultValues();
  
  void notifySetFormula(Cell paramCell);
  
  void notifyDeleteCell(Cell paramCell);
  
  void notifyUpdateCell(Cell paramCell);
  
  void evaluateAll();
  
  CellValue evaluate(Cell paramCell);
  
  int evaluateFormulaCell(Cell paramCell);
  
  @Internal(since = "POI 3.15 beta 3")
  CellType evaluateFormulaCellEnum(Cell paramCell);
  
  Cell evaluateInCell(Cell paramCell);
  
  void setupReferencedWorkbooks(Map<String, FormulaEvaluator> paramMap);
  
  void setIgnoreMissingWorkbooks(boolean paramBoolean);
  
  void setDebugEvaluationOutputForNextEval(boolean paramBoolean);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FormulaEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */