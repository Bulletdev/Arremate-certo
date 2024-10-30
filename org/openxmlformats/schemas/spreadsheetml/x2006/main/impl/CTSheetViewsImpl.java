package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;

public class CTSheetViewsImpl extends XmlComplexContentImpl implements CTSheetViews {
  private static final b SHEETVIEW$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetView");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTSheetViewsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTSheetView> getSheetViewList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSheetView>)new SheetViewList(this);
    } 
  }
  
  public CTSheetView[] getSheetViewArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHEETVIEW$0, arrayList);
      CTSheetView[] arrayOfCTSheetView = new CTSheetView[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSheetView);
      return arrayOfCTSheetView;
    } 
  }
  
  public CTSheetView getSheetViewArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetView cTSheetView = null;
      cTSheetView = (CTSheetView)get_store().find_element_user(SHEETVIEW$0, paramInt);
      if (cTSheetView == null)
        throw new IndexOutOfBoundsException(); 
      return cTSheetView;
    } 
  }
  
  public int sizeOfSheetViewArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHEETVIEW$0);
    } 
  }
  
  public void setSheetViewArray(CTSheetView[] paramArrayOfCTSheetView) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSheetView, SHEETVIEW$0);
    } 
  }
  
  public void setSheetViewArray(int paramInt, CTSheetView paramCTSheetView) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetView cTSheetView = null;
      cTSheetView = (CTSheetView)get_store().find_element_user(SHEETVIEW$0, paramInt);
      if (cTSheetView == null)
        throw new IndexOutOfBoundsException(); 
      cTSheetView.set((XmlObject)paramCTSheetView);
    } 
  }
  
  public CTSheetView insertNewSheetView(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetView cTSheetView = null;
      cTSheetView = (CTSheetView)get_store().insert_element_user(SHEETVIEW$0, paramInt);
      return cTSheetView;
    } 
  }
  
  public CTSheetView addNewSheetView() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetView cTSheetView = null;
      cTSheetView = (CTSheetView)get_store().add_element_user(SHEETVIEW$0);
      return cTSheetView;
    } 
  }
  
  public void removeSheetView(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETVIEW$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetViewsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */