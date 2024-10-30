package org.apache.xmlbeans.xml.stream;

public interface ReferenceResolver {
  XMLInputStream resolve(String paramString) throws XMLStreamException;
  
  String getId(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\ReferenceResolver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */