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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPhoneticPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPhoneticPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctphoneticpr898btype");
  
  long getFontId();
  
  STFontId xgetFontId();
  
  void setFontId(long paramLong);
  
  void xsetFontId(STFontId paramSTFontId);
  
  STPhoneticType$Enum getType();
  
  STPhoneticType xgetType();
  
  boolean isSetType();
  
  void setType(STPhoneticType$Enum paramSTPhoneticType$Enum);
  
  void xsetType(STPhoneticType paramSTPhoneticType);
  
  void unsetType();
  
  STPhoneticAlignment$Enum getAlignment();
  
  STPhoneticAlignment xgetAlignment();
  
  boolean isSetAlignment();
  
  void setAlignment(STPhoneticAlignment$Enum paramSTPhoneticAlignment$Enum);
  
  void xsetAlignment(STPhoneticAlignment paramSTPhoneticAlignment);
  
  void unsetAlignment();
  
  public static final class Factory {
    public static CTPhoneticPr newInstance() {
      return (CTPhoneticPr)POIXMLTypeLoader.newInstance(CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr newInstance(XmlOptions param1XmlOptions) {
      return (CTPhoneticPr)POIXMLTypeLoader.newInstance(CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static CTPhoneticPr parse(String param1String) throws XmlException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1String, CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1String, CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static CTPhoneticPr parse(File param1File) throws XmlException, IOException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1File, CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1File, CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static CTPhoneticPr parse(URL param1URL) throws XmlException, IOException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1URL, CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1URL, CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static CTPhoneticPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1InputStream, CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1InputStream, CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static CTPhoneticPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1Reader, CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1Reader, CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static CTPhoneticPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static CTPhoneticPr parse(Node param1Node) throws XmlException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1Node, CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1Node, CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static CTPhoneticPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTPhoneticPr.type, null);
    }
    
    public static CTPhoneticPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPhoneticPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTPhoneticPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPhoneticPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPhoneticPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPhoneticPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */