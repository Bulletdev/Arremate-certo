package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;

public class CTTextTabStopListImpl extends XmlComplexContentImpl implements CTTextTabStopList {
  private static final b TAB$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tab");
  
  public CTTextTabStopListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTextTabStop> getTabList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTextTabStop>)new TabList(this);
    } 
  }
  
  public CTTextTabStop[] getTabArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TAB$0, arrayList);
      CTTextTabStop[] arrayOfCTTextTabStop = new CTTextTabStop[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTextTabStop);
      return arrayOfCTTextTabStop;
    } 
  }
  
  public CTTextTabStop getTabArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextTabStop cTTextTabStop = null;
      cTTextTabStop = (CTTextTabStop)get_store().find_element_user(TAB$0, paramInt);
      if (cTTextTabStop == null)
        throw new IndexOutOfBoundsException(); 
      return cTTextTabStop;
    } 
  }
  
  public int sizeOfTabArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TAB$0);
    } 
  }
  
  public void setTabArray(CTTextTabStop[] paramArrayOfCTTextTabStop) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTextTabStop, TAB$0);
    } 
  }
  
  public void setTabArray(int paramInt, CTTextTabStop paramCTTextTabStop) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextTabStop cTTextTabStop = null;
      cTTextTabStop = (CTTextTabStop)get_store().find_element_user(TAB$0, paramInt);
      if (cTTextTabStop == null)
        throw new IndexOutOfBoundsException(); 
      cTTextTabStop.set((XmlObject)paramCTTextTabStop);
    } 
  }
  
  public CTTextTabStop insertNewTab(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextTabStop cTTextTabStop = null;
      cTTextTabStop = (CTTextTabStop)get_store().insert_element_user(TAB$0, paramInt);
      return cTTextTabStop;
    } 
  }
  
  public CTTextTabStop addNewTab() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextTabStop cTTextTabStop = null;
      cTTextTabStop = (CTTextTabStop)get_store().add_element_user(TAB$0);
      return cTTextTabStop;
    } 
  }
  
  public void removeTab(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TAB$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextTabStopListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */