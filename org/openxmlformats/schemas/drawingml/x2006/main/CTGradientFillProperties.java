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

public interface CTGradientFillProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGradientFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgradientfillproperties81c1type");
  
  CTGradientStopList getGsLst();
  
  boolean isSetGsLst();
  
  void setGsLst(CTGradientStopList paramCTGradientStopList);
  
  CTGradientStopList addNewGsLst();
  
  void unsetGsLst();
  
  CTLinearShadeProperties getLin();
  
  boolean isSetLin();
  
  void setLin(CTLinearShadeProperties paramCTLinearShadeProperties);
  
  CTLinearShadeProperties addNewLin();
  
  void unsetLin();
  
  CTPathShadeProperties getPath();
  
  boolean isSetPath();
  
  void setPath(CTPathShadeProperties paramCTPathShadeProperties);
  
  CTPathShadeProperties addNewPath();
  
  void unsetPath();
  
  CTRelativeRect getTileRect();
  
  boolean isSetTileRect();
  
  void setTileRect(CTRelativeRect paramCTRelativeRect);
  
  CTRelativeRect addNewTileRect();
  
  void unsetTileRect();
  
  STTileFlipMode$Enum getFlip();
  
  STTileFlipMode xgetFlip();
  
  boolean isSetFlip();
  
  void setFlip(STTileFlipMode$Enum paramSTTileFlipMode$Enum);
  
  void xsetFlip(STTileFlipMode paramSTTileFlipMode);
  
  void unsetFlip();
  
  boolean getRotWithShape();
  
  XmlBoolean xgetRotWithShape();
  
  boolean isSetRotWithShape();
  
  void setRotWithShape(boolean paramBoolean);
  
  void xsetRotWithShape(XmlBoolean paramXmlBoolean);
  
  void unsetRotWithShape();
  
  public static final class Factory {
    public static CTGradientFillProperties newInstance() {
      return (CTGradientFillProperties)POIXMLTypeLoader.newInstance(CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTGradientFillProperties)POIXMLTypeLoader.newInstance(CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static CTGradientFillProperties parse(String param1String) throws XmlException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1String, CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1String, CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static CTGradientFillProperties parse(File param1File) throws XmlException, IOException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1File, CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1File, CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static CTGradientFillProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1URL, CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1URL, CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static CTGradientFillProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static CTGradientFillProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1Reader, CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1Reader, CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static CTGradientFillProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static CTGradientFillProperties parse(Node param1Node) throws XmlException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1Node, CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1Node, CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static CTGradientFillProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTGradientFillProperties.type, null);
    }
    
    public static CTGradientFillProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGradientFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTGradientFillProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGradientFillProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGradientFillProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGradientFillProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */