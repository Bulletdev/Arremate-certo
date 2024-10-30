package org.apache.poi.sl.usermodel;

import java.awt.Color;
import org.apache.poi.sl.draw.geom.CustomGeometry;
import org.apache.poi.sl.draw.geom.IAdjustableShape;

public interface SimpleShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends IAdjustableShape, PlaceableShape<S, P>, Shape<S, P> {
  FillStyle getFillStyle();
  
  LineDecoration getLineDecoration();
  
  StrokeStyle getStrokeStyle();
  
  void setStrokeStyle(Object... paramVarArgs);
  
  CustomGeometry getGeometry();
  
  ShapeType getShapeType();
  
  void setShapeType(ShapeType paramShapeType);
  
  Placeholder getPlaceholder();
  
  void setPlaceholder(Placeholder paramPlaceholder);
  
  Shadow<S, P> getShadow();
  
  Color getFillColor();
  
  void setFillColor(Color paramColor);
  
  Hyperlink<S, P> getHyperlink();
  
  Hyperlink<S, P> createHyperlink();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\SimpleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */