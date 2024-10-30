package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

public class CTStringImpl extends XmlComplexContentImpl implements CTString {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTStringImpl(SchemaType paramSchemaType) {
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
  
  public STString xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(VAL$0);
      return sTString;
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
  
  public void xsetVal(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(VAL$0);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(VAL$0); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTStringImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */