package org.apache.poi.xwpf.usermodel;

import org.apache.poi.POIXMLDocumentPart;

public interface IBodyElement {
  IBody getBody();
  
  POIXMLDocumentPart getPart();
  
  BodyType getPartType();
  
  BodyElementType getElementType();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\IBodyElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */