package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextBulletSizePercent;

public class CTTextBulletSizePercentImpl extends XmlComplexContentImpl implements CTTextBulletSizePercent {
  private static final b VAL$0 = new b("", "val");
  
  public CTTextBulletSizePercentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextBulletSizePercent xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STTextBulletSizePercent sTTextBulletSizePercent = null;
      sTTextBulletSizePercent = (STTextBulletSizePercent)get_store().find_attribute_user(VAL$0);
      return sTTextBulletSizePercent;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetVal(STTextBulletSizePercent paramSTTextBulletSizePercent) {
    synchronized (monitor()) {
      check_orphaned();
      STTextBulletSizePercent sTTextBulletSizePercent = null;
      sTTextBulletSizePercent = (STTextBulletSizePercent)get_store().find_attribute_user(VAL$0);
      if (sTTextBulletSizePercent == null)
        sTTextBulletSizePercent = (STTextBulletSizePercent)get_store().add_attribute_user(VAL$0); 
      sTTextBulletSizePercent.set((XmlObject)paramSTTextBulletSizePercent);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextBulletSizePercentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */