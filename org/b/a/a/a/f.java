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
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.f.a.a.a.k;
import org.w3c.dom.Node;

public interface f extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(f.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("certidtypee64dtype");
  
  j c();
  
  void b(j paramj);
  
  j d();
  
  k a();
  
  void a(k paramk);
  
  k b();
  
  String getURI();
  
  XmlAnyURI a();
  
  boolean ew();
  
  void bj(String paramString);
  
  void a(XmlAnyURI paramXmlAnyURI);
  
  void hm();
  
  public static final class a {
    public static f b() {
      return (f)POIXMLTypeLoader.newInstance(f.type, null);
    }
    
    public static f a(XmlOptions param1XmlOptions) {
      return (f)POIXMLTypeLoader.newInstance(f.type, param1XmlOptions);
    }
    
    public static f a(String param1String) throws XmlException {
      return (f)POIXMLTypeLoader.parse(param1String, f.type, null);
    }
    
    public static f a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (f)POIXMLTypeLoader.parse(param1String, f.type, param1XmlOptions);
    }
    
    public static f a(File param1File) throws XmlException, IOException {
      return (f)POIXMLTypeLoader.parse(param1File, f.type, null);
    }
    
    public static f a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (f)POIXMLTypeLoader.parse(param1File, f.type, param1XmlOptions);
    }
    
    public static f a(URL param1URL) throws XmlException, IOException {
      return (f)POIXMLTypeLoader.parse(param1URL, f.type, null);
    }
    
    public static f a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (f)POIXMLTypeLoader.parse(param1URL, f.type, param1XmlOptions);
    }
    
    public static f a(InputStream param1InputStream) throws XmlException, IOException {
      return (f)POIXMLTypeLoader.parse(param1InputStream, f.type, null);
    }
    
    public static f a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (f)POIXMLTypeLoader.parse(param1InputStream, f.type, param1XmlOptions);
    }
    
    public static f a(Reader param1Reader) throws XmlException, IOException {
      return (f)POIXMLTypeLoader.parse(param1Reader, f.type, null);
    }
    
    public static f a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (f)POIXMLTypeLoader.parse(param1Reader, f.type, param1XmlOptions);
    }
    
    public static f a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (f)POIXMLTypeLoader.parse(param1XMLStreamReader, f.type, null);
    }
    
    public static f a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (f)POIXMLTypeLoader.parse(param1XMLStreamReader, f.type, param1XmlOptions);
    }
    
    public static f a(Node param1Node) throws XmlException {
      return (f)POIXMLTypeLoader.parse(param1Node, f.type, null);
    }
    
    public static f a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (f)POIXMLTypeLoader.parse(param1Node, f.type, param1XmlOptions);
    }
    
    public static f a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (f)POIXMLTypeLoader.parse(param1XMLInputStream, f.type, null);
    }
    
    public static f a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (f)POIXMLTypeLoader.parse(param1XMLInputStream, f.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, f.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, f.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */