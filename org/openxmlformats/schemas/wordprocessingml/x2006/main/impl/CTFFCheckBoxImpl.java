package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;

public class CTFFCheckBoxImpl extends XmlComplexContentImpl implements CTFFCheckBox {
  private static final b SIZE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "size");
  
  private static final b SIZEAUTO$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sizeAuto");
  
  private static final b DEFAULT$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "default");
  
  private static final b CHECKED$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "checked");
  
  public CTFFCheckBoxImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTHpsMeasure getSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SIZE$0, 0);
      if (cTHpsMeasure == null)
        return null; 
      return cTHpsMeasure;
    } 
  }
  
  public boolean isSetSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SIZE$0) != 0);
    } 
  }
  
  public void setSize(CTHpsMeasure paramCTHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SIZE$0, 0);
      if (cTHpsMeasure == null)
        cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SIZE$0); 
      cTHpsMeasure.set((XmlObject)paramCTHpsMeasure);
    } 
  }
  
  public CTHpsMeasure addNewSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SIZE$0);
      return cTHpsMeasure;
    } 
  }
  
  public void unsetSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SIZE$0, 0);
    } 
  }
  
  public CTOnOff getSizeAuto() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SIZEAUTO$2, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSizeAuto() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SIZEAUTO$2) != 0);
    } 
  }
  
  public void setSizeAuto(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SIZEAUTO$2, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SIZEAUTO$2); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSizeAuto() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SIZEAUTO$2);
      return cTOnOff;
    } 
  }
  
  public void unsetSizeAuto() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SIZEAUTO$2, 0);
    } 
  }
  
  public CTOnOff getDefault() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DEFAULT$4, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDefault() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEFAULT$4) != 0);
    } 
  }
  
  public void setDefault(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DEFAULT$4, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DEFAULT$4); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDefault() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DEFAULT$4);
      return cTOnOff;
    } 
  }
  
  public void unsetDefault() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFAULT$4, 0);
    } 
  }
  
  public CTOnOff getChecked() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CHECKED$6, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetChecked() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CHECKED$6) != 0);
    } 
  }
  
  public void setChecked(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CHECKED$6, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(CHECKED$6); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewChecked() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(CHECKED$6);
      return cTOnOff;
    } 
  }
  
  public void unsetChecked() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHECKED$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTFFCheckBoxImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */