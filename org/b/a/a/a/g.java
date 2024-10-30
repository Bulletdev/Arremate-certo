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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.etsi.uri.x01903.v13.AnyType;
import org.w3c.dom.Node;

public interface g extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(g.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("certificatevaluestype5c75type");
  
  List<k> al();
  
  k[] b();
  
  k c(int paramInt);
  
  int bq();
  
  void b(k[] paramArrayOfk);
  
  void b(int paramInt, k paramk);
  
  k d(int paramInt);
  
  k b();
  
  void aX(int paramInt);
  
  List<AnyType> am();
  
  AnyType[] a();
  
  AnyType a(int paramInt);
  
  int br();
  
  void a(AnyType[] paramArrayOfAnyType);
  
  void a(int paramInt, AnyType paramAnyType);
  
  AnyType b(int paramInt);
  
  AnyType a();
  
  void aY(int paramInt);
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static g a() {
      return (g)POIXMLTypeLoader.newInstance(g.type, null);
    }
    
    public static g a(XmlOptions param1XmlOptions) {
      return (g)POIXMLTypeLoader.newInstance(g.type, param1XmlOptions);
    }
    
    public static g a(String param1String) throws XmlException {
      return (g)POIXMLTypeLoader.parse(param1String, g.type, null);
    }
    
    public static g a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (g)POIXMLTypeLoader.parse(param1String, g.type, param1XmlOptions);
    }
    
    public static g a(File param1File) throws XmlException, IOException {
      return (g)POIXMLTypeLoader.parse(param1File, g.type, null);
    }
    
    public static g a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (g)POIXMLTypeLoader.parse(param1File, g.type, param1XmlOptions);
    }
    
    public static g a(URL param1URL) throws XmlException, IOException {
      return (g)POIXMLTypeLoader.parse(param1URL, g.type, null);
    }
    
    public static g a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (g)POIXMLTypeLoader.parse(param1URL, g.type, param1XmlOptions);
    }
    
    public static g a(InputStream param1InputStream) throws XmlException, IOException {
      return (g)POIXMLTypeLoader.parse(param1InputStream, g.type, null);
    }
    
    public static g a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (g)POIXMLTypeLoader.parse(param1InputStream, g.type, param1XmlOptions);
    }
    
    public static g a(Reader param1Reader) throws XmlException, IOException {
      return (g)POIXMLTypeLoader.parse(param1Reader, g.type, null);
    }
    
    public static g a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (g)POIXMLTypeLoader.parse(param1Reader, g.type, param1XmlOptions);
    }
    
    public static g a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (g)POIXMLTypeLoader.parse(param1XMLStreamReader, g.type, null);
    }
    
    public static g a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (g)POIXMLTypeLoader.parse(param1XMLStreamReader, g.type, param1XmlOptions);
    }
    
    public static g a(Node param1Node) throws XmlException {
      return (g)POIXMLTypeLoader.parse(param1Node, g.type, null);
    }
    
    public static g a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (g)POIXMLTypeLoader.parse(param1Node, g.type, param1XmlOptions);
    }
    
    public static g a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (g)POIXMLTypeLoader.parse(param1XMLInputStream, g.type, null);
    }
    
    public static g a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (g)POIXMLTypeLoader.parse(param1XMLInputStream, g.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, g.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, g.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */