package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;

public class CTRPrDefaultImpl extends XmlComplexContentImpl implements CTRPrDefault {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
  
  public CTRPrDefaultImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRPr getRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$0, 0);
      if (cTRPr == null)
        return null; 
      return cTRPr;
    } 
  }
  
  public boolean isSetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPR$0) != 0);
    } 
  }
  
  public void setRPr(CTRPr paramCTRPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$0, 0);
      if (cTRPr == null)
        cTRPr = (CTRPr)get_store().add_element_user(RPR$0); 
      cTRPr.set((XmlObject)paramCTRPr);
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
  
  public void unsetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTRPrDefaultImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */