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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STTextBulletSizePercent extends STPercentage {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextBulletSizePercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextbulletsizepercentb516type");
  
  public static final class Factory {
    public static STTextBulletSizePercent newValue(Object param1Object) {
      return (STTextBulletSizePercent)STTextBulletSizePercent.type.newValue(param1Object);
    }
    
    public static STTextBulletSizePercent newInstance() {
      return (STTextBulletSizePercent)POIXMLTypeLoader.newInstance(STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent newInstance(XmlOptions param1XmlOptions) {
      return (STTextBulletSizePercent)POIXMLTypeLoader.newInstance(STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static STTextBulletSizePercent parse(String param1String) throws XmlException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1String, STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1String, STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static STTextBulletSizePercent parse(File param1File) throws XmlException, IOException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1File, STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1File, STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static STTextBulletSizePercent parse(URL param1URL) throws XmlException, IOException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1URL, STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1URL, STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static STTextBulletSizePercent parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1InputStream, STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1InputStream, STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static STTextBulletSizePercent parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1Reader, STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1Reader, STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static STTextBulletSizePercent parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static STTextBulletSizePercent parse(Node param1Node) throws XmlException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1Node, STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1Node, STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static STTextBulletSizePercent parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1XMLInputStream, STTextBulletSizePercent.type, null);
    }
    
    public static STTextBulletSizePercent parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextBulletSizePercent)POIXMLTypeLoader.parse(param1XMLInputStream, STTextBulletSizePercent.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextBulletSizePercent.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextBulletSizePercent.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextBulletSizePercent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */