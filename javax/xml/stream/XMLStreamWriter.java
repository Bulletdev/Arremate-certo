package javax.xml.stream;

import javax.xml.namespace.a;

public interface XMLStreamWriter {
  void writeStartElement(String paramString) throws XMLStreamException;
  
  void writeStartElement(String paramString1, String paramString2) throws XMLStreamException;
  
  void writeStartElement(String paramString1, String paramString2, String paramString3) throws XMLStreamException;
  
  void writeEmptyElement(String paramString1, String paramString2) throws XMLStreamException;
  
  void writeEmptyElement(String paramString1, String paramString2, String paramString3) throws XMLStreamException;
  
  void writeEmptyElement(String paramString) throws XMLStreamException;
  
  void writeEndElement() throws XMLStreamException;
  
  void writeEndDocument() throws XMLStreamException;
  
  void close() throws XMLStreamException;
  
  void flush() throws XMLStreamException;
  
  void writeAttribute(String paramString1, String paramString2) throws XMLStreamException;
  
  void writeAttribute(String paramString1, String paramString2, String paramString3, String paramString4) throws XMLStreamException;
  
  void writeAttribute(String paramString1, String paramString2, String paramString3) throws XMLStreamException;
  
  void writeNamespace(String paramString1, String paramString2) throws XMLStreamException;
  
  void writeDefaultNamespace(String paramString) throws XMLStreamException;
  
  void writeComment(String paramString) throws XMLStreamException;
  
  void writeProcessingInstruction(String paramString) throws XMLStreamException;
  
  void writeProcessingInstruction(String paramString1, String paramString2) throws XMLStreamException;
  
  void writeCData(String paramString) throws XMLStreamException;
  
  void writeDTD(String paramString) throws XMLStreamException;
  
  void writeEntityRef(String paramString) throws XMLStreamException;
  
  void writeStartDocument() throws XMLStreamException;
  
  void writeStartDocument(String paramString) throws XMLStreamException;
  
  void writeStartDocument(String paramString1, String paramString2) throws XMLStreamException;
  
  void writeCharacters(String paramString) throws XMLStreamException;
  
  void writeCharacters(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws XMLStreamException;
  
  String getPrefix(String paramString) throws XMLStreamException;
  
  void setPrefix(String paramString1, String paramString2) throws XMLStreamException;
  
  void setDefaultNamespace(String paramString) throws XMLStreamException;
  
  void setNamespaceContext(a parama) throws XMLStreamException;
  
  a getNamespaceContext();
  
  Object getProperty(String paramString) throws IllegalArgumentException;
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\XMLStreamWriter.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */