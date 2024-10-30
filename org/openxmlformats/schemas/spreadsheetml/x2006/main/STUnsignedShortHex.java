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

public interface STUnsignedShortHex extends XmlHexBinary {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STUnsignedShortHex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stunsignedshorthex0bedtype");
  
  public static final class Factory {
    public static STUnsignedShortHex newValue(Object param1Object) {
      return (STUnsignedShortHex)STUnsignedShortHex.type.newValue(param1Object);
    }
    
    public static STUnsignedShortHex newInstance() {
      return (STUnsignedShortHex)POIXMLTypeLoader.newInstance(STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex newInstance(XmlOptions param1XmlOptions) {
      return (STUnsignedShortHex)POIXMLTypeLoader.newInstance(STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static STUnsignedShortHex parse(String param1String) throws XmlException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1String, STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1String, STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static STUnsignedShortHex parse(File param1File) throws XmlException, IOException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1File, STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1File, STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static STUnsignedShortHex parse(URL param1URL) throws XmlException, IOException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1URL, STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1URL, STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static STUnsignedShortHex parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1InputStream, STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1InputStream, STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static STUnsignedShortHex parse(Reader param1Reader) throws XmlException, IOException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1Reader, STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1Reader, STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static STUnsignedShortHex parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static STUnsignedShortHex parse(Node param1Node) throws XmlException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1Node, STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1Node, STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static STUnsignedShortHex parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1XMLInputStream, STUnsignedShortHex.type, null);
    }
    
    public static STUnsignedShortHex parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STUnsignedShortHex)POIXMLTypeLoader.parse(param1XMLInputStream, STUnsignedShortHex.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnsignedShortHex.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnsignedShortHex.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STUnsignedShortHex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */