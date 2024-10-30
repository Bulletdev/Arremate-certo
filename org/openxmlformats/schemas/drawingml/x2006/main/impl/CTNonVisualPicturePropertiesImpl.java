package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPictureLocking;

public class CTNonVisualPicturePropertiesImpl extends XmlComplexContentImpl implements CTNonVisualPictureProperties {
  private static final b PICLOCKS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "picLocks");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b PREFERRELATIVERESIZE$4 = new b("", "preferRelativeResize");
  
  public CTNonVisualPicturePropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPictureLocking getPicLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureLocking cTPictureLocking = null;
      cTPictureLocking = (CTPictureLocking)get_store().find_element_user(PICLOCKS$0, 0);
      if (cTPictureLocking == null)
        return null; 
      return cTPictureLocking;
    } 
  }
  
  public boolean isSetPicLocks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PICLOCKS$0) != 0);
    } 
  }
  
  public void setPicLocks(CTPictureLocking paramCTPictureLocking) {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureLocking cTPictureLocking = null;
      cTPictureLocking = (CTPictureLocking)get_store().find_element_user(PICLOCKS$0, 0);
      if (cTPictureLocking == null)
        cTPictureLocking = (CTPictureLocking)get_store().add_element_user(PICLOCKS$0); 
      cTPictureLocking.set((XmlObject)paramCTPictureLocking);
    } 
  }
  
  public CTPictureLocking addNewPicLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureLocking cTPictureLocking = null;
      cTPictureLocking = (CTPictureLocking)get_store().add_element_user(PICLOCKS$0);
      return cTPictureLocking;
    } 
  }
  
  public void unsetPicLocks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PICLOCKS$0, 0);
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
  
  public boolean getPreferRelativeResize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PREFERRELATIVERESIZE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PREFERRELATIVERESIZE$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPreferRelativeResize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PREFERRELATIVERESIZE$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PREFERRELATIVERESIZE$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPreferRelativeResize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PREFERRELATIVERESIZE$4) != null);
    } 
  }
  
  public void setPreferRelativeResize(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PREFERRELATIVERESIZE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PREFERRELATIVERESIZE$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPreferRelativeResize(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PREFERRELATIVERESIZE$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PREFERRELATIVERESIZE$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPreferRelativeResize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PREFERRELATIVERESIZE$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTNonVisualPicturePropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */