package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout;

public class CTLayoutImpl extends XmlComplexContentImpl implements CTLayout {
  private static final b MANUALLAYOUT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "manualLayout");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTLayoutImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTManualLayout getManualLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTManualLayout cTManualLayout = null;
      cTManualLayout = (CTManualLayout)get_store().find_element_user(MANUALLAYOUT$0, 0);
      if (cTManualLayout == null)
        return null; 
      return cTManualLayout;
    } 
  }
  
  public boolean isSetManualLayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MANUALLAYOUT$0) != 0);
    } 
  }
  
  public void setManualLayout(CTManualLayout paramCTManualLayout) {
    synchronized (monitor()) {
      check_orphaned();
      CTManualLayout cTManualLayout = null;
      cTManualLayout = (CTManualLayout)get_store().find_element_user(MANUALLAYOUT$0, 0);
      if (cTManualLayout == null)
        cTManualLayout = (CTManualLayout)get_store().add_element_user(MANUALLAYOUT$0); 
      cTManualLayout.set((XmlObject)paramCTManualLayout);
    } 
  }
  
  public CTManualLayout addNewManualLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTManualLayout cTManualLayout = null;
      cTManualLayout = (CTManualLayout)get_store().add_element_user(MANUALLAYOUT$0);
      return cTManualLayout;
    } 
  }
  
  public void unsetManualLayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MANUALLAYOUT$0, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTLayoutImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */