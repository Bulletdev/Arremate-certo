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

public interface CTMarkerStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMarkerStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmarkerstyle1f6ftype");
  
  STMarkerStyle.Enum getVal();
  
  STMarkerStyle xgetVal();
  
  void setVal(STMarkerStyle.Enum paramEnum);
  
  void xsetVal(STMarkerStyle paramSTMarkerStyle);
  
  public static final class Factory {
    public static CTMarkerStyle newInstance() {
      return (CTMarkerStyle)POIXMLTypeLoader.newInstance(CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTMarkerStyle)POIXMLTypeLoader.newInstance(CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static CTMarkerStyle parse(String param1String) throws XmlException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1String, CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1String, CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static CTMarkerStyle parse(File param1File) throws XmlException, IOException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1File, CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1File, CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static CTMarkerStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1URL, CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1URL, CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static CTMarkerStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1InputStream, CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1InputStream, CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static CTMarkerStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1Reader, CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1Reader, CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static CTMarkerStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static CTMarkerStyle parse(Node param1Node) throws XmlException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1Node, CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1Node, CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static CTMarkerStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTMarkerStyle.type, null);
    }
    
    public static CTMarkerStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMarkerStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTMarkerStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMarkerStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMarkerStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTMarkerStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */