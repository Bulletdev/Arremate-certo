package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;

public class CTHighlightImpl extends XmlComplexContentImpl implements CTHighlight {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTHighlightImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STHighlightColor.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STHighlightColor.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STHighlightColor xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STHighlightColor sTHighlightColor = null;
      sTHighlightColor = (STHighlightColor)get_store().find_attribute_user(VAL$0);
      return sTHighlightColor;
    } 
  }
  
  public void setVal(STHighlightColor.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STHighlightColor paramSTHighlightColor) {
    synchronized (monitor()) {
      check_orphaned();
      STHighlightColor sTHighlightColor = null;
      sTHighlightColor = (STHighlightColor)get_store().find_attribute_user(VAL$0);
      if (sTHighlightColor == null)
        sTHighlightColor = (STHighlightColor)get_store().add_attribute_user(VAL$0); 
      sTHighlightColor.set((XmlObject)paramSTHighlightColor);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTHighlightImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */