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

public interface STSignedHpsMeasure extends XmlInteger {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSignedHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsignedhpsmeasure8e89type");
  
  public static final class Factory {
    public static STSignedHpsMeasure newValue(Object param1Object) {
      return (STSignedHpsMeasure)STSignedHpsMeasure.type.newValue(param1Object);
    }
    
    public static STSignedHpsMeasure newInstance() {
      return (STSignedHpsMeasure)POIXMLTypeLoader.newInstance(STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure newInstance(XmlOptions param1XmlOptions) {
      return (STSignedHpsMeasure)POIXMLTypeLoader.newInstance(STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedHpsMeasure parse(String param1String) throws XmlException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1String, STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1String, STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedHpsMeasure parse(File param1File) throws XmlException, IOException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1File, STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1File, STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedHpsMeasure parse(URL param1URL) throws XmlException, IOException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1URL, STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1URL, STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedHpsMeasure parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1InputStream, STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1InputStream, STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedHpsMeasure parse(Reader param1Reader) throws XmlException, IOException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1Reader, STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1Reader, STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedHpsMeasure parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedHpsMeasure parse(Node param1Node) throws XmlException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1Node, STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1Node, STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static STSignedHpsMeasure parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STSignedHpsMeasure.type, null);
    }
    
    public static STSignedHpsMeasure parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSignedHpsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, STSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSignedHpsMeasure.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSignedHpsMeasure.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STSignedHpsMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */