package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

public class CTJcImpl extends XmlComplexContentImpl implements CTJc {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTJcImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STJc.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STJc.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STJc xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STJc sTJc = null;
      sTJc = (STJc)get_store().find_attribute_user(VAL$0);
      return sTJc;
    } 
  }
  
  public void setVal(STJc.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STJc paramSTJc) {
    synchronized (monitor()) {
      check_orphaned();
      STJc sTJc = null;
      sTJc = (STJc)get_store().find_attribute_user(VAL$0);
      if (sTJc == null)
        sTJc = (STJc)get_store().add_attribute_user(VAL$0); 
      sTJc.set((XmlObject)paramSTJc);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTJcImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */