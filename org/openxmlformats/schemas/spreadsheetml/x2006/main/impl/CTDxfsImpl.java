package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;

public class CTDxfsImpl extends XmlComplexContentImpl implements CTDxfs {
  private static final b DXF$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dxf");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTDxfsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTDxf> getDxfList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDxf>)new DxfList(this);
    } 
  }
  
  public CTDxf[] getDxfArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DXF$0, arrayList);
      CTDxf[] arrayOfCTDxf = new CTDxf[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDxf);
      return arrayOfCTDxf;
    } 
  }
  
  public CTDxf getDxfArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDxf cTDxf = null;
      cTDxf = (CTDxf)get_store().find_element_user(DXF$0, paramInt);
      if (cTDxf == null)
        throw new IndexOutOfBoundsException(); 
      return cTDxf;
    } 
  }
  
  public int sizeOfDxfArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DXF$0);
    } 
  }
  
  public void setDxfArray(CTDxf[] paramArrayOfCTDxf) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDxf, DXF$0);
    } 
  }
  
  public void setDxfArray(int paramInt, CTDxf paramCTDxf) {
    synchronized (monitor()) {
      check_orphaned();
      CTDxf cTDxf = null;
      cTDxf = (CTDxf)get_store().find_element_user(DXF$0, paramInt);
      if (cTDxf == null)
        throw new IndexOutOfBoundsException(); 
      cTDxf.set((XmlObject)paramCTDxf);
    } 
  }
  
  public CTDxf insertNewDxf(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDxf cTDxf = null;
      cTDxf = (CTDxf)get_store().insert_element_user(DXF$0, paramInt);
      return cTDxf;
    } 
  }
  
  public CTDxf addNewDxf() {
    synchronized (monitor()) {
      check_orphaned();
      CTDxf cTDxf = null;
      cTDxf = (CTDxf)get_store().add_element_user(DXF$0);
      return cTDxf;
    } 
  }
  
  public void removeDxf(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DXF$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDxfsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */