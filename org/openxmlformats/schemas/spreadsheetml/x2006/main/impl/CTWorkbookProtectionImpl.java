package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnsignedShortHex;

public class CTWorkbookProtectionImpl extends XmlComplexContentImpl implements CTWorkbookProtection {
  private static final b WORKBOOKPASSWORD$0 = new b("", "workbookPassword");
  
  private static final b REVISIONSPASSWORD$2 = new b("", "revisionsPassword");
  
  private static final b LOCKSTRUCTURE$4 = new b("", "lockStructure");
  
  private static final b LOCKWINDOWS$6 = new b("", "lockWindows");
  
  private static final b LOCKREVISION$8 = new b("", "lockRevision");
  
  public CTWorkbookProtectionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public byte[] getWorkbookPassword() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WORKBOOKPASSWORD$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUnsignedShortHex xgetWorkbookPassword() {
    synchronized (monitor()) {
      check_orphaned();
      STUnsignedShortHex sTUnsignedShortHex = null;
      sTUnsignedShortHex = (STUnsignedShortHex)get_store().find_attribute_user(WORKBOOKPASSWORD$0);
      return sTUnsignedShortHex;
    } 
  }
  
  public boolean isSetWorkbookPassword() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WORKBOOKPASSWORD$0) != null);
    } 
  }
  
  public void setWorkbookPassword(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WORKBOOKPASSWORD$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WORKBOOKPASSWORD$0); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetWorkbookPassword(STUnsignedShortHex paramSTUnsignedShortHex) {
    synchronized (monitor()) {
      check_orphaned();
      STUnsignedShortHex sTUnsignedShortHex = null;
      sTUnsignedShortHex = (STUnsignedShortHex)get_store().find_attribute_user(WORKBOOKPASSWORD$0);
      if (sTUnsignedShortHex == null)
        sTUnsignedShortHex = (STUnsignedShortHex)get_store().add_attribute_user(WORKBOOKPASSWORD$0); 
      sTUnsignedShortHex.set((XmlObject)paramSTUnsignedShortHex);
    } 
  }
  
  public void unsetWorkbookPassword() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WORKBOOKPASSWORD$0);
    } 
  }
  
  public byte[] getRevisionsPassword() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REVISIONSPASSWORD$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUnsignedShortHex xgetRevisionsPassword() {
    synchronized (monitor()) {
      check_orphaned();
      STUnsignedShortHex sTUnsignedShortHex = null;
      sTUnsignedShortHex = (STUnsignedShortHex)get_store().find_attribute_user(REVISIONSPASSWORD$2);
      return sTUnsignedShortHex;
    } 
  }
  
  public boolean isSetRevisionsPassword() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REVISIONSPASSWORD$2) != null);
    } 
  }
  
  public void setRevisionsPassword(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REVISIONSPASSWORD$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REVISIONSPASSWORD$2); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRevisionsPassword(STUnsignedShortHex paramSTUnsignedShortHex) {
    synchronized (monitor()) {
      check_orphaned();
      STUnsignedShortHex sTUnsignedShortHex = null;
      sTUnsignedShortHex = (STUnsignedShortHex)get_store().find_attribute_user(REVISIONSPASSWORD$2);
      if (sTUnsignedShortHex == null)
        sTUnsignedShortHex = (STUnsignedShortHex)get_store().add_attribute_user(REVISIONSPASSWORD$2); 
      sTUnsignedShortHex.set((XmlObject)paramSTUnsignedShortHex);
    } 
  }
  
  public void unsetRevisionsPassword() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REVISIONSPASSWORD$2);
    } 
  }
  
  public boolean getLockStructure() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKSTRUCTURE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LOCKSTRUCTURE$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLockStructure() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKSTRUCTURE$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(LOCKSTRUCTURE$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLockStructure() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LOCKSTRUCTURE$4) != null);
    } 
  }
  
  public void setLockStructure(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKSTRUCTURE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LOCKSTRUCTURE$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLockStructure(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKSTRUCTURE$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LOCKSTRUCTURE$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLockStructure() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LOCKSTRUCTURE$4);
    } 
  }
  
  public boolean getLockWindows() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKWINDOWS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LOCKWINDOWS$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLockWindows() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKWINDOWS$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(LOCKWINDOWS$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLockWindows() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LOCKWINDOWS$6) != null);
    } 
  }
  
  public void setLockWindows(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKWINDOWS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LOCKWINDOWS$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLockWindows(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKWINDOWS$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LOCKWINDOWS$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLockWindows() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LOCKWINDOWS$6);
    } 
  }
  
  public boolean getLockRevision() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKREVISION$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LOCKREVISION$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLockRevision() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKREVISION$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(LOCKREVISION$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLockRevision() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LOCKREVISION$8) != null);
    } 
  }
  
  public void setLockRevision(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKREVISION$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LOCKREVISION$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLockRevision(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKREVISION$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LOCKREVISION$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLockRevision() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LOCKREVISION$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTWorkbookProtectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */