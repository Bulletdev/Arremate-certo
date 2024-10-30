package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface STBorderId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STBorderId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stborderid1a80type");
  
  public static final class Factory {
    public static STBorderId newValue(Object param1Object) {
      return (STBorderId)STBorderId.type.newValue(param1Object);
    }
    
    public static STBorderId newInstance() {
      return (STBorderId)POIXMLTypeLoader.newInstance(STBorderId.type, null);
    }
    
    public static STBorderId newInstance(XmlOptions param1XmlOptions) {
      return (STBorderId)POIXMLTypeLoader.newInstance(STBorderId.type, param1XmlOptions);
    }
    
    public static STBorderId parse(String param1String) throws XmlException {
      return (STBorderId)POIXMLTypeLoader.parse(param1String, STBorderId.type, null);
    }
    
    public static STBorderId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STBorderId)POIXMLTypeLoader.parse(param1String, STBorderId.type, param1XmlOptions);
    }
    
    public static STBorderId parse(File param1File) throws XmlException, IOException {
      return (STBorderId)POIXMLTypeLoader.parse(param1File, STBorderId.type, null);
    }
    
    public static STBorderId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBorderId)POIXMLTypeLoader.parse(param1File, STBorderId.type, param1XmlOptions);
    }
    
    public static STBorderId parse(URL param1URL) throws XmlException, IOException {
      return (STBorderId)POIXMLTypeLoader.parse(param1URL, STBorderId.type, null);
    }
    
    public static STBorderId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBorderId)POIXMLTypeLoader.parse(param1URL, STBorderId.type, param1XmlOptions);
    }
    
    public static STBorderId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STBorderId)POIXMLTypeLoader.parse(param1InputStream, STBorderId.type, null);
    }
    
    public static STBorderId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBorderId)POIXMLTypeLoader.parse(param1InputStream, STBorderId.type, param1XmlOptions);
    }
    
    public static STBorderId parse(Reader param1Reader) throws XmlException, IOException {
      return (STBorderId)POIXMLTypeLoader.parse(param1Reader, STBorderId.type, null);
    }
    
    public static STBorderId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBorderId)POIXMLTypeLoader.parse(param1Reader, STBorderId.type, param1XmlOptions);
    }
    
    public static STBorderId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STBorderId)POIXMLTypeLoader.parse(param1XMLStreamReader, STBorderId.type, null);
    }
    
    public static STBorderId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STBorderId)POIXMLTypeLoader.parse(param1XMLStreamReader, STBorderId.type, param1XmlOptions);
    }
    
    public static STBorderId parse(Node param1Node) throws XmlException {
      return (STBorderId)POIXMLTypeLoader.parse(param1Node, STBorderId.type, null);
    }
    
    public static STBorderId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STBorderId)POIXMLTypeLoader.parse(param1Node, STBorderId.type, param1XmlOptions);
    }
    
    public static STBorderId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STBorderId)POIXMLTypeLoader.parse(param1XMLInputStream, STBorderId.type, null);
    }
    
    public static STBorderId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STBorderId)POIXMLTypeLoader.parse(param1XMLInputStream, STBorderId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBorderId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBorderId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STBorderId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */