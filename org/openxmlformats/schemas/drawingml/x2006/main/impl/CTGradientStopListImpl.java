package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList;

public class CTGradientStopListImpl extends XmlComplexContentImpl implements CTGradientStopList {
  private static final b GS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gs");
  
  public CTGradientStopListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTGradientStop> getGsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGradientStop>)new GsList(this);
    } 
  }
  
  public CTGradientStop[] getGsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GS$0, arrayList);
      CTGradientStop[] arrayOfCTGradientStop = new CTGradientStop[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGradientStop);
      return arrayOfCTGradientStop;
    } 
  }
  
  public CTGradientStop getGsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientStop cTGradientStop = null;
      cTGradientStop = (CTGradientStop)get_store().find_element_user(GS$0, paramInt);
      if (cTGradientStop == null)
        throw new IndexOutOfBoundsException(); 
      return cTGradientStop;
    } 
  }
  
  public int sizeOfGsArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GS$0);
    } 
  }
  
  public void setGsArray(CTGradientStop[] paramArrayOfCTGradientStop) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGradientStop, GS$0);
    } 
  }
  
  public void setGsArray(int paramInt, CTGradientStop paramCTGradientStop) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientStop cTGradientStop = null;
      cTGradientStop = (CTGradientStop)get_store().find_element_user(GS$0, paramInt);
      if (cTGradientStop == null)
        throw new IndexOutOfBoundsException(); 
      cTGradientStop.set((XmlObject)paramCTGradientStop);
    } 
  }
  
  public CTGradientStop insertNewGs(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientStop cTGradientStop = null;
      cTGradientStop = (CTGradientStop)get_store().insert_element_user(GS$0, paramInt);
      return cTGradientStop;
    } 
  }
  
  public CTGradientStop addNewGs() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientStop cTGradientStop = null;
      cTGradientStop = (CTGradientStop)get_store().add_element_user(GS$0);
      return cTGradientStop;
    } 
  }
  
  public void removeGs(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GS$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGradientStopListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */