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
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STSignedTwipsMeasure extends XmlInteger {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSignedTwipsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsignedtwipsmeasureb227type");
  
  public static final class Factory {
    public static STSignedTwipsMeasure newValue(Object param1Object) {
      return (STSignedTwipsMeasure)STSignedTwipsMeasure.type.newValue(param1Object);
    }
    
    public static STSignedTwipsMeasure newInstance() {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.newInstance(STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure newInstance(XmlOptions param1XmlOptions) {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.newInstance(STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedTwipsMeasure parse(String param1String) throws XmlException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1String, STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1String, STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedTwipsMeasure parse(File param1File) throws XmlException, IOException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1File, STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1File, STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedTwipsMeasure parse(URL param1URL) throws XmlException, IOException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1URL, STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1URL, STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedTwipsMeasure parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1InputStream, STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1InputStream, STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedTwipsMeasure parse(Reader param1Reader) throws XmlException, IOException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1Reader, STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1Reader, STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedTwipsMeasure parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedTwipsMeasure parse(Node param1Node) throws XmlException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1Node, STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1Node, STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedTwipsMeasure parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STSignedTwipsMeasure.type, null);
    }
    
    public static STSignedTwipsMeasure parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSignedTwipsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STSignedTwipsMeasure.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSignedTwipsMeasure.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSignedTwipsMeasure.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STSignedTwipsMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */