package org.apache.poi.sl.usermodel;

public interface Slide<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Sheet<S, P> {
  Notes<S, P> getNotes();
  
  void setNotes(Notes<S, P> paramNotes);
  
  boolean getFollowMasterBackground();
  
  void setFollowMasterBackground(boolean paramBoolean);
  
  boolean getFollowMasterColourScheme();
  
  void setFollowMasterColourScheme(boolean paramBoolean);
  
  boolean getFollowMasterObjects();
  
  void setFollowMasterObjects(boolean paramBoolean);
  
  int getSlideNumber();
  
  String getTitle();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Slide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */