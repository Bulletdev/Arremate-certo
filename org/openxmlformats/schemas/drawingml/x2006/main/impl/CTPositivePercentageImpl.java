package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositivePercentage;

public class CTPositivePercentageImpl extends XmlComplexContentImpl implements CTPositivePercentage {
  private static final b VAL$0 = new b("", "val");
  
  public CTPositivePercentageImpl(SchemaType paramSchemaType) {
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
  
  public STPositivePercentage xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STPositivePercentage sTPositivePercentage = null;
      sTPositivePercentage = (STPositivePercentage)get_store().find_attribute_user(VAL$0);
      return sTPositivePercentage;
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
  
  public void xsetVal(STPositivePercentage paramSTPositivePercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPositivePercentage sTPositivePercentage = null;
      sTPositivePercentage = (STPositivePercentage)get_store().find_attribute_user(VAL$0);
      if (sTPositivePercentage == null)
        sTPositivePercentage = (STPositivePercentage)get_store().add_attribute_user(VAL$0); 
      sTPositivePercentage.set((XmlObject)paramSTPositivePercentage);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPositivePercentageImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */