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

public interface CTEmptyElement extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTEmptyElement.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctemptyelement05catype");
  
  public static final class Factory {
    public static CTEmptyElement newInstance() {
      return (CTEmptyElement)POIXMLTypeLoader.newInstance(CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement newInstance(XmlOptions param1XmlOptions) {
      return (CTEmptyElement)POIXMLTypeLoader.newInstance(CTEmptyElement.type, param1XmlOptions);
    }
    
    public static CTEmptyElement parse(String param1String) throws XmlException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1String, CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1String, CTEmptyElement.type, param1XmlOptions);
    }
    
    public static CTEmptyElement parse(File param1File) throws XmlException, IOException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1File, CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1File, CTEmptyElement.type, param1XmlOptions);
    }
    
    public static CTEmptyElement parse(URL param1URL) throws XmlException, IOException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1URL, CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1URL, CTEmptyElement.type, param1XmlOptions);
    }
    
    public static CTEmptyElement parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1InputStream, CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1InputStream, CTEmptyElement.type, param1XmlOptions);
    }
    
    public static CTEmptyElement parse(Reader param1Reader) throws XmlException, IOException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1Reader, CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1Reader, CTEmptyElement.type, param1XmlOptions);
    }
    
    public static CTEmptyElement parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEmptyElement.type, param1XmlOptions);
    }
    
    public static CTEmptyElement parse(Node param1Node) throws XmlException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1Node, CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1Node, CTEmptyElement.type, param1XmlOptions);
    }
    
    public static CTEmptyElement parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1XMLInputStream, CTEmptyElement.type, null);
    }
    
    public static CTEmptyElement parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTEmptyElement)POIXMLTypeLoader.parse(param1XMLInputStream, CTEmptyElement.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEmptyElement.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEmptyElement.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTEmptyElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */