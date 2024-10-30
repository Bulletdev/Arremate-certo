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

public interface STGeomGuideName extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STGeomGuideName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stgeomguidename366ctype");
  
  public static final class Factory {
    public static STGeomGuideName newValue(Object param1Object) {
      return (STGeomGuideName)STGeomGuideName.type.newValue(param1Object);
    }
    
    public static STGeomGuideName newInstance() {
      return (STGeomGuideName)POIXMLTypeLoader.newInstance(STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName newInstance(XmlOptions param1XmlOptions) {
      return (STGeomGuideName)POIXMLTypeLoader.newInstance(STGeomGuideName.type, param1XmlOptions);
    }
    
    public static STGeomGuideName parse(String param1String) throws XmlException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1String, STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1String, STGeomGuideName.type, param1XmlOptions);
    }
    
    public static STGeomGuideName parse(File param1File) throws XmlException, IOException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1File, STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1File, STGeomGuideName.type, param1XmlOptions);
    }
    
    public static STGeomGuideName parse(URL param1URL) throws XmlException, IOException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1URL, STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1URL, STGeomGuideName.type, param1XmlOptions);
    }
    
    public static STGeomGuideName parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1InputStream, STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1InputStream, STGeomGuideName.type, param1XmlOptions);
    }
    
    public static STGeomGuideName parse(Reader param1Reader) throws XmlException, IOException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1Reader, STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1Reader, STGeomGuideName.type, param1XmlOptions);
    }
    
    public static STGeomGuideName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1XMLStreamReader, STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1XMLStreamReader, STGeomGuideName.type, param1XmlOptions);
    }
    
    public static STGeomGuideName parse(Node param1Node) throws XmlException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1Node, STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1Node, STGeomGuideName.type, param1XmlOptions);
    }
    
    public static STGeomGuideName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1XMLInputStream, STGeomGuideName.type, null);
    }
    
    public static STGeomGuideName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STGeomGuideName)POIXMLTypeLoader.parse(param1XMLInputStream, STGeomGuideName.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STGeomGuideName.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STGeomGuideName.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STGeomGuideName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */