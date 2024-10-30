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

public interface CTTextBulletSizePercent extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextBulletSizePercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextbulletsizepercent9b26type");
  
  int getVal();
  
  STTextBulletSizePercent xgetVal();
  
  boolean isSetVal();
  
  void setVal(int paramInt);
  
  void xsetVal(STTextBulletSizePercent paramSTTextBulletSizePercent);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTTextBulletSizePercent newInstance() {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.newInstance(CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent newInstance(XmlOptions param1XmlOptions) {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.newInstance(CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePercent parse(String param1String) throws XmlException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1String, CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1String, CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePercent parse(File param1File) throws XmlException, IOException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1File, CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1File, CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePercent parse(URL param1URL) throws XmlException, IOException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1URL, CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1URL, CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePercent parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1InputStream, CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1InputStream, CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePercent parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1Reader, CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1Reader, CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePercent parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePercent parse(Node param1Node) throws XmlException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1Node, CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1Node, CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePercent parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextBulletSizePercent.type, null);
    }
    
    public static CTTextBulletSizePercent parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextBulletSizePercent)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextBulletSizePercent.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextBulletSizePercent.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextBulletSizePercent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */