package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.Ptg;

public interface EvaluationName {
  String getNameText();
  
  boolean isFunctionName();
  
  boolean hasFormula();
  
  Ptg[] getNameDefinition();
  
  boolean isRange();
  
  NamePtg createPtg();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\EvaluationName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */