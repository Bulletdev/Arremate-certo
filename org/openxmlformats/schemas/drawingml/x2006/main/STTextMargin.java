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

public interface STTextMargin extends STCoordinate32 {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextMargin.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextmargin9666type");
  
  public static final class Factory {
    public static STTextMargin newValue(Object param1Object) {
      return (STTextMargin)STTextMargin.type.newValue(param1Object);
    }
    
    public static STTextMargin newInstance() {
      return (STTextMargin)POIXMLTypeLoader.newInstance(STTextMargin.type, null);
    }
    
    public static STTextMargin newInstance(XmlOptions param1XmlOptions) {
      return (STTextMargin)POIXMLTypeLoader.newInstance(STTextMargin.type, param1XmlOptions);
    }
    
    public static STTextMargin parse(String param1String) throws XmlException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1String, STTextMargin.type, null);
    }
    
    public static STTextMargin parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1String, STTextMargin.type, param1XmlOptions);
    }
    
    public static STTextMargin parse(File param1File) throws XmlException, IOException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1File, STTextMargin.type, null);
    }
    
    public static STTextMargin parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1File, STTextMargin.type, param1XmlOptions);
    }
    
    public static STTextMargin parse(URL param1URL) throws XmlException, IOException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1URL, STTextMargin.type, null);
    }
    
    public static STTextMargin parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1URL, STTextMargin.type, param1XmlOptions);
    }
    
    public static STTextMargin parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1InputStream, STTextMargin.type, null);
    }
    
    public static STTextMargin parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1InputStream, STTextMargin.type, param1XmlOptions);
    }
    
    public static STTextMargin parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1Reader, STTextMargin.type, null);
    }
    
    public static STTextMargin parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1Reader, STTextMargin.type, param1XmlOptions);
    }
    
    public static STTextMargin parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextMargin.type, null);
    }
    
    public static STTextMargin parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextMargin.type, param1XmlOptions);
    }
    
    public static STTextMargin parse(Node param1Node) throws XmlException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1Node, STTextMargin.type, null);
    }
    
    public static STTextMargin parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1Node, STTextMargin.type, param1XmlOptions);
    }
    
    public static STTextMargin parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1XMLInputStream, STTextMargin.type, null);
    }
    
    public static STTextMargin parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextMargin)POIXMLTypeLoader.parse(param1XMLInputStream, STTextMargin.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextMargin.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextMargin.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextMargin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */