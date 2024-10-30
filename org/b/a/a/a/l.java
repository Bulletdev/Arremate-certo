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
import org.etsi.uri.x01903.v13.IncludeType;
import org.etsi.uri.x01903.v13.ReferenceInfoType;
import org.w3c.dom.Node;

public interface l extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(l.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("generictimestamptypecdadtype");
  
  List<IncludeType> an();
  
  IncludeType[] a();
  
  IncludeType a(int paramInt);
  
  int sizeOfIncludeArray();
  
  void a(IncludeType[] paramArrayOfIncludeType);
  
  void a(int paramInt, IncludeType paramIncludeType);
  
  IncludeType b(int paramInt);
  
  IncludeType a();
  
  void removeInclude(int paramInt);
  
  List<ReferenceInfoType> ao();
  
  ReferenceInfoType[] a();
  
  ReferenceInfoType a(int paramInt);
  
  int bs();
  
  void a(ReferenceInfoType[] paramArrayOfReferenceInfoType);
  
  void a(int paramInt, ReferenceInfoType paramReferenceInfoType);
  
  ReferenceInfoType b(int paramInt);
  
  ReferenceInfoType a();
  
  void aZ(int paramInt);
  
  org.f.a.a.a.a a();
  
  boolean eC();
  
  void a(org.f.a.a.a.a parama);
  
  org.f.a.a.a.a b();
  
  void hs();
  
  List<k> ap();
  
  k[] c();
  
  k e(int paramInt);
  
  int bt();
  
  void c(k[] paramArrayOfk);
  
  void c(int paramInt, k paramk);
  
  k f(int paramInt);
  
  k d();
  
  void ba(int paramInt);
  
  List<AnyType> aq();
  
  AnyType[] b();
  
  AnyType c(int paramInt);
  
  int bu();
  
  void b(AnyType[] paramArrayOfAnyType);
  
  void b(int paramInt, AnyType paramAnyType);
  
  AnyType d(int paramInt);
  
  AnyType b();
  
  void bb(int paramInt);
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static l a() {
      return (l)POIXMLTypeLoader.newInstance(l.type, null);
    }
    
    public static l a(XmlOptions param1XmlOptions) {
      return (l)POIXMLTypeLoader.newInstance(l.type, param1XmlOptions);
    }
    
    public static l a(String param1String) throws XmlException {
      return (l)POIXMLTypeLoader.parse(param1String, l.type, null);
    }
    
    public static l a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (l)POIXMLTypeLoader.parse(param1String, l.type, param1XmlOptions);
    }
    
    public static l a(File param1File) throws XmlException, IOException {
      return (l)POIXMLTypeLoader.parse(param1File, l.type, null);
    }
    
    public static l a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (l)POIXMLTypeLoader.parse(param1File, l.type, param1XmlOptions);
    }
    
    public static l a(URL param1URL) throws XmlException, IOException {
      return (l)POIXMLTypeLoader.parse(param1URL, l.type, null);
    }
    
    public static l a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (l)POIXMLTypeLoader.parse(param1URL, l.type, param1XmlOptions);
    }
    
    public static l a(InputStream param1InputStream) throws XmlException, IOException {
      return (l)POIXMLTypeLoader.parse(param1InputStream, l.type, null);
    }
    
    public static l a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (l)POIXMLTypeLoader.parse(param1InputStream, l.type, param1XmlOptions);
    }
    
    public static l a(Reader param1Reader) throws XmlException, IOException {
      return (l)POIXMLTypeLoader.parse(param1Reader, l.type, null);
    }
    
    public static l a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (l)POIXMLTypeLoader.parse(param1Reader, l.type, param1XmlOptions);
    }
    
    public static l a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (l)POIXMLTypeLoader.parse(param1XMLStreamReader, l.type, null);
    }
    
    public static l a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (l)POIXMLTypeLoader.parse(param1XMLStreamReader, l.type, param1XmlOptions);
    }
    
    public static l a(Node param1Node) throws XmlException {
      return (l)POIXMLTypeLoader.parse(param1Node, l.type, null);
    }
    
    public static l a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (l)POIXMLTypeLoader.parse(param1Node, l.type, param1XmlOptions);
    }
    
    public static l a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (l)POIXMLTypeLoader.parse(param1XMLInputStream, l.type, null);
    }
    
    public static l a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (l)POIXMLTypeLoader.parse(param1XMLInputStream, l.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, l.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, l.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */