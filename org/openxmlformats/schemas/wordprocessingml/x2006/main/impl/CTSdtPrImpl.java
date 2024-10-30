package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDataBinding;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDropDownList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;

public class CTSdtPrImpl extends XmlComplexContentImpl implements CTSdtPr {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
  
  private static final b ALIAS$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alias");
  
  private static final b LOCK$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lock");
  
  private static final b PLACEHOLDER$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "placeholder");
  
  private static final b SHOWINGPLCHDR$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "showingPlcHdr");
  
  private static final b DATABINDING$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dataBinding");
  
  private static final b TEMPORARY$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "temporary");
  
  private static final b ID$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "id");
  
  private static final b TAG$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tag");
  
  private static final b EQUATION$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "equation");
  
  private static final b COMBOBOX$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "comboBox");
  
  private static final b DATE$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "date");
  
  private static final b DOCPARTOBJ$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartObj");
  
  private static final b DOCPARTLIST$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartList");
  
  private static final b DROPDOWNLIST$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dropDownList");
  
  private static final b PICTURE$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "picture");
  
  private static final b RICHTEXT$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "richText");
  
  private static final b TEXT$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "text");
  
  private static final b CITATION$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "citation");
  
  private static final b GROUP$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "group");
  
  private static final b BIBLIOGRAPHY$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bibliography");
  
  public CTSdtPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTRPr> getRPrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRPr>)new RPrList(this);
    } 
  }
  
  public CTRPr[] getRPrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RPR$0, arrayList);
      CTRPr[] arrayOfCTRPr = new CTRPr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRPr);
      return arrayOfCTRPr;
    } 
  }
  
  public CTRPr getRPrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$0, paramInt);
      if (cTRPr == null)
        throw new IndexOutOfBoundsException(); 
      return cTRPr;
    } 
  }
  
  public int sizeOfRPrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RPR$0);
    } 
  }
  
  public void setRPrArray(CTRPr[] paramArrayOfCTRPr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRPr, RPR$0);
    } 
  }
  
  public void setRPrArray(int paramInt, CTRPr paramCTRPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$0, paramInt);
      if (cTRPr == null)
        throw new IndexOutOfBoundsException(); 
      cTRPr.set((XmlObject)paramCTRPr);
    } 
  }
  
  public CTRPr insertNewRPr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().insert_element_user(RPR$0, paramInt);
      return cTRPr;
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
  
  public void removeRPr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$0, paramInt);
    } 
  }
  
  public List<CTString> getAliasList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTString>)new AliasList(this);
    } 
  }
  
  public CTString[] getAliasArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALIAS$2, arrayList);
      CTString[] arrayOfCTString = new CTString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTString);
      return arrayOfCTString;
    } 
  }
  
  public CTString getAliasArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(ALIAS$2, paramInt);
      if (cTString == null)
        throw new IndexOutOfBoundsException(); 
      return cTString;
    } 
  }
  
  public int sizeOfAliasArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALIAS$2);
    } 
  }
  
  public void setAliasArray(CTString[] paramArrayOfCTString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTString, ALIAS$2);
    } 
  }
  
  public void setAliasArray(int paramInt, CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(ALIAS$2, paramInt);
      if (cTString == null)
        throw new IndexOutOfBoundsException(); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString insertNewAlias(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().insert_element_user(ALIAS$2, paramInt);
      return cTString;
    } 
  }
  
  public CTString addNewAlias() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(ALIAS$2);
      return cTString;
    } 
  }
  
  public void removeAlias(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALIAS$2, paramInt);
    } 
  }
  
  public List<CTLock> getLockList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLock>)new LockList(this);
    } 
  }
  
  public CTLock[] getLockArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LOCK$4, arrayList);
      CTLock[] arrayOfCTLock = new CTLock[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLock);
      return arrayOfCTLock;
    } 
  }
  
  public CTLock getLockArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLock cTLock = null;
      cTLock = (CTLock)get_store().find_element_user(LOCK$4, paramInt);
      if (cTLock == null)
        throw new IndexOutOfBoundsException(); 
      return cTLock;
    } 
  }
  
  public int sizeOfLockArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LOCK$4);
    } 
  }
  
  public void setLockArray(CTLock[] paramArrayOfCTLock) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLock, LOCK$4);
    } 
  }
  
  public void setLockArray(int paramInt, CTLock paramCTLock) {
    synchronized (monitor()) {
      check_orphaned();
      CTLock cTLock = null;
      cTLock = (CTLock)get_store().find_element_user(LOCK$4, paramInt);
      if (cTLock == null)
        throw new IndexOutOfBoundsException(); 
      cTLock.set((XmlObject)paramCTLock);
    } 
  }
  
  public CTLock insertNewLock(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLock cTLock = null;
      cTLock = (CTLock)get_store().insert_element_user(LOCK$4, paramInt);
      return cTLock;
    } 
  }
  
  public CTLock addNewLock() {
    synchronized (monitor()) {
      check_orphaned();
      CTLock cTLock = null;
      cTLock = (CTLock)get_store().add_element_user(LOCK$4);
      return cTLock;
    } 
  }
  
  public void removeLock(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LOCK$4, paramInt);
    } 
  }
  
  public List<CTPlaceholder> getPlaceholderList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPlaceholder>)new PlaceholderList(this);
    } 
  }
  
  public CTPlaceholder[] getPlaceholderArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PLACEHOLDER$6, arrayList);
      CTPlaceholder[] arrayOfCTPlaceholder = new CTPlaceholder[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPlaceholder);
      return arrayOfCTPlaceholder;
    } 
  }
  
  public CTPlaceholder getPlaceholderArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPlaceholder cTPlaceholder = null;
      cTPlaceholder = (CTPlaceholder)get_store().find_element_user(PLACEHOLDER$6, paramInt);
      if (cTPlaceholder == null)
        throw new IndexOutOfBoundsException(); 
      return cTPlaceholder;
    } 
  }
  
  public int sizeOfPlaceholderArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PLACEHOLDER$6);
    } 
  }
  
  public void setPlaceholderArray(CTPlaceholder[] paramArrayOfCTPlaceholder) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPlaceholder, PLACEHOLDER$6);
    } 
  }
  
  public void setPlaceholderArray(int paramInt, CTPlaceholder paramCTPlaceholder) {
    synchronized (monitor()) {
      check_orphaned();
      CTPlaceholder cTPlaceholder = null;
      cTPlaceholder = (CTPlaceholder)get_store().find_element_user(PLACEHOLDER$6, paramInt);
      if (cTPlaceholder == null)
        throw new IndexOutOfBoundsException(); 
      cTPlaceholder.set((XmlObject)paramCTPlaceholder);
    } 
  }
  
  public CTPlaceholder insertNewPlaceholder(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPlaceholder cTPlaceholder = null;
      cTPlaceholder = (CTPlaceholder)get_store().insert_element_user(PLACEHOLDER$6, paramInt);
      return cTPlaceholder;
    } 
  }
  
  public CTPlaceholder addNewPlaceholder() {
    synchronized (monitor()) {
      check_orphaned();
      CTPlaceholder cTPlaceholder = null;
      cTPlaceholder = (CTPlaceholder)get_store().add_element_user(PLACEHOLDER$6);
      return cTPlaceholder;
    } 
  }
  
  public void removePlaceholder(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PLACEHOLDER$6, paramInt);
    } 
  }
  
  public List<CTOnOff> getShowingPlcHdrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOnOff>)new ShowingPlcHdrList(this);
    } 
  }
  
  public CTOnOff[] getShowingPlcHdrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHOWINGPLCHDR$8, arrayList);
      CTOnOff[] arrayOfCTOnOff = new CTOnOff[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOnOff);
      return arrayOfCTOnOff;
    } 
  }
  
  public CTOnOff getShowingPlcHdrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHOWINGPLCHDR$8, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      return cTOnOff;
    } 
  }
  
  public int sizeOfShowingPlcHdrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHOWINGPLCHDR$8);
    } 
  }
  
  public void setShowingPlcHdrArray(CTOnOff[] paramArrayOfCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOnOff, SHOWINGPLCHDR$8);
    } 
  }
  
  public void setShowingPlcHdrArray(int paramInt, CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHOWINGPLCHDR$8, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff insertNewShowingPlcHdr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().insert_element_user(SHOWINGPLCHDR$8, paramInt);
      return cTOnOff;
    } 
  }
  
  public CTOnOff addNewShowingPlcHdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SHOWINGPLCHDR$8);
      return cTOnOff;
    } 
  }
  
  public void removeShowingPlcHdr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHOWINGPLCHDR$8, paramInt);
    } 
  }
  
  public List<CTDataBinding> getDataBindingList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDataBinding>)new DataBindingList(this);
    } 
  }
  
  public CTDataBinding[] getDataBindingArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DATABINDING$10, arrayList);
      CTDataBinding[] arrayOfCTDataBinding = new CTDataBinding[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDataBinding);
      return arrayOfCTDataBinding;
    } 
  }
  
  public CTDataBinding getDataBindingArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBinding cTDataBinding = null;
      cTDataBinding = (CTDataBinding)get_store().find_element_user(DATABINDING$10, paramInt);
      if (cTDataBinding == null)
        throw new IndexOutOfBoundsException(); 
      return cTDataBinding;
    } 
  }
  
  public int sizeOfDataBindingArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DATABINDING$10);
    } 
  }
  
  public void setDataBindingArray(CTDataBinding[] paramArrayOfCTDataBinding) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDataBinding, DATABINDING$10);
    } 
  }
  
  public void setDataBindingArray(int paramInt, CTDataBinding paramCTDataBinding) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBinding cTDataBinding = null;
      cTDataBinding = (CTDataBinding)get_store().find_element_user(DATABINDING$10, paramInt);
      if (cTDataBinding == null)
        throw new IndexOutOfBoundsException(); 
      cTDataBinding.set((XmlObject)paramCTDataBinding);
    } 
  }
  
  public CTDataBinding insertNewDataBinding(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBinding cTDataBinding = null;
      cTDataBinding = (CTDataBinding)get_store().insert_element_user(DATABINDING$10, paramInt);
      return cTDataBinding;
    } 
  }
  
  public CTDataBinding addNewDataBinding() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBinding cTDataBinding = null;
      cTDataBinding = (CTDataBinding)get_store().add_element_user(DATABINDING$10);
      return cTDataBinding;
    } 
  }
  
  public void removeDataBinding(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATABINDING$10, paramInt);
    } 
  }
  
  public List<CTOnOff> getTemporaryList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOnOff>)new TemporaryList(this);
    } 
  }
  
  public CTOnOff[] getTemporaryArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TEMPORARY$12, arrayList);
      CTOnOff[] arrayOfCTOnOff = new CTOnOff[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOnOff);
      return arrayOfCTOnOff;
    } 
  }
  
  public CTOnOff getTemporaryArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TEMPORARY$12, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      return cTOnOff;
    } 
  }
  
  public int sizeOfTemporaryArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TEMPORARY$12);
    } 
  }
  
  public void setTemporaryArray(CTOnOff[] paramArrayOfCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOnOff, TEMPORARY$12);
    } 
  }
  
  public void setTemporaryArray(int paramInt, CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TEMPORARY$12, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff insertNewTemporary(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().insert_element_user(TEMPORARY$12, paramInt);
      return cTOnOff;
    } 
  }
  
  public CTOnOff addNewTemporary() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(TEMPORARY$12);
      return cTOnOff;
    } 
  }
  
  public void removeTemporary(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEMPORARY$12, paramInt);
    } 
  }
  
  public List<CTDecimalNumber> getIdList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDecimalNumber>)new IdList(this);
    } 
  }
  
  public CTDecimalNumber[] getIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ID$14, arrayList);
      CTDecimalNumber[] arrayOfCTDecimalNumber = new CTDecimalNumber[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDecimalNumber);
      return arrayOfCTDecimalNumber;
    } 
  }
  
  public CTDecimalNumber getIdArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(ID$14, paramInt);
      if (cTDecimalNumber == null)
        throw new IndexOutOfBoundsException(); 
      return cTDecimalNumber;
    } 
  }
  
  public int sizeOfIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ID$14);
    } 
  }
  
  public void setIdArray(CTDecimalNumber[] paramArrayOfCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDecimalNumber, ID$14);
    } 
  }
  
  public void setIdArray(int paramInt, CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(ID$14, paramInt);
      if (cTDecimalNumber == null)
        throw new IndexOutOfBoundsException(); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber insertNewId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().insert_element_user(ID$14, paramInt);
      return cTDecimalNumber;
    } 
  }
  
  public CTDecimalNumber addNewId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(ID$14);
      return cTDecimalNumber;
    } 
  }
  
  public void removeId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ID$14, paramInt);
    } 
  }
  
  public List<CTString> getTagList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTString>)new TagList(this);
    } 
  }
  
  public CTString[] getTagArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TAG$16, arrayList);
      CTString[] arrayOfCTString = new CTString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTString);
      return arrayOfCTString;
    } 
  }
  
  public CTString getTagArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(TAG$16, paramInt);
      if (cTString == null)
        throw new IndexOutOfBoundsException(); 
      return cTString;
    } 
  }
  
  public int sizeOfTagArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TAG$16);
    } 
  }
  
  public void setTagArray(CTString[] paramArrayOfCTString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTString, TAG$16);
    } 
  }
  
  public void setTagArray(int paramInt, CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(TAG$16, paramInt);
      if (cTString == null)
        throw new IndexOutOfBoundsException(); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString insertNewTag(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().insert_element_user(TAG$16, paramInt);
      return cTString;
    } 
  }
  
  public CTString addNewTag() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(TAG$16);
      return cTString;
    } 
  }
  
  public void removeTag(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TAG$16, paramInt);
    } 
  }
  
  public List<CTEmpty> getEquationList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new EquationList(this);
    } 
  }
  
  public CTEmpty[] getEquationArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(EQUATION$18, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getEquationArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(EQUATION$18, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfEquationArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(EQUATION$18);
    } 
  }
  
  public void setEquationArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, EQUATION$18);
    } 
  }
  
  public void setEquationArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(EQUATION$18, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewEquation(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(EQUATION$18, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewEquation() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(EQUATION$18);
      return cTEmpty;
    } 
  }
  
  public void removeEquation(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EQUATION$18, paramInt);
    } 
  }
  
  public List<CTSdtComboBox> getComboBoxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtComboBox>)new ComboBoxList(this);
    } 
  }
  
  public CTSdtComboBox[] getComboBoxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COMBOBOX$20, arrayList);
      CTSdtComboBox[] arrayOfCTSdtComboBox = new CTSdtComboBox[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtComboBox);
      return arrayOfCTSdtComboBox;
    } 
  }
  
  public CTSdtComboBox getComboBoxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtComboBox cTSdtComboBox = null;
      cTSdtComboBox = (CTSdtComboBox)get_store().find_element_user(COMBOBOX$20, paramInt);
      if (cTSdtComboBox == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtComboBox;
    } 
  }
  
  public int sizeOfComboBoxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COMBOBOX$20);
    } 
  }
  
  public void setComboBoxArray(CTSdtComboBox[] paramArrayOfCTSdtComboBox) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtComboBox, COMBOBOX$20);
    } 
  }
  
  public void setComboBoxArray(int paramInt, CTSdtComboBox paramCTSdtComboBox) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtComboBox cTSdtComboBox = null;
      cTSdtComboBox = (CTSdtComboBox)get_store().find_element_user(COMBOBOX$20, paramInt);
      if (cTSdtComboBox == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtComboBox.set((XmlObject)paramCTSdtComboBox);
    } 
  }
  
  public CTSdtComboBox insertNewComboBox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtComboBox cTSdtComboBox = null;
      cTSdtComboBox = (CTSdtComboBox)get_store().insert_element_user(COMBOBOX$20, paramInt);
      return cTSdtComboBox;
    } 
  }
  
  public CTSdtComboBox addNewComboBox() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtComboBox cTSdtComboBox = null;
      cTSdtComboBox = (CTSdtComboBox)get_store().add_element_user(COMBOBOX$20);
      return cTSdtComboBox;
    } 
  }
  
  public void removeComboBox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMBOBOX$20, paramInt);
    } 
  }
  
  public List<CTSdtDate> getDateList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtDate>)new DateList(this);
    } 
  }
  
  public CTSdtDate[] getDateArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DATE$22, arrayList);
      CTSdtDate[] arrayOfCTSdtDate = new CTSdtDate[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtDate);
      return arrayOfCTSdtDate;
    } 
  }
  
  public CTSdtDate getDateArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDate cTSdtDate = null;
      cTSdtDate = (CTSdtDate)get_store().find_element_user(DATE$22, paramInt);
      if (cTSdtDate == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtDate;
    } 
  }
  
  public int sizeOfDateArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DATE$22);
    } 
  }
  
  public void setDateArray(CTSdtDate[] paramArrayOfCTSdtDate) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtDate, DATE$22);
    } 
  }
  
  public void setDateArray(int paramInt, CTSdtDate paramCTSdtDate) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDate cTSdtDate = null;
      cTSdtDate = (CTSdtDate)get_store().find_element_user(DATE$22, paramInt);
      if (cTSdtDate == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtDate.set((XmlObject)paramCTSdtDate);
    } 
  }
  
  public CTSdtDate insertNewDate(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDate cTSdtDate = null;
      cTSdtDate = (CTSdtDate)get_store().insert_element_user(DATE$22, paramInt);
      return cTSdtDate;
    } 
  }
  
  public CTSdtDate addNewDate() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDate cTSdtDate = null;
      cTSdtDate = (CTSdtDate)get_store().add_element_user(DATE$22);
      return cTSdtDate;
    } 
  }
  
  public void removeDate(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATE$22, paramInt);
    } 
  }
  
  public List<CTSdtDocPart> getDocPartObjList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtDocPart>)new DocPartObjList(this);
    } 
  }
  
  public CTSdtDocPart[] getDocPartObjArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DOCPARTOBJ$24, arrayList);
      CTSdtDocPart[] arrayOfCTSdtDocPart = new CTSdtDocPart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtDocPart);
      return arrayOfCTSdtDocPart;
    } 
  }
  
  public CTSdtDocPart getDocPartObjArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDocPart cTSdtDocPart = null;
      cTSdtDocPart = (CTSdtDocPart)get_store().find_element_user(DOCPARTOBJ$24, paramInt);
      if (cTSdtDocPart == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtDocPart;
    } 
  }
  
  public int sizeOfDocPartObjArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DOCPARTOBJ$24);
    } 
  }
  
  public void setDocPartObjArray(CTSdtDocPart[] paramArrayOfCTSdtDocPart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtDocPart, DOCPARTOBJ$24);
    } 
  }
  
  public void setDocPartObjArray(int paramInt, CTSdtDocPart paramCTSdtDocPart) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDocPart cTSdtDocPart = null;
      cTSdtDocPart = (CTSdtDocPart)get_store().find_element_user(DOCPARTOBJ$24, paramInt);
      if (cTSdtDocPart == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtDocPart.set((XmlObject)paramCTSdtDocPart);
    } 
  }
  
  public CTSdtDocPart insertNewDocPartObj(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDocPart cTSdtDocPart = null;
      cTSdtDocPart = (CTSdtDocPart)get_store().insert_element_user(DOCPARTOBJ$24, paramInt);
      return cTSdtDocPart;
    } 
  }
  
  public CTSdtDocPart addNewDocPartObj() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDocPart cTSdtDocPart = null;
      cTSdtDocPart = (CTSdtDocPart)get_store().add_element_user(DOCPARTOBJ$24);
      return cTSdtDocPart;
    } 
  }
  
  public void removeDocPartObj(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCPARTOBJ$24, paramInt);
    } 
  }
  
  public List<CTSdtDocPart> getDocPartListList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtDocPart>)new DocPartListList(this);
    } 
  }
  
  public CTSdtDocPart[] getDocPartListArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DOCPARTLIST$26, arrayList);
      CTSdtDocPart[] arrayOfCTSdtDocPart = new CTSdtDocPart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtDocPart);
      return arrayOfCTSdtDocPart;
    } 
  }
  
  public CTSdtDocPart getDocPartListArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDocPart cTSdtDocPart = null;
      cTSdtDocPart = (CTSdtDocPart)get_store().find_element_user(DOCPARTLIST$26, paramInt);
      if (cTSdtDocPart == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtDocPart;
    } 
  }
  
  public int sizeOfDocPartListArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DOCPARTLIST$26);
    } 
  }
  
  public void setDocPartListArray(CTSdtDocPart[] paramArrayOfCTSdtDocPart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtDocPart, DOCPARTLIST$26);
    } 
  }
  
  public void setDocPartListArray(int paramInt, CTSdtDocPart paramCTSdtDocPart) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDocPart cTSdtDocPart = null;
      cTSdtDocPart = (CTSdtDocPart)get_store().find_element_user(DOCPARTLIST$26, paramInt);
      if (cTSdtDocPart == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtDocPart.set((XmlObject)paramCTSdtDocPart);
    } 
  }
  
  public CTSdtDocPart insertNewDocPartList(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDocPart cTSdtDocPart = null;
      cTSdtDocPart = (CTSdtDocPart)get_store().insert_element_user(DOCPARTLIST$26, paramInt);
      return cTSdtDocPart;
    } 
  }
  
  public CTSdtDocPart addNewDocPartList() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDocPart cTSdtDocPart = null;
      cTSdtDocPart = (CTSdtDocPart)get_store().add_element_user(DOCPARTLIST$26);
      return cTSdtDocPart;
    } 
  }
  
  public void removeDocPartList(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCPARTLIST$26, paramInt);
    } 
  }
  
  public List<CTSdtDropDownList> getDropDownListList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtDropDownList>)new DropDownListList(this);
    } 
  }
  
  public CTSdtDropDownList[] getDropDownListArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DROPDOWNLIST$28, arrayList);
      CTSdtDropDownList[] arrayOfCTSdtDropDownList = new CTSdtDropDownList[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtDropDownList);
      return arrayOfCTSdtDropDownList;
    } 
  }
  
  public CTSdtDropDownList getDropDownListArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDropDownList cTSdtDropDownList = null;
      cTSdtDropDownList = (CTSdtDropDownList)get_store().find_element_user(DROPDOWNLIST$28, paramInt);
      if (cTSdtDropDownList == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtDropDownList;
    } 
  }
  
  public int sizeOfDropDownListArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DROPDOWNLIST$28);
    } 
  }
  
  public void setDropDownListArray(CTSdtDropDownList[] paramArrayOfCTSdtDropDownList) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtDropDownList, DROPDOWNLIST$28);
    } 
  }
  
  public void setDropDownListArray(int paramInt, CTSdtDropDownList paramCTSdtDropDownList) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDropDownList cTSdtDropDownList = null;
      cTSdtDropDownList = (CTSdtDropDownList)get_store().find_element_user(DROPDOWNLIST$28, paramInt);
      if (cTSdtDropDownList == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtDropDownList.set((XmlObject)paramCTSdtDropDownList);
    } 
  }
  
  public CTSdtDropDownList insertNewDropDownList(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDropDownList cTSdtDropDownList = null;
      cTSdtDropDownList = (CTSdtDropDownList)get_store().insert_element_user(DROPDOWNLIST$28, paramInt);
      return cTSdtDropDownList;
    } 
  }
  
  public CTSdtDropDownList addNewDropDownList() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtDropDownList cTSdtDropDownList = null;
      cTSdtDropDownList = (CTSdtDropDownList)get_store().add_element_user(DROPDOWNLIST$28);
      return cTSdtDropDownList;
    } 
  }
  
  public void removeDropDownList(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DROPDOWNLIST$28, paramInt);
    } 
  }
  
  public List<CTEmpty> getPictureList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new PictureList(this);
    } 
  }
  
  public CTEmpty[] getPictureArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PICTURE$30, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getPictureArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(PICTURE$30, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfPictureArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PICTURE$30);
    } 
  }
  
  public void setPictureArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, PICTURE$30);
    } 
  }
  
  public void setPictureArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(PICTURE$30, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewPicture(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(PICTURE$30, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewPicture() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(PICTURE$30);
      return cTEmpty;
    } 
  }
  
  public void removePicture(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PICTURE$30, paramInt);
    } 
  }
  
  public List<CTEmpty> getRichTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new RichTextList(this);
    } 
  }
  
  public CTEmpty[] getRichTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RICHTEXT$32, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getRichTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(RICHTEXT$32, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfRichTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RICHTEXT$32);
    } 
  }
  
  public void setRichTextArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, RICHTEXT$32);
    } 
  }
  
  public void setRichTextArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(RICHTEXT$32, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewRichText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(RICHTEXT$32, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewRichText() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(RICHTEXT$32);
      return cTEmpty;
    } 
  }
  
  public void removeRichText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RICHTEXT$32, paramInt);
    } 
  }
  
  public List<CTSdtText> getTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSdtText>)new TextList(this);
    } 
  }
  
  public CTSdtText[] getTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TEXT$34, arrayList);
      CTSdtText[] arrayOfCTSdtText = new CTSdtText[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSdtText);
      return arrayOfCTSdtText;
    } 
  }
  
  public CTSdtText getTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtText cTSdtText = null;
      cTSdtText = (CTSdtText)get_store().find_element_user(TEXT$34, paramInt);
      if (cTSdtText == null)
        throw new IndexOutOfBoundsException(); 
      return cTSdtText;
    } 
  }
  
  public int sizeOfTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TEXT$34);
    } 
  }
  
  public void setTextArray(CTSdtText[] paramArrayOfCTSdtText) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSdtText, TEXT$34);
    } 
  }
  
  public void setTextArray(int paramInt, CTSdtText paramCTSdtText) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtText cTSdtText = null;
      cTSdtText = (CTSdtText)get_store().find_element_user(TEXT$34, paramInt);
      if (cTSdtText == null)
        throw new IndexOutOfBoundsException(); 
      cTSdtText.set((XmlObject)paramCTSdtText);
    } 
  }
  
  public CTSdtText insertNewText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtText cTSdtText = null;
      cTSdtText = (CTSdtText)get_store().insert_element_user(TEXT$34, paramInt);
      return cTSdtText;
    } 
  }
  
  public CTSdtText addNewText() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtText cTSdtText = null;
      cTSdtText = (CTSdtText)get_store().add_element_user(TEXT$34);
      return cTSdtText;
    } 
  }
  
  public void removeText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXT$34, paramInt);
    } 
  }
  
  public List<CTEmpty> getCitationList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new CitationList(this);
    } 
  }
  
  public CTEmpty[] getCitationArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CITATION$36, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getCitationArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(CITATION$36, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfCitationArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CITATION$36);
    } 
  }
  
  public void setCitationArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, CITATION$36);
    } 
  }
  
  public void setCitationArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(CITATION$36, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewCitation(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(CITATION$36, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewCitation() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(CITATION$36);
      return cTEmpty;
    } 
  }
  
  public void removeCitation(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CITATION$36, paramInt);
    } 
  }
  
  public List<CTEmpty> getGroupList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new GroupList(this);
    } 
  }
  
  public CTEmpty[] getGroupArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GROUP$38, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getGroupArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(GROUP$38, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfGroupArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GROUP$38);
    } 
  }
  
  public void setGroupArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, GROUP$38);
    } 
  }
  
  public void setGroupArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(GROUP$38, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewGroup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(GROUP$38, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewGroup() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(GROUP$38);
      return cTEmpty;
    } 
  }
  
  public void removeGroup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GROUP$38, paramInt);
    } 
  }
  
  public List<CTEmpty> getBibliographyList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new BibliographyList(this);
    } 
  }
  
  public CTEmpty[] getBibliographyArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BIBLIOGRAPHY$40, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getBibliographyArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(BIBLIOGRAPHY$40, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfBibliographyArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BIBLIOGRAPHY$40);
    } 
  }
  
  public void setBibliographyArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, BIBLIOGRAPHY$40);
    } 
  }
  
  public void setBibliographyArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(BIBLIOGRAPHY$40, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewBibliography(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(BIBLIOGRAPHY$40, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewBibliography() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(BIBLIOGRAPHY$40);
      return cTEmpty;
    } 
  }
  
  public void removeBibliography(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BIBLIOGRAPHY$40, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSdtPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */