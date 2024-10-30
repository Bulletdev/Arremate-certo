package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTPositiveSize2D extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPositiveSize2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpositivesize2d0147type");
  
  long getCx();
  
  STPositiveCoordinate xgetCx();
  
  void setCx(long paramLong);
  
  void xsetCx(STPositiveCoordinate paramSTPositiveCoordinate);
  
  long getCy();
  
  STPositiveCoordinate xgetCy();
  
  void setCy(long paramLong);
  
  void xsetCy(STPositiveCoordinate paramSTPositiveCoordinate);
  
  public static final class Factory {
    public static CTPositiveSize2D newInstance() {
      return (CTPositiveSize2D)POIXMLTypeLoader.newInstance(CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D newInstance(XmlOptions param1XmlOptions) {
      return (CTPositiveSize2D)POIXMLTypeLoader.newInstance(CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static CTPositiveSize2D parse(String param1String) throws XmlException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1String, CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1String, CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static CTPositiveSize2D parse(File param1File) throws XmlException, IOException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1File, CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1File, CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static CTPositiveSize2D parse(URL param1URL) throws XmlException, IOException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1URL, CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1URL, CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static CTPositiveSize2D parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1InputStream, CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1InputStream, CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static CTPositiveSize2D parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1Reader, CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1Reader, CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static CTPositiveSize2D parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static CTPositiveSize2D parse(Node param1Node) throws XmlException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1Node, CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1Node, CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static CTPositiveSize2D parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTPositiveSize2D.type, null);
    }
    
    public static CTPositiveSize2D parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPositiveSize2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTPositiveSize2D.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPositiveSize2D.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPositiveSize2D.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPositiveSize2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */