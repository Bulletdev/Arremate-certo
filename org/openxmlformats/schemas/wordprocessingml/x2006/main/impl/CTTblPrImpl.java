package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrChange;

public class CTTblPrImpl extends CTTblPrBaseImpl implements CTTblPr {
  private static final b TBLPRCHANGE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPrChange");
  
  public CTTblPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTblPrChange getTblPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrChange cTTblPrChange = null;
      cTTblPrChange = (CTTblPrChange)get_store().find_element_user(TBLPRCHANGE$0, 0);
      if (cTTblPrChange == null)
        return null; 
      return cTTblPrChange;
    } 
  }
  
  public boolean isSetTblPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLPRCHANGE$0) != 0);
    } 
  }
  
  public void setTblPrChange(CTTblPrChange paramCTTblPrChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrChange cTTblPrChange = null;
      cTTblPrChange = (CTTblPrChange)get_store().find_element_user(TBLPRCHANGE$0, 0);
      if (cTTblPrChange == null)
        cTTblPrChange = (CTTblPrChange)get_store().add_element_user(TBLPRCHANGE$0); 
      cTTblPrChange.set((XmlObject)paramCTTblPrChange);
    } 
  }
  
  public CTTblPrChange addNewTblPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrChange cTTblPrChange = null;
      cTTblPrChange = (CTTblPrChange)get_store().add_element_user(TBLPRCHANGE$0);
      return cTTblPrChange;
    } 
  }
  
  public void unsetTblPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLPRCHANGE$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */