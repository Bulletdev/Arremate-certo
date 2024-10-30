package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrChange;

public class CTTcPrImpl extends CTTcPrInnerImpl implements CTTcPr {
  private static final b TCPRCHANGE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPrChange");
  
  public CTTcPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTcPrChange getTcPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTcPrChange cTTcPrChange = null;
      cTTcPrChange = (CTTcPrChange)get_store().find_element_user(TCPRCHANGE$0, 0);
      if (cTTcPrChange == null)
        return null; 
      return cTTcPrChange;
    } 
  }
  
  public boolean isSetTcPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCPRCHANGE$0) != 0);
    } 
  }
  
  public void setTcPrChange(CTTcPrChange paramCTTcPrChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTcPrChange cTTcPrChange = null;
      cTTcPrChange = (CTTcPrChange)get_store().find_element_user(TCPRCHANGE$0, 0);
      if (cTTcPrChange == null)
        cTTcPrChange = (CTTcPrChange)get_store().add_element_user(TCPRCHANGE$0); 
      cTTcPrChange.set((XmlObject)paramCTTcPrChange);
    } 
  }
  
  public CTTcPrChange addNewTcPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTcPrChange cTTcPrChange = null;
      cTTcPrChange = (CTTcPrChange)get_store().add_element_user(TCPRCHANGE$0);
      return cTTcPrChange;
    } 
  }
  
  public void unsetTcPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCPRCHANGE$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTcPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */