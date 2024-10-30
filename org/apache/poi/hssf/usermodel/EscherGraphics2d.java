/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Composite;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.Image;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.Shape;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.GlyphVector;
/*     */ import java.awt.font.TextLayout;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Arc2D;
/*     */ import java.awt.geom.Area;
/*     */ import java.awt.geom.GeneralPath;
/*     */ import java.awt.geom.Line2D;
/*     */ import java.awt.geom.RoundRectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.BufferedImageOp;
/*     */ import java.awt.image.ImageObserver;
/*     */ import java.awt.image.RenderedImage;
/*     */ import java.awt.image.renderable.RenderableImage;
/*     */ import java.text.AttributedCharacterIterator;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EscherGraphics2d
/*     */   extends Graphics2D
/*     */ {
/*     */   private EscherGraphics _escherGraphics;
/*     */   private BufferedImage _img;
/*     */   private AffineTransform _trans;
/*     */   private Stroke _stroke;
/*     */   private Paint _paint;
/*     */   private Shape _deviceclip;
/*  78 */   private POILogger logger = POILogFactory.getLogger(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherGraphics2d(EscherGraphics paramEscherGraphics) {
/*  87 */     this._escherGraphics = paramEscherGraphics;
/*  88 */     setImg(new BufferedImage(1, 1, 2));
/*  89 */     setColor(Color.black);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRenderingHints(Map<?, ?> paramMap) {
/*  94 */     getG2D().addRenderingHints(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  99 */     Paint paint = getPaint();
/* 100 */     setColor(getBackground());
/* 101 */     fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
/* 102 */     setPaint(paint);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clip(Shape paramShape) {
/* 107 */     if (getDeviceclip() != null) {
/*     */       
/* 109 */       Area area = new Area(getClip());
/* 110 */       if (paramShape != null)
/* 111 */         area.intersect(new Area(paramShape)); 
/* 112 */       paramShape = area;
/*     */     } 
/* 114 */     setClip(paramShape);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 119 */     clip(new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 125 */     getG2D().copyArea(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics create() {
/* 130 */     return new EscherGraphics2d(this._escherGraphics);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 136 */     getEscherGraphics().dispose();
/* 137 */     getG2D().dispose();
/* 138 */     getImg().flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Shape paramShape) {
/* 143 */     if (paramShape instanceof Line2D) {
/*     */       
/* 145 */       Line2D line2D = (Line2D)paramShape;
/*     */       
/* 147 */       int i = 0;
/* 148 */       if (this._stroke != null && this._stroke instanceof BasicStroke) {
/* 149 */         i = (int)((BasicStroke)this._stroke).getLineWidth() * 12700;
/*     */       }
/*     */       
/* 152 */       drawLine((int)line2D.getX1(), (int)line2D.getY1(), (int)line2D.getX2(), (int)line2D.getY2(), i);
/*     */ 
/*     */     
/*     */     }
/* 156 */     else if (this.logger.check(5)) {
/* 157 */       this.logger.log(5, new Object[] { "draw not fully supported" });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 164 */     draw(new Arc2D.Float(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawGlyphVector(GlyphVector paramGlyphVector, float paramFloat1, float paramFloat2) {
/* 169 */     fill(paramGlyphVector.getOutline(paramFloat1, paramFloat2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Color paramColor, ImageObserver paramImageObserver) {
/* 175 */     if (this.logger.check(5))
/* 176 */       this.logger.log(5, new Object[] { "drawImage() not supported" }); 
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, ImageObserver paramImageObserver) {
/* 183 */     if (this.logger.check(5))
/* 184 */       this.logger.log(5, new Object[] { "drawImage() not supported" }); 
/* 185 */     return drawImage(paramImage, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, null, paramImageObserver);
/*     */   }
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, ImageObserver paramImageObserver) {
/* 189 */     if (this.logger.check(5))
/* 190 */       this.logger.log(5, new Object[] { "drawImage() not supported" }); 
/* 191 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageObserver paramImageObserver) {
/* 198 */     return drawImage(paramImage, paramInt1, paramInt2, paramInt3, paramInt4, null, paramImageObserver);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, Color paramColor, ImageObserver paramImageObserver) {
/* 203 */     return drawImage(paramImage, paramInt1, paramInt2, paramImage.getWidth(paramImageObserver), paramImage.getHeight(paramImageObserver), paramColor, paramImageObserver);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, ImageObserver paramImageObserver) {
/* 208 */     return drawImage(paramImage, paramInt1, paramInt2, paramImage.getWidth(paramImageObserver), paramImage.getHeight(paramImageObserver), paramImageObserver);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, AffineTransform paramAffineTransform, ImageObserver paramImageObserver) {
/* 213 */     AffineTransform affineTransform = (AffineTransform)getTrans().clone();
/* 214 */     getTrans().concatenate(paramAffineTransform);
/* 215 */     drawImage(paramImage, 0, 0, paramImageObserver);
/* 216 */     setTrans(affineTransform);
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawImage(BufferedImage paramBufferedImage, BufferedImageOp paramBufferedImageOp, int paramInt1, int paramInt2) {
/* 222 */     BufferedImage bufferedImage = paramBufferedImageOp.filter(paramBufferedImage, null);
/* 223 */     drawImage(bufferedImage, new AffineTransform(1.0F, 0.0F, 0.0F, 1.0F, paramInt1, paramInt2), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 228 */     getEscherGraphics().drawLine(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 233 */     int i = 0;
/* 234 */     if (this._stroke != null && this._stroke instanceof BasicStroke) {
/* 235 */       i = (int)((BasicStroke)this._stroke).getLineWidth() * 12700;
/*     */     }
/* 237 */     getEscherGraphics().drawLine(paramInt1, paramInt2, paramInt3, paramInt4, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawOval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 243 */     getEscherGraphics().drawOval(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawPolygon(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 250 */     getEscherGraphics().drawPolygon(paramArrayOfint1, paramArrayOfint2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPolyline(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 255 */     if (paramInt > 0) {
/*     */       
/* 257 */       GeneralPath generalPath = new GeneralPath();
/* 258 */       generalPath.moveTo(paramArrayOfint1[0], paramArrayOfint2[0]);
/* 259 */       for (byte b = 1; b < paramInt; b++) {
/* 260 */         generalPath.lineTo(paramArrayOfint1[b], paramArrayOfint2[b]);
/*     */       }
/* 262 */       draw(generalPath);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 268 */     this._escherGraphics.drawRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawRenderableImage(RenderableImage paramRenderableImage, AffineTransform paramAffineTransform) {
/* 273 */     drawRenderedImage(paramRenderableImage.createDefaultRendering(), paramAffineTransform);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawRenderedImage(RenderedImage paramRenderedImage, AffineTransform paramAffineTransform) {
/* 278 */     BufferedImage bufferedImage = new BufferedImage(paramRenderedImage.getColorModel(), paramRenderedImage.getData().createCompatibleWritableRaster(), false, null);
/* 279 */     bufferedImage.setData(paramRenderedImage.getData());
/* 280 */     drawImage(bufferedImage, paramAffineTransform, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 285 */     draw(new RoundRectangle2D.Float(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawString(String paramString, float paramFloat1, float paramFloat2) {
/* 290 */     getEscherGraphics().drawString(paramString, (int)paramFloat1, (int)paramFloat2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawString(String paramString, int paramInt1, int paramInt2) {
/* 295 */     getEscherGraphics().drawString(paramString, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawString(AttributedCharacterIterator paramAttributedCharacterIterator, float paramFloat1, float paramFloat2) {
/* 300 */     TextLayout textLayout = new TextLayout(paramAttributedCharacterIterator, getFontRenderContext());
/* 301 */     Paint paint = getPaint();
/* 302 */     setColor(getColor());
/* 303 */     fill(textLayout.getOutline(AffineTransform.getTranslateInstance(paramFloat1, paramFloat2)));
/* 304 */     setPaint(paint);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawString(AttributedCharacterIterator paramAttributedCharacterIterator, int paramInt1, int paramInt2) {
/* 309 */     getEscherGraphics().drawString(paramAttributedCharacterIterator, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(Shape paramShape) {
/* 314 */     if (this.logger.check(5)) {
/* 315 */       this.logger.log(5, new Object[] { "fill(Shape) not supported" });
/*     */     }
/*     */   }
/*     */   
/*     */   public void fillArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 320 */     fill(new Arc2D.Float(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 2));
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillOval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 325 */     this._escherGraphics.fillOval(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public void fillPolygon(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 349 */     this._escherGraphics.fillPolygon(paramArrayOfint1, paramArrayOfint2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 354 */     getEscherGraphics().fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 360 */     fill(new RoundRectangle2D.Float(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getBackground() {
/* 365 */     return getEscherGraphics().getBackground();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Shape getClip() {
/*     */     try {
/* 372 */       return getTrans().createInverse().createTransformedShape(getDeviceclip());
/*     */     }
/* 374 */     catch (Exception exception) {
/*     */       
/* 376 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle getClipBounds() {
/* 382 */     if (getDeviceclip() != null) {
/* 383 */       return getClip().getBounds();
/*     */     }
/* 385 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 390 */     return this._escherGraphics.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Composite getComposite() {
/* 395 */     return getG2D().getComposite();
/*     */   }
/*     */ 
/*     */   
/*     */   public GraphicsConfiguration getDeviceConfiguration() {
/* 400 */     return getG2D().getDeviceConfiguration();
/*     */   }
/*     */ 
/*     */   
/*     */   public Font getFont() {
/* 405 */     return getEscherGraphics().getFont();
/*     */   }
/*     */ 
/*     */   
/*     */   public FontMetrics getFontMetrics(Font paramFont) {
/* 410 */     return getEscherGraphics().getFontMetrics(paramFont);
/*     */   }
/*     */ 
/*     */   
/*     */   public FontRenderContext getFontRenderContext() {
/* 415 */     getG2D().setTransform(getTrans());
/* 416 */     return getG2D().getFontRenderContext();
/*     */   }
/*     */ 
/*     */   
/*     */   public Paint getPaint() {
/* 421 */     return this._paint;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getRenderingHint(RenderingHints.Key paramKey) {
/* 426 */     return getG2D().getRenderingHint(paramKey);
/*     */   }
/*     */ 
/*     */   
/*     */   public RenderingHints getRenderingHints() {
/* 431 */     return getG2D().getRenderingHints();
/*     */   }
/*     */ 
/*     */   
/*     */   public Stroke getStroke() {
/* 436 */     return this._stroke;
/*     */   }
/*     */ 
/*     */   
/*     */   public AffineTransform getTransform() {
/* 441 */     return (AffineTransform)getTrans().clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hit(Rectangle paramRectangle, Shape paramShape, boolean paramBoolean) {
/* 446 */     getG2D().setTransform(getTrans());
/* 447 */     getG2D().setStroke(getStroke());
/* 448 */     getG2D().setClip(getClip());
/* 449 */     return getG2D().hit(paramRectangle, paramShape, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(double paramDouble) {
/* 454 */     getTrans().rotate(paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 459 */     getTrans().rotate(paramDouble1, paramDouble2, paramDouble3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void scale(double paramDouble1, double paramDouble2) {
/* 464 */     getTrans().scale(paramDouble1, paramDouble2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBackground(Color paramColor) {
/* 469 */     getEscherGraphics().setBackground(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 474 */     setClip(new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setClip(Shape paramShape) {
/* 479 */     setDeviceclip(getTrans().createTransformedShape(paramShape));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 484 */     this._escherGraphics.setColor(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setComposite(Composite paramComposite) {
/* 489 */     getG2D().setComposite(paramComposite);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFont(Font paramFont) {
/* 494 */     getEscherGraphics().setFont(paramFont);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPaint(Paint paramPaint) {
/* 499 */     if (paramPaint != null) {
/*     */       
/* 501 */       this._paint = paramPaint;
/* 502 */       if (paramPaint instanceof Color) {
/* 503 */         setColor((Color)paramPaint);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPaintMode() {
/* 509 */     getEscherGraphics().setPaintMode();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderingHint(RenderingHints.Key paramKey, Object paramObject) {
/* 514 */     getG2D().setRenderingHint(paramKey, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderingHints(Map<?, ?> paramMap) {
/* 519 */     getG2D().setRenderingHints(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStroke(Stroke paramStroke) {
/* 524 */     this._stroke = paramStroke;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTransform(AffineTransform paramAffineTransform) {
/* 529 */     setTrans((AffineTransform)paramAffineTransform.clone());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setXORMode(Color paramColor) {
/* 534 */     getEscherGraphics().setXORMode(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void shear(double paramDouble1, double paramDouble2) {
/* 539 */     getTrans().shear(paramDouble1, paramDouble2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void transform(AffineTransform paramAffineTransform) {
/* 544 */     getTrans().concatenate(paramAffineTransform);
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
/*     */   public void translate(double paramDouble1, double paramDouble2) {
/* 561 */     getTrans().translate(paramDouble1, paramDouble2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void translate(int paramInt1, int paramInt2) {
/* 566 */     getTrans().translate(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   private EscherGraphics getEscherGraphics() {
/* 571 */     return this._escherGraphics;
/*     */   }
/*     */ 
/*     */   
/*     */   private BufferedImage getImg() {
/* 576 */     return this._img;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setImg(BufferedImage paramBufferedImage) {
/* 581 */     this._img = paramBufferedImage;
/*     */   }
/*     */ 
/*     */   
/*     */   private Graphics2D getG2D() {
/* 586 */     return (Graphics2D)this._img.getGraphics();
/*     */   }
/*     */ 
/*     */   
/*     */   private AffineTransform getTrans() {
/* 591 */     return this._trans;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setTrans(AffineTransform paramAffineTransform) {
/* 596 */     this._trans = paramAffineTransform;
/*     */   }
/*     */ 
/*     */   
/*     */   private Shape getDeviceclip() {
/* 601 */     return this._deviceclip;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setDeviceclip(Shape paramShape) {
/* 606 */     this._deviceclip = paramShape;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\EscherGraphics2d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */