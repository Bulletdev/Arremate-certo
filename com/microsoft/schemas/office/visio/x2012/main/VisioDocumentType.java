package com.microsoft.schemas.office.visio.x2012.main;

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

public interface VisioDocumentType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(VisioDocumentType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("visiodocumenttypebfcatype");
  
  DocumentSettingsType getDocumentSettings();
  
  boolean isSetDocumentSettings();
  
  void setDocumentSettings(DocumentSettingsType paramDocumentSettingsType);
  
  DocumentSettingsType addNewDocumentSettings();
  
  void unsetDocumentSettings();
  
  ColorsType getColors();
  
  boolean isSetColors();
  
  void setColors(ColorsType paramColorsType);
  
  ColorsType addNewColors();
  
  void unsetColors();
  
  FaceNamesType getFaceNames();
  
  boolean isSetFaceNames();
  
  void setFaceNames(FaceNamesType paramFaceNamesType);
  
  FaceNamesType addNewFaceNames();
  
  void unsetFaceNames();
  
  StyleSheetsType getStyleSheets();
  
  boolean isSetStyleSheets();
  
  void setStyleSheets(StyleSheetsType paramStyleSheetsType);
  
  StyleSheetsType addNewStyleSheets();
  
  void unsetStyleSheets();
  
  DocumentSheetType getDocumentSheet();
  
  boolean isSetDocumentSheet();
  
  void setDocumentSheet(DocumentSheetType paramDocumentSheetType);
  
  DocumentSheetType addNewDocumentSheet();
  
  void unsetDocumentSheet();
  
  EventListType getEventList();
  
  boolean isSetEventList();
  
  void setEventList(EventListType paramEventListType);
  
  EventListType addNewEventList();
  
  void unsetEventList();
  
  HeaderFooterType getHeaderFooter();
  
  boolean isSetHeaderFooter();
  
  void setHeaderFooter(HeaderFooterType paramHeaderFooterType);
  
  HeaderFooterType addNewHeaderFooter();
  
  void unsetHeaderFooter();
  
  PublishSettingsType getPublishSettings();
  
  boolean isSetPublishSettings();
  
  void setPublishSettings(PublishSettingsType paramPublishSettingsType);
  
  PublishSettingsType addNewPublishSettings();
  
  void unsetPublishSettings();
  
  public static final class Factory {
    public static VisioDocumentType newInstance() {
      return (VisioDocumentType)POIXMLTypeLoader.newInstance(VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType newInstance(XmlOptions param1XmlOptions) {
      return (VisioDocumentType)POIXMLTypeLoader.newInstance(VisioDocumentType.type, param1XmlOptions);
    }
    
    public static VisioDocumentType parse(String param1String) throws XmlException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1String, VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1String, VisioDocumentType.type, param1XmlOptions);
    }
    
    public static VisioDocumentType parse(File param1File) throws XmlException, IOException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1File, VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1File, VisioDocumentType.type, param1XmlOptions);
    }
    
    public static VisioDocumentType parse(URL param1URL) throws XmlException, IOException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1URL, VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1URL, VisioDocumentType.type, param1XmlOptions);
    }
    
    public static VisioDocumentType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1InputStream, VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1InputStream, VisioDocumentType.type, param1XmlOptions);
    }
    
    public static VisioDocumentType parse(Reader param1Reader) throws XmlException, IOException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1Reader, VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1Reader, VisioDocumentType.type, param1XmlOptions);
    }
    
    public static VisioDocumentType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1XMLStreamReader, VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1XMLStreamReader, VisioDocumentType.type, param1XmlOptions);
    }
    
    public static VisioDocumentType parse(Node param1Node) throws XmlException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1Node, VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1Node, VisioDocumentType.type, param1XmlOptions);
    }
    
    public static VisioDocumentType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1XMLInputStream, VisioDocumentType.type, null);
    }
    
    public static VisioDocumentType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (VisioDocumentType)POIXMLTypeLoader.parse(param1XMLInputStream, VisioDocumentType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, VisioDocumentType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, VisioDocumentType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\VisioDocumentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */