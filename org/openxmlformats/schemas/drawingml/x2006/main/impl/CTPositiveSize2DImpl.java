package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate;

public class CTPositiveSize2DImpl extends XmlComplexContentImpl implements CTPositiveSize2D {
  private static final b CX$0 = new b("", "cx");
  
  private static final b CY$2 = new b("", "cy");
  
  public CTPositiveSize2DImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getCx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CX$0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STPositiveCoordinate xgetCx() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(CX$0);
      return sTPositiveCoordinate;
    } 
  }
  
  public void setCx(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CX$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CX$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCx(STPositiveCoordinate paramSTPositiveCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(CX$0);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_store().add_attribute_user(CX$0); 
      sTPositiveCoordinate.set((XmlObject)paramSTPositiveCoordinate);
    } 
  }
  
  public long getCy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CY$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STPositiveCoordinate xgetCy() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(CY$2);
      return sTPositiveCoordinate;
    } 
  }
  
  public void setCy(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CY$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CY$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCy(STPositiveCoordinate paramSTPositiveCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(CY$2);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_store().add_attribute_user(CY$2); 
      sTPositiveCoordinate.set((XmlObject)paramSTPositiveCoordinate);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPositiveSize2DImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */