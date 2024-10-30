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

public interface CTTblPrBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblprbaseeba1type");
  
  CTString getTblStyle();
  
  boolean isSetTblStyle();
  
  void setTblStyle(CTString paramCTString);
  
  CTString addNewTblStyle();
  
  void unsetTblStyle();
  
  CTTblPPr getTblpPr();
  
  boolean isSetTblpPr();
  
  void setTblpPr(CTTblPPr paramCTTblPPr);
  
  CTTblPPr addNewTblpPr();
  
  void unsetTblpPr();
  
  CTTblOverlap getTblOverlap();
  
  boolean isSetTblOverlap();
  
  void setTblOverlap(CTTblOverlap paramCTTblOverlap);
  
  CTTblOverlap addNewTblOverlap();
  
  void unsetTblOverlap();
  
  CTOnOff getBidiVisual();
  
  boolean isSetBidiVisual();
  
  void setBidiVisual(CTOnOff paramCTOnOff);
  
  CTOnOff addNewBidiVisual();
  
  void unsetBidiVisual();
  
  CTDecimalNumber getTblStyleRowBandSize();
  
  boolean isSetTblStyleRowBandSize();
  
  void setTblStyleRowBandSize(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewTblStyleRowBandSize();
  
  void unsetTblStyleRowBandSize();
  
  CTDecimalNumber getTblStyleColBandSize();
  
  boolean isSetTblStyleColBandSize();
  
  void setTblStyleColBandSize(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewTblStyleColBandSize();
  
  void unsetTblStyleColBandSize();
  
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
    public static CTTblPrBase newInstance() {
      return (CTTblPrBase)POIXMLTypeLoader.newInstance(CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase newInstance(XmlOptions param1XmlOptions) {
      return (CTTblPrBase)POIXMLTypeLoader.newInstance(CTTblPrBase.type, param1XmlOptions);
    }
    
    public static CTTblPrBase parse(String param1String) throws XmlException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1String, CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1String, CTTblPrBase.type, param1XmlOptions);
    }
    
    public static CTTblPrBase parse(File param1File) throws XmlException, IOException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1File, CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1File, CTTblPrBase.type, param1XmlOptions);
    }
    
    public static CTTblPrBase parse(URL param1URL) throws XmlException, IOException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1URL, CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1URL, CTTblPrBase.type, param1XmlOptions);
    }
    
    public static CTTblPrBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1InputStream, CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1InputStream, CTTblPrBase.type, param1XmlOptions);
    }
    
    public static CTTblPrBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1Reader, CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1Reader, CTTblPrBase.type, param1XmlOptions);
    }
    
    public static CTTblPrBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblPrBase.type, param1XmlOptions);
    }
    
    public static CTTblPrBase parse(Node param1Node) throws XmlException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1Node, CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1Node, CTTblPrBase.type, param1XmlOptions);
    }
    
    public static CTTblPrBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblPrBase.type, null);
    }
    
    public static CTTblPrBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblPrBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblPrBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblPrBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblPrBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblPrBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */