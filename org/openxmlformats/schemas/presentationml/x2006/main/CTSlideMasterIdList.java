package org.openxmlformats.schemas.presentationml.x2006.main;

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

public interface CTSlideMasterIdList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlideMasterIdList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidemasteridlist0b63type");
  
  List<CTSlideMasterIdListEntry> getSldMasterIdList();
  
  CTSlideMasterIdListEntry[] getSldMasterIdArray();
  
  CTSlideMasterIdListEntry getSldMasterIdArray(int paramInt);
  
  int sizeOfSldMasterIdArray();
  
  void setSldMasterIdArray(CTSlideMasterIdListEntry[] paramArrayOfCTSlideMasterIdListEntry);
  
  void setSldMasterIdArray(int paramInt, CTSlideMasterIdListEntry paramCTSlideMasterIdListEntry);
  
  CTSlideMasterIdListEntry insertNewSldMasterId(int paramInt);
  
  CTSlideMasterIdListEntry addNewSldMasterId();
  
  void removeSldMasterId(int paramInt);
  
  public static final class Factory {
    public static CTSlideMasterIdList newInstance() {
      return (CTSlideMasterIdList)POIXMLTypeLoader.newInstance(CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList newInstance(XmlOptions param1XmlOptions) {
      return (CTSlideMasterIdList)POIXMLTypeLoader.newInstance(CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdList parse(String param1String) throws XmlException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1String, CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1String, CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdList parse(File param1File) throws XmlException, IOException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1File, CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1File, CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdList parse(URL param1URL) throws XmlException, IOException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1URL, CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1URL, CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1InputStream, CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1InputStream, CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1Reader, CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1Reader, CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdList parse(Node param1Node) throws XmlException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1Node, CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1Node, CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static CTSlideMasterIdList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideMasterIdList.type, null);
    }
    
    public static CTSlideMasterIdList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlideMasterIdList)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideMasterIdList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideMasterIdList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideMasterIdList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlideMasterIdList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */