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

public interface CTLineEndProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLineEndProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlineendproperties8acbtype");
  
  STLineEndType.Enum getType();
  
  STLineEndType xgetType();
  
  boolean isSetType();
  
  void setType(STLineEndType.Enum paramEnum);
  
  void xsetType(STLineEndType paramSTLineEndType);
  
  void unsetType();
  
  STLineEndWidth.Enum getW();
  
  STLineEndWidth xgetW();
  
  boolean isSetW();
  
  void setW(STLineEndWidth.Enum paramEnum);
  
  void xsetW(STLineEndWidth paramSTLineEndWidth);
  
  void unsetW();
  
  STLineEndLength.Enum getLen();
  
  STLineEndLength xgetLen();
  
  boolean isSetLen();
  
  void setLen(STLineEndLength.Enum paramEnum);
  
  void xsetLen(STLineEndLength paramSTLineEndLength);
  
  void unsetLen();
  
  public static final class Factory {
    public static CTLineEndProperties newInstance() {
      return (CTLineEndProperties)POIXMLTypeLoader.newInstance(CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTLineEndProperties)POIXMLTypeLoader.newInstance(CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static CTLineEndProperties parse(String param1String) throws XmlException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1String, CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1String, CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static CTLineEndProperties parse(File param1File) throws XmlException, IOException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1File, CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1File, CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static CTLineEndProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1URL, CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1URL, CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static CTLineEndProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1InputStream, CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1InputStream, CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static CTLineEndProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1Reader, CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1Reader, CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static CTLineEndProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static CTLineEndProperties parse(Node param1Node) throws XmlException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1Node, CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1Node, CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static CTLineEndProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineEndProperties.type, null);
    }
    
    public static CTLineEndProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLineEndProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineEndProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineEndProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineEndProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTLineEndProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */