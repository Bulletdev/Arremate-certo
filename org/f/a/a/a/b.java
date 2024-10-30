package org.f.a.a.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface b extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(b.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("digestmethodtype5ce0type");
  
  String getAlgorithm();
  
  XmlAnyURI c();
  
  void setAlgorithm(String paramString);
  
  void c(XmlAnyURI paramXmlAnyURI);
  
  public static final class a {
    public static b c() {
      return (b)POIXMLTypeLoader.newInstance(b.type, null);
    }
    
    public static b a(XmlOptions param1XmlOptions) {
      return (b)POIXMLTypeLoader.newInstance(b.type, param1XmlOptions);
    }
    
    public static b a(String param1String) throws XmlException {
      return (b)POIXMLTypeLoader.parse(param1String, b.type, null);
    }
    
    public static b a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (b)POIXMLTypeLoader.parse(param1String, b.type, param1XmlOptions);
    }
    
    public static b a(File param1File) throws XmlException, IOException {
      return (b)POIXMLTypeLoader.parse(param1File, b.type, null);
    }
    
    public static b a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (b)POIXMLTypeLoader.parse(param1File, b.type, param1XmlOptions);
    }
    
    public static b a(URL param1URL) throws XmlException, IOException {
      return (b)POIXMLTypeLoader.parse(param1URL, b.type, null);
    }
    
    public static b a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (b)POIXMLTypeLoader.parse(param1URL, b.type, param1XmlOptions);
    }
    
    public static b a(InputStream param1InputStream) throws XmlException, IOException {
      return (b)POIXMLTypeLoader.parse(param1InputStream, b.type, null);
    }
    
    public static b a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (b)POIXMLTypeLoader.parse(param1InputStream, b.type, param1XmlOptions);
    }
    
    public static b a(Reader param1Reader) throws XmlException, IOException {
      return (b)POIXMLTypeLoader.parse(param1Reader, b.type, null);
    }
    
    public static b a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (b)POIXMLTypeLoader.parse(param1Reader, b.type, param1XmlOptions);
    }
    
    public static b a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (b)POIXMLTypeLoader.parse(param1XMLStreamReader, b.type, null);
    }
    
    public static b a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (b)POIXMLTypeLoader.parse(param1XMLStreamReader, b.type, param1XmlOptions);
    }
    
    public static b a(Node param1Node) throws XmlException {
      return (b)POIXMLTypeLoader.parse(param1Node, b.type, null);
    }
    
    public static b a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (b)POIXMLTypeLoader.parse(param1Node, b.type, param1XmlOptions);
    }
    
    public static b a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (b)POIXMLTypeLoader.parse(param1XMLInputStream, b.type, null);
    }
    
    public static b a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (b)POIXMLTypeLoader.parse(param1XMLInputStream, b.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, b.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, b.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */