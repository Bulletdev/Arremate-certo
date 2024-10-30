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

public interface e extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(e.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("certidlisttype488btype");
  
  List<f> ak();
  
  f[] a();
  
  f a(int paramInt);
  
  int bp();
  
  void a(f[] paramArrayOff);
  
  void a(int paramInt, f paramf);
  
  f b(int paramInt);
  
  f a();
  
  void aW(int paramInt);
  
  public static final class a {
    public static e a() {
      return (e)POIXMLTypeLoader.newInstance(e.type, null);
    }
    
    public static e a(XmlOptions param1XmlOptions) {
      return (e)POIXMLTypeLoader.newInstance(e.type, param1XmlOptions);
    }
    
    public static e a(String param1String) throws XmlException {
      return (e)POIXMLTypeLoader.parse(param1String, e.type, null);
    }
    
    public static e a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (e)POIXMLTypeLoader.parse(param1String, e.type, param1XmlOptions);
    }
    
    public static e a(File param1File) throws XmlException, IOException {
      return (e)POIXMLTypeLoader.parse(param1File, e.type, null);
    }
    
    public static e a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (e)POIXMLTypeLoader.parse(param1File, e.type, param1XmlOptions);
    }
    
    public static e a(URL param1URL) throws XmlException, IOException {
      return (e)POIXMLTypeLoader.parse(param1URL, e.type, null);
    }
    
    public static e a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (e)POIXMLTypeLoader.parse(param1URL, e.type, param1XmlOptions);
    }
    
    public static e a(InputStream param1InputStream) throws XmlException, IOException {
      return (e)POIXMLTypeLoader.parse(param1InputStream, e.type, null);
    }
    
    public static e a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (e)POIXMLTypeLoader.parse(param1InputStream, e.type, param1XmlOptions);
    }
    
    public static e a(Reader param1Reader) throws XmlException, IOException {
      return (e)POIXMLTypeLoader.parse(param1Reader, e.type, null);
    }
    
    public static e a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (e)POIXMLTypeLoader.parse(param1Reader, e.type, param1XmlOptions);
    }
    
    public static e a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (e)POIXMLTypeLoader.parse(param1XMLStreamReader, e.type, null);
    }
    
    public static e a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (e)POIXMLTypeLoader.parse(param1XMLStreamReader, e.type, param1XmlOptions);
    }
    
    public static e a(Node param1Node) throws XmlException {
      return (e)POIXMLTypeLoader.parse(param1Node, e.type, null);
    }
    
    public static e a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (e)POIXMLTypeLoader.parse(param1Node, e.type, param1XmlOptions);
    }
    
    public static e a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (e)POIXMLTypeLoader.parse(param1XMLInputStream, e.type, null);
    }
    
    public static e a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (e)POIXMLTypeLoader.parse(param1XMLInputStream, e.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, e.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, e.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */