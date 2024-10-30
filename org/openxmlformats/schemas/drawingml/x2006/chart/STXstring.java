package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface STXstring extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STXstring.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stxstringb8cdtype");
  
  public static final class Factory {
    public static STXstring newValue(Object param1Object) {
      return (STXstring)STXstring.type.newValue(param1Object);
    }
    
    public static STXstring newInstance() {
      return (STXstring)POIXMLTypeLoader.newInstance(STXstring.type, null);
    }
    
    public static STXstring newInstance(XmlOptions param1XmlOptions) {
      return (STXstring)POIXMLTypeLoader.newInstance(STXstring.type, param1XmlOptions);
    }
    
    public static STXstring parse(String param1String) throws XmlException {
      return (STXstring)POIXMLTypeLoader.parse(param1String, STXstring.type, null);
    }
    
    public static STXstring parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STXstring)POIXMLTypeLoader.parse(param1String, STXstring.type, param1XmlOptions);
    }
    
    public static STXstring parse(File param1File) throws XmlException, IOException {
      return (STXstring)POIXMLTypeLoader.parse(param1File, STXstring.type, null);
    }
    
    public static STXstring parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STXstring)POIXMLTypeLoader.parse(param1File, STXstring.type, param1XmlOptions);
    }
    
    public static STXstring parse(URL param1URL) throws XmlException, IOException {
      return (STXstring)POIXMLTypeLoader.parse(param1URL, STXstring.type, null);
    }
    
    public static STXstring parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STXstring)POIXMLTypeLoader.parse(param1URL, STXstring.type, param1XmlOptions);
    }
    
    public static STXstring parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STXstring)POIXMLTypeLoader.parse(param1InputStream, STXstring.type, null);
    }
    
    public static STXstring parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STXstring)POIXMLTypeLoader.parse(param1InputStream, STXstring.type, param1XmlOptions);
    }
    
    public static STXstring parse(Reader param1Reader) throws XmlException, IOException {
      return (STXstring)POIXMLTypeLoader.parse(param1Reader, STXstring.type, null);
    }
    
    public static STXstring parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STXstring)POIXMLTypeLoader.parse(param1Reader, STXstring.type, param1XmlOptions);
    }
    
    public static STXstring parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STXstring)POIXMLTypeLoader.parse(param1XMLStreamReader, STXstring.type, null);
    }
    
    public static STXstring parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STXstring)POIXMLTypeLoader.parse(param1XMLStreamReader, STXstring.type, param1XmlOptions);
    }
    
    public static STXstring parse(Node param1Node) throws XmlException {
      return (STXstring)POIXMLTypeLoader.parse(param1Node, STXstring.type, null);
    }
    
    public static STXstring parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STXstring)POIXMLTypeLoader.parse(param1Node, STXstring.type, param1XmlOptions);
    }
    
    public static STXstring parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STXstring)POIXMLTypeLoader.parse(param1XMLInputStream, STXstring.type, null);
    }
    
    public static STXstring parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STXstring)POIXMLTypeLoader.parse(param1XMLInputStream, STXstring.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STXstring.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STXstring.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STXstring.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */