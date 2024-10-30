package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLang;

public class CTLanguageImpl extends XmlComplexContentImpl implements CTLanguage {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b EASTASIA$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsia");
  
  private static final b BIDI$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidi");
  
  public CTLanguageImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public Object getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STLang xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STLang sTLang = null;
      sTLang = (STLang)get_store().find_attribute_user(VAL$0);
      return sTLang;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetVal(STLang paramSTLang) {
    synchronized (monitor()) {
      check_orphaned();
      STLang sTLang = null;
      sTLang = (STLang)get_store().find_attribute_user(VAL$0);
      if (sTLang == null)
        sTLang = (STLang)get_store().add_attribute_user(VAL$0); 
      sTLang.set((XmlObject)paramSTLang);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
  
  public Object getEastAsia() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EASTASIA$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STLang xgetEastAsia() {
    synchronized (monitor()) {
      check_orphaned();
      STLang sTLang = null;
      sTLang = (STLang)get_store().find_attribute_user(EASTASIA$2);
      return sTLang;
    } 
  }
  
  public boolean isSetEastAsia() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EASTASIA$2) != null);
    } 
  }
  
  public void setEastAsia(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EASTASIA$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EASTASIA$2); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetEastAsia(STLang paramSTLang) {
    synchronized (monitor()) {
      check_orphaned();
      STLang sTLang = null;
      sTLang = (STLang)get_store().find_attribute_user(EASTASIA$2);
      if (sTLang == null)
        sTLang = (STLang)get_store().add_attribute_user(EASTASIA$2); 
      sTLang.set((XmlObject)paramSTLang);
    } 
  }
  
  public void unsetEastAsia() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EASTASIA$2);
    } 
  }
  
  public Object getBidi() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BIDI$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STLang xgetBidi() {
    synchronized (monitor()) {
      check_orphaned();
      STLang sTLang = null;
      sTLang = (STLang)get_store().find_attribute_user(BIDI$4);
      return sTLang;
    } 
  }
  
  public boolean isSetBidi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BIDI$4) != null);
    } 
  }
  
  public void setBidi(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BIDI$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BIDI$4); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetBidi(STLang paramSTLang) {
    synchronized (monitor()) {
      check_orphaned();
      STLang sTLang = null;
      sTLang = (STLang)get_store().find_attribute_user(BIDI$4);
      if (sTLang == null)
        sTLang = (STLang)get_store().add_attribute_user(BIDI$4); 
      sTLang.set((XmlObject)paramSTLang);
    } 
  }
  
  public void unsetBidi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BIDI$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTLanguageImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */