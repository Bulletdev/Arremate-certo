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

public interface STLangCode extends XmlHexBinary {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLangCode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlangcode02bdtype");
  
  public static final class Factory {
    public static STLangCode newValue(Object param1Object) {
      return (STLangCode)STLangCode.type.newValue(param1Object);
    }
    
    public static STLangCode newInstance() {
      return (STLangCode)POIXMLTypeLoader.newInstance(STLangCode.type, null);
    }
    
    public static STLangCode newInstance(XmlOptions param1XmlOptions) {
      return (STLangCode)POIXMLTypeLoader.newInstance(STLangCode.type, param1XmlOptions);
    }
    
    public static STLangCode parse(String param1String) throws XmlException {
      return (STLangCode)POIXMLTypeLoader.parse(param1String, STLangCode.type, null);
    }
    
    public static STLangCode parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLangCode)POIXMLTypeLoader.parse(param1String, STLangCode.type, param1XmlOptions);
    }
    
    public static STLangCode parse(File param1File) throws XmlException, IOException {
      return (STLangCode)POIXMLTypeLoader.parse(param1File, STLangCode.type, null);
    }
    
    public static STLangCode parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLangCode)POIXMLTypeLoader.parse(param1File, STLangCode.type, param1XmlOptions);
    }
    
    public static STLangCode parse(URL param1URL) throws XmlException, IOException {
      return (STLangCode)POIXMLTypeLoader.parse(param1URL, STLangCode.type, null);
    }
    
    public static STLangCode parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLangCode)POIXMLTypeLoader.parse(param1URL, STLangCode.type, param1XmlOptions);
    }
    
    public static STLangCode parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLangCode)POIXMLTypeLoader.parse(param1InputStream, STLangCode.type, null);
    }
    
    public static STLangCode parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLangCode)POIXMLTypeLoader.parse(param1InputStream, STLangCode.type, param1XmlOptions);
    }
    
    public static STLangCode parse(Reader param1Reader) throws XmlException, IOException {
      return (STLangCode)POIXMLTypeLoader.parse(param1Reader, STLangCode.type, null);
    }
    
    public static STLangCode parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLangCode)POIXMLTypeLoader.parse(param1Reader, STLangCode.type, param1XmlOptions);
    }
    
    public static STLangCode parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLangCode)POIXMLTypeLoader.parse(param1XMLStreamReader, STLangCode.type, null);
    }
    
    public static STLangCode parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLangCode)POIXMLTypeLoader.parse(param1XMLStreamReader, STLangCode.type, param1XmlOptions);
    }
    
    public static STLangCode parse(Node param1Node) throws XmlException {
      return (STLangCode)POIXMLTypeLoader.parse(param1Node, STLangCode.type, null);
    }
    
    public static STLangCode parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLangCode)POIXMLTypeLoader.parse(param1Node, STLangCode.type, param1XmlOptions);
    }
    
    public static STLangCode parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLangCode)POIXMLTypeLoader.parse(param1XMLInputStream, STLangCode.type, null);
    }
    
    public static STLangCode parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLangCode)POIXMLTypeLoader.parse(param1XMLInputStream, STLangCode.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLangCode.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLangCode.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STLangCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */