package org.apache.poi.sl.usermodel;

import java.awt.geom.Rectangle2D;

public interface GroupShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends PlaceableShape<S, P>, Shape<S, P>, ShapeContainer<S, P> {
  Rectangle2D getInteriorAnchor();
  
  void setInteriorAnchor(Rectangle2D paramRectangle2D);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\GroupShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */