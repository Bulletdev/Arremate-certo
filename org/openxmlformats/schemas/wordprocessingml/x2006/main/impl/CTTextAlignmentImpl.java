package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;

public class CTTextAlignmentImpl extends XmlComplexContentImpl implements CTTextAlignment {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTTextAlignmentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STTextAlignment.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STTextAlignment.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextAlignment xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STTextAlignment sTTextAlignment = null;
      sTTextAlignment = (STTextAlignment)get_store().find_attribute_user(VAL$0);
      return sTTextAlignment;
    } 
  }
  
  public void setVal(STTextAlignment.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STTextAlignment paramSTTextAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      STTextAlignment sTTextAlignment = null;
      sTTextAlignment = (STTextAlignment)get_store().find_attribute_user(VAL$0);
      if (sTTextAlignment == null)
        sTTextAlignment = (STTextAlignment)get_store().add_attribute_user(VAL$0); 
      sTTextAlignment.set((XmlObject)paramSTTextAlignment);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTextAlignmentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */