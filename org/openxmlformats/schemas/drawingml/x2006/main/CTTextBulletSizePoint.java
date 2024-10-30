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

public interface CTTextBulletSizePoint extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextBulletSizePoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextbulletsizepointe4f1type");
  
  int getVal();
  
  STTextFontSize xgetVal();
  
  boolean isSetVal();
  
  void setVal(int paramInt);
  
  void xsetVal(STTextFontSize paramSTTextFontSize);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTTextBulletSizePoint newInstance() {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.newInstance(CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint newInstance(XmlOptions param1XmlOptions) {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.newInstance(CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePoint parse(String param1String) throws XmlException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1String, CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1String, CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePoint parse(File param1File) throws XmlException, IOException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1File, CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1File, CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePoint parse(URL param1URL) throws XmlException, IOException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1URL, CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1URL, CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePoint parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1InputStream, CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1InputStream, CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePoint parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1Reader, CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1Reader, CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePoint parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePoint parse(Node param1Node) throws XmlException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1Node, CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1Node, CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static CTTextBulletSizePoint parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextBulletSizePoint.type, null);
    }
    
    public static CTTextBulletSizePoint parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextBulletSizePoint)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextBulletSizePoint.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextBulletSizePoint.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextBulletSizePoint.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextBulletSizePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */