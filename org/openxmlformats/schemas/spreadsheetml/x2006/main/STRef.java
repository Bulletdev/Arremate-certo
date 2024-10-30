package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface STRef extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stref90a2type");
  
  public static final class Factory {
    public static STRef newValue(Object param1Object) {
      return (STRef)STRef.type.newValue(param1Object);
    }
    
    public static STRef newInstance() {
      return (STRef)POIXMLTypeLoader.newInstance(STRef.type, null);
    }
    
    public static STRef newInstance(XmlOptions param1XmlOptions) {
      return (STRef)POIXMLTypeLoader.newInstance(STRef.type, param1XmlOptions);
    }
    
    public static STRef parse(String param1String) throws XmlException {
      return (STRef)POIXMLTypeLoader.parse(param1String, STRef.type, null);
    }
    
    public static STRef parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STRef)POIXMLTypeLoader.parse(param1String, STRef.type, param1XmlOptions);
    }
    
    public static STRef parse(File param1File) throws XmlException, IOException {
      return (STRef)POIXMLTypeLoader.parse(param1File, STRef.type, null);
    }
    
    public static STRef parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRef)POIXMLTypeLoader.parse(param1File, STRef.type, param1XmlOptions);
    }
    
    public static STRef parse(URL param1URL) throws XmlException, IOException {
      return (STRef)POIXMLTypeLoader.parse(param1URL, STRef.type, null);
    }
    
    public static STRef parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRef)POIXMLTypeLoader.parse(param1URL, STRef.type, param1XmlOptions);
    }
    
    public static STRef parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STRef)POIXMLTypeLoader.parse(param1InputStream, STRef.type, null);
    }
    
    public static STRef parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRef)POIXMLTypeLoader.parse(param1InputStream, STRef.type, param1XmlOptions);
    }
    
    public static STRef parse(Reader param1Reader) throws XmlException, IOException {
      return (STRef)POIXMLTypeLoader.parse(param1Reader, STRef.type, null);
    }
    
    public static STRef parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRef)POIXMLTypeLoader.parse(param1Reader, STRef.type, param1XmlOptions);
    }
    
    public static STRef parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STRef)POIXMLTypeLoader.parse(param1XMLStreamReader, STRef.type, null);
    }
    
    public static STRef parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STRef)POIXMLTypeLoader.parse(param1XMLStreamReader, STRef.type, param1XmlOptions);
    }
    
    public static STRef parse(Node param1Node) throws XmlException {
      return (STRef)POIXMLTypeLoader.parse(param1Node, STRef.type, null);
    }
    
    public static STRef parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STRef)POIXMLTypeLoader.parse(param1Node, STRef.type, param1XmlOptions);
    }
    
    public static STRef parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STRef)POIXMLTypeLoader.parse(param1XMLInputStream, STRef.type, null);
    }
    
    public static STRef parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STRef)POIXMLTypeLoader.parse(param1XMLInputStream, STRef.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STRef.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STRef.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */