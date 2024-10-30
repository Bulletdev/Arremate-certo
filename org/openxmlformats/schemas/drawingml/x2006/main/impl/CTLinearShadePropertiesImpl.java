package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedAngle;

public class CTLinearShadePropertiesImpl extends XmlComplexContentImpl implements CTLinearShadeProperties {
  private static final b ANG$0 = new b("", "ang");
  
  private static final b SCALED$2 = new b("", "scaled");
  
  public CTLinearShadePropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getAng() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANG$0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPositiveFixedAngle xgetAng() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveFixedAngle sTPositiveFixedAngle = null;
      sTPositiveFixedAngle = (STPositiveFixedAngle)get_store().find_attribute_user(ANG$0);
      return sTPositiveFixedAngle;
    } 
  }
  
  public boolean isSetAng() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ANG$0) != null);
    } 
  }
  
  public void setAng(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANG$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ANG$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetAng(STPositiveFixedAngle paramSTPositiveFixedAngle) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveFixedAngle sTPositiveFixedAngle = null;
      sTPositiveFixedAngle = (STPositiveFixedAngle)get_store().find_attribute_user(ANG$0);
      if (sTPositiveFixedAngle == null)
        sTPositiveFixedAngle = (STPositiveFixedAngle)get_store().add_attribute_user(ANG$0); 
      sTPositiveFixedAngle.set((XmlObject)paramSTPositiveFixedAngle);
    } 
  }
  
  public void unsetAng() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ANG$0);
    } 
  }
  
  public boolean getScaled() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCALED$2);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetScaled() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SCALED$2);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetScaled() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SCALED$2) != null);
    } 
  }
  
  public void setScaled(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCALED$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SCALED$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetScaled(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SCALED$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SCALED$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetScaled() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SCALED$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTLinearShadePropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */