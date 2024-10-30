package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPolarAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTXYAdjustHandle;

public class CTAdjustHandleListImpl extends XmlComplexContentImpl implements CTAdjustHandleList {
  private static final b AHXY$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ahXY");
  
  private static final b AHPOLAR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ahPolar");
  
  public CTAdjustHandleListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTXYAdjustHandle> getAhXYList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTXYAdjustHandle>)new AhXYList(this);
    } 
  }
  
  public CTXYAdjustHandle[] getAhXYArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AHXY$0, arrayList);
      CTXYAdjustHandle[] arrayOfCTXYAdjustHandle = new CTXYAdjustHandle[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTXYAdjustHandle);
      return arrayOfCTXYAdjustHandle;
    } 
  }
  
  public CTXYAdjustHandle getAhXYArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTXYAdjustHandle cTXYAdjustHandle = null;
      cTXYAdjustHandle = (CTXYAdjustHandle)get_store().find_element_user(AHXY$0, paramInt);
      if (cTXYAdjustHandle == null)
        throw new IndexOutOfBoundsException(); 
      return cTXYAdjustHandle;
    } 
  }
  
  public int sizeOfAhXYArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AHXY$0);
    } 
  }
  
  public void setAhXYArray(CTXYAdjustHandle[] paramArrayOfCTXYAdjustHandle) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTXYAdjustHandle, AHXY$0);
    } 
  }
  
  public void setAhXYArray(int paramInt, CTXYAdjustHandle paramCTXYAdjustHandle) {
    synchronized (monitor()) {
      check_orphaned();
      CTXYAdjustHandle cTXYAdjustHandle = null;
      cTXYAdjustHandle = (CTXYAdjustHandle)get_store().find_element_user(AHXY$0, paramInt);
      if (cTXYAdjustHandle == null)
        throw new IndexOutOfBoundsException(); 
      cTXYAdjustHandle.set((XmlObject)paramCTXYAdjustHandle);
    } 
  }
  
  public CTXYAdjustHandle insertNewAhXY(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTXYAdjustHandle cTXYAdjustHandle = null;
      cTXYAdjustHandle = (CTXYAdjustHandle)get_store().insert_element_user(AHXY$0, paramInt);
      return cTXYAdjustHandle;
    } 
  }
  
  public CTXYAdjustHandle addNewAhXY() {
    synchronized (monitor()) {
      check_orphaned();
      CTXYAdjustHandle cTXYAdjustHandle = null;
      cTXYAdjustHandle = (CTXYAdjustHandle)get_store().add_element_user(AHXY$0);
      return cTXYAdjustHandle;
    } 
  }
  
  public void removeAhXY(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AHXY$0, paramInt);
    } 
  }
  
  public List<CTPolarAdjustHandle> getAhPolarList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPolarAdjustHandle>)new AhPolarList(this);
    } 
  }
  
  public CTPolarAdjustHandle[] getAhPolarArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AHPOLAR$2, arrayList);
      CTPolarAdjustHandle[] arrayOfCTPolarAdjustHandle = new CTPolarAdjustHandle[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPolarAdjustHandle);
      return arrayOfCTPolarAdjustHandle;
    } 
  }
  
  public CTPolarAdjustHandle getAhPolarArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPolarAdjustHandle cTPolarAdjustHandle = null;
      cTPolarAdjustHandle = (CTPolarAdjustHandle)get_store().find_element_user(AHPOLAR$2, paramInt);
      if (cTPolarAdjustHandle == null)
        throw new IndexOutOfBoundsException(); 
      return cTPolarAdjustHandle;
    } 
  }
  
  public int sizeOfAhPolarArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AHPOLAR$2);
    } 
  }
  
  public void setAhPolarArray(CTPolarAdjustHandle[] paramArrayOfCTPolarAdjustHandle) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPolarAdjustHandle, AHPOLAR$2);
    } 
  }
  
  public void setAhPolarArray(int paramInt, CTPolarAdjustHandle paramCTPolarAdjustHandle) {
    synchronized (monitor()) {
      check_orphaned();
      CTPolarAdjustHandle cTPolarAdjustHandle = null;
      cTPolarAdjustHandle = (CTPolarAdjustHandle)get_store().find_element_user(AHPOLAR$2, paramInt);
      if (cTPolarAdjustHandle == null)
        throw new IndexOutOfBoundsException(); 
      cTPolarAdjustHandle.set((XmlObject)paramCTPolarAdjustHandle);
    } 
  }
  
  public CTPolarAdjustHandle insertNewAhPolar(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPolarAdjustHandle cTPolarAdjustHandle = null;
      cTPolarAdjustHandle = (CTPolarAdjustHandle)get_store().insert_element_user(AHPOLAR$2, paramInt);
      return cTPolarAdjustHandle;
    } 
  }
  
  public CTPolarAdjustHandle addNewAhPolar() {
    synchronized (monitor()) {
      check_orphaned();
      CTPolarAdjustHandle cTPolarAdjustHandle = null;
      cTPolarAdjustHandle = (CTPolarAdjustHandle)get_store().add_element_user(AHPOLAR$2);
      return cTPolarAdjustHandle;
    } 
  }
  
  public void removeAhPolar(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AHPOLAR$2, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTAdjustHandleListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */