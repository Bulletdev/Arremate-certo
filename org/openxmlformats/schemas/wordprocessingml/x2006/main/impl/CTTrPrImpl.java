package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

public class CTTrPrImpl extends CTTrPrBaseImpl implements CTTrPr {
  private static final b INS$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
  
  private static final b DEL$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
  
  private static final b TRPRCHANGE$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trPrChange");
  
  public CTTrPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTrackChange getIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(INS$0, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetIns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(INS$0) != 0);
    } 
  }
  
  public void setIns(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(INS$0, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(INS$0); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(INS$0);
      return cTTrackChange;
    } 
  }
  
  public void unsetIns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INS$0, 0);
    } 
  }
  
  public CTTrackChange getDel() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(DEL$2, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetDel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEL$2) != 0);
    } 
  }
  
  public void setDel(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(DEL$2, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(DEL$2); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewDel() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(DEL$2);
      return cTTrackChange;
    } 
  }
  
  public void unsetDel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEL$2, 0);
    } 
  }
  
  public CTTrPrChange getTrPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrPrChange cTTrPrChange = null;
      cTTrPrChange = (CTTrPrChange)get_store().find_element_user(TRPRCHANGE$4, 0);
      if (cTTrPrChange == null)
        return null; 
      return cTTrPrChange;
    } 
  }
  
  public boolean isSetTrPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TRPRCHANGE$4) != 0);
    } 
  }
  
  public void setTrPrChange(CTTrPrChange paramCTTrPrChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrPrChange cTTrPrChange = null;
      cTTrPrChange = (CTTrPrChange)get_store().find_element_user(TRPRCHANGE$4, 0);
      if (cTTrPrChange == null)
        cTTrPrChange = (CTTrPrChange)get_store().add_element_user(TRPRCHANGE$4); 
      cTTrPrChange.set((XmlObject)paramCTTrPrChange);
    } 
  }
  
  public CTTrPrChange addNewTrPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrPrChange cTTrPrChange = null;
      cTTrPrChange = (CTTrPrChange)get_store().add_element_user(TRPRCHANGE$4);
      return cTTrPrChange;
    } 
  }
  
  public void unsetTrPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TRPRCHANGE$4, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTrPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */