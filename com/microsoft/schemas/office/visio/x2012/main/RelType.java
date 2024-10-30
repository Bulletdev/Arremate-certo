package com.microsoft.schemas.office.visio.x2012.main;

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
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface RelType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(RelType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("reltype05f2type");
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static RelType newInstance() {
      return (RelType)POIXMLTypeLoader.newInstance(RelType.type, null);
    }
    
    public static RelType newInstance(XmlOptions param1XmlOptions) {
      return (RelType)POIXMLTypeLoader.newInstance(RelType.type, param1XmlOptions);
    }
    
    public static RelType parse(String param1String) throws XmlException {
      return (RelType)POIXMLTypeLoader.parse(param1String, RelType.type, null);
    }
    
    public static RelType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (RelType)POIXMLTypeLoader.parse(param1String, RelType.type, param1XmlOptions);
    }
    
    public static RelType parse(File param1File) throws XmlException, IOException {
      return (RelType)POIXMLTypeLoader.parse(param1File, RelType.type, null);
    }
    
    public static RelType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelType)POIXMLTypeLoader.parse(param1File, RelType.type, param1XmlOptions);
    }
    
    public static RelType parse(URL param1URL) throws XmlException, IOException {
      return (RelType)POIXMLTypeLoader.parse(param1URL, RelType.type, null);
    }
    
    public static RelType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelType)POIXMLTypeLoader.parse(param1URL, RelType.type, param1XmlOptions);
    }
    
    public static RelType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (RelType)POIXMLTypeLoader.parse(param1InputStream, RelType.type, null);
    }
    
    public static RelType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelType)POIXMLTypeLoader.parse(param1InputStream, RelType.type, param1XmlOptions);
    }
    
    public static RelType parse(Reader param1Reader) throws XmlException, IOException {
      return (RelType)POIXMLTypeLoader.parse(param1Reader, RelType.type, null);
    }
    
    public static RelType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelType)POIXMLTypeLoader.parse(param1Reader, RelType.type, param1XmlOptions);
    }
    
    public static RelType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (RelType)POIXMLTypeLoader.parse(param1XMLStreamReader, RelType.type, null);
    }
    
    public static RelType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (RelType)POIXMLTypeLoader.parse(param1XMLStreamReader, RelType.type, param1XmlOptions);
    }
    
    public static RelType parse(Node param1Node) throws XmlException {
      return (RelType)POIXMLTypeLoader.parse(param1Node, RelType.type, null);
    }
    
    public static RelType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (RelType)POIXMLTypeLoader.parse(param1Node, RelType.type, param1XmlOptions);
    }
    
    public static RelType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (RelType)POIXMLTypeLoader.parse(param1XMLInputStream, RelType.type, null);
    }
    
    public static RelType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (RelType)POIXMLTypeLoader.parse(param1XMLInputStream, RelType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, RelType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, RelType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\RelType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */