package org.apache.xmlbeans.xml.stream;

public interface StartDocument extends XMLEvent {
  String getSystemId();
  
  String getCharacterEncodingScheme();
  
  boolean isStandalone();
  
  String getVersion();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\StartDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */