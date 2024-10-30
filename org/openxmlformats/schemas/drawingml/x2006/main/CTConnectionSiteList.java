package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTConnectionSiteList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTConnectionSiteList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctconnectionsitelistab9etype");
  
  List<CTConnectionSite> getCxnList();
  
  CTConnectionSite[] getCxnArray();
  
  CTConnectionSite getCxnArray(int paramInt);
  
  int sizeOfCxnArray();
  
  void setCxnArray(CTConnectionSite[] paramArrayOfCTConnectionSite);
  
  void setCxnArray(int paramInt, CTConnectionSite paramCTConnectionSite);
  
  CTConnectionSite insertNewCxn(int paramInt);
  
  CTConnectionSite addNewCxn();
  
  void removeCxn(int paramInt);
  
  public static final class Factory {
    public static CTConnectionSiteList newInstance() {
      return (CTConnectionSiteList)POIXMLTypeLoader.newInstance(CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList newInstance(XmlOptions param1XmlOptions) {
      return (CTConnectionSiteList)POIXMLTypeLoader.newInstance(CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static CTConnectionSiteList parse(String param1String) throws XmlException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1String, CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1String, CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static CTConnectionSiteList parse(File param1File) throws XmlException, IOException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1File, CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1File, CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static CTConnectionSiteList parse(URL param1URL) throws XmlException, IOException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1URL, CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1URL, CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static CTConnectionSiteList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1InputStream, CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1InputStream, CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static CTConnectionSiteList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1Reader, CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1Reader, CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static CTConnectionSiteList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static CTConnectionSiteList parse(Node param1Node) throws XmlException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1Node, CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1Node, CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static CTConnectionSiteList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1XMLInputStream, CTConnectionSiteList.type, null);
    }
    
    public static CTConnectionSiteList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTConnectionSiteList)POIXMLTypeLoader.parse(param1XMLInputStream, CTConnectionSiteList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConnectionSiteList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConnectionSiteList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTConnectionSiteList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */