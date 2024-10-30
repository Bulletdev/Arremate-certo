/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.font.LineBreakMeasurer;
/*     */ import java.awt.font.TextAttribute;
/*     */ import java.awt.font.TextLayout;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.InvalidObjectException;
/*     */ import java.text.AttributedCharacterIterator;
/*     */ import java.text.AttributedString;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.sl.usermodel.AutoNumberingScheme;
/*     */ import org.apache.poi.sl.usermodel.Hyperlink;
/*     */ import org.apache.poi.sl.usermodel.Insets2D;
/*     */ import org.apache.poi.sl.usermodel.PaintStyle;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.sl.usermodel.ShapeContainer;
/*     */ import org.apache.poi.sl.usermodel.Sheet;
/*     */ import org.apache.poi.sl.usermodel.TextParagraph;
/*     */ import org.apache.poi.sl.usermodel.TextRun;
/*     */ import org.apache.poi.sl.usermodel.TextShape;
/*     */ import org.apache.poi.util.Units;
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
/*     */ public class DrawTextParagraph
/*     */   implements Drawable
/*     */ {
/*  56 */   public static final XlinkAttribute HYPERLINK_HREF = new XlinkAttribute("href");
/*  57 */   public static final XlinkAttribute HYPERLINK_LABEL = new XlinkAttribute("label");
/*     */   protected TextParagraph<?, ?, ?> paragraph;
/*     */   double x;
/*     */   double y;
/*  61 */   protected List<DrawTextFragment> lines = new ArrayList<DrawTextFragment>();
/*     */   protected String rawText;
/*     */   protected DrawTextFragment bullet;
/*  64 */   protected int autoNbrIdx = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double maxLineHeight;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class XlinkAttribute
/*     */     extends AttributedCharacterIterator.Attribute
/*     */   {
/*     */     XlinkAttribute(String param1String) {
/*  78 */       super(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Object readResolve() throws InvalidObjectException {
/*  85 */       if (DrawTextParagraph.HYPERLINK_HREF.getName().equals(getName())) {
/*  86 */         return DrawTextParagraph.HYPERLINK_HREF;
/*     */       }
/*  88 */       if (DrawTextParagraph.HYPERLINK_LABEL.getName().equals(getName())) {
/*  89 */         return DrawTextParagraph.HYPERLINK_LABEL;
/*     */       }
/*  91 */       throw new InvalidObjectException("unknown attribute name");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public DrawTextParagraph(TextParagraph<?, ?, ?> paramTextParagraph) {
/*  97 */     this.paragraph = paramTextParagraph;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(double paramDouble1, double paramDouble2) {
/* 102 */     this.x = paramDouble1;
/* 103 */     this.y = paramDouble2;
/*     */   }
/*     */   
/*     */   public double getY() {
/* 107 */     return this.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoNumberingIdx(int paramInt) {
/* 115 */     this.autoNbrIdx = paramInt;
/*     */   }
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D) {
/* 119 */     if (this.lines.isEmpty())
/*     */       return; 
/* 121 */     double d = this.y;
/*     */     
/* 123 */     boolean bool = true;
/* 124 */     int i = this.paragraph.getIndentLevel();
/* 125 */     Double double_1 = this.paragraph.getLeftMargin();
/* 126 */     if (double_1 == null)
/*     */     {
/* 128 */       double_1 = Double.valueOf(Units.toPoints(347663L * i));
/*     */     }
/* 130 */     Double double_2 = this.paragraph.getIndent();
/* 131 */     if (double_2 == null) {
/* 132 */       double_2 = Double.valueOf(Units.toPoints(347663L * i));
/*     */     }
/* 134 */     if (isHSLF())
/*     */     {
/* 136 */       double_2 = Double.valueOf(double_2.doubleValue() - double_1.doubleValue());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     Double double_3 = this.paragraph.getLineSpacing();
/* 146 */     if (double_3 == null) double_3 = Double.valueOf(100.0D);
/*     */     
/* 148 */     for (DrawTextFragment drawTextFragment : this.lines) {
/*     */       double d1;
/*     */       
/* 151 */       if (bool) {
/* 152 */         if (!isEmptyParagraph())
/*     */         {
/* 154 */           this.bullet = getBullet(paramGraphics2D, drawTextFragment.getAttributedString().getIterator());
/*     */         }
/*     */         
/* 157 */         if (this.bullet != null) {
/* 158 */           this.bullet.setPosition(this.x + double_1.doubleValue() + double_2.doubleValue(), d);
/* 159 */           this.bullet.draw(paramGraphics2D);
/*     */           
/* 161 */           double d4 = (this.bullet.getLayout().getAdvance() + 1.0F);
/* 162 */           d1 = this.x + Math.max(double_1.doubleValue(), double_1.doubleValue() + double_2.doubleValue() + d4);
/*     */         } else {
/* 164 */           d1 = this.x + double_1.doubleValue();
/*     */         } 
/*     */       } else {
/* 167 */         d1 = this.x + double_1.doubleValue();
/*     */       } 
/*     */       
/* 170 */       Rectangle2D rectangle2D = DrawShape.getAnchor(paramGraphics2D, (PlaceableShape<?, ?>)this.paragraph.getParentShape());
/*     */ 
/*     */       
/* 173 */       Insets2D insets2D = this.paragraph.getParentShape().getInsets();
/* 174 */       double d2 = insets2D.left;
/* 175 */       double d3 = insets2D.right;
/*     */       
/* 177 */       TextParagraph.TextAlign textAlign = this.paragraph.getTextAlign();
/* 178 */       if (textAlign == null) textAlign = TextParagraph.TextAlign.LEFT; 
/* 179 */       switch (textAlign) {
/*     */         case VERTICAL:
/* 181 */           d1 += (rectangle2D.getWidth() - drawTextFragment.getWidth() - d2 - d3 - double_1.doubleValue()) / 2.0D;
/*     */           break;
/*     */         case VERTICAL_270:
/* 184 */           d1 += rectangle2D.getWidth() - drawTextFragment.getWidth() - d2 - d3;
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 190 */       drawTextFragment.setPosition(d1, d);
/* 191 */       drawTextFragment.draw(paramGraphics2D);
/*     */       
/* 193 */       if (double_3.doubleValue() > 0.0D) {
/*     */         
/* 195 */         d += double_3.doubleValue() * 0.01D * drawTextFragment.getHeight();
/*     */       } else {
/*     */         
/* 198 */         d += -double_3.doubleValue();
/*     */       } 
/*     */       
/* 201 */       bool = false;
/*     */     } 
/*     */     
/* 204 */     this.y = d - this.y;
/*     */   }
/*     */   
/*     */   public float getFirstLineHeight() {
/* 208 */     return this.lines.isEmpty() ? 0.0F : ((DrawTextFragment)this.lines.get(0)).getHeight();
/*     */   }
/*     */   
/*     */   public float getLastLineHeight() {
/* 212 */     return this.lines.isEmpty() ? 0.0F : ((DrawTextFragment)this.lines.get(this.lines.size() - 1)).getHeight();
/*     */   }
/*     */   
/*     */   public boolean isEmptyParagraph() {
/* 216 */     return (this.lines.isEmpty() || this.rawText.trim().isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyTransform(Graphics2D paramGraphics2D) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawContent(Graphics2D paramGraphics2D) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void breakText(Graphics2D paramGraphics2D) {
/*     */     int i;
/* 231 */     this.lines.clear();
/*     */     
/* 233 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/* 234 */     StringBuilder stringBuilder = new StringBuilder();
/* 235 */     AttributedString attributedString = getAttributedString(paramGraphics2D, stringBuilder);
/* 236 */     boolean bool = "".equals(stringBuilder.toString().trim());
/*     */     
/* 238 */     AttributedCharacterIterator attributedCharacterIterator = attributedString.getIterator();
/* 239 */     LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(attributedCharacterIterator, paramGraphics2D.getFontRenderContext());
/*     */     do {
/* 241 */       int j = lineBreakMeasurer.getPosition();
/*     */       
/* 243 */       double d = getWrappingWidth((this.lines.size() == 0), paramGraphics2D) + 1.0D;
/*     */       
/* 245 */       if (d < 0.0D) d = 1.0D;
/*     */       
/* 247 */       int k = stringBuilder.indexOf("\n", j + 1);
/* 248 */       if (k == -1) k = attributedCharacterIterator.getEndIndex();
/*     */       
/* 250 */       TextLayout textLayout = lineBreakMeasurer.nextLayout((float)d, k, true);
/* 251 */       if (textLayout == null)
/*     */       {
/*     */         
/* 254 */         textLayout = lineBreakMeasurer.nextLayout((float)d, k, false);
/*     */       }
/*     */       
/* 257 */       if (textLayout == null) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/* 262 */       i = lineBreakMeasurer.getPosition();
/*     */       
/* 264 */       if (i < attributedCharacterIterator.getEndIndex() && stringBuilder.charAt(i) == '\n') {
/* 265 */         lineBreakMeasurer.setPosition(i + 1);
/*     */       }
/*     */       
/* 268 */       TextParagraph.TextAlign textAlign = this.paragraph.getTextAlign();
/* 269 */       if (textAlign == TextParagraph.TextAlign.JUSTIFY || textAlign == TextParagraph.TextAlign.JUSTIFY_LOW) {
/* 270 */         textLayout = textLayout.getJustifiedLayout((float)d);
/*     */       }
/*     */       
/* 273 */       AttributedString attributedString1 = bool ? null : new AttributedString(attributedCharacterIterator, j, i);
/*     */ 
/*     */       
/* 276 */       DrawTextFragment drawTextFragment = drawFactory.getTextFragment(textLayout, attributedString1);
/* 277 */       this.lines.add(drawTextFragment);
/*     */       
/* 279 */       this.maxLineHeight = Math.max(this.maxLineHeight, drawTextFragment.getHeight());
/*     */     }
/* 281 */     while (i != attributedCharacterIterator.getEndIndex());
/*     */ 
/*     */     
/* 284 */     this.rawText = stringBuilder.toString();
/*     */   } protected DrawTextFragment getBullet(Graphics2D paramGraphics2D, AttributedCharacterIterator paramAttributedCharacterIterator) {
/*     */     String str1;
/*     */     Paint paint;
/* 288 */     TextParagraph.BulletStyle bulletStyle = this.paragraph.getBulletStyle();
/* 289 */     if (bulletStyle == null) return null;
/*     */ 
/*     */     
/* 292 */     AutoNumberingScheme autoNumberingScheme = bulletStyle.getAutoNumberingScheme();
/* 293 */     if (autoNumberingScheme != null) {
/* 294 */       str1 = autoNumberingScheme.format(this.autoNbrIdx);
/*     */     } else {
/* 296 */       str1 = bulletStyle.getBulletCharacter();
/*     */     } 
/* 298 */     if (str1 == null) return null;
/*     */     
/* 300 */     String str2 = bulletStyle.getBulletFont();
/* 301 */     if (str2 == null) str2 = this.paragraph.getDefaultFontFamily(); 
/* 302 */     assert str2 != null;
/*     */     
/* 304 */     PlaceableShape<?, ?> placeableShape = getParagraphShape();
/* 305 */     PaintStyle paintStyle = bulletStyle.getBulletFontColor();
/*     */     
/* 307 */     if (paintStyle == null) {
/* 308 */       paint = (Paint)paramAttributedCharacterIterator.getAttribute(TextAttribute.FOREGROUND);
/*     */     } else {
/* 310 */       paint = (new DrawPaint(placeableShape)).getPaint(paramGraphics2D, paintStyle);
/*     */     } 
/*     */     
/* 313 */     float f = ((Float)paramAttributedCharacterIterator.getAttribute(TextAttribute.SIZE)).floatValue();
/* 314 */     Double double_ = bulletStyle.getBulletFontSize();
/* 315 */     if (double_ == null) double_ = Double.valueOf(100.0D); 
/* 316 */     if (double_.doubleValue() > 0.0D) { f = (float)(f * double_.doubleValue() * 0.01D); }
/* 317 */     else { f = (float)-double_.doubleValue(); }
/*     */ 
/*     */     
/* 320 */     AttributedString attributedString = new AttributedString(mapFontCharset(str1, str2));
/* 321 */     attributedString.addAttribute(TextAttribute.FOREGROUND, paint);
/* 322 */     attributedString.addAttribute(TextAttribute.FAMILY, str2);
/* 323 */     attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(f));
/*     */     
/* 325 */     TextLayout textLayout = new TextLayout(attributedString.getIterator(), paramGraphics2D.getFontRenderContext());
/* 326 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/* 327 */     return drawFactory.getTextFragment(textLayout, attributedString);
/*     */   }
/*     */   
/*     */   protected String getRenderableText(TextRun paramTextRun) {
/* 331 */     StringBuilder stringBuilder = new StringBuilder();
/* 332 */     TextRun.TextCap textCap = paramTextRun.getTextCap();
/* 333 */     String str = null;
/* 334 */     for (char c : paramTextRun.getRawText().toCharArray()) {
/* 335 */       switch (c) {
/*     */         case '\t':
/* 337 */           if (str == null) {
/* 338 */             str = tab2space(paramTextRun);
/*     */           }
/* 340 */           stringBuilder.append(str);
/*     */           break;
/*     */         case '\013':
/* 343 */           stringBuilder.append('\n');
/*     */           break;
/*     */         default:
/* 346 */           switch (textCap) { case VERTICAL:
/* 347 */               c = Character.toUpperCase(c); break;
/* 348 */             case VERTICAL_270: c = Character.toLowerCase(c);
/*     */               break; }
/*     */ 
/*     */           
/* 352 */           stringBuilder.append(c);
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 357 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String tab2space(TextRun paramTextRun) {
/* 364 */     AttributedString attributedString = new AttributedString(" ");
/* 365 */     String str = paramTextRun.getFontFamily();
/* 366 */     if (str == null) str = "Lucida Sans"; 
/* 367 */     attributedString.addAttribute(TextAttribute.FAMILY, str);
/*     */     
/* 369 */     Double double_1 = paramTextRun.getFontSize();
/* 370 */     if (double_1 == null) double_1 = Double.valueOf(12.0D); 
/* 371 */     attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(double_1.floatValue()));
/*     */     
/* 373 */     TextLayout textLayout = new TextLayout(attributedString.getIterator(), new FontRenderContext(null, true, true));
/* 374 */     double d = textLayout.getAdvance();
/*     */     
/* 376 */     Double double_2 = this.paragraph.getDefaultTabSize();
/* 377 */     if (double_2 == null) double_2 = Double.valueOf(d * 4.0D);
/*     */     
/* 379 */     int i = (int)Math.ceil(double_2.doubleValue() / d);
/* 380 */     StringBuilder stringBuilder = new StringBuilder();
/* 381 */     for (byte b = 0; b < i; b++) {
/* 382 */       stringBuilder.append(' ');
/*     */     }
/* 384 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getWrappingWidth(boolean paramBoolean, Graphics2D paramGraphics2D) {
/*     */     double d3;
/* 396 */     TextShape textShape = this.paragraph.getParentShape();
/*     */ 
/*     */     
/* 399 */     Insets2D insets2D = textShape.getInsets();
/* 400 */     double d1 = insets2D.left;
/* 401 */     double d2 = insets2D.right;
/*     */     
/* 403 */     int i = this.paragraph.getIndentLevel();
/* 404 */     if (i == -1)
/*     */     {
/* 406 */       i = 0;
/*     */     }
/* 408 */     Double double_1 = this.paragraph.getLeftMargin();
/* 409 */     if (double_1 == null)
/*     */     {
/* 411 */       double_1 = Double.valueOf(Units.toPoints(347663L * (i + 1)));
/*     */     }
/* 413 */     Double double_2 = this.paragraph.getIndent();
/* 414 */     if (double_2 == null) {
/* 415 */       double_2 = Double.valueOf(Units.toPoints(347663L * i));
/*     */     }
/* 417 */     Double double_3 = this.paragraph.getRightMargin();
/* 418 */     if (double_3 == null) {
/* 419 */       double_3 = Double.valueOf(0.0D);
/*     */     }
/*     */     
/* 422 */     Rectangle2D rectangle2D = DrawShape.getAnchor(paramGraphics2D, (PlaceableShape<?, ?>)textShape);
/* 423 */     TextShape.TextDirection textDirection = textShape.getTextDirection();
/*     */     
/* 425 */     if (!textShape.getWordWrap())
/* 426 */     { Dimension dimension = textShape.getSheet().getSlideShow().getPageSize();
/*     */       
/* 428 */       switch (textDirection)
/*     */       { default:
/* 430 */           d3 = dimension.getWidth() - rectangle2D.getX();
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
/* 461 */           return d3;case VERTICAL: d3 = dimension.getHeight() - rectangle2D.getX(); return d3;case VERTICAL_270: break; }  d3 = rectangle2D.getX(); } else { switch (textDirection) { default: d3 = rectangle2D.getWidth() - d1 - d2 - double_1.doubleValue() - double_3.doubleValue(); break;case VERTICAL: case VERTICAL_270: d3 = rectangle2D.getHeight() - d1 - d2 - double_1.doubleValue() - double_3.doubleValue(); break; }  if (paramBoolean && !isHSLF()) if (this.bullet != null) { if (double_2.doubleValue() > 0.0D) d3 -= double_2.doubleValue();  } else if (double_2.doubleValue() > 0.0D) { d3 -= double_2.doubleValue(); } else if (double_2.doubleValue() < 0.0D) { d3 += double_1.doubleValue(); }   }  return d3;
/*     */   }
/*     */   private static class AttributedStringData { AttributedCharacterIterator.Attribute attribute;
/*     */     Object value;
/*     */     int beginIndex;
/*     */     int endIndex;
/*     */     
/*     */     AttributedStringData(AttributedCharacterIterator.Attribute param1Attribute, Object param1Object, int param1Int1, int param1Int2) {
/* 469 */       this.attribute = param1Attribute;
/* 470 */       this.value = param1Object;
/* 471 */       this.beginIndex = param1Int1;
/* 472 */       this.endIndex = param1Int2;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PlaceableShape<?, ?> getParagraphShape() {
/* 481 */     return new PlaceableShape() {
/* 482 */         public ShapeContainer<?, ?> getParent() { return null; } public Rectangle2D getAnchor() {
/* 483 */           return DrawTextParagraph.this.paragraph.getParentShape().getAnchor();
/*     */         } public void setAnchor(Rectangle2D param1Rectangle2D) {} public double getRotation() {
/* 485 */           return 0.0D;
/*     */         }
/*     */         public void setRotation(double param1Double) {} public void setFlipHorizontal(boolean param1Boolean) {}
/*     */         public void setFlipVertical(boolean param1Boolean) {}
/* 489 */         public boolean getFlipHorizontal() { return false; }
/* 490 */         public boolean getFlipVertical() { return false; } public Sheet<?, ?> getSheet() {
/* 491 */           return DrawTextParagraph.this.paragraph.getParentShape().getSheet();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AttributedString getAttributedString(Graphics2D paramGraphics2D, StringBuilder paramStringBuilder) {
/* 497 */     ArrayList<AttributedStringData> arrayList = new ArrayList();
/* 498 */     if (paramStringBuilder == null) paramStringBuilder = new StringBuilder();
/*     */     
/* 500 */     PlaceableShape<?, ?> placeableShape = getParagraphShape();
/*     */     
/* 502 */     DrawFontManager drawFontManager = (DrawFontManager)paramGraphics2D.getRenderingHint(Drawable.FONT_HANDLER);
/*     */     
/* 504 */     for (TextRun textRun : this.paragraph) {
/* 505 */       String str1 = getRenderableText(textRun);
/*     */       
/* 507 */       if (str1.isEmpty()) {
/*     */         continue;
/*     */       }
/* 510 */       String str2 = textRun.getFontFamily();
/*     */       
/* 512 */       Map map = (Map)paramGraphics2D.getRenderingHint(Drawable.FONT_MAP);
/* 513 */       if (map != null && map.containsKey(str2)) {
/* 514 */         str2 = (String)map.get(str2);
/*     */       }
/* 516 */       if (drawFontManager != null) {
/* 517 */         str2 = drawFontManager.getRendererableFont(str2, textRun.getPitchAndFamily());
/*     */       }
/* 519 */       if (str2 == null) {
/* 520 */         str2 = this.paragraph.getDefaultFontFamily();
/*     */       }
/*     */       
/* 523 */       int i = paramStringBuilder.length();
/* 524 */       paramStringBuilder.append(mapFontCharset(str1, str2));
/* 525 */       int j = paramStringBuilder.length();
/*     */       
/* 527 */       arrayList.add(new AttributedStringData(TextAttribute.FAMILY, str2, i, j));
/*     */       
/* 529 */       PaintStyle paintStyle = textRun.getFontColor();
/* 530 */       Paint paint = (new DrawPaint(placeableShape)).getPaint(paramGraphics2D, paintStyle);
/* 531 */       arrayList.add(new AttributedStringData(TextAttribute.FOREGROUND, paint, i, j));
/*     */       
/* 533 */       Double double_ = textRun.getFontSize();
/* 534 */       if (double_ == null) double_ = this.paragraph.getDefaultFontSize(); 
/* 535 */       arrayList.add(new AttributedStringData(TextAttribute.SIZE, Float.valueOf(double_.floatValue()), i, j));
/*     */       
/* 537 */       if (textRun.isBold()) {
/* 538 */         arrayList.add(new AttributedStringData(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, i, j));
/*     */       }
/* 540 */       if (textRun.isItalic()) {
/* 541 */         arrayList.add(new AttributedStringData(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, i, j));
/*     */       }
/* 543 */       if (textRun.isUnderlined()) {
/* 544 */         arrayList.add(new AttributedStringData(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, i, j));
/* 545 */         arrayList.add(new AttributedStringData(TextAttribute.INPUT_METHOD_UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL, i, j));
/*     */       } 
/* 547 */       if (textRun.isStrikethrough()) {
/* 548 */         arrayList.add(new AttributedStringData(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON, i, j));
/*     */       }
/* 550 */       if (textRun.isSubscript()) {
/* 551 */         arrayList.add(new AttributedStringData(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, i, j));
/*     */       }
/* 553 */       if (textRun.isSuperscript()) {
/* 554 */         arrayList.add(new AttributedStringData(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, i, j));
/*     */       }
/*     */       
/* 557 */       Hyperlink hyperlink = textRun.getHyperlink();
/* 558 */       if (hyperlink != null) {
/* 559 */         arrayList.add(new AttributedStringData(HYPERLINK_HREF, hyperlink.getAddress(), i, j));
/* 560 */         arrayList.add(new AttributedStringData(HYPERLINK_LABEL, hyperlink.getLabel(), i, j));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 566 */     if (paramStringBuilder.length() == 0) {
/* 567 */       Double double_ = this.paragraph.getDefaultFontSize();
/* 568 */       paramStringBuilder.append(" ");
/* 569 */       arrayList.add(new AttributedStringData(TextAttribute.SIZE, Float.valueOf(double_.floatValue()), 0, 1));
/*     */     } 
/*     */     
/* 572 */     AttributedString attributedString = new AttributedString(paramStringBuilder.toString());
/* 573 */     for (AttributedStringData attributedStringData : arrayList) {
/* 574 */       attributedString.addAttribute(attributedStringData.attribute, attributedStringData.value, attributedStringData.beginIndex, attributedStringData.endIndex);
/*     */     }
/*     */     
/* 577 */     return attributedString;
/*     */   }
/*     */   
/*     */   protected boolean isHSLF() {
/* 581 */     return this.paragraph.getClass().getName().contains("HSLF");
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
/*     */   protected String mapFontCharset(String paramString1, String paramString2) {
/* 597 */     String str = paramString1;
/* 598 */     if ("Wingdings".equalsIgnoreCase(paramString2)) {
/*     */       
/* 600 */       boolean bool = false;
/* 601 */       char[] arrayOfChar = str.toCharArray();
/* 602 */       for (byte b = 0; b < arrayOfChar.length; b++) {
/*     */         
/* 604 */         if ((' ' <= arrayOfChar[b] && arrayOfChar[b] <= '') || (' ' <= arrayOfChar[b] && arrayOfChar[b] <= 'ÿ')) {
/*     */           
/* 606 */           arrayOfChar[b] = (char)(arrayOfChar[b] | 0xF000);
/* 607 */           bool = true;
/*     */         } 
/*     */       } 
/*     */       
/* 611 */       if (bool) {
/* 612 */         str = new String(arrayOfChar);
/*     */       }
/*     */     } 
/* 615 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawTextParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */