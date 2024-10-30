package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPictureNonVisual;

public class CTPictureImpl extends XmlComplexContentImpl implements CTPicture {
  private static final b NVPICPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvPicPr");
  
  private static final b BLIPFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "blipFill");
  
  private static final b SPPR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "spPr");
  
  private static final b STYLE$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "style");
  
  private static final b MACRO$8 = new b("", "macro");
  
  private static final b FPUBLISHED$10 = new b("", "fPublished");
  
  public CTPictureImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPictureNonVisual getNvPicPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureNonVisual cTPictureNonVisual = null;
      cTPictureNonVisual = (CTPictureNonVisual)get_store().find_element_user(NVPICPR$0, 0);
      if (cTPictureNonVisual == null)
        return null; 
      return cTPictureNonVisual;
    } 
  }
  
  public void setNvPicPr(CTPictureNonVisual paramCTPictureNonVisual) {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureNonVisual cTPictureNonVisual = null;
      cTPictureNonVisual = (CTPictureNonVisual)get_store().find_element_user(NVPICPR$0, 0);
      if (cTPictureNonVisual == null)
        cTPictureNonVisual = (CTPictureNonVisual)get_store().add_element_user(NVPICPR$0); 
      cTPictureNonVisual.set((XmlObject)paramCTPictureNonVisual);
    } 
  }
  
  public CTPictureNonVisual addNewNvPicPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureNonVisual cTPictureNonVisual = null;
      cTPictureNonVisual = (CTPictureNonVisual)get_store().add_element_user(NVPICPR$0);
      return cTPictureNonVisual;
    } 
  }
  
  public CTBlipFillProperties getBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$2, 0);
      if (cTBlipFillProperties == null)
        return null; 
      return cTBlipFillProperties;
    } 
  }
  
  public void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$2, 0);
      if (cTBlipFillProperties == null)
        cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$2); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$2);
      return cTBlipFillProperties;
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$4, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$4, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$4); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$4);
      return cTShapeProperties;
    } 
  }
  
  public CTShapeStyle getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeStyle cTShapeStyle = null;
      cTShapeStyle = (CTShapeStyle)get_store().find_element_user(STYLE$6, 0);
      if (cTShapeStyle == null)
        return null; 
      return cTShapeStyle;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLE$6) != 0);
    } 
  }
  
  public void setStyle(CTShapeStyle paramCTShapeStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeStyle cTShapeStyle = null;
      cTShapeStyle = (CTShapeStyle)get_store().find_element_user(STYLE$6, 0);
      if (cTShapeStyle == null)
        cTShapeStyle = (CTShapeStyle)get_store().add_element_user(STYLE$6); 
      cTShapeStyle.set((XmlObject)paramCTShapeStyle);
    } 
  }
  
  public CTShapeStyle addNewStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeStyle cTShapeStyle = null;
      cTShapeStyle = (CTShapeStyle)get_store().add_element_user(STYLE$6);
      return cTShapeStyle;
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLE$6, 0);
    } 
  }
  
  public String getMacro() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MACRO$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MACRO$8); 
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
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(MACRO$8); 
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
  
  public boolean getFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FPUBLISHED$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FPUBLISHED$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FPUBLISHED$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FPUBLISHED$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FPUBLISHED$10) != null);
    } 
  }
  
  public void setFPublished(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FPUBLISHED$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FPUBLISHED$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFPublished(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FPUBLISHED$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FPUBLISHED$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFPublished() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FPUBLISHED$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTPictureImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */