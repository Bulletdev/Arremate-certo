package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;

public class CTSlideIdListImpl extends XmlComplexContentImpl implements CTSlideIdList {
  private static final b SLDID$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sldId");
  
  public CTSlideIdListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTSlideIdListEntry> getSldIdList() {
    synchronized (monitor()) {
      check_orphaned();
      final class SldIdList extends AbstractList<CTSlideIdListEntry> {
        public CTSlideIdListEntry get(int param1Int) {
          return CTSlideIdListImpl.this.getSldIdArray(param1Int);
        }
        
        public CTSlideIdListEntry set(int param1Int, CTSlideIdListEntry param1CTSlideIdListEntry) {
          CTSlideIdListEntry cTSlideIdListEntry = CTSlideIdListImpl.this.getSldIdArray(param1Int);
          CTSlideIdListImpl.this.setSldIdArray(param1Int, param1CTSlideIdListEntry);
          return cTSlideIdListEntry;
        }
        
        public void add(int param1Int, CTSlideIdListEntry param1CTSlideIdListEntry) {
          CTSlideIdListImpl.this.insertNewSldId(param1Int).set((XmlObject)param1CTSlideIdListEntry);
        }
        
        public CTSlideIdListEntry remove(int param1Int) {
          CTSlideIdListEntry cTSlideIdListEntry = CTSlideIdListImpl.this.getSldIdArray(param1Int);
          CTSlideIdListImpl.this.removeSldId(param1Int);
          return cTSlideIdListEntry;
        }
        
        public int size() {
          return CTSlideIdListImpl.this.sizeOfSldIdArray();
        }
      };
      return new SldIdList();
    } 
  }
  
  public CTSlideIdListEntry[] getSldIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SLDID$0, arrayList);
      CTSlideIdListEntry[] arrayOfCTSlideIdListEntry = new CTSlideIdListEntry[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSlideIdListEntry);
      return arrayOfCTSlideIdListEntry;
    } 
  }
  
  public CTSlideIdListEntry getSldIdArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideIdListEntry cTSlideIdListEntry = null;
      cTSlideIdListEntry = (CTSlideIdListEntry)get_store().find_element_user(SLDID$0, paramInt);
      if (cTSlideIdListEntry == null)
        throw new IndexOutOfBoundsException(); 
      return cTSlideIdListEntry;
    } 
  }
  
  public int sizeOfSldIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SLDID$0);
    } 
  }
  
  public void setSldIdArray(CTSlideIdListEntry[] paramArrayOfCTSlideIdListEntry) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSlideIdListEntry, SLDID$0);
    } 
  }
  
  public void setSldIdArray(int paramInt, CTSlideIdListEntry paramCTSlideIdListEntry) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideIdListEntry cTSlideIdListEntry = null;
      cTSlideIdListEntry = (CTSlideIdListEntry)get_store().find_element_user(SLDID$0, paramInt);
      if (cTSlideIdListEntry == null)
        throw new IndexOutOfBoundsException(); 
      cTSlideIdListEntry.set((XmlObject)paramCTSlideIdListEntry);
    } 
  }
  
  public CTSlideIdListEntry insertNewSldId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideIdListEntry cTSlideIdListEntry = null;
      cTSlideIdListEntry = (CTSlideIdListEntry)get_store().insert_element_user(SLDID$0, paramInt);
      return cTSlideIdListEntry;
    } 
  }
  
  public CTSlideIdListEntry addNewSldId() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideIdListEntry cTSlideIdListEntry = null;
      cTSlideIdListEntry = (CTSlideIdListEntry)get_store().add_element_user(SLDID$0);
      return cTSlideIdListEntry;
    } 
  }
  
  public void removeSldId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SLDID$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTSlideIdListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */