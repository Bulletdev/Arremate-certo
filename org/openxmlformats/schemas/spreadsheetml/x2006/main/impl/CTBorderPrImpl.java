package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;

public class CTBorderPrImpl extends XmlComplexContentImpl implements CTBorderPr {
  private static final b COLOR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "color");
  
  private static final b STYLE$2 = new b("", "style");
  
  public CTBorderPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTColor getColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$0, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public boolean isSetColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLOR$0) != 0);
    } 
  }
  
  public void setColor(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$0, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(COLOR$0); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(COLOR$0);
      return cTColor;
    } 
  }
  
  public void unsetColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLOR$0, 0);
    } 
  }
  
  public STBorderStyle.Enum getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STYLE$2); 
      if (simpleValue == null)
        return null; 
      return (STBorderStyle.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBorderStyle xgetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STBorderStyle sTBorderStyle = null;
      sTBorderStyle = (STBorderStyle)get_store().find_attribute_user(STYLE$2);
      if (sTBorderStyle == null)
        sTBorderStyle = (STBorderStyle)get_default_attribute_value(STYLE$2); 
      return sTBorderStyle;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STYLE$2) != null);
    } 
  }
  
  public void setStyle(STBorderStyle.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLE$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetStyle(STBorderStyle paramSTBorderStyle) {
    synchronized (monitor()) {
      check_orphaned();
      STBorderStyle sTBorderStyle = null;
      sTBorderStyle = (STBorderStyle)get_store().find_attribute_user(STYLE$2);
      if (sTBorderStyle == null)
        sTBorderStyle = (STBorderStyle)get_store().add_attribute_user(STYLE$2); 
      sTBorderStyle.set((XmlObject)paramSTBorderStyle);
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STYLE$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTBorderPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */