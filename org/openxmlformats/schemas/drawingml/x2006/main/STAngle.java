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

public interface STAngle extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STAngle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stangle8074type");
  
  public static final class Factory {
    public static STAngle newValue(Object param1Object) {
      return (STAngle)STAngle.type.newValue(param1Object);
    }
    
    public static STAngle newInstance() {
      return (STAngle)POIXMLTypeLoader.newInstance(STAngle.type, null);
    }
    
    public static STAngle newInstance(XmlOptions param1XmlOptions) {
      return (STAngle)POIXMLTypeLoader.newInstance(STAngle.type, param1XmlOptions);
    }
    
    public static STAngle parse(String param1String) throws XmlException {
      return (STAngle)POIXMLTypeLoader.parse(param1String, STAngle.type, null);
    }
    
    public static STAngle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STAngle)POIXMLTypeLoader.parse(param1String, STAngle.type, param1XmlOptions);
    }
    
    public static STAngle parse(File param1File) throws XmlException, IOException {
      return (STAngle)POIXMLTypeLoader.parse(param1File, STAngle.type, null);
    }
    
    public static STAngle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAngle)POIXMLTypeLoader.parse(param1File, STAngle.type, param1XmlOptions);
    }
    
    public static STAngle parse(URL param1URL) throws XmlException, IOException {
      return (STAngle)POIXMLTypeLoader.parse(param1URL, STAngle.type, null);
    }
    
    public static STAngle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAngle)POIXMLTypeLoader.parse(param1URL, STAngle.type, param1XmlOptions);
    }
    
    public static STAngle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STAngle)POIXMLTypeLoader.parse(param1InputStream, STAngle.type, null);
    }
    
    public static STAngle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAngle)POIXMLTypeLoader.parse(param1InputStream, STAngle.type, param1XmlOptions);
    }
    
    public static STAngle parse(Reader param1Reader) throws XmlException, IOException {
      return (STAngle)POIXMLTypeLoader.parse(param1Reader, STAngle.type, null);
    }
    
    public static STAngle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAngle)POIXMLTypeLoader.parse(param1Reader, STAngle.type, param1XmlOptions);
    }
    
    public static STAngle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STAngle)POIXMLTypeLoader.parse(param1XMLStreamReader, STAngle.type, null);
    }
    
    public static STAngle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STAngle)POIXMLTypeLoader.parse(param1XMLStreamReader, STAngle.type, param1XmlOptions);
    }
    
    public static STAngle parse(Node param1Node) throws XmlException {
      return (STAngle)POIXMLTypeLoader.parse(param1Node, STAngle.type, null);
    }
    
    public static STAngle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STAngle)POIXMLTypeLoader.parse(param1Node, STAngle.type, param1XmlOptions);
    }
    
    public static STAngle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STAngle)POIXMLTypeLoader.parse(param1XMLInputStream, STAngle.type, null);
    }
    
    public static STAngle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STAngle)POIXMLTypeLoader.parse(param1XMLInputStream, STAngle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAngle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAngle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STAngle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */