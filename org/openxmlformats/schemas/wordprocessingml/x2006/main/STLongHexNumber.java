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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STLongHexNumber extends XmlHexBinary {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLongHexNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlonghexnumberd6batype");
  
  public static final class Factory {
    public static STLongHexNumber newValue(Object param1Object) {
      return (STLongHexNumber)STLongHexNumber.type.newValue(param1Object);
    }
    
    public static STLongHexNumber newInstance() {
      return (STLongHexNumber)POIXMLTypeLoader.newInstance(STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber newInstance(XmlOptions param1XmlOptions) {
      return (STLongHexNumber)POIXMLTypeLoader.newInstance(STLongHexNumber.type, param1XmlOptions);
    }
    
    public static STLongHexNumber parse(String param1String) throws XmlException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1String, STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1String, STLongHexNumber.type, param1XmlOptions);
    }
    
    public static STLongHexNumber parse(File param1File) throws XmlException, IOException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1File, STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1File, STLongHexNumber.type, param1XmlOptions);
    }
    
    public static STLongHexNumber parse(URL param1URL) throws XmlException, IOException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1URL, STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1URL, STLongHexNumber.type, param1XmlOptions);
    }
    
    public static STLongHexNumber parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1InputStream, STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1InputStream, STLongHexNumber.type, param1XmlOptions);
    }
    
    public static STLongHexNumber parse(Reader param1Reader) throws XmlException, IOException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1Reader, STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1Reader, STLongHexNumber.type, param1XmlOptions);
    }
    
    public static STLongHexNumber parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1XMLStreamReader, STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1XMLStreamReader, STLongHexNumber.type, param1XmlOptions);
    }
    
    public static STLongHexNumber parse(Node param1Node) throws XmlException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1Node, STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1Node, STLongHexNumber.type, param1XmlOptions);
    }
    
    public static STLongHexNumber parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1XMLInputStream, STLongHexNumber.type, null);
    }
    
    public static STLongHexNumber parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLongHexNumber)POIXMLTypeLoader.parse(param1XMLInputStream, STLongHexNumber.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLongHexNumber.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLongHexNumber.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STLongHexNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */