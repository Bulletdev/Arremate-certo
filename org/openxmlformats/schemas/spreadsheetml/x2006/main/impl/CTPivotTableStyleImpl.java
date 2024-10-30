package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableStyle;

public class CTPivotTableStyleImpl extends XmlComplexContentImpl implements CTPivotTableStyle {
  private static final b NAME$0 = new b("", "name");
  
  private static final b SHOWROWHEADERS$2 = new b("", "showRowHeaders");
  
  private static final b SHOWCOLHEADERS$4 = new b("", "showColHeaders");
  
  private static final b SHOWROWSTRIPES$6 = new b("", "showRowStripes");
  
  private static final b SHOWCOLSTRIPES$8 = new b("", "showColStripes");
  
  private static final b SHOWLASTCOLUMN$10 = new b("", "showLastColumn");
  
  public CTPivotTableStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$0);
      return xmlString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$0) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$0);
    } 
  }
  
  public boolean getShowRowHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWROWHEADERS$2);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowRowHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWROWHEADERS$2);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowRowHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWROWHEADERS$2) != null);
    } 
  }
  
  public void setShowRowHeaders(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWROWHEADERS$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWROWHEADERS$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowRowHeaders(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWROWHEADERS$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWROWHEADERS$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowRowHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWROWHEADERS$2);
    } 
  }
  
  public boolean getShowColHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWCOLHEADERS$4);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowColHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWCOLHEADERS$4);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowColHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWCOLHEADERS$4) != null);
    } 
  }
  
  public void setShowColHeaders(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWCOLHEADERS$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWCOLHEADERS$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowColHeaders(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWCOLHEADERS$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWCOLHEADERS$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowColHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWCOLHEADERS$4);
    } 
  }
  
  public boolean getShowRowStripes() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWROWSTRIPES$6);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowRowStripes() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWROWSTRIPES$6);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowRowStripes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWROWSTRIPES$6) != null);
    } 
  }
  
  public void setShowRowStripes(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWROWSTRIPES$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWROWSTRIPES$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowRowStripes(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWROWSTRIPES$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWROWSTRIPES$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowRowStripes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWROWSTRIPES$6);
    } 
  }
  
  public boolean getShowColStripes() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWCOLSTRIPES$8);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowColStripes() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWCOLSTRIPES$8);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowColStripes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWCOLSTRIPES$8) != null);
    } 
  }
  
  public void setShowColStripes(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWCOLSTRIPES$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWCOLSTRIPES$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowColStripes(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWCOLSTRIPES$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWCOLSTRIPES$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowColStripes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWCOLSTRIPES$8);
    } 
  }
  
  public boolean getShowLastColumn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWLASTCOLUMN$10);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowLastColumn() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWLASTCOLUMN$10);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowLastColumn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWLASTCOLUMN$10) != null);
    } 
  }
  
  public void setShowLastColumn(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWLASTCOLUMN$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWLASTCOLUMN$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowLastColumn(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWLASTCOLUMN$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWLASTCOLUMN$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowLastColumn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWLASTCOLUMN$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPivotTableStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */