package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutMode;

public class CTLayoutModeImpl extends XmlComplexContentImpl implements CTLayoutMode {
  private static final b VAL$0 = new b("", "val");
  
  public CTLayoutModeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STLayoutMode.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VAL$0); 
      if (simpleValue == null)
        return null; 
      return (STLayoutMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STLayoutMode xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STLayoutMode sTLayoutMode = null;
      sTLayoutMode = (STLayoutMode)get_store().find_attribute_user(VAL$0);
      if (sTLayoutMode == null)
        sTLayoutMode = (STLayoutMode)get_default_attribute_value(VAL$0); 
      return sTLayoutMode;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STLayoutMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STLayoutMode paramSTLayoutMode) {
    synchronized (monitor()) {
      check_orphaned();
      STLayoutMode sTLayoutMode = null;
      sTLayoutMode = (STLayoutMode)get_store().find_attribute_user(VAL$0);
      if (sTLayoutMode == null)
        sTLayoutMode = (STLayoutMode)get_store().add_attribute_user(VAL$0); 
      sTLayoutMode.set((XmlObject)paramSTLayoutMode);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTLayoutModeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */