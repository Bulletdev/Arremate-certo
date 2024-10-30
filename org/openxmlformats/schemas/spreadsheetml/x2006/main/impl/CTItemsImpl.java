package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems;

public class CTItemsImpl extends XmlComplexContentImpl implements CTItems {
  private static final b ITEM$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "item");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTItemsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTItem> getItemList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTItem>)new ItemList(this);
    } 
  }
  
  public CTItem[] getItemArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ITEM$0, arrayList);
      CTItem[] arrayOfCTItem = new CTItem[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTItem);
      return arrayOfCTItem;
    } 
  }
  
  public CTItem getItemArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTItem cTItem = null;
      cTItem = (CTItem)get_store().find_element_user(ITEM$0, paramInt);
      if (cTItem == null)
        throw new IndexOutOfBoundsException(); 
      return cTItem;
    } 
  }
  
  public int sizeOfItemArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ITEM$0);
    } 
  }
  
  public void setItemArray(CTItem[] paramArrayOfCTItem) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTItem, ITEM$0);
    } 
  }
  
  public void setItemArray(int paramInt, CTItem paramCTItem) {
    synchronized (monitor()) {
      check_orphaned();
      CTItem cTItem = null;
      cTItem = (CTItem)get_store().find_element_user(ITEM$0, paramInt);
      if (cTItem == null)
        throw new IndexOutOfBoundsException(); 
      cTItem.set((XmlObject)paramCTItem);
    } 
  }
  
  public CTItem insertNewItem(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTItem cTItem = null;
      cTItem = (CTItem)get_store().insert_element_user(ITEM$0, paramInt);
      return cTItem;
    } 
  }
  
  public CTItem addNewItem() {
    synchronized (monitor()) {
      check_orphaned();
      CTItem cTItem = null;
      cTItem = (CTItem)get_store().add_element_user(ITEM$0);
      return cTItem;
    } 
  }
  
  public void removeItem(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ITEM$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTItemsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */