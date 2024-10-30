/*     */ package org.apache.poi.sl.usermodel;public interface TextParagraph<S extends Shape<S, P>, P extends TextParagraph<S, P, T>, T extends TextRun> extends Iterable<T> { Double getSpaceBefore();
/*     */   void setSpaceBefore(Double paramDouble);
/*     */   Double getSpaceAfter();
/*     */   void setSpaceAfter(Double paramDouble);
/*     */   Double getLeftMargin();
/*     */   void setLeftMargin(Double paramDouble);
/*     */   Double getRightMargin();
/*     */   void setRightMargin(Double paramDouble);
/*     */   Double getIndent();
/*     */   void setIndent(Double paramDouble);
/*     */   int getIndentLevel();
/*     */   void setIndentLevel(int paramInt);
/*     */   Double getLineSpacing();
/*     */   
/*     */   void setLineSpacing(Double paramDouble);
/*     */   
/*     */   String getDefaultFontFamily();
/*     */   
/*     */   Double getDefaultFontSize();
/*     */   
/*     */   TextAlign getTextAlign();
/*     */   
/*     */   void setTextAlign(TextAlign paramTextAlign);
/*     */   
/*     */   FontAlign getFontAlign();
/*     */   
/*     */   BulletStyle getBulletStyle();
/*     */   
/*     */   void setBulletStyle(Object... paramVarArgs);
/*     */   
/*     */   Double getDefaultTabSize();
/*     */   
/*     */   TextShape<S, P> getParentShape();
/*     */   
/*     */   List<T> getTextRuns();
/*     */   
/*     */   boolean isHeaderOrFooter();
/*     */   
/*  39 */   public enum TextAlign { LEFT,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     CENTER,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     RIGHT,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     JUSTIFY,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     JUSTIFY_LOW,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     DIST,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     THAI_DIST; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum FontAlign
/*     */   {
/*  83 */     AUTO,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     TOP,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     CENTER,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     BASELINE,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     BOTTOM;
/*     */   }
/*     */   
/*     */   public static interface BulletStyle {
/*     */     String getBulletCharacter();
/*     */     
/*     */     String getBulletFont();
/*     */     
/*     */     Double getBulletFontSize();
/*     */     
/*     */     void setBulletFontColor(Color param1Color);
/*     */     
/*     */     void setBulletFontColor(PaintStyle param1PaintStyle);
/*     */     
/*     */     PaintStyle getBulletFontColor();
/*     */     
/*     */     AutoNumberingScheme getAutoNumberingScheme();
/*     */     
/*     */     Integer getAutoNumberingStartAt();
/*     */   } }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\TextParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */