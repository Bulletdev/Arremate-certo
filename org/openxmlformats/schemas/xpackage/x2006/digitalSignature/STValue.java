package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STValue extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STValue.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stvalueb6e1type");
  
  public static final class Factory {
    public static STValue newValue(Object param1Object) {
      return (STValue)STValue.type.newValue(param1Object);
    }
    
    public static STValue newInstance() {
      return (STValue)POIXMLTypeLoader.newInstance(STValue.type, null);
    }
    
    public static STValue newInstance(XmlOptions param1XmlOptions) {
      return (STValue)POIXMLTypeLoader.newInstance(STValue.type, param1XmlOptions);
    }
    
    public static STValue parse(String param1String) throws XmlException {
      return (STValue)POIXMLTypeLoader.parse(param1String, STValue.type, null);
    }
    
    public static STValue parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STValue)POIXMLTypeLoader.parse(param1String, STValue.type, param1XmlOptions);
    }
    
    public static STValue parse(File param1File) throws XmlException, IOException {
      return (STValue)POIXMLTypeLoader.parse(param1File, STValue.type, null);
    }
    
    public static STValue parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STValue)POIXMLTypeLoader.parse(param1File, STValue.type, param1XmlOptions);
    }
    
    public static STValue parse(URL param1URL) throws XmlException, IOException {
      return (STValue)POIXMLTypeLoader.parse(param1URL, STValue.type, null);
    }
    
    public static STValue parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STValue)POIXMLTypeLoader.parse(param1URL, STValue.type, param1XmlOptions);
    }
    
    public static STValue parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STValue)POIXMLTypeLoader.parse(param1InputStream, STValue.type, null);
    }
    
    public static STValue parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STValue)POIXMLTypeLoader.parse(param1InputStream, STValue.type, param1XmlOptions);
    }
    
    public static STValue parse(Reader param1Reader) throws XmlException, IOException {
      return (STValue)POIXMLTypeLoader.parse(param1Reader, STValue.type, null);
    }
    
    public static STValue parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STValue)POIXMLTypeLoader.parse(param1Reader, STValue.type, param1XmlOptions);
    }
    
    public static STValue parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STValue)POIXMLTypeLoader.parse(param1XMLStreamReader, STValue.type, null);
    }
    
    public static STValue parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STValue)POIXMLTypeLoader.parse(param1XMLStreamReader, STValue.type, param1XmlOptions);
    }
    
    public static STValue parse(Node param1Node) throws XmlException {
      return (STValue)POIXMLTypeLoader.parse(param1Node, STValue.type, null);
    }
    
    public static STValue parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STValue)POIXMLTypeLoader.parse(param1Node, STValue.type, param1XmlOptions);
    }
    
    public static STValue parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STValue)POIXMLTypeLoader.parse(param1XMLInputStream, STValue.type, null);
    }
    
    public static STValue parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STValue)POIXMLTypeLoader.parse(param1XMLInputStream, STValue.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STValue.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STValue.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\STValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */