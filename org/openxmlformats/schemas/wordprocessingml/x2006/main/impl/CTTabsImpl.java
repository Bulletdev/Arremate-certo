package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;

public class CTTabsImpl extends XmlComplexContentImpl implements CTTabs {
  private static final b TAB$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tab");
  
  public CTTabsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTabStop> getTabList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTabStop>)new TabList(this);
    } 
  }
  
  public CTTabStop[] getTabArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TAB$0, arrayList);
      CTTabStop[] arrayOfCTTabStop = new CTTabStop[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTabStop);
      return arrayOfCTTabStop;
    } 
  }
  
  public CTTabStop getTabArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTabStop cTTabStop = null;
      cTTabStop = (CTTabStop)get_store().find_element_user(TAB$0, paramInt);
      if (cTTabStop == null)
        throw new IndexOutOfBoundsException(); 
      return cTTabStop;
    } 
  }
  
  public int sizeOfTabArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TAB$0);
    } 
  }
  
  public void setTabArray(CTTabStop[] paramArrayOfCTTabStop) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTabStop, TAB$0);
    } 
  }
  
  public void setTabArray(int paramInt, CTTabStop paramCTTabStop) {
    synchronized (monitor()) {
      check_orphaned();
      CTTabStop cTTabStop = null;
      cTTabStop = (CTTabStop)get_store().find_element_user(TAB$0, paramInt);
      if (cTTabStop == null)
        throw new IndexOutOfBoundsException(); 
      cTTabStop.set((XmlObject)paramCTTabStop);
    } 
  }
  
  public CTTabStop insertNewTab(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTabStop cTTabStop = null;
      cTTabStop = (CTTabStop)get_store().insert_element_user(TAB$0, paramInt);
      return cTTabStop;
    } 
  }
  
  public CTTabStop addNewTab() {
    synchronized (monitor()) {
      check_orphaned();
      CTTabStop cTTabStop = null;
      cTTabStop = (CTTabStop)get_store().add_element_user(TAB$0);
      return cTTabStop;
    } 
  }
  
  public void removeTab(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TAB$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTabsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */