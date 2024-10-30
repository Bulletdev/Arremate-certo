package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields;

public class CTRowFieldsImpl extends XmlComplexContentImpl implements CTRowFields {
  private static final b FIELD$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "field");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTRowFieldsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTField> getFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTField>)new FieldList(this);
    } 
  }
  
  public CTField[] getFieldArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FIELD$0, arrayList);
      CTField[] arrayOfCTField = new CTField[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTField);
      return arrayOfCTField;
    } 
  }
  
  public CTField getFieldArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTField cTField = null;
      cTField = (CTField)get_store().find_element_user(FIELD$0, paramInt);
      if (cTField == null)
        throw new IndexOutOfBoundsException(); 
      return cTField;
    } 
  }
  
  public int sizeOfFieldArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FIELD$0);
    } 
  }
  
  public void setFieldArray(CTField[] paramArrayOfCTField) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTField, FIELD$0);
    } 
  }
  
  public void setFieldArray(int paramInt, CTField paramCTField) {
    synchronized (monitor()) {
      check_orphaned();
      CTField cTField = null;
      cTField = (CTField)get_store().find_element_user(FIELD$0, paramInt);
      if (cTField == null)
        throw new IndexOutOfBoundsException(); 
      cTField.set((XmlObject)paramCTField);
    } 
  }
  
  public CTField insertNewField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTField cTField = null;
      cTField = (CTField)get_store().insert_element_user(FIELD$0, paramInt);
      return cTField;
    } 
  }
  
  public CTField addNewField() {
    synchronized (monitor()) {
      check_orphaned();
      CTField cTField = null;
      cTField = (CTField)get_store().add_element_user(FIELD$0);
      return cTField;
    } 
  }
  
  public void removeField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FIELD$0, paramInt);
    } 
  }
  
  public long getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COUNT$2); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(COUNT$2); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNT$2) != null);
    } 
  }
  
  public void setCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNT$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COUNT$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNT$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTRowFieldsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */