package org.apache.xmlbeans.xml.stream;

public interface BufferedXMLInputStream extends XMLInputStream {
  void mark() throws XMLStreamException;
  
  void reset() throws XMLStreamException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\BufferedXMLInputStream.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */