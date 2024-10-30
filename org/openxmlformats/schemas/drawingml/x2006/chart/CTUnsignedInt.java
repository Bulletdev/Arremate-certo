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

public interface CTUnsignedInt extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTUnsignedInt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctunsignedinte8ectype");
  
  long getVal();
  
  XmlUnsignedInt xgetVal();
  
  void setVal(long paramLong);
  
  void xsetVal(XmlUnsignedInt paramXmlUnsignedInt);
  
  public static final class Factory {
    public static CTUnsignedInt newInstance() {
      return (CTUnsignedInt)POIXMLTypeLoader.newInstance(CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt newInstance(XmlOptions param1XmlOptions) {
      return (CTUnsignedInt)POIXMLTypeLoader.newInstance(CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static CTUnsignedInt parse(String param1String) throws XmlException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1String, CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1String, CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static CTUnsignedInt parse(File param1File) throws XmlException, IOException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1File, CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1File, CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static CTUnsignedInt parse(URL param1URL) throws XmlException, IOException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1URL, CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1URL, CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static CTUnsignedInt parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1InputStream, CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1InputStream, CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static CTUnsignedInt parse(Reader param1Reader) throws XmlException, IOException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1Reader, CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1Reader, CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static CTUnsignedInt parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1XMLStreamReader, CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1XMLStreamReader, CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static CTUnsignedInt parse(Node param1Node) throws XmlException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1Node, CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1Node, CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static CTUnsignedInt parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1XMLInputStream, CTUnsignedInt.type, null);
    }
    
    public static CTUnsignedInt parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTUnsignedInt)POIXMLTypeLoader.parse(param1XMLInputStream, CTUnsignedInt.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTUnsignedInt.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTUnsignedInt.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTUnsignedInt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */