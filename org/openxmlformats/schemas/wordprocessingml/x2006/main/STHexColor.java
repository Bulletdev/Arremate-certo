package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STHexColor extends XmlAnySimpleType {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHexColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthexcolor55d0type");
  
  Object getObjectValue();
  
  void setObjectValue(Object paramObject);
  
  Object objectValue();
  
  void objectSet(Object paramObject);
  
  SchemaType instanceType();
  
  public static final class Factory {
    public static STHexColor newValue(Object param1Object) {
      return (STHexColor)STHexColor.type.newValue(param1Object);
    }
    
    public static STHexColor newInstance() {
      return (STHexColor)POIXMLTypeLoader.newInstance(STHexColor.type, null);
    }
    
    public static STHexColor newInstance(XmlOptions param1XmlOptions) {
      return (STHexColor)POIXMLTypeLoader.newInstance(STHexColor.type, param1XmlOptions);
    }
    
    public static STHexColor parse(String param1String) throws XmlException {
      return (STHexColor)POIXMLTypeLoader.parse(param1String, STHexColor.type, null);
    }
    
    public static STHexColor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColor)POIXMLTypeLoader.parse(param1String, STHexColor.type, param1XmlOptions);
    }
    
    public static STHexColor parse(File param1File) throws XmlException, IOException {
      return (STHexColor)POIXMLTypeLoader.parse(param1File, STHexColor.type, null);
    }
    
    public static STHexColor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColor)POIXMLTypeLoader.parse(param1File, STHexColor.type, param1XmlOptions);
    }
    
    public static STHexColor parse(URL param1URL) throws XmlException, IOException {
      return (STHexColor)POIXMLTypeLoader.parse(param1URL, STHexColor.type, null);
    }
    
    public static STHexColor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColor)POIXMLTypeLoader.parse(param1URL, STHexColor.type, param1XmlOptions);
    }
    
    public static STHexColor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHexColor)POIXMLTypeLoader.parse(param1InputStream, STHexColor.type, null);
    }
    
    public static STHexColor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColor)POIXMLTypeLoader.parse(param1InputStream, STHexColor.type, param1XmlOptions);
    }
    
    public static STHexColor parse(Reader param1Reader) throws XmlException, IOException {
      return (STHexColor)POIXMLTypeLoader.parse(param1Reader, STHexColor.type, null);
    }
    
    public static STHexColor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColor)POIXMLTypeLoader.parse(param1Reader, STHexColor.type, param1XmlOptions);
    }
    
    public static STHexColor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHexColor)POIXMLTypeLoader.parse(param1XMLStreamReader, STHexColor.type, null);
    }
    
    public static STHexColor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColor)POIXMLTypeLoader.parse(param1XMLStreamReader, STHexColor.type, param1XmlOptions);
    }
    
    public static STHexColor parse(Node param1Node) throws XmlException {
      return (STHexColor)POIXMLTypeLoader.parse(param1Node, STHexColor.type, null);
    }
    
    public static STHexColor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColor)POIXMLTypeLoader.parse(param1Node, STHexColor.type, param1XmlOptions);
    }
    
    public static STHexColor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHexColor)POIXMLTypeLoader.parse(param1XMLInputStream, STHexColor.type, null);
    }
    
    public static STHexColor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHexColor)POIXMLTypeLoader.parse(param1XMLInputStream, STHexColor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHexColor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHexColor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STHexColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */