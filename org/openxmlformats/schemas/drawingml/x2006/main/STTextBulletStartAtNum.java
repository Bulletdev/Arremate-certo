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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STTextBulletStartAtNum extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextBulletStartAtNum.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextbulletstartatnum562btype");
  
  public static final class Factory {
    public static STTextBulletStartAtNum newValue(Object param1Object) {
      return (STTextBulletStartAtNum)STTextBulletStartAtNum.type.newValue(param1Object);
    }
    
    public static STTextBulletStartAtNum newInstance() {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.newInstance(STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum newInstance(XmlOptions param1XmlOptions) {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.newInstance(STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static STTextBulletStartAtNum parse(String param1String) throws XmlException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1String, STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1String, STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static STTextBulletStartAtNum parse(File param1File) throws XmlException, IOException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1File, STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1File, STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static STTextBulletStartAtNum parse(URL param1URL) throws XmlException, IOException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1URL, STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1URL, STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static STTextBulletStartAtNum parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1InputStream, STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1InputStream, STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static STTextBulletStartAtNum parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1Reader, STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1Reader, STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static STTextBulletStartAtNum parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static STTextBulletStartAtNum parse(Node param1Node) throws XmlException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1Node, STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1Node, STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static STTextBulletStartAtNum parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1XMLInputStream, STTextBulletStartAtNum.type, null);
    }
    
    public static STTextBulletStartAtNum parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextBulletStartAtNum)POIXMLTypeLoader.parse(param1XMLInputStream, STTextBulletStartAtNum.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextBulletStartAtNum.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextBulletStartAtNum.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextBulletStartAtNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */