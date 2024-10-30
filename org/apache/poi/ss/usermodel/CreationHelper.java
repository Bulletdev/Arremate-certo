package org.apache.poi.ss.usermodel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.util.Removal;

public interface CreationHelper {
  RichTextString createRichTextString(String paramString);
  
  DataFormat createDataFormat();
  
  @Removal(version = "3.17")
  @Deprecated
  Hyperlink createHyperlink(int paramInt);
  
  Hyperlink createHyperlink(HyperlinkType paramHyperlinkType);
  
  FormulaEvaluator createFormulaEvaluator();
  
  ExtendedColor createExtendedColor();
  
  ClientAnchor createClientAnchor();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\CreationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */