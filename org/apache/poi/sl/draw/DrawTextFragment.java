/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.font.TextLayout;
/*     */ import java.text.AttributedCharacterIterator;
/*     */ import java.text.AttributedString;
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
/*     */ public class DrawTextFragment
/*     */   implements Drawable
/*     */ {
/*     */   final TextLayout layout;
/*     */   final AttributedString str;
/*     */   double x;
/*     */   double y;
/*     */   
/*     */   public DrawTextFragment(TextLayout paramTextLayout, AttributedString paramAttributedString) {
/*  30 */     this.layout = paramTextLayout;
/*  31 */     this.str = paramAttributedString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(double paramDouble1, double paramDouble2) {
/*  36 */     this.x = paramDouble1;
/*  37 */     this.y = paramDouble2;
/*     */   }
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D) {
/*  41 */     if (this.str == null) {
/*     */       return;
/*     */     }
/*     */     
/*  45 */     double d = this.y + this.layout.getAscent();
/*     */     
/*  47 */     Integer integer = (Integer)paramGraphics2D.getRenderingHint(Drawable.TEXT_RENDERING_MODE);
/*  48 */     if (integer != null && integer.intValue() == 2) {
/*  49 */       this.layout.draw(paramGraphics2D, (float)this.x, (float)d);
/*     */     } else {
/*  51 */       paramGraphics2D.drawString(this.str.getIterator(), (float)this.x, (float)d);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void applyTransform(Graphics2D paramGraphics2D) {}
/*     */ 
/*     */   
/*     */   public void drawContent(Graphics2D paramGraphics2D) {}
/*     */   
/*     */   public TextLayout getLayout() {
/*  62 */     return this.layout;
/*     */   }
/*     */   
/*     */   public AttributedString getAttributedString() {
/*  66 */     return this.str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getHeight() {
/*  73 */     double d = Math.ceil(this.layout.getAscent()) + Math.ceil(this.layout.getDescent()) + this.layout.getLeading();
/*  74 */     return (float)d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getWidth() {
/*  82 */     return this.layout.getAdvance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/*  90 */     if (this.str == null) return "";
/*     */     
/*  92 */     AttributedCharacterIterator attributedCharacterIterator = this.str.getIterator();
/*  93 */     StringBuilder stringBuilder = new StringBuilder();
/*  94 */     for (char c = attributedCharacterIterator.first(); c != Character.MAX_VALUE; c = attributedCharacterIterator.next()) {
/*  95 */       stringBuilder.append(c);
/*     */     }
/*  97 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 102 */     return "[" + getClass().getSimpleName() + "] " + getString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawTextFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */