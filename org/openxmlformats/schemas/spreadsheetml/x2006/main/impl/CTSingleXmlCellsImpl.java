package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;

public class CTSingleXmlCellsImpl extends XmlComplexContentImpl implements CTSingleXmlCells {
  private static final b SINGLEXMLCELL$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "singleXmlCell");
  
  public CTSingleXmlCellsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTSingleXmlCell> getSingleXmlCellList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSingleXmlCell>)new SingleXmlCellList(this);
    } 
  }
  
  public CTSingleXmlCell[] getSingleXmlCellArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SINGLEXMLCELL$0, arrayList);
      CTSingleXmlCell[] arrayOfCTSingleXmlCell = new CTSingleXmlCell[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSingleXmlCell);
      return arrayOfCTSingleXmlCell;
    } 
  }
  
  public CTSingleXmlCell getSingleXmlCellArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSingleXmlCell cTSingleXmlCell = null;
      cTSingleXmlCell = (CTSingleXmlCell)get_store().find_element_user(SINGLEXMLCELL$0, paramInt);
      if (cTSingleXmlCell == null)
        throw new IndexOutOfBoundsException(); 
      return cTSingleXmlCell;
    } 
  }
  
  public int sizeOfSingleXmlCellArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SINGLEXMLCELL$0);
    } 
  }
  
  public void setSingleXmlCellArray(CTSingleXmlCell[] paramArrayOfCTSingleXmlCell) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSingleXmlCell, SINGLEXMLCELL$0);
    } 
  }
  
  public void setSingleXmlCellArray(int paramInt, CTSingleXmlCell paramCTSingleXmlCell) {
    synchronized (monitor()) {
      check_orphaned();
      CTSingleXmlCell cTSingleXmlCell = null;
      cTSingleXmlCell = (CTSingleXmlCell)get_store().find_element_user(SINGLEXMLCELL$0, paramInt);
      if (cTSingleXmlCell == null)
        throw new IndexOutOfBoundsException(); 
      cTSingleXmlCell.set((XmlObject)paramCTSingleXmlCell);
    } 
  }
  
  public CTSingleXmlCell insertNewSingleXmlCell(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSingleXmlCell cTSingleXmlCell = null;
      cTSingleXmlCell = (CTSingleXmlCell)get_store().insert_element_user(SINGLEXMLCELL$0, paramInt);
      return cTSingleXmlCell;
    } 
  }
  
  public CTSingleXmlCell addNewSingleXmlCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTSingleXmlCell cTSingleXmlCell = null;
      cTSingleXmlCell = (CTSingleXmlCell)get_store().add_element_user(SINGLEXMLCELL$0);
      return cTSingleXmlCell;
    } 
  }
  
  public void removeSingleXmlCell(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SINGLEXMLCELL$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSingleXmlCellsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */