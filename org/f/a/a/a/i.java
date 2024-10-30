package org.f.a.a.a;

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

public interface i extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(i.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("transforme335doctype");
  
  j a();
  
  void a(j paramj);
  
  j b();
  
  public static final class a {
    public static i a() {
      return (i)POIXMLTypeLoader.newInstance(i.type, null);
    }
    
    public static i a(XmlOptions param1XmlOptions) {
      return (i)POIXMLTypeLoader.newInstance(i.type, param1XmlOptions);
    }
    
    public static i a(String param1String) throws XmlException {
      return (i)POIXMLTypeLoader.parse(param1String, i.type, null);
    }
    
    public static i a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (i)POIXMLTypeLoader.parse(param1String, i.type, param1XmlOptions);
    }
    
    public static i a(File param1File) throws XmlException, IOException {
      return (i)POIXMLTypeLoader.parse(param1File, i.type, null);
    }
    
    public static i a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (i)POIXMLTypeLoader.parse(param1File, i.type, param1XmlOptions);
    }
    
    public static i a(URL param1URL) throws XmlException, IOException {
      return (i)POIXMLTypeLoader.parse(param1URL, i.type, null);
    }
    
    public static i a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (i)POIXMLTypeLoader.parse(param1URL, i.type, param1XmlOptions);
    }
    
    public static i a(InputStream param1InputStream) throws XmlException, IOException {
      return (i)POIXMLTypeLoader.parse(param1InputStream, i.type, null);
    }
    
    public static i a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (i)POIXMLTypeLoader.parse(param1InputStream, i.type, param1XmlOptions);
    }
    
    public static i a(Reader param1Reader) throws XmlException, IOException {
      return (i)POIXMLTypeLoader.parse(param1Reader, i.type, null);
    }
    
    public static i a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (i)POIXMLTypeLoader.parse(param1Reader, i.type, param1XmlOptions);
    }
    
    public static i a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (i)POIXMLTypeLoader.parse(param1XMLStreamReader, i.type, null);
    }
    
    public static i a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (i)POIXMLTypeLoader.parse(param1XMLStreamReader, i.type, param1XmlOptions);
    }
    
    public static i a(Node param1Node) throws XmlException {
      return (i)POIXMLTypeLoader.parse(param1Node, i.type, null);
    }
    
    public static i a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (i)POIXMLTypeLoader.parse(param1Node, i.type, param1XmlOptions);
    }
    
    public static i a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (i)POIXMLTypeLoader.parse(param1XMLInputStream, i.type, null);
    }
    
    public static i a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (i)POIXMLTypeLoader.parse(param1XMLInputStream, i.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, i.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, i.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */