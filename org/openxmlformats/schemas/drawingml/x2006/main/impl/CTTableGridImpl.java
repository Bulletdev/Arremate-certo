package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCol;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid;

public class CTTableGridImpl extends XmlComplexContentImpl implements CTTableGrid {
  private static final b GRIDCOL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gridCol");
  
  public CTTableGridImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTableCol> getGridColList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTableCol>)new GridColList(this);
    } 
  }
  
  public CTTableCol[] getGridColArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRIDCOL$0, arrayList);
      CTTableCol[] arrayOfCTTableCol = new CTTableCol[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTableCol);
      return arrayOfCTTableCol;
    } 
  }
  
  public CTTableCol getGridColArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCol cTTableCol = null;
      cTTableCol = (CTTableCol)get_store().find_element_user(GRIDCOL$0, paramInt);
      if (cTTableCol == null)
        throw new IndexOutOfBoundsException(); 
      return cTTableCol;
    } 
  }
  
  public int sizeOfGridColArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRIDCOL$0);
    } 
  }
  
  public void setGridColArray(CTTableCol[] paramArrayOfCTTableCol) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTableCol, GRIDCOL$0);
    } 
  }
  
  public void setGridColArray(int paramInt, CTTableCol paramCTTableCol) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCol cTTableCol = null;
      cTTableCol = (CTTableCol)get_store().find_element_user(GRIDCOL$0, paramInt);
      if (cTTableCol == null)
        throw new IndexOutOfBoundsException(); 
      cTTableCol.set((XmlObject)paramCTTableCol);
    } 
  }
  
  public CTTableCol insertNewGridCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCol cTTableCol = null;
      cTTableCol = (CTTableCol)get_store().insert_element_user(GRIDCOL$0, paramInt);
      return cTTableCol;
    } 
  }
  
  public CTTableCol addNewGridCol() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCol cTTableCol = null;
      cTTableCol = (CTTableCol)get_store().add_element_user(GRIDCOL$0);
      return cTTableCol;
    } 
  }
  
  public void removeGridCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRIDCOL$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableGridImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */