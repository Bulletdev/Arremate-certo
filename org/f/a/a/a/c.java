package org.f.a.a.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface c extends XmlBase64Binary {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(c.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("digestvaluetype010atype");
  
  public static final class a {
    public static c a(Object param1Object) {
      return (c)c.type.newValue(param1Object);
    }
    
    public static c b() {
      return (c)POIXMLTypeLoader.newInstance(c.type, null);
    }
    
    public static c a(XmlOptions param1XmlOptions) {
      return (c)POIXMLTypeLoader.newInstance(c.type, param1XmlOptions);
    }
    
    public static c a(String param1String) throws XmlException {
      return (c)POIXMLTypeLoader.parse(param1String, c.type, null);
    }
    
    public static c a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (c)POIXMLTypeLoader.parse(param1String, c.type, param1XmlOptions);
    }
    
    public static c a(File param1File) throws XmlException, IOException {
      return (c)POIXMLTypeLoader.parse(param1File, c.type, null);
    }
    
    public static c a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (c)POIXMLTypeLoader.parse(param1File, c.type, param1XmlOptions);
    }
    
    public static c a(URL param1URL) throws XmlException, IOException {
      return (c)POIXMLTypeLoader.parse(param1URL, c.type, null);
    }
    
    public static c a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (c)POIXMLTypeLoader.parse(param1URL, c.type, param1XmlOptions);
    }
    
    public static c a(InputStream param1InputStream) throws XmlException, IOException {
      return (c)POIXMLTypeLoader.parse(param1InputStream, c.type, null);
    }
    
    public static c a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (c)POIXMLTypeLoader.parse(param1InputStream, c.type, param1XmlOptions);
    }
    
    public static c a(Reader param1Reader) throws XmlException, IOException {
      return (c)POIXMLTypeLoader.parse(param1Reader, c.type, null);
    }
    
    public static c a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (c)POIXMLTypeLoader.parse(param1Reader, c.type, param1XmlOptions);
    }
    
    public static c a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (c)POIXMLTypeLoader.parse(param1XMLStreamReader, c.type, null);
    }
    
    public static c a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (c)POIXMLTypeLoader.parse(param1XMLStreamReader, c.type, param1XmlOptions);
    }
    
    public static c a(Node param1Node) throws XmlException {
      return (c)POIXMLTypeLoader.parse(param1Node, c.type, null);
    }
    
    public static c a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (c)POIXMLTypeLoader.parse(param1Node, c.type, param1XmlOptions);
    }
    
    public static c a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (c)POIXMLTypeLoader.parse(param1XMLInputStream, c.type, null);
    }
    
    public static c a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (c)POIXMLTypeLoader.parse(param1XMLInputStream, c.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, c.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, c.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */