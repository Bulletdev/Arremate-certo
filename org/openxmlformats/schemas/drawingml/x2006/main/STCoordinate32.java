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

public interface STCoordinate32 extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCoordinate32.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcoordinate322cc2type");
  
  public static final class Factory {
    public static STCoordinate32 newValue(Object param1Object) {
      return (STCoordinate32)STCoordinate32.type.newValue(param1Object);
    }
    
    public static STCoordinate32 newInstance() {
      return (STCoordinate32)POIXMLTypeLoader.newInstance(STCoordinate32.type, null);
    }
    
    public static STCoordinate32 newInstance(XmlOptions param1XmlOptions) {
      return (STCoordinate32)POIXMLTypeLoader.newInstance(STCoordinate32.type, param1XmlOptions);
    }
    
    public static STCoordinate32 parse(String param1String) throws XmlException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1String, STCoordinate32.type, null);
    }
    
    public static STCoordinate32 parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1String, STCoordinate32.type, param1XmlOptions);
    }
    
    public static STCoordinate32 parse(File param1File) throws XmlException, IOException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1File, STCoordinate32.type, null);
    }
    
    public static STCoordinate32 parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1File, STCoordinate32.type, param1XmlOptions);
    }
    
    public static STCoordinate32 parse(URL param1URL) throws XmlException, IOException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1URL, STCoordinate32.type, null);
    }
    
    public static STCoordinate32 parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1URL, STCoordinate32.type, param1XmlOptions);
    }
    
    public static STCoordinate32 parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1InputStream, STCoordinate32.type, null);
    }
    
    public static STCoordinate32 parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1InputStream, STCoordinate32.type, param1XmlOptions);
    }
    
    public static STCoordinate32 parse(Reader param1Reader) throws XmlException, IOException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1Reader, STCoordinate32.type, null);
    }
    
    public static STCoordinate32 parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1Reader, STCoordinate32.type, param1XmlOptions);
    }
    
    public static STCoordinate32 parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1XMLStreamReader, STCoordinate32.type, null);
    }
    
    public static STCoordinate32 parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1XMLStreamReader, STCoordinate32.type, param1XmlOptions);
    }
    
    public static STCoordinate32 parse(Node param1Node) throws XmlException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1Node, STCoordinate32.type, null);
    }
    
    public static STCoordinate32 parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1Node, STCoordinate32.type, param1XmlOptions);
    }
    
    public static STCoordinate32 parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1XMLInputStream, STCoordinate32.type, null);
    }
    
    public static STCoordinate32 parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCoordinate32)POIXMLTypeLoader.parse(param1XMLInputStream, STCoordinate32.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCoordinate32.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCoordinate32.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STCoordinate32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */