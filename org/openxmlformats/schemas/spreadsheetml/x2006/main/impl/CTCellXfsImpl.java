package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;

public class CTCellXfsImpl extends XmlComplexContentImpl implements CTCellXfs {
  private static final b XF$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "xf");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTCellXfsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTXf> getXfList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTXf>)new XfList(this);
    } 
  }
  
  public CTXf[] getXfArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(XF$0, arrayList);
      CTXf[] arrayOfCTXf = new CTXf[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTXf);
      return arrayOfCTXf;
    } 
  }
  
  public CTXf getXfArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTXf cTXf = null;
      cTXf = (CTXf)get_store().find_element_user(XF$0, paramInt);
      if (cTXf == null)
        throw new IndexOutOfBoundsException(); 
      return cTXf;
    } 
  }
  
  public int sizeOfXfArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(XF$0);
    } 
  }
  
  public void setXfArray(CTXf[] paramArrayOfCTXf) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTXf, XF$0);
    } 
  }
  
  public void setXfArray(int paramInt, CTXf paramCTXf) {
    synchronized (monitor()) {
      check_orphaned();
      CTXf cTXf = null;
      cTXf = (CTXf)get_store().find_element_user(XF$0, paramInt);
      if (cTXf == null)
        throw new IndexOutOfBoundsException(); 
      cTXf.set((XmlObject)paramCTXf);
    } 
  }
  
  public CTXf insertNewXf(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTXf cTXf = null;
      cTXf = (CTXf)get_store().insert_element_user(XF$0, paramInt);
      return cTXf;
    } 
  }
  
  public CTXf addNewXf() {
    synchronized (monitor()) {
      check_orphaned();
      CTXf cTXf = null;
      cTXf = (CTXf)get_store().add_element_user(XF$0);
      return cTXf;
    } 
  }
  
  public void removeXf(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(XF$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCellXfsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */