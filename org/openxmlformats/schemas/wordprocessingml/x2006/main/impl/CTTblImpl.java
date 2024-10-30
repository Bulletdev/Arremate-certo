package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

public class CTTblImpl extends XmlComplexContentImpl implements CTTbl {
  private static final b BOOKMARKSTART$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
  
  private static final b BOOKMARKEND$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
  
  private static final b MOVEFROMRANGESTART$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
  
  private static final b MOVEFROMRANGEEND$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
  
  private static final b MOVETORANGESTART$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
  
  private static final b MOVETORANGEEND$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
  
  private static final b COMMENTRANGESTART$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
  
  private static final b COMMENTRANGEEND$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
  
  private static final b CUSTOMXMLINSRANGESTART$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
  
  private static final b CUSTOMXMLINSRANGEEND$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
  
  private static final b CUSTOMXMLDELRANGESTART$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
  
  private static final b CUSTOMXMLDELRANGEEND$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
  
  private static final b CUSTOMXMLMOVEFROMRANGESTART$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
  
  private static final b CUSTOMXMLMOVEFROMRANGEEND$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
  
  private static final b CUSTOMXMLMOVETORANGESTART$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
  
  private static final b CUSTOMXMLMOVETORANGEEND$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
  
  private static final b TBLPR$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPr");
  
  private static final b TBLGRID$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblGrid");
  
  private static final b TR$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tr");
  
  private static final b CUSTOMXML$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
  
  private static final b SDT$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
  
  private static final b PROOFERR$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
  
  private static final b PERMSTART$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
  
  private static final b PERMEND$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
  
  private static final b INS$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
  
  private static final b DEL$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
  
  private static final b MOVEFROM$52 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
  
  private static final b MOVETO$54 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
  
  private static final b OMATHPARA$56 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
  
  private static final b OMATH$58 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");
  
  public CTTblImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
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
      get_store().find_all_element_users(BOOKMARKSTART$0, arrayList);
      CTBookmark[] arrayOfCTBookmark = new CTBookmark[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBookmark);
      return arrayOfCTBookmark;
    } 
  }
  
  public CTBookmark getBookmarkStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookmark cTBookmark = null;
      cTBookmark = (CTBookmark)get_store().find_element_user(BOOKMARKSTART$0, paramInt);
      if (cTBookmark == null)
        throw new IndexOutOfBoundsException(); 
      return cTBookmark;
    } 
  }
  
  public int sizeOfBookmarkStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BOOKMARKSTART$0);
    } 
  }
  
  public void setBookmarkStartArray(CTBookmark[] paramArrayOfCTBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBookmark, BOOKMARKSTART$0);
    } 
  }
  
  public void setBookmarkStartArray(int paramInt, CTBookmark paramCTBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookmark cTBookmark = null;
      cTBookmark = (CTBookmark)get_store().find_element_user(BOOKMARKSTART$0, paramInt);
      if (cTBookmark == null)
        throw new IndexOutOfBoundsException(); 
      cTBookmark.set((XmlObject)paramCTBookmark);
    } 
  }
  
  public CTBookmark insertNewBookmarkStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookmark cTBookmark = null;
      cTBookmark = (CTBookmark)get_store().insert_element_user(BOOKMARKSTART$0, paramInt);
      return cTBookmark;
    } 
  }
  
  public CTBookmark addNewBookmarkStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTBookmark cTBookmark = null;
      cTBookmark = (CTBookmark)get_store().add_element_user(BOOKMARKSTART$0);
      return cTBookmark;
    } 
  }
  
  public void removeBookmarkStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOKMARKSTART$0, paramInt);
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
      get_store().find_all_element_users(BOOKMARKEND$2, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getBookmarkEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(BOOKMARKEND$2, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfBookmarkEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BOOKMARKEND$2);
    } 
  }
  
  public void setBookmarkEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, BOOKMARKEND$2);
    } 
  }
  
  public void setBookmarkEndArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(BOOKMARKEND$2, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewBookmarkEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(BOOKMARKEND$2, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewBookmarkEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(BOOKMARKEND$2);
      return cTMarkupRange;
    } 
  }
  
  public void removeBookmarkEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOKMARKEND$2, paramInt);
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
      get_store().find_all_element_users(MOVEFROMRANGESTART$4, arrayList);
      CTMoveBookmark[] arrayOfCTMoveBookmark = new CTMoveBookmark[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMoveBookmark);
      return arrayOfCTMoveBookmark;
    } 
  }
  
  public CTMoveBookmark getMoveFromRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().find_element_user(MOVEFROMRANGESTART$4, paramInt);
      if (cTMoveBookmark == null)
        throw new IndexOutOfBoundsException(); 
      return cTMoveBookmark;
    } 
  }
  
  public int sizeOfMoveFromRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVEFROMRANGESTART$4);
    } 
  }
  
  public void setMoveFromRangeStartArray(CTMoveBookmark[] paramArrayOfCTMoveBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMoveBookmark, MOVEFROMRANGESTART$4);
    } 
  }
  
  public void setMoveFromRangeStartArray(int paramInt, CTMoveBookmark paramCTMoveBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().find_element_user(MOVEFROMRANGESTART$4, paramInt);
      if (cTMoveBookmark == null)
        throw new IndexOutOfBoundsException(); 
      cTMoveBookmark.set((XmlObject)paramCTMoveBookmark);
    } 
  }
  
  public CTMoveBookmark insertNewMoveFromRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().insert_element_user(MOVEFROMRANGESTART$4, paramInt);
      return cTMoveBookmark;
    } 
  }
  
  public CTMoveBookmark addNewMoveFromRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().add_element_user(MOVEFROMRANGESTART$4);
      return cTMoveBookmark;
    } 
  }
  
  public void removeMoveFromRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVEFROMRANGESTART$4, paramInt);
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
      get_store().find_all_element_users(MOVEFROMRANGEEND$6, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getMoveFromRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(MOVEFROMRANGEEND$6, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfMoveFromRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVEFROMRANGEEND$6);
    } 
  }
  
  public void setMoveFromRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, MOVEFROMRANGEEND$6);
    } 
  }
  
  public void setMoveFromRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(MOVEFROMRANGEEND$6, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewMoveFromRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(MOVEFROMRANGEEND$6, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewMoveFromRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(MOVEFROMRANGEEND$6);
      return cTMarkupRange;
    } 
  }
  
  public void removeMoveFromRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVEFROMRANGEEND$6, paramInt);
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
      get_store().find_all_element_users(MOVETORANGESTART$8, arrayList);
      CTMoveBookmark[] arrayOfCTMoveBookmark = new CTMoveBookmark[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMoveBookmark);
      return arrayOfCTMoveBookmark;
    } 
  }
  
  public CTMoveBookmark getMoveToRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().find_element_user(MOVETORANGESTART$8, paramInt);
      if (cTMoveBookmark == null)
        throw new IndexOutOfBoundsException(); 
      return cTMoveBookmark;
    } 
  }
  
  public int sizeOfMoveToRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVETORANGESTART$8);
    } 
  }
  
  public void setMoveToRangeStartArray(CTMoveBookmark[] paramArrayOfCTMoveBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMoveBookmark, MOVETORANGESTART$8);
    } 
  }
  
  public void setMoveToRangeStartArray(int paramInt, CTMoveBookmark paramCTMoveBookmark) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().find_element_user(MOVETORANGESTART$8, paramInt);
      if (cTMoveBookmark == null)
        throw new IndexOutOfBoundsException(); 
      cTMoveBookmark.set((XmlObject)paramCTMoveBookmark);
    } 
  }
  
  public CTMoveBookmark insertNewMoveToRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().insert_element_user(MOVETORANGESTART$8, paramInt);
      return cTMoveBookmark;
    } 
  }
  
  public CTMoveBookmark addNewMoveToRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTMoveBookmark cTMoveBookmark = null;
      cTMoveBookmark = (CTMoveBookmark)get_store().add_element_user(MOVETORANGESTART$8);
      return cTMoveBookmark;
    } 
  }
  
  public void removeMoveToRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVETORANGESTART$8, paramInt);
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
      get_store().find_all_element_users(MOVETORANGEEND$10, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getMoveToRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(MOVETORANGEEND$10, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfMoveToRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVETORANGEEND$10);
    } 
  }
  
  public void setMoveToRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, MOVETORANGEEND$10);
    } 
  }
  
  public void setMoveToRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(MOVETORANGEEND$10, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewMoveToRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(MOVETORANGEEND$10, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewMoveToRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(MOVETORANGEEND$10);
      return cTMarkupRange;
    } 
  }
  
  public void removeMoveToRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVETORANGEEND$10, paramInt);
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
      get_store().find_all_element_users(COMMENTRANGESTART$12, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getCommentRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(COMMENTRANGESTART$12, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfCommentRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COMMENTRANGESTART$12);
    } 
  }
  
  public void setCommentRangeStartArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, COMMENTRANGESTART$12);
    } 
  }
  
  public void setCommentRangeStartArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(COMMENTRANGESTART$12, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewCommentRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(COMMENTRANGESTART$12, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewCommentRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(COMMENTRANGESTART$12);
      return cTMarkupRange;
    } 
  }
  
  public void removeCommentRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMMENTRANGESTART$12, paramInt);
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
      get_store().find_all_element_users(COMMENTRANGEEND$14, arrayList);
      CTMarkupRange[] arrayOfCTMarkupRange = new CTMarkupRange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkupRange);
      return arrayOfCTMarkupRange;
    } 
  }
  
  public CTMarkupRange getCommentRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(COMMENTRANGEEND$14, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkupRange;
    } 
  }
  
  public int sizeOfCommentRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COMMENTRANGEEND$14);
    } 
  }
  
  public void setCommentRangeEndArray(CTMarkupRange[] paramArrayOfCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkupRange, COMMENTRANGEEND$14);
    } 
  }
  
  public void setCommentRangeEndArray(int paramInt, CTMarkupRange paramCTMarkupRange) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().find_element_user(COMMENTRANGEEND$14, paramInt);
      if (cTMarkupRange == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkupRange.set((XmlObject)paramCTMarkupRange);
    } 
  }
  
  public CTMarkupRange insertNewCommentRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().insert_element_user(COMMENTRANGEEND$14, paramInt);
      return cTMarkupRange;
    } 
  }
  
  public CTMarkupRange addNewCommentRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkupRange cTMarkupRange = null;
      cTMarkupRange = (CTMarkupRange)get_store().add_element_user(COMMENTRANGEEND$14);
      return cTMarkupRange;
    } 
  }
  
  public void removeCommentRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMMENTRANGEEND$14, paramInt);
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
      get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$16, arrayList);
      CTTrackChange[] arrayOfCTTrackChange = new CTTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrackChange);
      return arrayOfCTTrackChange;
    } 
  }
  
  public CTTrackChange getCustomXmlInsRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLINSRANGESTART$16, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrackChange;
    } 
  }
  
  public int sizeOfCustomXmlInsRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLINSRANGESTART$16);
    } 
  }
  
  public void setCustomXmlInsRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrackChange, CUSTOMXMLINSRANGESTART$16);
    } 
  }
  
  public void setCustomXmlInsRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLINSRANGESTART$16, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange insertNewCustomXmlInsRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().insert_element_user(CUSTOMXMLINSRANGESTART$16, paramInt);
      return cTTrackChange;
    } 
  }
  
  public CTTrackChange addNewCustomXmlInsRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CUSTOMXMLINSRANGESTART$16);
      return cTTrackChange;
    } 
  }
  
  public void removeCustomXmlInsRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLINSRANGESTART$16, paramInt);
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
      get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$18, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCustomXmlInsRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLINSRANGEEND$18, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCustomXmlInsRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLINSRANGEEND$18);
    } 
  }
  
  public void setCustomXmlInsRangeEndArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, CUSTOMXMLINSRANGEEND$18);
    } 
  }
  
  public void setCustomXmlInsRangeEndArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLINSRANGEEND$18, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCustomXmlInsRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(CUSTOMXMLINSRANGEEND$18, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCustomXmlInsRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(CUSTOMXMLINSRANGEEND$18);
      return cTMarkup;
    } 
  }
  
  public void removeCustomXmlInsRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLINSRANGEEND$18, paramInt);
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
      get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$20, arrayList);
      CTTrackChange[] arrayOfCTTrackChange = new CTTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrackChange);
      return arrayOfCTTrackChange;
    } 
  }
  
  public CTTrackChange getCustomXmlDelRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLDELRANGESTART$20, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrackChange;
    } 
  }
  
  public int sizeOfCustomXmlDelRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLDELRANGESTART$20);
    } 
  }
  
  public void setCustomXmlDelRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrackChange, CUSTOMXMLDELRANGESTART$20);
    } 
  }
  
  public void setCustomXmlDelRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLDELRANGESTART$20, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange insertNewCustomXmlDelRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().insert_element_user(CUSTOMXMLDELRANGESTART$20, paramInt);
      return cTTrackChange;
    } 
  }
  
  public CTTrackChange addNewCustomXmlDelRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CUSTOMXMLDELRANGESTART$20);
      return cTTrackChange;
    } 
  }
  
  public void removeCustomXmlDelRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLDELRANGESTART$20, paramInt);
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
      get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$22, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCustomXmlDelRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLDELRANGEEND$22, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCustomXmlDelRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLDELRANGEEND$22);
    } 
  }
  
  public void setCustomXmlDelRangeEndArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, CUSTOMXMLDELRANGEEND$22);
    } 
  }
  
  public void setCustomXmlDelRangeEndArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLDELRANGEEND$22, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCustomXmlDelRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(CUSTOMXMLDELRANGEEND$22, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCustomXmlDelRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(CUSTOMXMLDELRANGEEND$22);
      return cTMarkup;
    } 
  }
  
  public void removeCustomXmlDelRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLDELRANGEEND$22, paramInt);
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
      get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$24, arrayList);
      CTTrackChange[] arrayOfCTTrackChange = new CTTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrackChange);
      return arrayOfCTTrackChange;
    } 
  }
  
  public CTTrackChange getCustomXmlMoveFromRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$24, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrackChange;
    } 
  }
  
  public int sizeOfCustomXmlMoveFromRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$24);
    } 
  }
  
  public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrackChange, CUSTOMXMLMOVEFROMRANGESTART$24);
    } 
  }
  
  public void setCustomXmlMoveFromRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$24, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$24, paramInt);
      return cTTrackChange;
    } 
  }
  
  public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$24);
      return cTTrackChange;
    } 
  }
  
  public void removeCustomXmlMoveFromRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$24, paramInt);
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
      get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$26, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCustomXmlMoveFromRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$26, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCustomXmlMoveFromRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$26);
    } 
  }
  
  public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, CUSTOMXMLMOVEFROMRANGEEND$26);
    } 
  }
  
  public void setCustomXmlMoveFromRangeEndArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$26, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$26, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$26);
      return cTMarkup;
    } 
  }
  
  public void removeCustomXmlMoveFromRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$26, paramInt);
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
      get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$28, arrayList);
      CTTrackChange[] arrayOfCTTrackChange = new CTTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrackChange);
      return arrayOfCTTrackChange;
    } 
  }
  
  public CTTrackChange getCustomXmlMoveToRangeStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$28, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrackChange;
    } 
  }
  
  public int sizeOfCustomXmlMoveToRangeStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLMOVETORANGESTART$28);
    } 
  }
  
  public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] paramArrayOfCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrackChange, CUSTOMXMLMOVETORANGESTART$28);
    } 
  }
  
  public void setCustomXmlMoveToRangeStartArray(int paramInt, CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$28, paramInt);
      if (cTTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange insertNewCustomXmlMoveToRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$28, paramInt);
      return cTTrackChange;
    } 
  }
  
  public CTTrackChange addNewCustomXmlMoveToRangeStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$28);
      return cTTrackChange;
    } 
  }
  
  public void removeCustomXmlMoveToRangeStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLMOVETORANGESTART$28, paramInt);
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
      get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$30, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCustomXmlMoveToRangeEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$30, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCustomXmlMoveToRangeEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXMLMOVETORANGEEND$30);
    } 
  }
  
  public void setCustomXmlMoveToRangeEndArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, CUSTOMXMLMOVETORANGEEND$30);
    } 
  }
  
  public void setCustomXmlMoveToRangeEndArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$30, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCustomXmlMoveToRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$30, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCustomXmlMoveToRangeEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$30);
      return cTMarkup;
    } 
  }
  
  public void removeCustomXmlMoveToRangeEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXMLMOVETORANGEEND$30, paramInt);
    } 
  }
  
  public CTTblPr getTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPr cTTblPr = null;
      cTTblPr = (CTTblPr)get_store().find_element_user(TBLPR$32, 0);
      if (cTTblPr == null)
        return null; 
      return cTTblPr;
    } 
  }
  
  public void setTblPr(CTTblPr paramCTTblPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPr cTTblPr = null;
      cTTblPr = (CTTblPr)get_store().find_element_user(TBLPR$32, 0);
      if (cTTblPr == null)
        cTTblPr = (CTTblPr)get_store().add_element_user(TBLPR$32); 
      cTTblPr.set((XmlObject)paramCTTblPr);
    } 
  }
  
  public CTTblPr addNewTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPr cTTblPr = null;
      cTTblPr = (CTTblPr)get_store().add_element_user(TBLPR$32);
      return cTTblPr;
    } 
  }
  
  public CTTblGrid getTblGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGrid cTTblGrid = null;
      cTTblGrid = (CTTblGrid)get_store().find_element_user(TBLGRID$34, 0);
      if (cTTblGrid == null)
        return null; 
      return cTTblGrid;
    } 
  }
  
  public void setTblGrid(CTTblGrid paramCTTblGrid) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGrid cTTblGrid = null;
      cTTblGrid = (CTTblGrid)get_store().find_element_user(TBLGRID$34, 0);
      if (cTTblGrid == null)
        cTTblGrid = (CTTblGrid)get_store().add_element_user(TBLGRID$34); 
      cTTblGrid.set((XmlObject)paramCTTblGrid);
    } 
  }
  
  public CTTblGrid addNewTblGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGrid cTTblGrid = null;
      cTTblGrid = (CTTblGrid)get_store().add_element_user(TBLGRID$34);
      return cTTblGrid;
    } 
  }
  
  public List<CTRow> getTrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRow>)new TrList(this);
    } 
  }
  
  public CTRow[] getTrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TR$36, arrayList);
      CTRow[] arrayOfCTRow = new CTRow[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRow);
      return arrayOfCTRow;
    } 
  }
  
  public CTRow getTrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRow cTRow = null;
      cTRow = (CTRow)get_store().find_element_user(TR$36, paramInt);
      if (cTRow == null)
        throw new IndexOutOfBoundsException(); 
      return cTRow;
    } 
  }
  
  public int sizeOfTrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TR$36);
    } 
  }
  
  public void setTrArray(CTRow[] paramArrayOfCTRow) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRow, TR$36);
    } 
  }
  
  public void setTrArray(int paramInt, CTRow paramCTRow) {
    synchronized (monitor()) {
      check_orphaned();
      CTRow cTRow = null;
      cTRow = (CTRow)get_store().find_element_user(TR$36, paramInt);
      if (cTRow == null)
        throw new IndexOutOfBoundsException(); 
      cTRow.set((XmlObject)paramCTRow);
    } 
  }
  
  public CTRow insertNewTr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRow cTRow = null;
      cTRow = (CTRow)get_store().insert_element_user(TR$36, paramInt);
      return cTRow;
    } 
  }
  
  public CTRow addNewTr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRow cTRow = null;
      cTRow = (CTRow)get_store().add_element_user(TR$36);
      return cTRow;
    } 
  }
  
  public void removeTr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TR$36, paramInt);
    } 
  }
  
  public List<CTCustomXmlRow> getCustomXmlList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCustomXmlRow>)new CustomXmlList(this);
    } 
  }
  
  public CTCustomXmlRow[] getCustomXmlArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTOMXML$38, arrayList);
      CTCustomXmlRow[] arrayOfCTCustomXmlRow = new CTCustomXmlRow[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCustomXmlRow);
      return arrayOfCTCustomXmlRow;
    } 
  }
  
  public CTCustomXmlRow getCustomXmlArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlRow cTCustomXmlRow = null;
      cTCustomXmlRow = (CTCustomXmlRow)get_store().find_element_user(CUSTOMXML$38, paramInt);
      if (cTCustomXmlRow == null)
        throw new IndexOutOfBoundsException(); 
      return cTCustomXmlRow;
    } 
  }
  
  public int sizeOfCustomXmlArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTOMXML$38);
    } 
  }
  
  public void setCustomXmlArray(CTCustomXmlRow[] paramArrayOfCTCustomXmlRow) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCustomXmlRow, CUSTOMXML$38);
    } 
  }
  
  public void setCustomXmlArray(int paramInt, CTCustomXmlRow paramCTCustomXmlRow) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlRow cTCustomXmlRow = null;
      cTCustomXmlRow = (CTCustomXmlRow)get_store().find_element_user(CUSTOMXML$38, paramInt);
      if (cTCustomXmlRow == null)
        throw new IndexOutOfBoundsException(); 
      cTCustomXmlRow.set((XmlObject)paramCTCustomXmlRow);
    } 
  }
  
  public CTCustomXmlRow insertNewCustomXml(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlRow cTCustomXmlRow = null;
      cTCustomXmlRow = (CTCustomXmlRow)get_store().insert_element_user(CUSTOMXML$38, paramInt);
      return cTCustomXmlRow;
    } 
  }
  
  public CTCustomXmlRow addNewCustomXml() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomXmlRow cTCustomXmlRow = null;
      cTCustomXmlRow = (CTCustomXmlRow)get_store().add_element_user(CUSTOMXML$38);
      return cTCustomXmlRow;
    } 
  }
  
  public void removeCustomXml(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMXML$38, paramInt);
    } 
  }
  
  public List<CTSdtRow> getSdtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtRow>)new SdtList(this);
    } 
  }
  
  public CTSdtRow[] getSdtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SDT$40, arrayList);
      CTSdtRow[] arrayOfCTSdtRow = new CTSdtRow[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtRow);
      return arrayOfCTSdtRow;
    } 
  }
  
  public CTSdtRow getSdtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtRow cTSdtRow = null;
      cTSdtRow = (CTSdtRow)get_store().find_element_user(SDT$40, paramInt);
      if (cTSdtRow == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtRow;
    } 
  }
  
  public int sizeOfSdtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SDT$40);
    } 
  }
  
  public void setSdtArray(CTSdtRow[] paramArrayOfCTSdtRow) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtRow, SDT$40);
    } 
  }
  
  public void setSdtArray(int paramInt, CTSdtRow paramCTSdtRow) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtRow cTSdtRow = null;
      cTSdtRow = (CTSdtRow)get_store().find_element_user(SDT$40, paramInt);
      if (cTSdtRow == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtRow.set((XmlObject)paramCTSdtRow);
    } 
  }
  
  public CTSdtRow insertNewSdt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtRow cTSdtRow = null;
      cTSdtRow = (CTSdtRow)get_store().insert_element_user(SDT$40, paramInt);
      return cTSdtRow;
    } 
  }
  
  public CTSdtRow addNewSdt() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtRow cTSdtRow = null;
      cTSdtRow = (CTSdtRow)get_store().add_element_user(SDT$40);
      return cTSdtRow;
    } 
  }
  
  public void removeSdt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SDT$40, paramInt);
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
      get_store().find_all_element_users(PROOFERR$42, arrayList);
      CTProofErr[] arrayOfCTProofErr = new CTProofErr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTProofErr);
      return arrayOfCTProofErr;
    } 
  }
  
  public CTProofErr getProofErrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTProofErr cTProofErr = null;
      cTProofErr = (CTProofErr)get_store().find_element_user(PROOFERR$42, paramInt);
      if (cTProofErr == null)
        throw new IndexOutOfBoundsException(); 
      return cTProofErr;
    } 
  }
  
  public int sizeOfProofErrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PROOFERR$42);
    } 
  }
  
  public void setProofErrArray(CTProofErr[] paramArrayOfCTProofErr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTProofErr, PROOFERR$42);
    } 
  }
  
  public void setProofErrArray(int paramInt, CTProofErr paramCTProofErr) {
    synchronized (monitor()) {
      check_orphaned();
      CTProofErr cTProofErr = null;
      cTProofErr = (CTProofErr)get_store().find_element_user(PROOFERR$42, paramInt);
      if (cTProofErr == null)
        throw new IndexOutOfBoundsException(); 
      cTProofErr.set((XmlObject)paramCTProofErr);
    } 
  }
  
  public CTProofErr insertNewProofErr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTProofErr cTProofErr = null;
      cTProofErr = (CTProofErr)get_store().insert_element_user(PROOFERR$42, paramInt);
      return cTProofErr;
    } 
  }
  
  public CTProofErr addNewProofErr() {
    synchronized (monitor()) {
      check_orphaned();
      CTProofErr cTProofErr = null;
      cTProofErr = (CTProofErr)get_store().add_element_user(PROOFERR$42);
      return cTProofErr;
    } 
  }
  
  public void removeProofErr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROOFERR$42, paramInt);
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
      get_store().find_all_element_users(PERMSTART$44, arrayList);
      CTPermStart[] arrayOfCTPermStart = new CTPermStart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPermStart);
      return arrayOfCTPermStart;
    } 
  }
  
  public CTPermStart getPermStartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPermStart cTPermStart = null;
      cTPermStart = (CTPermStart)get_store().find_element_user(PERMSTART$44, paramInt);
      if (cTPermStart == null)
        throw new IndexOutOfBoundsException(); 
      return cTPermStart;
    } 
  }
  
  public int sizeOfPermStartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PERMSTART$44);
    } 
  }
  
  public void setPermStartArray(CTPermStart[] paramArrayOfCTPermStart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPermStart, PERMSTART$44);
    } 
  }
  
  public void setPermStartArray(int paramInt, CTPermStart paramCTPermStart) {
    synchronized (monitor()) {
      check_orphaned();
      CTPermStart cTPermStart = null;
      cTPermStart = (CTPermStart)get_store().find_element_user(PERMSTART$44, paramInt);
      if (cTPermStart == null)
        throw new IndexOutOfBoundsException(); 
      cTPermStart.set((XmlObject)paramCTPermStart);
    } 
  }
  
  public CTPermStart insertNewPermStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPermStart cTPermStart = null;
      cTPermStart = (CTPermStart)get_store().insert_element_user(PERMSTART$44, paramInt);
      return cTPermStart;
    } 
  }
  
  public CTPermStart addNewPermStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTPermStart cTPermStart = null;
      cTPermStart = (CTPermStart)get_store().add_element_user(PERMSTART$44);
      return cTPermStart;
    } 
  }
  
  public void removePermStart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PERMSTART$44, paramInt);
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
      get_store().find_all_element_users(PERMEND$46, arrayList);
      CTPerm[] arrayOfCTPerm = new CTPerm[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPerm);
      return arrayOfCTPerm;
    } 
  }
  
  public CTPerm getPermEndArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPerm cTPerm = null;
      cTPerm = (CTPerm)get_store().find_element_user(PERMEND$46, paramInt);
      if (cTPerm == null)
        throw new IndexOutOfBoundsException(); 
      return cTPerm;
    } 
  }
  
  public int sizeOfPermEndArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PERMEND$46);
    } 
  }
  
  public void setPermEndArray(CTPerm[] paramArrayOfCTPerm) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPerm, PERMEND$46);
    } 
  }
  
  public void setPermEndArray(int paramInt, CTPerm paramCTPerm) {
    synchronized (monitor()) {
      check_orphaned();
      CTPerm cTPerm = null;
      cTPerm = (CTPerm)get_store().find_element_user(PERMEND$46, paramInt);
      if (cTPerm == null)
        throw new IndexOutOfBoundsException(); 
      cTPerm.set((XmlObject)paramCTPerm);
    } 
  }
  
  public CTPerm insertNewPermEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPerm cTPerm = null;
      cTPerm = (CTPerm)get_store().insert_element_user(PERMEND$46, paramInt);
      return cTPerm;
    } 
  }
  
  public CTPerm addNewPermEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTPerm cTPerm = null;
      cTPerm = (CTPerm)get_store().add_element_user(PERMEND$46);
      return cTPerm;
    } 
  }
  
  public void removePermEnd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PERMEND$46, paramInt);
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
      get_store().find_all_element_users(INS$48, arrayList);
      CTRunTrackChange[] arrayOfCTRunTrackChange = new CTRunTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRunTrackChange);
      return arrayOfCTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange getInsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(INS$48, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTRunTrackChange;
    } 
  }
  
  public int sizeOfInsArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INS$48);
    } 
  }
  
  public void setInsArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRunTrackChange, INS$48);
    } 
  }
  
  public void setInsArray(int paramInt, CTRunTrackChange paramCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(INS$48, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTRunTrackChange.set((XmlObject)paramCTRunTrackChange);
    } 
  }
  
  public CTRunTrackChange insertNewIns(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().insert_element_user(INS$48, paramInt);
      return cTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange addNewIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().add_element_user(INS$48);
      return cTRunTrackChange;
    } 
  }
  
  public void removeIns(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INS$48, paramInt);
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
      get_store().find_all_element_users(DEL$50, arrayList);
      CTRunTrackChange[] arrayOfCTRunTrackChange = new CTRunTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRunTrackChange);
      return arrayOfCTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange getDelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(DEL$50, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTRunTrackChange;
    } 
  }
  
  public int sizeOfDelArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DEL$50);
    } 
  }
  
  public void setDelArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRunTrackChange, DEL$50);
    } 
  }
  
  public void setDelArray(int paramInt, CTRunTrackChange paramCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(DEL$50, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTRunTrackChange.set((XmlObject)paramCTRunTrackChange);
    } 
  }
  
  public CTRunTrackChange insertNewDel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().insert_element_user(DEL$50, paramInt);
      return cTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange addNewDel() {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().add_element_user(DEL$50);
      return cTRunTrackChange;
    } 
  }
  
  public void removeDel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEL$50, paramInt);
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
      get_store().find_all_element_users(MOVEFROM$52, arrayList);
      CTRunTrackChange[] arrayOfCTRunTrackChange = new CTRunTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRunTrackChange);
      return arrayOfCTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange getMoveFromArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(MOVEFROM$52, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTRunTrackChange;
    } 
  }
  
  public int sizeOfMoveFromArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVEFROM$52);
    } 
  }
  
  public void setMoveFromArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRunTrackChange, MOVEFROM$52);
    } 
  }
  
  public void setMoveFromArray(int paramInt, CTRunTrackChange paramCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(MOVEFROM$52, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTRunTrackChange.set((XmlObject)paramCTRunTrackChange);
    } 
  }
  
  public CTRunTrackChange insertNewMoveFrom(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().insert_element_user(MOVEFROM$52, paramInt);
      return cTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange addNewMoveFrom() {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().add_element_user(MOVEFROM$52);
      return cTRunTrackChange;
    } 
  }
  
  public void removeMoveFrom(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVEFROM$52, paramInt);
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
      get_store().find_all_element_users(MOVETO$54, arrayList);
      CTRunTrackChange[] arrayOfCTRunTrackChange = new CTRunTrackChange[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRunTrackChange);
      return arrayOfCTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange getMoveToArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(MOVETO$54, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      return cTRunTrackChange;
    } 
  }
  
  public int sizeOfMoveToArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVETO$54);
    } 
  }
  
  public void setMoveToArray(CTRunTrackChange[] paramArrayOfCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRunTrackChange, MOVETO$54);
    } 
  }
  
  public void setMoveToArray(int paramInt, CTRunTrackChange paramCTRunTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().find_element_user(MOVETO$54, paramInt);
      if (cTRunTrackChange == null)
        throw new IndexOutOfBoundsException(); 
      cTRunTrackChange.set((XmlObject)paramCTRunTrackChange);
    } 
  }
  
  public CTRunTrackChange insertNewMoveTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().insert_element_user(MOVETO$54, paramInt);
      return cTRunTrackChange;
    } 
  }
  
  public CTRunTrackChange addNewMoveTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTRunTrackChange cTRunTrackChange = null;
      cTRunTrackChange = (CTRunTrackChange)get_store().add_element_user(MOVETO$54);
      return cTRunTrackChange;
    } 
  }
  
  public void removeMoveTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVETO$54, paramInt);
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
      get_store().find_all_element_users(OMATHPARA$56, arrayList);
      CTOMathPara[] arrayOfCTOMathPara = new CTOMathPara[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOMathPara);
      return arrayOfCTOMathPara;
    } 
  }
  
  public CTOMathPara getOMathParaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMathPara cTOMathPara = null;
      cTOMathPara = (CTOMathPara)get_store().find_element_user(OMATHPARA$56, paramInt);
      if (cTOMathPara == null)
        throw new IndexOutOfBoundsException(); 
      return cTOMathPara;
    } 
  }
  
  public int sizeOfOMathParaArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(OMATHPARA$56);
    } 
  }
  
  public void setOMathParaArray(CTOMathPara[] paramArrayOfCTOMathPara) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOMathPara, OMATHPARA$56);
    } 
  }
  
  public void setOMathParaArray(int paramInt, CTOMathPara paramCTOMathPara) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMathPara cTOMathPara = null;
      cTOMathPara = (CTOMathPara)get_store().find_element_user(OMATHPARA$56, paramInt);
      if (cTOMathPara == null)
        throw new IndexOutOfBoundsException(); 
      cTOMathPara.set((XmlObject)paramCTOMathPara);
    } 
  }
  
  public CTOMathPara insertNewOMathPara(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMathPara cTOMathPara = null;
      cTOMathPara = (CTOMathPara)get_store().insert_element_user(OMATHPARA$56, paramInt);
      return cTOMathPara;
    } 
  }
  
  public CTOMathPara addNewOMathPara() {
    synchronized (monitor()) {
      check_orphaned();
      CTOMathPara cTOMathPara = null;
      cTOMathPara = (CTOMathPara)get_store().add_element_user(OMATHPARA$56);
      return cTOMathPara;
    } 
  }
  
  public void removeOMathPara(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OMATHPARA$56, paramInt);
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
      get_store().find_all_element_users(OMATH$58, arrayList);
      CTOMath[] arrayOfCTOMath = new CTOMath[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOMath);
      return arrayOfCTOMath;
    } 
  }
  
  public CTOMath getOMathArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMath cTOMath = null;
      cTOMath = (CTOMath)get_store().find_element_user(OMATH$58, paramInt);
      if (cTOMath == null)
        throw new IndexOutOfBoundsException(); 
      return cTOMath;
    } 
  }
  
  public int sizeOfOMathArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(OMATH$58);
    } 
  }
  
  public void setOMathArray(CTOMath[] paramArrayOfCTOMath) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOMath, OMATH$58);
    } 
  }
  
  public void setOMathArray(int paramInt, CTOMath paramCTOMath) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMath cTOMath = null;
      cTOMath = (CTOMath)get_store().find_element_user(OMATH$58, paramInt);
      if (cTOMath == null)
        throw new IndexOutOfBoundsException(); 
      cTOMath.set((XmlObject)paramCTOMath);
    } 
  }
  
  public CTOMath insertNewOMath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOMath cTOMath = null;
      cTOMath = (CTOMath)get_store().insert_element_user(OMATH$58, paramInt);
      return cTOMath;
    } 
  }
  
  public CTOMath addNewOMath() {
    synchronized (monitor()) {
      check_orphaned();
      CTOMath cTOMath = null;
      cTOMath = (CTOMath)get_store().add_element_user(OMATH$58);
      return cTOMath;
    } 
  }
  
  public void removeOMath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OMATH$58, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */