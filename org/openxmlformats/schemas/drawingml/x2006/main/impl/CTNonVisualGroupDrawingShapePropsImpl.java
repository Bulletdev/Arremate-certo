package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

public class CTNonVisualGroupDrawingShapePropsImpl extends XmlComplexContentImpl implements CTNonVisualGroupDrawingShapeProps {
  private static final b GRPSPLOCKS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpSpLocks");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  public CTNonVisualGroupDrawingShapePropsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGroupLocking getGrpSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupLocking cTGroupLocking = null;
      cTGroupLocking = (CTGroupLocking)get_store().find_element_user(GRPSPLOCKS$0, 0);
      if (cTGroupLocking == null)
        return null; 
      return cTGroupLocking;
    } 
  }
  
  public boolean isSetGrpSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRPSPLOCKS$0) != 0);
    } 
  }
  
  public void setGrpSpLocks(CTGroupLocking paramCTGroupLocking) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupLocking cTGroupLocking = null;
      cTGroupLocking = (CTGroupLocking)get_store().find_element_user(GRPSPLOCKS$0, 0);
      if (cTGroupLocking == null)
        cTGroupLocking = (CTGroupLocking)get_store().add_element_user(GRPSPLOCKS$0); 
      cTGroupLocking.set((XmlObject)paramCTGroupLocking);
    } 
  }
  
  public CTGroupLocking addNewGrpSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupLocking cTGroupLocking = null;
      cTGroupLocking = (CTGroupLocking)get_store().add_element_user(GRPSPLOCKS$0);
      return cTGroupLocking;
    } 
  }
  
  public void unsetGrpSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPSPLOCKS$0, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$2); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$2);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTNonVisualGroupDrawingShapePropsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */