package org.b.a.a.a;

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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface n extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(n.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ocspreftype089etype");
  
  m b();
  
  void a(m paramm);
  
  m c();
  
  j a();
  
  boolean eD();
  
  void a(j paramj);
  
  j b();
  
  void ht();
  
  public static final class a {
    public static n a() {
      return (n)POIXMLTypeLoader.newInstance(n.type, null);
    }
    
    public static n a(XmlOptions param1XmlOptions) {
      return (n)POIXMLTypeLoader.newInstance(n.type, param1XmlOptions);
    }
    
    public static n a(String param1String) throws XmlException {
      return (n)POIXMLTypeLoader.parse(param1String, n.type, null);
    }
    
    public static n a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (n)POIXMLTypeLoader.parse(param1String, n.type, param1XmlOptions);
    }
    
    public static n a(File param1File) throws XmlException, IOException {
      return (n)POIXMLTypeLoader.parse(param1File, n.type, null);
    }
    
    public static n a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (n)POIXMLTypeLoader.parse(param1File, n.type, param1XmlOptions);
    }
    
    public static n a(URL param1URL) throws XmlException, IOException {
      return (n)POIXMLTypeLoader.parse(param1URL, n.type, null);
    }
    
    public static n a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (n)POIXMLTypeLoader.parse(param1URL, n.type, param1XmlOptions);
    }
    
    public static n a(InputStream param1InputStream) throws XmlException, IOException {
      return (n)POIXMLTypeLoader.parse(param1InputStream, n.type, null);
    }
    
    public static n a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (n)POIXMLTypeLoader.parse(param1InputStream, n.type, param1XmlOptions);
    }
    
    public static n a(Reader param1Reader) throws XmlException, IOException {
      return (n)POIXMLTypeLoader.parse(param1Reader, n.type, null);
    }
    
    public static n a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (n)POIXMLTypeLoader.parse(param1Reader, n.type, param1XmlOptions);
    }
    
    public static n a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (n)POIXMLTypeLoader.parse(param1XMLStreamReader, n.type, null);
    }
    
    public static n a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (n)POIXMLTypeLoader.parse(param1XMLStreamReader, n.type, param1XmlOptions);
    }
    
    public static n a(Node param1Node) throws XmlException {
      return (n)POIXMLTypeLoader.parse(param1Node, n.type, null);
    }
    
    public static n a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (n)POIXMLTypeLoader.parse(param1Node, n.type, param1XmlOptions);
    }
    
    public static n a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (n)POIXMLTypeLoader.parse(param1XMLInputStream, n.type, null);
    }
    
    public static n a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (n)POIXMLTypeLoader.parse(param1XMLInputStream, n.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, n.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, n.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */