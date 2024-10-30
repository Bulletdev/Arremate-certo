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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.etsi.uri.x01903.v13.UnsignedDataObjectPropertiesType;
import org.w3c.dom.Node;

public interface x extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(x.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("unsignedpropertiestype49d6type");
  
  y a();
  
  boolean eU();
  
  void a(y paramy);
  
  y b();
  
  void hK();
  
  UnsignedDataObjectPropertiesType a();
  
  boolean eV();
  
  void a(UnsignedDataObjectPropertiesType paramUnsignedDataObjectPropertiesType);
  
  UnsignedDataObjectPropertiesType b();
  
  void hL();
  
  String getId();
  
  XmlID xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  void unsetId();
  
  public static final class a {
    public static x c() {
      return (x)POIXMLTypeLoader.newInstance(x.type, null);
    }
    
    public static x a(XmlOptions param1XmlOptions) {
      return (x)POIXMLTypeLoader.newInstance(x.type, param1XmlOptions);
    }
    
    public static x a(String param1String) throws XmlException {
      return (x)POIXMLTypeLoader.parse(param1String, x.type, null);
    }
    
    public static x a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (x)POIXMLTypeLoader.parse(param1String, x.type, param1XmlOptions);
    }
    
    public static x a(File param1File) throws XmlException, IOException {
      return (x)POIXMLTypeLoader.parse(param1File, x.type, null);
    }
    
    public static x a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (x)POIXMLTypeLoader.parse(param1File, x.type, param1XmlOptions);
    }
    
    public static x a(URL param1URL) throws XmlException, IOException {
      return (x)POIXMLTypeLoader.parse(param1URL, x.type, null);
    }
    
    public static x a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (x)POIXMLTypeLoader.parse(param1URL, x.type, param1XmlOptions);
    }
    
    public static x a(InputStream param1InputStream) throws XmlException, IOException {
      return (x)POIXMLTypeLoader.parse(param1InputStream, x.type, null);
    }
    
    public static x a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (x)POIXMLTypeLoader.parse(param1InputStream, x.type, param1XmlOptions);
    }
    
    public static x a(Reader param1Reader) throws XmlException, IOException {
      return (x)POIXMLTypeLoader.parse(param1Reader, x.type, null);
    }
    
    public static x a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (x)POIXMLTypeLoader.parse(param1Reader, x.type, param1XmlOptions);
    }
    
    public static x a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (x)POIXMLTypeLoader.parse(param1XMLStreamReader, x.type, null);
    }
    
    public static x a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (x)POIXMLTypeLoader.parse(param1XMLStreamReader, x.type, param1XmlOptions);
    }
    
    public static x a(Node param1Node) throws XmlException {
      return (x)POIXMLTypeLoader.parse(param1Node, x.type, null);
    }
    
    public static x a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (x)POIXMLTypeLoader.parse(param1Node, x.type, param1XmlOptions);
    }
    
    public static x a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (x)POIXMLTypeLoader.parse(param1XMLInputStream, x.type, null);
    }
    
    public static x a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (x)POIXMLTypeLoader.parse(param1XMLInputStream, x.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, x.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, x.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */