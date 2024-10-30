package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExChange;

public class CTTblPrExImpl extends CTTblPrExBaseImpl implements CTTblPrEx {
  private static final b TBLPREXCHANGE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPrExChange");
  
  public CTTblPrExImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTblPrExChange getTblPrExChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrExChange cTTblPrExChange = null;
      cTTblPrExChange = (CTTblPrExChange)get_store().find_element_user(TBLPREXCHANGE$0, 0);
      if (cTTblPrExChange == null)
        return null; 
      return cTTblPrExChange;
    } 
  }
  
  public boolean isSetTblPrExChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLPREXCHANGE$0) != 0);
    } 
  }
  
  public void setTblPrExChange(CTTblPrExChange paramCTTblPrExChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrExChange cTTblPrExChange = null;
      cTTblPrExChange = (CTTblPrExChange)get_store().find_element_user(TBLPREXCHANGE$0, 0);
      if (cTTblPrExChange == null)
        cTTblPrExChange = (CTTblPrExChange)get_store().add_element_user(TBLPREXCHANGE$0); 
      cTTblPrExChange.set((XmlObject)paramCTTblPrExChange);
    } 
  }
  
  public CTTblPrExChange addNewTblPrExChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrExChange cTTblPrExChange = null;
      cTTblPrExChange = (CTTblPrExChange)get_store().add_element_user(TBLPREXCHANGE$0);
      return cTTblPrExChange;
    } 
  }
  
  public void unsetTblPrExChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLPREXCHANGE$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblPrExImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */