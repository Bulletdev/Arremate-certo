package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.STScatterStyle;

public class CTScatterStyleImpl extends XmlComplexContentImpl implements CTScatterStyle {
  private static final b VAL$0 = new b("", "val");
  
  public CTScatterStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STScatterStyle.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VAL$0); 
      if (simpleValue == null)
        return null; 
      return (STScatterStyle.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STScatterStyle xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STScatterStyle sTScatterStyle = null;
      sTScatterStyle = (STScatterStyle)get_store().find_attribute_user(VAL$0);
      if (sTScatterStyle == null)
        sTScatterStyle = (STScatterStyle)get_default_attribute_value(VAL$0); 
      return sTScatterStyle;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STScatterStyle.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STScatterStyle paramSTScatterStyle) {
    synchronized (monitor()) {
      check_orphaned();
      STScatterStyle sTScatterStyle = null;
      sTScatterStyle = (STScatterStyle)get_store().find_attribute_user(VAL$0);
      if (sTScatterStyle == null)
        sTScatterStyle = (STScatterStyle)get_store().add_attribute_user(VAL$0); 
      sTScatterStyle.set((XmlObject)paramSTScatterStyle);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTScatterStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */