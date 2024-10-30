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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;

public class CTSstImpl extends XmlComplexContentImpl implements CTSst {
  private static final b SI$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "si");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b COUNT$4 = new b("", "count");
  
  private static final b UNIQUECOUNT$6 = new b("", "uniqueCount");
  
  public CTSstImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTRst> getSiList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRst>)new SiList(this);
    } 
  }
  
  public CTRst[] getSiArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SI$0, arrayList);
      CTRst[] arrayOfCTRst = new CTRst[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRst);
      return arrayOfCTRst;
    } 
  }
  
  public CTRst getSiArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().find_element_user(SI$0, paramInt);
      if (cTRst == null)
        throw new IndexOutOfBoundsException(); 
      return cTRst;
    } 
  }
  
  public int sizeOfSiArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SI$0);
    } 
  }
  
  public void setSiArray(CTRst[] paramArrayOfCTRst) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRst, SI$0);
    } 
  }
  
  public void setSiArray(int paramInt, CTRst paramCTRst) {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().find_element_user(SI$0, paramInt);
      if (cTRst == null)
        throw new IndexOutOfBoundsException(); 
      cTRst.set((XmlObject)paramCTRst);
    } 
  }
  
  public CTRst insertNewSi(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().insert_element_user(SI$0, paramInt);
      return cTRst;
    } 
  }
  
  public CTRst addNewSi() {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().add_element_user(SI$0);
      return cTRst;
    } 
  }
  
  public void removeSi(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SI$0, paramInt);
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
  
  public long getUniqueCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUECOUNT$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetUniqueCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(UNIQUECOUNT$6);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetUniqueCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNIQUECOUNT$6) != null);
    } 
  }
  
  public void setUniqueCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUECOUNT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNIQUECOUNT$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetUniqueCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(UNIQUECOUNT$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(UNIQUECOUNT$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetUniqueCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNIQUECOUNT$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSstImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */