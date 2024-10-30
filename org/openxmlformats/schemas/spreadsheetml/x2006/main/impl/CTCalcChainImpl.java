package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;

public class CTCalcChainImpl extends XmlComplexContentImpl implements CTCalcChain {
  private static final b C$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "c");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTCalcChainImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCalcCell> getCList() {
    synchronized (monitor()) {
      check_orphaned();
      final class CList extends AbstractList<CTCalcCell> {
        public CTCalcCell get(int param1Int) {
          return CTCalcChainImpl.this.getCArray(param1Int);
        }
        
        public CTCalcCell set(int param1Int, CTCalcCell param1CTCalcCell) {
          CTCalcCell cTCalcCell = CTCalcChainImpl.this.getCArray(param1Int);
          CTCalcChainImpl.this.setCArray(param1Int, param1CTCalcCell);
          return cTCalcCell;
        }
        
        public void add(int param1Int, CTCalcCell param1CTCalcCell) {
          CTCalcChainImpl.this.insertNewC(param1Int).set((XmlObject)param1CTCalcCell);
        }
        
        public CTCalcCell remove(int param1Int) {
          CTCalcCell cTCalcCell = CTCalcChainImpl.this.getCArray(param1Int);
          CTCalcChainImpl.this.removeC(param1Int);
          return cTCalcCell;
        }
        
        public int size() {
          return CTCalcChainImpl.this.sizeOfCArray();
        }
      };
      return new CList();
    } 
  }
  
  public CTCalcCell[] getCArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(C$0, arrayList);
      CTCalcCell[] arrayOfCTCalcCell = new CTCalcCell[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCalcCell);
      return arrayOfCTCalcCell;
    } 
  }
  
  public CTCalcCell getCArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcCell cTCalcCell = null;
      cTCalcCell = (CTCalcCell)get_store().find_element_user(C$0, paramInt);
      if (cTCalcCell == null)
        throw new IndexOutOfBoundsException(); 
      return cTCalcCell;
    } 
  }
  
  public int sizeOfCArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(C$0);
    } 
  }
  
  public void setCArray(CTCalcCell[] paramArrayOfCTCalcCell) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCalcCell, C$0);
    } 
  }
  
  public void setCArray(int paramInt, CTCalcCell paramCTCalcCell) {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcCell cTCalcCell = null;
      cTCalcCell = (CTCalcCell)get_store().find_element_user(C$0, paramInt);
      if (cTCalcCell == null)
        throw new IndexOutOfBoundsException(); 
      cTCalcCell.set((XmlObject)paramCTCalcCell);
    } 
  }
  
  public CTCalcCell insertNewC(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcCell cTCalcCell = null;
      cTCalcCell = (CTCalcCell)get_store().insert_element_user(C$0, paramInt);
      return cTCalcCell;
    } 
  }
  
  public CTCalcCell addNewC() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcCell cTCalcCell = null;
      cTCalcCell = (CTCalcCell)get_store().add_element_user(C$0);
      return cTCalcCell;
    } 
  }
  
  public void removeC(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(C$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCalcChainImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */