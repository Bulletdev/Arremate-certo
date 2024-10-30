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

public interface CTCustomGeometry2D extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCustomGeometry2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcustomgeometry2dca70type");
  
  CTGeomGuideList getAvLst();
  
  boolean isSetAvLst();
  
  void setAvLst(CTGeomGuideList paramCTGeomGuideList);
  
  CTGeomGuideList addNewAvLst();
  
  void unsetAvLst();
  
  CTGeomGuideList getGdLst();
  
  boolean isSetGdLst();
  
  void setGdLst(CTGeomGuideList paramCTGeomGuideList);
  
  CTGeomGuideList addNewGdLst();
  
  void unsetGdLst();
  
  CTAdjustHandleList getAhLst();
  
  boolean isSetAhLst();
  
  void setAhLst(CTAdjustHandleList paramCTAdjustHandleList);
  
  CTAdjustHandleList addNewAhLst();
  
  void unsetAhLst();
  
  CTConnectionSiteList getCxnLst();
  
  boolean isSetCxnLst();
  
  void setCxnLst(CTConnectionSiteList paramCTConnectionSiteList);
  
  CTConnectionSiteList addNewCxnLst();
  
  void unsetCxnLst();
  
  CTGeomRect getRect();
  
  boolean isSetRect();
  
  void setRect(CTGeomRect paramCTGeomRect);
  
  CTGeomRect addNewRect();
  
  void unsetRect();
  
  CTPath2DList getPathLst();
  
  void setPathLst(CTPath2DList paramCTPath2DList);
  
  CTPath2DList addNewPathLst();
  
  public static final class Factory {
    public static CTCustomGeometry2D newInstance() {
      return (CTCustomGeometry2D)POIXMLTypeLoader.newInstance(CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D newInstance(XmlOptions param1XmlOptions) {
      return (CTCustomGeometry2D)POIXMLTypeLoader.newInstance(CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static CTCustomGeometry2D parse(String param1String) throws XmlException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1String, CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1String, CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static CTCustomGeometry2D parse(File param1File) throws XmlException, IOException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1File, CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1File, CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static CTCustomGeometry2D parse(URL param1URL) throws XmlException, IOException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1URL, CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1URL, CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static CTCustomGeometry2D parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1InputStream, CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1InputStream, CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static CTCustomGeometry2D parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1Reader, CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1Reader, CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static CTCustomGeometry2D parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static CTCustomGeometry2D parse(Node param1Node) throws XmlException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1Node, CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1Node, CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static CTCustomGeometry2D parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTCustomGeometry2D.type, null);
    }
    
    public static CTCustomGeometry2D parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCustomGeometry2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTCustomGeometry2D.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCustomGeometry2D.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCustomGeometry2D.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTCustomGeometry2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */