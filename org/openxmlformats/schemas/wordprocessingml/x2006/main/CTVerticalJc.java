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

public interface CTVerticalJc extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTVerticalJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctverticaljca439type");
  
  STVerticalJc.Enum getVal();
  
  STVerticalJc xgetVal();
  
  void setVal(STVerticalJc.Enum paramEnum);
  
  void xsetVal(STVerticalJc paramSTVerticalJc);
  
  public static final class Factory {
    public static CTVerticalJc newInstance() {
      return (CTVerticalJc)POIXMLTypeLoader.newInstance(CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc newInstance(XmlOptions param1XmlOptions) {
      return (CTVerticalJc)POIXMLTypeLoader.newInstance(CTVerticalJc.type, param1XmlOptions);
    }
    
    public static CTVerticalJc parse(String param1String) throws XmlException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1String, CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1String, CTVerticalJc.type, param1XmlOptions);
    }
    
    public static CTVerticalJc parse(File param1File) throws XmlException, IOException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1File, CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1File, CTVerticalJc.type, param1XmlOptions);
    }
    
    public static CTVerticalJc parse(URL param1URL) throws XmlException, IOException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1URL, CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1URL, CTVerticalJc.type, param1XmlOptions);
    }
    
    public static CTVerticalJc parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1InputStream, CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1InputStream, CTVerticalJc.type, param1XmlOptions);
    }
    
    public static CTVerticalJc parse(Reader param1Reader) throws XmlException, IOException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1Reader, CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1Reader, CTVerticalJc.type, param1XmlOptions);
    }
    
    public static CTVerticalJc parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVerticalJc.type, param1XmlOptions);
    }
    
    public static CTVerticalJc parse(Node param1Node) throws XmlException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1Node, CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1Node, CTVerticalJc.type, param1XmlOptions);
    }
    
    public static CTVerticalJc parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1XMLInputStream, CTVerticalJc.type, null);
    }
    
    public static CTVerticalJc parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTVerticalJc)POIXMLTypeLoader.parse(param1XMLInputStream, CTVerticalJc.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVerticalJc.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVerticalJc.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTVerticalJc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */