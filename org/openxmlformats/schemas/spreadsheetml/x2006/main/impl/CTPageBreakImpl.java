package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;

public class CTPageBreakImpl extends XmlComplexContentImpl implements CTPageBreak {
  private static final b BRK$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "brk");
  
  private static final b COUNT$2 = new b("", "count");
  
  private static final b MANUALBREAKCOUNT$4 = new b("", "manualBreakCount");
  
  public CTPageBreakImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTBreak> getBrkList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBreak>)new BrkList(this);
    } 
  }
  
  public CTBreak[] getBrkArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BRK$0, arrayList);
      CTBreak[] arrayOfCTBreak = new CTBreak[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBreak);
      return arrayOfCTBreak;
    } 
  }
  
  public CTBreak getBrkArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBreak cTBreak = null;
      cTBreak = (CTBreak)get_store().find_element_user(BRK$0, paramInt);
      if (cTBreak == null)
        throw new IndexOutOfBoundsException(); 
      return cTBreak;
    } 
  }
  
  public int sizeOfBrkArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BRK$0);
    } 
  }
  
  public void setBrkArray(CTBreak[] paramArrayOfCTBreak) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBreak, BRK$0);
    } 
  }
  
  public void setBrkArray(int paramInt, CTBreak paramCTBreak) {
    synchronized (monitor()) {
      check_orphaned();
      CTBreak cTBreak = null;
      cTBreak = (CTBreak)get_store().find_element_user(BRK$0, paramInt);
      if (cTBreak == null)
        throw new IndexOutOfBoundsException(); 
      cTBreak.set((XmlObject)paramCTBreak);
    } 
  }
  
  public CTBreak insertNewBrk(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBreak cTBreak = null;
      cTBreak = (CTBreak)get_store().insert_element_user(BRK$0, paramInt);
      return cTBreak;
    } 
  }
  
  public CTBreak addNewBrk() {
    synchronized (monitor()) {
      check_orphaned();
      CTBreak cTBreak = null;
      cTBreak = (CTBreak)get_store().add_element_user(BRK$0);
      return cTBreak;
    } 
  }
  
  public void removeBrk(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BRK$0, paramInt);
    } 
  }
  
  public long getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COUNT$2); 
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
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(COUNT$2); 
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
  
  public long getManualBreakCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MANUALBREAKCOUNT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MANUALBREAKCOUNT$4); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetManualBreakCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MANUALBREAKCOUNT$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(MANUALBREAKCOUNT$4); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetManualBreakCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MANUALBREAKCOUNT$4) != null);
    } 
  }
  
  public void setManualBreakCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MANUALBREAKCOUNT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MANUALBREAKCOUNT$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetManualBreakCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MANUALBREAKCOUNT$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MANUALBREAKCOUNT$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetManualBreakCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MANUALBREAKCOUNT$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPageBreakImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */