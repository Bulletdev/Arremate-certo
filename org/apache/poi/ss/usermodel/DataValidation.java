package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddressList;

public interface DataValidation {
  DataValidationConstraint getValidationConstraint();
  
  void setErrorStyle(int paramInt);
  
  int getErrorStyle();
  
  void setEmptyCellAllowed(boolean paramBoolean);
  
  boolean getEmptyCellAllowed();
  
  void setSuppressDropDownArrow(boolean paramBoolean);
  
  boolean getSuppressDropDownArrow();
  
  void setShowPromptBox(boolean paramBoolean);
  
  boolean getShowPromptBox();
  
  void setShowErrorBox(boolean paramBoolean);
  
  boolean getShowErrorBox();
  
  void createPromptBox(String paramString1, String paramString2);
  
  String getPromptBoxTitle();
  
  String getPromptBoxText();
  
  void createErrorBox(String paramString1, String paramString2);
  
  String getErrorBoxTitle();
  
  String getErrorBoxText();
  
  CellRangeAddressList getRegions();
  
  public static final class ErrorStyle {
    public static final int STOP = 0;
    
    public static final int WARNING = 1;
    
    public static final int INFO = 2;
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\DataValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */