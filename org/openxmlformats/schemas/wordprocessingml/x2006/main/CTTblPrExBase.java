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

public interface CTTblPrExBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblPrExBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblprexbasee7eetype");
  
  CTTblWidth getTblW();
  
  boolean isSetTblW();
  
  void setTblW(CTTblWidth paramCTTblWidth);
  
  CTTblWidth addNewTblW();
  
  void unsetTblW();
  
  CTJc getJc();
  
  boolean isSetJc();
  
  void setJc(CTJc paramCTJc);
  
  CTJc addNewJc();
  
  void unsetJc();
  
  CTTblWidth getTblCellSpacing();
  
  boolean isSetTblCellSpacing();
  
  void setTblCellSpacing(CTTblWidth paramCTTblWidth);
  
  CTTblWidth addNewTblCellSpacing();
  
  void unsetTblCellSpacing();
  
  CTTblWidth getTblInd();
  
  boolean isSetTblInd();
  
  void setTblInd(CTTblWidth paramCTTblWidth);
  
  CTTblWidth addNewTblInd();
  
  void unsetTblInd();
  
  CTTblBorders getTblBorders();
  
  boolean isSetTblBorders();
  
  void setTblBorders(CTTblBorders paramCTTblBorders);
  
  CTTblBorders addNewTblBorders();
  
  void unsetTblBorders();
  
  CTShd getShd();
  
  boolean isSetShd();
  
  void setShd(CTShd paramCTShd);
  
  CTShd addNewShd();
  
  void unsetShd();
  
  CTTblLayoutType getTblLayout();
  
  boolean isSetTblLayout();
  
  void setTblLayout(CTTblLayoutType paramCTTblLayoutType);
  
  CTTblLayoutType addNewTblLayout();
  
  void unsetTblLayout();
  
  CTTblCellMar getTblCellMar();
  
  boolean isSetTblCellMar();
  
  void setTblCellMar(CTTblCellMar paramCTTblCellMar);
  
  CTTblCellMar addNewTblCellMar();
  
  void unsetTblCellMar();
  
  CTShortHexNumber getTblLook();
  
  boolean isSetTblLook();
  
  void setTblLook(CTShortHexNumber paramCTShortHexNumber);
  
  CTShortHexNumber addNewTblLook();
  
  void unsetTblLook();
  
  public static final class Factory {
    public static CTTblPrExBase newInstance() {
      return (CTTblPrExBase)POIXMLTypeLoader.newInstance(CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase newInstance(XmlOptions param1XmlOptions) {
      return (CTTblPrExBase)POIXMLTypeLoader.newInstance(CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static CTTblPrExBase parse(String param1String) throws XmlException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1String, CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1String, CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static CTTblPrExBase parse(File param1File) throws XmlException, IOException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1File, CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1File, CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static CTTblPrExBase parse(URL param1URL) throws XmlException, IOException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1URL, CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1URL, CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static CTTblPrExBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1InputStream, CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1InputStream, CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static CTTblPrExBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1Reader, CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1Reader, CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static CTTblPrExBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static CTTblPrExBase parse(Node param1Node) throws XmlException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1Node, CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1Node, CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static CTTblPrExBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblPrExBase.type, null);
    }
    
    public static CTTblPrExBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblPrExBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblPrExBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblPrExBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblPrExBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblPrExBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */