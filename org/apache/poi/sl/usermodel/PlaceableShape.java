package org.apache.poi.sl.usermodel;

import java.awt.geom.Rectangle2D;

public interface PlaceableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> {
  ShapeContainer<S, P> getParent();
  
  Sheet<S, P> getSheet();
  
  Rectangle2D getAnchor();
  
  void setAnchor(Rectangle2D paramRectangle2D);
  
  double getRotation();
  
  void setRotation(double paramDouble);
  
  void setFlipHorizontal(boolean paramBoolean);
  
  void setFlipVertical(boolean paramBoolean);
  
  boolean getFlipHorizontal();
  
  boolean getFlipVertical();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PlaceableShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */