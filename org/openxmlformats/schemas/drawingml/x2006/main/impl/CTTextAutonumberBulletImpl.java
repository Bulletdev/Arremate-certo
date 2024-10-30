package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextBulletStartAtNum;

public class CTTextAutonumberBulletImpl extends XmlComplexContentImpl implements CTTextAutonumberBullet {
  private static final b TYPE$0 = new b("", "type");
  
  private static final b STARTAT$2 = new b("", "startAt");
  
  public CTTextAutonumberBulletImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STTextAutonumberScheme.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        return null; 
      return (STTextAutonumberScheme.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextAutonumberScheme xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STTextAutonumberScheme sTTextAutonumberScheme = null;
      sTTextAutonumberScheme = (STTextAutonumberScheme)get_store().find_attribute_user(TYPE$0);
      return sTTextAutonumberScheme;
    } 
  }
  
  public void setType(STTextAutonumberScheme.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STTextAutonumberScheme paramSTTextAutonumberScheme) {
    synchronized (monitor()) {
      check_orphaned();
      STTextAutonumberScheme sTTextAutonumberScheme = null;
      sTTextAutonumberScheme = (STTextAutonumberScheme)get_store().find_attribute_user(TYPE$0);
      if (sTTextAutonumberScheme == null)
        sTTextAutonumberScheme = (STTextAutonumberScheme)get_store().add_attribute_user(TYPE$0); 
      sTTextAutonumberScheme.set((XmlObject)paramSTTextAutonumberScheme);
    } 
  }
  
  public int getStartAt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STARTAT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STARTAT$2); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextBulletStartAtNum xgetStartAt() {
    synchronized (monitor()) {
      check_orphaned();
      STTextBulletStartAtNum sTTextBulletStartAtNum = null;
      sTTextBulletStartAtNum = (STTextBulletStartAtNum)get_store().find_attribute_user(STARTAT$2);
      if (sTTextBulletStartAtNum == null)
        sTTextBulletStartAtNum = (STTextBulletStartAtNum)get_default_attribute_value(STARTAT$2); 
      return sTTextBulletStartAtNum;
    } 
  }
  
  public boolean isSetStartAt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STARTAT$2) != null);
    } 
  }
  
  public void setStartAt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STARTAT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STARTAT$2); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetStartAt(STTextBulletStartAtNum paramSTTextBulletStartAtNum) {
    synchronized (monitor()) {
      check_orphaned();
      STTextBulletStartAtNum sTTextBulletStartAtNum = null;
      sTTextBulletStartAtNum = (STTextBulletStartAtNum)get_store().find_attribute_user(STARTAT$2);
      if (sTTextBulletStartAtNum == null)
        sTTextBulletStartAtNum = (STTextBulletStartAtNum)get_store().add_attribute_user(STARTAT$2); 
      sTTextBulletStartAtNum.set((XmlObject)paramSTTextBulletStartAtNum);
    } 
  }
  
  public void unsetStartAt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STARTAT$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextAutonumberBulletImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */