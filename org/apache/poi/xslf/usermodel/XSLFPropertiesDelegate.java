/*      */ package org.apache.poi.xslf.usermodel;
/*      */ 
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*      */ import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Internal
/*      */ class XSLFPropertiesDelegate
/*      */ {
/*   53 */   private static final POILogger LOG = POILogFactory.getLogger(XSLFPropertiesDelegate.class);
/*      */ 
/*      */   
/*      */   public static XSLFFillProperties getFillDelegate(XmlObject paramXmlObject) {
/*   57 */     return getDelegate(XSLFFillProperties.class, paramXmlObject);
/*      */   }
/*      */   
/*      */   public static XSLFGeometryProperties getGeometryDelegate(XmlObject paramXmlObject) {
/*   61 */     return getDelegate(XSLFGeometryProperties.class, paramXmlObject);
/*      */   }
/*      */   
/*      */   public static XSLFEffectProperties getEffectDelegate(XmlObject paramXmlObject) {
/*   65 */     return getDelegate(XSLFEffectProperties.class, paramXmlObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface XSLFFillProperties
/*      */   {
/*      */     CTNoFillProperties getNoFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetNoFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setNoFill(CTNoFillProperties param1CTNoFillProperties);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTNoFillProperties addNewNoFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetNoFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTSolidColorFillProperties getSolidFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetSolidFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTSolidColorFillProperties addNewSolidFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetSolidFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTGradientFillProperties getGradFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetGradFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setGradFill(CTGradientFillProperties param1CTGradientFillProperties);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTGradientFillProperties addNewGradFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetGradFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTBlipFillProperties getBlipFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetBlipFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTBlipFillProperties addNewBlipFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetBlipFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTPatternFillProperties getPattFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetPattFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setPattFill(CTPatternFillProperties param1CTPatternFillProperties);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTPatternFillProperties addNewPattFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetPattFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTGroupFillProperties getGrpFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetGrpFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTGroupFillProperties addNewGrpFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetGrpFill();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetMatrixStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTStyleMatrixReference getMatrixStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isLineStyle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface XSLFGeometryProperties
/*      */   {
/*      */     CTCustomGeometry2D getCustGeom();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetCustGeom();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setCustGeom(CTCustomGeometry2D param1CTCustomGeometry2D);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTCustomGeometry2D addNewCustGeom();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetCustGeom();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTPresetGeometry2D getPrstGeom();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetPrstGeom();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setPrstGeom(CTPresetGeometry2D param1CTPresetGeometry2D);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTPresetGeometry2D addNewPrstGeom();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetPrstGeom();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface XSLFEffectProperties
/*      */   {
/*      */     CTEffectList getEffectLst();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetEffectLst();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setEffectLst(CTEffectList param1CTEffectList);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CTEffectList addNewEffectLst();
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetEffectLst();
/*      */ 
/*      */ 
/*      */     
/*      */     CTEffectContainer getEffectDag();
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isSetEffectDag();
/*      */ 
/*      */ 
/*      */     
/*      */     void setEffectDag(CTEffectContainer param1CTEffectContainer);
/*      */ 
/*      */ 
/*      */     
/*      */     CTEffectContainer addNewEffectDag();
/*      */ 
/*      */ 
/*      */     
/*      */     void unsetEffectDag();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class ShapeDelegate
/*      */     implements XSLFEffectProperties, XSLFFillProperties, XSLFGeometryProperties
/*      */   {
/*      */     final CTShapeProperties props;
/*      */ 
/*      */ 
/*      */     
/*      */     ShapeDelegate(CTShapeProperties param1CTShapeProperties) {
/*  346 */       this.props = param1CTShapeProperties;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties getNoFill() {
/*  351 */       return this.props.getNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetNoFill() {
/*  356 */       return this.props.isSetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoFill(CTNoFillProperties param1CTNoFillProperties) {
/*  361 */       this.props.setNoFill(param1CTNoFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties addNewNoFill() {
/*  366 */       return this.props.addNewNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetNoFill() {
/*  371 */       this.props.unsetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties getSolidFill() {
/*  376 */       return this.props.getSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetSolidFill() {
/*  381 */       return this.props.isSetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties) {
/*  386 */       this.props.setSolidFill(param1CTSolidColorFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties addNewSolidFill() {
/*  391 */       return this.props.addNewSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetSolidFill() {
/*  396 */       this.props.unsetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties getGradFill() {
/*  401 */       return this.props.getGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGradFill() {
/*  406 */       return this.props.isSetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGradFill(CTGradientFillProperties param1CTGradientFillProperties) {
/*  411 */       this.props.setGradFill(param1CTGradientFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties addNewGradFill() {
/*  416 */       return this.props.addNewGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGradFill() {
/*  421 */       this.props.unsetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties getBlipFill() {
/*  426 */       return this.props.getBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetBlipFill() {
/*  431 */       return this.props.isSetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties) {
/*  436 */       this.props.setBlipFill(param1CTBlipFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties addNewBlipFill() {
/*  441 */       return this.props.addNewBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetBlipFill() {
/*  446 */       this.props.unsetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties getPattFill() {
/*  451 */       return this.props.getPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetPattFill() {
/*  456 */       return this.props.isSetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setPattFill(CTPatternFillProperties param1CTPatternFillProperties) {
/*  461 */       this.props.setPattFill(param1CTPatternFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties addNewPattFill() {
/*  466 */       return this.props.addNewPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetPattFill() {
/*  471 */       this.props.unsetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties getGrpFill() {
/*  476 */       return this.props.getGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGrpFill() {
/*  481 */       return this.props.isSetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties) {
/*  486 */       this.props.setGrpFill(param1CTGroupFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties addNewGrpFill() {
/*  491 */       return this.props.addNewGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGrpFill() {
/*  496 */       this.props.unsetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTCustomGeometry2D getCustGeom() {
/*  501 */       return this.props.getCustGeom();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetCustGeom() {
/*  506 */       return this.props.isSetCustGeom();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setCustGeom(CTCustomGeometry2D param1CTCustomGeometry2D) {
/*  511 */       this.props.setCustGeom(param1CTCustomGeometry2D);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTCustomGeometry2D addNewCustGeom() {
/*  516 */       return this.props.addNewCustGeom();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetCustGeom() {
/*  521 */       this.props.unsetCustGeom();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPresetGeometry2D getPrstGeom() {
/*  526 */       return this.props.getPrstGeom();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetPrstGeom() {
/*  531 */       return this.props.isSetPrstGeom();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setPrstGeom(CTPresetGeometry2D param1CTPresetGeometry2D) {
/*  536 */       this.props.setPrstGeom(param1CTPresetGeometry2D);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPresetGeometry2D addNewPrstGeom() {
/*  541 */       return this.props.addNewPrstGeom();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetPrstGeom() {
/*  546 */       this.props.unsetPrstGeom();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTEffectList getEffectLst() {
/*  551 */       return this.props.getEffectLst();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetEffectLst() {
/*  556 */       return this.props.isSetEffectLst();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setEffectLst(CTEffectList param1CTEffectList) {
/*  561 */       this.props.setEffectLst(param1CTEffectList);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTEffectList addNewEffectLst() {
/*  566 */       return this.props.addNewEffectLst();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetEffectLst() {
/*  571 */       this.props.unsetEffectLst();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTEffectContainer getEffectDag() {
/*  576 */       return this.props.getEffectDag();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetEffectDag() {
/*  581 */       return this.props.isSetEffectDag();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setEffectDag(CTEffectContainer param1CTEffectContainer) {
/*  586 */       this.props.setEffectDag(param1CTEffectContainer);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTEffectContainer addNewEffectDag() {
/*  591 */       return this.props.addNewEffectDag();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetEffectDag() {
/*  596 */       this.props.unsetEffectDag();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetMatrixStyle() {
/*  601 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTStyleMatrixReference getMatrixStyle() {
/*  606 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isLineStyle() {
/*  611 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class BackgroundDelegate implements XSLFEffectProperties, XSLFFillProperties {
/*      */     final CTBackgroundProperties props;
/*      */     
/*      */     BackgroundDelegate(CTBackgroundProperties param1CTBackgroundProperties) {
/*  619 */       this.props = param1CTBackgroundProperties;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties getNoFill() {
/*  624 */       return this.props.getNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetNoFill() {
/*  629 */       return this.props.isSetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoFill(CTNoFillProperties param1CTNoFillProperties) {
/*  634 */       this.props.setNoFill(param1CTNoFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties addNewNoFill() {
/*  639 */       return this.props.addNewNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetNoFill() {
/*  644 */       this.props.unsetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties getSolidFill() {
/*  649 */       return this.props.getSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetSolidFill() {
/*  654 */       return this.props.isSetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties) {
/*  659 */       this.props.setSolidFill(param1CTSolidColorFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties addNewSolidFill() {
/*  664 */       return this.props.addNewSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetSolidFill() {
/*  669 */       this.props.unsetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties getGradFill() {
/*  674 */       return this.props.getGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGradFill() {
/*  679 */       return this.props.isSetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGradFill(CTGradientFillProperties param1CTGradientFillProperties) {
/*  684 */       this.props.setGradFill(param1CTGradientFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties addNewGradFill() {
/*  689 */       return this.props.addNewGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGradFill() {
/*  694 */       this.props.unsetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties getBlipFill() {
/*  699 */       return this.props.getBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetBlipFill() {
/*  704 */       return this.props.isSetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties) {
/*  709 */       this.props.setBlipFill(param1CTBlipFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties addNewBlipFill() {
/*  714 */       return this.props.addNewBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetBlipFill() {
/*  719 */       this.props.unsetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties getPattFill() {
/*  724 */       return this.props.getPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetPattFill() {
/*  729 */       return this.props.isSetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setPattFill(CTPatternFillProperties param1CTPatternFillProperties) {
/*  734 */       this.props.setPattFill(param1CTPatternFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties addNewPattFill() {
/*  739 */       return this.props.addNewPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetPattFill() {
/*  744 */       this.props.unsetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties getGrpFill() {
/*  749 */       return this.props.getGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGrpFill() {
/*  754 */       return this.props.isSetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties) {
/*  759 */       this.props.setGrpFill(param1CTGroupFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties addNewGrpFill() {
/*  764 */       return this.props.addNewGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGrpFill() {
/*  769 */       this.props.unsetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTEffectList getEffectLst() {
/*  774 */       return this.props.getEffectLst();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetEffectLst() {
/*  779 */       return this.props.isSetEffectLst();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setEffectLst(CTEffectList param1CTEffectList) {
/*  784 */       this.props.setEffectLst(param1CTEffectList);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTEffectList addNewEffectLst() {
/*  789 */       return this.props.addNewEffectLst();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetEffectLst() {
/*  794 */       this.props.unsetEffectLst();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTEffectContainer getEffectDag() {
/*  799 */       return this.props.getEffectDag();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetEffectDag() {
/*  804 */       return this.props.isSetEffectDag();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setEffectDag(CTEffectContainer param1CTEffectContainer) {
/*  809 */       this.props.setEffectDag(param1CTEffectContainer);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTEffectContainer addNewEffectDag() {
/*  814 */       return this.props.addNewEffectDag();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetEffectDag() {
/*  819 */       this.props.unsetEffectDag();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetMatrixStyle() {
/*  824 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTStyleMatrixReference getMatrixStyle() {
/*  829 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isLineStyle() {
/*  834 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class TableCellDelegate implements XSLFFillProperties {
/*      */     final CTTableCellProperties props;
/*      */     
/*      */     TableCellDelegate(CTTableCellProperties param1CTTableCellProperties) {
/*  842 */       this.props = param1CTTableCellProperties;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties getNoFill() {
/*  847 */       return this.props.getNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetNoFill() {
/*  852 */       return this.props.isSetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoFill(CTNoFillProperties param1CTNoFillProperties) {
/*  857 */       this.props.setNoFill(param1CTNoFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties addNewNoFill() {
/*  862 */       return this.props.addNewNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetNoFill() {
/*  867 */       this.props.unsetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties getSolidFill() {
/*  872 */       return this.props.getSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetSolidFill() {
/*  877 */       return this.props.isSetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties) {
/*  882 */       this.props.setSolidFill(param1CTSolidColorFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties addNewSolidFill() {
/*  887 */       return this.props.addNewSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetSolidFill() {
/*  892 */       this.props.unsetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties getGradFill() {
/*  897 */       return this.props.getGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGradFill() {
/*  902 */       return this.props.isSetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGradFill(CTGradientFillProperties param1CTGradientFillProperties) {
/*  907 */       this.props.setGradFill(param1CTGradientFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties addNewGradFill() {
/*  912 */       return this.props.addNewGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGradFill() {
/*  917 */       this.props.unsetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties getBlipFill() {
/*  922 */       return this.props.getBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetBlipFill() {
/*  927 */       return this.props.isSetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties) {
/*  932 */       this.props.setBlipFill(param1CTBlipFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties addNewBlipFill() {
/*  937 */       return this.props.addNewBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetBlipFill() {
/*  942 */       this.props.unsetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties getPattFill() {
/*  947 */       return this.props.getPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetPattFill() {
/*  952 */       return this.props.isSetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setPattFill(CTPatternFillProperties param1CTPatternFillProperties) {
/*  957 */       this.props.setPattFill(param1CTPatternFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties addNewPattFill() {
/*  962 */       return this.props.addNewPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetPattFill() {
/*  967 */       this.props.unsetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties getGrpFill() {
/*  972 */       return this.props.getGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGrpFill() {
/*  977 */       return this.props.isSetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties) {
/*  982 */       this.props.setGrpFill(param1CTGroupFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties addNewGrpFill() {
/*  987 */       return this.props.addNewGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGrpFill() {
/*  992 */       this.props.unsetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetMatrixStyle() {
/*  997 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTStyleMatrixReference getMatrixStyle() {
/* 1002 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isLineStyle() {
/* 1007 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class StyleMatrixDelegate implements XSLFFillProperties {
/*      */     final CTStyleMatrixReference props;
/*      */     
/*      */     StyleMatrixDelegate(CTStyleMatrixReference param1CTStyleMatrixReference) {
/* 1015 */       this.props = param1CTStyleMatrixReference;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties getNoFill() {
/* 1020 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetNoFill() {
/* 1025 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoFill(CTNoFillProperties param1CTNoFillProperties) {}
/*      */ 
/*      */     
/*      */     public CTNoFillProperties addNewNoFill() {
/* 1033 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetNoFill() {}
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties getSolidFill() {
/* 1041 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetSolidFill() {
/* 1046 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties) {}
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties addNewSolidFill() {
/* 1054 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetSolidFill() {}
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties getGradFill() {
/* 1062 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGradFill() {
/* 1067 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGradFill(CTGradientFillProperties param1CTGradientFillProperties) {}
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties addNewGradFill() {
/* 1075 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGradFill() {}
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties getBlipFill() {
/* 1083 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetBlipFill() {
/* 1088 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties) {}
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties addNewBlipFill() {
/* 1096 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetBlipFill() {}
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties getPattFill() {
/* 1104 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetPattFill() {
/* 1109 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setPattFill(CTPatternFillProperties param1CTPatternFillProperties) {}
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties addNewPattFill() {
/* 1117 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetPattFill() {}
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties getGrpFill() {
/* 1125 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGrpFill() {
/* 1130 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties) {}
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties addNewGrpFill() {
/* 1138 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetGrpFill() {}
/*      */ 
/*      */     
/*      */     public boolean isSetMatrixStyle() {
/* 1147 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTStyleMatrixReference getMatrixStyle() {
/* 1152 */       return this.props;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isLineStyle() {
/* 1157 */       XmlCursor xmlCursor = this.props.newCursor();
/* 1158 */       String str = xmlCursor.getName().dT();
/* 1159 */       xmlCursor.dispose();
/* 1160 */       return "lnRef".equals(str);
/*      */     }
/*      */   }
/*      */   
/*      */   private static class FillDelegate implements XSLFFillProperties {
/*      */     final CTFillProperties props;
/*      */     
/*      */     FillDelegate(CTFillProperties param1CTFillProperties) {
/* 1168 */       this.props = param1CTFillProperties;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties getNoFill() {
/* 1173 */       return this.props.getNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetNoFill() {
/* 1178 */       return this.props.isSetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoFill(CTNoFillProperties param1CTNoFillProperties) {
/* 1183 */       this.props.setNoFill(param1CTNoFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties addNewNoFill() {
/* 1188 */       return this.props.addNewNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetNoFill() {
/* 1193 */       this.props.unsetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties getSolidFill() {
/* 1198 */       return this.props.getSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetSolidFill() {
/* 1203 */       return this.props.isSetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties) {
/* 1208 */       this.props.setSolidFill(param1CTSolidColorFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties addNewSolidFill() {
/* 1213 */       return this.props.addNewSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetSolidFill() {
/* 1218 */       this.props.unsetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties getGradFill() {
/* 1223 */       return this.props.getGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGradFill() {
/* 1228 */       return this.props.isSetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGradFill(CTGradientFillProperties param1CTGradientFillProperties) {
/* 1233 */       this.props.setGradFill(param1CTGradientFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties addNewGradFill() {
/* 1238 */       return this.props.addNewGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGradFill() {
/* 1243 */       this.props.unsetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties getBlipFill() {
/* 1248 */       return this.props.getBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetBlipFill() {
/* 1253 */       return this.props.isSetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties) {
/* 1258 */       this.props.setBlipFill(param1CTBlipFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties addNewBlipFill() {
/* 1263 */       return this.props.addNewBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetBlipFill() {
/* 1268 */       this.props.unsetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties getPattFill() {
/* 1273 */       return this.props.getPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetPattFill() {
/* 1278 */       return this.props.isSetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setPattFill(CTPatternFillProperties param1CTPatternFillProperties) {
/* 1283 */       this.props.setPattFill(param1CTPatternFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties addNewPattFill() {
/* 1288 */       return this.props.addNewPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetPattFill() {
/* 1293 */       this.props.unsetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties getGrpFill() {
/* 1298 */       return this.props.getGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGrpFill() {
/* 1303 */       return this.props.isSetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties) {
/* 1308 */       this.props.setGrpFill(param1CTGroupFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties addNewGrpFill() {
/* 1313 */       return this.props.addNewGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGrpFill() {
/* 1318 */       this.props.unsetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetMatrixStyle() {
/* 1323 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTStyleMatrixReference getMatrixStyle() {
/* 1328 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isLineStyle() {
/* 1333 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class FillPartDelegate implements XSLFFillProperties {
/*      */     final XmlObject props;
/*      */     
/*      */     FillPartDelegate(XmlObject param1XmlObject) {
/* 1341 */       this.props = param1XmlObject;
/*      */     }
/*      */     
/*      */     public CTNoFillProperties getNoFill() {
/* 1345 */       return isSetNoFill() ? (CTNoFillProperties)this.props : null;
/*      */     }
/*      */     
/*      */     public boolean isSetNoFill() {
/* 1349 */       return this.props instanceof CTNoFillProperties;
/*      */     }
/*      */     
/*      */     public void setNoFill(CTNoFillProperties param1CTNoFillProperties) {}
/*      */     
/*      */     public CTNoFillProperties addNewNoFill() {
/* 1355 */       return null;
/*      */     }
/*      */     
/*      */     public void unsetNoFill() {}
/*      */     
/*      */     public CTSolidColorFillProperties getSolidFill() {
/* 1361 */       return isSetSolidFill() ? (CTSolidColorFillProperties)this.props : null;
/*      */     }
/*      */     
/*      */     public boolean isSetSolidFill() {
/* 1365 */       return this.props instanceof CTSolidColorFillProperties;
/*      */     }
/*      */     
/*      */     public void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties) {}
/*      */     
/*      */     public CTSolidColorFillProperties addNewSolidFill() {
/* 1371 */       return null;
/*      */     }
/*      */     
/*      */     public void unsetSolidFill() {}
/*      */     
/*      */     public CTGradientFillProperties getGradFill() {
/* 1377 */       return isSetGradFill() ? (CTGradientFillProperties)this.props : null;
/*      */     }
/*      */     
/*      */     public boolean isSetGradFill() {
/* 1381 */       return this.props instanceof CTGradientFillProperties;
/*      */     }
/*      */     
/*      */     public void setGradFill(CTGradientFillProperties param1CTGradientFillProperties) {}
/*      */     
/*      */     public CTGradientFillProperties addNewGradFill() {
/* 1387 */       return null;
/*      */     }
/*      */     
/*      */     public void unsetGradFill() {}
/*      */     
/*      */     public CTBlipFillProperties getBlipFill() {
/* 1393 */       return isSetBlipFill() ? (CTBlipFillProperties)this.props : null;
/*      */     }
/*      */     
/*      */     public boolean isSetBlipFill() {
/* 1397 */       return this.props instanceof CTBlipFillProperties;
/*      */     }
/*      */     
/*      */     public void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties) {}
/*      */     
/*      */     public CTBlipFillProperties addNewBlipFill() {
/* 1403 */       return null;
/*      */     }
/*      */     
/*      */     public void unsetBlipFill() {}
/*      */     
/*      */     public CTPatternFillProperties getPattFill() {
/* 1409 */       return isSetPattFill() ? (CTPatternFillProperties)this.props : null;
/*      */     }
/*      */     
/*      */     public boolean isSetPattFill() {
/* 1413 */       return this.props instanceof CTPatternFillProperties;
/*      */     }
/*      */     
/*      */     public void setPattFill(CTPatternFillProperties param1CTPatternFillProperties) {}
/*      */     
/*      */     public CTPatternFillProperties addNewPattFill() {
/* 1419 */       return null;
/*      */     }
/*      */     
/*      */     public void unsetPattFill() {}
/*      */     
/*      */     public CTGroupFillProperties getGrpFill() {
/* 1425 */       return isSetGrpFill() ? (CTGroupFillProperties)this.props : null;
/*      */     }
/*      */     
/*      */     public boolean isSetGrpFill() {
/* 1429 */       return this.props instanceof CTGroupFillProperties;
/*      */     }
/*      */     
/*      */     public void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties) {}
/*      */     
/*      */     public CTGroupFillProperties addNewGrpFill() {
/* 1435 */       return null;
/*      */     }
/*      */     
/*      */     public void unsetGrpFill() {}
/*      */     
/*      */     public boolean isSetMatrixStyle() {
/* 1441 */       return false;
/*      */     }
/*      */     
/*      */     public CTStyleMatrixReference getMatrixStyle() {
/* 1445 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isLineStyle() {
/* 1450 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class LineStyleDelegate implements XSLFFillProperties {
/*      */     final CTLineProperties props;
/*      */     
/*      */     LineStyleDelegate(CTLineProperties param1CTLineProperties) {
/* 1458 */       this.props = param1CTLineProperties;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties getNoFill() {
/* 1463 */       return this.props.getNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetNoFill() {
/* 1468 */       return this.props.isSetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoFill(CTNoFillProperties param1CTNoFillProperties) {
/* 1473 */       this.props.setNoFill(param1CTNoFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties addNewNoFill() {
/* 1478 */       return this.props.addNewNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetNoFill() {
/* 1483 */       this.props.unsetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties getSolidFill() {
/* 1488 */       return this.props.getSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetSolidFill() {
/* 1493 */       return this.props.isSetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties) {
/* 1498 */       this.props.setSolidFill(param1CTSolidColorFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties addNewSolidFill() {
/* 1503 */       return this.props.addNewSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetSolidFill() {
/* 1508 */       this.props.unsetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties getGradFill() {
/* 1513 */       return this.props.getGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGradFill() {
/* 1518 */       return this.props.isSetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGradFill(CTGradientFillProperties param1CTGradientFillProperties) {
/* 1523 */       this.props.setGradFill(param1CTGradientFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties addNewGradFill() {
/* 1528 */       return this.props.addNewGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGradFill() {
/* 1533 */       this.props.unsetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties getBlipFill() {
/* 1538 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetBlipFill() {
/* 1543 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties) {}
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties addNewBlipFill() {
/* 1551 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetBlipFill() {}
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties getPattFill() {
/* 1559 */       return this.props.getPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetPattFill() {
/* 1564 */       return this.props.isSetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setPattFill(CTPatternFillProperties param1CTPatternFillProperties) {
/* 1569 */       this.props.setPattFill(param1CTPatternFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties addNewPattFill() {
/* 1574 */       return this.props.addNewPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetPattFill() {
/* 1579 */       this.props.unsetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties getGrpFill() {
/* 1584 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGrpFill() {
/* 1589 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties) {}
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties addNewGrpFill() {
/* 1597 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGrpFill() {}
/*      */ 
/*      */     
/*      */     public boolean isSetMatrixStyle() {
/* 1605 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTStyleMatrixReference getMatrixStyle() {
/* 1610 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isLineStyle() {
/* 1615 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class TextCharDelegate implements XSLFFillProperties {
/*      */     final CTTextCharacterProperties props;
/*      */     
/*      */     TextCharDelegate(CTTextCharacterProperties param1CTTextCharacterProperties) {
/* 1623 */       this.props = param1CTTextCharacterProperties;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties getNoFill() {
/* 1628 */       return this.props.getNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetNoFill() {
/* 1633 */       return this.props.isSetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoFill(CTNoFillProperties param1CTNoFillProperties) {
/* 1638 */       this.props.setNoFill(param1CTNoFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTNoFillProperties addNewNoFill() {
/* 1643 */       return this.props.addNewNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetNoFill() {
/* 1648 */       this.props.unsetNoFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties getSolidFill() {
/* 1653 */       return this.props.getSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetSolidFill() {
/* 1658 */       return this.props.isSetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSolidFill(CTSolidColorFillProperties param1CTSolidColorFillProperties) {
/* 1663 */       this.props.setSolidFill(param1CTSolidColorFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTSolidColorFillProperties addNewSolidFill() {
/* 1668 */       return this.props.addNewSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetSolidFill() {
/* 1673 */       this.props.unsetSolidFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties getGradFill() {
/* 1678 */       return this.props.getGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGradFill() {
/* 1683 */       return this.props.isSetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGradFill(CTGradientFillProperties param1CTGradientFillProperties) {
/* 1688 */       this.props.setGradFill(param1CTGradientFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGradientFillProperties addNewGradFill() {
/* 1693 */       return this.props.addNewGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGradFill() {
/* 1698 */       this.props.unsetGradFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties getBlipFill() {
/* 1703 */       return this.props.getBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetBlipFill() {
/* 1708 */       return this.props.isSetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setBlipFill(CTBlipFillProperties param1CTBlipFillProperties) {
/* 1713 */       this.props.setBlipFill(param1CTBlipFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTBlipFillProperties addNewBlipFill() {
/* 1718 */       return this.props.addNewBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetBlipFill() {
/* 1723 */       this.props.unsetBlipFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties getPattFill() {
/* 1728 */       return this.props.getPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetPattFill() {
/* 1733 */       return this.props.isSetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setPattFill(CTPatternFillProperties param1CTPatternFillProperties) {
/* 1738 */       this.props.setPattFill(param1CTPatternFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTPatternFillProperties addNewPattFill() {
/* 1743 */       return this.props.addNewPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetPattFill() {
/* 1748 */       this.props.unsetPattFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties getGrpFill() {
/* 1753 */       return this.props.getGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetGrpFill() {
/* 1758 */       return this.props.isSetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void setGrpFill(CTGroupFillProperties param1CTGroupFillProperties) {
/* 1763 */       this.props.setGrpFill(param1CTGroupFillProperties);
/*      */     }
/*      */ 
/*      */     
/*      */     public CTGroupFillProperties addNewGrpFill() {
/* 1768 */       return this.props.addNewGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public void unsetGrpFill() {
/* 1773 */       this.props.unsetGrpFill();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSetMatrixStyle() {
/* 1778 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public CTStyleMatrixReference getMatrixStyle() {
/* 1783 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isLineStyle() {
/* 1788 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private static <T> T getDelegate(Class<T> paramClass, XmlObject paramXmlObject) {
/*      */     TextCharDelegate textCharDelegate;
/* 1794 */     ShapeDelegate shapeDelegate = null;
/* 1795 */     if (paramXmlObject == null)
/* 1796 */       return null; 
/* 1797 */     if (paramXmlObject instanceof CTShapeProperties) {
/* 1798 */       shapeDelegate = new ShapeDelegate((CTShapeProperties)paramXmlObject);
/* 1799 */     } else if (paramXmlObject instanceof CTBackgroundProperties) {
/* 1800 */       BackgroundDelegate backgroundDelegate = new BackgroundDelegate((CTBackgroundProperties)paramXmlObject);
/* 1801 */     } else if (paramXmlObject instanceof CTStyleMatrixReference) {
/* 1802 */       StyleMatrixDelegate styleMatrixDelegate = new StyleMatrixDelegate((CTStyleMatrixReference)paramXmlObject);
/* 1803 */     } else if (paramXmlObject instanceof CTTableCellProperties) {
/* 1804 */       TableCellDelegate tableCellDelegate = new TableCellDelegate((CTTableCellProperties)paramXmlObject);
/* 1805 */     } else if (paramXmlObject instanceof CTNoFillProperties || paramXmlObject instanceof CTSolidColorFillProperties || paramXmlObject instanceof CTGradientFillProperties || paramXmlObject instanceof CTBlipFillProperties || paramXmlObject instanceof CTPatternFillProperties || paramXmlObject instanceof CTGroupFillProperties) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1811 */       FillPartDelegate fillPartDelegate = new FillPartDelegate(paramXmlObject);
/* 1812 */     } else if (paramXmlObject instanceof CTFillProperties) {
/* 1813 */       FillDelegate fillDelegate = new FillDelegate((CTFillProperties)paramXmlObject);
/* 1814 */     } else if (paramXmlObject instanceof CTLineProperties) {
/* 1815 */       LineStyleDelegate lineStyleDelegate = new LineStyleDelegate((CTLineProperties)paramXmlObject);
/* 1816 */     } else if (paramXmlObject instanceof CTTextCharacterProperties) {
/* 1817 */       textCharDelegate = new TextCharDelegate((CTTextCharacterProperties)paramXmlObject);
/*      */     } else {
/* 1819 */       LOG.log(7, new Object[] { paramXmlObject.getClass().toString() + " is an unknown properties type" });
/* 1820 */       return null;
/*      */     } 
/*      */     
/* 1823 */     if (paramClass.isInstance(textCharDelegate)) {
/* 1824 */       return (T)textCharDelegate;
/*      */     }
/*      */     
/* 1827 */     LOG.log(5, new Object[] { textCharDelegate.getClass().toString() + " doesn't implement " + paramClass.toString() });
/* 1828 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFPropertiesDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */