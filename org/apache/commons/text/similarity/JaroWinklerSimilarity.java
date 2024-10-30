/*     */ package org.apache.commons.text.similarity;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class JaroWinklerSimilarity
/*     */   implements SimilarityScore<Double>
/*     */ {
/*     */   public Double apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  80 */     double d1 = 0.1D;
/*     */     
/*  82 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/*  83 */       throw new IllegalArgumentException("CharSequences must not be null");
/*     */     }
/*     */     
/*  86 */     if (StringUtils.equals(paramCharSequence1, paramCharSequence2)) {
/*  87 */       return Double.valueOf(1.0D);
/*     */     }
/*     */     
/*  90 */     int[] arrayOfInt = matches(paramCharSequence1, paramCharSequence2);
/*  91 */     double d2 = arrayOfInt[0];
/*  92 */     if (d2 == 0.0D) {
/*  93 */       return Double.valueOf(0.0D);
/*     */     }
/*  95 */     double d3 = (d2 / paramCharSequence1.length() + d2 / paramCharSequence2.length() + (d2 - arrayOfInt[1] / 2.0D) / d2) / 3.0D;
/*  96 */     double d4 = (d3 < 0.7D) ? d3 : (d3 + 0.1D * arrayOfInt[2] * (1.0D - d3));
/*  97 */     return Double.valueOf(d4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static int[] matches(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*     */     CharSequence charSequence1, charSequence2;
/* 109 */     if (paramCharSequence1.length() > paramCharSequence2.length()) {
/* 110 */       charSequence1 = paramCharSequence1;
/* 111 */       charSequence2 = paramCharSequence2;
/*     */     } else {
/* 113 */       charSequence1 = paramCharSequence2;
/* 114 */       charSequence2 = paramCharSequence1;
/*     */     } 
/* 116 */     int i = Math.max(charSequence1.length() / 2 - 1, 0);
/* 117 */     int[] arrayOfInt = new int[charSequence2.length()];
/* 118 */     Arrays.fill(arrayOfInt, -1);
/* 119 */     boolean[] arrayOfBoolean = new boolean[charSequence1.length()];
/* 120 */     byte b1 = 0;
/* 121 */     for (byte b2 = 0; b2 < charSequence2.length(); b2++) {
/* 122 */       char c = charSequence2.charAt(b2);
/* 123 */       for (int j = Math.max(b2 - i, 0), k = Math.min(b2 + i + 1, charSequence1.length()); j < k; j++) {
/* 124 */         if (!arrayOfBoolean[j] && c == charSequence1.charAt(j)) {
/* 125 */           arrayOfInt[b2] = j;
/* 126 */           arrayOfBoolean[j] = true;
/* 127 */           b1++;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 132 */     char[] arrayOfChar1 = new char[b1];
/* 133 */     char[] arrayOfChar2 = new char[b1]; byte b3, b4;
/* 134 */     for (b3 = 0, b4 = 0; b3 < charSequence2.length(); b3++) {
/* 135 */       if (arrayOfInt[b3] != -1) {
/* 136 */         arrayOfChar1[b4] = charSequence2.charAt(b3);
/* 137 */         b4++;
/*     */       } 
/*     */     } 
/* 140 */     for (b3 = 0, b4 = 0; b3 < charSequence1.length(); b3++) {
/* 141 */       if (arrayOfBoolean[b3]) {
/* 142 */         arrayOfChar2[b4] = charSequence1.charAt(b3);
/* 143 */         b4++;
/*     */       } 
/*     */     } 
/* 146 */     b3 = 0;
/* 147 */     for (b4 = 0; b4 < arrayOfChar1.length; b4++) {
/* 148 */       if (arrayOfChar1[b4] != arrayOfChar2[b4]) {
/* 149 */         b3++;
/*     */       }
/*     */     } 
/* 152 */     b4 = 0;
/* 153 */     for (byte b5 = 0; b5 < Math.min(4, charSequence2.length()) && 
/* 154 */       paramCharSequence1.charAt(b5) == paramCharSequence2.charAt(b5); b5++) {
/* 155 */       b4++;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 160 */     return new int[] { b1, b3, b4 };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\JaroWinklerSimilarity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */