package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface StyleSheetDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(StyleSheetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stylesheet5d8bdoctype");
  
  CTStylesheet getStyleSheet();
  
  void setStyleSheet(CTStylesheet paramCTStylesheet);
  
  CTStylesheet addNewStyleSheet();
  
  public static final class Factory {
    public static StyleSheetDocument newInstance() {
      return (StyleSheetDocument)POIXMLTypeLoader.newInstance(StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument newInstance(XmlOptions param1XmlOptions) {
      return (StyleSheetDocument)POIXMLTypeLoader.newInstance(StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static StyleSheetDocument parse(String param1String) throws XmlException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1String, StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1String, StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static StyleSheetDocument parse(File param1File) throws XmlException, IOException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1File, StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1File, StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static StyleSheetDocument parse(URL param1URL) throws XmlException, IOException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1URL, StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1URL, StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static StyleSheetDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1InputStream, StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1InputStream, StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static StyleSheetDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1Reader, StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1Reader, StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static StyleSheetDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static StyleSheetDocument parse(Node param1Node) throws XmlException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1Node, StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1Node, StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static StyleSheetDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1XMLInputStream, StyleSheetDocument.type, null);
    }
    
    public static StyleSheetDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (StyleSheetDocument)POIXMLTypeLoader.parse(param1XMLInputStream, StyleSheetDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, StyleSheetDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, StyleSheetDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\StyleSheetDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */