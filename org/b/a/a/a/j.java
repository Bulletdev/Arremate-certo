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
import org.f.a.a.a.b;
import org.f.a.a.a.c;
import org.w3c.dom.Node;

public interface j extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(j.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("digestalgandvaluetype234etype");
  
  b a();
  
  void a(b paramb);
  
  b b();
  
  byte[] p();
  
  c a();
  
  void f(byte[] paramArrayOfbyte);
  
  void a(c paramc);
  
  public static final class a {
    public static j e() {
      return (j)POIXMLTypeLoader.newInstance(j.type, null);
    }
    
    public static j a(XmlOptions param1XmlOptions) {
      return (j)POIXMLTypeLoader.newInstance(j.type, param1XmlOptions);
    }
    
    public static j a(String param1String) throws XmlException {
      return (j)POIXMLTypeLoader.parse(param1String, j.type, null);
    }
    
    public static j a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (j)POIXMLTypeLoader.parse(param1String, j.type, param1XmlOptions);
    }
    
    public static j a(File param1File) throws XmlException, IOException {
      return (j)POIXMLTypeLoader.parse(param1File, j.type, null);
    }
    
    public static j a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (j)POIXMLTypeLoader.parse(param1File, j.type, param1XmlOptions);
    }
    
    public static j a(URL param1URL) throws XmlException, IOException {
      return (j)POIXMLTypeLoader.parse(param1URL, j.type, null);
    }
    
    public static j a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (j)POIXMLTypeLoader.parse(param1URL, j.type, param1XmlOptions);
    }
    
    public static j a(InputStream param1InputStream) throws XmlException, IOException {
      return (j)POIXMLTypeLoader.parse(param1InputStream, j.type, null);
    }
    
    public static j a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (j)POIXMLTypeLoader.parse(param1InputStream, j.type, param1XmlOptions);
    }
    
    public static j a(Reader param1Reader) throws XmlException, IOException {
      return (j)POIXMLTypeLoader.parse(param1Reader, j.type, null);
    }
    
    public static j a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (j)POIXMLTypeLoader.parse(param1Reader, j.type, param1XmlOptions);
    }
    
    public static j a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (j)POIXMLTypeLoader.parse(param1XMLStreamReader, j.type, null);
    }
    
    public static j a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (j)POIXMLTypeLoader.parse(param1XMLStreamReader, j.type, param1XmlOptions);
    }
    
    public static j a(Node param1Node) throws XmlException {
      return (j)POIXMLTypeLoader.parse(param1Node, j.type, null);
    }
    
    public static j a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (j)POIXMLTypeLoader.parse(param1Node, j.type, param1XmlOptions);
    }
    
    public static j a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (j)POIXMLTypeLoader.parse(param1XMLInputStream, j.type, null);
    }
    
    public static j a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (j)POIXMLTypeLoader.parse(param1XMLInputStream, j.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, j.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, j.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */