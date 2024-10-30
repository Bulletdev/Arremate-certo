package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;

public class CTFontSizeImpl extends XmlComplexContentImpl implements CTFontSize {
  private static final b VAL$0 = new b("", "val");
  
  public CTFontSizeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public double getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(VAL$0);
      return xmlDouble;
    } 
  }
  
  public void setVal(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetVal(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(VAL$0);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(VAL$0); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTFontSizeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */