/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.LinearGradientPaint;
/*     */ import java.awt.MultipleGradientPaint;
/*     */ import java.awt.Paint;
/*     */ import java.awt.RadialGradientPaint;
/*     */ import java.awt.TexturePaint;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.sl.usermodel.ColorStyle;
/*     */ import org.apache.poi.sl.usermodel.PaintStyle;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DrawPaint
/*     */ {
/*  53 */   private static final POILogger LOG = POILogFactory.getLogger(DrawPaint.class);
/*     */   
/*  55 */   private static final Color TRANSPARENT = new Color(1.0F, 1.0F, 1.0F, 0.0F);
/*     */   
/*     */   protected PlaceableShape<?, ?> shape;
/*     */   
/*     */   public DrawPaint(PlaceableShape<?, ?> paramPlaceableShape) {
/*  60 */     this.shape = paramPlaceableShape;
/*     */   }
/*     */   
/*     */   private static class SimpleSolidPaint implements PaintStyle.SolidPaint {
/*     */     private final ColorStyle solidColor;
/*     */     
/*     */     SimpleSolidPaint(final Color color) {
/*  67 */       if (color == null) {
/*  68 */         throw new NullPointerException("Color needs to be specified");
/*     */       }
/*  70 */       this.solidColor = new ColorStyle() {
/*     */           public Color getColor() {
/*  72 */             return new Color(color.getRed(), color.getGreen(), color.getBlue());
/*     */           }
/*  74 */           public int getAlpha() { return (int)Math.round(color.getAlpha() * 100000.0D / 255.0D); }
/*  75 */           public int getHueOff() { return -1; }
/*  76 */           public int getHueMod() { return -1; }
/*  77 */           public int getSatOff() { return -1; }
/*  78 */           public int getSatMod() { return -1; }
/*  79 */           public int getLumOff() { return -1; }
/*  80 */           public int getLumMod() { return -1; }
/*  81 */           public int getShade() { return -1; } public int getTint() {
/*  82 */             return -1;
/*     */           }
/*     */         };
/*     */     }
/*     */     SimpleSolidPaint(ColorStyle param1ColorStyle) {
/*  87 */       if (param1ColorStyle == null) {
/*  88 */         throw new NullPointerException("Color needs to be specified");
/*     */       }
/*  90 */       this.solidColor = param1ColorStyle;
/*     */     }
/*     */     
/*     */     public ColorStyle getSolidColor() {
/*  94 */       return this.solidColor;
/*     */     }
/*     */   }
/*     */   
/*     */   public static PaintStyle.SolidPaint createSolidPaint(Color paramColor) {
/*  99 */     return (paramColor == null) ? null : new SimpleSolidPaint(paramColor);
/*     */   }
/*     */   
/*     */   public static PaintStyle.SolidPaint createSolidPaint(ColorStyle paramColorStyle) {
/* 103 */     return (paramColorStyle == null) ? null : new SimpleSolidPaint(paramColorStyle);
/*     */   }
/*     */   
/*     */   public Paint getPaint(Graphics2D paramGraphics2D, PaintStyle paramPaintStyle) {
/* 107 */     if (paramPaintStyle instanceof PaintStyle.SolidPaint)
/* 108 */       return getSolidPaint((PaintStyle.SolidPaint)paramPaintStyle, paramGraphics2D); 
/* 109 */     if (paramPaintStyle instanceof PaintStyle.GradientPaint)
/* 110 */       return getGradientPaint((PaintStyle.GradientPaint)paramPaintStyle, paramGraphics2D); 
/* 111 */     if (paramPaintStyle instanceof PaintStyle.TexturePaint) {
/* 112 */       return getTexturePaint((PaintStyle.TexturePaint)paramPaintStyle, paramGraphics2D);
/*     */     }
/* 114 */     return null;
/*     */   }
/*     */   
/*     */   protected Paint getSolidPaint(PaintStyle.SolidPaint paramSolidPaint, Graphics2D paramGraphics2D) {
/* 118 */     return applyColorTransform(paramSolidPaint.getSolidColor());
/*     */   }
/*     */   
/*     */   protected Paint getGradientPaint(PaintStyle.GradientPaint paramGradientPaint, Graphics2D paramGraphics2D) {
/* 122 */     switch (paramGradientPaint.getGradientType()) {
/*     */       case linear:
/* 124 */         return createLinearGradientPaint(paramGradientPaint, paramGraphics2D);
/*     */       case circular:
/* 126 */         return createRadialGradientPaint(paramGradientPaint, paramGraphics2D);
/*     */       case shape:
/* 128 */         return createPathGradientPaint(paramGradientPaint, paramGraphics2D);
/*     */     } 
/* 130 */     throw new UnsupportedOperationException("gradient fill of type " + paramGradientPaint + " not supported.");
/*     */   }
/*     */   
/*     */   protected Paint getTexturePaint(PaintStyle.TexturePaint paramTexturePaint, Graphics2D paramGraphics2D) {
/*     */     BufferedImage bufferedImage;
/* 135 */     InputStream inputStream = paramTexturePaint.getImageData();
/* 136 */     if (inputStream == null) return null; 
/* 137 */     assert paramGraphics2D != null;
/*     */     
/* 139 */     ImageRenderer imageRenderer = DrawPictureShape.getImageRenderer(paramGraphics2D, paramTexturePaint.getContentType());
/*     */     
/*     */     try {
/*     */       try {
/* 143 */         imageRenderer.loadImage(inputStream, paramTexturePaint.getContentType());
/*     */       } finally {
/* 145 */         inputStream.close();
/*     */       } 
/* 147 */     } catch (IOException iOException) {
/* 148 */       LOG.log(7, new Object[] { "Can't load image data - using transparent color", iOException });
/* 149 */       return null;
/*     */     } 
/*     */     
/* 152 */     int i = paramTexturePaint.getAlpha();
/* 153 */     if (0 <= i && i < 100000) {
/* 154 */       imageRenderer.setAlpha((i / 100000.0F));
/*     */     }
/*     */     
/* 157 */     Rectangle2D rectangle2D = this.shape.getAnchor();
/*     */     
/* 159 */     if ("image/x-wmf".equals(paramTexturePaint.getContentType())) {
/*     */ 
/*     */       
/* 162 */       bufferedImage = imageRenderer.getImage(new Dimension((int)rectangle2D.getWidth(), (int)rectangle2D.getHeight()));
/*     */     } else {
/* 164 */       bufferedImage = imageRenderer.getImage();
/*     */     } 
/*     */     
/* 167 */     if (bufferedImage == null) {
/* 168 */       LOG.log(7, new Object[] { "Can't load image data" });
/* 169 */       return null;
/*     */     } 
/* 171 */     return new TexturePaint(bufferedImage, rectangle2D);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color applyColorTransform(ColorStyle paramColorStyle) {
/* 186 */     if (paramColorStyle == null || paramColorStyle.getColor() == null) {
/* 187 */       return TRANSPARENT;
/*     */     }
/*     */     
/* 190 */     Color color = paramColorStyle.getColor();
/*     */     
/* 192 */     double d = getAlpha(color, paramColorStyle);
/* 193 */     double[] arrayOfDouble = RGB2HSL(color);
/* 194 */     applyHslModOff(arrayOfDouble, 0, paramColorStyle.getHueMod(), paramColorStyle.getHueOff());
/* 195 */     applyHslModOff(arrayOfDouble, 1, paramColorStyle.getSatMod(), paramColorStyle.getSatOff());
/* 196 */     applyHslModOff(arrayOfDouble, 2, paramColorStyle.getLumMod(), paramColorStyle.getLumOff());
/* 197 */     applyShade(arrayOfDouble, paramColorStyle);
/* 198 */     applyTint(arrayOfDouble, paramColorStyle);
/*     */     
/* 200 */     color = HSL2RGB(arrayOfDouble[0], arrayOfDouble[1], arrayOfDouble[2], d);
/*     */     
/* 202 */     return color;
/*     */   }
/*     */   
/*     */   private static double getAlpha(Color paramColor, ColorStyle paramColorStyle) {
/* 206 */     double d = paramColor.getAlpha() / 255.0D;
/* 207 */     int i = paramColorStyle.getAlpha();
/* 208 */     if (i != -1) {
/* 209 */       d *= i / 100000.0D;
/*     */     }
/* 211 */     return Math.min(1.0D, Math.max(0.0D, d));
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
/*     */   private static void applyHslModOff(double[] paramArrayOfdouble, int paramInt1, int paramInt2, int paramInt3) {
/* 240 */     if (paramInt2 == -1) paramInt2 = 100000; 
/* 241 */     if (paramInt3 == -1) paramInt3 = 0; 
/* 242 */     if (paramInt2 != 100000 || paramInt3 != 0) {
/* 243 */       double d1 = paramInt3 / 1000.0D;
/* 244 */       double d2 = paramInt2 / 100000.0D;
/* 245 */       paramArrayOfdouble[paramInt1] = paramArrayOfdouble[paramInt1] * d2 + d1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void applyShade(double[] paramArrayOfdouble, ColorStyle paramColorStyle) {
/* 255 */     int i = paramColorStyle.getShade();
/* 256 */     if (i == -1)
/*     */       return; 
/* 258 */     double d = i / 100000.0D;
/*     */     
/* 260 */     paramArrayOfdouble[2] = paramArrayOfdouble[2] * d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void applyTint(double[] paramArrayOfdouble, ColorStyle paramColorStyle) {
/* 270 */     int i = paramColorStyle.getTint();
/* 271 */     if (i == -1)
/*     */       return; 
/* 273 */     double d = (i / 100000.0F);
/*     */     
/* 275 */     paramArrayOfdouble[2] = paramArrayOfdouble[2] * d + 100.0D - d * 100.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Paint createLinearGradientPaint(PaintStyle.GradientPaint paramGradientPaint, Graphics2D paramGraphics2D) {
/* 280 */     double d1 = paramGradientPaint.getGradientAngle();
/* 281 */     Rectangle2D rectangle2D = DrawShape.getAnchor(paramGraphics2D, this.shape);
/*     */     
/* 283 */     AffineTransform affineTransform1 = AffineTransform.getRotateInstance(Math.toRadians(d1), rectangle2D.getX() + rectangle2D.getWidth() / 2.0D, rectangle2D.getY() + rectangle2D.getHeight() / 2.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 288 */     double d2 = Math.sqrt(rectangle2D.getHeight() * rectangle2D.getHeight() + rectangle2D.getWidth() * rectangle2D.getWidth());
/* 289 */     Point2D.Double double_1 = new Point2D.Double(rectangle2D.getX() + rectangle2D.getWidth() / 2.0D - d2 / 2.0D, rectangle2D.getY() + rectangle2D.getHeight() / 2.0D);
/*     */     
/* 291 */     Point2D point2D1 = affineTransform1.transform(double_1, null);
/*     */     
/* 293 */     Point2D.Double double_2 = new Point2D.Double(rectangle2D.getX() + rectangle2D.getWidth(), rectangle2D.getY() + rectangle2D.getHeight() / 2.0D);
/* 294 */     Point2D point2D2 = affineTransform1.transform(double_2, null);
/*     */     
/* 296 */     snapToAnchor(point2D1, rectangle2D);
/* 297 */     snapToAnchor(point2D2, rectangle2D);
/*     */     
/* 299 */     if (point2D1.equals(point2D2))
/*     */     {
/* 301 */       return null;
/*     */     }
/*     */     
/* 304 */     float[] arrayOfFloat = paramGradientPaint.getGradientFractions();
/* 305 */     Color[] arrayOfColor = new Color[arrayOfFloat.length];
/*     */     
/* 307 */     byte b = 0;
/* 308 */     for (ColorStyle colorStyle : paramGradientPaint.getGradientColors())
/*     */     {
/* 310 */       arrayOfColor[b++] = (colorStyle == null) ? TRANSPARENT : applyColorTransform(colorStyle);
/*     */     }
/*     */     
/* 313 */     AffineTransform affineTransform2 = new AffineTransform();
/* 314 */     if (paramGradientPaint.isRotatedWithShape()) {
/* 315 */       double d = this.shape.getRotation();
/* 316 */       if (d != 0.0D) {
/* 317 */         double d3 = rectangle2D.getX() + rectangle2D.getWidth() / 2.0D;
/* 318 */         double d4 = rectangle2D.getY() + rectangle2D.getHeight() / 2.0D;
/*     */         
/* 320 */         affineTransform2.translate(d3, d4);
/* 321 */         affineTransform2.rotate(Math.toRadians(-d));
/* 322 */         affineTransform2.translate(-d3, -d4);
/*     */       } 
/*     */     } 
/*     */     
/* 326 */     return new LinearGradientPaint(point2D1, point2D2, arrayOfFloat, arrayOfColor, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, affineTransform2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Paint createRadialGradientPaint(PaintStyle.GradientPaint paramGradientPaint, Graphics2D paramGraphics2D) {
/* 331 */     Rectangle2D rectangle2D = DrawShape.getAnchor(paramGraphics2D, this.shape);
/*     */     
/* 333 */     Point2D.Double double_ = new Point2D.Double(rectangle2D.getX() + rectangle2D.getWidth() / 2.0D, rectangle2D.getY() + rectangle2D.getHeight() / 2.0D);
/*     */ 
/*     */     
/* 336 */     float f = (float)Math.max(rectangle2D.getWidth(), rectangle2D.getHeight());
/*     */     
/* 338 */     float[] arrayOfFloat = paramGradientPaint.getGradientFractions();
/* 339 */     Color[] arrayOfColor = new Color[arrayOfFloat.length];
/*     */     
/* 341 */     byte b = 0;
/* 342 */     for (ColorStyle colorStyle : paramGradientPaint.getGradientColors()) {
/* 343 */       arrayOfColor[b++] = applyColorTransform(colorStyle);
/*     */     }
/*     */     
/* 346 */     return new RadialGradientPaint(double_, f, arrayOfFloat, arrayOfColor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Paint createPathGradientPaint(PaintStyle.GradientPaint paramGradientPaint, Graphics2D paramGraphics2D) {
/* 352 */     float[] arrayOfFloat = paramGradientPaint.getGradientFractions();
/* 353 */     Color[] arrayOfColor = new Color[arrayOfFloat.length];
/*     */     
/* 355 */     byte b = 0;
/* 356 */     for (ColorStyle colorStyle : paramGradientPaint.getGradientColors()) {
/* 357 */       arrayOfColor[b++] = applyColorTransform(colorStyle);
/*     */     }
/*     */     
/* 360 */     return new PathGradientPaint(arrayOfColor, arrayOfFloat);
/*     */   }
/*     */   
/*     */   protected void snapToAnchor(Point2D paramPoint2D, Rectangle2D paramRectangle2D) {
/* 364 */     if (paramPoint2D.getX() < paramRectangle2D.getX()) {
/* 365 */       paramPoint2D.setLocation(paramRectangle2D.getX(), paramPoint2D.getY());
/* 366 */     } else if (paramPoint2D.getX() > paramRectangle2D.getX() + paramRectangle2D.getWidth()) {
/* 367 */       paramPoint2D.setLocation(paramRectangle2D.getX() + paramRectangle2D.getWidth(), paramPoint2D.getY());
/*     */     } 
/*     */     
/* 370 */     if (paramPoint2D.getY() < paramRectangle2D.getY()) {
/* 371 */       paramPoint2D.setLocation(paramPoint2D.getX(), paramRectangle2D.getY());
/* 372 */     } else if (paramPoint2D.getY() > paramRectangle2D.getY() + paramRectangle2D.getHeight()) {
/* 373 */       paramPoint2D.setLocation(paramPoint2D.getX(), paramRectangle2D.getY() + paramRectangle2D.getHeight());
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color HSL2RGB(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 390 */     paramDouble2 = Math.max(0.0D, Math.min(100.0D, paramDouble2));
/* 391 */     paramDouble3 = Math.max(0.0D, Math.min(100.0D, paramDouble3));
/*     */     
/* 393 */     if (paramDouble4 < 0.0D || paramDouble4 > 1.0D) {
/* 394 */       String str = "Color parameter outside of expected range - Alpha: " + paramDouble4;
/* 395 */       throw new IllegalArgumentException(str);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 400 */     paramDouble1 %= 360.0D;
/* 401 */     paramDouble1 /= 360.0D;
/* 402 */     paramDouble2 /= 100.0D;
/* 403 */     paramDouble3 /= 100.0D;
/*     */     
/* 405 */     double d1 = (paramDouble3 < 0.5D) ? (paramDouble3 * (1.0D + paramDouble2)) : (paramDouble3 + paramDouble2 - paramDouble2 * paramDouble3);
/*     */ 
/*     */ 
/*     */     
/* 409 */     double d2 = 2.0D * paramDouble3 - d1;
/*     */     
/* 411 */     double d3 = Math.max(0.0D, HUE2RGB(d2, d1, paramDouble1 + 0.3333333333333333D));
/* 412 */     double d4 = Math.max(0.0D, HUE2RGB(d2, d1, paramDouble1));
/* 413 */     double d5 = Math.max(0.0D, HUE2RGB(d2, d1, paramDouble1 - 0.3333333333333333D));
/*     */     
/* 415 */     d3 = Math.min(d3, 1.0D);
/* 416 */     d4 = Math.min(d4, 1.0D);
/* 417 */     d5 = Math.min(d5, 1.0D);
/*     */     
/* 419 */     return new Color((float)d3, (float)d4, (float)d5, (float)paramDouble4);
/*     */   }
/*     */   
/*     */   private static double HUE2RGB(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 423 */     if (paramDouble3 < 0.0D) paramDouble3++;
/*     */     
/* 425 */     if (paramDouble3 > 1.0D) paramDouble3--;
/*     */     
/* 427 */     if (6.0D * paramDouble3 < 1.0D) {
/* 428 */       return paramDouble1 + (paramDouble2 - paramDouble1) * 6.0D * paramDouble3;
/*     */     }
/*     */     
/* 431 */     if (2.0D * paramDouble3 < 1.0D) {
/* 432 */       return paramDouble2;
/*     */     }
/*     */     
/* 435 */     if (3.0D * paramDouble3 < 2.0D) {
/* 436 */       return paramDouble1 + (paramDouble2 - paramDouble1) * 6.0D * (0.6666666666666666D - paramDouble3);
/*     */     }
/*     */     
/* 439 */     return paramDouble1;
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
/*     */   
/*     */   private static double[] RGB2HSL(Color paramColor) {
/* 452 */     float[] arrayOfFloat = paramColor.getRGBColorComponents(null);
/* 453 */     double d1 = arrayOfFloat[0];
/* 454 */     double d2 = arrayOfFloat[1];
/* 455 */     double d3 = arrayOfFloat[2];
/*     */ 
/*     */ 
/*     */     
/* 459 */     double d4 = Math.min(d1, Math.min(d2, d3));
/* 460 */     double d5 = Math.max(d1, Math.max(d2, d3));
/*     */ 
/*     */ 
/*     */     
/* 464 */     double d6 = 0.0D;
/*     */     
/* 466 */     if (d5 == d4) {
/* 467 */       d6 = 0.0D;
/* 468 */     } else if (d5 == d1) {
/* 469 */       d6 = (60.0D * (d2 - d3) / (d5 - d4) + 360.0D) % 360.0D;
/* 470 */     } else if (d5 == d2) {
/* 471 */       d6 = 60.0D * (d3 - d1) / (d5 - d4) + 120.0D;
/* 472 */     } else if (d5 == d3) {
/* 473 */       d6 = 60.0D * (d1 - d2) / (d5 - d4) + 240.0D;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 478 */     double d7 = (d5 + d4) / 2.0D;
/*     */ 
/*     */ 
/*     */     
/* 482 */     double d8 = 0.0D;
/*     */     
/* 484 */     if (d5 == d4) {
/* 485 */       d8 = 0.0D;
/* 486 */     } else if (d7 <= 0.5D) {
/* 487 */       d8 = (d5 - d4) / (d5 + d4);
/*     */     } else {
/* 489 */       d8 = (d5 - d4) / (2.0D - d5 - d4);
/*     */     } 
/*     */     
/* 492 */     return new double[] { d6, d8 * 100.0D, d7 * 100.0D };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int srgb2lin(float paramFloat) {
/* 503 */     if (paramFloat <= 0.04045D) {
/* 504 */       return (int)Math.rint(100000.0D * paramFloat / 12.92D);
/*     */     }
/* 506 */     return (int)Math.rint(100000.0D * Math.pow((paramFloat + 0.055D) / 1.055D, 2.4D));
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
/*     */   public static float lin2srgb(int paramInt) {
/* 518 */     if (paramInt <= 0.0031308D) {
/* 519 */       return (float)(paramInt / 100000.0D * 12.92D);
/*     */     }
/* 521 */     return (float)(1.055D * Math.pow(paramInt / 100000.0D, 0.4166666666666667D) - 0.055D);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawPaint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */