package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase;

public class CTTrPrBaseImpl extends XmlComplexContentImpl implements CTTrPrBase {
  private static final b CNFSTYLE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle");
  
  private static final b DIVID$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "divId");
  
  private static final b GRIDBEFORE$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridBefore");
  
  private static final b GRIDAFTER$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridAfter");
  
  private static final b WBEFORE$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wBefore");
  
  private static final b WAFTER$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wAfter");
  
  private static final b CANTSPLIT$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cantSplit");
  
  private static final b TRHEIGHT$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trHeight");
  
  private static final b TBLHEADER$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblHeader");
  
  private static final b TBLCELLSPACING$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing");
  
  private static final b JC$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
  
  private static final b HIDDEN$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hidden");
  
  public CTTrPrBaseImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCnf> getCnfStyleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCnf>)new CnfStyleList(this);
    } 
  }
  
  public CTCnf[] getCnfStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CNFSTYLE$0, arrayList);
      CTCnf[] arrayOfCTCnf = new CTCnf[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCnf);
      return arrayOfCTCnf;
    } 
  }
  
  public CTCnf getCnfStyleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().find_element_user(CNFSTYLE$0, paramInt);
      if (cTCnf == null)
        throw new IndexOutOfBoundsException(); 
      return cTCnf;
    } 
  }
  
  public int sizeOfCnfStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CNFSTYLE$0);
    } 
  }
  
  public void setCnfStyleArray(CTCnf[] paramArrayOfCTCnf) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCnf, CNFSTYLE$0);
    } 
  }
  
  public void setCnfStyleArray(int paramInt, CTCnf paramCTCnf) {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().find_element_user(CNFSTYLE$0, paramInt);
      if (cTCnf == null)
        throw new IndexOutOfBoundsException(); 
      cTCnf.set((XmlObject)paramCTCnf);
    } 
  }
  
  public CTCnf insertNewCnfStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().insert_element_user(CNFSTYLE$0, paramInt);
      return cTCnf;
    } 
  }
  
  public CTCnf addNewCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().add_element_user(CNFSTYLE$0);
      return cTCnf;
    } 
  }
  
  public void removeCnfStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CNFSTYLE$0, paramInt);
    } 
  }
  
  public List<CTDecimalNumber> getDivIdList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDecimalNumber>)new DivIdList(this);
    } 
  }
  
  public CTDecimalNumber[] getDivIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DIVID$2, arrayList);
      CTDecimalNumber[] arrayOfCTDecimalNumber = new CTDecimalNumber[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDecimalNumber);
      return arrayOfCTDecimalNumber;
    } 
  }
  
  public CTDecimalNumber getDivIdArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(DIVID$2, paramInt);
      if (cTDecimalNumber == null)
        throw new IndexOutOfBoundsException(); 
      return cTDecimalNumber;
    } 
  }
  
  public int sizeOfDivIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DIVID$2);
    } 
  }
  
  public void setDivIdArray(CTDecimalNumber[] paramArrayOfCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDecimalNumber, DIVID$2);
    } 
  }
  
  public void setDivIdArray(int paramInt, CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(DIVID$2, paramInt);
      if (cTDecimalNumber == null)
        throw new IndexOutOfBoundsException(); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber insertNewDivId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().insert_element_user(DIVID$2, paramInt);
      return cTDecimalNumber;
    } 
  }
  
  public CTDecimalNumber addNewDivId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(DIVID$2);
      return cTDecimalNumber;
    } 
  }
  
  public void removeDivId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DIVID$2, paramInt);
    } 
  }
  
  public List<CTDecimalNumber> getGridBeforeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDecimalNumber>)new GridBeforeList(this);
    } 
  }
  
  public CTDecimalNumber[] getGridBeforeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRIDBEFORE$4, arrayList);
      CTDecimalNumber[] arrayOfCTDecimalNumber = new CTDecimalNumber[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDecimalNumber);
      return arrayOfCTDecimalNumber;
    } 
  }
  
  public CTDecimalNumber getGridBeforeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(GRIDBEFORE$4, paramInt);
      if (cTDecimalNumber == null)
        throw new IndexOutOfBoundsException(); 
      return cTDecimalNumber;
    } 
  }
  
  public int sizeOfGridBeforeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRIDBEFORE$4);
    } 
  }
  
  public void setGridBeforeArray(CTDecimalNumber[] paramArrayOfCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDecimalNumber, GRIDBEFORE$4);
    } 
  }
  
  public void setGridBeforeArray(int paramInt, CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(GRIDBEFORE$4, paramInt);
      if (cTDecimalNumber == null)
        throw new IndexOutOfBoundsException(); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber insertNewGridBefore(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().insert_element_user(GRIDBEFORE$4, paramInt);
      return cTDecimalNumber;
    } 
  }
  
  public CTDecimalNumber addNewGridBefore() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(GRIDBEFORE$4);
      return cTDecimalNumber;
    } 
  }
  
  public void removeGridBefore(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRIDBEFORE$4, paramInt);
    } 
  }
  
  public List<CTDecimalNumber> getGridAfterList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDecimalNumber>)new GridAfterList(this);
    } 
  }
  
  public CTDecimalNumber[] getGridAfterArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRIDAFTER$6, arrayList);
      CTDecimalNumber[] arrayOfCTDecimalNumber = new CTDecimalNumber[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDecimalNumber);
      return arrayOfCTDecimalNumber;
    } 
  }
  
  public CTDecimalNumber getGridAfterArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(GRIDAFTER$6, paramInt);
      if (cTDecimalNumber == null)
        throw new IndexOutOfBoundsException(); 
      return cTDecimalNumber;
    } 
  }
  
  public int sizeOfGridAfterArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRIDAFTER$6);
    } 
  }
  
  public void setGridAfterArray(CTDecimalNumber[] paramArrayOfCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDecimalNumber, GRIDAFTER$6);
    } 
  }
  
  public void setGridAfterArray(int paramInt, CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(GRIDAFTER$6, paramInt);
      if (cTDecimalNumber == null)
        throw new IndexOutOfBoundsException(); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber insertNewGridAfter(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().insert_element_user(GRIDAFTER$6, paramInt);
      return cTDecimalNumber;
    } 
  }
  
  public CTDecimalNumber addNewGridAfter() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(GRIDAFTER$6);
      return cTDecimalNumber;
    } 
  }
  
  public void removeGridAfter(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRIDAFTER$6, paramInt);
    } 
  }
  
  public List<CTTblWidth> getWBeforeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTblWidth>)new WBeforeList(this);
    } 
  }
  
  public CTTblWidth[] getWBeforeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(WBEFORE$8, arrayList);
      CTTblWidth[] arrayOfCTTblWidth = new CTTblWidth[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTblWidth);
      return arrayOfCTTblWidth;
    } 
  }
  
  public CTTblWidth getWBeforeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(WBEFORE$8, paramInt);
      if (cTTblWidth == null)
        throw new IndexOutOfBoundsException(); 
      return cTTblWidth;
    } 
  }
  
  public int sizeOfWBeforeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(WBEFORE$8);
    } 
  }
  
  public void setWBeforeArray(CTTblWidth[] paramArrayOfCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTblWidth, WBEFORE$8);
    } 
  }
  
  public void setWBeforeArray(int paramInt, CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(WBEFORE$8, paramInt);
      if (cTTblWidth == null)
        throw new IndexOutOfBoundsException(); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth insertNewWBefore(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().insert_element_user(WBEFORE$8, paramInt);
      return cTTblWidth;
    } 
  }
  
  public CTTblWidth addNewWBefore() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(WBEFORE$8);
      return cTTblWidth;
    } 
  }
  
  public void removeWBefore(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WBEFORE$8, paramInt);
    } 
  }
  
  public List<CTTblWidth> getWAfterList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTblWidth>)new WAfterList(this);
    } 
  }
  
  public CTTblWidth[] getWAfterArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(WAFTER$10, arrayList);
      CTTblWidth[] arrayOfCTTblWidth = new CTTblWidth[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTblWidth);
      return arrayOfCTTblWidth;
    } 
  }
  
  public CTTblWidth getWAfterArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(WAFTER$10, paramInt);
      if (cTTblWidth == null)
        throw new IndexOutOfBoundsException(); 
      return cTTblWidth;
    } 
  }
  
  public int sizeOfWAfterArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(WAFTER$10);
    } 
  }
  
  public void setWAfterArray(CTTblWidth[] paramArrayOfCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTblWidth, WAFTER$10);
    } 
  }
  
  public void setWAfterArray(int paramInt, CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(WAFTER$10, paramInt);
      if (cTTblWidth == null)
        throw new IndexOutOfBoundsException(); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth insertNewWAfter(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().insert_element_user(WAFTER$10, paramInt);
      return cTTblWidth;
    } 
  }
  
  public CTTblWidth addNewWAfter() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(WAFTER$10);
      return cTTblWidth;
    } 
  }
  
  public void removeWAfter(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WAFTER$10, paramInt);
    } 
  }
  
  public List<CTOnOff> getCantSplitList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOnOff>)new CantSplitList(this);
    } 
  }
  
  public CTOnOff[] getCantSplitArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CANTSPLIT$12, arrayList);
      CTOnOff[] arrayOfCTOnOff = new CTOnOff[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOnOff);
      return arrayOfCTOnOff;
    } 
  }
  
  public CTOnOff getCantSplitArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CANTSPLIT$12, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      return cTOnOff;
    } 
  }
  
  public int sizeOfCantSplitArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CANTSPLIT$12);
    } 
  }
  
  public void setCantSplitArray(CTOnOff[] paramArrayOfCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOnOff, CANTSPLIT$12);
    } 
  }
  
  public void setCantSplitArray(int paramInt, CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CANTSPLIT$12, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff insertNewCantSplit(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().insert_element_user(CANTSPLIT$12, paramInt);
      return cTOnOff;
    } 
  }
  
  public CTOnOff addNewCantSplit() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(CANTSPLIT$12);
      return cTOnOff;
    } 
  }
  
  public void removeCantSplit(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CANTSPLIT$12, paramInt);
    } 
  }
  
  public List<CTHeight> getTrHeightList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTHeight>)new TrHeightList(this);
    } 
  }
  
  public CTHeight[] getTrHeightArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TRHEIGHT$14, arrayList);
      CTHeight[] arrayOfCTHeight = new CTHeight[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTHeight);
      return arrayOfCTHeight;
    } 
  }
  
  public CTHeight getTrHeightArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeight cTHeight = null;
      cTHeight = (CTHeight)get_store().find_element_user(TRHEIGHT$14, paramInt);
      if (cTHeight == null)
        throw new IndexOutOfBoundsException(); 
      return cTHeight;
    } 
  }
  
  public int sizeOfTrHeightArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TRHEIGHT$14);
    } 
  }
  
  public void setTrHeightArray(CTHeight[] paramArrayOfCTHeight) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTHeight, TRHEIGHT$14);
    } 
  }
  
  public void setTrHeightArray(int paramInt, CTHeight paramCTHeight) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeight cTHeight = null;
      cTHeight = (CTHeight)get_store().find_element_user(TRHEIGHT$14, paramInt);
      if (cTHeight == null)
        throw new IndexOutOfBoundsException(); 
      cTHeight.set((XmlObject)paramCTHeight);
    } 
  }
  
  public CTHeight insertNewTrHeight(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeight cTHeight = null;
      cTHeight = (CTHeight)get_store().insert_element_user(TRHEIGHT$14, paramInt);
      return cTHeight;
    } 
  }
  
  public CTHeight addNewTrHeight() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeight cTHeight = null;
      cTHeight = (CTHeight)get_store().add_element_user(TRHEIGHT$14);
      return cTHeight;
    } 
  }
  
  public void removeTrHeight(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TRHEIGHT$14, paramInt);
    } 
  }
  
  public List<CTOnOff> getTblHeaderList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOnOff>)new TblHeaderList(this);
    } 
  }
  
  public CTOnOff[] getTblHeaderArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TBLHEADER$16, arrayList);
      CTOnOff[] arrayOfCTOnOff = new CTOnOff[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOnOff);
      return arrayOfCTOnOff;
    } 
  }
  
  public CTOnOff getTblHeaderArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TBLHEADER$16, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      return cTOnOff;
    } 
  }
  
  public int sizeOfTblHeaderArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TBLHEADER$16);
    } 
  }
  
  public void setTblHeaderArray(CTOnOff[] paramArrayOfCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOnOff, TBLHEADER$16);
    } 
  }
  
  public void setTblHeaderArray(int paramInt, CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TBLHEADER$16, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff insertNewTblHeader(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().insert_element_user(TBLHEADER$16, paramInt);
      return cTOnOff;
    } 
  }
  
  public CTOnOff addNewTblHeader() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(TBLHEADER$16);
      return cTOnOff;
    } 
  }
  
  public void removeTblHeader(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLHEADER$16, paramInt);
    } 
  }
  
  public List<CTTblWidth> getTblCellSpacingList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTblWidth>)new TblCellSpacingList(this);
    } 
  }
  
  public CTTblWidth[] getTblCellSpacingArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TBLCELLSPACING$18, arrayList);
      CTTblWidth[] arrayOfCTTblWidth = new CTTblWidth[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTblWidth);
      return arrayOfCTTblWidth;
    } 
  }
  
  public CTTblWidth getTblCellSpacingArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLCELLSPACING$18, paramInt);
      if (cTTblWidth == null)
        throw new IndexOutOfBoundsException(); 
      return cTTblWidth;
    } 
  }
  
  public int sizeOfTblCellSpacingArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TBLCELLSPACING$18);
    } 
  }
  
  public void setTblCellSpacingArray(CTTblWidth[] paramArrayOfCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTblWidth, TBLCELLSPACING$18);
    } 
  }
  
  public void setTblCellSpacingArray(int paramInt, CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLCELLSPACING$18, paramInt);
      if (cTTblWidth == null)
        throw new IndexOutOfBoundsException(); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth insertNewTblCellSpacing(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().insert_element_user(TBLCELLSPACING$18, paramInt);
      return cTTblWidth;
    } 
  }
  
  public CTTblWidth addNewTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLCELLSPACING$18);
      return cTTblWidth;
    } 
  }
  
  public void removeTblCellSpacing(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLCELLSPACING$18, paramInt);
    } 
  }
  
  public List<CTJc> getJcList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTJc>)new JcList(this);
    } 
  }
  
  public CTJc[] getJcArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(JC$20, arrayList);
      CTJc[] arrayOfCTJc = new CTJc[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTJc);
      return arrayOfCTJc;
    } 
  }
  
  public CTJc getJcArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(JC$20, paramInt);
      if (cTJc == null)
        throw new IndexOutOfBoundsException(); 
      return cTJc;
    } 
  }
  
  public int sizeOfJcArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(JC$20);
    } 
  }
  
  public void setJcArray(CTJc[] paramArrayOfCTJc) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTJc, JC$20);
    } 
  }
  
  public void setJcArray(int paramInt, CTJc paramCTJc) {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(JC$20, paramInt);
      if (cTJc == null)
        throw new IndexOutOfBoundsException(); 
      cTJc.set((XmlObject)paramCTJc);
    } 
  }
  
  public CTJc insertNewJc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().insert_element_user(JC$20, paramInt);
      return cTJc;
    } 
  }
  
  public CTJc addNewJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().add_element_user(JC$20);
      return cTJc;
    } 
  }
  
  public void removeJc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(JC$20, paramInt);
    } 
  }
  
  public List<CTOnOff> getHiddenList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOnOff>)new HiddenList(this);
    } 
  }
  
  public CTOnOff[] getHiddenArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HIDDEN$22, arrayList);
      CTOnOff[] arrayOfCTOnOff = new CTOnOff[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOnOff);
      return arrayOfCTOnOff;
    } 
  }
  
  public CTOnOff getHiddenArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDDEN$22, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      return cTOnOff;
    } 
  }
  
  public int sizeOfHiddenArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HIDDEN$22);
    } 
  }
  
  public void setHiddenArray(CTOnOff[] paramArrayOfCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOnOff, HIDDEN$22);
    } 
  }
  
  public void setHiddenArray(int paramInt, CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDDEN$22, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff insertNewHidden(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().insert_element_user(HIDDEN$22, paramInt);
      return cTOnOff;
    } 
  }
  
  public CTOnOff addNewHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(HIDDEN$22);
      return cTOnOff;
    } 
  }
  
  public void removeHidden(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIDDEN$22, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTrPrBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */