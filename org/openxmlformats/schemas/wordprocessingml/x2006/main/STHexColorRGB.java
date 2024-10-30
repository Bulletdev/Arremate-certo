package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STHexColorRGB extends XmlHexBinary {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHexColorRGB.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthexcolorrgbd59dtype");
  
  public static final class Factory {
    public static STHexColorRGB newValue(Object param1Object) {
      return (STHexColorRGB)STHexColorRGB.type.newValue(param1Object);
    }
    
    public static STHexColorRGB newInstance() {
      return (STHexColorRGB)POIXMLTypeLoader.newInstance(STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB newInstance(XmlOptions param1XmlOptions) {
      return (STHexColorRGB)POIXMLTypeLoader.newInstance(STHexColorRGB.type, param1XmlOptions);
    }
    
    public static STHexColorRGB parse(String param1String) throws XmlException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1String, STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1String, STHexColorRGB.type, param1XmlOptions);
    }
    
    public static STHexColorRGB parse(File param1File) throws XmlException, IOException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1File, STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1File, STHexColorRGB.type, param1XmlOptions);
    }
    
    public static STHexColorRGB parse(URL param1URL) throws XmlException, IOException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1URL, STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1URL, STHexColorRGB.type, param1XmlOptions);
    }
    
    public static STHexColorRGB parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1InputStream, STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1InputStream, STHexColorRGB.type, param1XmlOptions);
    }
    
    public static STHexColorRGB parse(Reader param1Reader) throws XmlException, IOException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1Reader, STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1Reader, STHexColorRGB.type, param1XmlOptions);
    }
    
    public static STHexColorRGB parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1XMLStreamReader, STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1XMLStreamReader, STHexColorRGB.type, param1XmlOptions);
    }
    
    public static STHexColorRGB parse(Node param1Node) throws XmlException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1Node, STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1Node, STHexColorRGB.type, param1XmlOptions);
    }
    
    public static STHexColorRGB parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1XMLInputStream, STHexColorRGB.type, null);
    }
    
    public static STHexColorRGB parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHexColorRGB)POIXMLTypeLoader.parse(param1XMLInputStream, STHexColorRGB.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHexColorRGB.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHexColorRGB.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STHexColorRGB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */