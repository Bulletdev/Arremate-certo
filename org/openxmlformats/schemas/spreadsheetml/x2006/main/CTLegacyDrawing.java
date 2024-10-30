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

public interface CTLegacyDrawing extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLegacyDrawing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlegacydrawing49f4type");
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTLegacyDrawing newInstance() {
      return (CTLegacyDrawing)POIXMLTypeLoader.newInstance(CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing newInstance(XmlOptions param1XmlOptions) {
      return (CTLegacyDrawing)POIXMLTypeLoader.newInstance(CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static CTLegacyDrawing parse(String param1String) throws XmlException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1String, CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1String, CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static CTLegacyDrawing parse(File param1File) throws XmlException, IOException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1File, CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1File, CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static CTLegacyDrawing parse(URL param1URL) throws XmlException, IOException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1URL, CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1URL, CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static CTLegacyDrawing parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1InputStream, CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1InputStream, CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static CTLegacyDrawing parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1Reader, CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1Reader, CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static CTLegacyDrawing parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static CTLegacyDrawing parse(Node param1Node) throws XmlException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1Node, CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1Node, CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static CTLegacyDrawing parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1XMLInputStream, CTLegacyDrawing.type, null);
    }
    
    public static CTLegacyDrawing parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLegacyDrawing)POIXMLTypeLoader.parse(param1XMLInputStream, CTLegacyDrawing.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLegacyDrawing.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLegacyDrawing.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTLegacyDrawing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */