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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTExternalReference extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTExternalReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternalreference945ftype");
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTExternalReference newInstance() {
      return (CTExternalReference)POIXMLTypeLoader.newInstance(CTExternalReference.type, null);
    }
    
    public static CTExternalReference newInstance(XmlOptions param1XmlOptions) {
      return (CTExternalReference)POIXMLTypeLoader.newInstance(CTExternalReference.type, param1XmlOptions);
    }
    
    public static CTExternalReference parse(String param1String) throws XmlException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1String, CTExternalReference.type, null);
    }
    
    public static CTExternalReference parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1String, CTExternalReference.type, param1XmlOptions);
    }
    
    public static CTExternalReference parse(File param1File) throws XmlException, IOException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1File, CTExternalReference.type, null);
    }
    
    public static CTExternalReference parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1File, CTExternalReference.type, param1XmlOptions);
    }
    
    public static CTExternalReference parse(URL param1URL) throws XmlException, IOException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1URL, CTExternalReference.type, null);
    }
    
    public static CTExternalReference parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1URL, CTExternalReference.type, param1XmlOptions);
    }
    
    public static CTExternalReference parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1InputStream, CTExternalReference.type, null);
    }
    
    public static CTExternalReference parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1InputStream, CTExternalReference.type, param1XmlOptions);
    }
    
    public static CTExternalReference parse(Reader param1Reader) throws XmlException, IOException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1Reader, CTExternalReference.type, null);
    }
    
    public static CTExternalReference parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1Reader, CTExternalReference.type, param1XmlOptions);
    }
    
    public static CTExternalReference parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalReference.type, null);
    }
    
    public static CTExternalReference parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalReference.type, param1XmlOptions);
    }
    
    public static CTExternalReference parse(Node param1Node) throws XmlException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1Node, CTExternalReference.type, null);
    }
    
    public static CTExternalReference parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1Node, CTExternalReference.type, param1XmlOptions);
    }
    
    public static CTExternalReference parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalReference.type, null);
    }
    
    public static CTExternalReference parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTExternalReference)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalReference.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalReference.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalReference.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTExternalReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */