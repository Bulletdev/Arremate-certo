/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.StrokeStyle;
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
/*     */ public class DrawShape
/*     */   implements Drawable
/*     */ {
/*     */   protected final Shape<?, ?> shape;
/*     */   
/*     */   public DrawShape(Shape<?, ?> paramShape) {
/*  38 */     this.shape = paramShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyTransform(Graphics2D paramGraphics2D) {
/*  47 */     if (!(this.shape instanceof PlaceableShape))
/*     */       return; 
/*  49 */     PlaceableShape placeableShape = (PlaceableShape)this.shape;
/*  50 */     AffineTransform affineTransform = (AffineTransform)paramGraphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM);
/*  51 */     if (affineTransform == null) affineTransform = new AffineTransform(); 
/*  52 */     Rectangle2D rectangle2D = affineTransform.createTransformedShape(placeableShape.getAnchor()).getBounds2D();
/*     */ 
/*     */     
/*  55 */     double d = placeableShape.getRotation();
/*  56 */     if (d != 0.0D) {
/*     */       
/*  58 */       double d1 = rectangle2D.getCenterX();
/*  59 */       double d2 = rectangle2D.getCenterY();
/*     */ 
/*     */       
/*  62 */       d %= 360.0D;
/*  63 */       if (d < 0.0D) d += 360.0D;
/*     */       
/*  65 */       int i = ((int)d + 45) / 90 % 4;
/*  66 */       double d3 = 1.0D, d4 = 1.0D;
/*     */ 
/*     */       
/*  69 */       if (i == 1 || i == 3) {
/*     */         AffineTransform affineTransform1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  80 */         if (placeableShape.getClass().getCanonicalName().toLowerCase(Locale.ROOT).contains("hslf")) {
/*  81 */           affineTransform1 = new AffineTransform(affineTransform);
/*     */         } else {
/*     */           
/*  84 */           affineTransform1 = new AffineTransform();
/*  85 */           affineTransform1.translate(d1, d2);
/*  86 */           affineTransform1.rotate(1.5707963267948966D);
/*  87 */           affineTransform1.translate(-d1, -d2);
/*  88 */           affineTransform1.concatenate(affineTransform);
/*     */         } 
/*     */         
/*  91 */         affineTransform1.translate(d1, d2);
/*  92 */         affineTransform1.rotate(1.5707963267948966D);
/*  93 */         affineTransform1.translate(-d1, -d2);
/*     */         
/*  95 */         Rectangle2D rectangle2D1 = affineTransform1.createTransformedShape(placeableShape.getAnchor()).getBounds2D();
/*     */         
/*  97 */         d3 = safeScale(rectangle2D.getWidth(), rectangle2D1.getWidth());
/*  98 */         d4 = safeScale(rectangle2D.getHeight(), rectangle2D1.getHeight());
/*     */       } else {
/* 100 */         i = 0;
/*     */       } 
/*     */ 
/*     */       
/* 104 */       paramGraphics2D.translate(d1, d2);
/* 105 */       double d5 = Math.toRadians(d - i * 90.0D);
/* 106 */       if (d5 != 0.0D) {
/* 107 */         paramGraphics2D.rotate(d5);
/*     */       }
/* 109 */       paramGraphics2D.scale(d3, d4);
/* 110 */       d5 = Math.toRadians((i * 90));
/* 111 */       if (d5 != 0.0D) {
/* 112 */         paramGraphics2D.rotate(d5);
/*     */       }
/* 114 */       paramGraphics2D.translate(-d1, -d2);
/*     */     } 
/*     */ 
/*     */     
/* 118 */     if (placeableShape.getFlipHorizontal()) {
/* 119 */       paramGraphics2D.translate(rectangle2D.getX() + rectangle2D.getWidth(), rectangle2D.getY());
/* 120 */       paramGraphics2D.scale(-1.0D, 1.0D);
/* 121 */       paramGraphics2D.translate(-rectangle2D.getX(), -rectangle2D.getY());
/*     */     } 
/*     */ 
/*     */     
/* 125 */     if (placeableShape.getFlipVertical()) {
/* 126 */       paramGraphics2D.translate(rectangle2D.getX(), rectangle2D.getY() + rectangle2D.getHeight());
/* 127 */       paramGraphics2D.scale(1.0D, -1.0D);
/* 128 */       paramGraphics2D.translate(-rectangle2D.getX(), -rectangle2D.getY());
/*     */     } 
/*     */   }
/*     */   
/*     */   private static double safeScale(double paramDouble1, double paramDouble2) {
/* 133 */     if (paramDouble1 == 0.0D) {
/* 134 */       return 1.0D;
/*     */     }
/* 136 */     return (paramDouble2 == 0.0D) ? 1.0D : (paramDouble1 / paramDouble2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D) {}
/*     */ 
/*     */   
/*     */   public void drawContent(Graphics2D paramGraphics2D) {}
/*     */   
/*     */   public static Rectangle2D getAnchor(Graphics2D paramGraphics2D, PlaceableShape<?, ?> paramPlaceableShape) {
/* 146 */     return getAnchor(paramGraphics2D, paramPlaceableShape.getAnchor());
/*     */   }
/*     */   
/*     */   public static Rectangle2D getAnchor(Graphics2D paramGraphics2D, Rectangle2D paramRectangle2D) {
/* 150 */     if (paramGraphics2D == null) {
/* 151 */       return paramRectangle2D;
/*     */     }
/*     */     
/* 154 */     AffineTransform affineTransform = (AffineTransform)paramGraphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM);
/* 155 */     if (affineTransform != null) {
/* 156 */       paramRectangle2D = affineTransform.createTransformedShape(paramRectangle2D).getBounds2D();
/*     */     }
/* 158 */     return paramRectangle2D;
/*     */   }
/*     */   
/*     */   protected Shape<?, ?> getShape() {
/* 162 */     return this.shape;
/*     */   }
/*     */   
/*     */   protected static BasicStroke getStroke(StrokeStyle paramStrokeStyle) {
/* 166 */     float f1 = (float)paramStrokeStyle.getLineWidth();
/* 167 */     if (f1 == 0.0F) f1 = 0.25F;
/*     */     
/* 169 */     StrokeStyle.LineDash lineDash = paramStrokeStyle.getLineDash();
/* 170 */     if (lineDash == null) {
/* 171 */       lineDash = StrokeStyle.LineDash.SOLID;
/*     */     }
/*     */     
/* 174 */     int[] arrayOfInt = lineDash.pattern;
/* 175 */     float f2 = 0.0F;
/* 176 */     float[] arrayOfFloat = null;
/* 177 */     if (arrayOfInt != null) {
/* 178 */       arrayOfFloat = new float[arrayOfInt.length];
/* 179 */       for (byte b1 = 0; b1 < arrayOfInt.length; b1++) {
/* 180 */         arrayOfFloat[b1] = arrayOfInt[b1] * Math.max(1.0F, f1);
/*     */       }
/*     */     } 
/*     */     
/* 184 */     StrokeStyle.LineCap lineCap = paramStrokeStyle.getLineCap();
/* 185 */     if (lineCap == null) lineCap = StrokeStyle.LineCap.FLAT;
/*     */     
/* 187 */     switch (lineCap)
/*     */     { case ROUND:
/* 189 */         b = 1;
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
/* 200 */         bool = true;
/*     */         
/* 202 */         return new BasicStroke(f1, b, bool, f1, arrayOfFloat, 0.0F);case SQUARE: b = 2; bool = true; return new BasicStroke(f1, b, bool, f1, arrayOfFloat, 0.0F); }  byte b = 0; boolean bool = true; return new BasicStroke(f1, b, bool, f1, arrayOfFloat, 0.0F);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */