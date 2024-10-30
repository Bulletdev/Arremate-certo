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
import org.etsi.uri.x01903.v13.CounterSignatureType;
import org.w3c.dom.Node;

public interface y extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(y.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("unsignedsignaturepropertiestypecf32type");
  
  List<CounterSignatureType> at();
  
  CounterSignatureType[] a();
  
  CounterSignatureType a(int paramInt);
  
  int bx();
  
  void a(CounterSignatureType[] paramArrayOfCounterSignatureType);
  
  void a(int paramInt, CounterSignatureType paramCounterSignatureType);
  
  CounterSignatureType b(int paramInt);
  
  CounterSignatureType a();
  
  void be(int paramInt);
  
  List<z> au();
  
  z[] a();
  
  z a(int paramInt);
  
  int by();
  
  void a(z[] paramArrayOfz);
  
  void a(int paramInt, z paramz);
  
  z b(int paramInt);
  
  z a();
  
  void bf(int paramInt);
  
  List<h> av();
  
  h[] a();
  
  h a(int paramInt);
  
  int bz();
  
  void a(h[] paramArrayOfh);
  
  void a(int paramInt, h paramh);
  
  h b(int paramInt);
  
  h b();
  
  void bg(int paramInt);
  
  List<i> aw();
  
  i[] a();
  
  i a(int paramInt);
  
  int bA();
  
  void a(i[] paramArrayOfi);
  
  void a(int paramInt, i parami);
  
  i b(int paramInt);
  
  i b();
  
  void bh(int paramInt);
  
  List<h> ax();
  
  h[] b();
  
  h c(int paramInt);
  
  int bB();
  
  void b(h[] paramArrayOfh);
  
  void b(int paramInt, h paramh);
  
  h d(int paramInt);
  
  h c();
  
  void bi(int paramInt);
  
  List<i> ay();
  
  i[] b();
  
  i c(int paramInt);
  
  int bC();
  
  void b(i[] paramArrayOfi);
  
  void b(int paramInt, i parami);
  
  i d(int paramInt);
  
  i c();
  
  void bj(int paramInt);
  
  List<z> az();
  
  z[] b();
  
  z c(int paramInt);
  
  int bD();
  
  void b(z[] paramArrayOfz);
  
  void b(int paramInt, z paramz);
  
  z d(int paramInt);
  
  z b();
  
  void bk(int paramInt);
  
  List<z> aA();
  
  z[] c();
  
  z e(int paramInt);
  
  int bE();
  
  void c(z[] paramArrayOfz);
  
  void c(int paramInt, z paramz);
  
  z f(int paramInt);
  
  z c();
  
  void bl(int paramInt);
  
  List<g> aB();
  
  g[] a();
  
  g a(int paramInt);
  
  int bF();
  
  void a(g[] paramArrayOfg);
  
  void a(int paramInt, g paramg);
  
  g b(int paramInt);
  
  g b();
  
  void bm(int paramInt);
  
  List<t> aC();
  
  t[] a();
  
  t a(int paramInt);
  
  int bG();
  
  void a(t[] paramArrayOft);
  
  void a(int paramInt, t paramt);
  
  t b(int paramInt);
  
  t b();
  
  void bn(int paramInt);
  
  List<g> aD();
  
  g[] b();
  
  g c(int paramInt);
  
  int bH();
  
  void b(g[] paramArrayOfg);
  
  void b(int paramInt, g paramg);
  
  g d(int paramInt);
  
  g c();
  
  void bo(int paramInt);
  
  List<t> aE();
  
  t[] b();
  
  t c(int paramInt);
  
  int bI();
  
  void b(t[] paramArrayOft);
  
  void b(int paramInt, t paramt);
  
  t d(int paramInt);
  
  t c();
  
  void bp(int paramInt);
  
  List<z> aF();
  
  z[] d();
  
  z g(int paramInt);
  
  int bJ();
  
  void d(z[] paramArrayOfz);
  
  void d(int paramInt, z paramz);
  
  z h(int paramInt);
  
  z d();
  
  void bq(int paramInt);
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static y c() {
      return (y)POIXMLTypeLoader.newInstance(y.type, null);
    }
    
    public static y a(XmlOptions param1XmlOptions) {
      return (y)POIXMLTypeLoader.newInstance(y.type, param1XmlOptions);
    }
    
    public static y a(String param1String) throws XmlException {
      return (y)POIXMLTypeLoader.parse(param1String, y.type, null);
    }
    
    public static y a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (y)POIXMLTypeLoader.parse(param1String, y.type, param1XmlOptions);
    }
    
    public static y a(File param1File) throws XmlException, IOException {
      return (y)POIXMLTypeLoader.parse(param1File, y.type, null);
    }
    
    public static y a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (y)POIXMLTypeLoader.parse(param1File, y.type, param1XmlOptions);
    }
    
    public static y a(URL param1URL) throws XmlException, IOException {
      return (y)POIXMLTypeLoader.parse(param1URL, y.type, null);
    }
    
    public static y a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (y)POIXMLTypeLoader.parse(param1URL, y.type, param1XmlOptions);
    }
    
    public static y a(InputStream param1InputStream) throws XmlException, IOException {
      return (y)POIXMLTypeLoader.parse(param1InputStream, y.type, null);
    }
    
    public static y a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (y)POIXMLTypeLoader.parse(param1InputStream, y.type, param1XmlOptions);
    }
    
    public static y a(Reader param1Reader) throws XmlException, IOException {
      return (y)POIXMLTypeLoader.parse(param1Reader, y.type, null);
    }
    
    public static y a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (y)POIXMLTypeLoader.parse(param1Reader, y.type, param1XmlOptions);
    }
    
    public static y a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (y)POIXMLTypeLoader.parse(param1XMLStreamReader, y.type, null);
    }
    
    public static y a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (y)POIXMLTypeLoader.parse(param1XMLStreamReader, y.type, param1XmlOptions);
    }
    
    public static y a(Node param1Node) throws XmlException {
      return (y)POIXMLTypeLoader.parse(param1Node, y.type, null);
    }
    
    public static y a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (y)POIXMLTypeLoader.parse(param1Node, y.type, param1XmlOptions);
    }
    
    public static y a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (y)POIXMLTypeLoader.parse(param1XMLInputStream, y.type, null);
    }
    
    public static y a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (y)POIXMLTypeLoader.parse(param1XMLInputStream, y.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, y.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, y.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */