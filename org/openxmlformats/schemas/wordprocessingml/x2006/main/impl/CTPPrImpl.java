package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

public class CTPPrImpl extends CTPPrBaseImpl implements CTPPr {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
  
  private static final b SECTPR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sectPr");
  
  private static final b PPRCHANGE$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPrChange");
  
  public CTPPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTParaRPr getRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTParaRPr cTParaRPr = null;
      cTParaRPr = (CTParaRPr)get_store().find_element_user(RPR$0, 0);
      if (cTParaRPr == null)
        return null; 
      return cTParaRPr;
    } 
  }
  
  public boolean isSetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPR$0) != 0);
    } 
  }
  
  public void setRPr(CTParaRPr paramCTParaRPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTParaRPr cTParaRPr = null;
      cTParaRPr = (CTParaRPr)get_store().find_element_user(RPR$0, 0);
      if (cTParaRPr == null)
        cTParaRPr = (CTParaRPr)get_store().add_element_user(RPR$0); 
      cTParaRPr.set((XmlObject)paramCTParaRPr);
    } 
  }
  
  public CTParaRPr addNewRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTParaRPr cTParaRPr = null;
      cTParaRPr = (CTParaRPr)get_store().add_element_user(RPR$0);
      return cTParaRPr;
    } 
  }
  
  public void unsetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$0, 0);
    } 
  }
  
  public CTSectPr getSectPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPr cTSectPr = null;
      cTSectPr = (CTSectPr)get_store().find_element_user(SECTPR$2, 0);
      if (cTSectPr == null)
        return null; 
      return cTSectPr;
    } 
  }
  
  public boolean isSetSectPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SECTPR$2) != 0);
    } 
  }
  
  public void setSectPr(CTSectPr paramCTSectPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPr cTSectPr = null;
      cTSectPr = (CTSectPr)get_store().find_element_user(SECTPR$2, 0);
      if (cTSectPr == null)
        cTSectPr = (CTSectPr)get_store().add_element_user(SECTPR$2); 
      cTSectPr.set((XmlObject)paramCTSectPr);
    } 
  }
  
  public CTSectPr addNewSectPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSectPr cTSectPr = null;
      cTSectPr = (CTSectPr)get_store().add_element_user(SECTPR$2);
      return cTSectPr;
    } 
  }
  
  public void unsetSectPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SECTPR$2, 0);
    } 
  }
  
  public CTPPrChange getPPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPrChange cTPPrChange = null;
      cTPPrChange = (CTPPrChange)get_store().find_element_user(PPRCHANGE$4, 0);
      if (cTPPrChange == null)
        return null; 
      return cTPPrChange;
    } 
  }
  
  public boolean isSetPPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PPRCHANGE$4) != 0);
    } 
  }
  
  public void setPPrChange(CTPPrChange paramCTPPrChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTPPrChange cTPPrChange = null;
      cTPPrChange = (CTPPrChange)get_store().find_element_user(PPRCHANGE$4, 0);
      if (cTPPrChange == null)
        cTPPrChange = (CTPPrChange)get_store().add_element_user(PPRCHANGE$4); 
      cTPPrChange.set((XmlObject)paramCTPPrChange);
    } 
  }
  
  public CTPPrChange addNewPPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPrChange cTPPrChange = null;
      cTPPrChange = (CTPPrChange)get_store().add_element_user(PPRCHANGE$4);
      return cTPPrChange;
    } 
  }
  
  public void unsetPPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PPRCHANGE$4, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTPPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */