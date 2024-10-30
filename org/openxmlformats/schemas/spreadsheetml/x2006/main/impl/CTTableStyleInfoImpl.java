package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTTableStyleInfoImpl extends XmlComplexContentImpl implements CTTableStyleInfo {
  private static final b NAME$0 = new b("", "name");
  
  private static final b SHOWFIRSTCOLUMN$2 = new b("", "showFirstColumn");
  
  private static final b SHOWLASTCOLUMN$4 = new b("", "showLastColumn");
  
  private static final b SHOWROWSTRIPES$6 = new b("", "showRowStripes");
  
  private static final b SHOWCOLUMNSTRIPES$8 = new b("", "showColumnStripes");
  
  public CTTableStyleInfoImpl(SchemaType paramSchemaType) {
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
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$0);
      return sTXstring;
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
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$0);
    } 
  }
  
  public boolean getShowFirstColumn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWFIRSTCOLUMN$2);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowFirstColumn() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWFIRSTCOLUMN$2);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowFirstColumn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWFIRSTCOLUMN$2) != null);
    } 
  }
  
  public void setShowFirstColumn(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWFIRSTCOLUMN$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWFIRSTCOLUMN$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowFirstColumn(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWFIRSTCOLUMN$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWFIRSTCOLUMN$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowFirstColumn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWFIRSTCOLUMN$2);
    } 
  }
  
  public boolean getShowLastColumn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWLASTCOLUMN$4);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowLastColumn() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWLASTCOLUMN$4);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowLastColumn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWLASTCOLUMN$4) != null);
    } 
  }
  
  public void setShowLastColumn(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWLASTCOLUMN$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWLASTCOLUMN$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowLastColumn(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWLASTCOLUMN$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWLASTCOLUMN$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowLastColumn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWLASTCOLUMN$4);
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
  
  public boolean getShowColumnStripes() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWCOLUMNSTRIPES$8);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowColumnStripes() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWCOLUMNSTRIPES$8);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowColumnStripes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWCOLUMNSTRIPES$8) != null);
    } 
  }
  
  public void setShowColumnStripes(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWCOLUMNSTRIPES$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWCOLUMNSTRIPES$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowColumnStripes(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWCOLUMNSTRIPES$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWCOLUMNSTRIPES$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowColumnStripes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWCOLUMNSTRIPES$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTTableStyleInfoImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */