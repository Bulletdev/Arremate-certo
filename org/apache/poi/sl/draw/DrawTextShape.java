/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.sl.usermodel.Insets2D;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.ShapeContainer;
/*     */ import org.apache.poi.sl.usermodel.SimpleShape;
/*     */ import org.apache.poi.sl.usermodel.TextParagraph;
/*     */ import org.apache.poi.sl.usermodel.TextShape;
/*     */ import org.apache.poi.sl.usermodel.VerticalAlignment;
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
/*     */ public class DrawTextShape
/*     */   extends DrawSimpleShape
/*     */ {
/*     */   public DrawTextShape(TextShape<?, ?> paramTextShape) {
/*  38 */     super((SimpleShape<?, ?>)paramTextShape);
/*     */   }
/*     */   
/*     */   public void drawContent(Graphics2D paramGraphics2D) {
/*     */     double d3, d4;
/*  43 */     DrawFactory.getInstance(paramGraphics2D).fixFonts(paramGraphics2D);
/*     */     
/*  45 */     TextShape<?, ?> textShape = getShape();
/*     */     
/*  47 */     Rectangle2D rectangle2D = DrawShape.getAnchor(paramGraphics2D, (PlaceableShape<?, ?>)textShape);
/*  48 */     Insets2D insets2D = textShape.getInsets();
/*  49 */     double d1 = rectangle2D.getX() + insets2D.left;
/*  50 */     double d2 = rectangle2D.getY();
/*     */ 
/*     */     
/*  53 */     AffineTransform affineTransform = paramGraphics2D.getTransform();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     boolean bool1 = textShape.getFlipVertical();
/*  61 */     boolean bool2 = textShape.getFlipHorizontal();
/*  62 */     ShapeContainer shapeContainer = textShape.getParent();
/*  63 */     while (shapeContainer instanceof PlaceableShape) {
/*  64 */       PlaceableShape placeableShape = (PlaceableShape)shapeContainer;
/*  65 */       bool1 ^= placeableShape.getFlipVertical();
/*  66 */       bool2 ^= placeableShape.getFlipHorizontal();
/*  67 */       shapeContainer = placeableShape.getParent();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  72 */     if (bool2 ^ bool1) {
/*  73 */       double d5 = rectangle2D.getX();
/*  74 */       double d6 = rectangle2D.getY();
/*  75 */       paramGraphics2D.translate(d5 + rectangle2D.getWidth(), d6);
/*  76 */       paramGraphics2D.scale(-1.0D, 1.0D);
/*  77 */       paramGraphics2D.translate(-d5, -d6);
/*     */     } 
/*     */     
/*  80 */     Double double_ = textShape.getTextRotation();
/*  81 */     if (double_ != null && double_.doubleValue() != 0.0D) {
/*  82 */       double d5 = rectangle2D.getCenterX();
/*  83 */       double d6 = rectangle2D.getCenterY();
/*  84 */       paramGraphics2D.translate(d5, d6);
/*  85 */       paramGraphics2D.rotate(Math.toRadians(double_.doubleValue()));
/*  86 */       paramGraphics2D.translate(-d5, -d6);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     switch (textShape.getVerticalAlignment()) {
/*     */       
/*     */       default:
/*  95 */         d2 += insets2D.top;
/*     */         break;
/*     */       case BOTTOM:
/*  98 */         d3 = getTextHeight(paramGraphics2D);
/*  99 */         d2 += rectangle2D.getHeight() - d3 - insets2D.bottom;
/*     */         break;
/*     */       case MIDDLE:
/* 102 */         d3 = getTextHeight(paramGraphics2D);
/* 103 */         d4 = rectangle2D.getHeight() - d3 - insets2D.top - insets2D.bottom;
/* 104 */         d2 += insets2D.top + d4 / 2.0D;
/*     */         break;
/*     */     } 
/*     */     
/* 108 */     TextShape.TextDirection textDirection = textShape.getTextDirection();
/* 109 */     if (textDirection == TextShape.TextDirection.VERTICAL || textDirection == TextShape.TextDirection.VERTICAL_270) {
/* 110 */       double d5 = (textDirection == TextShape.TextDirection.VERTICAL) ? 90.0D : 270.0D;
/* 111 */       double d6 = rectangle2D.getCenterX();
/* 112 */       double d7 = rectangle2D.getCenterY();
/* 113 */       paramGraphics2D.translate(d6, d7);
/* 114 */       paramGraphics2D.rotate(Math.toRadians(d5));
/* 115 */       paramGraphics2D.translate(-d6, -d7);
/*     */ 
/*     */ 
/*     */       
/* 119 */       double d8 = rectangle2D.getWidth();
/* 120 */       double d9 = rectangle2D.getHeight();
/* 121 */       double d10 = (d8 - d9) / 2.0D;
/* 122 */       paramGraphics2D.translate(d10, -d10);
/*     */     } 
/*     */     
/* 125 */     drawParagraphs(paramGraphics2D, d1, d2);
/*     */ 
/*     */     
/* 128 */     paramGraphics2D.setTransform(affineTransform);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double drawParagraphs(Graphics2D paramGraphics2D, double paramDouble1, double paramDouble2) {
/* 137 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/*     */     
/* 139 */     double d = paramDouble2;
/*     */     
/* 141 */     Iterator<TextParagraph> iterator = getShape().iterator();
/*     */ 
/*     */     
/* 144 */     boolean bool = true;
/* 145 */     for (int i = 0; iterator.hasNext(); i++) {
/* 146 */       TextParagraph<?, ?, ?> textParagraph = iterator.next();
/* 147 */       DrawTextParagraph drawTextParagraph = drawFactory.getDrawable(textParagraph);
/* 148 */       TextParagraph.BulletStyle bulletStyle = textParagraph.getBulletStyle();
/* 149 */       if (bulletStyle == null || bulletStyle.getAutoNumberingScheme() == null) {
/* 150 */         i = -1;
/*     */       } else {
/* 152 */         Integer integer = bulletStyle.getAutoNumberingStartAt();
/* 153 */         if (integer == null) integer = Integer.valueOf(1);
/*     */         
/* 155 */         if (integer.intValue() > i) i = integer.intValue(); 
/*     */       } 
/* 157 */       drawTextParagraph.setAutoNumberingIdx(i);
/* 158 */       drawTextParagraph.breakText(paramGraphics2D);
/*     */       
/* 160 */       if (!bool) {
/*     */         
/* 162 */         Double double_ = textParagraph.getSpaceBefore();
/* 163 */         if (double_ == null) double_ = Double.valueOf(0.0D); 
/* 164 */         if (double_.doubleValue() > 0.0D) {
/*     */ 
/*     */           
/* 167 */           paramDouble2 += double_.doubleValue() * 0.01D * drawTextParagraph.getFirstLineHeight();
/*     */         } else {
/*     */           
/* 170 */           paramDouble2 += -double_.doubleValue();
/*     */         } 
/*     */       } 
/* 173 */       bool = false;
/*     */       
/* 175 */       drawTextParagraph.setPosition(paramDouble1, paramDouble2);
/* 176 */       drawTextParagraph.draw(paramGraphics2D);
/* 177 */       paramDouble2 += drawTextParagraph.getY();
/*     */       
/* 179 */       if (iterator.hasNext()) {
/* 180 */         Double double_ = textParagraph.getSpaceAfter();
/* 181 */         if (double_ == null) double_ = Double.valueOf(0.0D); 
/* 182 */         if (double_.doubleValue() > 0.0D) {
/*     */ 
/*     */           
/* 185 */           paramDouble2 += double_.doubleValue() * 0.01D * drawTextParagraph.getLastLineHeight();
/*     */         } else {
/*     */           
/* 188 */           paramDouble2 += -double_.doubleValue();
/*     */         } 
/*     */       } 
/*     */     } 
/* 192 */     return paramDouble2 - d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getTextHeight() {
/* 201 */     return getTextHeight(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getTextHeight(Graphics2D paramGraphics2D) {
/* 212 */     BufferedImage bufferedImage = new BufferedImage(1, 1, 1);
/* 213 */     Graphics2D graphics2D = bufferedImage.createGraphics();
/* 214 */     if (paramGraphics2D != null) {
/* 215 */       graphics2D.addRenderingHints(paramGraphics2D.getRenderingHints());
/* 216 */       graphics2D.setTransform(paramGraphics2D.getTransform());
/*     */     } 
/* 218 */     DrawFactory.getInstance(graphics2D).fixFonts(graphics2D);
/* 219 */     return drawParagraphs(graphics2D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected TextShape<?, ?> getShape() {
/* 224 */     return (TextShape<?, ?>)this.shape;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawTextShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */