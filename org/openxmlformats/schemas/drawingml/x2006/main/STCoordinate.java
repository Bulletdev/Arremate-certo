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
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STCoordinate extends XmlLong {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcoordinatefae3type");
  
  public static final class Factory {
    public static STCoordinate newValue(Object param1Object) {
      return (STCoordinate)STCoordinate.type.newValue(param1Object);
    }
    
    public static STCoordinate newInstance() {
      return (STCoordinate)POIXMLTypeLoader.newInstance(STCoordinate.type, null);
    }
    
    public static STCoordinate newInstance(XmlOptions param1XmlOptions) {
      return (STCoordinate)POIXMLTypeLoader.newInstance(STCoordinate.type, param1XmlOptions);
    }
    
    public static STCoordinate parse(String param1String) throws XmlException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1String, STCoordinate.type, null);
    }
    
    public static STCoordinate parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1String, STCoordinate.type, param1XmlOptions);
    }
    
    public static STCoordinate parse(File param1File) throws XmlException, IOException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1File, STCoordinate.type, null);
    }
    
    public static STCoordinate parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1File, STCoordinate.type, param1XmlOptions);
    }
    
    public static STCoordinate parse(URL param1URL) throws XmlException, IOException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1URL, STCoordinate.type, null);
    }
    
    public static STCoordinate parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1URL, STCoordinate.type, param1XmlOptions);
    }
    
    public static STCoordinate parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1InputStream, STCoordinate.type, null);
    }
    
    public static STCoordinate parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1InputStream, STCoordinate.type, param1XmlOptions);
    }
    
    public static STCoordinate parse(Reader param1Reader) throws XmlException, IOException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1Reader, STCoordinate.type, null);
    }
    
    public static STCoordinate parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1Reader, STCoordinate.type, param1XmlOptions);
    }
    
    public static STCoordinate parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1XMLStreamReader, STCoordinate.type, null);
    }
    
    public static STCoordinate parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1XMLStreamReader, STCoordinate.type, param1XmlOptions);
    }
    
    public static STCoordinate parse(Node param1Node) throws XmlException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1Node, STCoordinate.type, null);
    }
    
    public static STCoordinate parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1Node, STCoordinate.type, param1XmlOptions);
    }
    
    public static STCoordinate parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1XMLInputStream, STCoordinate.type, null);
    }
    
    public static STCoordinate parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCoordinate)POIXMLTypeLoader.parse(param1XMLInputStream, STCoordinate.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCoordinate.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCoordinate.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STCoordinate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */