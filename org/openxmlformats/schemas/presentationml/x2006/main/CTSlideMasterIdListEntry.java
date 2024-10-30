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

public interface CTSlideMasterIdListEntry extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlideMasterIdListEntry.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidemasteridlistentryae7ftype");
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getId();
  
  STSlideMasterId xgetId();
  
  boolean isSetId();
  
  void setId(long paramLong);
  
  void xsetId(STSlideMasterId paramSTSlideMasterId);
  
  void unsetId();
  
  String getId2();
  
  STRelationshipId xgetId2();
  
  void setId2(String paramString);
  
  void xsetId2(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTSlideMasterIdListEntry newInstance() {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.newInstance(CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry newInstance(XmlOptions param1XmlOptions) {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.newInstance(CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdListEntry parse(String param1String) throws XmlException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1String, CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1String, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdListEntry parse(File param1File) throws XmlException, IOException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1File, CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1File, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdListEntry parse(URL param1URL) throws XmlException, IOException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1URL, CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1URL, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdListEntry parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1InputStream, CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1InputStream, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdListEntry parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1Reader, CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1Reader, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdListEntry parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdListEntry parse(Node param1Node) throws XmlException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1Node, CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1Node, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdListEntry parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideMasterIdListEntry.type, null);
    }
    
    public static CTSlideMasterIdListEntry parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlideMasterIdListEntry)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideMasterIdListEntry.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideMasterIdListEntry.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlideMasterIdListEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */