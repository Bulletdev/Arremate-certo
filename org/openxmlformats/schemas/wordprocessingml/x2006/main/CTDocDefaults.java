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

public interface CTDocDefaults extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDocDefaults.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdocdefaults2ea8type");
  
  CTRPrDefault getRPrDefault();
  
  boolean isSetRPrDefault();
  
  void setRPrDefault(CTRPrDefault paramCTRPrDefault);
  
  CTRPrDefault addNewRPrDefault();
  
  void unsetRPrDefault();
  
  CTPPrDefault getPPrDefault();
  
  boolean isSetPPrDefault();
  
  void setPPrDefault(CTPPrDefault paramCTPPrDefault);
  
  CTPPrDefault addNewPPrDefault();
  
  void unsetPPrDefault();
  
  public static final class Factory {
    public static CTDocDefaults newInstance() {
      return (CTDocDefaults)POIXMLTypeLoader.newInstance(CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults newInstance(XmlOptions param1XmlOptions) {
      return (CTDocDefaults)POIXMLTypeLoader.newInstance(CTDocDefaults.type, param1XmlOptions);
    }
    
    public static CTDocDefaults parse(String param1String) throws XmlException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1String, CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1String, CTDocDefaults.type, param1XmlOptions);
    }
    
    public static CTDocDefaults parse(File param1File) throws XmlException, IOException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1File, CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1File, CTDocDefaults.type, param1XmlOptions);
    }
    
    public static CTDocDefaults parse(URL param1URL) throws XmlException, IOException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1URL, CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1URL, CTDocDefaults.type, param1XmlOptions);
    }
    
    public static CTDocDefaults parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1InputStream, CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1InputStream, CTDocDefaults.type, param1XmlOptions);
    }
    
    public static CTDocDefaults parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1Reader, CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1Reader, CTDocDefaults.type, param1XmlOptions);
    }
    
    public static CTDocDefaults parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDocDefaults.type, param1XmlOptions);
    }
    
    public static CTDocDefaults parse(Node param1Node) throws XmlException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1Node, CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1Node, CTDocDefaults.type, param1XmlOptions);
    }
    
    public static CTDocDefaults parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1XMLInputStream, CTDocDefaults.type, null);
    }
    
    public static CTDocDefaults parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDocDefaults)POIXMLTypeLoader.parse(param1XMLInputStream, CTDocDefaults.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDocDefaults.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDocDefaults.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTDocDefaults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */