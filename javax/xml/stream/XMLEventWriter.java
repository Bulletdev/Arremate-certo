package javax.xml.stream;

import javax.xml.namespace.a;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.XMLEventConsumer;

public interface XMLEventWriter extends XMLEventConsumer {
  void flush() throws XMLStreamException;
  
  void close() throws XMLStreamException;
  
  void add(XMLEvent paramXMLEvent) throws XMLStreamException;
  
  void add(XMLEventReader paramXMLEventReader) throws XMLStreamException;
  
  String getPrefix(String paramString) throws XMLStreamException;
  
  void setPrefix(String paramString1, String paramString2) throws XMLStreamException;
  
  void setDefaultNamespace(String paramString) throws XMLStreamException;
  
  void setNamespaceContext(a parama) throws XMLStreamException;
  
  a getNamespaceContext();
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\XMLEventWriter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */