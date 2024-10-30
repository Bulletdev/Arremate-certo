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

public interface STTextPoint extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextpoint4284type");
  
  public static final class Factory {
    public static STTextPoint newValue(Object param1Object) {
      return (STTextPoint)STTextPoint.type.newValue(param1Object);
    }
    
    public static STTextPoint newInstance() {
      return (STTextPoint)POIXMLTypeLoader.newInstance(STTextPoint.type, null);
    }
    
    public static STTextPoint newInstance(XmlOptions param1XmlOptions) {
      return (STTextPoint)POIXMLTypeLoader.newInstance(STTextPoint.type, param1XmlOptions);
    }
    
    public static STTextPoint parse(String param1String) throws XmlException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1String, STTextPoint.type, null);
    }
    
    public static STTextPoint parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1String, STTextPoint.type, param1XmlOptions);
    }
    
    public static STTextPoint parse(File param1File) throws XmlException, IOException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1File, STTextPoint.type, null);
    }
    
    public static STTextPoint parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1File, STTextPoint.type, param1XmlOptions);
    }
    
    public static STTextPoint parse(URL param1URL) throws XmlException, IOException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1URL, STTextPoint.type, null);
    }
    
    public static STTextPoint parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1URL, STTextPoint.type, param1XmlOptions);
    }
    
    public static STTextPoint parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1InputStream, STTextPoint.type, null);
    }
    
    public static STTextPoint parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1InputStream, STTextPoint.type, param1XmlOptions);
    }
    
    public static STTextPoint parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1Reader, STTextPoint.type, null);
    }
    
    public static STTextPoint parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1Reader, STTextPoint.type, param1XmlOptions);
    }
    
    public static STTextPoint parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextPoint.type, null);
    }
    
    public static STTextPoint parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextPoint.type, param1XmlOptions);
    }
    
    public static STTextPoint parse(Node param1Node) throws XmlException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1Node, STTextPoint.type, null);
    }
    
    public static STTextPoint parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1Node, STTextPoint.type, param1XmlOptions);
    }
    
    public static STTextPoint parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1XMLInputStream, STTextPoint.type, null);
    }
    
    public static STTextPoint parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextPoint)POIXMLTypeLoader.parse(param1XMLInputStream, STTextPoint.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextPoint.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextPoint.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */