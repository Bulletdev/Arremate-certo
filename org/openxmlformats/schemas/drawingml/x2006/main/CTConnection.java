package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTConnection extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTConnection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctconnection7fb9type");
  
  long getId();
  
  STDrawingElementId xgetId();
  
  void setId(long paramLong);
  
  void xsetId(STDrawingElementId paramSTDrawingElementId);
  
  long getIdx();
  
  XmlUnsignedInt xgetIdx();
  
  void setIdx(long paramLong);
  
  void xsetIdx(XmlUnsignedInt paramXmlUnsignedInt);
  
  public static final class Factory {
    public static CTConnection newInstance() {
      return (CTConnection)POIXMLTypeLoader.newInstance(CTConnection.type, null);
    }
    
    public static CTConnection newInstance(XmlOptions param1XmlOptions) {
      return (CTConnection)POIXMLTypeLoader.newInstance(CTConnection.type, param1XmlOptions);
    }
    
    public static CTConnection parse(String param1String) throws XmlException {
      return (CTConnection)POIXMLTypeLoader.parse(param1String, CTConnection.type, null);
    }
    
    public static CTConnection parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnection)POIXMLTypeLoader.parse(param1String, CTConnection.type, param1XmlOptions);
    }
    
    public static CTConnection parse(File param1File) throws XmlException, IOException {
      return (CTConnection)POIXMLTypeLoader.parse(param1File, CTConnection.type, null);
    }
    
    public static CTConnection parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnection)POIXMLTypeLoader.parse(param1File, CTConnection.type, param1XmlOptions);
    }
    
    public static CTConnection parse(URL param1URL) throws XmlException, IOException {
      return (CTConnection)POIXMLTypeLoader.parse(param1URL, CTConnection.type, null);
    }
    
    public static CTConnection parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnection)POIXMLTypeLoader.parse(param1URL, CTConnection.type, param1XmlOptions);
    }
    
    public static CTConnection parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTConnection)POIXMLTypeLoader.parse(param1InputStream, CTConnection.type, null);
    }
    
    public static CTConnection parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnection)POIXMLTypeLoader.parse(param1InputStream, CTConnection.type, param1XmlOptions);
    }
    
    public static CTConnection parse(Reader param1Reader) throws XmlException, IOException {
      return (CTConnection)POIXMLTypeLoader.parse(param1Reader, CTConnection.type, null);
    }
    
    public static CTConnection parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConnection)POIXMLTypeLoader.parse(param1Reader, CTConnection.type, param1XmlOptions);
    }
    
    public static CTConnection parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTConnection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConnection.type, null);
    }
    
    public static CTConnection parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConnection.type, param1XmlOptions);
    }
    
    public static CTConnection parse(Node param1Node) throws XmlException {
      return (CTConnection)POIXMLTypeLoader.parse(param1Node, CTConnection.type, null);
    }
    
    public static CTConnection parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConnection)POIXMLTypeLoader.parse(param1Node, CTConnection.type, param1XmlOptions);
    }
    
    public static CTConnection parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTConnection)POIXMLTypeLoader.parse(param1XMLInputStream, CTConnection.type, null);
    }
    
    public static CTConnection parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTConnection)POIXMLTypeLoader.parse(param1XMLInputStream, CTConnection.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConnection.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConnection.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */