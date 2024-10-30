package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalAlignRun;

public class CTVerticalAlignRunImpl extends XmlComplexContentImpl implements CTVerticalAlignRun {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTVerticalAlignRunImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STVerticalAlignRun.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STVerticalAlignRun.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STVerticalAlignRun xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STVerticalAlignRun sTVerticalAlignRun = null;
      sTVerticalAlignRun = (STVerticalAlignRun)get_store().find_attribute_user(VAL$0);
      return sTVerticalAlignRun;
    } 
  }
  
  public void setVal(STVerticalAlignRun.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STVerticalAlignRun paramSTVerticalAlignRun) {
    synchronized (monitor()) {
      check_orphaned();
      STVerticalAlignRun sTVerticalAlignRun = null;
      sTVerticalAlignRun = (STVerticalAlignRun)get_store().find_attribute_user(VAL$0);
      if (sTVerticalAlignRun == null)
        sTVerticalAlignRun = (STVerticalAlignRun)get_store().add_attribute_user(VAL$0); 
      sTVerticalAlignRun.set((XmlObject)paramSTVerticalAlignRun);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTVerticalAlignRunImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */