package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrossBetween;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrossBetween;

public class CTCrossBetweenImpl extends XmlComplexContentImpl implements CTCrossBetween {
  private static final b VAL$0 = new b("", "val");
  
  public CTCrossBetweenImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STCrossBetween.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STCrossBetween.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCrossBetween xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STCrossBetween sTCrossBetween = null;
      sTCrossBetween = (STCrossBetween)get_store().find_attribute_user(VAL$0);
      return sTCrossBetween;
    } 
  }
  
  public void setVal(STCrossBetween.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STCrossBetween paramSTCrossBetween) {
    synchronized (monitor()) {
      check_orphaned();
      STCrossBetween sTCrossBetween = null;
      sTCrossBetween = (STCrossBetween)get_store().find_attribute_user(VAL$0);
      if (sTCrossBetween == null)
        sTCrossBetween = (STCrossBetween)get_store().add_attribute_user(VAL$0); 
      sTCrossBetween.set((XmlObject)paramSTCrossBetween);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTCrossBetweenImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */