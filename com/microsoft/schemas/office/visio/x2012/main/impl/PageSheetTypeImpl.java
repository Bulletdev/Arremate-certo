package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PageSheetType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

public class PageSheetTypeImpl extends SheetTypeImpl implements PageSheetType {
  private static final b UNIQUEID$0 = new b("", "UniqueID");
  
  public PageSheetTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUEID$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(UNIQUEID$0);
      return xmlString;
    } 
  }
  
  public boolean isSetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNIQUEID$0) != null);
    } 
  }
  
  public void setUniqueID(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUEID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNIQUEID$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetUniqueID(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(UNIQUEID$0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(UNIQUEID$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNIQUEID$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\PageSheetTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */