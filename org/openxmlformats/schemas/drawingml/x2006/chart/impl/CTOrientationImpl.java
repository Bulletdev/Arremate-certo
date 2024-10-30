package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOrientation;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOrientation;

public class CTOrientationImpl extends XmlComplexContentImpl implements CTOrientation {
  private static final b VAL$0 = new b("", "val");
  
  public CTOrientationImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STOrientation.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VAL$0); 
      if (simpleValue == null)
        return null; 
      return (STOrientation.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOrientation xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STOrientation sTOrientation = null;
      sTOrientation = (STOrientation)get_store().find_attribute_user(VAL$0);
      if (sTOrientation == null)
        sTOrientation = (STOrientation)get_default_attribute_value(VAL$0); 
      return sTOrientation;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STOrientation.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STOrientation paramSTOrientation) {
    synchronized (monitor()) {
      check_orphaned();
      STOrientation sTOrientation = null;
      sTOrientation = (STOrientation)get_store().find_attribute_user(VAL$0);
      if (sTOrientation == null)
        sTOrientation = (STOrientation)get_store().add_attribute_user(VAL$0); 
      sTOrientation.set((XmlObject)paramSTOrientation);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTOrientationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */