package org.b.a.a.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.etsi.uri.x01903.v13.SignatureProductionPlaceType;
import org.etsi.uri.x01903.v13.SignerRoleType;
import org.w3c.dom.Node;

public interface w extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(w.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signedsignaturepropertiestype06abtype");
  
  Calendar l();
  
  XmlDateTime c();
  
  boolean eP();
  
  void e(Calendar paramCalendar);
  
  void c(XmlDateTime paramXmlDateTime);
  
  void hF();
  
  e d();
  
  boolean eQ();
  
  void b(e parame);
  
  e e();
  
  void hG();
  
  u b();
  
  boolean eR();
  
  void a(u paramu);
  
  u c();
  
  void hH();
  
  SignatureProductionPlaceType a();
  
  boolean eS();
  
  void a(SignatureProductionPlaceType paramSignatureProductionPlaceType);
  
  SignatureProductionPlaceType b();
  
  void hI();
  
  SignerRoleType a();
  
  boolean eT();
  
  void a(SignerRoleType paramSignerRoleType);
  
  SignerRoleType b();
  
  void hJ();
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static w c() {
      return (w)POIXMLTypeLoader.newInstance(w.type, null);
    }
    
    public static w a(XmlOptions param1XmlOptions) {
      return (w)POIXMLTypeLoader.newInstance(w.type, param1XmlOptions);
    }
    
    public static w a(String param1String) throws XmlException {
      return (w)POIXMLTypeLoader.parse(param1String, w.type, null);
    }
    
    public static w a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (w)POIXMLTypeLoader.parse(param1String, w.type, param1XmlOptions);
    }
    
    public static w a(File param1File) throws XmlException, IOException {
      return (w)POIXMLTypeLoader.parse(param1File, w.type, null);
    }
    
    public static w a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (w)POIXMLTypeLoader.parse(param1File, w.type, param1XmlOptions);
    }
    
    public static w a(URL param1URL) throws XmlException, IOException {
      return (w)POIXMLTypeLoader.parse(param1URL, w.type, null);
    }
    
    public static w a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (w)POIXMLTypeLoader.parse(param1URL, w.type, param1XmlOptions);
    }
    
    public static w a(InputStream param1InputStream) throws XmlException, IOException {
      return (w)POIXMLTypeLoader.parse(param1InputStream, w.type, null);
    }
    
    public static w a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (w)POIXMLTypeLoader.parse(param1InputStream, w.type, param1XmlOptions);
    }
    
    public static w a(Reader param1Reader) throws XmlException, IOException {
      return (w)POIXMLTypeLoader.parse(param1Reader, w.type, null);
    }
    
    public static w a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (w)POIXMLTypeLoader.parse(param1Reader, w.type, param1XmlOptions);
    }
    
    public static w a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (w)POIXMLTypeLoader.parse(param1XMLStreamReader, w.type, null);
    }
    
    public static w a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (w)POIXMLTypeLoader.parse(param1XMLStreamReader, w.type, param1XmlOptions);
    }
    
    public static w a(Node param1Node) throws XmlException {
      return (w)POIXMLTypeLoader.parse(param1Node, w.type, null);
    }
    
    public static w a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (w)POIXMLTypeLoader.parse(param1Node, w.type, param1XmlOptions);
    }
    
    public static w a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (w)POIXMLTypeLoader.parse(param1XMLInputStream, w.type, null);
    }
    
    public static w a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (w)POIXMLTypeLoader.parse(param1XMLInputStream, w.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, w.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, w.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */