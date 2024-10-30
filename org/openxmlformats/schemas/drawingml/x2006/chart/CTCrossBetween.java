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

public interface CTCrossBetween extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCrossBetween.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcrossbetweeneb14type");
  
  STCrossBetween.Enum getVal();
  
  STCrossBetween xgetVal();
  
  void setVal(STCrossBetween.Enum paramEnum);
  
  void xsetVal(STCrossBetween paramSTCrossBetween);
  
  public static final class Factory {
    public static CTCrossBetween newInstance() {
      return (CTCrossBetween)POIXMLTypeLoader.newInstance(CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween newInstance(XmlOptions param1XmlOptions) {
      return (CTCrossBetween)POIXMLTypeLoader.newInstance(CTCrossBetween.type, param1XmlOptions);
    }
    
    public static CTCrossBetween parse(String param1String) throws XmlException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1String, CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1String, CTCrossBetween.type, param1XmlOptions);
    }
    
    public static CTCrossBetween parse(File param1File) throws XmlException, IOException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1File, CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1File, CTCrossBetween.type, param1XmlOptions);
    }
    
    public static CTCrossBetween parse(URL param1URL) throws XmlException, IOException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1URL, CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1URL, CTCrossBetween.type, param1XmlOptions);
    }
    
    public static CTCrossBetween parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1InputStream, CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1InputStream, CTCrossBetween.type, param1XmlOptions);
    }
    
    public static CTCrossBetween parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1Reader, CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1Reader, CTCrossBetween.type, param1XmlOptions);
    }
    
    public static CTCrossBetween parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCrossBetween.type, param1XmlOptions);
    }
    
    public static CTCrossBetween parse(Node param1Node) throws XmlException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1Node, CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1Node, CTCrossBetween.type, param1XmlOptions);
    }
    
    public static CTCrossBetween parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1XMLInputStream, CTCrossBetween.type, null);
    }
    
    public static CTCrossBetween parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCrossBetween)POIXMLTypeLoader.parse(param1XMLInputStream, CTCrossBetween.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCrossBetween.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCrossBetween.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTCrossBetween.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */