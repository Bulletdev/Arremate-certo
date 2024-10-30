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
import org.w3c.dom.Node;

public interface CTCacheSource extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCacheSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcachesource00dctype");
  
  CTWorksheetSource getWorksheetSource();
  
  boolean isSetWorksheetSource();
  
  void setWorksheetSource(CTWorksheetSource paramCTWorksheetSource);
  
  CTWorksheetSource addNewWorksheetSource();
  
  void unsetWorksheetSource();
  
  CTConsolidation getConsolidation();
  
  boolean isSetConsolidation();
  
  void setConsolidation(CTConsolidation paramCTConsolidation);
  
  CTConsolidation addNewConsolidation();
  
  void unsetConsolidation();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  STSourceType.Enum getType();
  
  STSourceType xgetType();
  
  void setType(STSourceType.Enum paramEnum);
  
  void xsetType(STSourceType paramSTSourceType);
  
  long getConnectionId();
  
  XmlUnsignedInt xgetConnectionId();
  
  boolean isSetConnectionId();
  
  void setConnectionId(long paramLong);
  
  void xsetConnectionId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetConnectionId();
  
  public static final class Factory {
    public static CTCacheSource newInstance() {
      return (CTCacheSource)POIXMLTypeLoader.newInstance(CTCacheSource.type, null);
    }
    
    public static CTCacheSource newInstance(XmlOptions param1XmlOptions) {
      return (CTCacheSource)POIXMLTypeLoader.newInstance(CTCacheSource.type, param1XmlOptions);
    }
    
    public static CTCacheSource parse(String param1String) throws XmlException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1String, CTCacheSource.type, null);
    }
    
    public static CTCacheSource parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1String, CTCacheSource.type, param1XmlOptions);
    }
    
    public static CTCacheSource parse(File param1File) throws XmlException, IOException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1File, CTCacheSource.type, null);
    }
    
    public static CTCacheSource parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1File, CTCacheSource.type, param1XmlOptions);
    }
    
    public static CTCacheSource parse(URL param1URL) throws XmlException, IOException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1URL, CTCacheSource.type, null);
    }
    
    public static CTCacheSource parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1URL, CTCacheSource.type, param1XmlOptions);
    }
    
    public static CTCacheSource parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1InputStream, CTCacheSource.type, null);
    }
    
    public static CTCacheSource parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1InputStream, CTCacheSource.type, param1XmlOptions);
    }
    
    public static CTCacheSource parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1Reader, CTCacheSource.type, null);
    }
    
    public static CTCacheSource parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1Reader, CTCacheSource.type, param1XmlOptions);
    }
    
    public static CTCacheSource parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCacheSource.type, null);
    }
    
    public static CTCacheSource parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCacheSource.type, param1XmlOptions);
    }
    
    public static CTCacheSource parse(Node param1Node) throws XmlException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1Node, CTCacheSource.type, null);
    }
    
    public static CTCacheSource parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1Node, CTCacheSource.type, param1XmlOptions);
    }
    
    public static CTCacheSource parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1XMLInputStream, CTCacheSource.type, null);
    }
    
    public static CTCacheSource parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCacheSource)POIXMLTypeLoader.parse(param1XMLInputStream, CTCacheSource.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCacheSource.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCacheSource.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCacheSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */