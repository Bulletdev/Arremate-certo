package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmptyElement;

public class CTColorMappingOverrideImpl extends XmlComplexContentImpl implements CTColorMappingOverride {
  private static final b MASTERCLRMAPPING$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "masterClrMapping");
  
  private static final b OVERRIDECLRMAPPING$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "overrideClrMapping");
  
  public CTColorMappingOverrideImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTEmptyElement getMasterClrMapping() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmptyElement cTEmptyElement = null;
      cTEmptyElement = (CTEmptyElement)get_store().find_element_user(MASTERCLRMAPPING$0, 0);
      if (cTEmptyElement == null)
        return null; 
      return cTEmptyElement;
    } 
  }
  
  public boolean isSetMasterClrMapping() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MASTERCLRMAPPING$0) != 0);
    } 
  }
  
  public void setMasterClrMapping(CTEmptyElement paramCTEmptyElement) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmptyElement cTEmptyElement = null;
      cTEmptyElement = (CTEmptyElement)get_store().find_element_user(MASTERCLRMAPPING$0, 0);
      if (cTEmptyElement == null)
        cTEmptyElement = (CTEmptyElement)get_store().add_element_user(MASTERCLRMAPPING$0); 
      cTEmptyElement.set((XmlObject)paramCTEmptyElement);
    } 
  }
  
  public CTEmptyElement addNewMasterClrMapping() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmptyElement cTEmptyElement = null;
      cTEmptyElement = (CTEmptyElement)get_store().add_element_user(MASTERCLRMAPPING$0);
      return cTEmptyElement;
    } 
  }
  
  public void unsetMasterClrMapping() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MASTERCLRMAPPING$0, 0);
    } 
  }
  
  public CTColorMapping getOverrideClrMapping() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().find_element_user(OVERRIDECLRMAPPING$2, 0);
      if (cTColorMapping == null)
        return null; 
      return cTColorMapping;
    } 
  }
  
  public boolean isSetOverrideClrMapping() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OVERRIDECLRMAPPING$2) != 0);
    } 
  }
  
  public void setOverrideClrMapping(CTColorMapping paramCTColorMapping) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().find_element_user(OVERRIDECLRMAPPING$2, 0);
      if (cTColorMapping == null)
        cTColorMapping = (CTColorMapping)get_store().add_element_user(OVERRIDECLRMAPPING$2); 
      cTColorMapping.set((XmlObject)paramCTColorMapping);
    } 
  }
  
  public CTColorMapping addNewOverrideClrMapping() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().add_element_user(OVERRIDECLRMAPPING$2);
      return cTColorMapping;
    } 
  }
  
  public void unsetOverrideClrMapping() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OVERRIDECLRMAPPING$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTColorMappingOverrideImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */