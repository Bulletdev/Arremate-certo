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

public interface STFixedPercentage extends STPercentage {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfixedpercentagef0cftype");
  
  public static final class Factory {
    public static STFixedPercentage newValue(Object param1Object) {
      return (STFixedPercentage)STFixedPercentage.type.newValue(param1Object);
    }
    
    public static STFixedPercentage newInstance() {
      return (STFixedPercentage)POIXMLTypeLoader.newInstance(STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage newInstance(XmlOptions param1XmlOptions) {
      return (STFixedPercentage)POIXMLTypeLoader.newInstance(STFixedPercentage.type, param1XmlOptions);
    }
    
    public static STFixedPercentage parse(String param1String) throws XmlException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1String, STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1String, STFixedPercentage.type, param1XmlOptions);
    }
    
    public static STFixedPercentage parse(File param1File) throws XmlException, IOException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1File, STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1File, STFixedPercentage.type, param1XmlOptions);
    }
    
    public static STFixedPercentage parse(URL param1URL) throws XmlException, IOException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1URL, STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1URL, STFixedPercentage.type, param1XmlOptions);
    }
    
    public static STFixedPercentage parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1InputStream, STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1InputStream, STFixedPercentage.type, param1XmlOptions);
    }
    
    public static STFixedPercentage parse(Reader param1Reader) throws XmlException, IOException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1Reader, STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1Reader, STFixedPercentage.type, param1XmlOptions);
    }
    
    public static STFixedPercentage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, STFixedPercentage.type, param1XmlOptions);
    }
    
    public static STFixedPercentage parse(Node param1Node) throws XmlException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1Node, STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1Node, STFixedPercentage.type, param1XmlOptions);
    }
    
    public static STFixedPercentage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, STFixedPercentage.type, null);
    }
    
    public static STFixedPercentage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STFixedPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, STFixedPercentage.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFixedPercentage.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFixedPercentage.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STFixedPercentage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */