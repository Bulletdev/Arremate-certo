package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPoint;

public class CTTextSpacingPointImpl extends XmlComplexContentImpl implements CTTextSpacingPoint {
  private static final b VAL$0 = new b("", "val");
  
  public CTTextSpacingPointImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextSpacingPoint xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STTextSpacingPoint sTTextSpacingPoint = null;
      sTTextSpacingPoint = (STTextSpacingPoint)get_store().find_attribute_user(VAL$0);
      return sTTextSpacingPoint;
    } 
  }
  
  public void setVal(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetVal(STTextSpacingPoint paramSTTextSpacingPoint) {
    synchronized (monitor()) {
      check_orphaned();
      STTextSpacingPoint sTTextSpacingPoint = null;
      sTTextSpacingPoint = (STTextSpacingPoint)get_store().find_attribute_user(VAL$0);
      if (sTTextSpacingPoint == null)
        sTTextSpacingPoint = (STTextSpacingPoint)get_store().add_attribute_user(VAL$0); 
      sTTextSpacingPoint.set((XmlObject)paramSTTextSpacingPoint);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextSpacingPointImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */