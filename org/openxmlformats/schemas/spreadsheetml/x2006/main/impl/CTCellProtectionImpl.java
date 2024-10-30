package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellProtection;

public class CTCellProtectionImpl extends XmlComplexContentImpl implements CTCellProtection {
  private static final b LOCKED$0 = new b("", "locked");
  
  private static final b HIDDEN$2 = new b("", "hidden");
  
  public CTCellProtectionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public boolean getLocked() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKED$0);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKED$0);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LOCKED$0) != null);
    } 
  }
  
  public void setLocked(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKED$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LOCKED$0); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLocked(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKED$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LOCKED$0); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LOCKED$0);
    } 
  }
  
  public boolean getHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$2);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$2);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDDEN$2) != null);
    } 
  }
  
  public void setHidden(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDDEN$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHidden(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDDEN$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDDEN$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCellProtectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */