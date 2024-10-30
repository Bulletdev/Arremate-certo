package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;

public class CTUnderlinePropertyImpl extends XmlComplexContentImpl implements CTUnderlineProperty {
  private static final b VAL$0 = new b("", "val");
  
  public CTUnderlinePropertyImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STUnderlineValues.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VAL$0); 
      if (simpleValue == null)
        return null; 
      return (STUnderlineValues.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STUnderlineValues xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STUnderlineValues sTUnderlineValues = null;
      sTUnderlineValues = (STUnderlineValues)get_store().find_attribute_user(VAL$0);
      if (sTUnderlineValues == null)
        sTUnderlineValues = (STUnderlineValues)get_default_attribute_value(VAL$0); 
      return sTUnderlineValues;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STUnderlineValues.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STUnderlineValues paramSTUnderlineValues) {
    synchronized (monitor()) {
      check_orphaned();
      STUnderlineValues sTUnderlineValues = null;
      sTUnderlineValues = (STUnderlineValues)get_store().find_attribute_user(VAL$0);
      if (sTUnderlineValues == null)
        sTUnderlineValues = (STUnderlineValues)get_store().add_attribute_user(VAL$0); 
      sTUnderlineValues.set((XmlObject)paramSTUnderlineValues);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTUnderlinePropertyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */