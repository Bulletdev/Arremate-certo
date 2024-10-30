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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBaseStyles extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBaseStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbasestyles122etype");
  
  CTColorScheme getClrScheme();
  
  void setClrScheme(CTColorScheme paramCTColorScheme);
  
  CTColorScheme addNewClrScheme();
  
  CTFontScheme getFontScheme();
  
  void setFontScheme(CTFontScheme paramCTFontScheme);
  
  CTFontScheme addNewFontScheme();
  
  CTStyleMatrix getFmtScheme();
  
  void setFmtScheme(CTStyleMatrix paramCTStyleMatrix);
  
  CTStyleMatrix addNewFmtScheme();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTBaseStyles newInstance() {
      return (CTBaseStyles)POIXMLTypeLoader.newInstance(CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles newInstance(XmlOptions param1XmlOptions) {
      return (CTBaseStyles)POIXMLTypeLoader.newInstance(CTBaseStyles.type, param1XmlOptions);
    }
    
    public static CTBaseStyles parse(String param1String) throws XmlException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1String, CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1String, CTBaseStyles.type, param1XmlOptions);
    }
    
    public static CTBaseStyles parse(File param1File) throws XmlException, IOException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1File, CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1File, CTBaseStyles.type, param1XmlOptions);
    }
    
    public static CTBaseStyles parse(URL param1URL) throws XmlException, IOException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1URL, CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1URL, CTBaseStyles.type, param1XmlOptions);
    }
    
    public static CTBaseStyles parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1InputStream, CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1InputStream, CTBaseStyles.type, param1XmlOptions);
    }
    
    public static CTBaseStyles parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1Reader, CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1Reader, CTBaseStyles.type, param1XmlOptions);
    }
    
    public static CTBaseStyles parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBaseStyles.type, param1XmlOptions);
    }
    
    public static CTBaseStyles parse(Node param1Node) throws XmlException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1Node, CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1Node, CTBaseStyles.type, param1XmlOptions);
    }
    
    public static CTBaseStyles parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1XMLInputStream, CTBaseStyles.type, null);
    }
    
    public static CTBaseStyles parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBaseStyles)POIXMLTypeLoader.parse(param1XMLInputStream, CTBaseStyles.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBaseStyles.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBaseStyles.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTBaseStyles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */