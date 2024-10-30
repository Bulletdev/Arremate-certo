package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;

public class CTGeomGuideListImpl extends XmlComplexContentImpl implements CTGeomGuideList {
  private static final b GD$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gd");
  
  public CTGeomGuideListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTGeomGuide> getGdList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGeomGuide>)new GdList(this);
    } 
  }
  
  public CTGeomGuide[] getGdArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GD$0, arrayList);
      CTGeomGuide[] arrayOfCTGeomGuide = new CTGeomGuide[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGeomGuide);
      return arrayOfCTGeomGuide;
    } 
  }
  
  public CTGeomGuide getGdArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuide cTGeomGuide = null;
      cTGeomGuide = (CTGeomGuide)get_store().find_element_user(GD$0, paramInt);
      if (cTGeomGuide == null)
        throw new IndexOutOfBoundsException(); 
      return cTGeomGuide;
    } 
  }
  
  public int sizeOfGdArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GD$0);
    } 
  }
  
  public void setGdArray(CTGeomGuide[] paramArrayOfCTGeomGuide) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGeomGuide, GD$0);
    } 
  }
  
  public void setGdArray(int paramInt, CTGeomGuide paramCTGeomGuide) {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuide cTGeomGuide = null;
      cTGeomGuide = (CTGeomGuide)get_store().find_element_user(GD$0, paramInt);
      if (cTGeomGuide == null)
        throw new IndexOutOfBoundsException(); 
      cTGeomGuide.set((XmlObject)paramCTGeomGuide);
    } 
  }
  
  public CTGeomGuide insertNewGd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuide cTGeomGuide = null;
      cTGeomGuide = (CTGeomGuide)get_store().insert_element_user(GD$0, paramInt);
      return cTGeomGuide;
    } 
  }
  
  public CTGeomGuide addNewGd() {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuide cTGeomGuide = null;
      cTGeomGuide = (CTGeomGuide)get_store().add_element_user(GD$0);
      return cTGeomGuide;
    } 
  }
  
  public void removeGd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GD$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGeomGuideListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */