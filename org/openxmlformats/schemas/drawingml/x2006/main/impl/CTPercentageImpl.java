package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;

public class CTPercentageImpl extends XmlComplexContentImpl implements CTPercentage {
  private static final b VAL$0 = new b("", "val");
  
  public CTPercentageImpl(SchemaType paramSchemaType) {
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
  
  public STPercentage xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(VAL$0);
      return sTPercentage;
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
  
  public void xsetVal(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(VAL$0);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(VAL$0); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPercentageImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */