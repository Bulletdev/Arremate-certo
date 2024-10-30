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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STPositiveCoordinate32 extends STCoordinate32 {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPositiveCoordinate32.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpositivecoordinate321b9btype");
  
  public static final class Factory {
    public static STPositiveCoordinate32 newValue(Object param1Object) {
      return (STPositiveCoordinate32)STPositiveCoordinate32.type.newValue(param1Object);
    }
    
    public static STPositiveCoordinate32 newInstance() {
      return (STPositiveCoordinate32)POIXMLTypeLoader.newInstance(STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 newInstance(XmlOptions param1XmlOptions) {
      return (STPositiveCoordinate32)POIXMLTypeLoader.newInstance(STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static STPositiveCoordinate32 parse(String param1String) throws XmlException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1String, STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1String, STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static STPositiveCoordinate32 parse(File param1File) throws XmlException, IOException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1File, STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1File, STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static STPositiveCoordinate32 parse(URL param1URL) throws XmlException, IOException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1URL, STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1URL, STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static STPositiveCoordinate32 parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1InputStream, STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1InputStream, STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static STPositiveCoordinate32 parse(Reader param1Reader) throws XmlException, IOException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1Reader, STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1Reader, STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static STPositiveCoordinate32 parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1XMLStreamReader, STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1XMLStreamReader, STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static STPositiveCoordinate32 parse(Node param1Node) throws XmlException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1Node, STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1Node, STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static STPositiveCoordinate32 parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1XMLInputStream, STPositiveCoordinate32.type, null);
    }
    
    public static STPositiveCoordinate32 parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPositiveCoordinate32)POIXMLTypeLoader.parse(param1XMLInputStream, STPositiveCoordinate32.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPositiveCoordinate32.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPositiveCoordinate32.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STPositiveCoordinate32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */