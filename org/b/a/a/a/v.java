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
import org.etsi.uri.x01903.v13.SignedDataObjectPropertiesType;
import org.w3c.dom.Node;

public interface v extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(v.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signedpropertiestype163dtype");
  
  w a();
  
  boolean eN();
  
  void a(w paramw);
  
  w b();
  
  void hD();
  
  SignedDataObjectPropertiesType a();
  
  boolean eO();
  
  void a(SignedDataObjectPropertiesType paramSignedDataObjectPropertiesType);
  
  SignedDataObjectPropertiesType b();
  
  void hE();
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static v c() {
      return (v)POIXMLTypeLoader.newInstance(v.type, null);
    }
    
    public static v a(XmlOptions param1XmlOptions) {
      return (v)POIXMLTypeLoader.newInstance(v.type, param1XmlOptions);
    }
    
    public static v a(String param1String) throws XmlException {
      return (v)POIXMLTypeLoader.parse(param1String, v.type, null);
    }
    
    public static v a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (v)POIXMLTypeLoader.parse(param1String, v.type, param1XmlOptions);
    }
    
    public static v a(File param1File) throws XmlException, IOException {
      return (v)POIXMLTypeLoader.parse(param1File, v.type, null);
    }
    
    public static v a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (v)POIXMLTypeLoader.parse(param1File, v.type, param1XmlOptions);
    }
    
    public static v a(URL param1URL) throws XmlException, IOException {
      return (v)POIXMLTypeLoader.parse(param1URL, v.type, null);
    }
    
    public static v a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (v)POIXMLTypeLoader.parse(param1URL, v.type, param1XmlOptions);
    }
    
    public static v a(InputStream param1InputStream) throws XmlException, IOException {
      return (v)POIXMLTypeLoader.parse(param1InputStream, v.type, null);
    }
    
    public static v a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (v)POIXMLTypeLoader.parse(param1InputStream, v.type, param1XmlOptions);
    }
    
    public static v a(Reader param1Reader) throws XmlException, IOException {
      return (v)POIXMLTypeLoader.parse(param1Reader, v.type, null);
    }
    
    public static v a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (v)POIXMLTypeLoader.parse(param1Reader, v.type, param1XmlOptions);
    }
    
    public static v a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (v)POIXMLTypeLoader.parse(param1XMLStreamReader, v.type, null);
    }
    
    public static v a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (v)POIXMLTypeLoader.parse(param1XMLStreamReader, v.type, param1XmlOptions);
    }
    
    public static v a(Node param1Node) throws XmlException {
      return (v)POIXMLTypeLoader.parse(param1Node, v.type, null);
    }
    
    public static v a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (v)POIXMLTypeLoader.parse(param1Node, v.type, param1XmlOptions);
    }
    
    public static v a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (v)POIXMLTypeLoader.parse(param1XMLInputStream, v.type, null);
    }
    
    public static v a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (v)POIXMLTypeLoader.parse(param1XMLInputStream, v.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, v.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, v.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */