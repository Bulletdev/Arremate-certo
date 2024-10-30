package org.apache.xmlbeans.xml.stream;

public interface ChangePrefixMapping extends XMLEvent {
  String getOldNamespaceUri();
  
  String getNewNamespaceUri();
  
  String getPrefix();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\ChangePrefixMapping.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */