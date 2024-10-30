package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTShd extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTShd.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshd58c3type");
  
  STShd.Enum getVal();
  
  STShd xgetVal();
  
  void setVal(STShd.Enum paramEnum);
  
  void xsetVal(STShd paramSTShd);
  
  Object getColor();
  
  STHexColor xgetColor();
  
  boolean isSetColor();
  
  void setColor(Object paramObject);
  
  void xsetColor(STHexColor paramSTHexColor);
  
  void unsetColor();
  
  STThemeColor$Enum getThemeColor();
  
  STThemeColor xgetThemeColor();
  
  boolean isSetThemeColor();
  
  void setThemeColor(STThemeColor$Enum paramSTThemeColor$Enum);
  
  void xsetThemeColor(STThemeColor paramSTThemeColor);
  
  void unsetThemeColor();
  
  byte[] getThemeTint();
  
  STUcharHexNumber xgetThemeTint();
  
  boolean isSetThemeTint();
  
  void setThemeTint(byte[] paramArrayOfbyte);
  
  void xsetThemeTint(STUcharHexNumber paramSTUcharHexNumber);
  
  void unsetThemeTint();
  
  byte[] getThemeShade();
  
  STUcharHexNumber xgetThemeShade();
  
  boolean isSetThemeShade();
  
  void setThemeShade(byte[] paramArrayOfbyte);
  
  void xsetThemeShade(STUcharHexNumber paramSTUcharHexNumber);
  
  void unsetThemeShade();
  
  Object getFill();
  
  STHexColor xgetFill();
  
  boolean isSetFill();
  
  void setFill(Object paramObject);
  
  void xsetFill(STHexColor paramSTHexColor);
  
  void unsetFill();
  
  STThemeColor$Enum getThemeFill();
  
  STThemeColor xgetThemeFill();
  
  boolean isSetThemeFill();
  
  void setThemeFill(STThemeColor$Enum paramSTThemeColor$Enum);
  
  void xsetThemeFill(STThemeColor paramSTThemeColor);
  
  void unsetThemeFill();
  
  byte[] getThemeFillTint();
  
  STUcharHexNumber xgetThemeFillTint();
  
  boolean isSetThemeFillTint();
  
  void setThemeFillTint(byte[] paramArrayOfbyte);
  
  void xsetThemeFillTint(STUcharHexNumber paramSTUcharHexNumber);
  
  void unsetThemeFillTint();
  
  byte[] getThemeFillShade();
  
  STUcharHexNumber xgetThemeFillShade();
  
  boolean isSetThemeFillShade();
  
  void setThemeFillShade(byte[] paramArrayOfbyte);
  
  void xsetThemeFillShade(STUcharHexNumber paramSTUcharHexNumber);
  
  void unsetThemeFillShade();
  
  public static final class Factory {
    public static CTShd newInstance() {
      return (CTShd)POIXMLTypeLoader.newInstance(CTShd.type, null);
    }
    
    public static CTShd newInstance(XmlOptions param1XmlOptions) {
      return (CTShd)POIXMLTypeLoader.newInstance(CTShd.type, param1XmlOptions);
    }
    
    public static CTShd parse(String param1String) throws XmlException {
      return (CTShd)POIXMLTypeLoader.parse(param1String, CTShd.type, null);
    }
    
    public static CTShd parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShd)POIXMLTypeLoader.parse(param1String, CTShd.type, param1XmlOptions);
    }
    
    public static CTShd parse(File param1File) throws XmlException, IOException {
      return (CTShd)POIXMLTypeLoader.parse(param1File, CTShd.type, null);
    }
    
    public static CTShd parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShd)POIXMLTypeLoader.parse(param1File, CTShd.type, param1XmlOptions);
    }
    
    public static CTShd parse(URL param1URL) throws XmlException, IOException {
      return (CTShd)POIXMLTypeLoader.parse(param1URL, CTShd.type, null);
    }
    
    public static CTShd parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShd)POIXMLTypeLoader.parse(param1URL, CTShd.type, param1XmlOptions);
    }
    
    public static CTShd parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTShd)POIXMLTypeLoader.parse(param1InputStream, CTShd.type, null);
    }
    
    public static CTShd parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShd)POIXMLTypeLoader.parse(param1InputStream, CTShd.type, param1XmlOptions);
    }
    
    public static CTShd parse(Reader param1Reader) throws XmlException, IOException {
      return (CTShd)POIXMLTypeLoader.parse(param1Reader, CTShd.type, null);
    }
    
    public static CTShd parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShd)POIXMLTypeLoader.parse(param1Reader, CTShd.type, param1XmlOptions);
    }
    
    public static CTShd parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTShd)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShd.type, null);
    }
    
    public static CTShd parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShd)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShd.type, param1XmlOptions);
    }
    
    public static CTShd parse(Node param1Node) throws XmlException {
      return (CTShd)POIXMLTypeLoader.parse(param1Node, CTShd.type, null);
    }
    
    public static CTShd parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShd)POIXMLTypeLoader.parse(param1Node, CTShd.type, param1XmlOptions);
    }
    
    public static CTShd parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTShd)POIXMLTypeLoader.parse(param1XMLInputStream, CTShd.type, null);
    }
    
    public static CTShd parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTShd)POIXMLTypeLoader.parse(param1XMLInputStream, CTShd.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShd.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShd.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTShd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */