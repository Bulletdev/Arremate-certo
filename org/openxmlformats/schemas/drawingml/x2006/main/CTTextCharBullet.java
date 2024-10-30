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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTextCharBullet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextCharBullet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextcharbullet3c20type");
  
  String getChar();
  
  XmlString xgetChar();
  
  void setChar(String paramString);
  
  void xsetChar(XmlString paramXmlString);
  
  public static final class Factory {
    public static CTTextCharBullet newInstance() {
      return (CTTextCharBullet)POIXMLTypeLoader.newInstance(CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet newInstance(XmlOptions param1XmlOptions) {
      return (CTTextCharBullet)POIXMLTypeLoader.newInstance(CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static CTTextCharBullet parse(String param1String) throws XmlException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1String, CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1String, CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static CTTextCharBullet parse(File param1File) throws XmlException, IOException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1File, CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1File, CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static CTTextCharBullet parse(URL param1URL) throws XmlException, IOException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1URL, CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1URL, CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static CTTextCharBullet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1InputStream, CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1InputStream, CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static CTTextCharBullet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1Reader, CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1Reader, CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static CTTextCharBullet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static CTTextCharBullet parse(Node param1Node) throws XmlException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1Node, CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1Node, CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static CTTextCharBullet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextCharBullet.type, null);
    }
    
    public static CTTextCharBullet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextCharBullet)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextCharBullet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextCharBullet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextCharBullet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextCharBullet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */