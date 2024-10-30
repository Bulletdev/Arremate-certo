package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields;

public class CTPivotFieldsImpl extends XmlComplexContentImpl implements CTPivotFields {
  private static final b PIVOTFIELD$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotField");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTPivotFieldsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTPivotField> getPivotFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPivotField>)new PivotFieldList(this);
    } 
  }
  
  public CTPivotField[] getPivotFieldArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PIVOTFIELD$0, arrayList);
      CTPivotField[] arrayOfCTPivotField = new CTPivotField[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPivotField);
      return arrayOfCTPivotField;
    } 
  }
  
  public CTPivotField getPivotFieldArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotField cTPivotField = null;
      cTPivotField = (CTPivotField)get_store().find_element_user(PIVOTFIELD$0, paramInt);
      if (cTPivotField == null)
        throw new IndexOutOfBoundsException(); 
      return cTPivotField;
    } 
  }
  
  public int sizeOfPivotFieldArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PIVOTFIELD$0);
    } 
  }
  
  public void setPivotFieldArray(CTPivotField[] paramArrayOfCTPivotField) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPivotField, PIVOTFIELD$0);
    } 
  }
  
  public void setPivotFieldArray(int paramInt, CTPivotField paramCTPivotField) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotField cTPivotField = null;
      cTPivotField = (CTPivotField)get_store().find_element_user(PIVOTFIELD$0, paramInt);
      if (cTPivotField == null)
        throw new IndexOutOfBoundsException(); 
      cTPivotField.set((XmlObject)paramCTPivotField);
    } 
  }
  
  public CTPivotField insertNewPivotField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotField cTPivotField = null;
      cTPivotField = (CTPivotField)get_store().insert_element_user(PIVOTFIELD$0, paramInt);
      return cTPivotField;
    } 
  }
  
  public CTPivotField addNewPivotField() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotField cTPivotField = null;
      cTPivotField = (CTPivotField)get_store().add_element_user(PIVOTFIELD$0);
      return cTPivotField;
    } 
  }
  
  public void removePivotField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTFIELD$0, paramInt);
    } 
  }
  
  public long getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$2);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPivotFieldsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */