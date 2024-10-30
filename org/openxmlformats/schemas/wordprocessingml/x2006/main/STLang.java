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

public interface STLang extends XmlAnySimpleType {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLang.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlanga02atype");
  
  Object getObjectValue();
  
  void setObjectValue(Object paramObject);
  
  Object objectValue();
  
  void objectSet(Object paramObject);
  
  SchemaType instanceType();
  
  public static final class Factory {
    public static STLang newValue(Object param1Object) {
      return (STLang)STLang.type.newValue(param1Object);
    }
    
    public static STLang newInstance() {
      return (STLang)POIXMLTypeLoader.newInstance(STLang.type, null);
    }
    
    public static STLang newInstance(XmlOptions param1XmlOptions) {
      return (STLang)POIXMLTypeLoader.newInstance(STLang.type, param1XmlOptions);
    }
    
    public static STLang parse(String param1String) throws XmlException {
      return (STLang)POIXMLTypeLoader.parse(param1String, STLang.type, null);
    }
    
    public static STLang parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLang)POIXMLTypeLoader.parse(param1String, STLang.type, param1XmlOptions);
    }
    
    public static STLang parse(File param1File) throws XmlException, IOException {
      return (STLang)POIXMLTypeLoader.parse(param1File, STLang.type, null);
    }
    
    public static STLang parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLang)POIXMLTypeLoader.parse(param1File, STLang.type, param1XmlOptions);
    }
    
    public static STLang parse(URL param1URL) throws XmlException, IOException {
      return (STLang)POIXMLTypeLoader.parse(param1URL, STLang.type, null);
    }
    
    public static STLang parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLang)POIXMLTypeLoader.parse(param1URL, STLang.type, param1XmlOptions);
    }
    
    public static STLang parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLang)POIXMLTypeLoader.parse(param1InputStream, STLang.type, null);
    }
    
    public static STLang parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLang)POIXMLTypeLoader.parse(param1InputStream, STLang.type, param1XmlOptions);
    }
    
    public static STLang parse(Reader param1Reader) throws XmlException, IOException {
      return (STLang)POIXMLTypeLoader.parse(param1Reader, STLang.type, null);
    }
    
    public static STLang parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLang)POIXMLTypeLoader.parse(param1Reader, STLang.type, param1XmlOptions);
    }
    
    public static STLang parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLang)POIXMLTypeLoader.parse(param1XMLStreamReader, STLang.type, null);
    }
    
    public static STLang parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLang)POIXMLTypeLoader.parse(param1XMLStreamReader, STLang.type, param1XmlOptions);
    }
    
    public static STLang parse(Node param1Node) throws XmlException {
      return (STLang)POIXMLTypeLoader.parse(param1Node, STLang.type, null);
    }
    
    public static STLang parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLang)POIXMLTypeLoader.parse(param1Node, STLang.type, param1XmlOptions);
    }
    
    public static STLang parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLang)POIXMLTypeLoader.parse(param1XMLInputStream, STLang.type, null);
    }
    
    public static STLang parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLang)POIXMLTypeLoader.parse(param1XMLInputStream, STLang.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLang.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLang.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STLang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */