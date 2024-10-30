package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;

public class CTTickLblPosImpl extends XmlComplexContentImpl implements CTTickLblPos {
  private static final b VAL$0 = new b("", "val");
  
  public CTTickLblPosImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STTickLblPos.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VAL$0); 
      if (simpleValue == null)
        return null; 
      return (STTickLblPos.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTickLblPos xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STTickLblPos sTTickLblPos = null;
      sTTickLblPos = (STTickLblPos)get_store().find_attribute_user(VAL$0);
      if (sTTickLblPos == null)
        sTTickLblPos = (STTickLblPos)get_default_attribute_value(VAL$0); 
      return sTTickLblPos;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STTickLblPos.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STTickLblPos paramSTTickLblPos) {
    synchronized (monitor()) {
      check_orphaned();
      STTickLblPos sTTickLblPos = null;
      sTTickLblPos = (STTickLblPos)get_store().find_attribute_user(VAL$0);
      if (sTTickLblPos == null)
        sTTickLblPos = (STTickLblPos)get_store().add_attribute_user(VAL$0); 
      sTTickLblPos.set((XmlObject)paramSTTickLblPos);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTTickLblPosImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */