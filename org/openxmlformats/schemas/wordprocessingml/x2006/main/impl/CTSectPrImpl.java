package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEdnProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLineNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPaperSource;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;

public class CTSectPrImpl extends XmlComplexContentImpl implements CTSectPr {
  private static final b HEADERREFERENCE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "headerReference");
  
  private static final b FOOTERREFERENCE$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footerReference");
  
  private static final b FOOTNOTEPR$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnotePr");
  
  private static final b ENDNOTEPR$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnotePr");
  
  private static final b TYPE$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
  
  private static final b PGSZ$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgSz");
  
  private static final b PGMAR$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgMar");
  
  private static final b PAPERSRC$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "paperSrc");
  
  private static final b PGBORDERS$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgBorders");
  
  private static final b LNNUMTYPE$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lnNumType");
  
  private static final b PGNUMTYPE$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgNumType");
  
  private static final b COLS$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cols");
  
  private static final b FORMPROT$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "formProt");
  
  private static final b VALIGN$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vAlign");
  
  private static final b NOENDNOTE$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noEndnote");
  
  private static final b TITLEPG$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "titlePg");
  
  private static final b TEXTDIRECTION$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection");
  
  private static final b BIDI$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidi");
  
  private static final b RTLGUTTER$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtlGutter");
  
  private static final b DOCGRID$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docGrid");
  
  private static final b PRINTERSETTINGS$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printerSettings");
  
  private static final b SECTPRCHANGE$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sectPrChange");
  
  private static final b RSIDRPR$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidRPr");
  
  private static final b RSIDDEL$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidDel");
  
  private static final b RSIDR$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidR");
  
  private static final b RSIDSECT$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsidSect");
  
  public CTSectPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTHdrFtrRef> getHeaderReferenceList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTHdrFtrRef>)new HeaderReferenceList(this);
    } 
  }
  
  public CTHdrFtrRef[] getHeaderReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HEADERREFERENCE$0, arrayList);
      CTHdrFtrRef[] arrayOfCTHdrFtrRef = new CTHdrFtrRef[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTHdrFtrRef);
      return arrayOfCTHdrFtrRef;
    } 
  }
  
  public CTHdrFtrRef getHeaderReferenceArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtrRef cTHdrFtrRef = null;
      cTHdrFtrRef = (CTHdrFtrRef)get_store().find_element_user(HEADERREFERENCE$0, paramInt);
      if (cTHdrFtrRef == null)
        throw new IndexOutOfBoundsException(); 
      return cTHdrFtrRef;
    } 
  }
  
  public int sizeOfHeaderReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HEADERREFERENCE$0);
    } 
  }
  
  public void setHeaderReferenceArray(CTHdrFtrRef[] paramArrayOfCTHdrFtrRef) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTHdrFtrRef, HEADERREFERENCE$0);
    } 
  }
  
  public void setHeaderReferenceArray(int paramInt, CTHdrFtrRef paramCTHdrFtrRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtrRef cTHdrFtrRef = null;
      cTHdrFtrRef = (CTHdrFtrRef)get_store().find_element_user(HEADERREFERENCE$0, paramInt);
      if (cTHdrFtrRef == null)
        throw new IndexOutOfBoundsException(); 
      cTHdrFtrRef.set((XmlObject)paramCTHdrFtrRef);
    } 
  }
  
  public CTHdrFtrRef insertNewHeaderReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtrRef cTHdrFtrRef = null;
      cTHdrFtrRef = (CTHdrFtrRef)get_store().insert_element_user(HEADERREFERENCE$0, paramInt);
      return cTHdrFtrRef;
    } 
  }
  
  public CTHdrFtrRef addNewHeaderReference() {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtrRef cTHdrFtrRef = null;
      cTHdrFtrRef = (CTHdrFtrRef)get_store().add_element_user(HEADERREFERENCE$0);
      return cTHdrFtrRef;
    } 
  }
  
  public void removeHeaderReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HEADERREFERENCE$0, paramInt);
    } 
  }
  
  public List<CTHdrFtrRef> getFooterReferenceList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTHdrFtrRef>)new FooterReferenceList(this);
    } 
  }
  
  public CTHdrFtrRef[] getFooterReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FOOTERREFERENCE$2, arrayList);
      CTHdrFtrRef[] arrayOfCTHdrFtrRef = new CTHdrFtrRef[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTHdrFtrRef);
      return arrayOfCTHdrFtrRef;
    } 
  }
  
  public CTHdrFtrRef getFooterReferenceArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtrRef cTHdrFtrRef = null;
      cTHdrFtrRef = (CTHdrFtrRef)get_store().find_element_user(FOOTERREFERENCE$2, paramInt);
      if (cTHdrFtrRef == null)
        throw new IndexOutOfBoundsException(); 
      return cTHdrFtrRef;
    } 
  }
  
  public int sizeOfFooterReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FOOTERREFERENCE$2);
    } 
  }
  
  public void setFooterReferenceArray(CTHdrFtrRef[] paramArrayOfCTHdrFtrRef) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTHdrFtrRef, FOOTERREFERENCE$2);
    } 
  }
  
  public void setFooterReferenceArray(int paramInt, CTHdrFtrRef paramCTHdrFtrRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtrRef cTHdrFtrRef = null;
      cTHdrFtrRef = (CTHdrFtrRef)get_store().find_element_user(FOOTERREFERENCE$2, paramInt);
      if (cTHdrFtrRef == null)
        throw new IndexOutOfBoundsException(); 
      cTHdrFtrRef.set((XmlObject)paramCTHdrFtrRef);
    } 
  }
  
  public CTHdrFtrRef insertNewFooterReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtrRef cTHdrFtrRef = null;
      cTHdrFtrRef = (CTHdrFtrRef)get_store().insert_element_user(FOOTERREFERENCE$2, paramInt);
      return cTHdrFtrRef;
    } 
  }
  
  public CTHdrFtrRef addNewFooterReference() {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtrRef cTHdrFtrRef = null;
      cTHdrFtrRef = (CTHdrFtrRef)get_store().add_element_user(FOOTERREFERENCE$2);
      return cTHdrFtrRef;
    } 
  }
  
  public void removeFooterReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FOOTERREFERENCE$2, paramInt);
    } 
  }
  
  public CTFtnProps getFootnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnProps cTFtnProps = null;
      cTFtnProps = (CTFtnProps)get_store().find_element_user(FOOTNOTEPR$4, 0);
      if (cTFtnProps == null)
        return null; 
      return cTFtnProps;
    } 
  }
  
  public boolean isSetFootnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FOOTNOTEPR$4) != 0);
    } 
  }
  
  public void setFootnotePr(CTFtnProps paramCTFtnProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnProps cTFtnProps = null;
      cTFtnProps = (CTFtnProps)get_store().find_element_user(FOOTNOTEPR$4, 0);
      if (cTFtnProps == null)
        cTFtnProps = (CTFtnProps)get_store().add_element_user(FOOTNOTEPR$4); 
      cTFtnProps.set((XmlObject)paramCTFtnProps);
    } 
  }
  
  public CTFtnProps addNewFootnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnProps cTFtnProps = null;
      cTFtnProps = (CTFtnProps)get_store().add_element_user(FOOTNOTEPR$4);
      return cTFtnProps;
    } 
  }
  
  public void unsetFootnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FOOTNOTEPR$4, 0);
    } 
  }
  
  public CTEdnProps getEndnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTEdnProps cTEdnProps = null;
      cTEdnProps = (CTEdnProps)get_store().find_element_user(ENDNOTEPR$6, 0);
      if (cTEdnProps == null)
        return null; 
      return cTEdnProps;
    } 
  }
  
  public boolean isSetEndnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ENDNOTEPR$6) != 0);
    } 
  }
  
  public void setEndnotePr(CTEdnProps paramCTEdnProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTEdnProps cTEdnProps = null;
      cTEdnProps = (CTEdnProps)get_store().find_element_user(ENDNOTEPR$6, 0);
      if (cTEdnProps == null)
        cTEdnProps = (CTEdnProps)get_store().add_element_user(ENDNOTEPR$6); 
      cTEdnProps.set((XmlObject)paramCTEdnProps);
    } 
  }
  
  public CTEdnProps addNewEndnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTEdnProps cTEdnProps = null;
      cTEdnProps = (CTEdnProps)get_store().add_element_user(ENDNOTEPR$6);
      return cTEdnProps;
    } 
  }
  
  public void unsetEndnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENDNOTEPR$6, 0);
    } 
  }
  
  public CTSectType getType() {
    synchronized (monitor()) {
      check_orphaned();
      CTSectType cTSectType = null;
      cTSectType = (CTSectType)get_store().find_element_user(TYPE$8, 0);
      if (cTSectType == null)
        return null; 
      return cTSectType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TYPE$8) != 0);
    } 
  }
  
  public void setType(CTSectType paramCTSectType) {
    synchronized (monitor()) {
      check_orphaned();
      CTSectType cTSectType = null;
      cTSectType = (CTSectType)get_store().find_element_user(TYPE$8, 0);
      if (cTSectType == null)
        cTSectType = (CTSectType)get_store().add_element_user(TYPE$8); 
      cTSectType.set((XmlObject)paramCTSectType);
    } 
  }
  
  public CTSectType addNewType() {
    synchronized (monitor()) {
      check_orphaned();
      CTSectType cTSectType = null;
      cTSectType = (CTSectType)get_store().add_element_user(TYPE$8);
      return cTSectType;
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TYPE$8, 0);
    } 
  }
  
  public CTPageSz getPgSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSz cTPageSz = null;
      cTPageSz = (CTPageSz)get_store().find_element_user(PGSZ$10, 0);
      if (cTPageSz == null)
        return null; 
      return cTPageSz;
    } 
  }
  
  public boolean isSetPgSz() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PGSZ$10) != 0);
    } 
  }
  
  public void setPgSz(CTPageSz paramCTPageSz) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSz cTPageSz = null;
      cTPageSz = (CTPageSz)get_store().find_element_user(PGSZ$10, 0);
      if (cTPageSz == null)
        cTPageSz = (CTPageSz)get_store().add_element_user(PGSZ$10); 
      cTPageSz.set((XmlObject)paramCTPageSz);
    } 
  }
  
  public CTPageSz addNewPgSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSz cTPageSz = null;
      cTPageSz = (CTPageSz)get_store().add_element_user(PGSZ$10);
      return cTPageSz;
    } 
  }
  
  public void unsetPgSz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PGSZ$10, 0);
    } 
  }
  
  public CTPageMar getPgMar() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMar cTPageMar = null;
      cTPageMar = (CTPageMar)get_store().find_element_user(PGMAR$12, 0);
      if (cTPageMar == null)
        return null; 
      return cTPageMar;
    } 
  }
  
  public boolean isSetPgMar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PGMAR$12) != 0);
    } 
  }
  
  public void setPgMar(CTPageMar paramCTPageMar) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMar cTPageMar = null;
      cTPageMar = (CTPageMar)get_store().find_element_user(PGMAR$12, 0);
      if (cTPageMar == null)
        cTPageMar = (CTPageMar)get_store().add_element_user(PGMAR$12); 
      cTPageMar.set((XmlObject)paramCTPageMar);
    } 
  }
  
  public CTPageMar addNewPgMar() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMar cTPageMar = null;
      cTPageMar = (CTPageMar)get_store().add_element_user(PGMAR$12);
      return cTPageMar;
    } 
  }
  
  public void unsetPgMar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PGMAR$12, 0);
    } 
  }
  
  public CTPaperSource getPaperSrc() {
    synchronized (monitor()) {
      check_orphaned();
      CTPaperSource cTPaperSource = null;
      cTPaperSource = (CTPaperSource)get_store().find_element_user(PAPERSRC$14, 0);
      if (cTPaperSource == null)
        return null; 
      return cTPaperSource;
    } 
  }
  
  public boolean isSetPaperSrc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAPERSRC$14) != 0);
    } 
  }
  
  public void setPaperSrc(CTPaperSource paramCTPaperSource) {
    synchronized (monitor()) {
      check_orphaned();
      CTPaperSource cTPaperSource = null;
      cTPaperSource = (CTPaperSource)get_store().find_element_user(PAPERSRC$14, 0);
      if (cTPaperSource == null)
        cTPaperSource = (CTPaperSource)get_store().add_element_user(PAPERSRC$14); 
      cTPaperSource.set((XmlObject)paramCTPaperSource);
    } 
  }
  
  public CTPaperSource addNewPaperSrc() {
    synchronized (monitor()) {
      check_orphaned();
      CTPaperSource cTPaperSource = null;
      cTPaperSource = (CTPaperSource)get_store().add_element_user(PAPERSRC$14);
      return cTPaperSource;
    } 
  }
  
  public void unsetPaperSrc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAPERSRC$14, 0);
    } 
  }
  
  public CTPageBorders getPgBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBorders cTPageBorders = null;
      cTPageBorders = (CTPageBorders)get_store().find_element_user(PGBORDERS$16, 0);
      if (cTPageBorders == null)
        return null; 
      return cTPageBorders;
    } 
  }
  
  public boolean isSetPgBorders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PGBORDERS$16) != 0);
    } 
  }
  
  public void setPgBorders(CTPageBorders paramCTPageBorders) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBorders cTPageBorders = null;
      cTPageBorders = (CTPageBorders)get_store().find_element_user(PGBORDERS$16, 0);
      if (cTPageBorders == null)
        cTPageBorders = (CTPageBorders)get_store().add_element_user(PGBORDERS$16); 
      cTPageBorders.set((XmlObject)paramCTPageBorders);
    } 
  }
  
  public CTPageBorders addNewPgBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBorders cTPageBorders = null;
      cTPageBorders = (CTPageBorders)get_store().add_element_user(PGBORDERS$16);
      return cTPageBorders;
    } 
  }
  
  public void unsetPgBorders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PGBORDERS$16, 0);
    } 
  }
  
  public CTLineNumber getLnNumType() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineNumber cTLineNumber = null;
      cTLineNumber = (CTLineNumber)get_store().find_element_user(LNNUMTYPE$18, 0);
      if (cTLineNumber == null)
        return null; 
      return cTLineNumber;
    } 
  }
  
  public boolean isSetLnNumType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LNNUMTYPE$18) != 0);
    } 
  }
  
  public void setLnNumType(CTLineNumber paramCTLineNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineNumber cTLineNumber = null;
      cTLineNumber = (CTLineNumber)get_store().find_element_user(LNNUMTYPE$18, 0);
      if (cTLineNumber == null)
        cTLineNumber = (CTLineNumber)get_store().add_element_user(LNNUMTYPE$18); 
      cTLineNumber.set((XmlObject)paramCTLineNumber);
    } 
  }
  
  public CTLineNumber addNewLnNumType() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineNumber cTLineNumber = null;
      cTLineNumber = (CTLineNumber)get_store().add_element_user(LNNUMTYPE$18);
      return cTLineNumber;
    } 
  }
  
  public void unsetLnNumType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNNUMTYPE$18, 0);
    } 
  }
  
  public CTPageNumber getPgNumType() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageNumber cTPageNumber = null;
      cTPageNumber = (CTPageNumber)get_store().find_element_user(PGNUMTYPE$20, 0);
      if (cTPageNumber == null)
        return null; 
      return cTPageNumber;
    } 
  }
  
  public boolean isSetPgNumType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PGNUMTYPE$20) != 0);
    } 
  }
  
  public void setPgNumType(CTPageNumber paramCTPageNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageNumber cTPageNumber = null;
      cTPageNumber = (CTPageNumber)get_store().find_element_user(PGNUMTYPE$20, 0);
      if (cTPageNumber == null)
        cTPageNumber = (CTPageNumber)get_store().add_element_user(PGNUMTYPE$20); 
      cTPageNumber.set((XmlObject)paramCTPageNumber);
    } 
  }
  
  public CTPageNumber addNewPgNumType() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageNumber cTPageNumber = null;
      cTPageNumber = (CTPageNumber)get_store().add_element_user(PGNUMTYPE$20);
      return cTPageNumber;
    } 
  }
  
  public void unsetPgNumType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PGNUMTYPE$20, 0);
    } 
  }
  
  public CTColumns getCols() {
    synchronized (monitor()) {
      check_orphaned();
      CTColumns cTColumns = null;
      cTColumns = (CTColumns)get_store().find_element_user(COLS$22, 0);
      if (cTColumns == null)
        return null; 
      return cTColumns;
    } 
  }
  
  public boolean isSetCols() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLS$22) != 0);
    } 
  }
  
  public void setCols(CTColumns paramCTColumns) {
    synchronized (monitor()) {
      check_orphaned();
      CTColumns cTColumns = null;
      cTColumns = (CTColumns)get_store().find_element_user(COLS$22, 0);
      if (cTColumns == null)
        cTColumns = (CTColumns)get_store().add_element_user(COLS$22); 
      cTColumns.set((XmlObject)paramCTColumns);
    } 
  }
  
  public CTColumns addNewCols() {
    synchronized (monitor()) {
      check_orphaned();
      CTColumns cTColumns = null;
      cTColumns = (CTColumns)get_store().add_element_user(COLS$22);
      return cTColumns;
    } 
  }
  
  public void unsetCols() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLS$22, 0);
    } 
  }
  
  public CTOnOff getFormProt() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(FORMPROT$24, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetFormProt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FORMPROT$24) != 0);
    } 
  }
  
  public void setFormProt(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(FORMPROT$24, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(FORMPROT$24); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewFormProt() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(FORMPROT$24);
      return cTOnOff;
    } 
  }
  
  public void unsetFormProt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORMPROT$24, 0);
    } 
  }
  
  public CTVerticalJc getVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalJc cTVerticalJc = null;
      cTVerticalJc = (CTVerticalJc)get_store().find_element_user(VALIGN$26, 0);
      if (cTVerticalJc == null)
        return null; 
      return cTVerticalJc;
    } 
  }
  
  public boolean isSetVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VALIGN$26) != 0);
    } 
  }
  
  public void setVAlign(CTVerticalJc paramCTVerticalJc) {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalJc cTVerticalJc = null;
      cTVerticalJc = (CTVerticalJc)get_store().find_element_user(VALIGN$26, 0);
      if (cTVerticalJc == null)
        cTVerticalJc = (CTVerticalJc)get_store().add_element_user(VALIGN$26); 
      cTVerticalJc.set((XmlObject)paramCTVerticalJc);
    } 
  }
  
  public CTVerticalJc addNewVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalJc cTVerticalJc = null;
      cTVerticalJc = (CTVerticalJc)get_store().add_element_user(VALIGN$26);
      return cTVerticalJc;
    } 
  }
  
  public void unsetVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VALIGN$26, 0);
    } 
  }
  
  public CTOnOff getNoEndnote() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOENDNOTE$28, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetNoEndnote() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOENDNOTE$28) != 0);
    } 
  }
  
  public void setNoEndnote(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOENDNOTE$28, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(NOENDNOTE$28); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewNoEndnote() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(NOENDNOTE$28);
      return cTOnOff;
    } 
  }
  
  public void unsetNoEndnote() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOENDNOTE$28, 0);
    } 
  }
  
  public CTOnOff getTitlePg() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TITLEPG$30, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetTitlePg() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TITLEPG$30) != 0);
    } 
  }
  
  public void setTitlePg(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TITLEPG$30, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(TITLEPG$30); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewTitlePg() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(TITLEPG$30);
      return cTOnOff;
    } 
  }
  
  public void unsetTitlePg() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TITLEPG$30, 0);
    } 
  }
  
  public CTTextDirection getTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().find_element_user(TEXTDIRECTION$32, 0);
      if (cTTextDirection == null)
        return null; 
      return cTTextDirection;
    } 
  }
  
  public boolean isSetTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TEXTDIRECTION$32) != 0);
    } 
  }
  
  public void setTextDirection(CTTextDirection paramCTTextDirection) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().find_element_user(TEXTDIRECTION$32, 0);
      if (cTTextDirection == null)
        cTTextDirection = (CTTextDirection)get_store().add_element_user(TEXTDIRECTION$32); 
      cTTextDirection.set((XmlObject)paramCTTextDirection);
    } 
  }
  
  public CTTextDirection addNewTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().add_element_user(TEXTDIRECTION$32);
      return cTTextDirection;
    } 
  }
  
  public void unsetTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTDIRECTION$32, 0);
    } 
  }
  
  public CTOnOff getBidi() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BIDI$34, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBidi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BIDI$34) != 0);
    } 
  }
  
  public void setBidi(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BIDI$34, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BIDI$34); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBidi() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BIDI$34);
      return cTOnOff;
    } 
  }
  
  public void unsetBidi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BIDI$34, 0);
    } 
  }
  
  public CTOnOff getRtlGutter() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(RTLGUTTER$36, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetRtlGutter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RTLGUTTER$36) != 0);
    } 
  }
  
  public void setRtlGutter(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(RTLGUTTER$36, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(RTLGUTTER$36); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewRtlGutter() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(RTLGUTTER$36);
      return cTOnOff;
    } 
  }
  
  public void unsetRtlGutter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RTLGUTTER$36, 0);
    } 
  }
  
  public CTDocGrid getDocGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocGrid cTDocGrid = null;
      cTDocGrid = (CTDocGrid)get_store().find_element_user(DOCGRID$38, 0);
      if (cTDocGrid == null)
        return null; 
      return cTDocGrid;
    } 
  }
  
  public boolean isSetDocGrid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCGRID$38) != 0);
    } 
  }
  
  public void setDocGrid(CTDocGrid paramCTDocGrid) {
    synchronized (monitor()) {
      check_orphaned();
      CTDocGrid cTDocGrid = null;
      cTDocGrid = (CTDocGrid)get_store().find_element_user(DOCGRID$38, 0);
      if (cTDocGrid == null)
        cTDocGrid = (CTDocGrid)get_store().add_element_user(DOCGRID$38); 
      cTDocGrid.set((XmlObject)paramCTDocGrid);
    } 
  }
  
  public CTDocGrid addNewDocGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocGrid cTDocGrid = null;
      cTDocGrid = (CTDocGrid)get_store().add_element_user(DOCGRID$38);
      return cTDocGrid;
    } 
  }
  
  public void unsetDocGrid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCGRID$38, 0);
    } 
  }
  
  public CTRel getPrinterSettings() {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().find_element_user(PRINTERSETTINGS$40, 0);
      if (cTRel == null)
        return null; 
      return cTRel;
    } 
  }
  
  public boolean isSetPrinterSettings() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRINTERSETTINGS$40) != 0);
    } 
  }
  
  public void setPrinterSettings(CTRel paramCTRel) {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().find_element_user(PRINTERSETTINGS$40, 0);
      if (cTRel == null)
        cTRel = (CTRel)get_store().add_element_user(PRINTERSETTINGS$40); 
      cTRel.set((XmlObject)paramCTRel);
    } 
  }
  
  public CTRel addNewPrinterSettings() {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().add_element_user(PRINTERSETTINGS$40);
      return cTRel;
    } 
  }
  
  public void unsetPrinterSettings() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTERSETTINGS$40, 0);
    } 
  }
  
  public CTSectPrChange getSectPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPrChange cTSectPrChange = null;
      cTSectPrChange = (CTSectPrChange)get_store().find_element_user(SECTPRCHANGE$42, 0);
      if (cTSectPrChange == null)
        return null; 
      return cTSectPrChange;
    } 
  }
  
  public boolean isSetSectPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SECTPRCHANGE$42) != 0);
    } 
  }
  
  public void setSectPrChange(CTSectPrChange paramCTSectPrChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPrChange cTSectPrChange = null;
      cTSectPrChange = (CTSectPrChange)get_store().find_element_user(SECTPRCHANGE$42, 0);
      if (cTSectPrChange == null)
        cTSectPrChange = (CTSectPrChange)get_store().add_element_user(SECTPRCHANGE$42); 
      cTSectPrChange.set((XmlObject)paramCTSectPrChange);
    } 
  }
  
  public CTSectPrChange addNewSectPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPrChange cTSectPrChange = null;
      cTSectPrChange = (CTSectPrChange)get_store().add_element_user(SECTPRCHANGE$42);
      return cTSectPrChange;
    } 
  }
  
  public void unsetSectPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SECTPRCHANGE$42, 0);
    } 
  }
  
  public byte[] getRsidRPr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDRPR$44);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetRsidRPr() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDRPR$44);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetRsidRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RSIDRPR$44) != null);
    } 
  }
  
  public void setRsidRPr(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDRPR$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RSIDRPR$44); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRsidRPr(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDRPR$44);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(RSIDRPR$44); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetRsidRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RSIDRPR$44);
    } 
  }
  
  public byte[] getRsidDel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDDEL$46);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetRsidDel() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDDEL$46);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetRsidDel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RSIDDEL$46) != null);
    } 
  }
  
  public void setRsidDel(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDDEL$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RSIDDEL$46); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRsidDel(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDDEL$46);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(RSIDDEL$46); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetRsidDel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RSIDDEL$46);
    } 
  }
  
  public byte[] getRsidR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDR$48);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetRsidR() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDR$48);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetRsidR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RSIDR$48) != null);
    } 
  }
  
  public void setRsidR(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDR$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RSIDR$48); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRsidR(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDR$48);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(RSIDR$48); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetRsidR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RSIDR$48);
    } 
  }
  
  public byte[] getRsidSect() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDSECT$50);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetRsidSect() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDSECT$50);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetRsidSect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RSIDSECT$50) != null);
    } 
  }
  
  public void setRsidSect(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RSIDSECT$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RSIDSECT$50); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRsidSect(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(RSIDSECT$50);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(RSIDSECT$50); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetRsidSect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RSIDSECT$50);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSectPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */