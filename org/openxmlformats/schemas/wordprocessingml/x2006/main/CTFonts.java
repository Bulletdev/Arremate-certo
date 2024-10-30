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

public interface CTFonts extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFonts.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfonts124etype");
  
  STHint$Enum getHint();
  
  STHint xgetHint();
  
  boolean isSetHint();
  
  void setHint(STHint$Enum paramSTHint$Enum);
  
  void xsetHint(STHint paramSTHint);
  
  void unsetHint();
  
  String getAscii();
  
  STString xgetAscii();
  
  boolean isSetAscii();
  
  void setAscii(String paramString);
  
  void xsetAscii(STString paramSTString);
  
  void unsetAscii();
  
  String getHAnsi();
  
  STString xgetHAnsi();
  
  boolean isSetHAnsi();
  
  void setHAnsi(String paramString);
  
  void xsetHAnsi(STString paramSTString);
  
  void unsetHAnsi();
  
  String getEastAsia();
  
  STString xgetEastAsia();
  
  boolean isSetEastAsia();
  
  void setEastAsia(String paramString);
  
  void xsetEastAsia(STString paramSTString);
  
  void unsetEastAsia();
  
  String getCs();
  
  STString xgetCs();
  
  boolean isSetCs();
  
  void setCs(String paramString);
  
  void xsetCs(STString paramSTString);
  
  void unsetCs();
  
  STTheme.Enum getAsciiTheme();
  
  STTheme xgetAsciiTheme();
  
  boolean isSetAsciiTheme();
  
  void setAsciiTheme(STTheme.Enum paramEnum);
  
  void xsetAsciiTheme(STTheme paramSTTheme);
  
  void unsetAsciiTheme();
  
  STTheme.Enum getHAnsiTheme();
  
  STTheme xgetHAnsiTheme();
  
  boolean isSetHAnsiTheme();
  
  void setHAnsiTheme(STTheme.Enum paramEnum);
  
  void xsetHAnsiTheme(STTheme paramSTTheme);
  
  void unsetHAnsiTheme();
  
  STTheme.Enum getEastAsiaTheme();
  
  STTheme xgetEastAsiaTheme();
  
  boolean isSetEastAsiaTheme();
  
  void setEastAsiaTheme(STTheme.Enum paramEnum);
  
  void xsetEastAsiaTheme(STTheme paramSTTheme);
  
  void unsetEastAsiaTheme();
  
  STTheme.Enum getCstheme();
  
  STTheme xgetCstheme();
  
  boolean isSetCstheme();
  
  void setCstheme(STTheme.Enum paramEnum);
  
  void xsetCstheme(STTheme paramSTTheme);
  
  void unsetCstheme();
  
  public static final class Factory {
    public static CTFonts newInstance() {
      return (CTFonts)POIXMLTypeLoader.newInstance(CTFonts.type, null);
    }
    
    public static CTFonts newInstance(XmlOptions param1XmlOptions) {
      return (CTFonts)POIXMLTypeLoader.newInstance(CTFonts.type, param1XmlOptions);
    }
    
    public static CTFonts parse(String param1String) throws XmlException {
      return (CTFonts)POIXMLTypeLoader.parse(param1String, CTFonts.type, null);
    }
    
    public static CTFonts parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFonts)POIXMLTypeLoader.parse(param1String, CTFonts.type, param1XmlOptions);
    }
    
    public static CTFonts parse(File param1File) throws XmlException, IOException {
      return (CTFonts)POIXMLTypeLoader.parse(param1File, CTFonts.type, null);
    }
    
    public static CTFonts parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFonts)POIXMLTypeLoader.parse(param1File, CTFonts.type, param1XmlOptions);
    }
    
    public static CTFonts parse(URL param1URL) throws XmlException, IOException {
      return (CTFonts)POIXMLTypeLoader.parse(param1URL, CTFonts.type, null);
    }
    
    public static CTFonts parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFonts)POIXMLTypeLoader.parse(param1URL, CTFonts.type, param1XmlOptions);
    }
    
    public static CTFonts parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFonts)POIXMLTypeLoader.parse(param1InputStream, CTFonts.type, null);
    }
    
    public static CTFonts parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFonts)POIXMLTypeLoader.parse(param1InputStream, CTFonts.type, param1XmlOptions);
    }
    
    public static CTFonts parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFonts)POIXMLTypeLoader.parse(param1Reader, CTFonts.type, null);
    }
    
    public static CTFonts parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFonts)POIXMLTypeLoader.parse(param1Reader, CTFonts.type, param1XmlOptions);
    }
    
    public static CTFonts parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFonts)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFonts.type, null);
    }
    
    public static CTFonts parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFonts)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFonts.type, param1XmlOptions);
    }
    
    public static CTFonts parse(Node param1Node) throws XmlException {
      return (CTFonts)POIXMLTypeLoader.parse(param1Node, CTFonts.type, null);
    }
    
    public static CTFonts parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFonts)POIXMLTypeLoader.parse(param1Node, CTFonts.type, param1XmlOptions);
    }
    
    public static CTFonts parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFonts)POIXMLTypeLoader.parse(param1XMLInputStream, CTFonts.type, null);
    }
    
    public static CTFonts parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFonts)POIXMLTypeLoader.parse(param1XMLInputStream, CTFonts.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFonts.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFonts.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTFonts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */