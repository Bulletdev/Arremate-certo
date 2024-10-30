package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

public interface XmlTokenSource {
  Object monitor();
  
  XmlDocumentProperties documentProperties();
  
  XmlCursor newCursor();
  
  XMLInputStream newXMLInputStream();
  
  XMLStreamReader newXMLStreamReader();
  
  String xmlText();
  
  InputStream newInputStream();
  
  Reader newReader();
  
  Node newDomNode();
  
  Node getDomNode();
  
  void save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler) throws SAXException;
  
  void save(File paramFile) throws IOException;
  
  void save(OutputStream paramOutputStream) throws IOException;
  
  void save(Writer paramWriter) throws IOException;
  
  XMLInputStream newXMLInputStream(XmlOptions paramXmlOptions);
  
  XMLStreamReader newXMLStreamReader(XmlOptions paramXmlOptions);
  
  String xmlText(XmlOptions paramXmlOptions);
  
  InputStream newInputStream(XmlOptions paramXmlOptions);
  
  Reader newReader(XmlOptions paramXmlOptions);
  
  Node newDomNode(XmlOptions paramXmlOptions);
  
  void save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler, XmlOptions paramXmlOptions) throws SAXException;
  
  void save(File paramFile, XmlOptions paramXmlOptions) throws IOException;
  
  void save(OutputStream paramOutputStream, XmlOptions paramXmlOptions) throws IOException;
  
  void save(Writer paramWriter, XmlOptions paramXmlOptions) throws IOException;
  
  void dump();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlTokenSource.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */