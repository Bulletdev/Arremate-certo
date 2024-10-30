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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STUnsignedIntHex extends XmlHexBinary {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STUnsignedIntHex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stunsignedinthex27datype");
  
  public static final class Factory {
    public static STUnsignedIntHex newValue(Object param1Object) {
      return (STUnsignedIntHex)STUnsignedIntHex.type.newValue(param1Object);
    }
    
    public static STUnsignedIntHex newInstance() {
      return (STUnsignedIntHex)POIXMLTypeLoader.newInstance(STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex newInstance(XmlOptions param1XmlOptions) {
      return (STUnsignedIntHex)POIXMLTypeLoader.newInstance(STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static STUnsignedIntHex parse(String param1String) throws XmlException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1String, STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1String, STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static STUnsignedIntHex parse(File param1File) throws XmlException, IOException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1File, STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1File, STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static STUnsignedIntHex parse(URL param1URL) throws XmlException, IOException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1URL, STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1URL, STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static STUnsignedIntHex parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1InputStream, STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1InputStream, STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static STUnsignedIntHex parse(Reader param1Reader) throws XmlException, IOException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1Reader, STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1Reader, STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static STUnsignedIntHex parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static STUnsignedIntHex parse(Node param1Node) throws XmlException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1Node, STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1Node, STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static STUnsignedIntHex parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1XMLInputStream, STUnsignedIntHex.type, null);
    }
    
    public static STUnsignedIntHex parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STUnsignedIntHex)POIXMLTypeLoader.parse(param1XMLInputStream, STUnsignedIntHex.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnsignedIntHex.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnsignedIntHex.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STUnsignedIntHex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */