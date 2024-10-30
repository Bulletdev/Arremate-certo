package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;

public class CTSlideMasterIdListImpl extends XmlComplexContentImpl implements CTSlideMasterIdList {
  private static final b SLDMASTERID$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sldMasterId");
  
  public CTSlideMasterIdListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTSlideMasterIdListEntry> getSldMasterIdList() {
    synchronized (monitor()) {
      check_orphaned();
      final class SldMasterIdList extends AbstractList<CTSlideMasterIdListEntry> {
        public CTSlideMasterIdListEntry get(int param1Int) {
          return CTSlideMasterIdListImpl.this.getSldMasterIdArray(param1Int);
        }
        
        public CTSlideMasterIdListEntry set(int param1Int, CTSlideMasterIdListEntry param1CTSlideMasterIdListEntry) {
          CTSlideMasterIdListEntry cTSlideMasterIdListEntry = CTSlideMasterIdListImpl.this.getSldMasterIdArray(param1Int);
          CTSlideMasterIdListImpl.this.setSldMasterIdArray(param1Int, param1CTSlideMasterIdListEntry);
          return cTSlideMasterIdListEntry;
        }
        
        public void add(int param1Int, CTSlideMasterIdListEntry param1CTSlideMasterIdListEntry) {
          CTSlideMasterIdListImpl.this.insertNewSldMasterId(param1Int).set((XmlObject)param1CTSlideMasterIdListEntry);
        }
        
        public CTSlideMasterIdListEntry remove(int param1Int) {
          CTSlideMasterIdListEntry cTSlideMasterIdListEntry = CTSlideMasterIdListImpl.this.getSldMasterIdArray(param1Int);
          CTSlideMasterIdListImpl.this.removeSldMasterId(param1Int);
          return cTSlideMasterIdListEntry;
        }
        
        public int size() {
          return CTSlideMasterIdListImpl.this.sizeOfSldMasterIdArray();
        }
      };
      return new SldMasterIdList();
    } 
  }
  
  public CTSlideMasterIdListEntry[] getSldMasterIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SLDMASTERID$0, arrayList);
      CTSlideMasterIdListEntry[] arrayOfCTSlideMasterIdListEntry = new CTSlideMasterIdListEntry[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSlideMasterIdListEntry);
      return arrayOfCTSlideMasterIdListEntry;
    } 
  }
  
  public CTSlideMasterIdListEntry getSldMasterIdArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterIdListEntry cTSlideMasterIdListEntry = null;
      cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry)get_store().find_element_user(SLDMASTERID$0, paramInt);
      if (cTSlideMasterIdListEntry == null)
        throw new IndexOutOfBoundsException(); 
      return cTSlideMasterIdListEntry;
    } 
  }
  
  public int sizeOfSldMasterIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SLDMASTERID$0);
    } 
  }
  
  public void setSldMasterIdArray(CTSlideMasterIdListEntry[] paramArrayOfCTSlideMasterIdListEntry) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSlideMasterIdListEntry, SLDMASTERID$0);
    } 
  }
  
  public void setSldMasterIdArray(int paramInt, CTSlideMasterIdListEntry paramCTSlideMasterIdListEntry) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterIdListEntry cTSlideMasterIdListEntry = null;
      cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry)get_store().find_element_user(SLDMASTERID$0, paramInt);
      if (cTSlideMasterIdListEntry == null)
        throw new IndexOutOfBoundsException(); 
      cTSlideMasterIdListEntry.set((XmlObject)paramCTSlideMasterIdListEntry);
    } 
  }
  
  public CTSlideMasterIdListEntry insertNewSldMasterId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterIdListEntry cTSlideMasterIdListEntry = null;
      cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry)get_store().insert_element_user(SLDMASTERID$0, paramInt);
      return cTSlideMasterIdListEntry;
    } 
  }
  
  public CTSlideMasterIdListEntry addNewSldMasterId() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterIdListEntry cTSlideMasterIdListEntry = null;
      cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry)get_store().add_element_user(SLDMASTERID$0);
      return cTSlideMasterIdListEntry;
    } 
  }
  
  public void removeSldMasterId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SLDMASTERID$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTSlideMasterIdListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */