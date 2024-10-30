package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositivePercentage;

public class CTAlphaModulateFixedEffectImpl extends XmlComplexContentImpl implements CTAlphaModulateFixedEffect {
  private static final b AMT$0 = new b("", "amt");
  
  public CTAlphaModulateFixedEffectImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getAmt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AMT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(AMT$0); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPositivePercentage xgetAmt() {
    synchronized (monitor()) {
      check_orphaned();
      STPositivePercentage sTPositivePercentage = null;
      sTPositivePercentage = (STPositivePercentage)get_store().find_attribute_user(AMT$0);
      if (sTPositivePercentage == null)
        sTPositivePercentage = (STPositivePercentage)get_default_attribute_value(AMT$0); 
      return sTPositivePercentage;
    } 
  }
  
  public boolean isSetAmt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AMT$0) != null);
    } 
  }
  
  public void setAmt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AMT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AMT$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetAmt(STPositivePercentage paramSTPositivePercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPositivePercentage sTPositivePercentage = null;
      sTPositivePercentage = (STPositivePercentage)get_store().find_attribute_user(AMT$0);
      if (sTPositivePercentage == null)
        sTPositivePercentage = (STPositivePercentage)get_store().add_attribute_user(AMT$0); 
      sTPositivePercentage.set((XmlObject)paramSTPositivePercentage);
    } 
  }
  
  public void unsetAmt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AMT$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTAlphaModulateFixedEffectImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */