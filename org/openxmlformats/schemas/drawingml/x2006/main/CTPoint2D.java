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

public interface CTPoint2D extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPoint2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpoint2d8193type");
  
  long getX();
  
  STCoordinate xgetX();
  
  void setX(long paramLong);
  
  void xsetX(STCoordinate paramSTCoordinate);
  
  long getY();
  
  STCoordinate xgetY();
  
  void setY(long paramLong);
  
  void xsetY(STCoordinate paramSTCoordinate);
  
  public static final class Factory {
    public static CTPoint2D newInstance() {
      return (CTPoint2D)POIXMLTypeLoader.newInstance(CTPoint2D.type, null);
    }
    
    public static CTPoint2D newInstance(XmlOptions param1XmlOptions) {
      return (CTPoint2D)POIXMLTypeLoader.newInstance(CTPoint2D.type, param1XmlOptions);
    }
    
    public static CTPoint2D parse(String param1String) throws XmlException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1String, CTPoint2D.type, null);
    }
    
    public static CTPoint2D parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1String, CTPoint2D.type, param1XmlOptions);
    }
    
    public static CTPoint2D parse(File param1File) throws XmlException, IOException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1File, CTPoint2D.type, null);
    }
    
    public static CTPoint2D parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1File, CTPoint2D.type, param1XmlOptions);
    }
    
    public static CTPoint2D parse(URL param1URL) throws XmlException, IOException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1URL, CTPoint2D.type, null);
    }
    
    public static CTPoint2D parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1URL, CTPoint2D.type, param1XmlOptions);
    }
    
    public static CTPoint2D parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1InputStream, CTPoint2D.type, null);
    }
    
    public static CTPoint2D parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1InputStream, CTPoint2D.type, param1XmlOptions);
    }
    
    public static CTPoint2D parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1Reader, CTPoint2D.type, null);
    }
    
    public static CTPoint2D parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1Reader, CTPoint2D.type, param1XmlOptions);
    }
    
    public static CTPoint2D parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPoint2D.type, null);
    }
    
    public static CTPoint2D parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPoint2D.type, param1XmlOptions);
    }
    
    public static CTPoint2D parse(Node param1Node) throws XmlException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1Node, CTPoint2D.type, null);
    }
    
    public static CTPoint2D parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1Node, CTPoint2D.type, param1XmlOptions);
    }
    
    public static CTPoint2D parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTPoint2D.type, null);
    }
    
    public static CTPoint2D parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPoint2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTPoint2D.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPoint2D.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPoint2D.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPoint2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */