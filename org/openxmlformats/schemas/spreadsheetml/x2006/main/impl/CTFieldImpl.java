package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;

public class CTFieldImpl extends XmlComplexContentImpl implements CTField {
  private static final b X$0 = new b("", "x");
  
  public CTFieldImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getX() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X$0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetX() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(X$0);
      return xmlInt;
    } 
  }
  
  public void setX(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(X$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetX(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(X$0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(X$0); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTFieldImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */