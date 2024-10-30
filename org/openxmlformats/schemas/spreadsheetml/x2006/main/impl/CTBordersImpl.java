package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;

public class CTBordersImpl extends XmlComplexContentImpl implements CTBorders {
  private static final b BORDER$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "border");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTBordersImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTBorder> getBorderList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBorder>)new BorderList(this);
    } 
  }
  
  public CTBorder[] getBorderArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BORDER$0, arrayList);
      CTBorder[] arrayOfCTBorder = new CTBorder[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBorder);
      return arrayOfCTBorder;
    } 
  }
  
  public CTBorder getBorderArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDER$0, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      return cTBorder;
    } 
  }
  
  public int sizeOfBorderArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BORDER$0);
    } 
  }
  
  public void setBorderArray(CTBorder[] paramArrayOfCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBorder, BORDER$0);
    } 
  }
  
  public void setBorderArray(int paramInt, CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDER$0, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder insertNewBorder(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().insert_element_user(BORDER$0, paramInt);
      return cTBorder;
    } 
  }
  
  public CTBorder addNewBorder() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BORDER$0);
      return cTBorder;
    } 
  }
  
  public void removeBorder(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDER$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTBordersImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */