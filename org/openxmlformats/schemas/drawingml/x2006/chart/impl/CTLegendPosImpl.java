package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;

public class CTLegendPosImpl extends XmlComplexContentImpl implements CTLegendPos {
  private static final b VAL$0 = new b("", "val");
  
  public CTLegendPosImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STLegendPos.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VAL$0); 
      if (simpleValue == null)
        return null; 
      return (STLegendPos.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STLegendPos xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STLegendPos sTLegendPos = null;
      sTLegendPos = (STLegendPos)get_store().find_attribute_user(VAL$0);
      if (sTLegendPos == null)
        sTLegendPos = (STLegendPos)get_default_attribute_value(VAL$0); 
      return sTLegendPos;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STLegendPos.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STLegendPos paramSTLegendPos) {
    synchronized (monitor()) {
      check_orphaned();
      STLegendPos sTLegendPos = null;
      sTLegendPos = (STLegendPos)get_store().find_attribute_user(VAL$0);
      if (sTLegendPos == null)
        sTLegendPos = (STLegendPos)get_store().add_attribute_user(VAL$0); 
      sTLegendPos.set((XmlObject)paramSTLegendPos);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTLegendPosImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */