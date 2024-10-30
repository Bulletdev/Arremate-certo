package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutTarget;

public class CTLayoutTargetImpl extends XmlComplexContentImpl implements CTLayoutTarget {
  private static final b VAL$0 = new b("", "val");
  
  public CTLayoutTargetImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STLayoutTarget.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VAL$0); 
      if (simpleValue == null)
        return null; 
      return (STLayoutTarget.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STLayoutTarget xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STLayoutTarget sTLayoutTarget = null;
      sTLayoutTarget = (STLayoutTarget)get_store().find_attribute_user(VAL$0);
      if (sTLayoutTarget == null)
        sTLayoutTarget = (STLayoutTarget)get_default_attribute_value(VAL$0); 
      return sTLayoutTarget;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STLayoutTarget.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STLayoutTarget paramSTLayoutTarget) {
    synchronized (monitor()) {
      check_orphaned();
      STLayoutTarget sTLayoutTarget = null;
      sTLayoutTarget = (STLayoutTarget)get_store().find_attribute_user(VAL$0);
      if (sTLayoutTarget == null)
        sTLayoutTarget = (STLayoutTarget)get_store().add_attribute_user(VAL$0); 
      sTLayoutTarget.set((XmlObject)paramSTLayoutTarget);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTLayoutTargetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */