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
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTextFont extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextFont.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextfont92b7type");
  
  String getTypeface();
  
  STTextTypeface xgetTypeface();
  
  boolean isSetTypeface();
  
  void setTypeface(String paramString);
  
  void xsetTypeface(STTextTypeface paramSTTextTypeface);
  
  void unsetTypeface();
  
  byte[] getPanose();
  
  STPanose xgetPanose();
  
  boolean isSetPanose();
  
  void setPanose(byte[] paramArrayOfbyte);
  
  void xsetPanose(STPanose paramSTPanose);
  
  void unsetPanose();
  
  byte getPitchFamily();
  
  XmlByte xgetPitchFamily();
  
  boolean isSetPitchFamily();
  
  void setPitchFamily(byte paramByte);
  
  void xsetPitchFamily(XmlByte paramXmlByte);
  
  void unsetPitchFamily();
  
  byte getCharset();
  
  XmlByte xgetCharset();
  
  boolean isSetCharset();
  
  void setCharset(byte paramByte);
  
  void xsetCharset(XmlByte paramXmlByte);
  
  void unsetCharset();
  
  public static final class Factory {
    public static CTTextFont newInstance() {
      return (CTTextFont)POIXMLTypeLoader.newInstance(CTTextFont.type, null);
    }
    
    public static CTTextFont newInstance(XmlOptions param1XmlOptions) {
      return (CTTextFont)POIXMLTypeLoader.newInstance(CTTextFont.type, param1XmlOptions);
    }
    
    public static CTTextFont parse(String param1String) throws XmlException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1String, CTTextFont.type, null);
    }
    
    public static CTTextFont parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1String, CTTextFont.type, param1XmlOptions);
    }
    
    public static CTTextFont parse(File param1File) throws XmlException, IOException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1File, CTTextFont.type, null);
    }
    
    public static CTTextFont parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1File, CTTextFont.type, param1XmlOptions);
    }
    
    public static CTTextFont parse(URL param1URL) throws XmlException, IOException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1URL, CTTextFont.type, null);
    }
    
    public static CTTextFont parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1URL, CTTextFont.type, param1XmlOptions);
    }
    
    public static CTTextFont parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1InputStream, CTTextFont.type, null);
    }
    
    public static CTTextFont parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1InputStream, CTTextFont.type, param1XmlOptions);
    }
    
    public static CTTextFont parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1Reader, CTTextFont.type, null);
    }
    
    public static CTTextFont parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1Reader, CTTextFont.type, param1XmlOptions);
    }
    
    public static CTTextFont parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextFont.type, null);
    }
    
    public static CTTextFont parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextFont.type, param1XmlOptions);
    }
    
    public static CTTextFont parse(Node param1Node) throws XmlException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1Node, CTTextFont.type, null);
    }
    
    public static CTTextFont parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1Node, CTTextFont.type, param1XmlOptions);
    }
    
    public static CTTextFont parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextFont.type, null);
    }
    
    public static CTTextFont parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextFont)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextFont.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextFont.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextFont.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */