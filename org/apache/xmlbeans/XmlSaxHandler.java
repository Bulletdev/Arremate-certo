package org.apache.xmlbeans;

import javax.xml.namespace.b;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

public interface XmlSaxHandler {
  ContentHandler getContentHandler();
  
  LexicalHandler getLexicalHandler();
  
  void bookmarkLastEvent(XmlCursor.XmlBookmark paramXmlBookmark);
  
  void bookmarkLastAttr(b paramb, XmlCursor.XmlBookmark paramXmlBookmark);
  
  XmlObject getObject() throws XmlException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlSaxHandler.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */