/*     */ package org.apache.commons.text.translate;
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
/*     */ public class JavaUnicodeEscaper
/*     */   extends UnicodeEscaper
/*     */ {
/*     */   public static JavaUnicodeEscaper above(int paramInt) {
/*  36 */     return outsideOf(0, paramInt);
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
/*     */   public static JavaUnicodeEscaper below(int paramInt) {
/*  49 */     return outsideOf(paramInt, 2147483647);
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
/*     */   public static JavaUnicodeEscaper between(int paramInt1, int paramInt2) {
/*  64 */     return new JavaUnicodeEscaper(paramInt1, paramInt2, true);
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
/*     */   public static JavaUnicodeEscaper outsideOf(int paramInt1, int paramInt2) {
/*  79 */     return new JavaUnicodeEscaper(paramInt1, paramInt2, false);
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
/*     */   public JavaUnicodeEscaper(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  97 */     super(paramInt1, paramInt2, paramBoolean);
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
/*     */   protected String toUtf16Escape(int paramInt) {
/* 109 */     char[] arrayOfChar = Character.toChars(paramInt);
/* 110 */     return "\\u" + hex(arrayOfChar[0]) + "\\u" + hex(arrayOfChar[1]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\JavaUnicodeEscaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */