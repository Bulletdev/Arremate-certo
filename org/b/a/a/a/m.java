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
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface m extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(m.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ocspidentifiertype3968type");
  
  s a();
  
  void a(s params);
  
  s b();
  
  Calendar k();
  
  XmlDateTime b();
  
  void d(Calendar paramCalendar);
  
  void b(XmlDateTime paramXmlDateTime);
  
  String getURI();
  
  XmlAnyURI a();
  
  boolean ew();
  
  void bj(String paramString);
  
  void a(XmlAnyURI paramXmlAnyURI);
  
  void hm();
  
  public static final class a {
    public static m a() {
      return (m)POIXMLTypeLoader.newInstance(m.type, null);
    }
    
    public static m a(XmlOptions param1XmlOptions) {
      return (m)POIXMLTypeLoader.newInstance(m.type, param1XmlOptions);
    }
    
    public static m a(String param1String) throws XmlException {
      return (m)POIXMLTypeLoader.parse(param1String, m.type, null);
    }
    
    public static m a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (m)POIXMLTypeLoader.parse(param1String, m.type, param1XmlOptions);
    }
    
    public static m a(File param1File) throws XmlException, IOException {
      return (m)POIXMLTypeLoader.parse(param1File, m.type, null);
    }
    
    public static m a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (m)POIXMLTypeLoader.parse(param1File, m.type, param1XmlOptions);
    }
    
    public static m a(URL param1URL) throws XmlException, IOException {
      return (m)POIXMLTypeLoader.parse(param1URL, m.type, null);
    }
    
    public static m a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (m)POIXMLTypeLoader.parse(param1URL, m.type, param1XmlOptions);
    }
    
    public static m a(InputStream param1InputStream) throws XmlException, IOException {
      return (m)POIXMLTypeLoader.parse(param1InputStream, m.type, null);
    }
    
    public static m a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (m)POIXMLTypeLoader.parse(param1InputStream, m.type, param1XmlOptions);
    }
    
    public static m a(Reader param1Reader) throws XmlException, IOException {
      return (m)POIXMLTypeLoader.parse(param1Reader, m.type, null);
    }
    
    public static m a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (m)POIXMLTypeLoader.parse(param1Reader, m.type, param1XmlOptions);
    }
    
    public static m a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (m)POIXMLTypeLoader.parse(param1XMLStreamReader, m.type, null);
    }
    
    public static m a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (m)POIXMLTypeLoader.parse(param1XMLStreamReader, m.type, param1XmlOptions);
    }
    
    public static m a(Node param1Node) throws XmlException {
      return (m)POIXMLTypeLoader.parse(param1Node, m.type, null);
    }
    
    public static m a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (m)POIXMLTypeLoader.parse(param1Node, m.type, param1XmlOptions);
    }
    
    public static m a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (m)POIXMLTypeLoader.parse(param1XMLInputStream, m.type, null);
    }
    
    public static m a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (m)POIXMLTypeLoader.parse(param1XMLInputStream, m.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, m.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, m.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */