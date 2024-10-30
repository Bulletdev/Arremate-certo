package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilterColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

public class CTAutoFilterImpl extends XmlComplexContentImpl implements CTAutoFilter {
  private static final b FILTERCOLUMN$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "filterColumn");
  
  private static final b SORTSTATE$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sortState");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b REF$6 = new b("", "ref");
  
  public CTAutoFilterImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTFilterColumn> getFilterColumnList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFilterColumn>)new FilterColumnList(this);
    } 
  }
  
  public CTFilterColumn[] getFilterColumnArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FILTERCOLUMN$0, arrayList);
      CTFilterColumn[] arrayOfCTFilterColumn = new CTFilterColumn[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFilterColumn);
      return arrayOfCTFilterColumn;
    } 
  }
  
  public CTFilterColumn getFilterColumnArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFilterColumn cTFilterColumn = null;
      cTFilterColumn = (CTFilterColumn)get_store().find_element_user(FILTERCOLUMN$0, paramInt);
      if (cTFilterColumn == null)
        throw new IndexOutOfBoundsException(); 
      return cTFilterColumn;
    } 
  }
  
  public int sizeOfFilterColumnArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FILTERCOLUMN$0);
    } 
  }
  
  public void setFilterColumnArray(CTFilterColumn[] paramArrayOfCTFilterColumn) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFilterColumn, FILTERCOLUMN$0);
    } 
  }
  
  public void setFilterColumnArray(int paramInt, CTFilterColumn paramCTFilterColumn) {
    synchronized (monitor()) {
      check_orphaned();
      CTFilterColumn cTFilterColumn = null;
      cTFilterColumn = (CTFilterColumn)get_store().find_element_user(FILTERCOLUMN$0, paramInt);
      if (cTFilterColumn == null)
        throw new IndexOutOfBoundsException(); 
      cTFilterColumn.set((XmlObject)paramCTFilterColumn);
    } 
  }
  
  public CTFilterColumn insertNewFilterColumn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFilterColumn cTFilterColumn = null;
      cTFilterColumn = (CTFilterColumn)get_store().insert_element_user(FILTERCOLUMN$0, paramInt);
      return cTFilterColumn;
    } 
  }
  
  public CTFilterColumn addNewFilterColumn() {
    synchronized (monitor()) {
      check_orphaned();
      CTFilterColumn cTFilterColumn = null;
      cTFilterColumn = (CTFilterColumn)get_store().add_element_user(FILTERCOLUMN$0);
      return cTFilterColumn;
    } 
  }
  
  public void removeFilterColumn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILTERCOLUMN$0, paramInt);
    } 
  }
  
  public CTSortState getSortState() {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().find_element_user(SORTSTATE$2, 0);
      if (cTSortState == null)
        return null; 
      return cTSortState;
    } 
  }
  
  public boolean isSetSortState() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SORTSTATE$2) != 0);
    } 
  }
  
  public void setSortState(CTSortState paramCTSortState) {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().find_element_user(SORTSTATE$2, 0);
      if (cTSortState == null)
        cTSortState = (CTSortState)get_store().add_element_user(SORTSTATE$2); 
      cTSortState.set((XmlObject)paramCTSortState);
    } 
  }
  
  public CTSortState addNewSortState() {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().add_element_user(SORTSTATE$2);
      return cTSortState;
    } 
  }
  
  public void unsetSortState() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SORTSTATE$2, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$4) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$4, 0);
    } 
  }
  
  public String getRef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRef xgetRef() {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$6);
      return sTRef;
    } 
  }
  
  public boolean isSetRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REF$6) != null);
    } 
  }
  
  public void setRef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REF$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRef(STRef paramSTRef) {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$6);
      if (sTRef == null)
        sTRef = (STRef)get_store().add_attribute_user(REF$6); 
      sTRef.set((XmlObject)paramSTRef);
    } 
  }
  
  public void unsetRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REF$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTAutoFilterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */