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

public interface CTTickMark extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTickMark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttickmarke7f2type");
  
  STTickMark.Enum getVal();
  
  STTickMark xgetVal();
  
  boolean isSetVal();
  
  void setVal(STTickMark.Enum paramEnum);
  
  void xsetVal(STTickMark paramSTTickMark);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTTickMark newInstance() {
      return (CTTickMark)POIXMLTypeLoader.newInstance(CTTickMark.type, null);
    }
    
    public static CTTickMark newInstance(XmlOptions param1XmlOptions) {
      return (CTTickMark)POIXMLTypeLoader.newInstance(CTTickMark.type, param1XmlOptions);
    }
    
    public static CTTickMark parse(String param1String) throws XmlException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1String, CTTickMark.type, null);
    }
    
    public static CTTickMark parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1String, CTTickMark.type, param1XmlOptions);
    }
    
    public static CTTickMark parse(File param1File) throws XmlException, IOException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1File, CTTickMark.type, null);
    }
    
    public static CTTickMark parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1File, CTTickMark.type, param1XmlOptions);
    }
    
    public static CTTickMark parse(URL param1URL) throws XmlException, IOException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1URL, CTTickMark.type, null);
    }
    
    public static CTTickMark parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1URL, CTTickMark.type, param1XmlOptions);
    }
    
    public static CTTickMark parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1InputStream, CTTickMark.type, null);
    }
    
    public static CTTickMark parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1InputStream, CTTickMark.type, param1XmlOptions);
    }
    
    public static CTTickMark parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1Reader, CTTickMark.type, null);
    }
    
    public static CTTickMark parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1Reader, CTTickMark.type, param1XmlOptions);
    }
    
    public static CTTickMark parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTickMark.type, null);
    }
    
    public static CTTickMark parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTickMark.type, param1XmlOptions);
    }
    
    public static CTTickMark parse(Node param1Node) throws XmlException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1Node, CTTickMark.type, null);
    }
    
    public static CTTickMark parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1Node, CTTickMark.type, param1XmlOptions);
    }
    
    public static CTTickMark parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1XMLInputStream, CTTickMark.type, null);
    }
    
    public static CTTickMark parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTickMark)POIXMLTypeLoader.parse(param1XMLInputStream, CTTickMark.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTickMark.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTickMark.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTTickMark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */