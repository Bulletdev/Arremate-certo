package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;

public class CTPath2DMoveToImpl extends XmlComplexContentImpl implements CTPath2DMoveTo {
  private static final b PT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pt");
  
  public CTPath2DMoveToImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTAdjPoint2D getPt() {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjPoint2D cTAdjPoint2D = null;
      cTAdjPoint2D = (CTAdjPoint2D)get_store().find_element_user(PT$0, 0);
      if (cTAdjPoint2D == null)
        return null; 
      return cTAdjPoint2D;
    } 
  }
  
  public void setPt(CTAdjPoint2D paramCTAdjPoint2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjPoint2D cTAdjPoint2D = null;
      cTAdjPoint2D = (CTAdjPoint2D)get_store().find_element_user(PT$0, 0);
      if (cTAdjPoint2D == null)
        cTAdjPoint2D = (CTAdjPoint2D)get_store().add_element_user(PT$0); 
      cTAdjPoint2D.set((XmlObject)paramCTAdjPoint2D);
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
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPath2DMoveToImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */