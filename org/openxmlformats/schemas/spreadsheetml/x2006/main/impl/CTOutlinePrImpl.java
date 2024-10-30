package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;

public class CTOutlinePrImpl extends XmlComplexContentImpl implements CTOutlinePr {
  private static final b APPLYSTYLES$0 = new b("", "applyStyles");
  
  private static final b SUMMARYBELOW$2 = new b("", "summaryBelow");
  
  private static final b SUMMARYRIGHT$4 = new b("", "summaryRight");
  
  private static final b SHOWOUTLINESYMBOLS$6 = new b("", "showOutlineSymbols");
  
  public CTOutlinePrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public boolean getApplyStyles() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYSTYLES$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(APPLYSTYLES$0); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyStyles() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYSTYLES$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(APPLYSTYLES$0); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyStyles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYSTYLES$0) != null);
    } 
  }
  
  public void setApplyStyles(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYSTYLES$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYSTYLES$0); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyStyles(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYSTYLES$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYSTYLES$0); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyStyles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYSTYLES$0);
    } 
  }
  
  public boolean getSummaryBelow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUMMARYBELOW$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SUMMARYBELOW$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSummaryBelow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUMMARYBELOW$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SUMMARYBELOW$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSummaryBelow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUMMARYBELOW$2) != null);
    } 
  }
  
  public void setSummaryBelow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUMMARYBELOW$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUMMARYBELOW$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSummaryBelow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUMMARYBELOW$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SUMMARYBELOW$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSummaryBelow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUMMARYBELOW$2);
    } 
  }
  
  public boolean getSummaryRight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUMMARYRIGHT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SUMMARYRIGHT$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSummaryRight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUMMARYRIGHT$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SUMMARYRIGHT$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSummaryRight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUMMARYRIGHT$4) != null);
    } 
  }
  
  public void setSummaryRight(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUMMARYRIGHT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUMMARYRIGHT$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSummaryRight(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUMMARYRIGHT$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SUMMARYRIGHT$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSummaryRight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUMMARYRIGHT$4);
    } 
  }
  
  public boolean getShowOutlineSymbols() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWOUTLINESYMBOLS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWOUTLINESYMBOLS$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowOutlineSymbols() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWOUTLINESYMBOLS$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWOUTLINESYMBOLS$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowOutlineSymbols() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWOUTLINESYMBOLS$6) != null);
    } 
  }
  
  public void setShowOutlineSymbols(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWOUTLINESYMBOLS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWOUTLINESYMBOLS$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowOutlineSymbols(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWOUTLINESYMBOLS$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWOUTLINESYMBOLS$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowOutlineSymbols() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWOUTLINESYMBOLS$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTOutlinePrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */