package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;

public class CTPPrDefaultImpl extends XmlComplexContentImpl implements CTPPrDefault {
  private static final b PPR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPr");
  
  public CTPPrDefaultImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPPr getPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().find_element_user(PPR$0, 0);
      if (cTPPr == null)
        return null; 
      return cTPPr;
    } 
  }
  
  public boolean isSetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PPR$0) != 0);
    } 
  }
  
  public void setPPr(CTPPr paramCTPPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().find_element_user(PPR$0, 0);
      if (cTPPr == null)
        cTPPr = (CTPPr)get_store().add_element_user(PPR$0); 
      cTPPr.set((XmlObject)paramCTPPr);
    } 
  }
  
  public CTPPr addNewPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().add_element_user(PPR$0);
      return cTPPr;
    } 
  }
  
  public void unsetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PPR$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTPPrDefaultImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */