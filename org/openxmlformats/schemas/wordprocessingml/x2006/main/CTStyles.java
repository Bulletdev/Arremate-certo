package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTStyles extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstyles8506type");
  
  CTDocDefaults getDocDefaults();
  
  boolean isSetDocDefaults();
  
  void setDocDefaults(CTDocDefaults paramCTDocDefaults);
  
  CTDocDefaults addNewDocDefaults();
  
  void unsetDocDefaults();
  
  CTLatentStyles getLatentStyles();
  
  boolean isSetLatentStyles();
  
  void setLatentStyles(CTLatentStyles paramCTLatentStyles);
  
  CTLatentStyles addNewLatentStyles();
  
  void unsetLatentStyles();
  
  List<CTStyle> getStyleList();
  
  CTStyle[] getStyleArray();
  
  CTStyle getStyleArray(int paramInt);
  
  int sizeOfStyleArray();
  
  void setStyleArray(CTStyle[] paramArrayOfCTStyle);
  
  void setStyleArray(int paramInt, CTStyle paramCTStyle);
  
  CTStyle insertNewStyle(int paramInt);
  
  CTStyle addNewStyle();
  
  void removeStyle(int paramInt);
  
  public static final class Factory {
    public static CTStyles newInstance() {
      return (CTStyles)POIXMLTypeLoader.newInstance(CTStyles.type, null);
    }
    
    public static CTStyles newInstance(XmlOptions param1XmlOptions) {
      return (CTStyles)POIXMLTypeLoader.newInstance(CTStyles.type, param1XmlOptions);
    }
    
    public static CTStyles parse(String param1String) throws XmlException {
      return (CTStyles)POIXMLTypeLoader.parse(param1String, CTStyles.type, null);
    }
    
    public static CTStyles parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyles)POIXMLTypeLoader.parse(param1String, CTStyles.type, param1XmlOptions);
    }
    
    public static CTStyles parse(File param1File) throws XmlException, IOException {
      return (CTStyles)POIXMLTypeLoader.parse(param1File, CTStyles.type, null);
    }
    
    public static CTStyles parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyles)POIXMLTypeLoader.parse(param1File, CTStyles.type, param1XmlOptions);
    }
    
    public static CTStyles parse(URL param1URL) throws XmlException, IOException {
      return (CTStyles)POIXMLTypeLoader.parse(param1URL, CTStyles.type, null);
    }
    
    public static CTStyles parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyles)POIXMLTypeLoader.parse(param1URL, CTStyles.type, param1XmlOptions);
    }
    
    public static CTStyles parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStyles)POIXMLTypeLoader.parse(param1InputStream, CTStyles.type, null);
    }
    
    public static CTStyles parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyles)POIXMLTypeLoader.parse(param1InputStream, CTStyles.type, param1XmlOptions);
    }
    
    public static CTStyles parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStyles)POIXMLTypeLoader.parse(param1Reader, CTStyles.type, null);
    }
    
    public static CTStyles parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyles)POIXMLTypeLoader.parse(param1Reader, CTStyles.type, param1XmlOptions);
    }
    
    public static CTStyles parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStyles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStyles.type, null);
    }
    
    public static CTStyles parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStyles.type, param1XmlOptions);
    }
    
    public static CTStyles parse(Node param1Node) throws XmlException {
      return (CTStyles)POIXMLTypeLoader.parse(param1Node, CTStyles.type, null);
    }
    
    public static CTStyles parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyles)POIXMLTypeLoader.parse(param1Node, CTStyles.type, param1XmlOptions);
    }
    
    public static CTStyles parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStyles)POIXMLTypeLoader.parse(param1XMLInputStream, CTStyles.type, null);
    }
    
    public static CTStyles parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStyles)POIXMLTypeLoader.parse(param1XMLInputStream, CTStyles.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStyles.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStyles.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTStyles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */