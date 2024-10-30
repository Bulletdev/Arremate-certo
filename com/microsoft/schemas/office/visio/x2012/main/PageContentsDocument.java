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

public interface PageContentsDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(PageContentsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pagecontentsfc8bdoctype");
  
  PageContentsType getPageContents();
  
  void setPageContents(PageContentsType paramPageContentsType);
  
  PageContentsType addNewPageContents();
  
  public static final class Factory {
    public static PageContentsDocument newInstance() {
      return (PageContentsDocument)POIXMLTypeLoader.newInstance(PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument newInstance(XmlOptions param1XmlOptions) {
      return (PageContentsDocument)POIXMLTypeLoader.newInstance(PageContentsDocument.type, param1XmlOptions);
    }
    
    public static PageContentsDocument parse(String param1String) throws XmlException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1String, PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1String, PageContentsDocument.type, param1XmlOptions);
    }
    
    public static PageContentsDocument parse(File param1File) throws XmlException, IOException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1File, PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1File, PageContentsDocument.type, param1XmlOptions);
    }
    
    public static PageContentsDocument parse(URL param1URL) throws XmlException, IOException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1URL, PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1URL, PageContentsDocument.type, param1XmlOptions);
    }
    
    public static PageContentsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1InputStream, PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1InputStream, PageContentsDocument.type, param1XmlOptions);
    }
    
    public static PageContentsDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1Reader, PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1Reader, PageContentsDocument.type, param1XmlOptions);
    }
    
    public static PageContentsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PageContentsDocument.type, param1XmlOptions);
    }
    
    public static PageContentsDocument parse(Node param1Node) throws XmlException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1Node, PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1Node, PageContentsDocument.type, param1XmlOptions);
    }
    
    public static PageContentsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PageContentsDocument.type, null);
    }
    
    public static PageContentsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (PageContentsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PageContentsDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PageContentsDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PageContentsDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\PageContentsDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */