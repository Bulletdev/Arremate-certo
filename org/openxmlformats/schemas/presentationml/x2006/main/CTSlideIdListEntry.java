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

public interface CTSlideIdListEntry extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlideIdListEntry.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslideidlistentry427dtype");
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getId();
  
  STSlideId xgetId();
  
  void setId(long paramLong);
  
  void xsetId(STSlideId paramSTSlideId);
  
  String getId2();
  
  STRelationshipId xgetId2();
  
  void setId2(String paramString);
  
  void xsetId2(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTSlideIdListEntry newInstance() {
      return (CTSlideIdListEntry)POIXMLTypeLoader.newInstance(CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry newInstance(XmlOptions param1XmlOptions) {
      return (CTSlideIdListEntry)POIXMLTypeLoader.newInstance(CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideIdListEntry parse(String param1String) throws XmlException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1String, CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1String, CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideIdListEntry parse(File param1File) throws XmlException, IOException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1File, CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1File, CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideIdListEntry parse(URL param1URL) throws XmlException, IOException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1URL, CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1URL, CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideIdListEntry parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1InputStream, CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1InputStream, CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideIdListEntry parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1Reader, CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1Reader, CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideIdListEntry parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideIdListEntry parse(Node param1Node) throws XmlException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1Node, CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1Node, CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static CTSlideIdListEntry parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideIdListEntry.type, null);
    }
    
    public static CTSlideIdListEntry parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlideIdListEntry)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideIdListEntry.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideIdListEntry.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideIdListEntry.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlideIdListEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */