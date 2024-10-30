package javax.xml.stream;

import javax.xml.namespace.a;
import javax.xml.namespace.b;

public interface XMLStreamReader extends XMLStreamConstants {
  Object getProperty(String paramString) throws IllegalArgumentException;
  
  int next() throws XMLStreamException;
  
  void require(int paramInt, String paramString1, String paramString2) throws XMLStreamException;
  
  String getElementText() throws XMLStreamException;
  
  int nextTag() throws XMLStreamException;
  
  boolean hasNext() throws XMLStreamException;
  
  void close() throws XMLStreamException;
  
  String getNamespaceURI(String paramString);
  
  boolean isStartElement();
  
  boolean isEndElement();
  
  boolean isCharacters();
  
  boolean isWhiteSpace();
  
  String getAttributeValue(String paramString1, String paramString2);
  
  int getAttributeCount();
  
  b getAttributeName(int paramInt);
  
  String getAttributeNamespace(int paramInt);
  
  String getAttributeLocalName(int paramInt);
  
  String getAttributePrefix(int paramInt);
  
  String getAttributeType(int paramInt);
  
  String getAttributeValue(int paramInt);
  
  boolean isAttributeSpecified(int paramInt);
  
  int getNamespaceCount();
  
  String getNamespacePrefix(int paramInt);
  
  String getNamespaceURI(int paramInt);
  
  a getNamespaceContext();
  
  int getEventType();
  
  String getText();
  
  char[] getTextCharacters();
  
  int getTextCharacters(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) throws XMLStreamException;
  
  int getTextStart();
  
  int getTextLength();
  
  String getEncoding();
  
  boolean hasText();
  
  Location getLocation();
  
  b getName();
  
  String getLocalName();
  
  boolean hasName();
  
  String getNamespaceURI();
  
  String getPrefix();
  
  String getVersion();
  
  boolean isStandalone();
  
  boolean standaloneSet();
  
  String getCharacterEncodingScheme();
  
  String getPITarget();
  
  String getPIData();
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\XMLStreamReader.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */