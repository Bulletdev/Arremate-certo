package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;

public class CTAxPosImpl extends XmlComplexContentImpl implements CTAxPos {
  private static final b VAL$0 = new b("", "val");
  
  public CTAxPosImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STAxPos.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STAxPos.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STAxPos xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STAxPos sTAxPos = null;
      sTAxPos = (STAxPos)get_store().find_attribute_user(VAL$0);
      return sTAxPos;
    } 
  }
  
  public void setVal(STAxPos.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STAxPos paramSTAxPos) {
    synchronized (monitor()) {
      check_orphaned();
      STAxPos sTAxPos = null;
      sTAxPos = (STAxPos)get_store().find_attribute_user(VAL$0);
      if (sTAxPos == null)
        sTAxPos = (STAxPos)get_store().add_attribute_user(VAL$0); 
      sTAxPos.set((XmlObject)paramSTAxPos);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTAxPosImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */