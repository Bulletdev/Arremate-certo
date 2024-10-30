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

public interface CTPathShadeProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPathShadeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpathshadeproperties7ccctype");
  
  CTRelativeRect getFillToRect();
  
  boolean isSetFillToRect();
  
  void setFillToRect(CTRelativeRect paramCTRelativeRect);
  
  CTRelativeRect addNewFillToRect();
  
  void unsetFillToRect();
  
  STPathShadeType.Enum getPath();
  
  STPathShadeType xgetPath();
  
  boolean isSetPath();
  
  void setPath(STPathShadeType.Enum paramEnum);
  
  void xsetPath(STPathShadeType paramSTPathShadeType);
  
  void unsetPath();
  
  public static final class Factory {
    public static CTPathShadeProperties newInstance() {
      return (CTPathShadeProperties)POIXMLTypeLoader.newInstance(CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTPathShadeProperties)POIXMLTypeLoader.newInstance(CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static CTPathShadeProperties parse(String param1String) throws XmlException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1String, CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1String, CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static CTPathShadeProperties parse(File param1File) throws XmlException, IOException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1File, CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1File, CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static CTPathShadeProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1URL, CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1URL, CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static CTPathShadeProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1InputStream, CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1InputStream, CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static CTPathShadeProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1Reader, CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1Reader, CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static CTPathShadeProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static CTPathShadeProperties parse(Node param1Node) throws XmlException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1Node, CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1Node, CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static CTPathShadeProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTPathShadeProperties.type, null);
    }
    
    public static CTPathShadeProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPathShadeProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTPathShadeProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPathShadeProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPathShadeProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPathShadeProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */