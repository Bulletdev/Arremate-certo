package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

public class CTGraphicalObjectFrameImpl extends XmlComplexContentImpl implements CTGraphicalObjectFrame {
  private static final b NVGRAPHICFRAMEPR$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGraphicFramePr");
  
  private static final b XFRM$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "xfrm");
  
  private static final b GRAPHIC$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTGraphicalObjectFrameImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */