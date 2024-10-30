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

public interface STPositivePercentage extends STPercentage {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPositivePercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpositivepercentagedb9etype");
  
  public static final class Factory {
    public static STPositivePercentage newValue(Object param1Object) {
      return (STPositivePercentage)STPositivePercentage.type.newValue(param1Object);
    }
    
    public static STPositivePercentage newInstance() {
      return (STPositivePercentage)POIXMLTypeLoader.newInstance(STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage newInstance(XmlOptions param1XmlOptions) {
      return (STPositivePercentage)POIXMLTypeLoader.newInstance(STPositivePercentage.type, param1XmlOptions);
    }
    
    public static STPositivePercentage parse(String param1String) throws XmlException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1String, STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1String, STPositivePercentage.type, param1XmlOptions);
    }
    
    public static STPositivePercentage parse(File param1File) throws XmlException, IOException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1File, STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1File, STPositivePercentage.type, param1XmlOptions);
    }
    
    public static STPositivePercentage parse(URL param1URL) throws XmlException, IOException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1URL, STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1URL, STPositivePercentage.type, param1XmlOptions);
    }
    
    public static STPositivePercentage parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1InputStream, STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1InputStream, STPositivePercentage.type, param1XmlOptions);
    }
    
    public static STPositivePercentage parse(Reader param1Reader) throws XmlException, IOException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1Reader, STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1Reader, STPositivePercentage.type, param1XmlOptions);
    }
    
    public static STPositivePercentage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, STPositivePercentage.type, param1XmlOptions);
    }
    
    public static STPositivePercentage parse(Node param1Node) throws XmlException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1Node, STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1Node, STPositivePercentage.type, param1XmlOptions);
    }
    
    public static STPositivePercentage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1XMLInputStream, STPositivePercentage.type, null);
    }
    
    public static STPositivePercentage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPositivePercentage)POIXMLTypeLoader.parse(param1XMLInputStream, STPositivePercentage.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPositivePercentage.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPositivePercentage.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STPositivePercentage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */