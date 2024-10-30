package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;

public class CTPathShadePropertiesImpl extends XmlComplexContentImpl implements CTPathShadeProperties {
  private static final b FILLTORECT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fillToRect");
  
  private static final b PATH$2 = new b("", "path");
  
  public CTPathShadePropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRelativeRect getFillToRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().find_element_user(FILLTORECT$0, 0);
      if (cTRelativeRect == null)
        return null; 
      return cTRelativeRect;
    } 
  }
  
  public boolean isSetFillToRect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILLTORECT$0) != 0);
    } 
  }
  
  public void setFillToRect(CTRelativeRect paramCTRelativeRect) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().find_element_user(FILLTORECT$0, 0);
      if (cTRelativeRect == null)
        cTRelativeRect = (CTRelativeRect)get_store().add_element_user(FILLTORECT$0); 
      cTRelativeRect.set((XmlObject)paramCTRelativeRect);
    } 
  }
  
  public CTRelativeRect addNewFillToRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelativeRect cTRelativeRect = null;
      cTRelativeRect = (CTRelativeRect)get_store().add_element_user(FILLTORECT$0);
      return cTRelativeRect;
    } 
  }
  
  public void unsetFillToRect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILLTORECT$0, 0);
    } 
  }
  
  public STPathShadeType.Enum getPath() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PATH$2);
      if (simpleValue == null)
        return null; 
      return (STPathShadeType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPathShadeType xgetPath() {
    synchronized (monitor()) {
      check_orphaned();
      STPathShadeType sTPathShadeType = null;
      sTPathShadeType = (STPathShadeType)get_store().find_attribute_user(PATH$2);
      return sTPathShadeType;
    } 
  }
  
  public boolean isSetPath() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PATH$2) != null);
    } 
  }
  
  public void setPath(STPathShadeType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PATH$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PATH$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPath(STPathShadeType paramSTPathShadeType) {
    synchronized (monitor()) {
      check_orphaned();
      STPathShadeType sTPathShadeType = null;
      sTPathShadeType = (STPathShadeType)get_store().find_attribute_user(PATH$2);
      if (sTPathShadeType == null)
        sTPathShadeType = (STPathShadeType)get_store().add_attribute_user(PATH$2); 
      sTPathShadeType.set((XmlObject)paramSTPathShadeType);
    } 
  }
  
  public void unsetPath() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PATH$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPathShadePropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */