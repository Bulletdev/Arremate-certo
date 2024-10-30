package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData;

public class CTAnchorClientDataImpl extends XmlComplexContentImpl implements CTAnchorClientData {
  private static final b FLOCKSWITHSHEET$0 = new b("", "fLocksWithSheet");
  
  private static final b FPRINTSWITHSHEET$2 = new b("", "fPrintsWithSheet");
  
  public CTAnchorClientDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public boolean getFLocksWithSheet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLOCKSWITHSHEET$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FLOCKSWITHSHEET$0); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFLocksWithSheet() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FLOCKSWITHSHEET$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FLOCKSWITHSHEET$0); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFLocksWithSheet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FLOCKSWITHSHEET$0) != null);
    } 
  }
  
  public void setFLocksWithSheet(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLOCKSWITHSHEET$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FLOCKSWITHSHEET$0); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFLocksWithSheet(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FLOCKSWITHSHEET$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FLOCKSWITHSHEET$0); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFLocksWithSheet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FLOCKSWITHSHEET$0);
    } 
  }
  
  public boolean getFPrintsWithSheet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FPRINTSWITHSHEET$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FPRINTSWITHSHEET$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFPrintsWithSheet() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FPRINTSWITHSHEET$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FPRINTSWITHSHEET$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFPrintsWithSheet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FPRINTSWITHSHEET$2) != null);
    } 
  }
  
  public void setFPrintsWithSheet(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FPRINTSWITHSHEET$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FPRINTSWITHSHEET$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFPrintsWithSheet(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FPRINTSWITHSHEET$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FPRINTSWITHSHEET$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFPrintsWithSheet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FPRINTSWITHSHEET$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTAnchorClientDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */