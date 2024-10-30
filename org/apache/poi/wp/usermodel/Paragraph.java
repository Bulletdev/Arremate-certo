package org.apache.poi.wp.usermodel;

public interface Paragraph {
  int getIndentFromRight();
  
  void setIndentFromRight(int paramInt);
  
  int getIndentFromLeft();
  
  void setIndentFromLeft(int paramInt);
  
  int getFirstLineIndent();
  
  void setFirstLineIndent(int paramInt);
  
  int getFontAlignment();
  
  void setFontAlignment(int paramInt);
  
  boolean isWordWrapped();
  
  void setWordWrapped(boolean paramBoolean);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\w\\usermodel\Paragraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */