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

public interface STHpsMeasure extends STUnsignedDecimalNumber {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthpsmeasurec985type");
  
  public static final class Factory {
    public static STHpsMeasure newValue(Object param1Object) {
      return (STHpsMeasure)STHpsMeasure.type.newValue(param1Object);
    }
    
    public static STHpsMeasure newInstance() {
      return (STHpsMeasure)POIXMLTypeLoader.newInstance(STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure newInstance(XmlOptions param1XmlOptions) {
      return (STHpsMeasure)POIXMLTypeLoader.newInstance(STHpsMeasure.type, param1XmlOptions);
    }
    
    public static STHpsMeasure parse(String param1String) throws XmlException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1String, STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1String, STHpsMeasure.type, param1XmlOptions);
    }
    
    public static STHpsMeasure parse(File param1File) throws XmlException, IOException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1File, STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1File, STHpsMeasure.type, param1XmlOptions);
    }
    
    public static STHpsMeasure parse(URL param1URL) throws XmlException, IOException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1URL, STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1URL, STHpsMeasure.type, param1XmlOptions);
    }
    
    public static STHpsMeasure parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1InputStream, STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1InputStream, STHpsMeasure.type, param1XmlOptions);
    }
    
    public static STHpsMeasure parse(Reader param1Reader) throws XmlException, IOException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1Reader, STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1Reader, STHpsMeasure.type, param1XmlOptions);
    }
    
    public static STHpsMeasure parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STHpsMeasure.type, param1XmlOptions);
    }
    
    public static STHpsMeasure parse(Node param1Node) throws XmlException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1Node, STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1Node, STHpsMeasure.type, param1XmlOptions);
    }
    
    public static STHpsMeasure parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STHpsMeasure.type, null);
    }
    
    public static STHpsMeasure parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHpsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STHpsMeasure.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHpsMeasure.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHpsMeasure.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STHpsMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */