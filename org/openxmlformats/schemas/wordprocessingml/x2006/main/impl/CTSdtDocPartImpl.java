package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;

public class CTSdtDocPartImpl extends XmlComplexContentImpl implements CTSdtDocPart {
  private static final b DOCPARTGALLERY$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartGallery");
  
  private static final b DOCPARTCATEGORY$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartCategory");
  
  private static final b DOCPARTUNIQUE$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartUnique");
  
  public CTSdtDocPartImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTString getDocPartGallery() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(DOCPARTGALLERY$0, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetDocPartGallery() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCPARTGALLERY$0) != 0);
    } 
  }
  
  public void setDocPartGallery(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(DOCPARTGALLERY$0, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(DOCPARTGALLERY$0); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewDocPartGallery() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(DOCPARTGALLERY$0);
      return cTString;
    } 
  }
  
  public void unsetDocPartGallery() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCPARTGALLERY$0, 0);
    } 
  }
  
  public CTString getDocPartCategory() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(DOCPARTCATEGORY$2, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetDocPartCategory() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCPARTCATEGORY$2) != 0);
    } 
  }
  
  public void setDocPartCategory(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(DOCPARTCATEGORY$2, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(DOCPARTCATEGORY$2); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewDocPartCategory() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(DOCPARTCATEGORY$2);
      return cTString;
    } 
  }
  
  public void unsetDocPartCategory() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCPARTCATEGORY$2, 0);
    } 
  }
  
  public CTOnOff getDocPartUnique() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DOCPARTUNIQUE$4, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDocPartUnique() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCPARTUNIQUE$4) != 0);
    } 
  }
  
  public void setDocPartUnique(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DOCPARTUNIQUE$4, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DOCPARTUNIQUE$4); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDocPartUnique() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DOCPARTUNIQUE$4);
      return cTOnOff;
    } 
  }
  
  public void unsetDocPartUnique() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCPARTUNIQUE$4, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSdtDocPartImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */