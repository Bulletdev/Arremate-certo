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
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STDecimalNumber extends XmlInteger {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STDecimalNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdecimalnumber8d28type");
  
  public static final class Factory {
    public static STDecimalNumber newValue(Object param1Object) {
      return (STDecimalNumber)STDecimalNumber.type.newValue(param1Object);
    }
    
    public static STDecimalNumber newInstance() {
      return (STDecimalNumber)POIXMLTypeLoader.newInstance(STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber newInstance(XmlOptions param1XmlOptions) {
      return (STDecimalNumber)POIXMLTypeLoader.newInstance(STDecimalNumber.type, param1XmlOptions);
    }
    
    public static STDecimalNumber parse(String param1String) throws XmlException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1String, STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1String, STDecimalNumber.type, param1XmlOptions);
    }
    
    public static STDecimalNumber parse(File param1File) throws XmlException, IOException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1File, STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1File, STDecimalNumber.type, param1XmlOptions);
    }
    
    public static STDecimalNumber parse(URL param1URL) throws XmlException, IOException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1URL, STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1URL, STDecimalNumber.type, param1XmlOptions);
    }
    
    public static STDecimalNumber parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1InputStream, STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1InputStream, STDecimalNumber.type, param1XmlOptions);
    }
    
    public static STDecimalNumber parse(Reader param1Reader) throws XmlException, IOException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1Reader, STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1Reader, STDecimalNumber.type, param1XmlOptions);
    }
    
    public static STDecimalNumber parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1XMLStreamReader, STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1XMLStreamReader, STDecimalNumber.type, param1XmlOptions);
    }
    
    public static STDecimalNumber parse(Node param1Node) throws XmlException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1Node, STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1Node, STDecimalNumber.type, param1XmlOptions);
    }
    
    public static STDecimalNumber parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1XMLInputStream, STDecimalNumber.type, null);
    }
    
    public static STDecimalNumber parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STDecimalNumber)POIXMLTypeLoader.parse(param1XMLInputStream, STDecimalNumber.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDecimalNumber.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDecimalNumber.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STDecimalNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */