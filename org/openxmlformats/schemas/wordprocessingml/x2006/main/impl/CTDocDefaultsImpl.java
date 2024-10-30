package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;

public class CTDocDefaultsImpl extends XmlComplexContentImpl implements CTDocDefaults {
  private static final b RPRDEFAULT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrDefault");
  
  private static final b PPRDEFAULT$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPrDefault");
  
  public CTDocDefaultsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRPrDefault getRPrDefault() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrDefault cTRPrDefault = null;
      cTRPrDefault = (CTRPrDefault)get_store().find_element_user(RPRDEFAULT$0, 0);
      if (cTRPrDefault == null)
        return null; 
      return cTRPrDefault;
    } 
  }
  
  public boolean isSetRPrDefault() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPRDEFAULT$0) != 0);
    } 
  }
  
  public void setRPrDefault(CTRPrDefault paramCTRPrDefault) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrDefault cTRPrDefault = null;
      cTRPrDefault = (CTRPrDefault)get_store().find_element_user(RPRDEFAULT$0, 0);
      if (cTRPrDefault == null)
        cTRPrDefault = (CTRPrDefault)get_store().add_element_user(RPRDEFAULT$0); 
      cTRPrDefault.set((XmlObject)paramCTRPrDefault);
    } 
  }
  
  public CTRPrDefault addNewRPrDefault() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrDefault cTRPrDefault = null;
      cTRPrDefault = (CTRPrDefault)get_store().add_element_user(RPRDEFAULT$0);
      return cTRPrDefault;
    } 
  }
  
  public void unsetRPrDefault() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPRDEFAULT$0, 0);
    } 
  }
  
  public CTPPrDefault getPPrDefault() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPrDefault cTPPrDefault = null;
      cTPPrDefault = (CTPPrDefault)get_store().find_element_user(PPRDEFAULT$2, 0);
      if (cTPPrDefault == null)
        return null; 
      return cTPPrDefault;
    } 
  }
  
  public boolean isSetPPrDefault() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PPRDEFAULT$2) != 0);
    } 
  }
  
  public void setPPrDefault(CTPPrDefault paramCTPPrDefault) {
    synchronized (monitor()) {
      check_orphaned();
      CTPPrDefault cTPPrDefault = null;
      cTPPrDefault = (CTPPrDefault)get_store().find_element_user(PPRDEFAULT$2, 0);
      if (cTPPrDefault == null)
        cTPPrDefault = (CTPPrDefault)get_store().add_element_user(PPRDEFAULT$2); 
      cTPPrDefault.set((XmlObject)paramCTPPrDefault);
    } 
  }
  
  public CTPPrDefault addNewPPrDefault() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPrDefault cTPPrDefault = null;
      cTPPrDefault = (CTPPrDefault)get_store().add_element_user(PPRDEFAULT$2);
      return cTPPrDefault;
    } 
  }
  
  public void unsetPPrDefault() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PPRDEFAULT$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTDocDefaultsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */