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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPivotCaches extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPivotCaches.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotcaches4f32type");
  
  List<CTPivotCache> getPivotCacheList();
  
  CTPivotCache[] getPivotCacheArray();
  
  CTPivotCache getPivotCacheArray(int paramInt);
  
  int sizeOfPivotCacheArray();
  
  void setPivotCacheArray(CTPivotCache[] paramArrayOfCTPivotCache);
  
  void setPivotCacheArray(int paramInt, CTPivotCache paramCTPivotCache);
  
  CTPivotCache insertNewPivotCache(int paramInt);
  
  CTPivotCache addNewPivotCache();
  
  void removePivotCache(int paramInt);
  
  public static final class Factory {
    public static CTPivotCaches newInstance() {
      return (CTPivotCaches)POIXMLTypeLoader.newInstance(CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches newInstance(XmlOptions param1XmlOptions) {
      return (CTPivotCaches)POIXMLTypeLoader.newInstance(CTPivotCaches.type, param1XmlOptions);
    }
    
    public static CTPivotCaches parse(String param1String) throws XmlException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1String, CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1String, CTPivotCaches.type, param1XmlOptions);
    }
    
    public static CTPivotCaches parse(File param1File) throws XmlException, IOException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1File, CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1File, CTPivotCaches.type, param1XmlOptions);
    }
    
    public static CTPivotCaches parse(URL param1URL) throws XmlException, IOException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1URL, CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1URL, CTPivotCaches.type, param1XmlOptions);
    }
    
    public static CTPivotCaches parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1InputStream, CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1InputStream, CTPivotCaches.type, param1XmlOptions);
    }
    
    public static CTPivotCaches parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1Reader, CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1Reader, CTPivotCaches.type, param1XmlOptions);
    }
    
    public static CTPivotCaches parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotCaches.type, param1XmlOptions);
    }
    
    public static CTPivotCaches parse(Node param1Node) throws XmlException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1Node, CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1Node, CTPivotCaches.type, param1XmlOptions);
    }
    
    public static CTPivotCaches parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotCaches.type, null);
    }
    
    public static CTPivotCaches parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPivotCaches)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotCaches.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotCaches.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotCaches.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPivotCaches.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */