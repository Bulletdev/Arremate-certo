package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;

public class CTTablePartsImpl extends XmlComplexContentImpl implements CTTableParts {
  private static final b TABLEPART$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tablePart");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTTablePartsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTablePart> getTablePartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTablePart>)new TablePartList(this);
    } 
  }
  
  public CTTablePart[] getTablePartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TABLEPART$0, arrayList);
      CTTablePart[] arrayOfCTTablePart = new CTTablePart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTablePart);
      return arrayOfCTTablePart;
    } 
  }
  
  public CTTablePart getTablePartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePart cTTablePart = null;
      cTTablePart = (CTTablePart)get_store().find_element_user(TABLEPART$0, paramInt);
      if (cTTablePart == null)
        throw new IndexOutOfBoundsException(); 
      return cTTablePart;
    } 
  }
  
  public int sizeOfTablePartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TABLEPART$0);
    } 
  }
  
  public void setTablePartArray(CTTablePart[] paramArrayOfCTTablePart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTablePart, TABLEPART$0);
    } 
  }
  
  public void setTablePartArray(int paramInt, CTTablePart paramCTTablePart) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePart cTTablePart = null;
      cTTablePart = (CTTablePart)get_store().find_element_user(TABLEPART$0, paramInt);
      if (cTTablePart == null)
        throw new IndexOutOfBoundsException(); 
      cTTablePart.set((XmlObject)paramCTTablePart);
    } 
  }
  
  public CTTablePart insertNewTablePart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePart cTTablePart = null;
      cTTablePart = (CTTablePart)get_store().insert_element_user(TABLEPART$0, paramInt);
      return cTTablePart;
    } 
  }
  
  public CTTablePart addNewTablePart() {
    synchronized (monitor()) {
      check_orphaned();
      CTTablePart cTTablePart = null;
      cTTablePart = (CTTablePart)get_store().add_element_user(TABLEPART$0);
      return cTTablePart;
    } 
  }
  
  public void removeTablePart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABLEPART$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTTablePartsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */