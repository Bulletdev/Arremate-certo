package org.apache.poi.xslf.usermodel;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.ShapeContainer;

public interface XSLFShapeContainer extends ShapeContainer<XSLFShape, XSLFTextParagraph> {
  XSLFAutoShape createAutoShape();
  
  XSLFFreeformShape createFreeform();
  
  XSLFTextBox createTextBox();
  
  XSLFConnectorShape createConnector();
  
  XSLFGroupShape createGroup();
  
  XSLFPictureShape createPicture(PictureData paramPictureData);
  
  void clear();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFShapeContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */