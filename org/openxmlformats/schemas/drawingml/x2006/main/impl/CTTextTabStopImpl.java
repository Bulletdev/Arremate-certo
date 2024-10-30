package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextTabAlignType;

public class CTTextTabStopImpl extends XmlComplexContentImpl implements CTTextTabStop {
  private static final b POS$0 = new b("", "pos");
  
  private static final b ALGN$2 = new b("", "algn");
  
  public CTTextTabStopImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getPos() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POS$0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetPos() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(POS$0);
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetPos() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(POS$0) != null);
    } 
  }
  
  public void setPos(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POS$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(POS$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetPos(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(POS$0);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(POS$0); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetPos() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(POS$0);
    } 
  }
  
  public STTextTabAlignType.Enum getAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGN$2);
      if (simpleValue == null)
        return null; 
      return (STTextTabAlignType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextTabAlignType xgetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      STTextTabAlignType sTTextTabAlignType = null;
      sTTextTabAlignType = (STTextTabAlignType)get_store().find_attribute_user(ALGN$2);
      return sTTextTabAlignType;
    } 
  }
  
  public boolean isSetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALGN$2) != null);
    } 
  }
  
  public void setAlgn(STTextTabAlignType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGN$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALGN$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAlgn(STTextTabAlignType paramSTTextTabAlignType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextTabAlignType sTTextTabAlignType = null;
      sTTextTabAlignType = (STTextTabAlignType)get_store().find_attribute_user(ALGN$2);
      if (sTTextTabAlignType == null)
        sTTextTabAlignType = (STTextTabAlignType)get_store().add_attribute_user(ALGN$2); 
      sTTextTabAlignType.set((XmlObject)paramSTTextTabAlignType);
    } 
  }
  
  public void unsetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALGN$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextTabStopImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */