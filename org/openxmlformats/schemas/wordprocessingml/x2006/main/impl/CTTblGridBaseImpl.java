package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;

public class CTTblGridBaseImpl extends XmlComplexContentImpl implements CTTblGridBase {
  private static final b GRIDCOL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridCol");
  
  public CTTblGridBaseImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTblGridCol> getGridColList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTblGridCol>)new GridColList(this);
    } 
  }
  
  public CTTblGridCol[] getGridColArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRIDCOL$0, arrayList);
      CTTblGridCol[] arrayOfCTTblGridCol = new CTTblGridCol[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTblGridCol);
      return arrayOfCTTblGridCol;
    } 
  }
  
  public CTTblGridCol getGridColArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGridCol cTTblGridCol = null;
      cTTblGridCol = (CTTblGridCol)get_store().find_element_user(GRIDCOL$0, paramInt);
      if (cTTblGridCol == null)
        throw new IndexOutOfBoundsException(); 
      return cTTblGridCol;
    } 
  }
  
  public int sizeOfGridColArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRIDCOL$0);
    } 
  }
  
  public void setGridColArray(CTTblGridCol[] paramArrayOfCTTblGridCol) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTblGridCol, GRIDCOL$0);
    } 
  }
  
  public void setGridColArray(int paramInt, CTTblGridCol paramCTTblGridCol) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGridCol cTTblGridCol = null;
      cTTblGridCol = (CTTblGridCol)get_store().find_element_user(GRIDCOL$0, paramInt);
      if (cTTblGridCol == null)
        throw new IndexOutOfBoundsException(); 
      cTTblGridCol.set((XmlObject)paramCTTblGridCol);
    } 
  }
  
  public CTTblGridCol insertNewGridCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGridCol cTTblGridCol = null;
      cTTblGridCol = (CTTblGridCol)get_store().insert_element_user(GRIDCOL$0, paramInt);
      return cTTblGridCol;
    } 
  }
  
  public CTTblGridCol addNewGridCol() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblGridCol cTTblGridCol = null;
      cTTblGridCol = (CTTblGridCol)get_store().add_element_user(GRIDCOL$0);
      return cTTblGridCol;
    } 
  }
  
  public void removeGridCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRIDCOL$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblGridBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */