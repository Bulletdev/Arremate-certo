/*     */ package org.apache.commons.text.similarity;
/*     */ 
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ public class FuzzyScore
/*     */ {
/*     */   private final Locale locale;
/*     */   
/*     */   public FuzzyScore(Locale paramLocale) {
/*  53 */     if (paramLocale == null) {
/*  54 */       throw new IllegalArgumentException("Locale must not be null");
/*     */     }
/*  56 */     this.locale = paramLocale;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer fuzzyScore(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  85 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/*  86 */       throw new IllegalArgumentException("CharSequences must not be null");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     String str1 = paramCharSequence1.toString().toLowerCase(this.locale);
/*  94 */     String str2 = paramCharSequence2.toString().toLowerCase(this.locale);
/*     */ 
/*     */     
/*  97 */     byte b1 = 0;
/*     */ 
/*     */ 
/*     */     
/* 101 */     byte b2 = 0;
/*     */ 
/*     */     
/* 104 */     int i = Integer.MIN_VALUE;
/*     */     
/* 106 */     for (byte b3 = 0; b3 < str2.length(); b3++) {
/* 107 */       char c = str2.charAt(b3);
/*     */       
/* 109 */       boolean bool = false;
/*     */       
/* 111 */       for (; b2 < str1.length() && !bool; b2++) {
/* 112 */         char c1 = str1.charAt(b2);
/*     */         
/* 114 */         if (c == c1) {
/*     */           
/* 116 */           b1++;
/*     */ 
/*     */ 
/*     */           
/* 120 */           if (i + 1 == b2) {
/* 121 */             b1 += 2;
/*     */           }
/*     */           
/* 124 */           i = b2;
/*     */ 
/*     */ 
/*     */           
/* 128 */           bool = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     return Integer.valueOf(b1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/* 142 */     return this.locale;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\FuzzyScore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */