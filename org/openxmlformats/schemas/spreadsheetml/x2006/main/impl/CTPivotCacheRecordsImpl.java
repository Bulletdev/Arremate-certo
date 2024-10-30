package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRecord;

public class CTPivotCacheRecordsImpl extends XmlComplexContentImpl implements CTPivotCacheRecords {
  private static final b R$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "r");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b COUNT$4 = new b("", "count");
  
  public CTPivotCacheRecordsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTRecord> getRList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRecord>)new RList(this);
    } 
  }
  
  public CTRecord[] getRArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R$0, arrayList);
      CTRecord[] arrayOfCTRecord = new CTRecord[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRecord);
      return arrayOfCTRecord;
    } 
  }
  
  public CTRecord getRArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRecord cTRecord = null;
      cTRecord = (CTRecord)get_store().find_element_user(R$0, paramInt);
      if (cTRecord == null)
        throw new IndexOutOfBoundsException(); 
      return cTRecord;
    } 
  }
  
  public int sizeOfRArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(R$0);
    } 
  }
  
  public void setRArray(CTRecord[] paramArrayOfCTRecord) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRecord, R$0);
    } 
  }
  
  public void setRArray(int paramInt, CTRecord paramCTRecord) {
    synchronized (monitor()) {
      check_orphaned();
      CTRecord cTRecord = null;
      cTRecord = (CTRecord)get_store().find_element_user(R$0, paramInt);
      if (cTRecord == null)
        throw new IndexOutOfBoundsException(); 
      cTRecord.set((XmlObject)paramCTRecord);
    } 
  }
  
  public CTRecord insertNewR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRecord cTRecord = null;
      cTRecord = (CTRecord)get_store().insert_element_user(R$0, paramInt);
      return cTRecord;
    } 
  }
  
  public CTRecord addNewR() {
    synchronized (monitor()) {
      check_orphaned();
      CTRecord cTRecord = null;
      cTRecord = (CTRecord)get_store().add_element_user(R$0);
      return cTRecord;
    } 
  }
  
  public void removeR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R$0, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
  
  public long getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$4);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNT$4) != null);
    } 
  }
  
  public void setCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNT$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COUNT$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNT$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPivotCacheRecordsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */