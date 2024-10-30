package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnsignedIntHex;

public class CTColorImpl extends XmlComplexContentImpl implements CTColor {
  private static final b AUTO$0 = new b("", "auto");
  
  private static final b INDEXED$2 = new b("", "indexed");
  
  private static final b RGB$4 = new b("", "rgb");
  
  private static final b THEME$6 = new b("", "theme");
  
  private static final b TINT$8 = new b("", "tint");
  
  public CTColorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public boolean getAuto() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTO$0);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAuto() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTO$0);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAuto() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AUTO$0) != null);
    } 
  }
  
  public void setAuto(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTO$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTO$0); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAuto(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTO$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AUTO$0); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAuto() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AUTO$0);
    } 
  }
  
  public long getIndexed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INDEXED$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetIndexed() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(INDEXED$2);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetIndexed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INDEXED$2) != null);
    } 
  }
  
  public void setIndexed(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INDEXED$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INDEXED$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIndexed(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(INDEXED$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(INDEXED$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetIndexed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INDEXED$2);
    } 
  }
  
  public byte[] getRgb() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RGB$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUnsignedIntHex xgetRgb() {
    synchronized (monitor()) {
      check_orphaned();
      STUnsignedIntHex sTUnsignedIntHex = null;
      sTUnsignedIntHex = (STUnsignedIntHex)get_store().find_attribute_user(RGB$4);
      return sTUnsignedIntHex;
    } 
  }
  
  public boolean isSetRgb() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RGB$4) != null);
    } 
  }
  
  public void setRgb(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RGB$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RGB$4); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetRgb(STUnsignedIntHex paramSTUnsignedIntHex) {
    synchronized (monitor()) {
      check_orphaned();
      STUnsignedIntHex sTUnsignedIntHex = null;
      sTUnsignedIntHex = (STUnsignedIntHex)get_store().find_attribute_user(RGB$4);
      if (sTUnsignedIntHex == null)
        sTUnsignedIntHex = (STUnsignedIntHex)get_store().add_attribute_user(RGB$4); 
      sTUnsignedIntHex.set((XmlObject)paramSTUnsignedIntHex);
    } 
  }
  
  public void unsetRgb() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RGB$4);
    } 
  }
  
  public long getTheme() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEME$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetTheme() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(THEME$6);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetTheme() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEME$6) != null);
    } 
  }
  
  public void setTheme(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEME$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEME$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTheme(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(THEME$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(THEME$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetTheme() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEME$6);
    } 
  }
  
  public double getTint() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TINT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TINT$8); 
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetTint() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(TINT$8);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_default_attribute_value(TINT$8); 
      return xmlDouble;
    } 
  }
  
  public boolean isSetTint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TINT$8) != null);
    } 
  }
  
  public void setTint(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TINT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TINT$8); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetTint(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(TINT$8);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(TINT$8); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetTint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TINT$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTColorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */