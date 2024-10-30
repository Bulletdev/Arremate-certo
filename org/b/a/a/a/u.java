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
import org.etsi.uri.x01903.v13.SignaturePolicyIdType;
import org.w3c.dom.Node;

public interface u extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(u.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signaturepolicyidentifiertype80aftype");
  
  SignaturePolicyIdType a();
  
  boolean eL();
  
  void a(SignaturePolicyIdType paramSignaturePolicyIdType);
  
  SignaturePolicyIdType b();
  
  void hB();
  
  XmlObject a();
  
  boolean eM();
  
  void a(XmlObject paramXmlObject);
  
  XmlObject b();
  
  void hC();
  
  public static final class a {
    public static u a() {
      return (u)POIXMLTypeLoader.newInstance(u.type, null);
    }
    
    public static u a(XmlOptions param1XmlOptions) {
      return (u)POIXMLTypeLoader.newInstance(u.type, param1XmlOptions);
    }
    
    public static u a(String param1String) throws XmlException {
      return (u)POIXMLTypeLoader.parse(param1String, u.type, null);
    }
    
    public static u a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (u)POIXMLTypeLoader.parse(param1String, u.type, param1XmlOptions);
    }
    
    public static u a(File param1File) throws XmlException, IOException {
      return (u)POIXMLTypeLoader.parse(param1File, u.type, null);
    }
    
    public static u a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (u)POIXMLTypeLoader.parse(param1File, u.type, param1XmlOptions);
    }
    
    public static u a(URL param1URL) throws XmlException, IOException {
      return (u)POIXMLTypeLoader.parse(param1URL, u.type, null);
    }
    
    public static u a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (u)POIXMLTypeLoader.parse(param1URL, u.type, param1XmlOptions);
    }
    
    public static u a(InputStream param1InputStream) throws XmlException, IOException {
      return (u)POIXMLTypeLoader.parse(param1InputStream, u.type, null);
    }
    
    public static u a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (u)POIXMLTypeLoader.parse(param1InputStream, u.type, param1XmlOptions);
    }
    
    public static u a(Reader param1Reader) throws XmlException, IOException {
      return (u)POIXMLTypeLoader.parse(param1Reader, u.type, null);
    }
    
    public static u a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (u)POIXMLTypeLoader.parse(param1Reader, u.type, param1XmlOptions);
    }
    
    public static u a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (u)POIXMLTypeLoader.parse(param1XMLStreamReader, u.type, null);
    }
    
    public static u a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (u)POIXMLTypeLoader.parse(param1XMLStreamReader, u.type, param1XmlOptions);
    }
    
    public static u a(Node param1Node) throws XmlException {
      return (u)POIXMLTypeLoader.parse(param1Node, u.type, null);
    }
    
    public static u a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (u)POIXMLTypeLoader.parse(param1Node, u.type, param1XmlOptions);
    }
    
    public static u a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (u)POIXMLTypeLoader.parse(param1XMLInputStream, u.type, null);
    }
    
    public static u a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (u)POIXMLTypeLoader.parse(param1XMLInputStream, u.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, u.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, u.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */