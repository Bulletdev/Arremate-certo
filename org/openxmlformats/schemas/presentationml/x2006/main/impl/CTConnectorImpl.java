package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;

public class CTConnectorImpl extends XmlComplexContentImpl implements CTConnector {
  private static final b NVCXNSPPR$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "nvCxnSpPr");
  
  private static final b SPPR$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "spPr");
  
  private static final b STYLE$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "style");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
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
  
  public CTExtensionListModify getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionListModify == null)
        return null; 
      return cTExtensionListModify;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionListModify paramCTExtensionListModify) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionListModify == null)
        cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$6); 
      cTExtensionListModify.set((XmlObject)paramCTExtensionListModify);
    } 
  }
  
  public CTExtensionListModify addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$6);
      return cTExtensionListModify;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTConnectorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */