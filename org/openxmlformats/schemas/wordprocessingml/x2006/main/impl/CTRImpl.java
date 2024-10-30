package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;

public class CTRImpl extends XmlComplexContentImpl implements CTR {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
  
  private static final b BR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "br");
  
  private static final b T$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "t");
  
  private static final b DELTEXT$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "delText");
  
  private static final b INSTRTEXT$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "instrText");
  
  private static final b DELINSTRTEXT$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "delInstrText");
  
  private static final b NOBREAKHYPHEN$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noBreakHyphen");
  
  private static final b SOFTHYPHEN$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "softHyphen");
  
  private static final b DAYSHORT$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dayShort");
  
  private static final b MONTHSHORT$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "monthShort");
  
  private static final b YEARSHORT$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "yearShort");
  
  private static final b DAYLONG$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dayLong");
  
  private static final b MONTHLONG$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "monthLong");
  
  private static final b YEARLONG$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "yearLong");
  
  private static final b ANNOTATIONREF$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "annotationRef");
  
  private static final b FOOTNOTEREF$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnoteRef");
  
  private static final b ENDNOTEREF$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnoteRef");
  
  private static final b SEPARATOR$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "separator");
  
  private static final b CONTINUATIONSEPARATOR$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "continuationSeparator");
  
  private static final b SYM$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sym");
  
  private static final b PGNUM$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgNum");
  
  private static final b CR$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cr");
  
  private static final b TAB$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tab");
  
  private static final b OBJECT$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "object");
  
  private static final b PICT$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pict");
  
  private static final b FLDCHAR$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldChar");
  
  private static final b RUBY$52 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ruby");
  
  private static final b FOOTNOTEREFERENCE$54 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnoteReference");
  
  private static final b ENDNOTEREFERENCE$56 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnoteReference");
  
  private static final b COMMENTREFERENCE$58 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentReference");
  
  private static final b DRAWING$60 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawing");
  
  private static final b PTAB$62 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ptab");
  
  private static final b LASTRENDEREDPAGEBREAK$64 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lastRenderedPageBreak");
  
  private static final b RSIDRPR$66 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidRPr");
  
  private static final b RSIDDEL$68 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidDel");
  
  private static final b RSIDR$70 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidR");
  
  public CTRImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRPr getRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$0, 0);
      if (cTRPr == null)
        return null; 
      return cTRPr;
    } 
  }
  
  public boolean isSetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPR$0) != 0);
    } 
  }
  
  public void setRPr(CTRPr paramCTRPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$0, 0);
      if (cTRPr == null)
        cTRPr = (CTRPr)get_store().add_element_user(RPR$0); 
      cTRPr.set((XmlObject)paramCTRPr);
    } 
  }
  
  public CTRPr addNewRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().add_element_user(RPR$0);
      return cTRPr;
    } 
  }
  
  public void unsetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$0, 0);
    } 
  }
  
  public List<CTBr> getBrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBr>)new BrList(this);
    } 
  }
  
  public CTBr[] getBrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BR$2, arrayList);
      CTBr[] arrayOfCTBr = new CTBr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBr);
      return arrayOfCTBr;
    } 
  }
  
  public CTBr getBrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBr cTBr = null;
      cTBr = (CTBr)get_store().find_element_user(BR$2, paramInt);
      if (cTBr == null)
        throw new IndexOutOfBoundsException(); 
      return cTBr;
    } 
  }
  
  public int sizeOfBrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BR$2);
    } 
  }
  
  public void setBrArray(CTBr[] paramArrayOfCTBr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBr, BR$2);
    } 
  }
  
  public void setBrArray(int paramInt, CTBr paramCTBr) {
    synchronized (monitor()) {
      check_orphaned();
      CTBr cTBr = null;
      cTBr = (CTBr)get_store().find_element_user(BR$2, paramInt);
      if (cTBr == null)
        throw new IndexOutOfBoundsException(); 
      cTBr.set((XmlObject)paramCTBr);
    } 
  }
  
  public CTBr insertNewBr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBr cTBr = null;
      cTBr = (CTBr)get_store().insert_element_user(BR$2, paramInt);
      return cTBr;
    } 
  }
  
  public CTBr addNewBr() {
    synchronized (monitor()) {
      check_orphaned();
      CTBr cTBr = null;
      cTBr = (CTBr)get_store().add_element_user(BR$2);
      return cTBr;
    } 
  }
  
  public void removeBr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BR$2, paramInt);
    } 
  }
  
  public List<CTText> getTList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTText>)new TList(this);
    } 
  }
  
  public CTText[] getTArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(T$4, arrayList);
      CTText[] arrayOfCTText = new CTText[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTText);
      return arrayOfCTText;
    } 
  }
  
  public CTText getTArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(T$4, paramInt);
      if (cTText == null)
        throw new IndexOutOfBoundsException(); 
      return cTText;
    } 
  }
  
  public int sizeOfTArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(T$4);
    } 
  }
  
  public void setTArray(CTText[] paramArrayOfCTText) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTText, T$4);
    } 
  }
  
  public void setTArray(int paramInt, CTText paramCTText) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(T$4, paramInt);
      if (cTText == null)
        throw new IndexOutOfBoundsException(); 
      cTText.set((XmlObject)paramCTText);
    } 
  }
  
  public CTText insertNewT(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().insert_element_user(T$4, paramInt);
      return cTText;
    } 
  }
  
  public CTText addNewT() {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().add_element_user(T$4);
      return cTText;
    } 
  }
  
  public void removeT(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(T$4, paramInt);
    } 
  }
  
  public List<CTText> getDelTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTText>)new DelTextList(this);
    } 
  }
  
  public CTText[] getDelTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DELTEXT$6, arrayList);
      CTText[] arrayOfCTText = new CTText[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTText);
      return arrayOfCTText;
    } 
  }
  
  public CTText getDelTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(DELTEXT$6, paramInt);
      if (cTText == null)
        throw new IndexOutOfBoundsException(); 
      return cTText;
    } 
  }
  
  public int sizeOfDelTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DELTEXT$6);
    } 
  }
  
  public void setDelTextArray(CTText[] paramArrayOfCTText) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTText, DELTEXT$6);
    } 
  }
  
  public void setDelTextArray(int paramInt, CTText paramCTText) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(DELTEXT$6, paramInt);
      if (cTText == null)
        throw new IndexOutOfBoundsException(); 
      cTText.set((XmlObject)paramCTText);
    } 
  }
  
  public CTText insertNewDelText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().insert_element_user(DELTEXT$6, paramInt);
      return cTText;
    } 
  }
  
  public CTText addNewDelText() {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().add_element_user(DELTEXT$6);
      return cTText;
    } 
  }
  
  public void removeDelText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DELTEXT$6, paramInt);
    } 
  }
  
  public List<CTText> getInstrTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTText>)new InstrTextList(this);
    } 
  }
  
  public CTText[] getInstrTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(INSTRTEXT$8, arrayList);
      CTText[] arrayOfCTText = new CTText[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTText);
      return arrayOfCTText;
    } 
  }
  
  public CTText getInstrTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(INSTRTEXT$8, paramInt);
      if (cTText == null)
        throw new IndexOutOfBoundsException(); 
      return cTText;
    } 
  }
  
  public int sizeOfInstrTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INSTRTEXT$8);
    } 
  }
  
  public void setInstrTextArray(CTText[] paramArrayOfCTText) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTText, INSTRTEXT$8);
    } 
  }
  
  public void setInstrTextArray(int paramInt, CTText paramCTText) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(INSTRTEXT$8, paramInt);
      if (cTText == null)
        throw new IndexOutOfBoundsException(); 
      cTText.set((XmlObject)paramCTText);
    } 
  }
  
  public CTText insertNewInstrText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().insert_element_user(INSTRTEXT$8, paramInt);
      return cTText;
    } 
  }
  
  public CTText addNewInstrText() {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().add_element_user(INSTRTEXT$8);
      return cTText;
    } 
  }
  
  public void removeInstrText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INSTRTEXT$8, paramInt);
    } 
  }
  
  public List<CTText> getDelInstrTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTText>)new DelInstrTextList(this);
    } 
  }
  
  public CTText[] getDelInstrTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DELINSTRTEXT$10, arrayList);
      CTText[] arrayOfCTText = new CTText[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTText);
      return arrayOfCTText;
    } 
  }
  
  public CTText getDelInstrTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(DELINSTRTEXT$10, paramInt);
      if (cTText == null)
        throw new IndexOutOfBoundsException(); 
      return cTText;
    } 
  }
  
  public int sizeOfDelInstrTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DELINSTRTEXT$10);
    } 
  }
  
  public void setDelInstrTextArray(CTText[] paramArrayOfCTText) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTText, DELINSTRTEXT$10);
    } 
  }
  
  public void setDelInstrTextArray(int paramInt, CTText paramCTText) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(DELINSTRTEXT$10, paramInt);
      if (cTText == null)
        throw new IndexOutOfBoundsException(); 
      cTText.set((XmlObject)paramCTText);
    } 
  }
  
  public CTText insertNewDelInstrText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().insert_element_user(DELINSTRTEXT$10, paramInt);
      return cTText;
    } 
  }
  
  public CTText addNewDelInstrText() {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().add_element_user(DELINSTRTEXT$10);
      return cTText;
    } 
  }
  
  public void removeDelInstrText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DELINSTRTEXT$10, paramInt);
    } 
  }
  
  public List<CTEmpty> getNoBreakHyphenList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new NoBreakHyphenList(this);
    } 
  }
  
  public CTEmpty[] getNoBreakHyphenArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NOBREAKHYPHEN$12, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getNoBreakHyphenArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(NOBREAKHYPHEN$12, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfNoBreakHyphenArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NOBREAKHYPHEN$12);
    } 
  }
  
  public void setNoBreakHyphenArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, NOBREAKHYPHEN$12);
    } 
  }
  
  public void setNoBreakHyphenArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(NOBREAKHYPHEN$12, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewNoBreakHyphen(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(NOBREAKHYPHEN$12, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewNoBreakHyphen() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(NOBREAKHYPHEN$12);
      return cTEmpty;
    } 
  }
  
  public void removeNoBreakHyphen(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOBREAKHYPHEN$12, paramInt);
    } 
  }
  
  public List<CTEmpty> getSoftHyphenList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new SoftHyphenList(this);
    } 
  }
  
  public CTEmpty[] getSoftHyphenArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SOFTHYPHEN$14, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getSoftHyphenArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(SOFTHYPHEN$14, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfSoftHyphenArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SOFTHYPHEN$14);
    } 
  }
  
  public void setSoftHyphenArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, SOFTHYPHEN$14);
    } 
  }
  
  public void setSoftHyphenArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(SOFTHYPHEN$14, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewSoftHyphen(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(SOFTHYPHEN$14, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewSoftHyphen() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(SOFTHYPHEN$14);
      return cTEmpty;
    } 
  }
  
  public void removeSoftHyphen(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOFTHYPHEN$14, paramInt);
    } 
  }
  
  public List<CTEmpty> getDayShortList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new DayShortList(this);
    } 
  }
  
  public CTEmpty[] getDayShortArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DAYSHORT$16, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getDayShortArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(DAYSHORT$16, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfDayShortArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DAYSHORT$16);
    } 
  }
  
  public void setDayShortArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, DAYSHORT$16);
    } 
  }
  
  public void setDayShortArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(DAYSHORT$16, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewDayShort(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(DAYSHORT$16, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewDayShort() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(DAYSHORT$16);
      return cTEmpty;
    } 
  }
  
  public void removeDayShort(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DAYSHORT$16, paramInt);
    } 
  }
  
  public List<CTEmpty> getMonthShortList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new MonthShortList(this);
    } 
  }
  
  public CTEmpty[] getMonthShortArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MONTHSHORT$18, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getMonthShortArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(MONTHSHORT$18, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfMonthShortArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MONTHSHORT$18);
    } 
  }
  
  public void setMonthShortArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, MONTHSHORT$18);
    } 
  }
  
  public void setMonthShortArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(MONTHSHORT$18, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewMonthShort(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(MONTHSHORT$18, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewMonthShort() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(MONTHSHORT$18);
      return cTEmpty;
    } 
  }
  
  public void removeMonthShort(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MONTHSHORT$18, paramInt);
    } 
  }
  
  public List<CTEmpty> getYearShortList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new YearShortList(this);
    } 
  }
  
  public CTEmpty[] getYearShortArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(YEARSHORT$20, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getYearShortArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(YEARSHORT$20, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfYearShortArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(YEARSHORT$20);
    } 
  }
  
  public void setYearShortArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, YEARSHORT$20);
    } 
  }
  
  public void setYearShortArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(YEARSHORT$20, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewYearShort(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(YEARSHORT$20, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewYearShort() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(YEARSHORT$20);
      return cTEmpty;
    } 
  }
  
  public void removeYearShort(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(YEARSHORT$20, paramInt);
    } 
  }
  
  public List<CTEmpty> getDayLongList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new DayLongList(this);
    } 
  }
  
  public CTEmpty[] getDayLongArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DAYLONG$22, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getDayLongArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(DAYLONG$22, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfDayLongArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DAYLONG$22);
    } 
  }
  
  public void setDayLongArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, DAYLONG$22);
    } 
  }
  
  public void setDayLongArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(DAYLONG$22, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewDayLong(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(DAYLONG$22, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewDayLong() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(DAYLONG$22);
      return cTEmpty;
    } 
  }
  
  public void removeDayLong(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DAYLONG$22, paramInt);
    } 
  }
  
  public List<CTEmpty> getMonthLongList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new MonthLongList(this);
    } 
  }
  
  public CTEmpty[] getMonthLongArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MONTHLONG$24, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getMonthLongArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(MONTHLONG$24, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfMonthLongArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MONTHLONG$24);
    } 
  }
  
  public void setMonthLongArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, MONTHLONG$24);
    } 
  }
  
  public void setMonthLongArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(MONTHLONG$24, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewMonthLong(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(MONTHLONG$24, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewMonthLong() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(MONTHLONG$24);
      return cTEmpty;
    } 
  }
  
  public void removeMonthLong(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MONTHLONG$24, paramInt);
    } 
  }
  
  public List<CTEmpty> getYearLongList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new YearLongList(this);
    } 
  }
  
  public CTEmpty[] getYearLongArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(YEARLONG$26, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getYearLongArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(YEARLONG$26, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfYearLongArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(YEARLONG$26);
    } 
  }
  
  public void setYearLongArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, YEARLONG$26);
    } 
  }
  
  public void setYearLongArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(YEARLONG$26, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewYearLong(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(YEARLONG$26, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewYearLong() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(YEARLONG$26);
      return cTEmpty;
    } 
  }
  
  public void removeYearLong(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(YEARLONG$26, paramInt);
    } 
  }
  
  public List<CTEmpty> getAnnotationRefList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new AnnotationRefList(this);
    } 
  }
  
  public CTEmpty[] getAnnotationRefArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ANNOTATIONREF$28, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getAnnotationRefArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(ANNOTATIONREF$28, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfAnnotationRefArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ANNOTATIONREF$28);
    } 
  }
  
  public void setAnnotationRefArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, ANNOTATIONREF$28);
    } 
  }
  
  public void setAnnotationRefArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(ANNOTATIONREF$28, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewAnnotationRef(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(ANNOTATIONREF$28, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewAnnotationRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(ANNOTATIONREF$28);
      return cTEmpty;
    } 
  }
  
  public void removeAnnotationRef(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ANNOTATIONREF$28, paramInt);
    } 
  }
  
  public List<CTEmpty> getFootnoteRefList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new FootnoteRefList(this);
    } 
  }
  
  public CTEmpty[] getFootnoteRefArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FOOTNOTEREF$30, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getFootnoteRefArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(FOOTNOTEREF$30, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfFootnoteRefArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FOOTNOTEREF$30);
    } 
  }
  
  public void setFootnoteRefArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, FOOTNOTEREF$30);
    } 
  }
  
  public void setFootnoteRefArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(FOOTNOTEREF$30, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewFootnoteRef(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(FOOTNOTEREF$30, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewFootnoteRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(FOOTNOTEREF$30);
      return cTEmpty;
    } 
  }
  
  public void removeFootnoteRef(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FOOTNOTEREF$30, paramInt);
    } 
  }
  
  public List<CTEmpty> getEndnoteRefList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new EndnoteRefList(this);
    } 
  }
  
  public CTEmpty[] getEndnoteRefArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ENDNOTEREF$32, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getEndnoteRefArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(ENDNOTEREF$32, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfEndnoteRefArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ENDNOTEREF$32);
    } 
  }
  
  public void setEndnoteRefArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, ENDNOTEREF$32);
    } 
  }
  
  public void setEndnoteRefArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(ENDNOTEREF$32, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewEndnoteRef(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(ENDNOTEREF$32, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewEndnoteRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(ENDNOTEREF$32);
      return cTEmpty;
    } 
  }
  
  public void removeEndnoteRef(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENDNOTEREF$32, paramInt);
    } 
  }
  
  public List<CTEmpty> getSeparatorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new SeparatorList(this);
    } 
  }
  
  public CTEmpty[] getSeparatorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SEPARATOR$34, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getSeparatorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(SEPARATOR$34, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfSeparatorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SEPARATOR$34);
    } 
  }
  
  public void setSeparatorArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, SEPARATOR$34);
    } 
  }
  
  public void setSeparatorArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(SEPARATOR$34, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewSeparator(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(SEPARATOR$34, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewSeparator() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(SEPARATOR$34);
      return cTEmpty;
    } 
  }
  
  public void removeSeparator(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SEPARATOR$34, paramInt);
    } 
  }
  
  public List<CTEmpty> getContinuationSeparatorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new ContinuationSeparatorList(this);
    } 
  }
  
  public CTEmpty[] getContinuationSeparatorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CONTINUATIONSEPARATOR$36, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getContinuationSeparatorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(CONTINUATIONSEPARATOR$36, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfContinuationSeparatorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CONTINUATIONSEPARATOR$36);
    } 
  }
  
  public void setContinuationSeparatorArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, CONTINUATIONSEPARATOR$36);
    } 
  }
  
  public void setContinuationSeparatorArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(CONTINUATIONSEPARATOR$36, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewContinuationSeparator(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(CONTINUATIONSEPARATOR$36, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewContinuationSeparator() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(CONTINUATIONSEPARATOR$36);
      return cTEmpty;
    } 
  }
  
  public void removeContinuationSeparator(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONTINUATIONSEPARATOR$36, paramInt);
    } 
  }
  
  public List<CTSym> getSymList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSym>)new SymList(this);
    } 
  }
  
  public CTSym[] getSymArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SYM$38, arrayList);
      CTSym[] arrayOfCTSym = new CTSym[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSym);
      return arrayOfCTSym;
    } 
  }
  
  public CTSym getSymArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSym cTSym = null;
      cTSym = (CTSym)get_store().find_element_user(SYM$38, paramInt);
      if (cTSym == null)
        throw new IndexOutOfBoundsException(); 
      return cTSym;
    } 
  }
  
  public int sizeOfSymArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SYM$38);
    } 
  }
  
  public void setSymArray(CTSym[] paramArrayOfCTSym) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSym, SYM$38);
    } 
  }
  
  public void setSymArray(int paramInt, CTSym paramCTSym) {
    synchronized (monitor()) {
      check_orphaned();
      CTSym cTSym = null;
      cTSym = (CTSym)get_store().find_element_user(SYM$38, paramInt);
      if (cTSym == null)
        throw new IndexOutOfBoundsException(); 
      cTSym.set((XmlObject)paramCTSym);
    } 
  }
  
  public CTSym insertNewSym(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSym cTSym = null;
      cTSym = (CTSym)get_store().insert_element_user(SYM$38, paramInt);
      return cTSym;
    } 
  }
  
  public CTSym addNewSym() {
    synchronized (monitor()) {
      check_orphaned();
      CTSym cTSym = null;
      cTSym = (CTSym)get_store().add_element_user(SYM$38);
      return cTSym;
    } 
  }
  
  public void removeSym(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SYM$38, paramInt);
    } 
  }
  
  public List<CTEmpty> getPgNumList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new PgNumList(this);
    } 
  }
  
  public CTEmpty[] getPgNumArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PGNUM$40, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getPgNumArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(PGNUM$40, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfPgNumArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PGNUM$40);
    } 
  }
  
  public void setPgNumArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, PGNUM$40);
    } 
  }
  
  public void setPgNumArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(PGNUM$40, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewPgNum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(PGNUM$40, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewPgNum() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(PGNUM$40);
      return cTEmpty;
    } 
  }
  
  public void removePgNum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PGNUM$40, paramInt);
    } 
  }
  
  public List<CTEmpty> getCrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new CrList(this);
    } 
  }
  
  public CTEmpty[] getCrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CR$42, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getCrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(CR$42, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfCrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CR$42);
    } 
  }
  
  public void setCrArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, CR$42);
    } 
  }
  
  public void setCrArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(CR$42, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewCr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(CR$42, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewCr() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(CR$42);
      return cTEmpty;
    } 
  }
  
  public void removeCr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CR$42, paramInt);
    } 
  }
  
  public List<CTEmpty> getTabList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new TabList(this);
    } 
  }
  
  public CTEmpty[] getTabArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TAB$44, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getTabArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(TAB$44, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfTabArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TAB$44);
    } 
  }
  
  public void setTabArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, TAB$44);
    } 
  }
  
  public void setTabArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(TAB$44, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewTab(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(TAB$44, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewTab() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(TAB$44);
      return cTEmpty;
    } 
  }
  
  public void removeTab(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TAB$44, paramInt);
    } 
  }
  
  public List<CTObject> getObjectList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTObject>)new ObjectList(this);
    } 
  }
  
  public CTObject[] getObjectArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(OBJECT$46, arrayList);
      CTObject[] arrayOfCTObject = new CTObject[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTObject);
      return arrayOfCTObject;
    } 
  }
  
  public CTObject getObjectArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTObject cTObject = null;
      cTObject = (CTObject)get_store().find_element_user(OBJECT$46, paramInt);
      if (cTObject == null)
        throw new IndexOutOfBoundsException(); 
      return cTObject;
    } 
  }
  
  public int sizeOfObjectArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(OBJECT$46);
    } 
  }
  
  public void setObjectArray(CTObject[] paramArrayOfCTObject) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTObject, OBJECT$46);
    } 
  }
  
  public void setObjectArray(int paramInt, CTObject paramCTObject) {
    synchronized (monitor()) {
      check_orphaned();
      CTObject cTObject = null;
      cTObject = (CTObject)get_store().find_element_user(OBJECT$46, paramInt);
      if (cTObject == null)
        throw new IndexOutOfBoundsException(); 
      cTObject.set((XmlObject)paramCTObject);
    } 
  }
  
  public CTObject insertNewObject(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTObject cTObject = null;
      cTObject = (CTObject)get_store().insert_element_user(OBJECT$46, paramInt);
      return cTObject;
    } 
  }
  
  public CTObject addNewObject() {
    synchronized (monitor()) {
      check_orphaned();
      CTObject cTObject = null;
      cTObject = (CTObject)get_store().add_element_user(OBJECT$46);
      return cTObject;
    } 
  }
  
  public void removeObject(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OBJECT$46, paramInt);
    } 
  }
  
  public List<CTPicture> getPictList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPicture>)new PictList(this);
    } 
  }
  
  public CTPicture[] getPictArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PICT$48, arrayList);
      CTPicture[] arrayOfCTPicture = new CTPicture[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPicture);
      return arrayOfCTPicture;
    } 
  }
  
  public CTPicture getPictArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().find_element_user(PICT$48, paramInt);
      if (cTPicture == null)
        throw new IndexOutOfBoundsException(); 
      return cTPicture;
    } 
  }
  
  public int sizeOfPictArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PICT$48);
    } 
  }
  
  public void setPictArray(CTPicture[] paramArrayOfCTPicture) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPicture, PICT$48);
    } 
  }
  
  public void setPictArray(int paramInt, CTPicture paramCTPicture) {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().find_element_user(PICT$48, paramInt);
      if (cTPicture == null)
        throw new IndexOutOfBoundsException(); 
      cTPicture.set((XmlObject)paramCTPicture);
    } 
  }
  
  public CTPicture insertNewPict(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().insert_element_user(PICT$48, paramInt);
      return cTPicture;
    } 
  }
  
  public CTPicture addNewPict() {
    synchronized (monitor()) {
      check_orphaned();
      CTPicture cTPicture = null;
      cTPicture = (CTPicture)get_store().add_element_user(PICT$48);
      return cTPicture;
    } 
  }
  
  public void removePict(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PICT$48, paramInt);
    } 
  }
  
  public List<CTFldChar> getFldCharList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFldChar>)new FldCharList(this);
    } 
  }
  
  public CTFldChar[] getFldCharArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FLDCHAR$50, arrayList);
      CTFldChar[] arrayOfCTFldChar = new CTFldChar[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFldChar);
      return arrayOfCTFldChar;
    } 
  }
  
  public CTFldChar getFldCharArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFldChar cTFldChar = null;
      cTFldChar = (CTFldChar)get_store().find_element_user(FLDCHAR$50, paramInt);
      if (cTFldChar == null)
        throw new IndexOutOfBoundsException(); 
      return cTFldChar;
    } 
  }
  
  public int sizeOfFldCharArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FLDCHAR$50);
    } 
  }
  
  public void setFldCharArray(CTFldChar[] paramArrayOfCTFldChar) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFldChar, FLDCHAR$50);
    } 
  }
  
  public void setFldCharArray(int paramInt, CTFldChar paramCTFldChar) {
    synchronized (monitor()) {
      check_orphaned();
      CTFldChar cTFldChar = null;
      cTFldChar = (CTFldChar)get_store().find_element_user(FLDCHAR$50, paramInt);
      if (cTFldChar == null)
        throw new IndexOutOfBoundsException(); 
      cTFldChar.set((XmlObject)paramCTFldChar);
    } 
  }
  
  public CTFldChar insertNewFldChar(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFldChar cTFldChar = null;
      cTFldChar = (CTFldChar)get_store().insert_element_user(FLDCHAR$50, paramInt);
      return cTFldChar;
    } 
  }
  
  public CTFldChar addNewFldChar() {
    synchronized (monitor()) {
      check_orphaned();
      CTFldChar cTFldChar = null;
      cTFldChar = (CTFldChar)get_store().add_element_user(FLDCHAR$50);
      return cTFldChar;
    } 
  }
  
  public void removeFldChar(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FLDCHAR$50, paramInt);
    } 
  }
  
  public List<CTRuby> getRubyList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRuby>)new RubyList(this);
    } 
  }
  
  public CTRuby[] getRubyArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RUBY$52, arrayList);
      CTRuby[] arrayOfCTRuby = new CTRuby[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRuby);
      return arrayOfCTRuby;
    } 
  }
  
  public CTRuby getRubyArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRuby cTRuby = null;
      cTRuby = (CTRuby)get_store().find_element_user(RUBY$52, paramInt);
      if (cTRuby == null)
        throw new IndexOutOfBoundsException(); 
      return cTRuby;
    } 
  }
  
  public int sizeOfRubyArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RUBY$52);
    } 
  }
  
  public void setRubyArray(CTRuby[] paramArrayOfCTRuby) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRuby, RUBY$52);
    } 
  }
  
  public void setRubyArray(int paramInt, CTRuby paramCTRuby) {
    synchronized (monitor()) {
      check_orphaned();
      CTRuby cTRuby = null;
      cTRuby = (CTRuby)get_store().find_element_user(RUBY$52, paramInt);
      if (cTRuby == null)
        throw new IndexOutOfBoundsException(); 
      cTRuby.set((XmlObject)paramCTRuby);
    } 
  }
  
  public CTRuby insertNewRuby(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRuby cTRuby = null;
      cTRuby = (CTRuby)get_store().insert_element_user(RUBY$52, paramInt);
      return cTRuby;
    } 
  }
  
  public CTRuby addNewRuby() {
    synchronized (monitor()) {
      check_orphaned();
      CTRuby cTRuby = null;
      cTRuby = (CTRuby)get_store().add_element_user(RUBY$52);
      return cTRuby;
    } 
  }
  
  public void removeRuby(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RUBY$52, paramInt);
    } 
  }
  
  public List<CTFtnEdnRef> getFootnoteReferenceList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFtnEdnRef>)new FootnoteReferenceList(this);
    } 
  }
  
  public CTFtnEdnRef[] getFootnoteReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FOOTNOTEREFERENCE$54, arrayList);
      CTFtnEdnRef[] arrayOfCTFtnEdnRef = new CTFtnEdnRef[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFtnEdnRef);
      return arrayOfCTFtnEdnRef;
    } 
  }
  
  public CTFtnEdnRef getFootnoteReferenceArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdnRef cTFtnEdnRef = null;
      cTFtnEdnRef = (CTFtnEdnRef)get_store().find_element_user(FOOTNOTEREFERENCE$54, paramInt);
      if (cTFtnEdnRef == null)
        throw new IndexOutOfBoundsException(); 
      return cTFtnEdnRef;
    } 
  }
  
  public int sizeOfFootnoteReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FOOTNOTEREFERENCE$54);
    } 
  }
  
  public void setFootnoteReferenceArray(CTFtnEdnRef[] paramArrayOfCTFtnEdnRef) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFtnEdnRef, FOOTNOTEREFERENCE$54);
    } 
  }
  
  public void setFootnoteReferenceArray(int paramInt, CTFtnEdnRef paramCTFtnEdnRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdnRef cTFtnEdnRef = null;
      cTFtnEdnRef = (CTFtnEdnRef)get_store().find_element_user(FOOTNOTEREFERENCE$54, paramInt);
      if (cTFtnEdnRef == null)
        throw new IndexOutOfBoundsException(); 
      cTFtnEdnRef.set((XmlObject)paramCTFtnEdnRef);
    } 
  }
  
  public CTFtnEdnRef insertNewFootnoteReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdnRef cTFtnEdnRef = null;
      cTFtnEdnRef = (CTFtnEdnRef)get_store().insert_element_user(FOOTNOTEREFERENCE$54, paramInt);
      return cTFtnEdnRef;
    } 
  }
  
  public CTFtnEdnRef addNewFootnoteReference() {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdnRef cTFtnEdnRef = null;
      cTFtnEdnRef = (CTFtnEdnRef)get_store().add_element_user(FOOTNOTEREFERENCE$54);
      return cTFtnEdnRef;
    } 
  }
  
  public void removeFootnoteReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FOOTNOTEREFERENCE$54, paramInt);
    } 
  }
  
  public List<CTFtnEdnRef> getEndnoteReferenceList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFtnEdnRef>)new EndnoteReferenceList(this);
    } 
  }
  
  public CTFtnEdnRef[] getEndnoteReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ENDNOTEREFERENCE$56, arrayList);
      CTFtnEdnRef[] arrayOfCTFtnEdnRef = new CTFtnEdnRef[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFtnEdnRef);
      return arrayOfCTFtnEdnRef;
    } 
  }
  
  public CTFtnEdnRef getEndnoteReferenceArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdnRef cTFtnEdnRef = null;
      cTFtnEdnRef = (CTFtnEdnRef)get_store().find_element_user(ENDNOTEREFERENCE$56, paramInt);
      if (cTFtnEdnRef == null)
        throw new IndexOutOfBoundsException(); 
      return cTFtnEdnRef;
    } 
  }
  
  public int sizeOfEndnoteReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ENDNOTEREFERENCE$56);
    } 
  }
  
  public void setEndnoteReferenceArray(CTFtnEdnRef[] paramArrayOfCTFtnEdnRef) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFtnEdnRef, ENDNOTEREFERENCE$56);
    } 
  }
  
  public void setEndnoteReferenceArray(int paramInt, CTFtnEdnRef paramCTFtnEdnRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdnRef cTFtnEdnRef = null;
      cTFtnEdnRef = (CTFtnEdnRef)get_store().find_element_user(ENDNOTEREFERENCE$56, paramInt);
      if (cTFtnEdnRef == null)
        throw new IndexOutOfBoundsException(); 
      cTFtnEdnRef.set((XmlObject)paramCTFtnEdnRef);
    } 
  }
  
  public CTFtnEdnRef insertNewEndnoteReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdnRef cTFtnEdnRef = null;
      cTFtnEdnRef = (CTFtnEdnRef)get_store().insert_element_user(ENDNOTEREFERENCE$56, paramInt);
      return cTFtnEdnRef;
    } 
  }
  
  public CTFtnEdnRef addNewEndnoteReference() {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdnRef cTFtnEdnRef = null;
      cTFtnEdnRef = (CTFtnEdnRef)get_store().add_element_user(ENDNOTEREFERENCE$56);
      return cTFtnEdnRef;
    } 
  }
  
  public void removeEndnoteReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENDNOTEREFERENCE$56, paramInt);
    } 
  }
  
  public List<CTMarkup> getCommentReferenceList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMarkup>)new CommentReferenceList(this);
    } 
  }
  
  public CTMarkup[] getCommentReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COMMENTREFERENCE$58, arrayList);
      CTMarkup[] arrayOfCTMarkup = new CTMarkup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMarkup);
      return arrayOfCTMarkup;
    } 
  }
  
  public CTMarkup getCommentReferenceArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(COMMENTREFERENCE$58, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      return cTMarkup;
    } 
  }
  
  public int sizeOfCommentReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COMMENTREFERENCE$58);
    } 
  }
  
  public void setCommentReferenceArray(CTMarkup[] paramArrayOfCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMarkup, COMMENTREFERENCE$58);
    } 
  }
  
  public void setCommentReferenceArray(int paramInt, CTMarkup paramCTMarkup) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().find_element_user(COMMENTREFERENCE$58, paramInt);
      if (cTMarkup == null)
        throw new IndexOutOfBoundsException(); 
      cTMarkup.set((XmlObject)paramCTMarkup);
    } 
  }
  
  public CTMarkup insertNewCommentReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().insert_element_user(COMMENTREFERENCE$58, paramInt);
      return cTMarkup;
    } 
  }
  
  public CTMarkup addNewCommentReference() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkup cTMarkup = null;
      cTMarkup = (CTMarkup)get_store().add_element_user(COMMENTREFERENCE$58);
      return cTMarkup;
    } 
  }
  
  public void removeCommentReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMMENTREFERENCE$58, paramInt);
    } 
  }
  
  public List<CTDrawing> getDrawingList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDrawing>)new DrawingList(this);
    } 
  }
  
  public CTDrawing[] getDrawingArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DRAWING$60, arrayList);
      CTDrawing[] arrayOfCTDrawing = new CTDrawing[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDrawing);
      return arrayOfCTDrawing;
    } 
  }
  
  public CTDrawing getDrawingArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().find_element_user(DRAWING$60, paramInt);
      if (cTDrawing == null)
        throw new IndexOutOfBoundsException(); 
      return cTDrawing;
    } 
  }
  
  public int sizeOfDrawingArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DRAWING$60);
    } 
  }
  
  public void setDrawingArray(CTDrawing[] paramArrayOfCTDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDrawing, DRAWING$60);
    } 
  }
  
  public void setDrawingArray(int paramInt, CTDrawing paramCTDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().find_element_user(DRAWING$60, paramInt);
      if (cTDrawing == null)
        throw new IndexOutOfBoundsException(); 
      cTDrawing.set((XmlObject)paramCTDrawing);
    } 
  }
  
  public CTDrawing insertNewDrawing(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().insert_element_user(DRAWING$60, paramInt);
      return cTDrawing;
    } 
  }
  
  public CTDrawing addNewDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().add_element_user(DRAWING$60);
      return cTDrawing;
    } 
  }
  
  public void removeDrawing(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DRAWING$60, paramInt);
    } 
  }
  
  public List<CTPTab> getPtabList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPTab>)new PtabList(this);
    } 
  }
  
  public CTPTab[] getPtabArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PTAB$62, arrayList);
      CTPTab[] arrayOfCTPTab = new CTPTab[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPTab);
      return arrayOfCTPTab;
    } 
  }
  
  public CTPTab getPtabArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPTab cTPTab = null;
      cTPTab = (CTPTab)get_store().find_element_user(PTAB$62, paramInt);
      if (cTPTab == null)
        throw new IndexOutOfBoundsException(); 
      return cTPTab;
    } 
  }
  
  public int sizeOfPtabArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PTAB$62);
    } 
  }
  
  public void setPtabArray(CTPTab[] paramArrayOfCTPTab) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPTab, PTAB$62);
    } 
  }
  
  public void setPtabArray(int paramInt, CTPTab paramCTPTab) {
    synchronized (monitor()) {
      check_orphaned();
      CTPTab cTPTab = null;
      cTPTab = (CTPTab)get_store().find_element_user(PTAB$62, paramInt);
      if (cTPTab == null)
        throw new IndexOutOfBoundsException(); 
      cTPTab.set((XmlObject)paramCTPTab);
    } 
  }
  
  public CTPTab insertNewPtab(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPTab cTPTab = null;
      cTPTab = (CTPTab)get_store().insert_element_user(PTAB$62, paramInt);
      return cTPTab;
    } 
  }
  
  public CTPTab addNewPtab() {
    synchronized (monitor()) {
      check_orphaned();
      CTPTab cTPTab = null;
      cTPTab = (CTPTab)get_store().add_element_user(PTAB$62);
      return cTPTab;
    } 
  }
  
  public void removePtab(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PTAB$62, paramInt);
    } 
  }
  
  public List<CTEmpty> getLastRenderedPageBreakList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new LastRenderedPageBreakList(this);
    } 
  }
  
  public CTEmpty[] getLastRenderedPageBreakArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LASTRENDEREDPAGEBREAK$64, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getLastRenderedPageBreakArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(LASTRENDEREDPAGEBREAK$64, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfLastRenderedPageBreakArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LASTRENDEREDPAGEBREAK$64);
    } 
  }
  
  public void setLastRenderedPageBreakArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, LASTRENDEREDPAGEBREAK$64);
    } 
  }
  
  public void setLastRenderedPageBreakArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(LASTRENDEREDPAGEBREAK$64, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewLastRenderedPageBreak(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(LASTRENDEREDPAGEBREAK$64, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewLastRenderedPageBreak() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(LASTRENDEREDPAGEBREAK$64);
      return cTEmpty;
    } 
  }
  
  public void removeLastRenderedPageBreak(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LASTRENDEREDPAGEBREAK$64, paramInt);
    } 
  }
  
  public byte[] getRsidRPr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDRPR$66);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetRsidRPr() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDRPR$66);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetRsidRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RSIDRPR$66) != null);
    } 
  }
  
  public void setRsidRPr(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDRPR$66);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RSIDRPR$66); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRsidRPr(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDRPR$66);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(RSIDRPR$66); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetRsidRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RSIDRPR$66);
    } 
  }
  
  public byte[] getRsidDel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDDEL$68);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetRsidDel() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDDEL$68);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetRsidDel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RSIDDEL$68) != null);
    } 
  }
  
  public void setRsidDel(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDDEL$68);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RSIDDEL$68); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRsidDel(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDDEL$68);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(RSIDDEL$68); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetRsidDel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RSIDDEL$68);
    } 
  }
  
  public byte[] getRsidR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDR$70);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetRsidR() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDR$70);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetRsidR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RSIDR$70) != null);
    } 
  }
  
  public void setRsidR(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDR$70);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RSIDR$70); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRsidR(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDR$70);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(RSIDR$70); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetRsidR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RSIDR$70);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTRImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */