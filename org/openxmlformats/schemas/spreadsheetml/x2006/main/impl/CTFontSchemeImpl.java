package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontScheme;

public class CTFontSchemeImpl extends XmlComplexContentImpl implements CTFontScheme {
  private static final b VAL$0 = new b("", "val");
  
  public CTFontSchemeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STFontScheme.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STFontScheme.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STFontScheme xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STFontScheme sTFontScheme = null;
      sTFontScheme = (STFontScheme)get_store().find_attribute_user(VAL$0);
      return sTFontScheme;
    } 
  }
  
  public void setVal(STFontScheme.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STFontScheme paramSTFontScheme) {
    synchronized (monitor()) {
      check_orphaned();
      STFontScheme sTFontScheme = null;
      sTFontScheme = (STFontScheme)get_store().find_attribute_user(VAL$0);
      if (sTFontScheme == null)
        sTFontScheme = (STFontScheme)get_store().add_attribute_user(VAL$0); 
      sTFontScheme.set((XmlObject)paramSTFontScheme);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTFontSchemeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */