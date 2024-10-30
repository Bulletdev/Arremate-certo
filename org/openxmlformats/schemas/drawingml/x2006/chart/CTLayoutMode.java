package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTLayoutMode extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLayoutMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlayoutmode53eftype");
  
  STLayoutMode.Enum getVal();
  
  STLayoutMode xgetVal();
  
  boolean isSetVal();
  
  void setVal(STLayoutMode.Enum paramEnum);
  
  void xsetVal(STLayoutMode paramSTLayoutMode);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTLayoutMode newInstance() {
      return (CTLayoutMode)POIXMLTypeLoader.newInstance(CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode newInstance(XmlOptions param1XmlOptions) {
      return (CTLayoutMode)POIXMLTypeLoader.newInstance(CTLayoutMode.type, param1XmlOptions);
    }
    
    public static CTLayoutMode parse(String param1String) throws XmlException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1String, CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1String, CTLayoutMode.type, param1XmlOptions);
    }
    
    public static CTLayoutMode parse(File param1File) throws XmlException, IOException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1File, CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1File, CTLayoutMode.type, param1XmlOptions);
    }
    
    public static CTLayoutMode parse(URL param1URL) throws XmlException, IOException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1URL, CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1URL, CTLayoutMode.type, param1XmlOptions);
    }
    
    public static CTLayoutMode parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1InputStream, CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1InputStream, CTLayoutMode.type, param1XmlOptions);
    }
    
    public static CTLayoutMode parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1Reader, CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1Reader, CTLayoutMode.type, param1XmlOptions);
    }
    
    public static CTLayoutMode parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLayoutMode.type, param1XmlOptions);
    }
    
    public static CTLayoutMode parse(Node param1Node) throws XmlException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1Node, CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1Node, CTLayoutMode.type, param1XmlOptions);
    }
    
    public static CTLayoutMode parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1XMLInputStream, CTLayoutMode.type, null);
    }
    
    public static CTLayoutMode parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLayoutMode)POIXMLTypeLoader.parse(param1XMLInputStream, CTLayoutMode.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLayoutMode.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLayoutMode.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTLayoutMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */