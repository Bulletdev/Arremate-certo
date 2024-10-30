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

public interface CTSlideIdList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlideIdList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslideidlist70a5type");
  
  List<CTSlideIdListEntry> getSldIdList();
  
  CTSlideIdListEntry[] getSldIdArray();
  
  CTSlideIdListEntry getSldIdArray(int paramInt);
  
  int sizeOfSldIdArray();
  
  void setSldIdArray(CTSlideIdListEntry[] paramArrayOfCTSlideIdListEntry);
  
  void setSldIdArray(int paramInt, CTSlideIdListEntry paramCTSlideIdListEntry);
  
  CTSlideIdListEntry insertNewSldId(int paramInt);
  
  CTSlideIdListEntry addNewSldId();
  
  void removeSldId(int paramInt);
  
  public static final class Factory {
    public static CTSlideIdList newInstance() {
      return (CTSlideIdList)POIXMLTypeLoader.newInstance(CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList newInstance(XmlOptions param1XmlOptions) {
      return (CTSlideIdList)POIXMLTypeLoader.newInstance(CTSlideIdList.type, param1XmlOptions);
    }
    
    public static CTSlideIdList parse(String param1String) throws XmlException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1String, CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1String, CTSlideIdList.type, param1XmlOptions);
    }
    
    public static CTSlideIdList parse(File param1File) throws XmlException, IOException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1File, CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1File, CTSlideIdList.type, param1XmlOptions);
    }
    
    public static CTSlideIdList parse(URL param1URL) throws XmlException, IOException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1URL, CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1URL, CTSlideIdList.type, param1XmlOptions);
    }
    
    public static CTSlideIdList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1InputStream, CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1InputStream, CTSlideIdList.type, param1XmlOptions);
    }
    
    public static CTSlideIdList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1Reader, CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1Reader, CTSlideIdList.type, param1XmlOptions);
    }
    
    public static CTSlideIdList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideIdList.type, param1XmlOptions);
    }
    
    public static CTSlideIdList parse(Node param1Node) throws XmlException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1Node, CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1Node, CTSlideIdList.type, param1XmlOptions);
    }
    
    public static CTSlideIdList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideIdList.type, null);
    }
    
    public static CTSlideIdList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlideIdList)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideIdList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideIdList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideIdList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlideIdList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */