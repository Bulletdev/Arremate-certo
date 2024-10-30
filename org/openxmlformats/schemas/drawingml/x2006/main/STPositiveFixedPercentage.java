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

public interface STPositiveFixedPercentage extends STPercentage {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPositiveFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpositivefixedpercentagee756type");
  
  public static final class Factory {
    public static STPositiveFixedPercentage newValue(Object param1Object) {
      return (STPositiveFixedPercentage)STPositiveFixedPercentage.type.newValue(param1Object);
    }
    
    public static STPositiveFixedPercentage newInstance() {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.newInstance(STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage newInstance(XmlOptions param1XmlOptions) {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.newInstance(STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static STPositiveFixedPercentage parse(String param1String) throws XmlException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1String, STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1String, STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static STPositiveFixedPercentage parse(File param1File) throws XmlException, IOException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1File, STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1File, STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static STPositiveFixedPercentage parse(URL param1URL) throws XmlException, IOException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1URL, STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1URL, STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static STPositiveFixedPercentage parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1InputStream, STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1InputStream, STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static STPositiveFixedPercentage parse(Reader param1Reader) throws XmlException, IOException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1Reader, STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1Reader, STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static STPositiveFixedPercentage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static STPositiveFixedPercentage parse(Node param1Node) throws XmlException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1Node, STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1Node, STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static STPositiveFixedPercentage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, STPositiveFixedPercentage.type, null);
    }
    
    public static STPositiveFixedPercentage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPositiveFixedPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, STPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPositiveFixedPercentage.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPositiveFixedPercentage.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STPositiveFixedPercentage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */