package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType;

public class CTBrImpl extends XmlComplexContentImpl implements CTBr {
  private static final b TYPE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
  
  private static final b CLEAR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "clear");
  
  public CTBrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STBrType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        return null; 
      return (STBrType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBrType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STBrType sTBrType = null;
      sTBrType = (STBrType)get_store().find_attribute_user(TYPE$0);
      return sTBrType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$0) != null);
    } 
  }
  
  public void setType(STBrType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STBrType paramSTBrType) {
    synchronized (monitor()) {
      check_orphaned();
      STBrType sTBrType = null;
      sTBrType = (STBrType)get_store().find_attribute_user(TYPE$0);
      if (sTBrType == null)
        sTBrType = (STBrType)get_store().add_attribute_user(TYPE$0); 
      sTBrType.set((XmlObject)paramSTBrType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$0);
    } 
  }
  
  public STBrClear.Enum getClear() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLEAR$2);
      if (simpleValue == null)
        return null; 
      return (STBrClear.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBrClear xgetClear() {
    synchronized (monitor()) {
      check_orphaned();
      STBrClear sTBrClear = null;
      sTBrClear = (STBrClear)get_store().find_attribute_user(CLEAR$2);
      return sTBrClear;
    } 
  }
  
  public boolean isSetClear() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CLEAR$2) != null);
    } 
  }
  
  public void setClear(STBrClear.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLEAR$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CLEAR$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetClear(STBrClear paramSTBrClear) {
    synchronized (monitor()) {
      check_orphaned();
      STBrClear sTBrClear = null;
      sTBrClear = (STBrClear)get_store().find_attribute_user(CLEAR$2);
      if (sTBrClear == null)
        sTBrClear = (STBrClear)get_store().add_attribute_user(CLEAR$2); 
      sTBrClear.set((XmlObject)paramSTBrClear);
    } 
  }
  
  public void unsetClear() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CLEAR$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTBrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */