package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

public class CTTextImpl extends JavaStringHolderEx implements CTText {
  private static final b SPACE$0 = new b("http://www.w3.org/XML/1998/namespace", "space");
  
  public CTTextImpl(SchemaType paramSchemaType) {
    super(paramSchemaType, true);
  }
  
  protected CTTextImpl(SchemaType paramSchemaType, boolean paramBoolean) {
    super(paramSchemaType, paramBoolean);
  }
  
  public SpaceAttribute.Space.Enum getSpace() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPACE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SPACE$0); 
      if (simpleValue == null)
        return null; 
      return (SpaceAttribute.Space.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public SpaceAttribute.Space xgetSpace() {
    synchronized (monitor()) {
      check_orphaned();
      SpaceAttribute.Space space = null;
      space = (SpaceAttribute.Space)get_store().find_attribute_user(SPACE$0);
      if (space == null)
        space = (SpaceAttribute.Space)get_default_attribute_value(SPACE$0); 
      return space;
    } 
  }
  
  public boolean isSetSpace() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPACE$0) != null);
    } 
  }
  
  public void setSpace(SpaceAttribute.Space.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPACE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPACE$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSpace(SpaceAttribute.Space paramSpace) {
    synchronized (monitor()) {
      check_orphaned();
      SpaceAttribute.Space space = null;
      space = (SpaceAttribute.Space)get_store().find_attribute_user(SPACE$0);
      if (space == null)
        space = (SpaceAttribute.Space)get_store().add_attribute_user(SPACE$0); 
      space.set((XmlObject)paramSpace);
    } 
  }
  
  public void unsetSpace() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPACE$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTextImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */