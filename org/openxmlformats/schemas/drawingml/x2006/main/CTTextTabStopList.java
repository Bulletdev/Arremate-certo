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

public interface CTTextTabStopList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextTabStopList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttexttabstoplistf539type");
  
  List<CTTextTabStop> getTabList();
  
  CTTextTabStop[] getTabArray();
  
  CTTextTabStop getTabArray(int paramInt);
  
  int sizeOfTabArray();
  
  void setTabArray(CTTextTabStop[] paramArrayOfCTTextTabStop);
  
  void setTabArray(int paramInt, CTTextTabStop paramCTTextTabStop);
  
  CTTextTabStop insertNewTab(int paramInt);
  
  CTTextTabStop addNewTab();
  
  void removeTab(int paramInt);
  
  public static final class Factory {
    public static CTTextTabStopList newInstance() {
      return (CTTextTabStopList)POIXMLTypeLoader.newInstance(CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList newInstance(XmlOptions param1XmlOptions) {
      return (CTTextTabStopList)POIXMLTypeLoader.newInstance(CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static CTTextTabStopList parse(String param1String) throws XmlException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1String, CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1String, CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static CTTextTabStopList parse(File param1File) throws XmlException, IOException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1File, CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1File, CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static CTTextTabStopList parse(URL param1URL) throws XmlException, IOException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1URL, CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1URL, CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static CTTextTabStopList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1InputStream, CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1InputStream, CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static CTTextTabStopList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1Reader, CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1Reader, CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static CTTextTabStopList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static CTTextTabStopList parse(Node param1Node) throws XmlException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1Node, CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1Node, CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static CTTextTabStopList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextTabStopList.type, null);
    }
    
    public static CTTextTabStopList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextTabStopList)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextTabStopList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextTabStopList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextTabStopList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextTabStopList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */