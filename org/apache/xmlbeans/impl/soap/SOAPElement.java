package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;
import org.w3c.dom.Element;

public interface SOAPElement extends Node, Element {
  SOAPElement addChildElement(Name paramName) throws SOAPException;
  
  SOAPElement addChildElement(String paramString) throws SOAPException;
  
  SOAPElement addChildElement(String paramString1, String paramString2) throws SOAPException;
  
  SOAPElement addChildElement(String paramString1, String paramString2, String paramString3) throws SOAPException;
  
  SOAPElement addChildElement(SOAPElement paramSOAPElement) throws SOAPException;
  
  SOAPElement addTextNode(String paramString) throws SOAPException;
  
  SOAPElement addAttribute(Name paramName, String paramString) throws SOAPException;
  
  SOAPElement addNamespaceDeclaration(String paramString1, String paramString2) throws SOAPException;
  
  String getAttributeValue(Name paramName);
  
  Iterator getAllAttributes();
  
  String getNamespaceURI(String paramString);
  
  Iterator getNamespacePrefixes();
  
  Name getElementName();
  
  boolean removeAttribute(Name paramName);
  
  boolean removeNamespaceDeclaration(String paramString);
  
  Iterator getChildElements();
  
  Iterator getChildElements(Name paramName);
  
  void setEncodingStyle(String paramString) throws SOAPException;
  
  String getEncodingStyle();
  
  void removeContents();
  
  Iterator getVisibleNamespacePrefixes();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */