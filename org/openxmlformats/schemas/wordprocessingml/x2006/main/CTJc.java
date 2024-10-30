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

public interface CTJc extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctjc158ftype");
  
  STJc.Enum getVal();
  
  STJc xgetVal();
  
  void setVal(STJc.Enum paramEnum);
  
  void xsetVal(STJc paramSTJc);
  
  public static final class Factory {
    public static CTJc newInstance() {
      return (CTJc)POIXMLTypeLoader.newInstance(CTJc.type, null);
    }
    
    public static CTJc newInstance(XmlOptions param1XmlOptions) {
      return (CTJc)POIXMLTypeLoader.newInstance(CTJc.type, param1XmlOptions);
    }
    
    public static CTJc parse(String param1String) throws XmlException {
      return (CTJc)POIXMLTypeLoader.parse(param1String, CTJc.type, null);
    }
    
    public static CTJc parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTJc)POIXMLTypeLoader.parse(param1String, CTJc.type, param1XmlOptions);
    }
    
    public static CTJc parse(File param1File) throws XmlException, IOException {
      return (CTJc)POIXMLTypeLoader.parse(param1File, CTJc.type, null);
    }
    
    public static CTJc parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTJc)POIXMLTypeLoader.parse(param1File, CTJc.type, param1XmlOptions);
    }
    
    public static CTJc parse(URL param1URL) throws XmlException, IOException {
      return (CTJc)POIXMLTypeLoader.parse(param1URL, CTJc.type, null);
    }
    
    public static CTJc parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTJc)POIXMLTypeLoader.parse(param1URL, CTJc.type, param1XmlOptions);
    }
    
    public static CTJc parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTJc)POIXMLTypeLoader.parse(param1InputStream, CTJc.type, null);
    }
    
    public static CTJc parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTJc)POIXMLTypeLoader.parse(param1InputStream, CTJc.type, param1XmlOptions);
    }
    
    public static CTJc parse(Reader param1Reader) throws XmlException, IOException {
      return (CTJc)POIXMLTypeLoader.parse(param1Reader, CTJc.type, null);
    }
    
    public static CTJc parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTJc)POIXMLTypeLoader.parse(param1Reader, CTJc.type, param1XmlOptions);
    }
    
    public static CTJc parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTJc)POIXMLTypeLoader.parse(param1XMLStreamReader, CTJc.type, null);
    }
    
    public static CTJc parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTJc)POIXMLTypeLoader.parse(param1XMLStreamReader, CTJc.type, param1XmlOptions);
    }
    
    public static CTJc parse(Node param1Node) throws XmlException {
      return (CTJc)POIXMLTypeLoader.parse(param1Node, CTJc.type, null);
    }
    
    public static CTJc parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTJc)POIXMLTypeLoader.parse(param1Node, CTJc.type, param1XmlOptions);
    }
    
    public static CTJc parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTJc)POIXMLTypeLoader.parse(param1XMLInputStream, CTJc.type, null);
    }
    
    public static CTJc parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTJc)POIXMLTypeLoader.parse(param1XMLInputStream, CTJc.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTJc.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTJc.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTJc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */