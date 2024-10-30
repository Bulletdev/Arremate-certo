package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

public class CTNumFmtImpl extends XmlComplexContentImpl implements CTNumFmt {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTNumFmtImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STNumberFormat.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STNumberFormat.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STNumberFormat xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STNumberFormat sTNumberFormat = null;
      sTNumberFormat = (STNumberFormat)get_store().find_attribute_user(VAL$0);
      return sTNumberFormat;
    } 
  }
  
  public void setVal(STNumberFormat.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STNumberFormat paramSTNumberFormat) {
    synchronized (monitor()) {
      check_orphaned();
      STNumberFormat sTNumberFormat = null;
      sTNumberFormat = (STNumberFormat)get_store().find_attribute_user(VAL$0);
      if (sTNumberFormat == null)
        sTNumberFormat = (STNumberFormat)get_store().add_attribute_user(VAL$0); 
      sTNumberFormat.set((XmlObject)paramSTNumberFormat);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTNumFmtImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */