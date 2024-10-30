package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTHeaderFooter;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageSetup;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRelId;

public class CTPrintSettingsImpl extends XmlComplexContentImpl implements CTPrintSettings {
  private static final b HEADERFOOTER$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "headerFooter");
  
  private static final b PAGEMARGINS$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "pageMargins");
  
  private static final b PAGESETUP$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "pageSetup");
  
  private static final b LEGACYDRAWINGHF$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "legacyDrawingHF");
  
  public CTPrintSettingsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTHeaderFooter getHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HEADERFOOTER$0, 0);
      if (cTHeaderFooter == null)
        return null; 
      return cTHeaderFooter;
    } 
  }
  
  public boolean isSetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HEADERFOOTER$0) != 0);
    } 
  }
  
  public void setHeaderFooter(CTHeaderFooter paramCTHeaderFooter) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HEADERFOOTER$0, 0);
      if (cTHeaderFooter == null)
        cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HEADERFOOTER$0); 
      cTHeaderFooter.set((XmlObject)paramCTHeaderFooter);
    } 
  }
  
  public CTHeaderFooter addNewHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HEADERFOOTER$0);
      return cTHeaderFooter;
    } 
  }
  
  public void unsetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HEADERFOOTER$0, 0);
    } 
  }
  
  public CTPageMargins getPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().find_element_user(PAGEMARGINS$2, 0);
      if (cTPageMargins == null)
        return null; 
      return cTPageMargins;
    } 
  }
  
  public boolean isSetPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGEMARGINS$2) != 0);
    } 
  }
  
  public void setPageMargins(CTPageMargins paramCTPageMargins) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().find_element_user(PAGEMARGINS$2, 0);
      if (cTPageMargins == null)
        cTPageMargins = (CTPageMargins)get_store().add_element_user(PAGEMARGINS$2); 
      cTPageMargins.set((XmlObject)paramCTPageMargins);
    } 
  }
  
  public CTPageMargins addNewPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().add_element_user(PAGEMARGINS$2);
      return cTPageMargins;
    } 
  }
  
  public void unsetPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGEMARGINS$2, 0);
    } 
  }
  
  public CTPageSetup getPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().find_element_user(PAGESETUP$4, 0);
      if (cTPageSetup == null)
        return null; 
      return cTPageSetup;
    } 
  }
  
  public boolean isSetPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGESETUP$4) != 0);
    } 
  }
  
  public void setPageSetup(CTPageSetup paramCTPageSetup) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().find_element_user(PAGESETUP$4, 0);
      if (cTPageSetup == null)
        cTPageSetup = (CTPageSetup)get_store().add_element_user(PAGESETUP$4); 
      cTPageSetup.set((XmlObject)paramCTPageSetup);
    } 
  }
  
  public CTPageSetup addNewPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().add_element_user(PAGESETUP$4);
      return cTPageSetup;
    } 
  }
  
  public void unsetPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGESETUP$4, 0);
    } 
  }
  
  public CTRelId getLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelId cTRelId = null;
      cTRelId = (CTRelId)get_store().find_element_user(LEGACYDRAWINGHF$6, 0);
      if (cTRelId == null)
        return null; 
      return cTRelId;
    } 
  }
  
  public boolean isSetLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGACYDRAWINGHF$6) != 0);
    } 
  }
  
  public void setLegacyDrawingHF(CTRelId paramCTRelId) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelId cTRelId = null;
      cTRelId = (CTRelId)get_store().find_element_user(LEGACYDRAWINGHF$6, 0);
      if (cTRelId == null)
        cTRelId = (CTRelId)get_store().add_element_user(LEGACYDRAWINGHF$6); 
      cTRelId.set((XmlObject)paramCTRelId);
    } 
  }
  
  public CTRelId addNewLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelId cTRelId = null;
      cTRelId = (CTRelId)get_store().add_element_user(LEGACYDRAWINGHF$6);
      return cTRelId;
    } 
  }
  
  public void unsetLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGACYDRAWINGHF$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTPrintSettingsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */