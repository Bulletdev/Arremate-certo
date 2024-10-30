package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrameNonVisual;

public class CTGraphicalObjectFrameImpl extends XmlComplexContentImpl implements CTGraphicalObjectFrame {
  private static final b NVGRAPHICFRAMEPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvGraphicFramePr");
  
  private static final b XFRM$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "xfrm");
  
  private static final b GRAPHIC$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic");
  
  private static final b MACRO$6 = new b("", "macro");
  
  private static final b FPUBLISHED$8 = new b("", "fPublished");
  
  public CTGraphicalObjectFrameImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGraphicalObjectFrameNonVisual getNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = null;
      cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual)get_store().find_element_user(NVGRAPHICFRAMEPR$0, 0);
      if (cTGraphicalObjectFrameNonVisual == null)
        return null; 
      return cTGraphicalObjectFrameNonVisual;
    } 
  }
  
  public void setNvGraphicFramePr(CTGraphicalObjectFrameNonVisual paramCTGraphicalObjectFrameNonVisual) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = null;
      cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual)get_store().find_element_user(NVGRAPHICFRAMEPR$0, 0);
      if (cTGraphicalObjectFrameNonVisual == null)
        cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual)get_store().add_element_user(NVGRAPHICFRAMEPR$0); 
      cTGraphicalObjectFrameNonVisual.set((XmlObject)paramCTGraphicalObjectFrameNonVisual);
    } 
  }
  
  public CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = null;
      cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual)get_store().add_element_user(NVGRAPHICFRAMEPR$0);
      return cTGraphicalObjectFrameNonVisual;
    } 
  }
  
  public CTTransform2D getXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      CTTransform2D cTTransform2D = null;
      cTTransform2D = (CTTransform2D)get_store().find_element_user(XFRM$2, 0);
      if (cTTransform2D == null)
        return null; 
      return cTTransform2D;
    } 
  }
  
  public void setXfrm(CTTransform2D paramCTTransform2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTTransform2D cTTransform2D = null;
      cTTransform2D = (CTTransform2D)get_store().find_element_user(XFRM$2, 0);
      if (cTTransform2D == null)
        cTTransform2D = (CTTransform2D)get_store().add_element_user(XFRM$2); 
      cTTransform2D.set((XmlObject)paramCTTransform2D);
    } 
  }
  
  public CTTransform2D addNewXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      CTTransform2D cTTransform2D = null;
      cTTransform2D = (CTTransform2D)get_store().add_element_user(XFRM$2);
      return cTTransform2D;
    } 
  }
  
  public CTGraphicalObject getGraphic() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().find_element_user(GRAPHIC$4, 0);
      if (cTGraphicalObject == null)
        return null; 
      return cTGraphicalObject;
    } 
  }
  
  public void setGraphic(CTGraphicalObject paramCTGraphicalObject) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().find_element_user(GRAPHIC$4, 0);
      if (cTGraphicalObject == null)
        cTGraphicalObject = (CTGraphicalObject)get_store().add_element_user(GRAPHIC$4); 
      cTGraphicalObject.set((XmlObject)paramCTGraphicalObject);
    } 
  }
  
  public CTGraphicalObject addNewGraphic() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().add_element_user(GRAPHIC$4);
      return cTGraphicalObject;
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTGraphicalObjectFrameImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */