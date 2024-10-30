package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLogBase;

public class CTLogBaseImpl extends XmlComplexContentImpl implements CTLogBase {
  private static final b VAL$0 = new b("", "val");
  
  public CTLogBaseImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public double getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public STLogBase xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STLogBase sTLogBase = null;
      sTLogBase = (STLogBase)get_store().find_attribute_user(VAL$0);
      return sTLogBase;
    } 
  }
  
  public void setVal(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetVal(STLogBase paramSTLogBase) {
    synchronized (monitor()) {
      check_orphaned();
      STLogBase sTLogBase = null;
      sTLogBase = (STLogBase)get_store().find_attribute_user(VAL$0);
      if (sTLogBase == null)
        sTLogBase = (STLogBase)get_store().add_attribute_user(VAL$0); 
      sTLogBase.set((XmlObject)paramSTLogBase);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTLogBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */