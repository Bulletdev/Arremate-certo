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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTextTabStop extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextTabStop.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttexttabstopb57btype");
  
  int getPos();
  
  STCoordinate32 xgetPos();
  
  boolean isSetPos();
  
  void setPos(int paramInt);
  
  void xsetPos(STCoordinate32 paramSTCoordinate32);
  
  void unsetPos();
  
  STTextTabAlignType$Enum getAlgn();
  
  STTextTabAlignType xgetAlgn();
  
  boolean isSetAlgn();
  
  void setAlgn(STTextTabAlignType$Enum paramSTTextTabAlignType$Enum);
  
  void xsetAlgn(STTextTabAlignType paramSTTextTabAlignType);
  
  void unsetAlgn();
  
  public static final class Factory {
    public static CTTextTabStop newInstance() {
      return (CTTextTabStop)POIXMLTypeLoader.newInstance(CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop newInstance(XmlOptions param1XmlOptions) {
      return (CTTextTabStop)POIXMLTypeLoader.newInstance(CTTextTabStop.type, param1XmlOptions);
    }
    
    public static CTTextTabStop parse(String param1String) throws XmlException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1String, CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1String, CTTextTabStop.type, param1XmlOptions);
    }
    
    public static CTTextTabStop parse(File param1File) throws XmlException, IOException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1File, CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1File, CTTextTabStop.type, param1XmlOptions);
    }
    
    public static CTTextTabStop parse(URL param1URL) throws XmlException, IOException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1URL, CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1URL, CTTextTabStop.type, param1XmlOptions);
    }
    
    public static CTTextTabStop parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1InputStream, CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1InputStream, CTTextTabStop.type, param1XmlOptions);
    }
    
    public static CTTextTabStop parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1Reader, CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1Reader, CTTextTabStop.type, param1XmlOptions);
    }
    
    public static CTTextTabStop parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextTabStop.type, param1XmlOptions);
    }
    
    public static CTTextTabStop parse(Node param1Node) throws XmlException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1Node, CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1Node, CTTextTabStop.type, param1XmlOptions);
    }
    
    public static CTTextTabStop parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextTabStop.type, null);
    }
    
    public static CTTextTabStop parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextTabStop)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextTabStop.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextTabStop.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextTabStop.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextTabStop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */