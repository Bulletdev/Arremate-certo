package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCol extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCol.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcola95ftype");
  
  long getMin();
  
  XmlUnsignedInt xgetMin();
  
  void setMin(long paramLong);
  
  void xsetMin(XmlUnsignedInt paramXmlUnsignedInt);
  
  long getMax();
  
  XmlUnsignedInt xgetMax();
  
  void setMax(long paramLong);
  
  void xsetMax(XmlUnsignedInt paramXmlUnsignedInt);
  
  double getWidth();
  
  XmlDouble xgetWidth();
  
  boolean isSetWidth();
  
  void setWidth(double paramDouble);
  
  void xsetWidth(XmlDouble paramXmlDouble);
  
  void unsetWidth();
  
  long getStyle();
  
  XmlUnsignedInt xgetStyle();
  
  boolean isSetStyle();
  
  void setStyle(long paramLong);
  
  void xsetStyle(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetStyle();
  
  boolean getHidden();
  
  XmlBoolean xgetHidden();
  
  boolean isSetHidden();
  
  void setHidden(boolean paramBoolean);
  
  void xsetHidden(XmlBoolean paramXmlBoolean);
  
  void unsetHidden();
  
  boolean getBestFit();
  
  XmlBoolean xgetBestFit();
  
  boolean isSetBestFit();
  
  void setBestFit(boolean paramBoolean);
  
  void xsetBestFit(XmlBoolean paramXmlBoolean);
  
  void unsetBestFit();
  
  boolean getCustomWidth();
  
  XmlBoolean xgetCustomWidth();
  
  boolean isSetCustomWidth();
  
  void setCustomWidth(boolean paramBoolean);
  
  void xsetCustomWidth(XmlBoolean paramXmlBoolean);
  
  void unsetCustomWidth();
  
  boolean getPhonetic();
  
  XmlBoolean xgetPhonetic();
  
  boolean isSetPhonetic();
  
  void setPhonetic(boolean paramBoolean);
  
  void xsetPhonetic(XmlBoolean paramXmlBoolean);
  
  void unsetPhonetic();
  
  short getOutlineLevel();
  
  XmlUnsignedByte xgetOutlineLevel();
  
  boolean isSetOutlineLevel();
  
  void setOutlineLevel(short paramShort);
  
  void xsetOutlineLevel(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetOutlineLevel();
  
  boolean getCollapsed();
  
  XmlBoolean xgetCollapsed();
  
  boolean isSetCollapsed();
  
  void setCollapsed(boolean paramBoolean);
  
  void xsetCollapsed(XmlBoolean paramXmlBoolean);
  
  void unsetCollapsed();
  
  public static final class Factory {
    public static CTCol newInstance() {
      return (CTCol)POIXMLTypeLoader.newInstance(CTCol.type, null);
    }
    
    public static CTCol newInstance(XmlOptions param1XmlOptions) {
      return (CTCol)POIXMLTypeLoader.newInstance(CTCol.type, param1XmlOptions);
    }
    
    public static CTCol parse(String param1String) throws XmlException {
      return (CTCol)POIXMLTypeLoader.parse(param1String, CTCol.type, null);
    }
    
    public static CTCol parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCol)POIXMLTypeLoader.parse(param1String, CTCol.type, param1XmlOptions);
    }
    
    public static CTCol parse(File param1File) throws XmlException, IOException {
      return (CTCol)POIXMLTypeLoader.parse(param1File, CTCol.type, null);
    }
    
    public static CTCol parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCol)POIXMLTypeLoader.parse(param1File, CTCol.type, param1XmlOptions);
    }
    
    public static CTCol parse(URL param1URL) throws XmlException, IOException {
      return (CTCol)POIXMLTypeLoader.parse(param1URL, CTCol.type, null);
    }
    
    public static CTCol parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCol)POIXMLTypeLoader.parse(param1URL, CTCol.type, param1XmlOptions);
    }
    
    public static CTCol parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCol)POIXMLTypeLoader.parse(param1InputStream, CTCol.type, null);
    }
    
    public static CTCol parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCol)POIXMLTypeLoader.parse(param1InputStream, CTCol.type, param1XmlOptions);
    }
    
    public static CTCol parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCol)POIXMLTypeLoader.parse(param1Reader, CTCol.type, null);
    }
    
    public static CTCol parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCol)POIXMLTypeLoader.parse(param1Reader, CTCol.type, param1XmlOptions);
    }
    
    public static CTCol parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCol)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCol.type, null);
    }
    
    public static CTCol parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCol)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCol.type, param1XmlOptions);
    }
    
    public static CTCol parse(Node param1Node) throws XmlException {
      return (CTCol)POIXMLTypeLoader.parse(param1Node, CTCol.type, null);
    }
    
    public static CTCol parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCol)POIXMLTypeLoader.parse(param1Node, CTCol.type, param1XmlOptions);
    }
    
    public static CTCol parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCol)POIXMLTypeLoader.parse(param1XMLInputStream, CTCol.type, null);
    }
    
    public static CTCol parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCol)POIXMLTypeLoader.parse(param1XMLInputStream, CTCol.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCol.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCol.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */