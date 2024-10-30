package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

public class CTBodyImpl extends XmlComplexContentImpl implements CTBody {
  private static final b CUSTOMXML$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
  
  private static final b SDT$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
  
  private static final b P$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "p");
  
  private static final b TBL$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tbl");
  
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
  
  private static final b ALTCHUNK$58 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "altChunk");
  
  private static final b SECTPR$60 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sectPr");
  
  public CTBodyImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCustomXmlBlock> getCustomXmlList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCustomXmlBlock>)new CustomXmlList(this);
    } 
  }
  
  public CTCustomXmlBlock[] getCustomXmlArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXML$0, arrayList);
      CTCustomXmlBlock[] arrayOfCTCustomXmlBlock = new CTCustomXmlBlock[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCustomXmlBlock);
      return arrayOfCTCustomXmlBlock;
    } 
  }
  
  public CTCustomXmlBlock getCustomXmlArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlBlock cTCustomXmlBlock = null;
      cTCustomXmlBlock = (CTCustomXmlBlock)get_store().find_element_user(CUSTOMXML$0, paramInt);
      if (cTCustomXmlBlock == null)
        throw new IndexOutOfBoundsException(); 
      return cTCustomXmlBlock;
    } 
  }
  
  public int sizeOfCustomXmlArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXML$0);
    } 
  }
  
  public void setCustomXmlArray(CTCustomXmlBlock[] paramArrayOfCTCustomXmlBlock) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCustomXmlBlock, CUSTOMXML$0);
    } 
  }
  
  public void setCustomXmlArray(int paramInt, CTCustomXmlBlock paramCTCustomXmlBlock) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlBlock cTCustomXmlBlock = null;
      cTCustomXmlBlock = (CTCustomXmlBlock)get_store().find_element_user(CUSTOMXML$0, paramInt);
      if (cTCustomXmlBlock == null)
        throw new IndexOutOfBoundsException(); 
      cTCustomXmlBlock.set((XmlObject)paramCTCustomXmlBlock);
    } 
  }
  
  public CTCustomXmlBlock insertNewCustomXml(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlBlock cTCustomXmlBlock = null;
      cTCustomXmlBlock = (CTCustomXmlBlock)get_store().insert_element_user(CUSTOMXML$0, paramInt);
      return cTCustomXmlBlock;
    } 
  }
  
  public CTCustomXmlBlock addNewCustomXml() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlBlock cTCustomXmlBlock = null;
      cTCustomXmlBlock = (CTCustomXmlBlock)get_store().add_element_user(CUSTOMXML$0);
      return cTCustomXmlBlock;
    } 
  }
  
  public void removeCustomXml(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXML$0, paramInt);
    } 
  }
  
  public List<CTSdtBlock> getSdtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtBlock>)new SdtList(this);
    } 
  }
  
  public CTSdtBlock[] getSdtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SDT$2, arrayList);
      CTSdtBlock[] arrayOfCTSdtBlock = new CTSdtBlock[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtBlock);
      return arrayOfCTSdtBlock;
    } 
  }
  
  public CTSdtBlock getSdtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtBlock cTSdtBlock = null;
      cTSdtBlock = (CTSdtBlock)get_store().find_element_user(SDT$2, paramInt);
      if (cTSdtBlock == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtBlock;
    } 
  }
  
  public int sizeOfSdtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SDT$2);
    } 
  }
  
  public void setSdtArray(CTSdtBlock[] paramArrayOfCTSdtBlock) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtBlock, SDT$2);
    } 
  }
  
  public void setSdtArray(int paramInt, CTSdtBlock paramCTSdtBlock) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtBlock cTSdtBlock = null;
      cTSdtBlock = (CTSdtBlock)get_store().find_element_user(SDT$2, paramInt);
      if (cTSdtBlock == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtBlock.set((XmlObject)paramCTSdtBlock);
    } 
  }
  
  public CTSdtBlock insertNewSdt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtBlock cTSdtBlock = null;
      cTSdtBlock = (CTSdtBlock)get_store().insert_element_user(SDT$2, paramInt);
      return cTSdtBlock;
    } 
  }
  
  public CTSdtBlock addNewSdt() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtBlock cTSdtBlock = null;
      cTSdtBlock = (CTSdtBlock)get_store().add_element_user(SDT$2);
      return cTSdtBlock;
    } 
  }
  
  public void removeSdt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SDT$2, paramInt);
    } 
  }
  
  public List<CTP> getPList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTP>)new PList(this);
    } 
  }
  
  public CTP[] getPArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(P$4, arrayList);
      CTP[] arrayOfCTP = new CTP[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTP);
      return arrayOfCTP;
    } 
  }
  
  public CTP getPArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTP cTP = null;
      cTP = (CTP)get_store().find_element_user(P$4, paramInt);
      if (cTP == null)
        throw new IndexOutOfBoundsException(); 
      return cTP;
    } 
  }
  
  public int sizeOfPArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(P$4);
    } 
  }
  
  public void setPArray(CTP[] paramArrayOfCTP) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTP, P$4);
    } 
  }
  
  public void setPArray(int paramInt, CTP paramCTP) {
    synchronized (monitor()) {
      check_orphaned();
      CTP cTP = null;
      cTP = (CTP)get_store().find_element_user(P$4, paramInt);
      if (cTP == null)
        throw new IndexOutOfBoundsException(); 
      cTP.set((XmlObject)paramCTP);
    } 
  }
  
  public CTP insertNewP(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTP cTP = null;
      cTP = (CTP)get_store().insert_element_user(P$4, paramInt);
      return cTP;
    } 
  }
  
  public CTP addNewP() {
    synchronized (monitor()) {
      check_orphaned();
      CTP cTP = null;
      cTP = (CTP)get_store().add_element_user(P$4);
      return cTP;
    } 
  }
  
  public void removeP(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(P$4, paramInt);
    } 
  }
  
  public List<CTTbl> getTblList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTbl>)new TblList(this);
    } 
  }
  
  public CTTbl[] getTblArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TBL$6, arrayList);
      CTTbl[] arrayOfCTTbl = new CTTbl[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTbl);
      return arrayOfCTTbl;
    } 
  }
  
  public CTTbl getTblArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTbl cTTbl = null;
      cTTbl = (CTTbl)get_store().find_element_user(TBL$6, paramInt);
      if (cTTbl == null)
        throw new IndexOutOfBoundsException(); 
      return cTTbl;
    } 
  }
  
  public int sizeOfTblArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TBL$6);
    } 
  }
  
  public void setTblArray(CTTbl[] paramArrayOfCTTbl) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTbl, TBL$6);
    } 
  }
  
  public void setTblArray(int paramInt, CTTbl paramCTTbl) {
    synchronized (monitor()) {
      check_orphaned();
      CTTbl cTTbl = null;
      cTTbl = (CTTbl)get_store().find_element_user(TBL$6, paramInt);
      if (cTTbl == null)
        throw new IndexOutOfBoundsException(); 
      cTTbl.set((XmlObject)paramCTTbl);
    } 
  }
  
  public CTTbl insertNewTbl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTbl cTTbl = null;
      cTTbl = (CTTbl)get_store().insert_element_user(TBL$6, paramInt);
      return cTTbl;
    } 
  }
  
  public CTTbl addNewTbl() {
    synchronized (monitor()) {
      check_orphaned();
      CTTbl cTTbl = null;
      cTTbl = (CTTbl)get_store().add_element_user(TBL$6);
      return cTTbl;
    } 
  }
  
  public void removeTbl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBL$6, paramInt);
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
  
  public List<CTAltChunk> getAltChunkList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAltChunk>)new AltChunkList(this);
    } 
  }
  
  public CTAltChunk[] getAltChunkArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALTCHUNK$58, arrayList);
      CTAltChunk[] arrayOfCTAltChunk = new CTAltChunk[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAltChunk);
      return arrayOfCTAltChunk;
    } 
  }
  
  public CTAltChunk getAltChunkArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAltChunk cTAltChunk = null;
      cTAltChunk = (CTAltChunk)get_store().find_element_user(ALTCHUNK$58, paramInt);
      if (cTAltChunk == null)
        throw new IndexOutOfBoundsException(); 
      return cTAltChunk;
    } 
  }
  
  public int sizeOfAltChunkArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALTCHUNK$58);
    } 
  }
  
  public void setAltChunkArray(CTAltChunk[] paramArrayOfCTAltChunk) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAltChunk, ALTCHUNK$58);
    } 
  }
  
  public void setAltChunkArray(int paramInt, CTAltChunk paramCTAltChunk) {
    synchronized (monitor()) {
      check_orphaned();
      CTAltChunk cTAltChunk = null;
      cTAltChunk = (CTAltChunk)get_store().find_element_user(ALTCHUNK$58, paramInt);
      if (cTAltChunk == null)
        throw new IndexOutOfBoundsException(); 
      cTAltChunk.set((XmlObject)paramCTAltChunk);
    } 
  }
  
  public CTAltChunk insertNewAltChunk(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAltChunk cTAltChunk = null;
      cTAltChunk = (CTAltChunk)get_store().insert_element_user(ALTCHUNK$58, paramInt);
      return cTAltChunk;
    } 
  }
  
  public CTAltChunk addNewAltChunk() {
    synchronized (monitor()) {
      check_orphaned();
      CTAltChunk cTAltChunk = null;
      cTAltChunk = (CTAltChunk)get_store().add_element_user(ALTCHUNK$58);
      return cTAltChunk;
    } 
  }
  
  public void removeAltChunk(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALTCHUNK$58, paramInt);
    } 
  }
  
  public CTSectPr getSectPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPr cTSectPr = null;
      cTSectPr = (CTSectPr)get_store().find_element_user(SECTPR$60, 0);
      if (cTSectPr == null)
        return null; 
      return cTSectPr;
    } 
  }
  
  public boolean isSetSectPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SECTPR$60) != 0);
    } 
  }
  
  public void setSectPr(CTSectPr paramCTSectPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPr cTSectPr = null;
      cTSectPr = (CTSectPr)get_store().find_element_user(SECTPR$60, 0);
      if (cTSectPr == null)
        cTSectPr = (CTSectPr)get_store().add_element_user(SECTPR$60); 
      cTSectPr.set((XmlObject)paramCTSectPr);
    } 
  }
  
  public CTSectPr addNewSectPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPr cTSectPr = null;
      cTSectPr = (CTSectPr)get_store().add_element_user(SECTPR$60);
      return cTSectPr;
    } 
  }
  
  public void unsetSectPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SECTPR$60, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTBodyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */