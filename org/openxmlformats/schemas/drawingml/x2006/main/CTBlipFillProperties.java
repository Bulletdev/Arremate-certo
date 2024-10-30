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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBlipFillProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBlipFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctblipfillproperties0382type");
  
  CTBlip getBlip();
  
  boolean isSetBlip();
  
  void setBlip(CTBlip paramCTBlip);
  
  CTBlip addNewBlip();
  
  void unsetBlip();
  
  CTRelativeRect getSrcRect();
  
  boolean isSetSrcRect();
  
  void setSrcRect(CTRelativeRect paramCTRelativeRect);
  
  CTRelativeRect addNewSrcRect();
  
  void unsetSrcRect();
  
  CTTileInfoProperties getTile();
  
  boolean isSetTile();
  
  void setTile(CTTileInfoProperties paramCTTileInfoProperties);
  
  CTTileInfoProperties addNewTile();
  
  void unsetTile();
  
  CTStretchInfoProperties getStretch();
  
  boolean isSetStretch();
  
  void setStretch(CTStretchInfoProperties paramCTStretchInfoProperties);
  
  CTStretchInfoProperties addNewStretch();
  
  void unsetStretch();
  
  long getDpi();
  
  XmlUnsignedInt xgetDpi();
  
  boolean isSetDpi();
  
  void setDpi(long paramLong);
  
  void xsetDpi(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetDpi();
  
  boolean getRotWithShape();
  
  XmlBoolean xgetRotWithShape();
  
  boolean isSetRotWithShape();
  
  void setRotWithShape(boolean paramBoolean);
  
  void xsetRotWithShape(XmlBoolean paramXmlBoolean);
  
  void unsetRotWithShape();
  
  public static final class Factory {
    public static CTBlipFillProperties newInstance() {
      return (CTBlipFillProperties)POIXMLTypeLoader.newInstance(CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTBlipFillProperties)POIXMLTypeLoader.newInstance(CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static CTBlipFillProperties parse(String param1String) throws XmlException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1String, CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1String, CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static CTBlipFillProperties parse(File param1File) throws XmlException, IOException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1File, CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1File, CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static CTBlipFillProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1URL, CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1URL, CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static CTBlipFillProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static CTBlipFillProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1Reader, CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1Reader, CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static CTBlipFillProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static CTBlipFillProperties parse(Node param1Node) throws XmlException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1Node, CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1Node, CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static CTBlipFillProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTBlipFillProperties.type, null);
    }
    
    public static CTBlipFillProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBlipFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTBlipFillProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBlipFillProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBlipFillProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTBlipFillProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */