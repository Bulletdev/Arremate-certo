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

public interface STEighthPointMeasure extends STUnsignedDecimalNumber {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STEighthPointMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("steighthpointmeasure3371type");
  
  public static final class Factory {
    public static STEighthPointMeasure newValue(Object param1Object) {
      return (STEighthPointMeasure)STEighthPointMeasure.type.newValue(param1Object);
    }
    
    public static STEighthPointMeasure newInstance() {
      return (STEighthPointMeasure)POIXMLTypeLoader.newInstance(STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure newInstance(XmlOptions param1XmlOptions) {
      return (STEighthPointMeasure)POIXMLTypeLoader.newInstance(STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static STEighthPointMeasure parse(String param1String) throws XmlException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1String, STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1String, STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static STEighthPointMeasure parse(File param1File) throws XmlException, IOException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1File, STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1File, STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static STEighthPointMeasure parse(URL param1URL) throws XmlException, IOException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1URL, STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1URL, STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static STEighthPointMeasure parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1InputStream, STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1InputStream, STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static STEighthPointMeasure parse(Reader param1Reader) throws XmlException, IOException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1Reader, STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1Reader, STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static STEighthPointMeasure parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static STEighthPointMeasure parse(Node param1Node) throws XmlException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1Node, STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1Node, STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static STEighthPointMeasure parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STEighthPointMeasure.type, null);
    }
    
    public static STEighthPointMeasure parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STEighthPointMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STEighthPointMeasure.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STEighthPointMeasure.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STEighthPointMeasure.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STEighthPointMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */