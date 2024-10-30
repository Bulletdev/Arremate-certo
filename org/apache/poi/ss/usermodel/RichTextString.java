package org.apache.poi.ss.usermodel;

public interface RichTextString {
  void applyFont(int paramInt1, int paramInt2, short paramShort);
  
  void applyFont(int paramInt1, int paramInt2, Font paramFont);
  
  void applyFont(Font paramFont);
  
  void clearFormatting();
  
  String getString();
  
  int length();
  
  int numFormattingRuns();
  
  int getIndexOfFormattingRun(int paramInt);
  
  void applyFont(short paramShort);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\RichTextString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */