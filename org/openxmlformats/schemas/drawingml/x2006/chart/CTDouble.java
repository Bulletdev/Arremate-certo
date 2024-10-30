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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTDouble extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDouble.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdoublec10btype");
  
  double getVal();
  
  XmlDouble xgetVal();
  
  void setVal(double paramDouble);
  
  void xsetVal(XmlDouble paramXmlDouble);
  
  public static final class Factory {
    public static CTDouble newInstance() {
      return (CTDouble)POIXMLTypeLoader.newInstance(CTDouble.type, null);
    }
    
    public static CTDouble newInstance(XmlOptions param1XmlOptions) {
      return (CTDouble)POIXMLTypeLoader.newInstance(CTDouble.type, param1XmlOptions);
    }
    
    public static CTDouble parse(String param1String) throws XmlException {
      return (CTDouble)POIXMLTypeLoader.parse(param1String, CTDouble.type, null);
    }
    
    public static CTDouble parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDouble)POIXMLTypeLoader.parse(param1String, CTDouble.type, param1XmlOptions);
    }
    
    public static CTDouble parse(File param1File) throws XmlException, IOException {
      return (CTDouble)POIXMLTypeLoader.parse(param1File, CTDouble.type, null);
    }
    
    public static CTDouble parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDouble)POIXMLTypeLoader.parse(param1File, CTDouble.type, param1XmlOptions);
    }
    
    public static CTDouble parse(URL param1URL) throws XmlException, IOException {
      return (CTDouble)POIXMLTypeLoader.parse(param1URL, CTDouble.type, null);
    }
    
    public static CTDouble parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDouble)POIXMLTypeLoader.parse(param1URL, CTDouble.type, param1XmlOptions);
    }
    
    public static CTDouble parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDouble)POIXMLTypeLoader.parse(param1InputStream, CTDouble.type, null);
    }
    
    public static CTDouble parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDouble)POIXMLTypeLoader.parse(param1InputStream, CTDouble.type, param1XmlOptions);
    }
    
    public static CTDouble parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDouble)POIXMLTypeLoader.parse(param1Reader, CTDouble.type, null);
    }
    
    public static CTDouble parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDouble)POIXMLTypeLoader.parse(param1Reader, CTDouble.type, param1XmlOptions);
    }
    
    public static CTDouble parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDouble)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDouble.type, null);
    }
    
    public static CTDouble parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDouble)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDouble.type, param1XmlOptions);
    }
    
    public static CTDouble parse(Node param1Node) throws XmlException {
      return (CTDouble)POIXMLTypeLoader.parse(param1Node, CTDouble.type, null);
    }
    
    public static CTDouble parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDouble)POIXMLTypeLoader.parse(param1Node, CTDouble.type, param1XmlOptions);
    }
    
    public static CTDouble parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDouble)POIXMLTypeLoader.parse(param1XMLInputStream, CTDouble.type, null);
    }
    
    public static CTDouble parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDouble)POIXMLTypeLoader.parse(param1XMLInputStream, CTDouble.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDouble.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDouble.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */