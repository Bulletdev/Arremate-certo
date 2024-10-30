package org.b.a.a.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface k extends XmlBase64Binary {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(k.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("encapsulatedpkidatatype4081type");
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  String getEncoding();
  
  XmlAnyURI b();
  
  boolean eB();
  
  void setEncoding(String paramString);
  
  void b(XmlAnyURI paramXmlAnyURI);
  
  void hr();
  
  public static final class a {
    public static k c() {
      return (k)POIXMLTypeLoader.newInstance(k.type, null);
    }
    
    public static k a(XmlOptions param1XmlOptions) {
      return (k)POIXMLTypeLoader.newInstance(k.type, param1XmlOptions);
    }
    
    public static k a(String param1String) throws XmlException {
      return (k)POIXMLTypeLoader.parse(param1String, k.type, null);
    }
    
    public static k a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (k)POIXMLTypeLoader.parse(param1String, k.type, param1XmlOptions);
    }
    
    public static k a(File param1File) throws XmlException, IOException {
      return (k)POIXMLTypeLoader.parse(param1File, k.type, null);
    }
    
    public static k a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (k)POIXMLTypeLoader.parse(param1File, k.type, param1XmlOptions);
    }
    
    public static k a(URL param1URL) throws XmlException, IOException {
      return (k)POIXMLTypeLoader.parse(param1URL, k.type, null);
    }
    
    public static k a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (k)POIXMLTypeLoader.parse(param1URL, k.type, param1XmlOptions);
    }
    
    public static k a(InputStream param1InputStream) throws XmlException, IOException {
      return (k)POIXMLTypeLoader.parse(param1InputStream, k.type, null);
    }
    
    public static k a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (k)POIXMLTypeLoader.parse(param1InputStream, k.type, param1XmlOptions);
    }
    
    public static k a(Reader param1Reader) throws XmlException, IOException {
      return (k)POIXMLTypeLoader.parse(param1Reader, k.type, null);
    }
    
    public static k a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (k)POIXMLTypeLoader.parse(param1Reader, k.type, param1XmlOptions);
    }
    
    public static k a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (k)POIXMLTypeLoader.parse(param1XMLStreamReader, k.type, null);
    }
    
    public static k a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (k)POIXMLTypeLoader.parse(param1XMLStreamReader, k.type, param1XmlOptions);
    }
    
    public static k a(Node param1Node) throws XmlException {
      return (k)POIXMLTypeLoader.parse(param1Node, k.type, null);
    }
    
    public static k a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (k)POIXMLTypeLoader.parse(param1Node, k.type, param1XmlOptions);
    }
    
    public static k a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (k)POIXMLTypeLoader.parse(param1XMLInputStream, k.type, null);
    }
    
    public static k a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (k)POIXMLTypeLoader.parse(param1XMLInputStream, k.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, k.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, k.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */