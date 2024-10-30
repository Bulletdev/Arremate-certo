package org.apache.poi.ss.usermodel;

public interface Name {
  String getSheetName();
  
  String getNameName();
  
  void setNameName(String paramString);
  
  String getRefersToFormula();
  
  void setRefersToFormula(String paramString);
  
  boolean isFunctionName();
  
  boolean isDeleted();
  
  void setSheetIndex(int paramInt);
  
  int getSheetIndex();
  
  String getComment();
  
  void setComment(String paramString);
  
  void setFunction(boolean paramBoolean);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Name.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */