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

public interface CTAxPos extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAxPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctaxposff69type");
  
  STAxPos.Enum getVal();
  
  STAxPos xgetVal();
  
  void setVal(STAxPos.Enum paramEnum);
  
  void xsetVal(STAxPos paramSTAxPos);
  
  public static final class Factory {
    public static CTAxPos newInstance() {
      return (CTAxPos)POIXMLTypeLoader.newInstance(CTAxPos.type, null);
    }
    
    public static CTAxPos newInstance(XmlOptions param1XmlOptions) {
      return (CTAxPos)POIXMLTypeLoader.newInstance(CTAxPos.type, param1XmlOptions);
    }
    
    public static CTAxPos parse(String param1String) throws XmlException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1String, CTAxPos.type, null);
    }
    
    public static CTAxPos parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1String, CTAxPos.type, param1XmlOptions);
    }
    
    public static CTAxPos parse(File param1File) throws XmlException, IOException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1File, CTAxPos.type, null);
    }
    
    public static CTAxPos parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1File, CTAxPos.type, param1XmlOptions);
    }
    
    public static CTAxPos parse(URL param1URL) throws XmlException, IOException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1URL, CTAxPos.type, null);
    }
    
    public static CTAxPos parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1URL, CTAxPos.type, param1XmlOptions);
    }
    
    public static CTAxPos parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1InputStream, CTAxPos.type, null);
    }
    
    public static CTAxPos parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1InputStream, CTAxPos.type, param1XmlOptions);
    }
    
    public static CTAxPos parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1Reader, CTAxPos.type, null);
    }
    
    public static CTAxPos parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1Reader, CTAxPos.type, param1XmlOptions);
    }
    
    public static CTAxPos parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAxPos.type, null);
    }
    
    public static CTAxPos parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAxPos.type, param1XmlOptions);
    }
    
    public static CTAxPos parse(Node param1Node) throws XmlException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1Node, CTAxPos.type, null);
    }
    
    public static CTAxPos parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1Node, CTAxPos.type, param1XmlOptions);
    }
    
    public static CTAxPos parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1XMLInputStream, CTAxPos.type, null);
    }
    
    public static CTAxPos parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAxPos)POIXMLTypeLoader.parse(param1XMLInputStream, CTAxPos.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAxPos.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAxPos.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTAxPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */