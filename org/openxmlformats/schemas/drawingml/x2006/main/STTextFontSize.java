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

public interface STTextFontSize extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextFontSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextfontsizeb3a8type");
  
  public static final class Factory {
    public static STTextFontSize newValue(Object param1Object) {
      return (STTextFontSize)STTextFontSize.type.newValue(param1Object);
    }
    
    public static STTextFontSize newInstance() {
      return (STTextFontSize)POIXMLTypeLoader.newInstance(STTextFontSize.type, null);
    }
    
    public static STTextFontSize newInstance(XmlOptions param1XmlOptions) {
      return (STTextFontSize)POIXMLTypeLoader.newInstance(STTextFontSize.type, param1XmlOptions);
    }
    
    public static STTextFontSize parse(String param1String) throws XmlException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1String, STTextFontSize.type, null);
    }
    
    public static STTextFontSize parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1String, STTextFontSize.type, param1XmlOptions);
    }
    
    public static STTextFontSize parse(File param1File) throws XmlException, IOException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1File, STTextFontSize.type, null);
    }
    
    public static STTextFontSize parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1File, STTextFontSize.type, param1XmlOptions);
    }
    
    public static STTextFontSize parse(URL param1URL) throws XmlException, IOException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1URL, STTextFontSize.type, null);
    }
    
    public static STTextFontSize parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1URL, STTextFontSize.type, param1XmlOptions);
    }
    
    public static STTextFontSize parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1InputStream, STTextFontSize.type, null);
    }
    
    public static STTextFontSize parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1InputStream, STTextFontSize.type, param1XmlOptions);
    }
    
    public static STTextFontSize parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1Reader, STTextFontSize.type, null);
    }
    
    public static STTextFontSize parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1Reader, STTextFontSize.type, param1XmlOptions);
    }
    
    public static STTextFontSize parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextFontSize.type, null);
    }
    
    public static STTextFontSize parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextFontSize.type, param1XmlOptions);
    }
    
    public static STTextFontSize parse(Node param1Node) throws XmlException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1Node, STTextFontSize.type, null);
    }
    
    public static STTextFontSize parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1Node, STTextFontSize.type, param1XmlOptions);
    }
    
    public static STTextFontSize parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1XMLInputStream, STTextFontSize.type, null);
    }
    
    public static STTextFontSize parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextFontSize)POIXMLTypeLoader.parse(param1XMLInputStream, STTextFontSize.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextFontSize.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextFontSize.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextFontSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */