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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTHyperlink extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHyperlink.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthyperlink38actype");
  
  List<CTCustomXmlRun> getCustomXmlList();
  
  CTCustomXmlRun[] getCustomXmlArray();
  
  CTCustomXmlRun getCustomXmlArray(int paramInt);
  
  int sizeOfCustomXmlArray();
  
  void setCustomXmlArray(CTCustomXmlRun[] paramArrayOfCTCustomXmlRun);
  
  void setCustomXmlArray(int paramInt, CTCustomXmlRun paramCTCustomXmlRun);
  
  CTCustomXmlRun insertNewCustomXml(int paramInt);
  
  CTCustomXmlRun addNewCustomXml();
  
  void removeCustomXml(int paramInt);
  
  List<CTSmartTagRun> getSmartTagList();
  
  CTSmartTagRun[] getSmartTagArray();
  
  CTSmartTagRun getSmartTagArray(int paramInt);
  
  int sizeOfSmartTagArray();
  
  void setSmartTagArray(CTSmartTagRun[] paramArrayOfCTSmartTagRun);
  
  void setSmartTagArray(int paramInt, CTSmartTagRun paramCTSmartTagRun);
  
  CTSmartTagRun insertNewSmartTag(int paramInt);
  
  CTSmartTagRun addNewSmartTag();
  
  void removeSmartTag(int paramInt);
  
  List<CTSdtRun> getSdtList();
  
  CTSdtRun[] getSdtArray();
  
  CTSdtRun getSdtArray(int paramInt);
  
  int sizeOfSdtArray();
  
  void setSdtArray(CTSdtRun[] paramArrayOfCTSdtRun);
  
  void setSdtArray(int paramInt, CTSdtRun paramCTSdtRun);
  
  CTSdtRun insertNewSdt(int paramInt);
  
  CTSdtRun addNewSdt();
  
  void removeSdt(int paramInt);
  
  List<CTR> getRList();
  
  CTR[] getRArray();
  
  CTR getRArray(int paramInt);
  
  int sizeOfRArray();
  
  void setRArray(CTR[] paramArrayOfCTR);
  
  void setRArray(int paramInt, CTR paramCTR);
  
  CTR insertNewR(int paramInt);
  
  CTR addNewR();
  
  void removeR(int paramInt);
  
  List<CTProofErr> getProofErrList();
  
  CTProofErr[] getProofErrArray();
  
  CTProofErr getProofErrArray(int paramInt);
  
  int sizeOfProofErrArray();
  
  void setProofErrArray(CTProofErr[] paramArrayOfCTProofErr);
  
  void setProofErrArray(int paramInt, CTProofErr paramCTProofErr);
  
  CTProofErr insertNewProofErr(int paramInt);
  
  CTProofErr addNewProofErr();
  
  void removeProofErr(int paramInt);
  
  List<CTPermStart> getPermStartList();
  
  CTPermStart[] getPermStartArray();
  
  CTPermStart getPermStartArray(int paramInt);
  
  int sizeOfPermStartArray();
  
  void setPermStartArray(CTPermStart[] paramArrayOfCTPermStart);
  
  void setPermStartArray(int paramInt, CTPermStart paramCTPermStart);
  
  CTPermStart insertNewPermStart(int paramInt);
  
  CTPermStart addNewPermStart();
  
  void removePermStart(int paramInt);
  
  List<CTPerm> getPermEndList();
  
  CTPerm[] getPermEndArray();
  
  CTPerm getPermEndArray(int paramInt);
  
  int sizeOfPermEndArray();
  
  void setPermEndArray(CTPerm[] paramArrayOfCTPerm);
  
  void setPermEndArray(int paramInt, CTPerm paramCTPerm);
  
  CTPerm insertNewPermEnd(int paramInt);
  
  CTPerm addNewPermEnd();
  
  void removePermEnd(int paramInt);
  
  List<CTBookmark> getBookmarkStartList();
  
  CTBookmark[] getBookmarkStartArray();
  
  CTBookmark getBookmarkStartArray(int paramInt);
  
  int sizeOfBookmarkStartArray();
  
  void setBookmarkStartArray(CTBookmark[] paramArrayOfCTBookmark);
  
  void setBookmarkStartArray(int paramInt, CTBookmark paramCTBookmark);
  
  CTBookmark insertNewBookmarkStart(int paramInt);
  
  CTBookmark addNewBookmarkStart();
  
  void removeBookmarkStart(int paramInt);
  
  List<CTMarkupRange> getBookmarkEndList();
  
  CTMarkupRange[] getBookmarkEndArray();
  
  CTMarkupRange getBookmarkEndArray(int paramInt);
  
  int sizeOfBookmarkEndArray();
  
  void setBookmarkEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange);
  
  void setBookmarkEndArray(int paramInt, CTMarkupRange paramCTMarkupRange);
  
  CTMarkupRange insertNewBookmarkEnd(int paramInt);
  
  CTMarkupRange addNewBookmarkEnd();
  
  void removeBookmarkEnd(int paramInt);
  
  List<CTMoveBookmark> getMoveFromRangeStartList();
  
  CTMoveBookmark[] getMoveFromRangeStartArray();
  
  CTMoveBookmark getMoveFromRangeStartArray(int paramInt);
  
  int sizeOfMoveFromRangeStartArray();
  
  void setMoveFromRangeStartArray(CTMoveBookmark[] paramArrayOfCTMoveBookmark);
  
  void setMoveFromRangeStartArray(int paramInt, CTMoveBookmark paramCTMoveBookmark);
  
  CTMoveBookmark insertNewMoveFromRangeStart(int paramInt);
  
  CTMoveBookmark addNewMoveFromRangeStart();
  
  void removeMoveFromRangeStart(int paramInt);
  
  List<CTMarkupRange> getMoveFromRangeEndList();
  
  CTMarkupRange[] getMoveFromRangeEndArray();
  
  CTMarkupRange getMoveFromRangeEndArray(int paramInt);
  
  int sizeOfMoveFromRangeEndArray();
  
  void setMoveFromRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange);
  
  void setMoveFromRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange);
  
  CTMarkupRange insertNewMoveFromRangeEnd(int paramInt);
  
  CTMarkupRange addNewMoveFromRangeEnd();
  
  void removeMoveFromRangeEnd(int paramInt);
  
  List<CTMoveBookmark> getMoveToRangeStartList();
  
  CTMoveBookmark[] getMoveToRangeStartArray();
  
  CTMoveBookmark getMoveToRangeStartArray(int paramInt);
  
  int sizeOfMoveToRangeStartArray();
  
  void setMoveToRangeStartArray(CTMoveBookmark[] paramArrayOfCTMoveBookmark);
  
  void setMoveToRangeStartArray(int paramInt, CTMoveBookmark paramCTMoveBookmark);
  
  CTMoveBookmark insertNewMoveToRangeStart(int paramInt);
  
  CTMoveBookmark addNewMoveToRangeStart();
  
  void removeMoveToRangeStart(int paramInt);
  
  List<CTMarkupRange> getMoveToRangeEndList();
  
  CTMarkupRange[] getMoveToRangeEndArray();
  
  CTMarkupRange getMoveToRangeEndArray(int paramInt);
  
  int sizeOfMoveToRangeEndArray();
  
  void setMoveToRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange);
  
  void setMoveToRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange);
  
  CTMarkupRange insertNewMoveToRangeEnd(int paramInt);
  
  CTMarkupRange addNewMoveToRangeEnd();
  
  void removeMoveToRangeEnd(int paramInt);
  
  List<CTMarkupRange> getCommentRangeStartList();
  
  CTMarkupRange[] getCommentRangeStartArray();
  
  CTMarkupRange getCommentRangeStartArray(int paramInt);
  
  int sizeOfCommentRangeStartArray();
  
  void setCommentRangeStartArray(CTMarkupRange[] paramArrayOfCTMarkupRange);
  
  void setCommentRangeStartArray(int paramInt, CTMarkupRange paramCTMarkupRange);
  
  CTMarkupRange insertNewCommentRangeStart(int paramInt);
  
  CTMarkupRange addNewCommentRangeStart();
  
  void removeCommentRangeStart(int paramInt);
  
  List<CTMarkupRange> getCommentRangeEndList();
  
  CTMarkupRange[] getCommentRangeEndArray();
  
  CTMarkupRange getCommentRangeEndArray(int paramInt);
  
  int sizeOfCommentRangeEndArray();
  
  void setCommentRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange);
  
  void setCommentRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange);
  
  CTMarkupRange insertNewCommentRangeEnd(int paramInt);
  
  CTMarkupRange addNewCommentRangeEnd();
  
  void removeCommentRangeEnd(int paramInt);
  
  List<CTTrackChange> getCustomXmlInsRangeStartList();
  
  CTTrackChange[] getCustomXmlInsRangeStartArray();
  
  CTTrackChange getCustomXmlInsRangeStartArray(int paramInt);
  
  int sizeOfCustomXmlInsRangeStartArray();
  
  void setCustomXmlInsRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange);
  
  void setCustomXmlInsRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange);
  
  CTTrackChange insertNewCustomXmlInsRangeStart(int paramInt);
  
  CTTrackChange addNewCustomXmlInsRangeStart();
  
  void removeCustomXmlInsRangeStart(int paramInt);
  
  List<CTMarkup> getCustomXmlInsRangeEndList();
  
  CTMarkup[] getCustomXmlInsRangeEndArray();
  
  CTMarkup getCustomXmlInsRangeEndArray(int paramInt);
  
  int sizeOfCustomXmlInsRangeEndArray();
  
  void setCustomXmlInsRangeEndArray(CTMarkup[] paramArrayOfCTMarkup);
  
  void setCustomXmlInsRangeEndArray(int paramInt, CTMarkup paramCTMarkup);
  
  CTMarkup insertNewCustomXmlInsRangeEnd(int paramInt);
  
  CTMarkup addNewCustomXmlInsRangeEnd();
  
  void removeCustomXmlInsRangeEnd(int paramInt);
  
  List<CTTrackChange> getCustomXmlDelRangeStartList();
  
  CTTrackChange[] getCustomXmlDelRangeStartArray();
  
  CTTrackChange getCustomXmlDelRangeStartArray(int paramInt);
  
  int sizeOfCustomXmlDelRangeStartArray();
  
  void setCustomXmlDelRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange);
  
  void setCustomXmlDelRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange);
  
  CTTrackChange insertNewCustomXmlDelRangeStart(int paramInt);
  
  CTTrackChange addNewCustomXmlDelRangeStart();
  
  void removeCustomXmlDelRangeStart(int paramInt);
  
  List<CTMarkup> getCustomXmlDelRangeEndList();
  
  CTMarkup[] getCustomXmlDelRangeEndArray();
  
  CTMarkup getCustomXmlDelRangeEndArray(int paramInt);
  
  int sizeOfCustomXmlDelRangeEndArray();
  
  void setCustomXmlDelRangeEndArray(CTMarkup[] paramArrayOfCTMarkup);
  
  void setCustomXmlDelRangeEndArray(int paramInt, CTMarkup paramCTMarkup);
  
  CTMarkup insertNewCustomXmlDelRangeEnd(int paramInt);
  
  CTMarkup addNewCustomXmlDelRangeEnd();
  
  void removeCustomXmlDelRangeEnd(int paramInt);
  
  List<CTTrackChange> getCustomXmlMoveFromRangeStartList();
  
  CTTrackChange[] getCustomXmlMoveFromRangeStartArray();
  
  CTTrackChange getCustomXmlMoveFromRangeStartArray(int paramInt);
  
  int sizeOfCustomXmlMoveFromRangeStartArray();
  
  void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange);
  
  void setCustomXmlMoveFromRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange);
  
  CTTrackChange insertNewCustomXmlMoveFromRangeStart(int paramInt);
  
  CTTrackChange addNewCustomXmlMoveFromRangeStart();
  
  void removeCustomXmlMoveFromRangeStart(int paramInt);
  
  List<CTMarkup> getCustomXmlMoveFromRangeEndList();
  
  CTMarkup[] getCustomXmlMoveFromRangeEndArray();
  
  CTMarkup getCustomXmlMoveFromRangeEndArray(int paramInt);
  
  int sizeOfCustomXmlMoveFromRangeEndArray();
  
  void setCustomXmlMoveFromRangeEndArray(CTMarkup[] paramArrayOfCTMarkup);
  
  void setCustomXmlMoveFromRangeEndArray(int paramInt, CTMarkup paramCTMarkup);
  
  CTMarkup insertNewCustomXmlMoveFromRangeEnd(int paramInt);
  
  CTMarkup addNewCustomXmlMoveFromRangeEnd();
  
  void removeCustomXmlMoveFromRangeEnd(int paramInt);
  
  List<CTTrackChange> getCustomXmlMoveToRangeStartList();
  
  CTTrackChange[] getCustomXmlMoveToRangeStartArray();
  
  CTTrackChange getCustomXmlMoveToRangeStartArray(int paramInt);
  
  int sizeOfCustomXmlMoveToRangeStartArray();
  
  void setCustomXmlMoveToRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange);
  
  void setCustomXmlMoveToRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange);
  
  CTTrackChange insertNewCustomXmlMoveToRangeStart(int paramInt);
  
  CTTrackChange addNewCustomXmlMoveToRangeStart();
  
  void removeCustomXmlMoveToRangeStart(int paramInt);
  
  List<CTMarkup> getCustomXmlMoveToRangeEndList();
  
  CTMarkup[] getCustomXmlMoveToRangeEndArray();
  
  CTMarkup getCustomXmlMoveToRangeEndArray(int paramInt);
  
  int sizeOfCustomXmlMoveToRangeEndArray();
  
  void setCustomXmlMoveToRangeEndArray(CTMarkup[] paramArrayOfCTMarkup);
  
  void setCustomXmlMoveToRangeEndArray(int paramInt, CTMarkup paramCTMarkup);
  
  CTMarkup insertNewCustomXmlMoveToRangeEnd(int paramInt);
  
  CTMarkup addNewCustomXmlMoveToRangeEnd();
  
  void removeCustomXmlMoveToRangeEnd(int paramInt);
  
  List<CTRunTrackChange> getInsList();
  
  CTRunTrackChange[] getInsArray();
  
  CTRunTrackChange getInsArray(int paramInt);
  
  int sizeOfInsArray();
  
  void setInsArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange);
  
  void setInsArray(int paramInt, CTRunTrackChange paramCTRunTrackChange);
  
  CTRunTrackChange insertNewIns(int paramInt);
  
  CTRunTrackChange addNewIns();
  
  void removeIns(int paramInt);
  
  List<CTRunTrackChange> getDelList();
  
  CTRunTrackChange[] getDelArray();
  
  CTRunTrackChange getDelArray(int paramInt);
  
  int sizeOfDelArray();
  
  void setDelArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange);
  
  void setDelArray(int paramInt, CTRunTrackChange paramCTRunTrackChange);
  
  CTRunTrackChange insertNewDel(int paramInt);
  
  CTRunTrackChange addNewDel();
  
  void removeDel(int paramInt);
  
  List<CTRunTrackChange> getMoveFromList();
  
  CTRunTrackChange[] getMoveFromArray();
  
  CTRunTrackChange getMoveFromArray(int paramInt);
  
  int sizeOfMoveFromArray();
  
  void setMoveFromArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange);
  
  void setMoveFromArray(int paramInt, CTRunTrackChange paramCTRunTrackChange);
  
  CTRunTrackChange insertNewMoveFrom(int paramInt);
  
  CTRunTrackChange addNewMoveFrom();
  
  void removeMoveFrom(int paramInt);
  
  List<CTRunTrackChange> getMoveToList();
  
  CTRunTrackChange[] getMoveToArray();
  
  CTRunTrackChange getMoveToArray(int paramInt);
  
  int sizeOfMoveToArray();
  
  void setMoveToArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange);
  
  void setMoveToArray(int paramInt, CTRunTrackChange paramCTRunTrackChange);
  
  CTRunTrackChange insertNewMoveTo(int paramInt);
  
  CTRunTrackChange addNewMoveTo();
  
  void removeMoveTo(int paramInt);
  
  List<CTOMathPara> getOMathParaList();
  
  CTOMathPara[] getOMathParaArray();
  
  CTOMathPara getOMathParaArray(int paramInt);
  
  int sizeOfOMathParaArray();
  
  void setOMathParaArray(CTOMathPara[] paramArrayOfCTOMathPara);
  
  void setOMathParaArray(int paramInt, CTOMathPara paramCTOMathPara);
  
  CTOMathPara insertNewOMathPara(int paramInt);
  
  CTOMathPara addNewOMathPara();
  
  void removeOMathPara(int paramInt);
  
  List<CTOMath> getOMathList();
  
  CTOMath[] getOMathArray();
  
  CTOMath getOMathArray(int paramInt);
  
  int sizeOfOMathArray();
  
  void setOMathArray(CTOMath[] paramArrayOfCTOMath);
  
  void setOMathArray(int paramInt, CTOMath paramCTOMath);
  
  CTOMath insertNewOMath(int paramInt);
  
  CTOMath addNewOMath();
  
  void removeOMath(int paramInt);
  
  List<CTSimpleField> getFldSimpleList();
  
  CTSimpleField[] getFldSimpleArray();
  
  CTSimpleField getFldSimpleArray(int paramInt);
  
  int sizeOfFldSimpleArray();
  
  void setFldSimpleArray(CTSimpleField[] paramArrayOfCTSimpleField);
  
  void setFldSimpleArray(int paramInt, CTSimpleField paramCTSimpleField);
  
  CTSimpleField insertNewFldSimple(int paramInt);
  
  CTSimpleField addNewFldSimple();
  
  void removeFldSimple(int paramInt);
  
  List<CTHyperlink> getHyperlinkList();
  
  CTHyperlink[] getHyperlinkArray();
  
  CTHyperlink getHyperlinkArray(int paramInt);
  
  int sizeOfHyperlinkArray();
  
  void setHyperlinkArray(CTHyperlink[] paramArrayOfCTHyperlink);
  
  void setHyperlinkArray(int paramInt, CTHyperlink paramCTHyperlink);
  
  CTHyperlink insertNewHyperlink(int paramInt);
  
  CTHyperlink addNewHyperlink();
  
  void removeHyperlink(int paramInt);
  
  List<CTRel> getSubDocList();
  
  CTRel[] getSubDocArray();
  
  CTRel getSubDocArray(int paramInt);
  
  int sizeOfSubDocArray();
  
  void setSubDocArray(CTRel[] paramArrayOfCTRel);
  
  void setSubDocArray(int paramInt, CTRel paramCTRel);
  
  CTRel insertNewSubDoc(int paramInt);
  
  CTRel addNewSubDoc();
  
  void removeSubDoc(int paramInt);
  
  String getTgtFrame();
  
  STString xgetTgtFrame();
  
  boolean isSetTgtFrame();
  
  void setTgtFrame(String paramString);
  
  void xsetTgtFrame(STString paramSTString);
  
  void unsetTgtFrame();
  
  String getTooltip();
  
  STString xgetTooltip();
  
  boolean isSetTooltip();
  
  void setTooltip(String paramString);
  
  void xsetTooltip(STString paramSTString);
  
  void unsetTooltip();
  
  String getDocLocation();
  
  STString xgetDocLocation();
  
  boolean isSetDocLocation();
  
  void setDocLocation(String paramString);
  
  void xsetDocLocation(STString paramSTString);
  
  void unsetDocLocation();
  
  STOnOff.Enum getHistory();
  
  STOnOff xgetHistory();
  
  boolean isSetHistory();
  
  void setHistory(STOnOff.Enum paramEnum);
  
  void xsetHistory(STOnOff paramSTOnOff);
  
  void unsetHistory();
  
  String getAnchor();
  
  STString xgetAnchor();
  
  boolean isSetAnchor();
  
  void setAnchor(String paramString);
  
  void xsetAnchor(STString paramSTString);
  
  void unsetAnchor();
  
  String getId();
  
  STRelationshipId xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  void unsetId();
  
  public static final class Factory {
    public static CTHyperlink newInstance() {
      return (CTHyperlink)POIXMLTypeLoader.newInstance(CTHyperlink.type, null);
    }
    
    public static CTHyperlink newInstance(XmlOptions param1XmlOptions) {
      return (CTHyperlink)POIXMLTypeLoader.newInstance(CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(String param1String) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1String, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1String, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(File param1File) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1File, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1File, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(URL param1URL) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1URL, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1URL, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1InputStream, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1InputStream, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1Reader, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1Reader, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(Node param1Node) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1Node, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1Node, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1XMLInputStream, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1XMLInputStream, CTHyperlink.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHyperlink.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHyperlink.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTHyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */