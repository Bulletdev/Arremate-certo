package org.apache.poi.wp.usermodel;

public interface CharacterRun {
  boolean isBold();
  
  void setBold(boolean paramBoolean);
  
  boolean isItalic();
  
  void setItalic(boolean paramBoolean);
  
  boolean isSmallCaps();
  
  void setSmallCaps(boolean paramBoolean);
  
  boolean isCapitalized();
  
  void setCapitalized(boolean paramBoolean);
  
  boolean isStrikeThrough();
  
  void setStrikeThrough(boolean paramBoolean);
  
  boolean isDoubleStrikeThrough();
  
  void setDoubleStrikethrough(boolean paramBoolean);
  
  boolean isShadowed();
  
  void setShadow(boolean paramBoolean);
  
  boolean isEmbossed();
  
  void setEmbossed(boolean paramBoolean);
  
  boolean isImprinted();
  
  void setImprinted(boolean paramBoolean);
  
  int getFontSize();
  
  void setFontSize(int paramInt);
  
  int getCharacterSpacing();
  
  void setCharacterSpacing(int paramInt);
  
  int getKerning();
  
  void setKerning(int paramInt);
  
  boolean isHighlighted();
  
  String getFontName();
  
  String text();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\w\\usermodel\CharacterRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */