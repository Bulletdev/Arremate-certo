package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;

public class CTTableColumnsImpl extends XmlComplexContentImpl implements CTTableColumns {
  private static final b TABLECOLUMN$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableColumn");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTTableColumnsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTableColumn> getTableColumnList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTableColumn>)new TableColumnList(this);
    } 
  }
  
  public CTTableColumn[] getTableColumnArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TABLECOLUMN$0, arrayList);
      CTTableColumn[] arrayOfCTTableColumn = new CTTableColumn[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTableColumn);
      return arrayOfCTTableColumn;
    } 
  }
  
  public CTTableColumn getTableColumnArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableColumn cTTableColumn = null;
      cTTableColumn = (CTTableColumn)get_store().find_element_user(TABLECOLUMN$0, paramInt);
      if (cTTableColumn == null)
        throw new IndexOutOfBoundsException(); 
      return cTTableColumn;
    } 
  }
  
  public int sizeOfTableColumnArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TABLECOLUMN$0);
    } 
  }
  
  public void setTableColumnArray(CTTableColumn[] paramArrayOfCTTableColumn) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTableColumn, TABLECOLUMN$0);
    } 
  }
  
  public void setTableColumnArray(int paramInt, CTTableColumn paramCTTableColumn) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableColumn cTTableColumn = null;
      cTTableColumn = (CTTableColumn)get_store().find_element_user(TABLECOLUMN$0, paramInt);
      if (cTTableColumn == null)
        throw new IndexOutOfBoundsException(); 
      cTTableColumn.set((XmlObject)paramCTTableColumn);
    } 
  }
  
  public CTTableColumn insertNewTableColumn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableColumn cTTableColumn = null;
      cTTableColumn = (CTTableColumn)get_store().insert_element_user(TABLECOLUMN$0, paramInt);
      return cTTableColumn;
    } 
  }
  
  public CTTableColumn addNewTableColumn() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableColumn cTTableColumn = null;
      cTTableColumn = (CTTableColumn)get_store().add_element_user(TABLECOLUMN$0);
      return cTTableColumn;
    } 
  }
  
  public void removeTableColumn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABLECOLUMN$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTTableColumnsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */