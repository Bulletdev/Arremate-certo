package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideSizeCoordinate;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideSizeType;

public class CTSlideSizeImpl extends XmlComplexContentImpl implements CTSlideSize {
  private static final b CX$0 = new b("", "cx");
  
  private static final b CY$2 = new b("", "cy");
  
  private static final b TYPE$4 = new b("", "type");
  
  public CTSlideSizeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getCx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CX$0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STSlideSizeCoordinate xgetCx() {
    synchronized (monitor()) {
      check_orphaned();
      STSlideSizeCoordinate sTSlideSizeCoordinate = null;
      sTSlideSizeCoordinate = (STSlideSizeCoordinate)get_store().find_attribute_user(CX$0);
      return sTSlideSizeCoordinate;
    } 
  }
  
  public void setCx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CX$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CX$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetCx(STSlideSizeCoordinate paramSTSlideSizeCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STSlideSizeCoordinate sTSlideSizeCoordinate = null;
      sTSlideSizeCoordinate = (STSlideSizeCoordinate)get_store().find_attribute_user(CX$0);
      if (sTSlideSizeCoordinate == null)
        sTSlideSizeCoordinate = (STSlideSizeCoordinate)get_store().add_attribute_user(CX$0); 
      sTSlideSizeCoordinate.set((XmlObject)paramSTSlideSizeCoordinate);
    } 
  }
  
  public int getCy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CY$2);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STSlideSizeCoordinate xgetCy() {
    synchronized (monitor()) {
      check_orphaned();
      STSlideSizeCoordinate sTSlideSizeCoordinate = null;
      sTSlideSizeCoordinate = (STSlideSizeCoordinate)get_store().find_attribute_user(CY$2);
      return sTSlideSizeCoordinate;
    } 
  }
  
  public void setCy(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CY$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CY$2); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetCy(STSlideSizeCoordinate paramSTSlideSizeCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STSlideSizeCoordinate sTSlideSizeCoordinate = null;
      sTSlideSizeCoordinate = (STSlideSizeCoordinate)get_store().find_attribute_user(CY$2);
      if (sTSlideSizeCoordinate == null)
        sTSlideSizeCoordinate = (STSlideSizeCoordinate)get_store().add_attribute_user(CY$2); 
      sTSlideSizeCoordinate.set((XmlObject)paramSTSlideSizeCoordinate);
    } 
  }
  
  public STSlideSizeType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TYPE$4); 
      if (simpleValue == null)
        return null; 
      return (STSlideSizeType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STSlideSizeType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STSlideSizeType sTSlideSizeType = null;
      sTSlideSizeType = (STSlideSizeType)get_store().find_attribute_user(TYPE$4);
      if (sTSlideSizeType == null)
        sTSlideSizeType = (STSlideSizeType)get_default_attribute_value(TYPE$4); 
      return sTSlideSizeType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$4) != null);
    } 
  }
  
  public void setType(STSlideSizeType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STSlideSizeType paramSTSlideSizeType) {
    synchronized (monitor()) {
      check_orphaned();
      STSlideSizeType sTSlideSizeType = null;
      sTSlideSizeType = (STSlideSizeType)get_store().find_attribute_user(TYPE$4);
      if (sTSlideSizeType == null)
        sTSlideSizeType = (STSlideSizeType)get_store().add_attribute_user(TYPE$4); 
      sTSlideSizeType.set((XmlObject)paramSTSlideSizeType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTSlideSizeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */