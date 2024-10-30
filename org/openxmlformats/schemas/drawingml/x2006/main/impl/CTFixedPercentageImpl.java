package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STFixedPercentage;

public class CTFixedPercentageImpl extends XmlComplexContentImpl implements CTFixedPercentage {
  private static final b VAL$0 = new b("", "val");
  
  public CTFixedPercentageImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STFixedPercentage xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STFixedPercentage sTFixedPercentage = null;
      sTFixedPercentage = (STFixedPercentage)get_store().find_attribute_user(VAL$0);
      return sTFixedPercentage;
    } 
  }
  
  public void setVal(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetVal(STFixedPercentage paramSTFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STFixedPercentage sTFixedPercentage = null;
      sTFixedPercentage = (STFixedPercentage)get_store().find_attribute_user(VAL$0);
      if (sTFixedPercentage == null)
        sTFixedPercentage = (STFixedPercentage)get_store().add_attribute_user(VAL$0); 
      sTFixedPercentage.set((XmlObject)paramSTFixedPercentage);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTFixedPercentageImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */