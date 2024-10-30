package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors;

public class CTIgnoredErrorsImpl extends XmlComplexContentImpl implements CTIgnoredErrors {
  private static final b IGNOREDERROR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "ignoredError");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTIgnoredErrorsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTIgnoredError> getIgnoredErrorList() {
    synchronized (monitor()) {
      check_orphaned();
      final class IgnoredErrorList extends AbstractList<CTIgnoredError> {
        public CTIgnoredError get(int param1Int) {
          return CTIgnoredErrorsImpl.this.getIgnoredErrorArray(param1Int);
        }
        
        public CTIgnoredError set(int param1Int, CTIgnoredError param1CTIgnoredError) {
          CTIgnoredError cTIgnoredError = CTIgnoredErrorsImpl.this.getIgnoredErrorArray(param1Int);
          CTIgnoredErrorsImpl.this.setIgnoredErrorArray(param1Int, param1CTIgnoredError);
          return cTIgnoredError;
        }
        
        public void add(int param1Int, CTIgnoredError param1CTIgnoredError) {
          CTIgnoredErrorsImpl.this.insertNewIgnoredError(param1Int).set((XmlObject)param1CTIgnoredError);
        }
        
        public CTIgnoredError remove(int param1Int) {
          CTIgnoredError cTIgnoredError = CTIgnoredErrorsImpl.this.getIgnoredErrorArray(param1Int);
          CTIgnoredErrorsImpl.this.removeIgnoredError(param1Int);
          return cTIgnoredError;
        }
        
        public int size() {
          return CTIgnoredErrorsImpl.this.sizeOfIgnoredErrorArray();
        }
      };
      return new IgnoredErrorList();
    } 
  }
  
  public CTIgnoredError[] getIgnoredErrorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(IGNOREDERROR$0, arrayList);
      CTIgnoredError[] arrayOfCTIgnoredError = new CTIgnoredError[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTIgnoredError);
      return arrayOfCTIgnoredError;
    } 
  }
  
  public CTIgnoredError getIgnoredErrorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTIgnoredError cTIgnoredError = null;
      cTIgnoredError = (CTIgnoredError)get_store().find_element_user(IGNOREDERROR$0, paramInt);
      if (cTIgnoredError == null)
        throw new IndexOutOfBoundsException(); 
      return cTIgnoredError;
    } 
  }
  
  public int sizeOfIgnoredErrorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(IGNOREDERROR$0);
    } 
  }
  
  public void setIgnoredErrorArray(CTIgnoredError[] paramArrayOfCTIgnoredError) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTIgnoredError, IGNOREDERROR$0);
    } 
  }
  
  public void setIgnoredErrorArray(int paramInt, CTIgnoredError paramCTIgnoredError) {
    synchronized (monitor()) {
      check_orphaned();
      CTIgnoredError cTIgnoredError = null;
      cTIgnoredError = (CTIgnoredError)get_store().find_element_user(IGNOREDERROR$0, paramInt);
      if (cTIgnoredError == null)
        throw new IndexOutOfBoundsException(); 
      cTIgnoredError.set((XmlObject)paramCTIgnoredError);
    } 
  }
  
  public CTIgnoredError insertNewIgnoredError(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTIgnoredError cTIgnoredError = null;
      cTIgnoredError = (CTIgnoredError)get_store().insert_element_user(IGNOREDERROR$0, paramInt);
      return cTIgnoredError;
    } 
  }
  
  public CTIgnoredError addNewIgnoredError() {
    synchronized (monitor()) {
      check_orphaned();
      CTIgnoredError cTIgnoredError = null;
      cTIgnoredError = (CTIgnoredError)get_store().add_element_user(IGNOREDERROR$0);
      return cTIgnoredError;
    } 
  }
  
  public void removeIgnoredError(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IGNOREDERROR$0, paramInt);
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
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTIgnoredErrorsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */