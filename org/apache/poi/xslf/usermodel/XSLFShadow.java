/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.apache.poi.sl.draw.DrawPaint;
/*     */ import org.apache.poi.sl.usermodel.PaintStyle;
/*     */ import org.apache.poi.sl.usermodel.Shadow;
/*     */ import org.apache.poi.sl.usermodel.SimpleShape;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
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
/*     */ public class XSLFShadow
/*     */   extends XSLFShape
/*     */   implements Shadow<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   private XSLFSimpleShape _parent;
/*     */   
/*     */   XSLFShadow(CTOuterShadowEffect paramCTOuterShadowEffect, XSLFSimpleShape paramXSLFSimpleShape) {
/*  40 */     super((XmlObject)paramCTOuterShadowEffect, paramXSLFSimpleShape.getSheet());
/*     */     
/*  42 */     this._parent = paramXSLFSimpleShape;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFSimpleShape getShadowParent() {
/*  47 */     return this._parent;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle2D getAnchor() {
/*  52 */     return this._parent.getAnchor();
/*     */   }
/*     */   
/*     */   public void setAnchor(Rectangle2D paramRectangle2D) {
/*  56 */     throw new IllegalStateException("You can't set anchor of a shadow");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getDistance() {
/*  63 */     CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect)getXmlObject();
/*  64 */     return cTOuterShadowEffect.isSetDist() ? Units.toPoints(cTOuterShadowEffect.getDist()) : 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getAngle() {
/*  72 */     CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect)getXmlObject();
/*  73 */     return cTOuterShadowEffect.isSetDir() ? (cTOuterShadowEffect.getDir() / 60000.0D) : 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getBlur() {
/*  82 */     CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect)getXmlObject();
/*  83 */     return cTOuterShadowEffect.isSetBlurRad() ? Units.toPoints(cTOuterShadowEffect.getBlurRad()) : 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getFillColor() {
/*  91 */     PaintStyle.SolidPaint solidPaint = getFillStyle();
/*  92 */     if (solidPaint == null) return null; 
/*  93 */     return DrawPaint.applyColorTransform(solidPaint.getSolidColor());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PaintStyle.SolidPaint getFillStyle() {
/*  99 */     XSLFTheme xSLFTheme = getSheet().getTheme();
/* 100 */     CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect)getXmlObject();
/* 101 */     if (cTOuterShadowEffect == null) return null;
/*     */     
/* 103 */     CTSchemeColor cTSchemeColor = cTOuterShadowEffect.getSchemeClr();
/* 104 */     XSLFColor xSLFColor = new XSLFColor((XmlObject)cTOuterShadowEffect, xSLFTheme, cTSchemeColor);
/* 105 */     return DrawPaint.createSolidPaint(xSLFColor.getColorStyle());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */