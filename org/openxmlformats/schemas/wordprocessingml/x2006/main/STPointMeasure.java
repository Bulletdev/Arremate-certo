package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface STPointMeasure extends STUnsignedDecimalNumber {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPointMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpointmeasurea96atype");
  
  public static final class Factory {
    public static STPointMeasure newValue(Object param1Object) {
      return (STPointMeasure)STPointMeasure.type.newValue(param1Object);
    }
    
    public static STPointMeasure newInstance() {
      return (STPointMeasure)POIXMLTypeLoader.newInstance(STPointMeasure.type, null);
    }
    
    public static STPointMeasure newInstance(XmlOptions param1XmlOptions) {
      return (STPointMeasure)POIXMLTypeLoader.newInstance(STPointMeasure.type, param1XmlOptions);
    }
    
    public static STPointMeasure parse(String param1String) throws XmlException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1String, STPointMeasure.type, null);
    }
    
    public static STPointMeasure parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1String, STPointMeasure.type, param1XmlOptions);
    }
    
    public static STPointMeasure parse(File param1File) throws XmlException, IOException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1File, STPointMeasure.type, null);
    }
    
    public static STPointMeasure parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1File, STPointMeasure.type, param1XmlOptions);
    }
    
    public static STPointMeasure parse(URL param1URL) throws XmlException, IOException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1URL, STPointMeasure.type, null);
    }
    
    public static STPointMeasure parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1URL, STPointMeasure.type, param1XmlOptions);
    }
    
    public static STPointMeasure parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1InputStream, STPointMeasure.type, null);
    }
    
    public static STPointMeasure parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1InputStream, STPointMeasure.type, param1XmlOptions);
    }
    
    public static STPointMeasure parse(Reader param1Reader) throws XmlException, IOException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1Reader, STPointMeasure.type, null);
    }
    
    public static STPointMeasure parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1Reader, STPointMeasure.type, param1XmlOptions);
    }
    
    public static STPointMeasure parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STPointMeasure.type, null);
    }
    
    public static STPointMeasure parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STPointMeasure.type, param1XmlOptions);
    }
    
    public static STPointMeasure parse(Node param1Node) throws XmlException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1Node, STPointMeasure.type, null);
    }
    
    public static STPointMeasure parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1Node, STPointMeasure.type, param1XmlOptions);
    }
    
    public static STPointMeasure parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STPointMeasure.type, null);
    }
    
    public static STPointMeasure parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPointMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STPointMeasure.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPointMeasure.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPointMeasure.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STPointMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */