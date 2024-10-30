package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

public class CTNumImpl extends XmlComplexContentImpl implements CTNum {
  private static final b ABSTRACTNUMID$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNumId");
  
  private static final b LVLOVERRIDE$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlOverride");
  
  private static final b NUMID$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numId");
  
  public CTNumImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTDecimalNumber getAbstractNumId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(ABSTRACTNUMID$0, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public void setAbstractNumId(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(ABSTRACTNUMID$0, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(ABSTRACTNUMID$0); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewAbstractNumId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(ABSTRACTNUMID$0);
      return cTDecimalNumber;
    } 
  }
  
  public List<CTNumLvl> getLvlOverrideList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTNumLvl>)new LvlOverrideList(this);
    } 
  }
  
  public CTNumLvl[] getLvlOverrideArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LVLOVERRIDE$2, arrayList);
      CTNumLvl[] arrayOfCTNumLvl = new CTNumLvl[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTNumLvl);
      return arrayOfCTNumLvl;
    } 
  }
  
  public CTNumLvl getLvlOverrideArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumLvl cTNumLvl = null;
      cTNumLvl = (CTNumLvl)get_store().find_element_user(LVLOVERRIDE$2, paramInt);
      if (cTNumLvl == null)
        throw new IndexOutOfBoundsException(); 
      return cTNumLvl;
    } 
  }
  
  public int sizeOfLvlOverrideArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LVLOVERRIDE$2);
    } 
  }
  
  public void setLvlOverrideArray(CTNumLvl[] paramArrayOfCTNumLvl) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTNumLvl, LVLOVERRIDE$2);
    } 
  }
  
  public void setLvlOverrideArray(int paramInt, CTNumLvl paramCTNumLvl) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumLvl cTNumLvl = null;
      cTNumLvl = (CTNumLvl)get_store().find_element_user(LVLOVERRIDE$2, paramInt);
      if (cTNumLvl == null)
        throw new IndexOutOfBoundsException(); 
      cTNumLvl.set((XmlObject)paramCTNumLvl);
    } 
  }
  
  public CTNumLvl insertNewLvlOverride(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumLvl cTNumLvl = null;
      cTNumLvl = (CTNumLvl)get_store().insert_element_user(LVLOVERRIDE$2, paramInt);
      return cTNumLvl;
    } 
  }
  
  public CTNumLvl addNewLvlOverride() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumLvl cTNumLvl = null;
      cTNumLvl = (CTNumLvl)get_store().add_element_user(LVLOVERRIDE$2);
      return cTNumLvl;
    } 
  }
  
  public void removeLvlOverride(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVLOVERRIDE$2, paramInt);
    } 
  }
  
  public BigInteger getNumId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMID$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetNumId() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(NUMID$4);
      return sTDecimalNumber;
    } 
  }
  
  public void setNumId(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NUMID$4); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetNumId(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(NUMID$4);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(NUMID$4); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTNumImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */