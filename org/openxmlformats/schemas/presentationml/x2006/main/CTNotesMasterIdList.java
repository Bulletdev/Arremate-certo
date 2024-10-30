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
import org.w3c.dom.Node;

public interface CTNotesMasterIdList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNotesMasterIdList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnotesmasteridlist2853type");
  
  CTNotesMasterIdListEntry getNotesMasterId();
  
  boolean isSetNotesMasterId();
  
  void setNotesMasterId(CTNotesMasterIdListEntry paramCTNotesMasterIdListEntry);
  
  CTNotesMasterIdListEntry addNewNotesMasterId();
  
  void unsetNotesMasterId();
  
  public static final class Factory {
    public static CTNotesMasterIdList newInstance() {
      return (CTNotesMasterIdList)POIXMLTypeLoader.newInstance(CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList newInstance(XmlOptions param1XmlOptions) {
      return (CTNotesMasterIdList)POIXMLTypeLoader.newInstance(CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdList parse(String param1String) throws XmlException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1String, CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1String, CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdList parse(File param1File) throws XmlException, IOException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1File, CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1File, CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdList parse(URL param1URL) throws XmlException, IOException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1URL, CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1URL, CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1InputStream, CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1InputStream, CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1Reader, CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1Reader, CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdList parse(Node param1Node) throws XmlException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1Node, CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1Node, CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static CTNotesMasterIdList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1XMLInputStream, CTNotesMasterIdList.type, null);
    }
    
    public static CTNotesMasterIdList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNotesMasterIdList)POIXMLTypeLoader.parse(param1XMLInputStream, CTNotesMasterIdList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNotesMasterIdList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNotesMasterIdList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTNotesMasterIdList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */