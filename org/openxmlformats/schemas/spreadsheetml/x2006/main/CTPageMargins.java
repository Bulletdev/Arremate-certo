package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPageMargins extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPageMargins.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagemargins5455type");
  
  double getLeft();
  
  XmlDouble xgetLeft();
  
  void setLeft(double paramDouble);
  
  void xsetLeft(XmlDouble paramXmlDouble);
  
  double getRight();
  
  XmlDouble xgetRight();
  
  void setRight(double paramDouble);
  
  void xsetRight(XmlDouble paramXmlDouble);
  
  double getTop();
  
  XmlDouble xgetTop();
  
  void setTop(double paramDouble);
  
  void xsetTop(XmlDouble paramXmlDouble);
  
  double getBottom();
  
  XmlDouble xgetBottom();
  
  void setBottom(double paramDouble);
  
  void xsetBottom(XmlDouble paramXmlDouble);
  
  double getHeader();
  
  XmlDouble xgetHeader();
  
  void setHeader(double paramDouble);
  
  void xsetHeader(XmlDouble paramXmlDouble);
  
  double getFooter();
  
  XmlDouble xgetFooter();
  
  void setFooter(double paramDouble);
  
  void xsetFooter(XmlDouble paramXmlDouble);
  
  public static final class Factory {
    public static CTPageMargins newInstance() {
      return (CTPageMargins)POIXMLTypeLoader.newInstance(CTPageMargins.type, null);
    }
    
    public static CTPageMargins newInstance(XmlOptions param1XmlOptions) {
      return (CTPageMargins)POIXMLTypeLoader.newInstance(CTPageMargins.type, param1XmlOptions);
    }
    
    public static CTPageMargins parse(String param1String) throws XmlException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1String, CTPageMargins.type, null);
    }
    
    public static CTPageMargins parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1String, CTPageMargins.type, param1XmlOptions);
    }
    
    public static CTPageMargins parse(File param1File) throws XmlException, IOException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1File, CTPageMargins.type, null);
    }
    
    public static CTPageMargins parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1File, CTPageMargins.type, param1XmlOptions);
    }
    
    public static CTPageMargins parse(URL param1URL) throws XmlException, IOException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1URL, CTPageMargins.type, null);
    }
    
    public static CTPageMargins parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1URL, CTPageMargins.type, param1XmlOptions);
    }
    
    public static CTPageMargins parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1InputStream, CTPageMargins.type, null);
    }
    
    public static CTPageMargins parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1InputStream, CTPageMargins.type, param1XmlOptions);
    }
    
    public static CTPageMargins parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1Reader, CTPageMargins.type, null);
    }
    
    public static CTPageMargins parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1Reader, CTPageMargins.type, param1XmlOptions);
    }
    
    public static CTPageMargins parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPageMargins.type, null);
    }
    
    public static CTPageMargins parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPageMargins.type, param1XmlOptions);
    }
    
    public static CTPageMargins parse(Node param1Node) throws XmlException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1Node, CTPageMargins.type, null);
    }
    
    public static CTPageMargins parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1Node, CTPageMargins.type, param1XmlOptions);
    }
    
    public static CTPageMargins parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1XMLInputStream, CTPageMargins.type, null);
    }
    
    public static CTPageMargins parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPageMargins)POIXMLTypeLoader.parse(param1XMLInputStream, CTPageMargins.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPageMargins.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPageMargins.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPageMargins.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */