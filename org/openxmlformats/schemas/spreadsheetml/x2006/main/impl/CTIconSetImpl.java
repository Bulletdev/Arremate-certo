package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

public class CTIconSetImpl extends XmlComplexContentImpl implements CTIconSet {
  private static final b CFVO$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cfvo");
  
  private static final b ICONSET$2 = new b("", "iconSet");
  
  private static final b SHOWVALUE$4 = new b("", "showValue");
  
  private static final b PERCENT$6 = new b("", "percent");
  
  private static final b REVERSE$8 = new b("", "reverse");
  
  public CTIconSetImpl(SchemaType paramSchemaType) {
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
  
  public STIconSetType.Enum getIconSet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ICONSET$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ICONSET$2); 
      if (simpleValue == null)
        return null; 
      return (STIconSetType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STIconSetType xgetIconSet() {
    synchronized (monitor()) {
      check_orphaned();
      STIconSetType sTIconSetType = null;
      sTIconSetType = (STIconSetType)get_store().find_attribute_user(ICONSET$2);
      if (sTIconSetType == null)
        sTIconSetType = (STIconSetType)get_default_attribute_value(ICONSET$2); 
      return sTIconSetType;
    } 
  }
  
  public boolean isSetIconSet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ICONSET$2) != null);
    } 
  }
  
  public void setIconSet(STIconSetType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ICONSET$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ICONSET$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetIconSet(STIconSetType paramSTIconSetType) {
    synchronized (monitor()) {
      check_orphaned();
      STIconSetType sTIconSetType = null;
      sTIconSetType = (STIconSetType)get_store().find_attribute_user(ICONSET$2);
      if (sTIconSetType == null)
        sTIconSetType = (STIconSetType)get_store().add_attribute_user(ICONSET$2); 
      sTIconSetType.set((XmlObject)paramSTIconSetType);
    } 
  }
  
  public void unsetIconSet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ICONSET$2);
    } 
  }
  
  public boolean getShowValue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWVALUE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWVALUE$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowValue() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWVALUE$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWVALUE$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowValue() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWVALUE$4) != null);
    } 
  }
  
  public void setShowValue(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWVALUE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWVALUE$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowValue(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWVALUE$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWVALUE$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowValue() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWVALUE$4);
    } 
  }
  
  public boolean getPercent() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PERCENT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PERCENT$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPercent() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PERCENT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PERCENT$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPercent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PERCENT$6) != null);
    } 
  }
  
  public void setPercent(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PERCENT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PERCENT$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPercent(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PERCENT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PERCENT$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPercent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PERCENT$6);
    } 
  }
  
  public boolean getReverse() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REVERSE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(REVERSE$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetReverse() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(REVERSE$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(REVERSE$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetReverse() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REVERSE$8) != null);
    } 
  }
  
  public void setReverse(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REVERSE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REVERSE$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetReverse(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(REVERSE$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(REVERSE$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetReverse() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REVERSE$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTIconSetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */