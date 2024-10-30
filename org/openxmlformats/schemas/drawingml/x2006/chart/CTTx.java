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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

public interface CTTx extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttx9678type");
  
  CTStrRef getStrRef();
  
  boolean isSetStrRef();
  
  void setStrRef(CTStrRef paramCTStrRef);
  
  CTStrRef addNewStrRef();
  
  void unsetStrRef();
  
  CTTextBody getRich();
  
  boolean isSetRich();
  
  void setRich(CTTextBody paramCTTextBody);
  
  CTTextBody addNewRich();
  
  void unsetRich();
  
  public static final class Factory {
    public static CTTx newInstance() {
      return (CTTx)POIXMLTypeLoader.newInstance(CTTx.type, null);
    }
    
    public static CTTx newInstance(XmlOptions param1XmlOptions) {
      return (CTTx)POIXMLTypeLoader.newInstance(CTTx.type, param1XmlOptions);
    }
    
    public static CTTx parse(String param1String) throws XmlException {
      return (CTTx)POIXMLTypeLoader.parse(param1String, CTTx.type, null);
    }
    
    public static CTTx parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTx)POIXMLTypeLoader.parse(param1String, CTTx.type, param1XmlOptions);
    }
    
    public static CTTx parse(File param1File) throws XmlException, IOException {
      return (CTTx)POIXMLTypeLoader.parse(param1File, CTTx.type, null);
    }
    
    public static CTTx parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTx)POIXMLTypeLoader.parse(param1File, CTTx.type, param1XmlOptions);
    }
    
    public static CTTx parse(URL param1URL) throws XmlException, IOException {
      return (CTTx)POIXMLTypeLoader.parse(param1URL, CTTx.type, null);
    }
    
    public static CTTx parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTx)POIXMLTypeLoader.parse(param1URL, CTTx.type, param1XmlOptions);
    }
    
    public static CTTx parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTx)POIXMLTypeLoader.parse(param1InputStream, CTTx.type, null);
    }
    
    public static CTTx parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTx)POIXMLTypeLoader.parse(param1InputStream, CTTx.type, param1XmlOptions);
    }
    
    public static CTTx parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTx)POIXMLTypeLoader.parse(param1Reader, CTTx.type, null);
    }
    
    public static CTTx parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTx)POIXMLTypeLoader.parse(param1Reader, CTTx.type, param1XmlOptions);
    }
    
    public static CTTx parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTx.type, null);
    }
    
    public static CTTx parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTx.type, param1XmlOptions);
    }
    
    public static CTTx parse(Node param1Node) throws XmlException {
      return (CTTx)POIXMLTypeLoader.parse(param1Node, CTTx.type, null);
    }
    
    public static CTTx parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTx)POIXMLTypeLoader.parse(param1Node, CTTx.type, param1XmlOptions);
    }
    
    public static CTTx parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTx)POIXMLTypeLoader.parse(param1XMLInputStream, CTTx.type, null);
    }
    
    public static CTTx parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTx)POIXMLTypeLoader.parse(param1XMLInputStream, CTTx.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTx.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTx.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTTx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */