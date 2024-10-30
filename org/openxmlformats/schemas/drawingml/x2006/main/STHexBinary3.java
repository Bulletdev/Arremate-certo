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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STHexBinary3 extends XmlHexBinary {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHexBinary3.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthexbinary314e2type");
  
  public static final class Factory {
    public static STHexBinary3 newValue(Object param1Object) {
      return (STHexBinary3)STHexBinary3.type.newValue(param1Object);
    }
    
    public static STHexBinary3 newInstance() {
      return (STHexBinary3)POIXMLTypeLoader.newInstance(STHexBinary3.type, null);
    }
    
    public static STHexBinary3 newInstance(XmlOptions param1XmlOptions) {
      return (STHexBinary3)POIXMLTypeLoader.newInstance(STHexBinary3.type, param1XmlOptions);
    }
    
    public static STHexBinary3 parse(String param1String) throws XmlException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1String, STHexBinary3.type, null);
    }
    
    public static STHexBinary3 parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1String, STHexBinary3.type, param1XmlOptions);
    }
    
    public static STHexBinary3 parse(File param1File) throws XmlException, IOException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1File, STHexBinary3.type, null);
    }
    
    public static STHexBinary3 parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1File, STHexBinary3.type, param1XmlOptions);
    }
    
    public static STHexBinary3 parse(URL param1URL) throws XmlException, IOException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1URL, STHexBinary3.type, null);
    }
    
    public static STHexBinary3 parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1URL, STHexBinary3.type, param1XmlOptions);
    }
    
    public static STHexBinary3 parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1InputStream, STHexBinary3.type, null);
    }
    
    public static STHexBinary3 parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1InputStream, STHexBinary3.type, param1XmlOptions);
    }
    
    public static STHexBinary3 parse(Reader param1Reader) throws XmlException, IOException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1Reader, STHexBinary3.type, null);
    }
    
    public static STHexBinary3 parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1Reader, STHexBinary3.type, param1XmlOptions);
    }
    
    public static STHexBinary3 parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1XMLStreamReader, STHexBinary3.type, null);
    }
    
    public static STHexBinary3 parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1XMLStreamReader, STHexBinary3.type, param1XmlOptions);
    }
    
    public static STHexBinary3 parse(Node param1Node) throws XmlException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1Node, STHexBinary3.type, null);
    }
    
    public static STHexBinary3 parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1Node, STHexBinary3.type, param1XmlOptions);
    }
    
    public static STHexBinary3 parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1XMLInputStream, STHexBinary3.type, null);
    }
    
    public static STHexBinary3 parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHexBinary3)POIXMLTypeLoader.parse(param1XMLInputStream, STHexBinary3.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHexBinary3.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHexBinary3.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STHexBinary3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */