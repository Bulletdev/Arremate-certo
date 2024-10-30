package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTTabs extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTabs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttabsa2aatype");
  
  List<CTTabStop> getTabList();
  
  CTTabStop[] getTabArray();
  
  CTTabStop getTabArray(int paramInt);
  
  int sizeOfTabArray();
  
  void setTabArray(CTTabStop[] paramArrayOfCTTabStop);
  
  void setTabArray(int paramInt, CTTabStop paramCTTabStop);
  
  CTTabStop insertNewTab(int paramInt);
  
  CTTabStop addNewTab();
  
  void removeTab(int paramInt);
  
  public static final class Factory {
    public static CTTabs newInstance() {
      return (CTTabs)POIXMLTypeLoader.newInstance(CTTabs.type, null);
    }
    
    public static CTTabs newInstance(XmlOptions param1XmlOptions) {
      return (CTTabs)POIXMLTypeLoader.newInstance(CTTabs.type, param1XmlOptions);
    }
    
    public static CTTabs parse(String param1String) throws XmlException {
      return (CTTabs)POIXMLTypeLoader.parse(param1String, CTTabs.type, null);
    }
    
    public static CTTabs parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTabs)POIXMLTypeLoader.parse(param1String, CTTabs.type, param1XmlOptions);
    }
    
    public static CTTabs parse(File param1File) throws XmlException, IOException {
      return (CTTabs)POIXMLTypeLoader.parse(param1File, CTTabs.type, null);
    }
    
    public static CTTabs parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTabs)POIXMLTypeLoader.parse(param1File, CTTabs.type, param1XmlOptions);
    }
    
    public static CTTabs parse(URL param1URL) throws XmlException, IOException {
      return (CTTabs)POIXMLTypeLoader.parse(param1URL, CTTabs.type, null);
    }
    
    public static CTTabs parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTabs)POIXMLTypeLoader.parse(param1URL, CTTabs.type, param1XmlOptions);
    }
    
    public static CTTabs parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTabs)POIXMLTypeLoader.parse(param1InputStream, CTTabs.type, null);
    }
    
    public static CTTabs parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTabs)POIXMLTypeLoader.parse(param1InputStream, CTTabs.type, param1XmlOptions);
    }
    
    public static CTTabs parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTabs)POIXMLTypeLoader.parse(param1Reader, CTTabs.type, null);
    }
    
    public static CTTabs parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTabs)POIXMLTypeLoader.parse(param1Reader, CTTabs.type, param1XmlOptions);
    }
    
    public static CTTabs parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTabs)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTabs.type, null);
    }
    
    public static CTTabs parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTabs)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTabs.type, param1XmlOptions);
    }
    
    public static CTTabs parse(Node param1Node) throws XmlException {
      return (CTTabs)POIXMLTypeLoader.parse(param1Node, CTTabs.type, null);
    }
    
    public static CTTabs parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTabs)POIXMLTypeLoader.parse(param1Node, CTTabs.type, param1XmlOptions);
    }
    
    public static CTTabs parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTabs)POIXMLTypeLoader.parse(param1XMLInputStream, CTTabs.type, null);
    }
    
    public static CTTabs parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTabs)POIXMLTypeLoader.parse(param1XMLInputStream, CTTabs.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTabs.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTabs.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTabs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */