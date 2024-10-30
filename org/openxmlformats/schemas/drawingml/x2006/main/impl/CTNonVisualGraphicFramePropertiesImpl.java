package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectFrameLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

public class CTNonVisualGraphicFramePropertiesImpl extends XmlComplexContentImpl implements CTNonVisualGraphicFrameProperties {
  private static final b GRAPHICFRAMELOCKS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "graphicFrameLocks");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  public CTNonVisualGraphicFramePropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGraphicalObjectFrameLocking getGraphicFrameLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking = null;
      cTGraphicalObjectFrameLocking = (CTGraphicalObjectFrameLocking)get_store().find_element_user(GRAPHICFRAMELOCKS$0, 0);
      if (cTGraphicalObjectFrameLocking == null)
        return null; 
      return cTGraphicalObjectFrameLocking;
    } 
  }
  
  public boolean isSetGraphicFrameLocks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRAPHICFRAMELOCKS$0) != 0);
    } 
  }
  
  public void setGraphicFrameLocks(CTGraphicalObjectFrameLocking paramCTGraphicalObjectFrameLocking) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking = null;
      cTGraphicalObjectFrameLocking = (CTGraphicalObjectFrameLocking)get_store().find_element_user(GRAPHICFRAMELOCKS$0, 0);
      if (cTGraphicalObjectFrameLocking == null)
        cTGraphicalObjectFrameLocking = (CTGraphicalObjectFrameLocking)get_store().add_element_user(GRAPHICFRAMELOCKS$0); 
      cTGraphicalObjectFrameLocking.set((XmlObject)paramCTGraphicalObjectFrameLocking);
    } 
  }
  
  public CTGraphicalObjectFrameLocking addNewGraphicFrameLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking = null;
      cTGraphicalObjectFrameLocking = (CTGraphicalObjectFrameLocking)get_store().add_element_user(GRAPHICFRAMELOCKS$0);
      return cTGraphicalObjectFrameLocking;
    } 
  }
  
  public void unsetGraphicFrameLocks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRAPHICFRAMELOCKS$0, 0);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTNonVisualGraphicFramePropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */