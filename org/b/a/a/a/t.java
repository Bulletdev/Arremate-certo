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
import org.etsi.uri.x01903.v13.OtherCertStatusValuesType;
import org.w3c.dom.Node;

public interface t extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(t.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("revocationvaluestype9a6etype");
  
  d b();
  
  boolean eI();
  
  void a(d paramd);
  
  d c();
  
  void hy();
  
  p b();
  
  boolean eJ();
  
  void a(p paramp);
  
  p c();
  
  void hz();
  
  OtherCertStatusValuesType a();
  
  boolean eK();
  
  void a(OtherCertStatusValuesType paramOtherCertStatusValuesType);
  
  OtherCertStatusValuesType b();
  
  void hA();
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static t a() {
      return (t)POIXMLTypeLoader.newInstance(t.type, null);
    }
    
    public static t a(XmlOptions param1XmlOptions) {
      return (t)POIXMLTypeLoader.newInstance(t.type, param1XmlOptions);
    }
    
    public static t a(String param1String) throws XmlException {
      return (t)POIXMLTypeLoader.parse(param1String, t.type, null);
    }
    
    public static t a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (t)POIXMLTypeLoader.parse(param1String, t.type, param1XmlOptions);
    }
    
    public static t a(File param1File) throws XmlException, IOException {
      return (t)POIXMLTypeLoader.parse(param1File, t.type, null);
    }
    
    public static t a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (t)POIXMLTypeLoader.parse(param1File, t.type, param1XmlOptions);
    }
    
    public static t a(URL param1URL) throws XmlException, IOException {
      return (t)POIXMLTypeLoader.parse(param1URL, t.type, null);
    }
    
    public static t a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (t)POIXMLTypeLoader.parse(param1URL, t.type, param1XmlOptions);
    }
    
    public static t a(InputStream param1InputStream) throws XmlException, IOException {
      return (t)POIXMLTypeLoader.parse(param1InputStream, t.type, null);
    }
    
    public static t a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (t)POIXMLTypeLoader.parse(param1InputStream, t.type, param1XmlOptions);
    }
    
    public static t a(Reader param1Reader) throws XmlException, IOException {
      return (t)POIXMLTypeLoader.parse(param1Reader, t.type, null);
    }
    
    public static t a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (t)POIXMLTypeLoader.parse(param1Reader, t.type, param1XmlOptions);
    }
    
    public static t a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (t)POIXMLTypeLoader.parse(param1XMLStreamReader, t.type, null);
    }
    
    public static t a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (t)POIXMLTypeLoader.parse(param1XMLStreamReader, t.type, param1XmlOptions);
    }
    
    public static t a(Node param1Node) throws XmlException {
      return (t)POIXMLTypeLoader.parse(param1Node, t.type, null);
    }
    
    public static t a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (t)POIXMLTypeLoader.parse(param1Node, t.type, param1XmlOptions);
    }
    
    public static t a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (t)POIXMLTypeLoader.parse(param1XMLInputStream, t.type, null);
    }
    
    public static t a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (t)POIXMLTypeLoader.parse(param1XMLInputStream, t.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, t.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, t.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */