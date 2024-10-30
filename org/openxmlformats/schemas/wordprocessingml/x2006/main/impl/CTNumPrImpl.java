package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangeNumbering;

public class CTNumPrImpl extends XmlComplexContentImpl implements CTNumPr {
  private static final b ILVL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ilvl");
  
  private static final b NUMID$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numId");
  
  private static final b NUMBERINGCHANGE$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numberingChange");
  
  private static final b INS$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
  
  public CTNumPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTDecimalNumber getIlvl() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(ILVL$0, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetIlvl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ILVL$0) != 0);
    } 
  }
  
  public void setIlvl(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(ILVL$0, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(ILVL$0); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewIlvl() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(ILVL$0);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetIlvl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ILVL$0, 0);
    } 
  }
  
  public CTDecimalNumber getNumId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(NUMID$2, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetNumId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMID$2) != 0);
    } 
  }
  
  public void setNumId(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(NUMID$2, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(NUMID$2); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewNumId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(NUMID$2);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetNumId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMID$2, 0);
    } 
  }
  
  public CTTrackChangeNumbering getNumberingChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangeNumbering cTTrackChangeNumbering = null;
      cTTrackChangeNumbering = (CTTrackChangeNumbering)get_store().find_element_user(NUMBERINGCHANGE$4, 0);
      if (cTTrackChangeNumbering == null)
        return null; 
      return cTTrackChangeNumbering;
    } 
  }
  
  public boolean isSetNumberingChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMBERINGCHANGE$4) != 0);
    } 
  }
  
  public void setNumberingChange(CTTrackChangeNumbering paramCTTrackChangeNumbering) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangeNumbering cTTrackChangeNumbering = null;
      cTTrackChangeNumbering = (CTTrackChangeNumbering)get_store().find_element_user(NUMBERINGCHANGE$4, 0);
      if (cTTrackChangeNumbering == null)
        cTTrackChangeNumbering = (CTTrackChangeNumbering)get_store().add_element_user(NUMBERINGCHANGE$4); 
      cTTrackChangeNumbering.set((XmlObject)paramCTTrackChangeNumbering);
    } 
  }
  
  public CTTrackChangeNumbering addNewNumberingChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangeNumbering cTTrackChangeNumbering = null;
      cTTrackChangeNumbering = (CTTrackChangeNumbering)get_store().add_element_user(NUMBERINGCHANGE$4);
      return cTTrackChangeNumbering;
    } 
  }
  
  public void unsetNumberingChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMBERINGCHANGE$4, 0);
    } 
  }
  
  public CTTrackChange getIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(INS$6, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetIns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(INS$6) != 0);
    } 
  }
  
  public void setIns(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(INS$6, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(INS$6); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(INS$6);
      return cTTrackChange;
    } 
  }
  
  public void unsetIns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INS$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTNumPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */