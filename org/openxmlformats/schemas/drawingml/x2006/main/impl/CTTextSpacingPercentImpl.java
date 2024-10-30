package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPercent;

public class CTTextSpacingPercentImpl extends XmlComplexContentImpl implements CTTextSpacingPercent {
  private static final b VAL$0 = new b("", "val");
  
  public CTTextSpacingPercentImpl(SchemaType paramSchemaType) {
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
  
  public STTextSpacingPercent xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STTextSpacingPercent sTTextSpacingPercent = null;
      sTTextSpacingPercent = (STTextSpacingPercent)get_store().find_attribute_user(VAL$0);
      return sTTextSpacingPercent;
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
  
  public void xsetVal(STTextSpacingPercent paramSTTextSpacingPercent) {
    synchronized (monitor()) {
      check_orphaned();
      STTextSpacingPercent sTTextSpacingPercent = null;
      sTTextSpacingPercent = (STTextSpacingPercent)get_store().find_attribute_user(VAL$0);
      if (sTTextSpacingPercent == null)
        sTTextSpacingPercent = (STTextSpacingPercent)get_store().add_attribute_user(VAL$0); 
      sTTextSpacingPercent.set((XmlObject)paramSTTextSpacingPercent);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextSpacingPercentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */