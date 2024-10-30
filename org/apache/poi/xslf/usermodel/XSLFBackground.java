/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.sl.usermodel.Background;
/*     */ import org.apache.poi.sl.usermodel.Placeholder;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFBackground
/*     */   extends XSLFSimpleShape
/*     */   implements Background<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   XSLFBackground(CTBackground paramCTBackground, XSLFSheet paramXSLFSheet) {
/*  40 */     super((XmlObject)paramCTBackground, paramXSLFSheet);
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle2D getAnchor() {
/*  45 */     Dimension dimension = getSheet().getSlideShow().getPageSize();
/*  46 */     return new Rectangle2D.Double(0.0D, 0.0D, dimension.getWidth(), dimension.getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CTTransform2D getXfrm(boolean paramBoolean) {
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlaceholder(Placeholder paramPlaceholder) {
/*  64 */     throw new POIXMLException("Can't set a placeholder for a background");
/*     */   }
/*     */   
/*     */   protected CTBackgroundProperties getBgPr(boolean paramBoolean) {
/*  68 */     CTBackground cTBackground = (CTBackground)getXmlObject();
/*  69 */     if (!cTBackground.isSetBgPr() && paramBoolean) {
/*  70 */       if (cTBackground.isSetBgRef()) {
/*  71 */         cTBackground.unsetBgRef();
/*     */       }
/*  73 */       return cTBackground.addNewBgPr();
/*     */     } 
/*  75 */     return cTBackground.getBgPr();
/*     */   }
/*     */   
/*     */   public void setFillColor(Color paramColor) {
/*  79 */     CTBackgroundProperties cTBackgroundProperties = getBgPr(true);
/*     */     
/*  81 */     if (paramColor == null) {
/*  82 */       if (cTBackgroundProperties.isSetSolidFill()) {
/*  83 */         cTBackgroundProperties.unsetSolidFill();
/*     */       }
/*     */       
/*  86 */       if (!cTBackgroundProperties.isSetNoFill()) {
/*  87 */         cTBackgroundProperties.addNewNoFill();
/*     */       }
/*     */     } else {
/*  90 */       if (cTBackgroundProperties.isSetNoFill()) {
/*  91 */         cTBackgroundProperties.unsetNoFill();
/*     */       }
/*     */       
/*  94 */       CTSolidColorFillProperties cTSolidColorFillProperties = cTBackgroundProperties.isSetSolidFill() ? cTBackgroundProperties.getSolidFill() : cTBackgroundProperties.addNewSolidFill();
/*     */       
/*  96 */       XSLFColor xSLFColor = new XSLFColor((XmlObject)cTSolidColorFillProperties, getSheet().getTheme(), cTSolidColorFillProperties.getSchemeClr());
/*  97 */       xSLFColor.setColor(paramColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected XmlObject getShapeProperties() {
/* 103 */     CTBackground cTBackground = (CTBackground)getXmlObject();
/* 104 */     if (cTBackground.isSetBgPr())
/* 105 */       return (XmlObject)cTBackground.getBgPr(); 
/* 106 */     if (cTBackground.isSetBgRef()) {
/* 107 */       return (XmlObject)cTBackground.getBgRef();
/*     */     }
/* 109 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */