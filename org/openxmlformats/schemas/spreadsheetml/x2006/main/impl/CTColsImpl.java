package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;

public class CTColsImpl extends XmlComplexContentImpl implements CTCols {
  private static final b COL$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "col");
  
  public CTColsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCol> getColList() {
    synchronized (monitor()) {
      check_orphaned();
      final class ColList extends AbstractList<CTCol> {
        public CTCol get(int param1Int) {
          return CTColsImpl.this.getColArray(param1Int);
        }
        
        public CTCol set(int param1Int, CTCol param1CTCol) {
          CTCol cTCol = CTColsImpl.this.getColArray(param1Int);
          CTColsImpl.this.setColArray(param1Int, param1CTCol);
          return cTCol;
        }
        
        public void add(int param1Int, CTCol param1CTCol) {
          CTColsImpl.this.insertNewCol(param1Int).set((XmlObject)param1CTCol);
        }
        
        public CTCol remove(int param1Int) {
          CTCol cTCol = CTColsImpl.this.getColArray(param1Int);
          CTColsImpl.this.removeCol(param1Int);
          return cTCol;
        }
        
        public int size() {
          return CTColsImpl.this.sizeOfColArray();
        }
      };
      return new ColList();
    } 
  }
  
  public CTCol[] getColArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COL$0, arrayList);
      CTCol[] arrayOfCTCol = new CTCol[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCol);
      return arrayOfCTCol;
    } 
  }
  
  public CTCol getColArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCol cTCol = null;
      cTCol = (CTCol)get_store().find_element_user(COL$0, paramInt);
      if (cTCol == null)
        throw new IndexOutOfBoundsException(); 
      return cTCol;
    } 
  }
  
  public int sizeOfColArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COL$0);
    } 
  }
  
  public void setColArray(CTCol[] paramArrayOfCTCol) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCol, COL$0);
    } 
  }
  
  public void setColArray(int paramInt, CTCol paramCTCol) {
    synchronized (monitor()) {
      check_orphaned();
      CTCol cTCol = null;
      cTCol = (CTCol)get_store().find_element_user(COL$0, paramInt);
      if (cTCol == null)
        throw new IndexOutOfBoundsException(); 
      cTCol.set((XmlObject)paramCTCol);
    } 
  }
  
  public CTCol insertNewCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCol cTCol = null;
      cTCol = (CTCol)get_store().insert_element_user(COL$0, paramInt);
      return cTCol;
    } 
  }
  
  public CTCol addNewCol() {
    synchronized (monitor()) {
      check_orphaned();
      CTCol cTCol = null;
      cTCol = (CTCol)get_store().add_element_user(COL$0);
      return cTCol;
    } 
  }
  
  public void removeCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COL$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTColsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */