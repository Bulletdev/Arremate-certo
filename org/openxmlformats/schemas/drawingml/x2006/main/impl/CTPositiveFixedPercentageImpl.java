package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;

public class CTPositiveFixedPercentageImpl extends XmlComplexContentImpl implements CTPositiveFixedPercentage {
  private static final b VAL$0 = new b("", "val");
  
  public CTPositiveFixedPercentageImpl(SchemaType paramSchemaType) {
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
  
  public STPositiveFixedPercentage xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveFixedPercentage sTPositiveFixedPercentage = null;
      sTPositiveFixedPercentage = (STPositiveFixedPercentage)get_store().find_attribute_user(VAL$0);
      return sTPositiveFixedPercentage;
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
  
  public void xsetVal(STPositiveFixedPercentage paramSTPositiveFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveFixedPercentage sTPositiveFixedPercentage = null;
      sTPositiveFixedPercentage = (STPositiveFixedPercentage)get_store().find_attribute_user(VAL$0);
      if (sTPositiveFixedPercentage == null)
        sTPositiveFixedPercentage = (STPositiveFixedPercentage)get_store().add_attribute_user(VAL$0); 
      sTPositiveFixedPercentage.set((XmlObject)paramSTPositiveFixedPercentage);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPositiveFixedPercentageImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */