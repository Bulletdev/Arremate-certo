package org.apache.poi.ss.usermodel;

public interface Textbox {
  public static final short OBJECT_TYPE_TEXT = 6;
  
  RichTextString getString();
  
  void setString(RichTextString paramRichTextString);
  
  int getMarginLeft();
  
  void setMarginLeft(int paramInt);
  
  int getMarginRight();
  
  void setMarginRight(int paramInt);
  
  int getMarginTop();
  
  void setMarginTop(int paramInt);
  
  int getMarginBottom();
  
  void setMarginBottom(int paramInt);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Textbox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */