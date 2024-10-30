package org.apache.poi.sl.usermodel;

public interface GraphicalFrame<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends PlaceableShape<S, P>, Shape<S, P> {
  PictureShape<S, P> getFallbackPicture();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\GraphicalFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */