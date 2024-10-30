package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTH;
import com.microsoft.schemas.vml.CTHandles;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTHandlesImpl extends XmlComplexContentImpl implements CTHandles {
  private static final b H$0 = new b("urn:schemas-microsoft-com:vml", "h");
  
  public CTHandlesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTH> getHList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTH>)new HList(this);
    } 
  }
  
  public CTH[] getHArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(H$0, arrayList);
      CTH[] arrayOfCTH = new CTH[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTH);
      return arrayOfCTH;
    } 
  }
  
  public CTH getHArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTH cTH = null;
      cTH = (CTH)get_store().find_element_user(H$0, paramInt);
      if (cTH == null)
        throw new IndexOutOfBoundsException(); 
      return cTH;
    } 
  }
  
  public int sizeOfHArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(H$0);
    } 
  }
  
  public void setHArray(CTH[] paramArrayOfCTH) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTH, H$0);
    } 
  }
  
  public void setHArray(int paramInt, CTH paramCTH) {
    synchronized (monitor()) {
      check_orphaned();
      CTH cTH = null;
      cTH = (CTH)get_store().find_element_user(H$0, paramInt);
      if (cTH == null)
        throw new IndexOutOfBoundsException(); 
      cTH.set((XmlObject)paramCTH);
    } 
  }
  
  public CTH insertNewH(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTH cTH = null;
      cTH = (CTH)get_store().insert_element_user(H$0, paramInt);
      return cTH;
    } 
  }
  
  public CTH addNewH() {
    synchronized (monitor()) {
      check_orphaned();
      CTH cTH = null;
      cTH = (CTH)get_store().add_element_user(H$0);
      return cTH;
    } 
  }
  
  public void removeH(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(H$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTHandlesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */