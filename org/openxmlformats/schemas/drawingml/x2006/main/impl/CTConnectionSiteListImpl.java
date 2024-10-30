package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSite;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList;

public class CTConnectionSiteListImpl extends XmlComplexContentImpl implements CTConnectionSiteList {
  private static final b CXN$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "cxn");
  
  public CTConnectionSiteListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTConnectionSite> getCxnList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTConnectionSite>)new CxnList(this);
    } 
  }
  
  public CTConnectionSite[] getCxnArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CXN$0, arrayList);
      CTConnectionSite[] arrayOfCTConnectionSite = new CTConnectionSite[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTConnectionSite);
      return arrayOfCTConnectionSite;
    } 
  }
  
  public CTConnectionSite getCxnArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectionSite cTConnectionSite = null;
      cTConnectionSite = (CTConnectionSite)get_store().find_element_user(CXN$0, paramInt);
      if (cTConnectionSite == null)
        throw new IndexOutOfBoundsException(); 
      return cTConnectionSite;
    } 
  }
  
  public int sizeOfCxnArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CXN$0);
    } 
  }
  
  public void setCxnArray(CTConnectionSite[] paramArrayOfCTConnectionSite) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTConnectionSite, CXN$0);
    } 
  }
  
  public void setCxnArray(int paramInt, CTConnectionSite paramCTConnectionSite) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectionSite cTConnectionSite = null;
      cTConnectionSite = (CTConnectionSite)get_store().find_element_user(CXN$0, paramInt);
      if (cTConnectionSite == null)
        throw new IndexOutOfBoundsException(); 
      cTConnectionSite.set((XmlObject)paramCTConnectionSite);
    } 
  }
  
  public CTConnectionSite insertNewCxn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectionSite cTConnectionSite = null;
      cTConnectionSite = (CTConnectionSite)get_store().insert_element_user(CXN$0, paramInt);
      return cTConnectionSite;
    } 
  }
  
  public CTConnectionSite addNewCxn() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectionSite cTConnectionSite = null;
      cTConnectionSite = (CTConnectionSite)get_store().add_element_user(CXN$0);
      return cTConnectionSite;
    } 
  }
  
  public void removeCxn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CXN$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTConnectionSiteListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */