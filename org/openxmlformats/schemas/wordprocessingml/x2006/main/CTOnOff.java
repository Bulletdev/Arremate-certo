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

public interface CTOnOff extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTOnOff.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctonoff04c2type");
  
  STOnOff.Enum getVal();
  
  STOnOff xgetVal();
  
  boolean isSetVal();
  
  void setVal(STOnOff.Enum paramEnum);
  
  void xsetVal(STOnOff paramSTOnOff);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTOnOff newInstance() {
      return (CTOnOff)POIXMLTypeLoader.newInstance(CTOnOff.type, null);
    }
    
    public static CTOnOff newInstance(XmlOptions param1XmlOptions) {
      return (CTOnOff)POIXMLTypeLoader.newInstance(CTOnOff.type, param1XmlOptions);
    }
    
    public static CTOnOff parse(String param1String) throws XmlException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1String, CTOnOff.type, null);
    }
    
    public static CTOnOff parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1String, CTOnOff.type, param1XmlOptions);
    }
    
    public static CTOnOff parse(File param1File) throws XmlException, IOException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1File, CTOnOff.type, null);
    }
    
    public static CTOnOff parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1File, CTOnOff.type, param1XmlOptions);
    }
    
    public static CTOnOff parse(URL param1URL) throws XmlException, IOException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1URL, CTOnOff.type, null);
    }
    
    public static CTOnOff parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1URL, CTOnOff.type, param1XmlOptions);
    }
    
    public static CTOnOff parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1InputStream, CTOnOff.type, null);
    }
    
    public static CTOnOff parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1InputStream, CTOnOff.type, param1XmlOptions);
    }
    
    public static CTOnOff parse(Reader param1Reader) throws XmlException, IOException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1Reader, CTOnOff.type, null);
    }
    
    public static CTOnOff parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1Reader, CTOnOff.type, param1XmlOptions);
    }
    
    public static CTOnOff parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOnOff.type, null);
    }
    
    public static CTOnOff parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOnOff.type, param1XmlOptions);
    }
    
    public static CTOnOff parse(Node param1Node) throws XmlException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1Node, CTOnOff.type, null);
    }
    
    public static CTOnOff parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1Node, CTOnOff.type, param1XmlOptions);
    }
    
    public static CTOnOff parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1XMLInputStream, CTOnOff.type, null);
    }
    
    public static CTOnOff parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTOnOff)POIXMLTypeLoader.parse(param1XMLInputStream, CTOnOff.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOnOff.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOnOff.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTOnOff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */