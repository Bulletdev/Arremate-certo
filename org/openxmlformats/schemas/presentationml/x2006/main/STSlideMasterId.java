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

public interface STSlideMasterId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSlideMasterId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stslidemasteridfe71type");
  
  public static final class Factory {
    public static STSlideMasterId newValue(Object param1Object) {
      return (STSlideMasterId)STSlideMasterId.type.newValue(param1Object);
    }
    
    public static STSlideMasterId newInstance() {
      return (STSlideMasterId)POIXMLTypeLoader.newInstance(STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId newInstance(XmlOptions param1XmlOptions) {
      return (STSlideMasterId)POIXMLTypeLoader.newInstance(STSlideMasterId.type, param1XmlOptions);
    }
    
    public static STSlideMasterId parse(String param1String) throws XmlException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1String, STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1String, STSlideMasterId.type, param1XmlOptions);
    }
    
    public static STSlideMasterId parse(File param1File) throws XmlException, IOException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1File, STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1File, STSlideMasterId.type, param1XmlOptions);
    }
    
    public static STSlideMasterId parse(URL param1URL) throws XmlException, IOException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1URL, STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1URL, STSlideMasterId.type, param1XmlOptions);
    }
    
    public static STSlideMasterId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1InputStream, STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1InputStream, STSlideMasterId.type, param1XmlOptions);
    }
    
    public static STSlideMasterId parse(Reader param1Reader) throws XmlException, IOException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1Reader, STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1Reader, STSlideMasterId.type, param1XmlOptions);
    }
    
    public static STSlideMasterId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1XMLStreamReader, STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1XMLStreamReader, STSlideMasterId.type, param1XmlOptions);
    }
    
    public static STSlideMasterId parse(Node param1Node) throws XmlException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1Node, STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1Node, STSlideMasterId.type, param1XmlOptions);
    }
    
    public static STSlideMasterId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1XMLInputStream, STSlideMasterId.type, null);
    }
    
    public static STSlideMasterId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSlideMasterId)POIXMLTypeLoader.parse(param1XMLInputStream, STSlideMasterId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSlideMasterId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSlideMasterId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\STSlideMasterId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */