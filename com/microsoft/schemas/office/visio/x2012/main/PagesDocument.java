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

public interface PagesDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(PagesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pages52f4doctype");
  
  PagesType getPages();
  
  void setPages(PagesType paramPagesType);
  
  PagesType addNewPages();
  
  public static final class Factory {
    public static PagesDocument newInstance() {
      return (PagesDocument)POIXMLTypeLoader.newInstance(PagesDocument.type, null);
    }
    
    public static PagesDocument newInstance(XmlOptions param1XmlOptions) {
      return (PagesDocument)POIXMLTypeLoader.newInstance(PagesDocument.type, param1XmlOptions);
    }
    
    public static PagesDocument parse(String param1String) throws XmlException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1String, PagesDocument.type, null);
    }
    
    public static PagesDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1String, PagesDocument.type, param1XmlOptions);
    }
    
    public static PagesDocument parse(File param1File) throws XmlException, IOException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1File, PagesDocument.type, null);
    }
    
    public static PagesDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1File, PagesDocument.type, param1XmlOptions);
    }
    
    public static PagesDocument parse(URL param1URL) throws XmlException, IOException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1URL, PagesDocument.type, null);
    }
    
    public static PagesDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1URL, PagesDocument.type, param1XmlOptions);
    }
    
    public static PagesDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1InputStream, PagesDocument.type, null);
    }
    
    public static PagesDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1InputStream, PagesDocument.type, param1XmlOptions);
    }
    
    public static PagesDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1Reader, PagesDocument.type, null);
    }
    
    public static PagesDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1Reader, PagesDocument.type, param1XmlOptions);
    }
    
    public static PagesDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PagesDocument.type, null);
    }
    
    public static PagesDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PagesDocument.type, param1XmlOptions);
    }
    
    public static PagesDocument parse(Node param1Node) throws XmlException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1Node, PagesDocument.type, null);
    }
    
    public static PagesDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1Node, PagesDocument.type, param1XmlOptions);
    }
    
    public static PagesDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PagesDocument.type, null);
    }
    
    public static PagesDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (PagesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PagesDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PagesDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PagesDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\PagesDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */