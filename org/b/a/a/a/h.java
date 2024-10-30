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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface h extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(h.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("completecertificaterefstype07datype");
  
  e b();
  
  void a(e parame);
  
  e c();
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static h a() {
      return (h)POIXMLTypeLoader.newInstance(h.type, null);
    }
    
    public static h a(XmlOptions param1XmlOptions) {
      return (h)POIXMLTypeLoader.newInstance(h.type, param1XmlOptions);
    }
    
    public static h a(String param1String) throws XmlException {
      return (h)POIXMLTypeLoader.parse(param1String, h.type, null);
    }
    
    public static h a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (h)POIXMLTypeLoader.parse(param1String, h.type, param1XmlOptions);
    }
    
    public static h a(File param1File) throws XmlException, IOException {
      return (h)POIXMLTypeLoader.parse(param1File, h.type, null);
    }
    
    public static h a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (h)POIXMLTypeLoader.parse(param1File, h.type, param1XmlOptions);
    }
    
    public static h a(URL param1URL) throws XmlException, IOException {
      return (h)POIXMLTypeLoader.parse(param1URL, h.type, null);
    }
    
    public static h a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (h)POIXMLTypeLoader.parse(param1URL, h.type, param1XmlOptions);
    }
    
    public static h a(InputStream param1InputStream) throws XmlException, IOException {
      return (h)POIXMLTypeLoader.parse(param1InputStream, h.type, null);
    }
    
    public static h a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (h)POIXMLTypeLoader.parse(param1InputStream, h.type, param1XmlOptions);
    }
    
    public static h a(Reader param1Reader) throws XmlException, IOException {
      return (h)POIXMLTypeLoader.parse(param1Reader, h.type, null);
    }
    
    public static h a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (h)POIXMLTypeLoader.parse(param1Reader, h.type, param1XmlOptions);
    }
    
    public static h a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (h)POIXMLTypeLoader.parse(param1XMLStreamReader, h.type, null);
    }
    
    public static h a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (h)POIXMLTypeLoader.parse(param1XMLStreamReader, h.type, param1XmlOptions);
    }
    
    public static h a(Node param1Node) throws XmlException {
      return (h)POIXMLTypeLoader.parse(param1Node, h.type, null);
    }
    
    public static h a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (h)POIXMLTypeLoader.parse(param1Node, h.type, param1XmlOptions);
    }
    
    public static h a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (h)POIXMLTypeLoader.parse(param1XMLInputStream, h.type, null);
    }
    
    public static h a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (h)POIXMLTypeLoader.parse(param1XMLInputStream, h.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, h.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, h.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */