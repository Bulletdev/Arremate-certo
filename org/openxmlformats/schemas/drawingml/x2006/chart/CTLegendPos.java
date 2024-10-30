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

public interface CTLegendPos extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLegendPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlegendpos053ftype");
  
  STLegendPos.Enum getVal();
  
  STLegendPos xgetVal();
  
  boolean isSetVal();
  
  void setVal(STLegendPos.Enum paramEnum);
  
  void xsetVal(STLegendPos paramSTLegendPos);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTLegendPos newInstance() {
      return (CTLegendPos)POIXMLTypeLoader.newInstance(CTLegendPos.type, null);
    }
    
    public static CTLegendPos newInstance(XmlOptions param1XmlOptions) {
      return (CTLegendPos)POIXMLTypeLoader.newInstance(CTLegendPos.type, param1XmlOptions);
    }
    
    public static CTLegendPos parse(String param1String) throws XmlException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1String, CTLegendPos.type, null);
    }
    
    public static CTLegendPos parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1String, CTLegendPos.type, param1XmlOptions);
    }
    
    public static CTLegendPos parse(File param1File) throws XmlException, IOException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1File, CTLegendPos.type, null);
    }
    
    public static CTLegendPos parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1File, CTLegendPos.type, param1XmlOptions);
    }
    
    public static CTLegendPos parse(URL param1URL) throws XmlException, IOException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1URL, CTLegendPos.type, null);
    }
    
    public static CTLegendPos parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1URL, CTLegendPos.type, param1XmlOptions);
    }
    
    public static CTLegendPos parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1InputStream, CTLegendPos.type, null);
    }
    
    public static CTLegendPos parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1InputStream, CTLegendPos.type, param1XmlOptions);
    }
    
    public static CTLegendPos parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1Reader, CTLegendPos.type, null);
    }
    
    public static CTLegendPos parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1Reader, CTLegendPos.type, param1XmlOptions);
    }
    
    public static CTLegendPos parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLegendPos.type, null);
    }
    
    public static CTLegendPos parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLegendPos.type, param1XmlOptions);
    }
    
    public static CTLegendPos parse(Node param1Node) throws XmlException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1Node, CTLegendPos.type, null);
    }
    
    public static CTLegendPos parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1Node, CTLegendPos.type, param1XmlOptions);
    }
    
    public static CTLegendPos parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1XMLInputStream, CTLegendPos.type, null);
    }
    
    public static CTLegendPos parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLegendPos)POIXMLTypeLoader.parse(param1XMLInputStream, CTLegendPos.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLegendPos.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLegendPos.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTLegendPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */