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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STGuid extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STGuid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stguidd0f4type");
  
  public static final class Factory {
    public static STGuid newValue(Object param1Object) {
      return (STGuid)STGuid.type.newValue(param1Object);
    }
    
    public static STGuid newInstance() {
      return (STGuid)POIXMLTypeLoader.newInstance(STGuid.type, null);
    }
    
    public static STGuid newInstance(XmlOptions param1XmlOptions) {
      return (STGuid)POIXMLTypeLoader.newInstance(STGuid.type, param1XmlOptions);
    }
    
    public static STGuid parse(String param1String) throws XmlException {
      return (STGuid)POIXMLTypeLoader.parse(param1String, STGuid.type, null);
    }
    
    public static STGuid parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STGuid)POIXMLTypeLoader.parse(param1String, STGuid.type, param1XmlOptions);
    }
    
    public static STGuid parse(File param1File) throws XmlException, IOException {
      return (STGuid)POIXMLTypeLoader.parse(param1File, STGuid.type, null);
    }
    
    public static STGuid parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGuid)POIXMLTypeLoader.parse(param1File, STGuid.type, param1XmlOptions);
    }
    
    public static STGuid parse(URL param1URL) throws XmlException, IOException {
      return (STGuid)POIXMLTypeLoader.parse(param1URL, STGuid.type, null);
    }
    
    public static STGuid parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGuid)POIXMLTypeLoader.parse(param1URL, STGuid.type, param1XmlOptions);
    }
    
    public static STGuid parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STGuid)POIXMLTypeLoader.parse(param1InputStream, STGuid.type, null);
    }
    
    public static STGuid parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGuid)POIXMLTypeLoader.parse(param1InputStream, STGuid.type, param1XmlOptions);
    }
    
    public static STGuid parse(Reader param1Reader) throws XmlException, IOException {
      return (STGuid)POIXMLTypeLoader.parse(param1Reader, STGuid.type, null);
    }
    
    public static STGuid parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGuid)POIXMLTypeLoader.parse(param1Reader, STGuid.type, param1XmlOptions);
    }
    
    public static STGuid parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STGuid)POIXMLTypeLoader.parse(param1XMLStreamReader, STGuid.type, null);
    }
    
    public static STGuid parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STGuid)POIXMLTypeLoader.parse(param1XMLStreamReader, STGuid.type, param1XmlOptions);
    }
    
    public static STGuid parse(Node param1Node) throws XmlException {
      return (STGuid)POIXMLTypeLoader.parse(param1Node, STGuid.type, null);
    }
    
    public static STGuid parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STGuid)POIXMLTypeLoader.parse(param1Node, STGuid.type, param1XmlOptions);
    }
    
    public static STGuid parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STGuid)POIXMLTypeLoader.parse(param1XMLInputStream, STGuid.type, null);
    }
    
    public static STGuid parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STGuid)POIXMLTypeLoader.parse(param1XMLInputStream, STGuid.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STGuid.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STGuid.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STGuid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */