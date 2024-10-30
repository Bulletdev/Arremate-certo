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

public interface CTPPrBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpprbasebaeftype");
  
  CTString getPStyle();
  
  boolean isSetPStyle();
  
  void setPStyle(CTString paramCTString);
  
  CTString addNewPStyle();
  
  void unsetPStyle();
  
  CTOnOff getKeepNext();
  
  boolean isSetKeepNext();
  
  void setKeepNext(CTOnOff paramCTOnOff);
  
  CTOnOff addNewKeepNext();
  
  void unsetKeepNext();
  
  CTOnOff getKeepLines();
  
  boolean isSetKeepLines();
  
  void setKeepLines(CTOnOff paramCTOnOff);
  
  CTOnOff addNewKeepLines();
  
  void unsetKeepLines();
  
  CTOnOff getPageBreakBefore();
  
  boolean isSetPageBreakBefore();
  
  void setPageBreakBefore(CTOnOff paramCTOnOff);
  
  CTOnOff addNewPageBreakBefore();
  
  void unsetPageBreakBefore();
  
  CTFramePr getFramePr();
  
  boolean isSetFramePr();
  
  void setFramePr(CTFramePr paramCTFramePr);
  
  CTFramePr addNewFramePr();
  
  void unsetFramePr();
  
  CTOnOff getWidowControl();
  
  boolean isSetWidowControl();
  
  void setWidowControl(CTOnOff paramCTOnOff);
  
  CTOnOff addNewWidowControl();
  
  void unsetWidowControl();
  
  CTNumPr getNumPr();
  
  boolean isSetNumPr();
  
  void setNumPr(CTNumPr paramCTNumPr);
  
  CTNumPr addNewNumPr();
  
  void unsetNumPr();
  
  CTOnOff getSuppressLineNumbers();
  
  boolean isSetSuppressLineNumbers();
  
  void setSuppressLineNumbers(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSuppressLineNumbers();
  
  void unsetSuppressLineNumbers();
  
  CTPBdr getPBdr();
  
  boolean isSetPBdr();
  
  void setPBdr(CTPBdr paramCTPBdr);
  
  CTPBdr addNewPBdr();
  
  void unsetPBdr();
  
  CTShd getShd();
  
  boolean isSetShd();
  
  void setShd(CTShd paramCTShd);
  
  CTShd addNewShd();
  
  void unsetShd();
  
  CTTabs getTabs();
  
  boolean isSetTabs();
  
  void setTabs(CTTabs paramCTTabs);
  
  CTTabs addNewTabs();
  
  void unsetTabs();
  
  CTOnOff getSuppressAutoHyphens();
  
  boolean isSetSuppressAutoHyphens();
  
  void setSuppressAutoHyphens(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSuppressAutoHyphens();
  
  void unsetSuppressAutoHyphens();
  
  CTOnOff getKinsoku();
  
  boolean isSetKinsoku();
  
  void setKinsoku(CTOnOff paramCTOnOff);
  
  CTOnOff addNewKinsoku();
  
  void unsetKinsoku();
  
  CTOnOff getWordWrap();
  
  boolean isSetWordWrap();
  
  void setWordWrap(CTOnOff paramCTOnOff);
  
  CTOnOff addNewWordWrap();
  
  void unsetWordWrap();
  
  CTOnOff getOverflowPunct();
  
  boolean isSetOverflowPunct();
  
  void setOverflowPunct(CTOnOff paramCTOnOff);
  
  CTOnOff addNewOverflowPunct();
  
  void unsetOverflowPunct();
  
  CTOnOff getTopLinePunct();
  
  boolean isSetTopLinePunct();
  
  void setTopLinePunct(CTOnOff paramCTOnOff);
  
  CTOnOff addNewTopLinePunct();
  
  void unsetTopLinePunct();
  
  CTOnOff getAutoSpaceDE();
  
  boolean isSetAutoSpaceDE();
  
  void setAutoSpaceDE(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAutoSpaceDE();
  
  void unsetAutoSpaceDE();
  
  CTOnOff getAutoSpaceDN();
  
  boolean isSetAutoSpaceDN();
  
  void setAutoSpaceDN(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAutoSpaceDN();
  
  void unsetAutoSpaceDN();
  
  CTOnOff getBidi();
  
  boolean isSetBidi();
  
  void setBidi(CTOnOff paramCTOnOff);
  
  CTOnOff addNewBidi();
  
  void unsetBidi();
  
  CTOnOff getAdjustRightInd();
  
  boolean isSetAdjustRightInd();
  
  void setAdjustRightInd(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAdjustRightInd();
  
  void unsetAdjustRightInd();
  
  CTOnOff getSnapToGrid();
  
  boolean isSetSnapToGrid();
  
  void setSnapToGrid(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSnapToGrid();
  
  void unsetSnapToGrid();
  
  CTSpacing getSpacing();
  
  boolean isSetSpacing();
  
  void setSpacing(CTSpacing paramCTSpacing);
  
  CTSpacing addNewSpacing();
  
  void unsetSpacing();
  
  CTInd getInd();
  
  boolean isSetInd();
  
  void setInd(CTInd paramCTInd);
  
  CTInd addNewInd();
  
  void unsetInd();
  
  CTOnOff getContextualSpacing();
  
  boolean isSetContextualSpacing();
  
  void setContextualSpacing(CTOnOff paramCTOnOff);
  
  CTOnOff addNewContextualSpacing();
  
  void unsetContextualSpacing();
  
  CTOnOff getMirrorIndents();
  
  boolean isSetMirrorIndents();
  
  void setMirrorIndents(CTOnOff paramCTOnOff);
  
  CTOnOff addNewMirrorIndents();
  
  void unsetMirrorIndents();
  
  CTOnOff getSuppressOverlap();
  
  boolean isSetSuppressOverlap();
  
  void setSuppressOverlap(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSuppressOverlap();
  
  void unsetSuppressOverlap();
  
  CTJc getJc();
  
  boolean isSetJc();
  
  void setJc(CTJc paramCTJc);
  
  CTJc addNewJc();
  
  void unsetJc();
  
  CTTextDirection getTextDirection();
  
  boolean isSetTextDirection();
  
  void setTextDirection(CTTextDirection paramCTTextDirection);
  
  CTTextDirection addNewTextDirection();
  
  void unsetTextDirection();
  
  CTTextAlignment getTextAlignment();
  
  boolean isSetTextAlignment();
  
  void setTextAlignment(CTTextAlignment paramCTTextAlignment);
  
  CTTextAlignment addNewTextAlignment();
  
  void unsetTextAlignment();
  
  CTTextboxTightWrap getTextboxTightWrap();
  
  boolean isSetTextboxTightWrap();
  
  void setTextboxTightWrap(CTTextboxTightWrap paramCTTextboxTightWrap);
  
  CTTextboxTightWrap addNewTextboxTightWrap();
  
  void unsetTextboxTightWrap();
  
  CTDecimalNumber getOutlineLvl();
  
  boolean isSetOutlineLvl();
  
  void setOutlineLvl(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewOutlineLvl();
  
  void unsetOutlineLvl();
  
  CTDecimalNumber getDivId();
  
  boolean isSetDivId();
  
  void setDivId(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewDivId();
  
  void unsetDivId();
  
  CTCnf getCnfStyle();
  
  boolean isSetCnfStyle();
  
  void setCnfStyle(CTCnf paramCTCnf);
  
  CTCnf addNewCnfStyle();
  
  void unsetCnfStyle();
  
  public static final class Factory {
    public static CTPPrBase newInstance() {
      return (CTPPrBase)POIXMLTypeLoader.newInstance(CTPPrBase.type, null);
    }
    
    public static CTPPrBase newInstance(XmlOptions param1XmlOptions) {
      return (CTPPrBase)POIXMLTypeLoader.newInstance(CTPPrBase.type, param1XmlOptions);
    }
    
    public static CTPPrBase parse(String param1String) throws XmlException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1String, CTPPrBase.type, null);
    }
    
    public static CTPPrBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1String, CTPPrBase.type, param1XmlOptions);
    }
    
    public static CTPPrBase parse(File param1File) throws XmlException, IOException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1File, CTPPrBase.type, null);
    }
    
    public static CTPPrBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1File, CTPPrBase.type, param1XmlOptions);
    }
    
    public static CTPPrBase parse(URL param1URL) throws XmlException, IOException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1URL, CTPPrBase.type, null);
    }
    
    public static CTPPrBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1URL, CTPPrBase.type, param1XmlOptions);
    }
    
    public static CTPPrBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1InputStream, CTPPrBase.type, null);
    }
    
    public static CTPPrBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1InputStream, CTPPrBase.type, param1XmlOptions);
    }
    
    public static CTPPrBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1Reader, CTPPrBase.type, null);
    }
    
    public static CTPPrBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1Reader, CTPPrBase.type, param1XmlOptions);
    }
    
    public static CTPPrBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPPrBase.type, null);
    }
    
    public static CTPPrBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPPrBase.type, param1XmlOptions);
    }
    
    public static CTPPrBase parse(Node param1Node) throws XmlException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1Node, CTPPrBase.type, null);
    }
    
    public static CTPPrBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1Node, CTPPrBase.type, param1XmlOptions);
    }
    
    public static CTPPrBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTPPrBase.type, null);
    }
    
    public static CTPPrBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPPrBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTPPrBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPPrBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPPrBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTPPrBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */