package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties;

public class CTStretchInfoPropertiesImpl extends XmlComplexContentImpl implements CTStretchInfoProperties {
  private static final b FILLRECT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fillRect");
  
  public CTStretchInfoPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRelativeRect getFillRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().find_element_user(FILLRECT$0, 0);
      if (cTRelativeRect == null)
        return null; 
      return cTRelativeRect;
    } 
  }
  
  public boolean isSetFillRect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILLRECT$0) != 0);
    } 
  }
  
  public void setFillRect(CTRelativeRect paramCTRelativeRect) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().find_element_user(FILLRECT$0, 0);
      if (cTRelativeRect == null)
        cTRelativeRect = (CTRelativeRect)get_store().add_element_user(FILLRECT$0); 
      cTRelativeRect.set((XmlObject)paramCTRelativeRect);
    } 
  }
  
  public CTRelativeRect addNewFillRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().add_element_user(FILLRECT$0);
      return cTRelativeRect;
    } 
  }
  
  public void unsetFillRect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILLRECT$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTStretchInfoPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */