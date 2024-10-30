package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickMark;

public class CTTickMarkImpl extends XmlComplexContentImpl implements CTTickMark {
  private static final b VAL$0 = new b("", "val");
  
  public CTTickMarkImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STTickMark.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VAL$0); 
      if (simpleValue == null)
        return null; 
      return (STTickMark.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTickMark xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STTickMark sTTickMark = null;
      sTTickMark = (STTickMark)get_store().find_attribute_user(VAL$0);
      if (sTTickMark == null)
        sTTickMark = (STTickMark)get_default_attribute_value(VAL$0); 
      return sTTickMark;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STTickMark.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STTickMark paramSTTickMark) {
    synchronized (monitor()) {
      check_orphaned();
      STTickMark sTTickMark = null;
      sTTickMark = (STTickMark)get_store().find_attribute_user(VAL$0);
      if (sTTickMark == null)
        sTTickMark = (STTickMark)get_store().add_attribute_user(VAL$0); 
      sTTickMark.set((XmlObject)paramSTTickMark);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTTickMarkImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */