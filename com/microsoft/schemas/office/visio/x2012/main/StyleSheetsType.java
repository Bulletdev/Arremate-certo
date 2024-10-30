package com.microsoft.schemas.office.visio.x2012.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface StyleSheetsType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(StyleSheetsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stylesheetstypeb706type");
  
  List<StyleSheetType> getStyleSheetList();
  
  StyleSheetType[] getStyleSheetArray();
  
  StyleSheetType getStyleSheetArray(int paramInt);
  
  int sizeOfStyleSheetArray();
  
  void setStyleSheetArray(StyleSheetType[] paramArrayOfStyleSheetType);
  
  void setStyleSheetArray(int paramInt, StyleSheetType paramStyleSheetType);
  
  StyleSheetType insertNewStyleSheet(int paramInt);
  
  StyleSheetType addNewStyleSheet();
  
  void removeStyleSheet(int paramInt);
  
  public static final class Factory {
    public static StyleSheetsType newInstance() {
      return (StyleSheetsType)POIXMLTypeLoader.newInstance(StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType newInstance(XmlOptions param1XmlOptions) {
      return (StyleSheetsType)POIXMLTypeLoader.newInstance(StyleSheetsType.type, param1XmlOptions);
    }
    
    public static StyleSheetsType parse(String param1String) throws XmlException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1String, StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1String, StyleSheetsType.type, param1XmlOptions);
    }
    
    public static StyleSheetsType parse(File param1File) throws XmlException, IOException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1File, StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1File, StyleSheetsType.type, param1XmlOptions);
    }
    
    public static StyleSheetsType parse(URL param1URL) throws XmlException, IOException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1URL, StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1URL, StyleSheetsType.type, param1XmlOptions);
    }
    
    public static StyleSheetsType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1InputStream, StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1InputStream, StyleSheetsType.type, param1XmlOptions);
    }
    
    public static StyleSheetsType parse(Reader param1Reader) throws XmlException, IOException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1Reader, StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1Reader, StyleSheetsType.type, param1XmlOptions);
    }
    
    public static StyleSheetsType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1XMLStreamReader, StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1XMLStreamReader, StyleSheetsType.type, param1XmlOptions);
    }
    
    public static StyleSheetsType parse(Node param1Node) throws XmlException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1Node, StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1Node, StyleSheetsType.type, param1XmlOptions);
    }
    
    public static StyleSheetsType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1XMLInputStream, StyleSheetsType.type, null);
    }
    
    public static StyleSheetsType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (StyleSheetsType)POIXMLTypeLoader.parse(param1XMLInputStream, StyleSheetsType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, StyleSheetsType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, StyleSheetsType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\StyleSheetsType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */