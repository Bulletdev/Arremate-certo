package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;

public class CTDefinedNamesImpl extends XmlComplexContentImpl implements CTDefinedNames {
  private static final b DEFINEDNAME$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedName");
  
  public CTDefinedNamesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTDefinedName> getDefinedNameList() {
    synchronized (monitor()) {
      check_orphaned();
      final class DefinedNameList extends AbstractList<CTDefinedName> {
        public CTDefinedName get(int param1Int) {
          return CTDefinedNamesImpl.this.getDefinedNameArray(param1Int);
        }
        
        public CTDefinedName set(int param1Int, CTDefinedName param1CTDefinedName) {
          CTDefinedName cTDefinedName = CTDefinedNamesImpl.this.getDefinedNameArray(param1Int);
          CTDefinedNamesImpl.this.setDefinedNameArray(param1Int, param1CTDefinedName);
          return cTDefinedName;
        }
        
        public void add(int param1Int, CTDefinedName param1CTDefinedName) {
          CTDefinedNamesImpl.this.insertNewDefinedName(param1Int).set((XmlObject)param1CTDefinedName);
        }
        
        public CTDefinedName remove(int param1Int) {
          CTDefinedName cTDefinedName = CTDefinedNamesImpl.this.getDefinedNameArray(param1Int);
          CTDefinedNamesImpl.this.removeDefinedName(param1Int);
          return cTDefinedName;
        }
        
        public int size() {
          return CTDefinedNamesImpl.this.sizeOfDefinedNameArray();
        }
      };
      return new DefinedNameList();
    } 
  }
  
  public CTDefinedName[] getDefinedNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DEFINEDNAME$0, arrayList);
      CTDefinedName[] arrayOfCTDefinedName = new CTDefinedName[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDefinedName);
      return arrayOfCTDefinedName;
    } 
  }
  
  public CTDefinedName getDefinedNameArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDefinedName cTDefinedName = null;
      cTDefinedName = (CTDefinedName)get_store().find_element_user(DEFINEDNAME$0, paramInt);
      if (cTDefinedName == null)
        throw new IndexOutOfBoundsException(); 
      return cTDefinedName;
    } 
  }
  
  public int sizeOfDefinedNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DEFINEDNAME$0);
    } 
  }
  
  public void setDefinedNameArray(CTDefinedName[] paramArrayOfCTDefinedName) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDefinedName, DEFINEDNAME$0);
    } 
  }
  
  public void setDefinedNameArray(int paramInt, CTDefinedName paramCTDefinedName) {
    synchronized (monitor()) {
      check_orphaned();
      CTDefinedName cTDefinedName = null;
      cTDefinedName = (CTDefinedName)get_store().find_element_user(DEFINEDNAME$0, paramInt);
      if (cTDefinedName == null)
        throw new IndexOutOfBoundsException(); 
      cTDefinedName.set((XmlObject)paramCTDefinedName);
    } 
  }
  
  public CTDefinedName insertNewDefinedName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDefinedName cTDefinedName = null;
      cTDefinedName = (CTDefinedName)get_store().insert_element_user(DEFINEDNAME$0, paramInt);
      return cTDefinedName;
    } 
  }
  
  public CTDefinedName addNewDefinedName() {
    synchronized (monitor()) {
      check_orphaned();
      CTDefinedName cTDefinedName = null;
      cTDefinedName = (CTDefinedName)get_store().add_element_user(DEFINEDNAME$0);
      return cTDefinedName;
    } 
  }
  
  public void removeDefinedName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFINEDNAME$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDefinedNamesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */