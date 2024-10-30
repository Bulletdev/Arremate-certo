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

public interface CTLogBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLogBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlogbase9191type");
  
  double getVal();
  
  STLogBase xgetVal();
  
  void setVal(double paramDouble);
  
  void xsetVal(STLogBase paramSTLogBase);
  
  public static final class Factory {
    public static CTLogBase newInstance() {
      return (CTLogBase)POIXMLTypeLoader.newInstance(CTLogBase.type, null);
    }
    
    public static CTLogBase newInstance(XmlOptions param1XmlOptions) {
      return (CTLogBase)POIXMLTypeLoader.newInstance(CTLogBase.type, param1XmlOptions);
    }
    
    public static CTLogBase parse(String param1String) throws XmlException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1String, CTLogBase.type, null);
    }
    
    public static CTLogBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1String, CTLogBase.type, param1XmlOptions);
    }
    
    public static CTLogBase parse(File param1File) throws XmlException, IOException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1File, CTLogBase.type, null);
    }
    
    public static CTLogBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1File, CTLogBase.type, param1XmlOptions);
    }
    
    public static CTLogBase parse(URL param1URL) throws XmlException, IOException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1URL, CTLogBase.type, null);
    }
    
    public static CTLogBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1URL, CTLogBase.type, param1XmlOptions);
    }
    
    public static CTLogBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1InputStream, CTLogBase.type, null);
    }
    
    public static CTLogBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1InputStream, CTLogBase.type, param1XmlOptions);
    }
    
    public static CTLogBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1Reader, CTLogBase.type, null);
    }
    
    public static CTLogBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1Reader, CTLogBase.type, param1XmlOptions);
    }
    
    public static CTLogBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLogBase.type, null);
    }
    
    public static CTLogBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLogBase.type, param1XmlOptions);
    }
    
    public static CTLogBase parse(Node param1Node) throws XmlException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1Node, CTLogBase.type, null);
    }
    
    public static CTLogBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1Node, CTLogBase.type, param1XmlOptions);
    }
    
    public static CTLogBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTLogBase.type, null);
    }
    
    public static CTLogBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLogBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTLogBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLogBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLogBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTLogBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */