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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface StylesDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(StylesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("styles2732doctype");
  
  CTStyles getStyles();
  
  void setStyles(CTStyles paramCTStyles);
  
  CTStyles addNewStyles();
  
  public static final class Factory {
    public static StylesDocument newInstance() {
      return (StylesDocument)POIXMLTypeLoader.newInstance(StylesDocument.type, null);
    }
    
    public static StylesDocument newInstance(XmlOptions param1XmlOptions) {
      return (StylesDocument)POIXMLTypeLoader.newInstance(StylesDocument.type, param1XmlOptions);
    }
    
    public static StylesDocument parse(String param1String) throws XmlException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1String, StylesDocument.type, null);
    }
    
    public static StylesDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1String, StylesDocument.type, param1XmlOptions);
    }
    
    public static StylesDocument parse(File param1File) throws XmlException, IOException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1File, StylesDocument.type, null);
    }
    
    public static StylesDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1File, StylesDocument.type, param1XmlOptions);
    }
    
    public static StylesDocument parse(URL param1URL) throws XmlException, IOException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1URL, StylesDocument.type, null);
    }
    
    public static StylesDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1URL, StylesDocument.type, param1XmlOptions);
    }
    
    public static StylesDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1InputStream, StylesDocument.type, null);
    }
    
    public static StylesDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1InputStream, StylesDocument.type, param1XmlOptions);
    }
    
    public static StylesDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1Reader, StylesDocument.type, null);
    }
    
    public static StylesDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1Reader, StylesDocument.type, param1XmlOptions);
    }
    
    public static StylesDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, StylesDocument.type, null);
    }
    
    public static StylesDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, StylesDocument.type, param1XmlOptions);
    }
    
    public static StylesDocument parse(Node param1Node) throws XmlException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1Node, StylesDocument.type, null);
    }
    
    public static StylesDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1Node, StylesDocument.type, param1XmlOptions);
    }
    
    public static StylesDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, StylesDocument.type, null);
    }
    
    public static StylesDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (StylesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, StylesDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, StylesDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, StylesDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\StylesDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */