package org.openxmlformats.schemas.officeDocument.x2006.relationships;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STRelationshipId extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STRelationshipId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("strelationshipid1e94type");
  
  public static final class Factory {
    public static STRelationshipId newValue(Object param1Object) {
      return (STRelationshipId)STRelationshipId.type.newValue(param1Object);
    }
    
    public static STRelationshipId newInstance() {
      return (STRelationshipId)POIXMLTypeLoader.newInstance(STRelationshipId.type, null);
    }
    
    public static STRelationshipId newInstance(XmlOptions param1XmlOptions) {
      return (STRelationshipId)POIXMLTypeLoader.newInstance(STRelationshipId.type, param1XmlOptions);
    }
    
    public static STRelationshipId parse(String param1String) throws XmlException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1String, STRelationshipId.type, null);
    }
    
    public static STRelationshipId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1String, STRelationshipId.type, param1XmlOptions);
    }
    
    public static STRelationshipId parse(File param1File) throws XmlException, IOException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1File, STRelationshipId.type, null);
    }
    
    public static STRelationshipId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1File, STRelationshipId.type, param1XmlOptions);
    }
    
    public static STRelationshipId parse(URL param1URL) throws XmlException, IOException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1URL, STRelationshipId.type, null);
    }
    
    public static STRelationshipId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1URL, STRelationshipId.type, param1XmlOptions);
    }
    
    public static STRelationshipId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1InputStream, STRelationshipId.type, null);
    }
    
    public static STRelationshipId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1InputStream, STRelationshipId.type, param1XmlOptions);
    }
    
    public static STRelationshipId parse(Reader param1Reader) throws XmlException, IOException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1Reader, STRelationshipId.type, null);
    }
    
    public static STRelationshipId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1Reader, STRelationshipId.type, param1XmlOptions);
    }
    
    public static STRelationshipId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1XMLStreamReader, STRelationshipId.type, null);
    }
    
    public static STRelationshipId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1XMLStreamReader, STRelationshipId.type, param1XmlOptions);
    }
    
    public static STRelationshipId parse(Node param1Node) throws XmlException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1Node, STRelationshipId.type, null);
    }
    
    public static STRelationshipId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1Node, STRelationshipId.type, param1XmlOptions);
    }
    
    public static STRelationshipId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1XMLInputStream, STRelationshipId.type, null);
    }
    
    public static STRelationshipId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STRelationshipId)POIXMLTypeLoader.parse(param1XMLInputStream, STRelationshipId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STRelationshipId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STRelationshipId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\relationships\STRelationshipId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */