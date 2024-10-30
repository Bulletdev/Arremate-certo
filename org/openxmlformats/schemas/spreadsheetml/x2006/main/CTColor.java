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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTColor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolord2c2type");
  
  boolean getAuto();
  
  XmlBoolean xgetAuto();
  
  boolean isSetAuto();
  
  void setAuto(boolean paramBoolean);
  
  void xsetAuto(XmlBoolean paramXmlBoolean);
  
  void unsetAuto();
  
  long getIndexed();
  
  XmlUnsignedInt xgetIndexed();
  
  boolean isSetIndexed();
  
  void setIndexed(long paramLong);
  
  void xsetIndexed(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetIndexed();
  
  byte[] getRgb();
  
  STUnsignedIntHex xgetRgb();
  
  boolean isSetRgb();
  
  void setRgb(byte[] paramArrayOfbyte);
  
  void xsetRgb(STUnsignedIntHex paramSTUnsignedIntHex);
  
  void unsetRgb();
  
  long getTheme();
  
  XmlUnsignedInt xgetTheme();
  
  boolean isSetTheme();
  
  void setTheme(long paramLong);
  
  void xsetTheme(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetTheme();
  
  double getTint();
  
  XmlDouble xgetTint();
  
  boolean isSetTint();
  
  void setTint(double paramDouble);
  
  void xsetTint(XmlDouble paramXmlDouble);
  
  void unsetTint();
  
  public static final class Factory {
    public static CTColor newInstance() {
      return (CTColor)POIXMLTypeLoader.newInstance(CTColor.type, null);
    }
    
    public static CTColor newInstance(XmlOptions param1XmlOptions) {
      return (CTColor)POIXMLTypeLoader.newInstance(CTColor.type, param1XmlOptions);
    }
    
    public static CTColor parse(String param1String) throws XmlException {
      return (CTColor)POIXMLTypeLoader.parse(param1String, CTColor.type, null);
    }
    
    public static CTColor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColor)POIXMLTypeLoader.parse(param1String, CTColor.type, param1XmlOptions);
    }
    
    public static CTColor parse(File param1File) throws XmlException, IOException {
      return (CTColor)POIXMLTypeLoader.parse(param1File, CTColor.type, null);
    }
    
    public static CTColor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColor)POIXMLTypeLoader.parse(param1File, CTColor.type, param1XmlOptions);
    }
    
    public static CTColor parse(URL param1URL) throws XmlException, IOException {
      return (CTColor)POIXMLTypeLoader.parse(param1URL, CTColor.type, null);
    }
    
    public static CTColor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColor)POIXMLTypeLoader.parse(param1URL, CTColor.type, param1XmlOptions);
    }
    
    public static CTColor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTColor)POIXMLTypeLoader.parse(param1InputStream, CTColor.type, null);
    }
    
    public static CTColor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColor)POIXMLTypeLoader.parse(param1InputStream, CTColor.type, param1XmlOptions);
    }
    
    public static CTColor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTColor)POIXMLTypeLoader.parse(param1Reader, CTColor.type, null);
    }
    
    public static CTColor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColor)POIXMLTypeLoader.parse(param1Reader, CTColor.type, param1XmlOptions);
    }
    
    public static CTColor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTColor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColor.type, null);
    }
    
    public static CTColor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColor.type, param1XmlOptions);
    }
    
    public static CTColor parse(Node param1Node) throws XmlException {
      return (CTColor)POIXMLTypeLoader.parse(param1Node, CTColor.type, null);
    }
    
    public static CTColor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColor)POIXMLTypeLoader.parse(param1Node, CTColor.type, param1XmlOptions);
    }
    
    public static CTColor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTColor)POIXMLTypeLoader.parse(param1XMLInputStream, CTColor.type, null);
    }
    
    public static CTColor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTColor)POIXMLTypeLoader.parse(param1XMLInputStream, CTColor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */