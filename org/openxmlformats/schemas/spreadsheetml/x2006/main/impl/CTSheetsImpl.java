package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;

public class CTSheetsImpl extends XmlComplexContentImpl implements CTSheets {
  private static final b SHEET$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheet");
  
  public CTSheetsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTSheet> getSheetList() {
    synchronized (monitor()) {
      check_orphaned();
      final class SheetList extends AbstractList<CTSheet> {
        public CTSheet get(int param1Int) {
          return CTSheetsImpl.this.getSheetArray(param1Int);
        }
        
        public CTSheet set(int param1Int, CTSheet param1CTSheet) {
          CTSheet cTSheet = CTSheetsImpl.this.getSheetArray(param1Int);
          CTSheetsImpl.this.setSheetArray(param1Int, param1CTSheet);
          return cTSheet;
        }
        
        public void add(int param1Int, CTSheet param1CTSheet) {
          CTSheetsImpl.this.insertNewSheet(param1Int).set((XmlObject)param1CTSheet);
        }
        
        public CTSheet remove(int param1Int) {
          CTSheet cTSheet = CTSheetsImpl.this.getSheetArray(param1Int);
          CTSheetsImpl.this.removeSheet(param1Int);
          return cTSheet;
        }
        
        public int size() {
          return CTSheetsImpl.this.sizeOfSheetArray();
        }
      };
      return new SheetList();
    } 
  }
  
  public CTSheet[] getSheetArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHEET$0, arrayList);
      CTSheet[] arrayOfCTSheet = new CTSheet[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSheet);
      return arrayOfCTSheet;
    } 
  }
  
  public CTSheet getSheetArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheet cTSheet = null;
      cTSheet = (CTSheet)get_store().find_element_user(SHEET$0, paramInt);
      if (cTSheet == null)
        throw new IndexOutOfBoundsException(); 
      return cTSheet;
    } 
  }
  
  public int sizeOfSheetArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHEET$0);
    } 
  }
  
  public void setSheetArray(CTSheet[] paramArrayOfCTSheet) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSheet, SHEET$0);
    } 
  }
  
  public void setSheetArray(int paramInt, CTSheet paramCTSheet) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheet cTSheet = null;
      cTSheet = (CTSheet)get_store().find_element_user(SHEET$0, paramInt);
      if (cTSheet == null)
        throw new IndexOutOfBoundsException(); 
      cTSheet.set((XmlObject)paramCTSheet);
    } 
  }
  
  public CTSheet insertNewSheet(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheet cTSheet = null;
      cTSheet = (CTSheet)get_store().insert_element_user(SHEET$0, paramInt);
      return cTSheet;
    } 
  }
  
  public CTSheet addNewSheet() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheet cTSheet = null;
      cTSheet = (CTSheet)get_store().add_element_user(SHEET$0);
      return cTSheet;
    } 
  }
  
  public void removeSheet(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEET$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */