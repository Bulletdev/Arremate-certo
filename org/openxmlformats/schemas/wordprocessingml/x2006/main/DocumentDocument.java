package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface DocumentDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(DocumentDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("document2bd9doctype");
  
  CTDocument1 getDocument();
  
  void setDocument(CTDocument1 paramCTDocument1);
  
  CTDocument1 addNewDocument();
  
  public static final class Factory {
    public static DocumentDocument newInstance() {
      return (DocumentDocument)POIXMLTypeLoader.newInstance(DocumentDocument.type, null);
    }
    
    public static DocumentDocument newInstance(XmlOptions param1XmlOptions) {
      return (DocumentDocument)POIXMLTypeLoader.newInstance(DocumentDocument.type, param1XmlOptions);
    }
    
    public static DocumentDocument parse(String param1String) throws XmlException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1String, DocumentDocument.type, null);
    }
    
    public static DocumentDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1String, DocumentDocument.type, param1XmlOptions);
    }
    
    public static DocumentDocument parse(File param1File) throws XmlException, IOException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1File, DocumentDocument.type, null);
    }
    
    public static DocumentDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1File, DocumentDocument.type, param1XmlOptions);
    }
    
    public static DocumentDocument parse(URL param1URL) throws XmlException, IOException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1URL, DocumentDocument.type, null);
    }
    
    public static DocumentDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1URL, DocumentDocument.type, param1XmlOptions);
    }
    
    public static DocumentDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1InputStream, DocumentDocument.type, null);
    }
    
    public static DocumentDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1InputStream, DocumentDocument.type, param1XmlOptions);
    }
    
    public static DocumentDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1Reader, DocumentDocument.type, null);
    }
    
    public static DocumentDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1Reader, DocumentDocument.type, param1XmlOptions);
    }
    
    public static DocumentDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, DocumentDocument.type, null);
    }
    
    public static DocumentDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, DocumentDocument.type, param1XmlOptions);
    }
    
    public static DocumentDocument parse(Node param1Node) throws XmlException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1Node, DocumentDocument.type, null);
    }
    
    public static DocumentDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1Node, DocumentDocument.type, param1XmlOptions);
    }
    
    public static DocumentDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1XMLInputStream, DocumentDocument.type, null);
    }
    
    public static DocumentDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (DocumentDocument)POIXMLTypeLoader.parse(param1XMLInputStream, DocumentDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, DocumentDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, DocumentDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\DocumentDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */