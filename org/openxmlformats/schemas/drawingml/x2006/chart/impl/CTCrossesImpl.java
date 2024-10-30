package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrosses;

public class CTCrossesImpl extends XmlComplexContentImpl implements CTCrosses {
  private static final b VAL$0 = new b("", "val");
  
  public CTCrossesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STCrosses.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STCrosses.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCrosses xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STCrosses sTCrosses = null;
      sTCrosses = (STCrosses)get_store().find_attribute_user(VAL$0);
      return sTCrosses;
    } 
  }
  
  public void setVal(STCrosses.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STCrosses paramSTCrosses) {
    synchronized (monitor()) {
      check_orphaned();
      STCrosses sTCrosses = null;
      sTCrosses = (STCrosses)get_store().find_attribute_user(VAL$0);
      if (sTCrosses == null)
        sTCrosses = (STCrosses)get_store().add_attribute_user(VAL$0); 
      sTCrosses.set((XmlObject)paramSTCrosses);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTCrossesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */