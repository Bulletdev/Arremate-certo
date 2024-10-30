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

public interface CTGeomRect extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGeomRect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgeomrect53dbtype");
  
  Object getL();
  
  STAdjCoordinate xgetL();
  
  void setL(Object paramObject);
  
  void xsetL(STAdjCoordinate paramSTAdjCoordinate);
  
  Object getT();
  
  STAdjCoordinate xgetT();
  
  void setT(Object paramObject);
  
  void xsetT(STAdjCoordinate paramSTAdjCoordinate);
  
  Object getR();
  
  STAdjCoordinate xgetR();
  
  void setR(Object paramObject);
  
  void xsetR(STAdjCoordinate paramSTAdjCoordinate);
  
  Object getB();
  
  STAdjCoordinate xgetB();
  
  void setB(Object paramObject);
  
  void xsetB(STAdjCoordinate paramSTAdjCoordinate);
  
  public static final class Factory {
    public static CTGeomRect newInstance() {
      return (CTGeomRect)POIXMLTypeLoader.newInstance(CTGeomRect.type, null);
    }
    
    public static CTGeomRect newInstance(XmlOptions param1XmlOptions) {
      return (CTGeomRect)POIXMLTypeLoader.newInstance(CTGeomRect.type, param1XmlOptions);
    }
    
    public static CTGeomRect parse(String param1String) throws XmlException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1String, CTGeomRect.type, null);
    }
    
    public static CTGeomRect parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1String, CTGeomRect.type, param1XmlOptions);
    }
    
    public static CTGeomRect parse(File param1File) throws XmlException, IOException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1File, CTGeomRect.type, null);
    }
    
    public static CTGeomRect parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1File, CTGeomRect.type, param1XmlOptions);
    }
    
    public static CTGeomRect parse(URL param1URL) throws XmlException, IOException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1URL, CTGeomRect.type, null);
    }
    
    public static CTGeomRect parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1URL, CTGeomRect.type, param1XmlOptions);
    }
    
    public static CTGeomRect parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1InputStream, CTGeomRect.type, null);
    }
    
    public static CTGeomRect parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1InputStream, CTGeomRect.type, param1XmlOptions);
    }
    
    public static CTGeomRect parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1Reader, CTGeomRect.type, null);
    }
    
    public static CTGeomRect parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1Reader, CTGeomRect.type, param1XmlOptions);
    }
    
    public static CTGeomRect parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGeomRect.type, null);
    }
    
    public static CTGeomRect parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGeomRect.type, param1XmlOptions);
    }
    
    public static CTGeomRect parse(Node param1Node) throws XmlException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1Node, CTGeomRect.type, null);
    }
    
    public static CTGeomRect parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1Node, CTGeomRect.type, param1XmlOptions);
    }
    
    public static CTGeomRect parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1XMLInputStream, CTGeomRect.type, null);
    }
    
    public static CTGeomRect parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGeomRect)POIXMLTypeLoader.parse(param1XMLInputStream, CTGeomRect.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGeomRect.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGeomRect.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGeomRect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */