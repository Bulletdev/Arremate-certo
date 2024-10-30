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

public interface STTwipsMeasure extends STUnsignedDecimalNumber {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTwipsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttwipsmeasure1e23type");
  
  public static final class Factory {
    public static STTwipsMeasure newValue(Object param1Object) {
      return (STTwipsMeasure)STTwipsMeasure.type.newValue(param1Object);
    }
    
    public static STTwipsMeasure newInstance() {
      return (STTwipsMeasure)POIXMLTypeLoader.newInstance(STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure newInstance(XmlOptions param1XmlOptions) {
      return (STTwipsMeasure)POIXMLTypeLoader.newInstance(STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STTwipsMeasure parse(String param1String) throws XmlException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1String, STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1String, STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STTwipsMeasure parse(File param1File) throws XmlException, IOException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1File, STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1File, STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STTwipsMeasure parse(URL param1URL) throws XmlException, IOException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1URL, STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1URL, STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STTwipsMeasure parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1InputStream, STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1InputStream, STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STTwipsMeasure parse(Reader param1Reader) throws XmlException, IOException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1Reader, STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1Reader, STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STTwipsMeasure parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STTwipsMeasure parse(Node param1Node) throws XmlException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1Node, STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1Node, STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STTwipsMeasure parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STTwipsMeasure.type, null);
    }
    
    public static STTwipsMeasure parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTwipsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STTwipsMeasure.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTwipsMeasure.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTwipsMeasure.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STTwipsMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */