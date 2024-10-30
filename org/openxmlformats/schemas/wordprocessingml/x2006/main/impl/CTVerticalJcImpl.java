package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

public class CTVerticalJcImpl extends XmlComplexContentImpl implements CTVerticalJc {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTVerticalJcImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STVerticalJc.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STVerticalJc.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STVerticalJc xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STVerticalJc sTVerticalJc = null;
      sTVerticalJc = (STVerticalJc)get_store().find_attribute_user(VAL$0);
      return sTVerticalJc;
    } 
  }
  
  public void setVal(STVerticalJc.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STVerticalJc paramSTVerticalJc) {
    synchronized (monitor()) {
      check_orphaned();
      STVerticalJc sTVerticalJc = null;
      sTVerticalJc = (STVerticalJc)get_store().find_attribute_user(VAL$0);
      if (sTVerticalJc == null)
        sTVerticalJc = (STVerticalJc)get_store().add_attribute_user(VAL$0); 
      sTVerticalJc.set((XmlObject)paramSTVerticalJc);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTVerticalJcImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */