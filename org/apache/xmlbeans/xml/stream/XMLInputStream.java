package org.apache.xmlbeans.xml.stream;

public interface XMLInputStream {
  XMLEvent next() throws XMLStreamException;
  
  boolean hasNext() throws XMLStreamException;
  
  void skip() throws XMLStreamException;
  
  void skipElement() throws XMLStreamException;
  
  XMLEvent peek() throws XMLStreamException;
  
  boolean skip(int paramInt) throws XMLStreamException;
  
  boolean skip(XMLName paramXMLName) throws XMLStreamException;
  
  boolean skip(XMLName paramXMLName, int paramInt) throws XMLStreamException;
  
  XMLInputStream getSubStream() throws XMLStreamException;
  
  void close() throws XMLStreamException;
  
  ReferenceResolver getReferenceResolver();
  
  void setReferenceResolver(ReferenceResolver paramReferenceResolver);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\XMLInputStream.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */