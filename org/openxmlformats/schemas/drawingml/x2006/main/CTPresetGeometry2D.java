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

public interface CTPresetGeometry2D extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPresetGeometry2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpresetgeometry2db1detype");
  
  CTGeomGuideList getAvLst();
  
  boolean isSetAvLst();
  
  void setAvLst(CTGeomGuideList paramCTGeomGuideList);
  
  CTGeomGuideList addNewAvLst();
  
  void unsetAvLst();
  
  STShapeType.Enum getPrst();
  
  STShapeType xgetPrst();
  
  void setPrst(STShapeType.Enum paramEnum);
  
  void xsetPrst(STShapeType paramSTShapeType);
  
  public static final class Factory {
    public static CTPresetGeometry2D newInstance() {
      return (CTPresetGeometry2D)POIXMLTypeLoader.newInstance(CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D newInstance(XmlOptions param1XmlOptions) {
      return (CTPresetGeometry2D)POIXMLTypeLoader.newInstance(CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static CTPresetGeometry2D parse(String param1String) throws XmlException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1String, CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1String, CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static CTPresetGeometry2D parse(File param1File) throws XmlException, IOException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1File, CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1File, CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static CTPresetGeometry2D parse(URL param1URL) throws XmlException, IOException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1URL, CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1URL, CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static CTPresetGeometry2D parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1InputStream, CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1InputStream, CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static CTPresetGeometry2D parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1Reader, CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1Reader, CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static CTPresetGeometry2D parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static CTPresetGeometry2D parse(Node param1Node) throws XmlException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1Node, CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1Node, CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static CTPresetGeometry2D parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTPresetGeometry2D.type, null);
    }
    
    public static CTPresetGeometry2D parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPresetGeometry2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTPresetGeometry2D.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPresetGeometry2D.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPresetGeometry2D.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPresetGeometry2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */