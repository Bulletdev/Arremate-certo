package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellAddress;

public interface Comment {
  void setVisible(boolean paramBoolean);
  
  boolean isVisible();
  
  CellAddress getAddress();
  
  void setAddress(CellAddress paramCellAddress);
  
  void setAddress(int paramInt1, int paramInt2);
  
  int getRow();
  
  void setRow(int paramInt);
  
  int getColumn();
  
  void setColumn(int paramInt);
  
  String getAuthor();
  
  void setAuthor(String paramString);
  
  RichTextString getString();
  
  void setString(RichTextString paramRichTextString);
  
  ClientAnchor getClientAnchor();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Comment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */