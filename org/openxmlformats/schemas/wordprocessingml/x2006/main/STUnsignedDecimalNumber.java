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
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STUnsignedDecimalNumber extends XmlUnsignedLong {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STUnsignedDecimalNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stunsigneddecimalnumber74fdtype");
  
  public static final class Factory {
    public static STUnsignedDecimalNumber newValue(Object param1Object) {
      return (STUnsignedDecimalNumber)STUnsignedDecimalNumber.type.newValue(param1Object);
    }
    
    public static STUnsignedDecimalNumber newInstance() {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.newInstance(STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber newInstance(XmlOptions param1XmlOptions) {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.newInstance(STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static STUnsignedDecimalNumber parse(String param1String) throws XmlException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1String, STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1String, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static STUnsignedDecimalNumber parse(File param1File) throws XmlException, IOException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1File, STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1File, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static STUnsignedDecimalNumber parse(URL param1URL) throws XmlException, IOException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1URL, STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1URL, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static STUnsignedDecimalNumber parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1InputStream, STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1InputStream, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static STUnsignedDecimalNumber parse(Reader param1Reader) throws XmlException, IOException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1Reader, STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1Reader, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static STUnsignedDecimalNumber parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static STUnsignedDecimalNumber parse(Node param1Node) throws XmlException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1Node, STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1Node, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static STUnsignedDecimalNumber parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1XMLInputStream, STUnsignedDecimalNumber.type, null);
    }
    
    public static STUnsignedDecimalNumber parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STUnsignedDecimalNumber)POIXMLTypeLoader.parse(param1XMLInputStream, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnsignedDecimalNumber.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnsignedDecimalNumber.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STUnsignedDecimalNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */