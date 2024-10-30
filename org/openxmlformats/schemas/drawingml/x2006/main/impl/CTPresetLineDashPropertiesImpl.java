package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;

public class CTPresetLineDashPropertiesImpl extends XmlComplexContentImpl implements CTPresetLineDashProperties {
  private static final b VAL$0 = new b("", "val");
  
  public CTPresetLineDashPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STPresetLineDashVal.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STPresetLineDashVal.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPresetLineDashVal xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STPresetLineDashVal sTPresetLineDashVal = null;
      sTPresetLineDashVal = (STPresetLineDashVal)get_store().find_attribute_user(VAL$0);
      return sTPresetLineDashVal;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STPresetLineDashVal.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STPresetLineDashVal paramSTPresetLineDashVal) {
    synchronized (monitor()) {
      check_orphaned();
      STPresetLineDashVal sTPresetLineDashVal = null;
      sTPresetLineDashVal = (STPresetLineDashVal)get_store().find_attribute_user(VAL$0);
      if (sTPresetLineDashVal == null)
        sTPresetLineDashVal = (STPresetLineDashVal)get_store().add_attribute_user(VAL$0); 
      sTPresetLineDashVal.set((XmlObject)paramSTPresetLineDashVal);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPresetLineDashPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */