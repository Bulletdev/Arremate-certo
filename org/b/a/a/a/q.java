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

public interface q extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(q.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("qualifyingproperties53ccdoctype");
  
  r a();
  
  void a(r paramr);
  
  r b();
  
  public static final class a {
    public static q a() {
      return (q)POIXMLTypeLoader.newInstance(q.type, null);
    }
    
    public static q a(XmlOptions param1XmlOptions) {
      return (q)POIXMLTypeLoader.newInstance(q.type, param1XmlOptions);
    }
    
    public static q a(String param1String) throws XmlException {
      return (q)POIXMLTypeLoader.parse(param1String, q.type, null);
    }
    
    public static q a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (q)POIXMLTypeLoader.parse(param1String, q.type, param1XmlOptions);
    }
    
    public static q a(File param1File) throws XmlException, IOException {
      return (q)POIXMLTypeLoader.parse(param1File, q.type, null);
    }
    
    public static q a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (q)POIXMLTypeLoader.parse(param1File, q.type, param1XmlOptions);
    }
    
    public static q a(URL param1URL) throws XmlException, IOException {
      return (q)POIXMLTypeLoader.parse(param1URL, q.type, null);
    }
    
    public static q a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (q)POIXMLTypeLoader.parse(param1URL, q.type, param1XmlOptions);
    }
    
    public static q a(InputStream param1InputStream) throws XmlException, IOException {
      return (q)POIXMLTypeLoader.parse(param1InputStream, q.type, null);
    }
    
    public static q a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (q)POIXMLTypeLoader.parse(param1InputStream, q.type, param1XmlOptions);
    }
    
    public static q a(Reader param1Reader) throws XmlException, IOException {
      return (q)POIXMLTypeLoader.parse(param1Reader, q.type, null);
    }
    
    public static q a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (q)POIXMLTypeLoader.parse(param1Reader, q.type, param1XmlOptions);
    }
    
    public static q a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (q)POIXMLTypeLoader.parse(param1XMLStreamReader, q.type, null);
    }
    
    public static q a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (q)POIXMLTypeLoader.parse(param1XMLStreamReader, q.type, param1XmlOptions);
    }
    
    public static q a(Node param1Node) throws XmlException {
      return (q)POIXMLTypeLoader.parse(param1Node, q.type, null);
    }
    
    public static q a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (q)POIXMLTypeLoader.parse(param1Node, q.type, param1XmlOptions);
    }
    
    public static q a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (q)POIXMLTypeLoader.parse(param1XMLInputStream, q.type, null);
    }
    
    public static q a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (q)POIXMLTypeLoader.parse(param1XMLInputStream, q.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, q.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, q.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */