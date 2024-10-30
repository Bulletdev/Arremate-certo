package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetCalcPr;

public class CTSheetCalcPrImpl extends XmlComplexContentImpl implements CTSheetCalcPr {
  private static final b FULLCALCONLOAD$0 = new b("", "fullCalcOnLoad");
  
  public CTSheetCalcPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public boolean getFullCalcOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FULLCALCONLOAD$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FULLCALCONLOAD$0); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFullCalcOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FULLCALCONLOAD$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FULLCALCONLOAD$0); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFullCalcOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FULLCALCONLOAD$0) != null);
    } 
  }
  
  public void setFullCalcOnLoad(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FULLCALCONLOAD$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FULLCALCONLOAD$0); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFullCalcOnLoad(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FULLCALCONLOAD$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FULLCALCONLOAD$0); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFullCalcOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FULLCALCONLOAD$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetCalcPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */