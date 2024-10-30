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

public interface STPercentage extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpercentage0a85type");
  
  public static final class Factory {
    public static STPercentage newValue(Object param1Object) {
      return (STPercentage)STPercentage.type.newValue(param1Object);
    }
    
    public static STPercentage newInstance() {
      return (STPercentage)POIXMLTypeLoader.newInstance(STPercentage.type, null);
    }
    
    public static STPercentage newInstance(XmlOptions param1XmlOptions) {
      return (STPercentage)POIXMLTypeLoader.newInstance(STPercentage.type, param1XmlOptions);
    }
    
    public static STPercentage parse(String param1String) throws XmlException {
      return (STPercentage)POIXMLTypeLoader.parse(param1String, STPercentage.type, null);
    }
    
    public static STPercentage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPercentage)POIXMLTypeLoader.parse(param1String, STPercentage.type, param1XmlOptions);
    }
    
    public static STPercentage parse(File param1File) throws XmlException, IOException {
      return (STPercentage)POIXMLTypeLoader.parse(param1File, STPercentage.type, null);
    }
    
    public static STPercentage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPercentage)POIXMLTypeLoader.parse(param1File, STPercentage.type, param1XmlOptions);
    }
    
    public static STPercentage parse(URL param1URL) throws XmlException, IOException {
      return (STPercentage)POIXMLTypeLoader.parse(param1URL, STPercentage.type, null);
    }
    
    public static STPercentage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPercentage)POIXMLTypeLoader.parse(param1URL, STPercentage.type, param1XmlOptions);
    }
    
    public static STPercentage parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPercentage)POIXMLTypeLoader.parse(param1InputStream, STPercentage.type, null);
    }
    
    public static STPercentage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPercentage)POIXMLTypeLoader.parse(param1InputStream, STPercentage.type, param1XmlOptions);
    }
    
    public static STPercentage parse(Reader param1Reader) throws XmlException, IOException {
      return (STPercentage)POIXMLTypeLoader.parse(param1Reader, STPercentage.type, null);
    }
    
    public static STPercentage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPercentage)POIXMLTypeLoader.parse(param1Reader, STPercentage.type, param1XmlOptions);
    }
    
    public static STPercentage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, STPercentage.type, null);
    }
    
    public static STPercentage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, STPercentage.type, param1XmlOptions);
    }
    
    public static STPercentage parse(Node param1Node) throws XmlException {
      return (STPercentage)POIXMLTypeLoader.parse(param1Node, STPercentage.type, null);
    }
    
    public static STPercentage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPercentage)POIXMLTypeLoader.parse(param1Node, STPercentage.type, param1XmlOptions);
    }
    
    public static STPercentage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, STPercentage.type, null);
    }
    
    public static STPercentage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, STPercentage.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPercentage.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPercentage.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STPercentage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */