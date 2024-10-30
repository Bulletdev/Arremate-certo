/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.LinearGradientPaint;
/*     */ import java.awt.MultipleGradientPaint;
/*     */ import java.awt.Paint;
/*     */ import java.awt.PaintContext;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Area;
/*     */ import java.awt.geom.IllegalPathStateException;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.ColorModel;
/*     */ import java.awt.image.Raster;
/*     */ import java.awt.image.WritableRaster;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PathGradientPaint
/*     */   implements Paint
/*     */ {
/*     */   protected final Color[] colors;
/*     */   protected final float[] fractions;
/*     */   protected final int capStyle;
/*     */   protected final int joinStyle;
/*     */   protected final int transparency;
/*     */   
/*     */   public PathGradientPaint(Color[] paramArrayOfColor, float[] paramArrayOffloat) {
/*  37 */     this(paramArrayOfColor, paramArrayOffloat, 1, 1);
/*     */   }
/*     */   
/*     */   public PathGradientPaint(Color[] paramArrayOfColor, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  41 */     this.colors = (Color[])paramArrayOfColor.clone();
/*  42 */     this.fractions = (float[])paramArrayOffloat.clone();
/*  43 */     this.capStyle = paramInt1;
/*  44 */     this.joinStyle = paramInt2;
/*     */ 
/*     */     
/*  47 */     boolean bool = true;
/*  48 */     for (Color color : paramArrayOfColor) {
/*  49 */       if (color != null) {
/*  50 */         bool = (bool && color.getAlpha() == 255) ? true : false;
/*     */       }
/*     */     } 
/*  53 */     this.transparency = bool ? 1 : 3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PaintContext createContext(ColorModel paramColorModel, Rectangle paramRectangle, Rectangle2D paramRectangle2D, AffineTransform paramAffineTransform, RenderingHints paramRenderingHints) {
/*  61 */     return new PathGradientContext(paramColorModel, paramRectangle, paramRectangle2D, paramAffineTransform, paramRenderingHints);
/*     */   }
/*     */   
/*     */   public int getTransparency() {
/*  65 */     return this.transparency;
/*     */   }
/*     */ 
/*     */   
/*     */   class PathGradientContext
/*     */     implements PaintContext
/*     */   {
/*     */     protected final Rectangle deviceBounds;
/*     */     
/*     */     protected final Rectangle2D userBounds;
/*     */     
/*     */     protected final AffineTransform xform;
/*     */     
/*     */     protected final RenderingHints hints;
/*     */     
/*     */     protected final Shape shape;
/*     */     
/*     */     protected final PaintContext pCtx;
/*     */     
/*     */     protected final int gradientSteps;
/*     */     
/*     */     WritableRaster raster;
/*     */ 
/*     */     
/*     */     public PathGradientContext(ColorModel param1ColorModel, Rectangle param1Rectangle, Rectangle2D param1Rectangle2D, AffineTransform param1AffineTransform, RenderingHints param1RenderingHints) {
/*  90 */       this.shape = (Shape)param1RenderingHints.get(Drawable.GRADIENT_SHAPE);
/*  91 */       if (this.shape == null) {
/*  92 */         throw new IllegalPathStateException("PathGradientPaint needs a shape to be set via the rendering hint Drawable.GRADIANT_SHAPE.");
/*     */       }
/*     */       
/*  95 */       this.deviceBounds = param1Rectangle;
/*  96 */       this.userBounds = param1Rectangle2D;
/*  97 */       this.xform = param1AffineTransform;
/*  98 */       this.hints = param1RenderingHints;
/*     */       
/* 100 */       this.gradientSteps = getGradientSteps(this.shape);
/*     */       
/* 102 */       Point2D.Double double_1 = new Point2D.Double(0.0D, 0.0D);
/* 103 */       Point2D.Double double_2 = new Point2D.Double(this.gradientSteps, 0.0D);
/* 104 */       LinearGradientPaint linearGradientPaint = new LinearGradientPaint(double_1, double_2, PathGradientPaint.this.fractions, PathGradientPaint.this.colors, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform());
/*     */       
/* 106 */       Rectangle rectangle = new Rectangle(0, 0, this.gradientSteps, 1);
/* 107 */       this.pCtx = linearGradientPaint.createContext(param1ColorModel, rectangle, rectangle, new AffineTransform(), param1RenderingHints);
/*     */     }
/*     */     
/*     */     public void dispose() {}
/*     */     
/*     */     public ColorModel getColorModel() {
/* 113 */       return this.pCtx.getColorModel();
/*     */     }
/*     */     
/*     */     public Raster getRaster(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 117 */       ColorModel colorModel = getColorModel();
/* 118 */       if (this.raster == null) createRaster();
/*     */ 
/*     */       
/* 121 */       WritableRaster writableRaster = colorModel.createCompatibleWritableRaster(param1Int3, param1Int4);
/* 122 */       Rectangle2D.Double double_1 = new Rectangle2D.Double(param1Int1, param1Int2, param1Int3, param1Int4);
/* 123 */       if (!double_1.intersects(this.deviceBounds))
/*     */       {
/* 125 */         return writableRaster;
/*     */       }
/*     */       
/* 128 */       Rectangle2D.Double double_2 = new Rectangle2D.Double();
/* 129 */       Rectangle2D.intersect(double_1, this.deviceBounds, double_2);
/* 130 */       int i = (int)(double_2.getX() - this.deviceBounds.getX());
/* 131 */       int j = (int)(double_2.getY() - this.deviceBounds.getY());
/* 132 */       int k = (int)double_2.getWidth();
/* 133 */       int m = (int)double_2.getHeight();
/* 134 */       Object object = this.raster.getDataElements(i, j, k, m, null);
/* 135 */       i = (int)(double_2.getX() - double_1.getX());
/* 136 */       j = (int)(double_2.getY() - double_1.getY());
/* 137 */       writableRaster.setDataElements(i, j, k, m, object);
/*     */       
/* 139 */       return writableRaster;
/*     */     }
/*     */     
/*     */     protected int getGradientSteps(Shape param1Shape) {
/* 143 */       Rectangle rectangle = param1Shape.getBounds();
/* 144 */       int i = 1;
/* 145 */       int j = (int)(Math.max(rectangle.getWidth(), rectangle.getHeight()) / 2.0D);
/* 146 */       while (i < j - 1) {
/* 147 */         int k = i + (j - i) / 2;
/* 148 */         BasicStroke basicStroke = new BasicStroke(k, PathGradientPaint.this.capStyle, PathGradientPaint.this.joinStyle);
/* 149 */         Area area = new Area(basicStroke.createStrokedShape(param1Shape));
/* 150 */         if (area.isSingular()) {
/* 151 */           j = k; continue;
/*     */         } 
/* 153 */         i = k;
/*     */       } 
/*     */       
/* 156 */       return j;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void createRaster() {
/* 162 */       ColorModel colorModel = getColorModel();
/* 163 */       this.raster = colorModel.createCompatibleWritableRaster((int)this.deviceBounds.getWidth(), (int)this.deviceBounds.getHeight());
/* 164 */       BufferedImage bufferedImage = new BufferedImage(colorModel, this.raster, false, null);
/* 165 */       Graphics2D graphics2D = bufferedImage.createGraphics();
/* 166 */       graphics2D.setRenderingHints(this.hints);
/* 167 */       graphics2D.translate(-this.deviceBounds.getX(), -this.deviceBounds.getY());
/* 168 */       graphics2D.transform(this.xform);
/*     */       
/* 170 */       Raster raster = this.pCtx.getRaster(0, 0, this.gradientSteps, 1);
/* 171 */       int[] arrayOfInt = new int[colorModel.getNumComponents()];
/*     */       
/* 173 */       for (int i = this.gradientSteps - 1; i >= 0; i--) {
/* 174 */         raster.getPixel(i, 0, arrayOfInt);
/* 175 */         Color color = new Color(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]);
/* 176 */         if (arrayOfInt.length == 4)
/*     */         {
/* 178 */           graphics2D.setComposite(AlphaComposite.getInstance(2, arrayOfInt[3] / 255.0F));
/*     */         }
/* 180 */         graphics2D.setStroke(new BasicStroke((i + 1), PathGradientPaint.this.capStyle, PathGradientPaint.this.joinStyle));
/* 181 */         graphics2D.setColor(color);
/* 182 */         graphics2D.draw(this.shape);
/*     */       } 
/*     */       
/* 185 */       graphics2D.dispose();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\PathGradientPaint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */