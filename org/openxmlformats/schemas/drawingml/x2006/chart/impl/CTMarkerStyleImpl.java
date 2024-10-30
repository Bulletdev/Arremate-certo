package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle;

public class CTMarkerStyleImpl extends XmlComplexContentImpl implements CTMarkerStyle {
  private static final b VAL$0 = new b("", "val");
  
  public CTMarkerStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STMarkerStyle.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STMarkerStyle.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STMarkerStyle xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STMarkerStyle sTMarkerStyle = null;
      sTMarkerStyle = (STMarkerStyle)get_store().find_attribute_user(VAL$0);
      return sTMarkerStyle;
    } 
  }
  
  public void setVal(STMarkerStyle.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STMarkerStyle paramSTMarkerStyle) {
    synchronized (monitor()) {
      check_orphaned();
      STMarkerStyle sTMarkerStyle = null;
      sTMarkerStyle = (STMarkerStyle)get_store().find_attribute_user(VAL$0);
      if (sTMarkerStyle == null)
        sTMarkerStyle = (STMarkerStyle)get_store().add_attribute_user(VAL$0); 
      sTMarkerStyle.set((XmlObject)paramSTMarkerStyle);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTMarkerStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */