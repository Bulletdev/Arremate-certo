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

public interface CTR extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTR.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctr8120type");
  
  CTRPr getRPr();
  
  boolean isSetRPr();
  
  void setRPr(CTRPr paramCTRPr);
  
  CTRPr addNewRPr();
  
  void unsetRPr();
  
  List<CTBr> getBrList();
  
  CTBr[] getBrArray();
  
  CTBr getBrArray(int paramInt);
  
  int sizeOfBrArray();
  
  void setBrArray(CTBr[] paramArrayOfCTBr);
  
  void setBrArray(int paramInt, CTBr paramCTBr);
  
  CTBr insertNewBr(int paramInt);
  
  CTBr addNewBr();
  
  void removeBr(int paramInt);
  
  List<CTText> getTList();
  
  CTText[] getTArray();
  
  CTText getTArray(int paramInt);
  
  int sizeOfTArray();
  
  void setTArray(CTText[] paramArrayOfCTText);
  
  void setTArray(int paramInt, CTText paramCTText);
  
  CTText insertNewT(int paramInt);
  
  CTText addNewT();
  
  void removeT(int paramInt);
  
  List<CTText> getDelTextList();
  
  CTText[] getDelTextArray();
  
  CTText getDelTextArray(int paramInt);
  
  int sizeOfDelTextArray();
  
  void setDelTextArray(CTText[] paramArrayOfCTText);
  
  void setDelTextArray(int paramInt, CTText paramCTText);
  
  CTText insertNewDelText(int paramInt);
  
  CTText addNewDelText();
  
  void removeDelText(int paramInt);
  
  List<CTText> getInstrTextList();
  
  CTText[] getInstrTextArray();
  
  CTText getInstrTextArray(int paramInt);
  
  int sizeOfInstrTextArray();
  
  void setInstrTextArray(CTText[] paramArrayOfCTText);
  
  void setInstrTextArray(int paramInt, CTText paramCTText);
  
  CTText insertNewInstrText(int paramInt);
  
  CTText addNewInstrText();
  
  void removeInstrText(int paramInt);
  
  List<CTText> getDelInstrTextList();
  
  CTText[] getDelInstrTextArray();
  
  CTText getDelInstrTextArray(int paramInt);
  
  int sizeOfDelInstrTextArray();
  
  void setDelInstrTextArray(CTText[] paramArrayOfCTText);
  
  void setDelInstrTextArray(int paramInt, CTText paramCTText);
  
  CTText insertNewDelInstrText(int paramInt);
  
  CTText addNewDelInstrText();
  
  void removeDelInstrText(int paramInt);
  
  List<CTEmpty> getNoBreakHyphenList();
  
  CTEmpty[] getNoBreakHyphenArray();
  
  CTEmpty getNoBreakHyphenArray(int paramInt);
  
  int sizeOfNoBreakHyphenArray();
  
  void setNoBreakHyphenArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setNoBreakHyphenArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewNoBreakHyphen(int paramInt);
  
  CTEmpty addNewNoBreakHyphen();
  
  void removeNoBreakHyphen(int paramInt);
  
  List<CTEmpty> getSoftHyphenList();
  
  CTEmpty[] getSoftHyphenArray();
  
  CTEmpty getSoftHyphenArray(int paramInt);
  
  int sizeOfSoftHyphenArray();
  
  void setSoftHyphenArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setSoftHyphenArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewSoftHyphen(int paramInt);
  
  CTEmpty addNewSoftHyphen();
  
  void removeSoftHyphen(int paramInt);
  
  List<CTEmpty> getDayShortList();
  
  CTEmpty[] getDayShortArray();
  
  CTEmpty getDayShortArray(int paramInt);
  
  int sizeOfDayShortArray();
  
  void setDayShortArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setDayShortArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewDayShort(int paramInt);
  
  CTEmpty addNewDayShort();
  
  void removeDayShort(int paramInt);
  
  List<CTEmpty> getMonthShortList();
  
  CTEmpty[] getMonthShortArray();
  
  CTEmpty getMonthShortArray(int paramInt);
  
  int sizeOfMonthShortArray();
  
  void setMonthShortArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setMonthShortArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewMonthShort(int paramInt);
  
  CTEmpty addNewMonthShort();
  
  void removeMonthShort(int paramInt);
  
  List<CTEmpty> getYearShortList();
  
  CTEmpty[] getYearShortArray();
  
  CTEmpty getYearShortArray(int paramInt);
  
  int sizeOfYearShortArray();
  
  void setYearShortArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setYearShortArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewYearShort(int paramInt);
  
  CTEmpty addNewYearShort();
  
  void removeYearShort(int paramInt);
  
  List<CTEmpty> getDayLongList();
  
  CTEmpty[] getDayLongArray();
  
  CTEmpty getDayLongArray(int paramInt);
  
  int sizeOfDayLongArray();
  
  void setDayLongArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setDayLongArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewDayLong(int paramInt);
  
  CTEmpty addNewDayLong();
  
  void removeDayLong(int paramInt);
  
  List<CTEmpty> getMonthLongList();
  
  CTEmpty[] getMonthLongArray();
  
  CTEmpty getMonthLongArray(int paramInt);
  
  int sizeOfMonthLongArray();
  
  void setMonthLongArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setMonthLongArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewMonthLong(int paramInt);
  
  CTEmpty addNewMonthLong();
  
  void removeMonthLong(int paramInt);
  
  List<CTEmpty> getYearLongList();
  
  CTEmpty[] getYearLongArray();
  
  CTEmpty getYearLongArray(int paramInt);
  
  int sizeOfYearLongArray();
  
  void setYearLongArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setYearLongArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewYearLong(int paramInt);
  
  CTEmpty addNewYearLong();
  
  void removeYearLong(int paramInt);
  
  List<CTEmpty> getAnnotationRefList();
  
  CTEmpty[] getAnnotationRefArray();
  
  CTEmpty getAnnotationRefArray(int paramInt);
  
  int sizeOfAnnotationRefArray();
  
  void setAnnotationRefArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setAnnotationRefArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewAnnotationRef(int paramInt);
  
  CTEmpty addNewAnnotationRef();
  
  void removeAnnotationRef(int paramInt);
  
  List<CTEmpty> getFootnoteRefList();
  
  CTEmpty[] getFootnoteRefArray();
  
  CTEmpty getFootnoteRefArray(int paramInt);
  
  int sizeOfFootnoteRefArray();
  
  void setFootnoteRefArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setFootnoteRefArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewFootnoteRef(int paramInt);
  
  CTEmpty addNewFootnoteRef();
  
  void removeFootnoteRef(int paramInt);
  
  List<CTEmpty> getEndnoteRefList();
  
  CTEmpty[] getEndnoteRefArray();
  
  CTEmpty getEndnoteRefArray(int paramInt);
  
  int sizeOfEndnoteRefArray();
  
  void setEndnoteRefArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setEndnoteRefArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewEndnoteRef(int paramInt);
  
  CTEmpty addNewEndnoteRef();
  
  void removeEndnoteRef(int paramInt);
  
  List<CTEmpty> getSeparatorList();
  
  CTEmpty[] getSeparatorArray();
  
  CTEmpty getSeparatorArray(int paramInt);
  
  int sizeOfSeparatorArray();
  
  void setSeparatorArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setSeparatorArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewSeparator(int paramInt);
  
  CTEmpty addNewSeparator();
  
  void removeSeparator(int paramInt);
  
  List<CTEmpty> getContinuationSeparatorList();
  
  CTEmpty[] getContinuationSeparatorArray();
  
  CTEmpty getContinuationSeparatorArray(int paramInt);
  
  int sizeOfContinuationSeparatorArray();
  
  void setContinuationSeparatorArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setContinuationSeparatorArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewContinuationSeparator(int paramInt);
  
  CTEmpty addNewContinuationSeparator();
  
  void removeContinuationSeparator(int paramInt);
  
  List<CTSym> getSymList();
  
  CTSym[] getSymArray();
  
  CTSym getSymArray(int paramInt);
  
  int sizeOfSymArray();
  
  void setSymArray(CTSym[] paramArrayOfCTSym);
  
  void setSymArray(int paramInt, CTSym paramCTSym);
  
  CTSym insertNewSym(int paramInt);
  
  CTSym addNewSym();
  
  void removeSym(int paramInt);
  
  List<CTEmpty> getPgNumList();
  
  CTEmpty[] getPgNumArray();
  
  CTEmpty getPgNumArray(int paramInt);
  
  int sizeOfPgNumArray();
  
  void setPgNumArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setPgNumArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewPgNum(int paramInt);
  
  CTEmpty addNewPgNum();
  
  void removePgNum(int paramInt);
  
  List<CTEmpty> getCrList();
  
  CTEmpty[] getCrArray();
  
  CTEmpty getCrArray(int paramInt);
  
  int sizeOfCrArray();
  
  void setCrArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setCrArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewCr(int paramInt);
  
  CTEmpty addNewCr();
  
  void removeCr(int paramInt);
  
  List<CTEmpty> getTabList();
  
  CTEmpty[] getTabArray();
  
  CTEmpty getTabArray(int paramInt);
  
  int sizeOfTabArray();
  
  void setTabArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setTabArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewTab(int paramInt);
  
  CTEmpty addNewTab();
  
  void removeTab(int paramInt);
  
  List<CTObject> getObjectList();
  
  CTObject[] getObjectArray();
  
  CTObject getObjectArray(int paramInt);
  
  int sizeOfObjectArray();
  
  void setObjectArray(CTObject[] paramArrayOfCTObject);
  
  void setObjectArray(int paramInt, CTObject paramCTObject);
  
  CTObject insertNewObject(int paramInt);
  
  CTObject addNewObject();
  
  void removeObject(int paramInt);
  
  List<CTPicture> getPictList();
  
  CTPicture[] getPictArray();
  
  CTPicture getPictArray(int paramInt);
  
  int sizeOfPictArray();
  
  void setPictArray(CTPicture[] paramArrayOfCTPicture);
  
  void setPictArray(int paramInt, CTPicture paramCTPicture);
  
  CTPicture insertNewPict(int paramInt);
  
  CTPicture addNewPict();
  
  void removePict(int paramInt);
  
  List<CTFldChar> getFldCharList();
  
  CTFldChar[] getFldCharArray();
  
  CTFldChar getFldCharArray(int paramInt);
  
  int sizeOfFldCharArray();
  
  void setFldCharArray(CTFldChar[] paramArrayOfCTFldChar);
  
  void setFldCharArray(int paramInt, CTFldChar paramCTFldChar);
  
  CTFldChar insertNewFldChar(int paramInt);
  
  CTFldChar addNewFldChar();
  
  void removeFldChar(int paramInt);
  
  List<CTRuby> getRubyList();
  
  CTRuby[] getRubyArray();
  
  CTRuby getRubyArray(int paramInt);
  
  int sizeOfRubyArray();
  
  void setRubyArray(CTRuby[] paramArrayOfCTRuby);
  
  void setRubyArray(int paramInt, CTRuby paramCTRuby);
  
  CTRuby insertNewRuby(int paramInt);
  
  CTRuby addNewRuby();
  
  void removeRuby(int paramInt);
  
  List<CTFtnEdnRef> getFootnoteReferenceList();
  
  CTFtnEdnRef[] getFootnoteReferenceArray();
  
  CTFtnEdnRef getFootnoteReferenceArray(int paramInt);
  
  int sizeOfFootnoteReferenceArray();
  
  void setFootnoteReferenceArray(CTFtnEdnRef[] paramArrayOfCTFtnEdnRef);
  
  void setFootnoteReferenceArray(int paramInt, CTFtnEdnRef paramCTFtnEdnRef);
  
  CTFtnEdnRef insertNewFootnoteReference(int paramInt);
  
  CTFtnEdnRef addNewFootnoteReference();
  
  void removeFootnoteReference(int paramInt);
  
  List<CTFtnEdnRef> getEndnoteReferenceList();
  
  CTFtnEdnRef[] getEndnoteReferenceArray();
  
  CTFtnEdnRef getEndnoteReferenceArray(int paramInt);
  
  int sizeOfEndnoteReferenceArray();
  
  void setEndnoteReferenceArray(CTFtnEdnRef[] paramArrayOfCTFtnEdnRef);
  
  void setEndnoteReferenceArray(int paramInt, CTFtnEdnRef paramCTFtnEdnRef);
  
  CTFtnEdnRef insertNewEndnoteReference(int paramInt);
  
  CTFtnEdnRef addNewEndnoteReference();
  
  void removeEndnoteReference(int paramInt);
  
  List<CTMarkup> getCommentReferenceList();
  
  CTMarkup[] getCommentReferenceArray();
  
  CTMarkup getCommentReferenceArray(int paramInt);
  
  int sizeOfCommentReferenceArray();
  
  void setCommentReferenceArray(CTMarkup[] paramArrayOfCTMarkup);
  
  void setCommentReferenceArray(int paramInt, CTMarkup paramCTMarkup);
  
  CTMarkup insertNewCommentReference(int paramInt);
  
  CTMarkup addNewCommentReference();
  
  void removeCommentReference(int paramInt);
  
  List<CTDrawing> getDrawingList();
  
  CTDrawing[] getDrawingArray();
  
  CTDrawing getDrawingArray(int paramInt);
  
  int sizeOfDrawingArray();
  
  void setDrawingArray(CTDrawing[] paramArrayOfCTDrawing);
  
  void setDrawingArray(int paramInt, CTDrawing paramCTDrawing);
  
  CTDrawing insertNewDrawing(int paramInt);
  
  CTDrawing addNewDrawing();
  
  void removeDrawing(int paramInt);
  
  List<CTPTab> getPtabList();
  
  CTPTab[] getPtabArray();
  
  CTPTab getPtabArray(int paramInt);
  
  int sizeOfPtabArray();
  
  void setPtabArray(CTPTab[] paramArrayOfCTPTab);
  
  void setPtabArray(int paramInt, CTPTab paramCTPTab);
  
  CTPTab insertNewPtab(int paramInt);
  
  CTPTab addNewPtab();
  
  void removePtab(int paramInt);
  
  List<CTEmpty> getLastRenderedPageBreakList();
  
  CTEmpty[] getLastRenderedPageBreakArray();
  
  CTEmpty getLastRenderedPageBreakArray(int paramInt);
  
  int sizeOfLastRenderedPageBreakArray();
  
  void setLastRenderedPageBreakArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setLastRenderedPageBreakArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewLastRenderedPageBreak(int paramInt);
  
  CTEmpty addNewLastRenderedPageBreak();
  
  void removeLastRenderedPageBreak(int paramInt);
  
  byte[] getRsidRPr();
  
  STLongHexNumber xgetRsidRPr();
  
  boolean isSetRsidRPr();
  
  void setRsidRPr(byte[] paramArrayOfbyte);
  
  void xsetRsidRPr(STLongHexNumber paramSTLongHexNumber);
  
  void unsetRsidRPr();
  
  byte[] getRsidDel();
  
  STLongHexNumber xgetRsidDel();
  
  boolean isSetRsidDel();
  
  void setRsidDel(byte[] paramArrayOfbyte);
  
  void xsetRsidDel(STLongHexNumber paramSTLongHexNumber);
  
  void unsetRsidDel();
  
  byte[] getRsidR();
  
  STLongHexNumber xgetRsidR();
  
  boolean isSetRsidR();
  
  void setRsidR(byte[] paramArrayOfbyte);
  
  void xsetRsidR(STLongHexNumber paramSTLongHexNumber);
  
  void unsetRsidR();
  
  public static final class Factory {
    public static CTR newInstance() {
      return (CTR)POIXMLTypeLoader.newInstance(CTR.type, null);
    }
    
    public static CTR newInstance(XmlOptions param1XmlOptions) {
      return (CTR)POIXMLTypeLoader.newInstance(CTR.type, param1XmlOptions);
    }
    
    public static CTR parse(String param1String) throws XmlException {
      return (CTR)POIXMLTypeLoader.parse(param1String, CTR.type, null);
    }
    
    public static CTR parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTR)POIXMLTypeLoader.parse(param1String, CTR.type, param1XmlOptions);
    }
    
    public static CTR parse(File param1File) throws XmlException, IOException {
      return (CTR)POIXMLTypeLoader.parse(param1File, CTR.type, null);
    }
    
    public static CTR parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTR)POIXMLTypeLoader.parse(param1File, CTR.type, param1XmlOptions);
    }
    
    public static CTR parse(URL param1URL) throws XmlException, IOException {
      return (CTR)POIXMLTypeLoader.parse(param1URL, CTR.type, null);
    }
    
    public static CTR parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTR)POIXMLTypeLoader.parse(param1URL, CTR.type, param1XmlOptions);
    }
    
    public static CTR parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTR)POIXMLTypeLoader.parse(param1InputStream, CTR.type, null);
    }
    
    public static CTR parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTR)POIXMLTypeLoader.parse(param1InputStream, CTR.type, param1XmlOptions);
    }
    
    public static CTR parse(Reader param1Reader) throws XmlException, IOException {
      return (CTR)POIXMLTypeLoader.parse(param1Reader, CTR.type, null);
    }
    
    public static CTR parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTR)POIXMLTypeLoader.parse(param1Reader, CTR.type, param1XmlOptions);
    }
    
    public static CTR parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTR)POIXMLTypeLoader.parse(param1XMLStreamReader, CTR.type, null);
    }
    
    public static CTR parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTR)POIXMLTypeLoader.parse(param1XMLStreamReader, CTR.type, param1XmlOptions);
    }
    
    public static CTR parse(Node param1Node) throws XmlException {
      return (CTR)POIXMLTypeLoader.parse(param1Node, CTR.type, null);
    }
    
    public static CTR parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTR)POIXMLTypeLoader.parse(param1Node, CTR.type, param1XmlOptions);
    }
    
    public static CTR parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTR)POIXMLTypeLoader.parse(param1XMLInputStream, CTR.type, null);
    }
    
    public static CTR parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTR)POIXMLTypeLoader.parse(param1XMLInputStream, CTR.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTR.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTR.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */