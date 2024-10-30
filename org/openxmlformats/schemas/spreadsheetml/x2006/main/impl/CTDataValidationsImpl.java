package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidations;

public class CTDataValidationsImpl extends XmlComplexContentImpl implements CTDataValidations {
  private static final b DATAVALIDATION$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataValidation");
  
  private static final b DISABLEPROMPTS$2 = new b("", "disablePrompts");
  
  private static final b XWINDOW$4 = new b("", "xWindow");
  
  private static final b YWINDOW$6 = new b("", "yWindow");
  
  private static final b COUNT$8 = new b("", "count");
  
  public CTDataValidationsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTDataValidation> getDataValidationList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDataValidation>)new DataValidationList(this);
    } 
  }
  
  public CTDataValidation[] getDataValidationArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DATAVALIDATION$0, arrayList);
      CTDataValidation[] arrayOfCTDataValidation = new CTDataValidation[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDataValidation);
      return arrayOfCTDataValidation;
    } 
  }
  
  public CTDataValidation getDataValidationArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataValidation cTDataValidation = null;
      cTDataValidation = (CTDataValidation)get_store().find_element_user(DATAVALIDATION$0, paramInt);
      if (cTDataValidation == null)
        throw new IndexOutOfBoundsException(); 
      return cTDataValidation;
    } 
  }
  
  public int sizeOfDataValidationArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DATAVALIDATION$0);
    } 
  }
  
  public void setDataValidationArray(CTDataValidation[] paramArrayOfCTDataValidation) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDataValidation, DATAVALIDATION$0);
    } 
  }
  
  public void setDataValidationArray(int paramInt, CTDataValidation paramCTDataValidation) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataValidation cTDataValidation = null;
      cTDataValidation = (CTDataValidation)get_store().find_element_user(DATAVALIDATION$0, paramInt);
      if (cTDataValidation == null)
        throw new IndexOutOfBoundsException(); 
      cTDataValidation.set((XmlObject)paramCTDataValidation);
    } 
  }
  
  public CTDataValidation insertNewDataValidation(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataValidation cTDataValidation = null;
      cTDataValidation = (CTDataValidation)get_store().insert_element_user(DATAVALIDATION$0, paramInt);
      return cTDataValidation;
    } 
  }
  
  public CTDataValidation addNewDataValidation() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataValidation cTDataValidation = null;
      cTDataValidation = (CTDataValidation)get_store().add_element_user(DATAVALIDATION$0);
      return cTDataValidation;
    } 
  }
  
  public void removeDataValidation(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATAVALIDATION$0, paramInt);
    } 
  }
  
  public boolean getDisablePrompts() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISABLEPROMPTS$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DISABLEPROMPTS$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDisablePrompts() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DISABLEPROMPTS$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DISABLEPROMPTS$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDisablePrompts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISABLEPROMPTS$2) != null);
    } 
  }
  
  public void setDisablePrompts(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISABLEPROMPTS$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISABLEPROMPTS$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDisablePrompts(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DISABLEPROMPTS$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DISABLEPROMPTS$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDisablePrompts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISABLEPROMPTS$2);
    } 
  }
  
  public long getXWindow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XWINDOW$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetXWindow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(XWINDOW$4);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetXWindow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(XWINDOW$4) != null);
    } 
  }
  
  public void setXWindow(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XWINDOW$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XWINDOW$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetXWindow(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(XWINDOW$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(XWINDOW$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetXWindow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(XWINDOW$4);
    } 
  }
  
  public long getYWindow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(YWINDOW$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetYWindow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(YWINDOW$6);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetYWindow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(YWINDOW$6) != null);
    } 
  }
  
  public void setYWindow(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(YWINDOW$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(YWINDOW$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetYWindow(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(YWINDOW$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(YWINDOW$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetYWindow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(YWINDOW$6);
    } 
  }
  
  public long getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$8);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$8);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNT$8) != null);
    } 
  }
  
  public void setCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNT$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COUNT$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNT$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDataValidationsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */