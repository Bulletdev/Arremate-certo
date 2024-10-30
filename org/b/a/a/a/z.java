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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface z extends l {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(z.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("xadestimestamptypeaedbtype");
  
  public static final class a {
    public static z e() {
      return (z)POIXMLTypeLoader.newInstance(z.type, null);
    }
    
    public static z a(XmlOptions param1XmlOptions) {
      return (z)POIXMLTypeLoader.newInstance(z.type, param1XmlOptions);
    }
    
    public static z a(String param1String) throws XmlException {
      return (z)POIXMLTypeLoader.parse(param1String, z.type, null);
    }
    
    public static z a(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (z)POIXMLTypeLoader.parse(param1String, z.type, param1XmlOptions);
    }
    
    public static z a(File param1File) throws XmlException, IOException {
      return (z)POIXMLTypeLoader.parse(param1File, z.type, null);
    }
    
    public static z a(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (z)POIXMLTypeLoader.parse(param1File, z.type, param1XmlOptions);
    }
    
    public static z a(URL param1URL) throws XmlException, IOException {
      return (z)POIXMLTypeLoader.parse(param1URL, z.type, null);
    }
    
    public static z a(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (z)POIXMLTypeLoader.parse(param1URL, z.type, param1XmlOptions);
    }
    
    public static z a(InputStream param1InputStream) throws XmlException, IOException {
      return (z)POIXMLTypeLoader.parse(param1InputStream, z.type, null);
    }
    
    public static z a(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (z)POIXMLTypeLoader.parse(param1InputStream, z.type, param1XmlOptions);
    }
    
    public static z a(Reader param1Reader) throws XmlException, IOException {
      return (z)POIXMLTypeLoader.parse(param1Reader, z.type, null);
    }
    
    public static z a(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (z)POIXMLTypeLoader.parse(param1Reader, z.type, param1XmlOptions);
    }
    
    public static z a(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (z)POIXMLTypeLoader.parse(param1XMLStreamReader, z.type, null);
    }
    
    public static z a(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (z)POIXMLTypeLoader.parse(param1XMLStreamReader, z.type, param1XmlOptions);
    }
    
    public static z a(Node param1Node) throws XmlException {
      return (z)POIXMLTypeLoader.parse(param1Node, z.type, null);
    }
    
    public static z a(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (z)POIXMLTypeLoader.parse(param1Node, z.type, param1XmlOptions);
    }
    
    public static z a(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (z)POIXMLTypeLoader.parse(param1XMLInputStream, z.type, null);
    }
    
    public static z a(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (z)POIXMLTypeLoader.parse(param1XMLInputStream, z.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, z.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, z.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */