package org.apache.xmlbeans.xml.stream;

public interface AttributeIterator {
  Attribute next();
  
  boolean hasNext();
  
  Attribute peek();
  
  void skip();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\AttributeIterator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */