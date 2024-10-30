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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STString extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STString.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ststringa627type");
  
  public static final class Factory {
    public static STString newValue(Object param1Object) {
      return (STString)STString.type.newValue(param1Object);
    }
    
    public static STString newInstance() {
      return (STString)POIXMLTypeLoader.newInstance(STString.type, null);
    }
    
    public static STString newInstance(XmlOptions param1XmlOptions) {
      return (STString)POIXMLTypeLoader.newInstance(STString.type, param1XmlOptions);
    }
    
    public static STString parse(String param1String) throws XmlException {
      return (STString)POIXMLTypeLoader.parse(param1String, STString.type, null);
    }
    
    public static STString parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STString)POIXMLTypeLoader.parse(param1String, STString.type, param1XmlOptions);
    }
    
    public static STString parse(File param1File) throws XmlException, IOException {
      return (STString)POIXMLTypeLoader.parse(param1File, STString.type, null);
    }
    
    public static STString parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STString)POIXMLTypeLoader.parse(param1File, STString.type, param1XmlOptions);
    }
    
    public static STString parse(URL param1URL) throws XmlException, IOException {
      return (STString)POIXMLTypeLoader.parse(param1URL, STString.type, null);
    }
    
    public static STString parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STString)POIXMLTypeLoader.parse(param1URL, STString.type, param1XmlOptions);
    }
    
    public static STString parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STString)POIXMLTypeLoader.parse(param1InputStream, STString.type, null);
    }
    
    public static STString parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STString)POIXMLTypeLoader.parse(param1InputStream, STString.type, param1XmlOptions);
    }
    
    public static STString parse(Reader param1Reader) throws XmlException, IOException {
      return (STString)POIXMLTypeLoader.parse(param1Reader, STString.type, null);
    }
    
    public static STString parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STString)POIXMLTypeLoader.parse(param1Reader, STString.type, param1XmlOptions);
    }
    
    public static STString parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STString)POIXMLTypeLoader.parse(param1XMLStreamReader, STString.type, null);
    }
    
    public static STString parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STString)POIXMLTypeLoader.parse(param1XMLStreamReader, STString.type, param1XmlOptions);
    }
    
    public static STString parse(Node param1Node) throws XmlException {
      return (STString)POIXMLTypeLoader.parse(param1Node, STString.type, null);
    }
    
    public static STString parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STString)POIXMLTypeLoader.parse(param1Node, STString.type, param1XmlOptions);
    }
    
    public static STString parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STString)POIXMLTypeLoader.parse(param1XMLInputStream, STString.type, null);
    }
    
    public static STString parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STString)POIXMLTypeLoader.parse(param1XMLInputStream, STString.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STString.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STString.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */