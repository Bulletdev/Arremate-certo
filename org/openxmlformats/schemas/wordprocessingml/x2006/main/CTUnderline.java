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

public interface CTUnderline extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTUnderline.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctunderline8406type");
  
  STUnderline.Enum getVal();
  
  STUnderline xgetVal();
  
  boolean isSetVal();
  
  void setVal(STUnderline.Enum paramEnum);
  
  void xsetVal(STUnderline paramSTUnderline);
  
  void unsetVal();
  
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
  
  public static final class Factory {
    public static CTUnderline newInstance() {
      return (CTUnderline)POIXMLTypeLoader.newInstance(CTUnderline.type, null);
    }
    
    public static CTUnderline newInstance(XmlOptions param1XmlOptions) {
      return (CTUnderline)POIXMLTypeLoader.newInstance(CTUnderline.type, param1XmlOptions);
    }
    
    public static CTUnderline parse(String param1String) throws XmlException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1String, CTUnderline.type, null);
    }
    
    public static CTUnderline parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1String, CTUnderline.type, param1XmlOptions);
    }
    
    public static CTUnderline parse(File param1File) throws XmlException, IOException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1File, CTUnderline.type, null);
    }
    
    public static CTUnderline parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1File, CTUnderline.type, param1XmlOptions);
    }
    
    public static CTUnderline parse(URL param1URL) throws XmlException, IOException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1URL, CTUnderline.type, null);
    }
    
    public static CTUnderline parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1URL, CTUnderline.type, param1XmlOptions);
    }
    
    public static CTUnderline parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1InputStream, CTUnderline.type, null);
    }
    
    public static CTUnderline parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1InputStream, CTUnderline.type, param1XmlOptions);
    }
    
    public static CTUnderline parse(Reader param1Reader) throws XmlException, IOException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1Reader, CTUnderline.type, null);
    }
    
    public static CTUnderline parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1Reader, CTUnderline.type, param1XmlOptions);
    }
    
    public static CTUnderline parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1XMLStreamReader, CTUnderline.type, null);
    }
    
    public static CTUnderline parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1XMLStreamReader, CTUnderline.type, param1XmlOptions);
    }
    
    public static CTUnderline parse(Node param1Node) throws XmlException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1Node, CTUnderline.type, null);
    }
    
    public static CTUnderline parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1Node, CTUnderline.type, param1XmlOptions);
    }
    
    public static CTUnderline parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1XMLInputStream, CTUnderline.type, null);
    }
    
    public static CTUnderline parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTUnderline)POIXMLTypeLoader.parse(param1XMLInputStream, CTUnderline.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTUnderline.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTUnderline.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTUnderline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */