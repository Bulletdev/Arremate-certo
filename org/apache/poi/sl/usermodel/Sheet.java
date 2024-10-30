package org.apache.poi.sl.usermodel;

import java.awt.Graphics2D;

public interface Sheet<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends ShapeContainer<S, P> {
  SlideShow<S, P> getSlideShow();
  
  boolean getFollowMasterGraphics();
  
  MasterSheet<S, P> getMasterSheet();
  
  Background<S, P> getBackground();
  
  void draw(Graphics2D paramGraphics2D);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Sheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */