package org.apache.poi.sl.usermodel;

import java.util.List;

public interface ShapeContainer<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Iterable<S> {
  List<S> getShapes();
  
  void addShape(S paramS);
  
  boolean removeShape(S paramS);
  
  AutoShape<S, P> createAutoShape();
  
  FreeformShape<S, P> createFreeform();
  
  TextBox<S, P> createTextBox();
  
  ConnectorShape<S, P> createConnector();
  
  GroupShape<S, P> createGroup();
  
  PictureShape<S, P> createPicture(PictureData paramPictureData);
  
  TableShape<S, P> createTable(int paramInt1, int paramInt2);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ShapeContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */