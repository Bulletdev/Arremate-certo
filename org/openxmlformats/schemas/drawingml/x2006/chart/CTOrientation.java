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

public interface CTOrientation extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTOrientation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctorientationcb16type");
  
  STOrientation.Enum getVal();
  
  STOrientation xgetVal();
  
  boolean isSetVal();
  
  void setVal(STOrientation.Enum paramEnum);
  
  void xsetVal(STOrientation paramSTOrientation);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTOrientation newInstance() {
      return (CTOrientation)POIXMLTypeLoader.newInstance(CTOrientation.type, null);
    }
    
    public static CTOrientation newInstance(XmlOptions param1XmlOptions) {
      return (CTOrientation)POIXMLTypeLoader.newInstance(CTOrientation.type, param1XmlOptions);
    }
    
    public static CTOrientation parse(String param1String) throws XmlException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1String, CTOrientation.type, null);
    }
    
    public static CTOrientation parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1String, CTOrientation.type, param1XmlOptions);
    }
    
    public static CTOrientation parse(File param1File) throws XmlException, IOException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1File, CTOrientation.type, null);
    }
    
    public static CTOrientation parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1File, CTOrientation.type, param1XmlOptions);
    }
    
    public static CTOrientation parse(URL param1URL) throws XmlException, IOException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1URL, CTOrientation.type, null);
    }
    
    public static CTOrientation parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1URL, CTOrientation.type, param1XmlOptions);
    }
    
    public static CTOrientation parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1InputStream, CTOrientation.type, null);
    }
    
    public static CTOrientation parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1InputStream, CTOrientation.type, param1XmlOptions);
    }
    
    public static CTOrientation parse(Reader param1Reader) throws XmlException, IOException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1Reader, CTOrientation.type, null);
    }
    
    public static CTOrientation parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1Reader, CTOrientation.type, param1XmlOptions);
    }
    
    public static CTOrientation parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOrientation.type, null);
    }
    
    public static CTOrientation parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOrientation.type, param1XmlOptions);
    }
    
    public static CTOrientation parse(Node param1Node) throws XmlException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1Node, CTOrientation.type, null);
    }
    
    public static CTOrientation parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1Node, CTOrientation.type, param1XmlOptions);
    }
    
    public static CTOrientation parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1XMLInputStream, CTOrientation.type, null);
    }
    
    public static CTOrientation parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTOrientation)POIXMLTypeLoader.parse(param1XMLInputStream, CTOrientation.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOrientation.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOrientation.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTOrientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */