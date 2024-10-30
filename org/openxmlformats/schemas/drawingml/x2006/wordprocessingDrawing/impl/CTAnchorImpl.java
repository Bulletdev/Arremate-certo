package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTEffectExtent;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTPosH;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTPosV;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapNone;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapSquare;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapThrough;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapTight;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapTopBottom;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.STWrapDistance;

public class CTAnchorImpl extends XmlComplexContentImpl implements CTAnchor {
  private static final b SIMPLEPOS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "simplePos");
  
  private static final b POSITIONH$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "positionH");
  
  private static final b POSITIONV$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "positionV");
  
  private static final b EXTENT$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "extent");
  
  private static final b EFFECTEXTENT$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "effectExtent");
  
  private static final b WRAPNONE$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapNone");
  
  private static final b WRAPSQUARE$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapSquare");
  
  private static final b WRAPTIGHT$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapTight");
  
  private static final b WRAPTHROUGH$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapThrough");
  
  private static final b WRAPTOPANDBOTTOM$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapTopAndBottom");
  
  private static final b DOCPR$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "docPr");
  
  private static final b CNVGRAPHICFRAMEPR$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "cNvGraphicFramePr");
  
  private static final b GRAPHIC$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic");
  
  private static final b DISTT$26 = new b("", "distT");
  
  private static final b DISTB$28 = new b("", "distB");
  
  private static final b DISTL$30 = new b("", "distL");
  
  private static final b DISTR$32 = new b("", "distR");
  
  private static final b SIMPLEPOS2$34 = new b("", "simplePos");
  
  private static final b RELATIVEHEIGHT$36 = new b("", "relativeHeight");
  
  private static final b BEHINDDOC$38 = new b("", "behindDoc");
  
  private static final b LOCKED$40 = new b("", "locked");
  
  private static final b LAYOUTINCELL$42 = new b("", "layoutInCell");
  
  private static final b HIDDEN$44 = new b("", "hidden");
  
  private static final b ALLOWOVERLAP$46 = new b("", "allowOverlap");
  
  public CTAnchorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPoint2D getSimplePos() {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().find_element_user(SIMPLEPOS$0, 0);
      if (cTPoint2D == null)
        return null; 
      return cTPoint2D;
    } 
  }
  
  public void setSimplePos(CTPoint2D paramCTPoint2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().find_element_user(SIMPLEPOS$0, 0);
      if (cTPoint2D == null)
        cTPoint2D = (CTPoint2D)get_store().add_element_user(SIMPLEPOS$0); 
      cTPoint2D.set((XmlObject)paramCTPoint2D);
    } 
  }
  
  public CTPoint2D addNewSimplePos() {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().add_element_user(SIMPLEPOS$0);
      return cTPoint2D;
    } 
  }
  
  public CTPosH getPositionH() {
    synchronized (monitor()) {
      check_orphaned();
      CTPosH cTPosH = null;
      cTPosH = (CTPosH)get_store().find_element_user(POSITIONH$2, 0);
      if (cTPosH == null)
        return null; 
      return cTPosH;
    } 
  }
  
  public void setPositionH(CTPosH paramCTPosH) {
    synchronized (monitor()) {
      check_orphaned();
      CTPosH cTPosH = null;
      cTPosH = (CTPosH)get_store().find_element_user(POSITIONH$2, 0);
      if (cTPosH == null)
        cTPosH = (CTPosH)get_store().add_element_user(POSITIONH$2); 
      cTPosH.set((XmlObject)paramCTPosH);
    } 
  }
  
  public CTPosH addNewPositionH() {
    synchronized (monitor()) {
      check_orphaned();
      CTPosH cTPosH = null;
      cTPosH = (CTPosH)get_store().add_element_user(POSITIONH$2);
      return cTPosH;
    } 
  }
  
  public CTPosV getPositionV() {
    synchronized (monitor()) {
      check_orphaned();
      CTPosV cTPosV = null;
      cTPosV = (CTPosV)get_store().find_element_user(POSITIONV$4, 0);
      if (cTPosV == null)
        return null; 
      return cTPosV;
    } 
  }
  
  public void setPositionV(CTPosV paramCTPosV) {
    synchronized (monitor()) {
      check_orphaned();
      CTPosV cTPosV = null;
      cTPosV = (CTPosV)get_store().find_element_user(POSITIONV$4, 0);
      if (cTPosV == null)
        cTPosV = (CTPosV)get_store().add_element_user(POSITIONV$4); 
      cTPosV.set((XmlObject)paramCTPosV);
    } 
  }
  
  public CTPosV addNewPositionV() {
    synchronized (monitor()) {
      check_orphaned();
      CTPosV cTPosV = null;
      cTPosV = (CTPosV)get_store().add_element_user(POSITIONV$4);
      return cTPosV;
    } 
  }
  
  public CTPositiveSize2D getExtent() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(EXTENT$6, 0);
      if (cTPositiveSize2D == null)
        return null; 
      return cTPositiveSize2D;
    } 
  }
  
  public void setExtent(CTPositiveSize2D paramCTPositiveSize2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(EXTENT$6, 0);
      if (cTPositiveSize2D == null)
        cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(EXTENT$6); 
      cTPositiveSize2D.set((XmlObject)paramCTPositiveSize2D);
    } 
  }
  
  public CTPositiveSize2D addNewExtent() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(EXTENT$6);
      return cTPositiveSize2D;
    } 
  }
  
  public CTEffectExtent getEffectExtent() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectExtent cTEffectExtent = null;
      cTEffectExtent = (CTEffectExtent)get_store().find_element_user(EFFECTEXTENT$8, 0);
      if (cTEffectExtent == null)
        return null; 
      return cTEffectExtent;
    } 
  }
  
  public boolean isSetEffectExtent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTEXTENT$8) != 0);
    } 
  }
  
  public void setEffectExtent(CTEffectExtent paramCTEffectExtent) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectExtent cTEffectExtent = null;
      cTEffectExtent = (CTEffectExtent)get_store().find_element_user(EFFECTEXTENT$8, 0);
      if (cTEffectExtent == null)
        cTEffectExtent = (CTEffectExtent)get_store().add_element_user(EFFECTEXTENT$8); 
      cTEffectExtent.set((XmlObject)paramCTEffectExtent);
    } 
  }
  
  public CTEffectExtent addNewEffectExtent() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectExtent cTEffectExtent = null;
      cTEffectExtent = (CTEffectExtent)get_store().add_element_user(EFFECTEXTENT$8);
      return cTEffectExtent;
    } 
  }
  
  public void unsetEffectExtent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTEXTENT$8, 0);
    } 
  }
  
  public CTWrapNone getWrapNone() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapNone cTWrapNone = null;
      cTWrapNone = (CTWrapNone)get_store().find_element_user(WRAPNONE$10, 0);
      if (cTWrapNone == null)
        return null; 
      return cTWrapNone;
    } 
  }
  
  public boolean isSetWrapNone() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WRAPNONE$10) != 0);
    } 
  }
  
  public void setWrapNone(CTWrapNone paramCTWrapNone) {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapNone cTWrapNone = null;
      cTWrapNone = (CTWrapNone)get_store().find_element_user(WRAPNONE$10, 0);
      if (cTWrapNone == null)
        cTWrapNone = (CTWrapNone)get_store().add_element_user(WRAPNONE$10); 
      cTWrapNone.set((XmlObject)paramCTWrapNone);
    } 
  }
  
  public CTWrapNone addNewWrapNone() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapNone cTWrapNone = null;
      cTWrapNone = (CTWrapNone)get_store().add_element_user(WRAPNONE$10);
      return cTWrapNone;
    } 
  }
  
  public void unsetWrapNone() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WRAPNONE$10, 0);
    } 
  }
  
  public CTWrapSquare getWrapSquare() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapSquare cTWrapSquare = null;
      cTWrapSquare = (CTWrapSquare)get_store().find_element_user(WRAPSQUARE$12, 0);
      if (cTWrapSquare == null)
        return null; 
      return cTWrapSquare;
    } 
  }
  
  public boolean isSetWrapSquare() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WRAPSQUARE$12) != 0);
    } 
  }
  
  public void setWrapSquare(CTWrapSquare paramCTWrapSquare) {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapSquare cTWrapSquare = null;
      cTWrapSquare = (CTWrapSquare)get_store().find_element_user(WRAPSQUARE$12, 0);
      if (cTWrapSquare == null)
        cTWrapSquare = (CTWrapSquare)get_store().add_element_user(WRAPSQUARE$12); 
      cTWrapSquare.set((XmlObject)paramCTWrapSquare);
    } 
  }
  
  public CTWrapSquare addNewWrapSquare() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapSquare cTWrapSquare = null;
      cTWrapSquare = (CTWrapSquare)get_store().add_element_user(WRAPSQUARE$12);
      return cTWrapSquare;
    } 
  }
  
  public void unsetWrapSquare() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WRAPSQUARE$12, 0);
    } 
  }
  
  public CTWrapTight getWrapTight() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapTight cTWrapTight = null;
      cTWrapTight = (CTWrapTight)get_store().find_element_user(WRAPTIGHT$14, 0);
      if (cTWrapTight == null)
        return null; 
      return cTWrapTight;
    } 
  }
  
  public boolean isSetWrapTight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WRAPTIGHT$14) != 0);
    } 
  }
  
  public void setWrapTight(CTWrapTight paramCTWrapTight) {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapTight cTWrapTight = null;
      cTWrapTight = (CTWrapTight)get_store().find_element_user(WRAPTIGHT$14, 0);
      if (cTWrapTight == null)
        cTWrapTight = (CTWrapTight)get_store().add_element_user(WRAPTIGHT$14); 
      cTWrapTight.set((XmlObject)paramCTWrapTight);
    } 
  }
  
  public CTWrapTight addNewWrapTight() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapTight cTWrapTight = null;
      cTWrapTight = (CTWrapTight)get_store().add_element_user(WRAPTIGHT$14);
      return cTWrapTight;
    } 
  }
  
  public void unsetWrapTight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WRAPTIGHT$14, 0);
    } 
  }
  
  public CTWrapThrough getWrapThrough() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapThrough cTWrapThrough = null;
      cTWrapThrough = (CTWrapThrough)get_store().find_element_user(WRAPTHROUGH$16, 0);
      if (cTWrapThrough == null)
        return null; 
      return cTWrapThrough;
    } 
  }
  
  public boolean isSetWrapThrough() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WRAPTHROUGH$16) != 0);
    } 
  }
  
  public void setWrapThrough(CTWrapThrough paramCTWrapThrough) {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapThrough cTWrapThrough = null;
      cTWrapThrough = (CTWrapThrough)get_store().find_element_user(WRAPTHROUGH$16, 0);
      if (cTWrapThrough == null)
        cTWrapThrough = (CTWrapThrough)get_store().add_element_user(WRAPTHROUGH$16); 
      cTWrapThrough.set((XmlObject)paramCTWrapThrough);
    } 
  }
  
  public CTWrapThrough addNewWrapThrough() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapThrough cTWrapThrough = null;
      cTWrapThrough = (CTWrapThrough)get_store().add_element_user(WRAPTHROUGH$16);
      return cTWrapThrough;
    } 
  }
  
  public void unsetWrapThrough() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WRAPTHROUGH$16, 0);
    } 
  }
  
  public CTWrapTopBottom getWrapTopAndBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapTopBottom cTWrapTopBottom = null;
      cTWrapTopBottom = (CTWrapTopBottom)get_store().find_element_user(WRAPTOPANDBOTTOM$18, 0);
      if (cTWrapTopBottom == null)
        return null; 
      return cTWrapTopBottom;
    } 
  }
  
  public boolean isSetWrapTopAndBottom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WRAPTOPANDBOTTOM$18) != 0);
    } 
  }
  
  public void setWrapTopAndBottom(CTWrapTopBottom paramCTWrapTopBottom) {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapTopBottom cTWrapTopBottom = null;
      cTWrapTopBottom = (CTWrapTopBottom)get_store().find_element_user(WRAPTOPANDBOTTOM$18, 0);
      if (cTWrapTopBottom == null)
        cTWrapTopBottom = (CTWrapTopBottom)get_store().add_element_user(WRAPTOPANDBOTTOM$18); 
      cTWrapTopBottom.set((XmlObject)paramCTWrapTopBottom);
    } 
  }
  
  public CTWrapTopBottom addNewWrapTopAndBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrapTopBottom cTWrapTopBottom = null;
      cTWrapTopBottom = (CTWrapTopBottom)get_store().add_element_user(WRAPTOPANDBOTTOM$18);
      return cTWrapTopBottom;
    } 
  }
  
  public void unsetWrapTopAndBottom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WRAPTOPANDBOTTOM$18, 0);
    } 
  }
  
  public CTNonVisualDrawingProps getDocPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().find_element_user(DOCPR$20, 0);
      if (cTNonVisualDrawingProps == null)
        return null; 
      return cTNonVisualDrawingProps;
    } 
  }
  
  public void setDocPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().find_element_user(DOCPR$20, 0);
      if (cTNonVisualDrawingProps == null)
        cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().add_element_user(DOCPR$20); 
      cTNonVisualDrawingProps.set((XmlObject)paramCTNonVisualDrawingProps);
    } 
  }
  
  public CTNonVisualDrawingProps addNewDocPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().add_element_user(DOCPR$20);
      return cTNonVisualDrawingProps;
    } 
  }
  
  public CTNonVisualGraphicFrameProperties getCNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = null;
      cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties)get_store().find_element_user(CNVGRAPHICFRAMEPR$22, 0);
      if (cTNonVisualGraphicFrameProperties == null)
        return null; 
      return cTNonVisualGraphicFrameProperties;
    } 
  }
  
  public boolean isSetCNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CNVGRAPHICFRAMEPR$22) != 0);
    } 
  }
  
  public void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties paramCTNonVisualGraphicFrameProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = null;
      cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties)get_store().find_element_user(CNVGRAPHICFRAMEPR$22, 0);
      if (cTNonVisualGraphicFrameProperties == null)
        cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties)get_store().add_element_user(CNVGRAPHICFRAMEPR$22); 
      cTNonVisualGraphicFrameProperties.set((XmlObject)paramCTNonVisualGraphicFrameProperties);
    } 
  }
  
  public CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = null;
      cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties)get_store().add_element_user(CNVGRAPHICFRAMEPR$22);
      return cTNonVisualGraphicFrameProperties;
    } 
  }
  
  public void unsetCNvGraphicFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CNVGRAPHICFRAMEPR$22, 0);
    } 
  }
  
  public CTGraphicalObject getGraphic() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().find_element_user(GRAPHIC$24, 0);
      if (cTGraphicalObject == null)
        return null; 
      return cTGraphicalObject;
    } 
  }
  
  public void setGraphic(CTGraphicalObject paramCTGraphicalObject) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().find_element_user(GRAPHIC$24, 0);
      if (cTGraphicalObject == null)
        cTGraphicalObject = (CTGraphicalObject)get_store().add_element_user(GRAPHIC$24); 
      cTGraphicalObject.set((XmlObject)paramCTGraphicalObject);
    } 
  }
  
  public CTGraphicalObject addNewGraphic() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObject cTGraphicalObject = null;
      cTGraphicalObject = (CTGraphicalObject)get_store().add_element_user(GRAPHIC$24);
      return cTGraphicalObject;
    } 
  }
  
  public long getDistT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTT$26);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STWrapDistance xgetDistT() {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTT$26);
      return sTWrapDistance;
    } 
  }
  
  public boolean isSetDistT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISTT$26) != null);
    } 
  }
  
  public void setDistT(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISTT$26); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDistT(STWrapDistance paramSTWrapDistance) {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTT$26);
      if (sTWrapDistance == null)
        sTWrapDistance = (STWrapDistance)get_store().add_attribute_user(DISTT$26); 
      sTWrapDistance.set((XmlObject)paramSTWrapDistance);
    } 
  }
  
  public void unsetDistT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISTT$26);
    } 
  }
  
  public long getDistB() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTB$28);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STWrapDistance xgetDistB() {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTB$28);
      return sTWrapDistance;
    } 
  }
  
  public boolean isSetDistB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISTB$28) != null);
    } 
  }
  
  public void setDistB(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTB$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISTB$28); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDistB(STWrapDistance paramSTWrapDistance) {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTB$28);
      if (sTWrapDistance == null)
        sTWrapDistance = (STWrapDistance)get_store().add_attribute_user(DISTB$28); 
      sTWrapDistance.set((XmlObject)paramSTWrapDistance);
    } 
  }
  
  public void unsetDistB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISTB$28);
    } 
  }
  
  public long getDistL() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTL$30);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STWrapDistance xgetDistL() {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTL$30);
      return sTWrapDistance;
    } 
  }
  
  public boolean isSetDistL() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISTL$30) != null);
    } 
  }
  
  public void setDistL(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTL$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISTL$30); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDistL(STWrapDistance paramSTWrapDistance) {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTL$30);
      if (sTWrapDistance == null)
        sTWrapDistance = (STWrapDistance)get_store().add_attribute_user(DISTL$30); 
      sTWrapDistance.set((XmlObject)paramSTWrapDistance);
    } 
  }
  
  public void unsetDistL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISTL$30);
    } 
  }
  
  public long getDistR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTR$32);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STWrapDistance xgetDistR() {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTR$32);
      return sTWrapDistance;
    } 
  }
  
  public boolean isSetDistR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISTR$32) != null);
    } 
  }
  
  public void setDistR(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISTR$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISTR$32); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDistR(STWrapDistance paramSTWrapDistance) {
    synchronized (monitor()) {
      check_orphaned();
      STWrapDistance sTWrapDistance = null;
      sTWrapDistance = (STWrapDistance)get_store().find_attribute_user(DISTR$32);
      if (sTWrapDistance == null)
        sTWrapDistance = (STWrapDistance)get_store().add_attribute_user(DISTR$32); 
      sTWrapDistance.set((XmlObject)paramSTWrapDistance);
    } 
  }
  
  public void unsetDistR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISTR$32);
    } 
  }
  
  public boolean getSimplePos2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SIMPLEPOS2$34);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSimplePos2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SIMPLEPOS2$34);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSimplePos2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SIMPLEPOS2$34) != null);
    } 
  }
  
  public void setSimplePos2(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SIMPLEPOS2$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SIMPLEPOS2$34); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSimplePos2(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SIMPLEPOS2$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SIMPLEPOS2$34); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSimplePos2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SIMPLEPOS2$34);
    } 
  }
  
  public long getRelativeHeight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELATIVEHEIGHT$36);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetRelativeHeight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(RELATIVEHEIGHT$36);
      return xmlUnsignedInt;
    } 
  }
  
  public void setRelativeHeight(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELATIVEHEIGHT$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RELATIVEHEIGHT$36); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetRelativeHeight(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(RELATIVEHEIGHT$36);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(RELATIVEHEIGHT$36); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public boolean getBehindDoc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BEHINDDOC$38);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBehindDoc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BEHINDDOC$38);
      return xmlBoolean;
    } 
  }
  
  public void setBehindDoc(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BEHINDDOC$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BEHINDDOC$38); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBehindDoc(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BEHINDDOC$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BEHINDDOC$38); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public boolean getLocked() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKED$40);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKED$40);
      return xmlBoolean;
    } 
  }
  
  public void setLocked(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKED$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LOCKED$40); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLocked(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LOCKED$40);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LOCKED$40); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public boolean getLayoutInCell() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LAYOUTINCELL$42);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLayoutInCell() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LAYOUTINCELL$42);
      return xmlBoolean;
    } 
  }
  
  public void setLayoutInCell(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LAYOUTINCELL$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LAYOUTINCELL$42); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLayoutInCell(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LAYOUTINCELL$42);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LAYOUTINCELL$42); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public boolean getHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$44);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$44);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDDEN$44) != null);
    } 
  }
  
  public void setHidden(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDDEN$44); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHidden(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$44);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDDEN$44); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDDEN$44);
    } 
  }
  
  public boolean getAllowOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWOVERLAP$46);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAllowOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALLOWOVERLAP$46);
      return xmlBoolean;
    } 
  }
  
  public void setAllowOverlap(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWOVERLAP$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALLOWOVERLAP$46); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAllowOverlap(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALLOWOVERLAP$46);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ALLOWOVERLAP$46); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\wordprocessingDrawing\impl\CTAnchorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */