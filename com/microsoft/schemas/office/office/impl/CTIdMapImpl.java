package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.CTIdMap;
import com.microsoft.schemas.vml.STExt;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTIdMapImpl extends XmlComplexContentImpl implements CTIdMap {
  private static final b EXT$0 = new b("urn:schemas-microsoft-com:vml", "ext");
  
  private static final b DATA$2 = new b("", "data");
  
  public CTIdMapImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STExt.Enum getExt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXT$0);
      if (simpleValue == null)
        return null; 
      return (STExt.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STExt xgetExt() {
    synchronized (monitor()) {
      check_orphaned();
      STExt sTExt = null;
      sTExt = (STExt)get_store().find_attribute_user(EXT$0);
      return sTExt;
    } 
  }
  
  public boolean isSetExt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EXT$0) != null);
    } 
  }
  
  public void setExt(STExt.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EXT$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetExt(STExt paramSTExt) {
    synchronized (monitor()) {
      check_orphaned();
      STExt sTExt = null;
      sTExt = (STExt)get_store().find_attribute_user(EXT$0);
      if (sTExt == null)
        sTExt = (STExt)get_store().add_attribute_user(EXT$0); 
      sTExt.set((XmlObject)paramSTExt);
    } 
  }
  
  public void unsetExt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EXT$0);
    } 
  }
  
  public String getData() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATA$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetData() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(DATA$2);
      return xmlString;
    } 
  }
  
  public boolean isSetData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATA$2) != null);
    } 
  }
  
  public void setData(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATA$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATA$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetData(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(DATA$2);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(DATA$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATA$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\office\impl\CTIdMapImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */