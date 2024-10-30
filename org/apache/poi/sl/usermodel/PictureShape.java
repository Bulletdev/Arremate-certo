package org.apache.poi.sl.usermodel;

import java.awt.Insets;

public interface PictureShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends SimpleShape<S, P> {
  PictureData getPictureData();
  
  Insets getClipping();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PictureShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */