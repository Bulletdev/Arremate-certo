package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;

public class CTPrintOptionsImpl extends XmlComplexContentImpl implements CTPrintOptions {
  private static final b HORIZONTALCENTERED$0 = new b("", "horizontalCentered");
  
  private static final b VERTICALCENTERED$2 = new b("", "verticalCentered");
  
  private static final b HEADINGS$4 = new b("", "headings");
  
  private static final b GRIDLINES$6 = new b("", "gridLines");
  
  private static final b GRIDLINESSET$8 = new b("", "gridLinesSet");
  
  public CTPrintOptionsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public boolean getHorizontalCentered() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORIZONTALCENTERED$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HORIZONTALCENTERED$0); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHorizontalCentered() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HORIZONTALCENTERED$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HORIZONTALCENTERED$0); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHorizontalCentered() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HORIZONTALCENTERED$0) != null);
    } 
  }
  
  public void setHorizontalCentered(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORIZONTALCENTERED$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HORIZONTALCENTERED$0); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHorizontalCentered(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HORIZONTALCENTERED$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HORIZONTALCENTERED$0); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHorizontalCentered() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HORIZONTALCENTERED$0);
    } 
  }
  
  public boolean getVerticalCentered() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICALCENTERED$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VERTICALCENTERED$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetVerticalCentered() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VERTICALCENTERED$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(VERTICALCENTERED$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetVerticalCentered() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VERTICALCENTERED$2) != null);
    } 
  }
  
  public void setVerticalCentered(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICALCENTERED$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VERTICALCENTERED$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetVerticalCentered(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VERTICALCENTERED$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(VERTICALCENTERED$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetVerticalCentered() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VERTICALCENTERED$2);
    } 
  }
  
  public boolean getHeadings() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADINGS$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HEADINGS$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHeadings() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HEADINGS$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HEADINGS$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHeadings() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HEADINGS$4) != null);
    } 
  }
  
  public void setHeadings(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADINGS$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HEADINGS$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHeadings(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HEADINGS$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HEADINGS$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHeadings() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HEADINGS$4);
    } 
  }
  
  public boolean getGridLines() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRIDLINES$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(GRIDLINES$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetGridLines() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(GRIDLINES$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(GRIDLINES$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetGridLines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GRIDLINES$6) != null);
    } 
  }
  
  public void setGridLines(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRIDLINES$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GRIDLINES$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetGridLines(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(GRIDLINES$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(GRIDLINES$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetGridLines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GRIDLINES$6);
    } 
  }
  
  public boolean getGridLinesSet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRIDLINESSET$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(GRIDLINESSET$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetGridLinesSet() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(GRIDLINESSET$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(GRIDLINESSET$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetGridLinesSet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GRIDLINESSET$8) != null);
    } 
  }
  
  public void setGridLinesSet(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRIDLINESSET$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GRIDLINESSET$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetGridLinesSet(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(GRIDLINESSET$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(GRIDLINESSET$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetGridLinesSet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GRIDLINESSET$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPrintOptionsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */