package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTFontNameImpl extends XmlComplexContentImpl implements CTFontName {
  private static final b VAL$0 = new b("", "val");
  
  public CTFontNameImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(VAL$0);
      return sTXstring;
    } 
  }
  
  public void setVal(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetVal(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(VAL$0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(VAL$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTFontNameImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */