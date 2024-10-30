package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;

public class CTLineEndPropertiesImpl extends XmlComplexContentImpl implements CTLineEndProperties {
  private static final b TYPE$0 = new b("", "type");
  
  private static final b W$2 = new b("", "w");
  
  private static final b LEN$4 = new b("", "len");
  
  public CTLineEndPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STLineEndType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        return null; 
      return (STLineEndType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STLineEndType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STLineEndType sTLineEndType = null;
      sTLineEndType = (STLineEndType)get_store().find_attribute_user(TYPE$0);
      return sTLineEndType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$0) != null);
    } 
  }
  
  public void setType(STLineEndType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STLineEndType paramSTLineEndType) {
    synchronized (monitor()) {
      check_orphaned();
      STLineEndType sTLineEndType = null;
      sTLineEndType = (STLineEndType)get_store().find_attribute_user(TYPE$0);
      if (sTLineEndType == null)
        sTLineEndType = (STLineEndType)get_store().add_attribute_user(TYPE$0); 
      sTLineEndType.set((XmlObject)paramSTLineEndType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$0);
    } 
  }
  
  public STLineEndWidth.Enum getW() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$2);
      if (simpleValue == null)
        return null; 
      return (STLineEndWidth.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STLineEndWidth xgetW() {
    synchronized (monitor()) {
      check_orphaned();
      STLineEndWidth sTLineEndWidth = null;
      sTLineEndWidth = (STLineEndWidth)get_store().find_attribute_user(W$2);
      return sTLineEndWidth;
    } 
  }
  
  public boolean isSetW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(W$2) != null);
    } 
  }
  
  public void setW(STLineEndWidth.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(W$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetW(STLineEndWidth paramSTLineEndWidth) {
    synchronized (monitor()) {
      check_orphaned();
      STLineEndWidth sTLineEndWidth = null;
      sTLineEndWidth = (STLineEndWidth)get_store().find_attribute_user(W$2);
      if (sTLineEndWidth == null)
        sTLineEndWidth = (STLineEndWidth)get_store().add_attribute_user(W$2); 
      sTLineEndWidth.set((XmlObject)paramSTLineEndWidth);
    } 
  }
  
  public void unsetW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(W$2);
    } 
  }
  
  public STLineEndLength.Enum getLen() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEN$4);
      if (simpleValue == null)
        return null; 
      return (STLineEndLength.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STLineEndLength xgetLen() {
    synchronized (monitor()) {
      check_orphaned();
      STLineEndLength sTLineEndLength = null;
      sTLineEndLength = (STLineEndLength)get_store().find_attribute_user(LEN$4);
      return sTLineEndLength;
    } 
  }
  
  public boolean isSetLen() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LEN$4) != null);
    } 
  }
  
  public void setLen(STLineEndLength.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEN$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LEN$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetLen(STLineEndLength paramSTLineEndLength) {
    synchronized (monitor()) {
      check_orphaned();
      STLineEndLength sTLineEndLength = null;
      sTLineEndLength = (STLineEndLength)get_store().find_attribute_user(LEN$4);
      if (sTLineEndLength == null)
        sTLineEndLength = (STLineEndLength)get_store().add_attribute_user(LEN$4); 
      sTLineEndLength.set((XmlObject)paramSTLineEndLength);
    } 
  }
  
  public void unsetLen() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LEN$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTLineEndPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */