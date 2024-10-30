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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTPivotCache extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPivotCache.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotcache4de9type");
  
  long getCacheId();
  
  XmlUnsignedInt xgetCacheId();
  
  void setCacheId(long paramLong);
  
  void xsetCacheId(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTPivotCache newInstance() {
      return (CTPivotCache)POIXMLTypeLoader.newInstance(CTPivotCache.type, null);
    }
    
    public static CTPivotCache newInstance(XmlOptions param1XmlOptions) {
      return (CTPivotCache)POIXMLTypeLoader.newInstance(CTPivotCache.type, param1XmlOptions);
    }
    
    public static CTPivotCache parse(String param1String) throws XmlException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1String, CTPivotCache.type, null);
    }
    
    public static CTPivotCache parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1String, CTPivotCache.type, param1XmlOptions);
    }
    
    public static CTPivotCache parse(File param1File) throws XmlException, IOException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1File, CTPivotCache.type, null);
    }
    
    public static CTPivotCache parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1File, CTPivotCache.type, param1XmlOptions);
    }
    
    public static CTPivotCache parse(URL param1URL) throws XmlException, IOException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1URL, CTPivotCache.type, null);
    }
    
    public static CTPivotCache parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1URL, CTPivotCache.type, param1XmlOptions);
    }
    
    public static CTPivotCache parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1InputStream, CTPivotCache.type, null);
    }
    
    public static CTPivotCache parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1InputStream, CTPivotCache.type, param1XmlOptions);
    }
    
    public static CTPivotCache parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1Reader, CTPivotCache.type, null);
    }
    
    public static CTPivotCache parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1Reader, CTPivotCache.type, param1XmlOptions);
    }
    
    public static CTPivotCache parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotCache.type, null);
    }
    
    public static CTPivotCache parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotCache.type, param1XmlOptions);
    }
    
    public static CTPivotCache parse(Node param1Node) throws XmlException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1Node, CTPivotCache.type, null);
    }
    
    public static CTPivotCache parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1Node, CTPivotCache.type, param1XmlOptions);
    }
    
    public static CTPivotCache parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotCache.type, null);
    }
    
    public static CTPivotCache parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPivotCache)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotCache.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotCache.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotCache.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPivotCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */