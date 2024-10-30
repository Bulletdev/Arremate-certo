package org.b.a.a.a;

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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface s extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(s.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("responderidtype55b9type");
  
  String ee();
  
  XmlString b();
  
  boolean eG();
  
  void bk(String paramString);
  
  void b(XmlString paramXmlString);
  
  void hw();
  
  byte[] q();
  
  XmlBase64Binary a();
  
  boolean eH();
  
  void g(byte[] paramArrayOfbyte);
  
  void a(XmlBase64Binary paramXmlBase64Binary);
  
  void hx();
  
  public static final class a {
    public static s c() {
      return (s)POIXMLTypeLoader.newInstance(s.type, null);
    }
    
    public static s a(XmlOptions param1XmlOptions) {
      return (s)POIXMLTypeLoader.newInstance(s.type, param1XmlOptions);
    }
    
    public static s a(String param1String) throws XmlException {
      return (s)POIXMLTypeLoader.parse(param1String, s.type, null);
    }
    
    public static s a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (s)POIXMLTypeLoader.parse(param1String, s.type, param1XmlOptions);
    }
    
    public static s a(File param1File) throws XmlException, IOException {
      return (s)POIXMLTypeLoader.parse(param1File, s.type, null);
    }
    
    public static s a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (s)POIXMLTypeLoader.parse(param1File, s.type, param1XmlOptions);
    }
    
    public static s a(URL param1URL) throws XmlException, IOException {
      return (s)POIXMLTypeLoader.parse(param1URL, s.type, null);
    }
    
    public static s a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (s)POIXMLTypeLoader.parse(param1URL, s.type, param1XmlOptions);
    }
    
    public static s a(InputStream param1InputStream) throws XmlException, IOException {
      return (s)POIXMLTypeLoader.parse(param1InputStream, s.type, null);
    }
    
    public static s a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (s)POIXMLTypeLoader.parse(param1InputStream, s.type, param1XmlOptions);
    }
    
    public static s a(Reader param1Reader) throws XmlException, IOException {
      return (s)POIXMLTypeLoader.parse(param1Reader, s.type, null);
    }
    
    public static s a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (s)POIXMLTypeLoader.parse(param1Reader, s.type, param1XmlOptions);
    }
    
    public static s a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (s)POIXMLTypeLoader.parse(param1XMLStreamReader, s.type, null);
    }
    
    public static s a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (s)POIXMLTypeLoader.parse(param1XMLStreamReader, s.type, param1XmlOptions);
    }
    
    public static s a(Node param1Node) throws XmlException {
      return (s)POIXMLTypeLoader.parse(param1Node, s.type, null);
    }
    
    public static s a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (s)POIXMLTypeLoader.parse(param1Node, s.type, param1XmlOptions);
    }
    
    public static s a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (s)POIXMLTypeLoader.parse(param1XMLInputStream, s.type, null);
    }
    
    public static s a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (s)POIXMLTypeLoader.parse(param1XMLInputStream, s.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, s.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, s.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */