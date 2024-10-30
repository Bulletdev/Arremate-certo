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

public interface o extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(o.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ocsprefstypef13ftype");
  
  List<n> ar();
  
  n[] a();
  
  n a(int paramInt);
  
  int bv();
  
  void a(n[] paramArrayOfn);
  
  void a(int paramInt, n paramn);
  
  n b(int paramInt);
  
  n b();
  
  void bc(int paramInt);
  
  public static final class a {
    public static o c() {
      return (o)POIXMLTypeLoader.newInstance(o.type, null);
    }
    
    public static o a(XmlOptions param1XmlOptions) {
      return (o)POIXMLTypeLoader.newInstance(o.type, param1XmlOptions);
    }
    
    public static o a(String param1String) throws XmlException {
      return (o)POIXMLTypeLoader.parse(param1String, o.type, null);
    }
    
    public static o a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (o)POIXMLTypeLoader.parse(param1String, o.type, param1XmlOptions);
    }
    
    public static o a(File param1File) throws XmlException, IOException {
      return (o)POIXMLTypeLoader.parse(param1File, o.type, null);
    }
    
    public static o a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (o)POIXMLTypeLoader.parse(param1File, o.type, param1XmlOptions);
    }
    
    public static o a(URL param1URL) throws XmlException, IOException {
      return (o)POIXMLTypeLoader.parse(param1URL, o.type, null);
    }
    
    public static o a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (o)POIXMLTypeLoader.parse(param1URL, o.type, param1XmlOptions);
    }
    
    public static o a(InputStream param1InputStream) throws XmlException, IOException {
      return (o)POIXMLTypeLoader.parse(param1InputStream, o.type, null);
    }
    
    public static o a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (o)POIXMLTypeLoader.parse(param1InputStream, o.type, param1XmlOptions);
    }
    
    public static o a(Reader param1Reader) throws XmlException, IOException {
      return (o)POIXMLTypeLoader.parse(param1Reader, o.type, null);
    }
    
    public static o a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (o)POIXMLTypeLoader.parse(param1Reader, o.type, param1XmlOptions);
    }
    
    public static o a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (o)POIXMLTypeLoader.parse(param1XMLStreamReader, o.type, null);
    }
    
    public static o a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (o)POIXMLTypeLoader.parse(param1XMLStreamReader, o.type, param1XmlOptions);
    }
    
    public static o a(Node param1Node) throws XmlException {
      return (o)POIXMLTypeLoader.parse(param1Node, o.type, null);
    }
    
    public static o a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (o)POIXMLTypeLoader.parse(param1Node, o.type, param1XmlOptions);
    }
    
    public static o a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (o)POIXMLTypeLoader.parse(param1XMLInputStream, o.type, null);
    }
    
    public static o a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (o)POIXMLTypeLoader.parse(param1XMLInputStream, o.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, o.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, o.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */