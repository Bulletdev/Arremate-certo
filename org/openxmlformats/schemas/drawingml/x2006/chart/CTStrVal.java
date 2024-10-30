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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTStrVal extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStrVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstrval86cctype");
  
  String getV();
  
  STXstring xgetV();
  
  void setV(String paramString);
  
  void xsetV(STXstring paramSTXstring);
  
  long getIdx();
  
  XmlUnsignedInt xgetIdx();
  
  void setIdx(long paramLong);
  
  void xsetIdx(XmlUnsignedInt paramXmlUnsignedInt);
  
  public static final class Factory {
    public static CTStrVal newInstance() {
      return (CTStrVal)POIXMLTypeLoader.newInstance(CTStrVal.type, null);
    }
    
    public static CTStrVal newInstance(XmlOptions param1XmlOptions) {
      return (CTStrVal)POIXMLTypeLoader.newInstance(CTStrVal.type, param1XmlOptions);
    }
    
    public static CTStrVal parse(String param1String) throws XmlException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1String, CTStrVal.type, null);
    }
    
    public static CTStrVal parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1String, CTStrVal.type, param1XmlOptions);
    }
    
    public static CTStrVal parse(File param1File) throws XmlException, IOException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1File, CTStrVal.type, null);
    }
    
    public static CTStrVal parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1File, CTStrVal.type, param1XmlOptions);
    }
    
    public static CTStrVal parse(URL param1URL) throws XmlException, IOException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1URL, CTStrVal.type, null);
    }
    
    public static CTStrVal parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1URL, CTStrVal.type, param1XmlOptions);
    }
    
    public static CTStrVal parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1InputStream, CTStrVal.type, null);
    }
    
    public static CTStrVal parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1InputStream, CTStrVal.type, param1XmlOptions);
    }
    
    public static CTStrVal parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1Reader, CTStrVal.type, null);
    }
    
    public static CTStrVal parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1Reader, CTStrVal.type, param1XmlOptions);
    }
    
    public static CTStrVal parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStrVal.type, null);
    }
    
    public static CTStrVal parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStrVal.type, param1XmlOptions);
    }
    
    public static CTStrVal parse(Node param1Node) throws XmlException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1Node, CTStrVal.type, null);
    }
    
    public static CTStrVal parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1Node, CTStrVal.type, param1XmlOptions);
    }
    
    public static CTStrVal parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1XMLInputStream, CTStrVal.type, null);
    }
    
    public static CTStrVal parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStrVal)POIXMLTypeLoader.parse(param1XMLInputStream, CTStrVal.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStrVal.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStrVal.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTStrVal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */