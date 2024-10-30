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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBorder extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBorder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctborderf935type");
  
  CTBorderPr getLeft();
  
  boolean isSetLeft();
  
  void setLeft(CTBorderPr paramCTBorderPr);
  
  CTBorderPr addNewLeft();
  
  void unsetLeft();
  
  CTBorderPr getRight();
  
  boolean isSetRight();
  
  void setRight(CTBorderPr paramCTBorderPr);
  
  CTBorderPr addNewRight();
  
  void unsetRight();
  
  CTBorderPr getTop();
  
  boolean isSetTop();
  
  void setTop(CTBorderPr paramCTBorderPr);
  
  CTBorderPr addNewTop();
  
  void unsetTop();
  
  CTBorderPr getBottom();
  
  boolean isSetBottom();
  
  void setBottom(CTBorderPr paramCTBorderPr);
  
  CTBorderPr addNewBottom();
  
  void unsetBottom();
  
  CTBorderPr getDiagonal();
  
  boolean isSetDiagonal();
  
  void setDiagonal(CTBorderPr paramCTBorderPr);
  
  CTBorderPr addNewDiagonal();
  
  void unsetDiagonal();
  
  CTBorderPr getVertical();
  
  boolean isSetVertical();
  
  void setVertical(CTBorderPr paramCTBorderPr);
  
  CTBorderPr addNewVertical();
  
  void unsetVertical();
  
  CTBorderPr getHorizontal();
  
  boolean isSetHorizontal();
  
  void setHorizontal(CTBorderPr paramCTBorderPr);
  
  CTBorderPr addNewHorizontal();
  
  void unsetHorizontal();
  
  boolean getDiagonalUp();
  
  XmlBoolean xgetDiagonalUp();
  
  boolean isSetDiagonalUp();
  
  void setDiagonalUp(boolean paramBoolean);
  
  void xsetDiagonalUp(XmlBoolean paramXmlBoolean);
  
  void unsetDiagonalUp();
  
  boolean getDiagonalDown();
  
  XmlBoolean xgetDiagonalDown();
  
  boolean isSetDiagonalDown();
  
  void setDiagonalDown(boolean paramBoolean);
  
  void xsetDiagonalDown(XmlBoolean paramXmlBoolean);
  
  void unsetDiagonalDown();
  
  boolean getOutline();
  
  XmlBoolean xgetOutline();
  
  boolean isSetOutline();
  
  void setOutline(boolean paramBoolean);
  
  void xsetOutline(XmlBoolean paramXmlBoolean);
  
  void unsetOutline();
  
  public static final class Factory {
    public static CTBorder newInstance() {
      return (CTBorder)POIXMLTypeLoader.newInstance(CTBorder.type, null);
    }
    
    public static CTBorder newInstance(XmlOptions param1XmlOptions) {
      return (CTBorder)POIXMLTypeLoader.newInstance(CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(String param1String) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1String, CTBorder.type, null);
    }
    
    public static CTBorder parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1String, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(File param1File) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1File, CTBorder.type, null);
    }
    
    public static CTBorder parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1File, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(URL param1URL) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1URL, CTBorder.type, null);
    }
    
    public static CTBorder parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1URL, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1InputStream, CTBorder.type, null);
    }
    
    public static CTBorder parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1InputStream, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1Reader, CTBorder.type, null);
    }
    
    public static CTBorder parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1Reader, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBorder.type, null);
    }
    
    public static CTBorder parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(Node param1Node) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1Node, CTBorder.type, null);
    }
    
    public static CTBorder parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1Node, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBorder)POIXMLTypeLoader.parse(param1XMLInputStream, CTBorder.type, null);
    }
    
    public static CTBorder parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBorder)POIXMLTypeLoader.parse(param1XMLInputStream, CTBorder.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBorder.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBorder.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTBorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */