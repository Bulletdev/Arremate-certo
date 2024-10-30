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

public interface CTTblBorders extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblBorders.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblborders459ftype");
  
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
  
  public static final class Factory {
    public static CTTblBorders newInstance() {
      return (CTTblBorders)POIXMLTypeLoader.newInstance(CTTblBorders.type, null);
    }
    
    public static CTTblBorders newInstance(XmlOptions param1XmlOptions) {
      return (CTTblBorders)POIXMLTypeLoader.newInstance(CTTblBorders.type, param1XmlOptions);
    }
    
    public static CTTblBorders parse(String param1String) throws XmlException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1String, CTTblBorders.type, null);
    }
    
    public static CTTblBorders parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1String, CTTblBorders.type, param1XmlOptions);
    }
    
    public static CTTblBorders parse(File param1File) throws XmlException, IOException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1File, CTTblBorders.type, null);
    }
    
    public static CTTblBorders parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1File, CTTblBorders.type, param1XmlOptions);
    }
    
    public static CTTblBorders parse(URL param1URL) throws XmlException, IOException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1URL, CTTblBorders.type, null);
    }
    
    public static CTTblBorders parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1URL, CTTblBorders.type, param1XmlOptions);
    }
    
    public static CTTblBorders parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1InputStream, CTTblBorders.type, null);
    }
    
    public static CTTblBorders parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1InputStream, CTTblBorders.type, param1XmlOptions);
    }
    
    public static CTTblBorders parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1Reader, CTTblBorders.type, null);
    }
    
    public static CTTblBorders parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1Reader, CTTblBorders.type, param1XmlOptions);
    }
    
    public static CTTblBorders parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblBorders.type, null);
    }
    
    public static CTTblBorders parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblBorders.type, param1XmlOptions);
    }
    
    public static CTTblBorders parse(Node param1Node) throws XmlException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1Node, CTTblBorders.type, null);
    }
    
    public static CTTblBorders parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1Node, CTTblBorders.type, param1XmlOptions);
    }
    
    public static CTTblBorders parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblBorders.type, null);
    }
    
    public static CTTblBorders parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblBorders)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblBorders.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblBorders.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblBorders.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblBorders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */