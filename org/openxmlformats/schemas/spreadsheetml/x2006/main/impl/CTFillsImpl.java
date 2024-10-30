package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;

public class CTFillsImpl extends XmlComplexContentImpl implements CTFills {
  private static final b FILL$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fill");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTFillsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTFill> getFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFill>)new FillList(this);
    } 
  }
  
  public CTFill[] getFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FILL$0, arrayList);
      CTFill[] arrayOfCTFill = new CTFill[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFill);
      return arrayOfCTFill;
    } 
  }
  
  public CTFill getFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().find_element_user(FILL$0, paramInt);
      if (cTFill == null)
        throw new IndexOutOfBoundsException(); 
      return cTFill;
    } 
  }
  
  public int sizeOfFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FILL$0);
    } 
  }
  
  public void setFillArray(CTFill[] paramArrayOfCTFill) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFill, FILL$0);
    } 
  }
  
  public void setFillArray(int paramInt, CTFill paramCTFill) {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().find_element_user(FILL$0, paramInt);
      if (cTFill == null)
        throw new IndexOutOfBoundsException(); 
      cTFill.set((XmlObject)paramCTFill);
    } 
  }
  
  public CTFill insertNewFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().insert_element_user(FILL$0, paramInt);
      return cTFill;
    } 
  }
  
  public CTFill addNewFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().add_element_user(FILL$0);
      return cTFill;
    } 
  }
  
  public void removeFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILL$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTFillsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */