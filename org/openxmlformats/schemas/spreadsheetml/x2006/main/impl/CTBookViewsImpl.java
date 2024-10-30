package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews;

public class CTBookViewsImpl extends XmlComplexContentImpl implements CTBookViews {
  private static final b WORKBOOKVIEW$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbookView");
  
  public CTBookViewsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTBookView> getWorkbookViewList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBookView>)new WorkbookViewList(this);
    } 
  }
  
  public CTBookView[] getWorkbookViewArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(WORKBOOKVIEW$0, arrayList);
      CTBookView[] arrayOfCTBookView = new CTBookView[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBookView);
      return arrayOfCTBookView;
    } 
  }
  
  public CTBookView getWorkbookViewArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookView cTBookView = null;
      cTBookView = (CTBookView)get_store().find_element_user(WORKBOOKVIEW$0, paramInt);
      if (cTBookView == null)
        throw new IndexOutOfBoundsException(); 
      return cTBookView;
    } 
  }
  
  public int sizeOfWorkbookViewArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(WORKBOOKVIEW$0);
    } 
  }
  
  public void setWorkbookViewArray(CTBookView[] paramArrayOfCTBookView) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBookView, WORKBOOKVIEW$0);
    } 
  }
  
  public void setWorkbookViewArray(int paramInt, CTBookView paramCTBookView) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookView cTBookView = null;
      cTBookView = (CTBookView)get_store().find_element_user(WORKBOOKVIEW$0, paramInt);
      if (cTBookView == null)
        throw new IndexOutOfBoundsException(); 
      cTBookView.set((XmlObject)paramCTBookView);
    } 
  }
  
  public CTBookView insertNewWorkbookView(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookView cTBookView = null;
      cTBookView = (CTBookView)get_store().insert_element_user(WORKBOOKVIEW$0, paramInt);
      return cTBookView;
    } 
  }
  
  public CTBookView addNewWorkbookView() {
    synchronized (monitor()) {
      check_orphaned();
      CTBookView cTBookView = null;
      cTBookView = (CTBookView)get_store().add_element_user(WORKBOOKVIEW$0);
      return cTBookView;
    } 
  }
  
  public void removeWorkbookView(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WORKBOOKVIEW$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTBookViewsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */