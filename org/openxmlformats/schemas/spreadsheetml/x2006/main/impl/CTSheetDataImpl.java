package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData;

public class CTSheetDataImpl extends XmlComplexContentImpl implements CTSheetData {
  private static final b ROW$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "row");
  
  public CTSheetDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTRow> getRowList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRow>)new RowList(this);
    } 
  }
  
  public CTRow[] getRowArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ROW$0, arrayList);
      CTRow[] arrayOfCTRow = new CTRow[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRow);
      return arrayOfCTRow;
    } 
  }
  
  public CTRow getRowArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRow cTRow = null;
      cTRow = (CTRow)get_store().find_element_user(ROW$0, paramInt);
      if (cTRow == null)
        throw new IndexOutOfBoundsException(); 
      return cTRow;
    } 
  }
  
  public int sizeOfRowArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ROW$0);
    } 
  }
  
  public void setRowArray(CTRow[] paramArrayOfCTRow) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRow, ROW$0);
    } 
  }
  
  public void setRowArray(int paramInt, CTRow paramCTRow) {
    synchronized (monitor()) {
      check_orphaned();
      CTRow cTRow = null;
      cTRow = (CTRow)get_store().find_element_user(ROW$0, paramInt);
      if (cTRow == null)
        throw new IndexOutOfBoundsException(); 
      cTRow.set((XmlObject)paramCTRow);
    } 
  }
  
  public CTRow insertNewRow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRow cTRow = null;
      cTRow = (CTRow)get_store().insert_element_user(ROW$0, paramInt);
      return cTRow;
    } 
  }
  
  public CTRow addNewRow() {
    synchronized (monitor()) {
      check_orphaned();
      CTRow cTRow = null;
      cTRow = (CTRow)get_store().add_element_user(ROW$0);
      return cTRow;
    } 
  }
  
  public void removeRow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROW$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */