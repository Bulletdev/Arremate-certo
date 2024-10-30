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

public interface CTTickLblPos extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTickLblPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctticklblposff61type");
  
  STTickLblPos.Enum getVal();
  
  STTickLblPos xgetVal();
  
  boolean isSetVal();
  
  void setVal(STTickLblPos.Enum paramEnum);
  
  void xsetVal(STTickLblPos paramSTTickLblPos);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTTickLblPos newInstance() {
      return (CTTickLblPos)POIXMLTypeLoader.newInstance(CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos newInstance(XmlOptions param1XmlOptions) {
      return (CTTickLblPos)POIXMLTypeLoader.newInstance(CTTickLblPos.type, param1XmlOptions);
    }
    
    public static CTTickLblPos parse(String param1String) throws XmlException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1String, CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1String, CTTickLblPos.type, param1XmlOptions);
    }
    
    public static CTTickLblPos parse(File param1File) throws XmlException, IOException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1File, CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1File, CTTickLblPos.type, param1XmlOptions);
    }
    
    public static CTTickLblPos parse(URL param1URL) throws XmlException, IOException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1URL, CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1URL, CTTickLblPos.type, param1XmlOptions);
    }
    
    public static CTTickLblPos parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1InputStream, CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1InputStream, CTTickLblPos.type, param1XmlOptions);
    }
    
    public static CTTickLblPos parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1Reader, CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1Reader, CTTickLblPos.type, param1XmlOptions);
    }
    
    public static CTTickLblPos parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTickLblPos.type, param1XmlOptions);
    }
    
    public static CTTickLblPos parse(Node param1Node) throws XmlException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1Node, CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1Node, CTTickLblPos.type, param1XmlOptions);
    }
    
    public static CTTickLblPos parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1XMLInputStream, CTTickLblPos.type, null);
    }
    
    public static CTTickLblPos parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTickLblPos)POIXMLTypeLoader.parse(param1XMLInputStream, CTTickLblPos.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTickLblPos.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTickLblPos.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTTickLblPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */