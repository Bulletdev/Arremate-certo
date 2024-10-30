package org.openxmlformats.schemas.presentationml.x2006.main;

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

public interface CTSlideSize extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlideSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidesizeb0fdtype");
  
  int getCx();
  
  STSlideSizeCoordinate xgetCx();
  
  void setCx(int paramInt);
  
  void xsetCx(STSlideSizeCoordinate paramSTSlideSizeCoordinate);
  
  int getCy();
  
  STSlideSizeCoordinate xgetCy();
  
  void setCy(int paramInt);
  
  void xsetCy(STSlideSizeCoordinate paramSTSlideSizeCoordinate);
  
  STSlideSizeType$Enum getType();
  
  STSlideSizeType xgetType();
  
  boolean isSetType();
  
  void setType(STSlideSizeType$Enum paramSTSlideSizeType$Enum);
  
  void xsetType(STSlideSizeType paramSTSlideSizeType);
  
  void unsetType();
  
  public static final class Factory {
    public static CTSlideSize newInstance() {
      return (CTSlideSize)POIXMLTypeLoader.newInstance(CTSlideSize.type, null);
    }
    
    public static CTSlideSize newInstance(XmlOptions param1XmlOptions) {
      return (CTSlideSize)POIXMLTypeLoader.newInstance(CTSlideSize.type, param1XmlOptions);
    }
    
    public static CTSlideSize parse(String param1String) throws XmlException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1String, CTSlideSize.type, null);
    }
    
    public static CTSlideSize parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1String, CTSlideSize.type, param1XmlOptions);
    }
    
    public static CTSlideSize parse(File param1File) throws XmlException, IOException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1File, CTSlideSize.type, null);
    }
    
    public static CTSlideSize parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1File, CTSlideSize.type, param1XmlOptions);
    }
    
    public static CTSlideSize parse(URL param1URL) throws XmlException, IOException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1URL, CTSlideSize.type, null);
    }
    
    public static CTSlideSize parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1URL, CTSlideSize.type, param1XmlOptions);
    }
    
    public static CTSlideSize parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1InputStream, CTSlideSize.type, null);
    }
    
    public static CTSlideSize parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1InputStream, CTSlideSize.type, param1XmlOptions);
    }
    
    public static CTSlideSize parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1Reader, CTSlideSize.type, null);
    }
    
    public static CTSlideSize parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1Reader, CTSlideSize.type, param1XmlOptions);
    }
    
    public static CTSlideSize parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideSize.type, null);
    }
    
    public static CTSlideSize parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideSize.type, param1XmlOptions);
    }
    
    public static CTSlideSize parse(Node param1Node) throws XmlException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1Node, CTSlideSize.type, null);
    }
    
    public static CTSlideSize parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1Node, CTSlideSize.type, param1XmlOptions);
    }
    
    public static CTSlideSize parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideSize.type, null);
    }
    
    public static CTSlideSize parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlideSize)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideSize.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideSize.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideSize.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlideSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */