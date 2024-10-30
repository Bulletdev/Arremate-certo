package org.b.a.a.b;

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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.b.a.a.a.g;
import org.b.a.a.a.t;
import org.w3c.dom.Node;

public interface a extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(a.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("validationdatatype2c11type");
  
  g d();
  
  boolean eW();
  
  void a(g paramg);
  
  g b();
  
  void hM();
  
  t d();
  
  boolean eX();
  
  void a(t paramt);
  
  t b();
  
  void hN();
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  String getURI();
  
  XmlAnyURI a();
  
  boolean ew();
  
  void bj(String paramString);
  
  void a(XmlAnyURI paramXmlAnyURI);
  
  void hm();
  
  public static final class a {
    public static a a() {
      return (a)POIXMLTypeLoader.newInstance(a.type, null);
    }
    
    public static a a(XmlOptions param1XmlOptions) {
      return (a)POIXMLTypeLoader.newInstance(a.type, param1XmlOptions);
    }
    
    public static a a(String param1String) throws XmlException {
      return (a)POIXMLTypeLoader.parse(param1String, a.type, null);
    }
    
    public static a a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (a)POIXMLTypeLoader.parse(param1String, a.type, param1XmlOptions);
    }
    
    public static a a(File param1File) throws XmlException, IOException {
      return (a)POIXMLTypeLoader.parse(param1File, a.type, null);
    }
    
    public static a a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (a)POIXMLTypeLoader.parse(param1File, a.type, param1XmlOptions);
    }
    
    public static a a(URL param1URL) throws XmlException, IOException {
      return (a)POIXMLTypeLoader.parse(param1URL, a.type, null);
    }
    
    public static a a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (a)POIXMLTypeLoader.parse(param1URL, a.type, param1XmlOptions);
    }
    
    public static a a(InputStream param1InputStream) throws XmlException, IOException {
      return (a)POIXMLTypeLoader.parse(param1InputStream, a.type, null);
    }
    
    public static a a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (a)POIXMLTypeLoader.parse(param1InputStream, a.type, param1XmlOptions);
    }
    
    public static a a(Reader param1Reader) throws XmlException, IOException {
      return (a)POIXMLTypeLoader.parse(param1Reader, a.type, null);
    }
    
    public static a a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (a)POIXMLTypeLoader.parse(param1Reader, a.type, param1XmlOptions);
    }
    
    public static a a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (a)POIXMLTypeLoader.parse(param1XMLStreamReader, a.type, null);
    }
    
    public static a a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (a)POIXMLTypeLoader.parse(param1XMLStreamReader, a.type, param1XmlOptions);
    }
    
    public static a a(Node param1Node) throws XmlException {
      return (a)POIXMLTypeLoader.parse(param1Node, a.type, null);
    }
    
    public static a a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (a)POIXMLTypeLoader.parse(param1Node, a.type, param1XmlOptions);
    }
    
    public static a a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (a)POIXMLTypeLoader.parse(param1XMLInputStream, a.type, null);
    }
    
    public static a a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (a)POIXMLTypeLoader.parse(param1XMLInputStream, a.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, a.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, a.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */