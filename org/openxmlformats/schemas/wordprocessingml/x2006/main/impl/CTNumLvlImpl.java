package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

public class CTNumLvlImpl extends XmlComplexContentImpl implements CTNumLvl {
  private static final b STARTOVERRIDE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "startOverride");
  
  private static final b LVL$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvl");
  
  private static final b ILVL$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ilvl");
  
  public CTNumLvlImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTDecimalNumber getStartOverride() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(STARTOVERRIDE$0, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetStartOverride() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STARTOVERRIDE$0) != 0);
    } 
  }
  
  public void setStartOverride(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(STARTOVERRIDE$0, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(STARTOVERRIDE$0); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewStartOverride() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(STARTOVERRIDE$0);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetStartOverride() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STARTOVERRIDE$0, 0);
    } 
  }
  
  public CTLvl getLvl() {
    synchronized (monitor()) {
      check_orphaned();
      CTLvl cTLvl = null;
      cTLvl = (CTLvl)get_store().find_element_user(LVL$2, 0);
      if (cTLvl == null)
        return null; 
      return cTLvl;
    } 
  }
  
  public boolean isSetLvl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL$2) != 0);
    } 
  }
  
  public void setLvl(CTLvl paramCTLvl) {
    synchronized (monitor()) {
      check_orphaned();
      CTLvl cTLvl = null;
      cTLvl = (CTLvl)get_store().find_element_user(LVL$2, 0);
      if (cTLvl == null)
        cTLvl = (CTLvl)get_store().add_element_user(LVL$2); 
      cTLvl.set((XmlObject)paramCTLvl);
    } 
  }
  
  public CTLvl addNewLvl() {
    synchronized (monitor()) {
      check_orphaned();
      CTLvl cTLvl = null;
      cTLvl = (CTLvl)get_store().add_element_user(LVL$2);
      return cTLvl;
    } 
  }
  
  public void unsetLvl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL$2, 0);
    } 
  }
  
  public BigInteger getIlvl() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ILVL$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetIlvl() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ILVL$4);
      return sTDecimalNumber;
    } 
  }
  
  public void setIlvl(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ILVL$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ILVL$4); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetIlvl(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ILVL$4);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(ILVL$4); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTNumLvlImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */