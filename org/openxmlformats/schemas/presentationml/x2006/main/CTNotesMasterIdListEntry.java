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

public interface CTNotesMasterIdListEntry extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNotesMasterIdListEntry.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnotesmasteridlistentry278ftype");
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTNotesMasterIdListEntry newInstance() {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.newInstance(CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry newInstance(XmlOptions param1XmlOptions) {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.newInstance(CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdListEntry parse(String param1String) throws XmlException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1String, CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1String, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdListEntry parse(File param1File) throws XmlException, IOException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1File, CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1File, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdListEntry parse(URL param1URL) throws XmlException, IOException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1URL, CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1URL, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdListEntry parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1InputStream, CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1InputStream, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdListEntry parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1Reader, CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1Reader, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdListEntry parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdListEntry parse(Node param1Node) throws XmlException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1Node, CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1Node, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdListEntry parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1XMLInputStream, CTNotesMasterIdListEntry.type, null);
    }
    
    public static CTNotesMasterIdListEntry parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNotesMasterIdListEntry)POIXMLTypeLoader.parse(param1XMLInputStream, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNotesMasterIdListEntry.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNotesMasterIdListEntry.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTNotesMasterIdListEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */