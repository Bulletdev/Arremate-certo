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

public interface CTTcPrBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTcPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttcprbase93e6type");
  
  CTCnf getCnfStyle();
  
  boolean isSetCnfStyle();
  
  void setCnfStyle(CTCnf paramCTCnf);
  
  CTCnf addNewCnfStyle();
  
  void unsetCnfStyle();
  
  CTTblWidth getTcW();
  
  boolean isSetTcW();
  
  void setTcW(CTTblWidth paramCTTblWidth);
  
  CTTblWidth addNewTcW();
  
  void unsetTcW();
  
  CTDecimalNumber getGridSpan();
  
  boolean isSetGridSpan();
  
  void setGridSpan(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewGridSpan();
  
  void unsetGridSpan();
  
  CTHMerge getHMerge();
  
  boolean isSetHMerge();
  
  void setHMerge(CTHMerge paramCTHMerge);
  
  CTHMerge addNewHMerge();
  
  void unsetHMerge();
  
  CTVMerge getVMerge();
  
  boolean isSetVMerge();
  
  void setVMerge(CTVMerge paramCTVMerge);
  
  CTVMerge addNewVMerge();
  
  void unsetVMerge();
  
  CTTcBorders getTcBorders();
  
  boolean isSetTcBorders();
  
  void setTcBorders(CTTcBorders paramCTTcBorders);
  
  CTTcBorders addNewTcBorders();
  
  void unsetTcBorders();
  
  CTShd getShd();
  
  boolean isSetShd();
  
  void setShd(CTShd paramCTShd);
  
  CTShd addNewShd();
  
  void unsetShd();
  
  CTOnOff getNoWrap();
  
  boolean isSetNoWrap();
  
  void setNoWrap(CTOnOff paramCTOnOff);
  
  CTOnOff addNewNoWrap();
  
  void unsetNoWrap();
  
  CTTcMar getTcMar();
  
  boolean isSetTcMar();
  
  void setTcMar(CTTcMar paramCTTcMar);
  
  CTTcMar addNewTcMar();
  
  void unsetTcMar();
  
  CTTextDirection getTextDirection();
  
  boolean isSetTextDirection();
  
  void setTextDirection(CTTextDirection paramCTTextDirection);
  
  CTTextDirection addNewTextDirection();
  
  void unsetTextDirection();
  
  CTOnOff getTcFitText();
  
  boolean isSetTcFitText();
  
  void setTcFitText(CTOnOff paramCTOnOff);
  
  CTOnOff addNewTcFitText();
  
  void unsetTcFitText();
  
  CTVerticalJc getVAlign();
  
  boolean isSetVAlign();
  
  void setVAlign(CTVerticalJc paramCTVerticalJc);
  
  CTVerticalJc addNewVAlign();
  
  void unsetVAlign();
  
  CTOnOff getHideMark();
  
  boolean isSetHideMark();
  
  void setHideMark(CTOnOff paramCTOnOff);
  
  CTOnOff addNewHideMark();
  
  void unsetHideMark();
  
  public static final class Factory {
    public static CTTcPrBase newInstance() {
      return (CTTcPrBase)POIXMLTypeLoader.newInstance(CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase newInstance(XmlOptions param1XmlOptions) {
      return (CTTcPrBase)POIXMLTypeLoader.newInstance(CTTcPrBase.type, param1XmlOptions);
    }
    
    public static CTTcPrBase parse(String param1String) throws XmlException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1String, CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1String, CTTcPrBase.type, param1XmlOptions);
    }
    
    public static CTTcPrBase parse(File param1File) throws XmlException, IOException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1File, CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1File, CTTcPrBase.type, param1XmlOptions);
    }
    
    public static CTTcPrBase parse(URL param1URL) throws XmlException, IOException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1URL, CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1URL, CTTcPrBase.type, param1XmlOptions);
    }
    
    public static CTTcPrBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1InputStream, CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1InputStream, CTTcPrBase.type, param1XmlOptions);
    }
    
    public static CTTcPrBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1Reader, CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1Reader, CTTcPrBase.type, param1XmlOptions);
    }
    
    public static CTTcPrBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTcPrBase.type, param1XmlOptions);
    }
    
    public static CTTcPrBase parse(Node param1Node) throws XmlException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1Node, CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1Node, CTTcPrBase.type, param1XmlOptions);
    }
    
    public static CTTcPrBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTcPrBase.type, null);
    }
    
    public static CTTcPrBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTcPrBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTcPrBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTcPrBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTcPrBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTcPrBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */