package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields;

public class CTCacheFieldsImpl extends XmlComplexContentImpl implements CTCacheFields {
  private static final b CACHEFIELD$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cacheField");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTCacheFieldsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCacheField> getCacheFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCacheField>)new CacheFieldList(this);
    } 
  }
  
  public CTCacheField[] getCacheFieldArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CACHEFIELD$0, arrayList);
      CTCacheField[] arrayOfCTCacheField = new CTCacheField[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCacheField);
      return arrayOfCTCacheField;
    } 
  }
  
  public CTCacheField getCacheFieldArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheField cTCacheField = null;
      cTCacheField = (CTCacheField)get_store().find_element_user(CACHEFIELD$0, paramInt);
      if (cTCacheField == null)
        throw new IndexOutOfBoundsException(); 
      return cTCacheField;
    } 
  }
  
  public int sizeOfCacheFieldArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CACHEFIELD$0);
    } 
  }
  
  public void setCacheFieldArray(CTCacheField[] paramArrayOfCTCacheField) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCacheField, CACHEFIELD$0);
    } 
  }
  
  public void setCacheFieldArray(int paramInt, CTCacheField paramCTCacheField) {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheField cTCacheField = null;
      cTCacheField = (CTCacheField)get_store().find_element_user(CACHEFIELD$0, paramInt);
      if (cTCacheField == null)
        throw new IndexOutOfBoundsException(); 
      cTCacheField.set((XmlObject)paramCTCacheField);
    } 
  }
  
  public CTCacheField insertNewCacheField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheField cTCacheField = null;
      cTCacheField = (CTCacheField)get_store().insert_element_user(CACHEFIELD$0, paramInt);
      return cTCacheField;
    } 
  }
  
  public CTCacheField addNewCacheField() {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheField cTCacheField = null;
      cTCacheField = (CTCacheField)get_store().add_element_user(CACHEFIELD$0);
      return cTCacheField;
    } 
  }
  
  public void removeCacheField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CACHEFIELD$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCacheFieldsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */