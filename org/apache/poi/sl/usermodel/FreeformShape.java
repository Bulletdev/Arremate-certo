package org.apache.poi.sl.usermodel;

import java.awt.geom.Path2D;

public interface FreeformShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends AutoShape<S, P> {
  Path2D.Double getPath();
  
  int setPath(Path2D.Double paramDouble);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FreeformShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */