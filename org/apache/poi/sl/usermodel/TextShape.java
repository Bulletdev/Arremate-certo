/*     */ package org.apache.poi.sl.usermodel;public interface TextShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Iterable<P>, SimpleShape<S, P> { String getText();
/*     */   TextRun setText(String paramString);
/*     */   TextRun appendText(String paramString, boolean paramBoolean);
/*     */   List<? extends TextParagraph<S, P, ?>> getTextParagraphs();
/*     */   Insets2D getInsets();
/*     */   void setInsets(Insets2D paramInsets2D);
/*     */   double getTextHeight();
/*     */   
/*     */   VerticalAlignment getVerticalAlignment();
/*     */   
/*     */   void setVerticalAlignment(VerticalAlignment paramVerticalAlignment);
/*     */   
/*     */   boolean isHorizontalCentered();
/*     */   
/*     */   void setHorizontalCentered(Boolean paramBoolean);
/*     */   
/*     */   boolean getWordWrap();
/*     */   
/*     */   void setWordWrap(boolean paramBoolean);
/*     */   
/*     */   TextDirection getTextDirection();
/*     */   
/*     */   void setTextDirection(TextDirection paramTextDirection);
/*     */   
/*     */   Double getTextRotation();
/*     */   
/*     */   void setTextRotation(Double paramDouble);
/*     */   
/*     */   void setTextPlaceholder(TextPlaceholder paramTextPlaceholder);
/*     */   
/*     */   TextPlaceholder getTextPlaceholder();
/*     */   
/*  33 */   public enum TextDirection { HORIZONTAL,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     VERTICAL,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     VERTICAL_270,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     STACKED; }
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
/*     */   public enum TextAutofit
/*     */   {
/*  70 */     NONE,
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
/*  81 */     NORMAL,
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
/*  92 */     SHAPE;
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
/*     */   public enum TextPlaceholder
/*     */   {
/* 106 */     TITLE,
/*     */     
/* 108 */     BODY,
/*     */     
/* 110 */     CENTER_TITLE,
/*     */     
/* 112 */     CENTER_BODY,
/*     */     
/* 114 */     HALF_BODY,
/*     */     
/* 116 */     QUARTER_BODY,
/*     */     
/* 118 */     NOTES,
/*     */     
/* 120 */     OTHER;
/*     */   } }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\TextShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */