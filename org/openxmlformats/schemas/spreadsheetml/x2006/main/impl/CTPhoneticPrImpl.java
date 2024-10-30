package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPhoneticAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPhoneticType;

public class CTPhoneticPrImpl extends XmlComplexContentImpl implements CTPhoneticPr {
  private static final b FONTID$0 = new b("", "fontId");
  
  private static final b TYPE$2 = new b("", "type");
  
  private static final b ALIGNMENT$4 = new b("", "alignment");
  
  public CTPhoneticPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getFontId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONTID$0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STFontId xgetFontId() {
    synchronized (monitor()) {
      check_orphaned();
      STFontId sTFontId = null;
      sTFontId = (STFontId)get_store().find_attribute_user(FONTID$0);
      return sTFontId;
    } 
  }
  
  public void setFontId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONTID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FONTID$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFontId(STFontId paramSTFontId) {
    synchronized (monitor()) {
      check_orphaned();
      STFontId sTFontId = null;
      sTFontId = (STFontId)get_store().find_attribute_user(FONTID$0);
      if (sTFontId == null)
        sTFontId = (STFontId)get_store().add_attribute_user(FONTID$0); 
      sTFontId.set((XmlObject)paramSTFontId);
    } 
  }
  
  public STPhoneticType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TYPE$2); 
      if (simpleValue == null)
        return null; 
      return (STPhoneticType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPhoneticType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STPhoneticType sTPhoneticType = null;
      sTPhoneticType = (STPhoneticType)get_store().find_attribute_user(TYPE$2);
      if (sTPhoneticType == null)
        sTPhoneticType = (STPhoneticType)get_default_attribute_value(TYPE$2); 
      return sTPhoneticType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$2) != null);
    } 
  }
  
  public void setType(STPhoneticType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STPhoneticType paramSTPhoneticType) {
    synchronized (monitor()) {
      check_orphaned();
      STPhoneticType sTPhoneticType = null;
      sTPhoneticType = (STPhoneticType)get_store().find_attribute_user(TYPE$2);
      if (sTPhoneticType == null)
        sTPhoneticType = (STPhoneticType)get_store().add_attribute_user(TYPE$2); 
      sTPhoneticType.set((XmlObject)paramSTPhoneticType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$2);
    } 
  }
  
  public STPhoneticAlignment.Enum getAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNMENT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ALIGNMENT$4); 
      if (simpleValue == null)
        return null; 
      return (STPhoneticAlignment.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPhoneticAlignment xgetAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      STPhoneticAlignment sTPhoneticAlignment = null;
      sTPhoneticAlignment = (STPhoneticAlignment)get_store().find_attribute_user(ALIGNMENT$4);
      if (sTPhoneticAlignment == null)
        sTPhoneticAlignment = (STPhoneticAlignment)get_default_attribute_value(ALIGNMENT$4); 
      return sTPhoneticAlignment;
    } 
  }
  
  public boolean isSetAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALIGNMENT$4) != null);
    } 
  }
  
  public void setAlignment(STPhoneticAlignment.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNMENT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALIGNMENT$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAlignment(STPhoneticAlignment paramSTPhoneticAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      STPhoneticAlignment sTPhoneticAlignment = null;
      sTPhoneticAlignment = (STPhoneticAlignment)get_store().find_attribute_user(ALIGNMENT$4);
      if (sTPhoneticAlignment == null)
        sTPhoneticAlignment = (STPhoneticAlignment)get_store().add_attribute_user(ALIGNMENT$4); 
      sTPhoneticAlignment.set((XmlObject)paramSTPhoneticAlignment);
    } 
  }
  
  public void unsetAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALIGNMENT$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPhoneticPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */