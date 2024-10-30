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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STLogBase extends XmlDouble {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLogBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlogbase11a1type");
  
  public static final class Factory {
    public static STLogBase newValue(Object param1Object) {
      return (STLogBase)STLogBase.type.newValue(param1Object);
    }
    
    public static STLogBase newInstance() {
      return (STLogBase)POIXMLTypeLoader.newInstance(STLogBase.type, null);
    }
    
    public static STLogBase newInstance(XmlOptions param1XmlOptions) {
      return (STLogBase)POIXMLTypeLoader.newInstance(STLogBase.type, param1XmlOptions);
    }
    
    public static STLogBase parse(String param1String) throws XmlException {
      return (STLogBase)POIXMLTypeLoader.parse(param1String, STLogBase.type, null);
    }
    
    public static STLogBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLogBase)POIXMLTypeLoader.parse(param1String, STLogBase.type, param1XmlOptions);
    }
    
    public static STLogBase parse(File param1File) throws XmlException, IOException {
      return (STLogBase)POIXMLTypeLoader.parse(param1File, STLogBase.type, null);
    }
    
    public static STLogBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLogBase)POIXMLTypeLoader.parse(param1File, STLogBase.type, param1XmlOptions);
    }
    
    public static STLogBase parse(URL param1URL) throws XmlException, IOException {
      return (STLogBase)POIXMLTypeLoader.parse(param1URL, STLogBase.type, null);
    }
    
    public static STLogBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLogBase)POIXMLTypeLoader.parse(param1URL, STLogBase.type, param1XmlOptions);
    }
    
    public static STLogBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLogBase)POIXMLTypeLoader.parse(param1InputStream, STLogBase.type, null);
    }
    
    public static STLogBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLogBase)POIXMLTypeLoader.parse(param1InputStream, STLogBase.type, param1XmlOptions);
    }
    
    public static STLogBase parse(Reader param1Reader) throws XmlException, IOException {
      return (STLogBase)POIXMLTypeLoader.parse(param1Reader, STLogBase.type, null);
    }
    
    public static STLogBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLogBase)POIXMLTypeLoader.parse(param1Reader, STLogBase.type, param1XmlOptions);
    }
    
    public static STLogBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLogBase)POIXMLTypeLoader.parse(param1XMLStreamReader, STLogBase.type, null);
    }
    
    public static STLogBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLogBase)POIXMLTypeLoader.parse(param1XMLStreamReader, STLogBase.type, param1XmlOptions);
    }
    
    public static STLogBase parse(Node param1Node) throws XmlException {
      return (STLogBase)POIXMLTypeLoader.parse(param1Node, STLogBase.type, null);
    }
    
    public static STLogBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLogBase)POIXMLTypeLoader.parse(param1Node, STLogBase.type, param1XmlOptions);
    }
    
    public static STLogBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLogBase)POIXMLTypeLoader.parse(param1XMLInputStream, STLogBase.type, null);
    }
    
    public static STLogBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLogBase)POIXMLTypeLoader.parse(param1XMLInputStream, STLogBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLogBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLogBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STLogBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */