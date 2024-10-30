package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

public class CTAbstractNumImpl extends XmlComplexContentImpl implements CTAbstractNum {
  private static final b NSID$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "nsid");
  
  private static final b MULTILEVELTYPE$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "multiLevelType");
  
  private static final b TMPL$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tmpl");
  
  private static final b NAME$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
  
  private static final b STYLELINK$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleLink");
  
  private static final b NUMSTYLELINK$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numStyleLink");
  
  private static final b LVL$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvl");
  
  private static final b ABSTRACTNUMID$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNumId");
  
  public CTAbstractNumImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTLongHexNumber getNsid() {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().find_element_user(NSID$0, 0);
      if (cTLongHexNumber == null)
        return null; 
      return cTLongHexNumber;
    } 
  }
  
  public boolean isSetNsid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NSID$0) != 0);
    } 
  }
  
  public void setNsid(CTLongHexNumber paramCTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().find_element_user(NSID$0, 0);
      if (cTLongHexNumber == null)
        cTLongHexNumber = (CTLongHexNumber)get_store().add_element_user(NSID$0); 
      cTLongHexNumber.set((XmlObject)paramCTLongHexNumber);
    } 
  }
  
  public CTLongHexNumber addNewNsid() {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().add_element_user(NSID$0);
      return cTLongHexNumber;
    } 
  }
  
  public void unsetNsid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NSID$0, 0);
    } 
  }
  
  public CTMultiLevelType getMultiLevelType() {
    synchronized (monitor()) {
      check_orphaned();
      CTMultiLevelType cTMultiLevelType = null;
      cTMultiLevelType = (CTMultiLevelType)get_store().find_element_user(MULTILEVELTYPE$2, 0);
      if (cTMultiLevelType == null)
        return null; 
      return cTMultiLevelType;
    } 
  }
  
  public boolean isSetMultiLevelType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MULTILEVELTYPE$2) != 0);
    } 
  }
  
  public void setMultiLevelType(CTMultiLevelType paramCTMultiLevelType) {
    synchronized (monitor()) {
      check_orphaned();
      CTMultiLevelType cTMultiLevelType = null;
      cTMultiLevelType = (CTMultiLevelType)get_store().find_element_user(MULTILEVELTYPE$2, 0);
      if (cTMultiLevelType == null)
        cTMultiLevelType = (CTMultiLevelType)get_store().add_element_user(MULTILEVELTYPE$2); 
      cTMultiLevelType.set((XmlObject)paramCTMultiLevelType);
    } 
  }
  
  public CTMultiLevelType addNewMultiLevelType() {
    synchronized (monitor()) {
      check_orphaned();
      CTMultiLevelType cTMultiLevelType = null;
      cTMultiLevelType = (CTMultiLevelType)get_store().add_element_user(MULTILEVELTYPE$2);
      return cTMultiLevelType;
    } 
  }
  
  public void unsetMultiLevelType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MULTILEVELTYPE$2, 0);
    } 
  }
  
  public CTLongHexNumber getTmpl() {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().find_element_user(TMPL$4, 0);
      if (cTLongHexNumber == null)
        return null; 
      return cTLongHexNumber;
    } 
  }
  
  public boolean isSetTmpl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TMPL$4) != 0);
    } 
  }
  
  public void setTmpl(CTLongHexNumber paramCTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().find_element_user(TMPL$4, 0);
      if (cTLongHexNumber == null)
        cTLongHexNumber = (CTLongHexNumber)get_store().add_element_user(TMPL$4); 
      cTLongHexNumber.set((XmlObject)paramCTLongHexNumber);
    } 
  }
  
  public CTLongHexNumber addNewTmpl() {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().add_element_user(TMPL$4);
      return cTLongHexNumber;
    } 
  }
  
  public void unsetTmpl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TMPL$4, 0);
    } 
  }
  
  public CTString getName() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(NAME$6, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NAME$6) != 0);
    } 
  }
  
  public void setName(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(NAME$6, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(NAME$6); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewName() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(NAME$6);
      return cTString;
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NAME$6, 0);
    } 
  }
  
  public CTString getStyleLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(STYLELINK$8, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetStyleLink() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLELINK$8) != 0);
    } 
  }
  
  public void setStyleLink(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(STYLELINK$8, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(STYLELINK$8); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewStyleLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(STYLELINK$8);
      return cTString;
    } 
  }
  
  public void unsetStyleLink() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLELINK$8, 0);
    } 
  }
  
  public CTString getNumStyleLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(NUMSTYLELINK$10, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetNumStyleLink() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMSTYLELINK$10) != 0);
    } 
  }
  
  public void setNumStyleLink(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(NUMSTYLELINK$10, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(NUMSTYLELINK$10); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewNumStyleLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(NUMSTYLELINK$10);
      return cTString;
    } 
  }
  
  public void unsetNumStyleLink() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMSTYLELINK$10, 0);
    } 
  }
  
  public List<CTLvl> getLvlList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLvl>)new LvlList(this);
    } 
  }
  
  public CTLvl[] getLvlArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LVL$12, arrayList);
      CTLvl[] arrayOfCTLvl = new CTLvl[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLvl);
      return arrayOfCTLvl;
    } 
  }
  
  public CTLvl getLvlArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLvl cTLvl = null;
      cTLvl = (CTLvl)get_store().find_element_user(LVL$12, paramInt);
      if (cTLvl == null)
        throw new IndexOutOfBoundsException(); 
      return cTLvl;
    } 
  }
  
  public int sizeOfLvlArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LVL$12);
    } 
  }
  
  public void setLvlArray(CTLvl[] paramArrayOfCTLvl) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLvl, LVL$12);
    } 
  }
  
  public void setLvlArray(int paramInt, CTLvl paramCTLvl) {
    synchronized (monitor()) {
      check_orphaned();
      CTLvl cTLvl = null;
      cTLvl = (CTLvl)get_store().find_element_user(LVL$12, paramInt);
      if (cTLvl == null)
        throw new IndexOutOfBoundsException(); 
      cTLvl.set((XmlObject)paramCTLvl);
    } 
  }
  
  public CTLvl insertNewLvl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLvl cTLvl = null;
      cTLvl = (CTLvl)get_store().insert_element_user(LVL$12, paramInt);
      return cTLvl;
    } 
  }
  
  public CTLvl addNewLvl() {
    synchronized (monitor()) {
      check_orphaned();
      CTLvl cTLvl = null;
      cTLvl = (CTLvl)get_store().add_element_user(LVL$12);
      return cTLvl;
    } 
  }
  
  public void removeLvl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL$12, paramInt);
    } 
  }
  
  public BigInteger getAbstractNumId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ABSTRACTNUMID$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetAbstractNumId() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ABSTRACTNUMID$14);
      return sTDecimalNumber;
    } 
  }
  
  public void setAbstractNumId(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ABSTRACTNUMID$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ABSTRACTNUMID$14); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetAbstractNumId(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ABSTRACTNUMID$14);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(ABSTRACTNUMID$14); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTAbstractNumImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */