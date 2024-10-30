package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTMapInfo extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMapInfo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmapinfo1a09type");
  
  List<CTSchema> getSchemaList();
  
  CTSchema[] getSchemaArray();
  
  CTSchema getSchemaArray(int paramInt);
  
  int sizeOfSchemaArray();
  
  void setSchemaArray(CTSchema[] paramArrayOfCTSchema);
  
  void setSchemaArray(int paramInt, CTSchema paramCTSchema);
  
  CTSchema insertNewSchema(int paramInt);
  
  CTSchema addNewSchema();
  
  void removeSchema(int paramInt);
  
  List<CTMap> getMapList();
  
  CTMap[] getMapArray();
  
  CTMap getMapArray(int paramInt);
  
  int sizeOfMapArray();
  
  void setMapArray(CTMap[] paramArrayOfCTMap);
  
  void setMapArray(int paramInt, CTMap paramCTMap);
  
  CTMap insertNewMap(int paramInt);
  
  CTMap addNewMap();
  
  void removeMap(int paramInt);
  
  String getSelectionNamespaces();
  
  XmlString xgetSelectionNamespaces();
  
  void setSelectionNamespaces(String paramString);
  
  void xsetSelectionNamespaces(XmlString paramXmlString);
  
  public static final class Factory {
    public static CTMapInfo newInstance() {
      return (CTMapInfo)POIXMLTypeLoader.newInstance(CTMapInfo.type, null);
    }
    
    public static CTMapInfo newInstance(XmlOptions param1XmlOptions) {
      return (CTMapInfo)POIXMLTypeLoader.newInstance(CTMapInfo.type, param1XmlOptions);
    }
    
    public static CTMapInfo parse(String param1String) throws XmlException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1String, CTMapInfo.type, null);
    }
    
    public static CTMapInfo parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1String, CTMapInfo.type, param1XmlOptions);
    }
    
    public static CTMapInfo parse(File param1File) throws XmlException, IOException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1File, CTMapInfo.type, null);
    }
    
    public static CTMapInfo parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1File, CTMapInfo.type, param1XmlOptions);
    }
    
    public static CTMapInfo parse(URL param1URL) throws XmlException, IOException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1URL, CTMapInfo.type, null);
    }
    
    public static CTMapInfo parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1URL, CTMapInfo.type, param1XmlOptions);
    }
    
    public static CTMapInfo parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1InputStream, CTMapInfo.type, null);
    }
    
    public static CTMapInfo parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1InputStream, CTMapInfo.type, param1XmlOptions);
    }
    
    public static CTMapInfo parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1Reader, CTMapInfo.type, null);
    }
    
    public static CTMapInfo parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1Reader, CTMapInfo.type, param1XmlOptions);
    }
    
    public static CTMapInfo parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMapInfo.type, null);
    }
    
    public static CTMapInfo parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMapInfo.type, param1XmlOptions);
    }
    
    public static CTMapInfo parse(Node param1Node) throws XmlException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1Node, CTMapInfo.type, null);
    }
    
    public static CTMapInfo parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1Node, CTMapInfo.type, param1XmlOptions);
    }
    
    public static CTMapInfo parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1XMLInputStream, CTMapInfo.type, null);
    }
    
    public static CTMapInfo parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMapInfo)POIXMLTypeLoader.parse(param1XMLInputStream, CTMapInfo.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMapInfo.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMapInfo.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTMapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */