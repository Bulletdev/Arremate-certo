package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STTextIndentLevelType extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextIndentLevelType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextindentleveltypeaf86type");
  
  public static final class Factory {
    public static STTextIndentLevelType newValue(Object param1Object) {
      return (STTextIndentLevelType)STTextIndentLevelType.type.newValue(param1Object);
    }
    
    public static STTextIndentLevelType newInstance() {
      return (STTextIndentLevelType)POIXMLTypeLoader.newInstance(STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType newInstance(XmlOptions param1XmlOptions) {
      return (STTextIndentLevelType)POIXMLTypeLoader.newInstance(STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static STTextIndentLevelType parse(String param1String) throws XmlException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1String, STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1String, STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static STTextIndentLevelType parse(File param1File) throws XmlException, IOException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1File, STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1File, STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static STTextIndentLevelType parse(URL param1URL) throws XmlException, IOException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1URL, STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1URL, STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static STTextIndentLevelType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1InputStream, STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1InputStream, STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static STTextIndentLevelType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1Reader, STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1Reader, STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static STTextIndentLevelType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static STTextIndentLevelType parse(Node param1Node) throws XmlException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1Node, STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1Node, STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static STTextIndentLevelType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextIndentLevelType.type, null);
    }
    
    public static STTextIndentLevelType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextIndentLevelType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextIndentLevelType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextIndentLevelType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextIndentLevelType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextIndentLevelType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */