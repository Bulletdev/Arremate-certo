package org.b.a.a.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface p extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(p.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ocspvaluestypeb421type");
  
  List<k> as();
  
  k[] d();
  
  k g(int paramInt);
  
  int bw();
  
  void d(k[] paramArrayOfk);
  
  void d(int paramInt, k paramk);
  
  k h(int paramInt);
  
  k e();
  
  void bd(int paramInt);
  
  public static final class a {
    public static p a() {
      return (p)POIXMLTypeLoader.newInstance(p.type, null);
    }
    
    public static p a(XmlOptions param1XmlOptions) {
      return (p)POIXMLTypeLoader.newInstance(p.type, param1XmlOptions);
    }
    
    public static p a(String param1String) throws XmlException {
      return (p)POIXMLTypeLoader.parse(param1String, p.type, null);
    }
    
    public static p a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (p)POIXMLTypeLoader.parse(param1String, p.type, param1XmlOptions);
    }
    
    public static p a(File param1File) throws XmlException, IOException {
      return (p)POIXMLTypeLoader.parse(param1File, p.type, null);
    }
    
    public static p a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (p)POIXMLTypeLoader.parse(param1File, p.type, param1XmlOptions);
    }
    
    public static p a(URL param1URL) throws XmlException, IOException {
      return (p)POIXMLTypeLoader.parse(param1URL, p.type, null);
    }
    
    public static p a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (p)POIXMLTypeLoader.parse(param1URL, p.type, param1XmlOptions);
    }
    
    public static p a(InputStream param1InputStream) throws XmlException, IOException {
      return (p)POIXMLTypeLoader.parse(param1InputStream, p.type, null);
    }
    
    public static p a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (p)POIXMLTypeLoader.parse(param1InputStream, p.type, param1XmlOptions);
    }
    
    public static p a(Reader param1Reader) throws XmlException, IOException {
      return (p)POIXMLTypeLoader.parse(param1Reader, p.type, null);
    }
    
    public static p a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (p)POIXMLTypeLoader.parse(param1Reader, p.type, param1XmlOptions);
    }
    
    public static p a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (p)POIXMLTypeLoader.parse(param1XMLStreamReader, p.type, null);
    }
    
    public static p a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (p)POIXMLTypeLoader.parse(param1XMLStreamReader, p.type, param1XmlOptions);
    }
    
    public static p a(Node param1Node) throws XmlException {
      return (p)POIXMLTypeLoader.parse(param1Node, p.type, null);
    }
    
    public static p a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (p)POIXMLTypeLoader.parse(param1Node, p.type, param1XmlOptions);
    }
    
    public static p a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (p)POIXMLTypeLoader.parse(param1XMLInputStream, p.type, null);
    }
    
    public static p a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (p)POIXMLTypeLoader.parse(param1XMLInputStream, p.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, p.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, p.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */