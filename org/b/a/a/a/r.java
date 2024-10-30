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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface r extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(r.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("qualifyingpropertiestype9e16type");
  
  v a();
  
  boolean eE();
  
  void a(v paramv);
  
  v b();
  
  void hu();
  
  x a();
  
  boolean eF();
  
  void a(x paramx);
  
  x b();
  
  void hv();
  
  String getTarget();
  
  XmlAnyURI xgetTarget();
  
  void setTarget(String paramString);
  
  void xsetTarget(XmlAnyURI paramXmlAnyURI);
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static r c() {
      return (r)POIXMLTypeLoader.newInstance(r.type, null);
    }
    
    public static r a(XmlOptions param1XmlOptions) {
      return (r)POIXMLTypeLoader.newInstance(r.type, param1XmlOptions);
    }
    
    public static r a(String param1String) throws XmlException {
      return (r)POIXMLTypeLoader.parse(param1String, r.type, null);
    }
    
    public static r a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (r)POIXMLTypeLoader.parse(param1String, r.type, param1XmlOptions);
    }
    
    public static r a(File param1File) throws XmlException, IOException {
      return (r)POIXMLTypeLoader.parse(param1File, r.type, null);
    }
    
    public static r a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (r)POIXMLTypeLoader.parse(param1File, r.type, param1XmlOptions);
    }
    
    public static r a(URL param1URL) throws XmlException, IOException {
      return (r)POIXMLTypeLoader.parse(param1URL, r.type, null);
    }
    
    public static r a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (r)POIXMLTypeLoader.parse(param1URL, r.type, param1XmlOptions);
    }
    
    public static r a(InputStream param1InputStream) throws XmlException, IOException {
      return (r)POIXMLTypeLoader.parse(param1InputStream, r.type, null);
    }
    
    public static r a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (r)POIXMLTypeLoader.parse(param1InputStream, r.type, param1XmlOptions);
    }
    
    public static r a(Reader param1Reader) throws XmlException, IOException {
      return (r)POIXMLTypeLoader.parse(param1Reader, r.type, null);
    }
    
    public static r a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (r)POIXMLTypeLoader.parse(param1Reader, r.type, param1XmlOptions);
    }
    
    public static r a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (r)POIXMLTypeLoader.parse(param1XMLStreamReader, r.type, null);
    }
    
    public static r a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (r)POIXMLTypeLoader.parse(param1XMLStreamReader, r.type, param1XmlOptions);
    }
    
    public static r a(Node param1Node) throws XmlException {
      return (r)POIXMLTypeLoader.parse(param1Node, r.type, null);
    }
    
    public static r a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (r)POIXMLTypeLoader.parse(param1Node, r.type, param1XmlOptions);
    }
    
    public static r a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (r)POIXMLTypeLoader.parse(param1XMLInputStream, r.type, null);
    }
    
    public static r a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (r)POIXMLTypeLoader.parse(param1XMLInputStream, r.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, r.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, r.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */