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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface StyleSheetType extends SheetType {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(StyleSheetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stylesheettypeebcbtype");
  
  long getID();
  
  XmlUnsignedInt xgetID();
  
  void setID(long paramLong);
  
  void xsetID(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  String getNameU();
  
  XmlString xgetNameU();
  
  boolean isSetNameU();
  
  void setNameU(String paramString);
  
  void xsetNameU(XmlString paramXmlString);
  
  void unsetNameU();
  
  boolean getIsCustomName();
  
  XmlBoolean xgetIsCustomName();
  
  boolean isSetIsCustomName();
  
  void setIsCustomName(boolean paramBoolean);
  
  void xsetIsCustomName(XmlBoolean paramXmlBoolean);
  
  void unsetIsCustomName();
  
  boolean getIsCustomNameU();
  
  XmlBoolean xgetIsCustomNameU();
  
  boolean isSetIsCustomNameU();
  
  void setIsCustomNameU(boolean paramBoolean);
  
  void xsetIsCustomNameU(XmlBoolean paramXmlBoolean);
  
  void unsetIsCustomNameU();
  
  public static final class Factory {
    public static StyleSheetType newInstance() {
      return (StyleSheetType)POIXMLTypeLoader.newInstance(StyleSheetType.type, null);
    }
    
    public static StyleSheetType newInstance(XmlOptions param1XmlOptions) {
      return (StyleSheetType)POIXMLTypeLoader.newInstance(StyleSheetType.type, param1XmlOptions);
    }
    
    public static StyleSheetType parse(String param1String) throws XmlException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1String, StyleSheetType.type, null);
    }
    
    public static StyleSheetType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1String, StyleSheetType.type, param1XmlOptions);
    }
    
    public static StyleSheetType parse(File param1File) throws XmlException, IOException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1File, StyleSheetType.type, null);
    }
    
    public static StyleSheetType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1File, StyleSheetType.type, param1XmlOptions);
    }
    
    public static StyleSheetType parse(URL param1URL) throws XmlException, IOException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1URL, StyleSheetType.type, null);
    }
    
    public static StyleSheetType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1URL, StyleSheetType.type, param1XmlOptions);
    }
    
    public static StyleSheetType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1InputStream, StyleSheetType.type, null);
    }
    
    public static StyleSheetType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1InputStream, StyleSheetType.type, param1XmlOptions);
    }
    
    public static StyleSheetType parse(Reader param1Reader) throws XmlException, IOException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1Reader, StyleSheetType.type, null);
    }
    
    public static StyleSheetType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1Reader, StyleSheetType.type, param1XmlOptions);
    }
    
    public static StyleSheetType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1XMLStreamReader, StyleSheetType.type, null);
    }
    
    public static StyleSheetType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1XMLStreamReader, StyleSheetType.type, param1XmlOptions);
    }
    
    public static StyleSheetType parse(Node param1Node) throws XmlException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1Node, StyleSheetType.type, null);
    }
    
    public static StyleSheetType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1Node, StyleSheetType.type, param1XmlOptions);
    }
    
    public static StyleSheetType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1XMLInputStream, StyleSheetType.type, null);
    }
    
    public static StyleSheetType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (StyleSheetType)POIXMLTypeLoader.parse(param1XMLInputStream, StyleSheetType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, StyleSheetType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, StyleSheetType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\StyleSheetType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */