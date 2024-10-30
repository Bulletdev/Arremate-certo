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

public interface CTTcBorders extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTcBorders.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttcbordersa5fatype");
  
  CTBorder getTop();
  
  boolean isSetTop();
  
  void setTop(CTBorder paramCTBorder);
  
  CTBorder addNewTop();
  
  void unsetTop();
  
  CTBorder getLeft();
  
  boolean isSetLeft();
  
  void setLeft(CTBorder paramCTBorder);
  
  CTBorder addNewLeft();
  
  void unsetLeft();
  
  CTBorder getBottom();
  
  boolean isSetBottom();
  
  void setBottom(CTBorder paramCTBorder);
  
  CTBorder addNewBottom();
  
  void unsetBottom();
  
  CTBorder getRight();
  
  boolean isSetRight();
  
  void setRight(CTBorder paramCTBorder);
  
  CTBorder addNewRight();
  
  void unsetRight();
  
  CTBorder getInsideH();
  
  boolean isSetInsideH();
  
  void setInsideH(CTBorder paramCTBorder);
  
  CTBorder addNewInsideH();
  
  void unsetInsideH();
  
  CTBorder getInsideV();
  
  boolean isSetInsideV();
  
  void setInsideV(CTBorder paramCTBorder);
  
  CTBorder addNewInsideV();
  
  void unsetInsideV();
  
  CTBorder getTl2Br();
  
  boolean isSetTl2Br();
  
  void setTl2Br(CTBorder paramCTBorder);
  
  CTBorder addNewTl2Br();
  
  void unsetTl2Br();
  
  CTBorder getTr2Bl();
  
  boolean isSetTr2Bl();
  
  void setTr2Bl(CTBorder paramCTBorder);
  
  CTBorder addNewTr2Bl();
  
  void unsetTr2Bl();
  
  public static final class Factory {
    public static CTTcBorders newInstance() {
      return (CTTcBorders)POIXMLTypeLoader.newInstance(CTTcBorders.type, null);
    }
    
    public static CTTcBorders newInstance(XmlOptions param1XmlOptions) {
      return (CTTcBorders)POIXMLTypeLoader.newInstance(CTTcBorders.type, param1XmlOptions);
    }
    
    public static CTTcBorders parse(String param1String) throws XmlException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1String, CTTcBorders.type, null);
    }
    
    public static CTTcBorders parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1String, CTTcBorders.type, param1XmlOptions);
    }
    
    public static CTTcBorders parse(File param1File) throws XmlException, IOException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1File, CTTcBorders.type, null);
    }
    
    public static CTTcBorders parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1File, CTTcBorders.type, param1XmlOptions);
    }
    
    public static CTTcBorders parse(URL param1URL) throws XmlException, IOException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1URL, CTTcBorders.type, null);
    }
    
    public static CTTcBorders parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1URL, CTTcBorders.type, param1XmlOptions);
    }
    
    public static CTTcBorders parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1InputStream, CTTcBorders.type, null);
    }
    
    public static CTTcBorders parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1InputStream, CTTcBorders.type, param1XmlOptions);
    }
    
    public static CTTcBorders parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1Reader, CTTcBorders.type, null);
    }
    
    public static CTTcBorders parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1Reader, CTTcBorders.type, param1XmlOptions);
    }
    
    public static CTTcBorders parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTcBorders.type, null);
    }
    
    public static CTTcBorders parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTcBorders.type, param1XmlOptions);
    }
    
    public static CTTcBorders parse(Node param1Node) throws XmlException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1Node, CTTcBorders.type, null);
    }
    
    public static CTTcBorders parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1Node, CTTcBorders.type, param1XmlOptions);
    }
    
    public static CTTcBorders parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1XMLInputStream, CTTcBorders.type, null);
    }
    
    public static CTTcBorders parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTcBorders)POIXMLTypeLoader.parse(param1XMLInputStream, CTTcBorders.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTcBorders.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTcBorders.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTcBorders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */