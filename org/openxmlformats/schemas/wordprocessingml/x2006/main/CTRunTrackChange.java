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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTAcc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBar;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBorderBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTD;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTEqArr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTF;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTFunc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTGroupChr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTLimLow;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTLimUpp;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTM;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTNary;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTPhant;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTR;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTRad;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSPre;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSub;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSubSup;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSup;
import org.w3c.dom.Node;

public interface CTRunTrackChange extends CTTrackChange {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRunTrackChange.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctruntrackchangea458type");
  
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
  
  List<CTAcc> getAccList();
  
  CTAcc[] getAccArray();
  
  CTAcc getAccArray(int paramInt);
  
  int sizeOfAccArray();
  
  void setAccArray(CTAcc[] paramArrayOfCTAcc);
  
  void setAccArray(int paramInt, CTAcc paramCTAcc);
  
  CTAcc insertNewAcc(int paramInt);
  
  CTAcc addNewAcc();
  
  void removeAcc(int paramInt);
  
  List<CTBar> getBarList();
  
  CTBar[] getBarArray();
  
  CTBar getBarArray(int paramInt);
  
  int sizeOfBarArray();
  
  void setBarArray(CTBar[] paramArrayOfCTBar);
  
  void setBarArray(int paramInt, CTBar paramCTBar);
  
  CTBar insertNewBar(int paramInt);
  
  CTBar addNewBar();
  
  void removeBar(int paramInt);
  
  List<CTBox> getBoxList();
  
  CTBox[] getBoxArray();
  
  CTBox getBoxArray(int paramInt);
  
  int sizeOfBoxArray();
  
  void setBoxArray(CTBox[] paramArrayOfCTBox);
  
  void setBoxArray(int paramInt, CTBox paramCTBox);
  
  CTBox insertNewBox(int paramInt);
  
  CTBox addNewBox();
  
  void removeBox(int paramInt);
  
  List<CTBorderBox> getBorderBoxList();
  
  CTBorderBox[] getBorderBoxArray();
  
  CTBorderBox getBorderBoxArray(int paramInt);
  
  int sizeOfBorderBoxArray();
  
  void setBorderBoxArray(CTBorderBox[] paramArrayOfCTBorderBox);
  
  void setBorderBoxArray(int paramInt, CTBorderBox paramCTBorderBox);
  
  CTBorderBox insertNewBorderBox(int paramInt);
  
  CTBorderBox addNewBorderBox();
  
  void removeBorderBox(int paramInt);
  
  List<CTD> getDList();
  
  CTD[] getDArray();
  
  CTD getDArray(int paramInt);
  
  int sizeOfDArray();
  
  void setDArray(CTD[] paramArrayOfCTD);
  
  void setDArray(int paramInt, CTD paramCTD);
  
  CTD insertNewD(int paramInt);
  
  CTD addNewD();
  
  void removeD(int paramInt);
  
  List<CTEqArr> getEqArrList();
  
  CTEqArr[] getEqArrArray();
  
  CTEqArr getEqArrArray(int paramInt);
  
  int sizeOfEqArrArray();
  
  void setEqArrArray(CTEqArr[] paramArrayOfCTEqArr);
  
  void setEqArrArray(int paramInt, CTEqArr paramCTEqArr);
  
  CTEqArr insertNewEqArr(int paramInt);
  
  CTEqArr addNewEqArr();
  
  void removeEqArr(int paramInt);
  
  List<CTF> getFList();
  
  CTF[] getFArray();
  
  CTF getFArray(int paramInt);
  
  int sizeOfFArray();
  
  void setFArray(CTF[] paramArrayOfCTF);
  
  void setFArray(int paramInt, CTF paramCTF);
  
  CTF insertNewF(int paramInt);
  
  CTF addNewF();
  
  void removeF(int paramInt);
  
  List<CTFunc> getFuncList();
  
  CTFunc[] getFuncArray();
  
  CTFunc getFuncArray(int paramInt);
  
  int sizeOfFuncArray();
  
  void setFuncArray(CTFunc[] paramArrayOfCTFunc);
  
  void setFuncArray(int paramInt, CTFunc paramCTFunc);
  
  CTFunc insertNewFunc(int paramInt);
  
  CTFunc addNewFunc();
  
  void removeFunc(int paramInt);
  
  List<CTGroupChr> getGroupChrList();
  
  CTGroupChr[] getGroupChrArray();
  
  CTGroupChr getGroupChrArray(int paramInt);
  
  int sizeOfGroupChrArray();
  
  void setGroupChrArray(CTGroupChr[] paramArrayOfCTGroupChr);
  
  void setGroupChrArray(int paramInt, CTGroupChr paramCTGroupChr);
  
  CTGroupChr insertNewGroupChr(int paramInt);
  
  CTGroupChr addNewGroupChr();
  
  void removeGroupChr(int paramInt);
  
  List<CTLimLow> getLimLowList();
  
  CTLimLow[] getLimLowArray();
  
  CTLimLow getLimLowArray(int paramInt);
  
  int sizeOfLimLowArray();
  
  void setLimLowArray(CTLimLow[] paramArrayOfCTLimLow);
  
  void setLimLowArray(int paramInt, CTLimLow paramCTLimLow);
  
  CTLimLow insertNewLimLow(int paramInt);
  
  CTLimLow addNewLimLow();
  
  void removeLimLow(int paramInt);
  
  List<CTLimUpp> getLimUppList();
  
  CTLimUpp[] getLimUppArray();
  
  CTLimUpp getLimUppArray(int paramInt);
  
  int sizeOfLimUppArray();
  
  void setLimUppArray(CTLimUpp[] paramArrayOfCTLimUpp);
  
  void setLimUppArray(int paramInt, CTLimUpp paramCTLimUpp);
  
  CTLimUpp insertNewLimUpp(int paramInt);
  
  CTLimUpp addNewLimUpp();
  
  void removeLimUpp(int paramInt);
  
  List<CTM> getMList();
  
  CTM[] getMArray();
  
  CTM getMArray(int paramInt);
  
  int sizeOfMArray();
  
  void setMArray(CTM[] paramArrayOfCTM);
  
  void setMArray(int paramInt, CTM paramCTM);
  
  CTM insertNewM(int paramInt);
  
  CTM addNewM();
  
  void removeM(int paramInt);
  
  List<CTNary> getNaryList();
  
  CTNary[] getNaryArray();
  
  CTNary getNaryArray(int paramInt);
  
  int sizeOfNaryArray();
  
  void setNaryArray(CTNary[] paramArrayOfCTNary);
  
  void setNaryArray(int paramInt, CTNary paramCTNary);
  
  CTNary insertNewNary(int paramInt);
  
  CTNary addNewNary();
  
  void removeNary(int paramInt);
  
  List<CTPhant> getPhantList();
  
  CTPhant[] getPhantArray();
  
  CTPhant getPhantArray(int paramInt);
  
  int sizeOfPhantArray();
  
  void setPhantArray(CTPhant[] paramArrayOfCTPhant);
  
  void setPhantArray(int paramInt, CTPhant paramCTPhant);
  
  CTPhant insertNewPhant(int paramInt);
  
  CTPhant addNewPhant();
  
  void removePhant(int paramInt);
  
  List<CTRad> getRadList();
  
  CTRad[] getRadArray();
  
  CTRad getRadArray(int paramInt);
  
  int sizeOfRadArray();
  
  void setRadArray(CTRad[] paramArrayOfCTRad);
  
  void setRadArray(int paramInt, CTRad paramCTRad);
  
  CTRad insertNewRad(int paramInt);
  
  CTRad addNewRad();
  
  void removeRad(int paramInt);
  
  List<CTSPre> getSPreList();
  
  CTSPre[] getSPreArray();
  
  CTSPre getSPreArray(int paramInt);
  
  int sizeOfSPreArray();
  
  void setSPreArray(CTSPre[] paramArrayOfCTSPre);
  
  void setSPreArray(int paramInt, CTSPre paramCTSPre);
  
  CTSPre insertNewSPre(int paramInt);
  
  CTSPre addNewSPre();
  
  void removeSPre(int paramInt);
  
  List<CTSSub> getSSubList();
  
  CTSSub[] getSSubArray();
  
  CTSSub getSSubArray(int paramInt);
  
  int sizeOfSSubArray();
  
  void setSSubArray(CTSSub[] paramArrayOfCTSSub);
  
  void setSSubArray(int paramInt, CTSSub paramCTSSub);
  
  CTSSub insertNewSSub(int paramInt);
  
  CTSSub addNewSSub();
  
  void removeSSub(int paramInt);
  
  List<CTSSubSup> getSSubSupList();
  
  CTSSubSup[] getSSubSupArray();
  
  CTSSubSup getSSubSupArray(int paramInt);
  
  int sizeOfSSubSupArray();
  
  void setSSubSupArray(CTSSubSup[] paramArrayOfCTSSubSup);
  
  void setSSubSupArray(int paramInt, CTSSubSup paramCTSSubSup);
  
  CTSSubSup insertNewSSubSup(int paramInt);
  
  CTSSubSup addNewSSubSup();
  
  void removeSSubSup(int paramInt);
  
  List<CTSSup> getSSupList();
  
  CTSSup[] getSSupArray();
  
  CTSSup getSSupArray(int paramInt);
  
  int sizeOfSSupArray();
  
  void setSSupArray(CTSSup[] paramArrayOfCTSSup);
  
  void setSSupArray(int paramInt, CTSSup paramCTSSup);
  
  CTSSup insertNewSSup(int paramInt);
  
  CTSSup addNewSSup();
  
  void removeSSup(int paramInt);
  
  List<CTR> getR2List();
  
  CTR[] getR2Array();
  
  CTR getR2Array(int paramInt);
  
  int sizeOfR2Array();
  
  void setR2Array(CTR[] paramArrayOfCTR);
  
  void setR2Array(int paramInt, CTR paramCTR);
  
  CTR insertNewR2(int paramInt);
  
  CTR addNewR2();
  
  void removeR2(int paramInt);
  
  public static final class Factory {
    public static CTRunTrackChange newInstance() {
      return (CTRunTrackChange)POIXMLTypeLoader.newInstance(CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange newInstance(XmlOptions param1XmlOptions) {
      return (CTRunTrackChange)POIXMLTypeLoader.newInstance(CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static CTRunTrackChange parse(String param1String) throws XmlException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1String, CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1String, CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static CTRunTrackChange parse(File param1File) throws XmlException, IOException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1File, CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1File, CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static CTRunTrackChange parse(URL param1URL) throws XmlException, IOException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1URL, CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1URL, CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static CTRunTrackChange parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1InputStream, CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1InputStream, CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static CTRunTrackChange parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1Reader, CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1Reader, CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static CTRunTrackChange parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static CTRunTrackChange parse(Node param1Node) throws XmlException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1Node, CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1Node, CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static CTRunTrackChange parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1XMLInputStream, CTRunTrackChange.type, null);
    }
    
    public static CTRunTrackChange parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRunTrackChange)POIXMLTypeLoader.parse(param1XMLInputStream, CTRunTrackChange.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRunTrackChange.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRunTrackChange.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTRunTrackChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */