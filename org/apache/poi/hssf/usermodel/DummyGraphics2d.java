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
/*     */ import java.awt.Polygon;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.Shape;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.GlyphVector;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.BufferedImageOp;
/*     */ import java.awt.image.ImageObserver;
/*     */ import java.awt.image.RenderedImage;
/*     */ import java.awt.image.renderable.RenderableImage;
/*     */ import java.io.PrintStream;
/*     */ import java.text.AttributedCharacterIterator;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
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
/*     */ public class DummyGraphics2d
/*     */   extends Graphics2D
/*     */ {
/*     */   private BufferedImage bufimg;
/*     */   private final Graphics2D g2D;
/*     */   private final PrintStream log;
/*     */   
/*     */   public DummyGraphics2d() {
/*  57 */     this(System.out);
/*     */   }
/*     */   
/*     */   public DummyGraphics2d(PrintStream paramPrintStream) {
/*  61 */     this.bufimg = new BufferedImage(1000, 1000, 2);
/*  62 */     this.g2D = (Graphics2D)this.bufimg.getGraphics();
/*  63 */     this.log = paramPrintStream;
/*     */   }
/*     */   
/*     */   public DummyGraphics2d(PrintStream paramPrintStream, Graphics2D paramGraphics2D) {
/*  67 */     this.g2D = paramGraphics2D;
/*  68 */     this.log = paramPrintStream;
/*     */   }
/*     */   
/*     */   public void addRenderingHints(Map<?, ?> paramMap) {
/*  72 */     String str = "addRenderingHinds(Map):\n  hints = " + paramMap;
/*     */ 
/*     */     
/*  75 */     this.log.println(str);
/*  76 */     this.g2D.addRenderingHints(paramMap);
/*     */   }
/*     */   
/*     */   public void clip(Shape paramShape) {
/*  80 */     String str = "clip(Shape):\n  s = " + paramShape;
/*     */ 
/*     */     
/*  83 */     this.log.println(str);
/*  84 */     this.g2D.clip(paramShape);
/*     */   }
/*     */   
/*     */   public void draw(Shape paramShape) {
/*  88 */     String str = "draw(Shape):\n  s = " + paramShape;
/*     */ 
/*     */     
/*  91 */     this.log.println(str);
/*  92 */     this.g2D.draw(paramShape);
/*     */   }
/*     */   
/*     */   public void drawGlyphVector(GlyphVector paramGlyphVector, float paramFloat1, float paramFloat2) {
/*  96 */     String str = "drawGlyphVector(GlyphVector, float, float):\n  g = " + paramGlyphVector + "\n  x = " + paramFloat1 + "\n  y = " + paramFloat2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     this.log.println(str);
/* 102 */     this.g2D.drawGlyphVector(paramGlyphVector, paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void drawImage(BufferedImage paramBufferedImage, BufferedImageOp paramBufferedImageOp, int paramInt1, int paramInt2) {
/* 106 */     String str = "drawImage(BufferedImage, BufferedImageOp, x, y):\n  img = " + paramBufferedImage + "\n  op = " + paramBufferedImageOp + "\n  x = " + paramInt1 + "\n  y = " + paramInt2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     this.log.println(str);
/* 113 */     this.g2D.drawImage(paramBufferedImage, paramBufferedImageOp, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public boolean drawImage(Image paramImage, AffineTransform paramAffineTransform, ImageObserver paramImageObserver) {
/* 117 */     String str = "drawImage(Image,AfflineTransform,ImageObserver):\n  img = " + paramImage + "\n  xform = " + paramAffineTransform + "\n  obs = " + paramImageObserver;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     this.log.println(str);
/* 123 */     return this.g2D.drawImage(paramImage, paramAffineTransform, paramImageObserver);
/*     */   }
/*     */   
/*     */   public void drawRenderableImage(RenderableImage paramRenderableImage, AffineTransform paramAffineTransform) {
/* 127 */     String str = "drawRenderableImage(RenderableImage, AfflineTransform):\n  img = " + paramRenderableImage + "\n  xform = " + paramAffineTransform;
/*     */ 
/*     */ 
/*     */     
/* 131 */     this.log.println(str);
/* 132 */     this.g2D.drawRenderableImage(paramRenderableImage, paramAffineTransform);
/*     */   }
/*     */   
/*     */   public void drawRenderedImage(RenderedImage paramRenderedImage, AffineTransform paramAffineTransform) {
/* 136 */     String str = "drawRenderedImage(RenderedImage, AffineTransform):\n  img = " + paramRenderedImage + "\n  xform = " + paramAffineTransform;
/*     */ 
/*     */ 
/*     */     
/* 140 */     this.log.println(str);
/* 141 */     this.g2D.drawRenderedImage(paramRenderedImage, paramAffineTransform);
/*     */   }
/*     */   
/*     */   public void drawString(AttributedCharacterIterator paramAttributedCharacterIterator, float paramFloat1, float paramFloat2) {
/* 145 */     String str = "drawString(AttributedCharacterIterator):\n  iterator = " + paramAttributedCharacterIterator + "\n  x = " + paramFloat1 + "\n  y = " + paramFloat2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     this.log.println(str);
/* 151 */     this.g2D.drawString(paramAttributedCharacterIterator, paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void drawString(String paramString, float paramFloat1, float paramFloat2) {
/* 155 */     String str = "drawString(s,x,y):\n  s = " + paramString + "\n  x = " + paramFloat1 + "\n  y = " + paramFloat2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     this.log.println(str);
/* 161 */     this.g2D.drawString(paramString, paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void fill(Shape paramShape) {
/* 165 */     String str = "fill(Shape):\n  s = " + paramShape;
/*     */ 
/*     */     
/* 168 */     this.log.println(str);
/* 169 */     this.g2D.fill(paramShape);
/*     */   }
/*     */   
/*     */   public Color getBackground() {
/* 173 */     this.log.println("getBackground():");
/* 174 */     return this.g2D.getBackground();
/*     */   }
/*     */   
/*     */   public Composite getComposite() {
/* 178 */     this.log.println("getComposite():");
/* 179 */     return this.g2D.getComposite();
/*     */   }
/*     */   
/*     */   public GraphicsConfiguration getDeviceConfiguration() {
/* 183 */     this.log.println("getDeviceConfiguration():");
/* 184 */     return this.g2D.getDeviceConfiguration();
/*     */   }
/*     */   
/*     */   public FontRenderContext getFontRenderContext() {
/* 188 */     this.log.println("getFontRenderContext():");
/* 189 */     return this.g2D.getFontRenderContext();
/*     */   }
/*     */   
/*     */   public Paint getPaint() {
/* 193 */     this.log.println("getPaint():");
/* 194 */     return this.g2D.getPaint();
/*     */   }
/*     */   
/*     */   public Object getRenderingHint(RenderingHints.Key paramKey) {
/* 198 */     String str = "getRenderingHint(RenderingHints.Key):\n  hintKey = " + paramKey;
/*     */ 
/*     */     
/* 201 */     this.log.println(str);
/* 202 */     return this.g2D.getRenderingHint(paramKey);
/*     */   }
/*     */   
/*     */   public RenderingHints getRenderingHints() {
/* 206 */     this.log.println("getRenderingHints():");
/* 207 */     return this.g2D.getRenderingHints();
/*     */   }
/*     */   
/*     */   public Stroke getStroke() {
/* 211 */     this.log.println("getStroke():");
/* 212 */     return this.g2D.getStroke();
/*     */   }
/*     */   
/*     */   public AffineTransform getTransform() {
/* 216 */     this.log.println("getTransform():");
/* 217 */     return this.g2D.getTransform();
/*     */   }
/*     */   
/*     */   public boolean hit(Rectangle paramRectangle, Shape paramShape, boolean paramBoolean) {
/* 221 */     String str = "hit(Rectangle, Shape, onStroke):\n  rect = " + paramRectangle + "\n  s = " + paramShape + "\n  onStroke = " + paramBoolean;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     this.log.println(str);
/* 227 */     return this.g2D.hit(paramRectangle, paramShape, paramBoolean);
/*     */   }
/*     */   
/*     */   public void rotate(double paramDouble) {
/* 231 */     String str = "rotate(theta):\n  theta = " + paramDouble;
/*     */ 
/*     */     
/* 234 */     this.log.println(str);
/* 235 */     this.g2D.rotate(paramDouble);
/*     */   }
/*     */   
/*     */   public void rotate(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 239 */     String str = "rotate(double,double,double):\n  theta = " + paramDouble1 + "\n  x = " + paramDouble2 + "\n  y = " + paramDouble3;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 244 */     this.log.println(str);
/* 245 */     this.g2D.rotate(paramDouble1, paramDouble2, paramDouble3);
/*     */   }
/*     */   
/*     */   public void scale(double paramDouble1, double paramDouble2) {
/* 249 */     String str = "scale(double,double):\n  sx = " + paramDouble1 + "\n  sy";
/*     */ 
/*     */ 
/*     */     
/* 253 */     this.log.println(str);
/* 254 */     this.g2D.scale(paramDouble1, paramDouble2);
/*     */   }
/*     */   
/*     */   public void setBackground(Color paramColor) {
/* 258 */     String str = "setBackground(Color):\n  color = " + paramColor;
/*     */ 
/*     */     
/* 261 */     this.log.println(str);
/* 262 */     this.g2D.setBackground(paramColor);
/*     */   }
/*     */   
/*     */   public void setComposite(Composite paramComposite) {
/* 266 */     String str = "setComposite(Composite):\n  comp = " + paramComposite;
/*     */ 
/*     */     
/* 269 */     this.log.println(str);
/* 270 */     this.g2D.setComposite(paramComposite);
/*     */   }
/*     */   
/*     */   public void setPaint(Paint paramPaint) {
/* 274 */     String str = "setPaint(Paint):\n  paint = " + paramPaint;
/*     */ 
/*     */     
/* 277 */     this.log.println(str);
/* 278 */     this.g2D.setPaint(paramPaint);
/*     */   }
/*     */   
/*     */   public void setRenderingHint(RenderingHints.Key paramKey, Object paramObject) {
/* 282 */     String str = "setRenderingHint(RenderingHints.Key, Object):\n  hintKey = " + paramKey + "\n  hintValue = " + paramObject;
/*     */ 
/*     */ 
/*     */     
/* 286 */     this.log.println(str);
/* 287 */     this.g2D.setRenderingHint(paramKey, paramObject);
/*     */   }
/*     */   
/*     */   public void setRenderingHints(Map<?, ?> paramMap) {
/* 291 */     String str = "setRenderingHints(Map):\n  hints = " + paramMap;
/*     */ 
/*     */     
/* 294 */     this.log.println(str);
/* 295 */     this.g2D.setRenderingHints(paramMap);
/*     */   }
/*     */   
/*     */   public void setStroke(Stroke paramStroke) {
/*     */     String str;
/* 300 */     if (paramStroke instanceof BasicStroke) {
/* 301 */       BasicStroke basicStroke = (BasicStroke)paramStroke;
/* 302 */       str = "setStroke(Stoke):\n  s = BasicStroke(\n    dash[]: " + Arrays.toString(basicStroke.getDashArray()) + "\n    dashPhase: " + basicStroke.getDashPhase() + "\n    endCap: " + basicStroke.getEndCap() + "\n    lineJoin: " + basicStroke.getLineJoin() + "\n    width: " + basicStroke.getLineWidth() + "\n    miterLimit: " + basicStroke.getMiterLimit() + "\n  )";
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 312 */       str = "setStroke(Stoke):\n  s = " + paramStroke;
/*     */     } 
/*     */     
/* 315 */     this.log.println(str);
/* 316 */     this.g2D.setStroke(paramStroke);
/*     */   }
/*     */   
/*     */   public void setTransform(AffineTransform paramAffineTransform) {
/* 320 */     String str = "setTransform():\n  Tx = " + paramAffineTransform;
/*     */ 
/*     */     
/* 323 */     this.log.println(str);
/* 324 */     this.g2D.setTransform(paramAffineTransform);
/*     */   }
/*     */   
/*     */   public void shear(double paramDouble1, double paramDouble2) {
/* 328 */     String str = "shear(shx, dhy):\n  shx = " + paramDouble1 + "\n  shy = " + paramDouble2;
/*     */ 
/*     */ 
/*     */     
/* 332 */     this.log.println(str);
/* 333 */     this.g2D.shear(paramDouble1, paramDouble2);
/*     */   }
/*     */   
/*     */   public void transform(AffineTransform paramAffineTransform) {
/* 337 */     String str = "transform(AffineTransform):\n  Tx = " + paramAffineTransform;
/*     */ 
/*     */     
/* 340 */     this.log.println(str);
/* 341 */     this.g2D.transform(paramAffineTransform);
/*     */   }
/*     */   
/*     */   public void translate(double paramDouble1, double paramDouble2) {
/* 345 */     String str = "translate(double, double):\n  tx = " + paramDouble1 + "\n  ty = " + paramDouble2;
/*     */ 
/*     */ 
/*     */     
/* 349 */     this.log.println(str);
/* 350 */     this.g2D.translate(paramDouble1, paramDouble2);
/*     */   }
/*     */   
/*     */   public void clearRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 354 */     String str = "clearRect(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 360 */     this.log.println(str);
/* 361 */     this.g2D.clearRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void clipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 365 */     String str = "clipRect(int, int, int, int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 371 */     this.log.println(str);
/* 372 */     this.g2D.clipRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void copyArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 376 */     String str = "copyArea(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 382 */     this.log.println(str);
/* 383 */     this.g2D.copyArea(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */   
/*     */   public Graphics create() {
/* 387 */     this.log.println("create():");
/* 388 */     return this.g2D.create();
/*     */   }
/*     */   
/*     */   public Graphics create(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 392 */     String str = "create(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 398 */     this.log.println(str);
/* 399 */     return this.g2D.create(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 403 */     this.log.println("dispose():");
/* 404 */     this.g2D.dispose();
/*     */   }
/*     */   
/*     */   public void draw3DRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
/* 408 */     String str = "draw3DRect(int,int,int,int,boolean):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4 + "\n  raised = " + paramBoolean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 415 */     this.log.println(str);
/* 416 */     this.g2D.draw3DRect(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
/*     */   }
/*     */   
/*     */   public void drawArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 420 */     String str = "drawArc(int,int,int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4 + "\n  startAngle = " + paramInt5 + "\n  arcAngle = " + paramInt6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 428 */     this.log.println(str);
/* 429 */     this.g2D.drawArc(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */   
/*     */   public void drawBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 433 */     String str = "drawBytes(byte[],int,int,int,int):\n  data = " + Arrays.toString(paramArrayOfbyte) + "\n  offset = " + paramInt1 + "\n  length = " + paramInt2 + "\n  x = " + paramInt3 + "\n  y = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 440 */     this.log.println(str);
/* 441 */     this.g2D.drawBytes(paramArrayOfbyte, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void drawChars(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 445 */     String str = "drawChars(data,int,int,int,int):\n  data = " + Arrays.toString(paramArrayOfchar) + "\n  offset = " + paramInt1 + "\n  length = " + paramInt2 + "\n  x = " + paramInt3 + "\n  y = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 452 */     this.log.println(str);
/* 453 */     this.g2D.drawChars(paramArrayOfchar, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, ImageObserver paramImageObserver) {
/* 457 */     String str = "drawImage(Image,int,int,int,int,int,int,int,int,ImageObserver):\n  img = " + paramImage + "\n  dx1 = " + paramInt1 + "\n  dy1 = " + paramInt2 + "\n  dx2 = " + paramInt3 + "\n  dy2 = " + paramInt4 + "\n  sx1 = " + paramInt5 + "\n  sy1 = " + paramInt6 + "\n  sx2 = " + paramInt7 + "\n  sy2 = " + paramInt8 + "\n  observer = " + paramImageObserver;
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
/* 469 */     this.log.println(str);
/* 470 */     return this.g2D.drawImage(paramImage, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramImageObserver);
/*     */   }
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Color paramColor, ImageObserver paramImageObserver) {
/* 474 */     String str = "drawImage(Image,int,int,int,int,int,int,int,int,Color,ImageObserver):\n  img = " + paramImage + "\n  dx1 = " + paramInt1 + "\n  dy1 = " + paramInt2 + "\n  dx2 = " + paramInt3 + "\n  dy2 = " + paramInt4 + "\n  sx1 = " + paramInt5 + "\n  sy1 = " + paramInt6 + "\n  sx2 = " + paramInt7 + "\n  sy2 = " + paramInt8 + "\n  bgcolor = " + paramColor + "\n  observer = " + paramImageObserver;
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
/* 487 */     this.log.println(str);
/* 488 */     return this.g2D.drawImage(paramImage, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramColor, paramImageObserver);
/*     */   }
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, Color paramColor, ImageObserver paramImageObserver) {
/* 492 */     String str = "drawImage(Image,int,int,Color,ImageObserver):\n  img = " + paramImage + "\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  bgcolor = " + paramColor + "\n  observer = " + paramImageObserver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 499 */     this.log.println(str);
/* 500 */     return this.g2D.drawImage(paramImage, paramInt1, paramInt2, paramColor, paramImageObserver);
/*     */   }
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, ImageObserver paramImageObserver) {
/* 504 */     String str = "drawImage(Image,int,int,observer):\n  img = " + paramImage + "\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  observer = " + paramImageObserver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 510 */     this.log.println(str);
/* 511 */     return this.g2D.drawImage(paramImage, paramInt1, paramInt2, paramImageObserver);
/*     */   }
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, ImageObserver paramImageObserver) {
/* 515 */     String str = "drawImage(Image,int,int,int,int,Color,ImageObserver):\n  img = " + paramImage + "\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4 + "\n  bgcolor = " + paramColor + "\n  observer = " + paramImageObserver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 524 */     this.log.println(str);
/* 525 */     return this.g2D.drawImage(paramImage, paramInt1, paramInt2, paramInt3, paramInt4, paramColor, paramImageObserver);
/*     */   }
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageObserver paramImageObserver) {
/* 529 */     String str = "drawImage(Image,int,int,width,height,observer):\n  img = " + paramImage + "\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4 + "\n  observer = " + paramImageObserver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 537 */     this.log.println(str);
/* 538 */     return this.g2D.drawImage(paramImage, paramInt1, paramInt2, paramInt3, paramInt4, paramImageObserver);
/*     */   }
/*     */   
/*     */   public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 542 */     String str = "drawLine(int,int,int,int):\n  x1 = " + paramInt1 + "\n  y1 = " + paramInt2 + "\n  x2 = " + paramInt3 + "\n  y2 = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 548 */     this.log.println(str);
/* 549 */     this.g2D.drawLine(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void drawOval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 553 */     String str = "drawOval(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 559 */     this.log.println(str);
/* 560 */     this.g2D.drawOval(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void drawPolygon(Polygon paramPolygon) {
/* 564 */     String str = "drawPolygon(Polygon):\n  p = " + paramPolygon;
/*     */ 
/*     */     
/* 567 */     this.log.println(str);
/* 568 */     this.g2D.drawPolygon(paramPolygon);
/*     */   }
/*     */   
/*     */   public void drawPolygon(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 572 */     String str = "drawPolygon(int[],int[],int):\n  xPoints = " + Arrays.toString(paramArrayOfint1) + "\n  yPoints = " + Arrays.toString(paramArrayOfint2) + "\n  nPoints = " + paramInt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 577 */     this.log.println(str);
/* 578 */     this.g2D.drawPolygon(paramArrayOfint1, paramArrayOfint2, paramInt);
/*     */   }
/*     */   
/*     */   public void drawPolyline(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 582 */     String str = "drawPolyline(int[],int[],int):\n  xPoints = " + Arrays.toString(paramArrayOfint1) + "\n  yPoints = " + Arrays.toString(paramArrayOfint2) + "\n  nPoints = " + paramInt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 587 */     this.log.println(str);
/* 588 */     this.g2D.drawPolyline(paramArrayOfint1, paramArrayOfint2, paramInt);
/*     */   }
/*     */   
/*     */   public void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 592 */     String str = "drawRect(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 598 */     this.log.println(str);
/* 599 */     this.g2D.drawRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void drawRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 603 */     String str = "drawRoundRect(int,int,int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4 + "\n  arcWidth = " + paramInt5 + "\n  arcHeight = " + paramInt6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 611 */     this.log.println(str);
/* 612 */     this.g2D.drawRoundRect(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */   
/*     */   public void drawString(AttributedCharacterIterator paramAttributedCharacterIterator, int paramInt1, int paramInt2) {
/* 616 */     String str = "drawString(AttributedCharacterIterator,int,int):\n  iterator = " + paramAttributedCharacterIterator + "\n  x = " + paramInt1 + "\n  y = " + paramInt2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 621 */     this.log.println(str);
/* 622 */     this.g2D.drawString(paramAttributedCharacterIterator, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void drawString(String paramString, int paramInt1, int paramInt2) {
/* 626 */     String str = "drawString(str,int,int):\n  str = " + paramString + "\n  x = " + paramInt1 + "\n  y = " + paramInt2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 631 */     this.log.println(str);
/* 632 */     this.g2D.drawString(paramString, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void fill3DRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
/* 636 */     String str = "fill3DRect(int,int,int,int,boolean):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4 + "\n  raised = " + paramBoolean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 643 */     this.log.println(str);
/* 644 */     this.g2D.fill3DRect(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
/*     */   }
/*     */   
/*     */   public void fillArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 648 */     String str = "fillArc(int,int,int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4 + "\n  startAngle = " + paramInt5 + "\n  arcAngle = " + paramInt6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 656 */     this.log.println(str);
/* 657 */     this.g2D.fillArc(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */   
/*     */   public void fillOval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 661 */     String str = "fillOval(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 667 */     this.log.println(str);
/* 668 */     this.g2D.fillOval(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void fillPolygon(Polygon paramPolygon) {
/* 672 */     String str = "fillPolygon(Polygon):\n  p = " + paramPolygon;
/*     */ 
/*     */     
/* 675 */     this.log.println(str);
/* 676 */     this.g2D.fillPolygon(paramPolygon);
/*     */   }
/*     */   
/*     */   public void fillPolygon(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 680 */     String str = "fillPolygon(int[],int[],int):\n  xPoints = " + Arrays.toString(paramArrayOfint1) + "\n  yPoints = " + Arrays.toString(paramArrayOfint2) + "\n  nPoints = " + paramInt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 685 */     this.log.println(str);
/* 686 */     this.g2D.fillPolygon(paramArrayOfint1, paramArrayOfint2, paramInt);
/*     */   }
/*     */   
/*     */   public void fillRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 690 */     String str = "fillRect(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 696 */     this.log.println(str);
/* 697 */     this.g2D.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void fillRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 701 */     String str = "fillRoundRect(int,int,int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 707 */     this.log.println(str);
/* 708 */     this.g2D.fillRoundRect(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public final void finalize() {
/* 717 */     this.log.println("finalize():");
/* 718 */     this.g2D.finalize();
/* 719 */     super.finalize();
/*     */   }
/*     */   
/*     */   public Shape getClip() {
/* 723 */     this.log.println("getClip():");
/* 724 */     return this.g2D.getClip();
/*     */   }
/*     */   
/*     */   public Rectangle getClipBounds() {
/* 728 */     this.log.println("getClipBounds():");
/* 729 */     return this.g2D.getClipBounds();
/*     */   }
/*     */   
/*     */   public Rectangle getClipBounds(Rectangle paramRectangle) {
/* 733 */     String str = "getClipBounds(Rectangle):\n  r = " + paramRectangle;
/*     */ 
/*     */     
/* 736 */     this.log.println(str);
/* 737 */     return this.g2D.getClipBounds(paramRectangle);
/*     */   }
/*     */   
/*     */   public Color getColor() {
/* 741 */     this.log.println("getColor():");
/* 742 */     return this.g2D.getColor();
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 746 */     this.log.println("getFont():");
/* 747 */     return this.g2D.getFont();
/*     */   }
/*     */   
/*     */   public FontMetrics getFontMetrics() {
/* 751 */     this.log.println("getFontMetrics():");
/* 752 */     return this.g2D.getFontMetrics();
/*     */   }
/*     */   
/*     */   public FontMetrics getFontMetrics(Font paramFont) {
/* 756 */     this.log.println("getFontMetrics():");
/* 757 */     return this.g2D.getFontMetrics(paramFont);
/*     */   }
/*     */   
/*     */   public boolean hitClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 761 */     String str = "hitClip(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 767 */     this.log.println(str);
/* 768 */     return this.g2D.hitClip(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void setClip(Shape paramShape) {
/* 772 */     String str = "setClip(Shape):\n  clip = " + paramShape;
/*     */ 
/*     */     
/* 775 */     this.log.println(str);
/* 776 */     this.g2D.setClip(paramShape);
/*     */   }
/*     */   
/*     */   public void setClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 780 */     String str = "setClip(int,int,int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2 + "\n  width = " + paramInt3 + "\n  height = " + paramInt4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 786 */     this.log.println(str);
/* 787 */     this.g2D.setClip(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 791 */     String str = "setColor():\n  c = " + paramColor;
/*     */ 
/*     */     
/* 794 */     this.log.println(str);
/* 795 */     this.g2D.setColor(paramColor);
/*     */   }
/*     */   
/*     */   public void setFont(Font paramFont) {
/* 799 */     String str = "setFont(Font):\n  font = " + paramFont;
/*     */ 
/*     */     
/* 802 */     this.log.println(str);
/* 803 */     this.g2D.setFont(paramFont);
/*     */   }
/*     */   
/*     */   public void setPaintMode() {
/* 807 */     this.log.println("setPaintMode():");
/* 808 */     this.g2D.setPaintMode();
/*     */   }
/*     */   
/*     */   public void setXORMode(Color paramColor) {
/* 812 */     String str = "setXORMode(Color):\n  c1 = " + paramColor;
/*     */ 
/*     */     
/* 815 */     this.log.println(str);
/* 816 */     this.g2D.setXORMode(paramColor);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 820 */     this.log.println("toString():");
/* 821 */     return this.g2D.toString();
/*     */   }
/*     */   
/*     */   public void translate(int paramInt1, int paramInt2) {
/* 825 */     String str = "translate(int,int):\n  x = " + paramInt1 + "\n  y = " + paramInt2;
/*     */ 
/*     */ 
/*     */     
/* 829 */     this.log.println(str);
/* 830 */     this.g2D.translate(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\DummyGraphics2d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */