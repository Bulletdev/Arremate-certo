package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields;

public class CTDataFieldsImpl extends XmlComplexContentImpl implements CTDataFields {
  private static final b DATAFIELD$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataField");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTDataFieldsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTDataField> getDataFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      final class DataFieldList extends AbstractList<CTDataField> {
        public CTDataField get(int param1Int) {
          return CTDataFieldsImpl.this.getDataFieldArray(param1Int);
        }
        
        public CTDataField set(int param1Int, CTDataField param1CTDataField) {
          CTDataField cTDataField = CTDataFieldsImpl.this.getDataFieldArray(param1Int);
          CTDataFieldsImpl.this.setDataFieldArray(param1Int, param1CTDataField);
          return cTDataField;
        }
        
        public void add(int param1Int, CTDataField param1CTDataField) {
          CTDataFieldsImpl.this.insertNewDataField(param1Int).set((XmlObject)param1CTDataField);
        }
        
        public CTDataField remove(int param1Int) {
          CTDataField cTDataField = CTDataFieldsImpl.this.getDataFieldArray(param1Int);
          CTDataFieldsImpl.this.removeDataField(param1Int);
          return cTDataField;
        }
        
        public int size() {
          return CTDataFieldsImpl.this.sizeOfDataFieldArray();
        }
      };
      return new DataFieldList();
    } 
  }
  
  public CTDataField[] getDataFieldArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DATAFIELD$0, arrayList);
      CTDataField[] arrayOfCTDataField = new CTDataField[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDataField);
      return arrayOfCTDataField;
    } 
  }
  
  public CTDataField getDataFieldArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataField cTDataField = null;
      cTDataField = (CTDataField)get_store().find_element_user(DATAFIELD$0, paramInt);
      if (cTDataField == null)
        throw new IndexOutOfBoundsException(); 
      return cTDataField;
    } 
  }
  
  public int sizeOfDataFieldArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DATAFIELD$0);
    } 
  }
  
  public void setDataFieldArray(CTDataField[] paramArrayOfCTDataField) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDataField, DATAFIELD$0);
    } 
  }
  
  public void setDataFieldArray(int paramInt, CTDataField paramCTDataField) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataField cTDataField = null;
      cTDataField = (CTDataField)get_store().find_element_user(DATAFIELD$0, paramInt);
      if (cTDataField == null)
        throw new IndexOutOfBoundsException(); 
      cTDataField.set((XmlObject)paramCTDataField);
    } 
  }
  
  public CTDataField insertNewDataField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataField cTDataField = null;
      cTDataField = (CTDataField)get_store().insert_element_user(DATAFIELD$0, paramInt);
      return cTDataField;
    } 
  }
  
  public CTDataField addNewDataField() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataField cTDataField = null;
      cTDataField = (CTDataField)get_store().add_element_user(DATAFIELD$0);
      return cTDataField;
    } 
  }
  
  public void removeDataField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATAFIELD$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDataFieldsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */