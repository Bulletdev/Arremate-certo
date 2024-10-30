package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

public class CTShapeImpl extends XmlComplexContentImpl implements CTShape {
  private static final b NVSPPR$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "nvSpPr");
  
  private static final b SPPR$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "spPr");
  
  private static final b STYLE$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "style");
  
  private static final b TXBODY$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "txBody");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b USEBGFILL$10 = new b("", "useBgFill");
  
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
  
  public CTExtensionListModify getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionListModify == null)
        return null; 
      return cTExtensionListModify;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$8) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionListModify paramCTExtensionListModify) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionListModify == null)
        cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$8); 
      cTExtensionListModify.set((XmlObject)paramCTExtensionListModify);
    } 
  }
  
  public CTExtensionListModify addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$8);
      return cTExtensionListModify;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$8, 0);
    } 
  }
  
  public boolean getUseBgFill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEBGFILL$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(USEBGFILL$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUseBgFill() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEBGFILL$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(USEBGFILL$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUseBgFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USEBGFILL$10) != null);
    } 
  }
  
  public void setUseBgFill(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEBGFILL$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USEBGFILL$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUseBgFill(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEBGFILL$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(USEBGFILL$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUseBgFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USEBGFILL$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTShapeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */