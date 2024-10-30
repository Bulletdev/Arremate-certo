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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTransform2D extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTransform2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttransform2d5deftype");
  
  CTPoint2D getOff();
  
  boolean isSetOff();
  
  void setOff(CTPoint2D paramCTPoint2D);
  
  CTPoint2D addNewOff();
  
  void unsetOff();
  
  CTPositiveSize2D getExt();
  
  boolean isSetExt();
  
  void setExt(CTPositiveSize2D paramCTPositiveSize2D);
  
  CTPositiveSize2D addNewExt();
  
  void unsetExt();
  
  int getRot();
  
  STAngle xgetRot();
  
  boolean isSetRot();
  
  void setRot(int paramInt);
  
  void xsetRot(STAngle paramSTAngle);
  
  void unsetRot();
  
  boolean getFlipH();
  
  XmlBoolean xgetFlipH();
  
  boolean isSetFlipH();
  
  void setFlipH(boolean paramBoolean);
  
  void xsetFlipH(XmlBoolean paramXmlBoolean);
  
  void unsetFlipH();
  
  boolean getFlipV();
  
  XmlBoolean xgetFlipV();
  
  boolean isSetFlipV();
  
  void setFlipV(boolean paramBoolean);
  
  void xsetFlipV(XmlBoolean paramXmlBoolean);
  
  void unsetFlipV();
  
  public static final class Factory {
    public static CTTransform2D newInstance() {
      return (CTTransform2D)POIXMLTypeLoader.newInstance(CTTransform2D.type, null);
    }
    
    public static CTTransform2D newInstance(XmlOptions param1XmlOptions) {
      return (CTTransform2D)POIXMLTypeLoader.newInstance(CTTransform2D.type, param1XmlOptions);
    }
    
    public static CTTransform2D parse(String param1String) throws XmlException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1String, CTTransform2D.type, null);
    }
    
    public static CTTransform2D parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1String, CTTransform2D.type, param1XmlOptions);
    }
    
    public static CTTransform2D parse(File param1File) throws XmlException, IOException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1File, CTTransform2D.type, null);
    }
    
    public static CTTransform2D parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1File, CTTransform2D.type, param1XmlOptions);
    }
    
    public static CTTransform2D parse(URL param1URL) throws XmlException, IOException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1URL, CTTransform2D.type, null);
    }
    
    public static CTTransform2D parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1URL, CTTransform2D.type, param1XmlOptions);
    }
    
    public static CTTransform2D parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1InputStream, CTTransform2D.type, null);
    }
    
    public static CTTransform2D parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1InputStream, CTTransform2D.type, param1XmlOptions);
    }
    
    public static CTTransform2D parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1Reader, CTTransform2D.type, null);
    }
    
    public static CTTransform2D parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1Reader, CTTransform2D.type, param1XmlOptions);
    }
    
    public static CTTransform2D parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTransform2D.type, null);
    }
    
    public static CTTransform2D parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTransform2D.type, param1XmlOptions);
    }
    
    public static CTTransform2D parse(Node param1Node) throws XmlException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1Node, CTTransform2D.type, null);
    }
    
    public static CTTransform2D parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1Node, CTTransform2D.type, param1XmlOptions);
    }
    
    public static CTTransform2D parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTTransform2D.type, null);
    }
    
    public static CTTransform2D parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTransform2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTTransform2D.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTransform2D.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTransform2D.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTransform2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */