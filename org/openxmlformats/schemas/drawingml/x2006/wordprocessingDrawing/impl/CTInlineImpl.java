package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTEffectExtent;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.STWrapDistance;

public class CTInlineImpl extends XmlComplexContentImpl implements CTInline {
  private static final b EXTENT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "extent");
  
  private static final b EFFECTEXTENT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "effectExtent");
  
  private static final b DOCPR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "docPr");
  
  private static final b CNVGRAPHICFRAMEPR$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "cNvGraphicFramePr");
  
  private static final b GRAPHIC$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic");
  
  private static final b DISTT$10 = new b("", "distT");
  
  private static final b DISTB$12 = new b("", "distB");
  
  private static final b DISTL$14 = new b("", "distL");
  
  private static final b DISTR$16 = new b("", "distR");
  
  public CTInlineImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPositiveSize2D getExtent() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(EXTENT$0, 0);
      if (cTPositiveSize2D == null)
        return null; 
      return cTPositiveSize2D;
    } 
  }
  
  public void setExtent(CTPositiveSize2D paramCTPositiveSize2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(EXTENT$0, 0);
      if (cTPositiveSize2D == null)
        cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(EXTENT$0); 
      cTPositiveSize2D.set((XmlObject)paramCTPositiveSize2D);
    } 
  }
  
  public CTPositiveSize2D addNewExtent() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(EXTENT$0);
      return cTPositiveSize2D;
    } 
  }
  
  public CTEffectExtent getEffectExtent() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectExtent cTEffectExtent = null;
      cTEffectExtent = (CTEffectExtent)get_store().find_element_user(EFFECTEXTENT$2, 0);
      if (cTEffectExtent == null)
        return null; 
      return cTEffectExtent;
    } 
  }
  
  public boolean isSetEffectExtent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTEXTENT$2) != 0);
    } 
  }
  
  public void setEffectExtent(CTEffectExtent paramCTEffectExtent) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectExtent cTEffectExtent = null;
      cTEffectExtent = (CTEffectExtent)get_store().find_element_user(EFFECTEXTENT$2, 0);
      if (cTEffectExtent == null)
        cTEffectExtent = (CTEffectExtent)get_store().add_element_user(EFFECTEXTENT$2); 
      cTEffectExtent.set((XmlObject)paramCTEffectExtent);
    } 
  }
  
  public CTEffectExtent addNewEffectExtent() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectExtent cTEffectExtent = null;
      cTEffectExtent = (CTEffectExtent)get_store().add_element_user(EFFECTEXTENT$2);
      return cTEffectExtent;
    } 
  }
  
  public void unsetEffectExtent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTEXTENT$2, 0);
    } 
  }
  
  public CTNonVisualDrawingProps getDocPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().find_element_user(DOCPR$4, 0);
      if (cTNonVisualDrawingProps == null)
        return null; 
      return cTNonVisualDrawingProps;
    } 
  }
  
  public void setDocPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().find_element_user(DOCPR$4, 0);
      if (cTNonVisualDrawingProps == null)
        cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().add_element_user(DOCPR$4); 
      cTNonVisualDrawingProps.set((XmlObject)paramCTNonVisualDrawingProps);
    } 
  }
  
  public CTNonVisualDrawingProps addNewDocPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().add_element_user(DOCPR$4);
      return cTNonVisualDrawingProps;
    } 
  }
  
  public CTNonVisualGraphicFrameProperties getCNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = null;
      cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties)get_store().find_element_user(CNVGRAPHICFRAMEPR$6, 0);
      if (cTNonVisualGraphicFrameProperties == null)
        return null; 
      return cTNonVisualGraphicFrameProperties;
    } 
  }
  
  public boolean isSetCNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CNVGRAPHICFRAMEPR$6) != 0);
    } 
  }
  
  public void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties paramCTNonVisualGraphicFrameProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = null;
      cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties)get_store().find_element_user(CNVGRAPHICFRAMEPR$6, 0);
      if (cTNonVisualGraphicFrameProperties == null)
        cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties)get_store().add_element_user(CNVGRAPHICFRAMEPR$6); 
      cTNonVisualGraphicFrameProperties.set((XmlObject)paramCTNonVisualGraphicFrameProperties);
    } 
  }
  
  public CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = null;
      cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties)get_store().add_element_user(CNVGRAPHICFRAMEPR$6);
      return cTNonVisualGraphicFrameProperties;
    } 
  }
  
  public void unsetCNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CNVGRAPHICFRAMEPR$6, 0);
    } 
  }
  
  public CTGraphicalObject getGraphic() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().find_element_user(GRAPHIC$8, 0);
      if (cTGraphicalObject == null)
        return null; 
      return cTGraphicalObject;
    } 
  }
  
  public void setGraphic(CTGraphicalObject paramCTGraphicalObject) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().find_element_user(GRAPHIC$8, 0);
      if (cTGraphicalObject == null)
        cTGraphicalObject = (CTGraphicalObject)get_store().add_element_user(GRAPHIC$8); 
      cTGraphicalObject.set((XmlObject)paramCTGraphicalObject);
    } 
  }
  
  public CTGraphicalObject addNewGraphic() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().add_element_user(GRAPHIC$8);
      return cTGraphicalObject;
    } 
  }
  
  public long getDistT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTT$10);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STWrapDistance xgetDistT() {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTT$10);
      return sTWrapDistance;
    } 
  }
  
  public boolean isSetDistT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISTT$10) != null);
    } 
  }
  
  public void setDistT(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISTT$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDistT(STWrapDistance paramSTWrapDistance) {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTT$10);
      if (sTWrapDistance == null)
        sTWrapDistance = (STWrapDistance)get_store().add_attribute_user(DISTT$10); 
      sTWrapDistance.set((XmlObject)paramSTWrapDistance);
    } 
  }
  
  public void unsetDistT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISTT$10);
    } 
  }
  
  public long getDistB() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTB$12);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STWrapDistance xgetDistB() {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTB$12);
      return sTWrapDistance;
    } 
  }
  
  public boolean isSetDistB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISTB$12) != null);
    } 
  }
  
  public void setDistB(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTB$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISTB$12); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDistB(STWrapDistance paramSTWrapDistance) {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTB$12);
      if (sTWrapDistance == null)
        sTWrapDistance = (STWrapDistance)get_store().add_attribute_user(DISTB$12); 
      sTWrapDistance.set((XmlObject)paramSTWrapDistance);
    } 
  }
  
  public void unsetDistB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISTB$12);
    } 
  }
  
  public long getDistL() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTL$14);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STWrapDistance xgetDistL() {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTL$14);
      return sTWrapDistance;
    } 
  }
  
  public boolean isSetDistL() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISTL$14) != null);
    } 
  }
  
  public void setDistL(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTL$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISTL$14); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDistL(STWrapDistance paramSTWrapDistance) {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTL$14);
      if (sTWrapDistance == null)
        sTWrapDistance = (STWrapDistance)get_store().add_attribute_user(DISTL$14); 
      sTWrapDistance.set((XmlObject)paramSTWrapDistance);
    } 
  }
  
  public void unsetDistL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISTL$14);
    } 
  }
  
  public long getDistR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTR$16);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STWrapDistance xgetDistR() {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTR$16);
      return sTWrapDistance;
    } 
  }
  
  public boolean isSetDistR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISTR$16) != null);
    } 
  }
  
  public void setDistR(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTR$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISTR$16); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDistR(STWrapDistance paramSTWrapDistance) {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTR$16);
      if (sTWrapDistance == null)
        sTWrapDistance = (STWrapDistance)get_store().add_attribute_user(DISTR$16); 
      sTWrapDistance.set((XmlObject)paramSTWrapDistance);
    } 
  }
  
  public void unsetDistR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISTR$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\wordprocessingDrawing\impl\CTInlineImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */