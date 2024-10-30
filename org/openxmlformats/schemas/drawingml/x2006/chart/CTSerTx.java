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

public interface CTSerTx extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSerTx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsertxd722type");
  
  CTStrRef getStrRef();
  
  boolean isSetStrRef();
  
  void setStrRef(CTStrRef paramCTStrRef);
  
  CTStrRef addNewStrRef();
  
  void unsetStrRef();
  
  String getV();
  
  STXstring xgetV();
  
  boolean isSetV();
  
  void setV(String paramString);
  
  void xsetV(STXstring paramSTXstring);
  
  void unsetV();
  
  public static final class Factory {
    public static CTSerTx newInstance() {
      return (CTSerTx)POIXMLTypeLoader.newInstance(CTSerTx.type, null);
    }
    
    public static CTSerTx newInstance(XmlOptions param1XmlOptions) {
      return (CTSerTx)POIXMLTypeLoader.newInstance(CTSerTx.type, param1XmlOptions);
    }
    
    public static CTSerTx parse(String param1String) throws XmlException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1String, CTSerTx.type, null);
    }
    
    public static CTSerTx parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1String, CTSerTx.type, param1XmlOptions);
    }
    
    public static CTSerTx parse(File param1File) throws XmlException, IOException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1File, CTSerTx.type, null);
    }
    
    public static CTSerTx parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1File, CTSerTx.type, param1XmlOptions);
    }
    
    public static CTSerTx parse(URL param1URL) throws XmlException, IOException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1URL, CTSerTx.type, null);
    }
    
    public static CTSerTx parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1URL, CTSerTx.type, param1XmlOptions);
    }
    
    public static CTSerTx parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1InputStream, CTSerTx.type, null);
    }
    
    public static CTSerTx parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1InputStream, CTSerTx.type, param1XmlOptions);
    }
    
    public static CTSerTx parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1Reader, CTSerTx.type, null);
    }
    
    public static CTSerTx parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1Reader, CTSerTx.type, param1XmlOptions);
    }
    
    public static CTSerTx parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSerTx.type, null);
    }
    
    public static CTSerTx parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSerTx.type, param1XmlOptions);
    }
    
    public static CTSerTx parse(Node param1Node) throws XmlException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1Node, CTSerTx.type, null);
    }
    
    public static CTSerTx parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1Node, CTSerTx.type, param1XmlOptions);
    }
    
    public static CTSerTx parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1XMLInputStream, CTSerTx.type, null);
    }
    
    public static CTSerTx parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSerTx)POIXMLTypeLoader.parse(param1XMLInputStream, CTSerTx.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSerTx.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSerTx.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTSerTx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */