package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOrientation;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;

public class CTScalingImpl extends XmlComplexContentImpl implements CTScaling {
  private static final b LOGBASE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "logBase");
  
  private static final b ORIENTATION$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "orientation");
  
  private static final b MAX$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "max");
  
  private static final b MIN$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "min");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTScalingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTLogBase getLogBase() {
    synchronized (monitor()) {
      check_orphaned();
      CTLogBase cTLogBase = null;
      cTLogBase = (CTLogBase)get_store().find_element_user(LOGBASE$0, 0);
      if (cTLogBase == null)
        return null; 
      return cTLogBase;
    } 
  }
  
  public boolean isSetLogBase() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LOGBASE$0) != 0);
    } 
  }
  
  public void setLogBase(CTLogBase paramCTLogBase) {
    synchronized (monitor()) {
      check_orphaned();
      CTLogBase cTLogBase = null;
      cTLogBase = (CTLogBase)get_store().find_element_user(LOGBASE$0, 0);
      if (cTLogBase == null)
        cTLogBase = (CTLogBase)get_store().add_element_user(LOGBASE$0); 
      cTLogBase.set((XmlObject)paramCTLogBase);
    } 
  }
  
  public CTLogBase addNewLogBase() {
    synchronized (monitor()) {
      check_orphaned();
      CTLogBase cTLogBase = null;
      cTLogBase = (CTLogBase)get_store().add_element_user(LOGBASE$0);
      return cTLogBase;
    } 
  }
  
  public void unsetLogBase() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LOGBASE$0, 0);
    } 
  }
  
  public CTOrientation getOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      CTOrientation cTOrientation = null;
      cTOrientation = (CTOrientation)get_store().find_element_user(ORIENTATION$2, 0);
      if (cTOrientation == null)
        return null; 
      return cTOrientation;
    } 
  }
  
  public boolean isSetOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ORIENTATION$2) != 0);
    } 
  }
  
  public void setOrientation(CTOrientation paramCTOrientation) {
    synchronized (monitor()) {
      check_orphaned();
      CTOrientation cTOrientation = null;
      cTOrientation = (CTOrientation)get_store().find_element_user(ORIENTATION$2, 0);
      if (cTOrientation == null)
        cTOrientation = (CTOrientation)get_store().add_element_user(ORIENTATION$2); 
      cTOrientation.set((XmlObject)paramCTOrientation);
    } 
  }
  
  public CTOrientation addNewOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      CTOrientation cTOrientation = null;
      cTOrientation = (CTOrientation)get_store().add_element_user(ORIENTATION$2);
      return cTOrientation;
    } 
  }
  
  public void unsetOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ORIENTATION$2, 0);
    } 
  }
  
  public CTDouble getMax() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(MAX$4, 0);
      if (cTDouble == null)
        return null; 
      return cTDouble;
    } 
  }
  
  public boolean isSetMax() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MAX$4) != 0);
    } 
  }
  
  public void setMax(CTDouble paramCTDouble) {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(MAX$4, 0);
      if (cTDouble == null)
        cTDouble = (CTDouble)get_store().add_element_user(MAX$4); 
      cTDouble.set((XmlObject)paramCTDouble);
    } 
  }
  
  public CTDouble addNewMax() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().add_element_user(MAX$4);
      return cTDouble;
    } 
  }
  
  public void unsetMax() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MAX$4, 0);
    } 
  }
  
  public CTDouble getMin() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(MIN$6, 0);
      if (cTDouble == null)
        return null; 
      return cTDouble;
    } 
  }
  
  public boolean isSetMin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MIN$6) != 0);
    } 
  }
  
  public void setMin(CTDouble paramCTDouble) {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(MIN$6, 0);
      if (cTDouble == null)
        cTDouble = (CTDouble)get_store().add_element_user(MIN$6); 
      cTDouble.set((XmlObject)paramCTDouble);
    } 
  }
  
  public CTDouble addNewMin() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().add_element_user(MIN$6);
      return cTDouble;
    } 
  }
  
  public void unsetMin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MIN$6, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$8) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$8); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$8);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$8, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTScalingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */