package org.apache.xmlbeans.xml.stream;

import java.util.Map;

public interface StartElement extends XMLEvent {
  AttributeIterator getAttributes();
  
  AttributeIterator getNamespaces();
  
  AttributeIterator getAttributesAndNamespaces();
  
  Attribute getAttributeByName(XMLName paramXMLName);
  
  String getNamespaceUri(String paramString);
  
  Map getNamespaceMap();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\StartElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */