package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;

public class CTPoint2DImpl extends XmlComplexContentImpl implements CTPoint2D {
  private static final b X$0 = new b("", "x");
  
  private static final b Y$2 = new b("", "y");
  
  public CTPoint2DImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getX() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X$0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STCoordinate xgetX() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_attribute_user(X$0);
      return sTCoordinate;
    } 
  }
  
  public void setX(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(X$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetX(STCoordinate paramSTCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_attribute_user(X$0);
      if (sTCoordinate == null)
        sTCoordinate = (STCoordinate)get_store().add_attribute_user(X$0); 
      sTCoordinate.set((XmlObject)paramSTCoordinate);
    } 
  }
  
  public long getY() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(Y$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STCoordinate xgetY() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_attribute_user(Y$2);
      return sTCoordinate;
    } 
  }
  
  public void setY(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(Y$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(Y$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetY(STCoordinate paramSTCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_attribute_user(Y$2);
      if (sTCoordinate == null)
        sTCoordinate = (STCoordinate)get_store().add_attribute_user(Y$2); 
      sTCoordinate.set((XmlObject)paramSTCoordinate);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPoint2DImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */