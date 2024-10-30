package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;

public class CTAdjPoint2DImpl extends XmlComplexContentImpl implements CTAdjPoint2D {
  private static final b X$0 = new b("", "x");
  
  private static final b Y$2 = new b("", "y");
  
  public CTAdjPoint2DImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public Object getX() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STAdjCoordinate xgetX() {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(X$0);
      return sTAdjCoordinate;
    } 
  }
  
  public void setX(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(X$0); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetX(STAdjCoordinate paramSTAdjCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(X$0);
      if (sTAdjCoordinate == null)
        sTAdjCoordinate = (STAdjCoordinate)get_store().add_attribute_user(X$0); 
      sTAdjCoordinate.set((XmlObject)paramSTAdjCoordinate);
    } 
  }
  
  public Object getY() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(Y$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STAdjCoordinate xgetY() {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(Y$2);
      return sTAdjCoordinate;
    } 
  }
  
  public void setY(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(Y$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(Y$2); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetY(STAdjCoordinate paramSTAdjCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(Y$2);
      if (sTAdjCoordinate == null)
        sTAdjCoordinate = (STAdjCoordinate)get_store().add_attribute_user(Y$2); 
      sTAdjCoordinate.set((XmlObject)paramSTAdjCoordinate);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTAdjPoint2DImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */