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

public interface STTextSpacingPoint extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextSpacingPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextspacingpointdd05type");
  
  public static final class Factory {
    public static STTextSpacingPoint newValue(Object param1Object) {
      return (STTextSpacingPoint)STTextSpacingPoint.type.newValue(param1Object);
    }
    
    public static STTextSpacingPoint newInstance() {
      return (STTextSpacingPoint)POIXMLTypeLoader.newInstance(STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint newInstance(XmlOptions param1XmlOptions) {
      return (STTextSpacingPoint)POIXMLTypeLoader.newInstance(STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static STTextSpacingPoint parse(String param1String) throws XmlException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1String, STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1String, STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static STTextSpacingPoint parse(File param1File) throws XmlException, IOException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1File, STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1File, STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static STTextSpacingPoint parse(URL param1URL) throws XmlException, IOException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1URL, STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1URL, STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static STTextSpacingPoint parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1InputStream, STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1InputStream, STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static STTextSpacingPoint parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1Reader, STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1Reader, STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static STTextSpacingPoint parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static STTextSpacingPoint parse(Node param1Node) throws XmlException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1Node, STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1Node, STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static STTextSpacingPoint parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1XMLInputStream, STTextSpacingPoint.type, null);
    }
    
    public static STTextSpacingPoint parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextSpacingPoint)POIXMLTypeLoader.parse(param1XMLInputStream, STTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextSpacingPoint.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextSpacingPoint.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextSpacingPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */