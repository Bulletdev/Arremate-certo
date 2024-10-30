package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

public class CTTableImpl extends XmlComplexContentImpl implements CTTable {
  private static final b TBLPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tblPr");
  
  private static final b TBLGRID$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tblGrid");
  
  private static final b TR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tr");
  
  public CTTableImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTableProperties getTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableProperties cTTableProperties = null;
      cTTableProperties = (CTTableProperties)get_store().find_element_user(TBLPR$0, 0);
      if (cTTableProperties == null)
        return null; 
      return cTTableProperties;
    } 
  }
  
  public boolean isSetTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLPR$0) != 0);
    } 
  }
  
  public void setTblPr(CTTableProperties paramCTTableProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableProperties cTTableProperties = null;
      cTTableProperties = (CTTableProperties)get_store().find_element_user(TBLPR$0, 0);
      if (cTTableProperties == null)
        cTTableProperties = (CTTableProperties)get_store().add_element_user(TBLPR$0); 
      cTTableProperties.set((XmlObject)paramCTTableProperties);
    } 
  }
  
  public CTTableProperties addNewTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableProperties cTTableProperties = null;
      cTTableProperties = (CTTableProperties)get_store().add_element_user(TBLPR$0);
      return cTTableProperties;
    } 
  }
  
  public void unsetTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLPR$0, 0);
    } 
  }
  
  public CTTableGrid getTblGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableGrid cTTableGrid = null;
      cTTableGrid = (CTTableGrid)get_store().find_element_user(TBLGRID$2, 0);
      if (cTTableGrid == null)
        return null; 
      return cTTableGrid;
    } 
  }
  
  public void setTblGrid(CTTableGrid paramCTTableGrid) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableGrid cTTableGrid = null;
      cTTableGrid = (CTTableGrid)get_store().find_element_user(TBLGRID$2, 0);
      if (cTTableGrid == null)
        cTTableGrid = (CTTableGrid)get_store().add_element_user(TBLGRID$2); 
      cTTableGrid.set((XmlObject)paramCTTableGrid);
    } 
  }
  
  public CTTableGrid addNewTblGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableGrid cTTableGrid = null;
      cTTableGrid = (CTTableGrid)get_store().add_element_user(TBLGRID$2);
      return cTTableGrid;
    } 
  }
  
  public List<CTTableRow> getTrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTableRow>)new TrList(this);
    } 
  }
  
  public CTTableRow[] getTrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TR$4, arrayList);
      CTTableRow[] arrayOfCTTableRow = new CTTableRow[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTableRow);
      return arrayOfCTTableRow;
    } 
  }
  
  public CTTableRow getTrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableRow cTTableRow = null;
      cTTableRow = (CTTableRow)get_store().find_element_user(TR$4, paramInt);
      if (cTTableRow == null)
        throw new IndexOutOfBoundsException(); 
      return cTTableRow;
    } 
  }
  
  public int sizeOfTrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TR$4);
    } 
  }
  
  public void setTrArray(CTTableRow[] paramArrayOfCTTableRow) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTableRow, TR$4);
    } 
  }
  
  public void setTrArray(int paramInt, CTTableRow paramCTTableRow) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableRow cTTableRow = null;
      cTTableRow = (CTTableRow)get_store().find_element_user(TR$4, paramInt);
      if (cTTableRow == null)
        throw new IndexOutOfBoundsException(); 
      cTTableRow.set((XmlObject)paramCTTableRow);
    } 
  }
  
  public CTTableRow insertNewTr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableRow cTTableRow = null;
      cTTableRow = (CTTableRow)get_store().insert_element_user(TR$4, paramInt);
      return cTTableRow;
    } 
  }
  
  public CTTableRow addNewTr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableRow cTTableRow = null;
      cTTableRow = (CTTableRow)get_store().add_element_user(TR$4);
      return cTTableRow;
    } 
  }
  
  public void removeTr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TR$4, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */