/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.TextType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.impl.TextTypeImpl;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.TextLayout;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ public class XDGFText
/*     */ {
/*     */   TextType _text;
/*     */   XDGFShape _parent;
/*     */   
/*     */   public XDGFText(TextType paramTextType, XDGFShape paramXDGFShape) {
/*  40 */     this._text = paramTextType;
/*  41 */     this._parent = paramXDGFShape;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   TextType getXmlObject() {
/*  46 */     return this._text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextContent() {
/*  53 */     return ((TextTypeImpl)this._text).getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle2D.Double getTextBounds() {
/*  63 */     double d1 = this._parent.getTxtPinX().doubleValue();
/*  64 */     double d2 = this._parent.getTxtPinY().doubleValue();
/*     */     
/*  66 */     double d3 = this._parent.getTxtLocPinX().doubleValue();
/*  67 */     double d4 = this._parent.getTxtLocPinY().doubleValue();
/*     */     
/*  69 */     double d5 = this._parent.getTxtWidth().doubleValue();
/*  70 */     double d6 = this._parent.getTxtHeight().doubleValue();
/*     */     
/*  72 */     double d7 = d1 - d3;
/*  73 */     double d8 = d2 - d4;
/*     */     
/*  75 */     return new Rectangle2D.Double(d7, d8, d5, d6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path2D.Double getBoundsAsPath() {
/*  84 */     Rectangle2D.Double double_ = getTextBounds();
/*  85 */     Double double_1 = Double.valueOf(double_.getWidth());
/*  86 */     Double double_2 = Double.valueOf(double_.getHeight());
/*     */     
/*  88 */     Path2D.Double double_3 = new Path2D.Double();
/*  89 */     double_3.moveTo(0.0D, 0.0D);
/*  90 */     double_3.lineTo(double_1.doubleValue(), 0.0D);
/*  91 */     double_3.lineTo(double_1.doubleValue(), double_2.doubleValue());
/*  92 */     double_3.lineTo(0.0D, double_2.doubleValue());
/*  93 */     double_3.lineTo(0.0D, 0.0D);
/*     */     
/*  95 */     return double_3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Point2D.Double getTextCenter() {
/* 102 */     return new Point2D.Double(this._parent.getTxtLocPinX().doubleValue(), this._parent.getTxtLocPinY().doubleValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D) {
/* 112 */     String str = getTextContent();
/* 113 */     if (str.length() == 0) {
/*     */       return;
/*     */     }
/* 116 */     Rectangle2D.Double double_ = getTextBounds();
/*     */     
/* 118 */     String[] arrayOfString = str.trim().split("\n");
/* 119 */     FontRenderContext fontRenderContext = paramGraphics2D.getFontRenderContext();
/* 120 */     Font font = paramGraphics2D.getFont();
/*     */     
/* 122 */     AffineTransform affineTransform = paramGraphics2D.getTransform();
/*     */ 
/*     */ 
/*     */     
/* 126 */     Boolean bool1 = this._parent.getFlipX();
/* 127 */     Boolean bool2 = this._parent.getFlipY();
/*     */     
/* 129 */     if (bool2 == null || !this._parent.getFlipY().booleanValue()) {
/* 130 */       paramGraphics2D.translate(double_.x, double_.y);
/* 131 */       paramGraphics2D.scale(1.0D, -1.0D);
/* 132 */       paramGraphics2D.translate(0.0D, -double_.height + paramGraphics2D.getFontMetrics().getMaxCharBounds(paramGraphics2D).getHeight());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 137 */     if (bool1 != null && this._parent.getFlipX().booleanValue()) {
/* 138 */       paramGraphics2D.scale(-1.0D, 1.0D);
/* 139 */       paramGraphics2D.translate(-double_.width, 0.0D);
/*     */     } 
/*     */     
/* 142 */     Double double_1 = this._parent.getTxtAngle();
/* 143 */     if (double_1 != null && Math.abs(double_1.doubleValue()) > 0.01D) {
/* 144 */       paramGraphics2D.rotate(double_1.doubleValue());
/*     */     }
/* 146 */     float f = 0.0F;
/* 147 */     for (String str1 : arrayOfString) {
/*     */       
/* 149 */       if (str1.length() != 0) {
/*     */ 
/*     */         
/* 152 */         TextLayout textLayout = new TextLayout(str1, font, fontRenderContext);
/*     */         
/* 154 */         if (textLayout.isLeftToRight()) {
/* 155 */           textLayout.draw(paramGraphics2D, 0.0F, f);
/*     */         } else {
/* 157 */           textLayout.draw(paramGraphics2D, (float)(double_.width - textLayout.getAdvance()), f);
/*     */         } 
/*     */         
/* 160 */         f += textLayout.getAscent() + textLayout.getDescent() + textLayout.getLeading();
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     paramGraphics2D.setTransform(affineTransform);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */