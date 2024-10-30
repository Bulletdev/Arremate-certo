package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;

public class StyleSheetTypeImpl extends SheetTypeImpl implements StyleSheetType {
  private static final b ID$0 = new b("", "ID");
  
  private static final b NAME$2 = new b("", "Name");
  
  private static final b NAMEU$4 = new b("", "NameU");
  
  private static final b ISCUSTOMNAME$6 = new b("", "IsCustomName");
  
  private static final b ISCUSTOMNAMEU$8 = new b("", "IsCustomNameU");
  
  public StyleSheetTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$0);
      return xmlUnsignedInt;
    } 
  }
  
  public void setID(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetID(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$0); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$2);
      return xmlString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$2) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$2);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$2);
    } 
  }
  
  public String getNameU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMEU$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMEU$4);
      return xmlString;
    } 
  }
  
  public boolean isSetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAMEU$4) != null);
    } 
  }
  
  public void setNameU(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMEU$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAMEU$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetNameU(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMEU$4);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAMEU$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAMEU$4);
    } 
  }
  
  public boolean getIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAME$6);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAME$6);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISCUSTOMNAME$6) != null);
    } 
  }
  
  public void setIsCustomName(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAME$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISCUSTOMNAME$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsCustomName(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAME$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISCUSTOMNAME$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISCUSTOMNAME$6);
    } 
  }
  
  public boolean getIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAMEU$8);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAMEU$8);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISCUSTOMNAMEU$8) != null);
    } 
  }
  
  public void setIsCustomNameU(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAMEU$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISCUSTOMNAMEU$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsCustomNameU(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAMEU$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISCUSTOMNAMEU$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISCUSTOMNAMEU$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\StyleSheetTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */