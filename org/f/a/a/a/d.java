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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface d extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(d.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("objecttypec966type");
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  String getMimeType();
  
  XmlString c();
  
  boolean gI();
  
  void bO(String paramString);
  
  void c(XmlString paramXmlString);
  
  void iL();
  
  String getEncoding();
  
  XmlAnyURI b();
  
  boolean eB();
  
  void setEncoding(String paramString);
  
  void b(XmlAnyURI paramXmlAnyURI);
  
  void hr();
  
  public static final class a {
    public static d a() {
      return (d)POIXMLTypeLoader.newInstance(d.type, null);
    }
    
    public static d a(XmlOptions param1XmlOptions) {
      return (d)POIXMLTypeLoader.newInstance(d.type, param1XmlOptions);
    }
    
    public static d a(String param1String) throws XmlException {
      return (d)POIXMLTypeLoader.parse(param1String, d.type, null);
    }
    
    public static d a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (d)POIXMLTypeLoader.parse(param1String, d.type, param1XmlOptions);
    }
    
    public static d a(File param1File) throws XmlException, IOException {
      return (d)POIXMLTypeLoader.parse(param1File, d.type, null);
    }
    
    public static d a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (d)POIXMLTypeLoader.parse(param1File, d.type, param1XmlOptions);
    }
    
    public static d a(URL param1URL) throws XmlException, IOException {
      return (d)POIXMLTypeLoader.parse(param1URL, d.type, null);
    }
    
    public static d a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (d)POIXMLTypeLoader.parse(param1URL, d.type, param1XmlOptions);
    }
    
    public static d a(InputStream param1InputStream) throws XmlException, IOException {
      return (d)POIXMLTypeLoader.parse(param1InputStream, d.type, null);
    }
    
    public static d a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (d)POIXMLTypeLoader.parse(param1InputStream, d.type, param1XmlOptions);
    }
    
    public static d a(Reader param1Reader) throws XmlException, IOException {
      return (d)POIXMLTypeLoader.parse(param1Reader, d.type, null);
    }
    
    public static d a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (d)POIXMLTypeLoader.parse(param1Reader, d.type, param1XmlOptions);
    }
    
    public static d a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (d)POIXMLTypeLoader.parse(param1XMLStreamReader, d.type, null);
    }
    
    public static d a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (d)POIXMLTypeLoader.parse(param1XMLStreamReader, d.type, param1XmlOptions);
    }
    
    public static d a(Node param1Node) throws XmlException {
      return (d)POIXMLTypeLoader.parse(param1Node, d.type, null);
    }
    
    public static d a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (d)POIXMLTypeLoader.parse(param1Node, d.type, param1XmlOptions);
    }
    
    public static d a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (d)POIXMLTypeLoader.parse(param1XMLInputStream, d.type, null);
    }
    
    public static d a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (d)POIXMLTypeLoader.parse(param1XMLInputStream, d.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, d.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, d.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */