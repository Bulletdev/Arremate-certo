package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual;

public class CTConnectorImpl extends XmlComplexContentImpl implements CTConnector {
  private static final b NVCXNSPPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvCxnSpPr");
  
  private static final b SPPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "spPr");
  
  private static final b STYLE$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "style");
  
  private static final b MACRO$6 = new b("", "macro");
  
  private static final b FPUBLISHED$8 = new b("", "fPublished");
  
  public CTConnectorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTConnectorNonVisual getNvCxnSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectorNonVisual cTConnectorNonVisual = null;
      cTConnectorNonVisual = (CTConnectorNonVisual)get_store().find_element_user(NVCXNSPPR$0, 0);
      if (cTConnectorNonVisual == null)
        return null; 
      return cTConnectorNonVisual;
    } 
  }
  
  public void setNvCxnSpPr(CTConnectorNonVisual paramCTConnectorNonVisual) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectorNonVisual cTConnectorNonVisual = null;
      cTConnectorNonVisual = (CTConnectorNonVisual)get_store().find_element_user(NVCXNSPPR$0, 0);
      if (cTConnectorNonVisual == null)
        cTConnectorNonVisual = (CTConnectorNonVisual)get_store().add_element_user(NVCXNSPPR$0); 
      cTConnectorNonVisual.set((XmlObject)paramCTConnectorNonVisual);
    } 
  }
  
  public CTConnectorNonVisual addNewNvCxnSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectorNonVisual cTConnectorNonVisual = null;
      cTConnectorNonVisual = (CTConnectorNonVisual)get_store().add_element_user(NVCXNSPPR$0);
      return cTConnectorNonVisual;
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$2, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$2, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$2); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$2);
      return cTShapeProperties;
    } 
  }
  
  public CTShapeStyle getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeStyle cTShapeStyle = null;
      cTShapeStyle = (CTShapeStyle)get_store().find_element_user(STYLE$4, 0);
      if (cTShapeStyle == null)
        return null; 
      return cTShapeStyle;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLE$4) != 0);
    } 
  }
  
  public void setStyle(CTShapeStyle paramCTShapeStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeStyle cTShapeStyle = null;
      cTShapeStyle = (CTShapeStyle)get_store().find_element_user(STYLE$4, 0);
      if (cTShapeStyle == null)
        cTShapeStyle = (CTShapeStyle)get_store().add_element_user(STYLE$4); 
      cTShapeStyle.set((XmlObject)paramCTShapeStyle);
    } 
  }
  
  public CTShapeStyle addNewStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeStyle cTShapeStyle = null;
      cTShapeStyle = (CTShapeStyle)get_store().add_element_user(STYLE$4);
      return cTShapeStyle;
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLE$4, 0);
    } 
  }
  
  public String getMacro() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MACRO$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetMacro() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MACRO$6);
      return xmlString;
    } 
  }
  
  public boolean isSetMacro() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MACRO$6) != null);
    } 
  }
  
  public void setMacro(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MACRO$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MACRO$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetMacro(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MACRO$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(MACRO$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetMacro() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MACRO$6);
    } 
  }
  
  public boolean getFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FPUBLISHED$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FPUBLISHED$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FPUBLISHED$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FPUBLISHED$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FPUBLISHED$8) != null);
    } 
  }
  
  public void setFPublished(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FPUBLISHED$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FPUBLISHED$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFPublished(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FPUBLISHED$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FPUBLISHED$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FPUBLISHED$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTConnectorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */