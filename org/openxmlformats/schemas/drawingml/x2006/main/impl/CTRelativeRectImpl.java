package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;

public class CTRelativeRectImpl extends XmlComplexContentImpl implements CTRelativeRect {
  private static final b L$0 = new b("", "l");
  
  private static final b T$2 = new b("", "t");
  
  private static final b R$4 = new b("", "r");
  
  private static final b B$6 = new b("", "b");
  
  public CTRelativeRectImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getL() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(L$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(L$0); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPercentage xgetL() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(L$0);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_default_attribute_value(L$0); 
      return sTPercentage;
    } 
  }
  
  public boolean isSetL() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(L$0) != null);
    } 
  }
  
  public void setL(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(L$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(L$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetL(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(L$0);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(L$0); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
  
  public void unsetL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(L$0);
    } 
  }
  
  public int getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(T$2); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPercentage xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(T$2);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_default_attribute_value(T$2); 
      return sTPercentage;
    } 
  }
  
  public boolean isSetT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(T$2) != null);
    } 
  }
  
  public void setT(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(T$2); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetT(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(T$2);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(T$2); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
  
  public void unsetT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(T$2);
    } 
  }
  
  public int getR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(R$4); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPercentage xgetR() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(R$4);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_default_attribute_value(R$4); 
      return sTPercentage;
    } 
  }
  
  public boolean isSetR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(R$4) != null);
    } 
  }
  
  public void setR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R$4); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetR(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(R$4);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(R$4); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
  
  public void unsetR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(R$4);
    } 
  }
  
  public int getB() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(B$6); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPercentage xgetB() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(B$6);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_default_attribute_value(B$6); 
      return sTPercentage;
    } 
  }
  
  public boolean isSetB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(B$6) != null);
    } 
  }
  
  public void setB(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(B$6); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetB(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(B$6);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(B$6); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
  
  public void unsetB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(B$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTRelativeRectImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */