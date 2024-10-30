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

public interface CTScatterStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTScatterStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctscatterstyle94c9type");
  
  STScatterStyle.Enum getVal();
  
  STScatterStyle xgetVal();
  
  boolean isSetVal();
  
  void setVal(STScatterStyle.Enum paramEnum);
  
  void xsetVal(STScatterStyle paramSTScatterStyle);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTScatterStyle newInstance() {
      return (CTScatterStyle)POIXMLTypeLoader.newInstance(CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTScatterStyle)POIXMLTypeLoader.newInstance(CTScatterStyle.type, param1XmlOptions);
    }
    
    public static CTScatterStyle parse(String param1String) throws XmlException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1String, CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1String, CTScatterStyle.type, param1XmlOptions);
    }
    
    public static CTScatterStyle parse(File param1File) throws XmlException, IOException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1File, CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1File, CTScatterStyle.type, param1XmlOptions);
    }
    
    public static CTScatterStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1URL, CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1URL, CTScatterStyle.type, param1XmlOptions);
    }
    
    public static CTScatterStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1InputStream, CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1InputStream, CTScatterStyle.type, param1XmlOptions);
    }
    
    public static CTScatterStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1Reader, CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1Reader, CTScatterStyle.type, param1XmlOptions);
    }
    
    public static CTScatterStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTScatterStyle.type, param1XmlOptions);
    }
    
    public static CTScatterStyle parse(Node param1Node) throws XmlException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1Node, CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1Node, CTScatterStyle.type, param1XmlOptions);
    }
    
    public static CTScatterStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTScatterStyle.type, null);
    }
    
    public static CTScatterStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTScatterStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTScatterStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTScatterStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTScatterStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTScatterStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */