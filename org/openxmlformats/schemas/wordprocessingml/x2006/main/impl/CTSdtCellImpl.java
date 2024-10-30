package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;

public class CTSdtCellImpl extends XmlComplexContentImpl implements CTSdtCell {
  private static final b SDTPR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtPr");
  
  private static final b SDTENDPR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtEndPr");
  
  private static final b SDTCONTENT$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtContent");
  
  public CTSdtCellImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSdtPr getSdtPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtPr cTSdtPr = null;
      cTSdtPr = (CTSdtPr)get_store().find_element_user(SDTPR$0, 0);
      if (cTSdtPr == null)
        return null; 
      return cTSdtPr;
    } 
  }
  
  public boolean isSetSdtPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SDTPR$0) != 0);
    } 
  }
  
  public void setSdtPr(CTSdtPr paramCTSdtPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtPr cTSdtPr = null;
      cTSdtPr = (CTSdtPr)get_store().find_element_user(SDTPR$0, 0);
      if (cTSdtPr == null)
        cTSdtPr = (CTSdtPr)get_store().add_element_user(SDTPR$0); 
      cTSdtPr.set((XmlObject)paramCTSdtPr);
    } 
  }
  
  public CTSdtPr addNewSdtPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtPr cTSdtPr = null;
      cTSdtPr = (CTSdtPr)get_store().add_element_user(SDTPR$0);
      return cTSdtPr;
    } 
  }
  
  public void unsetSdtPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SDTPR$0, 0);
    } 
  }
  
  public CTSdtEndPr getSdtEndPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtEndPr cTSdtEndPr = null;
      cTSdtEndPr = (CTSdtEndPr)get_store().find_element_user(SDTENDPR$2, 0);
      if (cTSdtEndPr == null)
        return null; 
      return cTSdtEndPr;
    } 
  }
  
  public boolean isSetSdtEndPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SDTENDPR$2) != 0);
    } 
  }
  
  public void setSdtEndPr(CTSdtEndPr paramCTSdtEndPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtEndPr cTSdtEndPr = null;
      cTSdtEndPr = (CTSdtEndPr)get_store().find_element_user(SDTENDPR$2, 0);
      if (cTSdtEndPr == null)
        cTSdtEndPr = (CTSdtEndPr)get_store().add_element_user(SDTENDPR$2); 
      cTSdtEndPr.set((XmlObject)paramCTSdtEndPr);
    } 
  }
  
  public CTSdtEndPr addNewSdtEndPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtEndPr cTSdtEndPr = null;
      cTSdtEndPr = (CTSdtEndPr)get_store().add_element_user(SDTENDPR$2);
      return cTSdtEndPr;
    } 
  }
  
  public void unsetSdtEndPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SDTENDPR$2, 0);
    } 
  }
  
  public CTSdtContentCell getSdtContent() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtContentCell cTSdtContentCell = null;
      cTSdtContentCell = (CTSdtContentCell)get_store().find_element_user(SDTCONTENT$4, 0);
      if (cTSdtContentCell == null)
        return null; 
      return cTSdtContentCell;
    } 
  }
  
  public boolean isSetSdtContent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SDTCONTENT$4) != 0);
    } 
  }
  
  public void setSdtContent(CTSdtContentCell paramCTSdtContentCell) {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtContentCell cTSdtContentCell = null;
      cTSdtContentCell = (CTSdtContentCell)get_store().find_element_user(SDTCONTENT$4, 0);
      if (cTSdtContentCell == null)
        cTSdtContentCell = (CTSdtContentCell)get_store().add_element_user(SDTCONTENT$4); 
      cTSdtContentCell.set((XmlObject)paramCTSdtContentCell);
    } 
  }
  
  public CTSdtContentCell addNewSdtContent() {
    synchronized (monitor()) {
      check_orphaned();
      CTSdtContentCell cTSdtContentCell = null;
      cTSdtContentCell = (CTSdtContentCell)get_store().add_element_user(SDTCONTENT$4);
      return cTSdtContentCell;
    } 
  }
  
  public void unsetSdtContent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SDTCONTENT$4, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSdtCellImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */