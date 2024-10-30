package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr;

public class CTPageSetUpPrImpl extends XmlComplexContentImpl implements CTPageSetUpPr {
  private static final b AUTOPAGEBREAKS$0 = new b("", "autoPageBreaks");
  
  private static final b FITTOPAGE$2 = new b("", "fitToPage");
  
  public CTPageSetUpPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public boolean getAutoPageBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOPAGEBREAKS$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(AUTOPAGEBREAKS$0); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAutoPageBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOPAGEBREAKS$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(AUTOPAGEBREAKS$0); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAutoPageBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AUTOPAGEBREAKS$0) != null);
    } 
  }
  
  public void setAutoPageBreaks(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOPAGEBREAKS$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTOPAGEBREAKS$0); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAutoPageBreaks(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOPAGEBREAKS$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AUTOPAGEBREAKS$0); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAutoPageBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AUTOPAGEBREAKS$0);
    } 
  }
  
  public boolean getFitToPage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITTOPAGE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FITTOPAGE$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFitToPage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FITTOPAGE$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FITTOPAGE$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFitToPage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FITTOPAGE$2) != null);
    } 
  }
  
  public void setFitToPage(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FITTOPAGE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FITTOPAGE$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFitToPage(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FITTOPAGE$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FITTOPAGE$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFitToPage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FITTOPAGE$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPageSetUpPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */