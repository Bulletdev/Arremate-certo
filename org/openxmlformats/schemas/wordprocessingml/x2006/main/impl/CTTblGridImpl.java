package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridChange;

public class CTTblGridImpl extends CTTblGridBaseImpl implements CTTblGrid {
  private static final b TBLGRIDCHANGE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblGridChange");
  
  public CTTblGridImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTblGridChange getTblGridChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGridChange cTTblGridChange = null;
      cTTblGridChange = (CTTblGridChange)get_store().find_element_user(TBLGRIDCHANGE$0, 0);
      if (cTTblGridChange == null)
        return null; 
      return cTTblGridChange;
    } 
  }
  
  public boolean isSetTblGridChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLGRIDCHANGE$0) != 0);
    } 
  }
  
  public void setTblGridChange(CTTblGridChange paramCTTblGridChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGridChange cTTblGridChange = null;
      cTTblGridChange = (CTTblGridChange)get_store().find_element_user(TBLGRIDCHANGE$0, 0);
      if (cTTblGridChange == null)
        cTTblGridChange = (CTTblGridChange)get_store().add_element_user(TBLGRIDCHANGE$0); 
      cTTblGridChange.set((XmlObject)paramCTTblGridChange);
    } 
  }
  
  public CTTblGridChange addNewTblGridChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGridChange cTTblGridChange = null;
      cTTblGridChange = (CTTblGridChange)get_store().add_element_user(TBLGRIDCHANGE$0);
      return cTTblGridChange;
    } 
  }
  
  public void unsetTblGridChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLGRIDCHANGE$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblGridImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */