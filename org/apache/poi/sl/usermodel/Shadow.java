package org.apache.poi.sl.usermodel;

public interface Shadow<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> {
  SimpleShape<S, P> getShadowParent();
  
  double getDistance();
  
  double getAngle();
  
  double getBlur();
  
  PaintStyle.SolidPaint getFillStyle();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Shadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */