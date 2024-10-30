package com.microsoft.schemas.office.visio.x2012.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface PagesType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(PagesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pagestypef2e7type");
  
  List<PageType> getPageList();
  
  PageType[] getPageArray();
  
  PageType getPageArray(int paramInt);
  
  int sizeOfPageArray();
  
  void setPageArray(PageType[] paramArrayOfPageType);
  
  void setPageArray(int paramInt, PageType paramPageType);
  
  PageType insertNewPage(int paramInt);
  
  PageType addNewPage();
  
  void removePage(int paramInt);
  
  public static final class Factory {
    public static PagesType newInstance() {
      return (PagesType)POIXMLTypeLoader.newInstance(PagesType.type, null);
    }
    
    public static PagesType newInstance(XmlOptions param1XmlOptions) {
      return (PagesType)POIXMLTypeLoader.newInstance(PagesType.type, param1XmlOptions);
    }
    
    public static PagesType parse(String param1String) throws XmlException {
      return (PagesType)POIXMLTypeLoader.parse(param1String, PagesType.type, null);
    }
    
    public static PagesType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (PagesType)POIXMLTypeLoader.parse(param1String, PagesType.type, param1XmlOptions);
    }
    
    public static PagesType parse(File param1File) throws XmlException, IOException {
      return (PagesType)POIXMLTypeLoader.parse(param1File, PagesType.type, null);
    }
    
    public static PagesType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PagesType)POIXMLTypeLoader.parse(param1File, PagesType.type, param1XmlOptions);
    }
    
    public static PagesType parse(URL param1URL) throws XmlException, IOException {
      return (PagesType)POIXMLTypeLoader.parse(param1URL, PagesType.type, null);
    }
    
    public static PagesType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PagesType)POIXMLTypeLoader.parse(param1URL, PagesType.type, param1XmlOptions);
    }
    
    public static PagesType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (PagesType)POIXMLTypeLoader.parse(param1InputStream, PagesType.type, null);
    }
    
    public static PagesType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PagesType)POIXMLTypeLoader.parse(param1InputStream, PagesType.type, param1XmlOptions);
    }
    
    public static PagesType parse(Reader param1Reader) throws XmlException, IOException {
      return (PagesType)POIXMLTypeLoader.parse(param1Reader, PagesType.type, null);
    }
    
    public static PagesType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PagesType)POIXMLTypeLoader.parse(param1Reader, PagesType.type, param1XmlOptions);
    }
    
    public static PagesType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (PagesType)POIXMLTypeLoader.parse(param1XMLStreamReader, PagesType.type, null);
    }
    
    public static PagesType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (PagesType)POIXMLTypeLoader.parse(param1XMLStreamReader, PagesType.type, param1XmlOptions);
    }
    
    public static PagesType parse(Node param1Node) throws XmlException {
      return (PagesType)POIXMLTypeLoader.parse(param1Node, PagesType.type, null);
    }
    
    public static PagesType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (PagesType)POIXMLTypeLoader.parse(param1Node, PagesType.type, param1XmlOptions);
    }
    
    public static PagesType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (PagesType)POIXMLTypeLoader.parse(param1XMLInputStream, PagesType.type, null);
    }
    
    public static PagesType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (PagesType)POIXMLTypeLoader.parse(param1XMLInputStream, PagesType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PagesType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PagesType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\PagesType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */