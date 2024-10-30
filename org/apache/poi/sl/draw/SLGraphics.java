/*      */ package org.apache.poi.sl.draw;
/*      */ 
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.Composite;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.GraphicsConfiguration;
/*      */ import java.awt.GraphicsEnvironment;
/*      */ import java.awt.Image;
/*      */ import java.awt.Paint;
/*      */ import java.awt.Polygon;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.RenderingHints;
/*      */ import java.awt.Shape;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.font.FontRenderContext;
/*      */ import java.awt.font.GlyphVector;
/*      */ import java.awt.font.TextLayout;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.awt.geom.Arc2D;
/*      */ import java.awt.geom.Ellipse2D;
/*      */ import java.awt.geom.GeneralPath;
/*      */ import java.awt.geom.Line2D;
/*      */ import java.awt.geom.Path2D;
/*      */ import java.awt.geom.RoundRectangle2D;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.awt.image.BufferedImageOp;
/*      */ import java.awt.image.ImageObserver;
/*      */ import java.awt.image.RenderedImage;
/*      */ import java.awt.image.renderable.RenderableImage;
/*      */ import java.text.AttributedCharacterIterator;
/*      */ import java.util.Map;
/*      */ import org.apache.poi.sl.usermodel.FreeformShape;
/*      */ import org.apache.poi.sl.usermodel.GroupShape;
/*      */ import org.apache.poi.sl.usermodel.Insets2D;
/*      */ import org.apache.poi.sl.usermodel.PaintStyle;
/*      */ import org.apache.poi.sl.usermodel.SimpleShape;
/*      */ import org.apache.poi.sl.usermodel.StrokeStyle;
/*      */ import org.apache.poi.sl.usermodel.TextBox;
/*      */ import org.apache.poi.sl.usermodel.TextParagraph;
/*      */ import org.apache.poi.sl.usermodel.TextRun;
/*      */ import org.apache.poi.sl.usermodel.VerticalAlignment;
/*      */ import org.apache.poi.util.NotImplemented;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ import org.apache.poi.util.SuppressForbidden;
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
/*      */ public final class SLGraphics
/*      */   extends Graphics2D
/*      */   implements Cloneable
/*      */ {
/*   75 */   protected POILogger log = POILogFactory.getLogger(getClass());
/*      */   
/*      */   private GroupShape<?, ?> _group;
/*      */   
/*      */   private AffineTransform _transform;
/*      */   
/*      */   private Stroke _stroke;
/*      */   
/*      */   private Paint _paint;
/*      */   
/*      */   private Font _font;
/*      */   
/*      */   private Color _foreground;
/*      */   
/*      */   private Color _background;
/*      */   
/*      */   private RenderingHints _hints;
/*      */   
/*      */   public SLGraphics(GroupShape<?, ?> paramGroupShape) {
/*   94 */     this._group = paramGroupShape;
/*      */     
/*   96 */     this._transform = new AffineTransform();
/*   97 */     this._stroke = new BasicStroke();
/*   98 */     this._paint = Color.black;
/*   99 */     this._font = new Font("Arial", 0, 12);
/*  100 */     this._background = Color.black;
/*  101 */     this._foreground = Color.white;
/*  102 */     this._hints = new RenderingHints(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupShape<?, ?> getShapeGroup() {
/*  109 */     return this._group;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Font getFont() {
/*  119 */     return this._font;
/*      */   }
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
/*      */   public void setFont(Font paramFont) {
/*  133 */     this._font = paramFont;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Color getColor() {
/*  143 */     return this._foreground;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColor(Color paramColor) {
/*  155 */     setPaint(paramColor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Stroke getStroke() {
/*  166 */     return this._stroke;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStroke(Stroke paramStroke) {
/*  175 */     this._stroke = paramStroke;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Paint getPaint() {
/*  187 */     return this._paint;
/*      */   }
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
/*      */   public void setPaint(Paint paramPaint) {
/*  201 */     if (paramPaint == null)
/*      */       return; 
/*  203 */     this._paint = paramPaint;
/*  204 */     if (paramPaint instanceof Color) this._foreground = (Color)paramPaint;
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AffineTransform getTransform() {
/*  216 */     return new AffineTransform(this._transform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransform(AffineTransform paramAffineTransform) {
/*  228 */     this._transform = new AffineTransform(paramAffineTransform);
/*      */   }
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
/*      */   public void draw(Shape paramShape) {
/*  248 */     Path2D.Double double_ = new Path2D.Double(this._transform.createTransformedShape(paramShape));
/*  249 */     FreeformShape freeformShape = this._group.createFreeform();
/*  250 */     freeformShape.setPath(double_);
/*  251 */     freeformShape.setFillColor(null);
/*  252 */     applyStroke((SimpleShape<?, ?>)freeformShape);
/*  253 */     if (this._paint instanceof Color) {
/*  254 */       freeformShape.setStrokeStyle(new Object[] { this._paint });
/*      */     }
/*      */   }
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
/*      */   
/*      */   public void drawString(String paramString, float paramFloat1, float paramFloat2) {
/*  284 */     TextBox textBox = this._group.createTextBox();
/*      */     
/*  286 */     TextRun textRun = ((TextParagraph)textBox.getTextParagraphs().get(0)).getTextRuns().get(0);
/*  287 */     textRun.setFontSize(Double.valueOf(this._font.getSize()));
/*  288 */     textRun.setFontFamily(this._font.getFamily());
/*      */     
/*  290 */     if (getColor() != null) textRun.setFontColor((PaintStyle)DrawPaint.createSolidPaint(getColor())); 
/*  291 */     if (this._font.isBold()) textRun.setBold(true); 
/*  292 */     if (this._font.isItalic()) textRun.setItalic(true);
/*      */     
/*  294 */     textBox.setText(paramString);
/*      */     
/*  296 */     textBox.setInsets(new Insets2D(0.0D, 0.0D, 0.0D, 0.0D));
/*  297 */     textBox.setWordWrap(false);
/*  298 */     textBox.setHorizontalCentered(Boolean.valueOf(false));
/*  299 */     textBox.setVerticalAlignment(VerticalAlignment.MIDDLE);
/*      */ 
/*      */     
/*  302 */     TextLayout textLayout = new TextLayout(paramString, this._font, getFontRenderContext());
/*  303 */     float f1 = textLayout.getAscent();
/*      */     
/*  305 */     float f2 = (float)Math.floor(textLayout.getAdvance());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  312 */     float f3 = f1 * 2.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  319 */     paramFloat2 -= f3 / 2.0F + f1 / 2.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  326 */     textBox.setAnchor(new Rectangle((int)paramFloat1, (int)paramFloat2, (int)f2, (int)f3));
/*      */   }
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
/*      */   public void fill(Shape paramShape) {
/*  344 */     Path2D.Double double_ = new Path2D.Double(this._transform.createTransformedShape(paramShape));
/*  345 */     FreeformShape freeformShape = this._group.createFreeform();
/*  346 */     freeformShape.setPath(double_);
/*  347 */     applyPaint((SimpleShape<?, ?>)freeformShape);
/*  348 */     freeformShape.setStrokeStyle(new Object[0]);
/*      */   }
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
/*      */   public void translate(int paramInt1, int paramInt2) {
/*  363 */     this._transform.translate(paramInt1, paramInt2);
/*      */   }
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
/*      */   @NotImplemented
/*      */   public void clip(Shape paramShape) {
/*  387 */     if (this.log.check(5)) {
/*  388 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */   }
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
/*      */   @NotImplemented
/*      */   public Shape getClip() {
/*  410 */     if (this.log.check(5)) {
/*  411 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*  413 */     return null;
/*      */   }
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
/*      */   public void scale(double paramDouble1, double paramDouble2) {
/*  436 */     this._transform.scale(paramDouble1, paramDouble2);
/*      */   }
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
/*      */   public void drawRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  457 */     RoundRectangle2D.Double double_ = new RoundRectangle2D.Double(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*  458 */     draw(double_);
/*      */   }
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
/*      */   public void drawString(String paramString, int paramInt1, int paramInt2) {
/*  473 */     drawString(paramString, paramInt1, paramInt2);
/*      */   }
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
/*      */   public void fillOval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  488 */     Ellipse2D.Double double_ = new Ellipse2D.Double(paramInt1, paramInt2, paramInt3, paramInt4);
/*  489 */     fill(double_);
/*      */   }
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
/*      */   public void fillRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  511 */     RoundRectangle2D.Double double_ = new RoundRectangle2D.Double(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*  512 */     fill(double_);
/*      */   }
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
/*      */   public void fillArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  552 */     Arc2D.Double double_ = new Arc2D.Double(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 2);
/*  553 */     fill(double_);
/*      */   }
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
/*      */   public void drawArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  594 */     Arc2D.Double double_ = new Arc2D.Double(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0);
/*  595 */     draw(double_);
/*      */   }
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
/*      */   public void drawPolyline(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/*  613 */     if (paramInt > 0) {
/*  614 */       GeneralPath generalPath = new GeneralPath();
/*  615 */       generalPath.moveTo(paramArrayOfint1[0], paramArrayOfint2[0]);
/*  616 */       for (byte b = 1; b < paramInt; b++) {
/*  617 */         generalPath.lineTo(paramArrayOfint1[b], paramArrayOfint2[b]);
/*      */       }
/*  619 */       draw(generalPath);
/*      */     } 
/*      */   }
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
/*      */   public void drawOval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  641 */     Ellipse2D.Double double_ = new Ellipse2D.Double(paramInt1, paramInt2, paramInt3, paramInt4);
/*  642 */     draw(double_);
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, Color paramColor, ImageObserver paramImageObserver) {
/*  679 */     if (this.log.check(5)) {
/*  680 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */     
/*  683 */     return false;
/*      */   }
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
/*      */   @NotImplemented
/*      */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, ImageObserver paramImageObserver) {
/*  729 */     if (this.log.check(5)) {
/*  730 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */     
/*  733 */     return false;
/*      */   }
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
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, ImageObserver paramImageObserver) {
/*  789 */     if (this.log.check(5)) {
/*  790 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*  792 */     return false;
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Color paramColor, ImageObserver paramImageObserver) {
/*  854 */     if (this.log.check(5)) {
/*  855 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*  857 */     return false;
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, ImageObserver paramImageObserver) {
/*  895 */     if (this.log.check(5)) {
/*  896 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*  898 */     return false;
/*      */   }
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
/*      */   public void dispose() {}
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
/*      */   public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  941 */     Line2D.Double double_ = new Line2D.Double(paramInt1, paramInt2, paramInt3, paramInt4);
/*  942 */     draw(double_);
/*      */   }
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
/*      */   public void fillPolygon(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/*  967 */     Polygon polygon = new Polygon(paramArrayOfint1, paramArrayOfint2, paramInt);
/*  968 */     fill(polygon);
/*      */   }
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
/*      */   public void fillRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  991 */     Rectangle rectangle = new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4);
/*  992 */     fill(rectangle);
/*      */   }
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
/*      */   public void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1012 */     Rectangle rectangle = new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4);
/* 1013 */     draw(rectangle);
/*      */   }
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
/*      */   public void drawPolygon(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 1037 */     Polygon polygon = new Polygon(paramArrayOfint1, paramArrayOfint2, paramInt);
/* 1038 */     draw(polygon);
/*      */   }
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
/*      */   public void clipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1061 */     clip(new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4));
/*      */   }
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
/*      */   @NotImplemented
/*      */   public void setClip(Shape paramShape) {
/* 1082 */     if (this.log.check(5)) {
/* 1083 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */   }
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
/*      */   public Rectangle getClipBounds() {
/* 1105 */     Shape shape = getClip();
/* 1106 */     if (shape == null) {
/* 1107 */       return null;
/*      */     }
/* 1109 */     return shape.getBounds();
/*      */   }
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
/*      */   public void drawString(AttributedCharacterIterator paramAttributedCharacterIterator, int paramInt1, int paramInt2) {
/* 1126 */     drawString(paramAttributedCharacterIterator, paramInt1, paramInt2);
/*      */   }
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
/*      */   public void clearRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1149 */     Paint paint = getPaint();
/* 1150 */     setColor(getBackground());
/* 1151 */     fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
/* 1152 */     setPaint(paint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void copyArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1173 */     setClip(new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4));
/*      */   }
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
/*      */   public void rotate(double paramDouble) {
/* 1193 */     this._transform.rotate(paramDouble);
/*      */   }
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
/*      */   public void rotate(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1216 */     this._transform.rotate(paramDouble1, paramDouble2, paramDouble3);
/*      */   }
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
/*      */   public void shear(double paramDouble1, double paramDouble2) {
/* 1238 */     this._transform.shear(paramDouble1, paramDouble2);
/*      */   }
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
/*      */   public FontRenderContext getFontRenderContext() {
/* 1263 */     boolean bool1 = RenderingHints.VALUE_TEXT_ANTIALIAS_ON.equals(getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING));
/*      */     
/* 1265 */     boolean bool2 = RenderingHints.VALUE_FRACTIONALMETRICS_ON.equals(getRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS));
/*      */ 
/*      */ 
/*      */     
/* 1269 */     return new FontRenderContext(new AffineTransform(), bool1, bool2);
/*      */   }
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
/*      */   public void transform(AffineTransform paramAffineTransform) {
/* 1290 */     this._transform.concatenate(paramAffineTransform);
/*      */   }
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
/*      */   public void drawImage(BufferedImage paramBufferedImage, BufferedImageOp paramBufferedImageOp, int paramInt1, int paramInt2) {
/* 1318 */     paramBufferedImage = paramBufferedImageOp.filter(paramBufferedImage, null);
/* 1319 */     drawImage(paramBufferedImage, paramInt1, paramInt2, (ImageObserver)null);
/*      */   }
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
/*      */   public void setBackground(Color paramColor) {
/* 1339 */     if (paramColor == null) {
/*      */       return;
/*      */     }
/* 1342 */     this._background = paramColor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Color getBackground() {
/* 1352 */     return this._background;
/*      */   }
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
/*      */   
/*      */   @NotImplemented
/*      */   public void setComposite(Composite paramComposite) {
/* 1382 */     if (this.log.check(5)) {
/* 1383 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public Composite getComposite() {
/* 1396 */     if (this.log.check(5)) {
/* 1397 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/* 1399 */     return null;
/*      */   }
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
/*      */   public Object getRenderingHint(RenderingHints.Key paramKey) {
/* 1415 */     return this._hints.get(paramKey);
/*      */   }
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
/*      */   public void setRenderingHint(RenderingHints.Key paramKey, Object paramObject) {
/* 1430 */     this._hints.put(paramKey, paramObject);
/*      */   }
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
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawGlyphVector(GlyphVector paramGlyphVector, float paramFloat1, float paramFloat2) {
/* 1461 */     Shape shape = paramGlyphVector.getOutline(paramFloat1, paramFloat2);
/* 1462 */     fill(shape);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GraphicsConfiguration getDeviceConfiguration() {
/* 1471 */     return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
/*      */   }
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
/*      */   public void addRenderingHints(Map<?, ?> paramMap) {
/* 1490 */     this._hints.putAll(paramMap);
/*      */   }
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
/*      */   public void translate(double paramDouble1, double paramDouble2) {
/* 1510 */     this._transform.translate(paramDouble1, paramDouble2);
/*      */   }
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
/*      */   
/*      */   @NotImplemented
/*      */   public void drawString(AttributedCharacterIterator paramAttributedCharacterIterator, float paramFloat1, float paramFloat2) {
/* 1540 */     if (this.log.check(5)) {
/* 1541 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hit(Rectangle paramRectangle, Shape paramShape, boolean paramBoolean) {
/* 1577 */     if (paramBoolean) {
/* 1578 */       paramShape = getStroke().createStrokedShape(paramShape);
/*      */     }
/*      */     
/* 1581 */     paramShape = getTransform().createTransformedShape(paramShape);
/*      */     
/* 1583 */     return paramShape.intersects(paramRectangle);
/*      */   }
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
/*      */   public RenderingHints getRenderingHints() {
/* 1599 */     return this._hints;
/*      */   }
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
/*      */   public void setRenderingHints(Map<?, ?> paramMap) {
/* 1616 */     this._hints = new RenderingHints(null);
/* 1617 */     this._hints.putAll(paramMap);
/*      */   }
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
/*      */   
/*      */   @NotImplemented
/*      */   public boolean drawImage(Image paramImage, AffineTransform paramAffineTransform, ImageObserver paramImageObserver) {
/* 1647 */     if (this.log.check(5)) {
/* 1648 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/* 1650 */     return false;
/*      */   }
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
/*      */   @NotImplemented
/*      */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageObserver paramImageObserver) {
/* 1693 */     if (this.log.check(5)) {
/* 1694 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/* 1696 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Graphics create() {
/*      */     try {
/* 1707 */       return (Graphics)clone();
/* 1708 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 1709 */       throw new RuntimeException(cloneNotSupportedException);
/*      */     } 
/*      */   }
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
/*      */   @SuppressForbidden
/*      */   public FontMetrics getFontMetrics(Font paramFont) {
/* 1724 */     return Toolkit.getDefaultToolkit().getFontMetrics(paramFont);
/*      */   }
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
/*      */   @NotImplemented
/*      */   public void setXORMode(Color paramColor) {
/* 1744 */     if (this.log.check(5)) {
/* 1745 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public void setPaintMode() {
/* 1758 */     if (this.log.check(5)) {
/* 1759 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public void drawRenderedImage(RenderedImage paramRenderedImage, AffineTransform paramAffineTransform) {
/* 1796 */     if (this.log.check(5)) {
/* 1797 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */   }
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
/*      */   @NotImplemented
/*      */   public void drawRenderableImage(RenderableImage paramRenderableImage, AffineTransform paramAffineTransform) {
/* 1824 */     if (this.log.check(5)) {
/* 1825 */       this.log.log(5, new Object[] { "Not implemented" });
/*      */     }
/*      */   }
/*      */   
/*      */   protected void applyStroke(SimpleShape<?, ?> paramSimpleShape) {
/* 1830 */     if (this._stroke instanceof BasicStroke) {
/* 1831 */       BasicStroke basicStroke = (BasicStroke)this._stroke;
/* 1832 */       paramSimpleShape.setStrokeStyle(new Object[] { Double.valueOf(basicStroke.getLineWidth()) });
/* 1833 */       float[] arrayOfFloat = basicStroke.getDashArray();
/* 1834 */       if (arrayOfFloat != null)
/*      */       {
/* 1836 */         paramSimpleShape.setStrokeStyle(new Object[] { StrokeStyle.LineDash.DASH });
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void applyPaint(SimpleShape<?, ?> paramSimpleShape) {
/* 1842 */     if (this._paint instanceof Color)
/* 1843 */       paramSimpleShape.setFillColor((Color)this._paint); 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\SLGraphics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */