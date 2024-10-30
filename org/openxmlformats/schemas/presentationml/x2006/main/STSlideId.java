package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STSlideId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSlideId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stslideida0b3type");
  
  public static final class Factory {
    public static STSlideId newValue(Object param1Object) {
      return (STSlideId)STSlideId.type.newValue(param1Object);
    }
    
    public static STSlideId newInstance() {
      return (STSlideId)POIXMLTypeLoader.newInstance(STSlideId.type, null);
    }
    
    public static STSlideId newInstance(XmlOptions param1XmlOptions) {
      return (STSlideId)POIXMLTypeLoader.newInstance(STSlideId.type, param1XmlOptions);
    }
    
    public static STSlideId parse(String param1String) throws XmlException {
      return (STSlideId)POIXMLTypeLoader.parse(param1String, STSlideId.type, null);
    }
    
    public static STSlideId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideId)POIXMLTypeLoader.parse(param1String, STSlideId.type, param1XmlOptions);
    }
    
    public static STSlideId parse(File param1File) throws XmlException, IOException {
      return (STSlideId)POIXMLTypeLoader.parse(param1File, STSlideId.type, null);
    }
    
    public static STSlideId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideId)POIXMLTypeLoader.parse(param1File, STSlideId.type, param1XmlOptions);
    }
    
    public static STSlideId parse(URL param1URL) throws XmlException, IOException {
      return (STSlideId)POIXMLTypeLoader.parse(param1URL, STSlideId.type, null);
    }
    
    public static STSlideId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideId)POIXMLTypeLoader.parse(param1URL, STSlideId.type, param1XmlOptions);
    }
    
    public static STSlideId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSlideId)POIXMLTypeLoader.parse(param1InputStream, STSlideId.type, null);
    }
    
    public static STSlideId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideId)POIXMLTypeLoader.parse(param1InputStream, STSlideId.type, param1XmlOptions);
    }
    
    public static STSlideId parse(Reader param1Reader) throws XmlException, IOException {
      return (STSlideId)POIXMLTypeLoader.parse(param1Reader, STSlideId.type, null);
    }
    
    public static STSlideId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideId)POIXMLTypeLoader.parse(param1Reader, STSlideId.type, param1XmlOptions);
    }
    
    public static STSlideId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSlideId)POIXMLTypeLoader.parse(param1XMLStreamReader, STSlideId.type, null);
    }
    
    public static STSlideId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideId)POIXMLTypeLoader.parse(param1XMLStreamReader, STSlideId.type, param1XmlOptions);
    }
    
    public static STSlideId parse(Node param1Node) throws XmlException {
      return (STSlideId)POIXMLTypeLoader.parse(param1Node, STSlideId.type, null);
    }
    
    public static STSlideId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideId)POIXMLTypeLoader.parse(param1Node, STSlideId.type, param1XmlOptions);
    }
    
    public static STSlideId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSlideId)POIXMLTypeLoader.parse(param1XMLInputStream, STSlideId.type, null);
    }
    
    public static STSlideId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSlideId)POIXMLTypeLoader.parse(param1XMLInputStream, STSlideId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSlideId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSlideId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\STSlideId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */