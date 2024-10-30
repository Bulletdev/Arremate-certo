package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBreak;

public class CTBreakImpl extends XmlComplexContentImpl implements CTBreak {
  private static final b ID$0 = new b("", "id");
  
  private static final b MIN$2 = new b("", "min");
  
  private static final b MAX$4 = new b("", "max");
  
  private static final b MAN$6 = new b("", "man");
  
  private static final b PT$8 = new b("", "pt");
  
  public CTBreakImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ID$0); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ID$0); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$0) != null);
    } 
  }
  
  public void setId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$0); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$0);
    } 
  }
  
  public long getMin() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MIN$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MIN$2); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMin() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MIN$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(MIN$2); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetMin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MIN$2) != null);
    } 
  }
  
  public void setMin(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MIN$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MIN$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMin(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MIN$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MIN$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetMin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MIN$2);
    } 
  }
  
  public long getMax() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAX$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MAX$4); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMax() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAX$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(MAX$4); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetMax() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MAX$4) != null);
    } 
  }
  
  public void setMax(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAX$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAX$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMax(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAX$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MAX$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetMax() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MAX$4);
    } 
  }
  
  public boolean getMan() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAN$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MAN$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMan() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MAN$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MAN$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMan() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MAN$6) != null);
    } 
  }
  
  public void setMan(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAN$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAN$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMan(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MAN$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MAN$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMan() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MAN$6);
    } 
  }
  
  public boolean getPt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PT$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PT$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PT$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PT$8) != null);
    } 
  }
  
  public void setPt(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PT$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPt(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PT$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PT$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PT$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTBreakImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */