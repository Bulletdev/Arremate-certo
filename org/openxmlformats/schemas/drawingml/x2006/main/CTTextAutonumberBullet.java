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

public interface CTTextAutonumberBullet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextAutonumberBullet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextautonumberbulletd602type");
  
  STTextAutonumberScheme.Enum getType();
  
  STTextAutonumberScheme xgetType();
  
  void setType(STTextAutonumberScheme.Enum paramEnum);
  
  void xsetType(STTextAutonumberScheme paramSTTextAutonumberScheme);
  
  int getStartAt();
  
  STTextBulletStartAtNum xgetStartAt();
  
  boolean isSetStartAt();
  
  void setStartAt(int paramInt);
  
  void xsetStartAt(STTextBulletStartAtNum paramSTTextBulletStartAtNum);
  
  void unsetStartAt();
  
  public static final class Factory {
    public static CTTextAutonumberBullet newInstance() {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.newInstance(CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet newInstance(XmlOptions param1XmlOptions) {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.newInstance(CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static CTTextAutonumberBullet parse(String param1String) throws XmlException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1String, CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1String, CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static CTTextAutonumberBullet parse(File param1File) throws XmlException, IOException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1File, CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1File, CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static CTTextAutonumberBullet parse(URL param1URL) throws XmlException, IOException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1URL, CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1URL, CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static CTTextAutonumberBullet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1InputStream, CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1InputStream, CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static CTTextAutonumberBullet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1Reader, CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1Reader, CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static CTTextAutonumberBullet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static CTTextAutonumberBullet parse(Node param1Node) throws XmlException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1Node, CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1Node, CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static CTTextAutonumberBullet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextAutonumberBullet.type, null);
    }
    
    public static CTTextAutonumberBullet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextAutonumberBullet)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextAutonumberBullet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextAutonumberBullet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextAutonumberBullet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextAutonumberBullet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */