package com.microsoft.schemas.office.visio.x2012.main;

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

public interface VisioDocumentDocument1 extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(VisioDocumentDocument1.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("visiodocumentd431doctype");
  
  VisioDocumentType getVisioDocument();
  
  void setVisioDocument(VisioDocumentType paramVisioDocumentType);
  
  VisioDocumentType addNewVisioDocument();
  
  public static final class Factory {
    public static VisioDocumentDocument1 newInstance() {
      return (VisioDocumentDocument1)POIXMLTypeLoader.newInstance(VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 newInstance(XmlOptions param1XmlOptions) {
      return (VisioDocumentDocument1)POIXMLTypeLoader.newInstance(VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static VisioDocumentDocument1 parse(String param1String) throws XmlException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1String, VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1String, VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static VisioDocumentDocument1 parse(File param1File) throws XmlException, IOException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1File, VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1File, VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static VisioDocumentDocument1 parse(URL param1URL) throws XmlException, IOException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1URL, VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1URL, VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static VisioDocumentDocument1 parse(InputStream param1InputStream) throws XmlException, IOException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1InputStream, VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1InputStream, VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static VisioDocumentDocument1 parse(Reader param1Reader) throws XmlException, IOException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1Reader, VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1Reader, VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static VisioDocumentDocument1 parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1XMLStreamReader, VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1XMLStreamReader, VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static VisioDocumentDocument1 parse(Node param1Node) throws XmlException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1Node, VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1Node, VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static VisioDocumentDocument1 parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1XMLInputStream, VisioDocumentDocument1.type, null);
    }
    
    public static VisioDocumentDocument1 parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (VisioDocumentDocument1)POIXMLTypeLoader.parse(param1XMLInputStream, VisioDocumentDocument1.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, VisioDocumentDocument1.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, VisioDocumentDocument1.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\VisioDocumentDocument1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */