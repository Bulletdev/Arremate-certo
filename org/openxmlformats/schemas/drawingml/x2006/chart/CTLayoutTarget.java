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

public interface CTLayoutTarget extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLayoutTarget.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlayouttarget1001type");
  
  STLayoutTarget.Enum getVal();
  
  STLayoutTarget xgetVal();
  
  boolean isSetVal();
  
  void setVal(STLayoutTarget.Enum paramEnum);
  
  void xsetVal(STLayoutTarget paramSTLayoutTarget);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTLayoutTarget newInstance() {
      return (CTLayoutTarget)POIXMLTypeLoader.newInstance(CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget newInstance(XmlOptions param1XmlOptions) {
      return (CTLayoutTarget)POIXMLTypeLoader.newInstance(CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static CTLayoutTarget parse(String param1String) throws XmlException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1String, CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1String, CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static CTLayoutTarget parse(File param1File) throws XmlException, IOException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1File, CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1File, CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static CTLayoutTarget parse(URL param1URL) throws XmlException, IOException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1URL, CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1URL, CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static CTLayoutTarget parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1InputStream, CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1InputStream, CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static CTLayoutTarget parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1Reader, CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1Reader, CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static CTLayoutTarget parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static CTLayoutTarget parse(Node param1Node) throws XmlException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1Node, CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1Node, CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static CTLayoutTarget parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1XMLInputStream, CTLayoutTarget.type, null);
    }
    
    public static CTLayoutTarget parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLayoutTarget)POIXMLTypeLoader.parse(param1XMLInputStream, CTLayoutTarget.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLayoutTarget.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLayoutTarget.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTLayoutTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */