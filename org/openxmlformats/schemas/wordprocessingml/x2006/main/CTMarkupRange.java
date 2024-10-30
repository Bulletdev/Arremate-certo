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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTMarkupRange extends CTMarkup {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMarkupRange.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmarkuprangeba3dtype");
  
  STDisplacedByCustomXml$Enum getDisplacedByCustomXml();
  
  STDisplacedByCustomXml xgetDisplacedByCustomXml();
  
  boolean isSetDisplacedByCustomXml();
  
  void setDisplacedByCustomXml(STDisplacedByCustomXml$Enum paramSTDisplacedByCustomXml$Enum);
  
  void xsetDisplacedByCustomXml(STDisplacedByCustomXml paramSTDisplacedByCustomXml);
  
  void unsetDisplacedByCustomXml();
  
  public static final class Factory {
    public static CTMarkupRange newInstance() {
      return (CTMarkupRange)POIXMLTypeLoader.newInstance(CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange newInstance(XmlOptions param1XmlOptions) {
      return (CTMarkupRange)POIXMLTypeLoader.newInstance(CTMarkupRange.type, param1XmlOptions);
    }
    
    public static CTMarkupRange parse(String param1String) throws XmlException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1String, CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1String, CTMarkupRange.type, param1XmlOptions);
    }
    
    public static CTMarkupRange parse(File param1File) throws XmlException, IOException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1File, CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1File, CTMarkupRange.type, param1XmlOptions);
    }
    
    public static CTMarkupRange parse(URL param1URL) throws XmlException, IOException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1URL, CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1URL, CTMarkupRange.type, param1XmlOptions);
    }
    
    public static CTMarkupRange parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1InputStream, CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1InputStream, CTMarkupRange.type, param1XmlOptions);
    }
    
    public static CTMarkupRange parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1Reader, CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1Reader, CTMarkupRange.type, param1XmlOptions);
    }
    
    public static CTMarkupRange parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMarkupRange.type, param1XmlOptions);
    }
    
    public static CTMarkupRange parse(Node param1Node) throws XmlException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1Node, CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1Node, CTMarkupRange.type, param1XmlOptions);
    }
    
    public static CTMarkupRange parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1XMLInputStream, CTMarkupRange.type, null);
    }
    
    public static CTMarkupRange parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMarkupRange)POIXMLTypeLoader.parse(param1XMLInputStream, CTMarkupRange.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMarkupRange.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMarkupRange.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTMarkupRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */