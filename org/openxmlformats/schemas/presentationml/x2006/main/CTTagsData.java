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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTTagsData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTagsData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttagsdatac662type");
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTTagsData newInstance() {
      return (CTTagsData)POIXMLTypeLoader.newInstance(CTTagsData.type, null);
    }
    
    public static CTTagsData newInstance(XmlOptions param1XmlOptions) {
      return (CTTagsData)POIXMLTypeLoader.newInstance(CTTagsData.type, param1XmlOptions);
    }
    
    public static CTTagsData parse(String param1String) throws XmlException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1String, CTTagsData.type, null);
    }
    
    public static CTTagsData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1String, CTTagsData.type, param1XmlOptions);
    }
    
    public static CTTagsData parse(File param1File) throws XmlException, IOException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1File, CTTagsData.type, null);
    }
    
    public static CTTagsData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1File, CTTagsData.type, param1XmlOptions);
    }
    
    public static CTTagsData parse(URL param1URL) throws XmlException, IOException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1URL, CTTagsData.type, null);
    }
    
    public static CTTagsData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1URL, CTTagsData.type, param1XmlOptions);
    }
    
    public static CTTagsData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1InputStream, CTTagsData.type, null);
    }
    
    public static CTTagsData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1InputStream, CTTagsData.type, param1XmlOptions);
    }
    
    public static CTTagsData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1Reader, CTTagsData.type, null);
    }
    
    public static CTTagsData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1Reader, CTTagsData.type, param1XmlOptions);
    }
    
    public static CTTagsData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTagsData.type, null);
    }
    
    public static CTTagsData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTagsData.type, param1XmlOptions);
    }
    
    public static CTTagsData parse(Node param1Node) throws XmlException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1Node, CTTagsData.type, null);
    }
    
    public static CTTagsData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1Node, CTTagsData.type, param1XmlOptions);
    }
    
    public static CTTagsData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1XMLInputStream, CTTagsData.type, null);
    }
    
    public static CTTagsData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTagsData)POIXMLTypeLoader.parse(param1XMLInputStream, CTTagsData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTagsData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTagsData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTTagsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */