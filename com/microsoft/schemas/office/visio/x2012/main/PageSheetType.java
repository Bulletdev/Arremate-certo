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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface PageSheetType extends SheetType {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(PageSheetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pagesheettype679btype");
  
  String getUniqueID();
  
  XmlString xgetUniqueID();
  
  boolean isSetUniqueID();
  
  void setUniqueID(String paramString);
  
  void xsetUniqueID(XmlString paramXmlString);
  
  void unsetUniqueID();
  
  public static final class Factory {
    public static PageSheetType newInstance() {
      return (PageSheetType)POIXMLTypeLoader.newInstance(PageSheetType.type, null);
    }
    
    public static PageSheetType newInstance(XmlOptions param1XmlOptions) {
      return (PageSheetType)POIXMLTypeLoader.newInstance(PageSheetType.type, param1XmlOptions);
    }
    
    public static PageSheetType parse(String param1String) throws XmlException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1String, PageSheetType.type, null);
    }
    
    public static PageSheetType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1String, PageSheetType.type, param1XmlOptions);
    }
    
    public static PageSheetType parse(File param1File) throws XmlException, IOException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1File, PageSheetType.type, null);
    }
    
    public static PageSheetType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1File, PageSheetType.type, param1XmlOptions);
    }
    
    public static PageSheetType parse(URL param1URL) throws XmlException, IOException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1URL, PageSheetType.type, null);
    }
    
    public static PageSheetType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1URL, PageSheetType.type, param1XmlOptions);
    }
    
    public static PageSheetType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1InputStream, PageSheetType.type, null);
    }
    
    public static PageSheetType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1InputStream, PageSheetType.type, param1XmlOptions);
    }
    
    public static PageSheetType parse(Reader param1Reader) throws XmlException, IOException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1Reader, PageSheetType.type, null);
    }
    
    public static PageSheetType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1Reader, PageSheetType.type, param1XmlOptions);
    }
    
    public static PageSheetType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1XMLStreamReader, PageSheetType.type, null);
    }
    
    public static PageSheetType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1XMLStreamReader, PageSheetType.type, param1XmlOptions);
    }
    
    public static PageSheetType parse(Node param1Node) throws XmlException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1Node, PageSheetType.type, null);
    }
    
    public static PageSheetType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1Node, PageSheetType.type, param1XmlOptions);
    }
    
    public static PageSheetType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1XMLInputStream, PageSheetType.type, null);
    }
    
    public static PageSheetType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (PageSheetType)POIXMLTypeLoader.parse(param1XMLInputStream, PageSheetType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PageSheetType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PageSheetType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\PageSheetType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */