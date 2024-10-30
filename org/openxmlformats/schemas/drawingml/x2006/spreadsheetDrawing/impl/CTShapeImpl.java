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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;

public class CTShapeImpl extends XmlComplexContentImpl implements CTShape {
  private static final b NVSPPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvSpPr");
  
  private static final b SPPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "spPr");
  
  private static final b STYLE$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "style");
  
  private static final b TXBODY$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "txBody");
  
  private static final b MACRO$8 = new b("", "macro");
  
  private static final b TEXTLINK$10 = new b("", "textlink");
  
  private static final b FLOCKSTEXT$12 = new b("", "fLocksText");
  
  private static final b FPUBLISHED$14 = new b("", "fPublished");
  
  public CTShapeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTShapeNonVisual getNvSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeNonVisual cTShapeNonVisual = null;
      cTShapeNonVisual = (CTShapeNonVisual)get_store().find_element_user(NVSPPR$0, 0);
      if (cTShapeNonVisual == null)
        return null; 
      return cTShapeNonVisual;
    } 
  }
  
  public void setNvSpPr(CTShapeNonVisual paramCTShapeNonVisual) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeNonVisual cTShapeNonVisual = null;
      cTShapeNonVisual = (CTShapeNonVisual)get_store().find_element_user(NVSPPR$0, 0);
      if (cTShapeNonVisual == null)
        cTShapeNonVisual = (CTShapeNonVisual)get_store().add_element_user(NVSPPR$0); 
      cTShapeNonVisual.set((XmlObject)paramCTShapeNonVisual);
    } 
  }
  
  public CTShapeNonVisual addNewNvSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeNonVisual cTShapeNonVisual = null;
      cTShapeNonVisual = (CTShapeNonVisual)get_store().add_element_user(NVSPPR$0);
      return cTShapeNonVisual;
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
  
  public CTTextBody getTxBody() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXBODY$6, 0);
      if (cTTextBody == null)
        return null; 
      return cTTextBody;
    } 
  }
  
  public boolean isSetTxBody() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TXBODY$6) != 0);
    } 
  }
  
  public void setTxBody(CTTextBody paramCTTextBody) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXBODY$6, 0);
      if (cTTextBody == null)
        cTTextBody = (CTTextBody)get_store().add_element_user(TXBODY$6); 
      cTTextBody.set((XmlObject)paramCTTextBody);
    } 
  }
  
  public CTTextBody addNewTxBody() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().add_element_user(TXBODY$6);
      return cTTextBody;
    } 
  }
  
  public void unsetTxBody() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TXBODY$6, 0);
    } 
  }
  
  public String getMacro() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MACRO$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetMacro() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MACRO$8);
      return xmlString;
    } 
  }
  
  public boolean isSetMacro() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MACRO$8) != null);
    } 
  }
  
  public void setMacro(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MACRO$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MACRO$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetMacro(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MACRO$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(MACRO$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetMacro() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MACRO$8);
    } 
  }
  
  public String getTextlink() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTLINK$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTextlink() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TEXTLINK$10);
      return xmlString;
    } 
  }
  
  public boolean isSetTextlink() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TEXTLINK$10) != null);
    } 
  }
  
  public void setTextlink(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTLINK$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TEXTLINK$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTextlink(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TEXTLINK$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TEXTLINK$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTextlink() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TEXTLINK$10);
    } 
  }
  
  public boolean getFLocksText() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLOCKSTEXT$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FLOCKSTEXT$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFLocksText() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FLOCKSTEXT$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FLOCKSTEXT$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFLocksText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FLOCKSTEXT$12) != null);
    } 
  }
  
  public void setFLocksText(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLOCKSTEXT$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FLOCKSTEXT$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFLocksText(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FLOCKSTEXT$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FLOCKSTEXT$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFLocksText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FLOCKSTEXT$12);
    } 
  }
  
  public boolean getFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FPUBLISHED$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FPUBLISHED$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FPUBLISHED$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FPUBLISHED$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FPUBLISHED$14) != null);
    } 
  }
  
  public void setFPublished(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FPUBLISHED$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FPUBLISHED$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFPublished(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FPUBLISHED$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FPUBLISHED$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FPUBLISHED$14);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTShapeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */