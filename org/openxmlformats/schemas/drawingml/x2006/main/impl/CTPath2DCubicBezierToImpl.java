package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;

public class CTPath2DCubicBezierToImpl extends XmlComplexContentImpl implements CTPath2DCubicBezierTo {
  private static final b PT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pt");
  
  public CTPath2DCubicBezierToImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTAdjPoint2D> getPtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAdjPoint2D>)new PtList(this);
    } 
  }
  
  public CTAdjPoint2D[] getPtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PT$0, arrayList);
      CTAdjPoint2D[] arrayOfCTAdjPoint2D = new CTAdjPoint2D[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAdjPoint2D);
      return arrayOfCTAdjPoint2D;
    } 
  }
  
  public CTAdjPoint2D getPtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjPoint2D cTAdjPoint2D = null;
      cTAdjPoint2D = (CTAdjPoint2D)get_store().find_element_user(PT$0, paramInt);
      if (cTAdjPoint2D == null)
        throw new IndexOutOfBoundsException(); 
      return cTAdjPoint2D;
    } 
  }
  
  public int sizeOfPtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PT$0);
    } 
  }
  
  public void setPtArray(CTAdjPoint2D[] paramArrayOfCTAdjPoint2D) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAdjPoint2D, PT$0);
    } 
  }
  
  public void setPtArray(int paramInt, CTAdjPoint2D paramCTAdjPoint2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjPoint2D cTAdjPoint2D = null;
      cTAdjPoint2D = (CTAdjPoint2D)get_store().find_element_user(PT$0, paramInt);
      if (cTAdjPoint2D == null)
        throw new IndexOutOfBoundsException(); 
      cTAdjPoint2D.set((XmlObject)paramCTAdjPoint2D);
    } 
  }
  
  public CTAdjPoint2D insertNewPt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjPoint2D cTAdjPoint2D = null;
      cTAdjPoint2D = (CTAdjPoint2D)get_store().insert_element_user(PT$0, paramInt);
      return cTAdjPoint2D;
    } 
  }
  
  public CTAdjPoint2D addNewPt() {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjPoint2D cTAdjPoint2D = null;
      cTAdjPoint2D = (CTAdjPoint2D)get_store().add_element_user(PT$0);
      return cTAdjPoint2D;
    } 
  }
  
  public void removePt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PT$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPath2DCubicBezierToImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */