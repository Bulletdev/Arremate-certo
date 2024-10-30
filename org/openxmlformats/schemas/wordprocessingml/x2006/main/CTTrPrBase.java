package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTTrPrBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTrPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttrprbase5d77type");
  
  List<CTCnf> getCnfStyleList();
  
  CTCnf[] getCnfStyleArray();
  
  CTCnf getCnfStyleArray(int paramInt);
  
  int sizeOfCnfStyleArray();
  
  void setCnfStyleArray(CTCnf[] paramArrayOfCTCnf);
  
  void setCnfStyleArray(int paramInt, CTCnf paramCTCnf);
  
  CTCnf insertNewCnfStyle(int paramInt);
  
  CTCnf addNewCnfStyle();
  
  void removeCnfStyle(int paramInt);
  
  List<CTDecimalNumber> getDivIdList();
  
  CTDecimalNumber[] getDivIdArray();
  
  CTDecimalNumber getDivIdArray(int paramInt);
  
  int sizeOfDivIdArray();
  
  void setDivIdArray(CTDecimalNumber[] paramArrayOfCTDecimalNumber);
  
  void setDivIdArray(int paramInt, CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber insertNewDivId(int paramInt);
  
  CTDecimalNumber addNewDivId();
  
  void removeDivId(int paramInt);
  
  List<CTDecimalNumber> getGridBeforeList();
  
  CTDecimalNumber[] getGridBeforeArray();
  
  CTDecimalNumber getGridBeforeArray(int paramInt);
  
  int sizeOfGridBeforeArray();
  
  void setGridBeforeArray(CTDecimalNumber[] paramArrayOfCTDecimalNumber);
  
  void setGridBeforeArray(int paramInt, CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber insertNewGridBefore(int paramInt);
  
  CTDecimalNumber addNewGridBefore();
  
  void removeGridBefore(int paramInt);
  
  List<CTDecimalNumber> getGridAfterList();
  
  CTDecimalNumber[] getGridAfterArray();
  
  CTDecimalNumber getGridAfterArray(int paramInt);
  
  int sizeOfGridAfterArray();
  
  void setGridAfterArray(CTDecimalNumber[] paramArrayOfCTDecimalNumber);
  
  void setGridAfterArray(int paramInt, CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber insertNewGridAfter(int paramInt);
  
  CTDecimalNumber addNewGridAfter();
  
  void removeGridAfter(int paramInt);
  
  List<CTTblWidth> getWBeforeList();
  
  CTTblWidth[] getWBeforeArray();
  
  CTTblWidth getWBeforeArray(int paramInt);
  
  int sizeOfWBeforeArray();
  
  void setWBeforeArray(CTTblWidth[] paramArrayOfCTTblWidth);
  
  void setWBeforeArray(int paramInt, CTTblWidth paramCTTblWidth);
  
  CTTblWidth insertNewWBefore(int paramInt);
  
  CTTblWidth addNewWBefore();
  
  void removeWBefore(int paramInt);
  
  List<CTTblWidth> getWAfterList();
  
  CTTblWidth[] getWAfterArray();
  
  CTTblWidth getWAfterArray(int paramInt);
  
  int sizeOfWAfterArray();
  
  void setWAfterArray(CTTblWidth[] paramArrayOfCTTblWidth);
  
  void setWAfterArray(int paramInt, CTTblWidth paramCTTblWidth);
  
  CTTblWidth insertNewWAfter(int paramInt);
  
  CTTblWidth addNewWAfter();
  
  void removeWAfter(int paramInt);
  
  List<CTOnOff> getCantSplitList();
  
  CTOnOff[] getCantSplitArray();
  
  CTOnOff getCantSplitArray(int paramInt);
  
  int sizeOfCantSplitArray();
  
  void setCantSplitArray(CTOnOff[] paramArrayOfCTOnOff);
  
  void setCantSplitArray(int paramInt, CTOnOff paramCTOnOff);
  
  CTOnOff insertNewCantSplit(int paramInt);
  
  CTOnOff addNewCantSplit();
  
  void removeCantSplit(int paramInt);
  
  List<CTHeight> getTrHeightList();
  
  CTHeight[] getTrHeightArray();
  
  CTHeight getTrHeightArray(int paramInt);
  
  int sizeOfTrHeightArray();
  
  void setTrHeightArray(CTHeight[] paramArrayOfCTHeight);
  
  void setTrHeightArray(int paramInt, CTHeight paramCTHeight);
  
  CTHeight insertNewTrHeight(int paramInt);
  
  CTHeight addNewTrHeight();
  
  void removeTrHeight(int paramInt);
  
  List<CTOnOff> getTblHeaderList();
  
  CTOnOff[] getTblHeaderArray();
  
  CTOnOff getTblHeaderArray(int paramInt);
  
  int sizeOfTblHeaderArray();
  
  void setTblHeaderArray(CTOnOff[] paramArrayOfCTOnOff);
  
  void setTblHeaderArray(int paramInt, CTOnOff paramCTOnOff);
  
  CTOnOff insertNewTblHeader(int paramInt);
  
  CTOnOff addNewTblHeader();
  
  void removeTblHeader(int paramInt);
  
  List<CTTblWidth> getTblCellSpacingList();
  
  CTTblWidth[] getTblCellSpacingArray();
  
  CTTblWidth getTblCellSpacingArray(int paramInt);
  
  int sizeOfTblCellSpacingArray();
  
  void setTblCellSpacingArray(CTTblWidth[] paramArrayOfCTTblWidth);
  
  void setTblCellSpacingArray(int paramInt, CTTblWidth paramCTTblWidth);
  
  CTTblWidth insertNewTblCellSpacing(int paramInt);
  
  CTTblWidth addNewTblCellSpacing();
  
  void removeTblCellSpacing(int paramInt);
  
  List<CTJc> getJcList();
  
  CTJc[] getJcArray();
  
  CTJc getJcArray(int paramInt);
  
  int sizeOfJcArray();
  
  void setJcArray(CTJc[] paramArrayOfCTJc);
  
  void setJcArray(int paramInt, CTJc paramCTJc);
  
  CTJc insertNewJc(int paramInt);
  
  CTJc addNewJc();
  
  void removeJc(int paramInt);
  
  List<CTOnOff> getHiddenList();
  
  CTOnOff[] getHiddenArray();
  
  CTOnOff getHiddenArray(int paramInt);
  
  int sizeOfHiddenArray();
  
  void setHiddenArray(CTOnOff[] paramArrayOfCTOnOff);
  
  void setHiddenArray(int paramInt, CTOnOff paramCTOnOff);
  
  CTOnOff insertNewHidden(int paramInt);
  
  CTOnOff addNewHidden();
  
  void removeHidden(int paramInt);
  
  public static final class Factory {
    public static CTTrPrBase newInstance() {
      return (CTTrPrBase)POIXMLTypeLoader.newInstance(CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase newInstance(XmlOptions param1XmlOptions) {
      return (CTTrPrBase)POIXMLTypeLoader.newInstance(CTTrPrBase.type, param1XmlOptions);
    }
    
    public static CTTrPrBase parse(String param1String) throws XmlException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1String, CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1String, CTTrPrBase.type, param1XmlOptions);
    }
    
    public static CTTrPrBase parse(File param1File) throws XmlException, IOException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1File, CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1File, CTTrPrBase.type, param1XmlOptions);
    }
    
    public static CTTrPrBase parse(URL param1URL) throws XmlException, IOException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1URL, CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1URL, CTTrPrBase.type, param1XmlOptions);
    }
    
    public static CTTrPrBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1InputStream, CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1InputStream, CTTrPrBase.type, param1XmlOptions);
    }
    
    public static CTTrPrBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1Reader, CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1Reader, CTTrPrBase.type, param1XmlOptions);
    }
    
    public static CTTrPrBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTrPrBase.type, param1XmlOptions);
    }
    
    public static CTTrPrBase parse(Node param1Node) throws XmlException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1Node, CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1Node, CTTrPrBase.type, param1XmlOptions);
    }
    
    public static CTTrPrBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTrPrBase.type, null);
    }
    
    public static CTTrPrBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTrPrBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTrPrBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTrPrBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTrPrBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTrPrBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */