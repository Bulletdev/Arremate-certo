package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;

public class CTDataBarImpl extends XmlComplexContentImpl implements CTDataBar {
  private static final b CFVO$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cfvo");
  
  private static final b COLOR$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "color");
  
  private static final b MINLENGTH$4 = new b("", "minLength");
  
  private static final b MAXLENGTH$6 = new b("", "maxLength");
  
  private static final b SHOWVALUE$8 = new b("", "showValue");
  
  public CTDataBarImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCfvo> getCfvoList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCfvo>)new CfvoList(this);
    } 
  }
  
  public CTCfvo[] getCfvoArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CFVO$0, arrayList);
      CTCfvo[] arrayOfCTCfvo = new CTCfvo[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCfvo);
      return arrayOfCTCfvo;
    } 
  }
  
  public CTCfvo getCfvoArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfvo cTCfvo = null;
      cTCfvo = (CTCfvo)get_store().find_element_user(CFVO$0, paramInt);
      if (cTCfvo == null)
        throw new IndexOutOfBoundsException(); 
      return cTCfvo;
    } 
  }
  
  public int sizeOfCfvoArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CFVO$0);
    } 
  }
  
  public void setCfvoArray(CTCfvo[] paramArrayOfCTCfvo) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCfvo, CFVO$0);
    } 
  }
  
  public void setCfvoArray(int paramInt, CTCfvo paramCTCfvo) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfvo cTCfvo = null;
      cTCfvo = (CTCfvo)get_store().find_element_user(CFVO$0, paramInt);
      if (cTCfvo == null)
        throw new IndexOutOfBoundsException(); 
      cTCfvo.set((XmlObject)paramCTCfvo);
    } 
  }
  
  public CTCfvo insertNewCfvo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfvo cTCfvo = null;
      cTCfvo = (CTCfvo)get_store().insert_element_user(CFVO$0, paramInt);
      return cTCfvo;
    } 
  }
  
  public CTCfvo addNewCfvo() {
    synchronized (monitor()) {
      check_orphaned();
      CTCfvo cTCfvo = null;
      cTCfvo = (CTCfvo)get_store().add_element_user(CFVO$0);
      return cTCfvo;
    } 
  }
  
  public void removeCfvo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CFVO$0, paramInt);
    } 
  }
  
  public CTColor getColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$2, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public void setColor(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$2, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(COLOR$2); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(COLOR$2);
      return cTColor;
    } 
  }
  
  public long getMinLength() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINLENGTH$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MINLENGTH$4); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMinLength() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MINLENGTH$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(MINLENGTH$4); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetMinLength() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MINLENGTH$4) != null);
    } 
  }
  
  public void setMinLength(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINLENGTH$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MINLENGTH$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMinLength(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MINLENGTH$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MINLENGTH$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetMinLength() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MINLENGTH$4);
    } 
  }
  
  public long getMaxLength() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAXLENGTH$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MAXLENGTH$6); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMaxLength() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAXLENGTH$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(MAXLENGTH$6); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetMaxLength() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MAXLENGTH$6) != null);
    } 
  }
  
  public void setMaxLength(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAXLENGTH$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAXLENGTH$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMaxLength(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAXLENGTH$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MAXLENGTH$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetMaxLength() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MAXLENGTH$6);
    } 
  }
  
  public boolean getShowValue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWVALUE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWVALUE$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowValue() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWVALUE$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWVALUE$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowValue() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWVALUE$8) != null);
    } 
  }
  
  public void setShowValue(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWVALUE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWVALUE$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowValue(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWVALUE$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWVALUE$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowValue() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWVALUE$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDataBarImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */