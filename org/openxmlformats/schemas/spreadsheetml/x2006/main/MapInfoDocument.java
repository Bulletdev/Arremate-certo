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
import org.w3c.dom.Node;

public interface MapInfoDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(MapInfoDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("mapinfo5715doctype");
  
  CTMapInfo getMapInfo();
  
  void setMapInfo(CTMapInfo paramCTMapInfo);
  
  CTMapInfo addNewMapInfo();
  
  public static final class Factory {
    public static MapInfoDocument newInstance() {
      return (MapInfoDocument)POIXMLTypeLoader.newInstance(MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument newInstance(XmlOptions param1XmlOptions) {
      return (MapInfoDocument)POIXMLTypeLoader.newInstance(MapInfoDocument.type, param1XmlOptions);
    }
    
    public static MapInfoDocument parse(String param1String) throws XmlException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1String, MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1String, MapInfoDocument.type, param1XmlOptions);
    }
    
    public static MapInfoDocument parse(File param1File) throws XmlException, IOException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1File, MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1File, MapInfoDocument.type, param1XmlOptions);
    }
    
    public static MapInfoDocument parse(URL param1URL) throws XmlException, IOException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1URL, MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1URL, MapInfoDocument.type, param1XmlOptions);
    }
    
    public static MapInfoDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1InputStream, MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1InputStream, MapInfoDocument.type, param1XmlOptions);
    }
    
    public static MapInfoDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1Reader, MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1Reader, MapInfoDocument.type, param1XmlOptions);
    }
    
    public static MapInfoDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, MapInfoDocument.type, param1XmlOptions);
    }
    
    public static MapInfoDocument parse(Node param1Node) throws XmlException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1Node, MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1Node, MapInfoDocument.type, param1XmlOptions);
    }
    
    public static MapInfoDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1XMLInputStream, MapInfoDocument.type, null);
    }
    
    public static MapInfoDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (MapInfoDocument)POIXMLTypeLoader.parse(param1XMLInputStream, MapInfoDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MapInfoDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MapInfoDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\MapInfoDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */