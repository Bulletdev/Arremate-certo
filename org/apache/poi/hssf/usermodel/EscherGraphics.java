/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.image.ImageObserver;
/*     */ import java.text.AttributedCharacterIterator;
/*     */ import org.apache.poi.hssf.util.HSSFColor;
/*     */ import org.apache.poi.util.NotImplemented;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.SuppressForbidden;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EscherGraphics
/*     */   extends Graphics
/*     */ {
/*     */   private final HSSFShapeGroup escherGroup;
/*     */   private final HSSFWorkbook workbook;
/*  66 */   private float verticalPointsPerPixel = 1.0F;
/*     */   private final float verticalPixelsPerPoint;
/*     */   private Color foreground;
/*  69 */   private Color background = Color.white;
/*     */   private Font font;
/*  71 */   private static final POILogger logger = POILogFactory.getLogger(EscherGraphics.class);
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
/*     */   public EscherGraphics(HSSFShapeGroup paramHSSFShapeGroup, HSSFWorkbook paramHSSFWorkbook, Color paramColor, float paramFloat) {
/*  83 */     this.escherGroup = paramHSSFShapeGroup;
/*  84 */     this.workbook = paramHSSFWorkbook;
/*  85 */     this.verticalPointsPerPixel = paramFloat;
/*  86 */     this.verticalPixelsPerPoint = 1.0F / paramFloat;
/*  87 */     this.font = new Font("Arial", 0, 10);
/*  88 */     this.foreground = paramColor;
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
/*     */   EscherGraphics(HSSFShapeGroup paramHSSFShapeGroup, HSSFWorkbook paramHSSFWorkbook, Color paramColor, Font paramFont, float paramFloat) {
/* 103 */     this.escherGroup = paramHSSFShapeGroup;
/* 104 */     this.workbook = paramHSSFWorkbook;
/* 105 */     this.foreground = paramColor;
/*     */     
/* 107 */     this.font = paramFont;
/* 108 */     this.verticalPointsPerPixel = paramFloat;
/* 109 */     this.verticalPixelsPerPoint = 1.0F / paramFloat;
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
/*     */   @NotImplemented
/*     */   public void clearRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 129 */     Color color = this.foreground;
/* 130 */     setColor(this.background);
/* 131 */     fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
/* 132 */     setColor(color);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void clipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 139 */     if (logger.check(5)) {
/* 140 */       logger.log(5, new Object[] { "clipRect not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void copyArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 147 */     if (logger.check(5)) {
/* 148 */       logger.log(5, new Object[] { "copyArea not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Graphics create() {
/* 154 */     return new EscherGraphics(this.escherGroup, this.workbook, this.foreground, this.font, this.verticalPointsPerPixel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void drawArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 169 */     if (logger.check(5)) {
/* 170 */       logger.log(5, new Object[] { "drawArc not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Color paramColor, ImageObserver paramImageObserver) {
/* 181 */     if (logger.check(5)) {
/* 182 */       logger.log(5, new Object[] { "drawImage not supported" });
/*     */     }
/* 184 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, ImageObserver paramImageObserver) {
/* 194 */     if (logger.check(5))
/* 195 */       logger.log(5, new Object[] { "drawImage not supported" }); 
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor, ImageObserver paramImageObserver) {
/* 202 */     return drawImage(paramImage, paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, 0, 0, paramImage.getWidth(paramImageObserver), paramImage.getHeight(paramImageObserver), paramColor, paramImageObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageObserver paramImageObserver) {
/* 208 */     return drawImage(paramImage, paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, 0, 0, paramImage.getWidth(paramImageObserver), paramImage.getHeight(paramImageObserver), paramImageObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, Color paramColor, ImageObserver paramImageObserver) {
/* 214 */     return drawImage(paramImage, paramInt1, paramInt2, paramImage.getWidth(paramImageObserver), paramImage.getHeight(paramImageObserver), paramColor, paramImageObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Image paramImage, int paramInt1, int paramInt2, ImageObserver paramImageObserver) {
/* 220 */     return drawImage(paramImage, paramInt1, paramInt2, paramImage.getWidth(paramImageObserver), paramImage.getHeight(paramImageObserver), paramImageObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 226 */     drawLine(paramInt1, paramInt2, paramInt3, paramInt4, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 231 */     HSSFSimpleShape hSSFSimpleShape = this.escherGroup.createShape(new HSSFChildAnchor(paramInt1, paramInt2, paramInt3, paramInt4));
/* 232 */     hSSFSimpleShape.setShapeType(20);
/* 233 */     hSSFSimpleShape.setLineWidth(paramInt5);
/* 234 */     hSSFSimpleShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawOval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 240 */     HSSFSimpleShape hSSFSimpleShape = this.escherGroup.createShape(new HSSFChildAnchor(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4));
/* 241 */     hSSFSimpleShape.setShapeType(3);
/* 242 */     hSSFSimpleShape.setLineWidth(0);
/* 243 */     hSSFSimpleShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/* 244 */     hSSFSimpleShape.setNoFill(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawPolygon(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 251 */     int i = findBiggest(paramArrayOfint1);
/* 252 */     int j = findBiggest(paramArrayOfint2);
/* 253 */     int k = findSmallest(paramArrayOfint1);
/* 254 */     int m = findSmallest(paramArrayOfint2);
/* 255 */     HSSFPolygon hSSFPolygon = this.escherGroup.createPolygon(new HSSFChildAnchor(k, m, i, j));
/* 256 */     hSSFPolygon.setPolygonDrawArea(i - k, j - m);
/* 257 */     hSSFPolygon.setPoints(addToAll(paramArrayOfint1, -k), addToAll(paramArrayOfint2, -m));
/* 258 */     hSSFPolygon.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/* 259 */     hSSFPolygon.setLineWidth(0);
/* 260 */     hSSFPolygon.setNoFill(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private int[] addToAll(int[] paramArrayOfint, int paramInt) {
/* 265 */     int[] arrayOfInt = new int[paramArrayOfint.length];
/* 266 */     for (byte b = 0; b < paramArrayOfint.length; b++)
/* 267 */       arrayOfInt[b] = paramArrayOfint[b] + paramInt; 
/* 268 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void drawPolyline(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 276 */     if (logger.check(5)) {
/* 277 */       logger.log(5, new Object[] { "drawPolyline not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 284 */     if (logger.check(5)) {
/* 285 */       logger.log(5, new Object[] { "drawRect not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void drawRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 293 */     if (logger.check(5)) {
/* 294 */       logger.log(5, new Object[] { "drawRoundRect not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawString(String paramString, int paramInt1, int paramInt2) {
/* 300 */     if (paramString == null || paramString.equals("")) {
/*     */       return;
/*     */     }
/* 303 */     Font font = this.font;
/* 304 */     if (this.font.getName().equals("SansSerif")) {
/*     */       
/* 306 */       font = new Font("Arial", this.font.getStyle(), (int)(this.font.getSize() / this.verticalPixelsPerPoint));
/*     */     }
/*     */     else {
/*     */       
/* 310 */       font = new Font(this.font.getName(), this.font.getStyle(), (int)(this.font.getSize() / this.verticalPixelsPerPoint));
/*     */     } 
/* 312 */     FontDetails fontDetails = StaticFontMetrics.getFontDetails(font);
/* 313 */     int i = fontDetails.getStringWidth(paramString) * 8 + 12;
/* 314 */     int j = (int)(this.font.getSize() / this.verticalPixelsPerPoint + 6.0F) * 2;
/* 315 */     paramInt2 = (int)(paramInt2 - this.font.getSize() / this.verticalPixelsPerPoint + 2.0F * this.verticalPixelsPerPoint);
/* 316 */     HSSFTextbox hSSFTextbox = this.escherGroup.createTextbox(new HSSFChildAnchor(paramInt1, paramInt2, paramInt1 + i, paramInt2 + j));
/* 317 */     hSSFTextbox.setNoFill(true);
/* 318 */     hSSFTextbox.setLineStyle(-1);
/* 319 */     HSSFRichTextString hSSFRichTextString = new HSSFRichTextString(paramString);
/* 320 */     HSSFFont hSSFFont = matchFont(font);
/* 321 */     hSSFRichTextString.applyFont(hSSFFont);
/* 322 */     hSSFTextbox.setString(hSSFRichTextString);
/*     */   }
/*     */ 
/*     */   
/*     */   private HSSFFont matchFont(Font paramFont) {
/* 327 */     HSSFColor hSSFColor = this.workbook.getCustomPalette().findColor((byte)this.foreground.getRed(), (byte)this.foreground.getGreen(), (byte)this.foreground.getBlue());
/*     */     
/* 329 */     if (hSSFColor == null)
/* 330 */       hSSFColor = this.workbook.getCustomPalette().findSimilarColor((byte)this.foreground.getRed(), (byte)this.foreground.getGreen(), (byte)this.foreground.getBlue()); 
/* 331 */     boolean bool1 = ((paramFont.getStyle() & 0x1) != 0) ? true : false;
/* 332 */     boolean bool2 = ((paramFont.getStyle() & 0x2) != 0) ? true : false;
/* 333 */     HSSFFont hSSFFont = this.workbook.findFont(bool1 ? 700 : 0, hSSFColor.getIndex(), (short)(paramFont.getSize() * 20), paramFont.getName(), bool2, false, (short)0, (byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 341 */     if (hSSFFont == null) {
/*     */       
/* 343 */       hSSFFont = this.workbook.createFont();
/* 344 */       hSSFFont.setBoldweight(bool1 ? 700 : 0);
/* 345 */       hSSFFont.setColor(hSSFColor.getIndex());
/* 346 */       hSSFFont.setFontHeight((short)(paramFont.getSize() * 20));
/* 347 */       hSSFFont.setFontName(paramFont.getName());
/* 348 */       hSSFFont.setItalic(bool2);
/* 349 */       hSSFFont.setStrikeout(false);
/* 350 */       hSSFFont.setTypeOffset((short)0);
/* 351 */       hSSFFont.setUnderline((byte)0);
/*     */     } 
/*     */     
/* 354 */     return hSSFFont;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawString(AttributedCharacterIterator paramAttributedCharacterIterator, int paramInt1, int paramInt2) {
/* 362 */     if (logger.check(5)) {
/* 363 */       logger.log(5, new Object[] { "drawString not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 370 */     if (logger.check(5)) {
/* 371 */       logger.log(5, new Object[] { "fillArc not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillOval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 377 */     HSSFSimpleShape hSSFSimpleShape = this.escherGroup.createShape(new HSSFChildAnchor(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4));
/* 378 */     hSSFSimpleShape.setShapeType(3);
/* 379 */     hSSFSimpleShape.setLineStyle(-1);
/* 380 */     hSSFSimpleShape.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/* 381 */     hSSFSimpleShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/* 382 */     hSSFSimpleShape.setNoFill(false);
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
/*     */   public void fillPolygon(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 408 */     int i = findBiggest(paramArrayOfint1);
/* 409 */     int j = findBiggest(paramArrayOfint2);
/* 410 */     int k = findSmallest(paramArrayOfint1);
/* 411 */     int m = findSmallest(paramArrayOfint2);
/* 412 */     HSSFPolygon hSSFPolygon = this.escherGroup.createPolygon(new HSSFChildAnchor(k, m, i, j));
/* 413 */     hSSFPolygon.setPolygonDrawArea(i - k, j - m);
/* 414 */     hSSFPolygon.setPoints(addToAll(paramArrayOfint1, -k), addToAll(paramArrayOfint2, -m));
/* 415 */     hSSFPolygon.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/* 416 */     hSSFPolygon.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBiggest(int[] paramArrayOfint) {
/* 421 */     int i = Integer.MIN_VALUE;
/* 422 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*     */       
/* 424 */       if (paramArrayOfint[b] > i)
/* 425 */         i = paramArrayOfint[b]; 
/*     */     } 
/* 427 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findSmallest(int[] paramArrayOfint) {
/* 432 */     int i = Integer.MAX_VALUE;
/* 433 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*     */       
/* 435 */       if (paramArrayOfint[b] < i)
/* 436 */         i = paramArrayOfint[b]; 
/*     */     } 
/* 438 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 444 */     HSSFSimpleShape hSSFSimpleShape = this.escherGroup.createShape(new HSSFChildAnchor(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4));
/* 445 */     hSSFSimpleShape.setShapeType(1);
/* 446 */     hSSFSimpleShape.setLineStyle(-1);
/* 447 */     hSSFSimpleShape.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/* 448 */     hSSFSimpleShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 455 */     if (logger.check(5)) {
/* 456 */       logger.log(5, new Object[] { "fillRoundRect not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Shape getClip() {
/* 462 */     return getClipBounds();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getClipBounds() {
/* 468 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 474 */     return this.foreground;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Font getFont() {
/* 480 */     return this.font;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressForbidden
/*     */   public FontMetrics getFontMetrics(Font paramFont) {
/* 488 */     return Toolkit.getDefaultToolkit().getFontMetrics(paramFont);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 494 */     setClip(new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void setClip(Shape paramShape) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 507 */     this.foreground = paramColor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFont(Font paramFont) {
/* 513 */     this.font = paramFont;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void setPaintMode() {
/* 520 */     if (logger.check(5)) {
/* 521 */       logger.log(5, new Object[] { "setPaintMode not supported" });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void setXORMode(Color paramColor) {
/* 528 */     if (logger.check(5)) {
/* 529 */       logger.log(5, new Object[] { "setXORMode not supported" });
/*     */     }
/*     */   }
/*     */   
/*     */   @NotImplemented
/*     */   public void translate(int paramInt1, int paramInt2) {
/* 535 */     if (logger.check(5)) {
/* 536 */       logger.log(5, new Object[] { "translate not supported" });
/*     */     }
/*     */   }
/*     */   
/*     */   public Color getBackground() {
/* 541 */     return this.background;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBackground(Color paramColor) {
/* 546 */     this.background = paramColor;
/*     */   }
/*     */ 
/*     */   
/*     */   HSSFShapeGroup getEscherGraphics() {
/* 551 */     return this.escherGroup;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\EscherGraphics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */