package org.apache.xmlbeans.impl.soap;

import org.w3c.dom.Node;

public interface Node extends Node {
  String getValue();
  
  void setParentElement(SOAPElement paramSOAPElement) throws SOAPException;
  
  SOAPElement getParentElement();
  
  void detachNode();
  
  void recycleNode();
  
  void setValue(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\Node.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */