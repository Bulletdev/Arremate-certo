package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTCrosses extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCrosses.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcrossesbcb8type");
  
  STCrosses.Enum getVal();
  
  STCrosses xgetVal();
  
  void setVal(STCrosses.Enum paramEnum);
  
  void xsetVal(STCrosses paramSTCrosses);
  
  public static final class Factory {
    public static CTCrosses newInstance() {
      return (CTCrosses)POIXMLTypeLoader.newInstance(CTCrosses.type, null);
    }
    
    public static CTCrosses newInstance(XmlOptions param1XmlOptions) {
      return (CTCrosses)POIXMLTypeLoader.newInstance(CTCrosses.type, param1XmlOptions);
    }
    
    public static CTCrosses parse(String param1String) throws XmlException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1String, CTCrosses.type, null);
    }
    
    public static CTCrosses parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1String, CTCrosses.type, param1XmlOptions);
    }
    
    public static CTCrosses parse(File param1File) throws XmlException, IOException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1File, CTCrosses.type, null);
    }
    
    public static CTCrosses parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1File, CTCrosses.type, param1XmlOptions);
    }
    
    public static CTCrosses parse(URL param1URL) throws XmlException, IOException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1URL, CTCrosses.type, null);
    }
    
    public static CTCrosses parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1URL, CTCrosses.type, param1XmlOptions);
    }
    
    public static CTCrosses parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1InputStream, CTCrosses.type, null);
    }
    
    public static CTCrosses parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1InputStream, CTCrosses.type, param1XmlOptions);
    }
    
    public static CTCrosses parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1Reader, CTCrosses.type, null);
    }
    
    public static CTCrosses parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1Reader, CTCrosses.type, param1XmlOptions);
    }
    
    public static CTCrosses parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCrosses.type, null);
    }
    
    public static CTCrosses parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCrosses.type, param1XmlOptions);
    }
    
    public static CTCrosses parse(Node param1Node) throws XmlException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1Node, CTCrosses.type, null);
    }
    
    public static CTCrosses parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1Node, CTCrosses.type, param1XmlOptions);
    }
    
    public static CTCrosses parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1XMLInputStream, CTCrosses.type, null);
    }
    
    public static CTCrosses parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCrosses)POIXMLTypeLoader.parse(param1XMLInputStream, CTCrosses.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCrosses.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCrosses.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTCrosses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */