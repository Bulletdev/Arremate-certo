package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTNoFillProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNoFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnofillpropertiesbf92type");
  
  public static final class Factory {
    public static CTNoFillProperties newInstance() {
      return (CTNoFillProperties)POIXMLTypeLoader.newInstance(CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTNoFillProperties)POIXMLTypeLoader.newInstance(CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static CTNoFillProperties parse(String param1String) throws XmlException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1String, CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1String, CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static CTNoFillProperties parse(File param1File) throws XmlException, IOException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1File, CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1File, CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static CTNoFillProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1URL, CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1URL, CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static CTNoFillProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static CTNoFillProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1Reader, CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1Reader, CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static CTNoFillProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static CTNoFillProperties parse(Node param1Node) throws XmlException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1Node, CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1Node, CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static CTNoFillProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTNoFillProperties.type, null);
    }
    
    public static CTNoFillProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNoFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTNoFillProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNoFillProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNoFillProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTNoFillProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */