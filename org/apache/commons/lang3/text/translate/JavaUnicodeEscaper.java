/*     */ package org.apache.commons.lang3.text.translate;
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
/*     */ @Deprecated
/*     */ public class JavaUnicodeEscaper
/*     */   extends UnicodeEscaper
/*     */ {
/*     */   public static JavaUnicodeEscaper above(int paramInt) {
/*  40 */     return outsideOf(0, paramInt);
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
/*  53 */     return outsideOf(paramInt, 2147483647);
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
/*  68 */     return new JavaUnicodeEscaper(paramInt1, paramInt2, true);
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
/*  83 */     return new JavaUnicodeEscaper(paramInt1, paramInt2, false);
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
/* 101 */     super(paramInt1, paramInt2, paramBoolean);
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
/* 113 */     char[] arrayOfChar = Character.toChars(paramInt);
/* 114 */     return "\\u" + hex(arrayOfChar[0]) + "\\u" + hex(arrayOfChar[1]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\JavaUnicodeEscaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */