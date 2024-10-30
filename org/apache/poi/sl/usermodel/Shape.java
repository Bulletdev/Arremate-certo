package org.apache.poi.sl.usermodel;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public interface Shape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> {
  ShapeContainer<S, P> getParent();
  
  Sheet<S, P> getSheet();
  
  Rectangle2D getAnchor();
  
  void draw(Graphics2D paramGraphics2D, Rectangle2D paramRectangle2D);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Shape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */