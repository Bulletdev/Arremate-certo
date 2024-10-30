package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

public class CTRunTrackChangeImpl extends CTTrackChangeImpl implements CTRunTrackChange {
  private static final b CUSTOMXML$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
  
  private static final b SMARTTAG$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTag");
  
  private static final b SDT$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
  
  private static final b R$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "r");
  
  private static final b PROOFERR$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
  
  private static final b PERMSTART$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
  
  private static final b PERMEND$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
  
  private static final b BOOKMARKSTART$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
  
  private static final b BOOKMARKEND$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
  
  private static final b MOVEFROMRANGESTART$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
  
  private static final b MOVEFROMRANGEEND$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
  
  private static final b MOVETORANGESTART$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
  
  private static final b MOVETORANGEEND$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
  
  private static final b COMMENTRANGESTART$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
  
  private static final b COMMENTRANGEEND$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
  
  private static final b CUSTOMXMLINSRANGESTART$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
  
  private static final b CUSTOMXMLINSRANGEEND$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
  
  private static final b CUSTOMXMLDELRANGESTART$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
  
  private static final b CUSTOMXMLDELRANGEEND$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
  
  private static final b CUSTOMXMLMOVEFROMRANGESTART$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
  
  private static final b CUSTOMXMLMOVEFROMRANGEEND$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
  
  private static final b CUSTOMXMLMOVETORANGESTART$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
  
  private static final b CUSTOMXMLMOVETORANGEEND$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
  
  private static final b INS$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
  
  private static final b DEL$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
  
  private static final b MOVEFROM$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
  
  private static final b MOVETO$52 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
  
  private static final b OMATHPARA$54 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
  
  private static final b OMATH$56 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");
  
  private static final b ACC$58 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "acc");
  
  private static final b BAR$60 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "bar");
  
  private static final b BOX$62 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "box");
  
  private static final b BORDERBOX$64 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "borderBox");
  
  private static final b D$66 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "d");
  
  private static final b EQARR$68 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "eqArr");
  
  private static final b F$70 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "f");
  
  private static final b FUNC$72 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "func");
  
  private static final b GROUPCHR$74 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "groupChr");
  
  private static final b LIMLOW$76 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "limLow");
  
  private static final b LIMUPP$78 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "limUpp");
  
  private static final b M$80 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
  
  private static final b NARY$82 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "nary");
  
  private static final b PHANT$84 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "phant");
  
  private static final b RAD$86 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "rad");
  
  private static final b SPRE$88 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "sPre");
  
  private static final b SSUB$90 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSub");
  
  private static final b SSUBSUP$92 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSubSup");
  
  private static final b SSUP$94 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSup");
  
  private static final b R2$96 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "r");
  
  public CTRunTrackChangeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCustomXmlRun> getCustomXmlList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCustomXmlRun>)new CustomXmlList(this);
    } 
  }
  
  public CTCustomXmlRun[] getCustomXmlArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXML$0, arrayList);
      CTCustomXmlRun[] arrayOfCTCustomXmlRun = new CTCustomXmlRun[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCustomXmlRun);
      return arrayOfCTCustomXmlRun;
    } 
  }
  
  public CTCustomXmlRun getCustomXmlArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlRun cTCustomXmlRun = null;
      cTCustomXmlRun = (CTCustomXmlRun)get_store().find_element_user(CUSTOMXML$0, paramInt);
      if (cTCustomXmlRun == null)
        throw new IndexOutOfBoundsException(); 
      return cTCustomXmlRun;
    } 
  }
  
  public int sizeOfCustomXmlArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXML$0);
    } 
  }
  
  public void setCustomXmlArray(CTCustomXmlRun[] paramArrayOfCTCustomXmlRun) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCustomXmlRun, CUSTOMXML$0);
    } 
  }
  
  public void setCustomXmlArray(int paramInt, CTCustomXmlRun paramCTCustomXmlRun) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlRun cTCustomXmlRun = null;
      cTCustomXmlRun = (CTCustomXmlRun)get_store().find_element_user(CUSTOMXML$0, paramInt);
      if (cTCustomXmlRun == null)
        throw new IndexOutOfBoundsException(); 
      cTCustomXmlRun.set((XmlObject)paramCTCustomXmlRun);
    } 
  }
  
  public CTCustomXmlRun insertNewCustomXml(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlRun cTCustomXmlRun = null;
      cTCustomXmlRun = (CTCustomXmlRun)get_store().insert_element_user(CUSTOMXML$0, paramInt);
      return cTCustomXmlRun;
    } 
  }
  
  public CTCustomXmlRun addNewCustomXml() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlRun cTCustomXmlRun = null;
      cTCustomXmlRun = (CTCustomXmlRun)get_store().add_element_user(CUSTOMXML$0);
      return cTCustomXmlRun;
    } 
  }
  
  public void removeCustomXml(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXML$0, paramInt);
    } 
  }
  
  public List<CTSmartTagRun> getSmartTagList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSmartTagRun>)new SmartTagList(this);
    } 
  }
  
  public CTSmartTagRun[] getSmartTagArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SMARTTAG$2, arrayList);
      CTSmartTagRun[] arrayOfCTSmartTagRun = new CTSmartTagRun[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSmartTagRun);
      return arrayOfCTSmartTagRun;
    } 
  }
  
  public CTSmartTagRun getSmartTagArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagRun cTSmartTagRun = null;
      cTSmartTagRun = (CTSmartTagRun)get_store().find_element_user(SMARTTAG$2, paramInt);
      if (cTSmartTagRun == null)
        throw new IndexOutOfBoundsException(); 
      return cTSmartTagRun;
    } 
  }
  
  public int sizeOfSmartTagArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SMARTTAG$2);
    } 
  }
  
  public void setSmartTagArray(CTSmartTagRun[] paramArrayOfCTSmartTagRun) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSmartTagRun, SMARTTAG$2);
    } 
  }
  
  public void setSmartTagArray(int paramInt, CTSmartTagRun paramCTSmartTagRun) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagRun cTSmartTagRun = null;
      cTSmartTagRun = (CTSmartTagRun)get_store().find_element_user(SMARTTAG$2, paramInt);
      if (cTSmartTagRun == null)
        throw new IndexOutOfBoundsException(); 
      cTSmartTagRun.set((XmlObject)paramCTSmartTagRun);
    } 
  }
  
  public CTSmartTagRun insertNewSmartTag(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagRun cTSmartTagRun = null;
      cTSmartTagRun = (CTSmartTagRun)get_store().insert_element_user(SMARTTAG$2, paramInt);
      return cTSmartTagRun;
    } 
  }
  
  public CTSmartTagRun addNewSmartTag() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagRun cTSmartTagRun = null;
      cTSmartTagRun = (CTSmartTagRun)get_store().add_element_user(SMARTTAG$2);
      return cTSmartTagRun;
    } 
  }
  
  public void removeSmartTag(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMARTTAG$2, paramInt);
    } 
  }
  
  public List<CTSdtRun> getSdtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtRun>)new SdtList(this);
    } 
  }
  
  public CTSdtRun[] getSdtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SDT$4, arrayList);
      CTSdtRun[] arrayOfCTSdtRun = new CTSdtRun[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtRun);
      return arrayOfCTSdtRun;
    } 
  }
  
  public CTSdtRun getSdtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtRun cTSdtRun = null;
      cTSdtRun = (CTSdtRun)get_store().find_element_user(SDT$4, paramInt);
      if (cTSdtRun == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtRun;
    } 
  }
  
  public int sizeOfSdtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SDT$4);
    } 
  }
  
  public void setSdtArray(CTSdtRun[] paramArrayOfCTSdtRun) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtRun, SDT$4);
    } 
  }
  
  public void setSdtArray(int paramInt, CTSdtRun paramCTSdtRun) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtRun cTSdtRun = null;
      cTSdtRun = (CTSdtRun)get_store().find_element_user(SDT$4, paramInt);
      if (cTSdtRun == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtRun.set((XmlObject)paramCTSdtRun);
    } 
  }
  
  public CTSdtRun insertNewSdt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtRun cTSdtRun = null;
      cTSdtRun = (CTSdtRun)get_store().insert_element_user(SDT$4, paramInt);
      return cTSdtRun;
    } 
  }
  
  public CTSdtRun addNewSdt() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtRun cTSdtRun = null;
      cTSdtRun = (CTSdtRun)get_store().add_element_user(SDT$4);
      return cTSdtRun;
    } 
  }
  
  public void removeSdt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SDT$4, paramInt);
    } 
  }
  
  public List<CTR> getRList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTR>)new RList(this);
    } 
  }
  
  public CTR[] getRArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R$6, arrayList);
      CTR[] arrayOfCTR = new CTR[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTR);
      return arrayOfCTR;
    } 
  }
  
  public CTR getRArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTR cTR = null;
      cTR = (CTR)get_store().find_element_user(R$6, paramInt);
      if (cTR == null)
        throw new IndexOutOfBoundsException(); 
      return cTR;
    } 
  }
  
  public int sizeOfRArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(R$6);
    } 
  }
  
  public void setRArray(CTR[] paramArrayOfCTR) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTR, R$6);
    } 
  }
  
  public void setRArray(int paramInt, CTR paramCTR) {
    synchronized (monitor()) {
      check_orphaned();
      CTR cTR = null;
      cTR = (CTR)get_store().find_element_user(R$6, paramInt);
      if (cTR == null)
        throw new IndexOutOfBoundsException(); 
      cTR.set((XmlObject)paramCTR);
    } 
  }
  
  public CTR insertNewR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTR cTR = null;
      cTR = (CTR)get_store().insert_element_user(R$6, paramInt);
      return cTR;
    } 
  }
  
  public CTR addNewR() {
    synchronized (monitor()) {
      check_orphaned();
      CTR cTR = null;
      cTR = (CTR)get_store().add_element_user(R$6);
      return cTR;
    } 
  }
  
  public void removeR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R$6, paramInt);
    } 
  }
  
  public List<CTProofErr> getProofErrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTProofErr>)new ProofErrList(this);
    } 
  }
  
  public CTProofErr[] getProofErrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PROOFERR$8, arrayList);
      CTProofErr[] arrayOfCTProofErr = new CTProofErr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTProofErr);
      return arrayOfCTProofErr;
    } 
  }
  
  public CTProofErr getProofErrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTProofErr cTProofErr = null;
      cTProofErr = (CTProofErr)get_store().find_element_user(PROOFERR$8, paramInt);
      if (cTProofErr == null)
        throw new IndexOutOfBoundsException(); 
      return cTProofErr;
    } 
  }
  
  public int sizeOfProofErrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PROOFERR$8);
    } 
  }
  
  public void setProofErrArray(CTProofErr[] paramArrayOfCTProofErr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTProofErr, PROOFERR$8);
    } 
  }
  
  public void setProofErrArray(int paramInt, CTProofErr paramCTProofErr) {
    synchronized (monitor()) {
      check_orphaned();
      CTProofErr cTProofErr = null;
      cTProofErr = (CTProofErr)get_store().find_element_user(PROOFERR$8, paramInt);
      if (cTProofErr == null)
        throw new IndexOutOfBoundsException(); 
      cTProofErr.set((XmlObject)paramCTProofErr);
    } 
  }
  
  public CTProofErr insertNewProofErr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTProofErr cTProofErr = null;
      cTProofErr = (CTProofErr)get_store().insert_element_user(PROOFERR$8, paramInt);
      return cTProofErr;
    } 
  }
  
  public CTProofErr addNewProofErr() {
    synchronized (monitor()) {
      check_orphaned();
      CTProofErr cTProofErr = null;
      cTProofErr = (CTProofErr)get_store().add_element_user(PROOFERR$8);
      return cTProofErr;
    } 
  }
  
  public void removeProofErr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROOFERR$8, paramInt);
    } 
  }
  
  public List<CTPermStart> getPermStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPermStart>)new PermStartList(this);
    } 
  }
  
  public CTPermStart[] getPermStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PERMSTART$10, arrayList);
      CTPermStart[] arrayOfCTPermStart = new CTPermStart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPermStart);
      return arrayOfCTPermStart;
    } 
  }
  
  public CTPermStart getPermStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPermStart cTPermStart = null;
      cTPermStart = (CTPermStart)get_store().find_element_user(PERMSTART$10, paramInt);
      if (cTPermStart == null)
        throw new IndexOutOfBoundsException(); 
      return cTPermStart;
    } 
  }
  
  public int sizeOfPermStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PERMSTART$10);
    } 
  }
  
  public void setPermStartArray(CTPermStart[] paramArrayOfCTPermStart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPermStart, PERMSTART$10);
    } 
  }
  
  public void setPermStartArray(int paramInt, CTPermStart paramCTPermStart) {
    synchronized (monitor()) {
      check_orphaned();
      CTPermStart cTPermStart = null;
      cTPermStart = (CTPermStart)get_store().find_element_user(PERMSTART$10, paramInt);
      if (cTPermStart == null)
        throw new IndexOutOfBoundsException(); 
      cTPermStart.set((XmlObject)paramCTPermStart);
    } 
  }
  
  public CTPermStart insertNewPermStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPermStart cTPermStart = null;
      cTPermStart = (CTPermStart)get_store().insert_element_user(PERMSTART$10, paramInt);
      return cTPermStart;
    } 
  }
  
  public CTPermStart addNewPermStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTPermStart cTPermStart = null;
      cTPermStart = (CTPermStart)get_store().add_element_user(PERMSTART$10);
      return cTPermStart;
    } 
  }
  
  public void removePermStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PERMSTART$10, paramInt);
    } 
  }
  
  public List<CTPerm> getPermEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPerm>)new PermEndList(this);
    } 
  }
  
  public CTPerm[] getPermEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PERMEND$12, arrayList);
      CTPerm[] arrayOfCTPerm = new CTPerm[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPerm);
      return arrayOfCTPerm;
    } 
  }
  
  public CTPerm getPermEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPerm cTPerm = null;
      cTPerm = (CTPerm)get_store().find_element_user(PERMEND$12, paramInt);
      if (cTPerm == null)
        throw new IndexOutOfBoundsException(); 
      return cTPerm;
    } 
  }
  
  public int sizeOfPermEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PERMEND$12);
    } 
  }
  
  public void setPermEndArray(CTPerm[] paramArrayOfCTPerm) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPerm, PERMEND$12);
    } 
  }
  
  public void setPermEndArray(int paramInt, CTPerm paramCTPerm) {
    synchronized (monitor()) {
      check_orphaned();
      CTPerm cTPerm = null;
      cTPerm = (CTPerm)get_store().find_element_user(PERMEND$12, paramInt);
      if (cTPerm == null)
        throw new IndexOutOfBoundsException(); 
      cTPerm.set((XmlObject)paramCTPerm);
    } 
  }
  
  public CTPerm insertNewPermEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPerm cTPerm = null;
      cTPerm = (CTPerm)get_store().insert_element_user(PERMEND$12, paramInt);
      return cTPerm;
    } 
  }
  
  public CTPerm addNewPermEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTPerm cTPerm = null;
      cTPerm = (CTPerm)get_store().add_element_user(PERMEND$12);
      return cTPerm;
    } 
  }
  
  public void removePermEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PERMEND$12, paramInt);
    } 
  }
  
  public List<CTBookmark> getBookmarkStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBookmark>)new BookmarkStartList(this);
    } 
  }
  
  public CTBookmark[] getBookmarkStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BOOKMARKSTART$14, arrayList);
      CTBookmark[] arrayOfCTBookmark = new CTBookmark[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBookmark);
      return arrayOfCTBookmark;
    } 
  }
  
  public CTBookmark getBookmarkStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookmark cTBookmark = null;
      cTBookmark = (CTBookmark)get_store().find_element_user(BOOKMARKSTART$14, paramInt);
      if (cTBookmark == null)
        throw new IndexOutOfBoundsException(); 
      return cTBookmark;
    } 
  }
  
  public int sizeOfBookmarkStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BOOKMARKSTART$14);
    } 
  }
  
  public void setBookmarkStartArray(CTBookmark[] paramArrayOfCTBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBookmark, BOOKMARKSTART$14);
    } 
  }
  
  public void setBookmarkStartArray(int paramInt, CTBookmark paramCTBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookmark cTBookmark = null;
      cTBookmark = (CTBookmark)get_store().find_element_user(BOOKMARKSTART$14, paramInt);
      if (cTBookmark == null)
        throw new IndexOutOfBoundsException(); 
      cTBookmark.set((XmlObject)paramCTBookmark);
    } 
  }
  
  public CTBookmark insertNewBookmarkStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookmark cTBookmark = null;
      cTBookmark = (CTBookmark)get_store().insert_element_user(BOOKMARKSTART$14, paramInt);
      return cTBookmark;
    } 
  }
  
  public CTBookmark addNewBookmarkStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTBookmark cTBookmark = null;
      cTBookmark = (CTBookmark)get_store().add_element_user(BOOKMARKSTART$14);
      return cTBookmark;
    } 
  }
  
  public void removeBookmarkStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOKMARKSTART$14, paramInt);
    } 
  }
  
  public List<CTMarkupRange> getBookmarkEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkupRange>)new BookmarkEndList(this);
    } 
  }
  
  public CTMarkupRange[] getBookmarkEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BOOKMARKEND$16, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getBookmarkEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(BOOKMARKEND$16, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfBookmarkEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BOOKMARKEND$16);
    } 
  }
  
  public void setBookmarkEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, BOOKMARKEND$16);
    } 
  }
  
  public void setBookmarkEndArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(BOOKMARKEND$16, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewBookmarkEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(BOOKMARKEND$16, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewBookmarkEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(BOOKMARKEND$16);
      return cTMarkupRange;
    } 
  }
  
  public void removeBookmarkEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOKMARKEND$16, paramInt);
    } 
  }
  
  public List<CTMoveBookmark> getMoveFromRangeStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMoveBookmark>)new MoveFromRangeStartList(this);
    } 
  }
  
  public CTMoveBookmark[] getMoveFromRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MOVEFROMRANGESTART$18, arrayList);
      CTMoveBookmark[] arrayOfCTMoveBookmark = new CTMoveBookmark[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMoveBookmark);
      return arrayOfCTMoveBookmark;
    } 
  }
  
  public CTMoveBookmark getMoveFromRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().find_element_user(MOVEFROMRANGESTART$18, paramInt);
      if (cTMoveBookmark == null)
        throw new IndexOutOfBoundsException(); 
      return cTMoveBookmark;
    } 
  }
  
  public int sizeOfMoveFromRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVEFROMRANGESTART$18);
    } 
  }
  
  public void setMoveFromRangeStartArray(CTMoveBookmark[] paramArrayOfCTMoveBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMoveBookmark, MOVEFROMRANGESTART$18);
    } 
  }
  
  public void setMoveFromRangeStartArray(int paramInt, CTMoveBookmark paramCTMoveBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().find_element_user(MOVEFROMRANGESTART$18, paramInt);
      if (cTMoveBookmark == null)
        throw new IndexOutOfBoundsException(); 
      cTMoveBookmark.set((XmlObject)paramCTMoveBookmark);
    } 
  }
  
  public CTMoveBookmark insertNewMoveFromRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().insert_element_user(MOVEFROMRANGESTART$18, paramInt);
      return cTMoveBookmark;
    } 
  }
  
  public CTMoveBookmark addNewMoveFromRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().add_element_user(MOVEFROMRANGESTART$18);
      return cTMoveBookmark;
    } 
  }
  
  public void removeMoveFromRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVEFROMRANGESTART$18, paramInt);
    } 
  }
  
  public List<CTMarkupRange> getMoveFromRangeEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkupRange>)new MoveFromRangeEndList(this);
    } 
  }
  
  public CTMarkupRange[] getMoveFromRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MOVEFROMRANGEEND$20, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getMoveFromRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(MOVEFROMRANGEEND$20, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfMoveFromRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVEFROMRANGEEND$20);
    } 
  }
  
  public void setMoveFromRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, MOVEFROMRANGEEND$20);
    } 
  }
  
  public void setMoveFromRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(MOVEFROMRANGEEND$20, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewMoveFromRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(MOVEFROMRANGEEND$20, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewMoveFromRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(MOVEFROMRANGEEND$20);
      return cTMarkupRange;
    } 
  }
  
  public void removeMoveFromRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVEFROMRANGEEND$20, paramInt);
    } 
  }
  
  public List<CTMoveBookmark> getMoveToRangeStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMoveBookmark>)new MoveToRangeStartList(this);
    } 
  }
  
  public CTMoveBookmark[] getMoveToRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MOVETORANGESTART$22, arrayList);
      CTMoveBookmark[] arrayOfCTMoveBookmark = new CTMoveBookmark[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMoveBookmark);
      return arrayOfCTMoveBookmark;
    } 
  }
  
  public CTMoveBookmark getMoveToRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().find_element_user(MOVETORANGESTART$22, paramInt);
      if (cTMoveBookmark == null)
        throw new IndexOutOfBoundsException(); 
      return cTMoveBookmark;
    } 
  }
  
  public int sizeOfMoveToRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVETORANGESTART$22);
    } 
  }
  
  public void setMoveToRangeStartArray(CTMoveBookmark[] paramArrayOfCTMoveBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMoveBookmark, MOVETORANGESTART$22);
    } 
  }
  
  public void setMoveToRangeStartArray(int paramInt, CTMoveBookmark paramCTMoveBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().find_element_user(MOVETORANGESTART$22, paramInt);
      if (cTMoveBookmark == null)
        throw new IndexOutOfBoundsException(); 
      cTMoveBookmark.set((XmlObject)paramCTMoveBookmark);
    } 
  }
  
  public CTMoveBookmark insertNewMoveToRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().insert_element_user(MOVETORANGESTART$22, paramInt);
      return cTMoveBookmark;
    } 
  }
  
  public CTMoveBookmark addNewMoveToRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().add_element_user(MOVETORANGESTART$22);
      return cTMoveBookmark;
    } 
  }
  
  public void removeMoveToRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVETORANGESTART$22, paramInt);
    } 
  }
  
  public List<CTMarkupRange> getMoveToRangeEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkupRange>)new MoveToRangeEndList(this);
    } 
  }
  
  public CTMarkupRange[] getMoveToRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MOVETORANGEEND$24, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getMoveToRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(MOVETORANGEEND$24, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfMoveToRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVETORANGEEND$24);
    } 
  }
  
  public void setMoveToRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, MOVETORANGEEND$24);
    } 
  }
  
  public void setMoveToRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(MOVETORANGEEND$24, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewMoveToRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(MOVETORANGEEND$24, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewMoveToRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(MOVETORANGEEND$24);
      return cTMarkupRange;
    } 
  }
  
  public void removeMoveToRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVETORANGEEND$24, paramInt);
    } 
  }
  
  public List<CTMarkupRange> getCommentRangeStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkupRange>)new CommentRangeStartList(this);
    } 
  }
  
  public CTMarkupRange[] getCommentRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COMMENTRANGESTART$26, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getCommentRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(COMMENTRANGESTART$26, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfCommentRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COMMENTRANGESTART$26);
    } 
  }
  
  public void setCommentRangeStartArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, COMMENTRANGESTART$26);
    } 
  }
  
  public void setCommentRangeStartArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(COMMENTRANGESTART$26, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewCommentRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(COMMENTRANGESTART$26, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewCommentRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(COMMENTRANGESTART$26);
      return cTMarkupRange;
    } 
  }
  
  public void removeCommentRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMMENTRANGESTART$26, paramInt);
    } 
  }
  
  public List<CTMarkupRange> getCommentRangeEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkupRange>)new CommentRangeEndList(this);
    } 
  }
  
  public CTMarkupRange[] getCommentRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COMMENTRANGEEND$28, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getCommentRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(COMMENTRANGEEND$28, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfCommentRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COMMENTRANGEEND$28);
    } 
  }
  
  public void setCommentRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, COMMENTRANGEEND$28);
    } 
  }
  
  public void setCommentRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(COMMENTRANGEEND$28, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewCommentRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(COMMENTRANGEEND$28, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewCommentRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(COMMENTRANGEEND$28);
      return cTMarkupRange;
    } 
  }
  
  public void removeCommentRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMMENTRANGEEND$28, paramInt);
    } 
  }
  
  public List<CTTrackChange> getCustomXmlInsRangeStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTrackChange>)new CustomXmlInsRangeStartList(this);
    } 
  }
  
  public CTTrackChange[] getCustomXmlInsRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$30, arrayList);
      CTTrackChange[] arrayOfCTTrackChange = new CTTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrackChange);
      return arrayOfCTTrackChange;
    } 
  }
  
  public CTTrackChange getCustomXmlInsRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLINSRANGESTART$30, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrackChange;
    } 
  }
  
  public int sizeOfCustomXmlInsRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLINSRANGESTART$30);
    } 
  }
  
  public void setCustomXmlInsRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrackChange, CUSTOMXMLINSRANGESTART$30);
    } 
  }
  
  public void setCustomXmlInsRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLINSRANGESTART$30, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange insertNewCustomXmlInsRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().insert_element_user(CUSTOMXMLINSRANGESTART$30, paramInt);
      return cTTrackChange;
    } 
  }
  
  public CTTrackChange addNewCustomXmlInsRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CUSTOMXMLINSRANGESTART$30);
      return cTTrackChange;
    } 
  }
  
  public void removeCustomXmlInsRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLINSRANGESTART$30, paramInt);
    } 
  }
  
  public List<CTMarkup> getCustomXmlInsRangeEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkup>)new CustomXmlInsRangeEndList(this);
    } 
  }
  
  public CTMarkup[] getCustomXmlInsRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$32, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCustomXmlInsRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLINSRANGEEND$32, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCustomXmlInsRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLINSRANGEEND$32);
    } 
  }
  
  public void setCustomXmlInsRangeEndArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, CUSTOMXMLINSRANGEEND$32);
    } 
  }
  
  public void setCustomXmlInsRangeEndArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLINSRANGEEND$32, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCustomXmlInsRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(CUSTOMXMLINSRANGEEND$32, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCustomXmlInsRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(CUSTOMXMLINSRANGEEND$32);
      return cTMarkup;
    } 
  }
  
  public void removeCustomXmlInsRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLINSRANGEEND$32, paramInt);
    } 
  }
  
  public List<CTTrackChange> getCustomXmlDelRangeStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTrackChange>)new CustomXmlDelRangeStartList(this);
    } 
  }
  
  public CTTrackChange[] getCustomXmlDelRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$34, arrayList);
      CTTrackChange[] arrayOfCTTrackChange = new CTTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrackChange);
      return arrayOfCTTrackChange;
    } 
  }
  
  public CTTrackChange getCustomXmlDelRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLDELRANGESTART$34, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrackChange;
    } 
  }
  
  public int sizeOfCustomXmlDelRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLDELRANGESTART$34);
    } 
  }
  
  public void setCustomXmlDelRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrackChange, CUSTOMXMLDELRANGESTART$34);
    } 
  }
  
  public void setCustomXmlDelRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLDELRANGESTART$34, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange insertNewCustomXmlDelRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().insert_element_user(CUSTOMXMLDELRANGESTART$34, paramInt);
      return cTTrackChange;
    } 
  }
  
  public CTTrackChange addNewCustomXmlDelRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CUSTOMXMLDELRANGESTART$34);
      return cTTrackChange;
    } 
  }
  
  public void removeCustomXmlDelRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLDELRANGESTART$34, paramInt);
    } 
  }
  
  public List<CTMarkup> getCustomXmlDelRangeEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkup>)new CustomXmlDelRangeEndList(this);
    } 
  }
  
  public CTMarkup[] getCustomXmlDelRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$36, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCustomXmlDelRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLDELRANGEEND$36, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCustomXmlDelRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLDELRANGEEND$36);
    } 
  }
  
  public void setCustomXmlDelRangeEndArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, CUSTOMXMLDELRANGEEND$36);
    } 
  }
  
  public void setCustomXmlDelRangeEndArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLDELRANGEEND$36, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCustomXmlDelRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(CUSTOMXMLDELRANGEEND$36, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCustomXmlDelRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(CUSTOMXMLDELRANGEEND$36);
      return cTMarkup;
    } 
  }
  
  public void removeCustomXmlDelRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLDELRANGEEND$36, paramInt);
    } 
  }
  
  public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTrackChange>)new CustomXmlMoveFromRangeStartList(this);
    } 
  }
  
  public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$38, arrayList);
      CTTrackChange[] arrayOfCTTrackChange = new CTTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrackChange);
      return arrayOfCTTrackChange;
    } 
  }
  
  public CTTrackChange getCustomXmlMoveFromRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrackChange;
    } 
  }
  
  public int sizeOfCustomXmlMoveFromRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$38);
    } 
  }
  
  public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrackChange, CUSTOMXMLMOVEFROMRANGESTART$38);
    } 
  }
  
  public void setCustomXmlMoveFromRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, paramInt);
      return cTTrackChange;
    } 
  }
  
  public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$38);
      return cTTrackChange;
    } 
  }
  
  public void removeCustomXmlMoveFromRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$38, paramInt);
    } 
  }
  
  public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkup>)new CustomXmlMoveFromRangeEndList(this);
    } 
  }
  
  public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$40, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCustomXmlMoveFromRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCustomXmlMoveFromRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$40);
    } 
  }
  
  public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, CUSTOMXMLMOVEFROMRANGEEND$40);
    } 
  }
  
  public void setCustomXmlMoveFromRangeEndArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$40);
      return cTMarkup;
    } 
  }
  
  public void removeCustomXmlMoveFromRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$40, paramInt);
    } 
  }
  
  public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTrackChange>)new CustomXmlMoveToRangeStartList(this);
    } 
  }
  
  public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$42, arrayList);
      CTTrackChange[] arrayOfCTTrackChange = new CTTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrackChange);
      return arrayOfCTTrackChange;
    } 
  }
  
  public CTTrackChange getCustomXmlMoveToRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$42, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrackChange;
    } 
  }
  
  public int sizeOfCustomXmlMoveToRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLMOVETORANGESTART$42);
    } 
  }
  
  public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrackChange, CUSTOMXMLMOVETORANGESTART$42);
    } 
  }
  
  public void setCustomXmlMoveToRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$42, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange insertNewCustomXmlMoveToRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$42, paramInt);
      return cTTrackChange;
    } 
  }
  
  public CTTrackChange addNewCustomXmlMoveToRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$42);
      return cTTrackChange;
    } 
  }
  
  public void removeCustomXmlMoveToRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLMOVETORANGESTART$42, paramInt);
    } 
  }
  
  public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkup>)new CustomXmlMoveToRangeEndList(this);
    } 
  }
  
  public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$44, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCustomXmlMoveToRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$44, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCustomXmlMoveToRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLMOVETORANGEEND$44);
    } 
  }
  
  public void setCustomXmlMoveToRangeEndArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, CUSTOMXMLMOVETORANGEEND$44);
    } 
  }
  
  public void setCustomXmlMoveToRangeEndArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$44, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCustomXmlMoveToRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$44, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCustomXmlMoveToRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$44);
      return cTMarkup;
    } 
  }
  
  public void removeCustomXmlMoveToRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLMOVETORANGEEND$44, paramInt);
    } 
  }
  
  public List<CTRunTrackChange> getInsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRunTrackChange>)new InsList(this);
    } 
  }
  
  public CTRunTrackChange[] getInsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(INS$46, arrayList);
      CTRunTrackChange[] arrayOfCTRunTrackChange = new CTRunTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRunTrackChange);
      return arrayOfCTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange getInsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(INS$46, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTRunTrackChange;
    } 
  }
  
  public int sizeOfInsArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INS$46);
    } 
  }
  
  public void setInsArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRunTrackChange, INS$46);
    } 
  }
  
  public void setInsArray(int paramInt, CTRunTrackChange paramCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(INS$46, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTRunTrackChange.set((XmlObject)paramCTRunTrackChange);
    } 
  }
  
  public CTRunTrackChange insertNewIns(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().insert_element_user(INS$46, paramInt);
      return cTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange addNewIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().add_element_user(INS$46);
      return cTRunTrackChange;
    } 
  }
  
  public void removeIns(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INS$46, paramInt);
    } 
  }
  
  public List<CTRunTrackChange> getDelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRunTrackChange>)new DelList(this);
    } 
  }
  
  public CTRunTrackChange[] getDelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DEL$48, arrayList);
      CTRunTrackChange[] arrayOfCTRunTrackChange = new CTRunTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRunTrackChange);
      return arrayOfCTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange getDelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(DEL$48, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTRunTrackChange;
    } 
  }
  
  public int sizeOfDelArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DEL$48);
    } 
  }
  
  public void setDelArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRunTrackChange, DEL$48);
    } 
  }
  
  public void setDelArray(int paramInt, CTRunTrackChange paramCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(DEL$48, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTRunTrackChange.set((XmlObject)paramCTRunTrackChange);
    } 
  }
  
  public CTRunTrackChange insertNewDel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().insert_element_user(DEL$48, paramInt);
      return cTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange addNewDel() {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().add_element_user(DEL$48);
      return cTRunTrackChange;
    } 
  }
  
  public void removeDel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEL$48, paramInt);
    } 
  }
  
  public List<CTRunTrackChange> getMoveFromList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRunTrackChange>)new MoveFromList(this);
    } 
  }
  
  public CTRunTrackChange[] getMoveFromArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MOVEFROM$50, arrayList);
      CTRunTrackChange[] arrayOfCTRunTrackChange = new CTRunTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRunTrackChange);
      return arrayOfCTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange getMoveFromArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(MOVEFROM$50, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTRunTrackChange;
    } 
  }
  
  public int sizeOfMoveFromArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVEFROM$50);
    } 
  }
  
  public void setMoveFromArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRunTrackChange, MOVEFROM$50);
    } 
  }
  
  public void setMoveFromArray(int paramInt, CTRunTrackChange paramCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(MOVEFROM$50, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTRunTrackChange.set((XmlObject)paramCTRunTrackChange);
    } 
  }
  
  public CTRunTrackChange insertNewMoveFrom(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().insert_element_user(MOVEFROM$50, paramInt);
      return cTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange addNewMoveFrom() {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().add_element_user(MOVEFROM$50);
      return cTRunTrackChange;
    } 
  }
  
  public void removeMoveFrom(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVEFROM$50, paramInt);
    } 
  }
  
  public List<CTRunTrackChange> getMoveToList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRunTrackChange>)new MoveToList(this);
    } 
  }
  
  public CTRunTrackChange[] getMoveToArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MOVETO$52, arrayList);
      CTRunTrackChange[] arrayOfCTRunTrackChange = new CTRunTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRunTrackChange);
      return arrayOfCTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange getMoveToArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(MOVETO$52, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTRunTrackChange;
    } 
  }
  
  public int sizeOfMoveToArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVETO$52);
    } 
  }
  
  public void setMoveToArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRunTrackChange, MOVETO$52);
    } 
  }
  
  public void setMoveToArray(int paramInt, CTRunTrackChange paramCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(MOVETO$52, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTRunTrackChange.set((XmlObject)paramCTRunTrackChange);
    } 
  }
  
  public CTRunTrackChange insertNewMoveTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().insert_element_user(MOVETO$52, paramInt);
      return cTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange addNewMoveTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().add_element_user(MOVETO$52);
      return cTRunTrackChange;
    } 
  }
  
  public void removeMoveTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVETO$52, paramInt);
    } 
  }
  
  public List<CTOMathPara> getOMathParaList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOMathPara>)new OMathParaList(this);
    } 
  }
  
  public CTOMathPara[] getOMathParaArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(OMATHPARA$54, arrayList);
      CTOMathPara[] arrayOfCTOMathPara = new CTOMathPara[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOMathPara);
      return arrayOfCTOMathPara;
    } 
  }
  
  public CTOMathPara getOMathParaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMathPara cTOMathPara = null;
      cTOMathPara = (CTOMathPara)get_store().find_element_user(OMATHPARA$54, paramInt);
      if (cTOMathPara == null)
        throw new IndexOutOfBoundsException(); 
      return cTOMathPara;
    } 
  }
  
  public int sizeOfOMathParaArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(OMATHPARA$54);
    } 
  }
  
  public void setOMathParaArray(CTOMathPara[] paramArrayOfCTOMathPara) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOMathPara, OMATHPARA$54);
    } 
  }
  
  public void setOMathParaArray(int paramInt, CTOMathPara paramCTOMathPara) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMathPara cTOMathPara = null;
      cTOMathPara = (CTOMathPara)get_store().find_element_user(OMATHPARA$54, paramInt);
      if (cTOMathPara == null)
        throw new IndexOutOfBoundsException(); 
      cTOMathPara.set((XmlObject)paramCTOMathPara);
    } 
  }
  
  public CTOMathPara insertNewOMathPara(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMathPara cTOMathPara = null;
      cTOMathPara = (CTOMathPara)get_store().insert_element_user(OMATHPARA$54, paramInt);
      return cTOMathPara;
    } 
  }
  
  public CTOMathPara addNewOMathPara() {
    synchronized (monitor()) {
      check_orphaned();
      CTOMathPara cTOMathPara = null;
      cTOMathPara = (CTOMathPara)get_store().add_element_user(OMATHPARA$54);
      return cTOMathPara;
    } 
  }
  
  public void removeOMathPara(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OMATHPARA$54, paramInt);
    } 
  }
  
  public List<CTOMath> getOMathList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOMath>)new OMathList(this);
    } 
  }
  
  public CTOMath[] getOMathArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(OMATH$56, arrayList);
      CTOMath[] arrayOfCTOMath = new CTOMath[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOMath);
      return arrayOfCTOMath;
    } 
  }
  
  public CTOMath getOMathArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMath cTOMath = null;
      cTOMath = (CTOMath)get_store().find_element_user(OMATH$56, paramInt);
      if (cTOMath == null)
        throw new IndexOutOfBoundsException(); 
      return cTOMath;
    } 
  }
  
  public int sizeOfOMathArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(OMATH$56);
    } 
  }
  
  public void setOMathArray(CTOMath[] paramArrayOfCTOMath) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOMath, OMATH$56);
    } 
  }
  
  public void setOMathArray(int paramInt, CTOMath paramCTOMath) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMath cTOMath = null;
      cTOMath = (CTOMath)get_store().find_element_user(OMATH$56, paramInt);
      if (cTOMath == null)
        throw new IndexOutOfBoundsException(); 
      cTOMath.set((XmlObject)paramCTOMath);
    } 
  }
  
  public CTOMath insertNewOMath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMath cTOMath = null;
      cTOMath = (CTOMath)get_store().insert_element_user(OMATH$56, paramInt);
      return cTOMath;
    } 
  }
  
  public CTOMath addNewOMath() {
    synchronized (monitor()) {
      check_orphaned();
      CTOMath cTOMath = null;
      cTOMath = (CTOMath)get_store().add_element_user(OMATH$56);
      return cTOMath;
    } 
  }
  
  public void removeOMath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OMATH$56, paramInt);
    } 
  }
  
  public List<CTAcc> getAccList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAcc>)new AccList(this);
    } 
  }
  
  public CTAcc[] getAccArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ACC$58, arrayList);
      CTAcc[] arrayOfCTAcc = new CTAcc[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAcc);
      return arrayOfCTAcc;
    } 
  }
  
  public CTAcc getAccArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAcc cTAcc = null;
      cTAcc = (CTAcc)get_store().find_element_user(ACC$58, paramInt);
      if (cTAcc == null)
        throw new IndexOutOfBoundsException(); 
      return cTAcc;
    } 
  }
  
  public int sizeOfAccArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ACC$58);
    } 
  }
  
  public void setAccArray(CTAcc[] paramArrayOfCTAcc) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAcc, ACC$58);
    } 
  }
  
  public void setAccArray(int paramInt, CTAcc paramCTAcc) {
    synchronized (monitor()) {
      check_orphaned();
      CTAcc cTAcc = null;
      cTAcc = (CTAcc)get_store().find_element_user(ACC$58, paramInt);
      if (cTAcc == null)
        throw new IndexOutOfBoundsException(); 
      cTAcc.set((XmlObject)paramCTAcc);
    } 
  }
  
  public CTAcc insertNewAcc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAcc cTAcc = null;
      cTAcc = (CTAcc)get_store().insert_element_user(ACC$58, paramInt);
      return cTAcc;
    } 
  }
  
  public CTAcc addNewAcc() {
    synchronized (monitor()) {
      check_orphaned();
      CTAcc cTAcc = null;
      cTAcc = (CTAcc)get_store().add_element_user(ACC$58);
      return cTAcc;
    } 
  }
  
  public void removeAcc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ACC$58, paramInt);
    } 
  }
  
  public List<CTBar> getBarList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBar>)new BarList(this);
    } 
  }
  
  public CTBar[] getBarArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BAR$60, arrayList);
      CTBar[] arrayOfCTBar = new CTBar[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBar);
      return arrayOfCTBar;
    } 
  }
  
  public CTBar getBarArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBar cTBar = null;
      cTBar = (CTBar)get_store().find_element_user(BAR$60, paramInt);
      if (cTBar == null)
        throw new IndexOutOfBoundsException(); 
      return cTBar;
    } 
  }
  
  public int sizeOfBarArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BAR$60);
    } 
  }
  
  public void setBarArray(CTBar[] paramArrayOfCTBar) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBar, BAR$60);
    } 
  }
  
  public void setBarArray(int paramInt, CTBar paramCTBar) {
    synchronized (monitor()) {
      check_orphaned();
      CTBar cTBar = null;
      cTBar = (CTBar)get_store().find_element_user(BAR$60, paramInt);
      if (cTBar == null)
        throw new IndexOutOfBoundsException(); 
      cTBar.set((XmlObject)paramCTBar);
    } 
  }
  
  public CTBar insertNewBar(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBar cTBar = null;
      cTBar = (CTBar)get_store().insert_element_user(BAR$60, paramInt);
      return cTBar;
    } 
  }
  
  public CTBar addNewBar() {
    synchronized (monitor()) {
      check_orphaned();
      CTBar cTBar = null;
      cTBar = (CTBar)get_store().add_element_user(BAR$60);
      return cTBar;
    } 
  }
  
  public void removeBar(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BAR$60, paramInt);
    } 
  }
  
  public List<CTBox> getBoxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBox>)new BoxList(this);
    } 
  }
  
  public CTBox[] getBoxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BOX$62, arrayList);
      CTBox[] arrayOfCTBox = new CTBox[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBox);
      return arrayOfCTBox;
    } 
  }
  
  public CTBox getBoxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBox cTBox = null;
      cTBox = (CTBox)get_store().find_element_user(BOX$62, paramInt);
      if (cTBox == null)
        throw new IndexOutOfBoundsException(); 
      return cTBox;
    } 
  }
  
  public int sizeOfBoxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BOX$62);
    } 
  }
  
  public void setBoxArray(CTBox[] paramArrayOfCTBox) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBox, BOX$62);
    } 
  }
  
  public void setBoxArray(int paramInt, CTBox paramCTBox) {
    synchronized (monitor()) {
      check_orphaned();
      CTBox cTBox = null;
      cTBox = (CTBox)get_store().find_element_user(BOX$62, paramInt);
      if (cTBox == null)
        throw new IndexOutOfBoundsException(); 
      cTBox.set((XmlObject)paramCTBox);
    } 
  }
  
  public CTBox insertNewBox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBox cTBox = null;
      cTBox = (CTBox)get_store().insert_element_user(BOX$62, paramInt);
      return cTBox;
    } 
  }
  
  public CTBox addNewBox() {
    synchronized (monitor()) {
      check_orphaned();
      CTBox cTBox = null;
      cTBox = (CTBox)get_store().add_element_user(BOX$62);
      return cTBox;
    } 
  }
  
  public void removeBox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOX$62, paramInt);
    } 
  }
  
  public List<CTBorderBox> getBorderBoxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBorderBox>)new BorderBoxList(this);
    } 
  }
  
  public CTBorderBox[] getBorderBoxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BORDERBOX$64, arrayList);
      CTBorderBox[] arrayOfCTBorderBox = new CTBorderBox[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBorderBox);
      return arrayOfCTBorderBox;
    } 
  }
  
  public CTBorderBox getBorderBoxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderBox cTBorderBox = null;
      cTBorderBox = (CTBorderBox)get_store().find_element_user(BORDERBOX$64, paramInt);
      if (cTBorderBox == null)
        throw new IndexOutOfBoundsException(); 
      return cTBorderBox;
    } 
  }
  
  public int sizeOfBorderBoxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BORDERBOX$64);
    } 
  }
  
  public void setBorderBoxArray(CTBorderBox[] paramArrayOfCTBorderBox) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBorderBox, BORDERBOX$64);
    } 
  }
  
  public void setBorderBoxArray(int paramInt, CTBorderBox paramCTBorderBox) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderBox cTBorderBox = null;
      cTBorderBox = (CTBorderBox)get_store().find_element_user(BORDERBOX$64, paramInt);
      if (cTBorderBox == null)
        throw new IndexOutOfBoundsException(); 
      cTBorderBox.set((XmlObject)paramCTBorderBox);
    } 
  }
  
  public CTBorderBox insertNewBorderBox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderBox cTBorderBox = null;
      cTBorderBox = (CTBorderBox)get_store().insert_element_user(BORDERBOX$64, paramInt);
      return cTBorderBox;
    } 
  }
  
  public CTBorderBox addNewBorderBox() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderBox cTBorderBox = null;
      cTBorderBox = (CTBorderBox)get_store().add_element_user(BORDERBOX$64);
      return cTBorderBox;
    } 
  }
  
  public void removeBorderBox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDERBOX$64, paramInt);
    } 
  }
  
  public List<CTD> getDList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTD>)new DList(this);
    } 
  }
  
  public CTD[] getDArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(D$66, arrayList);
      CTD[] arrayOfCTD = new CTD[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTD);
      return arrayOfCTD;
    } 
  }
  
  public CTD getDArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTD cTD = null;
      cTD = (CTD)get_store().find_element_user(D$66, paramInt);
      if (cTD == null)
        throw new IndexOutOfBoundsException(); 
      return cTD;
    } 
  }
  
  public int sizeOfDArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(D$66);
    } 
  }
  
  public void setDArray(CTD[] paramArrayOfCTD) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTD, D$66);
    } 
  }
  
  public void setDArray(int paramInt, CTD paramCTD) {
    synchronized (monitor()) {
      check_orphaned();
      CTD cTD = null;
      cTD = (CTD)get_store().find_element_user(D$66, paramInt);
      if (cTD == null)
        throw new IndexOutOfBoundsException(); 
      cTD.set((XmlObject)paramCTD);
    } 
  }
  
  public CTD insertNewD(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTD cTD = null;
      cTD = (CTD)get_store().insert_element_user(D$66, paramInt);
      return cTD;
    } 
  }
  
  public CTD addNewD() {
    synchronized (monitor()) {
      check_orphaned();
      CTD cTD = null;
      cTD = (CTD)get_store().add_element_user(D$66);
      return cTD;
    } 
  }
  
  public void removeD(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(D$66, paramInt);
    } 
  }
  
  public List<CTEqArr> getEqArrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEqArr>)new EqArrList(this);
    } 
  }
  
  public CTEqArr[] getEqArrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(EQARR$68, arrayList);
      CTEqArr[] arrayOfCTEqArr = new CTEqArr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEqArr);
      return arrayOfCTEqArr;
    } 
  }
  
  public CTEqArr getEqArrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEqArr cTEqArr = null;
      cTEqArr = (CTEqArr)get_store().find_element_user(EQARR$68, paramInt);
      if (cTEqArr == null)
        throw new IndexOutOfBoundsException(); 
      return cTEqArr;
    } 
  }
  
  public int sizeOfEqArrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(EQARR$68);
    } 
  }
  
  public void setEqArrArray(CTEqArr[] paramArrayOfCTEqArr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEqArr, EQARR$68);
    } 
  }
  
  public void setEqArrArray(int paramInt, CTEqArr paramCTEqArr) {
    synchronized (monitor()) {
      check_orphaned();
      CTEqArr cTEqArr = null;
      cTEqArr = (CTEqArr)get_store().find_element_user(EQARR$68, paramInt);
      if (cTEqArr == null)
        throw new IndexOutOfBoundsException(); 
      cTEqArr.set((XmlObject)paramCTEqArr);
    } 
  }
  
  public CTEqArr insertNewEqArr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEqArr cTEqArr = null;
      cTEqArr = (CTEqArr)get_store().insert_element_user(EQARR$68, paramInt);
      return cTEqArr;
    } 
  }
  
  public CTEqArr addNewEqArr() {
    synchronized (monitor()) {
      check_orphaned();
      CTEqArr cTEqArr = null;
      cTEqArr = (CTEqArr)get_store().add_element_user(EQARR$68);
      return cTEqArr;
    } 
  }
  
  public void removeEqArr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EQARR$68, paramInt);
    } 
  }
  
  public List<CTF> getFList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTF>)new FList(this);
    } 
  }
  
  public CTF[] getFArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(F$70, arrayList);
      CTF[] arrayOfCTF = new CTF[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTF);
      return arrayOfCTF;
    } 
  }
  
  public CTF getFArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTF cTF = null;
      cTF = (CTF)get_store().find_element_user(F$70, paramInt);
      if (cTF == null)
        throw new IndexOutOfBoundsException(); 
      return cTF;
    } 
  }
  
  public int sizeOfFArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(F$70);
    } 
  }
  
  public void setFArray(CTF[] paramArrayOfCTF) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTF, F$70);
    } 
  }
  
  public void setFArray(int paramInt, CTF paramCTF) {
    synchronized (monitor()) {
      check_orphaned();
      CTF cTF = null;
      cTF = (CTF)get_store().find_element_user(F$70, paramInt);
      if (cTF == null)
        throw new IndexOutOfBoundsException(); 
      cTF.set((XmlObject)paramCTF);
    } 
  }
  
  public CTF insertNewF(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTF cTF = null;
      cTF = (CTF)get_store().insert_element_user(F$70, paramInt);
      return cTF;
    } 
  }
  
  public CTF addNewF() {
    synchronized (monitor()) {
      check_orphaned();
      CTF cTF = null;
      cTF = (CTF)get_store().add_element_user(F$70);
      return cTF;
    } 
  }
  
  public void removeF(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(F$70, paramInt);
    } 
  }
  
  public List<CTFunc> getFuncList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFunc>)new FuncList(this);
    } 
  }
  
  public CTFunc[] getFuncArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FUNC$72, arrayList);
      CTFunc[] arrayOfCTFunc = new CTFunc[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFunc);
      return arrayOfCTFunc;
    } 
  }
  
  public CTFunc getFuncArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFunc cTFunc = null;
      cTFunc = (CTFunc)get_store().find_element_user(FUNC$72, paramInt);
      if (cTFunc == null)
        throw new IndexOutOfBoundsException(); 
      return cTFunc;
    } 
  }
  
  public int sizeOfFuncArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FUNC$72);
    } 
  }
  
  public void setFuncArray(CTFunc[] paramArrayOfCTFunc) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFunc, FUNC$72);
    } 
  }
  
  public void setFuncArray(int paramInt, CTFunc paramCTFunc) {
    synchronized (monitor()) {
      check_orphaned();
      CTFunc cTFunc = null;
      cTFunc = (CTFunc)get_store().find_element_user(FUNC$72, paramInt);
      if (cTFunc == null)
        throw new IndexOutOfBoundsException(); 
      cTFunc.set((XmlObject)paramCTFunc);
    } 
  }
  
  public CTFunc insertNewFunc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFunc cTFunc = null;
      cTFunc = (CTFunc)get_store().insert_element_user(FUNC$72, paramInt);
      return cTFunc;
    } 
  }
  
  public CTFunc addNewFunc() {
    synchronized (monitor()) {
      check_orphaned();
      CTFunc cTFunc = null;
      cTFunc = (CTFunc)get_store().add_element_user(FUNC$72);
      return cTFunc;
    } 
  }
  
  public void removeFunc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FUNC$72, paramInt);
    } 
  }
  
  public List<CTGroupChr> getGroupChrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGroupChr>)new GroupChrList(this);
    } 
  }
  
  public CTGroupChr[] getGroupChrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GROUPCHR$74, arrayList);
      CTGroupChr[] arrayOfCTGroupChr = new CTGroupChr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGroupChr);
      return arrayOfCTGroupChr;
    } 
  }
  
  public CTGroupChr getGroupChrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupChr cTGroupChr = null;
      cTGroupChr = (CTGroupChr)get_store().find_element_user(GROUPCHR$74, paramInt);
      if (cTGroupChr == null)
        throw new IndexOutOfBoundsException(); 
      return cTGroupChr;
    } 
  }
  
  public int sizeOfGroupChrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GROUPCHR$74);
    } 
  }
  
  public void setGroupChrArray(CTGroupChr[] paramArrayOfCTGroupChr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGroupChr, GROUPCHR$74);
    } 
  }
  
  public void setGroupChrArray(int paramInt, CTGroupChr paramCTGroupChr) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupChr cTGroupChr = null;
      cTGroupChr = (CTGroupChr)get_store().find_element_user(GROUPCHR$74, paramInt);
      if (cTGroupChr == null)
        throw new IndexOutOfBoundsException(); 
      cTGroupChr.set((XmlObject)paramCTGroupChr);
    } 
  }
  
  public CTGroupChr insertNewGroupChr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupChr cTGroupChr = null;
      cTGroupChr = (CTGroupChr)get_store().insert_element_user(GROUPCHR$74, paramInt);
      return cTGroupChr;
    } 
  }
  
  public CTGroupChr addNewGroupChr() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupChr cTGroupChr = null;
      cTGroupChr = (CTGroupChr)get_store().add_element_user(GROUPCHR$74);
      return cTGroupChr;
    } 
  }
  
  public void removeGroupChr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GROUPCHR$74, paramInt);
    } 
  }
  
  public List<CTLimLow> getLimLowList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLimLow>)new LimLowList(this);
    } 
  }
  
  public CTLimLow[] getLimLowArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LIMLOW$76, arrayList);
      CTLimLow[] arrayOfCTLimLow = new CTLimLow[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLimLow);
      return arrayOfCTLimLow;
    } 
  }
  
  public CTLimLow getLimLowArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLimLow cTLimLow = null;
      cTLimLow = (CTLimLow)get_store().find_element_user(LIMLOW$76, paramInt);
      if (cTLimLow == null)
        throw new IndexOutOfBoundsException(); 
      return cTLimLow;
    } 
  }
  
  public int sizeOfLimLowArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LIMLOW$76);
    } 
  }
  
  public void setLimLowArray(CTLimLow[] paramArrayOfCTLimLow) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLimLow, LIMLOW$76);
    } 
  }
  
  public void setLimLowArray(int paramInt, CTLimLow paramCTLimLow) {
    synchronized (monitor()) {
      check_orphaned();
      CTLimLow cTLimLow = null;
      cTLimLow = (CTLimLow)get_store().find_element_user(LIMLOW$76, paramInt);
      if (cTLimLow == null)
        throw new IndexOutOfBoundsException(); 
      cTLimLow.set((XmlObject)paramCTLimLow);
    } 
  }
  
  public CTLimLow insertNewLimLow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLimLow cTLimLow = null;
      cTLimLow = (CTLimLow)get_store().insert_element_user(LIMLOW$76, paramInt);
      return cTLimLow;
    } 
  }
  
  public CTLimLow addNewLimLow() {
    synchronized (monitor()) {
      check_orphaned();
      CTLimLow cTLimLow = null;
      cTLimLow = (CTLimLow)get_store().add_element_user(LIMLOW$76);
      return cTLimLow;
    } 
  }
  
  public void removeLimLow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LIMLOW$76, paramInt);
    } 
  }
  
  public List<CTLimUpp> getLimUppList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLimUpp>)new LimUppList(this);
    } 
  }
  
  public CTLimUpp[] getLimUppArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LIMUPP$78, arrayList);
      CTLimUpp[] arrayOfCTLimUpp = new CTLimUpp[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLimUpp);
      return arrayOfCTLimUpp;
    } 
  }
  
  public CTLimUpp getLimUppArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLimUpp cTLimUpp = null;
      cTLimUpp = (CTLimUpp)get_store().find_element_user(LIMUPP$78, paramInt);
      if (cTLimUpp == null)
        throw new IndexOutOfBoundsException(); 
      return cTLimUpp;
    } 
  }
  
  public int sizeOfLimUppArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LIMUPP$78);
    } 
  }
  
  public void setLimUppArray(CTLimUpp[] paramArrayOfCTLimUpp) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLimUpp, LIMUPP$78);
    } 
  }
  
  public void setLimUppArray(int paramInt, CTLimUpp paramCTLimUpp) {
    synchronized (monitor()) {
      check_orphaned();
      CTLimUpp cTLimUpp = null;
      cTLimUpp = (CTLimUpp)get_store().find_element_user(LIMUPP$78, paramInt);
      if (cTLimUpp == null)
        throw new IndexOutOfBoundsException(); 
      cTLimUpp.set((XmlObject)paramCTLimUpp);
    } 
  }
  
  public CTLimUpp insertNewLimUpp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLimUpp cTLimUpp = null;
      cTLimUpp = (CTLimUpp)get_store().insert_element_user(LIMUPP$78, paramInt);
      return cTLimUpp;
    } 
  }
  
  public CTLimUpp addNewLimUpp() {
    synchronized (monitor()) {
      check_orphaned();
      CTLimUpp cTLimUpp = null;
      cTLimUpp = (CTLimUpp)get_store().add_element_user(LIMUPP$78);
      return cTLimUpp;
    } 
  }
  
  public void removeLimUpp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LIMUPP$78, paramInt);
    } 
  }
  
  public List<CTM> getMList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTM>)new MList(this);
    } 
  }
  
  public CTM[] getMArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(M$80, arrayList);
      CTM[] arrayOfCTM = new CTM[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTM);
      return arrayOfCTM;
    } 
  }
  
  public CTM getMArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTM cTM = null;
      cTM = (CTM)get_store().find_element_user(M$80, paramInt);
      if (cTM == null)
        throw new IndexOutOfBoundsException(); 
      return cTM;
    } 
  }
  
  public int sizeOfMArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(M$80);
    } 
  }
  
  public void setMArray(CTM[] paramArrayOfCTM) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTM, M$80);
    } 
  }
  
  public void setMArray(int paramInt, CTM paramCTM) {
    synchronized (monitor()) {
      check_orphaned();
      CTM cTM = null;
      cTM = (CTM)get_store().find_element_user(M$80, paramInt);
      if (cTM == null)
        throw new IndexOutOfBoundsException(); 
      cTM.set((XmlObject)paramCTM);
    } 
  }
  
  public CTM insertNewM(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTM cTM = null;
      cTM = (CTM)get_store().insert_element_user(M$80, paramInt);
      return cTM;
    } 
  }
  
  public CTM addNewM() {
    synchronized (monitor()) {
      check_orphaned();
      CTM cTM = null;
      cTM = (CTM)get_store().add_element_user(M$80);
      return cTM;
    } 
  }
  
  public void removeM(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(M$80, paramInt);
    } 
  }
  
  public List<CTNary> getNaryList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTNary>)new NaryList(this);
    } 
  }
  
  public CTNary[] getNaryArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NARY$82, arrayList);
      CTNary[] arrayOfCTNary = new CTNary[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTNary);
      return arrayOfCTNary;
    } 
  }
  
  public CTNary getNaryArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNary cTNary = null;
      cTNary = (CTNary)get_store().find_element_user(NARY$82, paramInt);
      if (cTNary == null)
        throw new IndexOutOfBoundsException(); 
      return cTNary;
    } 
  }
  
  public int sizeOfNaryArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NARY$82);
    } 
  }
  
  public void setNaryArray(CTNary[] paramArrayOfCTNary) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTNary, NARY$82);
    } 
  }
  
  public void setNaryArray(int paramInt, CTNary paramCTNary) {
    synchronized (monitor()) {
      check_orphaned();
      CTNary cTNary = null;
      cTNary = (CTNary)get_store().find_element_user(NARY$82, paramInt);
      if (cTNary == null)
        throw new IndexOutOfBoundsException(); 
      cTNary.set((XmlObject)paramCTNary);
    } 
  }
  
  public CTNary insertNewNary(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNary cTNary = null;
      cTNary = (CTNary)get_store().insert_element_user(NARY$82, paramInt);
      return cTNary;
    } 
  }
  
  public CTNary addNewNary() {
    synchronized (monitor()) {
      check_orphaned();
      CTNary cTNary = null;
      cTNary = (CTNary)get_store().add_element_user(NARY$82);
      return cTNary;
    } 
  }
  
  public void removeNary(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NARY$82, paramInt);
    } 
  }
  
  public List<CTPhant> getPhantList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPhant>)new PhantList(this);
    } 
  }
  
  public CTPhant[] getPhantArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PHANT$84, arrayList);
      CTPhant[] arrayOfCTPhant = new CTPhant[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPhant);
      return arrayOfCTPhant;
    } 
  }
  
  public CTPhant getPhantArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhant cTPhant = null;
      cTPhant = (CTPhant)get_store().find_element_user(PHANT$84, paramInt);
      if (cTPhant == null)
        throw new IndexOutOfBoundsException(); 
      return cTPhant;
    } 
  }
  
  public int sizeOfPhantArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PHANT$84);
    } 
  }
  
  public void setPhantArray(CTPhant[] paramArrayOfCTPhant) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPhant, PHANT$84);
    } 
  }
  
  public void setPhantArray(int paramInt, CTPhant paramCTPhant) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhant cTPhant = null;
      cTPhant = (CTPhant)get_store().find_element_user(PHANT$84, paramInt);
      if (cTPhant == null)
        throw new IndexOutOfBoundsException(); 
      cTPhant.set((XmlObject)paramCTPhant);
    } 
  }
  
  public CTPhant insertNewPhant(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhant cTPhant = null;
      cTPhant = (CTPhant)get_store().insert_element_user(PHANT$84, paramInt);
      return cTPhant;
    } 
  }
  
  public CTPhant addNewPhant() {
    synchronized (monitor()) {
      check_orphaned();
      CTPhant cTPhant = null;
      cTPhant = (CTPhant)get_store().add_element_user(PHANT$84);
      return cTPhant;
    } 
  }
  
  public void removePhant(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PHANT$84, paramInt);
    } 
  }
  
  public List<CTRad> getRadList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRad>)new RadList(this);
    } 
  }
  
  public CTRad[] getRadArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RAD$86, arrayList);
      CTRad[] arrayOfCTRad = new CTRad[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRad);
      return arrayOfCTRad;
    } 
  }
  
  public CTRad getRadArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRad cTRad = null;
      cTRad = (CTRad)get_store().find_element_user(RAD$86, paramInt);
      if (cTRad == null)
        throw new IndexOutOfBoundsException(); 
      return cTRad;
    } 
  }
  
  public int sizeOfRadArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RAD$86);
    } 
  }
  
  public void setRadArray(CTRad[] paramArrayOfCTRad) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRad, RAD$86);
    } 
  }
  
  public void setRadArray(int paramInt, CTRad paramCTRad) {
    synchronized (monitor()) {
      check_orphaned();
      CTRad cTRad = null;
      cTRad = (CTRad)get_store().find_element_user(RAD$86, paramInt);
      if (cTRad == null)
        throw new IndexOutOfBoundsException(); 
      cTRad.set((XmlObject)paramCTRad);
    } 
  }
  
  public CTRad insertNewRad(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRad cTRad = null;
      cTRad = (CTRad)get_store().insert_element_user(RAD$86, paramInt);
      return cTRad;
    } 
  }
  
  public CTRad addNewRad() {
    synchronized (monitor()) {
      check_orphaned();
      CTRad cTRad = null;
      cTRad = (CTRad)get_store().add_element_user(RAD$86);
      return cTRad;
    } 
  }
  
  public void removeRad(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RAD$86, paramInt);
    } 
  }
  
  public List<CTSPre> getSPreList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSPre>)new SPreList(this);
    } 
  }
  
  public CTSPre[] getSPreArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SPRE$88, arrayList);
      CTSPre[] arrayOfCTSPre = new CTSPre[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSPre);
      return arrayOfCTSPre;
    } 
  }
  
  public CTSPre getSPreArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSPre cTSPre = null;
      cTSPre = (CTSPre)get_store().find_element_user(SPRE$88, paramInt);
      if (cTSPre == null)
        throw new IndexOutOfBoundsException(); 
      return cTSPre;
    } 
  }
  
  public int sizeOfSPreArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SPRE$88);
    } 
  }
  
  public void setSPreArray(CTSPre[] paramArrayOfCTSPre) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSPre, SPRE$88);
    } 
  }
  
  public void setSPreArray(int paramInt, CTSPre paramCTSPre) {
    synchronized (monitor()) {
      check_orphaned();
      CTSPre cTSPre = null;
      cTSPre = (CTSPre)get_store().find_element_user(SPRE$88, paramInt);
      if (cTSPre == null)
        throw new IndexOutOfBoundsException(); 
      cTSPre.set((XmlObject)paramCTSPre);
    } 
  }
  
  public CTSPre insertNewSPre(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSPre cTSPre = null;
      cTSPre = (CTSPre)get_store().insert_element_user(SPRE$88, paramInt);
      return cTSPre;
    } 
  }
  
  public CTSPre addNewSPre() {
    synchronized (monitor()) {
      check_orphaned();
      CTSPre cTSPre = null;
      cTSPre = (CTSPre)get_store().add_element_user(SPRE$88);
      return cTSPre;
    } 
  }
  
  public void removeSPre(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPRE$88, paramInt);
    } 
  }
  
  public List<CTSSub> getSSubList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSSub>)new SSubList(this);
    } 
  }
  
  public CTSSub[] getSSubArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SSUB$90, arrayList);
      CTSSub[] arrayOfCTSSub = new CTSSub[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSSub);
      return arrayOfCTSSub;
    } 
  }
  
  public CTSSub getSSubArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSub cTSSub = null;
      cTSSub = (CTSSub)get_store().find_element_user(SSUB$90, paramInt);
      if (cTSSub == null)
        throw new IndexOutOfBoundsException(); 
      return cTSSub;
    } 
  }
  
  public int sizeOfSSubArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SSUB$90);
    } 
  }
  
  public void setSSubArray(CTSSub[] paramArrayOfCTSSub) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSSub, SSUB$90);
    } 
  }
  
  public void setSSubArray(int paramInt, CTSSub paramCTSSub) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSub cTSSub = null;
      cTSSub = (CTSSub)get_store().find_element_user(SSUB$90, paramInt);
      if (cTSSub == null)
        throw new IndexOutOfBoundsException(); 
      cTSSub.set((XmlObject)paramCTSSub);
    } 
  }
  
  public CTSSub insertNewSSub(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSub cTSSub = null;
      cTSSub = (CTSSub)get_store().insert_element_user(SSUB$90, paramInt);
      return cTSSub;
    } 
  }
  
  public CTSSub addNewSSub() {
    synchronized (monitor()) {
      check_orphaned();
      CTSSub cTSSub = null;
      cTSSub = (CTSSub)get_store().add_element_user(SSUB$90);
      return cTSSub;
    } 
  }
  
  public void removeSSub(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SSUB$90, paramInt);
    } 
  }
  
  public List<CTSSubSup> getSSubSupList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSSubSup>)new SSubSupList(this);
    } 
  }
  
  public CTSSubSup[] getSSubSupArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SSUBSUP$92, arrayList);
      CTSSubSup[] arrayOfCTSSubSup = new CTSSubSup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSSubSup);
      return arrayOfCTSSubSup;
    } 
  }
  
  public CTSSubSup getSSubSupArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSubSup cTSSubSup = null;
      cTSSubSup = (CTSSubSup)get_store().find_element_user(SSUBSUP$92, paramInt);
      if (cTSSubSup == null)
        throw new IndexOutOfBoundsException(); 
      return cTSSubSup;
    } 
  }
  
  public int sizeOfSSubSupArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SSUBSUP$92);
    } 
  }
  
  public void setSSubSupArray(CTSSubSup[] paramArrayOfCTSSubSup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSSubSup, SSUBSUP$92);
    } 
  }
  
  public void setSSubSupArray(int paramInt, CTSSubSup paramCTSSubSup) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSubSup cTSSubSup = null;
      cTSSubSup = (CTSSubSup)get_store().find_element_user(SSUBSUP$92, paramInt);
      if (cTSSubSup == null)
        throw new IndexOutOfBoundsException(); 
      cTSSubSup.set((XmlObject)paramCTSSubSup);
    } 
  }
  
  public CTSSubSup insertNewSSubSup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSubSup cTSSubSup = null;
      cTSSubSup = (CTSSubSup)get_store().insert_element_user(SSUBSUP$92, paramInt);
      return cTSSubSup;
    } 
  }
  
  public CTSSubSup addNewSSubSup() {
    synchronized (monitor()) {
      check_orphaned();
      CTSSubSup cTSSubSup = null;
      cTSSubSup = (CTSSubSup)get_store().add_element_user(SSUBSUP$92);
      return cTSSubSup;
    } 
  }
  
  public void removeSSubSup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SSUBSUP$92, paramInt);
    } 
  }
  
  public List<CTSSup> getSSupList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSSup>)new SSupList(this);
    } 
  }
  
  public CTSSup[] getSSupArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SSUP$94, arrayList);
      CTSSup[] arrayOfCTSSup = new CTSSup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSSup);
      return arrayOfCTSSup;
    } 
  }
  
  public CTSSup getSSupArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSup cTSSup = null;
      cTSSup = (CTSSup)get_store().find_element_user(SSUP$94, paramInt);
      if (cTSSup == null)
        throw new IndexOutOfBoundsException(); 
      return cTSSup;
    } 
  }
  
  public int sizeOfSSupArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SSUP$94);
    } 
  }
  
  public void setSSupArray(CTSSup[] paramArrayOfCTSSup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSSup, SSUP$94);
    } 
  }
  
  public void setSSupArray(int paramInt, CTSSup paramCTSSup) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSup cTSSup = null;
      cTSSup = (CTSSup)get_store().find_element_user(SSUP$94, paramInt);
      if (cTSSup == null)
        throw new IndexOutOfBoundsException(); 
      cTSSup.set((XmlObject)paramCTSSup);
    } 
  }
  
  public CTSSup insertNewSSup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSSup cTSSup = null;
      cTSSup = (CTSSup)get_store().insert_element_user(SSUP$94, paramInt);
      return cTSSup;
    } 
  }
  
  public CTSSup addNewSSup() {
    synchronized (monitor()) {
      check_orphaned();
      CTSSup cTSSup = null;
      cTSSup = (CTSSup)get_store().add_element_user(SSUP$94);
      return cTSSup;
    } 
  }
  
  public void removeSSup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SSUP$94, paramInt);
    } 
  }
  
  public List<CTR> getR2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTR>)new R2List(this);
    } 
  }
  
  public CTR[] getR2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R2$96, arrayList);
      CTR[] arrayOfCTR = new CTR[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTR);
      return arrayOfCTR;
    } 
  }
  
  public CTR getR2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTR cTR = null;
      cTR = (CTR)get_store().find_element_user(R2$96, paramInt);
      if (cTR == null)
        throw new IndexOutOfBoundsException(); 
      return cTR;
    } 
  }
  
  public int sizeOfR2Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(R2$96);
    } 
  }
  
  public void setR2Array(CTR[] paramArrayOfCTR) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTR, R2$96);
    } 
  }
  
  public void setR2Array(int paramInt, CTR paramCTR) {
    synchronized (monitor()) {
      check_orphaned();
      CTR cTR = null;
      cTR = (CTR)get_store().find_element_user(R2$96, paramInt);
      if (cTR == null)
        throw new IndexOutOfBoundsException(); 
      cTR.set((XmlObject)paramCTR);
    } 
  }
  
  public CTR insertNewR2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTR cTR = null;
      cTR = (CTR)get_store().insert_element_user(R2$96, paramInt);
      return cTR;
    } 
  }
  
  public CTR addNewR2() {
    synchronized (monitor()) {
      check_orphaned();
      CTR cTR = null;
      cTR = (CTR)get_store().add_element_user(R2$96);
      return cTR;
    } 
  }
  
  public void removeR2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R2$96, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTRunTrackChangeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */