package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

public class CTPatternFillImpl extends XmlComplexContentImpl implements CTPatternFill {
  private static final b FGCOLOR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fgColor");
  
  private static final b BGCOLOR$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "bgColor");
  
  private static final b PATTERNTYPE$4 = new b("", "patternType");
  
  public CTPatternFillImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTColor getFgColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(FGCOLOR$0, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public boolean isSetFgColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FGCOLOR$0) != 0);
    } 
  }
  
  public void setFgColor(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(FGCOLOR$0, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(FGCOLOR$0); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewFgColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(FGCOLOR$0);
      return cTColor;
    } 
  }
  
  public void unsetFgColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FGCOLOR$0, 0);
    } 
  }
  
  public CTColor getBgColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(BGCOLOR$2, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public boolean isSetBgColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BGCOLOR$2) != 0);
    } 
  }
  
  public void setBgColor(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(BGCOLOR$2, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(BGCOLOR$2); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewBgColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(BGCOLOR$2);
      return cTColor;
    } 
  }
  
  public void unsetBgColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BGCOLOR$2, 0);
    } 
  }
  
  public STPatternType.Enum getPatternType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PATTERNTYPE$4);
      if (simpleValue == null)
        return null; 
      return (STPatternType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPatternType xgetPatternType() {
    synchronized (monitor()) {
      check_orphaned();
      STPatternType sTPatternType = null;
      sTPatternType = (STPatternType)get_store().find_attribute_user(PATTERNTYPE$4);
      return sTPatternType;
    } 
  }
  
  public boolean isSetPatternType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PATTERNTYPE$4) != null);
    } 
  }
  
  public void setPatternType(STPatternType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PATTERNTYPE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PATTERNTYPE$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPatternType(STPatternType paramSTPatternType) {
    synchronized (monitor()) {
      check_orphaned();
      STPatternType sTPatternType = null;
      sTPatternType = (STPatternType)get_store().find_attribute_user(PATTERNTYPE$4);
      if (sTPatternType == null)
        sTPatternType = (STPatternType)get_store().add_attribute_user(PATTERNTYPE$4); 
      sTPatternType.set((XmlObject)paramSTPatternType);
    } 
  }
  
  public void unsetPatternType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PATTERNTYPE$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPatternFillImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */